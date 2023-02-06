package homework02;

import homework02.animals.Animal;
import homework02.animals.Bird;
import homework02.animals.Dog;
import homework02.animals.DomesticAnimal;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private List<Animal> animals;

    public Zoo() {
        this.animals = new ArrayList<Animal>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    private boolean noSuchIndex(int index) {
        if (index > animals.size() - 1) {
            System.out.println("No such index: " + index);
            return true;
        }
        return false;
    }

    public void removeAnimal(int index) {
        if (noSuchIndex(index)) {
            return;
        }
        animals.remove(index);
    }

    public String getAnimalInfo(int index) {
        if (noSuchIndex(index)) {
            return "";
        }
        return animals.get(index).getInfo();
    }

    public void animalMakeSound(int index) {
        if (noSuchIndex(index)) {
            return;
        }
        animals.get(index).makeSound();
    }

    public void animalFly(int index) {
        if (noSuchIndex(index)) {
            return;
        }
        Animal animal = animals.get(index);
        if (animal instanceof Bird) {
            ((Bird) animal).fly();
        } else {
            System.out.printf("%s is not a bird.%n", animal.getClass().getSimpleName());
        }
    }

    public void animalFawn(int index) {
        if (noSuchIndex(index)) {
            return;
        }
        Animal animal = animals.get(index);
        if (animal instanceof DomesticAnimal) {
            ((DomesticAnimal) animal).fawn();
        } else {
            System.out.printf("%s is not a domestic animal.%n", animal.getClass().getSimpleName());
        }
    }

    public void animalTrain(int index) {
        if (noSuchIndex(index)) {
            return;
        }
        Animal animal = animals.get(index);
        if (animal instanceof Dog) {
            ((Dog) animal).train();
        } else {
            System.out.printf("%s is not a dog.%n", animal.getClass().getSimpleName());
        }
    }

    public void printAllAnimalsInfo() {
        if (animals.isEmpty()) {
            System.out.println("The zoo is empty.");
            return;
        }
        int i = 0;
        for (Animal animal : animals) {
            System.out.printf("%d: ", i++);
            System.out.println(animal);
        }
    }

    public void allAnimalsMakeSound() {
        if (animals.isEmpty()) {
            System.out.println("The zoo is empty.");
            return;
        }
        for (Animal animal : animals) {
            animal.makeSound();
        }
    }
}
