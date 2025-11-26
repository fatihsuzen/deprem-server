package androidx.work;

import androidx.annotation.NonNull;
import androidx.work.OneTimeWorkRequest;
import j3.C2582a;
import kotlin.jvm.internal.t;
import r3.C2733c;

public final class OneTimeWorkRequestKt {
    public static final OneTimeWorkRequest.Builder setInputMerger(OneTimeWorkRequest.Builder builder, @NonNull C2733c cVar) {
        t.e(builder, "<this>");
        t.e(cVar, "inputMerger");
        return builder.setInputMerger(C2582a.a(cVar));
    }
}
