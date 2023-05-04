import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class StrikeEdgeZeroRecursion {
    public static void main(String[] args) throws FileNotFoundException {
    	
    	
    	boolean recursionResult = false;
    	
    	PrintWriter writer = new PrintWriter("C:\\Users\\Amin\\OneDrive\\Desktop\\352 - Part 2\\Part2_A_out.txt");
        

        int[] array = {4,8,5,2,3,5,1,6,4,0};
        writer.write("Example 1: ");
        String temp = "";
        temp = temp + "{";
        for(int i = 0; i < array.length-1; i++){
            temp = temp + (array[i] + ", ");
        }
        temp = temp + (array[array.length-1] + "} ==> ");
        recursionResult = StrikeEdgeRecursion(array,0,0,0);
        writer.write(temp);
        writer.write(recursionResult + "\n");
        writer.write("\n");
        
        
        int[] array2 = {5,8,2,3,1,5,0};
        writer.write("Example 2: ");
        String temp2 = "";
        temp2 = temp2 + "{";
        for(int i = 0; i < array2.length-1; i++){
            temp2 = temp2 + (array2[i] + ", ");
        }
        temp2 = temp2 + (array2[array2.length-1] + "} ==> ");
        recursionResult = StrikeEdgeRecursion(array2,0,0,0);
        writer.write(temp2);
        writer.write(recursionResult + "\n");
        writer.write("\n");
        
        
        int[] array3 = {10,0,4,8,5,2,3,5,1,6,4,0};
        writer.write("Example 3: ");
        String temp3 = "";
        temp3 = temp3 + "{";
        for(int i = 0; i < array3.length-1; i++){
        	temp3 = temp3 + (array3[i] + ", ");
        }
        temp3 = temp3 + (array3[array3.length-1] + "} ==> ");
        recursionResult = StrikeEdgeRecursion(array3,0,0,0);
        writer.write(temp3);
        writer.write(recursionResult + "\n");
        writer.write("\n");
        
        
        int[] array4 = {7,0,5,8,2,3,1,5,0};
        writer.write("Example 4: ");
        String temp4 = "";
        temp4 = temp4 + "{";
        for(int i = 0; i < array4.length-1; i++){
        	temp4 = temp4 + (array4[i] + ", ");
        }
        temp4 = temp4 + (array4[array4.length-1] + "} ==> ");
        recursionResult = StrikeEdgeRecursion(array4,0,0,0);
        writer.write(temp4);
        writer.write(recursionResult + "\n");
        writer.write("\n");
        
        writer.close();
    }

    public static boolean StrikeEdgeRecursion(int arr[], int position, int index, int count) {
        
        //left and right positions
        int left = position - arr[position];
        int right = position + arr[position];
        
        
        if(position < 0 || position >= arr.length){
            return false;
        }
        
        //if its equal to last zero
        if(right == arr.length-1){
            return true;
        }
        
        //checking if the values around it are 1
        if(arr[position] == 1 && (arr[right] == 1 || arr[left] == 1)){
            return StrikeEdgeRecursion(arr, right, index, count);
        }

        //checking if it goes back to the same step
        if(left >= 0 && arr[position] == arr[left] && right >= arr.length){
            return false;
        }

        //right side is out of bounds so we do the left side
        if(right >= arr.length && left >= 0){
            return StrikeEdgeRecursion(arr, left, index, count);
        }

        //right side because left side is out of bounds
        if(left < 0 && right < arr.length){
            return StrikeEdgeRecursion(arr, right, index, count);
        }

        //check both left and right
        if(left >= 0 && right <= arr.length){
            //store the index arr and if index == org ind, return false
            if(position == index){
                return false;
            }

            if(count == 0){
                index = position;
                count++;
            }

            if(StrikeEdgeRecursion(arr, left, index, count)){
                return true;
            }

            if(StrikeEdgeRecursion(arr, right, index, count)){
                return true;
            }
        }
        
        //returns false if nothing is found
        return false;
    }
}