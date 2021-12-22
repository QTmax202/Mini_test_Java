public class Person {
    private String name;
    private String date;
    private String idCard;


    public Person(String name, String date, String idCard) {
        this.name = name;
        this.date = date;
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return String.format("%-15s%-15s%-15s",name,date,idCard);
    }

}
