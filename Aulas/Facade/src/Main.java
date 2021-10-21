import impl.DiscountService;
import model.Card;
import model.Product;

public class Main {
    public static void main(String[] args) {
        Card cc = new Card();
        cc.setBank("Star Bank");
        cc.setNumber("012165198");

        Product p = new Product();
        p.setName("Coca-Cola");
        p.setType("Lata");

        DiscountService service = new DiscountService();
        Double totalDiscount = service.giveDiscount(cc, p, 20);

        System.out.println(totalDiscount);
    }
}
