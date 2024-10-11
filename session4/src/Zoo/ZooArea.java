package Zoo;

import java.util.ArrayList;
import java.util.List;

public class ZooArea {
    private String name;
    private int capacity;
    private List<Animal> animals;

    public ZooArea(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.animals = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public List<Animal> getAnimals() {
        return this.animals;
    }

    public void addAnimal(Animal animal) {
        if (this.animals.size() < this.capacity) {
            this.animals.add(animal);
        } else {
            System.out.println("No se puede agregar más animales en la zona "+ this.name);
        }
    }

}

