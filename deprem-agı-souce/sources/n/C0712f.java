package N;

import K.C0657d;
import N.C0716j;
import O.C0732a;
import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Scope;

/* renamed from: N.f  reason: case insensitive filesystem */
public class C0712f extends C0732a {
    @NonNull
    public static final Parcelable.Creator<C0712f> CREATOR = new l0();

    /* renamed from: o  reason: collision with root package name */
    static final Scope[] f3070o = new Scope[0];

    /* renamed from: p  reason: collision with root package name */
    static final C0657d[] f3071p = new C0657d[0];

    /* renamed from: a  reason: collision with root package name */
    final int f3072a;

    /* renamed from: b  reason: collision with root package name */
    final int f3073b;

    /* renamed from: c  reason: collision with root package name */
    final int f3074c;

    /* renamed from: d  reason: collision with root package name */
    String f3075d;

    /* renamed from: e  reason: collision with root package name */
    IBinder f3076e;

    /* renamed from: f  reason: collision with root package name */
    Scope[] f3077f;

    /* renamed from: g  reason: collision with root package name */
    Bundle f3078g;

    /* renamed from: h  reason: collision with root package name */
    Account f3079h;

    /* renamed from: i  reason: collision with root package name */
    C0657d[] f3080i;

    /* renamed from: j  reason: collision with root package name */
    C0657d[] f3081j;

    /* renamed from: k  reason: collision with root package name */
    final boolean f3082k;

    /* renamed from: l  reason: collision with root package name */
    final int f3083l;

    /* renamed from: m  reason: collision with root package name */
    boolean f3084m;

    /* renamed from: n  reason: collision with root package name */
    private final String f3085n;

    C0712f(int i5, int i6, int i7, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, C0657d[] dVarArr, C0657d[] dVarArr2, boolean z4, int i8, boolean z5, String str2) {
        Account account2;
        scopeArr = scopeArr == null ? f3070o : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        dVarArr = dVarArr == null ? f3071p : dVarArr;
        dVarArr2 = dVarArr2 == null ? f3071p : dVarArr2;
        this.f3072a = i5;
        this.f3073b = i6;
        this.f3074c = i7;
        if ("com.google.android.gms".equals(str)) {
            this.f3075d = "com.google.android.gms";
        } else {
            this.f3075d = str;
        }
        if (i5 < 2) {
            if (iBinder != null) {
                account2 = C0707a.k(C0716j.a.j(iBinder));
            } else {
                account2 = null;
            }
            this.f3079h = account2;
        } else {
            this.f3076e = iBinder;
            this.f3079h = account;
        }
        this.f3077f = scopeArr;
        this.f3078g = bundle;
        this.f3080i = dVarArr;
        this.f3081j = dVarArr2;
        this.f3082k = z4;
        this.f3083l = i8;
        this.f3084m = z5;
        this.f3085n = str2;
    }

    public String c() {
        return this.f3085n;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        l0.a(this, parcel, i5);
    }
}
