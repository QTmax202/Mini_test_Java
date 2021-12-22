import java.util.ArrayList;

public class Hotel extends Person{
    private int nameRoom;
    private int daysInHotel;
    private String kindOfRoom;
    private double roomRates;
//    private Person customers;
//
//    public Hotel(int nameRoom, int daysInHotel, String kindOfRoom, double roomRates, Person customers) {
//        this.nameRoom = nameRoom;
//        this.daysInHotel = daysInHotel;
//        this.kindOfRoom = kindOfRoom;
//        this.roomRates = roomRates;
//        this.customers = customers;
//    }

    public Hotel(String name, String date, String idCard, int nameRoom, int daysInHotel, String kindOfRoom, double roomRates) {
        super(name, date, idCard);
        this.nameRoom = nameRoom;
        this.daysInHotel = daysInHotel;
        this.kindOfRoom = kindOfRoom;
        this.roomRates = roomRates;
    }

    public int getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(int nameRoom) {
        this.nameRoom = nameRoom;
    }

    public int getDaysInHotel() {
        return daysInHotel;
    }

    public void setDaysInHotel(int daysInHotel) {
        this.daysInHotel = daysInHotel;
    }

    public String getKindOfRoom() {
        return kindOfRoom;
    }

    public void setKindOfRoom(String kindOfRoom) {
        this.kindOfRoom = kindOfRoom;
    }

    public double getRoomRates() {
        return roomRates;
    }

    public void setRoomRates(double roomRates) {
        this.roomRates = roomRates;
    }

//    public ArrayList<Person> getCustomers() {
//        return customers;
//    }
//
//    public void setCustomers(ArrayList<Person> customers) {
//        this.customers = customers;
//    }

    @Override
    public String toString() {
        return String.format("%-15s",nameRoom)+super.toString()+ String.format("%-15d%-15s%-15.2f",daysInHotel,kindOfRoom,roomRates);
    }
}
