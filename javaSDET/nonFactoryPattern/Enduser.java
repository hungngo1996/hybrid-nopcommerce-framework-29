package nonFactoryPattern;

public class Enduser {
    public static void main(String[] args) {
        HondaHead honda = new HondaHead();

        honda.viewCar();
        honda.bookCar();
        honda.driverCar();
    }

}
