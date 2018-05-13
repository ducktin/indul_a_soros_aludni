package model;

public class MapList {
    public static String[] options = {
            "The One And Only /2Player",
            "Normal, Some Crates, Some GoalFields /2Player",
            "Normal but Traps and Holes /2Player",
            "Normal Some Crates, Some GoalFields part 2 /2Player",
            "asd/2Player",
            "asd/2Player",
            "asd/2Player",
            "Falling into the Void /2Player",
            "Falling into the Void /2Player",
            "Wall of Death /2Player",
            "The One And Only /3Player",
            "Normal, Some Crates, Some GoalFields /2Player",
            "Normal, but Traps and Holes /2Player",
            "Normal, Some Crates, Some model.GoalField part 2 /2Player"
    };
    
    public static void printOptions() {
        for (int i = 0; i < MapList.options.length; i++) {
            System.out.println(MapList.options[i]);
        }
    }
    
}
