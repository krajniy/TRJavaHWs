package TRJavaHWs.practice;

public class TShirt extends Clothes implements MenClothes, WomenClothes{


    public TShirt(ClothesSize size, String color, double price) {
        super(size, color, price);
    }

    @Override
    public void dressMen() {

    }

    @Override
    public void dressWomen() {

    }
}
