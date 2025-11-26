package Z;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;

public abstract class g extends ContextCompat {
    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        int i5;
        if (!e.a()) {
            return context.registerReceiver(broadcastReceiver, intentFilter);
        }
        if (true != e.a()) {
            i5 = 0;
        } else {
            i5 = 2;
        }
        return context.registerReceiver(broadcastReceiver, intentFilter, i5);
    }
}
