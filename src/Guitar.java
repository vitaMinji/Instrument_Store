import java.sql.ResultSet;
import java.sql.Statement;

public class Guitar {

  private String serialNumber;
  private double price;
  GuitarSpec spec;
  ConnectDB cdb;
  
  
  public Guitar(String serialNumber, String sql) {
	cdb.connectDB();
	Statement stmt = null;
    this.serialNumber = serialNumber;
    ResultSet resultSet;
    
    this.price = price;
    this.spec = spec;
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(float newPrice) {
    this.price = newPrice;
  }

  public GuitarSpec getSpec() {
    return spec;
  }
}


//public class Guitar {
//
//	  private String serialNumber;
//	  private double price;
//	  GuitarSpec spec;
//
//	  public Guitar(String serialNumber, double price, GuitarSpec spec) {
//	    this.serialNumber = serialNumber;
//	    this.price = price;
//	    this.spec = spec;
//	  }
//
//	  public String getSerialNumber() {
//	    return serialNumber;
//	  }
//
//	  public double getPrice() {
//	    return price;
//	  }
//
//	  public void setPrice(float newPrice) {
//	    this.price = newPrice;
//	  }
//
//	  public GuitarSpec getSpec() {
//	    return spec;
//	  }
//	}
