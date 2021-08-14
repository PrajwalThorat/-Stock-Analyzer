import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main{
    public static void main(String[] args) {
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./data/CIPLA.NS.csv"));
            int count =0;
            // by calling readline method for first time
            // it reads first row, which usally called as header
            String header = reader.readLine();


            while(true){
                String line = reader.readLine();
                if(line!=null){
                    count++;
                }else{
                    break;
                }
            }
            System.out.println(count);
            //By completing this while loop
            //cursor reached to the end the file.

            reader.close();

            //Now read the data from the file
            //cursor need to placed again at the starting of the file

            //re-intialise buffered reader.
            reader = new BufferedReader(new FileReader("./data/CIPLA.NS.csv"));
            // to read header line
            reader.readLine();

            StockData[] stockDataList = new StockData[count];
            int index = 0;
            // then after, each line is called as records
            while(true){
                // readline method returns null value, if no further lines
                //existed to read
                String line = reader.readLine();
                if(line!=null){
                   
                    //2015-08-03,713.799988,716.950012,705.000000,712.299988,696.087708,916688
                    String[] fieldData = line.split(",(\"(?:[^\"]|\"\")\"|)");
                    String date = fieldData[0];
                    String openPrice = fieldData[1];
                    String highestPrice = fieldData[2];
                    String lowestPrice = fieldData[3];
                    String closedPrice = fieldData[4];
                    String adjustClosedPrice = fieldData[5];
                    String volume = fieldData[6];

                   
                    StockData stockData = new StockData();
                    stockData.setDate(date);
                   
                    try{
                    float openStockPrice = Float.parseFloat(openPrice);
                    stockData.setOpenStockPrice(openStockPrice);
                    }
                    catch(NumberFormatException e)
                    {
                        stockData.setOpenStockPrice(0);
                    }

                    try{
                    float highestStockPrice = Float.parseFloat(highestPrice);
                    stockData.setHighestStockPrice(highestStockPrice);
                    }
                    catch(NumberFormatException e)
                    {
                        stockData.setHighestStockPrice(0);
                    }

                    try{
                    float lowestStockPrice = Float.parseFloat(lowestPrice);
                    stockData.setLowestStockPrice(lowestStockPrice);
                    }
                    catch(NumberFormatException e)
                    {
                        stockData.setLowestStockPrice(0);
                    }
                    //""
                    try{
                    float closedStockPrice = Float.parseFloat(closedPrice);
                    stockData.setClosedStockPrice(closedStockPrice);
                    }
                    catch(NumberFormatException e)
                    {
                        stockData.setClosedStockPrice(0);
                    }

                    try{

                    float adjustClosedStockPrice = Float.parseFloat(adjustClosedPrice);
                    stockData.setAdjustClosedStockPrice(adjustClosedStockPrice);
                    }
                    catch(NumberFormatException e)
                    {
                        stockData.setAdjustClosedStockPrice(0);
                    }
                    try{
                    int noOfStocksTraded = Integer.parseInt(volume);
                    stockData.setNoOfStocksTraded(noOfStocksTraded);
                    }
                    catch(NumberFormatException e)
                    {
                        stockData.setNoOfStocksTraded(0);
                    }

                    stockDataList[index] = stockData;
                    index++;
                }else{
                    break;
                }
            }
            int DateList[]=new int[count];

            for(int i=0;i<stockDataList.length;i++)
            {
                String dateSplit[]=stockDataList[i].getDate().split("-"); 
                    int yearMonthDate=Integer.parseInt(dateSplit[0]+dateSplit[1]+dateSplit[2]);
                    DateList[i]=yearMonthDate;
            }

            for(int i=0;i<stockDataList.length-1;i++)
            {
                for(int j=i+1;j<stockDataList.length;j++)
                {
                if(DateList[i]>DateList[j])
                {
                    StockData temp=stockDataList[i];
                    stockDataList[i]=stockDataList[j];//sorted list
                    stockDataList[j]=temp;
                }
                }
            }
            
            Calculation calculate=new Calculation(stockDataList,stockDataList.length);
            calculate.absoluteReturnBetweenFirstAndLastRecord();
            calculate.absoluteReturnBetweenTwoSpecifiedDates();
            calculate.valueOfInvestmentOnaParticularDate();
            calculate.highestStockPriceForEntireRange();
            calculate.lowestStockPriceForEntireRange();
            calculate.averageDailyReturn();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }


    }
}



