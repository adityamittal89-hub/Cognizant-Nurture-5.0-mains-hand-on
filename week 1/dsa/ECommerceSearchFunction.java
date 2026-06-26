public class ECommerceSearchFunction {

public static void main(String[] args) {

Product[] products = {
new Product(3, "Shoes", "Fashion"),
new Product(1, "Phone", "Electronics"),
new Product(4, "Watch", "Accessories"),
new Product(2, "Laptop", "Electronics")
};

Product result1 = linearSearch(products, 4);
if (result1 != null) {
System.out.println(result1.productName);
}

Product[] sortedProducts = {
new Product(1, "Phone", "Electronics"),
new Product(2, "Laptop", "Electronics"),
new Product(3, "Shoes", "Fashion"),
new Product(4, "Watch", "Accessories")
};

Product result2 = binarySearch(sortedProducts, 4);
if (result2 != null) {
System.out.println(result2.productName);
}
}

public static Product linearSearch(Product[] products, int targetId) {
for (int i = 0; i < products.length; i++) {
if (products[i].productId == targetId) {
return products[i];
}
}
return null;
}

public static Product binarySearch(Product[] products, int targetId) {
int left = 0;
int right = products.length - 1;

while (left <= right) {
int mid = (left + right) / 2;

if (products[mid].productId == targetId) {
return products[mid];
} else if (products[mid].productId < targetId) {
left = mid + 1;
} else {
right = mid - 1;
}
}
return null;
}
}

class Product {

int productId;
String productName;
String category;

Product(int productId, String productName, String category) {
this.productId = productId;
this.productName = productName;
this.category = category;
}
}