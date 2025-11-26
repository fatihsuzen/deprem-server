package c;

import android.widget.CompoundButton;

public final /* synthetic */ class f implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i f872a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f873b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f874c;

    public /* synthetic */ f(i iVar, g gVar, String str) {
        this.f872a = iVar;
        this.f873b = gVar;
        this.f874c = str;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        g.b(this.f872a, this.f873b, this.f874c, compoundButton, z4);
    }
}
