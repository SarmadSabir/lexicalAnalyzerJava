package Assignment2;
//Necessary imports
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.util.regex.*;

public class Preprocessor {

	// Reads the content of a file and returns it as a string.
    public static String readFile(String filename) throws IOException {
    	// Create a BufferedReader for efficient reading.
    	BufferedReader reader = Files.newBufferedReader(Paths.get(filename));
        StringBuilder builder = new StringBuilder();
        String line;
        // Reading file line by line.
        while ((line = reader.readLine()) != null) {
            builder.append(line).append("\n");
        }
        reader.close();
        //return Content of the file as a string
        return builder.toString();
    }

    // removes single-line and multi-line comments from the given string
    public static String removeComments(String input) {
        // Remove single-line comments
        input = input.replaceAll("//.*", "");
        // Remove multi-line comments
        return input.replaceAll("/\\*.*?\\*/", "");
    }

    public static String removeBlankLinesAndSpaces(String input) {
        // Remove blank lines and trim spaces
        input = input.replaceAll("(?m)^[ \t]*\r?\n", "");
        // Remove unnecessary spaces
        return input.replaceAll("\\s+", " ").trim();
    }

    public static String removeImportStatementsAndAnnotations(String input) {
        // Remove import statements and annotations
        return input.replaceAll("import .*?;", "").replaceAll("@.*? ", "");
    }

    public static void writeFile(String output, String filename) throws IOException {
        FileWriter writer = new FileWriter(filename);
        // output Content to write to the file.
        writer.write(output);
        writer.close();
    }

    // Main method to run the preprocessing tasks
    public static void main(String[] args) throws IOException {
    	// Check for correct usage and number of arguments
    	if (args.length < 1) {
            System.err.println("Usage: java Preprocessor <input_file>");
            System.exit(1);
        }
    	// Reading the file content
        String input_file = args[0];
        String content = readFile(input_file);
        
        // Removing comments, blank lines, spaces, import statements, and annotations
        content = removeComments(content);
        content = removeBlankLinesAndSpaces(content);
        
        // Writing the preprocessed content to an output file and printing to the console
        content = removeImportStatementsAndAnnotations(content);
        writeFile(content, "out1.txt");
        System.out.println(content);
    }
}
