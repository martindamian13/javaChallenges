package Zoo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NewMain {
    public static void main(String[] args) {
        System.out.println("Hola amiwis");

        // Instanciamos el zoologico
        Zoo zoo = new Zoo();
        zoo.setName("Zoo de cde olo");

        String filePathAreas = "areas.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePathAreas))) {
            writer.write("Areas of the Zoo");
            List<String> areasOfTheZoo = new ArrayList<>();
            areasOfTheZoo.add("\nArea 1, 4");
            areasOfTheZoo.add("\nArea 2, 2");
            for (String areaOfTheZoo : areasOfTheZoo) {
                writer.write(areaOfTheZoo);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePathAreas))) {
            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] parts = line.split(", ");
                if (parts.length < 2) {
                    System.out.println("Error! One of the lines doesnt have enough data");
                    continue;
                }

                String name = parts[0];
                int capacity = Integer.parseInt(parts[1]);

                ZooArea area = new ZooArea(name, capacity);
                zoo.addArea(area);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: The file \"" + filePathAreas + "\" was not found.");
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        List<String> animalsInZoo = new ArrayList<>();

        animalsInZoo.add("Perro, Canino, Pastor aleman, Firulito, 2020");
        animalsInZoo.add("Gato, Felino, Egipcio, Arturo, 1940");
        animalsInZoo.add("Gato, Felino, Egipcio, Michi, 1890");
        animalsInZoo.add("Perro, Canino, Caniche, Lula, 2020");
        animalsInZoo.add("Caballo, Mammal, Persa, Tulio, 3000");
        animalsInZoo.add("Caballo, Mammal, Blanco, Rocinante, 400");

        List<ZooArea> areas = zoo.getAreas();
        if (areas.size() >= 2) {
            ZooArea area1 = areas.get(0);
            ZooArea area2 = areas.get(1);
            String filePathZoo = "zoo.txt";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePathZoo))) {
                writer.write("Animals of the zoo!");

                for (String animalInZoo : animalsInZoo) {
                    writer.write("\n" + animalInZoo);
                }
                System.out.println("Animal details successfully written to " + filePathZoo);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try (BufferedReader animalReader = new BufferedReader(new FileReader(filePathZoo))) {
                String line;
                boolean isFirstLine = true;
                int animalCount = 0;
                List<ZooArea> selectedAreas = zoo.getAreas(); // Get areas from the zoo

                while ((line = animalReader.readLine()) != null) {
                    if (isFirstLine) {
                        isFirstLine = false;
                        continue;
                    }

                    String[] parts = line.split(", ");
                    if (parts.length < 5) {
                        System.out.println("Error! One of the lines doesn't have enough data: " + line);
                        continue;
                    }

                    String animalType = parts[0];
                    String species = parts[1];
                    String breed = parts[2];
                    String name = parts[3];
                    int birthYear = Integer.parseInt(parts[4]);

                    if (!areas.isEmpty()) {

                        Animal animal;
                        switch (animalType) {
                            case "Perro":
                                animal = new Perro(species, breed, name, birthYear);
                                break;
                            case "Gato":
                                animal = new Gato(species, breed, name, birthYear);
                                break;
                            case "Caballo":
                                animal = new Caballo(species, breed, name, birthYear);
                                break;
                            default:
                                System.out.println("Unknown animal type: " + animalType);
                                continue;
                        }

                        if (animalCount < 3 && areas.size() > 0) {
                            areas.get(0).addAnimal(animal);
                        } else if (areas.size() > 1) {
                            areas.get(1).addAnimal(animal);
                        }

                        animalCount++;

                    }
                }
            } catch (FileNotFoundException e) {
                System.err.println("Error: The file \"" + filePathZoo + "\" was not found.");
            } catch (IOException e) {
                System.err.println("Error reading the file: " + e.getMessage());
            }


            // Imprimir el zoologico
            System.out.println("Zoologico: " + zoo.getName());
            System.out.println("Areas del zoologico:");
            for (ZooArea area : zoo.getAreas()) {
                System.out.println("Nombre del Area: " + area.getName() + " Capacidad: " + area.getCapacity() + " Animales en la zona:");
                for (Animal animal : area.getAnimals()) {
                    System.out.println("Nombre: " + animal.getName() + ". Especie: " + animal.getSpecie() + ". Raza: " + animal.getBreed() + ". Fecha de nacimiento: " + animal.getBirthYear());
                }
            }

            // Filtrar areas con menos de 3 animales
            System.out.println("Areas con menos de 3 animales:");
            List<ZooArea> filteredAreas = zoo.getAreas().stream()
                    .filter(zooArea -> zooArea.getAnimals().size() < 3)
                    .toList();

            for (ZooArea area : filteredAreas) {
                System.out.println("Area: " + area.getName());
                for (Animal animal : area.getAnimals()) {
                    System.out.println("Nombre: " + animal.getName() + ". Especie: " + animal.getSpecie() + ". Raza: " + animal.getBreed() + ". Fecha de nacimiento: " + animal.getBirthYear());
                }
            }
        }
    }
}
