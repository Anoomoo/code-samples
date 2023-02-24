public class Main {
    public static void main(String[] args) {
        calcBucket(17, 11, 6);
        System.out.println();
        calcBucket(98, 11, 6);
        System.out.println();
        calcBucket(92, 11, 6);
    }
    public static void calcBucket(int value, int tableSize, int count) {
        for (int i = 0; i <= count; i++) {
            System.out.printf(" %d", (h1(value) + (i * h2(value))) % tableSize);
        }
    }

    public static int h1(int value) {
        return value % 11;
    }

    public static int h2(int value) {
        return 5 - (value % 5);
    }
}