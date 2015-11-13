package com.newsoft.hello;

import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class SystemStatus {

    private static Sigar sigar = new Sigar();

    public static void showMemoryUsage(){
        System.out.println("**************************************");
        System.out.println("*** Informations about the Memory: ***");
        System.out.println("**************************************\n");

        Mem mem = null;
        try {
            mem = sigar.getMem();
        } catch (SigarException se) {
            se.printStackTrace();
        }

//        System.out.println("Actual total free system memory: "
//                + mem.getActualFree() / 1024 / 1024+ " MB");
//        System.out.println("Actual total used system memory: "
//                + mem.getActualUsed() / 1024 / 1024 + " MB");
//        System.out.println("Total free system memory ......: " + mem.getFree()
//                / 1024 / 1024+ " MB");
//        System.out.println("System Random Access Memory....: " + mem.getRam()
//                + " MB");
//        System.out.println("Total system memory............: " + mem.getTotal()
//                / 1024 / 1024+ " MB");
//        System.out.println("Total used system memory.......: " + mem.getUsed()
//                / 1024 / 1024+ " MB");


        NumberFormat formatter = new DecimalFormat("#0.00");

//        System.out.println("Actual total free system memory: "
//                + formatter.format((double)mem.getActualFree() / 1024 / 1024 /1024)+ " GB");
//        System.out.println("Actual total used system memory: "
//                + formatter.format((double)mem.getActualUsed() / 1024 / 1024/1024) + " GB");
//        System.out.println("Total free system memory ......: " + formatter.format((double)mem.getFree()
//                / 1024 / 1024/1024)+ " GB");
//        System.out.println("System Random Access Memory....: " + formatter.format((double)mem.getRam()/1024)
//                + " GB");

        System.out.println("Total system memory............: " + formatter.format((double)mem.getTotal()
                / 1024 / 1024/1024)+ " GB");
        System.out.println("Total used system memory.......: " + formatter.format((double)mem.getUsed()
                / 1024 / 1024/1024)+ " GB");
        System.out.println("Percentage used................: " + formatter.format((double)mem.getUsed()/mem.getTotal()*100)+ " %");
        System.out.println("\n**************************************\n");
    }
}
