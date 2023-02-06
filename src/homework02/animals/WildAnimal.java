package homework02.animals;

import java.time.LocalDate;

public abstract class WildAnimal extends Animal {
    private final String habitat;
    private final LocalDate findingDate;

    protected WildAnimal(int height, int weight, String eyeColor, String habitat, LocalDate findingDate) {
        super(height, weight, eyeColor);
        this.habitat = habitat;
        this.findingDate = findingDate;
    }

    public String getHabitat() {
        return habitat;
    }

    public LocalDate getFindingDate() {
        return findingDate;
    }

    @Override
    public String getInfo() {
        return String.format("%s, habitat: %s, finding date: %s",
                super.getInfo(), habitat, findingDate.format(dateFormatter));
    }
}
