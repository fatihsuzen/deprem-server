package com.uptodown.tv.ui.activity;

import W2.J;
import W2.u;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import b3.C2308e;
import c3.C2316b;
import com.uptodown.R;
import com.uptodown.tv.ui.fragment.TvAppDetailFragment;
import java.util.List;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import l2.C2668q;
import v2.C2801a;
import v2.C2802b;
import w3.C2865c0;
import w3.C2872g;
import w3.M;

public final class TvAppDetailActivity extends C2802b {

    public final class a implements Runnable {
        public a() {
        }

        public void run() {
            List<Fragment> fragments = TvAppDetailActivity.this.getSupportFragmentManager().getFragments();
            t.d(fragments, "getFragments(...)");
            if (fragments.size() > 0) {
                Fragment fragment = fragments.get(0);
                if (fragment instanceof TvAppDetailFragment) {
                    ((TvAppDetailFragment) fragment).b0();
                }
            }
        }
    }

    public final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final String f21166a;

        /* renamed from: b  reason: collision with root package name */
        private final int f21167b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TvAppDetailActivity f21168c;

        public b(TvAppDetailActivity tvAppDetailActivity, String str, int i5) {
            t.e(str, "packagename");
            this.f21168c = tvAppDetailActivity;
            this.f21166a = str;
            this.f21167b = i5;
        }

        public void run() {
            List<Fragment> fragments = this.f21168c.getSupportFragmentManager().getFragments();
            t.d(fragments, "getFragments(...)");
            if (fragments.size() > 0) {
                Fragment fragment = fragments.get(0);
                if (fragment instanceof TvAppDetailFragment) {
                    ((TvAppDetailFragment) fragment).L0(this.f21167b, this.f21166a);
                }
            }
        }
    }

    public final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final int f21169a;

        /* renamed from: b  reason: collision with root package name */
        private final C2668q f21170b;

        public c(int i5, C2668q qVar) {
            this.f21169a = i5;
            this.f21170b = qVar;
        }

        /* access modifiers changed from: private */
        public static final void b(Fragment fragment, c cVar) {
            ((TvAppDetailFragment) fragment).N0(cVar.f21169a, cVar.f21170b);
        }

        public void run() {
            List<Fragment> fragments = TvAppDetailActivity.this.getSupportFragmentManager().getFragments();
            t.d(fragments, "getFragments(...)");
            if (fragments.size() > 0) {
                Fragment fragment = fragments.get(0);
                if (fragment instanceof TvAppDetailFragment) {
                    TvAppDetailActivity.this.runOnUiThread(new C2801a(fragment, this));
                }
            }
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21172a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvAppDetailActivity f21173b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f21174c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(TvAppDetailActivity tvAppDetailActivity, String str, C2308e eVar) {
            super(2, eVar);
            this.f21173b = tvAppDetailActivity;
            this.f21174c = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f21173b, this.f21174c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f21172a == 0) {
                u.b(obj);
                List<Fragment> fragments = this.f21173b.getSupportFragmentManager().getFragments();
                t.d(fragments, "getFragments(...)");
                if (fragments.size() > 0) {
                    Fragment fragment = fragments.get(0);
                    if (fragment instanceof TvAppDetailFragment) {
                        ((TvAppDetailFragment) fragment).M0(this.f21174c);
                    }
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public final Object n(String str, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.c(), new d(this, str, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.tv_app_detail_activity);
    }
}
