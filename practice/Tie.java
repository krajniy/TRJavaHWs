package TRJavaHWs.practice;

public class Tie extends Clothes implements MenClothes{
    public Tie(ClothesSize size, String color, double price) {
        super(size, color, price);
    }

    @Override
    public void dressMen() {
        System.out.println("Man now wears a tie");


    }
}
