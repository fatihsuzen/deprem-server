package n4;

import W2.J;
import W2.u;
import android.graphics.BitmapFactory;
import b3.C2308e;
import c3.C2316b;
import java.net.URL;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

public final class e extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f25526a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(String str, C2308e eVar) {
        super(2, eVar);
        this.f25526a = str;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new e(this.f25526a, eVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        M m5 = (M) obj;
        return new e(this.f25526a, (C2308e) obj2).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        C2316b.f();
        u.b(obj);
        return BitmapFactory.decodeStream(new URL(this.f25526a).openConnection().getInputStream());
    }
}
