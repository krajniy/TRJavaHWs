package TRJavaHWs.practice;

public abstract class Clothes {
    private ClothesSize size;
    private String color;
    private double price;

    public Clothes(ClothesSize size, String color, double price) {
        this.size = size;
        this.color = color;
        this.price = price;
    }

    public ClothesSize getSize() {
        return size;
    }

    public void setSize(ClothesSize size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "size=" + size +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
