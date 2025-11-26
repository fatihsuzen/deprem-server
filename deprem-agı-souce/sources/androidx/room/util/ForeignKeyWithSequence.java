package androidx.room.util;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.jvm.internal.t;

final class ForeignKeyWithSequence implements Comparable<ForeignKeyWithSequence> {
    private final String from;
    private final int id;
    private final int sequence;
    private final String to;

    public ForeignKeyWithSequence(int i5, int i6, String str, String str2) {
        t.e(str, TypedValues.TransitionType.S_FROM);
        t.e(str2, TypedValues.TransitionType.S_TO);
        this.id = i5;
        this.sequence = i6;
        this.from = str;
        this.to = str2;
    }

    public final String getFrom() {
        return this.from;
    }

    public final int getId() {
        return this.id;
    }

    public final int getSequence() {
        return this.sequence;
    }

    public final String getTo() {
        return this.to;
    }

    public int compareTo(ForeignKeyWithSequence foreignKeyWithSequence) {
        t.e(foreignKeyWithSequence, "other");
        int i5 = this.id - foreignKeyWithSequence.id;
        return i5 == 0 ? this.sequence - foreignKeyWithSequence.sequence : i5;
    }
}
