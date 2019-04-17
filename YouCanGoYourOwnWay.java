import java.util.Scanner;

public class YouCanGoYourOwnWay {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int noOfTestcases = sc.nextInt();
            for (int i = 1; i <= noOfTestcases; i++) {

                sc.nextInt();
                String moves = sc.next();
                moves = moves.replaceAll("S", "X").replaceAll("E", "S").replaceAll("X", "E");
                System.out.println("Case #" + i + ": " + moves);
            }
    }

}
