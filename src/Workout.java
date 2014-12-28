import java.util.Date;
import java.util.ArrayList;

/**
 * Created by aneesh on 12/27/14.
 */
public class Workout {
    private ArrayList<Lift> lifts;

    private Date date;

    // Constructors
    public Workout() {
        this.setLifts(new ArrayList<Lift>());
        this.setDate(new Date());
    }

    public Workout(ArrayList<Lift> lifts) {
        this.setLifts(new ArrayList<Lift>(lifts));
        this.setDate(new Date());
    }

    public Workout(Date date) {
        this.setLifts(new ArrayList<Lift>());
        this.setDate(new Date(date.getTime()));
    }

    public Workout(Workout workout) {
        this.setLifts(new ArrayList<Lift>(workout.getLifts()));
        this.setDate(new Date(workout.getDate().getTime()));
    }

    // Getters
    private ArrayList<Lift> getLifts() {
        return this.lifts;
    }

    private Date getDate() {
        return this.date;
    }

    // Setters
    private void setLifts(ArrayList<Lift> lifts) {
        this.lifts = lifts;
    }

    private void setDate(Date date) {
        this.date = date;
    }

    // Unique methods
    public void addLift(Lift lift) {
        this.getLifts().add(lift);
    }

    // Object Overrides
    @Override
    public String toString() {
        String returned = this.getDate().toString();
        for (int i = 0; i < this.getLifts().size(); i++) {
            if (i  == 0) {
                returned += "\n" + this.getLifts().get(0).toString();
            }
            else {
                returned += "\n\n" + this.getLifts().get(i).toString();
            }
        }
        return returned;
    }
}
