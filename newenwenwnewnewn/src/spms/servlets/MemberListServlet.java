package spms.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.net.aso.r;
import spms.dao.MemberDao;
import spms.dto.Member;

/**
 * Servlet implementation class MemberListServlet
 */
@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Cache-Control", "no-store,no-cache, must-revalidate"); 
		response.setHeader("Pragma","no-cache");  
		response.setDateHeader("Expires",0);
		System.out.println("¸´Æ® ¼­ºí¸´ Åë°ú-2");
		ServletContext sc = request.getServletContext();
		System.out.println("¸´Æ® ¼­ºí¸´ Åë°ú-3");
		MemberDao memberDao  = (MemberDao)sc.getAttribute("memberDao");
		System.out.println("¸´Æ® ¼­ºí¸´ Åë°ú0");
		List<Member> members = memberDao.selectList();
		System.out.println("¸´Æ® ¼­ºí¸´ Åë°ú1");
		request.setAttribute("members", members);
		System.out.println("1-1");
		RequestDispatcher rd = request.getRequestDispatcher("MemberList.jsp");
		rd.forward(request, response);
		System.out.println("¸´Æ® ¼­ºí¸´ Åë°ú2");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("postµµÂø");
		
	}

}
