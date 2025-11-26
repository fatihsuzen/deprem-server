package z;

import android.database.Cursor;
import java.util.Map;
import u.C1883a;
import z.M;

/* renamed from: z.A  reason: case insensitive filesystem */
public final /* synthetic */ class C1940A implements M.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ M f17092a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f17093b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C1883a.C0164a f17094c;

    public /* synthetic */ C1940A(M m5, Map map, C1883a.C0164a aVar) {
        this.f17092a = m5;
        this.f17093b = map;
        this.f17094c = aVar;
    }

    public final Object apply(Object obj) {
        return M.A(this.f17092a, this.f17093b, this.f17094c, (Cursor) obj);
    }
}
