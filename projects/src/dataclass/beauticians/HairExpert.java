package dataclass.beauticians;

public class HairExpert extends Beauticians {

    public HairExpert(int id, String name, String phone, String email, double salary, BeauticianCatogory catogory, Shift shift) {
        super(id, name, phone, email, salary, catogory, shift);
    }

    public HairExpert(String name, String phone, String email, double salary, BeauticianCatogory catogory, Shift shift) {
        super(name, phone, email, salary, catogory, shift);
    }

    public HairExpert() {
    }

    @Override
    public String toString() {
        return "HairExpert{" +
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
