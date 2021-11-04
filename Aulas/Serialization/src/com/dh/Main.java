package com.dh;

import com.dh.model.Dog;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        FileOutputStream fileOut;
        FileInputStream fileIn;

        List<Dog> dogsRead;
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Jonas", 5));
        dogs.add(new Dog("Ednaldo", 10));
        dogs.add(new Dog("Rex", 1));
        dogs.add(new Dog("Lea", 2));

        try {
            fileOut = new FileOutputStream("dogs-list.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(dogs);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            fileIn = new FileInputStream("dogs-list.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            dogsRead = (ArrayList) in.readObject();
            for(Dog dog : dogsRead) {
                System.out.println(dog.toString());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
