package model;

public class MapList {
    public static String[] options = {
            "The One And Only /2Player",
            "Normal, Some Crates, Some GoalFields /2Player",
            "Normal but Traps and Holes /2Player",
            "BUY DLC: Normal Some Crates, Some GoalFields part 2 /2Player",
            "N/A/2Player",
            "N/A/2Player",
            "N/A/2Player",
            "BUY DLC: Falling into the Void /2Player",
            "BUY DLC: Falling into the Void /2Player",
            "BUY DLC: Wall of Death /2Player",
            "BUY DLC: The One And Only /3Player",
            "BUY DLC: Normal, Some Crates, Some GoalFields /2Player",
            "BUY DLC: Normal, but Traps and Holes /2Player",
            "BUY DLC: Normal, Some Crates, Some model.GoalField part 2 /2Player"
    };
    
    public static void printOptions() {
        for (int i = 0; i < MapList.options.length; i++) {
            System.out.println(MapList.options[i]);
        }
    }
    
}
