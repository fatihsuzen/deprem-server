package z2;

import android.content.Context;
import android.view.View;
import z2.C2959s;

/* renamed from: z2.q  reason: case insensitive filesystem */
public final /* synthetic */ class C2958q implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f26551a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f26552b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f26553c;

    public /* synthetic */ C2958q(Context context, String str, View view) {
        this.f26551a = context;
        this.f26552b = str;
        this.f26553c = view;
    }

    public final void onClick(View view) {
        C2959s.a.e(this.f26551a, this.f26552b, this.f26553c, view);
    }
}
