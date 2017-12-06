package sql;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;


/**
 * 
 * @author joel kass
 *
 */

public class Database implements DataBaseInt {

	private final String DB_DRIVER = "org.h2.Driver";
	final static Logger logger = Logger.getLogger(Database.class);
	private PreparedStatement createPreparedStatement = null;
	private PreparedStatement insertPreparedStatement = null;
	private PreparedStatement selectPreparedStatement = null;
	private PreparedStatement selectPreparedStatement1 = null;

	/**
	 * runQueries()
	 * 
	 * run the queries
	 * 
	 * @throws SQLException
	 * @throws IOException
	 */

	@Override
	public void runQueries() throws SQLException, IOException {
		Connection connection = getDBConnection();

		String CreateQuery = getSQL("CreateTables.sql");
		String InsertQuery = getSQL("InsertData.sql");

		String SelectQuery1 = getSQL("Select1.sql");

		String SelectQuery2 = getSQL("Select2.sql");

		try {

			// open the connection and execute the queries
			connection.setAutoCommit(false);

			createPreparedStatement = connection.prepareStatement(CreateQuery);
			createPreparedStatement.executeUpdate();
			createPreparedStatement.close();

			insertPreparedStatement = connection.prepareStatement(InsertQuery);

			insertPreparedStatement.executeUpdate();
			insertPreparedStatement.close();

			selectPreparedStatement = connection.prepareStatement(SelectQuery1);
			ResultSet rs = selectPreparedStatement.executeQuery();

			// execute query 1
			logger.info("Query1 -Top Scoring Teams");
			while (rs.next()) {

				logger.info(
						"TeamName  :" + rs.getString("TEAMNAME") + "  " + "TotalGoals  :" + rs.getInt("SUM(NUMGOALS)"));

			}

			logger.info("SQL Query1: " + SelectQuery1);

			logger.info("================================================================");

			// execute query 2
			selectPreparedStatement1 = connection.prepareStatement(SelectQuery2);
			ResultSet rs2 = selectPreparedStatement1.executeQuery();
			logger.info("Query2- top scoring player on every team");
			while (rs2.next()) {

				logger.info("TeamName  :" + rs2.getString("TEAMNAME") + "  " + "FirstName  :"
						+ rs2.getString("FIRSTNAME") + "  " + "LastName  :" + rs2.getString("LASTNAME") + "  "
						+ "Number of Goals  :" + rs2.getInt("NUMGOALS") + "  ");

			}

			logger.info("SQL Query2: " + SelectQuery2);
			selectPreparedStatement1.close();

			connection.commit();
		} catch (SQLException e) {
			logger.info("Exception Message " + e.getLocalizedMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	@Override
	/**
	 * getDBConnection() Sets up the database connection
	 * 
	 */
	public Connection getDBConnection() {
		Connection dbConnection = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			logger.info(e.getMessage());
		}
		try {
			dbConnection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			return dbConnection;
		} catch (SQLException e) {
			logger.info(e.getMessage());
		}
		return dbConnection;
	}

	/**
	 * getSQL
	 * 
	 * reads the sql file from the resources directory
	 * 
	 * @param name
	 * @return
	 */
	public static String getSQL(String name) {

		String fileName = name;
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());

		// Read File Content
		String content = null;
		try {
			content = new String(Files.readAllBytes(file.toPath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return content;

	}

}
