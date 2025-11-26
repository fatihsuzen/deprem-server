package m;

import E1.c;
import E1.e;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.RecyclerView;
import c.b;
import c.h;
import c.i;
import c.k;
import c.l;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.Vector;
import com.inmobi.cmp.core.model.gbc.GoogleBasicConsents;
import com.inmobi.cmp.core.model.portalconfig.GBCConsentValue;
import com.mbridge.msdk.MBridgeConstans;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.t;
import m4.d;
import r4.a;

public final class g extends Fragment implements b {

    /* renamed from: g  reason: collision with root package name */
    public static final String f949g;

    /* renamed from: a  reason: collision with root package name */
    public TextView f950a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f951b;

    /* renamed from: c  reason: collision with root package name */
    public e f952c;

    /* renamed from: d  reason: collision with root package name */
    public d f953d;

    /* renamed from: e  reason: collision with root package name */
    public Typeface f954e;

    /* renamed from: f  reason: collision with root package name */
    public Typeface f955f;

    static {
        String simpleName = g.class.getSimpleName();
        t.d(simpleName, "GBCPurposesFragment::class.java.simpleName");
        f949g = simpleName;
    }

    public final void d(i iVar) {
        t.e(iVar, "item");
    }

    public final void e(i iVar) {
        t.e(iVar, "item");
    }

    public final void f() {
        e eVar = this.f952c;
        RecyclerView.Adapter adapter = null;
        if (eVar == null) {
            t.w("viewModel");
            eVar = null;
        }
        RecyclerView recyclerView = this.f951b;
        if (recyclerView != null) {
            adapter = recyclerView.getAdapter();
        }
        if (adapter != null) {
            List<i> list = ((h) adapter).f884a;
            eVar.getClass();
            t.e(list, "gbcList");
            for (i iVar : list) {
                if (t.a(iVar.f895b, Boolean.TRUE)) {
                    boolean z4 = l.f960a;
                    int i5 = iVar.f894a.f18881a;
                    t.e(GBCConsentValue.GRANTED, "value");
                    l.f961b.set(i5);
                } else {
                    boolean z5 = l.f960a;
                    int i6 = iVar.f894a.f18881a;
                    GBCConsentValue gBCConsentValue = GBCConsentValue.DENIED;
                    t.e(gBCConsentValue, "value");
                    if (gBCConsentValue == GBCConsentValue.GRANTED) {
                        l.f961b.set(i6);
                    } else {
                        l.f961b.unset(i6);
                    }
                }
            }
            a aVar = eVar.f945a;
            r4.b bVar = r4.b.GBC_CONSENT_STRING;
            boolean z6 = l.f960a;
            Vector l5 = aVar.l(bVar);
            Vector vector = l.f961b;
            t.e(vector, "newVector");
            if (l5 != null) {
                l5.forEach(new i(vector));
            }
            aVar.h(bVar, vector);
            ChoiceCmpCallback choiceCmpCallback = eVar.f946b;
            if (choiceCmpCallback != null) {
                choiceCmpCallback.onGoogleBasicConsentChange(new GoogleBasicConsents(e.a(list, "adStorage"), e.a(list, "adUserData"), e.a(list, "adPersonalization"), e.a(list, "analyticsStorage")));
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.inmobi.cmp.presentation.components.switchlist.SwitchAdapter");
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getActivity() != null) {
            ViewModelStore viewModelStore = getViewModelStore();
            t.d(viewModelStore, "viewModelStore");
            this.f952c = (e) new ViewModelProvider(viewModelStore, (ViewModelProvider.Factory) new f()).get(e.class);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        t.e(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(c.gbc_purpose_container, viewGroup, false);
        t.d(inflate, "inflater.inflate(R.layou…tainer, container, false)");
        return inflate;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        Typeface typeface;
        Typeface typeface2;
        TextView textView;
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        Integer num5;
        Object obj;
        String str;
        boolean z4;
        View view2 = view;
        t.e(view2, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        super.onViewCreated(view, bundle);
        this.f950a = (TextView) view2.findViewById(E1.b.tv_google_consents);
        this.f951b = (RecyclerView) view2.findViewById(E1.b.rv_google_purposes_list);
        m4.c cVar = s4.c.f25856d;
        e eVar = null;
        if (cVar == null) {
            typeface = null;
        } else {
            typeface = cVar.f25314a;
        }
        this.f954e = typeface;
        if (cVar == null) {
            typeface2 = null;
        } else {
            typeface2 = cVar.f25315b;
        }
        this.f955f = typeface2;
        this.f953d = s4.c.f25857e;
        TextView textView2 = this.f950a;
        if (textView2 != null) {
            e eVar2 = this.f952c;
            if (eVar2 == null) {
                t.w("viewModel");
                eVar2 = null;
            }
            String str2 = eVar2.f947c.f18954b.f18948b;
            if (str2.length() == 0) {
                str2 = getString(e.google_consents);
                t.d(str2, "getString(R.string.google_consents)");
            }
            textView2.setText(str2);
        }
        RecyclerView recyclerView = this.f951b;
        if (recyclerView != null) {
            e eVar3 = this.f952c;
            if (eVar3 == null) {
                t.w("viewModel");
                eVar3 = null;
            }
            eVar3.getClass();
            ArrayList arrayList = new ArrayList();
            Vector l5 = eVar3.f945a.l(r4.b.GBC_CONSENT_STRING);
            for (R2.b bVar : eVar3.f947c.f18955c) {
                Integer num6 = bVar.f18951a;
                if (num6 != null) {
                    int intValue = num6.intValue();
                    Iterator it = eVar3.f948d.f19281b.f19232W.f19269c.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (((T3.e) obj).f19265a == intValue) {
                            break;
                        }
                    }
                    T3.e eVar4 = (T3.e) obj;
                    if (eVar4 != null) {
                        R2.a aVar = bVar.f18952b;
                        if (aVar == null) {
                            str = null;
                        } else {
                            str = aVar.f18947a;
                        }
                        if (str == null) {
                            str = "";
                        }
                        P3.e eVar5 = new P3.e(intValue, str);
                        if (l5 != null && l5.contains(eVar4.f19265a)) {
                            Boolean bool = l5.get(eVar4.f19265a);
                            if (bool != null) {
                                z4 = bool.booleanValue();
                                arrayList.add(new i(eVar5, Boolean.valueOf(z4), (l) null, k.GOOGLE_BASIC_CONSENT_PURPOSE, (String) null, (Integer) null, 116));
                            }
                        } else if (eVar4.f19266b == GBCConsentValue.GRANTED) {
                            z4 = true;
                            arrayList.add(new i(eVar5, Boolean.valueOf(z4), (l) null, k.GOOGLE_BASIC_CONSENT_PURPOSE, (String) null, (Integer) null, 116));
                        }
                        z4 = false;
                        arrayList.add(new i(eVar5, Boolean.valueOf(z4), (l) null, k.GOOGLE_BASIC_CONSENT_PURPOSE, (String) null, (Integer) null, 116));
                    }
                }
            }
            d dVar = this.f953d;
            if (dVar == null) {
                num2 = null;
            } else {
                num2 = dVar.f25324i;
            }
            if (dVar == null) {
                num3 = null;
            } else {
                num3 = dVar.f25320e;
            }
            if (dVar == null) {
                num4 = null;
            } else {
                num4 = dVar.f25321f;
            }
            if (dVar == null) {
                num5 = null;
            } else {
                num5 = dVar.f25316a;
            }
            recyclerView.setAdapter(new h((List) arrayList, (b) this, (String) null, num2, num3, num4, num5, (Typeface) null, this.f955f, 268));
        }
        d dVar2 = this.f953d;
        if (dVar2 != null) {
            Integer num7 = dVar2.f25322g;
            if (num7 != null) {
                view2.setBackgroundColor(num7.intValue());
            }
            Integer num8 = dVar2.f25324i;
            if (num8 != null) {
                int intValue2 = num8.intValue();
                TextView textView3 = this.f950a;
                if (textView3 != null) {
                    textView3.setTextColor(intValue2);
                }
            }
        }
        d dVar3 = this.f953d;
        if (!(dVar3 == null || (num = dVar3.f25316a) == null)) {
            int intValue3 = num.intValue();
            View findViewById = view2.findViewById(E1.b.gbc_purpose_divider);
            if (findViewById != null) {
                findViewById.setBackgroundTintList(ColorStateList.valueOf(intValue3));
            }
        }
        Typeface typeface3 = this.f954e;
        if (!(typeface3 == null || (textView = this.f950a) == null)) {
            textView.setTypeface(typeface3);
        }
        e eVar6 = this.f952c;
        if (eVar6 == null) {
            t.w("viewModel");
        } else {
            eVar = eVar6;
        }
        eVar.f945a.j(r4.b.GBC_SHOWN, true);
    }
}
