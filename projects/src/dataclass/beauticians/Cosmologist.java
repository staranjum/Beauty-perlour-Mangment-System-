package dataclass.beauticians;

public class Cosmologist extends Beauticians {

    public Cosmologist(int id, String name, String phone, String email, double salary, BeauticianCatogory catogory, Shift shift) {
        super(id, name, phone, email, salary, catogory, shift);
    }

    public Cosmologist(String name, String phone, String email, double salary, BeauticianCatogory catogory, Shift shift) {
        super(name, phone, email, salary, catogory, shift);
    }

    public Cosmologist() {
    }

    @Override
    public String toString() {
        return "Cosmologist{" +
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
