package sk.hovan.andrej.skuska.domacej;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import sk.upjs.jpaz2.*;

public class Launcher {

	public static void main(String[] args) {
		// put your code here
		
		  
        FrequencyTable ft = new FrequencyTable();

        Scanner sc = null;
        try {
                sc = new Scanner(new File("D:\\Workspace\\skuska.domacej\\src\\main\\java\\sk\\hovan\\andrej\\skuska\\domacej\\text.txt"));
                while (sc.hasNext())
                        ft.addOccurrence(sc.next());
        } catch (FileNotFoundException e) {
                System.err.println("Subor neexistuje.");
        } finally {
                if (sc != null)
                        sc.close();
        }

        System.out.println("Pocet roznych precitanych slov: " + ft.getWordCount());

        // Vypis po slovach
        String[] words = ft.getWords();
        System.out.println("Vyskyty slov: ");
        for (int i = 0; i < words.length; i++)
                System.out.println(words[i] + ": " + ft.getNumberOfOccurrences(words[i]));

        // test "hacknutia" objektu
        for (int i = 0; i < words.length; i++) {
                words[i] = "???";
        }

        // Vypis cez toString
        System.out.println("Vyskyty slov inak: " + ft.toString());

	}
}