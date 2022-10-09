import java.util.*;
import java.io.*;

public class User implements Serializable{
    String userName;
    String password;
    
    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
    
    
}