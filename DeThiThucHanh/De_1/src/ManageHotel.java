import java.util.ArrayList;
import java.util.Scanner;

public class ManageHotel {
    public static ArrayList<Person> customers;
//    public static ArrayList<Hotel> customersOfHotel;
    Scanner input = new Scanner(System.in);

    public ManageHotel() {
        customers = new ArrayList<>();
//        customersOfHotel = new ArrayList<>();
    }


//    public Person createCustomer(Scanner input) {
//        input.nextLine();
//        System.out.print("Nhập tên khách hàng: ");
//        String name = input.nextLine();
//        System.out.print("Nhập ngày sinh khách hàng: ");
//        String date = input.nextLine();
//        System.out.print("Nhập CMND khách hàng: ");
//        input.nextLine();
//        String id = input.nextLine();
//        id = checkCMND(id, input);
//        return new Person(name, date, id);
//    }

//    public Person createCustomerOfHotel(Scanner input) {
//        System.out.print("Nhập tên phòng: ");
//        int nameRoom = input.nextInt();
//        System.out.print("Nhập số ngày ở: ");
//        int daysInHotel = input.nextInt();
//        input.nextLine();
//        System.out.print("Nhập loại phòng: ");
//        String kindOfRoom = input.nextLine();
//        System.out.print("Nhập giá phòng: ");
//        double roomRates = input.nextDouble();
//        System.out.print("Nhập CMND khách hàng thuê phòng: ");
//        input.nextLine();
//        String id = input.nextLine();
//        for (int i = 0; i < customers.size(); i++) {
//            if (customers.get(i).getIdCard().equals(id)){
//                Person customer = customers.get(i);
//                return new Hotel(nameRoom, daysInHotel, kindOfRoom, roomRates, customer);
//            }
//        }
//        return null;
//    }

    public Person createCustomer(Scanner input) {
        input.nextLine();
        System.out.print("Nhập tên khách hàng: ");
        String name = input.nextLine();
        System.out.print("Nhập ngày sinh khách hàng: ");
        String date = input.nextLine();
        System.out.print("Nhập CMND khách hàng: ");
        input.nextLine();
        String id = input.nextLine();
        id = checkCMND(id, input);
        System.out.print("Nhập tên phòng: ");
        int nameRoom = input.nextInt();
        System.out.print("Nhập số ngày ở: ");
        int daysInHotel = input.nextInt();
        input.nextLine();
        System.out.print("Nhập loại phòng: ");
        String kindOfRoom = input.nextLine();
        System.out.print("Nhập giá phòng: ");
        double roomRates = input.nextDouble();
        return new Hotel(name, date, id, nameRoom, daysInHotel, kindOfRoom, roomRates);
    }

    public static String checkCMND(String idCad, Scanner input) {
        for (Person customer : customers) {
            while (customer.getIdCard().equals(idCad)) {
                System.out.print("CMND bị trùng, nhập lại CMND: ");
                idCad = input.nextLine();
            }
        }
        return idCad;
    }

    public void addCustomer() {
        customers.add(createCustomer(input));
    }

//    public void addCustomerOfHotel() {customersOfHotel.add(createCustomerOfHotel(input));}

    public void displayCustomer() {
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s", "Tên phòng", "Tên KH", "Ngày sinh KH", "CMND KH", "Số ngày ở", "Loại phòng", "Giá phòng");
        System.out.println();
        for (Person customer : customers) {
            System.out.println(customer);
        }
    }

    public void deleteCustomerByCMND() {
        input.nextLine();
        System.out.print("Nhập CMND khách hàng muốn xóa: ");
        String customerId = input.nextLine();
        customers.removeIf(customer -> customer.getIdCard().equals(customerId));
    }

    public void displayCustomerByKindOfRoom() {
        input.nextLine();
        System.out.print("Nhập loại phòng cần hiển thị: ");
        String kindOfRoom1 = input.nextLine();
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s", "Tên phòng", "Tên KH", "Ngày sinh KH", "CMND KH", "Số ngày ở", "Loại phòng", "Giá phòng");
        for (Person customer : customers) {
            Hotel customer1 = (Hotel) customer;
            if (customer1.getKindOfRoom().equals(kindOfRoom1)) {
                System.out.println(customer);
            }
        }
    }

    public void displayPriceByCMND() {
        input.nextLine();
        System.out.print("Nhập CMND khách hàng cần tính tiền: ");
        String id1 = input.nextLine();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getIdCard().equals(id1)){
                Hotel customer2 = (Hotel) customers.get(i);
                System.out.printf("Số tiền cần phải trả là: %5.2f", (customer2.getDaysInHotel() * customer2.getRoomRates()));
                System.out.println();
                customers.remove(i);
            }
        }
    }

//    public void fixCustomerByCMND() {
//        input.nextLine();
//        System.out.print("Nhập CMND khách hàng cần sửa: ");
//        String id2 = input.nextLoine();
//        for (Hotel customer3 : customersOfHotel) {
//            if (customer.getIdCard().equals(id2)) {
//                input.nextLine();
//                System.out.print("Nhập lại tên khách hàng: ");
//                customer3.setName(input.nextLine());
//                System.out.print("Nhập lại ngày sinh khách hàng: ");
//                customer3.setDate(input.nextLine());
//                System.out.print("Nhập lại CMND khách hàng: ");
//                String idCad1 = input.nextLine();
//                if (idCad1.equals("")){
//                    customer3.setIdCard(customer.getIdCard());
//                } else {
//                    customer3.setIdCard(idCad1);
//                }
//                System.out.print("Nhập lại tên phòng: ");
//                customer3.setNameRoom(input.nextInt());
//                System.out.print("Nhập lại số ngày ở: ");
//                customer3.setDaysInHotel(input.nextInt());
//                input.nextLine();
//                System.out.print("Nhập lại loại phòng: ");
//                customer3.setKindOfRoom(input.nextLine());
//                System.out.print("Nhập lại giá phòng: ");
//                customer3.setRoomRates(input.nextDouble());
//            }
//        }
//    }
}
