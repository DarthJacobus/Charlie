package com.example.migrainebuddy.Migraine;

import com.example.migrainebuddy.Migraine.Migraine;
import com.example.migrainebuddy.User.User;

import java.util.ArrayList;

public class MigraineTypeAlgorithm
{

    //Needed from user
    User user;
    ArrayList<Migraine> migraineInstanceList;
    Migraine migraineInstance;

    //Migraine types
    int menstrualMigraine, auraMigraine, nonAuraMigraine, chronicMigraine, hemiplegicMigraine, abdominalMigraine, brainstemAuraMigraine;


    public MigraineTypeAlgorithm(User user, ArrayList<Migraine> migraineInstanceList)
    {
        this.user = user;
        this.migraineInstanceList = migraineInstanceList;
    }


    public void evalMensturalMigraine()
    {
        if(user.getGender().equals("Female")) { menstrualMigraine++; }
        if(migraineInstance.menstruationPeriod) { menstrualMigraine++; }
        if(migraineInstance.hormoneTherapyMeds) { menstrualMigraine++;}
        if(migraineInstance.contraceptiveMeds) { menstrualMigraine++;}
        if(migraineInstance.lessUrination) { menstrualMigraine++; }
        if(migraineInstance.lessConstipration) { menstrualMigraine++; }


    }




























}
