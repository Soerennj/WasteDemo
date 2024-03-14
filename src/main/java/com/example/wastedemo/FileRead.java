package com.example.wastedemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class FileRead extends TrashEntry{

    static int activeInfo = 0;
    static int trashID = 0;
    static String time = "";
    static double weight = 0.0;


    public static ArrayList<TrashEntry> alSonderborg = new ArrayList<>();
    public static ArrayList<TrashEntry> alRodekro = new ArrayList<>();
    public static ArrayList<TrashEntry> alKliplev = new ArrayList<>();

    public static void main(String[] args) {

        try {

            File file = new File("./demo.txt");
            Scanner out = new Scanner(file);

            while (out.hasNextLine()) {
                String nextline = out.nextLine();

                determineData(nextline);

                if (hasNumbers(nextline)) {
                    switch (activeInfo) {
                        case 1:
                            alSonderborg.add(new TrashEntry("Sønderborg", trashID, time, weight));
                            break;
                        case 2:
                            alKliplev.add(new TrashEntry("Kliplev", trashID, time, weight));
                            break;
                        case 3:
                            alRodekro.add(new TrashEntry("Rødekro", trashID, time, weight));
                            break;
                    }
                }

            }

            for (TrashEntry o : alSonderborg
                 ) {
                System.out.println(o.time);
            }
            out.close();

        } catch (
                FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void determineData(String info) {
        if (info.toLowerCase().contains("sønderborg")) {
            activeInfo = 1;
            return;
        }
        else if (info.toLowerCase().contains("kliplev")) {
            activeInfo = 2;
            return;
        }
        else if (info.toLowerCase().contains("rødekro")) {
            activeInfo = 3;
            return;
        }

        if (info.toLowerCase().contains("trashid:"))
        {
            trashID = Integer.parseInt(info.substring(8));
            return;
        }

        if (info.toLowerCase().contains("weight"))
            return;

        String[] strArr = info.split(",");
        weight = Double.parseDouble(strArr[0]);
        time = strArr[1];


    }

    private static boolean hasNumbers(String line) {
        return line.matches(".*\\d.*");
    }

    static public ArrayList getSonderborg()
    {
        getStats();
        for (TrashEntry o: alSonderborg
             ) {
            System.out.println(o.getTime() + "  :   " + o.getWeight());
        }
        return alSonderborg;
    }
    static public ArrayList getKliplev()
    {
        return alKliplev;
    }
    static public ArrayList getRodekro()
    {
        return alRodekro;
    }
    static public void getStats()
    {
        try {

            File file = new File("./demo.txt");
            Scanner out = new Scanner(file);

            while (out.hasNextLine()) {
                String nextline = out.nextLine();

                determineData(nextline);

                if (hasNumbers(nextline)) {
                    switch (activeInfo) {
                        case 1:
                            alSonderborg.add(new TrashEntry("Sønderborg", trashID, time, weight));
                            break;
                        case 2:
                            alKliplev.add(new TrashEntry("Kliplev", trashID, time, weight));
                            break;
                        case 3:
                            alRodekro.add(new TrashEntry("Rødekro", trashID, time, weight));
                            break;
                    }
                }

            }

            for (TrashEntry o: alSonderborg
            ) {
                System.out.println("Test: " + o.getTime() + ": " + o.getWeight());
            }
            out.close();

        } catch (
                FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
