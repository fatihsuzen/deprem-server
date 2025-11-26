package v4;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import java.util.List;
import kotlin.jvm.internal.t;
import m4.d;
import s4.c;

public final class g extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    public final List f26069a;

    public g(List list) {
        t.e(list, "disclosures");
        this.f26069a = list;
    }

    public final int getItemCount() {
        return this.f26069a.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) {
        j jVar = (j) viewHolder;
        t.e(jVar, "holder");
        i iVar = (i) this.f26069a.get(i5);
        jVar.getClass();
        t.e(iVar, "disclosure");
        jVar.f26085k.setText(iVar.f26070a);
        jVar.f26084j.setText(iVar.f26071b);
        jVar.f26083i.setText(iVar.f26072c);
        jVar.f26082h.setText(iVar.f26073d);
        jVar.f26081g.setText(iVar.f26074e);
        d dVar = c.f25857e;
        if (dVar != null) {
            Integer num = dVar.f25324i;
            if (num != null) {
                int intValue = num.intValue();
                jVar.f26085k.setTextColor(intValue);
                jVar.f26080f.setTextColor(intValue);
                jVar.f26084j.setTextColor(intValue);
                jVar.f26079e.setTextColor(intValue);
                jVar.f26083i.setTextColor(intValue);
                jVar.f26078d.setTextColor(intValue);
                jVar.f26082h.setTextColor(intValue);
                jVar.f26077c.setTextColor(intValue);
                jVar.f26081g.setTextColor(intValue);
                jVar.f26076b.setTextColor(intValue);
            }
            Integer num2 = dVar.f25316a;
            if (num2 != null) {
                jVar.f26075a.setBackgroundColor(num2.intValue());
            }
        }
        m4.c cVar = c.f25856d;
        if (cVar != null) {
            Typeface typeface = cVar.f25315b;
            if (typeface != null) {
                jVar.f26085k.setTypeface(typeface);
                jVar.f26080f.setTypeface(typeface);
                jVar.f26084j.setTypeface(typeface);
                jVar.f26079e.setTypeface(typeface);
                jVar.f26083i.setTypeface(typeface);
                jVar.f26078d.setTypeface(typeface);
                jVar.f26082h.setTypeface(typeface);
                jVar.f26077c.setTypeface(typeface);
                jVar.f26081g.setTypeface(typeface);
            }
            Typeface typeface2 = cVar.f25314a;
            if (typeface2 != null) {
                jVar.f26076b.setTypeface(typeface2);
            }
        }
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(E1.c.list_item_disclosure, viewGroup, false);
        t.d(inflate, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        return new j(inflate);
    }
}
