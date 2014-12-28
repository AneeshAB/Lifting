import java.util.ArrayList;

/**
 * Created by aneesh on 12/27/14.
 */
public class Lift {
    private static final String DEFAULT_NAME = "Untitled";

    private ArrayList<Set> sets;

    private String name;

    // Constructors
    public Lift() {
        this.setSets(new ArrayList<Set>());
        this.setName(DEFAULT_NAME);
    }

    public Lift(ArrayList<Set> sets) {
        this.setSets(new ArrayList<Set>(sets));
        this.setName(DEFAULT_NAME);
    }

    public Lift(String name) {
        this.setSets(new ArrayList<Set>());
        this.setName(name);
    }

    public Lift(Lift lift) {
        this.setSets(new ArrayList<Set>(lift.getSets()));
        this.setName(lift.getName());
    }

    // Getters
    private ArrayList<Set> getSets() {
        return this.sets;
    }

    private String getName() {
        return this.name;
    }

    // Setters
    private void setSets(ArrayList<Set> sets) {
        this.sets = sets;
    }

    private void setName(String name) {
        this.name = name;
    }

    // Unique methods
    public void addSet(Set set) {
        this.getSets().add(set);
    }

    // Object Overrides
    @Override
    public String toString() {
        String returned = name + "\n" + "Reps" + "\t" + "Weight";
        for (Set s : this.getSets()) {
            returned += "\n" + s.toString();
        }
        return returned;
    }
}
