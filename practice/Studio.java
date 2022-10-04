package TRJavaHWs.practice;

public class Studio {
    private Clothes[] clothes;

    public Studio(Clothes[] clothes) {
        this.clothes = clothes;
    }

    public void dressWomen(Clothes[] clothes){
        for (Clothes clothes1 : clothes){
            if (clothes1 instanceof WomenClothes){
                System.out.println(clothes1);
            }
        }

    }
    public void dressMen(Clothes[] clothes){
        for (Clothes clothes1 : clothes){
            if (clothes1 instanceof MenClothes){
                System.out.println(clothes1);
            }
        }

    }
}
