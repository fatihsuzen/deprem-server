package z;

import android.database.Cursor;
import java.util.List;
import r.p;
import z.M;

/* renamed from: z.v  reason: case insensitive filesystem */
public final /* synthetic */ class C1969v implements M.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ M f17169a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f17170b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p f17171c;

    public /* synthetic */ C1969v(M m5, List list, p pVar) {
        this.f17169a = m5;
        this.f17170b = list;
        this.f17171c = pVar;
    }

    public final Object apply(Object obj) {
        return M.L(this.f17169a, this.f17170b, this.f17171c, (Cursor) obj);
    }
}
