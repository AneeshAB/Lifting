/**
 * Created by aneesh on 12/27/14.
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

public class Workout {
    private ArrayList<Lift> lifts;

    private Date date;

    // Testing
    public static void main(String[] args) {
        Workout w =  new Workout();
        Lift legPress = new Lift("Leg Press");
        legPress.addSet(new Set(5, 225));
        w.addLift(legPress);

        Lift pulldown = new Lift("Pulldown");
        pulldown.addSet(new Set(5, 150));
        w.addLift(pulldown);

        Lift overheadPress = new Lift("Overhead Press");
        overheadPress.addSet(new Set(5, 75));
        w.addLift(overheadPress);

        Lift machineRow = new Lift("Machine Row");
        machineRow.addSet(new Set(5, 140));
        w.addLift(machineRow);

        Lift benchPress = new Lift("Bench Press");
        benchPress.addSet(new Set(5, 120));
        w.addLift(benchPress);

        System.out.println(w);
    }

    // Constructors
    public Workout() {
        this(new Date());
    }


    public Workout(Date date) {
        this.setLifts(new ArrayList<Lift>());
        this.setDate(new Date(date.getTime()));
    }

    // Getters
    public ArrayList<Lift> getLifts() {
        return this.lifts;
    }

    private Date getDate() {
        return this.date;
    }

    public String getDateString() {
        return new SimpleDateFormat("YYYY-MM-DD").format(this.getDate());
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
