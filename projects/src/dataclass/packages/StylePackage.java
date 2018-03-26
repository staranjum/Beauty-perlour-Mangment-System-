package dataclass.packages;

public class StylePackage {

    protected int id;
    protected String name;
    protected PackageType type;
    protected double cost;

    public StylePackage(int id, String name, PackageType type, double cost) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.cost = cost;
    }

    public StylePackage(String name, PackageType type, double cost) {
        this.name = name;
        this.type = type;
        this.cost = cost;
    }

    public StylePackage() {

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

    public PackageType getType() {
        return type;
    }

    public void setType(PackageType type) {
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "StylePackage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", cost=" + cost +
                '}';
    }
}
