package vttp2022.day09.MyFileParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileParser {

    private File inputFileName;
    private List<String> updatedFile = new ArrayList<>();
    BufferedReader br;
    private String[][] myTwoDim;

    public FileParser(String fileName) throws IOException {

        inputFileName = new File("gol_files" + File.separator + fileName);
        readFile(inputFileName);

    }

    private void readFile(File fileName) throws IOException {
        
        try {
            FileReader reader = new FileReader(fileName);
            br = new BufferedReader(reader);
            String line = "";

            while ((line = br.readLine()) != null) {
                updatedFile.add(line);
            }
            // Filter out the comments and save it
            List<String> comments = updatedFile.stream()
                .filter(str -> str.contains("#"))
                .toList();
            updatedFile.removeAll(comments);
            br.close();
            System.out.println(updatedFile);

        } catch (Exception ex) {

        }
    }

    public void buildAst() {
        List<String> myAst = updatedFile.stream()
            .filter(str -> str.contains("*"))
            .toList();

        // Count the rows of astericks
        int rows = myAst.size();

        myTwoDim = new String[rows][];
        for (int i = 0; i < rows; i++) {
            String[] myRowValue = myAst.get(i).split("");
            myTwoDim[i] = new String[myRowValue.length];
            for (int j = 0; j < myRowValue.length; j++) {
                myTwoDim[i][j] = myRowValue[j];
            }
               
        }
        System.out.println(Arrays.deepToString(myTwoDim));

    }

    public List<String> getUpdatedFile() {
        return updatedFile;
    }

    public String[][] getMyTwoDim() {
        return myTwoDim;
    }
    
}
