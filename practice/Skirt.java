package TRJavaHWs.practice;

public class Skirt extends Clothes implements WomenClothes{
    public Skirt(ClothesSize size, String color, double price) {
        super(size, color, price);
    }

    @Override
    public void dressWomen() {
        System.out.println("Woman now wears a skirt");

    }
}
