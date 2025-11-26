package c;

import E1.b;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.t;

public final class g extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public final b f875a;

    /* renamed from: b  reason: collision with root package name */
    public final Integer f876b;

    /* renamed from: c  reason: collision with root package name */
    public final Integer f877c;

    /* renamed from: d  reason: collision with root package name */
    public final Integer f878d;

    /* renamed from: e  reason: collision with root package name */
    public final Integer f879e;

    /* renamed from: f  reason: collision with root package name */
    public final Typeface f880f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f881g;

    /* renamed from: h  reason: collision with root package name */
    public final SwitchCompat f882h;

    /* renamed from: i  reason: collision with root package name */
    public final View f883i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(View view, b bVar, Integer num, Integer num2, Integer num3, Integer num4, Typeface typeface) {
        super(view);
        t.e(view, "rootView");
        t.e(bVar, "listener");
        this.f875a = bVar;
        this.f876b = num;
        this.f877c = num2;
        this.f878d = num3;
        this.f879e = num4;
        this.f880f = typeface;
        View findViewById = view.findViewById(b.tv_switch_name);
        t.d(findViewById, "rootView.findViewById(R.id.tv_switch_name)");
        this.f881g = (TextView) findViewById;
        View findViewById2 = view.findViewById(b.switch_item);
        t.d(findViewById2, "rootView.findViewById(R.id.switch_item)");
        this.f882h = (SwitchCompat) findViewById2;
        View findViewById3 = view.findViewById(b.line_item);
        t.d(findViewById3, "rootView.findViewById(R.id.line_item)");
        this.f883i = findViewById3;
    }

    public static final void a(g gVar, i iVar, View view) {
        t.e(gVar, "this$0");
        t.e(iVar, "$switchItem");
        gVar.f875a.d(iVar);
    }

    public static final void b(i iVar, g gVar, String str, CompoundButton compoundButton, boolean z4) {
        t.e(iVar, "$switchItem");
        t.e(gVar, "this$0");
        t.e(str, "$tag");
        iVar.f895b = Boolean.valueOf(z4);
        gVar.f875a.e(iVar);
        boolean z5 = iVar.f898e;
        SwitchCompat switchCompat = gVar.f882h;
        if (switchCompat.isChecked() || !z5) {
            str = "";
        }
        switchCompat.setText(str);
    }

    public final void c(i iVar, String str) {
        String str2;
        boolean z4;
        t.e(iVar, "switchItem");
        t.e(str, "tag");
        TextView textView = this.f881g;
        textView.setText(l4.b.a(iVar.f894a.f18882b, iVar.f900g, iVar.f899f));
        Integer num = this.f876b;
        if (num != null) {
            textView.setTextColor(num.intValue());
        }
        textView.setOnClickListener(new e(this, iVar));
        Typeface typeface = this.f880f;
        if (typeface != null) {
            textView.setTypeface(typeface);
        }
        SwitchCompat switchCompat = this.f882h;
        if (iVar.f895b == null) {
            switchCompat.setVisibility(8);
        } else {
            switchCompat.setVisibility(0);
            Boolean bool = iVar.f895b;
            if (bool == null) {
                z4 = false;
            } else {
                z4 = bool.booleanValue();
            }
            switchCompat.setChecked(z4);
        }
        switchCompat.setContentDescription(iVar.f894a.f18882b);
        boolean z5 = iVar.f898e;
        SwitchCompat switchCompat2 = this.f882h;
        if (switchCompat2.isChecked() || !z5) {
            str2 = "";
        } else {
            str2 = str;
        }
        switchCompat2.setText(str2);
        switchCompat.setOnCheckedChangeListener(new f(iVar, this, str));
        Integer num2 = this.f877c;
        if (num2 != null) {
            int intValue = num2.intValue();
            Integer num3 = this.f878d;
            if (num3 != null) {
                int intValue2 = num3.intValue();
                switchCompat.setThumbTintList(new ColorStateList(new int[][]{new int[]{16842912}, new int[0]}, new int[]{intValue, intValue2}));
                switchCompat.setTrackTintList(new ColorStateList(new int[][]{new int[]{16842912}, new int[0]}, new int[]{ColorUtils.setAlphaComponent(intValue, 128), ColorUtils.setAlphaComponent(intValue2, 128)}));
            }
        }
        Integer num4 = this.f876b;
        if (num4 != null) {
            switchCompat.setTextColor(num4.intValue());
        }
        Typeface typeface2 = this.f880f;
        if (typeface2 != null) {
            switchCompat.setTypeface(typeface2);
        }
        Integer num5 = this.f879e;
        if (num5 != null) {
            this.f883i.setBackgroundColor(num5.intValue());
        }
    }
}
