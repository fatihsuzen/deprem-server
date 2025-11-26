package J;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;

public final class l implements Parcelable {
    public static final Parcelable.Creator<l> CREATOR = new j();

    /* renamed from: a  reason: collision with root package name */
    Messenger f2637a;

    public l(IBinder iBinder) {
        this.f2637a = new Messenger(iBinder);
    }

    public final IBinder a() {
        Messenger messenger = this.f2637a;
        messenger.getClass();
        return messenger.getBinder();
    }

    public final void b(Message message) {
        Messenger messenger = this.f2637a;
        messenger.getClass();
        messenger.send(message);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return a().equals(((l) obj).a());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public final int hashCode() {
        return a().hashCode();
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        Messenger messenger = this.f2637a;
        messenger.getClass();
        parcel.writeStrongBinder(messenger.getBinder());
    }
}
