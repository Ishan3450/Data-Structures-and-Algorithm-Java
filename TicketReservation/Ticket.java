package TicketReservation;

public class Ticket {
    int row, seat, price;
    Person person;

    Ticket(int row, int seat, int price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }
}
