package dataclass.beauticians;

public class Beauticians {

    protected int id;
    protected String name;
    protected String phone;
    protected String email;
    protected double salary;
    protected BeauticianCatogory catogory;
    protected Shift shift;

    public Beauticians(int id, String name, String phone, String email, double salary, BeauticianCatogory catogory, Shift shift) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.salary = salary;
        this.catogory = catogory;
        this.shift = shift;
    }

    public Beauticians(String name, String phone, String email, double salary, BeauticianCatogory catogory, Shift shift) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.salary = salary;
        this.catogory = catogory;
        this.shift = shift;
    }

    public Beauticians() {

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public BeauticianCatogory getCatogory() {
        return catogory;
    }

    public void setCatogory(BeauticianCatogory catogory) {
        this.catogory = catogory;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    @Override
    public String toString() {
        return "Beauticians{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", catogory=" + catogory +
                ", shift=" + shift +
                '}';
    }
}
