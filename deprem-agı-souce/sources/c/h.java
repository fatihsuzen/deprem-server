package c;

import E1.c;
import P3.e;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import java.util.List;
import kotlin.jvm.internal.t;

public final class h extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    public List f884a;

    /* renamed from: b  reason: collision with root package name */
    public final b f885b;

    /* renamed from: c  reason: collision with root package name */
    public final String f886c;

    /* renamed from: d  reason: collision with root package name */
    public final String f887d;

    /* renamed from: e  reason: collision with root package name */
    public final Integer f888e;

    /* renamed from: f  reason: collision with root package name */
    public final Integer f889f;

    /* renamed from: g  reason: collision with root package name */
    public final Integer f890g;

    /* renamed from: h  reason: collision with root package name */
    public final Integer f891h;

    /* renamed from: i  reason: collision with root package name */
    public final Typeface f892i;

    /* renamed from: j  reason: collision with root package name */
    public final Typeface f893j;

    public /* synthetic */ h(List list, b bVar, String str, Integer num, Integer num2, Integer num3, Integer num4, Typeface typeface, Typeface typeface2, int i5) {
        Typeface typeface3;
        b bVar2;
        List list2;
        h hVar;
        int i6 = i5;
        String str2 = (i6 & 4) != 0 ? "" : str;
        String str3 = (i6 & 8) != 0 ? "" : null;
        Integer num5 = (i6 & 16) != 0 ? null : num;
        Integer num6 = (i6 & 32) != 0 ? null : num2;
        Integer num7 = (i6 & 64) != 0 ? null : num3;
        Integer num8 = (i6 & 128) != 0 ? null : num4;
        Typeface typeface4 = (i6 & 256) != 0 ? null : typeface;
        if ((i6 & 512) != 0) {
            typeface3 = null;
            list2 = list;
            bVar2 = bVar;
            hVar = this;
        } else {
            typeface3 = typeface2;
            hVar = this;
            list2 = list;
            bVar2 = bVar;
        }
        new h(list2, bVar2, str2, str3, num5, num6, num7, num8, typeface4, typeface3);
    }

    public final void a() {
        this.f884a.add(0, new i(new e(), (Boolean) null, l.DESCRIPTION, (k) null, (String) null, (Integer) null, 122));
    }

    public final int getItemCount() {
        return this.f884a.size();
    }

    public final int getItemViewType(int i5) {
        return ((i) this.f884a.get(i5)).f896c.f920a;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) {
        t.e(viewHolder, "holder");
        if (viewHolder instanceof g) {
            ((g) viewHolder).c((i) this.f884a.get(i5), this.f887d);
        } else if (viewHolder instanceof c) {
            ((c) viewHolder).a(this.f886c);
        } else if (viewHolder instanceof d) {
            d dVar = (d) viewHolder;
            String str = ((i) this.f884a.get(i5)).f899f;
            dVar.getClass();
            t.e(str, "labelText");
            TextView textView = dVar.f868d;
            textView.setText(str);
            Integer num = dVar.f865a;
            if (num != null) {
                textView.setTextColor(num.intValue());
            }
            Typeface typeface = dVar.f867c;
            if (typeface != null) {
                textView.setTypeface(typeface);
            }
            Integer num2 = dVar.f866b;
            if (num2 != null) {
                dVar.f869e.setBackgroundColor(num2.intValue());
            }
        } else if (viewHolder instanceof a) {
            a aVar = (a) viewHolder;
            String str2 = ((i) this.f884a.get(i5)).f899f;
            aVar.getClass();
            t.e(str2, "labelText");
            TextView textView2 = aVar.f859d;
            textView2.setText(str2);
            Integer num3 = aVar.f856a;
            if (num3 != null) {
                textView2.setTextColor(num3.intValue());
            }
            Typeface typeface2 = aVar.f858c;
            if (typeface2 != null) {
                textView2.setTypeface(typeface2);
            }
            Integer num4 = aVar.f857b;
            if (num4 != null) {
                aVar.f860e.setBackgroundColor(num4.intValue());
            }
        }
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "parent");
        if (i5 == 1) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(c.list_item_switch_description, viewGroup, false);
            t.d(inflate, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
            return new c(inflate, this.f888e, this.f891h, this.f893j);
        } else if (i5 == 2) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(c.list_item_switch_label, viewGroup, false);
            t.d(inflate2, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
            return new d(inflate2, this.f888e, this.f891h, this.f892i);
        } else if (i5 == 3) {
            View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(c.list_item_non_switch, viewGroup, false);
            t.d(inflate3, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
            return new a(inflate3, this.f888e, this.f891h, this.f893j);
        } else {
            View inflate4 = LayoutInflater.from(viewGroup.getContext()).inflate(c.list_item_switch, viewGroup, false);
            t.d(inflate4, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
            return new g(inflate4, this.f885b, this.f888e, this.f889f, this.f890g, this.f891h, this.f893j);
        }
    }

    public final void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        t.e(viewHolder, "holder");
        if (viewHolder instanceof g) {
            ((g) viewHolder).f882h.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        }
        super.onViewRecycled(viewHolder);
    }

    public h(List list, b bVar, String str, String str2, Integer num, Integer num2, Integer num3, Integer num4, Typeface typeface, Typeface typeface2) {
        t.e(list, "switchItems");
        t.e(bVar, "listener");
        t.e(str, "descriptionItemText");
        t.e(str2, "switchTagText");
        this.f884a = list;
        this.f885b = bVar;
        this.f886c = str;
        this.f887d = str2;
        this.f888e = num;
        this.f889f = num2;
        this.f890g = num3;
        this.f891h = num4;
        this.f892i = typeface;
        this.f893j = typeface2;
        if (str.length() > 0) {
            a();
        }
    }
}
