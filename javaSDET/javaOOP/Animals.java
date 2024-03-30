package javaOOP;

public class Animals {
    private String animalName = "Lion";
    private int ageAnimal = 9;
    protected String getAnimalName(){ //Getter
    return this.animalName;
    }
    protected void setAnimalName(String animalName){ //Setter
            this.animalName = animalName;
    }
    protected int getAnimalAge(){
        return this.ageAnimal;
    }
    protected void setAgeAnimal(int ageAnimal){
        this.ageAnimal = ageAnimal;
    }
}
