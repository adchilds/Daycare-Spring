package com.adamchilds.daycare.common;

import com.adamchilds.daycare.exception.DaycareException;
import com.adamchilds.daycare.user.model.UserModel;
import com.adamchilds.daycare.user.model.UserModelValidator;
import com.adamchilds.daycare.user.service.UserModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.List;

/**
 * This class handles the login page's functionality
 */
@Controller
@SessionAttributes
class LoginController {

    // Used if we want to write a custom Validator
    @Autowired
    private UserModelValidator validator;

    // Our service which allows us to execute operations
    // on the database given a UserModel
    @Autowired
    private UserModelService userModelService;

    /**
     * Executed when the user clicks the "Login" button
     *
     * @param user The new UserModel being created and persisted to the database
     * @param result The result of any errors returned by the validator
     * @param modelMap A map that will persist data for consecutive page loads
     * @return A new ModelAndView instance, pointing to the login.jsp file
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView postLogin(@ModelAttribute("user") UserModel user, BindingResult result, ModelMap modelMap) {
        // Check for validation errors
        validator.validate(user, result);
        if (result.hasErrors()) {
            modelMap.put("user", user);
            modelMap.put("userModelList", userModelService.readAllUserModels());
            return new ModelAndView("/login", modelMap);
        } else {
            // Remove the user from the modelMap since we don't want the username and password
            // to stay in their appropriate textfield when the page reloads
            modelMap.remove(user);
        }

        // Persist new user data
        userModelService.create(user);
        userModelService.update(user);

        modelMap.put("userModelList", userModelService.readAllUserModels());

        // "redirect:/dashboard.html" goes to a dashboard.html page but doesn't carry over the data from modelMap
        return new ModelAndView("/login", modelMap);
    }

    /**
     * Handles setting up the view of the login page when it's first opened
     *
     * @return A new ModelAndView instance, pointing to the login.jsp file
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLogin() {
        return new ModelAndView("/login", "user", new UserModel());
    }

    /**
     * Executed when the user attempts to delete an entry in the "User List" table.
     *
     * @param userModelId The id of the UserModel being deleted
     * @param modelMap The map that needs to be updated after the UserModel has been deleted
     * @return A new ModelAndView instance, pointing to the login.jsp file
     */
    @RequestMapping(value = "/delete/{userModelId}", method = RequestMethod.GET)
    public ModelAndView removeUserModel(@PathVariable("userModelId") int userModelId, ModelMap modelMap) throws DaycareException {
        List<UserModel> userModelList = userModelService.readAllUserModels();

        UserModel userModelToDelete;
        try {
            // Remove the UserModel from the database
            userModelToDelete = userModelService.read(new Integer(userModelId).longValue());
            userModelService.remove(userModelToDelete);

            // Remove the UserModel from the List<UserModel>
            userModelList.remove(userModelToDelete);
        } catch (NullPointerException|IllegalArgumentException e) {
            // Nothing needs to be done except for a page reload. Reload will handle fixing the table.
            throw new DaycareException( "UserModel cannot be found in database, fixing view...", e );
        }

        modelMap.put("user", new UserModel());
        modelMap.put("userModelList", userModelList);

        return new ModelAndView(new InternalResourceView("/login"), modelMap);
    }

    /**
     * Executed when the user attempts to update an entry in the "User List" table.
     *
     * @param userModelId The id of the UserModel being updated
     * @param modelMap The map that needs to be updated after the UserModel has been updated
     * @return A new ModelAndView instance, pointing to the login.jsp file
     */
    @RequestMapping(value = "/update/{userModelId}", method = RequestMethod.GET)
    public ModelAndView updateUserModel(@PathVariable("userModelId") int userModelId, @ModelAttribute("user") UserModel userModel, ModelMap modelMap) {
        System.out.println("IN UPDATEUSERMODEL method");
        List<UserModel> userModelList = userModelService.readAllUserModels();
        UserModel userModelToUpdate = userModelService.read(new Integer(userModelId).longValue());

        System.out.println("NEW USER_MODEL: " + userModel);
        System.out.println("userModelToUpdate in updateUserModel() method (BEFORE): " + userModelToUpdate);

        try {
            userModelToUpdate.setUsername(userModel.getUsername());
            userModelToUpdate.setPassword(userModel.getPassword());

            System.out.println("userModelToUpdate in updateUserModel() method (AFTER): " + userModelToUpdate);

            userModelService.update(userModelToUpdate);

            System.out.println("NEW USER_MODEL IN DATABASE: " + userModelService.read(new Integer(userModelId).longValue()));
        } catch (NullPointerException e) {
            System.out.println( "UserModel cannot be found in database, fixing view..." );
        }

        modelMap.put("user", new UserModel());
        modelMap.put("userModelList", userModelList);

        return new ModelAndView(new InternalResourceView("/login"), modelMap);
    }
}