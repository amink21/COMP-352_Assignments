import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StrikeEdgeZeroStack {

    public static void main(String[] args) throws IOException {
    	
        int startPos = 0;
        
        boolean stackResult = false;
        
        PrintWriter writer = new PrintWriter("C:\\Users\\Amin\\OneDrive\\Desktop\\352 - Part 2\\Part2_B_out.txt");
        

        int[] array = {4,8,5,2,3,5,1,6,4,0};
        writer.write("Example 1: ");
        String temp = "";
        temp = temp + "{";
        for(int i = 0; i < array.length-1; i++){
            temp = temp + (array[i] + ", ");
        }
        temp = temp + (array[array.length-1] + "} ==> ");
        stackResult = hitZeroStack(startPos, array);
        writer.write(temp);
        writer.write(stackResult + "\n");
        writer.write("\n");
        
        
        int[] array2 = {5,8,2,3,1,5,0};
        writer.write("Example 2: ");
        String temp2 = "";
        temp2 = temp2 + "{";
        for(int i = 0; i < array2.length-1; i++){
            temp2 = temp2 + (array2[i] + ", ");
        }
        temp2 = temp2 + (array2[array2.length-1] + "} ==> ");
        stackResult = hitZeroStack(startPos, array2);
        writer.write(temp2);
        writer.write(stackResult + "\n");
        writer.write("\n");
        
        
        int[] array3 = {10,0,4,8,5,2,3,5,1,6,4,0};
        writer.write("Example 3: ");
        String temp3 = "";
        temp3 = temp3 + "{";
        for(int i = 0; i < array3.length-1; i++){
        	temp3 = temp3 + (array3[i] + ", ");
        }
        temp3 = temp3 + (array3[array3.length-1] + "} ==> ");
        stackResult = hitZeroStack(startPos, array3);
        writer.write(temp3);
        writer.write(stackResult + "\n");
        writer.write("\n");
        
        
        int[] array4 = {7,0,5,8,2,3,1,5,0};
        writer.write("Example 4: ");
        String temp4 = "";
        temp4 = temp4 + "{";
        for(int i = 0; i < array4.length-1; i++){
        	temp4 = temp4 + (array4[i] + ", ");
        }
        temp4 = temp4 + (array4[array4.length-1] + "} ==> ");
        stackResult = hitZeroStack(startPos, array4);
        writer.write(temp4);
        writer.write(stackResult + "\n");
        writer.write("\n");
        
        writer.close();
    }
    
	public static boolean hitZeroStack(int position, int[] array){
    	
    	
        List<Integer> isVisited = new ArrayList<Integer>();
        
        Stack<Integer> stack = new Stack<>();
        
        Boolean started = false;

        while(!stack.empty() || started == false){
            //to keep track of if we started or not
            if(!started)
                started = true;

            //push the initial position to stack
            if(stack.isEmpty())
                stack.push(position);

            //if the game is solveable
            if(stack.contains(array.length-1)) {
                return true;
            }

            //if we have already visited the current position, pop from stack
            if(!isVisited.isEmpty() && isVisited.contains(stack.peek())) {
                stack.pop();
                continue;
            }
            else
            	isVisited.add(stack.peek());

            //if this is ever true it means we've started searching for a solution but have expended all options and is thus not solveable
            if(stack.isEmpty()){
                return false;
            }
            else{
            	position = stack.peek();
            }

            //move right
            if(position + array[position] < array.length){
                stack.push(position + array[position]);
            }
            //move left
            if(position - array[position] >= 0){
                stack.push(position - array[position]);
            }
        }

        return false;
    }
    
}