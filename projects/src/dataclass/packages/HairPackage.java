package dataclass.packages;

public class HairPackage extends StylePackage {

    public HairPackage(int id, String name, PackageType type, double cost) {
        super(id, name, type, cost);
    }

    public HairPackage(String name, PackageType type, double cost) {
        super(name, type, cost);
    }

    public HairPackage() {
    }

    @Override
    public String toString() {
        return "HairPackage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", cost=" + cost +
                '}';
    }
}
