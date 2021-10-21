package api;

public class ProductAPI extends API {
    public Double checkDiscount(String product) {
        if (product.toLowerCase().equals("lata") || product.toLowerCase().equals("latas")) {
            setDiscount(10.00);
        }
        return getDiscount();
    }
}
