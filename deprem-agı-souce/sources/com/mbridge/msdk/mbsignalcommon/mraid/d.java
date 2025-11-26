package com.mbridge.msdk.mbsignalcommon.mraid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.lang.ref.WeakReference;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static double f10172a = -1.0d;

    /* renamed from: b  reason: collision with root package name */
    private Context f10173b;

    /* renamed from: c  reason: collision with root package name */
    private AudioManager f10174c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f10175d = false;

    /* renamed from: e  reason: collision with root package name */
    private b f10176e;

    /* renamed from: f  reason: collision with root package name */
    private a f10177f;

    private static class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<d> f10178a;

        public a(d dVar) {
            this.f10178a = new WeakReference<>(dVar);
        }

        public final void onReceive(Context context, Intent intent) {
            d dVar;
            b b5;
            if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3 && (dVar = this.f10178a.get()) != null && (b5 = dVar.b()) != null) {
                double a5 = dVar.a();
                if (a5 >= 0.0d) {
                    b5.a(a5);
                }
            }
        }
    }

    public interface b {
        void a(double d5);
    }

    public d(Context context) {
        this.f10173b = context;
        this.f10174c = (AudioManager) context.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
    }

    public final double a() {
        AudioManager audioManager = this.f10174c;
        int i5 = -1;
        int streamMaxVolume = audioManager != null ? audioManager.getStreamMaxVolume(3) : -1;
        AudioManager audioManager2 = this.f10174c;
        if (audioManager2 != null) {
            i5 = audioManager2.getStreamVolume(3);
        }
        double d5 = (((double) i5) * 100.0d) / ((double) streamMaxVolume);
        f10172a = d5;
        return d5;
    }

    public final b b() {
        return this.f10176e;
    }

    public final void c() {
        if (this.f10173b != null) {
            this.f10177f = new a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            this.f10173b.registerReceiver(this.f10177f, intentFilter);
            this.f10175d = true;
        }
    }

    public final void d() {
        Context context;
        if (this.f10175d && (context = this.f10173b) != null) {
            try {
                context.unregisterReceiver(this.f10177f);
                this.f10176e = null;
                this.f10175d = false;
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public final void a(b bVar) {
        this.f10176e = bVar;
    }
}
