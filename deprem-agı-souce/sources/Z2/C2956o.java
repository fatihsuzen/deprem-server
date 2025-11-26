package z2;

import S1.k;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.uptodown.R;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

/* renamed from: z2.o  reason: case insensitive filesystem */
public abstract class C2956o {

    /* renamed from: a  reason: collision with root package name */
    public static final a f26549a = new a((C2633k) null);

    /* renamed from: z2.o$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        /* access modifiers changed from: private */
        public static final void c(AlertDialog alertDialog, View view) {
            alertDialog.dismiss();
        }

        public final void b(Context context, String str) {
            t.e(context, "context");
            t.e(str, "changelogText");
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_changelog, (ViewGroup) null);
            k.a aVar = k.f32g;
            ((TextView) inflate.findViewById(R.id.tv_title_cd)).setTypeface(aVar.x());
            TextView textView = (TextView) inflate.findViewById(R.id.tv_changelog_cd);
            textView.setTypeface(aVar.x());
            TextView textView2 = (TextView) inflate.findViewById(R.id.tv_accept_cd);
            textView2.setTypeface(aVar.w());
            textView.setText(str);
            AlertDialog create = builder.setView(inflate).create();
            Window window = create.getWindow();
            if (window != null) {
                window.setBackgroundDrawableResource(17170445);
            }
            textView2.setOnClickListener(new C2955n(create));
            create.show();
        }

        private a() {
        }
    }
}
