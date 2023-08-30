package wordCounter;
import java.util.*;
import java.io.*;

public class wordCounter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        System.out.println("Enter text or provide a path to the file:");
        String input = sc.nextLine();

        String text = "";
        if (input.toLowerCase().endsWith(".txt")) {
            text = readFromFile(input);
        } else {
            text = input;
        }

        String[] words = text.split("[\\p{Punct}\\s]+");
        int wordCount = words.length;

        System.out.println("Total word count: " + wordCount);

        sc.close();
    }

    public static String readFromFile(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();
            return content.toString();
        } catch (FileNotFoundException e) {
            System.out.println("Error 404: File not found.");
        } catch (IOException e) {
            System.out.println("Error reading the file.");
            System.out.println(e);
        }
        return "";

	}

}
