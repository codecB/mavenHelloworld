package com.newsoft.hello;

import org.joda.time.DateTime;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        DateTime dt = new DateTime();
        int year = dt.getYear();

        System.out.println( "Hello World from "+year);
    }
}
