import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

      try {
    	  String sql;
    	  //ELECTRIC이 문제임 왜지
    	  sql = "SELECT * FROM guitar WHERE builder = '" + searchSpec.getBuilder() + "'  AND type ='" +  searchSpec.getType()+"'";
//    	  		+ " AND model ='" + searchSpec.getModel() 
//    	  		+ "'  AND type ='" +  searchSpec.getType() + "' AND numString ='" +  searchSpec.getNumStrings() + "' AND backWood ='" +  searchSpec.getBackWood()
//    			+ "' AND topWood ='" +searchSpec.getTopWood() + "'";
//    	  
    	  rs = stmt.executeQuery(sql);
    	  System.out.println(rs.toString());


    	  while(rs.next()) {
    		  Wood tempBackWood=null;
    		  tempBackWood = tempBackWood.toEnum(rs.getString("backWood"));
    		  Wood tempTopWood=null;
    		  tempTopWood = tempTopWood.toEnum(rs.getString("topWood"));
    		  
    		  Builder tempBuilder=null;
    		  tempBuilder = tempBuilder.toEnum(rs.getString("builder") );
    		  
    		  TypeGuitar tempType=null;
    		  tempType = tempType.toEnum(rs.getString("type"));
    		  
    		  
    		  Guitar gu = new Guitar(rs.getString("serialNumber"),rs.getInt("price"),
    				  new GuitarSpec(tempBuilder ,rs.getString("model")  ,tempType, rs.getInt("numString"), tempBackWood, tempTopWood));
    		
    		  matchingGuitars.add(gu);
    		  
    	  }

		}
		catch(SQLException e) {
			System.out.println(e);
		}


    return matchingGuitars;
  }
}
