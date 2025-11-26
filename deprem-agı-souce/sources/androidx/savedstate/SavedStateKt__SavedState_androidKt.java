package androidx.savedstate;

import W2.s;
import W2.y;
import X2.M;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import k3.l;
import kotlin.jvm.internal.t;

final /* synthetic */ class SavedStateKt__SavedState_androidKt {
    public static final Bundle savedState(Map<String, ? extends Object> map, l lVar) {
        s[] sVarArr;
        t.e(map, "initialState");
        t.e(lVar, "builderAction");
        if (map.isEmpty()) {
            sVarArr = new s[0];
        } else {
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry next : map.entrySet()) {
                arrayList.add(y.a((String) next.getKey(), next.getValue()));
            }
            sVarArr = (s[]) arrayList.toArray(new s[0]);
        }
        Bundle bundleOf = BundleKt.bundleOf((s[]) Arrays.copyOf(sVarArr, sVarArr.length));
        lVar.invoke(SavedStateWriter.m155boximpl(SavedStateWriter.m157constructorimpl(bundleOf)));
        return bundleOf;
    }

    public static /* synthetic */ Bundle savedState$default(Bundle bundle, l lVar, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            lVar = SavedStateKt__SavedState_androidKt$savedState$3.INSTANCE;
        }
        t.e(bundle, "initialState");
        t.e(lVar, "builderAction");
        Bundle bundle2 = new Bundle(bundle);
        lVar.invoke(SavedStateWriter.m155boximpl(SavedStateWriter.m157constructorimpl(bundle2)));
        return bundle2;
    }

    public static /* synthetic */ Bundle savedState$default(Map map, l lVar, int i5, Object obj) {
        s[] sVarArr;
        if ((i5 & 1) != 0) {
            map = M.h();
        }
        if ((i5 & 2) != 0) {
            lVar = SavedStateKt__SavedState_androidKt$savedState$1.INSTANCE;
        }
        t.e(map, "initialState");
        t.e(lVar, "builderAction");
        if (map.isEmpty()) {
            sVarArr = new s[0];
        } else {
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(y.a((String) entry.getKey(), entry.getValue()));
            }
            sVarArr = (s[]) arrayList.toArray(new s[0]);
        }
        Bundle bundleOf = BundleKt.bundleOf((s[]) Arrays.copyOf(sVarArr, sVarArr.length));
        lVar.invoke(SavedStateWriter.m155boximpl(SavedStateWriter.m157constructorimpl(bundleOf)));
        return bundleOf;
    }

    public static final Bundle savedState(Bundle bundle, l lVar) {
        t.e(bundle, "initialState");
        t.e(lVar, "builderAction");
        Bundle bundle2 = new Bundle(bundle);
        lVar.invoke(SavedStateWriter.m155boximpl(SavedStateWriter.m157constructorimpl(bundle2)));
        return bundle2;
    }
}
