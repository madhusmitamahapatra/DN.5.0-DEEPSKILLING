public class SearchUtils {
    /**
     * Linear search over the array of products by productName (case-insensitive).
     * Time complexity: O(n)
     * @return index of matching product or -1 if not found
     */
    public static int linearSearchByName(Product[] products, String name) {
        if (products == null || name == null) return -1;
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null && products[i].getProductName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Iterative binary search on a sorted (by productName) array of products.
     * Array must be sorted by productName (case-insensitive) before calling.
     * Time complexity: O(log n)
     * @return index in the provided array or -1 if not found
     */
    public static int binarySearchByName(Product[] sortedProducts, String name) {
        if (sortedProducts == null || name == null) return -1;
        int low = 0, high = sortedProducts.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            Product midProd = sortedProducts[mid];
            if (midProd == null) return -1;
            int cmp = midProd.getProductName().compareToIgnoreCase(name);
            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
