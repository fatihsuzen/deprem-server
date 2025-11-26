package androidx.savedstate;

import android.os.Bundle;
import k3.l;
import kotlin.jvm.internal.t;

final /* synthetic */ class SavedStateKt__SavedStateKt {
    public static final <T> T read(Bundle bundle, l lVar) {
        t.e(bundle, "<this>");
        t.e(lVar, "block");
        return lVar.invoke(SavedStateReader.m70boximpl(SavedStateReader.m71constructorimpl(bundle)));
    }

    public static final <T> T write(Bundle bundle, l lVar) {
        t.e(bundle, "<this>");
        t.e(lVar, "block");
        return lVar.invoke(SavedStateWriter.m155boximpl(SavedStateWriter.m157constructorimpl(bundle)));
    }
}
