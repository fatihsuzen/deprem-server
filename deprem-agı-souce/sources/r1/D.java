package R1;

import C2.T0;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import java.util.ArrayList;
import k2.H;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.P;
import l2.b0;

public final class D extends RecyclerView.Adapter {

    /* renamed from: c  reason: collision with root package name */
    public static final a f4001c = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f4002a;

    /* renamed from: b  reason: collision with root package name */
    private final H f4003b;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public D(ArrayList arrayList, H h5) {
        t.e(h5, "listener");
        this.f4002a = arrayList;
        this.f4003b = h5;
    }

    /* renamed from: a */
    public void onBindViewHolder(T0 t02, int i5) {
        Object obj;
        t.e(t02, "viewHolder");
        ArrayList arrayList = this.f4002a;
        Object obj2 = null;
        if (arrayList != null) {
            obj = arrayList.get(i5);
        } else {
            obj = null;
        }
        if (obj instanceof b0) {
            ArrayList arrayList2 = this.f4002a;
            if (arrayList2 != null) {
                obj2 = arrayList2.get(i5);
            }
            t.b(obj2);
            t02.g((b0) obj2);
            return;
        }
        ArrayList arrayList3 = this.f4002a;
        if (arrayList3 != null) {
            obj2 = arrayList3.get(i5);
        }
        t.b(obj2);
        t02.f((P) obj2);
    }

    /* renamed from: b */
    public T0 onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.screenshot_item, viewGroup, false);
        t.b(inflate);
        return new T0(inflate, this.f4003b);
    }

    public final void c(Object obj) {
        Integer num;
        t.e(obj, "item");
        ArrayList arrayList = this.f4002a;
        if (arrayList != null) {
            num = Integer.valueOf(arrayList.indexOf(obj));
        } else {
            num = null;
        }
        if (num != null && num.intValue() != -1) {
            ArrayList arrayList2 = this.f4002a;
            if (arrayList2 != null) {
                arrayList2.remove(num.intValue());
            }
            notifyItemRemoved(num.intValue());
        }
    }

    public int getItemCount() {
        ArrayList arrayList = this.f4002a;
        if (arrayList == null) {
            return 0;
        }
        t.b(arrayList);
        return arrayList.size();
    }

    public int getItemViewType(int i5) {
        Object obj;
        ArrayList arrayList = this.f4002a;
        if (arrayList != null) {
            obj = arrayList.get(i5);
        } else {
            obj = null;
        }
        if (obj instanceof b0) {
            return 0;
        }
        return 1;
    }
}
