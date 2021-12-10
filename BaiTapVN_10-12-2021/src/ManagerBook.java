import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerBook {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Book> list = new ArrayList<Book>();
        choiceBook(input, list);
    }

    public static Book createBook(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Nhập tên sách: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá sách: ");
        double price = scanner.nextDouble();
        System.out.print("Nhập số lượng: ");
        int quantity = scanner.nextInt();
        System.out.println("Nhập ngày sản xuất(YY/MM/DD): ");
        LocalDate publication = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        return new Book(name, price, quantity, publication);
    }

    public static ScienceBook createScienceBook(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Nhập tên sách: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá sách: ");
        double price = scanner.nextDouble();
        System.out.print("Nhập số lượng: ");
        int quantity = scanner.nextInt();
        System.out.println("Nhập ngày sản xuất(YY/MM/DD): ");
        LocalDate publication = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        scanner.nextLine();
        System.out.print("Thể loại: ");
        String category = scanner.nextLine();
        return new ScienceBook(name, price, quantity, publication, category);
    }

    public static Novel createNovel(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Nhập tên sách: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá sách: ");
        double price = scanner.nextDouble();
        System.out.print("Nhập số lượng: ");
        int quantity = scanner.nextInt();
        System.out.println("Nhập ngày sản xuất(YY/MM/DD): ");
        LocalDate publication = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        scanner.nextLine();
        System.out.print("Tác giả: ");
        String author = scanner.nextLine();
        return new Novel(name, price, quantity, publication, author);
    }

    public static void choiceBook(Scanner input, ArrayList<Book> list) {
        int choice = -1;
        double sum = 0;
        while (choice != 0) {
            System.out.println("1. Sách thường");
            System.out.println("2. Sách khoa học");
            System.out.println("3. Sách tiểu thuyết");
            System.out.println("4. Hiển thị tất cả quyển sách");
            System.out.println("5. Hiển thị tổng giá tiền tất cả sách");
            System.out.println("6. Hiển thị sách có giá tiền cao nhất");
            System.out.println("7. Hiển thị sách có giá tiền  nhất");
            System.out.println("0. Exit");
            System.out.print("In choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    list.add(createBook(input));
                    break;
                case 2:
                    list.add(createScienceBook(input));
                    break;
                case 3:
                    list.add(createNovel(input));
                    break;
                case 4:
                    System.out.println(list);
                    break;
                case 5:
                    System.out.println("Tồng giá tiền của tất cả sách: " + Book.sum);
                    break;
                case 6:
                    bookMaxPrice(list);
                    break;
                case 7:
                    bookMinPrice(list);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Sai kiểu sách!");
            }
        }
    }

    public static void bookMaxPrice(ArrayList<Book> list) {
        double max = list.get(0).getPrice();
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPrice() > max) {
                max = list.get(i).getPrice();
                index = i;
            }
        }
        System.out.println(list.get(index));
    }

    public static void bookMinPrice(ArrayList<Book> list) {
        double min = list.get(0).getPrice();
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPrice() < min) {
                min = list.get(i).getPrice();
                index = i;
            }
        }
        System.out.println(list.get(index));
    }
}
