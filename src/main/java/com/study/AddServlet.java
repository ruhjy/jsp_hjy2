package com.study;

import java.io.*;
import java.util.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 1. request param
		
		// 2. business login
		
		// 3. add attribute
		
		// 4. forward / redirect
		String view = "/WEB-INF/views/add.jsp";
		request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. get request param
		String name = request.getParameter("name");
		// 2. business login
		HttpSession session = request.getSession();
		List<String> list = (List<String>) session.getAttribute("db");
		
		list.add(name);
		// 3. add attribute
		
//		 4. forward / redirect
		String location = request.getContextPath() + "/list";
		response.sendRedirect(location);
	}

}
