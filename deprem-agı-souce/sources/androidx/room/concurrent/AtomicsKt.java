package androidx.room.concurrent;

import androidx.annotation.RestrictTo;
import java.util.concurrent.atomic.AtomicInteger;
import k3.l;
import kotlin.jvm.internal.t;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class AtomicsKt {
    public static final Void loop(AtomicInteger atomicInteger, l lVar) {
        t.e(atomicInteger, "<this>");
        t.e(lVar, "action");
        while (true) {
            lVar.invoke(Integer.valueOf(atomicInteger.get()));
        }
    }
}
