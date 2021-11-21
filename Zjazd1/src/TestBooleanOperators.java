public class TestBooleanOperators {
    public static void main(String[] args) {
        for (int i = 10; i >= 0; i--) {
            if(i==0) {
                System.out.println("Launching rocket...");
                break;
            }

            System.out.println(i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Countdown interrupted.");
            }
        }
    }
}