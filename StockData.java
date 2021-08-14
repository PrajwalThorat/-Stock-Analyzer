public class StockData {

    private String date;
    private float openStockPrice;
    private float highestStockPrice;
    private float lowestStockPrice;
    private float closedStockPrice;
    private float adjustClosedStockPrice;
    private int noOfStocksTraded;
    
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public float getOpenStockPrice() {
        return openStockPrice;
    }
    public void setOpenStockPrice(float openStockPrice) {
        this.openStockPrice = openStockPrice;
    }
    public float getHighestStockPrice() {
        return highestStockPrice;
    }
    public void setHighestStockPrice(float highestStockPrice) {
        this.highestStockPrice = highestStockPrice;
    }
    public float getLowestStockPrice() {
        return lowestStockPrice;
    }
    public void setLowestStockPrice(float lowestStockPrice) {
        this.lowestStockPrice = lowestStockPrice;
    }
    public float getClosedStockPrice() {
        return closedStockPrice;
    }
    public void setClosedStockPrice(float closedStockPrice) {
        this.closedStockPrice = closedStockPrice;
    }
    public float getAdjustClosedStockPrice() {
        return adjustClosedStockPrice;
    }
    public void setAdjustClosedStockPrice(float adjustClosedStockPrice) {
        this.adjustClosedStockPrice = adjustClosedStockPrice;
    }
    public int getNoOfStocksTraded() {
        return noOfStocksTraded;
    }
    public void setNoOfStocksTraded(int noOfStocksTraded) {
        this.noOfStocksTraded = noOfStocksTraded;
    }

    @Override
    public String toString() {
        return "StockData [adjustClosedStockPrice=" + adjustClosedStockPrice + ", closedStockPrice=" + closedStockPrice
                + ", date=" + date + ", highestStockPrice=" + highestStockPrice + ", lowestStockPrice="
                + lowestStockPrice + ", noOfStocksTraded=" + noOfStocksTraded + ", openStockPrice=" + openStockPrice
                + "]";
    }

}
