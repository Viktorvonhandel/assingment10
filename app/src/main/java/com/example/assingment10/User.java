package com.example.assingment10;
import java.io.Serializable;
public class User implements Serializable{


    private String firstName;
    private String lastName;
    private String email;
    private String degreeProgram;

    private String UserDegrees;

    public User(String firstName, String lastName, String email, String degreeProgram, String UserDegrees) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.degreeProgram = degreeProgram;
        this.UserDegrees = UserDegrees;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getDegreeProgram() {
        return degreeProgram;
    }
    public String getUserDegrees() {
        return UserDegrees;}
}
