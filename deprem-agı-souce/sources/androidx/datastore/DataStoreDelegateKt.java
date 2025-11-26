package androidx.datastore;

import androidx.datastore.core.Serializer;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import k3.l;
import kotlin.jvm.internal.t;
import n3.C2700a;
import w3.C2865c0;
import w3.C2908y0;
import w3.M;
import w3.N;
import w3.T0;

public final class DataStoreDelegateKt {
    public static final <T> C2700a dataStore(String str, Serializer<T> serializer, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, l lVar, M m5) {
        t.e(str, "fileName");
        t.e(serializer, "serializer");
        t.e(lVar, "produceMigrations");
        t.e(m5, "scope");
        return new DataStoreSingletonDelegate(str, new OkioSerializerWrapper(serializer), replaceFileCorruptionHandler, lVar, m5);
    }

    public static /* synthetic */ C2700a dataStore$default(String str, Serializer serializer, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, l lVar, M m5, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i5 & 8) != 0) {
            lVar = DataStoreDelegateKt$dataStore$1.INSTANCE;
        }
        if ((i5 & 16) != 0) {
            m5 = N.a(C2865c0.b().plus(T0.b((C2908y0) null, 1, (Object) null)));
        }
        return dataStore(str, serializer, replaceFileCorruptionHandler, lVar, m5);
    }
}
