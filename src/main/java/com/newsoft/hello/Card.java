package com.newsoft.hello;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.*;

public class Card {

    private String id;
    private List<String> contents;
    private int statusPointer;

    private static final List<Integer> intervals = new ArrayList<>(Arrays.asList(1,1,2,3,5,7,10,20,30,90,180));

    private List<DateTime> dates;

    private Map<DateTime,String> datesMap;

    private static final Map<String,Card> cards = new HashMap<>();

    public Card(){
        dates = new ArrayList<>();
        datesMap = new HashMap<>();
        DateTime dt = new DateTime();
        for(int i = 0;i<intervals.size();++i){
            dt = dt.plusDays(intervals.get(i));
            dates.add(dt);
            datesMap.put(dt,"");
        }



    }

    public Card(String id){
        this();
        this.id = id;
        statusPointer = 0;
        cards.put(id,this);
    }

    public Card(String id,DateTime start){

        dates = new ArrayList<>();
        datesMap = new HashMap<>();
        DateTime dt = start;
        for(int i = 0;i<intervals.size();++i){
            dt = dt.plusDays(intervals.get(i));
            dates.add(dt);
            datesMap.put(dt,"");
        }

        this.id = id;
        cards.put(id,this);
    }

    public String toString(){
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy_MM_dd");
        DateTime dt = new DateTime();
        return dt.toString(fmt) +": "+ intervals;
    }

    public List<DateTime> getDates(){
        return dates;
    }

    public Map<DateTime,String> getDatesMap(){
        return datesMap;
    }

    public void printSchedule1(){
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy_MM_dd");
        DateTime dt = new DateTime();

        System.out.println("**************************************");
        System.out.println("*** My Schedule: ***");
        System.out.println("**************************************\n");
        for(int i = statusPointer;i<intervals.size();++i){
            dt = dt.plusDays(intervals.get(i));
            System.out.println(dt.toString(fmt));
        }
        System.out.println();
    }

    public void printSchedule2(){
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy_MM_dd");
        DateTime dt = new DateTime();

        System.out.println("**************************************");
        System.out.println("*** My Schedule: ***");
        System.out.println("**************************************\n");


        for(int i = statusPointer;i<intervals.size();++i){
            dt = dt.plusDays(intervals.get(i));
            System.out.println(dt.toString(fmt));
        }


        System.out.println();
    }

    public static Map<String,Card> getAllCards(){
        return cards;
    }

    public static void printSchedule(DateTime start, DateTime end){
//        DateTime dt = start;
//        while (dt.isBefore(end)){
//
//        }


        for (Map.Entry<String, Card> entry : cards.entrySet()) {
            System.out.println(entry.getKey());

            List<DateTime> dates = entry.getValue().getDates();
            for (DateTime date:dates){
                System.out.println("****************************");
                System.out.println(date);
            }


        }

    }



}
