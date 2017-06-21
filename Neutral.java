class Neutral extends Human {
    private String identity;
    private String farts;

    Neutral() {
        super();
        identity = "none of your business";
        farts = "farts";
    }

    Neutral(double w, double h, String i, String f) {
        super(w, h);
        identity = i;
        farts = f;
    }

    void iFart(){
        super.iFart();
        System.out.println(farts);
    }

    void identifyAs(){
        super.identifyAs();
        System.out.println(identity);
    }
}