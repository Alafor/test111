package com.hk.answer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hk.ansdtos.AnsDto;
import com.hk.answer.daos.IAnsDao;

@Service
public class AnsService implements IAnsService {
	
	@Autowired
	private IAnsDao ansDao;
	
	@Override
	public List<AnsDto> getAllList() {
		return ansDao.getAllList();
	}

	@Override
	public boolean insertBoard(AnsDto dto) {
		return ansDao.insertBoard(dto);
	}

	@Override
	public AnsDto selectOneBoard(int seq) {
		List<AnsDto> list = ansDao.selectOneBoard(seq);
		return list.get(0);
	}


	@Override
	public boolean updateBoard(AnsDto dto) {
		return ansDao.updateBoard(dto);
	}

	@Override
	public boolean muldel(String[] chks) {
		return ansDao.muldel(chks);
	}
	
	
	@Override
	public boolean replyBoard(AnsDto dto) throws Exception {
		int count =0;
		try {
		ansDao.replyBoardupdate(dto.getSeq());
		count = ansDao.replyBoardinsert(dto);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("오류발생!");
			throw new Exception();
		}
		return count>0?true:false;
	}

	@Override
	public boolean readCount(int seq) {
		// TODO Auto-generated method stub
		return ansDao.readCount(seq);
	}

	@Override
	public AnsDto getBoardAjax(int seq) {
		// TODO Auto-generated method stub
		return ansDao.getBoardAjax(seq);
	}

}
