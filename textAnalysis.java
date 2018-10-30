import java.io.*;
import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
 
 
public class textAnalysis {
     
     
    public static void main(String[] args) throws FileNotFoundException{
         
        String simpleContents = "";
        String cipherContents = "";
        
        File simpleText = new File("C:\\Users\\Luke\\Documents\\Computer Science\\CSC3621\\Task1\\pg1661.txt");
        simpleContents = scanner(simpleText);
        File cipherText = new File("C:\\Users\\Luke\\Documents\\Computer Science\\CSC3621\\Task1\\Exercise1Ciphertext.txt");
        cipherContents = scanner(cipherText);
        
        
        //Get the frequency and percentage of simple text
        frequency(simpleContents, numberCharacters);
        System.out.println("Number of characters in simple text" + numberCharacters);
        percentage(numberCharacters, characterPercentage);
        System.out.println("Percentage of characters in simple text" + characterPercentage); 
        
        //Get the frequency and percentage of cipher text
        frequency(cipherContents, numberCharactersCipher);
        System.out.println("Number of characters in cipher text" + numberCharactersCipher);
        percentage(numberCharactersCipher, characterPercentageCipher);
        System.out.println("Percentage of characters in cipher text" + characterPercentageCipher);     
        
        
        
        
      
        
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
    
    public static TreeMap<Character, Integer> numberCharacters = new TreeMap<Character, Integer>();
    public static TreeMap<Character, Double> characterPercentage = new TreeMap<Character, Double>();
    public static TreeMap<Character, Integer> numberCharactersCipher = new TreeMap<Character, Integer>();
    public static TreeMap<Character, Double> characterPercentageCipher = new TreeMap<Character, Double>();

    
    //Calculates the frequency of characters in a tree
    private static void frequency(String stringContents, TreeMap<Character, Integer> numberCharacters){
    	
    
        for(int i = 0; i < stringContents.length(); i++){
        	
       
        char character = stringContents.charAt(i);
        
    	character = Character.toLowerCase(character);

        if(character >= 'a' && character <= 'z'){
        	
        if (numberCharacters.containsKey(character) == false){
        numberCharacters.put(character, 1);
        }
        
        else{
        int currentValue = numberCharacters.get(character);
        currentValue ++;
        numberCharacters.put(character, currentValue);
        }}
    }
    }
    //Calculates the percentage of times a character appears in a file
    private static void percentage(TreeMap<Character, Integer> numberCharacters, TreeMap<Character, Double> characterPercentage) {
    	int total = 0;
    	for(Map.Entry<Character, Integer> entry : numberCharacters.entrySet()){
    		total = total + entry.getValue();
    	}
    	
    	
    	
    	for(Map.Entry<Character, Integer> entry : numberCharacters.entrySet()){
    		
    		double percentage = ((((double)entry.getValue()) / total) * 100);
    		
    		characterPercentage.put(entry.getKey(), percentage);
    	}
    	

	}

    
     
}