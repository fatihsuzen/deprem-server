package k4;

import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.entity.CampaignEx;

public enum g {
    INIT("init"),
    NAVIGATION(NotificationCompat.CATEGORY_NAVIGATION),
    DONE("done"),
    NONE("none"),
    VISIT("visit"),
    CLICK(CampaignEx.JSON_NATIVE_VIDEO_CLICK);
    

    /* renamed from: a  reason: collision with root package name */
    public final String f24584a;

    /* access modifiers changed from: public */
    g(String str) {
        this.f24584a = str;
    }
}
