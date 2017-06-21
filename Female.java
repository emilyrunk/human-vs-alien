class Female extends Human {
    private String identity;
    private String farts;

    Female() {
        super();
        identity = "woman";
        farts = "champagne & roses";
    }

    Female(double w, double h) {
        super(w,h);
        identity = "woman";
        farts = "champagne & roses";
    }

    Female(double w, double h, String i, String f) {
        super(w, h);
        identity = i;
        farts = f;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String i) {
        identity = i;
    }

    public String getFarts() {
        return farts;
    }

    public void setFarts(String farts) {
        this.farts = farts;
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