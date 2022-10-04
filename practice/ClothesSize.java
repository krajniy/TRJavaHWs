package TRJavaHWs.practice;

public enum ClothesSize {
    XXS(32) {
        public String getDescription(){
            return "Детский размер";
        }
    },
    XS(34),
    S(36),
    M(38),
    L(40);

    private int euroSize;

    ClothesSize(int euroSize) {
        this.euroSize = euroSize;
    }

    public String getDescription(){
        return "Взрослый размер";
    }


}
