package controllers;

import java.util.Map;
import models.SurferDB;
import models.UserInfo;
import models.UserInfoDB;
import play.mvc.Controller;
import play.mvc.Security;
import play.data.Form;
import play.mvc.Result;
import views.html.Index;
import views.html.ShowSurfer;
import views.html.Login;
import views.formdata.FootStyleTypes;
import views.formdata.LoginFormData;
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
  @Security.Authenticated(Secured.class)
  public static Result newSurfer() {
    SurferFormData data = new SurferFormData();
    UserInfo user = UserInfoDB.getUser(request().username());
    String email = user.getEmail();
    Boolean isLoggedIn = (user != null);
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    Map<String, Boolean> surferTypeMap = SurferTypes.getTypes(data.surfType);
    return ok(ManageSurfer.render("New", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData, surferTypeMap, false, FootStyleTypes.getNameList()));
    
  }
  
  
  public static Result deleteSurfer(String slug) {
    SurferDB.deleteSurfer(slug);
    return ok(Index.render(""));
  }
  
  public static Result getSurfer(String slug) {
    UserInfo user = UserInfoDB.getUser(request().username());
    String email = user.getEmail();
    Boolean isLoggedIn = (user != null);
    SurferFormData data = new SurferFormData(SurferDB.getSurfer(slug));
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    return ok(ShowSurfer.render("show",Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),formData));
  }
  
  public static Result manageSurfer(String slug) {
    SurferFormData data = new SurferFormData(SurferDB.getSurfer(slug));
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    Map<String, Boolean> surferTypeMap = SurferTypes.getTypes(data.surfType);
    return ok(ManageSurfer.render("New", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData, surferTypeMap, false, FootStyleTypes.getNameList()));
  }
  /**
   * Handles the posting of data.
   * @return sadas.
   */
  public static Result postSurfer() {
    Form<SurferFormData> formData = Form.form(SurferFormData.class).bindFromRequest();
    
    if (formData.hasErrors()) {
      Map<String, Boolean> surfTypeMap = SurferTypes.types();
      return badRequest(ManageSurfer.render("New", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData, surfTypeMap, false, FootStyleTypes.getNameList()));
    }
    
    else {
    SurferFormData data = formData.get();
    SurferDB.addSurfer(data);
        return ok(ShowSurfer.render("show",Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),formData));
    }
  }
  /**
   * Provides the Login page (only to unauthenticated users). 
   * @return The Login page. 
   */
  public static Result login() {
    Form<LoginFormData> formData = Form.form(LoginFormData.class);
    return ok(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData));
  }


  /**
   * Processes a login form submission from an unauthenticated user. 
   * First we bind the HTTP POST data to an instance of LoginFormData.
   * The binding process will invoke the LoginFormData.validate() method.
   * If errors are found, re-render the page, displaying the error data. 
   * If errors not found, render the page with the good data. 
   * @return The index page with the results of validation. 
   */
  public static Result postLogin() {

    // Get the submitted form data from the request object, and run validation.
    Form<LoginFormData> formData = Form.form(LoginFormData.class).bindFromRequest();

    if (formData.hasErrors()) {
      flash("error", "Login credentials not valid.");
      return badRequest(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData));
    }
    else {
      // email/password OK, so now we set the session variable and only go to authenticated pages.
      session().clear();
      session("email", formData.get().email);
      return redirect(routes.Application.profile());
    }
  }
  
  /**
   * Logs out (only for authenticated users) and returns them to the Index page. 
   * @return A redirect to the Index page. 
   */
  @Security.Authenticated(Secured.class)
  public static Result logout() {
    session().clear();
    return redirect(routes.Application.index());
  }
  
  /**
   * Provides the Profile page (only to authenticated users).
   * @return The Profile page. 
   */
  @Security.Authenticated(Secured.class)
  public static Result profile() {
    return ok(Profile.render("Profile", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
  }
}

