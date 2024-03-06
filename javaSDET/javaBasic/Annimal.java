package javaBasic;

public abstract class Annimal {
    //Constructor
    public Annimal(String annimalName){
        System.out.println("Annimal running...");
    }

    // Thể hiện tính chất trừu tượng trong OOP (Abstaction)
    public abstract void sleep();

    public void eat(){
        // Có phần thân (body)
        System.out.println("Eating...");
    }

}
