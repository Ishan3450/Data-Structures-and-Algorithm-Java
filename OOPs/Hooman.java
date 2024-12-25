package OOPs;

public class Hooman{
    String name = "";
    float weight = 0.0f;
    int age = 0;
    boolean isMarried = false;

    // declaring population as static because it is commong for all human beings
    static long population;
    
    Hooman (String name, float weight, int age, boolean isMarried){
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.isMarried = isMarried;
        population += 1;
    }

    public void getHoomanInfo(){
        System.out.println("Name: " + name);
        System.out.println("Weight: " + weight);
        System.out.println("Age: " + age);
        System.out.println("Realtionship status: " + isMarried);
    }

    public long getPopulationCount(){
        return population;
    }
}