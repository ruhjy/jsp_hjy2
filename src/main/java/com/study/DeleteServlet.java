package com.study;

import java.io.*;
import java.util.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 1. get request parameter
		int index = Integer.parseInt(request.getParameter("index"));
		
		// 2. business logic
		HttpSession session = request.getSession();
		List<String> list = (List<String>) session.getAttribute("db");
		
		list.remove(index);
		
		// 3. add attribute
		
		// 4. forward / redirect
		String location = request.getContextPath() + "/list";
		response.sendRedirect(location);
	}

}
