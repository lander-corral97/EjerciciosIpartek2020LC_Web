package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.FutbolistaDAOSqlite;
import com.ipartek.formacion.pojo.Futbolista;

/**
 * Servlet implementation class DetallesFutbolistaController
 */
@WebServlet("/futbolista")
public class DetallesFutbolistaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FutbolistaDAOSqlite dao = FutbolistaDAOSqlite.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetallesFutbolistaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametroId = request.getParameter("id");
		int id = Integer.parseInt(parametroId);

		try {
			Futbolista fut = dao.get(id);
			request.setAttribute("futbolista", fut);
		} catch (Exception e) {
			request.setAttribute("error", "<p style='color:red;'>ERROR</p>");
			e.printStackTrace();
		}

		request.getRequestDispatcher("detalleFutbol.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
