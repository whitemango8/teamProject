package org.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.spring.domain.BoardVO;


public interface BoardMapper {
	
	// CRUD
	
	public void insert(BoardVO vo);
	
	public void insertSelectBno(BoardVO vo);
	
//	@Select("select * from tbl_board") 어노테이션으로 급할 때 쓸 수 있다 (xml에는 안써도됨)
	public List<BoardVO> selectAll();
	
	public int update(BoardVO vo);
	
//	@Delete("delete from tbl_board where bno=#{bno}") // 어노테이션으로도 작동가능(test있음)
	public int delete(int bno);
	
	public BoardVO select(Integer key);
	
	// 다음번째 bno 찾기
//	public Integer getMaxBno();
}
