package R1;

import C2.B1;
import C2.C2068x0;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import java.util.ArrayList;
import java.util.Iterator;
import k2.C2592b;
import k2.L;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2655d;

public final class F extends RecyclerView.Adapter {

    /* renamed from: f  reason: collision with root package name */
    public static final a f4008f = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f4009a;

    /* renamed from: b  reason: collision with root package name */
    private final C2592b f4010b;

    /* renamed from: c  reason: collision with root package name */
    private final L f4011c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f4012d;

    /* renamed from: e  reason: collision with root package name */
    private int f4013e = -1;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public F(ArrayList arrayList, Context context, C2592b bVar, L l5) {
        t.e(arrayList, "apps");
        t.e(context, "context");
        t.e(bVar, "applistener");
        t.e(l5, "uptodownProtectListener");
        this.f4009a = context;
        this.f4010b = bVar;
        this.f4011c = l5;
        a(arrayList);
    }

    private final void a(ArrayList arrayList) {
        d(new ArrayList());
        b().add("uptodown_protect");
        this.f4013e = 0;
        b().addAll(arrayList);
    }

    public final ArrayList b() {
        ArrayList arrayList = this.f4012d;
        if (arrayList != null) {
            return arrayList;
        }
        t.w(DataSchemeDataSource.SCHEME_DATA);
        return null;
    }

    public final void c(ArrayList arrayList) {
        t.e(arrayList, "apps");
        a(arrayList);
        notifyDataSetChanged();
    }

    public final void d(ArrayList arrayList) {
        t.e(arrayList, "<set-?>");
        this.f4012d = arrayList;
    }

    public int getItemCount() {
        return b().size();
    }

    public int getItemViewType(int i5) {
        Object obj = b().get(i5);
        t.d(obj, "get(...)");
        if (obj instanceof C2655d) {
            return 0;
        }
        if (!(obj instanceof String)) {
            throw new IllegalArgumentException();
        } else if (t.a((String) obj, "uptodown_protect")) {
            return 3;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) {
        t.e(viewHolder, "viewHolder");
        if (viewHolder instanceof C2068x0) {
            Object obj = b().get(i5);
            t.c(obj, "null cannot be cast to non-null type com.uptodown.models.App");
            ((C2068x0) viewHolder).e((C2655d) obj);
        } else if (viewHolder instanceof B1) {
            ArrayList arrayList = new ArrayList();
            Iterator it = b().iterator();
            t.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                t.d(next, "next(...)");
                if (next instanceof C2655d) {
                    arrayList.add(next);
                }
            }
            ((B1) viewHolder).d(arrayList, this.f4009a);
        } else {
            throw new IllegalArgumentException("ViewHolder unknown!!");
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "viewGroup");
        if (i5 == 0) {
            return new C2068x0(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.app_positive, viewGroup, false), this.f4010b, this.f4009a);
        }
        if (i5 == 3) {
            return new B1(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.uptodown_protect, viewGroup, false), this.f4011c);
        }
        throw new IllegalArgumentException("viewType unknown");
    }
}
