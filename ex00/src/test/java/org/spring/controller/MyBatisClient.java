package org.spring.controller;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.mapper.MemberMapper;
import org.spring.model.MemberVO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/data.xml"})
@Log4j

public class MyBatisClient {
	@Inject // 진짜 클래스를 만든게 아니라서 주입시키는것
	private SqlSessionFactory sqlFactory;
	
	@Inject // 개발자가 객체 생성을 하는 것이 아닌 스프링이 객체 생성을 하게 만듦
	private MemberMapper memberMapper;
	
	@Test
	public void testFactory() {
		log.info(sqlFactory);
	}
	
	@Test
	public void testSession() {
		try(SqlSession session = sqlFactory.openSession()) {
			// 괄호 안의 내용이 실행되지 않으면 try가 실행 안됨
			log.info(session);
			
			List<MemberVO> users = memberMapper.getAllMembers();
			
			System.out.println(users);
			
			MemberVO param = new MemberVO(); // memberVO의 getter/setter가 잘 만들어졌는지 
//			param.setId("eeee"); 없는 회원일 경우 null값으로 저장
			param.setId("hot");
			param.setPwd("1234");
			
			MemberVO user = memberMapper.getMemberVO(param);
			
			System.out.println(user);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	
	
