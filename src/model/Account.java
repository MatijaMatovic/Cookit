package model;

import java.util.Objects;

public class Account implements Comparable<Account> {

    public Account() {
    }

    private String username;

    private String password;

    private String email;

    private boolean active = true;

    public Account(String username) {
        this.username = username;
    }
    
    public Account(String username, String password,String email ) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

     public Account(String username, String password,String email ) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.username);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Account o) {
        return this.username.compareTo(o.username);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    

}
