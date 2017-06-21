class FixedQueue {
    private char q[];
    private int putloc, getloc;

    public FixedQueue (int size) {
        q = new char[size];
        putloc = getloc = 0;
    }

    public void put(char ch) {
        if(putloc == q.length) {
            System.out.println(" - Queue is full.");
            return;
        }
        q[putloc++] = ch;
    }

    public char get(int getlocation) {
        return q[getlocation];
    }
}