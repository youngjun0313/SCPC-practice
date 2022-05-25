public class Sandbox {
    public static void main(String[] args) {
//        rec(20000);
        for (int i = 0; i < 1000000; i++) {
            if(i==29999)
                System.out.println(i);
        }
    }

    private static void rec(int n) {
        if(n==0) {
            System.out.println(n);
        }  else {
            rec(n-1);
        }
    }
}
