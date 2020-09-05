/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.loginWindow;

import java.util.EventObject;

/**
 *
 * @author jovandjordjic
 */
public class LoginEvent extends EventObject {

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginEvent(Object o) {
        super(o);
    }

    public LoginEvent(String userName, String password, Object o) {
        super(o);
        this.userName = userName;
        this.password = password;
    }

}
