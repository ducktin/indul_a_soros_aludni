import java.util.Scanner;

public class Prototype {
    public static String[] options = {
            "1 Worker Moves to Empty Field",
            "2 Worker Moves towards Wall",
            "3 Worker Moves into Hole",
            "4 Worker Moves onto Switch",
            "5 Worker Moves onto GoalField",
            "6 Worker Pushes Crate to Empty Field",
            "7 Worker Pushes two Crates to an Empty Field, if he's strong enough",
            "8 Worker Pushes two Crates to an Empty Field, if he isn't strong enough",
            "9 Worker Pushes Crate to a Hole",
            "10 Worker Pushes Crate to Wall",
            "11 Worker Pushes Crate on a Switch",
            "12 Worker Pushes Crate onto a GoalField, the pushes it one more time",
            "13 Worker Pushes Worker to an Empty Field",
            "14 Worker Pushes Crate on Oily field, crate is heavier than worker's strength, but oil is helping",
            "15 Worker Pushes Crate on Honey field, crate is lighter than worker's strength, but honey is sticky"
    };

    public static void printOptions() {
        for (int i = 0; i < Prototype.options.length; i++) {
            // String index = String.valueOf(i + 1) + ". ";
            System.out.println(Prototype.options[i]);
        }
    }

}
