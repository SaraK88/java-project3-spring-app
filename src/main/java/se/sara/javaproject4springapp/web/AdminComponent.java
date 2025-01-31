package se.sara.javaproject4springapp.web;

import org.springframework.stereotype.Component;
import se.sara.javaproject4springapp.model.AdminDoc;

import java.util.List;

@Component
public class AdminComponent {

    public List<AdminDoc> getAdminDoc (){
        return List.of(
                new AdminDoc("Admin task 1", "Monthly account maintenance"),
                new AdminDoc("Admin task 2", "Information update"),
                new AdminDoc("Admin task 3", "Member coasts and benefits")
        );
    }
}
