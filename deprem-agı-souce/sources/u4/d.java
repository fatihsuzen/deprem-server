package u4;

import E1.c;
import E1.e;
import T3.i;
import T3.k;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
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
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.cmpapi.status.DisplayStatus;
import com.inmobi.cmp.model.Regulations;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.t;
import m.g;
import m.l;
import r4.a;
import v4.b;

public final class d extends b {

    /* renamed from: w  reason: collision with root package name */
    public static final String f26017w;

    /* renamed from: m  reason: collision with root package name */
    public LinearLayout f26018m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f26019n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f26020o;

    /* renamed from: p  reason: collision with root package name */
    public CheckBox f26021p;

    /* renamed from: q  reason: collision with root package name */
    public Button f26022q;

    /* renamed from: r  reason: collision with root package name */
    public CardView f26023r;

    /* renamed from: s  reason: collision with root package name */
    public TextView f26024s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f26025t;

    /* renamed from: u  reason: collision with root package name */
    public NestedScrollView f26026u;

    /* renamed from: v  reason: collision with root package name */
    public f f26027v;

    static {
        String simpleName = d.class.getSimpleName();
        t.d(simpleName, "CCPAPrivacyFragment::class.java.simpleName");
        f26017w = simpleName;
    }

    public static final void i(d dVar, String str, View view) {
        t.e(dVar, "this$0");
        t.e(str, "$link");
        dVar.getClass();
        try {
            if (str.length() > 0) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                dVar.startActivity(intent);
            }
        } catch (ActivityNotFoundException unused) {
            Log.e(f26017w, "No a valid URL has been passed");
        }
    }

    public static final void j(d dVar, boolean z4, View view) {
        t.e(dVar, "this$0");
        f fVar = dVar.f26027v;
        if (fVar == null) {
            t.w("viewModel");
            fVar = null;
        }
        F1.b bVar = new F1.b(DisplayStatus.DISMISSED, "User dismissed US regulations screen", Regulations.CCPA, z4);
        fVar.getClass();
        t.e(bVar, "displayInfo");
        ChoiceCmpCallback choiceCmpCallback = fVar.f26032b;
        if (choiceCmpCallback != null) {
            choiceCmpCallback.onCMPUIStatusChanged(bVar);
        }
        dVar.dismiss();
        FragmentActivity activity = dVar.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX WARNING: type inference failed for: r11v2, types: [androidx.fragment.app.Fragment] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void k(u4.d r10, boolean r11, android.view.View r12) {
        /*
            java.lang.String r12 = "this$0"
            kotlin.jvm.internal.t.e(r10, r12)
            u4.f r12 = r10.f26027v
            r0 = 0
            if (r12 != 0) goto L_0x0010
            java.lang.String r12 = "viewModel"
            kotlin.jvm.internal.t.w(r12)
            r12 = r0
        L_0x0010:
            android.widget.CheckBox r1 = r10.f26021p
            if (r1 != 0) goto L_0x0016
            r1 = 0
            goto L_0x001a
        L_0x0016:
            boolean r1 = r1.isChecked()
        L_0x001a:
            r4.a r2 = r12.f26031a
            r3 = 1
            if (r1 != r3) goto L_0x0022
            T3.k r3 = T3.k.YES
            goto L_0x0024
        L_0x0022:
            T3.k r3 = T3.k.NO
        L_0x0024:
            T3.i r4 = r12.f26034d
            if (r4 != 0) goto L_0x0029
            goto L_0x002d
        L_0x0029:
            T3.c r4 = r4.f19281b
            if (r4 != 0) goto L_0x002f
        L_0x002d:
            r4 = r0
            goto L_0x0031
        L_0x002f:
            java.lang.String r4 = r4.f19239d
        L_0x0031:
            java.lang.String r5 = "Y"
            boolean r4 = kotlin.jvm.internal.t.a(r4, r5)
            if (r4 == 0) goto L_0x003c
            T3.k r4 = T3.k.YES
            goto L_0x003e
        L_0x003c:
            T3.k r4 = T3.k.NO
        L_0x003e:
            T3.k r5 = T3.k.YES
            r4.a.d(r2, r5, r3, r4)
            T3.i r2 = s4.c.j()
            T3.c r2 = r2.f19281b
            java.lang.String r3 = r2.f19230U
            if (r3 != 0) goto L_0x004e
            goto L_0x0055
        L_0x004e:
            r4.a r4 = r12.f26031a
            r4.b r5 = r4.b.CCPA_CONFIG_THEME_UUID
            r4.i(r5, r3)
        L_0x0055:
            r4.a r3 = r12.f26031a
            r4.b r4 = r4.b.CCPA_CONFIG_LANGUAGE
            java.lang.String r2 = r2.f19250o
            r3.i(r4, r2)
            r4.a r2 = r12.f26031a
            r4.b r3 = r4.b.CCPA_CONFIG_GBC_APPLICABLE
            boolean r4 = m.l.f960a
            r2.j(r3, r4)
            com.inmobi.cmp.ChoiceCmpCallback r2 = r12.f26032b
            if (r2 != 0) goto L_0x006c
            goto L_0x0077
        L_0x006c:
            r4.a r3 = r12.f26031a
            r4.b r4 = r4.b.PRIVACY_STRING
            java.lang.String r3 = r3.k(r4)
            r2.onCCPAConsentGiven(r3)
        L_0x0077:
            w3.s0 r4 = w3.C2896s0.f26313a
            w3.I r5 = w3.C2865c0.b()
            u4.e r7 = new u4.e
            r7.<init>(r12, r1, r0)
            r8 = 2
            r9 = 0
            r6 = 0
            w3.C2908y0 unused = w3.C2876i.d(r4, r5, r6, r7, r8, r9)
            if (r11 == 0) goto L_0x00a1
            androidx.fragment.app.FragmentManager r11 = r10.getChildFragmentManager()
            java.lang.String r12 = m.g.f949g
            androidx.fragment.app.Fragment r11 = r11.findFragmentByTag(r12)
            boolean r12 = r11 instanceof m.g
            if (r12 == 0) goto L_0x009b
            r0 = r11
            m.g r0 = (m.g) r0
        L_0x009b:
            if (r0 != 0) goto L_0x009e
            goto L_0x00a1
        L_0x009e:
            r0.f()
        L_0x00a1:
            r10.dismiss()
            androidx.fragment.app.FragmentActivity r10 = r10.getActivity()
            if (r10 != 0) goto L_0x00ab
            return
        L_0x00ab:
            r10.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u4.d.k(u4.d, boolean, android.view.View):void");
    }

    public final void h(TextView textView, String str, String str2, boolean z4) {
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
            textView.setOnClickListener(new c(this, str));
        }
    }

    public final void onCancel(DialogInterface dialogInterface) {
        t.e(dialogInterface, "dialog");
        super.onCancel(dialogInterface);
        f fVar = this.f26027v;
        if (fVar == null) {
            t.w("viewModel");
            fVar = null;
        }
        F1.b bVar = new F1.b(DisplayStatus.DISMISSED, "User dismissed US regulations screen", Regulations.CCPA, l.f960a);
        fVar.getClass();
        t.e(bVar, "displayInfo");
        ChoiceCmpCallback choiceCmpCallback = fVar.f26032b;
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
            this.f26027v = (f) new ViewModelProvider(viewModelStore, (ViewModelProvider.Factory) new g()).get(f.class);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        t.e(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(c.dialog_ccpa_privacy, viewGroup, false);
        t.d(inflate, "inflater.inflate(R.layou…rivacy, container, false)");
        return inflate;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        String str;
        String str2;
        k kVar;
        String str3;
        k kVar2;
        T3.c cVar;
        i iVar;
        T3.c cVar2;
        String str4;
        T3.c cVar3;
        String str5;
        i iVar2;
        T3.c cVar4;
        String str6;
        T3.c cVar5;
        i iVar3;
        T3.c cVar6;
        String str7;
        T3.c cVar7;
        T3.c cVar8;
        TextView textView;
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        super.onViewCreated(view, bundle);
        boolean z4 = l.f960a;
        this.f26018m = (LinearLayout) view.findViewById(E1.b.container_ccpa_links);
        this.f26019n = (TextView) view.findViewById(E1.b.tv_privacy_policy_link);
        this.f26020o = (TextView) view.findViewById(E1.b.tv_delete_data_link);
        this.f26021p = (CheckBox) view.findViewById(E1.b.chx_ccpa_consent);
        this.f26022q = (Button) view.findViewById(E1.b.btn_ccpa_consent);
        this.f26023r = (CardView) view.findViewById(E1.b.bottom_container);
        this.f26024s = (TextView) view.findViewById(E1.b.tv_ccpa_content);
        this.f26025t = (TextView) view.findViewById(E1.b.tv_access_data_link);
        this.f26026u = (NestedScrollView) view.findViewById(E1.b.sv_container);
        int i5 = E1.b.gbc_fragment_container;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(i5);
        int i6 = 8;
        f fVar = null;
        if (l.f960a) {
            getChildFragmentManager().beginTransaction().add(i5, (Fragment) new g(), g.f949g).addToBackStack((String) null).commit();
            f fVar2 = this.f26027v;
            if (fVar2 == null) {
                t.w("viewModel");
                fVar2 = null;
            }
            fVar2.getClass();
            a aVar = fVar2.f26031a;
            t.e(aVar, "storage");
            aVar.j(r4.b.GBC_SHOWN, true);
        } else if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        TextView textView2 = this.f26050b;
        if (textView2 != null) {
            f fVar3 = this.f26027v;
            if (fVar3 == null) {
                t.w("viewModel");
                fVar3 = null;
            }
            String str8 = fVar3.f26033c.f25308a;
            if (str8.length() == 0) {
                str8 = getString(e.ccpa_privacy_title);
                t.d(str8, "getString(R.string.ccpa_privacy_title)");
            }
            textView2.setText(str8);
        }
        f fVar4 = this.f26027v;
        if (fVar4 == null) {
            t.w("viewModel");
            fVar4 = null;
        }
        if (fVar4.b().length() > 0) {
            TextView textView3 = this.f26024s;
            if (textView3 != null) {
                f fVar5 = this.f26027v;
                if (fVar5 == null) {
                    t.w("viewModel");
                    fVar5 = null;
                }
                textView3.setText(Q3.a.a(fVar5.b()));
            }
        } else {
            TextView textView4 = this.f26024s;
            if (textView4 != null) {
                textView4.setText(e.ccpa_content_message);
            }
        }
        TextView textView5 = this.f26024s;
        String str9 = "";
        if (textView5 != null) {
            f fVar6 = this.f26027v;
            if (fVar6 == null) {
                t.w("viewModel");
                fVar6 = null;
            }
            fVar6.getClass();
            textView5.append(l.f960a ? fVar6.f26036f.f18954b.f18949c : str9);
        }
        TextView textView6 = this.f26024s;
        if (textView6 != null) {
            textView6.setMovementMethod(LinkMovementMethod.getInstance());
        }
        Context context = getContext();
        if (!(context == null || (textView = this.f26024s) == null)) {
            textView.setLinkTextColor(ContextCompat.getColor(context, E1.a.colorBlueAccent));
        }
        LinearLayout linearLayout = this.f26018m;
        boolean z5 = false;
        if (linearLayout != null) {
            f fVar7 = this.f26027v;
            if (fVar7 == null) {
                t.w("viewModel");
                fVar7 = null;
            }
            i iVar4 = fVar7.f26034d;
            boolean z6 = (iVar4 == null || (cVar8 = iVar4.f19281b) == null || !cVar8.f19212C) ? false : true;
            t.e(linearLayout, "<this>");
            if (!z6) {
                i6 = 0;
            }
            linearLayout.setVisibility(i6);
        }
        TextView textView7 = this.f26020o;
        f fVar8 = this.f26027v;
        if (fVar8 == null) {
            t.w("viewModel");
            fVar8 = null;
        }
        i iVar5 = fVar8.f26034d;
        if (iVar5 == null || (cVar7 = iVar5.f19281b) == null || (str = cVar7.f19213D) == null) {
            str = str9;
        }
        f fVar9 = this.f26027v;
        if (fVar9 == null) {
            t.w("viewModel");
            fVar9 = null;
        }
        String c5 = fVar9.c();
        f fVar10 = this.f26027v;
        if (fVar10 == null) {
            t.w("viewModel");
            fVar10 = null;
        }
        h(textView7, str, c5, (fVar10.c().length() <= 0 || (iVar3 = fVar10.f26034d) == null || (cVar6 = iVar3.f19281b) == null || (str7 = cVar6.f19213D) == null || str7.length() <= 0) ? false : true);
        TextView textView8 = this.f26025t;
        f fVar11 = this.f26027v;
        if (fVar11 == null) {
            t.w("viewModel");
            fVar11 = null;
        }
        i iVar6 = fVar11.f26034d;
        if (iVar6 == null || (cVar5 = iVar6.f19281b) == null || (str2 = cVar5.f19214E) == null) {
            str2 = str9;
        }
        f fVar12 = this.f26027v;
        if (fVar12 == null) {
            t.w("viewModel");
            fVar12 = null;
        }
        String a5 = fVar12.a();
        f fVar13 = this.f26027v;
        if (fVar13 == null) {
            t.w("viewModel");
            fVar13 = null;
        }
        h(textView8, str2, a5, (fVar13.a().length() <= 0 || (iVar2 = fVar13.f26034d) == null || (cVar4 = iVar2.f19281b) == null || (str6 = cVar4.f19214E) == null || str6.length() <= 0) ? false : true);
        TextView textView9 = this.f26019n;
        f fVar14 = this.f26027v;
        if (fVar14 == null) {
            t.w("viewModel");
            fVar14 = null;
        }
        i iVar7 = fVar14.f26034d;
        if (!(iVar7 == null || (cVar3 = iVar7.f19281b) == null || (str5 = cVar3.f19215F) == null)) {
            str9 = str5;
        }
        f fVar15 = this.f26027v;
        if (fVar15 == null) {
            t.w("viewModel");
            fVar15 = null;
        }
        String d5 = fVar15.d();
        f fVar16 = this.f26027v;
        if (fVar16 == null) {
            t.w("viewModel");
            fVar16 = null;
        }
        if (!(fVar16.d().length() <= 0 || (iVar = fVar16.f26034d) == null || (cVar2 = iVar.f19281b) == null || (str4 = cVar2.f19215F) == null || str4.length() <= 0)) {
            z5 = true;
        }
        h(textView9, str9, d5, z5);
        ImageView imageView = this.f26051c;
        if (imageView != null) {
            imageView.setOnClickListener(new a(this, z4));
            f fVar17 = this.f26027v;
            if (fVar17 == null) {
                t.w("viewModel");
                fVar17 = null;
            }
            imageView.setContentDescription(fVar17.f26033c.f25313f);
        }
        CheckBox checkBox = this.f26021p;
        if (checkBox != null) {
            f fVar18 = this.f26027v;
            if (fVar18 == null) {
                t.w("viewModel");
                fVar18 = null;
            }
            checkBox.setChecked(t.a(fVar18.f26031a.b(2, 3), "Y"));
        }
        Button button = this.f26022q;
        if (button != null) {
            button.setOnClickListener(new b(this, z4));
        }
        m4.d dVar = this.f26058j;
        if (dVar != null) {
            Integer num = dVar.f25322g;
            if (num != null) {
                int intValue = num.intValue();
                view.setBackgroundColor(intValue);
                CardView cardView = this.f26023r;
                if (cardView != null) {
                    cardView.setCardBackgroundColor(intValue);
                }
            }
            Integer num2 = dVar.f25316a;
            if (num2 != null) {
                int intValue2 = num2.intValue();
                NestedScrollView nestedScrollView = this.f26026u;
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
                TextView textView10 = this.f26024s;
                if (textView10 != null) {
                    textView10.setTextColor(intValue3);
                }
                CheckBox checkBox2 = this.f26021p;
                if (checkBox2 != null) {
                    checkBox2.setTextColor(intValue3);
                }
                CheckBox checkBox3 = this.f26021p;
                if (checkBox3 != null) {
                    checkBox3.setButtonTintList(ColorStateList.valueOf(intValue3));
                }
            }
            Integer num4 = dVar.f25327l;
            if (num4 != null) {
                int intValue4 = num4.intValue();
                TextView textView11 = this.f26024s;
                if (textView11 != null) {
                    textView11.setLinkTextColor(intValue4);
                }
                TextView textView12 = this.f26025t;
                if (textView12 != null) {
                    textView12.setTextColor(intValue4);
                }
                TextView textView13 = this.f26020o;
                if (textView13 != null) {
                    textView13.setTextColor(intValue4);
                }
                TextView textView14 = this.f26019n;
                if (textView14 != null) {
                    textView14.setTextColor(intValue4);
                }
            }
            Integer num5 = dVar.f25330o;
            if (num5 != null) {
                int intValue5 = num5.intValue();
                Button button2 = this.f26022q;
                if (button2 != null) {
                    button2.setBackgroundColor(intValue5);
                }
            }
            Integer num6 = dVar.f25328m;
            if (num6 != null) {
                int intValue6 = num6.intValue();
                Button button3 = this.f26022q;
                if (button3 != null) {
                    button3.setTextColor(intValue6);
                }
            }
        }
        Typeface typeface = this.f26060l;
        if (typeface != null) {
            TextView textView15 = this.f26024s;
            if (textView15 != null) {
                textView15.setTypeface(typeface);
            }
            TextView textView16 = this.f26025t;
            if (textView16 != null) {
                textView16.setTypeface(typeface);
            }
            TextView textView17 = this.f26020o;
            if (textView17 != null) {
                textView17.setTypeface(typeface);
            }
            TextView textView18 = this.f26019n;
            if (textView18 != null) {
                textView18.setTypeface(typeface);
            }
            CheckBox checkBox4 = this.f26021p;
            if (checkBox4 != null) {
                checkBox4.setTypeface(typeface);
            }
            Button button4 = this.f26022q;
            if (button4 != null) {
                button4.setTypeface(typeface);
            }
        }
        f fVar19 = this.f26027v;
        if (fVar19 == null) {
            t.w("viewModel");
            fVar19 = null;
        }
        a aVar2 = fVar19.f26031a;
        if (t.a(aVar2.b(2, 3), "Y")) {
            kVar = k.YES;
        } else {
            kVar = k.NO;
        }
        i iVar8 = fVar19.f26034d;
        if (iVar8 == null || (cVar = iVar8.f19281b) == null) {
            str3 = null;
        } else {
            str3 = cVar.f19239d;
        }
        if (t.a(str3, "Y")) {
            kVar2 = k.YES;
        } else {
            kVar2 = k.NO;
        }
        a.d(aVar2, k.YES, kVar, kVar2);
        f fVar20 = this.f26027v;
        if (fVar20 == null) {
            t.w("viewModel");
        } else {
            fVar = fVar20;
        }
        fVar.f26031a.j(r4.b.CCPA_SHOWN, true);
    }
}
