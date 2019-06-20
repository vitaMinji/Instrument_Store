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
  
  
  //DB 에서 넘어온 값을 사용하기 위함
  //string-->enum
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