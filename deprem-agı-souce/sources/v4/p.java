package v4;

import E1.c;
import E1.f;
import P3.d;
import P3.e;
import T3.g;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.b;
import c.h;
import c.i;
import c.k;
import c.l;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import k4.z;
import kotlin.jvm.internal.t;

public final class p extends b {

    /* renamed from: A  reason: collision with root package name */
    public static k f26089A;

    /* renamed from: y  reason: collision with root package name */
    public static final String f26090y;

    /* renamed from: z  reason: collision with root package name */
    public static int f26091z;

    /* renamed from: m  reason: collision with root package name */
    public ConstraintLayout f26092m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f26093n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f26094o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f26095p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f26096q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f26097r;

    /* renamed from: s  reason: collision with root package name */
    public NestedScrollView f26098s;

    /* renamed from: t  reason: collision with root package name */
    public RecyclerView f26099t;

    /* renamed from: u  reason: collision with root package name */
    public I2.k f26100u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f26101v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f26102w;

    /* renamed from: x  reason: collision with root package name */
    public String f26103x;

    static {
        String simpleName = p.class.getSimpleName();
        t.d(simpleName, "LegalDetailFragment::class.java.simpleName");
        f26090y = simpleName;
    }

    public static final void i(p pVar, View view) {
        P3.k kVar;
        d dVar;
        Map map;
        Integer num;
        i a5;
        Map map2;
        i a6;
        Map map3;
        i a7;
        Map map4;
        p pVar2 = pVar;
        t.e(pVar2, "this$0");
        NestedScrollView nestedScrollView = pVar2.f26098s;
        if (nestedScrollView != null) {
            nestedScrollView.setVisibility(8);
        }
        RecyclerView recyclerView = pVar2.f26099t;
        if (recyclerView != null) {
            I2.k kVar2 = pVar2.f26100u;
            if (kVar2 == null) {
                t.w("viewModel");
                kVar2 = null;
            }
            int i5 = f26091z;
            k kVar3 = f26089A;
            if (kVar3 == null) {
                t.w("localSwitchItemType");
                kVar3 = null;
            }
            boolean z4 = pVar2.f26102w;
            String str = pVar2.f26103x;
            if (str == null) {
                str = "";
            }
            kVar2.getClass();
            t.e(kVar3, "itemType");
            t.e(str, "vendorTypeSelected");
            ArrayList arrayList = new ArrayList();
            int ordinal = kVar3.ordinal();
            if (ordinal == 4) {
                ArrayList arrayList2 = new ArrayList();
                if (!((!t.a(str, "ALL_VENDORS") && !t.a(str, "IAB_VENDORS")) || (dVar = kVar2.f18228a.f18314a) == null || (map = dVar.f18877i) == null)) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry entry : map.entrySet()) {
                        if (((P3.k) entry.getValue()).f18895k == null) {
                            linkedHashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                    for (Map.Entry value : linkedHashMap.entrySet()) {
                        P3.k kVar4 = (P3.k) value.getValue();
                        if (z4) {
                            for (Number intValue : kVar4.f18889e) {
                                if (intValue.intValue() == i5) {
                                    arrayList2.add(new i((e) kVar4, (Boolean) null, l.NON_SWITCH, k.PURPOSE_PARTNER, kVar4.f18882b, (Integer) null, 82));
                                }
                            }
                        } else {
                            for (Number intValue2 : kVar4.f18888d) {
                                if (intValue2.intValue() == i5) {
                                    arrayList2.add(new i((e) kVar4, (Boolean) null, l.NON_SWITCH, k.PURPOSE_PARTNER, kVar4.f18882b, (Integer) null, 82));
                                }
                            }
                        }
                    }
                }
                if (t.a(str, "ALL_VENDORS") || t.a(str, "NON_IAB_VENDORS")) {
                    for (g gVar : kVar2.f18229b.f19282c.f19277a) {
                        if (z4) {
                            for (Number intValue3 : gVar.f19276g) {
                                if (intValue3.intValue() == i5) {
                                    arrayList2.add(new i((e) gVar.a(), (Boolean) null, l.NON_SWITCH, k.PURPOSE_PARTNER, gVar.f19272c, (Integer) null, 82));
                                }
                            }
                        } else {
                            for (Number intValue4 : gVar.f19275f) {
                                if (intValue4.intValue() == i5) {
                                    arrayList2.add(new i((e) gVar.a(), (Boolean) null, l.NON_SWITCH, k.PURPOSE_PARTNER, gVar.f19272c, (Integer) null, 82));
                                }
                            }
                        }
                    }
                    if (t.a(str, "ALL_VENDORS") && (kVar = kVar2.f18231d) != null) {
                        if (z4) {
                            for (Number intValue5 : kVar.f18889e) {
                                if (intValue5.intValue() == i5) {
                                    arrayList2.add(new i((e) kVar, (Boolean) null, l.NON_SWITCH, k.PURPOSE_PARTNER, kVar.f18882b, (Integer) null, 82));
                                }
                            }
                        } else {
                            for (Number intValue6 : kVar.f18888d) {
                                if (intValue6.intValue() == i5) {
                                    arrayList2.add(new i((e) kVar, (Boolean) null, l.NON_SWITCH, k.PURPOSE_PARTNER, kVar.f18882b, (Integer) null, 82));
                                }
                            }
                        }
                    }
                }
                arrayList.addAll(arrayList2);
            } else if (ordinal != 5) {
                if (ordinal != 6) {
                    if (ordinal == 7 && (t.a(str, "ALL_VENDORS") || t.a(str, "IAB_VENDORS"))) {
                        d dVar2 = kVar2.f18228a.f18314a;
                        if (!(dVar2 == null || (map4 = dVar2.f18877i) == null)) {
                            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                            for (Map.Entry entry2 : map4.entrySet()) {
                                if (((P3.k) entry2.getValue()).f18895k == null) {
                                    linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                                }
                            }
                            for (Map.Entry value2 : linkedHashMap2.entrySet()) {
                                P3.k kVar5 = (P3.k) value2.getValue();
                                for (Number intValue7 : kVar5.f18893i) {
                                    if (intValue7.intValue() == i5) {
                                        arrayList.add(new i((e) kVar5, (Boolean) null, l.NON_SWITCH, k.PURPOSE_PARTNER, kVar5.f18882b, (Integer) null, 82));
                                    }
                                }
                            }
                        }
                        P3.k kVar6 = kVar2.f18231d;
                        if (!(kVar6 == null || (a7 = kVar2.a(str, kVar6.f18893i, i5)) == null)) {
                            arrayList.add(a7);
                        }
                    }
                } else if (t.a(str, "ALL_VENDORS") || t.a(str, "IAB_VENDORS")) {
                    d dVar3 = kVar2.f18228a.f18314a;
                    if (!(dVar3 == null || (map3 = dVar3.f18877i) == null)) {
                        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                        for (Map.Entry entry3 : map3.entrySet()) {
                            if (((P3.k) entry3.getValue()).f18895k == null) {
                                linkedHashMap3.put(entry3.getKey(), entry3.getValue());
                            }
                        }
                        for (Map.Entry value3 : linkedHashMap3.entrySet()) {
                            P3.k kVar7 = (P3.k) value3.getValue();
                            for (Number intValue8 : kVar7.f18892h) {
                                if (intValue8.intValue() == i5) {
                                    arrayList.add(new i((e) kVar7, (Boolean) null, l.NON_SWITCH, k.PURPOSE_PARTNER, kVar7.f18882b, (Integer) null, 82));
                                }
                            }
                        }
                    }
                    P3.k kVar8 = kVar2.f18231d;
                    if (!(kVar8 == null || (a6 = kVar2.a(str, kVar8.f18892h, i5)) == null)) {
                        arrayList.add(a6);
                    }
                }
            } else if (t.a(str, "ALL_VENDORS") || t.a(str, "IAB_VENDORS")) {
                d dVar4 = kVar2.f18228a.f18314a;
                if (!(dVar4 == null || (map2 = dVar4.f18877i) == null)) {
                    LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                    for (Map.Entry entry4 : map2.entrySet()) {
                        if (((P3.k) entry4.getValue()).f18895k == null) {
                            linkedHashMap4.put(entry4.getKey(), entry4.getValue());
                        }
                    }
                    for (Map.Entry value4 : linkedHashMap4.entrySet()) {
                        P3.k kVar9 = (P3.k) value4.getValue();
                        for (Number intValue9 : kVar9.f18891g) {
                            if (intValue9.intValue() == i5) {
                                arrayList.add(new i((e) kVar9, (Boolean) null, l.NON_SWITCH, k.PURPOSE_PARTNER, kVar9.f18882b, (Integer) null, 82));
                            }
                        }
                    }
                }
                P3.k kVar10 = kVar2.f18231d;
                if (!(kVar10 == null || (a5 = kVar2.a(str, kVar10.f18891g, i5)) == null)) {
                    arrayList.add(a5);
                }
            }
            Integer num2 = null;
            m mVar = new m();
            m4.d dVar5 = pVar2.f26058j;
            if (dVar5 == null) {
                num = null;
            } else {
                num = dVar5.f25324i;
            }
            if (dVar5 != null) {
                num2 = dVar5.f25316a;
            }
            recyclerView.setAdapter(new h((List) arrayList, (b) mVar, (String) null, num, (Integer) null, (Integer) null, num2, (Typeface) null, pVar2.f26060l, 364));
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setVisibility(0);
        }
        pVar2.f26101v = true;
    }

    public static final void k(p pVar, View view) {
        t.e(pVar, "this$0");
        pVar.h();
    }

    public final void h() {
        if (this.f26101v) {
            NestedScrollView nestedScrollView = this.f26098s;
            if (nestedScrollView != null) {
                nestedScrollView.setVisibility(0);
            }
            RecyclerView recyclerView = this.f26099t;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            this.f26101v = false;
            return;
        }
        UUID uuid = z.f24676a;
        StringBuilder sb = new StringBuilder();
        k kVar = f26089A;
        if (kVar == null) {
            t.w("localSwitchItemType");
            kVar = null;
        }
        int ordinal = kVar.ordinal();
        int i5 = 6;
        if (ordinal != 5) {
            if (ordinal != 6) {
                i5 = 7;
                if (ordinal != 7) {
                    i5 = 3;
                }
            } else {
                i5 = 1;
            }
        }
        sb.append(k4.d.a(i5));
        sb.append("-id:");
        sb.append(f26091z);
        String sb2 = sb.toString();
        t.e("collapseElement", "identifier");
        t.e(sb2, "value");
        z.f24677b.i("collapseElement", sb2);
        dismiss();
    }

    public final void j(View view) {
        this.f26092m = (ConstraintLayout) view.findViewById(E1.b.legal_detail_container);
        this.f26093n = (TextView) view.findViewById(E1.b.detail_legal_description_label);
        this.f26094o = (TextView) view.findViewById(E1.b.detail_legal_description);
        this.f26095p = (TextView) view.findViewById(E1.b.detail_description);
        this.f26096q = (TextView) view.findViewById(E1.b.detail_title);
        this.f26097r = (TextView) view.findViewById(E1.b.tv_show_partners);
        this.f26098s = (NestedScrollView) view.findViewById(E1.b.sc_description_container);
        this.f26099t = (RecyclerView) view.findViewById(E1.b.rv_purpose_partners_list);
        I2.k kVar = this.f26100u;
        if (kVar == null) {
            t.w("viewModel");
            kVar = null;
        }
        String str = kVar.f18233f.e().f25447p;
        if (str.length() > 0) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new UnderlineSpan(), 0, str.length(), 0);
            TextView textView = this.f26097r;
            if (textView != null) {
                textView.setText(spannableString);
            }
        }
        TextView textView2 = this.f26097r;
        if (textView2 != null) {
            textView2.setOnClickListener(new o(this));
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            TextView textView3 = this.f26096q;
            if (textView3 != null) {
                textView3.setText(arguments.getString(CampaignEx.JSON_KEY_TITLE, ""));
            }
            TextView textView4 = this.f26095p;
            if (textView4 != null) {
                textView4.setText(arguments.getString("description", ""));
            }
            TextView textView5 = this.f26094o;
            if (textView5 != null) {
                textView5.setText(arguments.getString("legal_description", ""));
            }
            TextView textView6 = this.f26093n;
            if (textView6 != null) {
                textView6.setText(arguments.getString("legal_description_label", ""));
            }
            this.f26102w = arguments.getBoolean("legitimate_interest", false);
            this.f26103x = arguments.getString("vendor_type_selected", "");
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ViewModelStore viewModelStore = activity.getViewModelStore();
            t.d(viewModelStore, "it.viewModelStore");
            this.f26100u = (I2.k) new ViewModelProvider(viewModelStore, (ViewModelProvider.Factory) new I2.l()).get(I2.k.class);
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        l lVar;
        Context context = getContext();
        if (context == null) {
            lVar = null;
        } else {
            lVar = new l(context, this, f.CmpActivityTheme);
        }
        if (lVar != null) {
            return lVar;
        }
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        t.d(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        return onCreateDialog;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        t.e(layoutInflater, "inflater");
        return layoutInflater.inflate(c.dialog_legal_detail, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        TextView textView;
        String str;
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        super.onViewCreated(view, bundle);
        TextView textView2 = this.f26050b;
        I2.k kVar = null;
        if (textView2 != null) {
            k kVar2 = f26089A;
            if (kVar2 == null) {
                t.w("localSwitchItemType");
                kVar2 = null;
            }
            int ordinal = kVar2.ordinal();
            if (ordinal == 4) {
                I2.k kVar3 = this.f26100u;
                if (kVar3 == null) {
                    t.w("viewModel");
                    kVar3 = null;
                }
                str = kVar3.f18233f.e().f25435d;
            } else if (ordinal == 5) {
                I2.k kVar4 = this.f26100u;
                if (kVar4 == null) {
                    t.w("viewModel");
                    kVar4 = null;
                }
                str = kVar4.f18233f.e().f25437f;
            } else if (ordinal != 6) {
                I2.k kVar5 = this.f26100u;
                if (kVar5 == null) {
                    t.w("viewModel");
                    kVar5 = null;
                }
                str = kVar5.f18233f.e().f25435d;
            } else {
                I2.k kVar6 = this.f26100u;
                if (kVar6 == null) {
                    t.w("viewModel");
                    kVar6 = null;
                }
                str = kVar6.f18233f.e().f25437f;
            }
            textView2.setText(str);
        }
        ImageView imageView = this.f26051c;
        if (imageView != null) {
            imageView.setOnClickListener(new n(this));
            I2.k kVar7 = this.f26100u;
            if (kVar7 == null) {
                t.w("viewModel");
            } else {
                kVar = kVar7;
            }
            imageView.setContentDescription(kVar.f18233f.e().f25446o);
        }
        j(view);
        m4.d dVar = this.f26058j;
        if (dVar != null) {
            Integer num = dVar.f25324i;
            if (num != null) {
                int intValue = num.intValue();
                TextView textView3 = this.f26096q;
                if (textView3 != null) {
                    textView3.setTextColor(intValue);
                }
                TextView textView4 = this.f26095p;
                if (textView4 != null) {
                    textView4.setTextColor(intValue);
                }
                TextView textView5 = this.f26094o;
                if (textView5 != null) {
                    textView5.setTextColor(intValue);
                }
                TextView textView6 = this.f26093n;
                if (textView6 != null) {
                    textView6.setTextColor(intValue);
                }
            }
            Integer num2 = dVar.f25327l;
            if (num2 != null) {
                int intValue2 = num2.intValue();
                TextView textView7 = this.f26097r;
                if (textView7 != null) {
                    textView7.setTextColor(intValue2);
                }
            }
            Integer num3 = dVar.f25322g;
            if (num3 != null) {
                int intValue3 = num3.intValue();
                ConstraintLayout constraintLayout = this.f26092m;
                if (constraintLayout != null) {
                    constraintLayout.setBackgroundColor(intValue3);
                }
            }
        }
        Typeface typeface = this.f26059k;
        if (!(typeface == null || (textView = this.f26096q) == null)) {
            textView.setTypeface(typeface);
        }
        Typeface typeface2 = this.f26060l;
        if (typeface2 != null) {
            TextView textView8 = this.f26097r;
            if (textView8 != null) {
                textView8.setTypeface(typeface2);
            }
            TextView textView9 = this.f26095p;
            if (textView9 != null) {
                textView9.setTypeface(typeface2);
            }
            TextView textView10 = this.f26094o;
            if (textView10 != null) {
                textView10.setTypeface(typeface2);
            }
            TextView textView11 = this.f26093n;
            if (textView11 != null) {
                textView11.setTypeface(typeface2);
            }
        }
    }
}
