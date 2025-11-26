package v4;

import E1.c;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import java.util.List;
import kotlin.jvm.internal.t;
import m4.q;

public final class s extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    public final List f26108a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f26109b;

    /* renamed from: c  reason: collision with root package name */
    public final Integer f26110c;

    /* renamed from: d  reason: collision with root package name */
    public final Typeface f26111d;

    public s(List list, Context context, Integer num, Typeface typeface) {
        t.e(list, "items");
        t.e(context, "context");
        this.f26108a = list;
        this.f26109b = context;
        this.f26110c = num;
        this.f26111d = typeface;
    }

    public final int getItemCount() {
        return this.f26108a.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) {
        r rVar = (r) viewHolder;
        t.e(rVar, "holder");
        rVar.b(this.f26109b, (q) this.f26108a.get(i5), this.f26110c);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(c.list_publisher_link, viewGroup, false);
        t.d(inflate, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        return new r(inflate, this.f26111d);
    }
}
