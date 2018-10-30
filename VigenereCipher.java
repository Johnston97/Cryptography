import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class VigenereCipher {
	
    public static void main(String[] args) throws FileNotFoundException{
    	
        String textContents = "";
        String password = "";
        String encryptedText = "";
        String decryptedText = "";
        
    	File text = new File("C:\\Users\\Luke\\Documents\\Computer Science\\CSC3621\\Task2\\pg1661.txt");
    	//File text = new File("C:\\Users\\Luke\\Documents\\Computer Science\\CSC3621\\Task2\\text.txt");

        textContents = scanner(text);
     
        /*
        //Get the frequency and percentage of simple text
        frequency(textContents, numberCharactersCipher);
        System.out.println("Number of characters in simple text" + numberCharactersCipher);
       
        percentage(numberCharactersCipher, characterPercentageCipher);
        System.out.println("Percentage of characters in simple text" + characterPercentageCipher); 
        */


        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter a password. Only lower case characters");
        password = input.nextLine();
        while(!password.matches("[a-z]+")){
        	System.out.println("Please enter a valid password");
        	password = input.nextLine();
        }
        
        encryptedText = encrypt(textContents, password);
    	System.out.println(encryptedText);
    	
    	
    	//decryptedText = decrypt(encryptedText, password);
    	//System.out.println(decryptedText);
    }
    
    
    public static TreeMap<Character, Integer> numberCharactersCipher = new TreeMap<Character, Integer>();
    public static TreeMap<Character, Double> characterPercentageCipher = new TreeMap<Character, Double>();
    
    //Takes a file and returns a string of file contents
    public static String scanner(File file) throws FileNotFoundException{
        Scanner sc = new Scanner(file);
        String fileContents = "";
        
        while (sc.hasNextLine()){
            fileContents += sc.nextLine();
        }
         return fileContents;
    }
    
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
    
    //encrypts the file with a vigenereCipher using the inputted key
    private static String encrypt(String stringContents, String key){
    	String text = "";
    	int keyPosition = 0;
    	
        for(int i = 0; i < stringContents.length(); i++){
            char character = stringContents.charAt(i);
            character = Character.toLowerCase(character);
         
            if(character < 'a' || character > 'z'){
            	character = character;
            }else{
         
            character = (char)(((character + key.charAt(keyPosition) - (2*97))% 26) + 97);
        
            text = text + character;
            keyPosition++;
            if(keyPosition >= key.length()){
            	keyPosition = 0;
            	}		
    
            }
            
       
       
    } return text;
    }

    private static String decrypt(String stringContents, String key){
    	String text = "";
    	
    	int keyPosition = 0;
        for(int i = 0; i < stringContents.length(); i++){
            char character = stringContents.charAt(i);

        	if(character < 'a' || character > 'z'){
            	character = character;
            }else{
            character = (char)(((character - key.charAt(keyPosition) + 26) % 26) + 97);
        
            text = text + character;
            keyPosition++;
            if(keyPosition >= key.length()){
            	keyPosition = 0;
            	}		
            	}
        	}    	
        
        return text;
        
}
    

}




	
