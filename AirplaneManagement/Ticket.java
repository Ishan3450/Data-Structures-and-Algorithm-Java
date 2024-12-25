package AirplaneManagement;

public class Ticket {
    char row;
    int seat, price;
    Person owner;

    public Ticket(char row, int seat, int price, Person owner) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.owner = owner;
    }

    public char getRow() {
        return row;
    }

    public void setRow(char row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Ticket [row=" + row + ", seat=" + seat + ", price=" + price + ", owner=" + owner + "]";
    }
}
