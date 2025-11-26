package v4;

import E1.c;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import m4.r;

public final class w extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    public List f26123a;

    /* renamed from: b  reason: collision with root package name */
    public final t f26124b;

    /* renamed from: c  reason: collision with root package name */
    public final Integer f26125c;

    /* renamed from: d  reason: collision with root package name */
    public final Integer f26126d;

    /* renamed from: e  reason: collision with root package name */
    public final Typeface f26127e;

    public w(ArrayList arrayList, t tVar, Integer num, Integer num2, Typeface typeface) {
        t.e(arrayList, "items");
        t.e(tVar, "listener");
        this.f26123a = arrayList;
        this.f26124b = tVar;
        this.f26125c = num;
        this.f26126d = num2;
        this.f26127e = typeface;
    }

    public final int getItemCount() {
        return this.f26123a.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) {
        v vVar = (v) viewHolder;
        t.e(vVar, "holder");
        vVar.a((r) this.f26123a.get(i5));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(c.list_item_stack, viewGroup, false);
        t.d(inflate, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        return new v(inflate, this.f26124b, this.f26125c, this.f26126d, this.f26127e);
    }
}
