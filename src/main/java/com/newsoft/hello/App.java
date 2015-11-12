package com.newsoft.hello;

import org.joda.time.DateTime;
import java.lang.reflect.Field;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        DateTime dt = new DateTime();
        int year = dt.getYear();
        System.out.println( "Hello from "+year);

        SystemStatus.showMemoryUsage();
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
