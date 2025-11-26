package l2;

import S1.k;
import X2.C2250q;
import a3.C2265a;
import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.same.report.i;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import k2.C2599i;
import k2.C2601k;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import s3.C2754h;
import t3.C2788l;
import t3.p;
import t3.s;
import z2.C2966z;

/* renamed from: l2.o  reason: case insensitive filesystem */
public final class C2666o {

    /* renamed from: g  reason: collision with root package name */
    public static final a f25106g = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private int f25107a;

    /* renamed from: b  reason: collision with root package name */
    private String f25108b;

    /* renamed from: c  reason: collision with root package name */
    private final Long f25109c;

    /* renamed from: d  reason: collision with root package name */
    private String f25110d;

    /* renamed from: e  reason: collision with root package name */
    private String f25111e;

    /* renamed from: f  reason: collision with root package name */
    private String f25112f;

    /* renamed from: l2.o$a */
    public static final class a {

        /* renamed from: l2.o$a$a  reason: collision with other inner class name */
        public static final class C0252a implements Comparator {
            public final int compare(Object obj, Object obj2) {
                return C2265a.a(Integer.valueOf(((C2666o) obj).b()), Integer.valueOf(((C2666o) obj2).b()));
            }
        }

        /* renamed from: l2.o$a$b */
        public static final class b extends ClickableSpan {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Context f25113a;

            b(Context context) {
                this.f25113a = context;
            }

            public void onClick(View view) {
                t.e(view, "widget");
            }

            public void updateDrawState(TextPaint textPaint) {
                t.e(textPaint, "ds");
                super.updateDrawState(textPaint);
                textPaint.setColor(ContextCompat.getColor(this.f25113a, R.color.main_blue));
                textPaint.setTypeface(k.f32g.w());
            }
        }

        /* renamed from: l2.o$a$c */
        public static final class c extends ClickableSpan {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C2666o f25114a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2599i f25115b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Context f25116c;

            c(C2666o oVar, C2599i iVar, Context context) {
                this.f25114a = oVar;
                this.f25115b = iVar;
                this.f25116c = context;
            }

            public void onClick(View view) {
                t.e(view, "widget");
                if (UptodownApp.f13477F.Z() && this.f25114a.a() != null) {
                    this.f25115b.a(this.f25114a.a().longValue());
                }
            }

            public void updateDrawState(TextPaint textPaint) {
                t.e(textPaint, "ds");
                super.updateDrawState(textPaint);
                textPaint.setColor(ContextCompat.getColor(this.f25116c, R.color.main_blue));
                textPaint.setTypeface(k.f32g.w());
            }
        }

        /* renamed from: l2.o$a$d */
        public static final class d extends ClickableSpan {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C2666o f25117a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2599i f25118b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Context f25119c;

            d(C2666o oVar, C2599i iVar, Context context) {
                this.f25117a = oVar;
                this.f25118b = iVar;
                this.f25119c = context;
            }

            public void onClick(View view) {
                t.e(view, "widget");
                if (UptodownApp.f13477F.Z() && this.f25117a.a() != null) {
                    C2660i iVar = new C2660i((int) this.f25117a.a().longValue(), this.f25117a.d(), (String) null, 4, (C2633k) null);
                    iVar.v(true);
                    this.f25118b.b(iVar);
                }
            }

            public void updateDrawState(TextPaint textPaint) {
                t.e(textPaint, "ds");
                super.updateDrawState(textPaint);
                textPaint.setColor(ContextCompat.getColor(this.f25119c, R.color.main_blue));
                textPaint.setTypeface(k.f32g.w());
            }
        }

        /* renamed from: l2.o$a$e */
        public static final class e extends ClickableSpan {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C2666o f25120a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2599i f25121b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Context f25122c;

            e(C2666o oVar, C2599i iVar, Context context) {
                this.f25120a = oVar;
                this.f25121b = iVar;
                this.f25122c = context;
            }

            public void onClick(View view) {
                t.e(view, "widget");
                if (UptodownApp.f13477F.Z() && this.f25120a.a() != null) {
                    this.f25121b.b(new C2660i((int) this.f25120a.a().longValue(), this.f25120a.d(), (String) null, 4, (C2633k) null));
                }
            }

            public void updateDrawState(TextPaint textPaint) {
                t.e(textPaint, "ds");
                super.updateDrawState(textPaint);
                textPaint.setColor(ContextCompat.getColor(this.f25122c, R.color.main_blue));
                textPaint.setTypeface(k.f32g.w());
            }
        }

        /* renamed from: l2.o$a$f */
        public static final class f extends ClickableSpan {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C2666o f25123a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2599i f25124b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Context f25125c;

            f(C2666o oVar, C2599i iVar, Context context) {
                this.f25123a = oVar;
                this.f25124b = iVar;
                this.f25125c = context;
            }

            public void onClick(View view) {
                String e5;
                t.e(view, "widget");
                if (UptodownApp.f13477F.Z() && (e5 = this.f25123a.e()) != null && e5.length() != 0) {
                    C2599i iVar = this.f25124b;
                    String e6 = this.f25123a.e();
                    t.b(e6);
                    iVar.c(e6);
                }
            }

            public void updateDrawState(TextPaint textPaint) {
                t.e(textPaint, "ds");
                super.updateDrawState(textPaint);
                textPaint.setColor(ContextCompat.getColor(this.f25125c, R.color.main_blue));
                textPaint.setTypeface(k.f32g.w());
            }
        }

        /* renamed from: l2.o$a$g */
        public static final class g extends ClickableSpan {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C2666o f25126a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2601k f25127b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Context f25128c;

            g(C2666o oVar, C2601k kVar, Context context) {
                this.f25126a = oVar;
                this.f25127b = kVar;
                this.f25128c = context;
            }

            public void onClick(View view) {
                t.e(view, "widget");
                if (UptodownApp.f13477F.Z() && this.f25126a.a() != null) {
                    this.f25127b.a(this.f25126a.a().longValue());
                }
            }

            public void updateDrawState(TextPaint textPaint) {
                t.e(textPaint, "ds");
                super.updateDrawState(textPaint);
                textPaint.setColor(ContextCompat.getColor(this.f25128c, R.color.main_blue));
                textPaint.setTypeface(k.f32g.w());
            }
        }

        /* renamed from: l2.o$a$h */
        public static final class h extends ClickableSpan {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C2666o f25129a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2601k f25130b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Context f25131c;

            h(C2666o oVar, C2601k kVar, Context context) {
                this.f25129a = oVar;
                this.f25130b = kVar;
                this.f25131c = context;
            }

            public void onClick(View view) {
                t.e(view, "widget");
                if (UptodownApp.f13477F.Z() && this.f25129a.a() != null) {
                    C2660i iVar = new C2660i((int) this.f25129a.a().longValue(), this.f25129a.d(), (String) null, 4, (C2633k) null);
                    iVar.v(true);
                    this.f25130b.b(iVar);
                }
            }

            public void updateDrawState(TextPaint textPaint) {
                t.e(textPaint, "ds");
                super.updateDrawState(textPaint);
                textPaint.setColor(ContextCompat.getColor(this.f25131c, R.color.main_blue));
                textPaint.setTypeface(k.f32g.w());
            }
        }

        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        /* access modifiers changed from: private */
        public static final C2666o f(C2788l lVar) {
            t.e(lVar, "it");
            return new C2666o(lVar.b().c(), (String) lVar.a().get(0), (String) lVar.a().get(1), lVar.getValue());
        }

        private final List g(String str) {
            ArrayList arrayList = new ArrayList();
            for (C2788l lVar : p.e(new p("\\[(\\w+)=([\\w\\d]*)](.*?)\\[/(\\w+)]"), str, 0, 2, (Object) null)) {
                arrayList.add(new C2666o(lVar.b().c(), (String) lVar.a().get(1), Long.valueOf(Long.parseLong((String) lVar.a().get(2))), (String) lVar.a().get(3), lVar.getValue()));
            }
            for (C2788l lVar2 : p.e(new p("\\[url=([^\\]]+)](.*?)\\[/url]"), str, 0, 2, (Object) null)) {
                C2666o oVar = new C2666o(lVar2.b().c(), (String) lVar2.a().get(0), (String) lVar2.a().get(2), lVar2.getValue());
                oVar.g((String) lVar2.a().get(1));
                arrayList.add(oVar);
            }
            for (C2788l lVar3 : p.e(new p("<(\\w+)>(.*?)</(\\w+)>"), str, 0, 2, (Object) null)) {
                arrayList.add(new C2666o(lVar3.b().c(), (String) lVar3.a().get(1), (String) lVar3.a().get(2), lVar3.getValue()));
            }
            return C2250q.h0(arrayList, new C0252a());
        }

        /* access modifiers changed from: private */
        public static final CharSequence i(C2788l lVar) {
            t.e(lVar, "it");
            return (CharSequence) lVar.a().get(1);
        }

        /* access modifiers changed from: private */
        public static final CharSequence k(C2788l lVar) {
            t.e(lVar, "it");
            return (CharSequence) lVar.a().get(3);
        }

        /* access modifiers changed from: private */
        public static final CharSequence l(C2788l lVar) {
            t.e(lVar, "it");
            return (CharSequence) lVar.a().get(2);
        }

        public final List e(String str, String str2) {
            t.e(str, "inputText");
            t.e(str2, "tag");
            return C2754h.x(C2754h.v(p.e(new p(str2), str, 0, 2, (Object) null), new C2662k()));
        }

        public final SpannableStringBuilder h(Context context, String str) {
            t.e(context, "context");
            t.e(str, "inputText");
            List<C2666o> e5 = e(str, "\\[a](.*?)\\[/a]");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(new p("\\[a](.*?)\\[/a]").i(str, new C2663l()));
            for (C2666o oVar : e5) {
                int f02 = s.f0(spannableStringBuilder, oVar.d(), 0, false, 6, (Object) null);
                int length = oVar.d().length() + f02;
                if (f02 >= 0) {
                    spannableStringBuilder.setSpan(new b(context), f02, length, 33);
                }
            }
            return spannableStringBuilder;
        }

        public final String j(SpannableStringBuilder spannableStringBuilder) {
            t.e(spannableStringBuilder, "<this>");
            return s.L(new p("<(\\w+)>(.*?)</(\\w+)>").i(new p("\\[(\\w+)=([\\w\\d]*)](.*?)\\[/(\\w+)]").i(spannableStringBuilder, new C2664m()), new C2665n()), "<br />", "", false, 4, (Object) null);
        }

        public final SpannableStringBuilder m(String str, Context context, C2599i iVar) {
            Context context2 = context;
            C2599i iVar2 = iVar;
            String str2 = str;
            t.e(str2, "inputText");
            t.e(context2, "context");
            t.e(iVar2, "listener");
            String L4 = s.L(s.L(str2, "<br />", "\n", false, 4, (Object) null), "<br/>", "\n", false, 4, (Object) null);
            List<C2666o> g5 = g(L4);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(L4);
            int i5 = 0;
            for (C2666o oVar : g5) {
                int b5 = oVar.b() - i5;
                int length = oVar.d().length() + b5;
                String f5 = oVar.f();
                t.b(f5);
                spannableStringBuilder = spannableStringBuilder.replace(b5, f5.length() + b5, oVar.d());
                String c5 = oVar.c();
                switch (c5.hashCode()) {
                    case 116079:
                        if (c5.equals("url")) {
                            spannableStringBuilder.setSpan(new f(oVar, iVar2, context2), b5, length, 33);
                            break;
                        } else {
                            break;
                        }
                    case 93028092:
                        if (c5.equals("appID")) {
                            spannableStringBuilder.setSpan(new c(oVar, iVar2, context2), b5, length, 33);
                            break;
                        } else {
                            break;
                        }
                    case 1296531097:
                        if (c5.equals("categoryID")) {
                            spannableStringBuilder.setSpan(new e(oVar, iVar2, context2), b5, length, 33);
                            break;
                        } else {
                            break;
                        }
                    case 1524339519:
                        if (c5.equals("floatingCategoryID")) {
                            spannableStringBuilder.setSpan(new d(oVar, iVar2, context2), b5, length, 33);
                            break;
                        } else {
                            break;
                        }
                }
                String f6 = oVar.f();
                t.b(f6);
                i5 = (i5 + f6.length()) - oVar.d().length();
            }
            return spannableStringBuilder;
        }

        public final SpannableStringBuilder n(String str, Context context, C2601k kVar) {
            Context context2 = context;
            C2601k kVar2 = kVar;
            String str2 = str;
            t.e(str2, "inputText");
            t.e(context2, "context");
            t.e(kVar2, "listener");
            String L4 = s.L(s.L(str2, "<br />", "\n", false, 4, (Object) null), "<br/>", "\n", false, 4, (Object) null);
            List<C2666o> g5 = g(L4);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(L4);
            int i5 = 0;
            for (C2666o oVar : g5) {
                int b5 = oVar.b() - i5;
                int length = oVar.d().length() + b5;
                String f5 = oVar.f();
                t.b(f5);
                spannableStringBuilder = spannableStringBuilder.replace(b5, f5.length() + b5, oVar.d());
                String c5 = oVar.c();
                int hashCode = c5.hashCode();
                if (hashCode != 98) {
                    if (hashCode != 105) {
                        if (hashCode != 117) {
                            if (hashCode != 93028092) {
                                if (hashCode != 1524339519) {
                                    if (hashCode != 3274) {
                                        if (hashCode == 3275 && c5.equals("h3")) {
                                            float dimension = context2.getResources().getDimension(R.dimen.text_size_m);
                                            Typeface w4 = k.f32g.w();
                                            t.b(w4);
                                            spannableStringBuilder.setSpan(new C2966z(dimension, w4, ContextCompat.getColor(context2, R.color.text_primary)), b5, length, 33);
                                        }
                                    } else if (c5.equals("h2")) {
                                        float dimension2 = context2.getResources().getDimension(R.dimen.text_size_l);
                                        Typeface w5 = k.f32g.w();
                                        t.b(w5);
                                        spannableStringBuilder.setSpan(new C2966z(dimension2, w5, ContextCompat.getColor(context2, R.color.text_primary)), b5, length, 33);
                                    }
                                } else if (c5.equals("floatingCategoryID")) {
                                    spannableStringBuilder.setSpan(new h(oVar, kVar2, context2), b5, length, 33);
                                }
                            } else if (c5.equals("appID")) {
                                spannableStringBuilder.setSpan(new g(oVar, kVar2, context2), b5, length, 33);
                            }
                        } else if (c5.equals("u")) {
                            spannableStringBuilder.setSpan(new UnderlineSpan(), b5, length, 33);
                        }
                    } else if (c5.equals(i.f9538a)) {
                        spannableStringBuilder.setSpan(new StyleSpan(2), b5, length, 33);
                    }
                } else if (c5.equals(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B)) {
                    spannableStringBuilder.setSpan(new StyleSpan(1), b5, length, 33);
                }
                String f6 = oVar.f();
                t.b(f6);
                i5 = (i5 + f6.length()) - oVar.d().length();
            }
            return spannableStringBuilder;
        }

        private a() {
        }
    }

    public C2666o(int i5, String str, Long l5, String str2, String str3) {
        t.e(str, "tagType");
        t.e(str2, MimeTypes.BASE_TYPE_TEXT);
        this.f25107a = i5;
        this.f25108b = str;
        this.f25109c = l5;
        this.f25110d = str2;
        this.f25111e = str3;
    }

    public final Long a() {
        return this.f25109c;
    }

    public final int b() {
        return this.f25107a;
    }

    public final String c() {
        return this.f25108b;
    }

    public final String d() {
        return this.f25110d;
    }

    public final String e() {
        return this.f25112f;
    }

    public final String f() {
        return this.f25111e;
    }

    public final void g(String str) {
        this.f25112f = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public C2666o(int i5, String str, String str2, String str3) {
        this(i5, str, (Long) null, str2, str3);
        t.e(str, "tagType");
        t.e(str2, MimeTypes.BASE_TYPE_TEXT);
    }
}
