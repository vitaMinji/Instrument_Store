import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
  
  //추가한것
  private Connection conn;
  private Statement stmt;
  private ResultSet rs;

  public Inventory() {
	  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/guitar_inventory?serverTimezone=Asia/Seoul","root","7202");
			stmt = conn.createStatement(); 
			
		} catch(ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} 
		catch(SQLException e) {
			System.out.println(e);
		}
  }

  public void addGuitar(String sql) {
	  try {
			stmt.executeUpdate(sql);	
		}
		catch(SQLException e) {
			System.out.println(e);
		}
  }
  
  
  public List search(GuitarSpec searchSpec) {
    List matchingGuitars = new LinkedList();
    //count 사용하자
      try {
    	  String sql;//어따써
    	  sql = "SELECT * FROM guitar WHERE " + "builder IN ('" + searchSpec.getBuilder() + "')" + " AND "
    			+ "model IN ('" + searchSpec.getModel() + "')" + " AND " + "type IN ('" +  searchSpec.getType() + "')" + " AND "
    			+ "numString IN ('" +  searchSpec.getNumStrings() + "')" + " AND " + "backWood IN ('" +  searchSpec.getBackWood()
    			+ "')" + " AND " + "topWood IN ('" +searchSpec.getTopWood() + "')";
    	  
    	  rs = stmt.executeQuery(sql);
    	  boolean hasNext;
    	  
    	  while(rs.next()) {
    		      matchingGuitars.add(rs);
    	  }
    	  
			
		}
		catch(SQLException e) {
			System.out.println(e);
		}


    return matchingGuitars;
  }
}
