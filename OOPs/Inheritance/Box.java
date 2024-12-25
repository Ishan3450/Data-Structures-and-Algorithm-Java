package OOPs.Inheritance;

// Box contains threee properties : S{height, width, length}
public class Box {
    double height;
    double width;
    double length;

    // default constructor
    Box(){
        height = -1;
        width = -1;
        length = -1;
    }
    
    // Constructor overloading 
    Box(double height, double width, double length){
        this.height = height;
        this.width = width;
        this.length = length;
    }

    // Square
    Box(double side){
        this.height = side;
        this.width = side;
        this.length = side;
    }

    // copying Box into another one
    Box(Box oldBox){
        this.height = oldBox.height;
        this.width = oldBox.width;
        this.length = oldBox.length;
    }
    

    public void getBoxData(){
        System.out.println(height + " " + width + " " + length);
    }

}
