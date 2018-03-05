package domain;

public class Cat extends Pet {
    public Cat(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Cat{}" + super.toString();
    }
}
