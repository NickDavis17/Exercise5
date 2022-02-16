package com.company;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class AddressBook {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {


        HashMap<String, String> map = new HashMap<>() {
            @Override
            public String toString() {
                StringBuilder stb = new StringBuilder();
                for (HashMap.Entry<String, String> entry : this.entrySet()) {
                    stb.append(entry.getKey()).append(" ")
                            .append(entry.getValue()).append("\n");
                }
                return stb.toString();
            }
        };
        System.out.println("Please Select and option:");
        System.out.println("1: Add person to directory");
        System.out.println("2: Search for a person's email");
        System.out.println("3: End");
        int choice = input.nextInt();
        //input.nextLine();
        while (choice != 3) {
            if (choice == 1) {
                collectingInputs(map);

            }

            if (choice == 2) {
                display(map);
                input.nextLine();
                System.out.println("Please enter a name");
                String searchName = input.nextLine();
                if (map.containsKey(searchName)) {
                    System.out.println(map.get(searchName));
                } else {
                    System.out.println("Sorry, that person does not exist");
                }
            }
            System.out.println("Please Select and option:");
            System.out.println("1: Add person to directory");
            System.out.println("2: Search for a person's email");
            System.out.println("3: End");

            choice = input.nextInt();

        }
        display(map);

    }

    static HashMap<String, String> collectingInputs(HashMap<String, String> map) {
        int num = 1;
        System.out.println("What is the name of your person");
        input.nextLine();
        String name = input.nextLine();
        System.out.println("What is their email address?");
        String email = input.nextLine();
        Person aPerson = new Person(name, email);
        map.put(name, email);
        /*while(!(name.equalsIgnoreCase("End"))){

            System.out.println("What name does your person have");
            name = input.nextLine();
            if(name.equalsIgnoreCase("End")){
                System.out.println(map);
                System.exit(0);
            }
            System.out.println("What is their email address?");
            email = input.nextLine();

            Person newPerson = new Person(name, email);*/
        num += 1;
        map.put(name, email);
        System.out.println("Your person has been created. " + aPerson);
        return map;
    }

    static void display(HashMap<String, String> map) {
        System.out.println(map);
    }
}