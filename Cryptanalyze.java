import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Cryptanalyze {
	
	public static void main(String[] args) throws FileNotFoundException{
		
		String cipherContents = "";
        String decryptedText = "";
        
        File cipherText = new File("C:\\Users\\Luke\\Documents\\Computer Science\\CSC3621\\Task1\\Exercise1Ciphertext.txt");
        cipherContents = scanner(cipherText);
	
        //Manually need to enter the correct number of places to shift by. To shift forward enter a negative number.
        decryptedText = shift(cipherContents, 4);
        System.out.println(decryptedText);
         
        try(PrintWriter out = new PrintWriter("decryptedText.txt")){
        	out.println(decryptedText);
        }
        
	
}
	 //Takes a file and returns a string of file contents
    public static String scanner(File file) throws FileNotFoundException{
        Scanner sc = new Scanner(file);
        String fileContents = "";
        
        while (sc.hasNextLine()){
            fileContents += sc.nextLine();
        }
         return fileContents;
    }
	//Shifts the characters in the file a number of times in a certain direction
    private static String shift(String stringContents, int shift){
    	String text = "";
    	
        for(int i = 0; i < stringContents.length(); i++){
        	
            char character = stringContents.charAt(i);
            character = Character.toLowerCase(character);
          
            if(character < 'a' || character > 'z'){
            	character = character;
            }else{
           character = (char) (character - shift);
            if(character < 'a'){
            	character = (char) (character + 26);
            }
            }
            text = text + character;
        }
        return text;
    }
}