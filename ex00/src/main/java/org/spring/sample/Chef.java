package org.spring.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component // 스프링이 직접 해당 클래스를 관리해야 하는 대상임을 표시
@Data // setter, getter, toString(), 생성자까지 자동 생성하는 Lombok 기능
// 이 두개는 필수 어노테이션!


public class Chef {
	
}
