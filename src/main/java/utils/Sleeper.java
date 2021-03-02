package utils;

import java.util.concurrent.TimeUnit;

public class Sleeper {

    Logger log = new Logger();

    public Sleeper() {
    }

    /**
     * Sleep for milliseconds
     *
     * @param milliseconds milliseconds
     */
    public void sleepForMilliseconds(Integer milliseconds) {
        log.debug("Sleep for " + milliseconds + " milliseconds.");
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sleep for seconds
     *
     * @param seconds seconds
     */
    public void sleepForSeconds(Integer seconds) {
        log.debug("Sleep for " + seconds + " seconds.");
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
