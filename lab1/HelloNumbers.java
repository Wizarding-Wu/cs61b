package exercise.chap1;

public class HelloNumbers {
    public static void main(String[] args) {
        int x = 0, sum = 0;
        while (x < 10) {
            System.out.print(sum + " ");
            x = x + 1;
            sum = sum + x;
        }
        System.out.println();
        System.out.println(5 + 10);
        System.out.println(5 + "10");
    }
}
