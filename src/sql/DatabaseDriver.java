package sql;

import java.sql.SQLException;

import org.h2.tools.DeleteDbFiles;

public class DatabaseDriver {
	
	
/**
 * Driver for database queries
 * @param args
 * @throws Exception
 */
    public static void main(String[] args) throws Exception {
        try {
        	
        	
        	Database data = new Database();
        	DeleteDbFiles.execute("~", "test", true);
        	
            data.runQueries();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
