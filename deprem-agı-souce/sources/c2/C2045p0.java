package C2;

import S1.k;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import k2.C2614y;
import kotlin.jvm.internal.t;
import l2.C2642B;
import t3.s;

/* renamed from: C2.p0  reason: case insensitive filesystem */
public final class C2045p0 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final C2614y f17854a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f17855b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f17856c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f17857d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f17858e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f17859f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f17860g;

    /* renamed from: h  reason: collision with root package name */
    private Context f17861h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2045p0(View view, C2614y yVar) {
        super(view);
        t.e(view, "itemView");
        this.f17854a = yVar;
        View findViewById = view.findViewById(R.id.tv_title);
        t.d(findViewById, "findViewById(...)");
        this.f17855b = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_msg);
        t.d(findViewById2, "findViewById(...)");
        this.f17856c = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.tv_action_01);
        t.d(findViewById3, "findViewById(...)");
        this.f17857d = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_action_02);
        t.d(findViewById4, "findViewById(...)");
        this.f17858e = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.tv_date);
        t.d(findViewById5, "findViewById(...)");
        this.f17859f = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.iv_delete_notification);
        t.d(findViewById6, "findViewById(...)");
        this.f17860g = (ImageView) findViewById6;
        Context context = view.getContext();
        t.d(context, "getContext(...)");
        this.f17861h = context;
        this.f17857d.setOnClickListener(new C2036m0(this));
        this.f17858e.setOnClickListener(new C2039n0(this));
        this.f17860g.setOnClickListener(new C2042o0(this));
        TextView textView = this.f17855b;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.x());
        this.f17856c.setTypeface(aVar.x());
        this.f17859f.setTypeface(aVar.x());
        this.f17857d.setTypeface(aVar.w());
        this.f17858e.setTypeface(aVar.w());
    }

    /* access modifiers changed from: private */
    public static final void d(C2045p0 p0Var, View view) {
        int bindingAdapterPosition;
        if (p0Var.f17854a != null && (bindingAdapterPosition = p0Var.getBindingAdapterPosition()) != -1) {
            p0Var.f17854a.c(bindingAdapterPosition);
        }
    }

    /* access modifiers changed from: private */
    public static final void e(C2045p0 p0Var, View view) {
        int bindingAdapterPosition;
        if (p0Var.f17854a != null && (bindingAdapterPosition = p0Var.getBindingAdapterPosition()) != -1) {
            p0Var.f17854a.a(bindingAdapterPosition);
        }
    }

    /* access modifiers changed from: private */
    public static final void f(C2045p0 p0Var, View view) {
        int bindingAdapterPosition;
        if (p0Var.f17854a != null && (bindingAdapterPosition = p0Var.getBindingAdapterPosition()) != -1) {
            p0Var.f17854a.b(bindingAdapterPosition);
        }
    }

    private final String g(String str) {
        switch (str.hashCode()) {
            case -1569440520:
                if (!str.equals("positive_apps")) {
                    return "";
                }
                String string = this.f17861h.getString(R.string.title_positive_apps);
                t.d(string, "getString(...)");
                return string;
            case -1335458389:
                if (!str.equals("delete")) {
                    return "";
                }
                String string2 = this.f17861h.getString(R.string.option_button_delete);
                t.d(string2, "getString(...)");
                return string2;
            case -504325460:
                if (!str.equals("open_app")) {
                    return "";
                }
                String string3 = this.f17861h.getString(R.string.open);
                t.d(string3, "getString(...)");
                return string3;
            case -234430262:
                if (!str.equals("updates")) {
                    return "";
                }
                String string4 = this.f17861h.getString(R.string.updates);
                t.d(string4, "getString(...)");
                return string4;
            case 212443764:
                str.equals("no_action");
                return "";
            case 1085191854:
                if (!str.equals("update_uptodown")) {
                    return "";
                }
                String string5 = this.f17861h.getString(R.string.action_update);
                t.d(string5, "getString(...)");
                return string5;
            case 1117687366:
                if (!str.equals("preregister")) {
                    return "";
                }
                String string6 = this.f17861h.getString(R.string.action_app_details_settings);
                t.d(string6, "getString(...)");
                return string6;
            case 1312704747:
                if (!str.equals("downloads")) {
                    return "";
                }
                String string7 = this.f17861h.getString(R.string.downloads_title);
                t.d(string7, "getString(...)");
                return string7;
            case 1957569947:
                if (!str.equals("install")) {
                    return "";
                }
                String string8 = this.f17861h.getString(R.string.option_button_install);
                t.d(string8, "getString(...)");
                return string8;
            default:
                return "";
        }
    }

    public final void h(C2642B b5) {
        t.e(b5, "notificationRegistry");
        this.f17855b.setText(b5.f());
        this.f17856c.setText(b5.d());
        String e5 = b5.e();
        t.b(e5);
        Date date = new Date(Long.parseLong(e5));
        this.f17859f.setText(DateFormat.getDateTimeInstance().format(Long.valueOf(date.getTime())));
        String a5 = b5.a();
        this.f17857d.setVisibility(8);
        this.f17858e.setVisibility(8);
        if (a5 != null && !s.V(a5, "no_action", false, 2, (Object) null)) {
            List G02 = s.G0(a5, new String[]{";"}, false, 0, 6, (Object) null);
            int size = G02.size();
            if (size == 1) {
                this.f17857d.setText(g((String) G02.get(0)));
                this.f17857d.setVisibility(0);
            } else if (size == 2) {
                this.f17857d.setText(g((String) G02.get(0)));
                this.f17858e.setText(g((String) G02.get(1)));
                this.f17857d.setVisibility(0);
                this.f17858e.setVisibility(0);
            }
        }
    }
}
