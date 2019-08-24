/*
 * This is an exercise in try-catch. 
 */
package assignment04;
import java.io.FileNotFoundException;
import java.util.*;

public class Exercise12_15 {

	public static void main(String[] args){
		java.io.File HW = new java.io.File(("Exercise12_15.txt"));
		if (HW.exists()){
			System.out.println("This file already exists.");
			System.exit(1);
		}
		
		try (java.io.PrintWriter out = new java.io.PrintWriter(HW);){
			//Writes the data into the file
			Random ranInt = new Random();	
			for(int i = 0; i < 100; i++){
				out.print(ranInt.nextInt(100) + " ");
			}
			out.close();
			
			//reads the data into an array
			Scanner in = new Scanner(HW);
			ArrayList<Integer> list = new ArrayList<>();
			for(int i = 0; i < 100; i++){
				list.add(in.nextInt());
			}
			
			// orders the data and then displays
			java.util.Collections.sort(list);
			for (int i = 0; i < list.size(); i++){
				System.out.print(list.get(i) + " ");
			}
			in.close();
		} 
		catch (FileNotFoundException e) {
			System.out.print("No file exists to write");
			e.printStackTrace();
		}
		
	}

}