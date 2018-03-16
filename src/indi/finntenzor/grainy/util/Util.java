package indi.finntenzor.grainy.util;

import java.util.Random;

/**
 * Tools class.
 * 
 * @author FinnTenzor
 *
 */
public class Util {
    public final static Random RANDOM = new Random(System.currentTimeMillis());

    /**
     * Convert exception to stack trace string.
     * 
     * @param e Exception.
     * @return Stack trace string.
     */
    public static String exceptionToString(Exception e) {
        StringBuilder sb = new StringBuilder();
        StackTraceElement[] ste = e.getStackTrace();
        sb.append("\n");
        sb.append(e.toString());
        for (StackTraceElement st : ste) {
            sb.append("\n  at ");
            sb.append(st.toString());
        }
        return sb.toString();
    }

    /**
     * Try sleep and not throw.
     * 
     * @param millis Time interval.
     */
    public static void trySleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }

}
