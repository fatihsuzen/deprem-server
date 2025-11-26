package J;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import j$.util.Objects;

final class y {

    /* renamed from: a  reason: collision with root package name */
    private final Messenger f2662a;

    /* renamed from: b  reason: collision with root package name */
    private final l f2663b;

    y(IBinder iBinder) {
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if (Objects.equals(interfaceDescriptor, "android.os.IMessenger")) {
            this.f2662a = new Messenger(iBinder);
            this.f2663b = null;
        } else if (Objects.equals(interfaceDescriptor, "com.google.android.gms.iid.IMessengerCompat")) {
            this.f2663b = new l(iBinder);
            this.f2662a = null;
        } else {
            Log.w("MessengerIpcClient", "Invalid interface descriptor: ".concat(String.valueOf(interfaceDescriptor)));
            throw new RemoteException();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Message message) {
        Messenger messenger = this.f2662a;
        if (messenger != null) {
            messenger.send(message);
            return;
        }
        l lVar = this.f2663b;
        if (lVar != null) {
            lVar.b(message);
            return;
        }
        throw new IllegalStateException("Both messengers are null");
    }
}
