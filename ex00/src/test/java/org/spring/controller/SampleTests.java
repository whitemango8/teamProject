package org.spring.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.sample.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

// 테스트 코드가 스프링을 실행하는 역할이라고 표시
@RunWith(SpringJUnit4ClassRunner.class)

// 테스트 서버때는 꼭 써주는 root-context.xml 경로
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

// Lombok을 이용하여 로그 기록하는 객체 생성
@Log4j

public class SampleTests {
	
	@Autowired
	private Restaurant restaurant;
	

	
	@Test
	public void test1() {
		System.out.println("test1");
		// 로그 vs 프린트문
		log.info("test1"); // 어디어디에:어디 이런식으로 프린트찍을 필요x
		log.info(restaurant); // 의존성주입 확인 가능
	}
}
