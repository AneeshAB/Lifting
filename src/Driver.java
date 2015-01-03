/**
 * Created by aneesh on 12/27/14.
 */

import java.io.Console;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Driver {
    public static void main(String[] args) {
        Console console = System.console();
        Date workoutDate = null;

        // Get the workout date from the user
        while (workoutDate == null) {
            String dateString = console.readLine("Workout date in form MM-dd-yy (Blank for today): ");
            if (dateString.equals("")) {
                workoutDate = new Date();
                break;
            }

            try {
                SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yy");
                workoutDate = formatter.parse(dateString);
            }
            catch (ParseException e) { }
        }

        Workout workout = new Workout(workoutDate);
        // Lift / Set loop
        String liftName = "";
        for (int i = 0; true; i++) {
            liftName = console.readLine("Enter lift name (q to exit): ");
            if (liftName.equals("q")) {
                break;
            }

            if (liftName.equals("")) {
                continue;
            }

            workout.addLift(new Lift(liftName));

            // Set loop
            String setString = "";
            for (int j = 0; true; j++) {
                setString = console.readLine("Enter set data in form reps weight (q to exit): ");
                if (setString.equals("q")) {
                    break;
                }

                if (setString.indexOf(" ") == -1) {
                    System.out.println("Invalid input");
                    continue;
                }

                try {
                    int numReps = Integer.parseInt(setString.substring(0, setString.indexOf(" ")));
                    int weight = Integer.parseInt(setString.substring(setString.indexOf(" ") + 1));
                    workout.getLifts().get(i).addSet(new Set(numReps, weight));
                }
                catch (NumberFormatException e) {
                    System.out.println("Invalid input");
                }
            }
        }

        System.out.println(workout);
    }
}