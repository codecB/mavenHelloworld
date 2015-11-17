package com.newsoft.hello;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
//        DateTime dt = new DateTime();
//        int year = dt.getYear();
//        System.out.println( "Hello from "+year);
//
//        SystemStatus.showMemoryUsage();

        Card c1 = new Card("p1",new DateTime(2015,12,31, 0, 0));
        Card c2 = new Card("p2");

        Card.printSchedule(new DateTime(2015,11,1, 0, 0),new DateTime(2015,12,31, 0, 0));


//        Map<String,Card> cardMap = Card.getAllCards();
//
//        for (Map.Entry<String, Card> entry : cardMap.entrySet()) {
//            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//        }




//        List<DateTime> dates = c1.getDates();
//        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy_MM_dd");
//        Iterator<DateTime> it = dates.iterator();
//        while (it.hasNext()){
//            DateTime dt = it.next();
//            System.out.println(dt.toString(fmt));
//        }


//        DateTime dt1 = new DateTime();
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        DateTime dt2 = new DateTime();
//
//        System.out.println(dt1.withTimeAtStartOfDay().equals(dt2.withTimeAtStartOfDay()));


//        c1.printSchedule();

    }

    /**
     * Sets JVM argument java.library.path to use the dll.
     * Not a clean solution but it works.
     */
    private static void setLibraryPath(){
        System.setProperty( "java.library.path",  System.getProperty("user.dir") + "\\lib" );
        Field fieldSysPath = null;
        try {
            fieldSysPath = ClassLoader.class.getDeclaredField( "sys_paths" );
            fieldSysPath.setAccessible( true );
            fieldSysPath.set( null, null );
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
