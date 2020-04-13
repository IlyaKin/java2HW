package ru.geekbrains.java2.online.lessonC;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class PhoneBook {
    public  static HashMap<String, String> mapEmail = new LinkedHashMap<>();
    public  static  HashMap<String, String> mapPhone = new LinkedHashMap<>();

    PhoneBook() {

    }
    public static void addPhone(Person person){
        mapPhone.put(person.Surname,person.getPhone());


    }
    public static void addEmail(Person person){
        mapEmail.put(person.Surname, person.getEmail());
    }

    public static void findNumber (String surname) {
        for (Object key : mapPhone.keySet()) {
            if (surname == key) {
                System.out.println(key + "=" + mapPhone.get(key));

            }
        }}
    public static void findEmail (String surname){
        for (Object key: mapEmail.keySet()) {
            if (surname == key)
                System.out.println(key + "=" + mapEmail.get(key));
        }
    }

    public static HashMap<String, String> getMapEmail() {
        return mapEmail;
    }

    public static HashMap<String, String> getMapPhone() {
        return mapPhone;
    }

}

