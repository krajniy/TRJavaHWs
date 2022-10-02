package TRJavaHWs.lesson2.eshop;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Good> goodsInBasket; //� ������� ������, �� ������� ���-����� ������ ���������� �����, �������� �� ����

    public Basket() {
        goodsInBasket = new ArrayList<>();
    }

    public List<Good> getGoodsInBasket() {
        return goodsInBasket;
    }

    public void addToBasket(Good good){
        goodsInBasket.add(good);
    }

    public void addAllToBasket(List<Good> goods){
        goodsInBasket.addAll(goods);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "goodsInBasket=" + goodsInBasket +
                '}';
    }
}
