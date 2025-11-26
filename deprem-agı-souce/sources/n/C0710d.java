package N;

import L.C0668a;
import android.accounts.Account;
import android.view.View;
import androidx.collection.ArraySet;
import h0.C1667a;
import j$.util.DesugarCollections;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: N.d  reason: case insensitive filesystem */
public final class C0710d {

    /* renamed from: a  reason: collision with root package name */
    private final Account f3044a;

    /* renamed from: b  reason: collision with root package name */
    private final Set f3045b;

    /* renamed from: c  reason: collision with root package name */
    private final Set f3046c;

    /* renamed from: d  reason: collision with root package name */
    private final Map f3047d;

    /* renamed from: e  reason: collision with root package name */
    private final int f3048e;

    /* renamed from: f  reason: collision with root package name */
    private final View f3049f;

    /* renamed from: g  reason: collision with root package name */
    private final String f3050g;

    /* renamed from: h  reason: collision with root package name */
    private final String f3051h;

    /* renamed from: i  reason: collision with root package name */
    private final C1667a f3052i;

    /* renamed from: j  reason: collision with root package name */
    private Integer f3053j;

    /* renamed from: N.d$a */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Account f3054a;

        /* renamed from: b  reason: collision with root package name */
        private ArraySet f3055b;

        /* renamed from: c  reason: collision with root package name */
        private String f3056c;

        /* renamed from: d  reason: collision with root package name */
        private String f3057d;

        /* renamed from: e  reason: collision with root package name */
        private final C1667a f3058e = C1667a.f15348j;

        public C0710d a() {
            return new C0710d(this.f3054a, this.f3055b, (Map) null, 0, (View) null, this.f3056c, this.f3057d, this.f3058e, false);
        }

        public a b(String str) {
            this.f3056c = str;
            return this;
        }

        public final a c(Collection collection) {
            if (this.f3055b == null) {
                this.f3055b = new ArraySet();
            }
            this.f3055b.addAll(collection);
            return this;
        }

        public final a d(Account account) {
            this.f3054a = account;
            return this;
        }

        public final a e(String str) {
            this.f3057d = str;
            return this;
        }
    }

    public C0710d(Account account, Set set, Map map, int i5, View view, String str, String str2, C1667a aVar, boolean z4) {
        Set set2;
        this.f3044a = account;
        if (set == null) {
            set2 = Collections.EMPTY_SET;
        } else {
            set2 = DesugarCollections.unmodifiableSet(set);
        }
        this.f3045b = set2;
        map = map == null ? Collections.EMPTY_MAP : map;
        this.f3047d = map;
        this.f3049f = view;
        this.f3048e = i5;
        this.f3050g = str;
        this.f3051h = str2;
        this.f3052i = aVar == null ? C1667a.f15348j : aVar;
        HashSet hashSet = new HashSet(set2);
        Iterator it = map.values().iterator();
        if (!it.hasNext()) {
            this.f3046c = DesugarCollections.unmodifiableSet(hashSet);
        } else {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    public Account a() {
        return this.f3044a;
    }

    public String b() {
        Account account = this.f3044a;
        if (account != null) {
            return account.name;
        }
        return null;
    }

    public Account c() {
        Account account = this.f3044a;
        if (account != null) {
            return account;
        }
        return new Account("<<default account>>", "com.google");
    }

    public Set d() {
        return this.f3046c;
    }

    public Set e(C0668a aVar) {
        android.support.v4.media.a.a(this.f3047d.get(aVar));
        return this.f3045b;
    }

    public String f() {
        return this.f3050g;
    }

    public Set g() {
        return this.f3045b;
    }

    public final C1667a h() {
        return this.f3052i;
    }

    public final Integer i() {
        return this.f3053j;
    }

    public final String j() {
        return this.f3051h;
    }

    public final void k(Integer num) {
        this.f3053j = num;
    }
}
