/**
 * Created by aneesh on 12/27/14.
 */
public class Set {
    private int numReps;
    private int weight;

    // Constructors
    public Set(int numReps, int weight) {
        this.numReps = numReps;
        this.weight = weight;
    }

    public Set(Set set) {
        this.setNumReps(set.getNumReps());
        this.setWeight(set.getWeight());
    }

    // Getters
    private int getNumReps() {
        return this.numReps;
    }

    private int getWeight() {
        return this.weight;
    }

    // Setters
    private void setNumReps(int numReps) {
        this.numReps = numReps;
    }

    private void setWeight(int weight) {
        this.weight = weight;
    }

    // Object Overrides
    @Override
    public String toString() {
        return this.getNumReps() + "\t\t" + this.getWeight();
    }
}
