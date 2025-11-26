package androidx.work;

import kotlin.jvm.internal.t;

public final class NoOpInputMergerFactory extends InputMergerFactory {
    public static final NoOpInputMergerFactory INSTANCE = new NoOpInputMergerFactory();

    private NoOpInputMergerFactory() {
    }

    public Void createInputMerger(String str) {
        t.e(str, "className");
        return null;
    }
}
