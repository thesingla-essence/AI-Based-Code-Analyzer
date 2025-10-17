package sample;

public class test1 {
    int a = 5;
    int b = 10;
    int c = 0;
    int unused1 = 100;
    int unused2;
    String name = "Sayak";

    public void complicatedMethod() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < 5; j++) {
                    if (j > 2) {
                        for (int k = 0; k < 3; k++) {
                            if (k == 1) {
                                System.out.println("Deep nesting level");
                            } else {
                                if (k == 2) {
                                    System.out.println("Still deeper");
                                } else {
                                    if (k == 0) {
                                        System.out.println("Even deeper");
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (i == 5) {
                System.out.println("Midpoint reached");
            } else {
                System.out.println("Odd value: " + i);
            }
        }

        int temp = 0;
        while (temp < 10) {
            switch (temp % 3) {
                case 0:
                    System.out.println("Zero case");
                    break;
                case 1:
                    System.out.println("One case");
                    break;
                default:
                    System.out.println("Other case");
            }
            temp++;
        }

        if (a > 0 && b > 0 && c >= 0 && a + b + c < 100 && name.length() > 0 && temp > -1 && a != b && !(a > b)) {
            System.out.println("Unnecessarily long condition.");
        }
    }

    public void redundant() {
        int x = 5;
        int y = 10;
        int z = 15;
        x++;
        y++;
        z++;
    }

    public void emptyBlock() {
    }

    public void noPurpose() {
        int random = 99;
    }
}
