package sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public interface DataBaseInt {
	
	
	public void runQueries() throws SQLException, IOException;
	
	public Connection getDBConnection();

}
