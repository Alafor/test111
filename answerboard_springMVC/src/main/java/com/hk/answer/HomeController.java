package com.hk.answer;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hk.ansdtos.AnsDto;
import com.hk.answer.service.AnsService;
import com.hk.answer.service.IAnsService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private IAnsService ansService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/boardlist.do", method = RequestMethod.GET)
	public String boardlist(HttpServletRequest request, Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		List<AnsDto> list = ansService.getAllList();
		System.out.println("list:" +list.get(0).getTitle());
		model.addAttribute("list", list);
		request.getSession().removeAttribute("readcount");
		return "boardlist";
	}
	@RequestMapping(value = "/insertform.do", method = RequestMethod.GET)
	public String insertform(Locale locale, Model model) {
		logger.info("글추가 폼 이동 {}.", locale);
		
		
		return "insertboard";
	}
	@RequestMapping(value = "/insertboard.do", method = RequestMethod.POST)
	public String insertboard(Locale locale, Model model,AnsDto dto) {
		logger.info("글추가 하기 {}.", locale);
		
		if(ansService.insertBoard(dto)) {
			return "redirect:boardlist.do";
			
		}else {
			System.out.println("안됨!!!!!!!!!!!!!!!!!!");
			model.addAttribute("msg", "글작성 에러");
			return "error";
		}
		
		
	}
	@RequestMapping(value = "/boarddetail.do", method = RequestMethod.GET)
	public String boarddetail(HttpServletRequest request, Locale locale, Model model,int seq) {
		logger.info("글읽기 {}.", locale);
		
		String rSeq =(String)request.getSession().getAttribute("readcount");
		if(rSeq==null) {
			request.getSession().setAttribute("readcount", ""+seq);
			ansService.readCount(seq);
		}
		
		
		model.addAttribute("dto", ansService.selectOneBoard(seq));
		return "detail";
		
	}
	@RequestMapping(value = "/muldel.do")
	public String muldel(Locale locale, Model model,String[] chk,int seq) {
		logger.info("여러글 지우기 {}.", locale);
		
		if(chk==null) {
			chk = new String[] {""+seq};
			System.out.println("chk 0 : "+chk[0]);
		}      
		
		
		if(ansService.muldel(chk)) {
			return "redirect:boardlist.do";
			
		}else {
			model.addAttribute("msg", "글삭제 에러");
			return "error";
		}
		
	}
	
	@RequestMapping(value = "/updateform.do", method = RequestMethod.GET)
	public String updateform(Locale locale, Model model,int seq) {
		logger.info("업데이트 폼{}.", locale);
		
		model.addAttribute("dto", ansService.selectOneBoard(seq));
		return "updateboard";
		
	}
	
	@RequestMapping(value = "/updateboard.do", method = RequestMethod.POST)
	public String updateboard(Locale locale, Model model,AnsDto dto) {
		logger.info("업데이트 {}.", locale);
		
		if(ansService.updateBoard(dto)) {
			return "redirect:boardlist.do";
			
		}else {
			System.out.println("안됨!!!!!!!!!!!!!!!!!!");
			model.addAttribute("msg", "글작성 에러");
			return "error";
		}
		
	}
	
	
	@RequestMapping(value = "/replyboard.do", method = RequestMethod.POST)
	public String replyboard(Locale locale, Model model,AnsDto dto) throws Exception {
		logger.info("리플달기 보드 {}.", locale); 

	
			if(ansService.replyBoard(dto)){
				return "redirect:boardlist.do";
				
			}else {
				System.out.println("else 안됨!!!!!!!!!!!!!!!!!!");
				model.addAttribute("msg", "글작성 에러");
				return "error";
			}
	
		
	}
	
	@ResponseBody //==>printwrite 마냥 브라우져로 출력 
	@RequestMapping(value = "/ContentAjax.do", method = RequestMethod.POST)
	public Map<String, AnsDto> ContentAjax(Locale locale, Model model,AnsDto dto) {
		logger.info("리플달기 보드 {}.", locale);
		AnsDto aDto = ansService.getBoardAjax(dto.getSeq());
		Map<String, AnsDto> map = new HashMap();
		map.put("dto", aDto);
		return map;
		
	}
}
