package com.dh;

import com.dh.model.Contact;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        FileOutputStream fileOut;
        FileInputStream fileIn;

        List<Contact> contacts = new ArrayList<>();
        Collections.addAll(contacts,
                new Contact("Matheus", "matheus@gmail.com", "51987654321"),
                new Contact("Jonas", "jonas@imaginarium.com", "51999998888"),
                new Contact("Kekw", "kekw@hotmales.com", "21915847623"));

        try {
            fileOut = new FileOutputStream("contacts");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(contacts);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            fileIn = new FileInputStream("contacts");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            List<Contact> data = (ArrayList<Contact>) in.readObject();
            for (Contact contact : data) {
                System.out.println("Nome: " + contact.getName());
                System.out.println("E-mail: " + contact.getEmail());
                System.out.println("Telefone: " + contact.getPhoneNumber());
                System.out.println("---------------------------------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
