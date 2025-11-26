package z2;

import android.content.Context;
import android.view.ViewGroup;
import com.uptodown.R;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

/* renamed from: z2.p  reason: case insensitive filesystem */
public abstract class C2957p {

    /* renamed from: a  reason: collision with root package name */
    public static final a f26550a = new a((C2633k) null);

    /* renamed from: z2.p$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private final boolean a(Context context) {
            if (694 > com.uptodown.activities.preferences.a.f15150a.o(context)) {
                return true;
            }
            return false;
        }

        public final boolean b(Context context, ViewGroup viewGroup) {
            t.e(context, "context");
            t.e(viewGroup, "container");
            if (!a(context)) {
                return false;
            }
            com.uptodown.activities.preferences.a.f15150a.O0(context, 694);
            String string = context.getString(R.string.last_changelog);
            t.d(string, "getString(...)");
            if (string.length() <= 0) {
                return false;
            }
            C2959s.f26555a.d(context, viewGroup, string);
            return true;
        }

        private a() {
        }
    }
}
