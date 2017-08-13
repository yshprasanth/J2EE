package comparable;

import java.util.Set;
import java.util.TreeSet;

class Product implements Comparable<Product>{
    String productName;
    int productId;

    public Product(String productName, int productId) {
        this.productName = productName;
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productId=" + productId +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        System.out.println(this + " is comparedTo " + o);
        return productName.compareToIgnoreCase(o.productName);
    }

    @Override
    public boolean equals(Object o) {
        System.out.println(this + " is equals " + o);
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        return productName.equalsIgnoreCase(product.productName);
    }

    @Override
    public int hashCode() {
        int result = productName != null ? productName.hashCode() : 0;
        result = 31 * result + productId;
        return result;
    }
}
public class SetCompare {
    public static void main(String args[]) {
        Set<Product> prodList = new TreeSet<Product>();

        prodList.add(new Product("A", 13546));
        prodList.add(new Product("B", 04762));
        prodList.add(new Product("C", 12221));
        prodList.add(new Product("D", 44387));

        for (Product p : prodList)
            System.out.printf("%5s - %-14s ID: %d\n", p.productName, p.productName, p.productId);
    }
}
