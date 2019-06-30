package com.example.migrainebuddy.Migraine;


public class Migraine
{

    //Identifier
    public static String date;


    //Migraine
    String duration, timeOfDay;
    String headLocation;
    int migraineType;

    //Food, Drinks and Medicinal consumption
    String calories;
    Boolean medication, sleepingMeds, hormoneTherapyMeds, contraceptiveMeds, birthControlMeds;
    Boolean plentyOfWater, alcoholConsumption, waterAfterPhyAct, dehydration, caffeineBeverage;

    //Activity and Sleep
    int hoursOfSleep, qualityOfSleep;
    int hoursOfPhyAct;
    int sweatALot;



    //Emotions: Stress, Family, Friends
    Boolean depression, anxiety, excitment, shock, sad;
    Boolean breakUp, fight;
    int depressionLevel, anxietyLevel, excitmentLevel, shockLevel, sadnessLevel;


    //Stimuli: Lights, sounds, smell
    Boolean flickeringLight, brightLight, sunlight;
    Boolean strongSmell, stuffyAir, pollutedAir, hotTemperature, coldTemperature;
    Boolean firstHandSmoking, secondHandSmoking;
    Boolean loudNoise;



    //Body
    Boolean menstruationPeriod;
    int headPainLevel;
    Boolean lessUrination;
    Boolean lessConstipration;




    public Migraine(String date)
    {
        this.date = date;

    }

















}
