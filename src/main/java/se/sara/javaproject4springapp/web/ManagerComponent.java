package se.sara.javaproject4springapp.web;

import org.springframework.stereotype.Component;
import se.sara.javaproject4springapp.model.ManagerDoc;

import java.util.List;

@Component
public class ManagerComponent {

    public List<ManagerDoc> getManagerDoc (){
        return List.of(
                new ManagerDoc("Manager task1", "Daily agenda"),
                new ManagerDoc("Manager task2", "Meetings and conferences"),
                new ManagerDoc("Manager task3", "Admin delegations and overview")
                );
    }

}
