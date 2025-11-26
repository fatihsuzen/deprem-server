package z2;

import S1.k;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import android.widget.ImageView;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.CustomWebView;
import com.uptodown.activities.GdprPrivacySettings;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.preferences.a;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.t;
import l2.C2668q;
import l2.T;
import t3.s;

/* renamed from: z2.v  reason: case insensitive filesystem */
public final class C2962v {

    /* renamed from: a  reason: collision with root package name */
    public static final a f26557a = new a((C2633k) null);

    /* renamed from: z2.v$a */
    public static final class a {

        /* renamed from: z2.v$a$a  reason: collision with other inner class name */
        public static final class C0266a extends CharacterStyle implements UpdateAppearance {

            /* renamed from: a  reason: collision with root package name */
            private final Shader f26558a;

            /* renamed from: b  reason: collision with root package name */
            private final float f26559b;

            public C0266a(Shader shader, float f5) {
                t.e(shader, "shader");
                this.f26558a = shader;
                this.f26559b = f5;
            }

            public void updateDrawState(TextPaint textPaint) {
                t.e(textPaint, "tp");
                textPaint.setShader(this.f26558a);
                textPaint.setTextSize(this.f26559b);
                textPaint.setColor(textPaint.linkColor);
            }
        }

        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final void a(ImageView imageView) {
            t.e(imageView, "<this>");
            imageView.setForeground((Drawable) null);
            imageView.setPadding(0, 0, 0, 0);
        }

        public final void b(ImageView imageView) {
            t.e(imageView, "<this>");
            int dimension = (int) imageView.getContext().getResources().getDimension(R.dimen.border_radius_xs);
            imageView.setForeground(ContextCompat.getDrawable(imageView.getContext(), R.drawable.shape_stroke_review_avatar_turbo));
            imageView.setPadding(dimension, dimension, dimension, dimension);
        }

        public final void c(ImageView imageView) {
            t.e(imageView, "<this>");
            int dimension = (int) imageView.getContext().getResources().getDimension(R.dimen.border_radius_xs);
            imageView.setForeground(ContextCompat.getDrawable(imageView.getContext(), R.drawable.shape_stroke_review_small_avatar_turbo));
            imageView.setPadding(dimension, dimension, dimension, dimension);
        }

        private a() {
        }
    }

    /* access modifiers changed from: private */
    public static final void f(Activity activity, DialogInterface dialogInterface, int i5) {
        dialogInterface.dismiss();
        Class<GdprPrivacySettings> cls = GdprPrivacySettings.class;
        if (activity instanceof AppDetailActivity) {
            ((AppDetailActivity) activity).s3().launch(new Intent(activity, cls));
        } else if (activity instanceof MainActivity) {
            ((MainActivity) activity).N5().launch(new Intent(activity, cls));
        } else {
            activity.startActivity(new Intent(activity, cls));
        }
    }

    /* access modifiers changed from: private */
    public static final void g(DialogInterface dialogInterface, int i5) {
        t.e(dialogInterface, "dialogInterface");
        dialogInterface.dismiss();
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ba A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String q(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = ","
            if (r6 != 0) goto L_0x0005
            return r0
        L_0x0005:
            int r1 = r6.hashCode()
            java.lang.String r2 = " "
            java.lang.String r3 = ""
            java.lang.String r4 = "."
            switch(r1) {
                case 3121: goto L_0x00b2;
                case 3179: goto L_0x00a8;
                case 3201: goto L_0x009e;
                case 3241: goto L_0x009b;
                case 3246: goto L_0x0091;
                case 3276: goto L_0x0087;
                case 3329: goto L_0x0084;
                case 3355: goto L_0x007a;
                case 3365: goto L_0x0070;
                case 3371: goto L_0x0066;
                case 3383: goto L_0x0063;
                case 3428: goto L_0x0060;
                case 3431: goto L_0x005d;
                case 3588: goto L_0x0052;
                case 3645: goto L_0x0047;
                case 3651: goto L_0x003c;
                case 3700: goto L_0x0035;
                case 3710: goto L_0x002a;
                case 3763: goto L_0x001f;
                case 3886: goto L_0x0014;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x00ba
        L_0x0014:
            java.lang.String r1 = "zh"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x001e
            goto L_0x00ba
        L_0x001e:
            return r3
        L_0x001f:
            java.lang.String r1 = "vi"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0029
            goto L_0x00ba
        L_0x0029:
            return r4
        L_0x002a:
            java.lang.String r1 = "tr"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0034
            goto L_0x00ba
        L_0x0034:
            return r4
        L_0x0035:
            java.lang.String r1 = "th"
        L_0x0037:
            r6.equals(r1)
            goto L_0x00ba
        L_0x003c:
            java.lang.String r1 = "ru"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0046
            goto L_0x00ba
        L_0x0046:
            return r2
        L_0x0047:
            java.lang.String r1 = "ro"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0051
            goto L_0x00ba
        L_0x0051:
            return r4
        L_0x0052:
            java.lang.String r1 = "pt"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x005c
            goto L_0x00ba
        L_0x005c:
            return r4
        L_0x005d:
            java.lang.String r1 = "kr"
            goto L_0x0037
        L_0x0060:
            java.lang.String r1 = "ko"
            goto L_0x0037
        L_0x0063:
            java.lang.String r1 = "ja"
            goto L_0x0037
        L_0x0066:
            java.lang.String r1 = "it"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x006f
            goto L_0x00ba
        L_0x006f:
            return r4
        L_0x0070:
            java.lang.String r1 = "in"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0079
            goto L_0x00ba
        L_0x0079:
            return r4
        L_0x007a:
            java.lang.String r1 = "id"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0083
            goto L_0x00ba
        L_0x0083:
            return r4
        L_0x0084:
            java.lang.String r1 = "hi"
            goto L_0x0037
        L_0x0087:
            java.lang.String r1 = "fr"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0090
            goto L_0x00ba
        L_0x0090:
            return r2
        L_0x0091:
            java.lang.String r1 = "es"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x009a
            goto L_0x00ba
        L_0x009a:
            return r4
        L_0x009b:
            java.lang.String r1 = "en"
            goto L_0x0037
        L_0x009e:
            java.lang.String r1 = "de"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x00a7
            goto L_0x00ba
        L_0x00a7:
            return r4
        L_0x00a8:
            java.lang.String r1 = "cn"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x00b1
            goto L_0x00ba
        L_0x00b1:
            return r3
        L_0x00b2:
            java.lang.String r1 = "ar"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x00bb
        L_0x00ba:
            return r0
        L_0x00bb:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: z2.C2962v.q(java.lang.String):java.lang.String");
    }

    public static /* synthetic */ void u(C2962v vVar, Activity activity, String str, String str2, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            str2 = null;
        }
        vVar.t(activity, str, str2);
    }

    public final String c(String str) {
        String str2;
        t.e(str, "url");
        if (!s.V(str, ".uptodown.com/", false, 2, (Object) null)) {
            return str;
        }
        if (s.V(str, "?", false, 2, (Object) null)) {
            str2 = str + '&';
        } else {
            str2 = str + '?';
        }
        return str2 + "userAgent=uptodownandroid";
    }

    public final SpannableString d(String str, String str2, Context context) {
        t.e(str, "originalString");
        t.e(str2, "subString");
        t.e(context, "context");
        SpannableString spannableString = new SpannableString(str);
        String str3 = str2;
        int f02 = s.f0(str, str3, 0, false, 6, (Object) null);
        int length = str3.length() + f02;
        if (f02 != -1) {
            float dimension = context.getResources().getDimension(R.dimen.text_size_m);
            Typeface w4 = k.f32g.w();
            t.b(w4);
            spannableString.setSpan(new C2966z(dimension, w4, ContextCompat.getColor(context, R.color.text_primary)), f02, length, 33);
        }
        return spannableString;
    }

    public final AlertDialog e(AlertDialog alertDialog, Activity activity) {
        t.e(activity, "activity");
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        a.C0147a aVar = com.uptodown.activities.preferences.a.f15150a;
        if (!aVar.W(activity) || aVar.k0(activity)) {
            return null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage(activity.getString(R.string.tracking_disabled_warning_gdpr));
        builder.setPositiveButton(R.string.gdpr_set_up, new C2960t(activity));
        builder.setNegativeButton(17039360, new C2961u());
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        if (!activity.isFinishing()) {
            create.show();
        }
        return create;
    }

    public final void h(Context context, String str, String str2) {
        t.e(context, "context");
        t.e(str, "packagenameInstalled");
        t.e(str2, "packageNameDeepLink");
        try {
            if (s.E(str, str2, true)) {
                Iterator it = new E().l(context).iterator();
                t.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    t.d(next, "next(...)");
                    File file = (File) next;
                    E e5 = new E();
                    String name = file.getName();
                    t.d(name, "getName(...)");
                    String k5 = e5.k(name);
                    if (k5 != null && s.E(k5, str2, true)) {
                        String absolutePath = file.getAbsolutePath();
                        if (file.delete()) {
                            C2940B a5 = C2940B.f26458v.a(context);
                            a5.a();
                            t.b(absolutePath);
                            a5.z(absolutePath);
                            a5.m();
                            return;
                        }
                        return;
                    }
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public final String i(int i5, Context context) {
        t.e(context, "context");
        return j(i5, com.uptodown.activities.preferences.a.f15150a.n(context));
    }

    public final String j(int i5, String str) {
        String valueOf = String.valueOf(i5);
        String q5 = q(str);
        if (s.E(str, "es", true) && i5 < 10000) {
            return valueOf;
        }
        String str2 = "";
        while (valueOf.length() > 3) {
            Q q6 = Q.f24695a;
            String substring = valueOf.substring(valueOf.length() - 3);
            t.d(substring, "substring(...)");
            str2 = String.format(q5 + "%s%s", Arrays.copyOf(new Object[]{substring, str2}, 2));
            t.d(str2, "format(...)");
            valueOf = valueOf.substring(0, valueOf.length() - 3);
            t.d(valueOf, "substring(...)");
        }
        if (valueOf.length() <= 0) {
            return str2;
        }
        return valueOf + str2;
    }

    public final String k(int i5) {
        if (i5 >= 1000000) {
            double d5 = ((double) i5) / 1000000.0d;
            int i6 = (int) d5;
            if (d5 == ((double) i6)) {
                StringBuilder sb = new StringBuilder();
                sb.append(i6);
                sb.append('M');
                return sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            Q q5 = Q.f24695a;
            String format = String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(d5)}, 1));
            t.d(format, "format(...)");
            sb2.append(s.L(format, ",0", "", false, 4, (Object) null));
            sb2.append('M');
            return sb2.toString();
        } else if (i5 < 1000) {
            return String.valueOf(i5);
        } else {
            double d6 = ((double) i5) / 1000.0d;
            int i7 = (int) d6;
            if (d6 == ((double) i7)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(i7);
                sb3.append('K');
                return sb3.toString();
            }
            StringBuilder sb4 = new StringBuilder();
            Q q6 = Q.f24695a;
            String format2 = String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(d6)}, 1));
            t.d(format2, "format(...)");
            sb4.append(s.L(format2, ",0", "", false, 4, (Object) null));
            sb4.append('K');
            return sb4.toString();
        }
    }

    public final ArrayList l(Context context) {
        t.e(context, "context");
        ArrayList arrayList = new ArrayList();
        C2940B a5 = C2940B.f26458v.a(context);
        a5.a();
        Iterator it = a5.p0().iterator();
        t.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            C2668q qVar = (C2668q) next;
            if (qVar.M()) {
                arrayList.add(qVar);
            }
        }
        a5.m();
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x004f, code lost:
        if (t3.s.P(r2, "https://play.google.com", false, 2, (java.lang.Object) null) != false) goto L_0x0051;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String m(android.net.Uri r12) {
        /*
            r11 = this;
            java.lang.String r0 = "uri"
            kotlin.jvm.internal.t.e(r12, r0)
            java.lang.String r1 = r12.toString()
            java.lang.String r0 = "toString(...)"
            kotlin.jvm.internal.t.d(r1, r0)
            java.lang.String r2 = "utd://"
            r7 = 0
            r8 = 2
            r9 = 0
            boolean r2 = t3.s.P(r1, r2, r7, r8, r9)
            java.lang.String r10 = "substring(...)"
            if (r2 == 0) goto L_0x0024
            r12 = 6
            java.lang.String r12 = r1.substring(r12)
            kotlin.jvm.internal.t.d(r12, r10)
            return r12
        L_0x0024:
            java.lang.String r2 = r12.toString()
            kotlin.jvm.internal.t.d(r2, r0)
            java.lang.String r3 = "market://"
            boolean r2 = t3.s.P(r2, r3, r7, r8, r9)
            if (r2 != 0) goto L_0x0051
            java.lang.String r2 = r12.toString()
            kotlin.jvm.internal.t.d(r2, r0)
            java.lang.String r3 = "http://play.google.com"
            boolean r2 = t3.s.P(r2, r3, r7, r8, r9)
            if (r2 != 0) goto L_0x0051
            java.lang.String r2 = r12.toString()
            kotlin.jvm.internal.t.d(r2, r0)
            java.lang.String r3 = "https://play.google.com"
            boolean r2 = t3.s.P(r2, r3, r7, r8, r9)
            if (r2 == 0) goto L_0x008d
        L_0x0051:
            java.lang.String r2 = r12.toString()
            kotlin.jvm.internal.t.d(r2, r0)
            r0 = r2
            java.lang.String r2 = "details?id="
            boolean r0 = t3.s.V(r0, r2, r7, r8, r9)
            if (r0 == 0) goto L_0x008d
            r5 = 6
            r6 = 0
            r3 = 0
            r4 = 0
            int r12 = t3.s.f0(r1, r2, r3, r4, r5, r6)
            int r12 = r12 + 11
            java.lang.String r0 = "&"
            boolean r0 = t3.s.V(r1, r0, r7, r8, r9)
            if (r0 == 0) goto L_0x0085
            r5 = 6
            r6 = 0
            java.lang.String r2 = "&"
            r3 = 0
            r4 = 0
            int r0 = t3.s.f0(r1, r2, r3, r4, r5, r6)
            java.lang.String r12 = r1.substring(r12, r0)
            kotlin.jvm.internal.t.d(r12, r10)
            return r12
        L_0x0085:
            java.lang.String r12 = r1.substring(r12)
            kotlin.jvm.internal.t.d(r12, r10)
            return r12
        L_0x008d:
            java.lang.String r12 = r12.toString()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: z2.C2962v.m(android.net.Uri):java.lang.String");
    }

    public final String n(long j5) {
        if (j5 <= 0) {
            return null;
        }
        return new SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(new Date(j5));
    }

    public final String o(long j5) {
        if (j5 <= 0) {
            return null;
        }
        return new SimpleDateFormat("dd MMM yyyy HH:mm", Locale.getDefault()).format(new Date(j5));
    }

    public final String p(long j5) {
        if (j5 <= 0) {
            return null;
        }
        return new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date(j5));
    }

    public final File r(Context context) {
        C2668q qVar;
        t.e(context, "context");
        C2940B a5 = C2940B.f26458v.a(context);
        a5.a();
        String packageName = context.getPackageName();
        t.d(packageName, "getPackageName(...)");
        T G02 = a5.G0(packageName);
        File file = null;
        if (G02 != null) {
            qVar = G02.b(context);
        } else {
            qVar = null;
        }
        if (qVar != null && qVar.f()) {
            file = qVar.n();
        }
        a5.m();
        return file;
    }

    public final boolean s(Context context) {
        if (context == null || (context.getResources().getConfiguration().uiMode & 48) != 16) {
            return false;
        }
        return true;
    }

    public final void t(Activity activity, String str, String str2) {
        t.e(activity, "activity");
        t.e(str, "url");
        String c5 = c(str);
        try {
            new CustomTabsIntent.Builder().build().launchUrl(activity, Uri.parse(c5));
        } catch (Exception unused) {
            Intent intent = new Intent(activity, CustomWebView.class);
            if (str2 != null) {
                intent.putExtra(CampaignEx.JSON_KEY_TITLE, str2);
            }
            intent.putExtra("url", c5);
            activity.startActivity(intent, UptodownApp.f13477F.a(activity));
            Bundle bundle = new Bundle();
            bundle.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "urlNotOpened");
            bundle.putString("url", str);
            new F(activity).d("open_url", bundle);
        }
    }

    public final boolean v(String str, String str2) {
        if (str == null && str2 != null) {
            return false;
        }
        if (str == null || str2 != null) {
            return s.E(str, str2, true);
        }
        return false;
    }

    public final Uri w(File file, Context context) {
        t.e(context, "context");
        if (Build.VERSION.SDK_INT >= 24) {
            t.b(file);
            Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".provider", file);
            t.b(uriForFile);
            return uriForFile;
        }
        Uri fromFile = Uri.fromFile(file);
        t.b(fromFile);
        return fromFile;
    }
}
