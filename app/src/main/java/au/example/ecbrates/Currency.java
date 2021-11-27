package au.example.ecbrates;

public class Currency {
    public String getCurrencyName() {
        return currencyName;
    }

    public Currency(String currencyName, Double rate) {
        this.currencyName = currencyName;
        this.rate = rate;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    private String currencyName;
    private Double rate;


}
