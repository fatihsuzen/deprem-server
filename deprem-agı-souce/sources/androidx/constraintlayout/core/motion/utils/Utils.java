package androidx.constraintlayout.core.motion.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Arrays;

public class Utils {
    static DebugHandle sOurHandle;

    public interface DebugHandle {
        void message(String str);
    }

    private static int clamp(int i5) {
        int i6 = (i5 & (~(i5 >> 31))) - 255;
        return (i6 & (i6 >> 31)) + 255;
    }

    public static void log(String str, String str2) {
        PrintStream printStream = System.out;
        printStream.println(str + " : " + str2);
    }

    public static void logStack(String str, int i5) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int min = Math.min(i5, stackTrace.length - 1);
        String str2 = " ";
        for (int i6 = 1; i6 <= min; i6++) {
            StackTraceElement stackTraceElement = stackTrace[i6];
            str2 = str2 + " ";
            PrintStream printStream = System.out;
            printStream.println(str + str2 + (".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()) + str2);
        }
    }

    public static void loge(String str, String str2) {
        PrintStream printStream = System.err;
        printStream.println(str + " : " + str2);
    }

    public static int rgbaTocColor(float f5, float f6, float f7, float f8) {
        int clamp = clamp((int) (f5 * 255.0f));
        int clamp2 = clamp((int) (f6 * 255.0f));
        return (clamp << 16) | (clamp((int) (f8 * 255.0f)) << 24) | (clamp2 << 8) | clamp((int) (f7 * 255.0f));
    }

    public static void setDebugHandle(DebugHandle debugHandle) {
        sOurHandle = debugHandle;
    }

    public static void socketSend(String str) {
        try {
            OutputStream outputStream = new Socket("127.0.0.1", 5327).getOutputStream();
            outputStream.write(str.getBytes());
            outputStream.close();
        } catch (IOException e5) {
            PrintStream printStream = System.err;
            printStream.println(e5.toString() + "\n" + Arrays.toString(e5.getStackTrace()).replace("[", "   at ").replace(",", "\n   at").replace("]", ""));
        }
    }

    public int getInterpolatedColor(float[] fArr) {
        int clamp = clamp((int) (((float) Math.pow((double) fArr[0], 0.45454545454545453d)) * 255.0f));
        int clamp2 = clamp((int) (((float) Math.pow((double) fArr[1], 0.45454545454545453d)) * 255.0f));
        return (clamp((int) (fArr[3] * 255.0f)) << 24) | (clamp << 16) | (clamp2 << 8) | clamp((int) (((float) Math.pow((double) fArr[2], 0.45454545454545453d)) * 255.0f));
    }

    public static void log(String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String substring = (stackTraceElement.getMethodName() + "                  ").substring(0, 17);
        String str2 = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")" + "    ".substring(Integer.toString(stackTraceElement.getLineNumber()).length()) + substring;
        System.out.println(str2 + " " + str);
        DebugHandle debugHandle = sOurHandle;
        if (debugHandle != null) {
            debugHandle.message(str2 + " " + str);
        }
    }
}
