package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.FutbolistaDAOSqlite;
import com.ipartek.formacion.pojo.Futbolista;

/**
 * Servlet implementation class FutbolistaController
 */
@WebServlet("/futbol")
public class FutbolistaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FutbolistaDAOSqlite dao = FutbolistaDAOSqlite.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FutbolistaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Conseguir perros
		ArrayList<Futbolista> lista = new ArrayList<Futbolista>();

		try {

			lista = dao.listar();

		} catch (Exception e) {

			lista.add(new Futbolista(1, "Juan", "random"));
			lista.add(new Futbolista(2, "Alberto", "random"));
			lista.add(new Futbolista(3, "José", "random"));
			lista.add(new Futbolista(4, "-", "-"));

			e.printStackTrace();

		}

		// Enviarlos a la JSP
		request.setAttribute("futbolistas", lista);

		// Ir a la JSP
		request.getRequestDispatcher("futbol.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String parametroNombre = request.getParamenter("nombre_del_parámetro");
		String parametroNombre = request.getParameter("nombre");
		int parametroEdad = Integer.parseInt(request.getParameter("edad"));
		float parametroAltura = Float.parseFloat(request.getParameter("altura"));
		String parametroNacionalidad = request.getParameter("nacionalidad");
		String parametroEquipo = request.getParameter("equipo");

		Futbolista f = new Futbolista();
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

		try {
			request.setAttribute("futbolista", dao.nuevo(f));
		} catch (Exception e) {
			request.setAttribute("futbolista", "<p style='color: red;'>ERROR</p>");
			e.printStackTrace();
		}

		request.getRequestDispatcher("futbolCreado.jsp").forward(request, response);
	}

}
