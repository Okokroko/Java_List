package list;

public class Textlist {
    public static void main(String[] args) {
        DynamicSizedList<String> pgNames = new DynamicSizedList<>();

        pgNames.add("John");
        pgNames.add("san");
        pgNames.add("jerry");
        pgNames.add("frank");
        pgNames.add("hank");

        System.out.println(pgNames.get(4));
        System.out.println(pgNames.swap(2,3));
        System.out.println(pgNames.get(3));
    }

}
