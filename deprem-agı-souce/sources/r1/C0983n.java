package R1;

import C2.C2009d0;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import java.util.ArrayList;
import k2.C2613x;
import kotlin.jvm.internal.t;
import l2.C2675y;

/* renamed from: R1.n  reason: case insensitive filesystem */
public final class C0983n extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f4266a;

    /* renamed from: b  reason: collision with root package name */
    private final C2613x f4267b;

    /* renamed from: c  reason: collision with root package name */
    private final String f4268c;

    public C0983n(ArrayList arrayList, C2613x xVar, String str) {
        t.e(xVar, "listener");
        t.e(str, "currentLanguageCode");
        this.f4266a = arrayList;
        this.f4267b = xVar;
        this.f4268c = str;
    }

    /* renamed from: a */
    public void onBindViewHolder(C2009d0 d0Var, int i5) {
        C2675y yVar;
        t.e(d0Var, "viewHolder");
        ArrayList arrayList = this.f4266a;
        if (arrayList != null) {
            yVar = (C2675y) arrayList.get(i5);
        } else {
            yVar = null;
        }
        t.b(yVar);
        d0Var.b(yVar, this.f4268c);
    }

    /* renamed from: b */
    public C2009d0 onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.language_item, viewGroup, false);
        t.b(inflate);
        return new C2009d0(inflate, this.f4267b);
    }

    public int getItemCount() {
        ArrayList arrayList = this.f4266a;
        if (arrayList == null) {
            return 0;
        }
        t.b(arrayList);
        return arrayList.size();
    }
}
