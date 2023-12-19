package org.spring.service;

import java.util.List;

import org.spring.domain.BoardVO;
import org.spring.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Service
@Log4j
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{

	// DB와 연결시켜야해 -> mapper와 연결시키자
	// BoardServiceImpl가 실행되면 자동으로 mapper가 만들어진다(의존성주입)
//	@Autowired
//	private BoardMapper mapper;
	
	// 최근에 쓰는 방법은 @AllArgsConstructor쓰고 final 상수 하나 만듦
	private final BoardMapper mapper; 
	
	
	@Override
	public BoardVO get(Integer key) {
		log.info("글 상세보기");
		return mapper.select(key);
	}

	@Override
	public void register(BoardVO vo) {
		log.info("글 등록하기");
//		mapper.insert(vo);
		
	}

	@Override
	public int modify(BoardVO vo) {
		log.info("글 수정하기");
		return mapper.update(vo);
	}

	@Override
	public int remove(Integer key) {
		log.info("글 삭제하기");
		return mapper.delete(key); // delete는 int를 받지만 자동boxing된다
	}

	@Override
	public List<BoardVO> listAll() {
		log.info("모든 글 출력");
		return mapper.selectAll();
	}

	@Override
	public Integer registerKey(BoardVO vo) {
		log.info("vo: "+vo);
		mapper.insertSelectBno(vo);
		return vo.getBno();
	}

//	@Override
//	public int getMaxBno() {
//		return mapper.getMaxBno();
//	}

}
