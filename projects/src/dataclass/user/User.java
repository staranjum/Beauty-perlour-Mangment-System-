package dataclass.user;

public class User {

    private int id;
    private String name;
    private String phone;
    private String address;
    private long visitedDate;

    public User(int id, String name, String phone, String address, long visitedDate) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.visitedDate = visitedDate;
    }

    public User(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public User(){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getVisitedDate() {
        return visitedDate;
    }

    public void setVisitedDate(long visitedDate) {
        this.visitedDate = visitedDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", visitedDate=" + visitedDate +
                '}';
    }
}
