class loopc {
    public static void main(String[] args) {
        int x = -100;
        int count = 0;                     
        do { 
            x = x + 1;
            count++;
        }while (x++ <= 100);
        System.err.println("count");
    }
}