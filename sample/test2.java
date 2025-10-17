package sample;

public class test2 {
    private int count;
    private int unusedValue = 10;

    public SampleClass() {
        count = 0;
    }

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public void displayMessage() {
        System.out.println("Hello from SampleClass!");
    }
}
