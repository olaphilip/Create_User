import java.io.*;
import java.util.*;
import java.math.BigInteger; 
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;

public class Main
{
    Scanner input = new Scanner(System.in);
    Admin a = new Admin();
    Calender c = new Calender();
    Menu m = new Menu();
    CreateUser cU = new CreateUser();
    String userName;
    String pin;
    String newP;
    
    public static void main(String[] args) throws Exception{
        Main main = new Main();
        main.ReadFile();
        main.ReadUser();
        main.Run();
        main.WriteFile();
        main.WriteUser();
    }//end main
    
    public void Run(){
        System.out.println("WELCOME TO THE IDENTITY CREATOR");
        try{
                
            boolean exitRequested = false;
            while (!exitRequested) {
                System.out.println("Please Identify yourself:");
                userName = input.nextLine();
                System.out.println("PIN:");
                pin = input.nextLine();
                newP = cU.toHexString(cU.getSHA(pin));
                if (userName.equals("Philip") && pin.equals("Secret Password")){
                    m.AdminMenu();
                    int adminChoice = Integer.parseInt(input.nextLine());
                    switch (adminChoice){
                        case 1:
                            cU.Run();
                            break;
                        case 2:
                            a.run();
                            break;
                        case 3:
                            exitRequested = true;
                    }//end switch
                }//end if
                else if (pin.equals("new")){
                    m.UserMenu();
                    int userChoice = Integer.parseInt(input.nextLine());
                    switch (userChoice){
                        case 1:
                            getHuman();
                    }
                }else{
                    exitRequested = true;
                }
        }//end while
        }catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown for incorrect algorithm: " + e);
        }
    }//end run
    
    public void WriteFile(){
        try{
            FileOutputStream outFile = new FileOutputStream("identity.dat");
            ObjectOutputStream output = new ObjectOutputStream(outFile);
            System.out.println(a.getHuman().size());
            
            output.writeObject(a);
            
            outFile.close();
            output.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void WriteUser(){
        try{
            FileOutputStream oF = new FileOutputStream("users.dat");
            ObjectOutputStream out = new ObjectOutputStream(oF);
            out.writeObject(cU);
            oF.close();
            out.close();
            
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public void ReadFile(){
        try {
            FileInputStream inFile = new FileInputStream("identity.dat");
            ObjectInputStream input = new ObjectInputStream(inFile);
            a = (Admin)input.readObject();
            
        } catch (Exception e) {
            //System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void ReadUser(){
        try{
            FileInputStream iF = new FileInputStream("users.dat");
            ObjectInputStream in = new ObjectInputStream(iF);
            cU = (CreateUser)in.readObject();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    
    public void getHuman(){
        ArrayList <Person> Human = a.getHuman();
        System.out.println(Human.size());
        for (int i = 0; i < Human.size(); i++){
            System.out.println(Human.get(i).toString());
        }
    }
    
    public void getUser(){
        ArrayList<User> userlist = cU.getUser();
        for(int i = 0; i< userlist.size(); i++){
            String myusers = userlist.get(i).toString();
            System.out.println(myusers);
        }
    }
}
