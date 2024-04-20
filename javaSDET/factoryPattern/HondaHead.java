package factoryPattern;

public class HondaHead extends carFactory{
    public void viewCar(){
        System.out.println("View Honda Car");
    }
    public void driverCar(){
        System.out.println("Drive Honda Car");
    }
    public void bookCar(){
        System.out.println("Book Honda Car");
    }
}
