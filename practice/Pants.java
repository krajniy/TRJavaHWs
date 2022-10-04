package TRJavaHWs.practice;

public class Pants extends Clothes implements MenClothes, WomenClothes {
    public Pants(ClothesSize size, String color, double price) {
        super(size, color, price);
    }

    @Override
    public void dressMen() {

    }

    @Override
    public void dressWomen() {

    }
}
