package se.sara.javaproject4springapp.model;


public class AdminDoc {
    private String title;
    private String description;

    public AdminDoc(String title, String description) {
        this.title = title;
        this.description = description;

    }

    public AdminDoc() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
