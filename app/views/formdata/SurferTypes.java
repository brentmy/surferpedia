package views.formdata;

import java.util.HashMap;
import java.util.Map;

/**
 * Hey.
 * @author Brent
 *
 */
public class SurferTypes {
  private static String[] types = {"Male", "Female", "Grom"};
  
  /**
   * 
   * @return typeMap abc.
   */
  public static Map<String, Boolean> types() {
    Map<String, Boolean> typeMap = new HashMap<>();
    for (String type : types) {
      typeMap.put(type, false);
    }
    return typeMap;
  }
  
  /**
   * @param surferType s.
   * @return surferType asc.
   */
  public static Map<String, Boolean> getTypes(String surferType) {
    Map<String, Boolean> typeMap = SurferTypes.types();
    if (isType(surferType)) {
    typeMap.put(surferType, true);
    }
    return typeMap;
  }
  
  /**
   * true if valid type.
   * @param telType asd.
   * @return boolean.
   */
  public static boolean isType(String surfType) {
    return SurferTypes.types().keySet().contains(surfType);
  }
    


}
