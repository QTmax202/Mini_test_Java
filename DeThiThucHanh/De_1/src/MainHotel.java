import java.util.Scanner;

public class MainHotel {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ManageHotel manageHotel =new ManageHotel();
        int choice;
        do {
            System.out.println("Menu");
            System.out.println("1. Hiển thị thông tin khách hàng");
            System.out.println("2. Nhập thông tin khách hàng");
            System.out.println("3. Nhập thông tin nhiều khách hàng");
            System.out.println("4. Xóa thông tin khách hàng theo CMND");
            System.out.println("5. Hiển thị thông tin khách hàng theo loại phòng");
            System.out.println("6. Hiển thị số tiền cần phải trả khi khách trả phòng theo CMND");
//            System.out.println("7. Sửa thông tin khách hàng theo CMND");
            System.out.println("0. Thoát menu");
            System.out.print("Nhập lựa chọn: ");
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    manageHotel.displayCustomer();
                    break;
                case 2:
                    manageHotel.addCustomer();
                    break;
                case 3:
                    System.out.print("số khách hàng cần nhập thông tin: ");
                    int count = input.nextInt();
                    for (int i = 0; i < count; i++) {
                        manageHotel.addCustomer();
                        System.out.println("---");
                    }
                    break;
                case 4:
                    manageHotel.deleteCustomerByCMND();
                    break;
                case 5:
                    manageHotel.displayCustomerByKindOfRoom();
                    break;
                case 6:
                    manageHotel.displayPriceByCMND();
                    break;
                case 7:
//                    manageHotel.fixCustomerByCMND();
                    break;
            }
        } while (choice != 0);
    }
}
