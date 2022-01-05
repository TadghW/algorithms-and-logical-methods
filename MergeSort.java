package Assignment;
import java.util.Scanner;
import java.util.ArrayList;

public class MergeSort {

    public ArrayList<Integer> list = new ArrayList<Integer>();
    public static void main(String args[]){
             
        MergeSort instance = new MergeSort();
        instance.startMergeSort();  
    }

    public void startMergeSort(){
        
        //prompt user for merge sort
        System.out.println("Enter six numbers in a random order");

        //assign user input numbers to variables
        Scanner sc = new Scanner(System.in);
        int numberOne = Integer.parseInt(sc.nextLine());
        int numberTwo = Integer.parseInt(sc.nextLine());
        int numberThree = Integer.parseInt(sc.nextLine());
        int numberFour = Integer.parseInt(sc.nextLine());
        int numberFive = Integer.parseInt(sc.nextLine());
        int numberSix = Integer.parseInt(sc.nextLine());
        sc.close();
        
        //add numbers to ArrayList
        list.add(numberOne);
        list.add(numberTwo);
        list.add(numberThree);
        list.add(numberFour);
        list.add(numberFive);
        list.add(numberSix);
                
        //print the list
        System.out.println("Array Before Merge Sort");
        for(Integer number: list){  
            System.out.print(number + " ");  
        }  

        //sort the list
        ArrayList<Integer> sortedList = mergeSort(list);
        
        //print the sorted list
        System.out.println("\nArray After Merge Sort");  
        for(Integer number: sortedList){
            System.out.print(number + " ");
        }
    
    }

    public ArrayList<Integer> mergeSort(ArrayList<Integer> list){
    
        int n = list.size();
        
        //if the list is smaller than 2 it can't be split again
        if(n < 2){
            return list;
        }

        //create two new lists to store split values into
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();

        //add list[0] ... list[list.length / 2] to list1
        for(int i = 0; i < (n / 2); i++){
            list1.add(list.get(i));
        }

        //add list[(list.length / 2) + 1] ... list[list.length] to list2
        for(int j = (n / 2); j < n; j++){
            list2.add(list.get(j));
        }

        //Now run mergeSort on those lists, splitting them apart again
        list1 = mergeSort(list1);
        list2 = mergeSort(list2);
        
        //Once you've completed that, merge list1 and list 2 together
        return merge(list1, list2);
    }

    public ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2){
        
        //Create an empty ArrayList to merge list1 and list2 into
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        
        
        //While both lists contain values, add them to list3 in ascending order, going by left to right when equal
        while(list1.size() != 0 && list2.size() !=0){
            if(list1.get(0) > list2.get(0)){
                int smallerValue = list2.get(0);
                list3.add(smallerValue);
                list2.remove(0);        
            } else if(list1.get(0) < list2.get(0)) {
                int smallerValue = list1.get(0);
                list3.add(smallerValue);
                list1.remove(0);
            } else {
                list3.add(list1.get(0));
                list3.add(list2.get(0));
                list1.remove(0);
                list2.remove(0);
            }
        }

        //If one of the lists is empty, add other list's remaining value(s) into list 3 from leftmost onwards
        while(list1.size() != 0){
            int remainingValue = list1.get(0);
            list3.add(remainingValue);
            list1.remove(0);
        }

        while(list2.size() != 0){
            int remainingValue = list2.get(0);
            list3.add(remainingValue);
            list2.remove(0);
        }

        //return the merged list
        return list3;
    }

}
