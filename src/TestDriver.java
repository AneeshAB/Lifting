/**
 * Created by aneesh on 12/27/14.
 */
public class TestDriver {
    public static void main(String[] args) {
        Workout w = new Workout();

        Lift l = new Lift("Bench Press");
        l.addSet(new Set(5, 135));
        l.addSet(new Set(5, 135));
        l.addSet(new Set(5, 135));

        Lift l2 = new Lift("Deadlift");
        l2.addSet(new Set(5, 225));

        Lift l3 = new Lift("Squat");
        l3.addSet(new Set(5, 165));

        w.addLift(l);
        w.addLift(l2);
        w.addLift(l3);

        System.out.println(w);
    }
}
