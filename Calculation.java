import java.util.Scanner;

public class Calculation {
    private StockData stockDataList[];

    public Calculation(StockData stockDataList[],int size)
    {
        this.stockDataList=new StockData[size];
     for(int i=0;i<stockDataList.length;i++)
      this.stockDataList[i]=stockDataList[i];
    }

    Scanner scanner=new Scanner(System.in);
    public void absoluteReturnBetweenFirstAndLastRecord()
    {  
     System.out.println("Absolute return between first and last record is : ");  
    float result=((stockDataList[stockDataList.length-1].getClosedStockPrice()-stockDataList[0].getClosedStockPrice())/stockDataList[0].getClosedStockPrice());
    
  //System.out.println(stockDataList[stockDataList.length-1].getClosedStockPrice());
    //System.out.println(stockDataList[0].getClosedStockPrice());
   System.out.println(result*100);

    }

    public void absoluteReturnBetweenTwoSpecifiedDates()
    {
        float startStockPrice=0f,endStockPrice=0f;
    System.out.println("Enter start date : ");
    String date1=scanner.nextLine();
    System.out.println("Enter end date : ");
    String date2=scanner.nextLine();
    for(int i=0;i<stockDataList.length;i++)
    {
        if(stockDataList[i].getDate().equals(date1))
        startStockPrice = stockDataList[i].getClosedStockPrice();
        if(stockDataList[i].getDate().equals(date2))
        endStockPrice = stockDataList[i].getClosedStockPrice();
    }
    System.out.println("Absolute return between the specified dates are : ");
    System.out.println(((endStockPrice-startStockPrice)/startStockPrice)*100);
    }

    public void valueOfInvestmentOnaParticularDate()
    {
        System.out.println("Enter particular date : ");
        String date=scanner.nextLine();
        System.out.println("Value of investment on mentioned date is : ");
        for(int i=0;i<stockDataList.length;i++)
        {
            if(stockDataList[i].getDate().equals(date))
            System.out.println(stockDataList[i].getClosedStockPrice());
        }

    }
    
    public void highestStockPriceForEntireRange()
    {
       float highest=0f;
      for(int i=0;i<stockDataList.length;i++)
      {
          if(stockDataList[i].getHighestStockPrice()>highest)
          highest=stockDataList[i].getHighestStockPrice();
      }
      
      System.out.println("The highest stock price for entire range is : ");
      System.out.println(highest); 
    }

    public void lowestStockPriceForEntireRange()
    {
        float lowest=stockDataList[0].getLowestStockPrice();
        for(int i=1;i<stockDataList.length;i++)
        {
            if(stockDataList[i].getLowestStockPrice()<lowest && stockDataList[i].getLowestStockPrice()!=0)
            lowest=stockDataList[i].getLowestStockPrice();
        }
        System.out.println("The lowest stock price for entire range is : ");
        System.out.println(lowest); 
    }

    public void averageDailyReturn()
    {
        float sum=0f,average=0f;
       for(int i=1;i<stockDataList.length;i++)
       {
        float previousDayClose=stockDataList[i-1].getClosedStockPrice();
        float currentDayClose=stockDataList[i].getClosedStockPrice();
        sum=sum+((currentDayClose-previousDayClose)/previousDayClose);
        //System.out.println(sum);
       }
       
        average=(sum/(stockDataList.length-1)*100);
       System.out.println("The average daily return of the stock is : ");
       System.out.println(average);
    }
}

