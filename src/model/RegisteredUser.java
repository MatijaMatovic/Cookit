package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class RegisteredUser extends AccountOwner {

    public String name;

    public String surname;

    public String birthDate;

    public boolean privileged = false;

    public Set<Integer> recipeIDs;

    public Set<Review> reviews;

    public Set<String> following;
    
    
    public RegisteredUser() {
        recipeIDs = new HashSet<>();
        reviews = new HashSet<>();
        following = new HashSet<>();
    }


    public RegisteredUser(String name) {
        this();
        this.name = name; 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return LocalDate.parse(this.birthDate, DateTimeFormatter.ISO_DATE);
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate.format(DateTimeFormatter.ISO_DATE);
    }

    public boolean isPrivileged() {
        return privileged;
    }

    public void setPrivileged(boolean privileged) {
        this.privileged = privileged;
    }

    public Set<Integer> getRecipes() {
        return recipeIDs;
    }

    public void setRecipes(Set<Integer> recipes) {
        this.recipeIDs = recipes;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Set<String> getFollowing() {
        return following;
    }

    public void setFollowing(Set<String> following) {
        this.following = following;
    }
    
    

}