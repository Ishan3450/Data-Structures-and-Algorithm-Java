package OOPs;

public class Main {
    public static void main(String[] args) {
        Hooman h1 = new Hooman("Ishan Jagani", 84.9f, 18, false);
        Hooman h2 = new Hooman("Something Something", 80.9f, 54, true);

        h1.getHoomanInfo();
        System.out.println();
        h2.getHoomanInfo();
        System.out.println("-----------------------");
        System.out.println("Population: " + h1.getPopulationCount());
    }
}
