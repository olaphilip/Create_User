import java.util.*;
import java.io.*;

public class Person implements Serializable{
    protected String Fname;
    protected String Lname;
    protected String Addy;
    protected int CredScore;
    protected String BankName;
    protected int AccountNum;
    protected String SSN;
    
    public Person(String Fname, String Lname, String Addy, int CredScore, String BankName, int AccountNum, String SSN){
        this.Fname = Fname;
        this.Lname = Lname;
        this.Addy = Addy;
        this.CredScore = CredScore;
        this.BankName = BankName;
        this.AccountNum = AccountNum;
        this.SSN = SSN;
    }//default constructor
    
    public String toString(){
        return "Name: " + this.Lname + ", " + this.Fname + "\nAddress: " + this.Addy + "\nCredit Score: " + this.CredScore + "\nBank Name: " + this.BankName + "\nAccount Number: " + this.AccountNum + "\nSSN: " + this.SSN;
    }
    
}