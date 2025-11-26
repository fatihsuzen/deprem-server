package w2;

import W2.J;
import W2.u;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.app.VerticalGridSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.VerticalGridPresenter;
import androidx.lifecycle.LifecycleOwnerKt;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.squareup.picasso.s;
import com.uptodown.R;
import java.util.ArrayList;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.t;
import l2.C2657f;
import l2.C2660i;
import org.json.JSONArray;
import org.json.JSONObject;
import v2.C2802b;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.I0;
import w3.M;
import w3.O;
import z2.F;
import z2.Z;

/* renamed from: w2.W  reason: case insensitive filesystem */
public final class C2827W extends VerticalGridSupportFragment implements BrowseSupportFragment.MainFragmentAdapterProvider {

    /* renamed from: f  reason: collision with root package name */
    public static final a f26152f = new a((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ArrayObjectAdapter f26153a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public C2660i f26154b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f26155c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f26156d;

    /* renamed from: e  reason: collision with root package name */
    private final BrowseSupportFragment.MainFragmentAdapter f26157e = new f(this);

    /* renamed from: w2.W$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final C2827W a(C2660i iVar) {
            t.e(iVar, "category");
            C2827W w4 = new C2827W();
            w4.setArguments(iVar.s());
            return w4;
        }

        private a() {
        }
    }

    /* renamed from: w2.W$b */
    private final class b implements OnItemViewClickedListener {
        public b() {
        }

        /* renamed from: a */
        public void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
            if ((obj instanceof C2657f) && C2827W.this.getActivity() != null && viewHolder != null) {
                C2802b bVar = (C2802b) C2827W.this.getActivity();
                t.b(bVar);
                bVar.m((C2657f) obj, viewHolder);
            }
        }
    }

    /* renamed from: w2.W$c */
    private final class c implements OnItemViewSelectedListener {
        public c() {
        }

        /* renamed from: a */
        public void onItemSelected(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
            if (obj != null) {
                ArrayObjectAdapter h5 = C2827W.this.f26153a;
                t.b(h5);
                int indexOf = h5.indexOf(obj);
                if (indexOf < C2827W.this.f26155c && indexOf >= C2827W.this.f26155c - 5 && !C2827W.this.f26156d) {
                    C2827W.this.s();
                }
            }
        }
    }

    /* renamed from: w2.W$d */
    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f26160a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2827W f26161b;

        /* renamed from: w2.W$d$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f26162a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2827W f26163b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ L f26164c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2827W w4, L l5, C2308e eVar) {
                super(2, eVar);
                this.f26163b = w4;
                this.f26164c = l5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f26163b, this.f26164c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f26162a == 0) {
                    u.b(obj);
                    this.f26163b.t((ArrayList) this.f26164c.f24690a);
                    this.f26163b.f26156d = false;
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(C2827W w4, C2308e eVar) {
            super(2, eVar);
            this.f26161b = w4;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f26161b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            l2.M m5;
            Integer num;
            Resources resources;
            Object f5 = C2316b.f();
            int i5 = this.f26160a;
            if (i5 == 0) {
                u.b(obj);
                L l5 = new L();
                this.f26161b.f26156d = true;
                FragmentActivity requireActivity = this.f26161b.requireActivity();
                t.d(requireActivity, "requireActivity(...)");
                Z z4 = new Z(requireActivity);
                if (this.f26161b.f26154b != null) {
                    C2660i i6 = this.f26161b.f26154b;
                    t.b(i6);
                    int c5 = i6.c();
                    if (c5 == -2) {
                        m5 = z4.N(75, this.f26161b.f26155c);
                    } else if (c5 != -1) {
                        C2660i i7 = this.f26161b.f26154b;
                        t.b(i7);
                        if (i7.i()) {
                            C2660i i8 = this.f26161b.f26154b;
                            t.b(i8);
                            m5 = z4.o0(i8.c(), 75, this.f26161b.f26155c);
                        } else {
                            C2660i i9 = this.f26161b.f26154b;
                            t.b(i9);
                            m5 = z4.l0(i9.c(), 75, this.f26161b.f26155c);
                        }
                    } else {
                        m5 = z4.k0(75, this.f26161b.f26155c);
                    }
                } else {
                    m5 = null;
                }
                if (!(m5 == null || m5.b() || m5.e() == null)) {
                    JSONObject e5 = m5.e();
                    t.b(e5);
                    JSONArray optJSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                    if (e5.optInt("success") == 1 && optJSONArray != null) {
                        l5.f24690a = new ArrayList();
                        Context context = this.f26161b.getContext();
                        if (context == null || (resources = context.getResources()) == null) {
                            num = null;
                        } else {
                            num = kotlin.coroutines.jvm.internal.b.b(resources.getDimensionPixelSize(R.dimen.tv_card_height));
                        }
                        int length = optJSONArray.length();
                        for (int i10 = 0; i10 < length; i10++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                            C2657f.b bVar = C2657f.f25002J0;
                            t.b(optJSONObject);
                            C2657f b5 = C2657f.b.b(bVar, optJSONObject, (Context) null, 2, (Object) null);
                            ((ArrayList) l5.f24690a).add(b5);
                            if (num != null) {
                                s.h().l(b5.F(num.intValue())).d();
                            }
                            this.f26161b.f26155c = this.f26161b.f26155c + 1;
                        }
                    }
                }
                I0 c6 = C2865c0.c();
                a aVar = new a(this.f26161b, l5, (C2308e) null);
                this.f26160a = 1;
                if (C2872g.g(c6, aVar, this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: w2.W$e */
    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f26165a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2827W f26166b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(C2827W w4, C2308e eVar) {
            super(2, eVar);
            this.f26166b = w4;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f26166b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f26165a;
            if (i5 == 0) {
                u.b(obj);
                C2827W w4 = this.f26166b;
                this.f26165a = 1;
                if (w4.r(this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public C2827W() {
        VerticalGridPresenter verticalGridPresenter = new VerticalGridPresenter();
        verticalGridPresenter.setNumberOfColumns(5);
        setGridPresenter(verticalGridPresenter);
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) new u2.d());
        this.f26153a = arrayObjectAdapter;
        setAdapter(arrayObjectAdapter);
    }

    private final void p(String str) {
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setMessage(str);
            builder.setPositiveButton(17039370, new C2826V());
            builder.setCancelable(true);
            builder.create().show();
        }
    }

    /* access modifiers changed from: private */
    public static final void q(DialogInterface dialogInterface, int i5) {
        t.e(dialogInterface, "dialogInterface");
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    public final Object r(C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new d(this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final void s() {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), (C2312i) null, (O) null, new e(this, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void t(ArrayList arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                ArrayObjectAdapter arrayObjectAdapter = this.f26153a;
                if (arrayObjectAdapter != null) {
                    arrayObjectAdapter.add(arrayList.get(i5));
                }
            }
        } else if (getContext() != null) {
            String string = getString(R.string.no_data_available);
            t.d(string, "getString(...)");
            p(string);
        }
    }

    public BrowseSupportFragment.MainFragmentAdapter getMainFragmentAdapter() {
        return this.f26157e;
    }

    public void onCreate(Bundle bundle) {
        Bundle arguments;
        super.onCreate(bundle);
        F f5 = new F(getContext());
        String simpleName = C2827W.class.getSimpleName();
        t.d(simpleName, "getSimpleName(...)");
        f5.f(simpleName);
        if (this.f26154b == null && (arguments = getArguments()) != null) {
            C2660i iVar = new C2660i(0, (String) null, (String) null, 7, (C2633k) null);
            this.f26154b = iVar;
            t.b(iVar);
            iVar.q(arguments);
        }
        startEntranceTransition();
        setOnItemViewClickedListener(new b());
        setOnItemViewSelectedListener(new c());
    }

    public void onResume() {
        super.onResume();
        if (this.f26155c == 0) {
            s();
        }
    }

    /* renamed from: w2.W$f */
    public static final class f extends BrowseSupportFragment.MainFragmentAdapter {
        f(C2827W w4) {
            super(w4);
        }

        public void setEntranceTransitionState(boolean z4) {
        }
    }
}
