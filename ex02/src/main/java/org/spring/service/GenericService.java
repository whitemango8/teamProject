package org.spring.service;

public interface GenericService<VO, K> {
	// VO, K < 순서는 객체-단일객체 순서로 쓰는 것이 좋다
	
	// PK로 특정 튜플 반환의 의미
	public VO get(K key);
	
	// 릴레이션에 튜플 추가 
	public void register(VO vo);
	
	// 튜플 수정: 참고-스프링에서는 파라미터타입을 객체로 설정하는 것이 좋다
	public int modify(VO vo);
	
	// 튜플 삭제
	public int remove(K key);
}
