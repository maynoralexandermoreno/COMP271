package assignment10;

import java.io.*;
import java.util.Random;
public class Exercise17_03 {
	public static void main(String[] args) throws IOException {
		// this is to actually create the file to practice with
		int sum = 0;
		int in = 0;
		try (DataOutputStream output = new DataOutputStream(new FileOutputStream("Exercise17_03.dat"))){
			Random upper = new Random();
			int randomNumberOfInts = 1 + upper.nextInt(500);
			for (int i = 0; i < randomNumberOfInts; i++){
				output.writeInt(upper.nextInt(1000));
			}
		}
		// this is the actual part of the hw assignment
		try (DataInputStream input = new DataInputStream(new FileInputStream("Exercise17_03.dat"))){
			while (true){
				in = input.readInt();
				sum = sum + in;
				System.out.print(sum + " ");
			}
		}
		catch (EOFException ex){
			System.out.print("\n" + "The sum is " + sum);
		}
	}
}

