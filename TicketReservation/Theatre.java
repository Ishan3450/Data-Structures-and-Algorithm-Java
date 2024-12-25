package TicketReservation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Theatre {

    static int[] ticketPrice = { 10, 20, 30 }; // ticket price for row 1,2,3 respectively
    static boolean[] row1 = new boolean[12];
    static boolean[] row2 = new boolean[16];
    static boolean[] row3 = new boolean[20];
    static ArrayList<Ticket> ticketsInfo = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to the New Theatre\n");
        int userRes = 0; // userRes is user's response from the menu

        do {
            printMenu();
            userRes = sc.nextInt();
            System.out.println();

            switch (userRes) {

                case 0:
                    break;
                case 1:
                    buy_ticket();
                    break;
                case 2:
                    print_seating_area();
                    break;
                case 3:
                    cancel_ticket();
                    break;
                case 4:
                    show_available();
                    break;
                case 5:
                    try {
                        save_arrays();
                    } catch (IOException e) {
                        System.out.println("ERROR: " + e.getLocalizedMessage());
                    }
                    break;
                case 6:
                    try {
                        load_arrays();
                    } catch (ClassNotFoundException | IOException e) {
                        System.out.println("ERROR: " + e.getLocalizedMessage());
                    }
                    break;
                case 7:
                    show_tickets_info();
                    break;
                case 8:
                    ticketsInfo = (ArrayList<Ticket>) sort_tickets();
                    show_tickets_info();
                    break;
                default:
                    System.out.println("Invalid option, please select a valid one.");

            }
        } while (userRes != 0); // 0 is for exit, so we will keep the loop running till user not enters 0.

    }

    /*
     * Method: to print the options menu
     */
    public static void printMenu() {
        System.out.println();
        System.out.println("----------------------------------------------------");
        System.out.println("Please select an option: \n");
        System.out.println("\t1) Buy a ticket");
        System.out.println("\t2) Print seating area");
        System.out.println("\t3) Cancel ticket");
        System.out.println("\t4) List available seats");
        System.out.println("\t5) Save to file");
        System.out.println("\t6) Load from file");
        System.out.println("\t7) Print ticket information and total price");
        System.out.println("\t8) Sort tickets by price");
        System.out.println("\t0) Quit");
        System.out.println("----------------------------------------------------");
        System.out.print("Enter option: ");

    }

    /*
     * Method: to buy available tickets from the user inputs
     */
    public static void buy_ticket() {
        int rowNo, seatNo;
        Person person;
        String name, surname, email;

        System.out.print("Enter row number: ");
        rowNo = sc.nextInt();

        System.out.print("Enter seat number: ");
        seatNo = sc.nextInt();

        if(rowNo > 3){
            System.out.println("Invalid row number !!");
        } else if (is_seat_available(rowNo, seatNo)) {
            sc.nextLine(); // an extra input to resolve the multiple string input problem in java

            System.out.print("Enter your name: ");
            name = sc.nextLine();

            System.out.print("Enter your surname: ");
            surname = sc.nextLine();

            System.out.print("Enter your email: ");
            email = sc.nextLine();

            person = new Person(name, surname, email);

            // adding the ticket to the ticketInfo list
            Ticket t = new Ticket(rowNo, seatNo, ticketPrice[rowNo - 1], person);
            ticketsInfo.add(t);

            printTicket(t);
        } else {
            System.out.println("Seat not available book another one.");
        }

    }

    /*
     * Method: method which check is the seat (row number and seat number) entered
     * by user is available or not, if available then the corresponding seat will be
     * booked.
     * Reference: used in buy_ticket() method
     */
    public static boolean is_seat_available(int rowNo, int seatNo) {
        switch (rowNo) {
            case 1:
                // if user selects rowNo 1 then we have to choose array row1[]

                // now check if the seat number is available or not
                if (seatNo <= row1.length && row1[seatNo - 1] == false) {
                    row1[seatNo - 1] = true; // marking the seat to 1 which describes booked.
                    return true;
                }
                return false;

            case 2:
                // if user selects rowNo 2 then we have to choose array row2[]
                if (seatNo <= row2.length && row2[seatNo - 1] == false) {
                    row2[seatNo - 1] = true; // marking the seat to 1 which describes booked.
                    return true;
                }
                return false;

            case 3:
                // if user selects rowNo 3 then we have to choose array row2[]

                if (seatNo <= row3.length && row3[seatNo - 1] == false) {
                    row3[seatNo - 1] = true; // marking the seat to 1 which describes booked.
                    return true;
                }
                return false;

            default:
                return false;
        }

    }

    /*
     * Method: prints the seating area of the theatre
     */
    public static void print_seating_area() {
        System.out.println("    *************");
        System.out.println("    *   Stage   *");
        System.out.println("    *************");
        System.out.println();

        // spaces before row 1
        for (int i = 0; i < 4; i++) {
            System.out.print(" ");
        }

        // printing row 1
        for (int i = 0; i < row1.length; i++) {
            if (i == row1.length / 2) {
                System.out.print(" ");
            }

            if (row1[i]) {
                System.out.print("X");
            } else {
                System.out.print("O");
            }
        }
        System.out.println();

        // spaces before row 2
        for (int i = 0; i < 2; i++) {
            System.out.print(" ");
        }

        // printing row 2
        for (int i = 0; i < row2.length; i++) {
            if (i == row2.length / 2) {
                System.out.print(" ");
            }

            if (row2[i]) {
                System.out.print("X");
            } else {
                System.out.print("O");
            }
        }
        System.out.println();

        // printing row 3
        for (int i = 0; i < row3.length; i++) {
            if (i == row3.length / 2) {
                System.out.print(" ");
            }

            if (row3[i]) {
                System.out.print("X");
            } else {
                System.out.print("O");
            }
        }
    }

    /*
     * Method: cancels the booked ticket by the user and acknowledges the user on
     * success.
     */
    public static void cancel_ticket() {
        boolean isCancelled = false; // isCancelled will be used to check the status of the operation
        int rowNo, seatNo;

        System.out.print("Enter row number: ");
        rowNo = sc.nextInt();

        System.out.println();

        System.out.print("Enter seat number: ");
        seatNo = sc.nextInt();

        switch (rowNo) {
            case 1:
                // if user selects rowNo 1 then we have to choose array row1[]

                // now check if the seat number is available or not
                if (seatNo < row1.length && row1[seatNo - 1] == true) {
                    row1[seatNo - 1] = false; // marking the seat to 0 which describes seat is available.
                    isCancelled = true;
                    System.out.println("Ticket cancelled successfully.");
                } else {
                    System.out.println("Invalid entry, do check your row and seat number.");
                }
                break;

            case 2:
                // if user selects rowNo 2 then we have to choose array row2[]
                if (seatNo < row2.length && row2[seatNo - 1] == true) {
                    row2[seatNo - 1] = false; // marking the seat to 0 which describes seat is available.
                    isCancelled = true;
                    System.out.println("Ticket cancelled successfully.");
                } else {
                    System.out.println("Invalid entry, do check your row and seat number.");
                }
                break;

            case 3:
                // if user selects rowNo 3 then we have to choose array row3[]

                if (seatNo < row3.length && row3[seatNo - 1] == true) {
                    row3[seatNo - 1] = false; // marking the seat to 0 which describes seat is available.
                    isCancelled = true;
                    System.out.println("Ticket cancelled successfully.");
                } else {
                    System.out.println("Invalid entry, do check your row and seat number.");
                }
                break;

            default:
                System.out.println("Invalid row number");
        }

        if (isCancelled) { // if the ticked is cancelled then we have to remove it from the ticketInfo
                           // arraylist also
            for (int i = 0; i < ticketsInfo.size(); i++) {
                Ticket curr = ticketsInfo.get(i);

                if (rowNo == curr.row && seatNo == curr.seat) {
                    ticketsInfo.remove(i);
                }
            }
        }
    }

    /*
     * Method: this method prints the available seats with seat numbers with respect
     * to row.
     */
    public static void show_available() {
        // printing available seats in row 1
        System.out.print("Seats available in row 1: ");
        for (int i = 0; i < row1.length; i++) {
            if (!row1[i]) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();

        // printing available seats in row 2
        System.out.print("Seats available in row 2: ");
        for (int i = 0; i < row2.length; i++) {
            if (!row2[i]) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();

        // printing available seats in row 3
        System.out.print("Seats available in row 3: ");
        for (int i = 0; i < row3.length; i++) {
            if (!row3[i]) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();

    }

    /*
     * Method: to save all the current array info to a file.
     */
    public static void save_arrays() throws FileNotFoundException, IOException {
        // merging all the 3 arrays into a 2D array for easy manipulation from/to file
        boolean[][] merged = { row1, row2, row3 };
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./seatInfo.txt"));
        out.writeObject(merged);
        out.flush();
        out.close();

        System.out.println("Saved !!");
    }

    /*
     * Method: to load all the current array info to a file.
     */
    public static void load_arrays() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("./seatInfo.txt"));
        boolean[][] merged = (boolean[][]) in.readObject();
        // updating the newly fetched info of the rows
        row1 = merged[0];
        row2 = merged[1];
        row3 = merged[2];
        in.close();

        System.out.println("Load successfull !!");
    }

    /*
     * Method:
     * Params: Ticket.java class object
     */
    public static void printTicket(Ticket ticket) {
        System.out.println("-----------------------------------------");
        System.out.println("Ticket Information for " + ticket.person.name + " " + ticket.person.surname);
        System.out.println("-----------------------------------------");
        System.out.println("Name: " + ticket.person.name);
        System.out.println("Surname: " + ticket.person.surname);
        System.out.println("Email: " + ticket.person.email);
        System.out.println("Row: " + ticket.row);
        System.out.println("Seat: " + ticket.seat);
        System.out.println("Price: " + ticket.price);
        System.out.println("-----------------------------------------");
    }

    /*
     * Method: prints all the tickets' information and at last the total amount of
     * all the tickets together
     */
    public static void show_tickets_info() {
        int totalAmountToPay = 0;

        for (Ticket elem : ticketsInfo) {
            printTicket(elem);
            totalAmountToPay += elem.price;
        }

        System.out.println("-----------------------------------------");
        System.out.println("Total price of tickets: " + totalAmountToPay);
        System.out.println("-----------------------------------------");

    }

    /*
     * Method: sorts all the tickets according to the price of the tickets
     */
    public static List<Ticket> sort_tickets() {
        List<Ticket> list = new ArrayList<Ticket>();

        list = ticketsInfo;
        /*
         * Sorting Method: Bubble sort algorithm is used for sorting the tickets based
         * on its price in ascending order
         */
        for (int i = 0; i < list.size(); i++) {
            for (int j = 1; j < list.size() - i; j++) {
                if (list.get(j).price < list.get(j - 1).price) {
                    Ticket temp = list.get(j);
                    list.set(j, list.get(j - 1));
                    list.set(j - 1, temp);
                }
            }
        }

        return list;
    }
}
