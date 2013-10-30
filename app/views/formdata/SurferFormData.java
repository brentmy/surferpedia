package views.formdata;

import java.util.ArrayList;
import java.util.List;
import models.Surfer;
import models.SurferDB;
import play.data.validation.ValidationError;

/**
 * Backing class for form data.
 * @author Brent
 *
 */

public class SurferFormData {

/** ID #. */
public String awards = "";
/** the First name. */
public String surferName = "";
/** the last name. */
public String home = "";
/** the carousel. */
public String carousel = "";
/** carousel Type. */
public String bioUrl = "";
/** bio Type. */
public String bio = "";
/** slug Type. */
public String slug = "";
/** type Type. */
public String surfType = "";
public String footStyles = "";

/**
 * Empty constructor.
 */
public SurferFormData() {
  //empty constructor 
}



/**
 * @param surferName a.
 * @param home b.
 * @param carousel c.
 * @param bioUrl d.
 */
public SurferFormData(String surferName, String home, String awards, String footStyles, String carousel, String bioUrl, String bio, String slug, String surfType) {
  this.surferName = surferName;
  this.home = home;
  this.awards = awards;
  this.footStyles = footStyles;
  this.carousel = carousel;
  this.bioUrl = bioUrl;
  this.bio = bio;
  this.slug = slug;
  this.surfType = surfType;
}



/**
 * @param contact the contact.
 * 
 */
public SurferFormData(Surfer surfer) {
  this.surferName = surfer.getSurferName();
  this.home = surfer.getHome();
  this.awards = surfer.getAwards();
  this.footStyles = surfer.getFootStyles();
  this.carousel = surfer.getCarouselUrl();
  this.bioUrl = surfer.getBioUrl();
  this.bio = surfer.getBio();
  this.slug = surfer.getSlug();
  this.surfType = surfer.getType();
}

/** Validates the form all fields can't be empty tel is 12 chars. 
 * @return list of errors.
 * 
 * */
public List<ValidationError> validate() {
  List<ValidationError> errors = new ArrayList<>();
  
  if (surferName == null || surferName.length() == 0) {
   errors.add(new ValidationError("surferName", "Name is Required"));
  }
  
  if (home == null || home.length() == 0) {
    errors.add(new ValidationError("home", "home town is required"));
   }
  if (carousel == null || carousel.length() == 0) {
    errors.add(new ValidationError("carousel", "Carousel Url is required"));
   }
  
  if (bioUrl == null || bioUrl.length() == 0) {
    errors.add(new ValidationError("bioUrl", "bio Url is required"));
   }
  
  if (bio == null || bio.length() == 0) {
    errors.add(new ValidationError("bio", "bio is required"));
   }
  if (slug == null || slug.length() == 0) {
    errors.add(new ValidationError("slug", "slug is required"));
   }
  
  if (SurferDB.getSurfer(slug) != null) {
    errors.add(new ValidationError("slug", "slug is already taken"));
   }
  if (!SurferTypes.isType(surfType)) {
    errors.add(new ValidationError("surfType", "Invalid surfer Type"));
   }
  
  return (errors.isEmpty() ? null : errors);
}

}


