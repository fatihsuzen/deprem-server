package com.uptodown.activities;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import java.util.ArrayList;
import k2.W;
import kotlin.jvm.internal.t;
import z2.O;
import z3.D;
import z3.F;
import z3.w;

public final class j0 extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final w f15075a;

    /* renamed from: b  reason: collision with root package name */
    private final D f15076b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f15077c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f15078d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f15079e;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList f15080a;

        public a(ArrayList arrayList) {
            t.e(arrayList, "wishlist");
            this.f15080a = arrayList;
        }

        public final ArrayList a() {
            return this.f15080a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && t.a(this.f15080a, ((a) obj).f15080a);
        }

        public int hashCode() {
            return this.f15080a.hashCode();
        }

        public String toString() {
            return "WishlistData(wishlist=" + this.f15080a + ')';
        }
    }

    public static final class b implements W {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j0 f15081a;

        b(j0 j0Var) {
            this.f15081a = j0Var;
        }

        public void a() {
            this.f15081a.f15075a.setValue(new O.c(new a(new ArrayList())));
            this.f15081a.i(false);
        }

        public void b(ArrayList arrayList, boolean z4, int i5) {
            t.e(arrayList, "userList");
            if (!arrayList.isEmpty()) {
                j0 j0Var = this.f15081a;
                j0Var.f15079e = j0Var.f15079e + arrayList.size();
                this.f15081a.f15075a.setValue(new O.c(new a(arrayList)));
            } else if (this.f15081a.f15079e == 0) {
                this.f15081a.f15075a.setValue(new O.c(new a(new ArrayList())));
            } else {
                this.f15081a.h(true);
                this.f15081a.f15075a.setValue(O.b.f26508a);
            }
            this.f15081a.i(false);
        }
    }

    public j0() {
        w a5 = F.a(O.a.f26507a);
        this.f15075a = a5;
        this.f15076b = a5;
    }

    public final void d(Context context) {
        t.e(context, "context");
        this.f15078d = true;
        this.f15075a.setValue(O.a.f26507a);
        new g2.w(context, ViewModelKt.getViewModelScope(this)).j(30, this.f15079e, new b(this));
    }

    public final boolean e() {
        return this.f15077c;
    }

    public final D f() {
        return this.f15076b;
    }

    public final boolean g() {
        return this.f15078d;
    }

    public final void h(boolean z4) {
        this.f15077c = z4;
    }

    public final void i(boolean z4) {
        this.f15078d = z4;
    }
}
