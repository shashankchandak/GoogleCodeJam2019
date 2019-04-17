import java.math.BigInteger;
import java.util.Scanner;

public class ForegoneSolution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int noOfTestCases = sc.nextInt();
        for (int i = 1; i <= noOfTestCases; i++) {

            BigInteger number = sc.nextBigInteger();
            StringBuilder newNumber = new StringBuilder(number.toString());

            for (int j = 0; j < number.toString().length(); j++) {
                if (newNumber.toString().charAt(j)=='4')
                    newNumber.setCharAt(j, '2');
            }
                System.out.println("Case #" + i + ": " + newNumber.toString() + " " + number.subtract(new BigInteger(newNumber.toString())));
        }
    }
}