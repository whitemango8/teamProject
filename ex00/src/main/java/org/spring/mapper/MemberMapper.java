package org.spring.mapper;

import java.util.List;

import org.spring.model.MemberVO;

public interface MemberMapper {
   // 인터페이스에서 기능 구현 X
   public List<MemberVO> getAllMembers();
   
   // Id 와 Pw를 줬을 때 해당하는 user를 반환
   public MemberVO getMemberVO(MemberVO user);
}