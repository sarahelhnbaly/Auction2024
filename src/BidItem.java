import java.util.*;
public class BidItem extends Item
{
    private String itemName;
    private double initialAmount;
    
    private static List<Item> itemList;
    public BidItem()
    {
        itemList = new ArrayList<>();
    }
    
    public BidItem(String itemName,double initialAmount)
    {
        this.itemName = itemName;
        this.initialAmount = initialAmount;
    }
    
    public String getName()
    {
        return itemName;
    }
    
    public double getInitialAmount()
    {
        return initialAmount;
    }
    
   public  void registerItem()
   {
       try
       {
           Scanner input = new Scanner(System.in);
           System.out.println("Enter item name: ");
           String name = input.next();
           System.out.println("Enter initial amount: ");
           double amount = input.nextDouble();
           BidItem item  = new BidItem(name,amount);
           itemList.add(item);
        }catch(Exception err)
        {
            System.out.println("Error in entering the bid item");
        }
    }
    
    public static List<Item> getListItem()
    {
        return itemList;
    }
    
    public String toString()
    {
        return itemName + "  initial amount is : " + initialAmount;
    }
}
