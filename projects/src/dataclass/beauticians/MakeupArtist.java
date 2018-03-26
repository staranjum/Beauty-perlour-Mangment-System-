package dataclass.beauticians;

public class MakeupArtist extends Beauticians {

    public MakeupArtist(int id, String name, String phone, String email, double salary, BeauticianCatogory catogory, Shift shift) {
        super(id, name, phone, email, salary, catogory, shift);
    }

    public MakeupArtist(String name, String phone, String email, double salary, BeauticianCatogory catogory, Shift shift) {
        super(name, phone, email, salary, catogory, shift);
    }

    public MakeupArtist() {
    }

    @Override
    public String toString() {
        return "MakeupArtist{" +
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
