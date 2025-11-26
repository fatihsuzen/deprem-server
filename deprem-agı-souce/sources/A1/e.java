package A1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import u1.g;
import u1.j;

public abstract class e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static j f2289a = j.UNKNOWN;

    class a extends BroadcastReceiver {
        a() {
        }

        public void onReceive(Context context, Intent intent) {
            j jVar;
            if (intent.getAction() == "android.media.action.HDMI_AUDIO_PLUG") {
                int intExtra = intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", -1);
                if (intExtra == 0) {
                    jVar = j.NOT_DETECTED;
                } else if (intExtra == 1) {
                    jVar = j.UNKNOWN;
                } else {
                    return;
                }
                j unused = e.f2289a = jVar;
            }
        }
    }

    public static j a() {
        if (a.a() != g.CTV) {
            return j.UNKNOWN;
        }
        return f2289a;
    }

    public static void c(Context context) {
        context.registerReceiver(new a(), new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
    }
}
