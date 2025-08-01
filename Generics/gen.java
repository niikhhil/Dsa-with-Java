public class gen {
    public static <T> void printElements(T[] arr) {
        for(T element: arr) {
            System.out.print(element + " ");
        }
    }
    public static void main(String[] args) {
        Integer[] intArr = {0, 1, 2, 3, 4, 5};
        Float[] floatArr = {0.1f, 1.1f, 2.1f, 3.1f, 4.1f, 5.1f};
        String[] stringArr = {"0", "1", "2","3", "4", "5"};

        System.out.println("Integer Array");
        printElements(intArr);
        System.out.println();


        System.out.println("Float Array");
        printElements(floatArr);
        System.out.println();

        System.out.println("String Array");
        printElements(stringArr);
    }
}
