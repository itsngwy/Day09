package vttp2022.day09.MyFileParser;

import java.io.IOException;

public class Main 
{
    public static void main( String[] args ) throws IOException
    {   
        String fileName = args[0];
        FileParser fp = new FileParser(fileName);
        Session mySess = new Session(fp);
        mySess.start();

    }
}
