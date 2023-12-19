package org.spring.controller;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/data.xml"})
@Log4j

public class JDBC_Client {
	// 의존성주입(DI): 객체 생성을 스프링이 해줌
	@Autowired
	private ApplicationContext context; // DB는 항상 켜져있어야 한다
	
	@Test
	public void dataSourceTest() { // data.xml의 bean을 가져와야해
		DataSource ds = (DataSource) context.getBean("dataSource"); // 연결 객체 생성
		try {
			log.info(ds.getConnection());
			log.info("연결성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
