package sample;

public class ControlFlowHeavy {

    public void evaluate(int value) {
        if (value > 100) {
            System.out.println("High");
        } else if (value > 50) {
            System.out.println("Medium");
        } else if (value > 25) {
            System.out.println("Low");
        } else if (value > 10) {
            System.out.println("Very Low");
        } else {
            System.out.println("Tiny");
        }

        switch (value % 3) {
            case 0:
                System.out.println("Divisible by 3");
                break;
            case 1:
                System.out.println("Remainder 1");
                break;
            default:
                System.out.println("Remainder 2");
        }
    }
}
