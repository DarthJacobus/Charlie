package com.example.migrainebuddy.User;

import com.example.migrainebuddy.Migraine.Migraine;

import java.util.ArrayList;

public class User
{
    public static String email, password, firstName, lastName;
    public static int gender;
    public static ArrayList<Migraine> migraineInstanceList;

    public User(String email, String password, String firstName, String lastName, int gender)
    {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        migraineInstanceList = new ArrayList<>();
    }

    //Getter and setter methods
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public int getGender() { return gender; }
    public void setGender(int gender) { this.gender = gender; }


    //Add instance to Migraine list
    public void addToMigraineInstanceList(Migraine migraineInstance)
    {
        migraineInstanceList.add(migraineInstance);
    }

    //Get Migraine list
    public ArrayList<Migraine> getMigraineInstanceList()
    {
        return migraineInstanceList;
    }






}
