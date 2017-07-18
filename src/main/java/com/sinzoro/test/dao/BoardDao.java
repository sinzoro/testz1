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
		return sqlSession.selectOne("board.countAll"); // ��ü ������ ������. dao���� ����ؼ� �ִ´�.
	}
	
	
	public PageVO getPageVO(int requirePage) {
		int totalCount =  cnt();
		int pageContents = 3; // 1 �������� ������ ������ ����.
		
		int totalPage = (totalCount%pageContents == 0 ? totalCount/pageContents : totalCount/pageContents+1); // ��ü ������ ���� 2
		int perPage = 5; // ��� ������ ������ ����.
		//int requirePage = 1; // ��û���� �������� ������ ��û �������� 1�̴�. Ŭ���̾�Ʈ���� ���޹޴´�.
		
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