package javaOOP;

import java.util.Arrays;

public class Dog extends Animals {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.setAnimalName("Husky");
        dog.setAgeAnimal(9);
        System.out.println(dog.getAnimalName());
        System.out.println(dog.getAnimalAge());
    }
}
