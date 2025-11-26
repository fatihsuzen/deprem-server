package z;

import A.C0619a;
import A.C0620b;
import B.C0628a;
import C.C0634a;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import p.C1745c;
import r.h;
import r.i;
import r.p;
import u.C1883a;
import u.C1884b;
import u.C1885c;
import u.e;
import u.f;
import v.C1892a;

public class M implements C1952d, C0620b, C1951c {

    /* renamed from: f  reason: collision with root package name */
    private static final C1745c f17105f = C1745c.b("proto");

    /* renamed from: a  reason: collision with root package name */
    private final W f17106a;

    /* renamed from: b  reason: collision with root package name */
    private final C0628a f17107b;

    /* renamed from: c  reason: collision with root package name */
    private final C0628a f17108c;

    /* renamed from: d  reason: collision with root package name */
    private final C1953e f17109d;

    /* renamed from: e  reason: collision with root package name */
    private final T2.a f17110e;

    interface b {
        Object apply(Object obj);
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        final String f17111a;

        /* renamed from: b  reason: collision with root package name */
        final String f17112b;

        private c(String str, String str2) {
            this.f17111a = str;
            this.f17112b = str2;
        }
    }

    interface d {
        Object a();
    }

    M(C0628a aVar, C0628a aVar2, C1953e eVar, W w4, T2.a aVar3) {
        this.f17106a = w4;
        this.f17107b = aVar;
        this.f17108c = aVar2;
        this.f17109d = eVar;
        this.f17110e = aVar3;
    }

    public static /* synthetic */ C1883a A(M m5, Map map, C1883a.C0164a aVar, Cursor cursor) {
        m5.getClass();
        while (cursor.moveToNext()) {
            String string = cursor.getString(0);
            C1885c.b Q4 = m5.Q(cursor.getInt(1));
            long j5 = cursor.getLong(2);
            if (!map.containsKey(string)) {
                map.put(string, new ArrayList());
            }
            ((List) map.get(string)).add(C1885c.c().c(Q4).b(j5).a());
        }
        m5.f0(aVar, map);
        return aVar.e(m5.X()).d(m5.V()).c((String) m5.f17110e.get()).b();
    }

    public static /* synthetic */ Boolean B(Cursor cursor) {
        boolean z4;
        if (cursor.getCount() > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        return Boolean.valueOf(z4);
    }

    public static /* synthetic */ Long C(M m5, i iVar, p pVar, SQLiteDatabase sQLiteDatabase) {
        boolean z4;
        byte[] bArr;
        if (m5.a0()) {
            m5.d(1, C1885c.b.CACHE_FULL, iVar.n());
            return -1L;
        }
        long S4 = m5.S(sQLiteDatabase, pVar);
        int e5 = m5.f17109d.e();
        byte[] a5 = iVar.e().a();
        if (a5.length <= e5) {
            z4 = true;
        } else {
            z4 = false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(S4));
        contentValues.put("transport_name", iVar.n());
        contentValues.put("timestamp_ms", Long.valueOf(iVar.f()));
        contentValues.put("uptime_ms", Long.valueOf(iVar.o()));
        contentValues.put("payload_encoding", iVar.e().b().a());
        contentValues.put("code", iVar.d());
        contentValues.put("num_attempts", 0);
        contentValues.put(MRAIDCommunicatorUtil.PLACEMENT_INLINE, Boolean.valueOf(z4));
        if (z4) {
            bArr = a5;
        } else {
            bArr = new byte[0];
        }
        contentValues.put("payload", bArr);
        contentValues.put("product_id", iVar.l());
        contentValues.put("pseudonymous_id", iVar.m());
        contentValues.put("experiment_ids_clear_blob", iVar.g());
        contentValues.put("experiment_ids_encrypted_blob", iVar.h());
        long insert = sQLiteDatabase.insert("events", (String) null, contentValues);
        if (!z4) {
            int ceil = (int) Math.ceil(((double) a5.length) / ((double) e5));
            for (int i5 = 1; i5 <= ceil; i5++) {
                byte[] copyOfRange = Arrays.copyOfRange(a5, (i5 - 1) * e5, Math.min(i5 * e5, a5.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(insert));
                contentValues2.put("sequence_num", Integer.valueOf(i5));
                contentValues2.put("bytes", copyOfRange);
                sQLiteDatabase.insert("event_payloads", (String) null, contentValues2);
            }
        }
        for (Map.Entry entry : iVar.k().entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("event_id", Long.valueOf(insert));
            contentValues3.put(RewardPlus.NAME, (String) entry.getKey());
            contentValues3.put("value", (String) entry.getValue());
            sQLiteDatabase.insert("event_metadata", (String) null, contentValues3);
        }
        return Long.valueOf(insert);
    }

    public static /* synthetic */ Long G(Cursor cursor) {
        if (!cursor.moveToNext()) {
            return null;
        }
        return Long.valueOf(cursor.getLong(0));
    }

    public static /* synthetic */ Object H(Throwable th) {
        throw new C0619a("Timed out while trying to acquire the lock.", th);
    }

    public static /* synthetic */ Object I(String str, C1885c.b bVar, long j5, SQLiteDatabase sQLiteDatabase) {
        if (!((Boolean) k0(sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(bVar.getNumber())}), new y())).booleanValue()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("log_source", str);
            contentValues.put("reason", Integer.valueOf(bVar.getNumber()));
            contentValues.put("events_dropped_count", Long.valueOf(j5));
            sQLiteDatabase.insert("log_event_dropped", (String) null, contentValues);
            return null;
        }
        sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j5 + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(bVar.getNumber())});
        return null;
    }

    public static /* synthetic */ Object J(Map map, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j5 = cursor.getLong(0);
            Set set = (Set) map.get(Long.valueOf(j5));
            if (set == null) {
                set = new HashSet();
                map.put(Long.valueOf(j5), set);
            }
            set.add(new c(cursor.getString(1), cursor.getString(2)));
        }
        return null;
    }

    public static /* synthetic */ Integer K(M m5, long j5, SQLiteDatabase sQLiteDatabase) {
        m5.getClass();
        String[] strArr = {String.valueOf(j5)};
        k0(sQLiteDatabase.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr), new r(m5));
        return Integer.valueOf(sQLiteDatabase.delete("events", "timestamp_ms < ?", strArr));
    }

    public static /* synthetic */ Object L(M m5, List list, p pVar, Cursor cursor) {
        m5.getClass();
        while (cursor.moveToNext()) {
            boolean z4 = false;
            long j5 = cursor.getLong(0);
            if (cursor.getInt(7) != 0) {
                z4 = true;
            }
            i.a o5 = i.a().n(cursor.getString(1)).i(cursor.getLong(2)).o(cursor.getLong(3));
            if (z4) {
                o5.h(new h(i0(cursor.getString(4)), cursor.getBlob(5)));
            } else {
                o5.h(new h(i0(cursor.getString(4)), m5.g0(j5)));
            }
            if (!cursor.isNull(6)) {
                o5.g(Integer.valueOf(cursor.getInt(6)));
            }
            if (!cursor.isNull(8)) {
                o5.l(Integer.valueOf(cursor.getInt(8)));
            }
            if (!cursor.isNull(9)) {
                o5.m(cursor.getString(9));
            }
            if (!cursor.isNull(10)) {
                o5.j(cursor.getBlob(10));
            }
            if (!cursor.isNull(11)) {
                o5.k(cursor.getBlob(11));
            }
            list.add(C1959k.a(j5, pVar, o5.d()));
        }
        return null;
    }

    public static /* synthetic */ Object M(M m5, SQLiteDatabase sQLiteDatabase) {
        m5.getClass();
        sQLiteDatabase.compileStatement("DELETE FROM log_event_dropped").execute();
        sQLiteDatabase.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + m5.f17107b.a()).execute();
        return null;
    }

    public static /* synthetic */ Long O(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    public static /* synthetic */ f P(long j5, SQLiteDatabase sQLiteDatabase) {
        return (f) k0(sQLiteDatabase.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]), new C1943D(j5));
    }

    private C1885c.b Q(int i5) {
        C1885c.b bVar = C1885c.b.REASON_UNKNOWN;
        if (i5 == bVar.getNumber()) {
            return bVar;
        }
        C1885c.b bVar2 = C1885c.b.MESSAGE_TOO_OLD;
        if (i5 == bVar2.getNumber()) {
            return bVar2;
        }
        C1885c.b bVar3 = C1885c.b.CACHE_FULL;
        if (i5 == bVar3.getNumber()) {
            return bVar3;
        }
        C1885c.b bVar4 = C1885c.b.PAYLOAD_TOO_BIG;
        if (i5 == bVar4.getNumber()) {
            return bVar4;
        }
        C1885c.b bVar5 = C1885c.b.MAX_RETRIES_REACHED;
        if (i5 == bVar5.getNumber()) {
            return bVar5;
        }
        C1885c.b bVar6 = C1885c.b.INVALID_PAYLOD;
        if (i5 == bVar6.getNumber()) {
            return bVar6;
        }
        C1885c.b bVar7 = C1885c.b.SERVER_ERROR;
        if (i5 == bVar7.getNumber()) {
            return bVar7;
        }
        C1892a.b("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i5));
        return bVar;
    }

    private void R(SQLiteDatabase sQLiteDatabase) {
        h0(new C1960l(sQLiteDatabase), new C1970w());
    }

    private long S(SQLiteDatabase sQLiteDatabase, p pVar) {
        Long Y4 = Y(sQLiteDatabase, pVar);
        if (Y4 != null) {
            return Y4.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", pVar.b());
        contentValues.put("priority", Integer.valueOf(C0634a.a(pVar.d())));
        contentValues.put("next_request_ms", 0);
        if (pVar.c() != null) {
            contentValues.put("extras", Base64.encodeToString(pVar.c(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", (String) null, contentValues);
    }

    private C1884b V() {
        return C1884b.b().b(e.c().b(T()).c(C1953e.f17146a.f()).a()).a();
    }

    private long W() {
        return U().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    private f X() {
        return (f) Z(new C1942C(this.f17107b.a()));
    }

    private Long Y(SQLiteDatabase sQLiteDatabase, p pVar) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(new String[]{pVar.b(), String.valueOf(C0634a.a(pVar.d()))}));
        if (pVar.c() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(pVar.c(), 0));
        } else {
            sb.append(" and extras is null");
        }
        return (Long) k0(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), (String) null, (String) null, (String) null), new C1971x());
    }

    private boolean a0() {
        if (W() * getPageSize() >= this.f17109d.f()) {
            return true;
        }
        return false;
    }

    private List b0(List list, Map map) {
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            C1959k kVar = (C1959k) listIterator.next();
            if (map.containsKey(Long.valueOf(kVar.c()))) {
                i.a p5 = kVar.b().p();
                for (c cVar : (Set) map.get(Long.valueOf(kVar.c()))) {
                    p5.c(cVar.f17111a, cVar.f17112b);
                }
                listIterator.set(C1959k.a(kVar.c(), kVar.d(), p5.d()));
            }
        }
        return list;
    }

    private List c0(SQLiteDatabase sQLiteDatabase, p pVar, int i5) {
        ArrayList arrayList = new ArrayList();
        Long Y4 = Y(sQLiteDatabase, pVar);
        if (Y4 == null) {
            return arrayList;
        }
        k0(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", MRAIDCommunicatorUtil.PLACEMENT_INLINE, "product_id", "pseudonymous_id", "experiment_ids_clear_blob", "experiment_ids_encrypted_blob"}, "context_id = ?", new String[]{Y4.toString()}, (String) null, (String) null, (String) null, String.valueOf(i5)), new C1969v(this, arrayList, pVar));
        return arrayList;
    }

    private Map d0(SQLiteDatabase sQLiteDatabase, List list) {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i5 = 0; i5 < list.size(); i5++) {
            sb.append(((C1959k) list.get(i5)).c());
            if (i5 < list.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        k0(sQLiteDatabase.query("event_metadata", new String[]{"event_id", RewardPlus.NAME, "value"}, sb.toString(), (String[]) null, (String) null, (String) null, (String) null), new z(hashMap));
        return hashMap;
    }

    private static byte[] e0(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    private void f0(C1883a.C0164a aVar, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            aVar.a(u.d.c().c((String) entry.getKey()).b((List) entry.getValue()).a());
        }
    }

    private byte[] g0(long j5) {
        return (byte[]) k0(U().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j5)}, (String) null, (String) null, "sequence_num"), new C1941B());
    }

    private long getPageSize() {
        return U().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    private Object h0(d dVar, b bVar) {
        long a5 = this.f17108c.a();
        while (true) {
            try {
                return dVar.a();
            } catch (SQLiteDatabaseLockedException e5) {
                if (this.f17108c.a() >= ((long) this.f17109d.b()) + a5) {
                    return bVar.apply(e5);
                }
                SystemClock.sleep(50);
            }
        }
    }

    private static C1745c i0(String str) {
        if (str == null) {
            return f17105f;
        }
        return C1745c.b(str);
    }

    private static String j0(Iterable iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(((C1959k) it.next()).c());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    static Object k0(Cursor cursor, b bVar) {
        try {
            return bVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    public static /* synthetic */ List o(M m5, p pVar, SQLiteDatabase sQLiteDatabase) {
        List c02 = m5.c0(sQLiteDatabase, pVar, m5.f17109d.d());
        for (p.f fVar : p.f.values()) {
            if (fVar != pVar.d()) {
                int d5 = m5.f17109d.d() - c02.size();
                if (d5 <= 0) {
                    break;
                }
                c02.addAll(m5.c0(sQLiteDatabase, pVar.f(fVar), d5));
            }
        }
        return m5.b0(c02, m5.d0(sQLiteDatabase, c02));
    }

    public static /* synthetic */ List p(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(p.a().b(cursor.getString(1)).d(C0634a.b(cursor.getInt(2))).c(e0(cursor.getString(3))).a());
        }
        return arrayList;
    }

    public static /* synthetic */ Object q(M m5, Cursor cursor) {
        m5.getClass();
        while (cursor.moveToNext()) {
            int i5 = cursor.getInt(0);
            m5.d((long) i5, C1885c.b.MAX_RETRIES_REACHED, cursor.getString(1));
        }
        return null;
    }

    public static /* synthetic */ SQLiteDatabase s(Throwable th) {
        throw new C0619a("Timed out while trying to open db.", th);
    }

    public static /* synthetic */ Object t(M m5, Cursor cursor) {
        m5.getClass();
        while (cursor.moveToNext()) {
            int i5 = cursor.getInt(0);
            m5.d((long) i5, C1885c.b.MESSAGE_TOO_OLD, cursor.getString(1));
        }
        return null;
    }

    public static /* synthetic */ Object u(M m5, String str, String str2, SQLiteDatabase sQLiteDatabase) {
        m5.getClass();
        sQLiteDatabase.compileStatement(str).execute();
        k0(sQLiteDatabase.rawQuery(str2, (String[]) null), new C1968u(m5));
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    public static /* synthetic */ Boolean v(M m5, p pVar, SQLiteDatabase sQLiteDatabase) {
        Long Y4 = m5.Y(sQLiteDatabase, pVar);
        if (Y4 == null) {
            return Boolean.FALSE;
        }
        return (Boolean) k0(m5.U().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{Y4.toString()}), new C1967t());
    }

    public static /* synthetic */ Object x(long j5, p pVar, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j5));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{pVar.b(), String.valueOf(C0634a.a(pVar.d()))}) < 1) {
            contentValues.put("backend_name", pVar.b());
            contentValues.put("priority", Integer.valueOf(C0634a.a(pVar.d())));
            sQLiteDatabase.insert("transport_contexts", (String) null, contentValues);
        }
        return null;
    }

    public static /* synthetic */ byte[] y(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            i5 += blob.length;
        }
        byte[] bArr = new byte[i5];
        int i6 = 0;
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            byte[] bArr2 = (byte[]) arrayList.get(i7);
            System.arraycopy(bArr2, 0, bArr, i6, bArr2.length);
            i6 += bArr2.length;
        }
        return bArr;
    }

    public static /* synthetic */ List z(SQLiteDatabase sQLiteDatabase) {
        return (List) k0(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), new J());
    }

    public void D(Iterable iterable) {
        if (iterable.iterator().hasNext()) {
            Z(new K(this, "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + j0(iterable), "SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name"));
        }
    }

    public Iterable E(p pVar) {
        return (Iterable) Z(new L(this, pVar));
    }

    /* access modifiers changed from: package-private */
    public long T() {
        return W() * getPageSize();
    }

    /* access modifiers changed from: package-private */
    public SQLiteDatabase U() {
        W w4 = this.f17106a;
        Objects.requireNonNull(w4);
        return (SQLiteDatabase) h0(new C1944E(w4), new C1945F());
    }

    /* access modifiers changed from: package-private */
    public Object Z(b bVar) {
        SQLiteDatabase U4 = U();
        U4.beginTransaction();
        try {
            Object apply = bVar.apply(U4);
            U4.setTransactionSuccessful();
            return apply;
        } finally {
            U4.endTransaction();
        }
    }

    public void a() {
        Z(new C1964p(this));
    }

    public int b() {
        return ((Integer) Z(new C1948I(this, this.f17107b.a() - this.f17109d.c()))).intValue();
    }

    public void c(Iterable iterable) {
        if (iterable.iterator().hasNext()) {
            U().compileStatement("DELETE FROM events WHERE _id in " + j0(iterable)).execute();
        }
    }

    public void close() {
        this.f17106a.close();
    }

    public void d(long j5, C1885c.b bVar, String str) {
        Z(new C1965q(str, bVar, j5));
    }

    public boolean h(p pVar) {
        return ((Boolean) Z(new C1962n(this, pVar))).booleanValue();
    }

    public Iterable i() {
        return (Iterable) Z(new C1946G());
    }

    public C1959k j(p pVar, i iVar) {
        C1892a.c("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", pVar.d(), iVar.n(), pVar.b());
        long longValue = ((Long) Z(new C1961m(this, iVar, pVar))).longValue();
        if (longValue < 1) {
            return null;
        }
        return C1959k.a(longValue, pVar, iVar);
    }

    public C1883a l() {
        return (C1883a) Z(new C1966s(this, "SELECT log_source, reason, events_dropped_count FROM log_event_dropped", new HashMap(), C1883a.e()));
    }

    public Object m(C0620b.a aVar) {
        SQLiteDatabase U4 = U();
        R(U4);
        try {
            Object execute = aVar.execute();
            U4.setTransactionSuccessful();
            return execute;
        } finally {
            U4.endTransaction();
        }
    }

    public long r(p pVar) {
        return ((Long) k0(U().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{pVar.b(), String.valueOf(C0634a.a(pVar.d()))}), new C1947H())).longValue();
    }

    public void w(p pVar, long j5) {
        Z(new C1963o(j5, pVar));
    }
}
