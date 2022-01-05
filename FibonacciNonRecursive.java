package Assignment;
import java.util.Scanner;

public class FibonacciNonRecursive {
    
public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    System.out.println("Which number of the Fibonacci sequence would you like to calculate?");
    int n = Integer.parseInt(sc.nextLine());
    sc.close();
    
    //in order to calculate later digits in the fibonacci sequence I start at [0, 1, 1, 2], shortcutting (0 + 1) and (1 + 1)
    //now int a serves as the most recent number in the sequence, and b the one before that
    //c is where the program will store the next number on the sequence
    int a = 2;
    int b = 1;
    int c = 0;
    
    //calculates the next number of the sequence n times, moving the program along the sequence after each calculation
    //i = 3 to account for skipping the first 2 digits of the sequence
    for(int i = 3; i < n; i++){
        c = a + b;
        int x = a;
        a = c;
        b = x;
    }
    System.out.println("Number " + n + " of the Fibonacci Sequence = " + c);
}

}
