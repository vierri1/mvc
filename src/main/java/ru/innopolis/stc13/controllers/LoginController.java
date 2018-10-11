package ru.innopolis.stc13.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(name = "login_error", required = false) String error,
                        @RequestParam(name = "logout", required = false) String logout,
                        Model model){
        return "login";
    }

    @RequestMapping("/openpage")
    public String getOpenPage(Model model) {
        return "openpage";
    }

    @RequestMapping("/adminpage")
    public String getAdminPage(Model model) {
        return "adminpage";
    }

    @RequestMapping("/userpage")
    public String getUserPage(Model model) {
        return "userpage";
    }
}
