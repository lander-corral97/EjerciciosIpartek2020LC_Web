package com.ipartek.formacion.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.pojo.Perro;

public class PerroDAOSqlite implements PerroDAO {

	private static final String PATH = "ddbb/perrera.db";

	@Override
	public ArrayList<Perro> listar() {
		String sql = "Select * From perro Order By nombre ASC;";
		ArrayList<Perro> perros = new ArrayList<Perro>();

		try (Connection cnn = DriverManager.getConnection("jdbc:sqlite:" + PATH);
				PreparedStatement pst = cnn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {

			while (rs.next()) {
				Perro p = new Perro();
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				/*
				 * p.setRaza(rs.getString("raza")); p.setPeso(rs.getFloat("peso"));
				 * p.setVacunado(rs.getBoolean("vacunado"));
				 * p.setHistoria(rs.getString("historia"));
				 */
				perros.add(p);
			}

			/*
			 * for (Perro perro : perros) { System.out.println(perro); }
			 */

		} catch (SQLException e) {
			System.err.println("Error: SQLException");
		}

		return perros;
	}

	@Override
	public Perro recuperar(int id) {
		Perro perro = null;

		String sql = "Select * From Perro Where id = ?;";

		try (Connection cnn = DriverManager.getConnection("jdbc:sqlite:" + PATH);
				PreparedStatement pst = cnn.prepareStatement(sql);) {
			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					perro = new Perro();
					perro.setId(rs.getInt("id"));
					perro.setNombre(rs.getString("nombre"));
				}
			}
		} catch (SQLException e) {
			System.err.println("Error: SQLException");
		}
		return perro;
	}

	@Override
	public Perro crear(Perro p) throws Exception {
		Perro perro = null;
		String sql = "Insert into perro (nombre, peso) Values (?,?);";
		try (Connection cnn = DriverManager.getConnection("jdbc:sqlite:" + PATH);
				PreparedStatement pst = cnn.prepareStatement(sql);) {
			pst.setString(1, p.getNombre());
			pst.setFloat(2, p.getPeso());

			pst.executeUpdate();
		}

		return perro;
	}

	@Override
	public Perro modificar(Perro p) throws Exception {
		Perro perro = null;
		String sql = "Update perro nombre = ?, peso = ? Where id = ?;";
		try (Connection cnn = DriverManager.getConnection("jdbc:sqlite:" + PATH);
				PreparedStatement pst = cnn.prepareStatement(sql);) {
			pst.setString(1, p.getNombre());
			pst.setFloat(2, p.getPeso());
			pst.setInt(3, p.getId());

			pst.executeUpdate();
		}

		return perro;
	}

	@Override
	public boolean eliminar(int id) throws Exception {
		Boolean resul = false;
		String sql = "Delete From perro Where id = ?;";
		try (Connection cnn = DriverManager.getConnection("jdbc:sqlite:" + PATH);
				PreparedStatement pst = cnn.prepareStatement(sql);) {
			pst.setInt(1, id);

			if (pst.executeUpdate() == 1) {
				resul = true;
			}
		}

		return resul;
	}

}
