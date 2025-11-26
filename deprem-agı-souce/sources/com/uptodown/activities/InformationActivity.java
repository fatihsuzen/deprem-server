package com.uptodown.activities;

import O1.C0835m0;
import O1.C0843n0;
import O1.C0851o0;
import S1.k;
import W2.C2223l;
import W2.m;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.uptodown.R;
import h2.C2402a0;
import kotlin.jvm.internal.t;
import l2.C2666o;
import z2.C2962v;

public final class InformationActivity extends C1598a {

    /* renamed from: K  reason: collision with root package name */
    private final C2223l f13767K = m.b(new C0851o0(this));

    /* access modifiers changed from: private */
    public static final C2402a0 i3(InformationActivity informationActivity) {
        return C2402a0.c(informationActivity.getLayoutInflater());
    }

    private final C2402a0 j3() {
        return (C2402a0) this.f13767K.getValue();
    }

    private final void k3() {
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            j3().f22742c.setNavigationIcon(drawable);
            j3().f22742c.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        j3().f22742c.setNavigationOnClickListener(new C0835m0(this));
        TextView textView = j3().f22749j;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        j3().f22743d.setTypeface(aVar.x());
        j3().f22744e.setTypeface(aVar.x());
        j3().f22745f.setTypeface(aVar.x());
        j3().f22747h.setTypeface(aVar.x());
        j3().f22748i.setTypeface(aVar.x());
        j3().f22746g.setTypeface(aVar.x());
        TextView textView2 = j3().f22746g;
        C2666o.a aVar2 = C2666o.f25106g;
        String string = getString(R.string.information_activity_dev_on_board_more_info);
        t.d(string, "getString(...)");
        textView2.setText(aVar2.h(this, string));
        j3().f22746g.setOnClickListener(new C0843n0(this));
    }

    /* access modifiers changed from: private */
    public static final void l3(InformationActivity informationActivity, View view) {
        informationActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void m3(InformationActivity informationActivity, View view) {
        String string = informationActivity.getString(R.string.url_dev_on_board);
        t.d(string, "getString(...)");
        String string2 = informationActivity.getString(R.string.support_title);
        t.d(string2, "getString(...)");
        new C2962v().t(informationActivity, string, string2);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) j3().getRoot());
        k3();
    }
}
