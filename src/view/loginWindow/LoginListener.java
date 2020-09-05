/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.loginWindow;

import java.util.EventListener;

/**
 *
 * @author jovandjordjic
 */
public interface LoginListener extends EventListener {
    public void loginEventEmitted(LoginEvent e);
}
