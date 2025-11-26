package G2;

import E1.c;
import E1.e;
import Q3.a;
import R3.j;
import T3.i;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.cmpapi.status.DisplayStatus;
import com.inmobi.cmp.model.Regulations;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.t;
import m.l;
import m4.d;
import u4.g;
import v4.b;

public final class f extends b {

    /* renamed from: x  reason: collision with root package name */
    public static final String f18144x;

    /* renamed from: m  reason: collision with root package name */
    public LinearLayout f18145m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f18146n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f18147o;

    /* renamed from: p  reason: collision with root package name */
    public Button f18148p;

    /* renamed from: q  reason: collision with root package name */
    public Button f18149q;

    /* renamed from: r  reason: collision with root package name */
    public CardView f18150r;

    /* renamed from: s  reason: collision with root package name */
    public TextView f18151s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f18152t;

    /* renamed from: u  reason: collision with root package name */
    public NestedScrollView f18153u;

    /* renamed from: v  reason: collision with root package name */
    public u4.f f18154v;

    /* renamed from: w  reason: collision with root package name */
    public p f18155w;

    static {
        String simpleName = f.class.getSimpleName();
        t.d(simpleName, "MSPAPrivacyFragment::class.java.simpleName");
        f18144x = simpleName;
    }

    public static final void h(f fVar, View view) {
        t.e(fVar, "this$0");
        p pVar = fVar.f18155w;
        if (pVar == null) {
            t.w("mspaViewModel");
            pVar = null;
        }
        F1.b bVar = new F1.b(DisplayStatus.DISMISSED, "User dismissed US regulations screen", Regulations.MSPA, l.f960a);
        pVar.getClass();
        t.e(bVar, "displayInfo");
        ChoiceCmpCallback choiceCmpCallback = pVar.f18181c;
        if (choiceCmpCallback != null) {
            choiceCmpCallback.onCMPUIStatusChanged(bVar);
        }
        fVar.dismiss();
        FragmentActivity activity = fVar.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static final void i(f fVar, String str) {
        t.e(fVar, "this$0");
        fVar.dismiss();
        FragmentActivity activity = fVar.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static final void j(f fVar, String str, View view) {
        t.e(fVar, "this$0");
        t.e(str, "$link");
        fVar.getClass();
        try {
            if (str.length() > 0) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                fVar.startActivity(intent);
            }
        } catch (ActivityNotFoundException unused) {
            Log.e(f18144x, "No a valid URL has been passed");
        }
    }

    public static final void l(f fVar, View view) {
        t.e(fVar, "this$0");
        p pVar = fVar.f18155w;
        if (pVar == null) {
            t.w("mspaViewModel");
            pVar = null;
        }
        pVar.a().observe(fVar, new e(fVar));
    }

    public static final void m(f fVar, View view) {
        FragmentManager supportFragmentManager;
        FragmentTransaction beginTransaction;
        FragmentTransaction add;
        t.e(fVar, "this$0");
        FragmentActivity activity = fVar.getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null && (beginTransaction = supportFragmentManager.beginTransaction()) != null && (add = beginTransaction.add((Fragment) new l(), "d0.b")) != null) {
            add.commit();
        }
    }

    public final void k(TextView textView, String str, String str2, boolean z4) {
        int i5;
        if (textView != null) {
            textView.setText(str2);
            t.e(textView, "<this>");
            if (z4) {
                i5 = 0;
            } else {
                i5 = 8;
            }
            textView.setVisibility(i5);
            textView.setOnClickListener(new d(this, str));
        }
    }

    public final void onCancel(DialogInterface dialogInterface) {
        t.e(dialogInterface, "dialog");
        super.onCancel(dialogInterface);
        p pVar = this.f18155w;
        if (pVar == null) {
            t.w("mspaViewModel");
            pVar = null;
        }
        F1.b bVar = new F1.b(DisplayStatus.DISMISSED, "User dismissed US regulations screen", Regulations.MSPA, l.f960a);
        pVar.getClass();
        t.e(bVar, "displayInfo");
        ChoiceCmpCallback choiceCmpCallback = pVar.f18181c;
        if (choiceCmpCallback != null) {
            choiceCmpCallback.onCMPUIStatusChanged(bVar);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getActivity() != null) {
            ViewModelStore viewModelStore = getViewModelStore();
            t.d(viewModelStore, "viewModelStore");
            this.f18154v = (u4.f) new ViewModelProvider(viewModelStore, (ViewModelProvider.Factory) new g()).get(u4.f.class);
            ViewModelStore viewModelStore2 = getViewModelStore();
            t.d(viewModelStore2, "viewModelStore");
            this.f18155w = (p) new ViewModelProvider(viewModelStore2, (ViewModelProvider.Factory) new q()).get(p.class);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        t.e(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(c.dialog_mspa_privacy, viewGroup, false);
        t.d(inflate, "inflater.inflate(R.layou…rivacy, container, false)");
        return inflate;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        String str;
        String str2;
        i iVar;
        T3.c cVar;
        String str3;
        T3.c cVar2;
        String str4;
        i iVar2;
        T3.c cVar3;
        String str5;
        T3.c cVar4;
        i iVar3;
        T3.c cVar5;
        String str6;
        T3.c cVar6;
        T3.c cVar7;
        TextView textView;
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        super.onViewCreated(view, bundle);
        this.f18145m = (LinearLayout) view.findViewById(E1.b.container_ccpa_links);
        this.f18146n = (TextView) view.findViewById(E1.b.tv_privacy_policy_link);
        this.f18147o = (TextView) view.findViewById(E1.b.tv_delete_data_link);
        this.f18152t = (TextView) view.findViewById(E1.b.tv_access_data_link);
        this.f18150r = (CardView) view.findViewById(E1.b.bottom_container);
        this.f18151s = (TextView) view.findViewById(E1.b.tv_ccpa_content);
        this.f18153u = (NestedScrollView) view.findViewById(E1.b.sv_container);
        this.f18148p = (Button) view.findViewById(E1.b.btn_preferences);
        this.f18149q = (Button) view.findViewById(E1.b.btn_confirm);
        p pVar = this.f18155w;
        p pVar2 = null;
        if (pVar == null) {
            t.w("mspaViewModel");
            pVar = null;
        }
        j.d(pVar.f18179a);
        TextView textView2 = this.f26050b;
        if (textView2 != null) {
            u4.f fVar = this.f18154v;
            if (fVar == null) {
                t.w("ccpaViewModel");
                fVar = null;
            }
            String str7 = fVar.f26033c.f25308a;
            if (str7.length() == 0) {
                str7 = getString(e.ccpa_privacy_title);
                t.d(str7, "getString(R.string.ccpa_privacy_title)");
            }
            textView2.setText(str7);
        }
        u4.f fVar2 = this.f18154v;
        if (fVar2 == null) {
            t.w("ccpaViewModel");
            fVar2 = null;
        }
        if (fVar2.b().length() > 0) {
            TextView textView3 = this.f18151s;
            if (textView3 != null) {
                u4.f fVar3 = this.f18154v;
                if (fVar3 == null) {
                    t.w("ccpaViewModel");
                    fVar3 = null;
                }
                textView3.setText(a.a(fVar3.b()));
            }
        } else {
            TextView textView4 = this.f18151s;
            if (textView4 != null) {
                textView4.setText(e.ccpa_content_message);
            }
        }
        TextView textView5 = this.f18151s;
        String str8 = "";
        if (textView5 != null) {
            u4.f fVar4 = this.f18154v;
            if (fVar4 == null) {
                t.w("ccpaViewModel");
                fVar4 = null;
            }
            fVar4.getClass();
            textView5.append(l.f960a ? fVar4.f26036f.f18954b.f18949c : str8);
        }
        TextView textView6 = this.f18151s;
        if (textView6 != null) {
            textView6.setMovementMethod(LinkMovementMethod.getInstance());
        }
        Context context = getContext();
        if (!(context == null || (textView = this.f18151s) == null)) {
            textView.setLinkTextColor(ContextCompat.getColor(context, E1.a.colorBlueAccent));
        }
        LinearLayout linearLayout = this.f18145m;
        boolean z4 = false;
        if (linearLayout != null) {
            u4.f fVar5 = this.f18154v;
            if (fVar5 == null) {
                t.w("ccpaViewModel");
                fVar5 = null;
            }
            i iVar4 = fVar5.f26034d;
            boolean z5 = (iVar4 == null || (cVar7 = iVar4.f19281b) == null || !cVar7.f19212C) ? false : true;
            t.e(linearLayout, "<this>");
            linearLayout.setVisibility(!z5 ? 0 : 8);
        }
        TextView textView7 = this.f18147o;
        u4.f fVar6 = this.f18154v;
        if (fVar6 == null) {
            t.w("ccpaViewModel");
            fVar6 = null;
        }
        i iVar5 = fVar6.f26034d;
        if (iVar5 == null || (cVar6 = iVar5.f19281b) == null || (str = cVar6.f19213D) == null) {
            str = str8;
        }
        u4.f fVar7 = this.f18154v;
        if (fVar7 == null) {
            t.w("ccpaViewModel");
            fVar7 = null;
        }
        String c5 = fVar7.c();
        u4.f fVar8 = this.f18154v;
        if (fVar8 == null) {
            t.w("ccpaViewModel");
            fVar8 = null;
        }
        k(textView7, str, c5, (fVar8.c().length() <= 0 || (iVar3 = fVar8.f26034d) == null || (cVar5 = iVar3.f19281b) == null || (str6 = cVar5.f19213D) == null || str6.length() <= 0) ? false : true);
        TextView textView8 = this.f18152t;
        u4.f fVar9 = this.f18154v;
        if (fVar9 == null) {
            t.w("ccpaViewModel");
            fVar9 = null;
        }
        i iVar6 = fVar9.f26034d;
        if (iVar6 == null || (cVar4 = iVar6.f19281b) == null || (str2 = cVar4.f19214E) == null) {
            str2 = str8;
        }
        u4.f fVar10 = this.f18154v;
        if (fVar10 == null) {
            t.w("ccpaViewModel");
            fVar10 = null;
        }
        String a5 = fVar10.a();
        u4.f fVar11 = this.f18154v;
        if (fVar11 == null) {
            t.w("ccpaViewModel");
            fVar11 = null;
        }
        k(textView8, str2, a5, (fVar11.a().length() <= 0 || (iVar2 = fVar11.f26034d) == null || (cVar3 = iVar2.f19281b) == null || (str5 = cVar3.f19214E) == null || str5.length() <= 0) ? false : true);
        TextView textView9 = this.f18146n;
        u4.f fVar12 = this.f18154v;
        if (fVar12 == null) {
            t.w("ccpaViewModel");
            fVar12 = null;
        }
        i iVar7 = fVar12.f26034d;
        if (!(iVar7 == null || (cVar2 = iVar7.f19281b) == null || (str4 = cVar2.f19215F) == null)) {
            str8 = str4;
        }
        u4.f fVar13 = this.f18154v;
        if (fVar13 == null) {
            t.w("ccpaViewModel");
            fVar13 = null;
        }
        String d5 = fVar13.d();
        u4.f fVar14 = this.f18154v;
        if (fVar14 == null) {
            t.w("ccpaViewModel");
            fVar14 = null;
        }
        if (!(fVar14.d().length() <= 0 || (iVar = fVar14.f26034d) == null || (cVar = iVar.f19281b) == null || (str3 = cVar.f19215F) == null || str3.length() <= 0)) {
            z4 = true;
        }
        k(textView9, str8, d5, z4);
        ImageView imageView = this.f26051c;
        if (imageView != null) {
            imageView.setOnClickListener(new a(this));
            u4.f fVar15 = this.f18154v;
            if (fVar15 == null) {
                t.w("ccpaViewModel");
                fVar15 = null;
            }
            imageView.setContentDescription(fVar15.f26033c.f25313f);
        }
        Button button = this.f18149q;
        if (button != null) {
            button.setOnClickListener(new b(this));
        }
        Button button2 = this.f18148p;
        if (button2 != null) {
            button2.setOnClickListener(new c(this));
        }
        d dVar = this.f26058j;
        if (dVar != null) {
            Integer num = dVar.f25322g;
            if (num != null) {
                int intValue = num.intValue();
                view.setBackgroundColor(intValue);
                CardView cardView = this.f18150r;
                if (cardView != null) {
                    cardView.setCardBackgroundColor(intValue);
                }
            }
            Integer num2 = dVar.f25316a;
            if (num2 != null) {
                int intValue2 = num2.intValue();
                NestedScrollView nestedScrollView = this.f18153u;
                if (nestedScrollView != null) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setCornerRadius(2.0f);
                    gradientDrawable.setStroke(4, intValue2);
                    nestedScrollView.setBackground(gradientDrawable);
                }
            }
            Integer num3 = dVar.f25324i;
            if (num3 != null) {
                int intValue3 = num3.intValue();
                TextView textView10 = this.f18151s;
                if (textView10 != null) {
                    textView10.setTextColor(intValue3);
                }
            }
            Integer num4 = dVar.f25327l;
            if (num4 != null) {
                int intValue4 = num4.intValue();
                TextView textView11 = this.f18151s;
                if (textView11 != null) {
                    textView11.setLinkTextColor(intValue4);
                }
                TextView textView12 = this.f18152t;
                if (textView12 != null) {
                    textView12.setTextColor(intValue4);
                }
                TextView textView13 = this.f18147o;
                if (textView13 != null) {
                    textView13.setTextColor(intValue4);
                }
                TextView textView14 = this.f18146n;
                if (textView14 != null) {
                    textView14.setTextColor(intValue4);
                }
            }
            Integer num5 = dVar.f25330o;
            if (num5 != null) {
                int intValue5 = num5.intValue();
                Button button3 = this.f18148p;
                if (button3 != null) {
                    button3.setBackgroundColor(intValue5);
                }
                Button button4 = this.f18149q;
                if (button4 != null) {
                    button4.setBackgroundColor(intValue5);
                }
            }
            Integer num6 = dVar.f25328m;
            if (num6 != null) {
                int intValue6 = num6.intValue();
                Button button5 = this.f18148p;
                if (button5 != null) {
                    button5.setTextColor(intValue6);
                }
                Button button6 = this.f18149q;
                if (button6 != null) {
                    button6.setTextColor(intValue6);
                }
            }
        }
        Typeface typeface = this.f26060l;
        if (typeface != null) {
            TextView textView15 = this.f18151s;
            if (textView15 != null) {
                textView15.setTypeface(typeface);
            }
            TextView textView16 = this.f18152t;
            if (textView16 != null) {
                textView16.setTypeface(typeface);
            }
            TextView textView17 = this.f18147o;
            if (textView17 != null) {
                textView17.setTypeface(typeface);
            }
            TextView textView18 = this.f18146n;
            if (textView18 != null) {
                textView18.setTypeface(typeface);
            }
            Button button7 = this.f18149q;
            if (button7 != null) {
                button7.setTypeface(typeface);
            }
            Button button8 = this.f18148p;
            if (button8 != null) {
                button8.setTypeface(typeface);
            }
        }
        p pVar3 = this.f18155w;
        if (pVar3 == null) {
            t.w("mspaViewModel");
            pVar3 = null;
        }
        if (!j.f19019d) {
            pVar3.c();
        } else {
            pVar3.getClass();
        }
        j.f19019d = true;
        s4.c.l().j(r4.b.MSPA_SHOWN, true);
        p pVar4 = this.f18155w;
        if (pVar4 == null) {
            t.w("mspaViewModel");
        } else {
            pVar2 = pVar4;
        }
        pVar2.getClass();
        if (l.f960a) {
            r4.a l5 = s4.c.l();
            t.e(l5, "storage");
            l5.j(r4.b.GBC_SHOWN, true);
        }
    }
}
