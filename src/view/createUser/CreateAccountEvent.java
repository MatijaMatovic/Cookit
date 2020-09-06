/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.createUser;

import java.time.LocalDate;
import java.util.EventObject;

/**
 *
 * @author jovandjordjic
 */
public class CreateAccountEvent extends EventObject{
    
    private String username;
    private String password;
    
    private String name;
    private String surname;
    private String email;
    
    private LocalDate birthDate;
    
    public CreateAccountEvent(Object source) {
        super(source);
    }

    public CreateAccountEvent(String username, String password, String name, String surname, String email, LocalDate birthDate, Object source) {
        super(source);
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthDate = birthDate;
    }
    
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    
    
    
    
}
