import java.util.Scanner;
public class GameAlgo {
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        long t;
        t= sc.nextInt();
        while(t!=0) {
            long N, Buffer, Oc = 0, Ec = 0;
            String S = "";
            N = sc.nextInt();
            for (long i = 0; i < N; i++) {
                Buffer = sc.nextInt();
                if (Buffer % 2 == 0) {
                    Ec++;
                } else {
                    Oc++;
                }
            }
            if (Oc % 4 == 1) {
                if (Ec % 2 == 0) {
                    S += "Bob";
                } else {
                    S += "Alice";
                }
            } else if (Oc % 4 == 3 || Oc % 4 == 0) {
                S += "Alice";
            } else {
                S += "Bob";
            }
            t--;
            System.out.println(S);
        }
    }
}
