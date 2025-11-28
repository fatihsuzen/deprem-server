package com.finazzi.distquake;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.appcompat.app.C0768d;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.C0832r0;
import com.google.android.gms.ads.RequestConfiguration;
import d7.d;
import d7.e;
import org.achartengine.a;
import org.achartengine.b;

public class ChartWaveActivity extends C0768d {

    /* renamed from: O  reason: collision with root package name */
    private double f12530O = 0.0d;

    /* renamed from: P  reason: collision with root package name */
    private b f12531P;

    /* renamed from: Q  reason: collision with root package name */
    private d f12532Q = new d();

    /* renamed from: R  reason: collision with root package name */
    private e7.d f12533R = new e7.d();

    /* renamed from: S  reason: collision with root package name */
    private e f12534S;

    /* renamed from: T  reason: collision with root package name */
    private e7.e f12535T;

    private void e0() {
        e eVar = new e(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        this.f12534S = eVar;
        this.f12532Q.a(eVar);
        e7.e eVar2 = new e7.e();
        this.f12535T = eVar2;
        eVar2.f(Color.rgb(255, 0, 0));
        this.f12535T.u((float) 2);
        this.f12533R.a(this.f12535T);
        this.f12533R.x1(Paint.Align.LEFT, 0);
        this.f12533R.x1(Paint.Align.RIGHT, 0);
        this.f12533R.p1(-16777216);
        this.f12533R.y1(0, -16777216);
        this.f12533R.s1(-this.f12530O);
        this.f12533R.q1(this.f12530O);
        this.f12533R.D1(false, false);
        this.f12533R.g1(false);
        float f8 = (float) 24;
        this.f12533R.T(f8);
        this.f12533R.c1(f8);
        this.f12533R.N(-16777216);
        this.f12533R.S(-16777216);
        this.f12533R.M(true);
        this.f12533R.O(Color.rgb(221, 221, 221));
        this.f12533R.f1(Color.rgb(221, 221, 221));
        this.f12533R.d1(Color.rgb(150, 150, 150));
        this.f12533R.o1(0);
        this.f12533R.v1(10);
        this.f12533R.z1(8.0f);
        this.f12533R.V(new int[]{70, 112, 70, 70});
        this.f12533R.W(true);
        this.f12533R.X(true);
        this.f12533R.B1("[m/s²]");
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2030R.layout.userchart);
        int i8 = getResources().getConfiguration().uiMode & 48;
        if (Build.VERSION.SDK_INT >= 35 && i8 == 16) {
            Window window = getWindow();
            C0832r0.a(window, window.getDecorView()).d(true);
        }
        boolean z7 = getSharedPreferences(MainActivity.class.getSimpleName(), 0).getBoolean("pro_features", false);
        Toolbar toolbar = (Toolbar) findViewById(C2030R.id.toolbar);
        b0(toolbar);
        if (!z7) {
            toolbar.setLogo(2131230872);
        } else {
            toolbar.setLogo(2131230875);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        int i8;
        super.onResume();
        LinearLayout linearLayout = (LinearLayout) findViewById(C2030R.id.chart);
        b bVar = this.f12531P;
        if (bVar == null) {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                double[] doubleArray = extras.getDoubleArray("com.finazzi.distquake.measure_vector");
                String string = extras.getString("com.finazzi.distquake.time_firstMeasure");
                String string2 = extras.getString("com.finazzi.distquake.time_lastMeasure");
                if (doubleArray != null) {
                    i8 = doubleArray.length;
                } else {
                    i8 = 0;
                }
                double d8 = 0.0d;
                for (int i9 = 0; i9 < i8; i9++) {
                    d8 += doubleArray[i9];
                }
                double d9 = d8 / ((double) i8);
                for (int i10 = 0; i10 < i8; i10++) {
                    double d10 = doubleArray[i10] - d9;
                    doubleArray[i10] = d10;
                    if (Math.abs(d10) > this.f12530O) {
                        this.f12530O = Math.abs(doubleArray[i10]);
                    }
                }
                this.f12530O *= 1.15d;
                e0();
                if (doubleArray != null) {
                    for (int i11 = 0; i11 < i8; i11++) {
                        double d11 = (double) i11;
                        this.f12534S.a(d11, doubleArray[i11]);
                        if (i11 == 0) {
                            this.f12533R.d0(d11, string);
                        }
                        if (i11 == i8 - 1) {
                            this.f12533R.d0(d11, string2);
                        }
                    }
                    b b8 = a.b(this, this.f12532Q, this.f12533R);
                    this.f12531P = b8;
                    b8.setBackgroundColor(Color.rgb(221, 221, 221));
                    linearLayout.addView(this.f12531P);
                    return;
                }
                return;
            }
            return;
        }
        bVar.a();
    }
}
