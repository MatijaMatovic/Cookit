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

    public RegisteredUser(String name) {
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
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isPrivileged() {
        return privileged;
    }

    public void setPrivileged(boolean privileged) {
        this.privileged = privileged;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Set<RegisteredUser> getFollowing() {
        return following;
    }

    public void setFollowing(Set<RegisteredUser> following) {
        this.following = following;
    }
    
    

}