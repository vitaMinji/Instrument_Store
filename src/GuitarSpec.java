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

  public String getModel() {
    return model;
  }

  public TypeGuitar getType() {
    return type;
  }

  public int getNumStrings() {
    return numStrings;
  }

  public Wood getBackWood() {
    return backWood;
  }

  public Wood getTopWood() {
    return topWood;
  }

  public boolean matches(GuitarSpec otherSpec) {
    if (builder != otherSpec.builder)
      return false;
    if ((model != null) && (!model.equals("")) &&
        (!model.toLowerCase().equals(otherSpec.model.toLowerCase())))
      return false;
    if (type != otherSpec.type)
      return false;
    if (numStrings != otherSpec.numStrings)
      return false;
    if (backWood != otherSpec.backWood)
      return false;
    if (topWood != otherSpec.topWood)
      return false;
    return true;
  }
}
