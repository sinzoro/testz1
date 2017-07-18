package com.sinzoro.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class TestFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException { // ��� ��û(Request)�� ���ؼ� �� �κ��� ����ȴ�.
	    HttpServletRequest request = (HttpServletRequest)req;
	    
	    System.out.println("RequestURL : "+request.getRequestURL());
	    
	    chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig config) throws ServletException { // �ʱ�ȭ�� �� ����Ǵ� �κ�
	    String testParam = config.getInitParameter("testParam");
	    
	    System.out.println("testParam : "+testParam);
	}


	@Override
	public void destroy() {
	    
	}

}
