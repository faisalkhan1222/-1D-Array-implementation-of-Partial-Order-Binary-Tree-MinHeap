import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


/*
 Main Class using Heap Sort (Java)
 1D Array implementation of Partial Order Binary Trees/Priority Q/MinHeap
 Author: FaisalKhan
 Dated: 2/22/16.
 */

public class Main {

	public static void main(String[] args) {
		
		 //check if a file is passed into the program as an argument
	      if(args.length < 3){
	         System.err.println("Error! Please Provide three files as arguments\n" +
	         		"Please pass an Inputfile as First argument\nPlease pass an Outputfile as second argument\n" +
	         		"Please pass an Outputfile as Third argument");
	         throw new IllegalArgumentException(" \nArgument files not provided Correctly");
	      }//if
		
		int count = 0;//count the number of elements in the file
		//open input file and store the number of elements
		File inputFile = new File(args[0]);
		  try {

		        Scanner file = new Scanner(inputFile);
		        System.out.println();

			    System.out.println("Data read from File");

		        while (file.hasNextInt()) {
		            int data = file.nextInt();
		            System.out.print(data + " ");
		            count ++;
		        }
		        file.close(); 
		    } 
		    catch (FileNotFoundException e) {
		        e.printStackTrace();
		    }
		
	  
		  //create a new object of heapsort with size number of elements in file + 1
		  HeapSort heap = new HeapSort(count+1);
		 
		  
		    File outputfile1 = new File(args[1]);//the first output file to store the first 10 elements of the heap

	        try {

	        	FileWriter outfile1W = new FileWriter(outputfile1);
			    PrintWriter outfile1 = new PrintWriter (outfile1W);

			    outfile1.println("--------------------------------------------------------------------------------");
			    outfile1.println( "Build Heap \n Format -> BuildHeap: The Number of Elements according to HeapArray[0]\n" +
			    		" followed by the ten elements of the heap, one element per row \n");
		        outfile1.println("--------------------------------------------------------------------------------");

				 //open the input file again to push the data into the stack
		        Scanner file = new Scanner(inputFile);

		        while (file.hasNextInt()) {
		            int data = file.nextInt();
		            heap.buildHeap(data,outfile1);
		        }
		        file.close();
		        
		        outfile1.println("--------------------------------------------------------------------------------");
		        outfile1.println("--------------------------------------------------------------------------------");

		        outfile1.close();
		    } 
		    catch (FileNotFoundException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
				e.printStackTrace();
			}
		  
	        System.out.println();
	        System.out.println();
	        System.out.print("Total Elements in the Heap: ");
	        heap.printHeapToConsole();
	        
	        
	    	File outputfile2 = new File(args[2]);//2nd output file to store all the deleted roots
			try {

				FileWriter outfile1W = new FileWriter(outputfile1, true);
			    PrintWriter outfile1 = new PrintWriter (outfile1W,true);
			    
				FileWriter outfile2W = new FileWriter(outputfile2);
			    PrintWriter outfile2 = new PrintWriter (outfile2W);

			    outfile1.println("--------------------------------------------------------------------------------");
			    outfile1.println(" Delete Heap \n Format -> DeleteHeap: The Number of Elements according to HeapArray[0]\n " +
			    		"followed by the ten elements of the heap, one element per row \n");
		        outfile1.println("--------------------------------------------------------------------------------");

		      
			    heap.deleteHeap(outfile1,outfile2);

			    outfile1.close();
			    outfile2.close();
		    } 
		     catch (IOException e) {
				e.printStackTrace();
			}
	}

}
