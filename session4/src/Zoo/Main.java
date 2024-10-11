package Zoo;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hola amiwis");

        // Instanciamos el zoologico
        Zoo zoo = new Zoo();
        zoo.setName("Zoo de cde olo");

        // Instanciamos las areas del zoologico
        ZooArea area1 = new ZooArea("Area 1", 4);
        ZooArea area2 = new ZooArea("Area 2", 2);

        // Agregamos las areas al zoologico
        zoo.addArea(area1);
        zoo.addArea(area2);

        // Instanciamos los animales
        Animal perro1 = new Perro("Canino", "Pastor aleman ponele", "Firulito", 2020);
        Animal gato1 = new Gato("Felino","Egipcio","Arturo", 1940);
        Animal gato2 = new Gato("Felino","Egipcio","Michi", 1890);
        Animal perro2 = new Perro("Canino", "Caniche", "Lula", 2020);
        Animal caballo1 = new Caballo("Mammal","Persa","Tulio",3000);
        Animal caballo2 = new Caballo("Mammal","Blanco","Rocinante",400);

        // Agregar animales a las areas
        area1.addAnimal(perro1);
        area1.addAnimal(gato1);
        area1.addAnimal(caballo2);
        area2.addAnimal(caballo1);
        area2.addAnimal(gato2);
        area2.addAnimal(perro2);

        // Imprimir el zoologico
        System.out.println("Zoologico: " + zoo.getName());
        System.out.println("Areas del zoologico:");
        for (ZooArea area : zoo.getAreas()) {
            System.out.println("Area: " + area.getName() + " Capacidad: " + area.getCapacity()+ " Animales en la zona:");
            for (Animal animal : area.getAnimals()) {
                System.out.println("Nombre: " + animal.getName() + ". Especie: " + animal.getSpecie() + ". Raza: " + animal.getBreed() + ". Fecha de nacimiento: " + animal.getBirthYear());
            }
        }


        // Filtrar areas con menos de 3 animales
        System.out.println("Areas con menos de 3 animales:");
        List<ZooArea> filteredAreas = zoo.getAreas().stream()
                .filter(zooArea -> zooArea.getCapacity() < 3).toList();

        for (ZooArea area: filteredAreas){
            for (Animal animal : area.getAnimals()){
                System.out.println("Nombre: " + animal.getName() + ". Especie: " + animal.getSpecie() + ". Raza: " + animal.getBreed() + ". Fecha de nacimiento: " + animal.getBirthYear());
            }
        }
    }
}
