import java.util.LinkedHashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {

        Map<Integer, Integer> hp = new LinkedHashMap<>();

        hp.put(10, 100);
        hp.put(12, 98);
        hp.put(10, 98);

        for (Map.Entry<Integer, Integer> i : hp.entrySet()) {
            System.out.println(i.getKey() + " " + i.getValue());
        }

        hp.remove(12);

        if (hp.containsKey(10)) {
            System.out.println("Marks of RollNo 10: " + hp.get(10));
        } else {
            System.out.println("Student not found");
        }

        hp.put(10, 56);

        for (Map.Entry<Integer, Integer> i : hp.entrySet()) {
            System.out.println(i.getKey() + " " + i.getValue());
        }
    }
}