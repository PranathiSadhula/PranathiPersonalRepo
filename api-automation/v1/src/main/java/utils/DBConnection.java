package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import utils.constants.Constants;
import utils.constants.PropertyReaderUtil;

public class DBConnection  extends PropertyReaderUtil{

	/** This variable holds the value of Connection */
	private static Connection connection = null;

	private static DBConnection singleDBConnection;

	/** Class Level Varaible - log */
	//static Logger log = Logger.getLogger(DBConnection.class);
	static Logger infolog = Logger.getLogger("infolog");
	static Logger errorlog = Logger.getLogger("errorlog");
	

	/** This varaible contains ths Config Path */
	public static String configPath = null;

	private DBConnection()  {
		loadDatabaseDriver();
		setConnection(getConnection( prop.getProperty(Constants.DB_URL), prop.getProperty(Constants.DB_USER_NAME), prop.getProperty(Constants.DB_PASSWORD)));

	}

	public static DBConnection getDBConnection()  {

		if (singleDBConnection == null) {
			singleDBConnection = new DBConnection();
		}
		return singleDBConnection;
	}

	private static void loadDatabaseDriver()  {
		try {
			String dbDriver = prop.getProperty(Constants.ORACLEDRIVER);
			Class.forName(dbDriver);
			infolog.info("database driver "+dbDriver+" is loaded");
		} catch (ClassNotFoundException ce) {
			errorlog.error(ce);
			
		}
	}
	
	private static Connection getConnection(
			String dbname,
			String user,
			String passwd)
			
		{

			Connection con = null;
			String dburl = prop.getProperty(Constants.DBCONNECTIONSTR) + dbname;
			
			try {
				con = DriverManager.getConnection(dburl, user, passwd);
				infolog.info(DBConnection.class+" DB connection is established "+con);
			} catch (SQLException e) {
				errorlog.error(e);
			}
			return con;
		}

	
	public static void closeConnection(Connection connection)
	{
		if (connection != null)
		{
			try
			{
				connection.close();
				connection = null;
			}
			catch (SQLException e)
			{
				errorlog.warn(e);
			}
		}
	}

	public  Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		DBConnection.connection = connection;
	}

}
