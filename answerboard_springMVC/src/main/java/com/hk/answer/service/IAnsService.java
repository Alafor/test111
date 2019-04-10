package com.hk.answer.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.transaction.annotation.Transactional;

import com.hk.ansdtos.AnsDto;


public interface IAnsService {
	
	public List<AnsDto> getAllList() ;
	
	public boolean insertBoard(AnsDto dto) ;
	
	public AnsDto selectOneBoard(int seq);


	public boolean updateBoard(AnsDto dto) ;

	public boolean muldel(String[] chks) ;
	//답글달기
	//(rollbackFor=Exception.class)
	public boolean replyBoard(AnsDto dto) throws Exception;
	
	public boolean readCount(int seq) ;
	
	public AnsDto getBoardAjax(int seq);
}
