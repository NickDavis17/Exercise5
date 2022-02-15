package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class AddressBook {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {


        HashMap<Integer, Person> map = new HashMap<>(){
            @Override
            public String toString() {
                StringBuilder stb = new StringBuilder();
                for (HashMap.Entry<Integer, Person> entry : this.entrySet()) {
                    stb.append(entry.getKey()).append(" ")
                            .append(entry.getValue()).append("\n");
                }
                return stb.toString();
            }
        };

        collectingInputs(map);
        
        display(map);

    }
    static void collectingInputs(HashMap<Integer, Person> map){
        int num = 1;
        System.out.println("What is the name of your person");
        String name = input.nextLine();
        System.out.println("What is their email address?");
        String email = input.nextLine();
        Person aPerson = new Person(name, email);
        map.put(num,aPerson);
        while(!(name.equalsIgnoreCase("End"))){

            System.out.println("What name does your person have");
            name = input.nextLine();
            if(name.equalsIgnoreCase("End")){
                System.out.println(map);
                System.exit(0);
            }
            System.out.println("What is their email address?");
            email = input.nextLine();

            Person newPerson = new Person(name, email);
            num += 1;
            map.put(num, newPerson);

        }

    }
    static void display(HashMap<Integer, Person> map){
        System.out.println(map);
    }
}