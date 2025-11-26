package R1;

import C2.C2045p0;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import java.util.ArrayList;
import k2.C2614y;
import kotlin.jvm.internal.t;
import l2.C2642B;

/* renamed from: R1.p  reason: case insensitive filesystem */
public final class C0985p extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f4275a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f4276b;

    /* renamed from: c  reason: collision with root package name */
    private final C2614y f4277c;

    public C0985p(ArrayList arrayList, Context context, C2614y yVar) {
        t.e(arrayList, DataSchemeDataSource.SCHEME_DATA);
        t.e(context, "context");
        t.e(yVar, "listener");
        this.f4275a = arrayList;
        this.f4276b = context;
        this.f4277c = yVar;
    }

    public final ArrayList a() {
        return this.f4275a;
    }

    /* renamed from: b */
    public void onBindViewHolder(C2045p0 p0Var, int i5) {
        t.e(p0Var, "viewHolder");
        Object obj = this.f4275a.get(i5);
        t.d(obj, "get(...)");
        p0Var.h((C2642B) obj);
    }

    /* renamed from: c */
    public C2045p0 onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(this.f4276b).inflate(R.layout.notification_registry_item, viewGroup, false);
        t.b(inflate);
        return new C2045p0(inflate, this.f4277c);
    }

    public final void d(ArrayList arrayList) {
        t.e(arrayList, "<set-?>");
        this.f4275a = arrayList;
    }

    public int getItemCount() {
        return this.f4275a.size();
    }
}
