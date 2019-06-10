import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {
	public String url="\"jdbc:mysql://localhost:3306/guitar_inventory?serverTimezone=Asia/Seoul\",\"root\",\"7202\"";
	public void connectDB() {
		
	  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=null;
			conn = DriverManager.getConnection(url);	
		} catch(ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} 
		catch(SQLException e) {
			System.out.println(e);
		}
}
}
