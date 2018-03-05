package queue;

import domain.Cat;
import domain.Dog;
import domain.Pet;

import java.util.LinkedList;

public class PetQueue {
    private LinkedList<Cat> cats = new LinkedList<>();
    private LinkedList<Dog> dogs = new LinkedList<>();
    private LinkedList<Pet> pets = new LinkedList<>();

    public void add(Pet pet) {
        pets.add(pet);
        if (pet instanceof Cat) {
            cats.add((Cat)pet);
        } else if (pet instanceof Dog) {
            dogs.add((Dog) pet);
        }

    }

    public Pet removeFirst() {
        Pet pet = pets.removeFirst();
        if (pet instanceof Cat) {
            cats.removeFirstOccurrence(pet);
        }
        if (pet instanceof Dog) {
            dogs.removeFirstOccurrence(pet);
        }
        return pet;
    }

    public Cat removeFirstCat() {
        Cat cat = cats.removeFirst();
        pets.removeFirstOccurrence(cat);
        return cat;
    }

    public Dog removeFirstDog() {
        Dog dog = dogs.removeFirst();
        pets.removeFirstOccurrence(dog);
        return dog;
    }

}


