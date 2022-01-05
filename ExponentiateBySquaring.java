package Assignment;
import java.util.Scanner;


public class ExponentiateBySquaring {

    //Main initiates the expBySquare function with user inputs passed as paramters
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the base");
        int x = Integer.parseInt(sc.nextLine());
        System.out.println("Input the exponent");
        int n = Integer.parseInt(sc.nextLine());
        ExponentiateBySquaring instance = new ExponentiateBySquaring();
        System.out.println(x + " to the power of " + n + " = ");
        System.out.println(instance.expBySquareInit(x, n));
        sc.close();
    }

    public int expBySquareInit(int x, int n){
        return expBySquare(x, n);
    }

    public int expBySquare(int x, int n){
        int result = 0;
        if(n < 0){
            result = expBySquare((1/x), -n);
        }
        if(n == 0){
            
        } else if(n == 1){
            result = x;
        } else if((n%2)==0){
            result = expBySquare(x*x, n/2);
        } else {
            result = x * expBySquare(x*x, (n-1)/2);
        }
        return result;
    }
}
