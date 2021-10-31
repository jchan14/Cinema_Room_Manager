import java.util.*;

class FixingStringIndexOutOfBoundsException {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();
        int index = scanner.nextInt();

        System.out.println(string.length() > index && index >= 0 ? string.charAt(index) : "Out of bounds!");
    }
}