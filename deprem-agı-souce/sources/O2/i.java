package O2;

import E1.c;
import E1.e;
import M2.g;
import P3.k;
import X2.C2250q;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b3.C2308e;
import c.h;
import com.mbridge.msdk.MBridgeConstans;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import k4.z;
import kotlin.jvm.internal.t;
import m3.C2690a;
import m4.d;
import v4.b;
import w3.C2865c0;
import w3.C2908y0;
import w3.O;

public final class i extends b implements c.b {

    /* renamed from: m  reason: collision with root package name */
    public ConstraintLayout f18825m;

    /* renamed from: n  reason: collision with root package name */
    public RecyclerView f18826n;

    /* renamed from: o  reason: collision with root package name */
    public l f18827o;

    /* renamed from: p  reason: collision with root package name */
    public h f18828p;

    public static final void i(i iVar, View view) {
        t.e(iVar, "this$0");
        iVar.dismiss();
    }

    public static final void j(i iVar, PopupWindow popupWindow, ImageView imageView, CardView cardView, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view) {
        Integer num;
        Integer num2;
        t.e(iVar, "this$0");
        t.e(popupWindow, "$mypopupWindow");
        d dVar = iVar.f26058j;
        if (!(dVar == null || (num2 = dVar.f25322g) == null)) {
            cardView.setBackgroundTintList(ColorStateList.valueOf(num2.intValue()));
        }
        d dVar2 = iVar.f26058j;
        if (!(dVar2 == null || (num = dVar2.f25326k) == null)) {
            int intValue = num.intValue();
            if (textView != null) {
                textView.setTextColor(ColorStateList.valueOf(intValue));
            }
            if (textView2 != null) {
                textView2.setTextColor(ColorStateList.valueOf(intValue));
            }
            if (textView3 != null) {
                textView3.setTextColor(ColorStateList.valueOf(intValue));
            }
            if (textView4 != null) {
                textView4.setTextColor(ColorStateList.valueOf(intValue));
            }
        }
        popupWindow.showAsDropDown(imageView);
    }

    public static final void k(PopupWindow popupWindow, i iVar, View view) {
        t.e(popupWindow, "$mypopupWindow");
        t.e(iVar, "this$0");
        popupWindow.dismiss();
        TextView textView = iVar.f26050b;
        if (textView != null) {
            textView.setText(iVar.getString(e.all_partners_toolbar_title));
        }
        l lVar = iVar.f18827o;
        if (lVar == null) {
            t.w("viewModel");
            lVar = null;
        }
        j jVar = j.f18829a;
        lVar.getClass();
        t.e(jVar, "<set-?>");
        lVar.f18845j = jVar;
        iVar.h();
    }

    public static final void m(PopupWindow popupWindow, i iVar, View view) {
        t.e(popupWindow, "$mypopupWindow");
        t.e(iVar, "this$0");
        popupWindow.dismiss();
        TextView textView = iVar.f26050b;
        if (textView != null) {
            textView.setText(iVar.getString(e.iab_partners_toolbar_title));
        }
        l lVar = iVar.f18827o;
        if (lVar == null) {
            t.w("viewModel");
            lVar = null;
        }
        j jVar = j.f18830b;
        lVar.getClass();
        t.e(jVar, "<set-?>");
        lVar.f18845j = jVar;
        iVar.h();
    }

    public static final void n(PopupWindow popupWindow, i iVar, View view) {
        t.e(popupWindow, "$mypopupWindow");
        t.e(iVar, "this$0");
        popupWindow.dismiss();
        TextView textView = iVar.f26050b;
        if (textView != null) {
            textView.setText(iVar.getString(e.non_iab_partners_toolbar_title));
        }
        l lVar = iVar.f18827o;
        if (lVar == null) {
            t.w("viewModel");
            lVar = null;
        }
        j jVar = j.f18831c;
        lVar.getClass();
        t.e(jVar, "<set-?>");
        lVar.f18845j = jVar;
        iVar.h();
    }

    public static final void o(PopupWindow popupWindow, i iVar, View view) {
        t.e(popupWindow, "$mypopupWindow");
        t.e(iVar, "this$0");
        popupWindow.dismiss();
        TextView textView = iVar.f26050b;
        if (textView != null) {
            textView.setText(iVar.getString(e.google_partners_toolbar_title));
        }
        l lVar = iVar.f18827o;
        if (lVar == null) {
            t.w("viewModel");
            lVar = null;
        }
        j jVar = j.f18832d;
        lVar.getClass();
        t.e(jVar, "<set-?>");
        lVar.f18845j = jVar;
        iVar.h();
    }

    public final void d(c.i iVar) {
        FragmentActivity fragmentActivity;
        g gVar;
        String str;
        String str2;
        String str3;
        c.i iVar2 = iVar;
        t.e(iVar2, "item");
        FragmentActivity activity = getActivity();
        if (activity != null && (iVar2.f894a instanceof k)) {
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            String str4 = g.f18627H;
            if (supportFragmentManager.findFragmentByTag(str4) == null) {
                P3.e eVar = iVar2.f894a;
                if (eVar instanceof k) {
                    String str5 = eVar.f18882b;
                    String str6 = ((k) eVar).f18887c;
                    l lVar = this.f18827o;
                    if (lVar == null) {
                        t.w("viewModel");
                        lVar = null;
                    }
                    String a5 = lVar.a(((k) iVar2.f894a).f18888d, a.f18801a);
                    l lVar2 = this.f18827o;
                    if (lVar2 == null) {
                        t.w("viewModel");
                        lVar2 = null;
                    }
                    String a6 = lVar2.a(((k) iVar2.f894a).f18891g, a.f18802b);
                    l lVar3 = this.f18827o;
                    if (lVar3 == null) {
                        t.w("viewModel");
                        lVar3 = null;
                    }
                    String a7 = lVar3.a(((k) iVar2.f894a).f18892h, a.f18803c);
                    l lVar4 = this.f18827o;
                    if (lVar4 == null) {
                        t.w("viewModel");
                        lVar4 = null;
                    }
                    String a8 = lVar4.a(((k) iVar2.f894a).f18893i, a.f18804d);
                    l lVar5 = this.f18827o;
                    if (lVar5 == null) {
                        t.w("viewModel");
                        lVar5 = null;
                    }
                    String a9 = lVar5.a(((k) iVar2.f894a).f18898n, a.f18805e);
                    String str7 = ((k) iVar2.f894a).f18894j;
                    l lVar6 = this.f18827o;
                    if (lVar6 == null) {
                        t.w("viewModel");
                        lVar6 = null;
                    }
                    int i5 = ((k) iVar2.f894a).f18896l;
                    lVar6.getClass();
                    fragmentActivity = activity;
                    if (i5 < 0) {
                        str = "";
                    } else {
                        float f5 = ((float) i5) / 86400.0f;
                        if (f5 >= 1.0f) {
                            str = C2690a.a(f5) + ' ' + lVar6.f18836a.g().f25458i;
                        } else {
                            str = i5 + ' ' + lVar6.f18836a.g().f25459j;
                        }
                    }
                    l lVar7 = this.f18827o;
                    if (lVar7 == null) {
                        t.w("viewModel");
                        lVar7 = null;
                    }
                    Boolean bool = ((k) iVar2.f894a).f18897m;
                    lVar7.getClass();
                    String str8 = str7;
                    if (t.a(bool, Boolean.TRUE)) {
                        str2 = lVar7.f18836a.g().f25462m;
                    } else if (t.a(bool, Boolean.FALSE)) {
                        str2 = lVar7.f18836a.g().f25463n;
                    } else {
                        str2 = "";
                    }
                    l lVar8 = this.f18827o;
                    if (lVar8 == null) {
                        t.w("viewModel");
                        lVar8 = null;
                    }
                    P3.b bVar = ((k) iVar2.f894a).f18899o;
                    if (bVar == null || (str3 = Integer.valueOf(bVar.f18866a).toString()) == null) {
                        str3 = "";
                    }
                    lVar8.getClass();
                    t.e(str3, "dataRetention");
                    if (str3.length() != 0) {
                        str3 = str3 + ' ' + lVar8.f18836a.g().f25458i;
                    }
                    P3.e eVar2 = iVar2.f894a;
                    String str9 = str;
                    String str10 = str8;
                    M2.b bVar2 = new M2.b(str5, str6, a5, (String) null, a6, a7, a8, a9, str10, str9, str2, str3, eVar2.f18881a, iVar2.f897d, ((k) eVar2).f18900p, "Error: cannot load vendor file", 8);
                    t.e(bVar2, "args");
                    gVar = new g();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("partner_detail_args", bVar2);
                    gVar.setArguments(bundle);
                } else {
                    fragmentActivity = activity;
                    gVar = null;
                }
                if (gVar != null) {
                    fragmentActivity.getSupportFragmentManager().beginTransaction().add((Fragment) gVar, str4).commit();
                }
            }
        }
    }

    public final void e(c.i iVar) {
        t.e(iVar, "item");
        l lVar = this.f18827o;
        if (lVar == null) {
            t.w("viewModel");
            lVar = null;
        }
        lVar.getClass();
        t.e(iVar, "item");
        c.k kVar = iVar.f897d;
        c.k kVar2 = c.k.NON_IAB_VENDOR;
        if (kVar == kVar2) {
            Boolean bool = iVar.f895b;
            Boolean bool2 = Boolean.TRUE;
            if (t.a(bool, bool2)) {
                lVar.f18837b.f18307A.set(iVar.f894a.f18881a);
                UUID uuid = z.f24676a;
                z.d("Non IAB_" + iVar.f894a.f18881a, String.valueOf(t.a(iVar.f895b, bool2)));
                return;
            }
        }
        if (iVar.f897d != kVar2 || !t.a(iVar.f895b, Boolean.FALSE)) {
            c.k kVar3 = iVar.f897d;
            c.k kVar4 = c.k.IAB_VENDOR;
            if (kVar3 == kVar4) {
                Boolean bool3 = iVar.f895b;
                Boolean bool4 = Boolean.TRUE;
                if (t.a(bool3, bool4)) {
                    lVar.f18837b.f18339z.set(iVar.f894a.f18881a);
                    UUID uuid2 = z.f24676a;
                    z.d("Vendors_" + iVar.f894a.f18881a, String.valueOf(t.a(iVar.f895b, bool4)));
                    return;
                }
            }
            if (iVar.f897d != kVar4 || !t.a(iVar.f895b, Boolean.FALSE)) {
                c.k kVar5 = iVar.f897d;
                c.k kVar6 = c.k.GOOGLE_VENDOR;
                if (kVar5 == kVar6) {
                    Boolean bool5 = iVar.f895b;
                    Boolean bool6 = Boolean.TRUE;
                    if (t.a(bool5, bool6)) {
                        lVar.f18837b.f18308B.set(iVar.f894a.f18881a);
                        UUID uuid3 = z.f24676a;
                        z.d("Google_" + iVar.f894a.f18881a, String.valueOf(t.a(iVar.f895b, bool6)));
                        return;
                    }
                }
                if (iVar.f897d != kVar6 || !t.a(iVar.f895b, Boolean.FALSE)) {
                    c.k kVar7 = iVar.f897d;
                    c.k kVar8 = c.k.PUBLISHER_VENDOR;
                    if (kVar7 == kVar8) {
                        Boolean bool7 = iVar.f895b;
                        Boolean bool8 = Boolean.TRUE;
                        if (t.a(bool7, bool8)) {
                            lVar.f18837b.f18333t.set(iVar.f894a.f18881a);
                            lVar.f18837b.f18335v.setItems(C2250q.r0(((k) iVar.f894a).f18888d));
                            UUID uuid4 = z.f24676a;
                            z.d("Vendors_" + iVar.f894a.f18881a, String.valueOf(t.a(iVar.f895b, bool8)));
                            return;
                        }
                    }
                    if (iVar.f897d == kVar8 && t.a(iVar.f895b, Boolean.FALSE)) {
                        lVar.f18837b.f18333t.unset(iVar.f894a.f18881a);
                        lVar.f18837b.f18335v.unset((Set<Integer>) C2250q.r0(((k) iVar.f894a).f18888d));
                        UUID uuid5 = z.f24676a;
                        z.d("Vendors_" + iVar.f894a.f18881a, String.valueOf(t.a(iVar.f895b, Boolean.TRUE)));
                        return;
                    }
                    return;
                }
                lVar.f18837b.f18308B.unset(iVar.f894a.f18881a);
                UUID uuid6 = z.f24676a;
                z.d("Google_" + iVar.f894a.f18881a, String.valueOf(t.a(iVar.f895b, Boolean.TRUE)));
                return;
            }
            lVar.f18837b.f18339z.unset(iVar.f894a.f18881a);
            UUID uuid7 = z.f24676a;
            z.d("Vendors_" + iVar.f894a.f18881a, String.valueOf(t.a(iVar.f895b, Boolean.TRUE)));
            return;
        }
        lVar.f18837b.f18307A.unset(iVar.f894a.f18881a);
        UUID uuid8 = z.f24676a;
        z.d("Non IAB_" + iVar.f894a.f18881a, String.valueOf(t.a(iVar.f895b, Boolean.TRUE)));
    }

    public final void h() {
        CharSequence query;
        boolean z4;
        SearchView searchView = this.f26053e;
        if (searchView != null && (query = searchView.getQuery()) != null) {
            h hVar = this.f18828p;
            l lVar = null;
            if (hVar == null) {
                t.w("switchAdapter");
                hVar = null;
            }
            l lVar2 = this.f18827o;
            if (lVar2 == null) {
                t.w("viewModel");
            } else {
                lVar = lVar2;
            }
            List c5 = lVar.c(query.toString());
            if (query.length() > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            hVar.getClass();
            t.e(c5, "switchItems");
            hVar.f884a = c5;
            if (!z4) {
                hVar.a();
            }
            hVar.notifyDataSetChanged();
        }
    }

    public final void l() {
        ImageView imageView;
        l lVar = this.f18827o;
        l lVar2 = null;
        if (lVar == null) {
            t.w("viewModel");
            lVar = null;
        }
        if (!lVar.e().isEmpty() || !lVar.b().isEmpty()) {
            Toolbar toolbar = this.f26049a;
            if (toolbar == null) {
                imageView = null;
            } else {
                imageView = (ImageView) toolbar.findViewById(E1.b.toolbar_menu);
            }
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            View inflate = LayoutInflater.from(getContext()).inflate(c.list_partner_menu, (ViewGroup) null);
            CardView cardView = (CardView) inflate.findViewById(E1.b.cv_menu_item);
            TextView textView = (TextView) inflate.findViewById(E1.b.tv_menu_all);
            TextView textView2 = (TextView) inflate.findViewById(E1.b.tv_menu_iab);
            TextView textView3 = (TextView) inflate.findViewById(E1.b.tv_menu_non_iab);
            TextView textView4 = (TextView) inflate.findViewById(E1.b.tv_menu_google);
            l lVar3 = this.f18827o;
            if (lVar3 == null) {
                t.w("viewModel");
                lVar3 = null;
            }
            if (lVar3.e().isEmpty()) {
                textView3.setVisibility(8);
            }
            l lVar4 = this.f18827o;
            if (lVar4 == null) {
                t.w("viewModel");
            } else {
                lVar2 = lVar4;
            }
            if (lVar2.b().isEmpty()) {
                textView4.setVisibility(8);
            }
            PopupWindow popupWindow = new PopupWindow(inflate, 600, -2, true);
            popupWindow.setElevation(10.0f);
            textView.setOnClickListener(new d(popupWindow, this));
            textView2.setOnClickListener(new e(popupWindow, this));
            textView3.setOnClickListener(new f(popupWindow, this));
            textView4.setOnClickListener(new g(popupWindow, this));
            if (imageView != null) {
                imageView.setOnClickListener(new h(this, popupWindow, imageView, cardView, textView, textView2, textView3, textView4));
            }
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getActivity() != null) {
            ViewModelStore viewModelStore = getViewModelStore();
            t.d(viewModelStore, "viewModelStore");
            this.f18827o = (l) new ViewModelProvider(viewModelStore, (ViewModelProvider.Factory) new m()).get(l.class);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        t.e(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(c.dialog_partners, viewGroup, false);
        t.d(inflate, "inflater.inflate(R.layou…rtners, container, false)");
        return inflate;
    }

    public final void onPause() {
        boolean z4;
        super.onPause();
        l lVar = this.f18827o;
        if (lVar == null) {
            t.w("viewModel");
            lVar = null;
        }
        SearchView searchView = this.f26053e;
        if (searchView == null) {
            z4 = false;
        } else {
            z4 = searchView.hasFocus();
        }
        lVar.f18846k = z4;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        SearchView searchView;
        Integer num5;
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        super.onViewCreated(view, bundle);
        this.f18825m = (ConstraintLayout) view.findViewById(E1.b.partners_container);
        this.f18826n = (RecyclerView) view.findViewById(E1.b.rv_partners_list);
        l lVar = this.f18827o;
        l lVar2 = null;
        if (lVar == null) {
            t.w("viewModel");
            lVar = null;
        }
        lVar.getClass();
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(lVar), C2865c0.b(), (O) null, new k(lVar, (C2308e) null), 2, (Object) null);
        TextView textView = this.f26050b;
        if (textView != null) {
            l lVar3 = this.f18827o;
            if (lVar3 == null) {
                t.w("viewModel");
                lVar3 = null;
            }
            textView.setText(l4.e.a(lVar3.f18836a.f().f25466a));
        }
        ImageView imageView = this.f26051c;
        if (imageView != null) {
            imageView.setOnClickListener(new c(this));
            l lVar4 = this.f18827o;
            if (lVar4 == null) {
                t.w("viewModel");
                lVar4 = null;
            }
            imageView.setContentDescription(lVar4.f18836a.f().f25472g);
        }
        l();
        SearchView searchView2 = this.f26053e;
        if (searchView2 != null) {
            searchView2.setVisibility(0);
        }
        SearchView searchView3 = this.f26053e;
        if (searchView3 != null) {
            l lVar5 = this.f18827o;
            if (lVar5 == null) {
                t.w("viewModel");
                lVar5 = null;
            }
            searchView3.setQueryHint(lVar5.f18836a.f().f25468c);
        }
        SearchView searchView4 = this.f26053e;
        if (searchView4 != null) {
            searchView4.setOnQueryTextListener(new b(this));
        }
        l lVar6 = this.f18827o;
        if (lVar6 == null) {
            t.w("viewModel");
            lVar6 = null;
        }
        List c5 = lVar6.c("");
        l lVar7 = this.f18827o;
        if (lVar7 == null) {
            t.w("viewModel");
            lVar7 = null;
        }
        String str = lVar7.f18836a.f().f25467b;
        d dVar = this.f26058j;
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
        if (dVar == null) {
            num4 = null;
        } else {
            num4 = dVar.f25316a;
        }
        this.f18828p = new h(c5, (c.b) this, str, num, num2, num3, num4, this.f26059k, this.f26060l, 8);
        RecyclerView recyclerView = this.f18826n;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            h hVar = this.f18828p;
            if (hVar == null) {
                t.w("switchAdapter");
                hVar = null;
            }
            recyclerView.setAdapter(hVar);
        }
        d dVar2 = this.f26058j;
        if (!(dVar2 == null || (num5 = dVar2.f25322g) == null)) {
            int intValue = num5.intValue();
            ConstraintLayout constraintLayout = this.f18825m;
            if (constraintLayout != null) {
                constraintLayout.setBackgroundColor(intValue);
            }
        }
        l lVar8 = this.f18827o;
        if (lVar8 == null) {
            t.w("viewModel");
        } else {
            lVar2 = lVar8;
        }
        if (lVar2.f18846k && (searchView = this.f26053e) != null) {
            searchView.requestFocus();
        }
    }
}
