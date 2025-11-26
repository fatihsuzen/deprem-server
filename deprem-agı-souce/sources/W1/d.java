package w1;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

public final class d extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private final Context f16758a;

    /* renamed from: b  reason: collision with root package name */
    private final AudioManager f16759b;

    /* renamed from: c  reason: collision with root package name */
    private final a f16760c;

    /* renamed from: d  reason: collision with root package name */
    private final c f16761d;

    /* renamed from: e  reason: collision with root package name */
    private float f16762e;

    public d(Handler handler, Context context, a aVar, c cVar) {
        super(handler);
        this.f16758a = context;
        this.f16759b = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.f16760c = aVar;
        this.f16761d = cVar;
    }

    private float a() {
        return this.f16760c.a(this.f16759b.getStreamVolume(3), this.f16759b.getStreamMaxVolume(3));
    }

    private boolean b(float f5) {
        if (f5 != this.f16762e) {
            return true;
        }
        return false;
    }

    private void c() {
        this.f16761d.a(this.f16762e);
    }

    public void d() {
        this.f16762e = a();
        c();
        this.f16758a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public void e() {
        this.f16758a.getContentResolver().unregisterContentObserver(this);
    }

    public void onChange(boolean z4) {
        super.onChange(z4);
        float a5 = a();
        if (b(a5)) {
            this.f16762e = a5;
            c();
        }
    }
}
