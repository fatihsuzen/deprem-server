package j4;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import g4.b;
import java.util.Locale;
import p4.a;

public class d {

    /* renamed from: d  reason: collision with root package name */
    private static final String f24539d = b.i(d.class);

    /* renamed from: a  reason: collision with root package name */
    private final Context f24540a;

    /* renamed from: b  reason: collision with root package name */
    private final e f24541b;

    /* renamed from: c  reason: collision with root package name */
    private final a f24542c;

    public d(Context context, e eVar, a aVar) {
        this.f24540a = context;
        this.f24541b = eVar;
        this.f24542c = aVar;
    }

    public int[] a() {
        try {
            Display defaultDisplay = ((WindowManager) this.f24540a.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            int i5 = displayMetrics.widthPixels;
            int i6 = displayMetrics.heightPixels;
            if (i5 == -1 || i6 == -1) {
                DisplayMetrics displayMetrics2 = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics2);
                i5 = displayMetrics2.widthPixels;
                i6 = displayMetrics2.heightPixels;
            }
            return new int[]{i5, i6};
        } catch (NullPointerException e5) {
            a.b(f24539d).e(e5, "Window service was not available from this context", new Object[0]);
            return null;
        }
    }

    public String b() {
        String a5 = this.f24541b.a();
        if (a5 != null && !a5.startsWith("Apache-HttpClient/UNAVAILABLE (java")) {
            return a5;
        }
        String b5 = this.f24541b.b();
        if (b5 == null) {
            b5 = "0.0.0";
        }
        String c5 = this.f24542c.c();
        String b6 = this.f24542c.b();
        String a6 = this.f24542c.a();
        return String.format(Locale.US, "Dalvik/%s (Linux; U; Android %s; %s Build/%s)", new Object[]{b5, c5, b6, a6});
    }

    public String c() {
        return Locale.getDefault().getLanguage();
    }
}
