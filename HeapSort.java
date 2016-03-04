import java.io.PrintWriter;

/*
 Heap Sort Class(Java)
 Author: FaisalKhan
 Dated: 2/22/16.
 */

class HeapSort{
  
    
    int[] heapAry;
    int arrayCapacity;//a variable to keep track of the size of the array
                    // so i can check is full and is empty properties.
    int insertHere;//keep track of the index to insert data
    
    HeapSort(int capacity){
        heapAry = new int[capacity];
       
        arrayCapacity = capacity;
        
        insertHere = 1;
    }
    
    void buildHeap(int data, PrintWriter outfile1){
        insertOneDataItem(data);
        bubbleUp(insertHere-1);//start from the very last element added and bubbleUp
        outfile1.print("\nBuildHeap: ");
        printHeapToFile(outfile1);
    }
    
    void deleteHeap(PrintWriter outfile1, PrintWriter outfile2){
        while(!isHeapEmpty()){
        DeleteRoot(outfile2);
        bubbleDown(1);// pass in 1 as a parameter to buubleDown to start from the root
        outfile1.print("deleteHeap: ");
        printHeapToFile(outfile1);
        outfile1.println();
        }
    }
    
    void insertOneDataItem(int data){

        if(!isHeapFull()){
            heapAry[insertHere] = data;
            heapAry[0] = insertHere;
            insertHere ++;
        }
    }
    
    void DeleteRoot(PrintWriter outfile2){
        //put the root element in temp and replace root
        // with the very last element
        int temp = heapAry[1];
        int lastElement = heapAry[0];
        heapAry[1] = heapAry[lastElement];
        //reduce the number of elements by 1 at index 0
        heapAry[0] = heapAry[0] - 1;
        outfile2.println("Deleted Root: "+ temp);
    }
    
    void bubbleUp(int element){
    
        int parent = element/2;
        
        int temp = 0;
        //check that the child ie element is smaller than its parent
        // and that the child is not the root then swap the parent and child
        // and call bubbleUp recursively
        if(heapAry[element] < heapAry[parent] && element != 1){
            temp = heapAry[parent];
            heapAry[parent] = heapAry[element];
            heapAry[element] = temp;
            bubbleUp(parent);
        }
    }

    void bubbleDown(int element){
        
        int parent = element;
        int leftChild = parent * 2;
        int rightChild = (parent *2) + 1;
        int temp = 0;
        int decide = 0;
        
        //check if the left child index is greater than
        //the max possible elements in the array if true return
        if(leftChild > heapAry[0]){
            return;
        } //if
        
        //check if the left child is the very last element ie leaf child
        if(leftChild == heapAry[0]){
            if(heapAry[leftChild] < heapAry[parent]){
                temp = heapAry[leftChild];
                heapAry[leftChild] = heapAry[parent];
                heapAry[parent] = temp;
            } //if
        } //if
        
        //check if the left or right child is the smallest of the two
        //and assign it to the variable decide
        if(heapAry[leftChild] < heapAry[rightChild]){
            decide = leftChild;
        } //if
        else{
            decide = rightChild;
        } //else
        
        //from the previous step we checked for the min child
        // now check that child against the parent and swap if its
        //smaller than the parent then call bubbleDown recursively
        if(heapAry[decide] < heapAry[parent]){
            temp = heapAry[decide];
            heapAry[decide] = heapAry[parent];
            heapAry[parent] = temp;
            bubbleDown(decide);
        } //if
            
              }
    
    //check if index 0 is 0 for empty heap
    boolean isHeapEmpty(){
    
        return heapAry[0] == 0;
    }
    
    //To check if heap is full check the index 0 of array to
    //see if we have the max elements
    boolean isHeapFull(){
    	
        return heapAry[0] == arrayCapacity - 1;
    }
    
    //print the first 10 elements to the output file 
    void printHeapToFile(PrintWriter outfile){
    	
        for(int i=0; i <= heapAry[0]; i++){
            if(i > 10){
                break;
            }
            
            outfile.println(heapAry[i]);
        }
    }    
 
    //print all the elements to the console
 void printHeapToConsole(){
    	
        for(int i=0; i <= heapAry[0]; i++){
            System.out.println(heapAry[i]);
        }
    }    
}

