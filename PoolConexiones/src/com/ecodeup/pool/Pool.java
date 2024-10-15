package com.ecodeup.pool;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class Pool {
	private static BasicDataSource ds = null;

	public static DataSource getDataSource() {
		if (ds == null) {
			ds = new BasicDataSource();
			ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
			ds.setUsername("root");
			ds.setPassword("root");
			ds.setUrl("jdbc:mysql://localhost:3306/test");
			// Definimos el tamano del pool de conexiones
			ds.setInitialSize(50);// 50 Conexiones iniciales
			ds.setMaxIdle(10);
			ds.setMaxTotal(20);
			ds.setMaxWaitMillis(5000);

		}
		return ds;
	}

	public static Connection getConexion() throws SQLException {
		return getDataSource().getConnection();
	}
}
