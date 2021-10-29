package com.example.demo7;

import java.util.Set;

public class Bruger
{
    String name;
    String password;

    Set<String> brugerHuskeliste;

    public Bruger(String name, String password)
    {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Set<String> getBrugerHuskeliste() {
        return brugerHuskeliste;
    }

    public void setBrugerHuskeliste(Set<String> brugerHuskeliste) {
        this.brugerHuskeliste = brugerHuskeliste;
    }
}
