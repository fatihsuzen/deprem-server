package androidx.room.coroutines;

import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import java.util.Arrays;
import k3.l;
import kotlin.jvm.internal.t;
import z3.C2972e;
import z3.C2974g;

public final class FlowUtil {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <R> C2972e createFlow(RoomDatabase roomDatabase, boolean z4, String[] strArr, l lVar) {
        t.e(roomDatabase, "db");
        t.e(strArr, "tableNames");
        t.e(lVar, "block");
        return new FlowUtil$createFlow$$inlined$map$1(C2974g.i(roomDatabase.getInvalidationTracker().createFlow((String[]) Arrays.copyOf(strArr, strArr.length), true)), roomDatabase, z4, lVar);
    }
}
