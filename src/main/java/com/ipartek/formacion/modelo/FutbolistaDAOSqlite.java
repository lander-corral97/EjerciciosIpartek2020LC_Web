package com.ipartek.formacion.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.pojo.Futbolista;

public class FutbolistaDAOSqlite implements FutbolistaDAO {

	private static final String DRIVER_URL = "jdbc:sqlite:c:/ddbb/futbolista.db";
	private static FutbolistaDAOSqlite INSTANCE = null;

	private FutbolistaDAOSqlite() {
		super();
	}

	public synchronized static FutbolistaDAOSqlite getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new FutbolistaDAOSqlite();
		}
		return INSTANCE;
	}

	@Override
	public ArrayList<Futbolista> listar() throws Exception {
		Class.forName("org.sqlite.JDBC");

		ArrayList<Futbolista> futs = new ArrayList<Futbolista>();
		String sql = "Select * From futbolista Order By nombre asc;";
		try (Connection cnn = DriverManager.getConnection(DRIVER_URL);
				PreparedStatement pst = cnn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				Futbolista fut = new Futbolista();
				fut.setAltura(rs.getFloat("altura"));
				fut.setEdad(rs.getInt("edad"));
				fut.setEquipo(rs.getString("equipo"));
				fut.setId(rs.getInt("id"));
				fut.setNacionalidad(rs.getString("nacionalidad"));
				fut.setNombre(rs.getString("nombre"));

				futs.add(fut);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Ha habido un problema con la conexión a la BBDD...");
		} catch (Exception e) {
			throw new Exception("Ha ocurrido un error");
		}

		return futs;
	}

	@Override
	public Futbolista get(int id) throws Exception {
		Class.forName("org.sqlite.JDBC");

		Futbolista fut = null;
		String sql = "Select * From futbolista Where id = ?";

		try (Connection cnn = DriverManager.getConnection(DRIVER_URL);
				PreparedStatement pst = cnn.prepareStatement(sql);) {

			pst.setInt(1, id);

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					fut = new Futbolista();
					fut.setAltura(rs.getFloat("altura"));
					fut.setEdad(rs.getInt("edad"));
					fut.setEquipo(rs.getString("equipo"));
					fut.setId(rs.getInt("id"));
					fut.setNacionalidad(rs.getString("nacionalidad"));
					fut.setNombre(rs.getString("nombre"));
				}
			}

		} catch (SQLException e) {
			throw new Exception("Ha habido un problema con la conexi�n a la BBDD...");
		} catch (Exception e) {
			throw new Exception("Ha ocurrido un error");
		}

		return fut;
	}

	@Override
	public Futbolista nuevo(Futbolista fut) throws Exception {
		Class.forName("org.sqlite.JDBC");

		String sql = "Insert into futbolista (nombre ,edad ,altura ,nacionalidad ,equipo) Values (?, ?, round(?, 2), ?, ?);";

		try (Connection cnn = DriverManager.getConnection(DRIVER_URL);
				PreparedStatement pst = cnn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);) {

			pst.setString(1, fut.getNombre());
			pst.setInt(2, fut.getEdad());
			pst.setFloat(3, fut.getAltura());
			pst.setString(4, fut.getNacionalidad());
			pst.setString(5, fut.getEquipo());

			int affectedRows = pst.executeUpdate();

			if (affectedRows == 1) {
				try (ResultSet rsKeys = pst.getGeneratedKeys()) {
					if (rsKeys.next()) {
						int id = rsKeys.getInt(1);
						fut.setId(id);
					}
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Ha habido un problema con la conexi�n a la BBDD...");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Ha ocurrido un error");
		}

		return fut;
	}

	@Override
	public ArrayList<Futbolista> buscarFutbolistaPorNombre(String busqueda) throws Exception {
		Class.forName("org.sqlite.JDBC");

		ArrayList<Futbolista> futs = new ArrayList<Futbolista>();
		String sql = "Select * From futbolista Where Lower(nombre) Like Lower(?) Order By id asc;";

		try (Connection cnn = DriverManager.getConnection(DRIVER_URL);
				PreparedStatement pst = cnn.prepareStatement(sql);) {

			pst.setString(1, "%" + busqueda + "%");

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					Futbolista fut = new Futbolista();
					fut.setAltura(rs.getFloat("altura"));
					fut.setEdad(rs.getInt("edad"));
					fut.setEquipo(rs.getString("equipo"));
					fut.setId(rs.getInt("id"));
					fut.setNacionalidad(rs.getString("nacionalidad"));
					fut.setNombre(rs.getString("nombre"));

					futs.add(fut);
				}
			}
		} catch (SQLException e) {
			throw new Exception("Ha habido un problema con la conexi�n a la BBDD...");
		} catch (Exception e) {
			throw new Exception("Ha ocurrido un error");
		}

		return futs;
	}

	@Override
	public Futbolista modificar(Futbolista fut) throws Exception {
		Class.forName("org.sqlite.JDBC");

		String sql = "Update futbolista set nombre = ?, edad = ?, altura = round(?, 2), nacionalidad = ?, equipo = ? Where id = ?;";

		try (Connection cnn = DriverManager.getConnection(DRIVER_URL);
				PreparedStatement pst = cnn.prepareStatement(sql);) {

			pst.setString(1, fut.getNombre());
			pst.setInt(2, fut.getEdad());
			pst.setFloat(3, fut.getAltura());
			pst.setString(4, fut.getNacionalidad());
			pst.setString(5, fut.getEquipo());
			pst.setInt(6, fut.getId());

			pst.executeUpdate();

		} catch (SQLException e) {
			throw new Exception("Ha habido un problema con la conexi�n a la BBDD...");
		} catch (Exception e) {
			throw new Exception("Ha ocurrido un error");
		}

		return fut;
	}

	@Override
	public boolean borrar(int id) throws Exception {
		Class.forName("org.sqlite.JDBC");

		boolean resul = false;
		String sql = "Delete From futbolista Where id = ?;";

		try (Connection cnn = DriverManager.getConnection(DRIVER_URL);
				PreparedStatement pst = cnn.prepareStatement(sql);) {

			pst.setInt(1, id);

			if (pst.executeUpdate() == 0) {
				resul = true;
			}

		} catch (SQLException e) {
			throw new Exception("Ha habido un problema con la conexi�n a la BBDD...");
		} catch (Exception e) {
			throw new Exception("Ha ocurrido un error");
		}

		return resul;
	}

	@Override
	public ArrayList<Futbolista> getFutbolistaNacionalidad(String nacionalidad) throws Exception {
		Class.forName("org.sqlite.JDBC");

		ArrayList<Futbolista> futs = new ArrayList<Futbolista>();
		String sql = "Select * From futbolista Where Lower(nacionalidad) = Lower(?) Order By nombre asc;";

		try (Connection cnn = DriverManager.getConnection(DRIVER_URL);
				PreparedStatement pst = cnn.prepareStatement(sql);) {

			pst.setString(1, nacionalidad);

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					Futbolista fut = new Futbolista();
					fut.setAltura(rs.getFloat("altura"));
					fut.setEdad(rs.getInt("edad"));
					fut.setEquipo(rs.getString("equipo"));
					fut.setId(rs.getInt("id"));
					fut.setNacionalidad(rs.getString("nacionalidad"));
					fut.setNombre(rs.getString("nombre"));

					futs.add(fut);
				}
			}
		} catch (SQLException e) {
			throw new Exception("Ha habido un problema con la conexi�n a la BBDD...");
		} catch (Exception e) {
			throw new Exception("Ha ocurrido un error");
		}

		return futs;
	}

	@Override
	public ArrayList<Futbolista> getFutbolistaMayorMenorEdad(int edad, String mayorMenor) throws Exception {
		Class.forName("org.sqlite.JDBC");

		ArrayList<Futbolista> futs = new ArrayList<Futbolista>();
		String sql = "";

		if (mayorMenor.equals(">")) {
			sql = "Select * From futbolista Where edad > ? Order By edad Asc, nombre Asc;";
		} else {
			sql = "Select * From futbolista Where edad < ? Order By edad Asc, nombre Asc;";
		}

		try (Connection cnn = DriverManager.getConnection(DRIVER_URL);
				PreparedStatement pst = cnn.prepareStatement(sql);) {

			pst.setInt(1, edad);

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					Futbolista fut = new Futbolista();
					fut.setAltura(rs.getFloat("altura"));
					fut.setEdad(rs.getInt("edad"));
					fut.setEquipo(rs.getString("equipo"));
					fut.setId(rs.getInt("id"));
					fut.setNacionalidad(rs.getString("nacionalidad"));
					fut.setNombre(rs.getString("nombre"));

					futs.add(fut);
				}
			}
		} catch (SQLException e) {
			throw new Exception("Ha habido un problema con la conexi�n a la BBDD...");
		} catch (Exception e) {
			throw new Exception("Ha ocurrido un error");
		}

		return futs;
	}

}
