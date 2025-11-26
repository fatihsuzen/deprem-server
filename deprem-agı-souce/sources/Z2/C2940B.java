package z2;

import W2.J;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2642B;
import l2.C2647G;
import l2.C2649I;
import l2.C2650J;
import l2.C2652a;
import l2.C2653b;
import l2.C2655d;
import l2.C2658g;
import l2.C2661j;
import l2.C2668q;
import l2.C2669s;
import l2.C2670t;
import l2.C2673w;
import l2.N;
import l2.T;
import l2.r;
import t3.s;

/* renamed from: z2.B  reason: case insensitive filesystem */
public final class C2940B extends SQLiteOpenHelper {

    /* renamed from: v  reason: collision with root package name */
    public static final a f26458v = new a((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public static C2940B f26459w;

    /* renamed from: a  reason: collision with root package name */
    private SQLiteDatabase f26460a;

    /* renamed from: b  reason: collision with root package name */
    private final String[] f26461b = {"id", RewardPlus.NAME, "packagename", "versionCode", "issystemapp", "isSystemService", "urlFicha", "md5signature", "exclude", "size", "excludeFromTracking", "defaultName", "sha256", "positiveNotified", "appID", "hasOldVersions", "trackInfoRegistered"};

    /* renamed from: c  reason: collision with root package name */
    private final String[] f26462c = {"id", MBridgeConstans.APP_ID, "sha256", "size", MBridgeConstans.DYNAMIC_VIEW_WX_PATH};

    /* renamed from: d  reason: collision with root package name */
    private final String[] f26463d = {"id", "packagename", "versionCode", "versionName", "notified", "ignoreVersion", "isPartialUpdate", "newFeatures", "installationAttempts"};

    /* renamed from: e  reason: collision with root package name */
    private final String[] f26464e = {"id", "packagename", "checked", "incomplete", "versioncode", "versionname", "attempts", "idPrograma", "downloadAnyway", "md5signature", "supportedAbis", "minsdk", "urlIcon", "appName", "nextAttemptTimeStamp", "updateId", "deeplink"};

    /* renamed from: f  reason: collision with root package name */
    private final String[] f26465f = {"id", "downloadId", "fileId", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "size", "size_downloaded", "filehash", "absolutePath", "attempts", "nextAttemptTimeStamp"};

    /* renamed from: g  reason: collision with root package name */
    private final String[] f26466g = {"id", "appId", "categoryFrom"};

    /* renamed from: h  reason: collision with root package name */
    private final String[] f26467h = {"search", CampaignEx.JSON_KEY_TIMESTAMP};

    /* renamed from: i  reason: collision with root package name */
    private final String[] f26468i = {"id", MBridgeConstans.DYNAMIC_VIEW_WX_PATH};

    /* renamed from: j  reason: collision with root package name */
    private final String[] f26469j = {"id", CampaignEx.JSON_KEY_TIMESTAMP, CampaignEx.JSON_KEY_TITLE, NotificationCompat.CATEGORY_MESSAGE, "actions", "extra_info"};

    /* renamed from: k  reason: collision with root package name */
    private final String[] f26470k = {"appId", "automaticDownload"};

    /* renamed from: l  reason: collision with root package name */
    private final String[] f26471l = {"appId"};

    /* renamed from: m  reason: collision with root package name */
    private final String[] f26472m = {MBridgeConstans.DYNAMIC_VIEW_WX_PATH, "date"};

    /* renamed from: n  reason: collision with root package name */
    private final String[] f26473n = {"id", "notificationId", "packagename", "versioncode", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY};

    /* renamed from: o  reason: collision with root package name */
    private final String[] f26474o = {"id", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "packagename", "versionname_old", "versionname_new", "versioncode_old", "versioncode_new", "size", CampaignEx.JSON_KEY_TIMESTAMP};

    /* renamed from: p  reason: collision with root package name */
    private final String[] f26475p = {"id", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "json", CampaignEx.JSON_KEY_TIMESTAMP};

    /* renamed from: q  reason: collision with root package name */
    private final String[] f26476q = {"id", "json", CampaignEx.JSON_KEY_TIMESTAMP};

    /* renamed from: r  reason: collision with root package name */
    private final String[] f26477r = {"id", "json", CampaignEx.JSON_KEY_TIMESTAMP};

    /* renamed from: s  reason: collision with root package name */
    private final String[] f26478s = {RewardPlus.NAME};

    /* renamed from: t  reason: collision with root package name */
    private final String[] f26479t = {"id", "appId", "sourceDeviceName", "downloadId"};

    /* renamed from: u  reason: collision with root package name */
    private final AtomicInteger f26480u = new AtomicInteger();

    /* renamed from: z2.B$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final synchronized C2940B a(Context context) {
            C2940B d5;
            try {
                t.e(context, "context");
                if (C2940B.f26459w == null) {
                    C2940B.f26459w = new C2940B(context.getApplicationContext());
                }
                d5 = C2940B.f26459w;
                t.b(d5);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
            return d5;
        }

        private a() {
        }
    }

    public C2940B(Context context) {
        super(context, "Uptodown.db", (SQLiteDatabase.CursorFactory) null, 688);
    }

    private final int B(int i5) {
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        return sQLiteDatabase.delete("download_files", "downloadId=?", new String[]{String.valueOf(i5)});
    }

    private final J J0() {
        this.f26460a = getWritableDatabase();
        return J.f19942a;
    }

    private final void O(int i5) {
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        sQLiteDatabase.delete("download_required_features", "downloadId=?", new String[]{String.valueOf(i5)});
    }

    private final void P(T t5) {
        if (t5.a() != null) {
            C2668q a5 = t5.a();
            t.b(a5);
            if (a5.q() >= 0) {
                C2668q a6 = t5.a();
                t.b(a6);
                O(a6.q());
            }
        }
    }

    private final void T(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS updates");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS apps");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS app_files");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS downloads");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS download_files");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS download_promoted");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS recent_searches");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS installable_files");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS notifications");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS deep_link_files");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS active_notifications");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS activity_log");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS responses");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS preregistrations");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS preregistrations_to_notify");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS errors");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS download_required_features");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS remote_installs");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS app_installers");
    }

    private final void d1(T t5) {
        ArrayList i5 = t5.i();
        if (i5 != null && !i5.isEmpty() && t5.a() != null) {
            C2668q a5 = t5.a();
            t.b(a5);
            if (a5.q() >= 0) {
                ArrayList i6 = t5.i();
                t.b(i6);
                Iterator it = i6.iterator();
                t.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    t.d(next, "next(...)");
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(RewardPlus.NAME, (String) next);
                    C2668q a6 = t5.a();
                    t.b(a6);
                    contentValues.put("downloadId", Integer.valueOf(a6.q()));
                    SQLiteDatabase sQLiteDatabase = this.f26460a;
                    t.b(sQLiteDatabase);
                    sQLiteDatabase.insert("download_required_features", (String) null, contentValues);
                }
            }
        }
    }

    private final C2652a e1(Cursor cursor) {
        int i5 = cursor.getInt(0);
        int i6 = cursor.getInt(1);
        String string = cursor.getString(2);
        String string2 = cursor.getString(3);
        t.b(string);
        t.b(string2);
        C2652a aVar = new C2652a(string, Long.parseLong(string2));
        aVar.i(i5);
        aVar.h(i6);
        aVar.j(C2652a.f24934f.a(cursor.getInt(4)));
        return aVar;
    }

    private final C2655d f1(Cursor cursor) {
        C2655d dVar = new C2655d();
        dVar.S(cursor.getLong(0));
        dVar.V(cursor.getString(1));
        dVar.W(cursor.getString(2));
        String string = cursor.getString(3);
        t.d(string, "getString(...)");
        dVar.h0(Long.parseLong(string));
        dVar.d0(cursor.getInt(4));
        dVar.e0(cursor.getInt(5));
        dVar.g0(cursor.getString(6));
        dVar.U(cursor.getString(7));
        dVar.N(cursor.getInt(8));
        String string2 = cursor.getString(9);
        t.d(string2, "getString(...)");
        dVar.b0(Long.parseLong(string2));
        dVar.O(cursor.getInt(10));
        dVar.L(cursor.getString(11));
        dVar.Z(cursor.getString(12));
        dVar.Y(cursor.getInt(13));
        dVar.K(cursor.getLong(14));
        dVar.R(cursor.getInt(15));
        dVar.f0(cursor.getInt(16));
        return dVar;
    }

    private final C2673w g1(Cursor cursor) {
        cursor.getInt(0);
        cursor.getInt(1);
        C2673w wVar = new C2673w();
        wVar.f(cursor.getString(2));
        String string = cursor.getString(3);
        t.d(string, "getString(...)");
        wVar.g(Long.parseLong(string));
        wVar.e(cursor.getString(4));
        return wVar;
    }

    private final C2668q h1(Cursor cursor) {
        C2668q qVar = new C2668q();
        qVar.R(cursor);
        return qVar;
    }

    private final r i1(Cursor cursor) {
        r rVar = new r();
        rVar.j(cursor);
        return rVar;
    }

    private final C2669s j1(Cursor cursor) {
        C2669s sVar = new C2669s();
        sVar.e(cursor);
        return sVar;
    }

    private final C2670t k1(Cursor cursor) {
        C2670t tVar = new C2670t();
        tVar.d(cursor.getLong(0));
        tVar.e(cursor.getString(1));
        tVar.f(cursor.getLong(2));
        return tVar;
    }

    private final C2668q l0(long j5) {
        Exception exc;
        Cursor cursor;
        C2668q qVar;
        try {
            SQLiteDatabase sQLiteDatabase = this.f26460a;
            t.b(sQLiteDatabase);
            cursor = sQLiteDatabase.query("downloads", this.f26464e, "updateId=?", new String[]{String.valueOf(j5)}, (String) null, (String) null, (String) null);
            try {
                if (cursor.moveToFirst()) {
                    qVar = h1(cursor);
                } else {
                    qVar = null;
                }
                cursor.close();
                if (qVar != null && qVar.q() >= 0) {
                    qVar.a0(n0(qVar.q()));
                }
                return qVar;
            } catch (Exception e5) {
                exc = e5;
                exc.printStackTrace();
                cursor.close();
                return null;
            }
        } catch (Exception e6) {
            exc = e6;
            cursor = null;
            exc.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return null;
        }
    }

    private final C2649I l1(Cursor cursor) {
        C2649I i5 = new C2649I();
        i5.c(cursor.getString(0));
        i5.d(cursor.getString(1));
        return i5;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: l2.r} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final l2.r m0(java.lang.String r12) {
        /*
            r11 = this;
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r11.f26460a     // Catch:{ Exception -> 0x002b }
            kotlin.jvm.internal.t.b(r2)     // Catch:{ Exception -> 0x002b }
            java.lang.String r3 = "download_files"
            java.lang.String[] r4 = r11.f26465f     // Catch:{ Exception -> 0x002b }
            java.lang.String r5 = "fileId=?"
            java.lang.String[] r6 = new java.lang.String[]{r12}     // Catch:{ Exception -> 0x002b }
            r8 = 0
            r9 = 0
            r7 = 0
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x002b }
            boolean r0 = r12.moveToFirst()     // Catch:{ Exception -> 0x0022 }
            if (r0 == 0) goto L_0x0027
            l2.r r1 = r11.i1(r12)     // Catch:{ Exception -> 0x0022 }
            goto L_0x0027
        L_0x0022:
            r0 = move-exception
            r10 = r1
            r1 = r12
            r12 = r10
            goto L_0x002d
        L_0x0027:
            r12.close()     // Catch:{ Exception -> 0x0022 }
            return r1
        L_0x002b:
            r0 = move-exception
            r12 = r1
        L_0x002d:
            r0.printStackTrace()
            if (r1 == 0) goto L_0x003b
            boolean r0 = r1.isClosed()
            if (r0 != 0) goto L_0x003b
            r1.close()
        L_0x003b:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: z2.C2940B.m0(java.lang.String):l2.r");
    }

    private final N m1(Cursor cursor) {
        int i5 = cursor.getInt(0);
        String string = cursor.getString(1);
        String string2 = cursor.getString(2);
        String string3 = cursor.getString(3);
        t.b(string);
        t.b(string2);
        N n5 = new N(string, string2);
        n5.g(i5);
        t.b(string3);
        n5.h(Long.parseLong(string3));
        return n5;
    }

    private final ArrayList n0(int i5) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f26460a;
            t.b(sQLiteDatabase);
            Cursor query = sQLiteDatabase.query("download_files", this.f26465f, "downloadId=?", new String[]{String.valueOf(i5)}, (String) null, (String) null, (String) null);
            if (query.moveToFirst()) {
                arrayList.add(i1(query));
            }
            while (query.moveToNext()) {
                arrayList.add(i1(query));
            }
            query.close();
            return arrayList;
        } catch (Exception e5) {
            e5.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    private final T n1(Cursor cursor) {
        long j5 = cursor.getLong(0);
        String string = cursor.getString(1);
        t.b(string);
        T t5 = new T(string);
        t5.p(j5);
        String string2 = cursor.getString(2);
        t.d(string2, "getString(...)");
        t5.v(Long.parseLong(string2));
        t5.w(cursor.getString(3));
        t5.s(cursor.getInt(4));
        t5.q(cursor.getInt(5));
        t5.t(cursor.getInt(6));
        t5.r(cursor.getString(7));
        return t5;
    }

    private final void o(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS updates(id integer primary key autoincrement, packagename text, versionCode text, versionName text, notified integer default 0, ignoreVersion integer default 0, isPartialUpdate integer default 0, newFeatures text, installationAttempts integer default 0);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS apps( id integer primary key autoincrement, name text, packagename text, versionCode text, issystemapp integer default 0, isSystemService integer default 0, urlFicha text, md5signature text, exclude integer default 0, size text, excludeFromTracking integer default 0, defaultName text, sha256 text, positiveNotified integer default 0, appID integer default 0, hasOldVersions integer default 0, trackInfoRegistered integer default 0);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS app_files( id integer primary key autoincrement, app_id integer, sha256 text, size text, path text);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS downloads(id integer primary key autoincrement, packagename text, checked integer default 0, incomplete integer default 0, versioncode integer default 0, versionname text, attempts integer default 0, idPrograma integer default 0, downloadAnyway integer default 0, md5signature text, supportedAbis text, minsdk integer default 0, urlIcon text, appName text, nextAttemptTimeStamp integer default 0, updateId integer default 0, deeplink integer default 0);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS download_files(id integer primary key autoincrement, downloadId integer default 0, fileId integer default 0, type text, size integer default 0, size_downloaded integer default 0, filehash text, absolutePath text, attempts integer default 0, nextAttemptTimeStamp integer default 0);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS download_promoted(id integer primary key autoincrement, appId integer default 0, categoryFrom text);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS recent_searches(id integer primary key autoincrement, search text unique, timestamp text);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS installable_files(id integer primary key autoincrement, path text);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS notifications(id integer primary key autoincrement, timestamp text, title text, msg text, actions text, extra_info text);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS deep_link_files(id integer primary key autoincrement, path text, date text);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS active_notifications(id integer primary key autoincrement, notificationId integer, packagename text, versioncode integer, type integer);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS activity_log(id integer primary key autoincrement, type integer, packagename text, versionname_old text, versionname_new text, versioncode_old text, versioncode_new text, size text, timestamp text);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS responses(id integer primary key autoincrement, type integer, json text, timestamp text);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS events(id integer primary key autoincrement, json text, timestamp integer);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS preregistrations(id integer primary key autoincrement, appId integer, automaticDownload integer);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS preregistrations_to_notify(id integer primary key autoincrement, appId integer);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS errors(id integer primary key autoincrement, json text, timestamp integer);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS download_required_features(id integer primary key autoincrement, name text, downloadId text);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS remote_installs(id integer primary key autoincrement, appId integer, sourceDeviceName text, downloadId integer);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS app_installers(id integer primary key autoincrement, packagename text, installer_packagename text);");
    }

    public final int A(C2668q qVar) {
        if (qVar == null) {
            return 0;
        }
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        int delete = sQLiteDatabase.delete("downloads", "id=?", new String[]{String.valueOf(qVar.q())});
        B(qVar.q());
        return delete;
    }

    public final ArrayList A0() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f26460a;
            t.b(sQLiteDatabase);
            Cursor query = sQLiteDatabase.query("preregistrations", this.f26470k, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (query.moveToFirst()) {
                C2647G g5 = new C2647G();
                g5.g(query);
                arrayList.add(g5);
            }
            while (query.moveToNext()) {
                C2647G g6 = new C2647G();
                g6.g(query);
                arrayList.add(g6);
            }
            query.close();
            return arrayList;
        } catch (Exception e5) {
            e5.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final int A1(C2673w wVar) {
        t.e(wVar, "appFile");
        ContentValues contentValues = new ContentValues();
        contentValues.put("sha256", wVar.c());
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        return sQLiteDatabase.update("app_files", contentValues, "path=?", new String[]{wVar.a()});
    }

    public final ArrayList B0() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f26460a;
            t.b(sQLiteDatabase);
            Cursor query = sQLiteDatabase.query("preregistrations_to_notify", this.f26471l, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (query.moveToFirst()) {
                C2647G g5 = new C2647G();
                g5.g(query);
                arrayList.add(g5);
            }
            while (query.moveToNext()) {
                C2647G g6 = new C2647G();
                g6.g(query);
                arrayList.add(g6);
            }
            query.close();
            return arrayList;
        } catch (Exception e5) {
            e5.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final void B1(C2655d dVar) {
        t.e(dVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        ContentValues contentValues = new ContentValues();
        if (dVar.r() != null) {
            contentValues.put("sha256", dVar.r());
        }
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        sQLiteDatabase.update("apps", contentValues, "packagename=?", new String[]{dVar.o()});
    }

    public final int C(long j5) {
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        return sQLiteDatabase.delete("events", "id=?", new String[]{String.valueOf(j5)});
    }

    public final ArrayList C0() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f26460a;
            t.b(sQLiteDatabase);
            Cursor query = sQLiteDatabase.query("recent_searches", this.f26467h, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (query.moveToFirst()) {
                arrayList.add(l1(query));
            }
            while (query.moveToNext()) {
                arrayList.add(l1(query));
            }
            query.close();
            return arrayList;
        } catch (Exception e5) {
            e5.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final void C1(T t5) {
        t.e(t5, "update");
        ContentValues contentValues = new ContentValues();
        contentValues.put("versionCode", Long.valueOf(t5.j()));
        contentValues.put("versionName", t5.k());
        contentValues.put("notified", Integer.valueOf(t5.g()));
        contentValues.put("ignoreVersion", Integer.valueOf(t5.e()));
        contentValues.put("isPartialUpdate", Integer.valueOf(t5.n()));
        contentValues.put("newFeatures", t5.f());
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        sQLiteDatabase.update("updates", contentValues, "packagename=?", new String[]{t5.h()});
    }

    public final ArrayList D0() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        Cursor query = sQLiteDatabase.query("remote_installs", this.f26479t, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        t.d(query, "query(...)");
        if (query.moveToFirst()) {
            C2650J j5 = new C2650J();
            j5.e(query);
            arrayList.add(j5);
            while (query.moveToNext()) {
                C2650J j6 = new C2650J();
                j6.e(query);
                arrayList.add(j6);
            }
        }
        query.close();
        return arrayList;
    }

    public final int D1(C2668q qVar) {
        t.e(qVar, "download");
        ContentValues contentValues = new ContentValues();
        contentValues.put("packagename", qVar.w());
        contentValues.put("checked", Integer.valueOf(qVar.k()));
        contentValues.put("incomplete", Integer.valueOf(qVar.r()));
        contentValues.put("versioncode", Long.valueOf(qVar.E()));
        contentValues.put("versionname", qVar.H());
        contentValues.put("attempts", Integer.valueOf(qVar.j()));
        contentValues.put("idPrograma", Long.valueOf(qVar.h()));
        contentValues.put("downloadAnyway", Integer.valueOf(qVar.l()));
        contentValues.put("md5signature", qVar.t());
        contentValues.put("supportedAbis", qVar.A());
        contentValues.put("minsdk", Integer.valueOf(qVar.u()));
        contentValues.put("urlIcon", qVar.D());
        contentValues.put("appName", qVar.i());
        contentValues.put("nextAttemptTimeStamp", Long.valueOf(qVar.v()));
        contentValues.put("updateId", Long.valueOf(qVar.C()));
        contentValues.put("deeplink", Integer.valueOf(qVar.L()));
        if (qVar.q() >= 0) {
            SQLiteDatabase sQLiteDatabase = this.f26460a;
            t.b(sQLiteDatabase);
            return sQLiteDatabase.update("downloads", contentValues, "id=?", new String[]{String.valueOf(qVar.q())});
        } else if (qVar.w() == null || qVar.E() <= 0) {
            return 0;
        } else {
            String[] strArr = {qVar.w(), String.valueOf(qVar.E())};
            SQLiteDatabase sQLiteDatabase2 = this.f26460a;
            t.b(sQLiteDatabase2);
            return sQLiteDatabase2.update("downloads", contentValues, "packagename=? AND versioncode=?", strArr);
        }
    }

    public final ArrayList E0(long j5) {
        String[] strArr = {String.valueOf(j5)};
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        Cursor query = sQLiteDatabase.query("remote_installs", this.f26479t, "appId=?", strArr, (String) null, (String) null, (String) null);
        t.d(query, "query(...)");
        if (query.moveToFirst()) {
            C2650J j6 = new C2650J();
            j6.e(query);
            arrayList.add(j6);
            while (query.moveToNext()) {
                C2650J j7 = new C2650J();
                j7.e(query);
                arrayList.add(j7);
            }
        }
        query.close();
        return arrayList;
    }

    public final void E1(r rVar) {
        t.e(rVar, "downloadFile");
        ContentValues contentValues = new ContentValues();
        contentValues.put("size_downloaded", Long.valueOf(rVar.h()));
        contentValues.put("absolutePath", rVar.a());
        contentValues.put("attempts", Integer.valueOf(rVar.b()));
        contentValues.put("nextAttemptTimeStamp", Long.valueOf(rVar.g()));
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        sQLiteDatabase.update("download_files", contentValues, "id=?", new String[]{String.valueOf(rVar.f())});
    }

    public final int F(long j5) {
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        return sQLiteDatabase.delete("errors", "id=?", new String[]{String.valueOf(j5)});
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: l2.N} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final l2.N F0(java.lang.String r12) {
        /*
            r11 = this;
            java.lang.String r0 = "type"
            kotlin.jvm.internal.t.e(r12, r0)
            r1 = 0
            java.lang.String[] r6 = new java.lang.String[]{r12}     // Catch:{ Exception -> 0x0030 }
            android.database.sqlite.SQLiteDatabase r2 = r11.f26460a     // Catch:{ Exception -> 0x0030 }
            kotlin.jvm.internal.t.b(r2)     // Catch:{ Exception -> 0x0030 }
            java.lang.String r3 = "responses"
            java.lang.String[] r4 = r11.f26475p     // Catch:{ Exception -> 0x0030 }
            java.lang.String r5 = "type=?"
            r8 = 0
            r9 = 0
            r7 = 0
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0030 }
            boolean r0 = r12.moveToFirst()     // Catch:{ Exception -> 0x0027 }
            if (r0 == 0) goto L_0x002c
            l2.N r1 = r11.m1(r12)     // Catch:{ Exception -> 0x0027 }
            goto L_0x002c
        L_0x0027:
            r0 = move-exception
            r10 = r1
            r1 = r12
            r12 = r10
            goto L_0x0032
        L_0x002c:
            r12.close()     // Catch:{ Exception -> 0x0027 }
            return r1
        L_0x0030:
            r0 = move-exception
            r12 = r1
        L_0x0032:
            r0.printStackTrace()
            if (r1 == 0) goto L_0x0040
            boolean r0 = r1.isClosed()
            if (r0 != 0) goto L_0x0040
            r1.close()
        L_0x0040:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: z2.C2940B.F0(java.lang.String):l2.N");
    }

    public final void F1(C2642B b5, String str, String str2) {
        t.e(b5, "notification");
        t.e(str, "notificationActions");
        t.e(str2, "notificationMsg");
        ContentValues contentValues = new ContentValues();
        contentValues.put("actions", str);
        contentValues.put(NotificationCompat.CATEGORY_MESSAGE, str2);
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        sQLiteDatabase.update("notifications", contentValues, "id=?", new String[]{String.valueOf(b5.c())});
    }

    public final int G(String str) {
        t.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        return sQLiteDatabase.delete("installable_files", "path=?", new String[]{str});
    }

    public final T G0(String str) {
        Cursor cursor;
        T t5;
        t.e(str, "packagename");
        try {
            SQLiteDatabase sQLiteDatabase = this.f26460a;
            t.b(sQLiteDatabase);
            cursor = sQLiteDatabase.query("updates", this.f26463d, "packagename=?", new String[]{str}, (String) null, (String) null, (String) null);
            try {
                if (cursor.moveToFirst()) {
                    t5 = n1(cursor);
                    t5.o(l0(t5.d()));
                    t5.u(H0(t5.a()));
                } else {
                    t5 = null;
                }
                cursor.close();
                return t5;
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace();
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                return null;
            }
        } catch (Exception e6) {
            e = e6;
            cursor = null;
            e.printStackTrace();
            cursor.close();
            return null;
        }
    }

    public final void G1(long j5, int i5) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("automaticDownload", Integer.valueOf(i5));
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        sQLiteDatabase.update("preregistrations", contentValues, "appId=?", new String[]{String.valueOf(j5)});
    }

    public final int H(int i5) {
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        return sQLiteDatabase.delete("notifications", "id=?", new String[]{String.valueOf(i5)});
    }

    public final ArrayList H0(C2668q qVar) {
        ArrayList arrayList = new ArrayList();
        if (qVar != null) {
            Cursor cursor = null;
            try {
                if (qVar.q() >= 0) {
                    SQLiteDatabase sQLiteDatabase = this.f26460a;
                    t.b(sQLiteDatabase);
                    Cursor query = sQLiteDatabase.query("download_required_features", this.f26478s, "downloadId=?", new String[]{String.valueOf(qVar.q())}, (String) null, (String) null, (String) null);
                    if (query.moveToFirst()) {
                        arrayList.add(query.getString(0));
                        while (query.moveToNext()) {
                            arrayList.add(query.getString(0));
                        }
                    }
                    query.close();
                    return arrayList;
                }
            } catch (Exception e5) {
                e5.printStackTrace();
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
            }
        }
        return arrayList;
    }

    public final int H1(C2650J j5) {
        t.e(j5, "remoteInstall");
        ContentValues contentValues = new ContentValues();
        contentValues.put("downloadId", Integer.valueOf(j5.b()));
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        return sQLiteDatabase.update("remote_installs", contentValues, "appId=?", new String[]{String.valueOf(j5.a())});
    }

    public final int I() {
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        return sQLiteDatabase.delete("events", "timestamp < ?", new String[]{String.valueOf(System.currentTimeMillis() - 2592000000L)});
    }

    public final ArrayList I0() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f26460a;
            t.b(sQLiteDatabase);
            Cursor query = sQLiteDatabase.query("updates", this.f26463d, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (query.moveToFirst()) {
                T n12 = n1(query);
                arrayList.add(n12);
                n12.o(l0(n12.d()));
                n12.u(H0(n12.a()));
            }
            while (query.moveToNext()) {
                T n13 = n1(query);
                arrayList.add(n13);
                n13.o(l0(n13.d()));
                n13.u(H0(n13.a()));
            }
            query.close();
            return arrayList;
        } catch (Exception e5) {
            e5.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final void I1(String str, long j5, int i5) {
        t.e(str, "packagename");
        ContentValues contentValues = new ContentValues();
        contentValues.put("appID", Long.valueOf(j5));
        contentValues.put("hasOldVersions", Integer.valueOf(i5));
        contentValues.put("trackInfoRegistered", 1);
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        sQLiteDatabase.update("apps", contentValues, "packagename=?", new String[]{str});
    }

    public final int J() {
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        return sQLiteDatabase.delete("errors", "timestamp < ?", new String[]{String.valueOf(System.currentTimeMillis() - 2592000000L)});
    }

    public final int K(int i5) {
        int w02 = w0(i5);
        if (w02 <= 0) {
            return 0;
        }
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        return sQLiteDatabase.delete("notifications", "id<=?", new String[]{String.valueOf(w02)});
    }

    public final void K0(C2652a aVar) {
        t.e(aVar, "activeNotification");
        ContentValues contentValues = new ContentValues();
        contentValues.put("notificationId", Integer.valueOf(aVar.a()));
        contentValues.put("packagename", aVar.c());
        contentValues.put("versioncode", Long.valueOf(aVar.e()));
        contentValues.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, Integer.valueOf(aVar.d().ordinal()));
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        sQLiteDatabase.insert("active_notifications", (String) null, contentValues);
    }

    public final int L(String str) {
        t.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        return sQLiteDatabase.delete("recent_searches", "search=?", new String[]{str});
    }

    public final void L0(C2653b bVar) {
        t.e(bVar, "activityLog");
        ContentValues contentValues = new ContentValues();
        contentValues.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, Integer.valueOf(bVar.d()));
        contentValues.put("packagename", bVar.a());
        contentValues.put("versioncode_old", bVar.g());
        contentValues.put("versioncode_new", bVar.f());
        contentValues.put("versionname_old", bVar.i());
        contentValues.put("versionname_new", bVar.h());
        contentValues.put("size", bVar.b());
        contentValues.put(CampaignEx.JSON_KEY_TIMESTAMP, bVar.c());
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        sQLiteDatabase.insert("activity_log", (String) null, contentValues);
    }

    public final void M(long j5) {
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        sQLiteDatabase.delete("remote_installs", "appId=?", new String[]{String.valueOf(j5)});
    }

    public final C2655d M0(C2655d dVar) {
        t.e(dVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        ContentValues contentValues = new ContentValues();
        contentValues.put(RewardPlus.NAME, dVar.m());
        contentValues.put("packagename", dVar.o());
        contentValues.put("versionCode", Long.valueOf(dVar.A()));
        contentValues.put("issystemapp", Integer.valueOf(dVar.E()));
        contentValues.put("isSystemService", Integer.valueOf(dVar.G()));
        contentValues.put("urlFicha", dVar.z());
        contentValues.put("md5signature", dVar.k());
        contentValues.put("exclude", Integer.valueOf(dVar.e()));
        contentValues.put("size", String.valueOf(dVar.t()));
        contentValues.put("excludeFromTracking", Integer.valueOf(dVar.f()));
        contentValues.put("defaultName", dVar.c());
        contentValues.put("sha256", dVar.r());
        contentValues.put("positiveNotified", Integer.valueOf(dVar.q()));
        contentValues.put("appID", Long.valueOf(dVar.b()));
        contentValues.put("hasOldVersions", Integer.valueOf(dVar.h()));
        if (dVar.y() >= 0) {
            contentValues.put("trackInfoRegistered", Integer.valueOf(dVar.y()));
        }
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        dVar.S(sQLiteDatabase.insert("apps", (String) null, contentValues));
        return dVar;
    }

    public final void N(int i5) {
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        sQLiteDatabase.delete("remote_installs", "downloadId=?", new String[]{String.valueOf(i5)});
    }

    public final long N0(long j5, C2673w wVar) {
        t.e(wVar, "appFile");
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, String.valueOf(j5));
        contentValues.put("sha256", wVar.c());
        contentValues.put("size", String.valueOf(wVar.d()));
        contentValues.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, wVar.a());
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        return sQLiteDatabase.insert("app_files", (String) null, contentValues);
    }

    public final long O0(String str, String str2) {
        t.e(str, "packagename");
        t.e(str2, "installerPackagename");
        ContentValues contentValues = new ContentValues();
        contentValues.put("packagename", str);
        contentValues.put("installer_packagename", str2);
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        return sQLiteDatabase.insert("app_installers", (String) null, contentValues);
    }

    public final void P0(C2661j jVar) {
        t.e(jVar, "deepLink");
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, jVar.e());
        contentValues.put("date", jVar.a());
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        sQLiteDatabase.insert("deep_link_files", (String) null, contentValues);
    }

    public final int Q(String str) {
        t.e(str, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        return sQLiteDatabase.delete("responses", "type=?", new String[]{str});
    }

    public final C2668q Q0(C2668q qVar) {
        t.e(qVar, "download");
        ContentValues contentValues = new ContentValues();
        contentValues.put("packagename", qVar.w());
        contentValues.put("checked", Integer.valueOf(qVar.k()));
        contentValues.put("incomplete", Integer.valueOf(qVar.r()));
        contentValues.put("versioncode", Long.valueOf(qVar.E()));
        contentValues.put("versionname", qVar.H());
        contentValues.put("attempts", Integer.valueOf(qVar.j()));
        contentValues.put("idPrograma", Long.valueOf(qVar.h()));
        contentValues.put("downloadAnyway", Integer.valueOf(qVar.l()));
        contentValues.put("md5signature", qVar.t());
        contentValues.put("supportedAbis", qVar.A());
        contentValues.put("minsdk", Integer.valueOf(qVar.u()));
        contentValues.put("urlIcon", qVar.D());
        contentValues.put("appName", qVar.i());
        contentValues.put("nextAttemptTimeStamp", Long.valueOf(qVar.v()));
        contentValues.put("updateId", Long.valueOf(qVar.C()));
        contentValues.put("deeplink", Integer.valueOf(qVar.L()));
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        long insert = sQLiteDatabase.insert("downloads", (String) null, contentValues);
        qVar.c0((int) insert);
        Iterator it = qVar.o().iterator();
        t.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            R0((r) next, insert);
        }
        return qVar;
    }

    public final int R(String str) {
        t.e(str, "packagename");
        String[] strArr = {str};
        T G02 = G0(str);
        if (G02 != null) {
            P(G02);
            A(G02.a());
        }
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        return sQLiteDatabase.delete("updates", "packagename=?", strArr);
    }

    public final void R0(r rVar, long j5) {
        t.e(rVar, "downloadFile");
        ContentValues contentValues = new ContentValues();
        contentValues.put("downloadId", Long.valueOf(j5));
        contentValues.put("fileId", Long.valueOf(rVar.d()));
        contentValues.put("size", Long.valueOf(rVar.i()));
        contentValues.put("size_downloaded", Long.valueOf(rVar.h()));
        contentValues.put("filehash", rVar.e());
        contentValues.put("absolutePath", rVar.a());
        contentValues.put("attempts", Integer.valueOf(rVar.b()));
        contentValues.put("nextAttemptTimeStamp", Long.valueOf(rVar.g()));
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        sQLiteDatabase.insert("download_files", (String) null, contentValues);
    }

    public final void S() {
        Iterator it = I0().iterator();
        t.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            R(((T) next).h());
        }
    }

    public final C2669s S0(C2669s sVar) {
        t.e(sVar, "downloadPromoted");
        ContentValues contentValues = new ContentValues();
        contentValues.put("appId", Long.valueOf(sVar.b()));
        contentValues.put("categoryFrom", sVar.c());
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        sVar.h((int) sQLiteDatabase.insert("download_promoted", (String) null, contentValues));
        return sVar;
    }

    public final void T0(C2670t tVar) {
        t.e(tVar, NotificationCompat.CATEGORY_EVENT);
        ContentValues contentValues = new ContentValues();
        contentValues.put("json", tVar.b());
        contentValues.put(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(tVar.c()));
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        sQLiteDatabase.insert("events", (String) null, contentValues);
    }

    public final C2652a U(int i5) {
        Cursor cursor;
        C2652a aVar;
        try {
            SQLiteDatabase sQLiteDatabase = this.f26460a;
            t.b(sQLiteDatabase);
            cursor = sQLiteDatabase.query("active_notifications", this.f26473n, "notificationId=?", new String[]{String.valueOf(i5)}, (String) null, (String) null, (String) null);
            try {
                if (cursor.moveToFirst()) {
                    aVar = e1(cursor);
                } else {
                    aVar = null;
                }
                cursor.close();
                return aVar;
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace();
                cursor.close();
                return null;
            }
        } catch (Exception e6) {
            e = e6;
            cursor = null;
            e.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return null;
        }
    }

    public final void U0(C2670t tVar) {
        t.e(tVar, NotificationCompat.CATEGORY_EVENT);
        ContentValues contentValues = new ContentValues();
        contentValues.put("json", tVar.b());
        contentValues.put(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(tVar.c()));
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        sQLiteDatabase.insert("errors", (String) null, contentValues);
    }

    public final C2652a V(String str, long j5) {
        Exception exc;
        Cursor cursor;
        C2652a aVar;
        t.e(str, "packageName");
        try {
            SQLiteDatabase sQLiteDatabase = this.f26460a;
            t.b(sQLiteDatabase);
            cursor = sQLiteDatabase.query("active_notifications", this.f26473n, "packagename=? AND versioncode=?", new String[]{str, String.valueOf(j5)}, (String) null, (String) null, (String) null);
            try {
                if (cursor.moveToFirst()) {
                    aVar = e1(cursor);
                } else {
                    aVar = null;
                }
                cursor.close();
                return aVar;
            } catch (Exception e5) {
                exc = e5;
                exc.printStackTrace();
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                return null;
            }
        } catch (Exception e6) {
            exc = e6;
            cursor = null;
            exc.printStackTrace();
            cursor.close();
            return null;
        }
    }

    public final void V0(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, str);
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        sQLiteDatabase.insert("installable_files", (String) null, contentValues);
    }

    public final C2652a W(int i5) {
        Cursor cursor;
        C2652a aVar;
        try {
            SQLiteDatabase sQLiteDatabase = this.f26460a;
            t.b(sQLiteDatabase);
            cursor = sQLiteDatabase.query("active_notifications", this.f26473n, "id=?", new String[]{String.valueOf(i5)}, (String) null, (String) null, (String) null);
            try {
                if (cursor.moveToFirst()) {
                    aVar = e1(cursor);
                } else {
                    aVar = null;
                }
                cursor.close();
                return aVar;
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace();
                cursor.close();
                return null;
            }
        } catch (Exception e6) {
            e = e6;
            cursor = null;
            e.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return null;
        }
    }

    public final void W0(C2642B b5) {
        t.e(b5, "notificationRegistry");
        ContentValues contentValues = new ContentValues();
        contentValues.put(CampaignEx.JSON_KEY_TIMESTAMP, b5.e());
        contentValues.put(CampaignEx.JSON_KEY_TITLE, b5.f());
        contentValues.put(NotificationCompat.CATEGORY_MESSAGE, b5.d());
        contentValues.put("actions", b5.a());
        contentValues.put("extra_info", b5.b());
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        sQLiteDatabase.insert("notifications", (String) null, contentValues);
    }

    public final ArrayList X() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f26460a;
            t.b(sQLiteDatabase);
            Cursor query = sQLiteDatabase.query("active_notifications", this.f26473n, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (query.moveToFirst()) {
                arrayList.add(e1(query));
                while (query.moveToNext()) {
                    arrayList.add(e1(query));
                }
            }
            query.close();
            return arrayList;
        } catch (Exception e5) {
            e5.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final void X0(C2647G g5) {
        t.e(g5, "preRegister");
        ContentValues contentValues = new ContentValues();
        contentValues.put("appId", Long.valueOf(g5.b()));
        contentValues.put("automaticDownload", Integer.valueOf(g5.d()));
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        sQLiteDatabase.insert("preregistrations", (String) null, contentValues);
    }

    public final C2655d Y(String str) {
        Cursor cursor;
        C2655d dVar;
        t.e(str, "packagename");
        try {
            SQLiteDatabase sQLiteDatabase = this.f26460a;
            t.b(sQLiteDatabase);
            cursor = sQLiteDatabase.query("apps", this.f26461b, "packagename=?", new String[]{str}, (String) null, (String) null, (String) null);
            try {
                if (cursor.moveToFirst()) {
                    dVar = f1(cursor);
                } else {
                    dVar = null;
                }
                cursor.close();
                return dVar;
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace();
                cursor.close();
                return null;
            }
        } catch (Exception e6) {
            e = e6;
            cursor = null;
            e.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return null;
        }
    }

    public final void Y0(C2647G g5) {
        t.e(g5, "preRegister");
        ContentValues contentValues = new ContentValues();
        contentValues.put("appId", Long.valueOf(g5.b()));
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        sQLiteDatabase.insert("preregistrations_to_notify", (String) null, contentValues);
    }

    public final ArrayList Z(long j5) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f26460a;
            t.b(sQLiteDatabase);
            Cursor query = sQLiteDatabase.query("app_files", this.f26462c, "app_id=?", new String[]{String.valueOf(j5)}, (String) null, (String) null, (String) null);
            if (query.moveToFirst()) {
                arrayList.add(g1(query));
                while (query.moveToNext()) {
                    arrayList.add(g1(query));
                }
            }
            query.close();
            return arrayList;
        } catch (Exception e5) {
            e5.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final void Z0(C2649I i5) {
        t.e(i5, "recentSearch");
        ContentValues contentValues = new ContentValues();
        contentValues.put("search", i5.a());
        contentValues.put(CampaignEx.JSON_KEY_TIMESTAMP, i5.b());
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        sQLiteDatabase.insert("recent_searches", (String) null, contentValues);
    }

    public final synchronized void a() {
        if (this.f26480u.incrementAndGet() == 1) {
            C2940B b5 = f26459w;
            t.b(b5);
            b5.J0();
        }
    }

    public final ArrayList a0(C2655d dVar) {
        t.e(dVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        if (dVar.i() >= 0) {
            return Z(dVar.i());
        }
        if (dVar.o() == null) {
            return null;
        }
        String o5 = dVar.o();
        t.b(o5);
        C2655d Y4 = Y(o5);
        if (Y4 != null) {
            return Z(Y4.i());
        }
        return null;
    }

    public final void a1(C2650J j5) {
        t.e(j5, "remoteInstall");
        ContentValues contentValues = new ContentValues();
        contentValues.put("appId", Long.valueOf(j5.a()));
        contentValues.put("sourceDeviceName", j5.c());
        contentValues.put("downloadId", Integer.valueOf(j5.b()));
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        sQLiteDatabase.insert("remote_installs", (String) null, contentValues);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String b0(java.lang.String r13) {
        /*
            r12 = this;
            java.lang.String r0 = "packagename"
            kotlin.jvm.internal.t.e(r13, r0)
            r1 = 0
            java.lang.String[] r6 = new java.lang.String[]{r13}     // Catch:{ Exception -> 0x0037 }
            android.database.sqlite.SQLiteDatabase r2 = r12.f26460a     // Catch:{ Exception -> 0x0037 }
            kotlin.jvm.internal.t.b(r2)     // Catch:{ Exception -> 0x0037 }
            java.lang.String r3 = "app_installers"
            java.lang.String r13 = "installer_packagename"
            java.lang.String[] r4 = new java.lang.String[]{r13}     // Catch:{ Exception -> 0x0037 }
            java.lang.String r5 = "packagename=?"
            java.lang.String r10 = "1"
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r13 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0037 }
            boolean r0 = r13.moveToFirst()     // Catch:{ Exception -> 0x002e }
            if (r0 == 0) goto L_0x0033
            r0 = 0
            java.lang.String r1 = r13.getString(r0)     // Catch:{ Exception -> 0x002e }
            goto L_0x0033
        L_0x002e:
            r0 = move-exception
            r11 = r1
            r1 = r13
            r13 = r11
            goto L_0x0039
        L_0x0033:
            r13.close()     // Catch:{ Exception -> 0x002e }
            return r1
        L_0x0037:
            r0 = move-exception
            r13 = r1
        L_0x0039:
            r0.printStackTrace()
            if (r1 == 0) goto L_0x0047
            boolean r0 = r1.isClosed()
            if (r0 != 0) goto L_0x0047
            r1.close()
        L_0x0047:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: z2.C2940B.b0(java.lang.String):java.lang.String");
    }

    public final void b1(N n5) {
        t.e(n5, "response");
        ContentValues contentValues = new ContentValues();
        contentValues.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, n5.e());
        contentValues.put("json", n5.b());
        contentValues.put(CampaignEx.JSON_KEY_TIMESTAMP, String.valueOf(n5.d()));
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        sQLiteDatabase.insert("responses", (String) null, contentValues);
    }

    public final ArrayList c0() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f26460a;
            t.b(sQLiteDatabase);
            Cursor query = sQLiteDatabase.query("app_installers", (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (query.moveToFirst()) {
                do {
                    String string = query.getString(query.getColumnIndexOrThrow("packagename"));
                    String string2 = query.getString(query.getColumnIndexOrThrow("installer_packagename"));
                    t.b(string);
                    t.b(string2);
                    arrayList.add(new C2658g(string, string2));
                } while (query.moveToNext());
            }
            query.close();
            return arrayList;
        } catch (Exception e5) {
            e5.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final void c1(T t5) {
        t.e(t5, "update");
        if (t5.a() != null) {
            C2668q a5 = t5.a();
            t.b(a5);
            t5.o(Q0(a5));
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("packagename", t5.h());
        contentValues.put("versionCode", Long.valueOf(t5.j()));
        contentValues.put("versionName", t5.k());
        contentValues.put("notified", Integer.valueOf(t5.g()));
        contentValues.put("ignoreVersion", Integer.valueOf(t5.e()));
        contentValues.put("isPartialUpdate", Integer.valueOf(t5.n()));
        contentValues.put("newFeatures", t5.f());
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        long insert = sQLiteDatabase.insert("updates", (String) null, contentValues);
        if (t5.a() == null) {
            return;
        }
        if (insert >= 0) {
            C2668q a6 = t5.a();
            t.b(a6);
            a6.f0(insert);
            d1(t5);
            C2668q a7 = t5.a();
            t.b(a7);
            D1(a7);
            return;
        }
        C2668q a8 = t5.a();
        t.b(a8);
        A(a8);
    }

    public final ArrayList d0() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f26460a;
            t.b(sQLiteDatabase);
            Cursor query = sQLiteDatabase.query("apps", this.f26461b, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (query.moveToFirst()) {
                arrayList.add(f1(query));
                while (query.moveToNext()) {
                    arrayList.add(f1(query));
                }
            }
            query.close();
            return arrayList;
        } catch (Exception e5) {
            e5.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final ArrayList e0() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f26460a;
            t.b(sQLiteDatabase);
            Cursor query = sQLiteDatabase.query("deep_link_files", this.f26472m, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (query.moveToFirst()) {
                C2661j jVar = new C2661j();
                jVar.h(query.getString(0));
                jVar.f(query.getString(1));
                arrayList.add(jVar);
            }
            while (query.moveToNext()) {
                C2661j jVar2 = new C2661j();
                jVar2.h(query.getString(0));
                jVar2.f(query.getString(1));
                arrayList.add(jVar2);
            }
            query.close();
            return arrayList;
        } catch (Exception e5) {
            e5.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final C2668q f0(String str) {
        t.e(str, "filename");
        Iterator it = p0().iterator();
        t.d(it, "iterator(...)");
        C2668q qVar = null;
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            C2668q qVar2 = (C2668q) next;
            Iterator it2 = qVar2.o().iterator();
            t.d(it2, "iterator(...)");
            while (it2.hasNext()) {
                Object next2 = it2.next();
                t.d(next2, "next(...)");
                r rVar = (r) next2;
                if (rVar.a() != null) {
                    String a5 = rVar.a();
                    t.b(a5);
                    if (s.E(new File(a5).getName(), str, true)) {
                        qVar = qVar2;
                    }
                }
            }
        }
        return qVar;
    }

    public final C2668q g0(String str) {
        t.e(str, "absolutePath");
        Iterator it = p0().iterator();
        t.d(it, "iterator(...)");
        C2668q qVar = null;
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            C2668q qVar2 = (C2668q) next;
            if (!qVar2.o().isEmpty()) {
                Iterator it2 = qVar2.o().iterator();
                t.d(it2, "iterator(...)");
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next2 = it2.next();
                    t.d(next2, "next(...)");
                    r rVar = (r) next2;
                    if (rVar.a() != null) {
                        String a5 = rVar.a();
                        t.b(a5);
                        File parentFile = new File(a5).getParentFile();
                        if (parentFile != null && s.E(parentFile.getAbsolutePath(), str, true)) {
                            qVar = qVar2;
                            break;
                        }
                    }
                }
            }
        }
        return qVar;
    }

    public final C2668q h0(String str) {
        Long l5;
        Cursor cursor;
        C2668q qVar;
        t.e(str, "fileId");
        r m02 = m0(str);
        if (m02 != null) {
            l5 = Long.valueOf(m02.c());
        } else {
            l5 = null;
        }
        if (l5 != null) {
            try {
                SQLiteDatabase sQLiteDatabase = this.f26460a;
                t.b(sQLiteDatabase);
                cursor = sQLiteDatabase.query("downloads", this.f26464e, "id=?", new String[]{String.valueOf(m02.c())}, (String) null, (String) null, (String) null);
                try {
                    if (cursor.moveToFirst()) {
                        qVar = h1(cursor);
                    } else {
                        qVar = null;
                    }
                    cursor.close();
                    if (qVar != null && qVar.q() >= 0) {
                        qVar.a0(n0(qVar.q()));
                    }
                    return qVar;
                } catch (Exception e5) {
                    e = e5;
                    e.printStackTrace();
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (Exception e6) {
                e = e6;
                cursor = null;
                e.printStackTrace();
                cursor.close();
                return null;
            }
        }
        return null;
    }

    public final C2668q i0(int i5) {
        Cursor cursor;
        C2668q qVar;
        try {
            SQLiteDatabase sQLiteDatabase = this.f26460a;
            t.b(sQLiteDatabase);
            cursor = sQLiteDatabase.query("downloads", this.f26464e, "id=?", new String[]{String.valueOf(i5)}, (String) null, (String) null, (String) null);
            try {
                if (cursor.moveToFirst()) {
                    qVar = h1(cursor);
                } else {
                    qVar = null;
                }
                cursor.close();
                if (qVar != null && qVar.q() >= 0) {
                    qVar.a0(n0(qVar.q()));
                }
                return qVar;
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace();
                cursor.close();
                return null;
            }
        } catch (Exception e6) {
            e = e6;
            cursor = null;
            e.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return null;
        }
    }

    public final C2668q j0(String str) {
        Cursor cursor;
        C2668q qVar;
        t.e(str, "packagename");
        try {
            SQLiteDatabase sQLiteDatabase = this.f26460a;
            t.b(sQLiteDatabase);
            cursor = sQLiteDatabase.query("downloads", this.f26464e, "packagename=?", new String[]{str}, (String) null, (String) null, "versioncode DESC");
            try {
                if (cursor.moveToFirst()) {
                    qVar = h1(cursor);
                } else {
                    qVar = null;
                }
                cursor.close();
                if (qVar != null && qVar.q() >= 0) {
                    qVar.a0(n0(qVar.q()));
                }
                return qVar;
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace();
                cursor.close();
                return null;
            }
        } catch (Exception e6) {
            e = e6;
            cursor = null;
            e.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return null;
        }
    }

    public final C2668q k0(String str, long j5) {
        Exception exc;
        Cursor cursor;
        C2668q qVar;
        t.e(str, "packagename");
        try {
            SQLiteDatabase sQLiteDatabase = this.f26460a;
            t.b(sQLiteDatabase);
            cursor = sQLiteDatabase.query("downloads", this.f26464e, "packagename=? AND versioncode=?", new String[]{str, String.valueOf(j5)}, (String) null, (String) null, (String) null);
            try {
                if (cursor.moveToFirst()) {
                    qVar = h1(cursor);
                } else {
                    qVar = null;
                }
                cursor.close();
                if (qVar != null && qVar.q() >= 0) {
                    qVar.a0(n0(qVar.q()));
                }
                return qVar;
            } catch (Exception e5) {
                exc = e5;
                exc.printStackTrace();
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                return null;
            }
        } catch (Exception e6) {
            exc = e6;
            cursor = null;
            exc.printStackTrace();
            cursor.close();
            return null;
        }
    }

    public final synchronized void m() {
        try {
            if (this.f26480u.decrementAndGet() == 0) {
                C2940B b5 = f26459w;
                t.b(b5);
                b5.close();
            } else if (this.f26480u.get() < 0) {
                this.f26480u.set(0);
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.String[], android.database.Cursor] */
    public final int n() {
        int i5 = 0;
        ? r12 = 0;
        try {
            SQLiteDatabase sQLiteDatabase = this.f26460a;
            t.b(sQLiteDatabase);
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT COUNT(id) AS count FROM notifications", r12);
            if (rawQuery.moveToFirst()) {
                i5 = rawQuery.getInt(0);
            }
            rawQuery.close();
            return i5;
        } catch (Exception e5) {
            e5.printStackTrace();
            if (r12 != 0 && !r12.isClosed()) {
                r12.close();
            }
            return 0;
        }
    }

    public final C2669s o0(long j5) {
        Exception exc;
        Cursor cursor;
        C2669s sVar;
        try {
            SQLiteDatabase sQLiteDatabase = this.f26460a;
            t.b(sQLiteDatabase);
            cursor = sQLiteDatabase.query("download_promoted", this.f26466g, "appId=?", new String[]{String.valueOf(j5)}, (String) null, (String) null, (String) null);
            try {
                if (cursor.moveToFirst()) {
                    sVar = j1(cursor);
                } else {
                    sVar = null;
                }
                cursor.close();
                return sVar;
            } catch (Exception e5) {
                exc = e5;
                exc.printStackTrace();
                cursor.close();
                return null;
            }
        } catch (Exception e6) {
            exc = e6;
            cursor = null;
            exc.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return null;
        }
    }

    public final int o1() {
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        return sQLiteDatabase.delete("preregistrations", (String) null, (String[]) null);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        t.e(sQLiteDatabase, "mSQLiteDatabase");
        this.f26460a = sQLiteDatabase;
        t.b(sQLiteDatabase);
        o(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i5, int i6) {
        t.e(sQLiteDatabase, "sqLiteDatabase");
        if (i5 < 656) {
            T(sQLiteDatabase);
        } else {
            if (i5 < 687) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS downloads");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS download_files");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS download_promoted");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS download_required_features");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS updates");
            }
            if (i5 < 688) {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS app_installers(id integer primary key autoincrement, packagename text, installer_packagename text);");
            }
        }
        o(sQLiteDatabase);
    }

    public final int p(C2652a aVar) {
        t.e(aVar, "activeNotification");
        if (aVar.b() > -1) {
            SQLiteDatabase sQLiteDatabase = this.f26460a;
            t.b(sQLiteDatabase);
            return sQLiteDatabase.delete("active_notifications", "id=?", new String[]{String.valueOf(aVar.b())});
        } else if (aVar.a() > -1) {
            SQLiteDatabase sQLiteDatabase2 = this.f26460a;
            t.b(sQLiteDatabase2);
            return sQLiteDatabase2.delete("active_notifications", "notificationId=?", new String[]{String.valueOf(aVar.a())});
        } else if (aVar.c().length() <= 0) {
            return 0;
        } else {
            SQLiteDatabase sQLiteDatabase3 = this.f26460a;
            t.b(sQLiteDatabase3);
            return sQLiteDatabase3.delete("active_notifications", "packagename=?", new String[]{aVar.c()});
        }
    }

    public final ArrayList p0() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f26460a;
            t.b(sQLiteDatabase);
            Cursor query = sQLiteDatabase.query("downloads", this.f26464e, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (query.moveToFirst()) {
                C2668q h12 = h1(query);
                if (h12.q() >= 0) {
                    h12.a0(n0(h12.q()));
                }
                arrayList.add(h12);
            }
            while (query.moveToNext()) {
                C2668q h13 = h1(query);
                if (h13.q() >= 0) {
                    h13.a0(n0(h13.q()));
                }
                arrayList.add(h13);
            }
            query.close();
            return arrayList;
        } catch (Exception e5) {
            e5.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final int p1(long j5) {
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        return sQLiteDatabase.delete("download_promoted", "appId=?", new String[]{String.valueOf(j5)});
    }

    public final int q() {
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        return sQLiteDatabase.delete("notifications", (String) null, (String[]) null);
    }

    public final ArrayList q0() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f26460a;
            t.b(sQLiteDatabase);
            Cursor query = sQLiteDatabase.query("events", this.f26476q, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (query.moveToFirst()) {
                arrayList.add(k1(query));
                while (query.moveToNext()) {
                    arrayList.add(k1(query));
                }
            }
            query.close();
            return arrayList;
        } catch (Exception e5) {
            e5.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final int q1(long j5) {
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        return sQLiteDatabase.delete("preregistrations", "appId=?", new String[]{String.valueOf(j5)});
    }

    public final ArrayList r0() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f26460a;
            t.b(sQLiteDatabase);
            Cursor query = sQLiteDatabase.query("errors", this.f26477r, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (query.moveToFirst()) {
                arrayList.add(k1(query));
                while (query.moveToNext()) {
                    arrayList.add(k1(query));
                }
            }
            query.close();
            return arrayList;
        } catch (Exception e5) {
            e5.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final int r1(long j5) {
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        return sQLiteDatabase.delete("preregistrations_to_notify", "appId=?", new String[]{String.valueOf(j5)});
    }

    public final int s() {
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        return sQLiteDatabase.delete("responses", (String) null, (String[]) null);
    }

    public final ArrayList s0() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f26460a;
            t.b(sQLiteDatabase);
            Cursor query = sQLiteDatabase.query("installable_files", this.f26468i, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (query.moveToFirst()) {
                arrayList.add(query.getString(1));
            }
            while (query.moveToNext()) {
                arrayList.add(query.getString(1));
            }
            query.close();
            return arrayList;
        } catch (Exception e5) {
            e5.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final C2668q s1(int i5) {
        Cursor cursor;
        C2668q qVar;
        try {
            SQLiteDatabase sQLiteDatabase = this.f26460a;
            t.b(sQLiteDatabase);
            cursor = sQLiteDatabase.query("downloads", this.f26464e, "id=?", new String[]{String.valueOf(i5)}, (String) null, (String) null, (String) null);
            try {
                if (cursor.moveToFirst()) {
                    qVar = h1(cursor);
                } else {
                    qVar = null;
                }
                cursor.close();
                if (qVar != null && qVar.q() >= 0) {
                    qVar.a0(n0(qVar.q()));
                }
                return qVar;
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace();
                cursor.close();
                return null;
            }
        } catch (Exception e6) {
            e = e6;
            cursor = null;
            e.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return null;
        }
    }

    public final void t(String str) {
        t.e(str, "packagename");
        C2655d Y4 = Y(str);
        if (Y4 != null) {
            SQLiteDatabase sQLiteDatabase = this.f26460a;
            t.b(sQLiteDatabase);
            sQLiteDatabase.delete("apps", "packagename=?", new String[]{str});
            SQLiteDatabase sQLiteDatabase2 = this.f26460a;
            t.b(sQLiteDatabase2);
            sQLiteDatabase2.delete("app_files", "app_id=?", new String[]{String.valueOf(Y4.i())});
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: l2.B} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final l2.C2642B t0() {
        /*
            r11 = this;
            r1 = 0
            java.lang.String r0 = "update_uptodown"
            java.lang.String[] r6 = new java.lang.String[]{r0}     // Catch:{ Exception -> 0x0033 }
            android.database.sqlite.SQLiteDatabase r2 = r11.f26460a     // Catch:{ Exception -> 0x0033 }
            kotlin.jvm.internal.t.b(r2)     // Catch:{ Exception -> 0x0033 }
            java.lang.String r3 = "notifications"
            java.lang.String[] r4 = r11.f26469j     // Catch:{ Exception -> 0x0033 }
            java.lang.String r5 = "actions=?"
            java.lang.String r9 = "id DESC"
            r7 = 0
            r8 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0033 }
            boolean r0 = r2.moveToFirst()     // Catch:{ Exception -> 0x002a }
            if (r0 == 0) goto L_0x002f
            l2.B r0 = new l2.B     // Catch:{ Exception -> 0x002a }
            r0.<init>()     // Catch:{ Exception -> 0x002a }
            r0.g(r2)     // Catch:{ Exception -> 0x002a }
            r1 = r0
            goto L_0x002f
        L_0x002a:
            r0 = move-exception
            r10 = r2
            r2 = r1
            r1 = r10
            goto L_0x0035
        L_0x002f:
            r2.close()     // Catch:{ Exception -> 0x002a }
            return r1
        L_0x0033:
            r0 = move-exception
            r2 = r1
        L_0x0035:
            r0.printStackTrace()
            if (r1 == 0) goto L_0x0043
            boolean r0 = r1.isClosed()
            if (r0 != 0) goto L_0x0043
            r1.close()
        L_0x0043:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: z2.C2940B.t0():l2.B");
    }

    public final void t1() {
        ContentValues contentValues = new ContentValues();
        contentValues.putNull("urlFicha");
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        sQLiteDatabase.update("apps", contentValues, (String) null, (String[]) null);
    }

    public final void u(C2655d dVar) {
        t.e(dVar, "appToDelete");
        if (dVar.i() < 0) {
            String o5 = dVar.o();
            t.b(o5);
            C2655d Y4 = Y(o5);
            if (Y4 != null) {
                dVar.S(Y4.i());
            }
        }
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        sQLiteDatabase.delete("apps", "packagename=?", new String[]{dVar.o()});
        SQLiteDatabase sQLiteDatabase2 = this.f26460a;
        t.b(sQLiteDatabase2);
        sQLiteDatabase2.delete("app_files", "app_id=?", new String[]{String.valueOf(dVar.i())});
    }

    public final int u0() {
        int i5;
        int i6 = 0;
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f26460a;
            t.b(sQLiteDatabase);
            cursor = sQLiteDatabase.query("active_notifications", new String[]{"notificationId"}, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (cursor.moveToFirst()) {
                int i7 = cursor.getInt(0);
                loop0:
                while (true) {
                    i5 = i7;
                    while (true) {
                        try {
                            if (!cursor.moveToNext()) {
                                break loop0;
                            }
                            i7 = cursor.getInt(0);
                            if (i7 > i5) {
                            }
                        } catch (Exception e5) {
                            e = e5;
                            i6 = i5;
                            e.printStackTrace();
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            return i6;
                        }
                    }
                }
                i6 = i5;
            }
            cursor.close();
            return i6;
        } catch (Exception e6) {
            e = e6;
            e.printStackTrace();
            cursor.close();
            return i6;
        }
    }

    public final void u1() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("checked", 1);
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        sQLiteDatabase.update("downloads", contentValues, (String) null, (String[]) null);
    }

    public final void v(C2673w wVar) {
        t.e(wVar, "appFile");
        if (wVar.c() != null) {
            SQLiteDatabase sQLiteDatabase = this.f26460a;
            t.b(sQLiteDatabase);
            sQLiteDatabase.delete("app_files", "sha256=?", new String[]{wVar.c()});
        } else if (wVar.a() != null) {
            SQLiteDatabase sQLiteDatabase2 = this.f26460a;
            t.b(sQLiteDatabase2);
            sQLiteDatabase2.delete("app_files", "path=?", new String[]{wVar.a()});
        }
    }

    public final ArrayList v0() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        Cursor query = sQLiteDatabase.query("remote_installs", this.f26479t, "downloadId < 0", (String[]) null, (String) null, (String) null, (String) null);
        t.d(query, "query(...)");
        if (query.moveToFirst()) {
            C2650J j5 = new C2650J();
            j5.e(query);
            arrayList.add(j5);
            while (query.moveToNext()) {
                C2650J j6 = new C2650J();
                j6.e(query);
                arrayList.add(j6);
            }
        }
        query.close();
        return arrayList;
    }

    public final void v1(C2655d dVar) {
        t.e(dVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        ContentValues contentValues = new ContentValues();
        contentValues.put("exclude", Integer.valueOf(dVar.e()));
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        sQLiteDatabase.update("apps", contentValues, "packagename=?", new String[]{dVar.o()});
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.String[], android.database.Cursor] */
    public final int w0(int i5) {
        int i6 = 0;
        ? r12 = 0;
        try {
            SQLiteDatabase sQLiteDatabase = this.f26460a;
            t.b(sQLiteDatabase);
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT id FROM notifications ORDER BY id DESC LIMIT " + i5 + ",1", r12);
            if (rawQuery.moveToFirst()) {
                i6 = rawQuery.getInt(0);
            }
            rawQuery.close();
            return i6;
        } catch (Exception e5) {
            e5.printStackTrace();
            if (r12 != 0 && !r12.isClosed()) {
                r12.close();
            }
            return 0;
        }
    }

    public final int w1(int i5) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("trackInfoRegistered", Integer.valueOf(i5));
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        return sQLiteDatabase.update("apps", contentValues, (String) null, (String[]) null);
    }

    public final int x(String str) {
        t.e(str, "packagename");
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        return sQLiteDatabase.delete("app_installers", "packagename=?", new String[]{str});
    }

    public final ArrayList x0() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f26460a;
            t.b(sQLiteDatabase);
            Cursor query = sQLiteDatabase.query("notifications", this.f26469j, (String) null, (String[]) null, (String) null, (String) null, "id DESC");
            if (query.moveToFirst()) {
                C2642B b5 = new C2642B();
                b5.g(query);
                arrayList.add(b5);
            }
            while (query.moveToNext()) {
                C2642B b6 = new C2642B();
                b6.g(query);
                arrayList.add(b6);
            }
            query.close();
            return arrayList;
        } catch (Exception e5) {
            e5.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final void x1(C2652a aVar) {
        t.e(aVar, "activeNotification");
        ContentValues contentValues = new ContentValues();
        contentValues.put("notificationId", Integer.valueOf(aVar.a()));
        contentValues.put("packagename", aVar.c());
        contentValues.put("versioncode", Long.valueOf(aVar.e()));
        contentValues.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, Integer.valueOf(aVar.d().ordinal()));
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        sQLiteDatabase.update("active_notifications", contentValues, "id=?", new String[]{String.valueOf(aVar.b())});
    }

    public final void y() {
        Iterator it = d0().iterator();
        t.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            C2655d dVar = (C2655d) next;
            if (dVar.f() == 1) {
                u(dVar);
            }
        }
    }

    public final C2647G y0(long j5) {
        Exception exc;
        Cursor cursor;
        C2647G g5;
        try {
            SQLiteDatabase sQLiteDatabase = this.f26460a;
            t.b(sQLiteDatabase);
            cursor = sQLiteDatabase.query("preregistrations", this.f26470k, "appId=?", new String[]{String.valueOf(j5)}, (String) null, (String) null, (String) null);
            try {
                if (cursor.moveToFirst()) {
                    g5 = C2647G.f24762f.c(cursor);
                } else {
                    g5 = null;
                }
                cursor.close();
                return g5;
            } catch (Exception e5) {
                exc = e5;
                exc.printStackTrace();
                cursor.close();
                return null;
            }
        } catch (Exception e6) {
            exc = e6;
            cursor = null;
            exc.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return null;
        }
    }

    public final void y1(C2655d dVar) {
        t.e(dVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        ContentValues contentValues = new ContentValues();
        if (dVar.m() != null) {
            contentValues.put(RewardPlus.NAME, dVar.m());
        }
        if (dVar.A() > 0) {
            contentValues.put("versionCode", Long.valueOf(dVar.A()));
        }
        contentValues.put("issystemapp", Integer.valueOf(dVar.E()));
        contentValues.put("isSystemService", Integer.valueOf(dVar.G()));
        if (dVar.z() != null) {
            contentValues.put("urlFicha", dVar.z());
        }
        if (dVar.k() != null) {
            contentValues.put("md5signature", dVar.k());
        }
        contentValues.put("exclude", Integer.valueOf(dVar.e()));
        contentValues.put("size", String.valueOf(dVar.t()));
        contentValues.put("excludeFromTracking", Integer.valueOf(dVar.f()));
        if (dVar.c() != null) {
            contentValues.put("defaultName", dVar.c());
        }
        if (dVar.r() != null) {
            contentValues.put("sha256", dVar.r());
        }
        contentValues.put("positiveNotified", Integer.valueOf(dVar.q()));
        contentValues.put("appID", Long.valueOf(dVar.b()));
        contentValues.put("hasOldVersions", Integer.valueOf(dVar.h()));
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        sQLiteDatabase.update("apps", contentValues, "packagename=?", new String[]{dVar.o()});
    }

    public final int z(String str) {
        t.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        return sQLiteDatabase.delete("deep_link_files", "path=?", new String[]{str});
    }

    public final C2647G z0(long j5) {
        Exception exc;
        Cursor cursor;
        C2647G g5;
        try {
            SQLiteDatabase sQLiteDatabase = this.f26460a;
            t.b(sQLiteDatabase);
            cursor = sQLiteDatabase.query("preregistrations_to_notify", this.f26471l, "appId=?", new String[]{String.valueOf(j5)}, (String) null, (String) null, (String) null);
            try {
                if (cursor.moveToFirst()) {
                    g5 = C2647G.f24762f.c(cursor);
                } else {
                    g5 = null;
                }
                cursor.close();
                return g5;
            } catch (Exception e5) {
                exc = e5;
                exc.printStackTrace();
                cursor.close();
                return null;
            }
        } catch (Exception e6) {
            exc = e6;
            cursor = null;
            exc.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return null;
        }
    }

    public final void z1(C2655d dVar) {
        t.e(dVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        ContentValues contentValues = new ContentValues();
        contentValues.put("excludeFromTracking", Integer.valueOf(dVar.f()));
        SQLiteDatabase sQLiteDatabase = this.f26460a;
        t.b(sQLiteDatabase);
        sQLiteDatabase.update("apps", contentValues, "packagename=?", new String[]{dVar.o()});
    }
}
