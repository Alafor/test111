package com.hk.answer.daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.ansdtos.AnsDto;

@Repository
public class AnsDao implements IAnsDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private String nameSpace = "com.hk.ansboard.";
	
	@Override
	public List<AnsDto> getAllList() {
		// TODO Auto-generated method stub
		
		
		return sqlSession.selectList(nameSpace+"boardlist");
	}

	@Override
	public boolean insertBoard(AnsDto dto) {
		// TODO Auto-generated method stub
		int count =0;
		count = sqlSession.insert(nameSpace+"insertboard", dto);
		return count>0?true:false;
	}

	@Override
	public List<AnsDto> selectOneBoard(int seq) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("seq", ""+seq);
		return sqlSession.selectList(nameSpace+"boardlist",map);
	}

	

	@Override
	public boolean updateBoard(AnsDto dto) {
		int count =0;
		count = sqlSession.delete(nameSpace+"updateboard", dto);
		return count>0?true:false;
	}

	@Override
	public boolean muldel(String[] chks) {
		int count =0;
		Map<String , String[]> map = new HashMap<String, String[]>();
		map.put("seqs", chks);
		count = sqlSession.delete(nameSpace+"muldelboard", map);
		return count>0?true:false;
	}

	@Override
	public int replyBoardupdate(int seq) {
		// TODO Auto-generated method stub
		return sqlSession.update(nameSpace+"replyupdate", seq);
		
	}

	@Override
	public int replyBoardinsert(AnsDto dto) {
		// TODO Auto-generated method stub
		return sqlSession.insert(nameSpace+"replyinsert", dto);
	}

	@Override
	public boolean readCount(int seq) {
		int count =0;
		count = sqlSession.update(nameSpace+"readcount", seq);
		return count>0?true:false;
	}

	@Override
	public AnsDto getBoardAjax(int seq) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace+"detailAjax",seq);
	}

}
