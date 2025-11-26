package M2;

import E1.a;
import E1.c;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import b3.C2308e;
import b3.C2312i;
import c.k;
import k3.p;
import kotlin.jvm.internal.t;
import m4.d;
import o4.n;
import o4.o;
import v4.b;

public final class g extends b {

    /* renamed from: H  reason: collision with root package name */
    public static final String f18627H;

    /* renamed from: A  reason: collision with root package name */
    public TextView f18628A;

    /* renamed from: B  reason: collision with root package name */
    public TextView f18629B;

    /* renamed from: C  reason: collision with root package name */
    public TextView f18630C;

    /* renamed from: D  reason: collision with root package name */
    public TextView f18631D;

    /* renamed from: E  reason: collision with root package name */
    public ImageView f18632E;

    /* renamed from: F  reason: collision with root package name */
    public b f18633F;

    /* renamed from: G  reason: collision with root package name */
    public h f18634G;

    /* renamed from: m  reason: collision with root package name */
    public TextView f18635m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f18636n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f18637o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f18638p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f18639q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f18640r;

    /* renamed from: s  reason: collision with root package name */
    public TextView f18641s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f18642t;

    /* renamed from: u  reason: collision with root package name */
    public TextView f18643u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f18644v;

    /* renamed from: w  reason: collision with root package name */
    public TextView f18645w;

    /* renamed from: x  reason: collision with root package name */
    public TextView f18646x;

    /* renamed from: y  reason: collision with root package name */
    public TextView f18647y;

    /* renamed from: z  reason: collision with root package name */
    public TextView f18648z;

    static {
        String simpleName = g.class.getSimpleName();
        t.d(simpleName, "PartnersDetailFragment::class.java.simpleName");
        f18627H = simpleName;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void h(M2.g r5, android.view.View r6) {
        /*
            java.lang.String r6 = "this$0"
            kotlin.jvm.internal.t.e(r5, r6)
            java.util.UUID r6 = k4.z.f24676a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            M2.h r0 = r5.f18634G
            r1 = 0
            if (r0 != 0) goto L_0x0017
            java.lang.String r0 = "viewModel"
            kotlin.jvm.internal.t.w(r0)
            r0 = r1
        L_0x0017:
            M2.b r2 = r5.f18633F
            java.lang.String r3 = "args"
            if (r2 != 0) goto L_0x0021
            kotlin.jvm.internal.t.w(r3)
            r2 = r1
        L_0x0021:
            c.k r2 = r2.f18619n
            r0.getClass()
            java.lang.String r0 = "switchItemType"
            kotlin.jvm.internal.t.e(r2, r0)
            int r0 = r2.ordinal()
            if (r0 == 0) goto L_0x003b
            r2 = 1
            r4 = 2
            if (r0 == r2) goto L_0x003d
            if (r0 == r4) goto L_0x0038
            goto L_0x003b
        L_0x0038:
            r4 = 10
            goto L_0x003d
        L_0x003b:
            r4 = 8
        L_0x003d:
            java.lang.String r0 = k4.d.a(r4)
            r6.append(r0)
            java.lang.String r0 = "-id:"
            r6.append(r0)
            M2.b r0 = r5.f18633F
            if (r0 != 0) goto L_0x0051
            kotlin.jvm.internal.t.w(r3)
            goto L_0x0052
        L_0x0051:
            r1 = r0
        L_0x0052:
            int r0 = r1.f18618m
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            java.lang.String r0 = "identifier"
            java.lang.String r1 = "collapseElement"
            kotlin.jvm.internal.t.e(r1, r0)
            java.lang.String r0 = "value"
            kotlin.jvm.internal.t.e(r6, r0)
            k4.l r0 = k4.z.f24677b
            r0.i(r1, r6)
            r5.dismiss()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: M2.g.h(M2.g, android.view.View):void");
    }

    public static final void i(g gVar, String str, View view) {
        t.e(gVar, "this$0");
        t.e(str, "$link");
        Context context = gVar.getContext();
        if (context != null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            context.startActivity(intent);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: M2.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: M2.h} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void j(M2.g r5, m4.f r6) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.t.e(r5, r0)
            M2.h r0 = r5.f18634G
            java.lang.String r1 = "viewModel"
            r2 = 0
            if (r0 != 0) goto L_0x0010
            kotlin.jvm.internal.t.w(r1)
            r0 = r2
        L_0x0010:
            java.lang.String r3 = "it"
            kotlin.jvm.internal.t.d(r6, r3)
            r0.a(r6)
            M2.h r6 = r5.f18634G
            if (r6 != 0) goto L_0x0020
            kotlin.jvm.internal.t.w(r1)
            r6 = r2
        L_0x0020:
            java.util.ArrayList r6 = r6.f18652d
            boolean r6 = r6.isEmpty()
            java.lang.String r0 = "args"
            if (r6 != 0) goto L_0x0072
            androidx.fragment.app.FragmentActivity r6 = r5.getActivity()
            if (r6 != 0) goto L_0x0031
            goto L_0x0090
        L_0x0031:
            androidx.fragment.app.FragmentManager r3 = r6.getSupportFragmentManager()
            java.lang.String r4 = K2.g.f18399o
            androidx.fragment.app.Fragment r3 = r3.findFragmentByTag(r4)
            if (r3 != 0) goto L_0x0090
            androidx.fragment.app.FragmentManager r6 = r6.getSupportFragmentManager()
            androidx.fragment.app.FragmentTransaction r6 = r6.beginTransaction()
            K2.c r3 = new K2.c
            M2.h r5 = r5.f18634G
            if (r5 != 0) goto L_0x004f
            kotlin.jvm.internal.t.w(r1)
            goto L_0x0050
        L_0x004f:
            r2 = r5
        L_0x0050:
            java.util.ArrayList r5 = r2.f18652d
            r3.<init>((java.util.List) r5)
            kotlin.jvm.internal.t.e(r3, r0)
            K2.g r5 = new K2.g
            r5.<init>()
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r1 = "partner_disclosure_args"
            r0.putParcelable(r1, r3)
            r5.setArguments(r0)
            androidx.fragment.app.FragmentTransaction r5 = r6.add((androidx.fragment.app.Fragment) r5, (java.lang.String) r4)
            r5.commit()
            return
        L_0x0072:
            android.widget.TextView r6 = r5.f18631D
            if (r6 != 0) goto L_0x0077
            goto L_0x0085
        L_0x0077:
            M2.b r1 = r5.f18633F
            if (r1 != 0) goto L_0x007f
            kotlin.jvm.internal.t.w(r0)
            goto L_0x0080
        L_0x007f:
            r2 = r1
        L_0x0080:
            java.lang.String r0 = r2.f18621p
            r6.setText(r0)
        L_0x0085:
            android.content.Context r6 = r5.getContext()
            if (r6 != 0) goto L_0x008c
            goto L_0x0090
        L_0x008c:
            android.widget.TextView r5 = r5.f18631D
            if (r5 != 0) goto L_0x0091
        L_0x0090:
            return
        L_0x0091:
            int r0 = E1.a.colorRed
            int r6 = androidx.core.content.ContextCompat.getColor(r6, r0)
            r5.setTextColor(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: M2.g.j(M2.g, m4.f):void");
    }

    public static void k(TextView textView, TextView textView2, String str, String str2) {
        if (str.length() > 0 && textView != null) {
            textView.setText(str);
        }
        if (str2.length() <= 0) {
            if (textView != null) {
                textView.setVisibility(8);
            }
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        } else if (textView2 != null) {
            textView2.setText(str2);
        }
    }

    public static final void m(g gVar, View view) {
        TextView textView;
        t.e(gVar, "this$0");
        b bVar = gVar.f18633F;
        b bVar2 = null;
        if (bVar == null) {
            t.w("args");
            bVar = null;
        }
        if (bVar.f18620o.length() > 0) {
            h hVar = gVar.f18634G;
            if (hVar == null) {
                t.w("viewModel");
                hVar = null;
            }
            b bVar3 = gVar.f18633F;
            if (bVar3 == null) {
                t.w("args");
                bVar3 = null;
            }
            String str = bVar3.f18620o;
            hVar.getClass();
            t.e(str, "url");
            o oVar = hVar.f18650b;
            oVar.getClass();
            t.e(str, "url");
            CoroutineLiveDataKt.liveData$default((C2312i) null, 0, (p) new n(oVar, str, (C2308e) null), 3, (Object) null).observe(gVar, new f(gVar));
            return;
        }
        TextView textView2 = gVar.f18631D;
        if (textView2 != null) {
            b bVar4 = gVar.f18633F;
            if (bVar4 == null) {
                t.w("args");
            } else {
                bVar2 = bVar4;
            }
            textView2.setText(bVar2.f18621p);
        }
        Context context = gVar.getContext();
        if (context != null && (textView = gVar.f18631D) != null) {
            textView.setTextColor(ContextCompat.getColor(context, a.colorRed));
        }
    }

    public final void l(String str, String str2) {
        TextView textView;
        if (str.length() > 0 && (textView = this.f18635m) != null) {
            textView.setText(str);
        }
        if (URLUtil.isValidUrl(str2)) {
            TextView textView2 = this.f18635m;
            if (textView2 != null) {
                textView2.setOnClickListener(new e(this, str2));
                return;
            }
            return;
        }
        TextView textView3 = this.f18635m;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
    }

    public final void n(View view) {
        this.f18632E = (ImageView) view.findViewById(E1.b.toolbar_icon);
        this.f18631D = (TextView) view.findViewById(E1.b.tv_disclosures);
        this.f18630C = (TextView) view.findViewById(E1.b.tv_description);
        this.f18629B = (TextView) view.findViewById(E1.b.tv_purposes);
        this.f18628A = (TextView) view.findViewById(E1.b.tv_legitimate_interests);
        this.f18648z = (TextView) view.findViewById(E1.b.tv_special_purposes);
        this.f18647y = (TextView) view.findViewById(E1.b.tv_features);
        this.f18646x = (TextView) view.findViewById(E1.b.tv_special_features);
        this.f18645w = (TextView) view.findViewById(E1.b.tv_purposes_label);
        this.f18644v = (TextView) view.findViewById(E1.b.tv_legitimate_interests_label);
        this.f18643u = (TextView) view.findViewById(E1.b.tv_special_purposes_label);
        this.f18642t = (TextView) view.findViewById(E1.b.tv_features_label);
        this.f18641s = (TextView) view.findViewById(E1.b.tv_special_features_label);
        this.f18640r = (TextView) view.findViewById(E1.b.tv_cookie_max_age);
        this.f18638p = (TextView) view.findViewById(E1.b.tv_uses_non_cookie_access);
        this.f18639q = (TextView) view.findViewById(E1.b.tv_data_retention);
        this.f18637o = (TextView) view.findViewById(E1.b.tv_data_declarations);
        this.f18636n = (TextView) view.findViewById(E1.b.tv_data_declarations_label);
        this.f18635m = (TextView) view.findViewById(E1.b.tv_privacy_policy_link);
        ImageView imageView = this.f18632E;
        if (imageView != null) {
            imageView.setOnClickListener(new c(this));
            h hVar = this.f18634G;
            if (hVar == null) {
                t.w("viewModel");
                hVar = null;
            }
            imageView.setContentDescription(hVar.f18651c.g().f25464o);
        }
        TextView textView = this.f18631D;
        if (textView != null) {
            textView.setOnClickListener(new d(this));
        }
        d dVar = this.f26058j;
        if (dVar != null) {
            Integer num = dVar.f25322g;
            if (num != null) {
                view.setBackgroundColor(num.intValue());
            }
            Integer num2 = dVar.f25324i;
            if (num2 != null) {
                int intValue = num2.intValue();
                TextView textView2 = this.f18630C;
                if (textView2 != null) {
                    textView2.setTextColor(intValue);
                }
                TextView textView3 = this.f18629B;
                if (textView3 != null) {
                    textView3.setTextColor(intValue);
                }
                TextView textView4 = this.f18628A;
                if (textView4 != null) {
                    textView4.setTextColor(intValue);
                }
                TextView textView5 = this.f18648z;
                if (textView5 != null) {
                    textView5.setTextColor(intValue);
                }
                TextView textView6 = this.f18647y;
                if (textView6 != null) {
                    textView6.setTextColor(intValue);
                }
                TextView textView7 = this.f18646x;
                if (textView7 != null) {
                    textView7.setTextColor(intValue);
                }
                TextView textView8 = this.f18645w;
                if (textView8 != null) {
                    textView8.setTextColor(intValue);
                }
                TextView textView9 = this.f18644v;
                if (textView9 != null) {
                    textView9.setTextColor(intValue);
                }
                TextView textView10 = this.f18643u;
                if (textView10 != null) {
                    textView10.setTextColor(intValue);
                }
                TextView textView11 = this.f18642t;
                if (textView11 != null) {
                    textView11.setTextColor(intValue);
                }
                TextView textView12 = this.f18641s;
                if (textView12 != null) {
                    textView12.setTextColor(intValue);
                }
                TextView textView13 = this.f18640r;
                if (textView13 != null) {
                    textView13.setTextColor(intValue);
                }
                TextView textView14 = this.f18638p;
                if (textView14 != null) {
                    textView14.setTextColor(intValue);
                }
                TextView textView15 = this.f18639q;
                if (textView15 != null) {
                    textView15.setTextColor(intValue);
                }
                TextView textView16 = this.f18637o;
                if (textView16 != null) {
                    textView16.setTextColor(intValue);
                }
                TextView textView17 = this.f18636n;
                if (textView17 != null) {
                    textView17.setTextColor(intValue);
                }
            }
            Integer num3 = dVar.f25327l;
            if (num3 != null) {
                int intValue2 = num3.intValue();
                TextView textView18 = this.f18631D;
                if (textView18 != null) {
                    textView18.setTextColor(intValue2);
                }
                TextView textView19 = this.f18635m;
                if (textView19 != null) {
                    textView19.setTextColor(intValue2);
                }
            }
        }
        Typeface typeface = this.f26059k;
        if (typeface != null) {
            TextView textView20 = this.f18645w;
            if (textView20 != null) {
                textView20.setTypeface(typeface);
            }
            TextView textView21 = this.f18644v;
            if (textView21 != null) {
                textView21.setTypeface(typeface);
            }
            TextView textView22 = this.f18643u;
            if (textView22 != null) {
                textView22.setTypeface(typeface);
            }
            TextView textView23 = this.f18642t;
            if (textView23 != null) {
                textView23.setTypeface(typeface);
            }
            TextView textView24 = this.f18641s;
            if (textView24 != null) {
                textView24.setTypeface(typeface);
            }
            TextView textView25 = this.f18636n;
            if (textView25 != null) {
                textView25.setTypeface(typeface);
            }
        }
        Typeface typeface2 = this.f26060l;
        if (typeface2 != null) {
            TextView textView26 = this.f18630C;
            if (textView26 != null) {
                textView26.setTypeface(typeface2);
            }
            TextView textView27 = this.f18629B;
            if (textView27 != null) {
                textView27.setTypeface(typeface2);
            }
            TextView textView28 = this.f18628A;
            if (textView28 != null) {
                textView28.setTypeface(typeface2);
            }
            TextView textView29 = this.f18648z;
            if (textView29 != null) {
                textView29.setTypeface(typeface2);
            }
            TextView textView30 = this.f18647y;
            if (textView30 != null) {
                textView30.setTypeface(typeface2);
            }
            TextView textView31 = this.f18646x;
            if (textView31 != null) {
                textView31.setTypeface(typeface2);
            }
            TextView textView32 = this.f18631D;
            if (textView32 != null) {
                textView32.setTypeface(typeface2);
            }
            TextView textView33 = this.f18635m;
            if (textView33 != null) {
                textView33.setTypeface(typeface2);
            }
            TextView textView34 = this.f18640r;
            if (textView34 != null) {
                textView34.setTypeface(typeface2);
            }
            TextView textView35 = this.f18638p;
            if (textView35 != null) {
                textView35.setTypeface(typeface2);
            }
            TextView textView36 = this.f18639q;
            if (textView36 != null) {
                textView36.setTypeface(typeface2);
            }
            TextView textView37 = this.f18637o;
            if (textView37 != null) {
                textView37.setTypeface(typeface2);
            }
        }
    }

    public final void onCreate(Bundle bundle) {
        b bVar;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            bVar = null;
        } else {
            bVar = (b) V2.b.a(arguments, "partner_detail_args", b.class);
        }
        if (bVar == null) {
            bVar = new b((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, (k) null, (String) null, (String) null, 65535);
        }
        this.f18633F = bVar;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ViewModelStore viewModelStore = activity.getViewModelStore();
            t.d(viewModelStore, "viewModelStore");
            this.f18634G = (h) new ViewModelProvider(viewModelStore, (ViewModelProvider.Factory) new i()).get(h.class);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        t.e(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(c.dialog_partners_detail, viewGroup, false);
        t.d(inflate, "inflater.inflate(R.layou…detail, container, false)");
        return inflate;
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x023c  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0196  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r12, android.os.Bundle r13) {
        /*
            r11 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.t.e(r12, r0)
            super.onViewCreated(r12, r13)
            java.util.UUID r13 = k4.z.f24676a
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            M2.h r0 = r11.f18634G
            java.lang.String r1 = "viewModel"
            r2 = 0
            if (r0 != 0) goto L_0x001a
            kotlin.jvm.internal.t.w(r1)
            r0 = r2
        L_0x001a:
            M2.b r3 = r11.f18633F
            java.lang.String r4 = "args"
            if (r3 != 0) goto L_0x0024
            kotlin.jvm.internal.t.w(r4)
            r3 = r2
        L_0x0024:
            c.k r3 = r3.f18619n
            r0.getClass()
            java.lang.String r0 = "switchItemType"
            kotlin.jvm.internal.t.e(r3, r0)
            int r0 = r3.ordinal()
            r3 = 1
            r5 = 2
            r6 = 8
            if (r0 == 0) goto L_0x0042
            if (r0 == r3) goto L_0x0040
            if (r0 == r5) goto L_0x003d
            goto L_0x0042
        L_0x003d:
            r0 = 10
            goto L_0x0043
        L_0x0040:
            r0 = r5
            goto L_0x0043
        L_0x0042:
            r0 = r6
        L_0x0043:
            java.lang.String r0 = k4.d.a(r0)
            r13.append(r0)
            java.lang.String r0 = "-id:"
            r13.append(r0)
            M2.b r0 = r11.f18633F
            if (r0 != 0) goto L_0x0057
            kotlin.jvm.internal.t.w(r4)
            r0 = r2
        L_0x0057:
            int r0 = r0.f18618m
            r13.append(r0)
            java.lang.String r13 = r13.toString()
            java.lang.String r0 = "identifier"
            java.lang.String r7 = "expandElement"
            kotlin.jvm.internal.t.e(r7, r0)
            java.lang.String r0 = "value"
            kotlin.jvm.internal.t.e(r13, r0)
            k4.l r0 = k4.z.f24677b
            r0.i(r7, r13)
            r11.n(r12)
            M2.b r12 = r11.f18633F
            if (r12 != 0) goto L_0x007c
            kotlin.jvm.internal.t.w(r4)
            r12 = r2
        L_0x007c:
            android.widget.TextView r13 = r11.f26050b
            if (r13 != 0) goto L_0x0081
            goto L_0x0086
        L_0x0081:
            java.lang.String r0 = r12.f18606a
            r13.setText(r0)
        L_0x0086:
            java.lang.String r13 = r12.f18607b
            r0 = 0
            if (r13 != 0) goto L_0x008c
            goto L_0x00a4
        L_0x008c:
            java.lang.String r4 = "null"
            boolean r4 = kotlin.jvm.internal.t.a(r13, r4)
            if (r4 != 0) goto L_0x00a4
            android.widget.TextView r4 = r11.f18630C
            if (r4 != 0) goto L_0x0099
            goto L_0x009c
        L_0x0099:
            r4.setText(r13)
        L_0x009c:
            android.widget.TextView r13 = r11.f18630C
            if (r13 != 0) goto L_0x00a1
            goto L_0x00a4
        L_0x00a1:
            r13.setVisibility(r0)
        L_0x00a4:
            java.lang.String r13 = r12.f18615j
            int r13 = r13.length()
            if (r13 != 0) goto L_0x00b5
            android.widget.TextView r13 = r11.f18640r
            if (r13 != 0) goto L_0x00b1
            goto L_0x00eb
        L_0x00b1:
            r13.setVisibility(r6)
            goto L_0x00eb
        L_0x00b5:
            android.widget.TextView r13 = r11.f18640r
            if (r13 != 0) goto L_0x00ba
            goto L_0x00bd
        L_0x00ba:
            r13.setVisibility(r0)
        L_0x00bd:
            android.widget.TextView r13 = r11.f18640r
            if (r13 != 0) goto L_0x00c2
            goto L_0x00eb
        L_0x00c2:
            android.content.Context r4 = r11.getContext()
            if (r4 != 0) goto L_0x00ca
            r4 = r2
            goto L_0x00e8
        L_0x00ca:
            int r7 = E1.e.subtitle_format
            M2.h r8 = r11.f18634G
            if (r8 != 0) goto L_0x00d4
            kotlin.jvm.internal.t.w(r1)
            r8 = r2
        L_0x00d4:
            o4.k r8 = r8.f18651c
            m4.m r8 = r8.g()
            java.lang.String r8 = r8.f25457h
            java.lang.String r9 = r12.f18615j
            java.lang.Object[] r10 = new java.lang.Object[r5]
            r10[r0] = r8
            r10[r3] = r9
            java.lang.String r4 = r4.getString(r7, r10)
        L_0x00e8:
            r13.setText(r4)
        L_0x00eb:
            java.lang.String r13 = r12.f18616k
            int r13 = r13.length()
            if (r13 != 0) goto L_0x00fc
            android.widget.TextView r13 = r11.f18638p
            if (r13 != 0) goto L_0x00f8
            goto L_0x0132
        L_0x00f8:
            r13.setVisibility(r6)
            goto L_0x0132
        L_0x00fc:
            android.widget.TextView r13 = r11.f18638p
            if (r13 != 0) goto L_0x0101
            goto L_0x0104
        L_0x0101:
            r13.setVisibility(r0)
        L_0x0104:
            android.widget.TextView r13 = r11.f18638p
            if (r13 != 0) goto L_0x0109
            goto L_0x0132
        L_0x0109:
            android.content.Context r4 = r11.getContext()
            if (r4 != 0) goto L_0x0111
            r4 = r2
            goto L_0x012f
        L_0x0111:
            int r7 = E1.e.subtitle_format
            M2.h r8 = r11.f18634G
            if (r8 != 0) goto L_0x011b
            kotlin.jvm.internal.t.w(r1)
            r8 = r2
        L_0x011b:
            o4.k r8 = r8.f18651c
            m4.m r8 = r8.g()
            java.lang.String r8 = r8.f25461l
            java.lang.String r9 = r12.f18616k
            java.lang.Object[] r10 = new java.lang.Object[r5]
            r10[r0] = r8
            r10[r3] = r9
            java.lang.String r4 = r4.getString(r7, r10)
        L_0x012f:
            r13.setText(r4)
        L_0x0132:
            java.lang.String r13 = r12.f18617l
            int r13 = r13.length()
            if (r13 != 0) goto L_0x0143
            android.widget.TextView r13 = r11.f18639q
            if (r13 != 0) goto L_0x013f
            goto L_0x0179
        L_0x013f:
            r13.setVisibility(r6)
            goto L_0x0179
        L_0x0143:
            android.widget.TextView r13 = r11.f18639q
            if (r13 != 0) goto L_0x0148
            goto L_0x014b
        L_0x0148:
            r13.setVisibility(r0)
        L_0x014b:
            android.widget.TextView r13 = r11.f18639q
            if (r13 != 0) goto L_0x0150
            goto L_0x0179
        L_0x0150:
            android.content.Context r4 = r11.getContext()
            if (r4 != 0) goto L_0x0158
            r3 = r2
            goto L_0x0176
        L_0x0158:
            int r7 = E1.e.subtitle_format
            M2.h r8 = r11.f18634G
            if (r8 != 0) goto L_0x0162
            kotlin.jvm.internal.t.w(r1)
            r8 = r2
        L_0x0162:
            o4.k r8 = r8.f18651c
            m4.m r8 = r8.g()
            java.lang.String r8 = r8.f25465p
            java.lang.String r9 = r12.f18617l
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r0] = r8
            r5[r3] = r9
            java.lang.String r3 = r4.getString(r7, r5)
        L_0x0176:
            r13.setText(r3)
        L_0x0179:
            android.widget.TextView r13 = r11.f18631D
            if (r13 != 0) goto L_0x017e
            goto L_0x0191
        L_0x017e:
            M2.h r3 = r11.f18634G
            if (r3 != 0) goto L_0x0186
            kotlin.jvm.internal.t.w(r1)
            r3 = r2
        L_0x0186:
            o4.k r3 = r3.f18651c
            m4.m r3 = r3.g()
            java.lang.String r3 = r3.f25460k
            r13.setText(r3)
        L_0x0191:
            android.widget.TextView r13 = r11.f18631D
            if (r13 != 0) goto L_0x0196
            goto L_0x01a2
        L_0x0196:
            java.lang.String r3 = r12.f18620o
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x019f
            r6 = r0
        L_0x019f:
            r13.setVisibility(r6)
        L_0x01a2:
            android.widget.TextView r13 = r11.f18645w
            android.widget.TextView r0 = r11.f18629B
            M2.h r3 = r11.f18634G
            if (r3 != 0) goto L_0x01ae
            kotlin.jvm.internal.t.w(r1)
            r3 = r2
        L_0x01ae:
            o4.k r3 = r3.f18651c
            m4.m r3 = r3.g()
            java.lang.String r3 = r3.f25450a
            java.lang.String r4 = r12.f18608c
            k(r13, r0, r3, r4)
            android.widget.TextView r13 = r11.f18644v
            android.widget.TextView r0 = r11.f18628A
            M2.h r3 = r11.f18634G
            if (r3 != 0) goto L_0x01c7
            kotlin.jvm.internal.t.w(r1)
            r3 = r2
        L_0x01c7:
            o4.k r3 = r3.f18651c
            m4.m r3 = r3.g()
            java.lang.String r3 = r3.f25451b
            java.lang.String r4 = r12.f18609d
            k(r13, r0, r3, r4)
            android.widget.TextView r13 = r11.f18643u
            android.widget.TextView r0 = r11.f18648z
            M2.h r3 = r11.f18634G
            if (r3 != 0) goto L_0x01e0
            kotlin.jvm.internal.t.w(r1)
            r3 = r2
        L_0x01e0:
            o4.k r3 = r3.f18651c
            m4.m r3 = r3.g()
            java.lang.String r3 = r3.f25452c
            java.lang.String r4 = r12.f18610e
            k(r13, r0, r3, r4)
            android.widget.TextView r13 = r11.f18642t
            android.widget.TextView r0 = r11.f18647y
            M2.h r3 = r11.f18634G
            if (r3 != 0) goto L_0x01f9
            kotlin.jvm.internal.t.w(r1)
            r3 = r2
        L_0x01f9:
            o4.k r3 = r3.f18651c
            m4.m r3 = r3.g()
            java.lang.String r3 = r3.f25453d
            java.lang.String r4 = r12.f18611f
            k(r13, r0, r3, r4)
            android.widget.TextView r13 = r11.f18641s
            android.widget.TextView r0 = r11.f18646x
            M2.h r3 = r11.f18634G
            if (r3 != 0) goto L_0x0212
            kotlin.jvm.internal.t.w(r1)
            r3 = r2
        L_0x0212:
            o4.k r3 = r3.f18651c
            m4.m r3 = r3.g()
            java.lang.String r3 = r3.f25454e
            java.lang.String r4 = r12.f18612g
            k(r13, r0, r3, r4)
            android.widget.TextView r13 = r11.f18636n
            android.widget.TextView r0 = r11.f18637o
            M2.h r3 = r11.f18634G
            if (r3 != 0) goto L_0x022b
            kotlin.jvm.internal.t.w(r1)
            r3 = r2
        L_0x022b:
            o4.k r3 = r3.f18651c
            m4.m r3 = r3.g()
            java.lang.String r3 = r3.f25455f
            java.lang.String r4 = r12.f18613h
            k(r13, r0, r3, r4)
            M2.h r13 = r11.f18634G
            if (r13 != 0) goto L_0x0240
            kotlin.jvm.internal.t.w(r1)
            goto L_0x0241
        L_0x0240:
            r2 = r13
        L_0x0241:
            o4.k r13 = r2.f18651c
            m4.m r13 = r13.g()
            java.lang.String r13 = r13.f25456g
            java.lang.String r12 = r12.f18614i
            r11.l(r13, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: M2.g.onViewCreated(android.view.View, android.os.Bundle):void");
    }
}
