package h0;

import L.C0668a;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.api.Scope;

/* renamed from: h0.d  reason: case insensitive filesystem */
public abstract class C1670d {

    /* renamed from: a  reason: collision with root package name */
    public static final C0668a.g f15358a;

    /* renamed from: b  reason: collision with root package name */
    public static final C0668a.g f15359b;

    /* renamed from: c  reason: collision with root package name */
    public static final C0668a.C0048a f15360c;

    /* renamed from: d  reason: collision with root package name */
    static final C0668a.C0048a f15361d;

    /* renamed from: e  reason: collision with root package name */
    public static final Scope f15362e = new Scope("profile");

    /* renamed from: f  reason: collision with root package name */
    public static final Scope f15363f = new Scope(NotificationCompat.CATEGORY_EMAIL);

    /* renamed from: g  reason: collision with root package name */
    public static final C0668a f15364g;

    /* renamed from: h  reason: collision with root package name */
    public static final C0668a f15365h;

    static {
        C0668a.g gVar = new C0668a.g();
        f15358a = gVar;
        C0668a.g gVar2 = new C0668a.g();
        f15359b = gVar2;
        C1668b bVar = new C1668b();
        f15360c = bVar;
        C1669c cVar = new C1669c();
        f15361d = cVar;
        f15364g = new C0668a("SignIn.API", bVar, gVar);
        f15365h = new C0668a("SignIn.INTERNAL_API", cVar, gVar2);
    }
}
