package DSA;

class Product {
int productId;
String productName;
String category;
    
public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}  
class LinearSearch{
        public int search(Product[] p,int productId){
            for(int i=0;i<p.length;i++){
                if(p[i].productId == productId){
                    return i; 
                }
            }
            return -1; 
        }
    }

class BinarySearch{
        public int search(Product[] p,int productId){
            int low = 0;
            int high = p.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (p[mid].productId == productId) {
                    return mid; 
                } else if (p[mid].productId < productId) {
                    low = mid + 1; 
                } else {
                    high = mid - 1; 
                }
            }
            return -1; 
        }
}
      
public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(205, "Shirt", "Apparel"),
            new Product(150, "Book", "Stationery"),
            new Product(120, "Phone", "Electronics"),
            new Product(180, "Shoes", "Footwear")
        };

        // For binary search, create a sorted array by productId
        Product[] sortedProducts = products.clone();
        java.util.Arrays.sort(sortedProducts, (a, b) -> Integer.compare(a.productId, b.productId));

        // Example usage
        LinearSearch linearSearch = new LinearSearch();
        int linearIndex = linearSearch.search(products, 150);

        BinarySearch binarySearch = new BinarySearch();
        int binaryIndex = binarySearch.search(sortedProducts, 150);

        System.out.println("Linear Search Index: " + linearIndex);
        System.out.println("Binary Search Index: " + binaryIndex);
        if (linearIndex != -1) {
            System.out.println("Found using Linear Search: " + products[linearIndex].productName);
        } else {
            System.out.println("Product not found using Linear Search.");       
        }
        if (binaryIndex != -1) {
            System.out.println("Found using Binary Search: " + sortedProducts[binaryIndex].productName);
        } else {
            System.out.println("Product not found using Binary Search.");
        }
    }
}
