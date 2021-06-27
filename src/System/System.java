/**
 * Ohad Shalom 204525505
 * Yana Chichkin 321271033
 */
package System;

import Animals.*;
import Mobility.Point;
import Olympics.Medal;
import Olympics.Medaltype;

import java.util.InputMismatchException;
import java.util.Scanner;

public class System {
    /**
     * checks for valid input and handles InputMismatch exception
     * @param sc1 scanner class
     * @return int from user
     */
    public static int intInput(Scanner sc1) {
        int anint = 0;
        boolean flag = true;
        while (flag) {
            try {
                anint = sc1.nextInt();
                flag = false;
            } catch (InputMismatchException e1) {
                sc1.nextLine();
                java.lang.System.out.println("wrong input,need an integer\nTry again");
            }
        }
        return anint;
    }
        public static double doubleInput(Scanner sc1){
            double adouble = 0;
            boolean flag = true;
            while (flag) {
                try {
                    adouble = sc1.nextDouble();
                    flag = false;
                } catch (InputMismatchException e1) {
                    sc1.nextLine();
                    java.lang.System.out.println("wrong input,need an integer\nTry again");
                }
            }
            return adouble;
        }
            /**
             * prints each animal toString method
             * @param animals animal list
             */
    public static void animalsTostring(Animal[] animals){
        java.lang.System.out.println("Printing animals info");
        for(Animal animal:animals)
            java.lang.System.out.println(animal.toString());
    }

    /**
     * for each animal in animals activates make_sound method
     * @param animals animal list
     */
    public static void animalsSpeak(Animal[] animals){
        java.lang.System.out.println("Animals Speak:");
        for(Animal animal:animals)
            animal.makeSound();
    }

    /**
     * recives input for the common fields of each animal
     * @param name animal name
     * @param doubles list of 2 doubles ,index 0 weight,index 1 speed
     * @param gt pointer to animal gender type
     * @param p1 pointer to a point
     */
    public static void animalInput(String[] name, double[] doubles, genderType[] gt, Point[] p1){
        Scanner sc1= new Scanner(java.lang.System.in);
        int temp,x,y;
        java.lang.System.out.println("Enter animal name");
        name[0]=sc1.nextLine();
        java.lang.System.out.println("Enter animal weight");
        doubles[0]=doubleInput(sc1);
        java.lang.System.out.println("Enter animal speed");
        doubles[1]=doubleInput(sc1);
        java.lang.System.out.println("Enter animal gender(Male-0,Female-1,Hermaphrodite-2)");
        switch (intInput(sc1)){
            case 0:
                gt[0]=genderType.Male;
                break;
            case 1:
                gt[0]=genderType.Female;
                break;
            case 3:
                gt[0]=genderType.Hermaphrodite;
        }
        java.lang.System.out.println("Enter animal location:(enter -1 for default location)");
        if(intInput(sc1)==-1){
            p1[0]=null;
        }
        else {
            java.lang.System.out.println("Enter x");
            x=intInput(sc1);
            java.lang.System.out.println("Enter y");
            y=intInput(sc1);
            p1[0]=new Point(x,y);
        }
    }

    /**
     * prints main menu
     */
    public static void printMenu(){
        java.lang.System.out.println("1.Print toString\n2.Animals speak\n3.Quit");
    }

    /**
     * initiate a new animal list
     * @return full animal list
     */
    public static Animal[] initAnimals(){
        Animal[] animals;
        String[] name=new String[2];
        double[] doubles=new double[2];
        genderType[] gt=new genderType[1];
        Point[] p1=new Point[1];
        Medal[] medals=new Medal[0];
        Scanner sc1=new Scanner(java.lang.System.in);
        int arrsize;
        double extra1,extra2;
        int extra3,extra4,extra5;
        boolean b1;
        java.lang.System.out.println("Enter how much animals to add");
        arrsize=intInput(sc1);
        animals=new Animal[arrsize];
        for(int i=0;i<animals.length;i++){
            animalInput(name,doubles,gt,p1);
            medals=initMedals();
            java.lang.System.out.println("Enter animal type(Air-0,Water-1,Terrestrial-2)");
            switch (intInput(sc1)){
                case 0://Air Animal
                    java.lang.System.out.println("Enter wingspan");
                    extra1=doubleInput(sc1);
                    java.lang.System.out.println("Enter animal number(Pigeon-0,Eagle-1)");
                    switch (intInput(sc1)){
                        case 0:
                            java.lang.System.out.println("Enter pigeon family");
                            sc1.nextLine();
                            name[1]=sc1.nextLine();
                           // animals[i]=new Pigeon(name[0],gt[0],doubles[0],doubles[1],medals,p1[0],extra1,name[1]);
                            break;
                        case 1:
                            java.lang.System.out.println("Enter altitude");
                            extra2=doubleInput(sc1);
                           // animals[i]=new Eagle(name[0],gt[0],doubles[0],doubles[1],medals,p1[0],extra1,extra2);
                            break;
                    }
                    break;
                case 1://Water Animal
                    java.lang.System.out.println("Enter dive depth");
                    extra3=intInput(sc1);
                    java.lang.System.out.println("Enter animal number(Alligator-0,Dolphin-1,Whale-2)");
                    switch (intInput(sc1)){
                        case 0:
                            java.lang.System.out.println("Enter area of living");
                            sc1.nextLine();
                            name[1]=sc1.nextLine();
                            java.lang.System.out.println("Enter number of legs");
                            extra5=intInput(sc1);
                           // animals[i]=new Alligator(name[0],gt[0],doubles[0],doubles[1],medals,p1[0],extra3,name[1],extra5);
                            break;
                        case 1:
                            java.lang.System.out.println("Enter area of water type(sea-1,sweet-else)");
                            extra4=intInput(sc1);
                            //animals[i]=new Dolphin(name[0],gt[0],doubles[0],doubles[1],medals,p1[0],extra3,extra4);
                            break;
                        case 2:
                            java.lang.System.out.println("Enter food type");
                            sc1.nextLine();
                            name[1]=sc1.nextLine();
                            //animals[i]=new Whale(name[0],gt[0],doubles[0],doubles[1],medals,p1[0],extra3,name[1]);
                            break;

                    }
                    break;
                case 2://Terrestrial Animal
                    java.lang.System.out.println("Enter number of legs");
                    extra3=intInput(sc1);
                    java.lang.System.out.println("Enter animal number(Cat-0,Dog-1,Snake-2)");
                    switch (intInput(sc1)){
                        case 0:
                            java.lang.System.out.println("Cat castrated?(1-yes)");
                            if(intInput(sc1)==1)
                                b1=true;
                            else b1=false;
                            //animals[i]=new Cat(name[0],gt[0],doubles[0],doubles[1],medals,p1[0],extra3,b1);
                            break;
                        case 1:
                            java.lang.System.out.println("Enter dog breed");
                            sc1.nextLine();
                            name[1]=sc1.nextLine();
                           // animals[i]=new Dog(name[0],gt[0],doubles[0],doubles[1],medals,p1[0],extra3,name[1]);
                            break;
                        case 2:
                            java.lang.System.out.println("Enter snake length");
                            extra2=doubleInput(sc1);
                            java.lang.System.out.println("Enter the snake poisonous level(0-LOW,1-MEDIUM,2-HIGH");
                            int temp=intInput(sc1);
                            switch (temp){
                                case 0:
                                    //animals[i]=new Snake(name[0],gt[0],doubles[0],doubles[1],medals,p1[0],PoisonousLevel.LOW,extra2);
                                    break;
                                case 1:
                                   // animals[i]=new Snake(name[0],gt[0],doubles[0],doubles[1],medals,p1[0],PoisonousLevel.MEDIUM,extra2);
                                    break;
                                case 2:
                                   // animals[i]=new Snake(name[0],gt[0],doubles[0],doubles[1],medals,p1[0],PoisonousLevel.HIGH,extra2);
                                    break;
                                default:
                                  //  animals[i]=new Snake(name[0],gt[0],doubles[0],doubles[1],medals,p1[0],PoisonousLevel.LOW,extra2);
                            }

                    }
            }
        }
        return animals;
    }

    /**
     * initiates medal list
     * @return full medal list
     */
    public static Medal[] initMedals(){
        Medaltype tempMT;
        String tempS;
        Scanner sc1=new Scanner(java.lang.System.in);
        int medalsnum=0;
        java.lang.System.out.println("Enter how much medals");
        medalsnum=intInput(sc1);
        Medal[] medals=new Medal[medalsnum];
        for(int i=0;i<medalsnum;i++)
        {
            java.lang.System.out.println("Medal number "+ i +"\nFor default medal enter 1");
            if(intInput(sc1)==1){
                medals[i]=new Medal();
                continue;
            }
            java.lang.System.out.println("Enter medal type(0-Gold,1-Silver,2-Bronze");
            switch (intInput(sc1)) {
                case 0:
                    tempMT = Medaltype.gold;
                    break;
                case 1:
                    tempMT = Medaltype.silver;
                    break;
                default:
                    tempMT=Medaltype.bronze;
                    break;
            }
            java.lang.System.out.println("Enter medal tournament");
            sc1.nextLine();
            tempS=sc1.nextLine();
            java.lang.System.out.println("Enter year");
            medals[i]=new Medal(tempMT,tempS,intInput(sc1));
        }
        return medals;
    }

    /**
     * main
     * @param args args
     */
    public static void main1(String[] args) {
        Scanner sc1=new Scanner(java.lang.System.in);
        int flag;

        Animal[] animals = initAnimals();
        do {
            printMenu();
            flag=intInput(sc1);
            switch (flag){
                case 1:
                    animalsTostring(animals);
                    break;
                case 2:
                    animalsSpeak(animals);
                    break;
                case 3:
                    break;
                default:
                    java.lang.System.out.println("Wrong input try again");
            }

        }while(flag!=3);
    }
}
