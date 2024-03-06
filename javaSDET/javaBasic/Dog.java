package javaBasic;

public class Dog extends Annimal{

    String annimalName; //Biến Global


    public void getName(String annimalName){// Biến Local
        this.annimalName = annimalName;
    }
    public Dog(String Annimal){
        super(Annimal); //gọi tới constructor của lớp cha Annimal
        System.out.println("AA");
    }
    @Override
    public void sleep() {
        System.out.println("Sleeping...");
    }
    // Thể hiện tính chất kế thừa trong OOP (Inheritance)

}
