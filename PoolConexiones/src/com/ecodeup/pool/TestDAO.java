package com.ecodeup.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDAO {
	private Connection connection = null;

	public TestDAO() {
		// TODO Auto-generated constructor stub
	}

	// registar un articulo
	public boolean registrar(Articulo a) throws SQLException {
		boolean estado = false;
		Statement stm;

		connection = getConnection();

		String sqlArticulos = "INSERT INTO articulos VALUES (NULL,'" + a.getNombre() + "','" + a.getDescripcion() + "',"
				+ a.getPrecio() + ")";

		try {
			connection.setAutoCommit(false); // le indicamos el inicio de la transacci�n
			stm = connection.createStatement();
			stm.executeUpdate(sqlArticulos);
			connection.commit(); // si todo va bien hacemos commit y guardamos los datos
			estado = true;
			stm.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				estado = false;
				connection.rollback(); // si algo pas� en la transacci�n hacemos roollback y no se guarda
										// ningun registro
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return estado;
	}

	// accede a la conexi�n de la clase Pool
	private Connection getConnection() throws SQLException {
		return Pool.getConexion();
	}

}
