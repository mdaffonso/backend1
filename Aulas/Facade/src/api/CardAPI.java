package api;

public class CardAPI extends API {

    public Double checkDiscount(String bank) {
        if(bank.toLowerCase().equals("star bank")) {
            setDiscount(20.00);
        }
        return getDiscount();
    }
}
