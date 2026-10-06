import java.util.ArrayList;

public class Sorting {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(40);
        arr.add(20);
        arr.add(60);
        arr.add(30);

        System.out.println(arr);

        arr.sort(null);

        System.out.println(arr);
    }
}
