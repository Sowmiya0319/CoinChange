import java.util.Arrays;
import java.util.Scanner;

public class coinChange {

  public static int minCoins(int[] coins, int m, int amount, int[] coinLimit) {
    int[] coinCount = new int[ amount+ 1];
    Arrays.fill(coinCount, Integer.MAX_VALUE);
    coinCount[0] = 0;
   int par=0;
    for (int i = 0; i <m; i++) {
        par+=coins[i]*coinLimit[i];
      for (int j = coins[i]; j <= par && j<=amount; j++) {
          
          coinCount[j]=Math.min(coinCount[j-coins[i]]+1,coinCount[j]);
      }
    }
    int mincoin = 0;
       for(int i=1;i<=amount;i++)
       {
      mincoin=coinCount[i];
         
  }
       return mincoin;
  }


   public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Choose your currency");
    System.out.println("1.British Pound \n 2.US Dollar \n 3.Norweigian Krone \n");
    int currency=sc.nextInt();
   System.out.println("Enter the amount");
   int amount=sc.nextInt();
    if(currency==1)
    {
      int[] coins = {1,2,5,10,20,50};
      int[] coinLimit={5,4,1,1,2,2};
       int m = coins.length;
   
    System.out.println("Minimum coins required is " + (minCoins(coins, m, amount,coinLimit)));
   
    }
    else if(currency==2)
    {
      int[] coins={1,5,10,25};
      int[] coinLimit={1,2,3,2,1};
       int m = coins.length;
   
    System.out.println("Minimum coins required is " + minCoins(coins, m, amount,coinLimit));
    }
    else if(currency==3)
    {
      int[] coins={1,5,10,20};
      int[] coinLimit={2,2,1,4};
       int m = coins.length;
    
    System.out.println("Minimum coins required is " + minCoins(coins, m,amount,coinLimit));
  } 
   }
}