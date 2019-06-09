import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
  private List guitars;
  
  

  public Inventory() {
    guitars = new LinkedList();
  }

  public void addGuitar(String sql) {
	  
	  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/guitar_inventory?serverTimezone=Asia/Seoul","root","7202");
			Statement stmt = conn.createStatement(); 
			
			stmt.executeUpdate(sql);
			conn.close();
			
		} catch(ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} 
		catch(SQLException e) {
			System.out.println(e);
		}
//    Guitar guitar = new Guitar(serialNumber, price, spec);
//    guitars.add(guitar);
  }
  
//쓸모없니?
  
//  public Guitar getGuitar(String serialNumber) {
//    for (Iterator i = guitars.iterator(); i.hasNext(); ) {
//      Guitar guitar = (Guitar)i.next();
//      if (guitar.getSerialNumber().equals(serialNumber)) {
//        return guitar;
//      }
//    }
//    return null;
//  }

  public List search(GuitarSpec searchSpec) {
    List matchingGuitars = new LinkedList();
    for (Iterator i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar)i.next();
      if (guitar.getSpec().matches(searchSpec))
        matchingGuitars.add(guitar);
    }
    return matchingGuitars;
  }
}
