package TRJavaHWs.practice;

public class TShirt extends Clothes implements MenClothes, WomenClothes{


    public TShirt(ClothesSize size, String color, double price) {
        super(size, color, price);
    }

    @Override
    public void dressMen() {
        System.out.println("Man now wears a t-shirt");

    }

    @Override
    public void dressWomen() {
        System.out.println("Woman now wears a t-shirt");

    }
}
