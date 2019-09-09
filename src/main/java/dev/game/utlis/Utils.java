package dev.game.utlis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class Utils {

    public static String loadFileAsString(String path){
        StringBuilder builder = new StringBuilder();
        try {
            FileReader r = new FileReader(Utils.class.getClassLoader()
                .getResource("worlds/world1.txt").getPath());
            BufferedReader br = new BufferedReader(r);
            String line;
            while((line = br.readLine()) != null)
                builder.append(line).append("\n");
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static int parseInt(String number){
        try{
            return Integer.parseInt(number);
        }catch(NumberFormatException e){
            e.printStackTrace();
            return 0;
        }
    }
}