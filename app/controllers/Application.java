package controllers;

import java.util.Map;
import models.SurferDB;
import play.mvc.Controller;
import play.data.Form;
import play.mvc.Result;
import views.html.Index;
import views.html.ShowSurfer;
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
    return ok(Index.render(""));
  }
  
  /**
   * Returns new contact form simple form.
   * @param id s.
   * @return The new Contact form.
   */
  public static Result newSurfer() {
    SurferFormData data = new SurferFormData();
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    Map<String, Boolean> surferTypeMap = SurferTypes.types();
    return ok(ManageSurfer.render(formData, surferTypeMap,false));
    
  }
  
  /**
   * Handles the posting of data.
   * @return sadas.
   */
  public static Result postSurfer() {
    Form<SurferFormData> formData = Form.form(SurferFormData.class).bindFromRequest();
    
    if (formData.hasErrors()) {
      System.out.println("Errors");
      Map<String, Boolean> surfTypeMap = SurferTypes.types();
      return badRequest(ManageSurfer.render(formData, surfTypeMap, false));
    }
    
    else {
    SurferFormData data = formData.get();
    Map<String, Boolean> surfTypeMap = SurferTypes.getTypes(data.surfType);
    SurferDB.addSurfer(data);
        return ok(ShowSurfer.render(formData));
    }
  }
  public static Result deleteSurfer(String slug) {
    SurferDB.deleteSurfer(slug);
    return ok(Index.render(""));
  }
  
  public static Result getSurfer(String slug) {
    SurferFormData data = new SurferFormData(SurferDB.getSurfer(slug));
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    return ok(ShowSurfer.render(formData));
  }
  
  public static Result manageSurfer(String slug) {
    SurferFormData data = new SurferFormData(SurferDB.getSurfer(slug));
   
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    Map<String, Boolean> surferTypeMap = SurferTypes.getTypes(data.surfType);
    return ok(ManageSurfer.render(formData, surferTypeMap, true));
  }
}
