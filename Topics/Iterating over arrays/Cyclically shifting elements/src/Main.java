import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[Integer.parseInt(scanner.nextLine())];
        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.print(a[a.length - 1] + " ");
        for (int i = 0; i < a.length - 1; i++) {
            System.out.print(a[i] + " ");
        }
    }
}