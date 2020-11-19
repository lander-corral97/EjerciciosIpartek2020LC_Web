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
 * Servlet implementation class FutbolistaModificarController
 */
@WebServlet("/modificar-futbolista")
public class FutbolistaModificarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FutbolistaDAOSqlite dao = FutbolistaDAOSqlite.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FutbolistaModificarController() {
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

		request.getRequestDispatcher("formularioModificar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametroId = request.getParameter("id");
		int id = Integer.parseInt(parametroId);

		String parametroNombre = request.getParameter("nombre");
		int parametroEdad = Integer.parseInt(request.getParameter("edad"));
		float parametroAltura = Float.parseFloat(request.getParameter("altura"));
		String parametroNacionalidad = request.getParameter("nacionalidad");
		String parametroEquipo = request.getParameter("equipo");

		Futbolista f = new Futbolista();
		try {
			f = dao.get(id);

			f.setNombre(parametroNombre);
			try {
				f.setEdad(parametroEdad);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				f.setAltura(parametroAltura);
			} catch (Exception e) {
				e.printStackTrace();
			}
			f.setNacionalidad(parametroNacionalidad);
			f.setEquipo(parametroEquipo);

			dao.modificar(f);
		} catch (Exception e) {
			request.setAttribute("error", "<p style='color:red;'>ERROR</p>");
			e.printStackTrace();
		}

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
