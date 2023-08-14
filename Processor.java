package Assignment2;

import java.io.IOException;

// The Processor class processes input files and performs certain transformations on them
public class Processor {

	// Processes a given input string. 
    // Newlines are replaced with nothing (effectively removed) 
    // and a sentinel value "$" is appended at the end.
    public static String processFile(String input) {
        // Remove newline characters and add sentinel value
        return input.replace("\n", "") + "$";
    }

    public static void main(String[] args) throws IOException {
    	// Check if the user has provided an input file as an argument.
        // If not, display the correct usage and exit
        if (args.length < 1) {
            System.err.println("Usage: java Processor <input_file>");
            System.exit(1);
        }
        
        // Retrieve the name/path of the input file.
        String input_file = args[0];
        
        // Using the static methods of Preprocessor directly
        String content = Preprocessor.readFile(input_file);
        
        // Process the content of the file to replace newlines and append a sentinel.
        content = processFile(content);
        
        // Write the processed content to a new file named "out2.txt".
        Preprocessor.writeFile(content, "out2.txt");
        
        // Display the processed content on the console.
        System.out.println(content);
    }
}
