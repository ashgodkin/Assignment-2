import java.io.File;
import java.util.Scanner;
import java.util.*;

public class Reader{
	public static void main(String args[]){
        File usersFile = new File("moviedata_small/users5.dat");
        Scanner inUsers = new Scanner(usersFile);
          //each field is separated(delimited) by a '|'
        String delims = "[|]";
        while (!inUsers.isEmpty()) {
            // get user and rating from data source
            String userDetails = inUsers.readLine();

            // parse user details string
            String[] userTokens = userDetails.split(delims);

            // output user data to console.
            if (userTokens.length == 7) {
                System.out.println("UserID: "+userTokens[0]+",First Name:"+
                        userTokens[1]+",Surname:" + userTokens[2]+",Age:"+
                        Integer.parseInt(userTokens[3])+",Gender:"+userTokens[4]+",Occupation:"+
                        userTokens[5]);

            }
            else
            {
                throw new Exception("Invalid member length: "+userTokens.length);
            }
	}
	}
	
	public void isEmpty(){
		if(users == null);
	}
	
	public void readLine(){
	}
}
