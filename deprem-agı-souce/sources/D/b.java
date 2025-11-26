package d;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import d.a;

public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final boolean f923a = false;

    /* renamed from: b  reason: collision with root package name */
    final Handler f924b = null;

    /* renamed from: c  reason: collision with root package name */
    a f925c;

    class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* renamed from: b */
        public b[] newArray(int i5) {
            return new b[i5];
        }
    }

    /* renamed from: d.b$b  reason: collision with other inner class name */
    class C0020b extends a.C0018a {
        C0020b() {
        }

        public void o0(int i5, Bundle bundle) {
            b bVar = b.this;
            Handler handler = bVar.f924b;
            if (handler != null) {
                handler.post(new c(i5, bundle));
            } else {
                bVar.a(i5, bundle);
            }
        }
    }

    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final int f927a;

        /* renamed from: b  reason: collision with root package name */
        final Bundle f928b;

        c(int i5, Bundle bundle) {
            this.f927a = i5;
            this.f928b = bundle;
        }

        public void run() {
            b.this.a(this.f927a, this.f928b);
        }
    }

    b(Parcel parcel) {
        this.f925c = a.C0018a.i(parcel.readStrongBinder());
    }

    public void b(int i5, Bundle bundle) {
        if (this.f923a) {
            Handler handler = this.f924b;
            if (handler != null) {
                handler.post(new c(i5, bundle));
            } else {
                a(i5, bundle);
            }
        } else {
            a aVar = this.f925c;
            if (aVar != null) {
                try {
                    aVar.o0(i5, bundle);
                } catch (RemoteException unused) {
                }
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        synchronized (this) {
            try {
                if (this.f925c == null) {
                    this.f925c = new C0020b();
                }
                parcel.writeStrongBinder(this.f925c.asBinder());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i5, Bundle bundle) {
    }
}
