package org.spring.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/* 
 * <의존성 주입 방법>
 * Setter주입: @Setter(onMethod = {@Autowired})
 * 생성자 주입: @AllArgsConstructor
 * 필드 주입: @Autowired
 * 최근 가장 핫한 방법 final사용: @RequiredArgsConstructor
*/

@Component
@ToString
@Data
@RequiredArgsConstructor
public class Restaurant {
	
	// <Setter주입>
//	private  Chef chef;
//	
//	@Autowired // 안하면 chef=null이 뜬다
//	public void setChef(Chef chef) {
//		// 일단 내가 만들면 Data보다 우선이기 때문에 이거를 만든다
//		this.chef = chef;
//	}
	

	
	// 실행하려면 : root-context.xml 설정을 해야한다 
	
	// <fianl 사용>
	private final Chef chef;
}
