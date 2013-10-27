package models;

public class Surfer {
    private String surferName;
    private String home;
    private String awards;
    private String carouselUrl;
    private String bioUrl;
    private String bio;
    private String slug;
    private String type;
    
    /** 
     *
     * @param id the id.
     * @param surferName the first name.
     * @param home the last name.
     * @param carouselUrl the carouselUrl.
     * @param bioUrl the carouselUrl.
     * 
     * */
    public Surfer(String surferName, String home, String awards, String carouselUrl, String bioUrl, String bio, String slug, String type) {
      this.surferName = surferName;
      this.home = home;
      this.awards= awards;
      this.carouselUrl = carouselUrl;
      this.bioUrl = bioUrl;
      this.bio = bio;
      this.slug = slug;
      this.setType(type);
    }
    /** 
     * gets first name.
     * @return first name.
     * */
    public String getSurferName() {
      return surferName;
    }
    /** 
     * gets first name.
     * @param surferName is.
     * 
     * */
    public void setSurferName(String surferName) {
      this.surferName = surferName;
    }
    /** 
     * gets first name.
     * @return first name.
     * */
    public String getHome() {
      return home;
    }
    /** 
     * gets last name.
     * @param home is.
     * 
     * */
    public void setHome(String home) {
      this.home = home;
    }
 
    /**
     * @return the bioUrl
     */
    public String getBioUrl() {
      return bioUrl;
    }
    /**
     * @param bioUrl the bioUrl to set
     */
    public void setBioUrl(String bioUrl) {
      this.bioUrl = bioUrl;
    }
    /**
     * @return the carouselUrl
     */
    public String getCarouselUrl() {
      return carouselUrl;
    }
    /**
     * @param carouselUrl the carouselUrl to set
     */
    public void setCarouselUrl(String carouselUrl) {
      this.carouselUrl = carouselUrl;
    }
    /**
     * @return the bio
     */
    public String getBio() {
      return bio;
    }
    /**
     * @param bio the bio to set
     */
    public void setBio(String bio) {
      this.bio = bio;
    }
    /**
     * @return the slug
     */
    public String getSlug() {
      return slug;
    }
    /**
     * @param slug the slug to set
     */
    public void setSlug(String slug) {
      this.slug = slug;
    }
    /**
     * @return the type
     */
    public String getType() {
      return type;
    }
    /**
     * @param type the type to set
     */
    public void setType(String type) {
      this.type = type;
    }
    /**
     * @return the awards
     */
    public String getAwards() {
      return awards;
    }
    /**
     * @param awards the awards to set
     */
    public void setAwards(String awards) {
      this.awards = awards;
    }


    
  }


