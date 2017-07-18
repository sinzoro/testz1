package com.sinzoro.test.vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PageVO {
	
	int startContent;
	int endContent;
	int beginPage;
	int endPage;
	@Override
	public String toString() {
		return "PageVO [startContent=" + startContent + ", endContent=" + endContent + ", beginPage=" + beginPage
				+ ", endPage=" + endPage + "]";
	}
	
	
}
