import java.util.Scanner;

public class Product {
    private int id;
    private String name;
    private double price;
    private String type;
    private String money = "USD";

    public Product(){
    }

    public Product(int id, String name, double price, String type, String money){
        this.id = id;
        this.name = name;
        this.price = price;
        this.money = money;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", money='" + money + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Product[] products = new Product[inSize(input)];

        for (int i = 0; i < products.length ; i++) {
            System.out.printf("Nhap san pham thu %d",i+1);
            System.out.println();
            Product product = createProduct(input);
            products[i] = product;
        }

        for (Product i : products) {
            System.out.println(i);
        }

        sumProduct(products);
        System.out.println();
        inputProduct(input,products);
    }


    public static void inputProduct(Scanner input, Product[] product){
        System.out.print("Nhap id san pham can in ra:");
        int id = input.nextInt();
        for (int i = 0; i < product.length ; i++) {
            if (product[i].id == id){
                System.out.print(product[i]);
            }
        }
    }

    public static void sumProduct(Product[] product){
        double sum = 0 ;
        for (int i = 0; i < product.length; i++) {
            sum += product[i].price;
        }
        System.out.printf("Tong gia cac san pham: %.2f",sum);
    }

    public static int inSize(Scanner input){
        System.out.print("Nhap so san pham: ");
        int size = input.nextInt();
        return size;
    }

    public static Product createProduct(Scanner input){
        System.out.print("Nhap ma san pham: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Nhap ten san pham: ");
        String name = input.nextLine();
        System.out.print("Nhap gia san pham: ");
        double price = input.nextDouble();
        input.nextLine();
        System.out.print("Nhap loai san pham: ");
        String type = input.nextLine();
        System.out.print("Nhap don vi tien san pham: ");
        String money = input.nextLine();
        return new Product(id,name,price,type,money);
    }
}
