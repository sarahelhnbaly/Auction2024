import java.util.*;
import java.io.*;
public class Driver extends Thread
{
   private static Vector<Person> winner;
    private static Scanner in = new Scanner(System.in);
   public static void main(String[] args)
   {
       int more =1;
       
       while(more == 1)
       {
           winner = new Vector<>();
           Users user = new Users();
        
          
           System.out.println("Enter number of users to bid");
           int n = in.nextInt();
           user.registerUsers(n);
         
            
           
            System.out.println("Lets start the bidding\n");
            System.out.println("----------------------------------------------------------\n");
            BidItem item = new BidItem();
            item.registerItem();
           
           Vector<Double>processAmount = new Vector<>();
            while(true)
            {
                System.out.println("\nSelect a user to bid: ");
                int userid = in.nextInt();
                List<Person> userList = Users.getUserList();
                Person biduser = getUserId(userList,userid);
                
                if(biduser != null)
                {
                    System.out.println("\nEnter amount: " );
                    double amount = in.nextDouble();
                    
                    if(amount < BidItem.getListItem().get(0).getInitialAmount())
                    {
                        System.out.println("Amount must be greater than initial amount of the selected item");
                        continue;
                    }
                    else
                    {
                        processAmount.add(amount);
                        
                        if(processAmount.size() > 1)
                        {
                            if(amount < processAmount.get(processAmount.size() -2))
                            {
                                System.out.println("you need to put higher amount");
                                continue;
                            }
                        }
                        
                        winner.add(biduser);
                    }
                    
                }
                
                
                System.out.println("\nStop bid 1- yes 0- no");
                int stop = in.nextInt();
                
                if(stop == 1)
                {
                    System.out.println("The winner is " + biduser.getFirstname() + " " + biduser.getLastname());
                    break;
                }
            }
            
            
       
            System.out.println("\n\nPlay Again ? \n 1-yes 0-no ");
            more = in.nextInt();
       }
    }
    
    
    
    private static Person getUserId( List<Person> users,int userid)
    {
        for(Person obj:users)
        {
            if(obj.getUserId() == userid)
                return obj;
        }
        
        return null;
    }
}
