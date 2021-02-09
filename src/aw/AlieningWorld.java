package aw;

import aw.generation.Generator;

public class AlieningWorld {

    // settings
    public static int amountOfElements = 25;
    public static int amountOfWParticles = 12; // can not be bigger than 36 |&| if string with chars is modified then the hard limit is 256 after that adding more will just be useless

    // code
    public static void main(String[] args) {

       System.out.println("AW is starting, please wait!");

       System.out.println("Logging everything what happens.");

       Generator.startGen();



   }

}
