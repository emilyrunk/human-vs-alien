abstract class Human{
    private double weight;
    private double height;

    //Constructor
    Human() {
        weight = height = 0.0;
    }

    Human(double w, double h) {
        weight = w;
        height = h;
    }

    //Getters and Setters
    public double getWeight() {
        return weight;
    }
    public void setWeight(double w) {
        weight = w;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double h) {
        height = h;
    }

    void showStats() {
        System.out.println("Weight is: " + weight + " and height is: " + height );
    }

    void iFart() {
        System.out.print("My farts smell like ");
    }

    void identifyAs() {
        System.out.print("I identify as a ");
    }


}