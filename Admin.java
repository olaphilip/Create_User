import java.util.Random;
import java.util.*;
import java.io.*;

public class Admin implements Serializable{
    
    String fName;
    int creditSc;
    int accountNum;
    String SSN;
    int phoneNum;
    ArrayList <Person> Human;
    
    public Admin(){
        Human = new ArrayList <Person>();
    }//constructor
    
    
    public void run(){
        String[] firstName = new String[] {"Ade", "Tunde", "Bobby", "Stephen", "Charles", "Christy", "David", "Ethan", "Fin", "Fiona", "Georgina", "George", "Helen", "James", "Judy", "Liam", "Lory", "Mike", "Mary", "Nelson", "Noah", "Peter", "Princess", "Roseline", "Rona", "Talia", "Eunice", "Ibrahim", "Usman",};
        String[] lastName = new String[] {"Charles", "Stephens", "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Anderson", "Wilson", "Taylor", "Moore", "Jackson"};
        Random r = new Random();
        int fRand = r.nextInt(firstName.length);
        int lRand = r.nextInt(lastName.length);
        String fName = firstName[fRand];
        String lName = lastName[lRand];
        
        //Adress
        String[] addName = new String[] {"Stanhope", "George Bush", "Meditation", "Silver Canoe", "Gentle Rain", "Loch Ness", "Melody"};
        int addRand = r.nextInt(addName.length);
        String str = addName[addRand];
        int houseNum = randBetween(1111, 9999);
        String[] type = new String[] {"St", "Way", "Drive", "Road", "Lane", "Blvd"};
        int typeRand = r.nextInt(type.length);
        String strType = type[typeRand];
        String addy = houseNum + " " + str + strType;
        
        //credit Score
        creditSc = randBetween(620, 850);
        
        //bank
        String[] Bank = new String[] {"PNC Bank", "JP Morgan Chase", "Fifth Third", "Bank of America", "Wells Fargo", "Citi Bank", "Capital One", "IMCU"};
        int bankRand = r.nextInt(Bank.length);
        String bankName = Bank[bankRand];
        accountNum = randBetween(123456789, 999999999);
        
        //social sec
        int ssn1 = randBetween(000, 999);
        int ssn2 = randBetween(00, 99);
        int ssn3 = randBetween(0000, 9999);
        SSN = ssn1 + "-" + ssn2 + "-" + ssn3;
        
        //Phone Number
        int areaCode;
        
        //creator
        create(fName, lName, addy, creditSc, bankName, accountNum, SSN);
        
    }
    
    
    public int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
    
    public void create(String fName, String lName, String addy, int creditSc, String bankName, int accountNum, String SSN){
        Person p = new Person(fName, lName, addy, creditSc, bankName, accountNum, SSN);
        
        Human.add(p);
 
        System.out.println(Human);
    }
    
    public ArrayList <Person> getHuman(){
        return Human;
    }
}