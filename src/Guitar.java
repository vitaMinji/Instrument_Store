import java.sql.ResultSet;

public class Guitar {

  private String serialNumber;
  private double price;
  GuitarSpec spec;

  public Guitar(String serialNumber, String sql) {
    this.serialNumber = serialNumber;
    ResultSet resultSet;
    resultSet = stmt.executeQuery("select price from guitar where id='"+serialNumber+"'");
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
