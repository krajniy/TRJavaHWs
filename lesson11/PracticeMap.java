package TRJavaHWs.lesson11;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PracticeMap {
    public static void main(String[] args) {
        /*
        Найти маршрут из заданного списка билетов
    Учитывая список билетов, найти маршрут по порядку, используя данный список.
    Вход:
    «Berlin» -> «London»
    «Tokyo» -> «Seoul»
    «Mumbai» -> «Berlin»
    «Seoul» -> «Mumbai»

    Выход:
    Tokyo->Seoul, Seoul->Mumbai, Mumbai->Berlin, Berlin->Lindon

         */

        Scanner scanner = new Scanner(System.in);
        String start = scanner.nextLine();

        Map<String, String> tickets = new HashMap<>();
        tickets.put("Berlin", "London");
        tickets.put("Tokyo", "Seoul");
        tickets.put("Mumbai", "Berlin");
        tickets.put("Seoul", "Mumbai");

        System.out.println(findWay(start, tickets));



    }
    public static String findWay (String start, Map<String, String> tickets){
        StringBuilder sb = new StringBuilder();
        String result = "";
        if (!tickets.containsKey(start)){
            sb.append(start);
            return sb.toString();
        }
        if ( tickets.get(start)==null){
            sb.append(start);
            return sb.toString();
        }

            while (tickets.containsKey(start) && start!=null){
                sb.append(start).append("->").append(tickets.get(start)).append(" ");

                result = tickets.get(start);
                start = tickets.get(result);
                sb.append(result).append("->").append(start).append(" ");



            }

        return sb.toString();

    }
}
