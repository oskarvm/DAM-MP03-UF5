package A2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainNo {
    public static void main(String[] args) {

        String Noel = "*<]:-DOo";
        String Rens = ">:o)";
        String Follet = "<]:-D";
        String FolletNoel = "<]:-DOo";
        String substring;


        int compteNoel = 0, compteRens = 0, compteFollet = 0;
        boolean booleanNoel = false, boolenaRens = false, booleanFollet = false;

        try {
            File myObj = new File("src/santako.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String mm = data;

                while (data.indexOf(Noel)>-1){

                    if (data.contains(Noel)) {
                        booleanNoel = true;
                        compteNoel++;
                        substring = data.substring(data.indexOf(Noel) + Noel.length());
                        data = substring;
                    }
                }

                data = mm;
                while (data.indexOf(Rens)>-1){

                    if (data.contains(Rens)) {
                        boolenaRens = true;
                        compteRens++;
                        substring = data.substring(data.indexOf(Rens) + Rens.length());
                        data = substring;
                    }
                }

                data = mm;
                while (data.indexOf(Follet)>-1){
                    if (data.contains(Follet)) {
                        if (!data.contains(FolletNoel)) {
                            booleanFollet = true;
                            compteFollet++;
                        }
                        substring = data.substring(data.indexOf(Follet) + Follet.length());
                        data = substring;
                    }
                }


                if (booleanNoel){System.out.print("Pare Noel ("+ compteNoel+") ");}
                if (boolenaRens){System.out.print("Rens ("+ compteRens+") ");}
                if (booleanFollet){System.out.print("Follets ("+ compteFollet+") ");}
                System.out.print("\n");

                booleanNoel = false;
                boolenaRens = false;
                booleanFollet = false;
                compteNoel = 0;
                compteRens = 0;
                compteFollet = 0;

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
