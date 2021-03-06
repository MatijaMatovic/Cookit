/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.createUser;

import java.util.EventObject;

/**
 *
 * @author jovandjordjic
 */
public class GenerateUsernameEvent extends EventObject{
    
    private String name;
    private String surname;
    private String email;
    
    public GenerateUsernameEvent(Object source) {
        super(source);
    }

    public GenerateUsernameEvent(String name, String surname, String email, Object source) {
        super(source);
        this.name = name;
        this.surname = surname;
        this.email = email;
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
    
    
    
}
