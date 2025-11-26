package I2;

import O2.j;
import P3.c;
import P3.d;
import P3.e;
import P3.f;
import P3.h;
import P3.k;
import Q2.m;
import V2.a;
import X2.C2250q;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.Vector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import k4.A;
import k4.z;
import m.g;
import m.l;
import t3.s;
import v4.b;
import v4.p;
import v4.t;
import v4.w;

public final class i extends b implements c.b, t {

    /* renamed from: A  reason: collision with root package name */
    public TextView f18209A;

    /* renamed from: B  reason: collision with root package name */
    public k f18210B;

    /* renamed from: C  reason: collision with root package name */
    public w f18211C;

    /* renamed from: m  reason: collision with root package name */
    public RecyclerView f18212m;

    /* renamed from: n  reason: collision with root package name */
    public RecyclerView f18213n;

    /* renamed from: o  reason: collision with root package name */
    public RecyclerView f18214o;

    /* renamed from: p  reason: collision with root package name */
    public RecyclerView f18215p;

    /* renamed from: q  reason: collision with root package name */
    public ConstraintLayout f18216q;

    /* renamed from: r  reason: collision with root package name */
    public LinearLayout f18217r;

    /* renamed from: s  reason: collision with root package name */
    public LinearLayout f18218s;

    /* renamed from: t  reason: collision with root package name */
    public Button f18219t;

    /* renamed from: u  reason: collision with root package name */
    public Button f18220u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f18221v;

    /* renamed from: w  reason: collision with root package name */
    public TextView f18222w;

    /* renamed from: x  reason: collision with root package name */
    public TextView f18223x;

    /* renamed from: y  reason: collision with root package name */
    public TextView f18224y;

    /* renamed from: z  reason: collision with root package name */
    public TextView f18225z;

    public static final void i(i iVar, View view) {
        kotlin.jvm.internal.t.e(iVar, "this$0");
        iVar.dismiss();
    }

    public static final void j(i iVar, Boolean bool) {
        kotlin.jvm.internal.t.e(iVar, "this$0");
        w wVar = iVar.f18211C;
        k kVar = null;
        if (wVar == null) {
            kotlin.jvm.internal.t.w("stacksAdapter");
            wVar = null;
        }
        k kVar2 = iVar.f18210B;
        if (kVar2 == null) {
            kotlin.jvm.internal.t.w("viewModel");
        } else {
            kVar = kVar2;
        }
        ArrayList e5 = kVar.e();
        wVar.getClass();
        kotlin.jvm.internal.t.e(e5, "items");
        wVar.f26123a = e5;
        wVar.notifyDataSetChanged();
    }

    public static final void k(i iVar, String str) {
        Fragment fragment;
        FragmentManager supportFragmentManager;
        kotlin.jvm.internal.t.e(iVar, "this$0");
        FragmentActivity activity = iVar.getActivity();
        if (activity == null || (supportFragmentManager = activity.getSupportFragmentManager()) == null) {
            fragment = null;
        } else {
            fragment = supportFragmentManager.findFragmentByTag(m.f18916m);
        }
        BottomSheetDialogFragment bottomSheetDialogFragment = (BottomSheetDialogFragment) fragment;
        if (bottomSheetDialogFragment != null) {
            bottomSheetDialogFragment.dismiss();
        }
        FragmentActivity activity2 = iVar.getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    public static final void m(i iVar, View view) {
        LiveData liveData;
        Map map;
        int i5;
        int i6;
        Map map2;
        int i7;
        g gVar;
        i iVar2 = iVar;
        kotlin.jvm.internal.t.e(iVar2, "this$0");
        k kVar = null;
        if (l.f960a) {
            Fragment findFragmentByTag = iVar2.getChildFragmentManager().findFragmentByTag(g.f949g);
            if (findFragmentByTag instanceof g) {
                gVar = (g) findFragmentByTag;
            } else {
                gVar = null;
            }
            if (gVar != null) {
                gVar.f();
            }
        }
        k kVar2 = iVar2.f18210B;
        if (kVar2 == null) {
            kotlin.jvm.internal.t.w("viewModel");
        } else {
            kVar = kVar2;
        }
        kVar.getClass();
        if (a.e()) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(kVar.c());
            ArrayList arrayList2 = new ArrayList();
            d dVar = kVar.f18228a.f18314a;
            int i8 = 0;
            if (!(dVar == null || (map = dVar.f18872d) == null)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry entry : map.entrySet()) {
                    if (kVar.f18228a.f18331r.contains(((h) entry.getValue()).f18881a)) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                    int i9 = ((h) entry2.getValue()).f18881a;
                    d dVar2 = kVar.f18228a.f18314a;
                    if (dVar2 == null || (map2 = dVar2.f18877i) == null) {
                        i5 = 0;
                    } else {
                        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                        for (Map.Entry entry3 : map2.entrySet()) {
                            if (((k) entry3.getValue()).f18895k == null) {
                                linkedHashMap2.put(entry3.getKey(), entry3.getValue());
                            }
                        }
                        i5 = 0;
                        for (Map.Entry value : linkedHashMap2.entrySet()) {
                            Set<Number> set = ((k) value.getValue()).f18888d;
                            if (!b.w.a(set) || !set.isEmpty()) {
                                i7 = 0;
                                for (Number intValue : set) {
                                    if (intValue.intValue() == i9 && (i7 = i7 + 1) < 0) {
                                        C2250q.n();
                                    }
                                }
                            } else {
                                i7 = 0;
                            }
                            i5 += i7;
                        }
                    }
                    for (T3.g gVar2 : kVar.f18229b.f19282c.f19277a) {
                        List<Number> list = gVar2.f19275f;
                        if (!(list instanceof Collection) || !list.isEmpty()) {
                            i6 = 0;
                            for (Number intValue2 : list) {
                                if (intValue2.intValue() == i9 && (i6 = i6 + 1) < 0) {
                                    C2250q.n();
                                }
                            }
                        } else {
                            i6 = 0;
                        }
                        i5 += i6;
                    }
                    for (Number intValue3 : kVar.f18229b.f19281b.f19254s) {
                        if (intValue3.intValue() == i9) {
                            i5++;
                        }
                    }
                    if (i5 > 0) {
                        arrayList2.add(new c.i((e) entry2.getValue(), kVar.f18228a.f18331r.get(((h) entry2.getValue()).f18881a), (c.l) null, c.k.PURPOSE, kVar.f18233f.f().f25469d, Integer.valueOf(i5), 20));
                    }
                }
            }
            arrayList.addAll(arrayList2);
            int size = arrayList.size();
            while (true) {
                if (i8 < size) {
                    Object obj = arrayList.get(i8);
                    i8++;
                    if (kotlin.jvm.internal.t.a(((c.i) obj).f895b, Boolean.TRUE)) {
                        break;
                    }
                } else {
                    ChoiceCmp choiceCmp = ChoiceCmp.INSTANCE;
                    ChoiceCmpCallback callback = choiceCmp.getCallback();
                    if (callback != null) {
                        callback.onActionButtonClicked(F1.a.f2460a);
                    }
                    choiceCmp.setLoginProcessStart();
                    UUID uuid = z.f24676a;
                    liveData = z.e(A.ACTION1);
                }
            }
            kVar.f();
            UUID uuid2 = z.f24676a;
            liveData = z.a(A.SAVE_AND_EXIT);
        } else {
            kVar.f();
            UUID uuid22 = z.f24676a;
            liveData = z.a(A.SAVE_AND_EXIT);
        }
        liveData.observe(iVar2, new h(iVar2));
    }

    public static final void n(i iVar, String str) {
        Fragment fragment;
        FragmentManager supportFragmentManager;
        kotlin.jvm.internal.t.e(iVar, "this$0");
        FragmentActivity activity = iVar.getActivity();
        if (activity == null || (supportFragmentManager = activity.getSupportFragmentManager()) == null) {
            fragment = null;
        } else {
            fragment = supportFragmentManager.findFragmentByTag(m.f18916m);
        }
        BottomSheetDialogFragment bottomSheetDialogFragment = (BottomSheetDialogFragment) fragment;
        if (bottomSheetDialogFragment != null) {
            bottomSheetDialogFragment.dismiss();
        }
        FragmentActivity activity2 = iVar.getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    public static final void o(i iVar, View view) {
        FragmentManager supportFragmentManager;
        FragmentTransaction beginTransaction;
        FragmentTransaction add;
        kotlin.jvm.internal.t.e(iVar, "this$0");
        FragmentActivity activity = iVar.getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null && (beginTransaction = supportFragmentManager.beginTransaction()) != null && (add = beginTransaction.add((Fragment) new O2.i(), "h0.c")) != null) {
            add.commit();
        }
    }

    public static final void p(i iVar, View view) {
        FragmentManager supportFragmentManager;
        FragmentTransaction beginTransaction;
        FragmentTransaction add;
        kotlin.jvm.internal.t.e(iVar, "this$0");
        FragmentActivity activity = iVar.getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null && (beginTransaction = supportFragmentManager.beginTransaction()) != null && (add = beginTransaction.add((Fragment) new o.i(), "c0.b")) != null) {
            add.commit();
        }
    }

    public static final void q(i iVar, View view) {
        g gVar;
        kotlin.jvm.internal.t.e(iVar, "this$0");
        k kVar = null;
        if (l.f960a) {
            Fragment findFragmentByTag = iVar.getChildFragmentManager().findFragmentByTag(g.f949g);
            if (findFragmentByTag instanceof g) {
                gVar = (g) findFragmentByTag;
            } else {
                gVar = null;
            }
            if (gVar != null) {
                m.e eVar = gVar.f952c;
                if (eVar == null) {
                    kotlin.jvm.internal.t.w("viewModel");
                    eVar = null;
                }
                eVar.getClass();
                if (l.f960a) {
                    Vector vector = l.f961b;
                    vector.setAllOwnedItems();
                    r4.a aVar = eVar.f945a;
                    r4.b bVar = r4.b.GBC_CONSENT_STRING;
                    Vector l5 = aVar.l(bVar);
                    kotlin.jvm.internal.t.e(vector, "newVector");
                    if (l5 != null) {
                        l5.forEach(new m.i(vector));
                    }
                    aVar.h(bVar, vector);
                    ChoiceCmpCallback choiceCmpCallback = eVar.f946b;
                    if (choiceCmpCallback != null) {
                        choiceCmpCallback.onGoogleBasicConsentChange(l.a());
                    }
                }
            }
        }
        k kVar2 = iVar.f18210B;
        if (kVar2 == null) {
            kotlin.jvm.internal.t.w("viewModel");
        } else {
            kVar = kVar2;
        }
        kVar.f18228a.w();
        kVar.f();
        UUID uuid = z.f24676a;
        z.a(A.ACCEPT_ALL).observe(iVar, new g(iVar));
    }

    public final void d(c.i iVar) {
        kotlin.jvm.internal.t.e(iVar, "item");
        FragmentActivity activity = getActivity();
        if (activity != null && (iVar.f894a instanceof f)) {
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            String str = p.f26090y;
            if (supportFragmentManager.findFragmentByTag(str) == null) {
                FragmentTransaction beginTransaction = activity.getSupportFragmentManager().beginTransaction();
                e eVar = iVar.f894a;
                String str2 = eVar.f18882b;
                String a5 = ((f) eVar).a();
                String b5 = ((f) iVar.f894a).b();
                k kVar = this.f18210B;
                k kVar2 = null;
                if (kVar == null) {
                    kotlin.jvm.internal.t.w("viewModel");
                    kVar = null;
                }
                String str3 = kVar.f18233f.e().f25440i;
                k kVar3 = this.f18210B;
                if (kVar3 == null) {
                    kotlin.jvm.internal.t.w("viewModel");
                } else {
                    kVar2 = kVar3;
                }
                beginTransaction.add((Fragment) v4.k.b(str2, a5, b5, str3, kVar2.f18233f.e().f25445n, iVar.f894a.f18881a, iVar.f897d, false, j.f18829a), str).commit();
            }
        }
    }

    public final void e(c.i iVar) {
        kotlin.jvm.internal.t.e(iVar, "item");
        k kVar = this.f18210B;
        if (kVar == null) {
            kotlin.jvm.internal.t.w("viewModel");
            kVar = null;
        }
        kVar.getClass();
        kotlin.jvm.internal.t.e(iVar, "item");
        e eVar = iVar.f894a;
        if (eVar instanceof h) {
            Boolean bool = iVar.f895b;
            Boolean bool2 = Boolean.TRUE;
            if (kotlin.jvm.internal.t.a(bool, bool2)) {
                kVar.f18228a.f18331r.set(iVar.f894a.f18881a);
            } else {
                kVar.f18228a.f18331r.unset(iVar.f894a.f18881a);
            }
            UUID uuid = z.f24676a;
            z.d("Purposes_" + iVar.f894a.f18881a, String.valueOf(kotlin.jvm.internal.t.a(iVar.f895b, bool2)));
        } else if (eVar instanceof c) {
            Boolean bool3 = iVar.f895b;
            Boolean bool4 = Boolean.TRUE;
            if (kotlin.jvm.internal.t.a(bool3, bool4)) {
                kVar.f18228a.f18330q.set(iVar.f894a.f18881a);
            } else {
                kVar.f18228a.f18330q.unset(iVar.f894a.f18881a);
            }
            UUID uuid2 = z.f24676a;
            z.d("Special Features_" + iVar.f894a.f18881a, String.valueOf(kotlin.jvm.internal.t.a(iVar.f895b, bool4)));
        }
    }

    public final String h() {
        int i5;
        Map map;
        k kVar = this.f18210B;
        k kVar2 = null;
        if (kVar == null) {
            kotlin.jvm.internal.t.w("viewModel");
            kVar = null;
        }
        d dVar = kVar.f18228a.f18314a;
        int i6 = 0;
        if (dVar == null || (map = dVar.f18877i) == null) {
            i5 = 0;
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                if (((k) entry.getValue()).f18895k == null) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            i5 = linkedHashMap.size();
        }
        List list = kVar.f18229b.f19282c.f19277a;
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            Set r02 = C2250q.r0(((T3.g) next).f19275f);
            List list2 = kVar.f18229b.f19281b.f19243h;
            if (!b.w.a(r02) || !r02.isEmpty()) {
                Iterator it = r02.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (list2.contains(Integer.valueOf(((Number) it.next()).intValue()))) {
                            arrayList.add(next);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        int size = kVar.f18230c.f18273a.size() + arrayList.size() + i5;
        if (kVar.f18231d != null) {
            i6 = 1;
        }
        String valueOf = String.valueOf(size + i6);
        k kVar3 = this.f18210B;
        if (kVar3 == null) {
            kotlin.jvm.internal.t.w("viewModel");
        } else {
            kVar2 = kVar3;
        }
        String J4 = s.J(kVar2.f18233f.e().f25433b, "${partners}", valueOf, true);
        String string = getString(E1.e.consent_storage_method);
        kotlin.jvm.internal.t.d(string, "getString(R.string.consent_storage_method)");
        return s.J(s.J(J4, "${consentStorageMethod}", string, true), "${consentStorageDuration}", "13", true);
    }

    public final void l() {
        Button button = this.f18220u;
        k kVar = null;
        if (button != null) {
            k kVar2 = this.f18210B;
            if (kVar2 == null) {
                kotlin.jvm.internal.t.w("viewModel");
                kVar2 = null;
            }
            button.setText(kVar2.f18233f.e().f25438g);
            button.setOnClickListener(new c(this));
        }
        Button button2 = this.f18219t;
        if (button2 != null) {
            k kVar3 = this.f18210B;
            if (kVar3 == null) {
                kotlin.jvm.internal.t.w("viewModel");
            } else {
                kVar = kVar3;
            }
            button2.setText(kVar.f18233f.e().f25439h);
            button2.setOnClickListener(new d(this));
        }
        LinearLayout linearLayout = this.f18218s;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new e(this));
        }
        LinearLayout linearLayout2 = this.f18217r;
        if (linearLayout2 != null) {
            linearLayout2.setOnClickListener(new f(this));
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ViewModelStore viewModelStore = activity.getViewModelStore();
            kotlin.jvm.internal.t.d(viewModelStore, "it.viewModelStore");
            k kVar = (k) new ViewModelProvider(viewModelStore, (ViewModelProvider.Factory) new l()).get(k.class);
            this.f18210B = kVar;
            if (kVar == null) {
                kotlin.jvm.internal.t.w("viewModel");
                kVar = null;
            }
            kVar.f18242o.observe(this, new b(this));
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.t.e(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(E1.c.dialog_options, viewGroup, false);
        kotlin.jvm.internal.t.d(inflate, "inflater.inflate(R.layou…ptions, container, false)");
        return inflate;
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        kotlin.jvm.internal.t.e(menuItem, "item");
        if (menuItem.getItemId() == 16908332) {
            requireActivity().getOnBackPressedDispatcher().onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0284  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0288  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x028a  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x029d  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x030c  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0352  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x03bc  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x03e8  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0416  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x04d0  */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x04e0  */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x04f0  */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x0500  */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x0510  */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x051c  */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x0539  */
    /* JADX WARNING: Removed duplicated region for block: B:292:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0205  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x021d  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0235  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x024d  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0255  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0276  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r19, android.os.Bundle r20) {
        /*
            r18 = this;
            r2 = r18
            r11 = r19
            java.lang.String r0 = "view"
            kotlin.jvm.internal.t.e(r11, r0)
            super.onViewCreated(r19, r20)
            int r0 = E1.b.rv_privacy_policy
            android.view.View r0 = r11.findViewById(r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            r2.f18212m = r0
            int r0 = E1.b.rv_special_features_list
            android.view.View r0 = r11.findViewById(r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            r2.f18213n = r0
            int r0 = E1.b.rv_purposes_list
            android.view.View r0 = r11.findViewById(r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            r2.f18214o = r0
            int r0 = E1.b.rv_stacks_list
            android.view.View r0 = r11.findViewById(r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            r2.f18215p = r0
            int r0 = E1.b.options_container
            android.view.View r0 = r11.findViewById(r0)
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            r2.f18216q = r0
            int r0 = E1.b.section_legitimate_int
            android.view.View r0 = r11.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r2.f18217r = r0
            int r0 = E1.b.section_partners
            android.view.View r0 = r11.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r2.f18218s = r0
            int r0 = E1.b.btn_agree_to_all
            android.view.View r0 = r11.findViewById(r0)
            android.widget.Button r0 = (android.widget.Button) r0
            r2.f18220u = r0
            int r0 = E1.b.btn_save_and_exit
            android.view.View r0 = r11.findViewById(r0)
            android.widget.Button r0 = (android.widget.Button) r0
            r2.f18219t = r0
            int r0 = E1.b.tv_partners_options
            android.view.View r0 = r11.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r2.f18221v = r0
            int r0 = E1.b.tv_special_purposes_and_features_label
            android.view.View r0 = r11.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r2.f18222w = r0
            int r0 = E1.b.tv_purposes_label
            android.view.View r0 = r11.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r2.f18223x = r0
            int r0 = E1.b.tv_leg_interests_label
            android.view.View r0 = r11.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r2.f18224y = r0
            int r0 = E1.b.tv_partners_label
            android.view.View r0 = r11.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r2.f18225z = r0
            int r0 = E1.b.tv_options_description
            android.view.View r0 = r11.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r2.f18209A = r0
            int r0 = E1.b.gbc_fragment_container
            android.view.View r1 = r11.findViewById(r0)
            android.widget.FrameLayout r1 = (android.widget.FrameLayout) r1
            boolean r3 = m.l.f960a
            r12 = 8
            r13 = 0
            if (r3 == 0) goto L_0x00cc
            androidx.fragment.app.FragmentManager r1 = r2.getChildFragmentManager()
            androidx.fragment.app.FragmentTransaction r1 = r1.beginTransaction()
            m.g r3 = new m.g
            r3.<init>()
            java.lang.String r4 = m.g.f949g
            androidx.fragment.app.FragmentTransaction r0 = r1.add((int) r0, (androidx.fragment.app.Fragment) r3, (java.lang.String) r4)
            androidx.fragment.app.FragmentTransaction r0 = r0.addToBackStack(r13)
            r0.commit()
            goto L_0x00d2
        L_0x00cc:
            if (r1 != 0) goto L_0x00cf
            goto L_0x00d2
        L_0x00cf:
            r1.setVisibility(r12)
        L_0x00d2:
            I2.k r0 = r2.f18210B
            java.lang.String r14 = "viewModel"
            if (r0 != 0) goto L_0x00dc
            kotlin.jvm.internal.t.w(r14)
            r0 = r13
        L_0x00dc:
            r0.getClass()
            w3.M r3 = androidx.lifecycle.ViewModelKt.getViewModelScope(r0)
            w3.I r4 = w3.C2865c0.b()
            I2.j r6 = new I2.j
            r6.<init>(r0, r13)
            r7 = 2
            r8 = 0
            r5 = 0
            w3.C2908y0 unused = w3.C2876i.d(r3, r4, r5, r6, r7, r8)
            I2.k r0 = r2.f18210B
            if (r0 != 0) goto L_0x00fa
            kotlin.jvm.internal.t.w(r14)
            r0 = r13
        L_0x00fa:
            o4.k r0 = r0.f18233f
            m4.l r0 = r0.e()
            java.lang.String r0 = r0.f25432a
            boolean r1 = V2.a.e()
            r15 = 0
            if (r1 == 0) goto L_0x013c
            I2.k r0 = r2.f18210B
            if (r0 != 0) goto L_0x0111
            kotlin.jvm.internal.t.w(r14)
            r0 = r13
        L_0x0111:
            o4.k r0 = r0.f18233f
            m4.l r0 = r0.e()
            m4.e r0 = r0.f25448q
            java.lang.String r0 = r0.f25335d
            I2.k r1 = r2.f18210B
            if (r1 != 0) goto L_0x0123
            kotlin.jvm.internal.t.w(r14)
            r1 = r13
        L_0x0123:
            o4.k r1 = r1.f18233f
            m4.l r1 = r1.e()
            m4.e r1 = r1.f25448q
            java.lang.String r1 = r1.f25336e
            android.widget.TextView r3 = r2.f18209A
            if (r3 != 0) goto L_0x0132
            goto L_0x0139
        L_0x0132:
            android.text.Spanned r0 = androidx.core.text.HtmlCompat.fromHtml(r0, r15)
            r3.setText(r0)
        L_0x0139:
            r0 = r1
            goto L_0x01a8
        L_0x013c:
            boolean r1 = V2.a.d()
            if (r1 == 0) goto L_0x019c
            I2.k r0 = r2.f18210B
            if (r0 != 0) goto L_0x014a
            kotlin.jvm.internal.t.w(r14)
            r0 = r13
        L_0x014a:
            o4.k r0 = r0.f18233f
            m4.l r0 = r0.e()
            m4.a r0 = r0.f25449r
            java.lang.String r0 = r0.f25305c
            I2.k r1 = r2.f18210B
            if (r1 != 0) goto L_0x015c
            kotlin.jvm.internal.t.w(r14)
            r1 = r13
        L_0x015c:
            o4.k r1 = r1.f18233f
            m4.l r1 = r1.e()
            m4.a r1 = r1.f25449r
            java.lang.String r1 = r1.f25306d
            int r3 = r1.length()
            if (r3 != 0) goto L_0x017c
            I2.k r1 = r2.f18210B
            if (r1 != 0) goto L_0x0174
            kotlin.jvm.internal.t.w(r14)
            r1 = r13
        L_0x0174:
            o4.k r1 = r1.f18233f
            m4.l r1 = r1.e()
            java.lang.String r1 = r1.f25432a
        L_0x017c:
            int r3 = r0.length()
            if (r3 <= 0) goto L_0x018f
            android.widget.TextView r3 = r2.f18209A
            if (r3 != 0) goto L_0x0187
            goto L_0x0139
        L_0x0187:
            android.text.Spanned r0 = androidx.core.text.HtmlCompat.fromHtml(r0, r15)
            r3.setText(r0)
            goto L_0x0139
        L_0x018f:
            android.widget.TextView r0 = r2.f18209A
            if (r0 != 0) goto L_0x0194
            goto L_0x0139
        L_0x0194:
            java.lang.String r3 = r2.h()
            r0.setText(r3)
            goto L_0x0139
        L_0x019c:
            android.widget.TextView r1 = r2.f18209A
            if (r1 != 0) goto L_0x01a1
            goto L_0x01a8
        L_0x01a1:
            java.lang.String r3 = r2.h()
            r1.setText(r3)
        L_0x01a8:
            android.widget.TextView r1 = r2.f18209A
            if (r1 != 0) goto L_0x01ad
            goto L_0x01c8
        L_0x01ad:
            I2.k r3 = r2.f18210B
            if (r3 != 0) goto L_0x01b5
            kotlin.jvm.internal.t.w(r14)
            r3 = r13
        L_0x01b5:
            r3.getClass()
            boolean r4 = m.l.f960a
            if (r4 == 0) goto L_0x01c3
            R2.c r3 = r3.f18238k
            R2.a r3 = r3.f18954b
            java.lang.String r3 = r3.f18949c
            goto L_0x01c5
        L_0x01c3:
            java.lang.String r3 = ""
        L_0x01c5:
            r1.append(r3)
        L_0x01c8:
            android.widget.TextView r1 = r2.f18225z
            if (r1 != 0) goto L_0x01cd
            goto L_0x01e4
        L_0x01cd:
            I2.k r3 = r2.f18210B
            if (r3 != 0) goto L_0x01d5
            kotlin.jvm.internal.t.w(r14)
            r3 = r13
        L_0x01d5:
            o4.k r3 = r3.f18233f
            m4.l r3 = r3.e()
            java.lang.String r3 = r3.f25436e
            java.lang.String r3 = l4.e.a(r3)
            r1.setText(r3)
        L_0x01e4:
            android.widget.TextView r1 = r2.f18224y
            if (r1 != 0) goto L_0x01e9
            goto L_0x0200
        L_0x01e9:
            I2.k r3 = r2.f18210B
            if (r3 != 0) goto L_0x01f1
            kotlin.jvm.internal.t.w(r14)
            r3 = r13
        L_0x01f1:
            o4.k r3 = r3.f18233f
            m4.l r3 = r3.e()
            java.lang.String r3 = r3.f25434c
            java.lang.String r3 = l4.e.a(r3)
            r1.setText(r3)
        L_0x0200:
            android.widget.TextView r1 = r2.f18223x
            if (r1 != 0) goto L_0x0205
            goto L_0x0218
        L_0x0205:
            I2.k r3 = r2.f18210B
            if (r3 != 0) goto L_0x020d
            kotlin.jvm.internal.t.w(r14)
            r3 = r13
        L_0x020d:
            o4.k r3 = r3.f18233f
            m4.l r3 = r3.e()
            java.lang.String r3 = r3.f25435d
            r1.setText(r3)
        L_0x0218:
            android.widget.TextView r1 = r2.f18222w
            if (r1 != 0) goto L_0x021d
            goto L_0x0230
        L_0x021d:
            I2.k r3 = r2.f18210B
            if (r3 != 0) goto L_0x0225
            kotlin.jvm.internal.t.w(r14)
            r3 = r13
        L_0x0225:
            o4.k r3 = r3.f18233f
            m4.l r3 = r3.e()
            java.lang.String r3 = r3.f25437f
            r1.setText(r3)
        L_0x0230:
            android.widget.TextView r1 = r2.f18221v
            if (r1 != 0) goto L_0x0235
            goto L_0x0248
        L_0x0235:
            I2.k r3 = r2.f18210B
            if (r3 != 0) goto L_0x023d
            kotlin.jvm.internal.t.w(r14)
            r3 = r13
        L_0x023d:
            o4.k r3 = r3.f18233f
            m4.l r3 = r3.e()
            java.lang.String r3 = r3.f25441j
            r1.setText(r3)
        L_0x0248:
            android.widget.TextView r1 = r2.f26050b
            if (r1 != 0) goto L_0x024d
            goto L_0x0250
        L_0x024d:
            r1.setText(r0)
        L_0x0250:
            android.widget.ImageView r0 = r2.f26051c
            if (r0 != 0) goto L_0x0255
            goto L_0x0270
        L_0x0255:
            I2.a r1 = new I2.a
            r1.<init>(r2)
            r0.setOnClickListener(r1)
            I2.k r1 = r2.f18210B
            if (r1 != 0) goto L_0x0265
            kotlin.jvm.internal.t.w(r14)
            r1 = r13
        L_0x0265:
            o4.k r1 = r1.f18233f
            m4.l r1 = r1.e()
            java.lang.String r1 = r1.f25446o
            r0.setContentDescription(r1)
        L_0x0270:
            v4.w r0 = new v4.w
            I2.k r1 = r2.f18210B
            if (r1 != 0) goto L_0x027a
            kotlin.jvm.internal.t.w(r14)
            r1 = r13
        L_0x027a:
            java.util.ArrayList r1 = r1.e()
            m4.d r3 = r2.f26058j
            if (r3 != 0) goto L_0x0284
            r4 = r13
            goto L_0x0286
        L_0x0284:
            java.lang.Integer r4 = r3.f25324i
        L_0x0286:
            if (r3 != 0) goto L_0x028a
            r3 = r13
            goto L_0x028c
        L_0x028a:
            java.lang.Integer r3 = r3.f25316a
        L_0x028c:
            android.graphics.Typeface r5 = r2.f26060l
            r17 = r4
            r4 = r3
            r3 = r17
            r0.<init>(r1, r2, r3, r4, r5)
            r2.f18211C = r0
            androidx.recyclerview.widget.RecyclerView r0 = r2.f18215p
            if (r0 != 0) goto L_0x029d
            goto L_0x02b6
        L_0x029d:
            androidx.recyclerview.widget.LinearLayoutManager r1 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r3 = r0.getContext()
            r1.<init>(r3)
            r0.setLayoutManager(r1)
            v4.w r1 = r2.f18211C
            if (r1 != 0) goto L_0x02b3
            java.lang.String r1 = "stacksAdapter"
            kotlin.jvm.internal.t.w(r1)
            r1 = r13
        L_0x02b3:
            r0.setAdapter(r1)
        L_0x02b6:
            androidx.recyclerview.widget.RecyclerView r0 = r2.f18214o
            if (r0 != 0) goto L_0x02bb
            goto L_0x0307
        L_0x02bb:
            androidx.recyclerview.widget.LinearLayoutManager r1 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r3 = r0.getContext()
            r1.<init>(r3)
            r0.setLayoutManager(r1)
            r1 = r0
            c.h r0 = new c.h
            I2.k r3 = r2.f18210B
            if (r3 != 0) goto L_0x02d2
            kotlin.jvm.internal.t.w(r14)
            r3 = r13
        L_0x02d2:
            java.util.ArrayList r3 = r3.b()
            m4.d r4 = r2.f26058j
            if (r4 != 0) goto L_0x02dc
            r5 = r13
            goto L_0x02de
        L_0x02dc:
            java.lang.Integer r5 = r4.f25324i
        L_0x02de:
            if (r4 != 0) goto L_0x02e2
            r6 = r13
            goto L_0x02e4
        L_0x02e2:
            java.lang.Integer r6 = r4.f25320e
        L_0x02e4:
            if (r4 != 0) goto L_0x02e8
            r7 = r13
            goto L_0x02ea
        L_0x02e8:
            java.lang.Integer r7 = r4.f25321f
        L_0x02ea:
            if (r4 != 0) goto L_0x02ee
            r4 = r13
            goto L_0x02f0
        L_0x02ee:
            java.lang.Integer r4 = r4.f25316a
        L_0x02f0:
            android.graphics.Typeface r9 = r2.f26060l
            r10 = 268(0x10c, float:3.76E-43)
            r8 = r1
            r1 = r3
            r3 = 0
            r16 = r8
            r8 = 0
            r12 = r7
            r7 = r4
            r4 = r5
            r5 = r6
            r6 = r12
            r12 = r16
            r0.<init>((java.util.List) r1, (c.b) r2, (java.lang.String) r3, (java.lang.Integer) r4, (java.lang.Integer) r5, (java.lang.Integer) r6, (java.lang.Integer) r7, (android.graphics.Typeface) r8, (android.graphics.Typeface) r9, (int) r10)
            r12.setAdapter(r0)
        L_0x0307:
            androidx.recyclerview.widget.RecyclerView r12 = r2.f18213n
            if (r12 != 0) goto L_0x030c
            goto L_0x034d
        L_0x030c:
            androidx.recyclerview.widget.LinearLayoutManager r0 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r1 = r12.getContext()
            r0.<init>(r1)
            r12.setLayoutManager(r0)
            c.h r0 = new c.h
            I2.k r1 = r2.f18210B
            if (r1 != 0) goto L_0x0322
            kotlin.jvm.internal.t.w(r14)
            r1 = r13
        L_0x0322:
            java.util.ArrayList r1 = r1.d()
            m4.d r3 = r2.f26058j
            if (r3 != 0) goto L_0x032c
            r4 = r13
            goto L_0x032e
        L_0x032c:
            java.lang.Integer r4 = r3.f25324i
        L_0x032e:
            if (r3 != 0) goto L_0x0332
            r5 = r13
            goto L_0x0334
        L_0x0332:
            java.lang.Integer r5 = r3.f25320e
        L_0x0334:
            if (r3 != 0) goto L_0x0338
            r6 = r13
            goto L_0x033a
        L_0x0338:
            java.lang.Integer r6 = r3.f25321f
        L_0x033a:
            if (r3 != 0) goto L_0x033e
            r7 = r13
            goto L_0x0341
        L_0x033e:
            java.lang.Integer r3 = r3.f25316a
            r7 = r3
        L_0x0341:
            android.graphics.Typeface r9 = r2.f26060l
            r10 = 268(0x10c, float:3.76E-43)
            r3 = 0
            r8 = 0
            r0.<init>((java.util.List) r1, (c.b) r2, (java.lang.String) r3, (java.lang.Integer) r4, (java.lang.Integer) r5, (java.lang.Integer) r6, (java.lang.Integer) r7, (android.graphics.Typeface) r8, (android.graphics.Typeface) r9, (int) r10)
            r12.setAdapter(r0)
        L_0x034d:
            androidx.recyclerview.widget.RecyclerView r0 = r2.f18212m
            if (r0 != 0) goto L_0x0352
            goto L_0x03b2
        L_0x0352:
            androidx.recyclerview.widget.LinearLayoutManager r1 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r3 = r0.getContext()
            r1.<init>(r3)
            r0.setLayoutManager(r1)
            v4.s r1 = new v4.s
            I2.k r3 = r2.f18210B
            if (r3 != 0) goto L_0x0368
            kotlin.jvm.internal.t.w(r14)
            r3 = r13
        L_0x0368:
            r3.getClass()
            boolean r4 = V2.a.e()
            if (r4 == 0) goto L_0x037c
            o4.k r3 = r3.f18233f
            m4.l r3 = r3.e()
            m4.e r3 = r3.f25448q
            java.util.List r3 = r3.f25337f
            goto L_0x0399
        L_0x037c:
            T3.i r4 = r3.f18229b
            T3.c r4 = r4.f19281b
            T3.d r4 = r4.f19231V
            java.lang.Boolean r4 = r4.f19263b
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            boolean r4 = kotlin.jvm.internal.t.a(r4, r5)
            if (r4 == 0) goto L_0x0397
            o4.k r3 = r3.f18233f
            m4.l r3 = r3.e()
            m4.a r3 = r3.f25449r
            java.util.List r3 = r3.f25307e
            goto L_0x0399
        L_0x0397:
            java.util.List r3 = r3.f18234g
        L_0x0399:
            android.content.Context r4 = r0.getContext()
            java.lang.String r5 = "context"
            kotlin.jvm.internal.t.d(r4, r5)
            m4.d r5 = r2.f26058j
            if (r5 != 0) goto L_0x03a8
            r5 = r13
            goto L_0x03aa
        L_0x03a8:
            java.lang.Integer r5 = r5.f25327l
        L_0x03aa:
            android.graphics.Typeface r6 = r2.f26060l
            r1.<init>(r3, r4, r5, r6)
            r0.setAdapter(r1)
        L_0x03b2:
            r2.l()
            android.widget.TextView r0 = r2.f18223x
            java.lang.String r1 = "itemsList"
            if (r0 != 0) goto L_0x03bc
            goto L_0x03e3
        L_0x03bc:
            I2.k r3 = r2.f18210B
            if (r3 != 0) goto L_0x03c4
            kotlin.jvm.internal.t.w(r14)
            r3 = r13
        L_0x03c4:
            I2.k r4 = r2.f18210B
            if (r4 != 0) goto L_0x03cc
            kotlin.jvm.internal.t.w(r14)
            r4 = r13
        L_0x03cc:
            java.util.ArrayList r4 = r4.b()
            r3.getClass()
            kotlin.jvm.internal.t.e(r4, r1)
            boolean r3 = r4.isEmpty()
            if (r3 != 0) goto L_0x03de
            r3 = r15
            goto L_0x03e0
        L_0x03de:
            r3 = 8
        L_0x03e0:
            r0.setVisibility(r3)
        L_0x03e3:
            android.widget.TextView r0 = r2.f18222w
            if (r0 != 0) goto L_0x03e8
            goto L_0x0410
        L_0x03e8:
            I2.k r3 = r2.f18210B
            if (r3 != 0) goto L_0x03f0
            kotlin.jvm.internal.t.w(r14)
            r3 = r13
        L_0x03f0:
            I2.k r4 = r2.f18210B
            if (r4 != 0) goto L_0x03f8
            kotlin.jvm.internal.t.w(r14)
            goto L_0x03f9
        L_0x03f8:
            r13 = r4
        L_0x03f9:
            java.util.ArrayList r4 = r13.d()
            r3.getClass()
            kotlin.jvm.internal.t.e(r4, r1)
            boolean r1 = r4.isEmpty()
            if (r1 != 0) goto L_0x040b
            r12 = r15
            goto L_0x040d
        L_0x040b:
            r12 = 8
        L_0x040d:
            r0.setVisibility(r12)
        L_0x0410:
            m4.d r0 = r2.f26058j
            if (r0 != 0) goto L_0x0416
            goto L_0x04b9
        L_0x0416:
            java.lang.Integer r1 = r0.f25322g
            if (r1 != 0) goto L_0x041b
            goto L_0x0427
        L_0x041b:
            int r1 = r1.intValue()
            androidx.constraintlayout.widget.ConstraintLayout r3 = r2.f18216q
            if (r3 != 0) goto L_0x0424
            goto L_0x0427
        L_0x0424:
            r3.setBackgroundColor(r1)
        L_0x0427:
            java.lang.Integer r1 = r0.f25324i
            if (r1 != 0) goto L_0x042c
            goto L_0x0460
        L_0x042c:
            int r1 = r1.intValue()
            android.widget.TextView r3 = r2.f18223x
            if (r3 != 0) goto L_0x0435
            goto L_0x0438
        L_0x0435:
            r3.setTextColor(r1)
        L_0x0438:
            android.widget.TextView r3 = r2.f18222w
            if (r3 != 0) goto L_0x043d
            goto L_0x0440
        L_0x043d:
            r3.setTextColor(r1)
        L_0x0440:
            android.widget.TextView r3 = r2.f18221v
            if (r3 != 0) goto L_0x0445
            goto L_0x0448
        L_0x0445:
            r3.setTextColor(r1)
        L_0x0448:
            android.widget.TextView r3 = r2.f18225z
            if (r3 != 0) goto L_0x044d
            goto L_0x0450
        L_0x044d:
            r3.setTextColor(r1)
        L_0x0450:
            android.widget.TextView r3 = r2.f18224y
            if (r3 != 0) goto L_0x0455
            goto L_0x0458
        L_0x0455:
            r3.setTextColor(r1)
        L_0x0458:
            android.widget.TextView r3 = r2.f18209A
            if (r3 != 0) goto L_0x045d
            goto L_0x0460
        L_0x045d:
            r3.setTextColor(r1)
        L_0x0460:
            java.lang.Integer r1 = r0.f25316a
            if (r1 != 0) goto L_0x0465
            goto L_0x047f
        L_0x0465:
            int r1 = r1.intValue()
            android.widget.TextView r3 = r2.f18209A
            if (r3 != 0) goto L_0x046e
            goto L_0x047f
        L_0x046e:
            android.graphics.drawable.GradientDrawable r4 = new android.graphics.drawable.GradientDrawable
            r4.<init>()
            r5 = 1073741824(0x40000000, float:2.0)
            r4.setCornerRadius(r5)
            r5 = 4
            r4.setStroke(r5, r1)
            r3.setBackground(r4)
        L_0x047f:
            java.lang.Integer r1 = r0.f25328m
            if (r1 != 0) goto L_0x0484
            goto L_0x0498
        L_0x0484:
            int r1 = r1.intValue()
            android.widget.Button r3 = r2.f18220u
            if (r3 != 0) goto L_0x048d
            goto L_0x0490
        L_0x048d:
            r3.setTextColor(r1)
        L_0x0490:
            android.widget.Button r3 = r2.f18219t
            if (r3 != 0) goto L_0x0495
            goto L_0x0498
        L_0x0495:
            r3.setTextColor(r1)
        L_0x0498:
            java.lang.Integer r0 = r0.f25330o
            if (r0 != 0) goto L_0x049d
            goto L_0x04b9
        L_0x049d:
            int r0 = r0.intValue()
            android.widget.Button r1 = r2.f18220u
            if (r1 != 0) goto L_0x04a6
            goto L_0x04ad
        L_0x04a6:
            android.content.res.ColorStateList r3 = android.content.res.ColorStateList.valueOf(r0)
            r1.setBackgroundTintList(r3)
        L_0x04ad:
            android.widget.Button r1 = r2.f18219t
            if (r1 != 0) goto L_0x04b2
            goto L_0x04b9
        L_0x04b2:
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r0)
            r1.setBackgroundTintList(r0)
        L_0x04b9:
            m4.d r0 = r2.f26058j
            if (r0 != 0) goto L_0x04be
            goto L_0x0517
        L_0x04be:
            java.lang.Integer r0 = r0.f25316a
            if (r0 != 0) goto L_0x04c3
            goto L_0x0517
        L_0x04c3:
            int r0 = r0.intValue()
            int r1 = E1.b.purposes_divider
            android.view.View r1 = r11.findViewById(r1)
            if (r1 != 0) goto L_0x04d0
            goto L_0x04d7
        L_0x04d0:
            android.content.res.ColorStateList r3 = android.content.res.ColorStateList.valueOf(r0)
            r1.setBackgroundTintList(r3)
        L_0x04d7:
            int r1 = E1.b.special_features_divider
            android.view.View r1 = r11.findViewById(r1)
            if (r1 != 0) goto L_0x04e0
            goto L_0x04e7
        L_0x04e0:
            android.content.res.ColorStateList r3 = android.content.res.ColorStateList.valueOf(r0)
            r1.setBackgroundTintList(r3)
        L_0x04e7:
            int r1 = E1.b.partners_divider
            android.view.View r1 = r11.findViewById(r1)
            if (r1 != 0) goto L_0x04f0
            goto L_0x04f7
        L_0x04f0:
            android.content.res.ColorStateList r3 = android.content.res.ColorStateList.valueOf(r0)
            r1.setBackgroundTintList(r3)
        L_0x04f7:
            int r1 = E1.b.consent_divider
            android.view.View r1 = r11.findViewById(r1)
            if (r1 != 0) goto L_0x0500
            goto L_0x0507
        L_0x0500:
            android.content.res.ColorStateList r3 = android.content.res.ColorStateList.valueOf(r0)
            r1.setBackgroundTintList(r3)
        L_0x0507:
            int r1 = E1.b.leg_interests_divider
            android.view.View r1 = r11.findViewById(r1)
            if (r1 != 0) goto L_0x0510
            goto L_0x0517
        L_0x0510:
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r0)
            r1.setBackgroundTintList(r0)
        L_0x0517:
            android.graphics.Typeface r0 = r2.f26059k
            if (r0 != 0) goto L_0x051c
            goto L_0x0534
        L_0x051c:
            android.widget.TextView r1 = r2.f18223x
            if (r1 != 0) goto L_0x0521
            goto L_0x0524
        L_0x0521:
            r1.setTypeface(r0)
        L_0x0524:
            android.widget.TextView r1 = r2.f18222w
            if (r1 != 0) goto L_0x0529
            goto L_0x052c
        L_0x0529:
            r1.setTypeface(r0)
        L_0x052c:
            android.widget.TextView r1 = r2.f18221v
            if (r1 != 0) goto L_0x0531
            goto L_0x0534
        L_0x0531:
            r1.setTypeface(r0)
        L_0x0534:
            android.graphics.Typeface r0 = r2.f26060l
            if (r0 != 0) goto L_0x0539
            goto L_0x055d
        L_0x0539:
            android.widget.TextView r1 = r2.f18209A
            if (r1 != 0) goto L_0x053e
            goto L_0x0541
        L_0x053e:
            r1.setTypeface(r0)
        L_0x0541:
            android.widget.TextView r1 = r2.f18225z
            if (r1 != 0) goto L_0x0546
            goto L_0x0549
        L_0x0546:
            r1.setTypeface(r0)
        L_0x0549:
            android.widget.TextView r1 = r2.f18224y
            if (r1 != 0) goto L_0x054e
            goto L_0x0551
        L_0x054e:
            r1.setTypeface(r0)
        L_0x0551:
            android.widget.Button r1 = r2.f18220u
            if (r1 != 0) goto L_0x0556
            goto L_0x0559
        L_0x0556:
            r1.setTypeface(r0)
        L_0x0559:
            android.widget.Button r1 = r2.f18219t
            if (r1 != 0) goto L_0x055e
        L_0x055d:
            return
        L_0x055e:
            r1.setTypeface(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: I2.i.onViewCreated(android.view.View, android.os.Bundle):void");
    }
}
