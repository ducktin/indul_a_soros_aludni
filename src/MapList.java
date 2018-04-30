public class MapList {
    public static String[] options = {
            "Two player maps:\n1. The One And Only",
            "2. Normal, Some Crates, Some GoalFields",
            "3. Normal but Traps and Holes",
            "4. Normal Some Crates, Some GoalFields part 2",
            "5. asd",
            "6. asd",
            "7. asd",
            "8. Falling into the Void",
            "9. Falling into the Void",
            "10. Wall of Death",
            "3 Player maps:\n11. The One And Only",
            "12. Normal, Some Crates, Some GoalFields",
            "13. Normal, but Traps and Holes",
            "14. Normal, Some Crates, Some GoalField part 2"
    };

    public static void printOptions() {
        for (int i = 0; i < MapList.options.length; i++) {
            System.out.println(MapList.options[i]);
        }
    }

}
