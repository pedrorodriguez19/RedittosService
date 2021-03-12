package com.redittos.socialmedia.dao.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.DriverManager;

import com.redittos.socialmedia.service.DataException;

public class DBUtils {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/Redittos?serverTimezone=UTC&useSSL=false";

	static final String USER = "redittoswebapp";
	static final String PASS = "redittos.2021";
	private static Logger log = LogManager.getLogger();

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(JDBC_DRIVER);
		Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
		return connection;
	}

	public static final void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			log.error(e);
		}
	}

	public static final void close(Statement st) {
		try {
			if (st != null) {
				st.close();
			}
		} catch (Exception e) {
			log.error(e);
		}
	}

	/**
	 * Cierra la conexion.
	 * 
	 * Metodo de cierre <b>para el caso de sentencias con autocommit = true</b>.
	 * 
	 * En caso de autocommit = false deber�a usarse:
	 * {@link #closeConnection(Connection, Boolean)} para que ejecute previamente
	 * commit() o rollback() previamente al cierre.
	 * 
	 * @param connection Conexion a cerrar.
	 * 
	 */
	public static void closeConnection(Connection connection) throws DataException {

		if (connection != null) {
			try {
				// Previene un mal uso
				if (!connection.getAutoCommit()) {
					throw new DataException("Autocommit disabled. Commit or Rollback should be done explicitly.");
				}

				connection.close();
			} catch (SQLException e) {
				throw new DataException(e);
			}
		}
	}

	/**
	 * Metodo de finalizacion de transaccionn <b>para el caso de autocommit =
	 * false</b> y de cierre de conexion.
	 * 
	 * Ejecuta commit() o rollback() y a continuacion cierra la conexi�n.
	 * 
	 * @param connection       Conexion a cerrar.
	 * @param commitOrRollback Si es true ejecuta commit() y en caso contrario
	 *                         ejecuta rollback().
	 */
	public static void closeConnection(Connection connection, boolean commitOrRollback) throws DataException {
		if (connection != null) {
			try {

				if (commitOrRollback) {
					connection.commit();
				} else {
					connection.rollback();
				}
			} catch (SQLException e) {
				throw new DataException(e);
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new DataException(e);
				}
			}
		}
	}

	public static java.sql.Date getDate(Date date) {
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		return sqlDate;
	}
}
