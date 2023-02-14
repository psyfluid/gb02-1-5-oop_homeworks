package homework04;

public class Program {
    public static void main(String[] args) {
        TestStringArray();
        TestIntegerArray();
    }

    private static void TestStringArray() {
        MyArray<String> myArray = new MyArray<>(new String[]{"deal", "deer", "bitter", "person", "bitter", "envelope"
                , "delivery", "listen", "merchant", "cat"});

        System.out.println("Test String array");
        myArray.printArray();
        System.out.println();

        System.out.println("Add new element");
        myArray.add("new");
        myArray.printArray();
        System.out.println();

        System.out.println("Remove element with index 3");
        myArray.remove(3);
        myArray.printArray();
        System.out.println();

        System.out.println("Remove elements with value \"bitter\"");
        myArray.removeValue("bitter");
        myArray.printArray();
        System.out.println();

        System.out.println("Find index of value \"listen\"");
        System.out.println(myArray.indexOf("listen"));
        System.out.println();

        System.out.println("Find value \"cat\"");
        System.out.println(myArray.contains("cat"));
        System.out.println();

        System.out.println("Default sort (bubble sort)");
        MyArray<String> tempArray = myArray.clone();
        tempArray.sort();
        tempArray.printArray();
        System.out.println();

        System.out.println("Explicit bubble sort");
        tempArray = myArray.clone();
        tempArray.sort(MyArray.SortingType.BubbleSort);
        tempArray.printArray();
        System.out.println();

        System.out.println("Insertion sort");
        tempArray = myArray.clone();
        tempArray.sort(MyArray.SortingType.InsertionSort);
        tempArray.printArray();
        System.out.println();

        System.out.println("Selection sort");
        tempArray = myArray.clone();
        tempArray.sort(MyArray.SortingType.SelectionSort);
        tempArray.printArray();
        System.out.println();
    }

    private static void TestIntegerArray() {
        MyArray<Integer> myArray = new MyArray<>(new Integer[]{5, 2, 4, 10, 4});

        System.out.println("Test Integer array");
        myArray.printArray();
        System.out.println();

        System.out.println("Minimum");
        System.out.println(myArray.min());
        System.out.println();

        System.out.println("Maximum");
        System.out.println(myArray.max());
        System.out.println();

        System.out.println("Sum of elements");
        System.out.println(myArray.sumOfElements());
        System.out.println();

        System.out.println("Product of elements");
        System.out.println(myArray.productOfElements());
        System.out.println();

    }
}
