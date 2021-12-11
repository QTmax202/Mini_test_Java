import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.Scanner;

public class ManagerBook {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Book> list = new ArrayList<Book>();
        ArrayList<ScienceBook> list1 = new ArrayList<ScienceBook>();
        ArrayList<Novel> list2 = new ArrayList<Novel>();
        choiceBook(input, list, list1, list2);
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

    public static void choiceBook(Scanner input, ArrayList<Book> list, ArrayList<ScienceBook> list1, ArrayList<Novel> list2) {
        int choice = -1;
        double sum = 0;
        while (choice != 0) {
            System.out.println("1. Sách thường");
            System.out.println("2. Sách khoa học");
            System.out.println("3. Sách tiểu thuyết");
            System.out.println("4. Hiển thị tất cả quyển sách");
            System.out.println("5. Hiển thị tổng giá tiền tất cả sách");
            System.out.println("6. Hiển thị sách có giá tiền cao nhất");
            System.out.println("7. Hiển thị sách có giá tiền thấp nhất");
            System.out.println("8. Hiển thị tất cả các quyển sách theo thể loại");
            System.out.println("9. Hiển thị tất cả các quyển sách theo tác giả");
            System.out.println("10. Hiển thị đơn giá trung bình của sách khoa học");
            System.out.println("11. Hiển thị tất cả các quyển sách trong khoảng giá");
            System.out.println("12. Hiển thị tất cả các quyển sách thuộc sách khoa học");
            System.out.println("13. Hiển thị tất cả các quyển sách thuộc sách tiểu thuyết");
            System.out.println("14. Hiển thị tất cả các quyển sách có giá tiền bẳng");
            System.out.println("0. Exit");
            System.out.print("In choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    Book str = createBook(input);
                    list.add(str);
                    break;
                case 2:
                    ScienceBook str1 = createScienceBook(input);
                    list.add(str1);
                    list1.add(str1);
                    break;
                case 3:
                    Novel str2 = createNovel(input);
                    list.add(str2);
                    list2.add(str2);
                    break;
                case 4:
                    allBook(list);
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
                case 8:
                    findBooksByGenre(input, list1);
                    break;
                case 9:
                    findBooksByAuthor(input, list2);
                    break;
                case 10:
                    avgPriceScienceBook(list1);
                    break;
                case 11:
                    fundOfBook(input, list);
                    break;
                case 12:
                    allScienceBooks(list1);
                    break;
                case 13:
                    allNovel(list2);
                    break;
                case 14:
                    moneyOfBook(input,list);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Sai kiểu sách!");
            }
        }
    }

    public static void bookMaxPrice (ArrayList<Book> list) {
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

    public static void bookMinPrice (ArrayList<Book> list) {
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

    public static void allBook (ArrayList<Book> list) {
        ListIterator<Book> iterator = list.listIterator();
        while (iterator.hasNext()) {
            System.out.println((Book) iterator.next());
        }
    }

    public static void findBooksByGenre (Scanner scanner, ArrayList<ScienceBook> list1) {
        scanner.nextLine();
        System.out.print("Thể loại cần tìm: ");
        String str = scanner.nextLine();
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).getCategory().equals(str)) {
                System.out.println(list1.get(i));
            }
        }
    }

    public static void findBooksByAuthor (Scanner scanner, ArrayList<Novel> list2) {
        scanner.nextLine();
        System.out.print("Tác giả cần tìm: ");
        String str1 = scanner.nextLine();
        for (int i = 0; i < list2.size(); i++) {
            if (list2.get(i).getAuthor().equals(str1)) {
                System.out.println(list2.get(i));
            }
        }
    }

    public static void avgPriceScienceBook (ArrayList<ScienceBook> list1) {
        double sum = 0.0;
        for (int i = 0; i < list1.size(); i++) {
            sum += list1.get(i).getPrice();
        }
        System.out.printf("Đơn giá trung bình của sách khoa học: %.2f", sum / list1.size());
        System.out.println();
    }

    public static void allScienceBooks (ArrayList<ScienceBook> list1){
        ListIterator<ScienceBook> iterator1 = list1.listIterator();
        while (iterator1.hasNext()) {
            System.out.println((ScienceBook) iterator1.next());
        }
    }

    public static void allNovel (ArrayList<Novel> list2){
        ListIterator<Novel> iterator2 = list2.listIterator();
        while (iterator2.hasNext()) {
            System.out.println((Novel) iterator2.next());
        }
    }

    public static void moneyOfBook (Scanner input, ArrayList<Book> list){
        System.out.print("các quyển sách có giá tiền bẳng: ");
        double price = input.nextDouble();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPrice() == price) {
                System.out.println(list.get(i));
            }
        }
    }

    public static void fundOfBook (Scanner input , ArrayList<Book> list){
        System.out.print("Giá min: ");
        double price1 = input.nextDouble();
        System.out.print("Giá max: ");
        double price2 = input.nextDouble();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPrice() >= price1 && list.get(i).getPrice() <= price2) {
                System.out.println(list.get(i));
            }
        }
    }
}