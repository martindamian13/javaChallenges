package Zoo;

public class Perro implements Animal {
    private String specie;
    private String breed;
    private String name;
    private int birthYear;

    public Perro(String specie, String breed, String name, int birthYear){
        this.specie = specie;
        this.breed = breed;
        this.name = name;
        this.birthYear= birthYear;
    }

    @Override
    public String getBreed() {
        return this.breed;
    }

    @Override
    public int getBirthYear() {
        return this.birthYear;
    }

    @Override
    public String getSpecie() {
        return this.specie;
    }
    @Override
    public String getName(){
        return this.name;
    }
}
