import java.util.*;

public class Solution {

        int n;

        public static void main(String args[]){
            Solution s=new Solution();
            s.calculate();

        }

        public void calculate(){

            Scanner sc=new Scanner(System.in);
            n=sc.nextInt();
            sc.nextLine();

            ArrayList<Crypto> crypto=new ArrayList<>();


            for(int i=0;i<n;i++){

                int N=sc.nextInt();
                int noOfNumbers=sc.nextInt();
                sc.nextLine();

                ArrayList<Long> tempNumbers=new ArrayList<>();
                for(int k=0;k<noOfNumbers;k++)
                    tempNumbers.add(sc.nextLong());
                crypto.add(new Crypto(N,noOfNumbers,tempNumbers));
                sc.nextLine();
            }

            for(int i=0;i<n;i++){
                ArrayList<Long> primeWithSequence=new ArrayList<>();
                HashSet<Long> primeNumbers=new HashSet<>();
                HashMap<Long,Character> primeMapping=new HashMap<>();

                ArrayList<Long> cipherNumbers=crypto.get(i).getNumbers();
                long f1=0,f2=0;

                long firstCipher=cipherNumbers.get(0);
                f1=firstFactor(firstCipher);
                f2=firstCipher/f1;

                if(cipherNumbers.get(1)%f1==0) {
                    primeWithSequence.add(f2);
                    primeWithSequence.add(f1);
                }
                else{
                    primeWithSequence.add(f1);
                    primeWithSequence.add(f2);
                }

                for(int k=1;k<cipherNumbers.size();k++){
                   primeWithSequence.add(cipherNumbers.get(k)/primeWithSequence.get(k));
                }



                primeNumbers=new HashSet<>(primeWithSequence);
                ArrayList<Long> primeNos=new ArrayList<>(primeNumbers);
                Collections.sort(primeNos);

             int alphabets=65;
             for(int m=0;m<26;m++){
                 primeMapping.put(primeNos.get(m),(char)alphabets);
                 alphabets++;
             }
             System.out.print("Case #"+(i+1)+": ");
             for(int z=0;z <primeWithSequence.size();z++){
                 System.out.print(primeMapping.get(primeWithSequence.get(z)));
             }
             System.out.println("");

            }

        }

        private long firstFactor(long number){

            for(int i=1;i<number;i++){
                if(number%i==0){
                    if(i!=1)
                        return i;
                }
            }
            return -1;
        }
}



class Crypto{

    int N;
    int noOfNumbers;
    ArrayList<Long> numbers;

    public Crypto(int n, int noOfNumbers, ArrayList<Long> numbers) {
        N = n;
        this.noOfNumbers = noOfNumbers;
        this.numbers = numbers;
    }

    public ArrayList<Long> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<Long> numbers) {
        this.numbers = numbers;
    }

    public int getN() {
        return N;
    }

    public void setN(int n) {
        N = n;
    }

    public int getNoOfNumbers() {
        return noOfNumbers;
    }

    public void setNoOfNumbers(int noOfNumbers) {
        this.noOfNumbers = noOfNumbers;
    }
}
