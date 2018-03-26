package dataclass.packages;

public class MakeOverPackage extends StylePackage {

    public MakeOverPackage(int id, String name, PackageType type, double cost) {
        super(id, name, type, cost);
    }

    public MakeOverPackage(String name, PackageType type, double cost) {
        super(name, type, cost);
    }

    public MakeOverPackage() {
    }

    @Override
    public String toString() {
        return "MakeOverPackage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", cost=" + cost +
                '}';
    }
}
