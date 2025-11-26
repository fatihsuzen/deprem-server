package u1;

import A1.g;
import android.webkit.WebView;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final l f16672a;

    /* renamed from: b  reason: collision with root package name */
    private final WebView f16673b;

    /* renamed from: c  reason: collision with root package name */
    private final List f16674c;

    /* renamed from: d  reason: collision with root package name */
    private final Map f16675d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final String f16676e;

    /* renamed from: f  reason: collision with root package name */
    private final String f16677f;

    /* renamed from: g  reason: collision with root package name */
    private final String f16678g;

    /* renamed from: h  reason: collision with root package name */
    private final e f16679h;

    private d(l lVar, WebView webView, String str, List list, String str2, String str3, e eVar) {
        ArrayList arrayList = new ArrayList();
        this.f16674c = arrayList;
        this.f16672a = lVar;
        this.f16673b = webView;
        this.f16676e = str;
        this.f16679h = eVar;
        if (list != null) {
            arrayList.addAll(list);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String uuid = UUID.randomUUID().toString();
                this.f16675d.put(uuid, (m) it.next());
            }
        }
        this.f16678g = str2;
        this.f16677f = str3;
    }

    public static d a(l lVar, WebView webView, String str, String str2) {
        g.b(lVar, "Partner is null");
        g.b(webView, "WebView is null");
        if (str2 != null) {
            g.c(str2, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new d(lVar, webView, (String) null, (List) null, str, str2, e.HTML);
    }

    public static d b(l lVar, String str, List list, String str2, String str3) {
        g.b(lVar, "Partner is null");
        g.b(str, "OM SDK JS script content is null");
        g.b(list, "VerificationScriptResources is null");
        if (str3 != null) {
            g.c(str3, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new d(lVar, (WebView) null, str, list, str2, str3, e.NATIVE);
    }

    public e c() {
        return this.f16679h;
    }

    public String d() {
        return this.f16678g;
    }

    public String e() {
        return this.f16677f;
    }

    public Map f() {
        return DesugarCollections.unmodifiableMap(this.f16675d);
    }

    public String g() {
        return this.f16676e;
    }

    public l h() {
        return this.f16672a;
    }

    public List i() {
        return DesugarCollections.unmodifiableList(this.f16674c);
    }

    public WebView j() {
        return this.f16673b;
    }
}
