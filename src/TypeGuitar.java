public enum TypeGuitar { 

  ACOUSTIC, ELECTRIC;

  public String toString() {
    switch(this) {
      case ACOUSTIC: return "acoustic";
      case ELECTRIC: return "electric";
      default:       return "unspecified";
    }
  }
  
static private String tempText;
  
  public static TypeGuitar toEnum(String text) {
      for (TypeGuitar b : TypeGuitar.values()) {
    	  tempText=b.toString();
          if (b.tempText.equalsIgnoreCase(text)) {
              return b;
          }
      }
      return null;
  }
}