package Assignment;
import java.util.Scanner;
import java.util.ArrayList;

public class Fibonacci {

    ArrayList<Integer> sequence = new ArrayList<Integer>();

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Which number of the Fibonacci sequence would you like to calculate?");
        int n = Integer.parseInt(sc.nextLine());
        sc.close();
        System.out.println("Calculating...");
        
        Fibonacci instance = new Fibonacci();
        instance.sequence.add(instance.fibonacci(n));
        System.out.println("Number " + n + " of the Fibonacci Sequence = ");
        System.out.println(instance.sequence);
    }

    public int fibonacci(int n){
        if(n < 2){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
    
}
