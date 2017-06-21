class QDemo {
    public static void main(String args[]) {
        FixedQueue q1 = new FixedQueue(5);
        q1.put((char) ('A'));
        System.out.println("Char at 0 - " + q1.get(0));
        System.out.println("Char at 1 - " + q1.get(1));
    }
}