package b2;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import java.util.Locale;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

/* renamed from: b2.e  reason: case insensitive filesystem */
public final class C2285e extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    public static final a f20689a = new a((C2633k) null);

    /* renamed from: b2.e$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final C2285e a(Context context, Locale locale) {
            Context context2;
            t.e(context, "newBase");
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT >= 24) {
                configuration.setLocale(locale);
                C2284d.a();
                LocaleList a5 = C2283c.a(new Locale[]{locale});
                LocaleList.setDefault(a5);
                configuration.setLocales(a5);
                context2 = context.createConfigurationContext(configuration);
            } else {
                configuration.setLocale(locale);
                context2 = context.createConfigurationContext(configuration);
            }
            return new C2285e(context2);
        }

        private a() {
        }
    }

    public C2285e(Context context) {
        super(context);
    }
}
