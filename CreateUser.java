import java.util.*;
import java.io.*;
import java.math.BigInteger; 
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;

public class CreateUser implements Serializable{
    Scanner input = new Scanner(System.in);
    ArrayList <User> userlist;
    String userName;
    String password;
    String hashedPass;
    //private static final long serialVersionUID
    
    public CreateUser(){
        userlist = new ArrayList<User>();
    }//constructor
    
    public ArrayList<User> getUser(){
        return userlist;
    }
    
    public void Run(){
        try{
            System.out.println("Enter Username:");
            userName = input.nextLine();
            System.out.println("Please enter your Password");
            password = input.nextLine();
            hashedPass = toHexString(getSHA(password));
            System.out.println(hashedPass);
        }
        //to specify wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown for incorrect algorithm: " + e);
        }
        
        userCreate(userName, hashedPass);
    }
    
    public void userCreate(String userName, String hashedPass){
        User u = new User(userName, hashedPass);
        
        userlist.add(u);
    }
    
// Java program to calculate SHA hash value 
  
    public static byte[] getSHA(String input) throws NoSuchAlgorithmException
    { 
        //Static getInstance method is called with hashing SHA 
        MessageDigest md = MessageDigest.getInstance("SHA-256"); 
  
        // digest() method called 
        // to calculate message digest of an input 
        // and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8)); 
    }
    
    public static String toHexString(byte[] hash)
    {
        // Convert byte array into signum representation 
        BigInteger number = new BigInteger(1, hash); 
  
        // Convert message digest into hex value 
        StringBuilder hexString = new StringBuilder(number.toString(16)); 
  
        // Pad with leading zeros
        while (hexString.length() < 32) 
        { 
            hexString.insert(0, '0'); 
        } 
  
        return hexString.toString(); 
    }
}