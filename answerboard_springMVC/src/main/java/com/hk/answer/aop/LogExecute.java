package com.hk.answer.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.aspectj.lang.JoinPoint;

public class LogExecute {

	/*
	 * 	getArgs():메서드의 아규먼트를 반환
		getTarget():대상 객체를 반환
		getSignature():호출되는 메서드에 대한 정보
				----->getName:메서드의 이름 구함
				----->toLongName:메서드의 파라미터,리턴 타입을 포함한 메서드의 이름 출력
				----->toShortName:메서드를 축약해서 표현
		getThis():프록시 객체를 반환
	*/
	public void before(JoinPoint join) {
		Logger log =LoggerFactory.getLogger(join.getTarget()+"");
		log.debug("debug:시작");
		log.info("info:시작");
	}
	
	public void afterReturning(JoinPoint join) {
		Logger log =LoggerFactory.getLogger(join.getTarget()+"");
		log.info("info:끝");
		log.debug("debug:끝");
	}
	
	public void daoError(JoinPoint join) {
		Logger log =LoggerFactory.getLogger(join.getTarget()+"");
		log.info("info Args:"+join.getArgs());
		log.debug("debug toLong:"+join.toLongString());
	}
}
