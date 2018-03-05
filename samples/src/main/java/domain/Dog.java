package domain;

public class Dog extends Pet{
    public Dog(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Dog{}" + super.toString();
    }
}
