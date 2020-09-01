package model;

import java.util.Set;


public class Sponsor extends AccountOwner {

    public Sponsor() {
    }

    public String companyName;

    public String address;

    public String telephone;

    public Set<Advertisement> ads;

}