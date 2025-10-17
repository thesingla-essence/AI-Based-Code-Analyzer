package sample;

public class ComplexClass {

    public void processData(int[] data) {
        int total = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > 0) {
                for (int j = 0; j < i; j++) {
                    if (data[j] % 2 == 0) {
                        if (data[j] > 10) {
                            total += data[j];
                        }
                    }
                }
            }
        }

        if (total > 100)
            System.out.println("High total value");
        else
            System.out.println("Low total value");
    }

    public void dummyMethod() {
        int unusedVar = 100;
    }
}
