package Exercises.List_8.Task_6;

public class Author {
    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("%s (%s, %s)", name, email, gender);
    }
}
