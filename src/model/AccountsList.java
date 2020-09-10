/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jovandjordjic
 */
public class AccountsList {

    private Map<String, Account> allAccountsMap;
    private Map<String, Account> activeAccountsMap;
    private Map<String, Account> inactiveAccountsMap;

    public AccountsList() {
        this.allAccountsMap = new HashMap<>();
        this.activeAccountsMap = new HashMap<>();
        this.inactiveAccountsMap = new HashMap<>();
    }

    public void addAccount(Account a) {

        allAccountsMap.put(a.getUsername(), a);

        boolean active = a.isActive();
        if (active) {
            activeAccountsMap.put(a.getUsername(), a);
        } else {
            inactiveAccountsMap.put(a.getUsername(), a);
        }
    }

    public Account getAccount(String username) {
        return this.allAccountsMap.get(username);
    }

    public Account getAccount(String username, boolean active) {
        if (active) {
            return this.allAccountsMap.get(username);
        }

        return this.allAccountsMap.get(username);
    }

}
