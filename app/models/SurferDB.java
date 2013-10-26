package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.SurferFormData;

/**
 * database for surfers.
 * @author Brent
 *
 */
public class SurferDB {
 private static Map<String, Surfer> surfers = new HashMap<>();
 
 /**
  * Updates contact if 0 and reupdate if not.
  * @param formData the form data.
  * @return contact
  */
public static Surfer addSurfer(SurferFormData formData) {
  Surfer surfer;
  /* long iD2 = (formData.id == 0) ? surfers.size() + 1 : formData.id;// clean entry
  Contact contact = new Contact(iD2, formData.firstName, formData.lastName, formData.telephone);
  surfers.put(iD2, contact);*/
  if (formData.slug == null) {
    String slug=formData.slug;
    surfer = new Surfer(formData.surferName, formData.home, formData.carousel, formData.bioUrl, formData.bio, formData.slug, formData.surfType);
    surfers.put(slug, surfer);
  }
  else {
    surfer = new Surfer(formData.surferName, formData.home, formData.carousel, formData.bioUrl, formData.bio, formData.slug, formData.surfType);
    surfers.put(formData.slug, surfer);
  }
  
  return surfer;
   }
/**
 * 
 * @return contact
 */
public static List<Surfer> getSurfers() {
  return new ArrayList<>(surfers.values());
}
/**
 * gets contact.
 * @param id id.
 * @return contact
 */
public static Surfer getSurfer(String slug)  {
  Surfer surfer = surfers.get(slug);
  if (surfer == null) {
    throw new RuntimeException("Non-Existant slug" + slug);
  }
  return surfer;
}
 
public static void deleteSurfer(String slug) {
  surfers.remove(slug);
}
}
