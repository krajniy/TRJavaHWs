package TRJavaHWs.practice;

public class Pants extends Clothes implements MenClothes, WomenClothes {
    public Pants(ClothesSize size, String color, double price) {
        super(size, color, price);
    }

    @Override
    public void dressMen() {
        System.out.println("Man now wears pants");

    }

    @Override
    public void dressWomen() {
        System.out.println("Woman now wears pants");


    }
}
