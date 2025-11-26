package com.google.android.gms.measurement;

import android.content.Context;
import android.content.Intent;
import androidx.legacy.content.WakefulBroadcastReceiver;
import f0.C1659n;
import f0.C1660o;

public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements C1659n {

    /* renamed from: a  reason: collision with root package name */
    private C1660o f5717a;

    public void a(Context context, Intent intent) {
        WakefulBroadcastReceiver.startWakefulService(context, intent);
    }

    public void onReceive(Context context, Intent intent) {
        if (this.f5717a == null) {
            this.f5717a = new C1660o(this);
        }
        this.f5717a.a(context, intent);
    }
}
