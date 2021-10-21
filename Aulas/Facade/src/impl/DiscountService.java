package impl;

import api.CardAPI;
import api.ProductAPI;
import api.QuantityAPI;
import itf.IDiscount;
import model.Card;
import model.Product;

public class DiscountService implements IDiscount {

    private CardAPI cardApi;
    private ProductAPI productApi;
    private QuantityAPI quantityApi;

    public DiscountService() {
        cardApi = new CardAPI();
        productApi = new ProductAPI();
        quantityApi = new QuantityAPI();
    }

    @Override
    public Double giveDiscount(Card card, Product product, Integer quantity) {
        return cardApi.checkDiscount(card.getBank()) + productApi.checkDiscount(product.getType()) + quantityApi.checkDiscount(quantity);
    }
}
