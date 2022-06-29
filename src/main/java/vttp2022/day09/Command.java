package vttp2022.day09;

import java.util.Arrays;
import java.util.List;

// This is to try out the logic 

public class Command {

    public static void main(String[] args) {


        // This is to build the dot 
        String[][] box = new String[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j =0; j < 5; j++) {
                box[i][j] = ".";
                System.out.print(box[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        int startX = 1;
        int startY = 1;

        String[][] astericks = {{"*"}, {"*", "*"}, {"*"}};

        // This is to edit the dot to astericks
        for (int i = startX; i <= astericks.length; i++) {
            for (int j = startY; j <= astericks[i-1].length; j++) {
                if (astericks[i-1] != null) {
                    box[i][j] = astericks[i-1][j-1];
                } 
                
            }
        }
        
        // To print out the edited astericks
        for (int i = 0; i < 5; i++) {
            for (int j =0; j < 5; j++) {
                System.out.print(box[i][j]);
            }
            System.out.println();
        }

        // List<String> myList = Arrays.asList("*", "**", "*");
        // System.out.println(myList);
        // // Count the rows of astericks
        // int rows = 3;
        // int listSize = myList.size();

        // String[][] myTwoDim = new String[rows][];
        // for (int i = 0; i < 3; i++) {
        //     String[] myRowValue = myList.get(i).split("");
        //     myTwoDim[i] = new String[myRowValue.length];
        //     for (int j =0; j < myRowValue.length; j++) {
        //         myTwoDim[i][j] = myRowValue[j];
        //     }
               
        // }
        // System.out.println(Arrays.deepToString(myTwoDim));
    }
}