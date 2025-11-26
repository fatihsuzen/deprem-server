package P0;

import H0.c;
import H0.d;
import W2.J;
import android.content.Context;
import android.os.Build;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import f0.P;
import j$.time.ZoneOffset;
import j$.time.format.DateTimeFormatter;
import j$.util.DateRetargetClass;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

class p {

    /* renamed from: b  reason: collision with root package name */
    private static final Preferences.Key f3896b = PreferencesKeys.longKey("fire-global");

    /* renamed from: c  reason: collision with root package name */
    private static final Preferences.Key f3897c = PreferencesKeys.longKey("fire-count");

    /* renamed from: d  reason: collision with root package name */
    private static final Preferences.Key f3898d = PreferencesKeys.stringKey("last-used-date");

    /* renamed from: a  reason: collision with root package name */
    private final c f3899a;

    public p(Context context, String str) {
        this.f3899a = new c(context, "FirebaseHeartBeat" + str);
    }

    public static /* synthetic */ J b(p pVar, String str, String str2, Preferences.Key key, MutablePreferences mutablePreferences) {
        pVar.getClass();
        Preferences.Key key2 = f3898d;
        if (((String) d.a(mutablePreferences, key2, "")).equals(str)) {
            Preferences.Key i5 = pVar.i(mutablePreferences, str);
            if (i5 == null || i5.getName().equals(str2)) {
                return null;
            }
            pVar.q(mutablePreferences, key, str);
            return null;
        }
        Preferences.Key key3 = f3897c;
        long longValue = ((Long) d.a(mutablePreferences, key3, 0L)).longValue();
        if (longValue + 1 == 30) {
            longValue = pVar.e(mutablePreferences);
        }
        HashSet hashSet = new HashSet((Collection) d.a(mutablePreferences, key, new HashSet()));
        hashSet.add(str);
        mutablePreferences.set(key, hashSet);
        mutablePreferences.set(key3, Long.valueOf(longValue + 1));
        mutablePreferences.set(key2, str);
        return null;
    }

    public static /* synthetic */ J c(p pVar, MutablePreferences mutablePreferences) {
        pVar.getClass();
        long j5 = 0;
        for (Map.Entry next : mutablePreferences.asMap().entrySet()) {
            if (next.getValue() instanceof Set) {
                Preferences.Key key = (Preferences.Key) next.getKey();
                String h5 = pVar.h(System.currentTimeMillis());
                if (((Set) next.getValue()).contains(h5)) {
                    mutablePreferences.set(key, P.a(new Object[]{h5}));
                    j5++;
                } else {
                    mutablePreferences.remove(key);
                }
            }
        }
        if (j5 == 0) {
            mutablePreferences.remove(f3897c);
            return null;
        }
        mutablePreferences.set(f3897c, Long.valueOf(j5));
        return null;
    }

    public static /* synthetic */ J d(p pVar, String str, MutablePreferences mutablePreferences) {
        pVar.getClass();
        mutablePreferences.set(f3898d, str);
        pVar.l(mutablePreferences, str);
        return null;
    }

    private synchronized long e(MutablePreferences mutablePreferences) {
        long j5;
        try {
            long longValue = ((Long) d.a(mutablePreferences, f3897c, 0L)).longValue();
            String str = "";
            Set hashSet = new HashSet();
            String str2 = null;
            for (Map.Entry next : mutablePreferences.asMap().entrySet()) {
                if (next.getValue() instanceof Set) {
                    Set<String> set = (Set) next.getValue();
                    for (String str3 : set) {
                        if (str2 != null) {
                            if (str2.compareTo(str3) > 0) {
                            }
                        }
                        str = ((Preferences.Key) next.getKey()).getName();
                        hashSet = set;
                        str2 = str3;
                    }
                }
            }
            HashSet hashSet2 = new HashSet(hashSet);
            hashSet2.remove(str2);
            mutablePreferences.set(PreferencesKeys.stringSetKey(str), hashSet2);
            j5 = longValue - 1;
            mutablePreferences.set(f3897c, Long.valueOf(j5));
        } finally {
            while (true) {
            }
        }
        return j5;
    }

    private synchronized String h(long j5) {
        if (Build.VERSION.SDK_INT >= 26) {
            return DateRetargetClass.toInstant(new Date(j5)).atOffset(ZoneOffset.UTC).toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
        return new SimpleDateFormat("yyyy-MM-dd", Locale.UK).format(new Date(j5));
    }

    private synchronized Preferences.Key i(MutablePreferences mutablePreferences, String str) {
        for (Map.Entry next : mutablePreferences.asMap().entrySet()) {
            if (next.getValue() instanceof Set) {
                for (String equals : (Set) next.getValue()) {
                    if (str.equals(equals)) {
                        return PreferencesKeys.stringSetKey(((Preferences.Key) next.getKey()).getName());
                    }
                }
                continue;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void l(androidx.datastore.preferences.core.MutablePreferences r4, java.lang.String r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            androidx.datastore.preferences.core.Preferences$Key r0 = r3.i(r4, r5)     // Catch:{ all -> 0x0026 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r3)
            return
        L_0x0009:
            java.util.HashSet r1 = new java.util.HashSet     // Catch:{ all -> 0x0026 }
            java.util.HashSet r2 = new java.util.HashSet     // Catch:{ all -> 0x0026 }
            r2.<init>()     // Catch:{ all -> 0x0026 }
            java.lang.Object r2 = H0.d.a(r4, r0, r2)     // Catch:{ all -> 0x0026 }
            java.util.Collection r2 = (java.util.Collection) r2     // Catch:{ all -> 0x0026 }
            r1.<init>(r2)     // Catch:{ all -> 0x0026 }
            r1.remove(r5)     // Catch:{ all -> 0x0026 }
            boolean r5 = r1.isEmpty()     // Catch:{ all -> 0x0026 }
            if (r5 == 0) goto L_0x0028
            r4.remove(r0)     // Catch:{ all -> 0x0026 }
            goto L_0x002b
        L_0x0026:
            r4 = move-exception
            goto L_0x002d
        L_0x0028:
            r4.set(r0, r1)     // Catch:{ all -> 0x0026 }
        L_0x002b:
            monitor-exit(r3)
            return
        L_0x002d:
            monitor-exit(r3)     // Catch:{ all -> 0x0026 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: P0.p.l(androidx.datastore.preferences.core.MutablePreferences, java.lang.String):void");
    }

    private synchronized void q(MutablePreferences mutablePreferences, Preferences.Key key, String str) {
        l(mutablePreferences, str);
        HashSet hashSet = new HashSet((Collection) d.a(mutablePreferences, key, new HashSet()));
        hashSet.add(str);
        mutablePreferences.set(key, hashSet);
    }

    /* access modifiers changed from: package-private */
    public synchronized void f() {
        this.f3899a.g(new m(this));
    }

    /* access modifiers changed from: package-private */
    public synchronized List g() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            String h5 = h(System.currentTimeMillis());
            for (Map.Entry entry : this.f3899a.h().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    HashSet hashSet = new HashSet((Set) entry.getValue());
                    hashSet.remove(h5);
                    if (!hashSet.isEmpty()) {
                        arrayList.add(q.a(((Preferences.Key) entry.getKey()).getName(), new ArrayList(hashSet)));
                    }
                }
            }
            p(System.currentTimeMillis());
        } finally {
            while (true) {
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean j(long j5, long j6) {
        return h(j5).equals(h(j6));
    }

    /* access modifiers changed from: package-private */
    public synchronized void k() {
        this.f3899a.g(new n(this, h(System.currentTimeMillis())));
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean m(long j5) {
        return n(f3896b, j5);
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean n(Preferences.Key key, long j5) {
        if (j(((Long) this.f3899a.j(key, -1L)).longValue(), j5)) {
            return false;
        }
        this.f3899a.k(key, Long.valueOf(j5));
        return true;
    }

    /* access modifiers changed from: package-private */
    public synchronized void o(long j5, String str) {
        this.f3899a.g(new l(this, h(j5), str, PreferencesKeys.stringSetKey(str)));
    }

    /* access modifiers changed from: package-private */
    public synchronized void p(long j5) {
        this.f3899a.g(new o(j5));
    }
}
