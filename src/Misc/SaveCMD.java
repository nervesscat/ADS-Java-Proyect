package Misc;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

/**
 * @author meavilam@unah.hn
 * @version 1.0
 * @since 2023-07-28
 */
public class SaveCMD {

    /**
     * Guarda un string en un archivo
     * @param content String a guardar
     */
    public static void save(String content) {
        try {
            FileWriter fw = new FileWriter("History.MEAM", true);
            fw.write(content + "\n");
            fw.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Carga un string de un archivo y lo imprime
     */
    public static void printHistory() {
        try {
            java.io.BufferedReader br = new BufferedReader(new FileReader("History.MEAM"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
