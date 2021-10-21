package api;

public class QuantityAPI extends API {

    public Double checkDiscount(int quantity) {
        if (quantity > 12) {
            setDiscount(15.00);
        }
        return getDiscount();
    }
}
