package com.sinzoro.test.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sinzoro.test.dao.BoardDao;
import com.sinzoro.test.vo.BoardVO;

@Controller
@RequestMapping("/home/*")
public class BoardController {
    
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
    @Autowired
    BoardDao boardDao;
    
    @RequestMapping("/insBoard")
    public String ins(RedirectAttributes redirectAttributes, BoardVO boardVO) {
    	//logger.debug("boardVO : {}", boardVO.toString());
        boardDao.insert(boardVO);
        return "redirect:/home/board";
    }
    
    @RequestMapping("/findOne")
    public String findOne(RedirectAttributes redirectAttributes, @RequestParam("id") int id) {
        redirectAttributes.addFlashAttribute("getBoardVO", boardDao.findOne(id));
        return "redirect:/home/board";
    }
    
    @RequestMapping("/delete")
    public String delete(HttpServletRequest request, @RequestParam("id") int id) {
        request.setAttribute("getBoardVO", boardDao.delete(id));
        return "redirect:/home/board";
    }
    
    
   
}
