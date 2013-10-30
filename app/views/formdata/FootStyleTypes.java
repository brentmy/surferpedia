package views.formdata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represent a student grade level.
 * This class includes:
 * <ul>
 * <li> The model structure (fields, plus getters and setters).
 * <li> Some methods to facilitate form display and manipulation (getNameList, etc.).
 * <li> Some fields and methods to "fake" a database of FootStyleTypess.
 * </ul>
 */
public class FootStyleTypes {
  private long id;
  private String name;

  /**
   * Create a new Grade Level.
   * @param id The id.
   * @param name The name of the grade.
   */
  public FootStyleTypes(long id, String name) {
    this.id = id;
    this.name = name;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  /**
   * Provide a list of names for use in form display.
   * @return A list of level names in sorted order.
   */
  public static List<String> getNameList() {
    String[] nameArray = {"Goofy", "Regular"};
    return Arrays.asList(nameArray);
  }

  /**
   * Return the FootStyleTypes instance in the database with name 'levelName' or null if not found.
   * @param levelName The Level name.
   * @return The FootStyleTypes instance, or null if not found.
   */
  public static FootStyleTypes findLevel(String levelName) {
    for (FootStyleTypes level : allLevels) {
      if (levelName.equals(level.getName())) {
        return level;
      }
    }
    return null;
  }

  /**
   * Provide a default grade level for use in form display.
   * @return The default grade level.
   */
  public static FootStyleTypes getDefaultLevel() {
    return findLevel("Goofy");
  }

  @Override
  public String toString() {
    return String.format("[FootStyleTypes %s]", this.name);
  }

  /** Fake a database of Grade Levels. */
  private static List<FootStyleTypes> allLevels = new ArrayList<>();

  /** Instantiate the fake database. */
  static {
    allLevels.add(new FootStyleTypes(1L, "Goofy"));
    allLevels.add(new FootStyleTypes(2L, "Regular"));

  }


}
