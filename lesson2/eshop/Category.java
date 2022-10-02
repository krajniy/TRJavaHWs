package TRJavaHWs.lesson2.eshop;

public class Category {
    private String name;
    private Good[] goods;

    public Category(String name, Good[] goods) {
        this.name = name;
        this.goods = goods;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Good[] getGoods() {
        return goods;
    }

    public void setGoods(Good[] goods) {
        this.goods = goods;
    }
}
