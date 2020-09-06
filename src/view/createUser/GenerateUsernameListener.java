/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.createUser;

import java.util.EventListener;

/**
 *
 * @author jovandjordjic
 */
public interface GenerateUsernameListener extends EventListener{
    public void generateUsernameEventOccured(GenerateUsernameEvent e);
}
