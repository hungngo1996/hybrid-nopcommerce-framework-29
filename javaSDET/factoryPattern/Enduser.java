package factoryPattern;

import commons.CarList;

public class Enduser {

    public static carFactory carfactory;
    public static void main(String[] args) {
        carfactory = getCar("huyndai");
        carfactory.viewCar();
        carfactory.bookCar();
        carfactory.driverCar();
    }

    public static carFactory getCar(String carName) {
        carFactory car = null;
        CarList carList = CarList.valueOf(carName.toUpperCase());
        switch (carList){
            case HONDA:
                car = new HondaHead();
                break;
            case HUYNDAI:
                car = new HuyndaiHead();
                break;
            case FORD:
                car = new FordHead();
                break;
            default:
                new RuntimeException("Car name is not valid");
        }
        return car;
    }

}
