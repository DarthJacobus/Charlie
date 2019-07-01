package com.example.migrainebuddy.User;

import com.example.migrainebuddy.Migraine.Migraine;
import java.util.ArrayList;

public class User
{
    public static String email, password, firstName, lastName, monthBorn, dayBorn, yearBorn, gender;
    public static String dateOfBirth;
    public static ArrayList<Migraine> migraineInstanceList;

    public User(String email, String password, String firstName, String lastName, String monthBorn, String dayBorn, String yearBorn, String gender)
    {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.monthBorn = monthBorn;
        this.dayBorn = dayBorn;
        this.yearBorn = yearBorn;
        this.gender = gender;

        dateOfBirth = this.monthBorn + "/" + this.dayBorn + "/" + this.yearBorn;

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

    public String getMonthBorn() { return monthBorn; }
    public void setMonthBorn(String monthBorn) { this.monthBorn = monthBorn; }

    public String getDayBorn() { return dayBorn; }
    public void setDayBorn(String dayBorn) { this.dayBorn = dayBorn; }

    public String getYearBorn() { return yearBorn; }
    public void setYearBorn(String yearBorn) { this.yearBorn = yearBorn; }

    public String getDateOfBirth() { return dateOfBirth; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }


    //Method: Add instance to Migraine list
    public void addToMigraineInstanceList(Migraine migraineInstance)
    {
        migraineInstanceList.add(migraineInstance);
    }


    //Method: Get Migraine list
    public ArrayList<Migraine> getMigraineInstanceList()
    {
        return migraineInstanceList;
    }









}
