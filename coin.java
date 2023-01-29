import java.util.Arrays;
import java.util.Scanner;

public class coin {

public static int coinchange(int[] coins, int m, int amount) {
    int[] coinCount = new int[amount + 1];
    Arrays.fill(coinCount, Integer.MAX_VALUE);
    coinCount[0] = 0;

    for (int i = 1; i <= amount; i++) {
      for (int j = 0; j < m; j++) {
        if (coins[j] <= i) {
          int coin = coinCount[i - coins[j]];
          if (coin != Integer.MAX_VALUE && coin + 1 < coinCount[i]) {
            coinCount[i] = coin + 1;
          }
        }
      }
    }
    return coinCount[amount];
  }


  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Choose your currency");
    System.out.println("1.British Pound \n 2.US Dollar \n 3.Norweigian Krone \n Enter the currency code");
    int currency=sc.nextInt();
   System.out.println("Enter the amount");
   int amount=sc.nextInt();
    if(currency==1)
    {
      int[] coins = {1,2,5,10,20,50};
       int m = coins.length;
   
    System.out.println("Minimum coins required is " + coinchange(coins, m, amount));
   
    }
    else if(currency==2)
    {
      int[] coins={1,2,5};
       int m = coins.length;
   
    System.out.println("Minimum coins required is " +  coinchange(coins, m, amount));
    }
    else if(currency==3)
    {
      int[] coins={1,5,10,20};
       int m = coins.length;
    
    System.out.println("Minimum coins required is " + coinchange(coins, m,amount));
  } 
  else
    {
        System.out.print("Enter valid currency code");
    }
  
   
  }
}
