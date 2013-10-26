package controllers;

import java.util.Map;
import models.SurferDB;
import play.mvc.Controller;
import play.data.Form;
import play.mvc.Result;
import views.html.Index;
import views.formdata.SurferFormData;
import views.formdata.SurferTypes;
import views.html.ManageSurfer;
import views.formdata.SurferFormData;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page. 
   * @return The resulting home page. 
   */
  public static Result index() {
    return ok(Index.render(SurferDB.getSurfers()));
  }
  
  /**
   * Returns new contact form simple form.
   * @param id s.
   * @return The new Contact form.
   */
  public static Result newSurfer(long id) {
    SurferFormData form = id == 0 ? new SurferFormData() : new SurferFormData(SurferDB.getSurfer(id)); 
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(form);
    Map<String, Boolean> surferTypeMap = SurferTypes.getTypes(form.surfType);
    return ok(ManageSurfer.render(formData, surferTypeMap));
    
  }
  
  /**
   * Handles the posting of data.
   * @return sadas.
   */
  public static Result postContact() {
    Form<SurferFormData> formData = Form.form(SurferFormData.class).bindFromRequest();
    
    if (formData.hasErrors()) {
      System.out.println("Errors");
      Map<String, Boolean> telephoneTypeMap = SurferTypes.types();
      return badRequest(ManageSurfer.render(formData, telephoneTypeMap));
    }
    
    else {
    SurferFormData data = formData.get();
    SurferDB.addSurfer(data);
    Map<String, Boolean> telephoneTypeMap = SurferTypes.getTypes(data.surfType);
        return ok(ManageSurfer.render(formData, telephoneTypeMap));
    }
  }
}
