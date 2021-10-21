package itf;

import model.Card;
import model.Product;

public interface IDiscount {
    Double giveDiscount(Card card, Product product, Integer quantity);
}
