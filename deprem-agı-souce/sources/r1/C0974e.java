package R1;

import C2.Q;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import java.util.ArrayList;
import k2.C2592b;
import kotlin.jvm.internal.t;
import l2.C2655d;

/* renamed from: R1.e  reason: case insensitive filesystem */
public final class C0974e extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private final Context f4155a;

    /* renamed from: b  reason: collision with root package name */
    private final C2592b f4156b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList f4157c;

    public C0974e(ArrayList arrayList, Context context, C2592b bVar) {
        t.e(arrayList, "apps");
        t.e(context, "context");
        t.e(bVar, "applistener");
        this.f4155a = context;
        this.f4156b = bVar;
        b(arrayList);
    }

    public final ArrayList a() {
        ArrayList arrayList = this.f4157c;
        if (arrayList != null) {
            return arrayList;
        }
        t.w(DataSchemeDataSource.SCHEME_DATA);
        return null;
    }

    public final void b(ArrayList arrayList) {
        t.e(arrayList, "apps");
        c(arrayList);
        notifyDataSetChanged();
    }

    public final void c(ArrayList arrayList) {
        t.e(arrayList, "<set-?>");
        this.f4157c = arrayList;
    }

    public int getItemCount() {
        return a().size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) {
        t.e(viewHolder, "viewHolder");
        if (viewHolder instanceof Q) {
            Object obj = a().get(i5);
            t.d(obj, "get(...)");
            ((Q) viewHolder).k((C2655d) obj);
            return;
        }
        throw new IllegalArgumentException("ViewHolder unknown!!");
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.free_up_item, viewGroup, false);
        t.b(inflate);
        return new Q(inflate, this.f4156b, this.f4155a);
    }
}
