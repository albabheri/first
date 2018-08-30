/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.first.app.config;

import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Optional;

/**
 *
 * @author albab
 */
@Component
public class CORSFilter implements Filter {

    
    public CORSFilter() {
        //System.out.println("INIT FILTER");
    }
    
    @Override
    public void init(FilterConfig fc) throws ServletException {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
    }

//    @Override
//    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
//       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//       HttpServletRequest request = (HttpServletRequest) sr;
//        HttpServletResponse response = (HttpServletResponse) sr1;
//        
//        Enumeration<String> headerNames = request.getHeaderNames();
//        System.out.println("-------> FILTER");
//        if (headerNames != null) {
//                while (headerNames.hasMoreElements()) {
//                        System.out.println("Header: " + request.getHeader(headerNames.nextElement()));
//                }
//        }
//    }
    
	@SuppressWarnings("rawtypes")
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// throw new UnsupportedOperationException("Not supported yet."); //To
		// change body of generated methods, choose Tools | Templates.
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

//		response.setHeader("Access-Control-Allow-Origin", "http://0.0.0.0:8080");
//		response.setHeader("Access-Control-Allow-Origin", "*");
		
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
//		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "Authorization,Content-Type, Accept, X-Requested-With, remember-me");

		String auth = request.getHeader("authorization");

		System.out.println("PATH :" + request.getRequestURI());
		System.out.println("PATH :" + request.getRemoteAddr());
		System.out.println("PATH :" + request.getContextPath());

		//
		Enumeration<String> headerNames = request.getHeaderNames();
		Collection<String> headerNamesRes = response.getHeaderNames();
		// System.out.println("REQUEST --- >");
		//
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			System.out.print("Header : " + headerName);
			String headerValue = request.getHeader(headerName);
			System.out.print(" (" + headerValue + ")\n");
		}
		//
		System.out.println("RESPONSE :");
		for (String headerName : headerNamesRes) {
			// String headerName = headerNames.nextElement();
			System.out.print("Header : " + headerName);
			String headerValue = request.getHeader(headerName);
			System.out.print(" (" + headerValue + ")\n");
		}

		HttpSession session = request.getSession(false);
		if (session != null) {
			System.out.println("sess = " + session.getAttribute("TOKEN"));
			//
			Enumeration<String> hh = session.getAttributeNames();
			while (hh.hasMoreElements()) {
				String headerName = hh.nextElement();
				System.out.print("Sess : " + headerName);
				String headerValue = session.getAttribute(headerName).toString();
				System.out.print(" (" + headerValue + ")\n");
			}
		}

		Optional username = Optional.fromNullable(request.getHeader("X-Auth-Username"));
		Optional password = Optional.fromNullable(request.getHeader("X-Auth-Password"));
		Optional token = Optional.fromNullable(request.getHeader("X-Auth-Token"));

		System.out.println("US:" + username);
		System.out.println("UpasswordS:" + password);
		System.out.println("token:" + token);
		// String A=WebUtils.isSameOrigin(req); //.getCookie(request,
		// "JSESSIONID");
		// System.out.println("COOOK:"+A);

		if (auth == null) {
			chain.doFilter(req, response);
		} else {
			String[] arr = auth.split(" ");
			byte[] valueDecoded = Base64.decodeBase64(arr[1]);
			System.out.println("Decoded value is " + new String(valueDecoded));
			chain.doFilter(req, response);
		}
	}

	@Override
	public void destroy() {
		//throw new UnsupportedOperationException("Not supported yet.");
	}
    
}

