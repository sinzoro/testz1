package com.sinzoro.test.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinzoro.test.vo.BoardVO;
import com.sinzoro.test.vo.PageVO;

@Repository
public class BoardDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public int insert(BoardVO boardVO) {
		return sqlSession.insert("board.insert", boardVO);
	}
	public int delete(int id) {
	    return sqlSession.delete("board.delete", id);
	}
	public int update(BoardVO boardVO) {
	    return sqlSession.update("board.update", boardVO);
	}
	
	
	public int cnt() {
		return sqlSession.selectOne("board.countAll"); // 전체 컨텐츠 갯수임. dao에서 계산해서 넣는다.
	}
	
	
	public PageVO getPageVO(int requirePage) {
		int totalCount =  cnt();
		int pageContents = 3; // 1 페이지당 보여줄 컨텐츠 갯수.
		
		int totalPage = (totalCount%pageContents == 0 ? totalCount/pageContents : totalCount/pageContents+1); // 전체 페이지 숫자 2
		int perPage = 5; // 뷰당 보여줄 페이지 갯수.
		//int requirePage = 1; // 요청받은 페이지가 없으면 요청 페이지는 1이다. 클라이언트에서 전달받는다.
		
		int beginPage = requirePage - requirePage%perPage + 1;
		int flag = beginPage + perPage - 1;
		int endPage = flag > totalPage ? totalPage : flag;
		
		int startContent = pageContents*requirePage-pageContents;
		
		PageVO pageVO = new PageVO();
		pageVO.setBeginPage(beginPage);
		pageVO.setEndPage(endPage);
		pageVO.setStartContent(startContent);
		pageVO.setEndContent(pageContents);
		return pageVO;
	}
	
	
	public List<BoardVO> findAll(PageVO pageVO) {
		return sqlSession.selectList("board.pageContent", pageVO);

	}
	
	public BoardVO findOne(int id) {
	    return sqlSession.selectOne("board.findOne", id);
	}
	
}