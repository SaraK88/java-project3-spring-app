package se.sara.javaproject4springapp.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.sara.javaproject4springapp.model.AdminDoc;

import java.util.List;

@Controller
public class AppController {

    private final AdminComponent adminComponent;
    private final ManagerComponent managerComponent;

    public AppController(AdminComponent adminComponent, ManagerComponent managerComponent) {
        this.adminComponent = adminComponent;
        this.managerComponent = managerComponent;
    }

    @GetMapping ("/user")
    public String user(Model model) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("username", username);
        return "user";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        List<AdminDoc> adminDoc = adminComponent.getAdminDoc();
        model.addAttribute("adminDoc", adminDoc);
        return "admin";
    }

    @GetMapping("/manager")
    public String manager (Model model){
        model.addAttribute("managerDoc", managerComponent.getManagerDoc());
        return "manager";
    }
}
