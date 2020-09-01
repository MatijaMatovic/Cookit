package model;

import java.time.LocalDate;
import java.util.Set;

public class RegisteredUser extends AccountOwner {

    public RegisteredUser() {
    }

    public String name;

    public String surname;

    public LocalDate birthDate;

    public boolean privileged = false;

    public Set<Recipe> recipes;

    public Set<Review> reviews;


    public Set<RegisteredUser> following;

}