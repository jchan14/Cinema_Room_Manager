package cinema;

import java.util.Scanner;

public class Cinema {
    final static int THRESHOLD = 60;
    private int row;
    private int seat;
    private char[][] matrix;
    final private String SPACE = " ";
    private int sold;
    private int income;



    public static void main(String[] args) {
        exercise5();
    }

    public Cinema(int row, int seat) {
        this.row = row;
        this.seat = seat;
        matrix = new char[row][seat];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < seat; j++) {
                matrix[i][j] = 'S';
            }
        }
    }

    private void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int input;
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println();
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            try {
                input = Integer.parseInt(scanner.nextLine());
                switch (input) {
                    case 0:
                        keepGoing = false;
//                        System.exit(0);
                        break;
                    case 1:
                        printScheme();
                        break;
                    case 2:
                        buyTicket();
                        break;
                    case 3:
                        showStatistics();
                        break;
                    default:
                        System.out.println("i'm confused... what did you enter? " + input);
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input.  Please try again.");
            }
        }
    }

    private void showStatistics() {
        System.out.println();
        System.out.println("Number of purchased tickets: " + sold);
        System.out.println(String.format("Percentage: %.2f%%", (float) sold / (row * seat) * 100));
        System.out.println("Current income: $" + income);
        System.out.println("Total income: $"+ calculateIncome());
    }

    public int calculateIncome() {
        int total = row * seat;
        int income;

        if (total > THRESHOLD) {
            income = row / 2 * seat * 10 + (row - row / 2) * seat * 8;
        } else {
            income = total * 10;
        }
//        System.out.println("Total income:");
//        System.out.println("$" + income);
        return income;
    }

    public void calculateTicketPrice(int seatRow, int seatNumber) {
        int total = row * seat;
        int price;

        if (total > THRESHOLD) {
            price = seatRow - 1 < (row / 2) ? 10 : 8;
        } else {
            price = 10;
        }
        System.out.print("\nTicket price: ");
        System.out.println("$" + price);
        income+=price;
    }

    private void updateSeat(int seatRow, int seatNumber, char character) {
        matrix[seatRow - 1][seatNumber - 1] = character;
    }

    public static void exercise5() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
//        int row = scanner.nextInt();
        int row = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the number of seats in each row:");
//        int seat = scanner.nextInt();
        int seat = Integer.parseInt(scanner.nextLine());
        Cinema c = new Cinema(row, seat);
        c.displayMenu();
    }

    private boolean isSeatAvailable(int row, int seat) {
        return matrix[row - 1][seat - 1] == 'S' ? true : false;
    }

    private void buyTicket() {
        Scanner scanner = new Scanner(System.in);
        boolean isRequestValid = false;
        int seatRow;
        int seatNumber;

        while (true) {
            System.out.println();
            System.out.println("Enter a row number:");
            seatRow = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter a seat number in that row:");
            seatNumber = Integer.parseInt(scanner.nextLine());

            try {
                isRequestValid = isSeatAvailable(seatRow, seatNumber);
                if (isRequestValid) {
                    calculateTicketPrice(seatRow, seatNumber);
                    updateSeat(seatRow, seatNumber, 'B');
                    sold++;
                    break;
                } else {
                    System.out.println("\nThat ticket has already been purchased!\n");
                }
            } catch (Exception e) {
                System.out.println("\nWrong input!");
            }
        }
    }

//    private void printScheme() {
//        System.out.println("Cinema:");
//        for (int a = 0; a < row + 1; a++) {
//            for (int b = 0; b < seat + 1; b++) {
//                if (a == 0) {
//                    if (b == 0) {
//                        System.out.print(SPACE + SPACE);
//                    } else {
//                        System.out.print(b + SPACE);
//                    }
//                } else if (a > 0) {
//                    if (b == 0) {
//                        System.out.print(a + SPACE);
//                    } else {
//                        System.out.print("S" + SPACE);
//                    }
//                }
//            }
//            System.out.println();
//        }
//    }

    private void printScheme() {
        System.out.println();
        System.out.println("Cinema:");
        System.out.print(SPACE + SPACE);
        for (int i = 1; i <= seat; i++) {
            System.out.print(i + SPACE);
        }
        System.out.println();
        for (int i = 0; i < row; i++) {
            System.out.print(i + 1 + SPACE);
            for (int j = 0; j < seat; j++) {
                System.out.print(matrix[i][j] + SPACE);
            }
            System.out.println();
        }
    }
}


//package cinema;
//
//        import java.util.Scanner;
//
//public class Cinema {
//
//    public static void main(String[] args) {
//        // Write your code here
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter the number of rows: ");
//        int rows = scanner.nextInt();
//        System.out.println("Enter the number of seats in each row:");
//        int columns = scanner.nextInt();
//        printStructure(rows, columns, -1, -1);
//        System.out.println();
//
//        System.out.println("Enter a row number:");
//        int chosenRow = scanner.nextInt();
//        System.out.println("Enter a seat number in that row:");
//        int chosenCol = scanner.nextInt();
//
//        int numberSeats = rows * columns;
//
//        System.out.print("Ticket price: ");
//        if (numberSeats < 60) {
//            System.out.println("$" + 10);
//        } else {
//            int halfFront = (rows / 2) * columns;
//            System.out.println("$" + (halfFront >= chosenRow * columns ? "10" : "8"));
//        }
//
//        printStructure(rows, columns, chosenRow, chosenCol);
//    }
//
//    private static void printStructure(int rows, int columns, int chosenRow, int chosenCol) {
//        System.out.println();
//        System.out.println("Cinema:");
//        for (int i = 0; i <= rows; i++) {
//            System.out.print(i == 0 ? "  " : i + " ");
//            for (int j = 1; j <= columns; j++) {
//                if(i == chosenRow && j == chosenCol) {
//                    System.out.print("B ");
//                } else {
//                    System.out.print(i == 0 ? j + " " : "S ");
//                }
//            }
//            System.out.println();
//        }
//    }
//}