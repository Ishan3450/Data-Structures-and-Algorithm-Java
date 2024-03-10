package AirplaneManagement;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class PlaneManagement {
    static int[] A = new int[14];
    static int[] B = new int[12];
    static int[] C = new int[12];
    static int[] D = new int[14];
    static Ticket[] tickets = new Ticket[52]; // 14 + 14 + 12 + 12 = 52 seats in total
    static int ticketNumber = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Plane Management application");
        int choice = 0;

        do {
            System.out.println("*********************************************************");
            System.out.println("*\t\t\tMENU OPTIONS\t\t\t*");
            System.out.println("*********************************************************");
            System.out.println("\t 1) Buy a seat");
            System.out.println("\t 2) Cancel a seat");
            System.out.println("\t 3) Find first available seat");
            System.out.println("\t 4) Show seating plan");
            System.out.println("\t 5) Print tickets information and total sales");
            System.out.println("\t 6) Search ticket");
            System.out.println("\t 0) Quit");
            System.out.println("*********************************************************");
            System.out.print("Please select an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    buy_seat();
                    break;

                case 2:
                    cancel_seat();
                    break;

                case 3:
                    find_first_available();
                    break;

                case 4:
                    show_seating_plan();
                    break;

                case 5:
                    print_tickets_info();
                    break;

                case 6:
                    search_ticket();
                    break;

                default:
                    choice = 0;
                    break;
            }

            System.out.println();
        } while (choice != 0);
    }
    
    public static void buy_seat() {
        System.out.println("Enter row letter: ");
        char row = sc.next().toUpperCase().charAt(0);

        // checking seat validity
        if (row < 65 || row > 68) {
            System.out.println("Invalid row letter");
            return;
        }

        System.out.println("Enter seat number: ");
        int seatNo = sc.nextInt();

        if (row == 'A' || row == 'D') {
            if (seatNo < 1 || seatNo > 14) {
                System.out.println("Invalid seat number !!");
                return;
            }
        }

        if (row == 'B' || row == 'C') {
            if (seatNo < 1 || seatNo > 12) {
                System.out.println("Invalid seat number !!");
                return;
            }
        }

        Person customer = createPerson();
        boolean isValid = false;

        // seat booking
        if (row == 'A') {
            if (A[seatNo - 1] == 0) {
                isValid = true;
                System.out.println("Seat booked");
                A[seatNo - 1] = 1;
            } else {
                System.out.println("Seat not available");
            }
        } else if (row == 'B') {
            if (B[seatNo - 1] == 0) {
                isValid = true;
                System.out.println("Seat booked");
                B[seatNo - 1] = 1;
            } else {
                System.out.println("Seat not available");
            }
        } else if (row == 'C') {
            if (C[seatNo - 1] == 0) {
                isValid = true;
                System.out.println("Seat booked");
                C[seatNo - 1] = 1;
            } else {
                System.out.println("Seat not available");
            }
        } else if (row == 'D') {
            if (D[seatNo - 1] == 0) {
                isValid = true;
                System.out.println("Seat booked");
                D[seatNo - 1] = 1;
            } else {
                System.out.println("Seat not available");
            }
        }

        if (isValid) {
            Ticket newTicket = new Ticket(row, seatNo, getTicketCost(seatNo), customer);
            tickets[ticketNumber++] = newTicket;
            save(row, seatNo, newTicket);
        }
    }

    public static void cancel_seat() {
        System.out.println("Enter row letter: ");
        char row = sc.next().toUpperCase().charAt(0);

        // checking seat validity
        if (row < 65 || row > 68) {
            System.out.println("Invalid row letter");
            return;
        }

        System.out.println("Enter seat number: ");
        int seatNo = sc.nextInt();

        if (row == 'A' || row == 'D') {
            if (seatNo < 1 || seatNo > 14) {
                System.out.println("Invalid seat number !!");
                return;
            }
        }

        if (row == 'B' || row == 'C') {
            if (seatNo < 1 || seatNo > 12) {
                System.out.println("Invalid seat number !!");
                return;
            }
        }

        // seat cancelling
        if (row == 'A') {
            if (A[seatNo - 1] == 1) {
                System.out.println("Seat cancelled");
                A[seatNo - 1] = 0;
                cancelTicket('A', seatNo);
            } else {
                System.out.println("Seat already available !!");
            }
        } else if (row == 'B') {
            if (B[seatNo - 1] == 1) {
                System.out.println("Seat cancelled");
                B[seatNo - 1] = 0;
                cancelTicket('B', seatNo);
            } else {
                System.out.println("Seat already available !!");
            }
        } else if (row == 'C') {
            if (C[seatNo - 1] == 1) {
                System.out.println("Seat cancelled");
                C[seatNo - 1] = 0;
                cancelTicket('C', seatNo);
            } else {
                System.out.println("Seat already available !!");
            }
        } else if (row == 'D') {
            if (D[seatNo - 1] == 1) {
                System.out.println("Seat cancelled");
                D[seatNo - 1] = 0;
                cancelTicket('D', seatNo);
            } else {
                System.out.println("Seat already available !!");
            }
        }
    }

    public static void find_first_available() {
        for (int i = 0; i < 14; i++) {
            if (A[i] == 0) {
                System.out.println("First Seat Available: ROW A & SEAT " + (i + 1));
                return;
            }
        }

        for (int i = 0; i < 12; i++) {
            if (B[i] == 0) {
                System.out.println("First Seat Available: ROW B & SEAT " + (i + 1));
                return;
            }
        }

        for (int i = 0; i < 12; i++) {
            if (C[i] == 0) {
                System.out.println("First Seat Available: ROW C & SEAT " + (i + 1));
                return;
            }
        }

        for (int i = 0; i < 14; i++) {
            if (D[i] == 0) {
                System.out.println("First Seat Available: ROW D & SEAT " + (i + 1));
                return;
            }
        }
    }

    public static void show_seating_plan() {
        for (int i = 0; i < 14; i++) {
            System.out.print(A[i] == 0 ? "O" : "X");
        }
        System.out.println();

        for (int i = 0; i < 12; i++) {
            System.out.print(B[i] == 0 ? "O" : "X");
        }
        System.out.println();

        for (int i = 0; i < 12; i++) {
            System.out.print(C[i] == 0 ? "O" : "X");
        }
        System.out.println();

        for (int i = 0; i < 14; i++) {
            System.out.print(D[i] == 0 ? "O" : "X");
        }
        System.out.println();
    }

    public static void print_tickets_info() {
        int totalCounter = 0;
        System.out.println("Tickets sold during this session:");
        System.out.println("*******************************************");

        for (int i = 0; i < ticketNumber; i++) {
            System.out.println(tickets[i]);
            totalCounter += tickets[i].price;
        }

        System.out.println("*******************************************");
        System.out.println("Total Counter: " + totalCounter);

        System.out.println();
    }

    public static void search_ticket() {
        System.out.println("Enter row letter: ");
        char row = sc.next().toUpperCase().charAt(0);

        // checking seat validity
        if (row < 65 || row > 68) {
            System.out.println("Invalid row letter");
            return;
        }

        System.out.println("Enter seat number: ");
        int seatNo = sc.nextInt();

        if (row == 'A' || row == 'D') {
            if (seatNo < 1 || seatNo > 14) {
                System.out.println("Invalid seat number !!");
                return;
            }
        }

        boolean isTicketFound = false;
    
        for(int i = 0; i < ticketNumber; i ++){
            Ticket ticket = tickets[i];

            if(ticket.row == row && ticket.seat == seatNo){
                System.out.println(ticket);
                isTicketFound = true;
                break;
            }
        }

        if(!isTicketFound){
            System.out.println("This seat is available");
        }
    }

    public static void save(char row, int seat, Ticket t){
        try{
            final String fileName = "AirplaneManagement/" + row + "" + seat + ".txt";

            File file = new File(fileName);
            FileWriter writer = new FileWriter(file);

            writer.write(t.toString());
            writer.close();
        } catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

    /* Util methods */

    private static Person createPerson() {
        String name, surname, email;

        System.out.print("Enter your name: ");
        sc.nextLine();
        name = sc.nextLine();

        System.out.print("Enter your surname: ");
        surname = sc.nextLine();

        System.out.print("Enter your email: ");
        email = sc.nextLine();

        return new Person(name, surname, email);
    }

    private static int getTicketCost(int seatNo) {
        if (seatNo >= 1 && seatNo <= 5)
            return 200;
        if (seatNo >= 6 && seatNo <= 9)
            return 150;
        if (seatNo >= 10 && seatNo <= 14)
            return 180;
        return 0;
    }

    private static void cancelTicket(char row, int seatNo) {
        int i = 0;

        while (i < ticketNumber) {
            Ticket curr = tickets[i];

            if (curr.row == row && curr.seat == seatNo) {
                break;
            }

            i++;
        }

        // process to remove the ticket with corresponding row and seatNo
        while (i < ticketNumber - 1) {
            tickets[i] = tickets[i + 1];
            i++;
        }
        ticketNumber--;
    }

}
