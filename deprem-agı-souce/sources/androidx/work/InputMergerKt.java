package androidx.work;

import kotlin.jvm.internal.t;

public final class InputMergerKt {
    private static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("InputMerger");
        t.d(tagWithPrefix, "tagWithPrefix(...)");
        TAG = tagWithPrefix;
    }

    public static final InputMerger fromClassName(String str) {
        t.e(str, "className");
        try {
            Object newInstance = Class.forName(str).getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
            t.c(newInstance, "null cannot be cast to non-null type androidx.work.InputMerger");
            return (InputMerger) newInstance;
        } catch (Exception e5) {
            Logger logger = Logger.get();
            String str2 = TAG;
            logger.error(str2, "Trouble instantiating " + str, e5);
            return null;
        }
    }
}
