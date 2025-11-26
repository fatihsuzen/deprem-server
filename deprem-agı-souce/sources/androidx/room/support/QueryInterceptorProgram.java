package androidx.room.support;

import androidx.sqlite.db.SupportSQLiteProgram;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;

public final class QueryInterceptorProgram implements SupportSQLiteProgram {
    private final List<Object> bindArgsCache = new ArrayList();

    private final void saveArgsToCache(int i5, Object obj) {
        int size;
        int i6 = i5 - 1;
        if (i6 >= this.bindArgsCache.size() && (size = this.bindArgsCache.size()) <= i6) {
            while (true) {
                this.bindArgsCache.add((Object) null);
                if (size == i6) {
                    break;
                }
                size++;
            }
        }
        this.bindArgsCache.set(i6, obj);
    }

    public void bindBlob(int i5, byte[] bArr) {
        t.e(bArr, "value");
        saveArgsToCache(i5, bArr);
    }

    public void bindDouble(int i5, double d5) {
        saveArgsToCache(i5, Double.valueOf(d5));
    }

    public void bindLong(int i5, long j5) {
        saveArgsToCache(i5, Long.valueOf(j5));
    }

    public void bindNull(int i5) {
        saveArgsToCache(i5, (Object) null);
    }

    public void bindString(int i5, String str) {
        t.e(str, "value");
        saveArgsToCache(i5, str);
    }

    public void clearBindings() {
        this.bindArgsCache.clear();
    }

    public void close() {
    }

    public final List<Object> getBindArgsCache$room_runtime_release() {
        return this.bindArgsCache;
    }
}
