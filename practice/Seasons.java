package TRJavaHWs.practice;

import java.util.Arrays;

public enum Seasons {
    SPRING(12),
    SUMMER(25){
        public String getDescription() {
              return   "Warm season";
        }
    },
    AUTUMN(15),
    WINTER(5);

    private double averageTemp;

    public String getDescription() {
            return "Cold season";
    }


    public double getAverageTemp() {
        return averageTemp;
    }

    Seasons(double averageTemp) {
        this.averageTemp = averageTemp;
    }

    public static void main(String[] args) {
        Seasons favoriteSeason = Seasons.AUTUMN;
        System.out.println("Name of favorite season is " + favoriteSeason.name() + "\nAverage temperature is " +
                favoriteSeason.getAverageTemp() + " ." + favoriteSeason.getDescription());

        Seasons[] seasons = Seasons.values();


        for (Seasons s : seasons) {
            System.out.println(s.name());
            System.out.println(s.averageTemp);
            System.out.println(s.getDescription());
        }
    }

    public static void printLove(Seasons season) {
        switch (season) {
            case AUTUMN -> System.out.println("I love Autumn");
            case SPRING -> System.out.println("I love Spring");
            case SUMMER -> System.out.println("I love Summer");
            case WINTER -> System.out.println("I love Winter");

        }


    }

}
