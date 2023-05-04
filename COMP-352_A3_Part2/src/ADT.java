/**
 * @author Amin Kadawala - 40200998
 * @author Maxime Arseneau - 40207886
 * 
 * Assignment 3, Part 2 - COMP352
 * 
 * Date: December 5th, 2022
 *
 */

/**
 * interface of the methods we have to create that both ADT uses
 */
public interface ADT {
	
	/**
	 * Outputs all keys
	 */
	public void allKeys();
	
	/**
	 * @param key
	 * @param value
	 * 
	 * Adds a key into the ADT
	 */
	public void add(int key, String value);
	
	/**
	 * @param key
	 * 
	 * Removes the provided @param key
	 */
	public void remove(int key);
	
	/**
	 * @param key
	 * @return the value which is associated of @param key
	 */
	public String getValues(int key);
	
	/**
	 * @param key
	 * @return the integer key of the next key if exists of @param key
	 */
	public int nextKey(int key);
	
	/**
	 * @param key
	 * @return the integer key of the previous key if exists of @param key
	 */
	public int prevKey(int key);
	
	/**
	 * @param key1
	 * @param key2
	 * @return an integer value of how many keys are in between two keys
	 */
	public int rangeKey(int key1, int key2);
	
	/**
	 * @param key
	 * @return true/false value whether key exists or not 
	 */
	public boolean contains(int key);
	
}