package OOPs.Inheritance;

public class WeightedBox extends Box{
    double weight;

    WeightedBox(double height, double width, double length, double weight){
        super(height, width, length);
        this.weight = weight;
    }

    public void getWeightedBoxData(){
        System.out.println(height + " " + width + " " + length + " " + weight);
        
    }
}