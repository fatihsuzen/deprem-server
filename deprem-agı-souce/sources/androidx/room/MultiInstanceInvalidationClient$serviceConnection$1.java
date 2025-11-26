package androidx.room;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import androidx.room.IMultiInstanceInvalidationService;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import kotlin.jvm.internal.t;

public final class MultiInstanceInvalidationClient$serviceConnection$1 implements ServiceConnection {
    final /* synthetic */ MultiInstanceInvalidationClient this$0;

    MultiInstanceInvalidationClient$serviceConnection$1(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        this.this$0 = multiInstanceInvalidationClient;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        t.e(componentName, RewardPlus.NAME);
        t.e(iBinder, NotificationCompat.CATEGORY_SERVICE);
        this.this$0.invalidationService = IMultiInstanceInvalidationService.Stub.asInterface(iBinder);
        this.this$0.registerCallback();
    }

    public void onServiceDisconnected(ComponentName componentName) {
        t.e(componentName, RewardPlus.NAME);
        this.this$0.invalidationService = null;
    }
}
