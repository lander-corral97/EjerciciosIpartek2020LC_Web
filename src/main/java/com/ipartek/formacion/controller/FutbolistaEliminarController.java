package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.FutbolistaDAOSqlite;

/**
 * Servlet implementation class FutbolistaEliminarController
 */
@WebServlet("/futbol-eliminar")
public class FutbolistaEliminarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FutbolistaDAOSqlite dao = FutbolistaDAOSqlite.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FutbolistaEliminarController() {
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
			if (!dao.borrar(id)) {
				request.setAttribute("mensaje", "Futbolista eliminado");
			} else {
				request.setAttribute("mensaje",
						"<p style='color:red;'>Lo sentimos pero no se ha podido eliminar el futbolista</p>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				request.setAttribute("futbolistas", dao.listar());
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("futbol.jsp").forward(request, response);
		}
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
