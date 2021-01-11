package A2;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        /*

        *<]:-DOo
        >:o)
        <]:-D



        */
        Pattern Noel = Pattern.compile("\\*<]:-DOo");
        Pattern Rens = Pattern.compile(">:o\\)");
        Pattern Follet = Pattern.compile("[^*]<]:-D");

        int compteNoel = 0;
        int compteRens = 0;
        int compteFollet = 0;
        boolean booleanNoel = false;
        boolean booleanRens = false;
        boolean booleanFollet = false;

        try {
            File mitxt = new File("src/santako.txt");
            Scanner myReader = new Scanner(mitxt);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                Matcher noel = Noel.matcher(data);
                Matcher rens = Rens.matcher(data);
                Matcher follet = Follet.matcher(data);
                while (noel.find()){
                    compteNoel++;
                    booleanNoel = true;
                }

                while (rens.find()){
                    compteRens++;
                    booleanRens = true;
                }

                while (follet.find()){
                    compteFollet++;
                    booleanFollet = true;
                }

                if(booleanNoel) System.out.print("Pare Noel (" + compteNoel + ") ");
                if(booleanRens) System.out.print("Ren(" + compteRens + ") ");
                if (booleanFollet) System.out.print("Follet (" + compteFollet + ") ");

                booleanNoel = false;
                booleanRens = false;
                booleanFollet = false;

                 compteNoel = 0;
                 compteRens = 0;
                 compteFollet = 0;

                System.out.println("");

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }
}
