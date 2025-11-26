package z2;

import S1.k;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.uptodown.R;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

/* renamed from: z2.s  reason: case insensitive filesystem */
public abstract class C2959s {

    /* renamed from: a  reason: collision with root package name */
    public static final a f26555a = new a((C2633k) null);

    /* renamed from: z2.s$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private final void c(View view) {
            ViewGroup viewGroup;
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }

        /* access modifiers changed from: private */
        public static final void e(Context context, String str, View view, View view2) {
            C2956o.f26549a.b(context, str);
            a aVar = C2959s.f26555a;
            t.b(view);
            aVar.c(view);
        }

        /* access modifiers changed from: private */
        public static final void f(View view, View view2) {
            a aVar = C2959s.f26555a;
            t.b(view);
            aVar.c(view);
        }

        public final View d(Context context, ViewGroup viewGroup, String str) {
            t.e(context, "context");
            t.e(viewGroup, "container");
            t.e(str, "changelogText");
            View inflate = LayoutInflater.from(context).inflate(R.layout.changelog_notification_view, viewGroup, false);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_subtitle_cd);
            TextView textView2 = (TextView) inflate.findViewById(R.id.tv_version_cd);
            View findViewById = inflate.findViewById(R.id.iv_close_cd);
            if (textView != null) {
                textView.setTypeface(k.f32g.x());
            }
            if (textView2 != null) {
                textView2.setTypeface(k.f32g.w());
            }
            if (textView2 != null) {
                textView2.setText(context.getString(R.string.version_changelog_notification, new Object[]{"6.94"}));
            }
            View findViewById2 = inflate.findViewById(R.id.rl_content_area);
            if (findViewById2 != null) {
                findViewById2.setOnClickListener(new C2958q(context, str, inflate));
            }
            if (findViewById != null) {
                findViewById.setOnClickListener(new r(inflate));
            }
            viewGroup.addView(inflate);
            t.b(inflate);
            return inflate;
        }

        private a() {
        }
    }
}
