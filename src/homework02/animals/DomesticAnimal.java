package homework02.animals;

import java.time.LocalDate;

public abstract class DomesticAnimal extends Animal {
    private final String breed;
    private final String hairColor;
    private final LocalDate birthdate;
    private String name;
    private boolean vaccinated;

    protected DomesticAnimal(int height, int weight, String eyeColor, String name, String breed, boolean vaccinated,
                             String hairColor, LocalDate birthdate) {
        super(height, weight, eyeColor);
        this.name = name;
        this.breed = breed;
        this.vaccinated = vaccinated;
        this.hairColor = hairColor;
        this.birthdate = birthdate;
    }

    public abstract void fawn();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public String getHairColor() {
        return hairColor;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    @Override
    public String getInfo() {
        return String.format("%s, name: %s, breed: %s, vaccinated: %s, hair color: %s, birthdate: %s", super.getInfo(),
                name, breed, vaccinated ? "yes" : "no", hairColor, birthdate.format(dateFormatter));
    }
}
