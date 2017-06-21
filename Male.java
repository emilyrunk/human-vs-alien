class Male extends Human {
    private String identity;
    private String farts;

    Male() {
        super();
        identity = "male";
        farts = "roadkill & feet";
    }

    Male(double w, double h, String i, String f) {
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