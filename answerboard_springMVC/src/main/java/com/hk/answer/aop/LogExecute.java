package com.hk.answer.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.aspectj.lang.JoinPoint;

public class LogExecute {

	/*
	 * 	getArgs():�޼����� �ƱԸ�Ʈ�� ��ȯ
		getTarget():��� ��ü�� ��ȯ
		getSignature():ȣ��Ǵ� �޼��忡 ���� ����
				----->getName:�޼����� �̸� ����
				----->toLongName:�޼����� �Ķ����,���� Ÿ���� ������ �޼����� �̸� ���
				----->toShortName:�޼��带 ����ؼ� ǥ��
		getThis():���Ͻ� ��ü�� ��ȯ
	*/
	public void before(JoinPoint join) {
		Logger log =LoggerFactory.getLogger(join.getTarget()+"");
		log.debug("debug:����");
		log.info("info:����");
	}
	
	public void afterReturning(JoinPoint join) {
		Logger log =LoggerFactory.getLogger(join.getTarget()+"");
		log.info("info:��");
		log.debug("debug:��");
	}
	
	public void daoError(JoinPoint join) {
		Logger log =LoggerFactory.getLogger(join.getTarget()+"");
		log.info("info Args:"+join.getArgs());
		log.debug("debug toLong:"+join.toLongString());
	}
}
