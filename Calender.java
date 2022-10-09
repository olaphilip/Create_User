import java.util.*;
import java.io.*;

public class Calender implements Serializable{
    public static void cal(){
        //present day
        Calendar c = Calendar.getInstance();
        System.out.println("The Current Date is: " + c.getTime());
    }
    
    //birthday
    public static void DOB(){
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(1900, 2010);
        gc.set(gc.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        System.out.println(gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH));
    }
    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
}