/**
 * @author Amin Kadawala - 40200998
 * @author Maxime Arseneau - 40207886
 * 
 * Assignment 3, Part 2 - COMP352
 * 
 * Date: December 5th, 2022
 *
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ElasticERL {
    
	ADT dataStructure;
	int count;
	int thresholdSize;
	
	/**
	 * @param size
	 * 
	 * Determining which ADT to use, less than 1000 or greater
	 */
	public void setEINThreshold(int size) {
		thresholdSize = size;
		dataStructure = size <= 1000 ? new linkedList() : new linkedList(); //add partners
	}
	
	/**
	 * @param erl
	 * @return generated int of 8 random digits
	 * 
	 * Method to generate 8 random digits that are unique
	 */
	public static int generate(ElasticERL erl) {
        String id = "";
        for(int i = 0; i < 8; i++){ //generating all 8 numbers differently 
            id += (int)Math.floor(Math.random()*10); //random number
        }
        int EIN_ID = Integer.parseInt(id); //string to integer
        return EIN_ID;
	}
	
	/**
	 * @param erl
	 * 
	 * Calls the allkeys method which outputs all keys
	 */
	public void allKeys(ElasticERL erl) {
		erl.dataStructure.allKeys(); //cals allkeys()
	}
	
	/**
	 * @param erl
	 * @param key
	 * @param value
	 * 
	 * Checks whether key exists, if not then adds
	 */
	public void add(ElasticERL erl, int key, String value) {
		int len = (int) (Math.log10(key) + 1);
		if (len == 8) {
			if (!erl.contains(erl, key)) { //if it doesnt exist then add key
				erl.dataStructure.add(key, value);
				System.out.println("Successfully added key: " + key);
				count++;
			}
			else {
			System.out.println("EIN # already exists."); //output if key already exist
			}
		}
		else {
			System.out.println("Key not valid.");
		}
	}
	
	/**
	 * @param erl
	 * @param key
	 * 
	 * Calls remove method to remove a key
	 */
	public void remove(ElasticERL erl, int key) {
		erl.dataStructure.remove(key); //call remove method
		count--;
	}
	
	/**
	 * @param erl
	 * @param key
	 * @return the value associated with the key
	 */
	public String getValues(ElasticERL erl, int key) { 
		return erl.dataStructure.getValues(key); //calls getValue method
	}
	
	/**
	 * @param erl
	 * @param key
	 * @return the next key after @param key
	 */
	public int nextKey(ElasticERL erl, int key) {
		return erl.dataStructure.nextKey(key); //calls nextKey method
	}

	/**
	 * @param erl
	 * @param key
	 * @return the previous key of @param key
	 */
	public int prevKey(ElasticERL erl, int key) {
		return erl.dataStructure.prevKey(key); //calls prevKey method
	}
	
	/**
	 * @param erl
	 * @param key1
	 * @param key2
	 * @return an integer of how many keys are between @param key1 and @param key2
	 */
	public int rangeKey(ElasticERL erl, int key1, int key2) {
		return erl.dataStructure.rangeKey(key1, key2); //calls rangeKey method
	}
	
	/**
	 * @param erl
	 * @param key
	 * @return true or false whether a key exists or not
	 */
	public boolean contains(ElasticERL erl, int key) {
		return erl.dataStructure.contains(key); //checking to see whether a key contains 
	}
	
	/**
	 * @param args
	 * @throws FileNotFoundException
	 * 
	 * Main method where the welcome message and file testing is located
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scanner = new Scanner(System.in);
		ElasticERL erl = new ElasticERL(); //making an object
		
		//Welcome message
		System.out.println("----------------------------------------------------------------\n"
						 + "		   EHITS Tracking System\n"
						 + "----------------------------------------------------------------\n");
		
		//asking number of numbers
		System.out.print("Please input the total size of EIN #s: ");
		int totalSize = scanner.nextInt();
		
		//call method with the numbers to determine which ADT to use
		erl.setEINThreshold(totalSize);
		
		//inputting file and adding all the EIN numbers 
		Scanner sc = new Scanner(new FileInputStream("C:\\Users\\Amin\\Desktop\\COMP-352_A3_P2\\file1.txt"));
		while(sc.hasNextLine()) {
			String data = sc.nextLine();
			Integer insertData = Integer.parseInt(data);
			erl.add(erl, insertData, "S_ " + insertData);
		}
		sc.close();
		
		
		//TESTING ALL CASES FOR LINKEDLIST
		System.out.println("\nAll Keys:");
		erl.allKeys(erl); //show all keys
		
		System.out.println("\nPrevious key for 33255593: " + erl.prevKey(erl, 33255593)); //show previous key
		
		System.out.println("\nNext key for 13326261: " + erl.nextKey(erl, 13326261)); //show next key
		
		System.out.println("\nRange between key 33240013 and key 33266743: " + erl.rangeKey(erl, 33240013, 33266743)); //show range between two keys
		
		System.out.println("\nRemove key 83747069: ");
		erl.remove(erl, 83747069); //removing a key
		
		System.out.println("\nRemove key 12345678: ");
		erl.remove(erl, 12345678); //removing a key
		
		System.out.println("\nAll Keys:");
		erl.allKeys(erl); //show all keys to see the removed key
		
		System.out.println("\nGenerating 10 random keys: "); //generating 10 random keys from generating method
		for (int i = 0; i < 9; i++) {
			int EIN = generate(erl);
			erl.add(erl, EIN, "S_" + EIN);
		}
		
		System.out.println("\nAll Keys:");
		erl.allKeys(erl); //show all keys to see the generated keys
		
		System.out.println("\nGenerating 2 keys of your choice: "); //generating two keys from user input 
		for (int i = 0; i < 2; i++) {
			System.out.print("Input 8 digit EIN #: ");
			int EIN = scanner.nextInt();
			System.out.print("Input EIN equipment name: "); //inputting value by user
			scanner.nextLine();
			String EINInfo = scanner.nextLine();
			erl.add(erl, EIN, EINInfo);
		}
		
		System.out.println("\nAll Keys:");
		erl.allKeys(erl); //show keys to see the ones added by user
		
		System.out.println("\nValue of key: 12345678: " + erl.getValues(erl, 12345678)); //getting the value of a key
		
		
		scanner.close();
	}
		
}