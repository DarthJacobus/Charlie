package com.example.migrainebuddy.User;

import com.example.migrainebuddy.User.User;

public class FemaleUser extends User
{

    //Menstrual
    public static Boolean menarche;
    public static Boolean menopause;
    public static Boolean hormoneReplacementTherapy;

    //Pregnancy
    public static Boolean pregnant;
    public static Boolean contraceptivePills;





    //Constructor
    public FemaleUser(String email, String password, String firstName, String lastName, String monthBorn, String dayBorn,
                                  String yearBorn)
    {
        super(email, password, firstName, lastName, monthBorn, dayBorn, yearBorn, "Female");

    }


    //Setter methods
    public void setMenarche(Boolean menarche) {this.menarche = menarche;}
    public void setMenopause(Boolean menpause) {this.menopause = menopause;}
    public void setHormoneReplacementTherapy(Boolean hormoneReplacementTherapy) {this.hormoneReplacementTherapy = hormoneReplacementTherapy;}
    public void setPregnant(Boolean pregnant) { this.pregnant = pregnant; }
    public void setContraceptivePills(Boolean contraceptivePills) {this.contraceptivePills = contraceptivePills;}


    //Getter methods
    public Boolean getMenarche() {return menarche;}
    public Boolean getMenopause() {return menopause;}
    public Boolean getHormoneReplacementTherapy() {return hormoneReplacementTherapy;}
    public Boolean getPregnant() {return pregnant;}
    public Boolean getContraceptivePills() {return contraceptivePills;}


    //Other methods
    private void analyzeVariableConsequences()
    {

        if(menarche) {
            menopause = false;
        }

        if(menopause) {
            menarche = false;
            pregnant = false;
            contraceptivePills = false;
        }

    }





}
