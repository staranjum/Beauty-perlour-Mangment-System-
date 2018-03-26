package dataclass.packages;

public class CosmicPackage extends StylePackage {

    public CosmicPackage(int id, String name, PackageType type, double cost) {
        super(id, name, type, cost);
    }

    public CosmicPackage(String name, PackageType type, double cost) {
        super(name, type, cost);
    }

    public CosmicPackage() {
    }

    @Override
    public String toString() {
        return "CosmicPackage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", cost=" + cost +
                '}';
    }
}
