package com.uptodown.activities;

import O1.C0754c0;
import O1.C0763d0;
import O1.C0771e0;
import O1.C0779f0;
import O1.C0787g0;
import O1.C0795h0;
import O1.C0803i0;
import O1.C0811j0;
import O1.C0819k0;
import O1.C0827l0;
import S1.k;
import W2.C2223l;
import W2.m;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import com.inmobi.cmp.ChoiceCmp;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.preferences.a;
import h2.z1;
import kotlin.jvm.internal.t;
import z2.C2962v;
import z2.F;
import z2.Y;

public final class GdprPrivacySettings extends C1598a {

    /* renamed from: K  reason: collision with root package name */
    private final C2223l f13764K = m.b(new C0754c0(this));

    private final void A3() {
        boolean isChecked = q3().f23715m.isChecked();
        a.C0147a aVar = a.f15150a;
        if (aVar.Q(this) != isChecked) {
            aVar.w0(this, isChecked);
        }
        boolean isChecked2 = q3().f23713k.isChecked();
        if (aVar.O(this) != isChecked2) {
            aVar.r0(this, isChecked2);
        }
        boolean isChecked3 = q3().f23714l.isChecked();
        if (aVar.k0(this) != isChecked3) {
            aVar.o1(this, isChecked3);
        }
        F f5 = new F(this);
        if (aVar.k0(this)) {
            UptodownApp.a aVar2 = UptodownApp.f13477F;
            UptodownApp.a.O0(aVar2, this, false, 2, (Object) null);
            aVar2.I(this);
            f5.b();
            setResult(-1);
            return;
        }
        setResult(0);
    }

    private final void B3() {
        if (q3().f23718p.getVisibility() == 0) {
            q3().f23716n.setText(R.string.save);
            q3().f23716n.setOnClickListener(new C0827l0(this));
            q3().f23718p.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public static final void C3(GdprPrivacySettings gdprPrivacySettings, View view) {
        gdprPrivacySettings.A3();
        gdprPrivacySettings.finish();
    }

    private final void D3(SwitchCompat switchCompat, TextView textView, boolean z4) {
        if (z4) {
            switchCompat.setTextColor(ContextCompat.getColor(this, R.color.text_primary));
            textView.setTextColor(ContextCompat.getColor(this, R.color.text_primary));
            return;
        }
        switchCompat.setTextColor(ContextCompat.getColor(this, R.color.main_light_grey));
        textView.setTextColor(ContextCompat.getColor(this, R.color.main_light_grey));
    }

    /* access modifiers changed from: private */
    public static final z1 p3(GdprPrivacySettings gdprPrivacySettings) {
        return z1.c(gdprPrivacySettings.getLayoutInflater());
    }

    private final z1 q3() {
        return (z1) this.f13764K.getValue();
    }

    /* access modifiers changed from: private */
    public static final void r3(GdprPrivacySettings gdprPrivacySettings, View view) {
        gdprPrivacySettings.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final void s3(GdprPrivacySettings gdprPrivacySettings, CompoundButton compoundButton, boolean z4) {
        SwitchCompat switchCompat = gdprPrivacySettings.q3().f23713k;
        t.d(switchCompat, "sAnalyticsWizardPrivacy");
        TextView textView = gdprPrivacySettings.q3().f23720r;
        t.d(textView, "tvDescriptionAnalyticsWizardPrivacy");
        gdprPrivacySettings.D3(switchCompat, textView, z4);
        gdprPrivacySettings.B3();
    }

    /* access modifiers changed from: private */
    public static final void t3(GdprPrivacySettings gdprPrivacySettings, CompoundButton compoundButton, boolean z4) {
        SwitchCompat switchCompat = gdprPrivacySettings.q3().f23715m;
        t.d(switchCompat, "sErrorLogWizardPrivacy");
        TextView textView = gdprPrivacySettings.q3().f23722t;
        t.d(textView, "tvDescriptionErrorLogWizardPrivacy");
        gdprPrivacySettings.D3(switchCompat, textView, z4);
        gdprPrivacySettings.B3();
    }

    /* access modifiers changed from: private */
    public static final void u3(GdprPrivacySettings gdprPrivacySettings, View view) {
        gdprPrivacySettings.z3();
    }

    /* access modifiers changed from: private */
    public static final void v3(GdprPrivacySettings gdprPrivacySettings, CompoundButton compoundButton, boolean z4) {
        SwitchCompat switchCompat = gdprPrivacySettings.q3().f23714l;
        t.d(switchCompat, "sDeviceAnalysisWizardPrivacy");
        TextView textView = gdprPrivacySettings.q3().f23721s;
        t.d(textView, "tvDescriptionDeviceAnalysisWizardPrivacy");
        gdprPrivacySettings.D3(switchCompat, textView, z4);
        gdprPrivacySettings.B3();
        if (!gdprPrivacySettings.q3().f23714l.isChecked()) {
            gdprPrivacySettings.q3().f23702C.setVisibility(0);
        } else {
            gdprPrivacySettings.q3().f23702C.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public static final void w3(GdprPrivacySettings gdprPrivacySettings, View view) {
        if (!gdprPrivacySettings.isFinishing()) {
            C2962v vVar = new C2962v();
            String string = gdprPrivacySettings.getString(R.string.url_contact);
            t.d(string, "getString(...)");
            C2962v.u(vVar, gdprPrivacySettings, string, (String) null, 4, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void x3(GdprPrivacySettings gdprPrivacySettings, View view) {
        new Y().a(gdprPrivacySettings, true);
        new Y().b(false);
        gdprPrivacySettings.q3().f23714l.setChecked(true);
        gdprPrivacySettings.q3().f23713k.setChecked(true);
        gdprPrivacySettings.q3().f23715m.setChecked(true);
        gdprPrivacySettings.A3();
        gdprPrivacySettings.finish();
    }

    /* access modifiers changed from: private */
    public static final void y3(GdprPrivacySettings gdprPrivacySettings, View view) {
        gdprPrivacySettings.B3();
        gdprPrivacySettings.q3().f23714l.setChecked(false);
        gdprPrivacySettings.q3().f23713k.setChecked(false);
        gdprPrivacySettings.q3().f23715m.setChecked(false);
    }

    private final void z3() {
        ChoiceCmp.forceDisplayUI(this);
        ChoiceCmp.showUSRegulationScreen(this);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) q3().getRoot());
        q3().f23704b.setOnClickListener(new C0763d0(this));
        TextView textView = q3().f23724v;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        q3().f23701B.setTypeface(aVar.w());
        q3().f23717o.setTypeface(aVar.x());
        q3().f23727y.setTypeface(aVar.w());
        q3().f23721s.setTypeface(aVar.x());
        q3().f23726x.setTypeface(aVar.w());
        q3().f23720r.setTypeface(aVar.x());
        q3().f23728z.setTypeface(aVar.w());
        q3().f23722t.setTypeface(aVar.x());
        q3().f23725w.setTypeface(aVar.w());
        q3().f23719q.setTypeface(aVar.x());
        q3().f23700A.setTypeface(aVar.w());
        q3().f23723u.setTypeface(aVar.x());
        q3().f23716n.setTypeface(aVar.w());
        q3().f23718p.setTypeface(aVar.w());
        TextView textView2 = q3().f23702C;
        textView2.setText("⚠ " + getString(R.string.tracking_disabled_warning_gdpr) + " ⚠");
        q3().f23702C.setTypeface(aVar.x());
        SwitchCompat switchCompat = q3().f23713k;
        a.C0147a aVar2 = a.f15150a;
        switchCompat.setChecked(aVar2.O(this));
        q3().f23715m.setChecked(aVar2.Q(this));
        q3().f23714l.setChecked(aVar2.k0(this));
        if (aVar2.V(this)) {
            SwitchCompat switchCompat2 = q3().f23713k;
            t.d(switchCompat2, "sAnalyticsWizardPrivacy");
            TextView textView3 = q3().f23720r;
            t.d(textView3, "tvDescriptionAnalyticsWizardPrivacy");
            D3(switchCompat2, textView3, q3().f23713k.isChecked());
            SwitchCompat switchCompat3 = q3().f23715m;
            t.d(switchCompat3, "sErrorLogWizardPrivacy");
            TextView textView4 = q3().f23722t;
            t.d(textView4, "tvDescriptionErrorLogWizardPrivacy");
            D3(switchCompat3, textView4, q3().f23715m.isChecked());
            SwitchCompat switchCompat4 = q3().f23714l;
            t.d(switchCompat4, "sDeviceAnalysisWizardPrivacy");
            TextView textView5 = q3().f23721s;
            t.d(textView5, "tvDescriptionDeviceAnalysisWizardPrivacy");
            D3(switchCompat4, textView5, q3().f23714l.isChecked());
        } else {
            SwitchCompat switchCompat5 = q3().f23713k;
            t.d(switchCompat5, "sAnalyticsWizardPrivacy");
            TextView textView6 = q3().f23720r;
            t.d(textView6, "tvDescriptionAnalyticsWizardPrivacy");
            D3(switchCompat5, textView6, true);
            SwitchCompat switchCompat6 = q3().f23715m;
            t.d(switchCompat6, "sErrorLogWizardPrivacy");
            TextView textView7 = q3().f23722t;
            t.d(textView7, "tvDescriptionErrorLogWizardPrivacy");
            D3(switchCompat6, textView7, true);
            SwitchCompat switchCompat7 = q3().f23714l;
            t.d(switchCompat7, "sDeviceAnalysisWizardPrivacy");
            TextView textView8 = q3().f23721s;
            t.d(textView8, "tvDescriptionDeviceAnalysisWizardPrivacy");
            D3(switchCompat7, textView8, true);
            q3().f23713k.setChecked(true);
            q3().f23715m.setChecked(true);
            q3().f23714l.setChecked(true);
        }
        if (!q3().f23714l.isChecked()) {
            q3().f23702C.setVisibility(0);
        } else {
            q3().f23702C.setVisibility(8);
        }
        q3().f23713k.setOnCheckedChangeListener(new C0771e0(this));
        q3().f23715m.setOnCheckedChangeListener(new C0779f0(this));
        q3().f23706d.setOnClickListener(new C0787g0(this));
        q3().f23714l.setOnCheckedChangeListener(new C0795h0(this));
        q3().f23711i.setOnClickListener(new C0803i0(this));
        q3().f23716n.setOnClickListener(new C0811j0(this));
        q3().f23718p.setOnClickListener(new C0819k0(this));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        a.C0147a aVar = a.f15150a;
        if (!aVar.V(this)) {
            aVar.H0(this, true);
            aVar.r0(this, true);
            aVar.w0(this, true);
            aVar.o1(this, true);
        }
    }
}
