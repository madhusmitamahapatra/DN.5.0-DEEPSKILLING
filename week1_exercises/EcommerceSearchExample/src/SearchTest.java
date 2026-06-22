import java.util.Arrays;

public class SearchTest {
    public static void main(String[] args) {
        Product[] products = new Product[] {
            new Product(101, "Apple iPhone 13", "Electronics"),
            new Product(102, "Samsung Galaxy S21", "Electronics"),
            new Product(103, "Sony Headphones", "Audio"),
            new Product(104, "Dell XPS 13", "Computers"),
            new Product(105, "Apple MacBook Pro", "Computers")
        };

        System.out.println("-- Linear Search --");
        String target1 = "Sony Headphones";
        int li = SearchUtils.linearSearchByName(products, target1);
        if (li >= 0) System.out.println("Found at index " + li + ": " + products[li]);
        else System.out.println("Not found: " + target1);

        System.out.println("\n-- Binary Search --");
        Product[] sorted = products.clone();
        Arrays.sort(sorted); // sorts by productName via compareTo
        System.out.println("Sorted array by name:");
        for (int i = 0; i < sorted.length; i++) System.out.println(i + ": " + sorted[i]);

        String target2 = "Apple MacBook Pro";
        int bi = SearchUtils.binarySearchByName(sorted, target2);
        if (bi >= 0) System.out.println("Found at index " + bi + ": " + sorted[bi]);
        else System.out.println("Not found: " + target2);

        System.out.println("\n-- Complexity Notes --");
        System.out.println("Linear search: Best O(1) (found at first element), Average O(n), Worst O(n)");
        System.out.println("Binary search: Requires sorted data. Best O(1) (found at mid), Average O(log n), Worst O(log n)");
    }
}
