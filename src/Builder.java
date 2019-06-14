public enum Builder { 

  FENDER, MARTIN, GIBSON, COLLINGS, OLSON, RYAN, PRS, ANY;

  public String toString() {
    switch(this) {
      case FENDER:   return "Fender";
      case MARTIN:   return "Martin";
      case GIBSON:   return "Gibson";
      case COLLINGS: return "Collings";
      case OLSON:    return "Olson";
      case RYAN:     return "Ryan";
      case PRS :     return "PRS";
      default:       return "Unspecified";
    }
  }
  
  static private String tempText;
  
  public static Builder toEnum(String text) {
      for (Builder b : Builder.values()) {
    	  tempText=b.toString();
          if (b.tempText.equalsIgnoreCase(text)) {
              return b;
          }
      }
      return null;
  }
}
