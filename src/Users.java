
import java.util.*;
public class Users extends Person
{
    private int userid;
    private String firstname;
    private String lastname;
    private double amount;
    private static List<Person> userList;
    
    public int getUserId()
    {
        return userid;
    }
    
    public String getFirstname()
    {
        return firstname;
    }
    
    public String getLastname()
    {
        return lastname;
    }
    
    public double getAmount()
    {
        return amount;
    }
    
    public Users()
    {
        userList = new ArrayList<>();
    }
    
    public Users(int userid,String firstname,String lastname,double amount)
    {
        this.userid = userid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.amount = amount;
    }
    
    public void registerUsers(int n)
    {
        Scanner input = new Scanner(System.in);
        int i=0;
        while(i<n)
        {
            try
            {
                System.out.println("Enter userid: ");
                int userid = input.nextInt();
                System.out.println("Enter firstname: ");
                String firstname = input.next();
                System.out.println("Enter lastname: ");
                String lastname = input.next();
                System.out.println("Enter amount: ");
                double amount = input.nextDouble();
                Users user = new Users(userid,firstname,lastname,amount);
                userList.add(user);
            }catch(Exception err)
            {
                System.out.println("Error in entering user data");
                i--;
            }
            i++;
        }
        
    }
    
    public static List<Person> getUserList()
    {
        return userList;
    }
    
    public String toString()
    {
        return userid + " " +firstname + " " + lastname + " " +amount;
    }
}
