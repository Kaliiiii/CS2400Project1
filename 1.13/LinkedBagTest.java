import java.util.Arrays;
public class LinkedBagTest {
public static void main(String[]args)    {
    BagInterface<String>bagA = new LinkedBag<>();
    BagInterface<String>bagB = new LinkedBag<>();

    bagA.add("Potato");
    bagA.add("Orange");
    bagA.add("Grape");
    bagA.add("Potato");
    bagA.add("Cauliflower");
    bagA.add("Carrot");
    bagB.add("Bell Pepper");
    bagB.add("Carrot");
    bagB.add("Potato");
    bagB.add("Lettuce");
    bagB.add("Green Bean");
    bagB.add("Orange");

    System.out.println("Linked Bag Test: ");
    System.out.print("Bag A: ");
    System.out.println(Arrays.toString(bagA.toArray()));
    System.out.print("Bag B: ");
    System.out.println(Arrays.toString(bagB.toArray()));
    System.out.print("Union of Bag A and Bag B: ");
    System.out.println(Arrays.toString(bagA.union(bagB).toArray()));
    System.out.print("Intersection of Bag A and Bag B: ");
    System.out.println(Arrays.toString(bagA.intersection(bagB).toArray()));
    System.out.print("Difference of Bag A and Bag B: ");
    System.out.println(Arrays.toString(bagA.difference(bagB).toArray()));

}
}
