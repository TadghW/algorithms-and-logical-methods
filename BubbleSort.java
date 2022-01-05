package Assignment;
import java.util.Scanner;

public class BubbleSort {  
    
    public static void main(String[] args) {  
                
        //prompt user for input
        System.out.println("Enter six numbers in a random order");
        
        Scanner sc = new Scanner(System.in);

        //assign user input numbers to variables
        int numberOne = Integer.parseInt(sc.nextLine());
        int numberTwo = Integer.parseInt(sc.nextLine());
        int numberThree = Integer.parseInt(sc.nextLine());
        int numberFour = Integer.parseInt(sc.nextLine());
        int numberFive = Integer.parseInt(sc.nextLine());
        int listix = Integer.parseInt(sc.nextLine());

        //create an array of user input variables
        int list[] = {numberOne, numberTwo, numberThree, numberFour, numberFive, listix};  
         
        //print the array before being sorted
        System.out.println("Array Before Bubble Sort");
        for(int i=0; i < list.length; i++){  
            System.out.print(list[i] + " ");  
        }  
        System.out.println();  
          
        //sort the array
        bubbleSort(list);  
         
        //print the sorted array
        System.out.println("\nArray After Bubble Sort");  
        for(int i=0; i < list.length; i++){  
            System.out.print(list[i] + " ");
        }  

        sc.close();
   
    }
        
    static void bubbleSort(int[] list) {  

        //Every time a pass is completed one number has been successfully sorted.
        //Stored outside of the sortingRequired logic for reporting purposes.
        int passesCompleted = 0;

        //sortingRequired can be set to false if a pass occurs without a single swap.
        boolean sortingRequired = true;
        while(sortingRequired){

            for(int j = 0; j < (list.length); j++){

                //Every time a number is moved sortingDone is true, when a pass has completed without a single number moved we know that the list is sorted.
                boolean sortingDone = false;

                //Subtracting passesCompleted makes sure that the algorithm doesn't compare numbers that have already been sorted to the correct location.
                for(int i = 0; i < (list.length - (1 + passesCompleted)); i++){
                
                    if(list[i] > list[i + 1]){
                        int numberStore = list[i + 1];
                        list[i + 1] = list[i];
                        list[i] = numberStore;
                        sortingDone = true;
                    }   

                }
                
                passesCompleted++;

                //if the last pass didn't move a single number (therefor the list is sorted), exit.
                if(sortingDone == false){
                    sortingRequired = false;
                }
            }
        }

        System.out.println("\nArray sorted in " + passesCompleted + " passes.");
    }  
}
  