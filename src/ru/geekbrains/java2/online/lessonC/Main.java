package ru.geekbrains.java2.online.lessonC;

import com.sun.source.tree.NewArrayTree;

import javax.sound.midi.Soundbank;
import javax.swing.plaf.synth.SynthUI;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main (String[] args){
        String[] arr = {"Из-за", "леса", "леса", "темного", "подымалась", "красна", "зорюшка", "рассыпала", "ясной", "радугой", "огоньки","лучи", "багровые", "загорались", "ярким", "пламенем", "сосны", "старые", "могучие", "наряжали", "сетки", "хвойные", "покрывала", "златотканые"};
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.addAll(Arrays.asList(arr));
        System.out.println(set);

        calcWords(arr);

        Person p1 = new Person("Kin", "54648787", "sdfds@fds.ru");
        Person p2 = new Person("Avdienko","4568643","dsfd@dsda.ru");
        Person p3 = new Person("Firsova","4683753","sfd@fdsf.ru");
        Person p4 = new Person("Abramov", "89645314", "fdhfj@sdfg.ru");
        Person p5 = new Person("Serov", "864745634", "fdsfgaq@sdsqwef.ru");

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addPhone(p1);
        phoneBook.addEmail(p1);
        phoneBook.addPhone(p2);
        phoneBook.addEmail(p2);
        phoneBook.addPhone(p3);
        phoneBook.addEmail(p3);
        phoneBook.addPhone(p4);
        phoneBook.addEmail(p4);
        phoneBook.addPhone(p5);
        phoneBook.addEmail(p5);
        //System.out.println(phoneBook.getMapEmail());
        // System.out.println(phoneBook.getMapPhone());


        Scanner a = new Scanner(System.in);
        System.out.println("Введите фамилию латиницей");
        String inputData = a.nextLine();
        phoneBook.findNumber(inputData);
        phoneBook.findEmail(inputData);

    }
    private static void calcWords(String[] arr) {
        LinkedHashMap<String, Integer> map= new LinkedHashMap<>();
        for (String word : arr) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        System.out.println(map);
    }

}

