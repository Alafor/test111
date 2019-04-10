package com.hk.answer.daos;

import java.util.List;

import com.hk.ansdtos.AnsDto;

public interface IAnsDao {
	public List<AnsDto> getAllList() ;
	
	public boolean insertBoard(AnsDto dto) ;
	
	public List<AnsDto> selectOneBoard(int seq);


	public boolean updateBoard(AnsDto dto) ;

	public boolean muldel(String[] chks) ;
	
	public int replyBoardupdate(int seq);
	
	public int replyBoardinsert(AnsDto dto);
	
	public boolean readCount(int seq) ;
	
	public AnsDto getBoardAjax(int seq);
}
