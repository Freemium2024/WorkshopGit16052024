import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] args) {
        String filename = "names.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Read file name from names.txt
                String fileName = line.trim();
                File file = new File(fileName);
                if (file.exists() && file.isFile()) {
                    // If file exists, read and display its contents
                    System.out.println("File: " + fileName);
                    displayFileContents(file);
                    System.out.println("---------------------------------");
                } else {
                    System.out.println("File not found: " + fileName);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    // Method to display file contents
    private static void displayFileContents(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
