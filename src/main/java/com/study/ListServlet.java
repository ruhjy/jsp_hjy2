package com.study;

import java.io.*;
import java.util.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. request param

		// 2. business logic
		HttpSession session = request.getSession();
		Object o = session.getAttribute("db");

		if (o == null) {
			o = new ArrayList<String>();
			session.setAttribute("db", o);
		}

		// 3. add attribute
//		request.setAttribute("list", o);
		request.setAttribute("list", List.of("태웅", "백호", "태섭", "대만"));

		// 4. forward / redirect
		String view = "/WEB-INF/views/list.jsp";
		request.getRequestDispatcher(view).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

}
