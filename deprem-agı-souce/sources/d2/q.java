package D2;

import S1.k;
import W2.J;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import h2.H;
import h2.a1;
import java.util.HashMap;
import java.util.Locale;
import k3.p;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class q {

    /* renamed from: e  reason: collision with root package name */
    public static final a f18031e = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f18032a;

    /* renamed from: b  reason: collision with root package name */
    private final View f18033b;

    /* renamed from: c  reason: collision with root package name */
    private final HashMap f18034c;

    /* renamed from: d  reason: collision with root package name */
    private final p f18035d;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public final class b extends RecyclerView.Adapter {

        /* renamed from: a  reason: collision with root package name */
        private final HashMap f18036a;

        /* renamed from: b  reason: collision with root package name */
        private final p f18037b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ q f18038c;

        public final class a extends RecyclerView.ViewHolder {

            /* renamed from: a  reason: collision with root package name */
            private final H f18039a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ b f18040b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(b bVar, H h5) {
                super(h5.getRoot());
                t.e(h5, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
                this.f18040b = bVar;
                this.f18039a = h5;
            }

            public final H a() {
                return this.f18039a;
            }
        }

        public b(q qVar, HashMap hashMap, p pVar) {
            t.e(hashMap, "options");
            t.e(pVar, "onOptionClick");
            this.f18038c = qVar;
            this.f18036a = hashMap;
            this.f18037b = pVar;
        }

        /* access modifiers changed from: private */
        public static final void c(b bVar, int i5, String str, View view) {
            bVar.f18037b.invoke(Integer.valueOf(i5), str);
        }

        /* renamed from: b */
        public void onBindViewHolder(a aVar, int i5) {
            String str;
            t.e(aVar, "holder");
            String str2 = (String) this.f18036a.get(Integer.valueOf(i5));
            if (str2 != null && str2.length() != 0) {
                TextView textView = aVar.a().f22380b;
                if (str2.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    String valueOf = String.valueOf(str2.charAt(0));
                    t.c(valueOf, "null cannot be cast to non-null type java.lang.String");
                    String upperCase = valueOf.toUpperCase(Locale.ROOT);
                    t.d(upperCase, "toUpperCase(...)");
                    sb.append(upperCase);
                    String substring = str2.substring(1);
                    t.d(substring, "substring(...)");
                    sb.append(substring);
                    str = sb.toString();
                } else {
                    str = str2;
                }
                textView.setText(str);
                aVar.a().f22380b.setTypeface(k.f32g.x());
                aVar.itemView.setOnClickListener(new r(this, i5, str2));
            }
        }

        /* renamed from: d */
        public a onCreateViewHolder(ViewGroup viewGroup, int i5) {
            t.e(viewGroup, "parent");
            H c5 = H.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            t.d(c5, "inflate(...)");
            return new a(this, c5);
        }

        public int getItemCount() {
            return this.f18036a.size();
        }
    }

    public q(Context context, View view, HashMap hashMap, p pVar) {
        t.e(context, "context");
        t.e(view, "anchor");
        t.e(hashMap, "options");
        t.e(pVar, "onOptionSelected");
        this.f18032a = context;
        this.f18033b = view;
        this.f18034c = hashMap;
        this.f18035d = pVar;
    }

    /* access modifiers changed from: private */
    public static final J d(q qVar, PopupWindow popupWindow, int i5, String str) {
        t.e(str, "selectedOption");
        qVar.f18035d.invoke(Integer.valueOf(i5), str);
        popupWindow.dismiss();
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final void e(q qVar, LinearLayout linearLayout) {
        new n(qVar.f18032a).i(linearLayout, R.anim.hide_dropdown_menu);
    }

    public final void c() {
        LinearLayout b5 = a1.c(LayoutInflater.from(this.f18032a), (ViewGroup) null, false).getRoot();
        t.d(b5, "getRoot(...)");
        PopupWindow popupWindow = new PopupWindow(b5, this.f18033b.getWidth(), -2, true);
        new n(this.f18032a).h(b5, R.anim.show_dropdown_menu);
        View findViewById = b5.findViewById(R.id.recycler_view);
        t.d(findViewById, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        b bVar = new b(this, this.f18034c, new o(this, popupWindow));
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f18032a));
        recyclerView.setAdapter(bVar);
        popupWindow.setElevation(10.0f);
        popupWindow.showAsDropDown(this.f18033b);
        popupWindow.setOnDismissListener(new p(this, b5));
    }
}
