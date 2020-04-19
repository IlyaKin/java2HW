package ru.geekbrains.java2.online.lessonE;

import org.w3c.dom.ls.LSOutput;

import javax.swing.plaf.TableHeaderUI;
import java.sql.Array;
import java.util.Arrays;

public class Main {

    static final int size = 10000000;
    static final int h = size/2;

    private static void CalcArr() {
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));}

       System.out.printf("Время работы метода CalcArr = %d\n", System.currentTimeMillis()-a);
    }

    private static void ArrDev (){

        float[] arrFull = new float[size];
        for (int i = 0; i < size; i++) {
            arrFull[i] = 1;
        }

        float[] arrHalf1 = new float[h];
        float[] arrHalf2 = new float[h];
        long a = System.currentTimeMillis();
        System.arraycopy(arrFull,0,arrHalf1,0, h);
        System.arraycopy(arrFull,h,arrHalf2,0, h);
        System.out.printf("Время разбивки массива = %d\n", System.currentTimeMillis()-a);


        Thread arrHalf1Thread = new Thread(new Runnable() {
            @Override
            public void run() {
                long a = System.currentTimeMillis();
                for (int i = 0; i < arrHalf1.length; i++) {
                    arrHalf1[i] = (float)(arrHalf1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2)); }
                System.out.printf("Время отработки 1го потока = %d\n", System.currentTimeMillis()-a);
                 }
        });

        Thread arrHalf2Thread = new Thread(new Runnable() {
            @Override
            public void run() {
                long a = System.currentTimeMillis();
                for (int i = 0; i < arrHalf2.length; i++) {
                    arrHalf2[i] = (float)(arrHalf2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));}
                System.out.printf("Время отработки 2го потока = %d\n", System.currentTimeMillis()-a);
            }
        });
            arrHalf1Thread.start();
            arrHalf2Thread.start();

        try {
            arrHalf1Thread.join();
            arrHalf2Thread.join();
            long b = System.currentTimeMillis();
            System.arraycopy(arrHalf1, 0, arrFull, 0, h);
            System.arraycopy(arrHalf2, 0, arrFull, h, h);
            System.out.printf("Время склейки массива = %d\n", System.currentTimeMillis()-b);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public static void main (String[] args) {
        CalcArr();
        ArrDev();
    }
}
