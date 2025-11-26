package com.mbridge.msdk.foundation.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;

public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    private a f8973a;

    private class a extends SQLiteOpenHelper {
        public a(Context context, String str, int i5) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i5);
            if (MBridgeConstans.DEBUG) {
                af.a("DatabaseOpenHelper", "数据库： name :" + str + "  " + i5);
            }
        }

        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (MBridgeConstans.DEBUG) {
                af.a("DatabaseOpenHelper", "数据库创建了");
            }
            f.this.a(sQLiteDatabase);
        }

        public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i5, int i6) {
            f.this.a(sQLiteDatabase, i5, i6);
        }

        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i5, int i6) {
            if (MBridgeConstans.DEBUG) {
                af.a("DatabaseOpenHelper", "数据库升级了");
            }
            f.this.b(sQLiteDatabase, i5, i6);
        }
    }

    public f(Context context) {
        this.f8973a = new a(context, a(), b());
    }

    /* access modifiers changed from: protected */
    public abstract String a();

    /* access modifiers changed from: protected */
    public abstract void a(SQLiteDatabase sQLiteDatabase);

    /* access modifiers changed from: protected */
    public abstract void a(SQLiteDatabase sQLiteDatabase, int i5, int i6);

    /* access modifiers changed from: protected */
    public abstract int b();

    /* access modifiers changed from: protected */
    public abstract void b(SQLiteDatabase sQLiteDatabase, int i5, int i6);

    public final SQLiteDatabase c() {
        return this.f8973a.getReadableDatabase();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockFinish
        jadx.core.utils.exceptions.JadxRuntimeException: Dominance frontier not set for block: B:3:0x0008
        	at jadx.core.dex.nodes.BlockNode.lock(BlockNode.java:75)
        	at jadx.core.utils.ImmutableList.forEach(ImmutableList.java:108)
        	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:472)
        	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:27)
        */
    public final synchronized android.database.sqlite.SQLiteDatabase d() {
        /*
            r1 = this;
            monitor-enter(r1)
            com.mbridge.msdk.foundation.db.f$a r0 = r1.f8973a     // Catch:{ Exception -> 0x000b }
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ Exception -> 0x000b }
            goto L_0x000c
        L_0x0008:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0008 }
            throw r0
        L_0x000b:
            r0 = 0
        L_0x000c:
            monitor-exit(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.f.d():android.database.sqlite.SQLiteDatabase");
    }
}
