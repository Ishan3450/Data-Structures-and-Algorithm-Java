package OOPs.Inheritance;

public class Main {

    public static void main(String[] args){
        // default constructor
        Box b1 = new Box();
        b1.getBoxData();

        // one arguement constructor
        Box b2 = new Box(7.5d);
        b2.getBoxData();

        // constructor taking all the arguements
        Box b3 = new Box(6.4d, 6.3d, 8.5d);
        b3.getBoxData();

        // copying default constructor b1 into b3
        b3 = new Box(b1);
        b3.getBoxData();

        System.out.println();

        // creating weighted box
        WeightedBox wb1 = new WeightedBox(6.4d, 6.3d, 8.5d, 10);

        wb1.getWeightedBoxData();

    }

}
