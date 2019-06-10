import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class GuitarSpec {
 
  private Builder builder; 
  private String model;
  private TypeGuitar type;
  private int numStrings;
  private Wood backWood;
  private Wood topWood;

  public GuitarSpec(Builder builder, String model, TypeGuitar type,
                    int numStrings, Wood backWood, Wood topWood) {
    this.builder = builder;
    this.model = model;
    this.type = type;
    this.numStrings = numStrings;
    this.backWood = backWood;
    this.topWood = topWood;
  }

  public Builder getBuilder() {
    return builder;
  }
  
  public void setBuilder(Builder builder) {
	  this.builder=builder;
  }

  public String getModel() {
    return model;
  }
  
  public void setModel(String model) {
	  this.model=model;
  }

  public TypeGuitar getType() {
    return type;
  }
  
  public void setType(TypeGuitar type) {
	  this.type=type;
  }

  public int getNumStrings() {
    return numStrings;
  }
  
  public void setNumStrings(int numStrings) {
	  this.numStrings=numStrings;
  }

  public Wood getBackWood() {
    return backWood;
  }
  
  public void setBackWood(Wood backWood) {
	  this.backWood=backWood;
  }

  public Wood getTopWood() {
    return topWood;
  }
  
  public void setTopWood(Wood topWood) {
	  this.topWood=topWood;
  }

  public List matches() {
	List matchingGuitars = new LinkedList();
    String sql;
    sql = "SELECT * FROM guitar WHERE " + "builder IN ('" + this.getBuilder() + "')" + " AND "
			+ "model IN ('" + this.getModel() + "')" + " AND " + "type IN ('" + this.getType() + "')" + " AND "
			+ "numStrings IN ('" + this.getNumStrings() + "')" + " AND " + "backWood IN ('" + this.getBackWood()
			+ "')" + " AND " + "topWood IN ('" + this.getTopWood() + "')";
    try {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection conn=null;
    	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/guitar_inventory?serverTimezone=Asia/Seoul","root","7202");
    	Statement stmt = conn.createStatement(); 
    				
    	stmt.executeUpdate(sql);
    				
    } catch(ClassNotFoundException e) {
    	System.out.println("JDBC 드라이버 로드 에러");
    } catch(SQLException e) {
    	System.out.println(e);
    }
    return matchingGuitars;
  }
}
