import java.time.Duration;
import java.time.Instant;

public class Timer {
    private final Instant creationTime;
    private Instant currentTime;

    public Timer() {
        creationTime = Instant.ofEpochMilli(System.currentTimeMillis());
    }

    public long getCurrentTime() {
        currentTime = Instant.ofEpochMilli(System.currentTimeMillis());
        return Duration.between(creationTime, currentTime).toMillis();
    }

    public Instant getCreationTime() {
        return creationTime;
    }

    public static void main(String[] args) {
        Timer timer = new Timer();

        System.out.println(timer.getCreationTime());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(timer.getCurrentTime());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(timer.getCurrentTime());
    }
}
