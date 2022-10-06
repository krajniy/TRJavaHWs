package TRJavaHWs.practice;

public class Main {
    public static void main(String[] args) {
        Clothes[] clothes = new Clothes[]{
                new Pants(ClothesSize.L, "blue", 100),
                new Skirt(ClothesSize.XS, "white", 300),
                new TShirt(ClothesSize.XXS, "pink", 200),
                new Tie(ClothesSize.M, "ruby", 1500)
        };
        Studio studio = new Studio(clothes);
        studio.dressMen(clothes);
        studio.dressWomen(clothes);

    }
}
