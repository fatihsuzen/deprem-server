package androidx.browser.customtabs;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.a;
import android.support.customtabs.d;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PostMessageService extends Service {
    private d.a mBinder = new d.a() {
        public void onMessageChannelReady(@NonNull a aVar, @Nullable Bundle bundle) throws RemoteException {
            aVar.onMessageChannelReady(bundle);
        }

        public void onPostMessage(@NonNull a aVar, @NonNull String str, @Nullable Bundle bundle) throws RemoteException {
            aVar.onPostMessage(str, bundle);
        }
    };

    @NonNull
    public IBinder onBind(@Nullable Intent intent) {
        return this.mBinder;
    }
}
