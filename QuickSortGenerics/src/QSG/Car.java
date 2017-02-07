package QSG;

public class Car implements Comparable<Car> {

    private String name;
    private int fuelTankSize;

    public Car(String name, int fuelTankSize) {
        this.name = name;
        this.fuelTankSize = fuelTankSize;
    }

    public int getFuelTankSize() {
        return fuelTankSize;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", fuelTankSize=" + fuelTankSize +
                '}';
    }

    @Override
    public int compareTo(Car o) {
        if (this.fuelTankSize > o.getFuelTankSize()) {
            return -1;
        } else if (this.fuelTankSize == o.getFuelTankSize()) {
            return 0;
        } else {
            return 1;
        }
    }
}
