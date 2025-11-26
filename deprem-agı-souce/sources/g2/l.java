package G2;

import E1.c;
import E1.e;
import R3.f;
import R3.g;
import R3.j;
import X2.C2242i;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.RecyclerView;
import b3.C2308e;
import c.h;
import c.i;
import c.k;
import com.mbridge.msdk.MBridgeConstans;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import m4.d;
import r4.a;
import v4.b;
import w3.C2865c0;
import w3.C2908y0;
import w3.O;

public final class l extends b implements c.b {

    /* renamed from: m  reason: collision with root package name */
    public TextView f18161m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f18162n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f18163o;

    /* renamed from: p  reason: collision with root package name */
    public Button f18164p;

    /* renamed from: q  reason: collision with root package name */
    public Button f18165q;

    /* renamed from: r  reason: collision with root package name */
    public RecyclerView f18166r;

    /* renamed from: s  reason: collision with root package name */
    public RecyclerView f18167s;

    /* renamed from: t  reason: collision with root package name */
    public RecyclerView f18168t;

    /* renamed from: u  reason: collision with root package name */
    public FrameLayout f18169u;

    /* renamed from: v  reason: collision with root package name */
    public ConstraintLayout f18170v;

    /* renamed from: w  reason: collision with root package name */
    public View f18171w;

    /* renamed from: x  reason: collision with root package name */
    public View f18172x;

    /* renamed from: y  reason: collision with root package name */
    public View f18173y;

    /* renamed from: z  reason: collision with root package name */
    public p f18174z;

    public static final void j(l lVar, View view) {
        t.e(lVar, "this$0");
        lVar.dismiss();
    }

    public static final void k(l lVar, String str) {
        t.e(lVar, "this$0");
        lVar.dismiss();
        FragmentActivity activity = lVar.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void l(G2.l r6, android.view.View r7) {
        /*
            java.lang.String r7 = "this$0"
            kotlin.jvm.internal.t.e(r6, r7)
            boolean r7 = m.l.f960a
            r0 = 0
            if (r7 == 0) goto L_0x0022
            androidx.fragment.app.FragmentManager r7 = r6.getChildFragmentManager()
            java.lang.String r1 = m.g.f949g
            androidx.fragment.app.Fragment r7 = r7.findFragmentByTag(r1)
            boolean r1 = r7 instanceof m.g
            if (r1 == 0) goto L_0x001b
            m.g r7 = (m.g) r7
            goto L_0x001c
        L_0x001b:
            r7 = r0
        L_0x001c:
            if (r7 != 0) goto L_0x001f
            goto L_0x0022
        L_0x001f:
            r7.f()
        L_0x0022:
            G2.p r7 = r6.f18174z
            if (r7 != 0) goto L_0x002c
            java.lang.String r7 = "viewModel"
            kotlin.jvm.internal.t.w(r7)
            r7 = r0
        L_0x002c:
            androidx.recyclerview.widget.RecyclerView r1 = r6.f18166r
            if (r1 != 0) goto L_0x0032
            r1 = r0
            goto L_0x0036
        L_0x0032:
            androidx.recyclerview.widget.RecyclerView$Adapter r1 = r1.getAdapter()
        L_0x0036:
            boolean r2 = r1 instanceof c.h
            if (r2 == 0) goto L_0x003d
            c.h r1 = (c.h) r1
            goto L_0x003e
        L_0x003d:
            r1 = r0
        L_0x003e:
            r2 = 10
            if (r1 != 0) goto L_0x0043
            goto L_0x0047
        L_0x0043:
            java.util.List r1 = r1.f884a
            if (r1 != 0) goto L_0x0049
        L_0x0047:
            r3 = r0
            goto L_0x0068
        L_0x0049:
            java.util.ArrayList r3 = new java.util.ArrayList
            int r4 = X2.C2250q.p(r1, r2)
            r3.<init>(r4)
            java.util.Iterator r1 = r1.iterator()
        L_0x0056:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0068
            java.lang.Object r4 = r1.next()
            c.i r4 = (c.i) r4
            java.lang.Boolean r4 = r4.f895b
            r3.add(r4)
            goto L_0x0056
        L_0x0068:
            androidx.recyclerview.widget.RecyclerView r1 = r6.f18167s
            if (r1 != 0) goto L_0x006e
            r1 = r0
            goto L_0x0072
        L_0x006e:
            androidx.recyclerview.widget.RecyclerView$Adapter r1 = r1.getAdapter()
        L_0x0072:
            boolean r4 = r1 instanceof c.h
            if (r4 == 0) goto L_0x0079
            c.h r1 = (c.h) r1
            goto L_0x007a
        L_0x0079:
            r1 = r0
        L_0x007a:
            if (r1 != 0) goto L_0x007d
            goto L_0x0081
        L_0x007d:
            java.util.List r1 = r1.f884a
            if (r1 != 0) goto L_0x0083
        L_0x0081:
            r4 = r0
            goto L_0x00a2
        L_0x0083:
            java.util.ArrayList r4 = new java.util.ArrayList
            int r5 = X2.C2250q.p(r1, r2)
            r4.<init>(r5)
            java.util.Iterator r1 = r1.iterator()
        L_0x0090:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x00a2
            java.lang.Object r5 = r1.next()
            c.i r5 = (c.i) r5
            java.lang.Boolean r5 = r5.f895b
            r4.add(r5)
            goto L_0x0090
        L_0x00a2:
            androidx.recyclerview.widget.RecyclerView r1 = r6.f18168t
            if (r1 != 0) goto L_0x00a8
            r1 = r0
            goto L_0x00ac
        L_0x00a8:
            androidx.recyclerview.widget.RecyclerView$Adapter r1 = r1.getAdapter()
        L_0x00ac:
            boolean r5 = r1 instanceof c.h
            if (r5 == 0) goto L_0x00b3
            c.h r1 = (c.h) r1
            goto L_0x00b4
        L_0x00b3:
            r1 = r0
        L_0x00b4:
            if (r1 != 0) goto L_0x00b7
            goto L_0x00db
        L_0x00b7:
            java.util.List r1 = r1.f884a
            if (r1 != 0) goto L_0x00bc
            goto L_0x00db
        L_0x00bc:
            java.util.ArrayList r0 = new java.util.ArrayList
            int r2 = X2.C2250q.p(r1, r2)
            r0.<init>(r2)
            java.util.Iterator r1 = r1.iterator()
        L_0x00c9:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00db
            java.lang.Object r2 = r1.next()
            c.i r2 = (c.i) r2
            java.lang.Boolean r2 = r2.f895b
            r0.add(r2)
            goto L_0x00c9
        L_0x00db:
            if (r3 != 0) goto L_0x00e1
            java.util.List r3 = X2.C2250q.g()
        L_0x00e1:
            if (r4 != 0) goto L_0x00e7
            java.util.List r4 = X2.C2250q.g()
        L_0x00e7:
            java.util.List r1 = X2.C2250q.b0(r3, r4)
            if (r0 != 0) goto L_0x00f1
            java.util.List r0 = X2.C2250q.g()
        L_0x00f1:
            java.util.List r0 = X2.C2250q.b0(r1, r0)
            r7.getClass()
            java.lang.String r1 = "purposeSwitchItemList"
            kotlin.jvm.internal.t.e(r0, r1)
            r7.c()
            T3.i r7 = s4.c.j()
            T3.c r7 = r7.f19281b
            java.lang.String r1 = r7.f19230U
            if (r1 != 0) goto L_0x010b
            goto L_0x0114
        L_0x010b:
            r4.a r2 = s4.c.l()
            r4.b r3 = r4.b.MSPA_CONFIG_THEME_UUID
            r2.i(r3, r1)
        L_0x0114:
            r4.a r1 = s4.c.l()
            r4.b r2 = r4.b.MSPA_CONFIG_LANGUAGE
            java.lang.String r7 = r7.f19250o
            r1.i(r2, r7)
            r4.a r7 = s4.c.l()
            r4.b r1 = r4.b.MSPA_CONFIG_GBC_APPLICABLE
            boolean r2 = m.l.f960a
            r7.j(r1, r2)
            boolean r7 = r0 instanceof java.util.Collection
            if (r7 == 0) goto L_0x0135
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x0135
            goto L_0x0174
        L_0x0135:
            java.util.Iterator r1 = r0.iterator()
        L_0x0139:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0174
            java.lang.Object r2 = r1.next()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            boolean r2 = kotlin.jvm.internal.t.a(r2, r3)
            if (r2 != 0) goto L_0x0139
            if (r7 == 0) goto L_0x0156
            boolean r7 = r0.isEmpty()
            if (r7 == 0) goto L_0x0156
            goto L_0x0171
        L_0x0156:
            java.util.Iterator r7 = r0.iterator()
        L_0x015a:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x0171
            java.lang.Object r0 = r7.next()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r0 = kotlin.jvm.internal.t.a(r0, r1)
            if (r0 != 0) goto L_0x015a
            k4.b r7 = k4.b.ACCEPT_PARTIAL
            goto L_0x0176
        L_0x0171:
            k4.b r7 = k4.b.REJECT
            goto L_0x0176
        L_0x0174:
            k4.b r7 = k4.b.ACCEPT_ALL
        L_0x0176:
            java.util.UUID r0 = k4.z.f24676a
            k4.A r0 = k4.A.SAVE_AND_EXIT
            androidx.lifecycle.LiveData r7 = k4.z.b(r0, r7)
            G2.k r0 = new G2.k
            r0.<init>(r6)
            r7.observe(r6, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: G2.l.l(G2.l, android.view.View):void");
    }

    public static final void m(l lVar, String str) {
        t.e(lVar, "this$0");
        lVar.dismiss();
        FragmentActivity activity = lVar.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static final void n(l lVar, View view) {
        t.e(lVar, "this$0");
        p pVar = lVar.f18174z;
        if (pVar == null) {
            t.w("viewModel");
            pVar = null;
        }
        pVar.a().observe(lVar, new j(lVar));
    }

    public final void d(i iVar) {
        t.e(iVar, "item");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: R3.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: R3.g} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(c.i r6) {
        /*
            r5 = this;
            java.lang.String r0 = "item"
            kotlin.jvm.internal.t.e(r6, r0)
            G2.p r0 = r5.f18174z
            r1 = 0
            if (r0 != 0) goto L_0x0010
            java.lang.String r0 = "viewModel"
            kotlin.jvm.internal.t.w(r0)
            r0 = r1
        L_0x0010:
            r0.getClass()
            java.lang.String r2 = "itemData"
            kotlin.jvm.internal.t.e(r6, r2)
            c.k r2 = r6.f897d
            int r2 = r2.ordinal()
            r3 = 10
            if (r2 == r3) goto L_0x0088
            r3 = 11
            if (r2 == r3) goto L_0x0028
            goto L_0x00b4
        L_0x0028:
            R3.a r0 = r0.f18179a
            java.util.List r0 = r0.f18959d
            if (r0 != 0) goto L_0x002f
            goto L_0x0080
        L_0x002f:
            java.util.Iterator r0 = r0.iterator()
        L_0x0033:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0052
            java.lang.Object r2 = r0.next()
            r3 = r2
            R3.f r3 = (R3.f) r3
            java.lang.Integer r3 = r3.f18985a
            int[] r4 = R3.j.f19017b
            int r4 = X2.C2242i.Q(r4)
            if (r3 != 0) goto L_0x004b
            goto L_0x0033
        L_0x004b:
            int r3 = r3.intValue()
            if (r3 != r4) goto L_0x0033
            goto L_0x0053
        L_0x0052:
            r2 = r1
        L_0x0053:
            R3.f r2 = (R3.f) r2
            if (r2 != 0) goto L_0x0058
            goto L_0x0080
        L_0x0058:
            java.util.List r0 = r2.f18990f
            if (r0 != 0) goto L_0x005d
            goto L_0x0080
        L_0x005d:
            java.util.Iterator r0 = r0.iterator()
        L_0x0061:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x007e
            java.lang.Object r2 = r0.next()
            r3 = r2
            R3.g r3 = (R3.g) r3
            java.lang.Integer r3 = r3.f18993b
            P3.e r4 = r6.f894a
            int r4 = r4.f18881a
            if (r3 != 0) goto L_0x0077
            goto L_0x0061
        L_0x0077:
            int r3 = r3.intValue()
            if (r3 != r4) goto L_0x0061
            r1 = r2
        L_0x007e:
            R3.g r1 = (R3.g) r1
        L_0x0080:
            if (r1 != 0) goto L_0x0083
            goto L_0x00b4
        L_0x0083:
            java.lang.Boolean r6 = r6.f895b
            r1.f18995d = r6
            return
        L_0x0088:
            R3.a r0 = r0.f18179a
            java.util.List r0 = r0.f18959d
            if (r0 != 0) goto L_0x008f
            goto L_0x00b2
        L_0x008f:
            java.util.Iterator r0 = r0.iterator()
        L_0x0093:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00b0
            java.lang.Object r2 = r0.next()
            r3 = r2
            R3.f r3 = (R3.f) r3
            java.lang.Integer r3 = r3.f18985a
            P3.e r4 = r6.f894a
            int r4 = r4.f18881a
            if (r3 != 0) goto L_0x00a9
            goto L_0x0093
        L_0x00a9:
            int r3 = r3.intValue()
            if (r3 != r4) goto L_0x0093
            r1 = r2
        L_0x00b0:
            R3.f r1 = (R3.f) r1
        L_0x00b2:
            if (r1 != 0) goto L_0x00b5
        L_0x00b4:
            return
        L_0x00b5:
            java.lang.Boolean r6 = r6.f895b
            r1.f18987c = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: G2.l.e(c.i):void");
    }

    public final h h(ArrayList arrayList) {
        Integer num;
        Integer num2;
        Integer num3;
        d dVar = this.f26058j;
        Integer num4 = null;
        if (dVar == null) {
            num = null;
        } else {
            num = dVar.f25324i;
        }
        if (dVar == null) {
            num2 = null;
        } else {
            num2 = dVar.f25320e;
        }
        if (dVar == null) {
            num3 = null;
        } else {
            num3 = dVar.f25321f;
        }
        if (dVar != null) {
            num4 = dVar.f25316a;
        }
        return new h((List) arrayList, (c.b) this, (String) null, num, num2, num3, num4, (Typeface) null, this.f26060l, 268);
    }

    public final void i() {
        Button button = this.f18164p;
        if (button != null) {
            button.setOnClickListener(new h(this));
        }
        Button button2 = this.f18165q;
        if (button2 != null) {
            button2.setOnClickListener(new i(this));
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getActivity() != null) {
            ViewModelStore viewModelStore = getViewModelStore();
            t.d(viewModelStore, "viewModelStore");
            p pVar = (p) new ViewModelProvider(viewModelStore, (ViewModelProvider.Factory) new q()).get(p.class);
            this.f18174z = pVar;
            if (pVar == null) {
                t.w("viewModel");
                pVar = null;
            }
            pVar.b(j.f19016a);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        t.e(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(c.dialog_mspa_options, viewGroup, false);
        t.d(inflate, "inflater.inflate(R.layou…ptions, container, false)");
        return inflate;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        ArrayList arrayList;
        View view2 = view;
        t.e(view2, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        super.onViewCreated(view, bundle);
        TextView textView = this.f26050b;
        if (textView != null) {
            textView.setText(getString(e.ccpa_privacy_title));
        }
        this.f18161m = (TextView) view2.findViewById(E1.b.tv_purposes_label1);
        this.f18166r = (RecyclerView) view2.findViewById(E1.b.rv_purposes_list);
        this.f18162n = (TextView) view2.findViewById(E1.b.tv_sensitive_purposes);
        this.f18163o = (TextView) view2.findViewById(E1.b.tv_child_sensitive_purposes);
        this.f18164p = (Button) view2.findViewById(E1.b.btn_save_and_exit);
        this.f18165q = (Button) view2.findViewById(E1.b.btn_agree_to_all);
        this.f18167s = (RecyclerView) view2.findViewById(E1.b.rv_sensitive_purposes_list);
        this.f18168t = (RecyclerView) view2.findViewById(E1.b.rv_child_sensitive_purposes_list);
        this.f18169u = (FrameLayout) view2.findViewById(E1.b.gbc_fragment_container);
        this.f18170v = (ConstraintLayout) view2.findViewById(E1.b.mspa_options_container);
        this.f18171w = view2.findViewById(E1.b.purposes_divider);
        this.f18172x = view2.findViewById(E1.b.sensitive_purposes_divider);
        this.f18173y = view2.findViewById(E1.b.child_sensitive_purposes_divider);
        ImageView imageView = this.f26051c;
        if (imageView != null) {
            imageView.setOnClickListener(new g(this));
        }
        p pVar = this.f18174z;
        if (pVar == null) {
            t.w("viewModel");
            pVar = null;
        }
        ArrayList b5 = pVar.b(j.f19016a);
        if (!b5.isEmpty()) {
            RecyclerView recyclerView = this.f18166r;
            if (recyclerView != null) {
                recyclerView.setAdapter(h(b5));
            }
            TextView textView2 = this.f18161m;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            RecyclerView recyclerView2 = this.f18166r;
            if (recyclerView2 != null) {
                recyclerView2.setVisibility(0);
            }
            View view3 = this.f18171w;
            if (view3 != null) {
                view3.setVisibility(0);
            }
        } else {
            TextView textView3 = this.f18161m;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            RecyclerView recyclerView3 = this.f18166r;
            if (recyclerView3 != null) {
                recyclerView3.setVisibility(8);
            }
            View view4 = this.f18171w;
            if (view4 != null) {
                view4.setVisibility(8);
            }
        }
        p pVar2 = this.f18174z;
        if (pVar2 == null) {
            t.w("viewModel");
            pVar2 = null;
        }
        pVar2.getClass();
        ArrayList arrayList2 = new ArrayList();
        List list = pVar2.f18179a.f18959d;
        if (list == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (Object next : list) {
                Integer num = ((f) next).f18985a;
                if (num != null) {
                    if (C2242i.J(j.f19017b, num.intValue())) {
                        arrayList.add(next);
                    }
                }
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                List<g> list2 = ((f) obj).f18990f;
                if (list2 != null) {
                    for (g gVar : list2) {
                        Integer num2 = gVar.f18993b;
                        if (num2 != null) {
                            int intValue = num2.intValue();
                            String str = gVar.f18996e;
                            if (str == null) {
                                str = "";
                            }
                            arrayList2.add(new i(new P3.e(intValue, str), gVar.f18995d, (c.l) null, k.MSPA_SENSITIVE_PURPOSE, (String) null, (Integer) null, 116));
                        }
                    }
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            RecyclerView recyclerView4 = this.f18167s;
            if (recyclerView4 != null) {
                recyclerView4.setAdapter(h(arrayList2));
            }
            TextView textView4 = this.f18162n;
            if (textView4 != null) {
                textView4.setVisibility(0);
            }
            RecyclerView recyclerView5 = this.f18167s;
            if (recyclerView5 != null) {
                recyclerView5.setVisibility(0);
            }
            View view5 = this.f18172x;
            if (view5 != null) {
                view5.setVisibility(0);
            }
        } else {
            TextView textView5 = this.f18162n;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            RecyclerView recyclerView6 = this.f18167s;
            if (recyclerView6 != null) {
                recyclerView6.setVisibility(8);
            }
            View view6 = this.f18172x;
            if (view6 != null) {
                view6.setVisibility(8);
            }
        }
        p pVar3 = this.f18174z;
        if (pVar3 == null) {
            t.w("viewModel");
            pVar3 = null;
        }
        ArrayList b6 = pVar3.b(j.f19018c);
        if (!b6.isEmpty()) {
            RecyclerView recyclerView7 = this.f18168t;
            if (recyclerView7 != null) {
                recyclerView7.setAdapter(h(b6));
            }
            TextView textView6 = this.f18163o;
            if (textView6 != null) {
                textView6.setVisibility(0);
            }
            RecyclerView recyclerView8 = this.f18168t;
            if (recyclerView8 != null) {
                recyclerView8.setVisibility(0);
            }
            View view7 = this.f18173y;
            if (view7 != null) {
                view7.setVisibility(0);
            }
        } else {
            TextView textView7 = this.f18163o;
            if (textView7 != null) {
                textView7.setVisibility(8);
            }
            RecyclerView recyclerView9 = this.f18168t;
            if (recyclerView9 != null) {
                recyclerView9.setVisibility(8);
            }
            View view8 = this.f18173y;
            if (view8 != null) {
                view8.setVisibility(8);
            }
        }
        if (m.l.f960a) {
            getChildFragmentManager().beginTransaction().add(E1.b.gbc_fragment_container, (Fragment) new m.g(), m.g.f949g).addToBackStack((String) null).commit();
            FrameLayout frameLayout = this.f18169u;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            p pVar4 = this.f18174z;
            if (pVar4 == null) {
                t.w("viewModel");
                pVar4 = null;
            }
            pVar4.getClass();
            if (m.l.f960a) {
                a l5 = s4.c.l();
                t.e(l5, "storage");
                l5.j(r4.b.GBC_SHOWN, true);
            }
        } else {
            FrameLayout frameLayout2 = this.f18169u;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(8);
            }
        }
        i();
        d dVar = this.f26058j;
        if (dVar != null) {
            Integer num3 = dVar.f25322g;
            if (num3 != null) {
                int intValue2 = num3.intValue();
                ConstraintLayout constraintLayout = this.f18170v;
                if (constraintLayout != null) {
                    constraintLayout.setBackgroundColor(intValue2);
                }
            }
            Integer num4 = dVar.f25324i;
            if (num4 != null) {
                int intValue3 = num4.intValue();
                TextView textView8 = this.f18161m;
                if (textView8 != null) {
                    textView8.setTextColor(intValue3);
                }
                TextView textView9 = this.f18162n;
                if (textView9 != null) {
                    textView9.setTextColor(intValue3);
                }
                TextView textView10 = this.f18163o;
                if (textView10 != null) {
                    textView10.setTextColor(intValue3);
                }
            }
            Integer num5 = dVar.f25328m;
            if (num5 != null) {
                int intValue4 = num5.intValue();
                Button button = this.f18164p;
                if (button != null) {
                    button.setTextColor(intValue4);
                }
                Button button2 = this.f18165q;
                if (button2 != null) {
                    button2.setTextColor(intValue4);
                }
            }
            Integer num6 = dVar.f25330o;
            if (num6 != null) {
                int intValue5 = num6.intValue();
                Button button3 = this.f18164p;
                if (button3 != null) {
                    button3.setBackgroundTintList(ColorStateList.valueOf(intValue5));
                }
                Button button4 = this.f18165q;
                if (button4 != null) {
                    button4.setBackgroundTintList(ColorStateList.valueOf(intValue5));
                }
            }
        }
        Typeface typeface = this.f26059k;
        if (typeface != null) {
            TextView textView11 = this.f18161m;
            if (textView11 != null) {
                textView11.setTypeface(typeface);
            }
            TextView textView12 = this.f18162n;
            if (textView12 != null) {
                textView12.setTypeface(typeface);
            }
            TextView textView13 = this.f18163o;
            if (textView13 != null) {
                textView13.setTypeface(typeface);
            }
        }
        Typeface typeface2 = this.f26060l;
        if (typeface2 != null) {
            Button button5 = this.f18164p;
            if (button5 != null) {
                button5.setTypeface(typeface2);
            }
            Button button6 = this.f18165q;
            if (button6 != null) {
                button6.setTypeface(typeface2);
            }
        }
        p pVar5 = this.f18174z;
        if (pVar5 == null) {
            t.w("viewModel");
            pVar5 = null;
        }
        pVar5.getClass();
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(pVar5), C2865c0.b(), (O) null, new o(pVar5, (C2308e) null), 2, (Object) null);
    }
}
