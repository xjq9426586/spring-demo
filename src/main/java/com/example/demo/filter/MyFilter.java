package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class MyFilter implements Filter {
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest srequest, ServletResponse sresponse,
			FilterChain filterChain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) srequest;
		System.out.println("this is MyFilter,url :" + request.getRequestURI());
		System.out.println(request.getSession());
		HttpServletResponse response=(HttpServletResponse) sresponse;
		
		//解决跨域问题
		 response.setHeader("Access-Control-Allow-Origin", "*");  
         response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");  
         response.setHeader("Access-Control-Max-Age", "3600");  
         response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Content-Type,Accept");
		filterChain.doFilter(srequest, sresponse);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}

}
