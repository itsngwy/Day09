package vttp2022.day09.MyFileParser;

import java.util.Arrays;
import java.util.List;

public class Session {

    FileParser myFP;
    String[][] box;
    String[][] ast;
    private List<String> updatedFile;
    private static final String GRID = "GRID";
    private static final String START = "START";
    private static final String DATA = "DATA";

    public Session(FileParser fileDir) {

        this.myFP = fileDir;
        updatedFile = myFP.getUpdatedFile();
    }

    public void start() {

        Boolean stop = false;
        int gridX = 0;
        int gridY = 0;
        int startX = 0;
        int startY = 0;

        while(!stop) {

            // 3 can be hard coded but maybe can try not hardcoding it 
            for (int k = 0; k < 3; k++) {

                String[] terms = updatedFile.get(k).split(" ");
                String cmd = terms[0];
                System.out.println(Arrays.toString(terms));

                switch (cmd) {
                    case GRID:
                        gridX = Integer.parseInt(terms[1]);
                        gridY = Integer.parseInt(terms[2]);
                        box = new String[gridX][gridY];
                        for (int i = 0; i < gridX; i++) {
                            for (int j =0; j < gridY; j++) {
                                box[i][j] = ".";
                                System.out.print(box[i][j]);
                            }
                            System.out.println();
                        }
                        break;
                    case START:
                        startX = Integer.parseInt(terms[1]);
                        startY = Integer.parseInt(terms[2]);
                        break;
                    case DATA:
                        myFP.buildAst();
                        ast = myFP.getMyTwoDim();
                        break;
    
                    default:
                        
                }
            }
            // This is to edit the dot to astericks
            for (int i = startX; i < ast.length + startX; i++) {
                // Find the longest length amongst the lines of ast
                for (int j = startY; j < ast[i-startX].length + startY; j++) {
                    // Do if statement to change the space to .
                    if (ast[i-startX][j-startY].equals(" ")) {
                        box[i][j] = ".";
                    } else {
                        box[i][j] = ast[i-startX][j-startY];
                    }
                    
                }
            }
            System.out.println();
            // To print out the edited astericks
            for (int i = 0; i < gridX; i++) {
                for (int j =0; j < gridY; j++) {
                    System.out.print(box[i][j]);
                }
                System.out.println();
            }
            stop = true;
        }
    }
    
}
