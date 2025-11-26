package com.mbridge.msdk.foundation.tools;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

public final class b {

    public final class a {

        /* renamed from: b  reason: collision with root package name */
        private final String f9672b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f9673c;

        a(String str, boolean z4) {
            this.f9672b = str;
            this.f9673c = z4;
        }

        public final String a() {
            return this.f9672b;
        }

        public final boolean b() {
            return this.f9673c;
        }
    }

    /* renamed from: com.mbridge.msdk.foundation.tools.b$b  reason: collision with other inner class name */
    private final class C0091b implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        boolean f9674a;

        /* renamed from: c  reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f9676c;

        private C0091b() {
            this.f9676c = new LinkedBlockingQueue<>(1);
            this.f9674a = false;
        }

        public final IBinder a() throws InterruptedException {
            if (!this.f9674a) {
                this.f9674a = true;
                return this.f9676c.take();
            }
            throw new IllegalStateException();
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f9676c.put(iBinder);
            } catch (InterruptedException e5) {
                af.b("AdvertisingIdClient", e5.getMessage());
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public final a a(Context context) throws Exception {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            C0091b bVar = new C0091b();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (context.bindService(intent, bVar, 1)) {
                try {
                    c cVar = new c(bVar.a());
                    a aVar = new a(cVar.a(), cVar.a(true));
                    context.unbindService(bVar);
                    return aVar;
                } catch (Exception e5) {
                    throw e5;
                } catch (Throwable th) {
                    context.unbindService(bVar);
                    throw th;
                }
            } else {
                throw new IOException("Google Play connection failed");
            }
        } else {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
    }

    private final class c implements IInterface {

        /* renamed from: b  reason: collision with root package name */
        private IBinder f9678b;

        public c(IBinder iBinder) {
            this.f9678b = iBinder;
        }

        /* JADX INFO: finally extract failed */
        public final String a() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f9678b.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                obtain2.recycle();
                obtain.recycle();
                return readString;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                throw th;
            }
        }

        public final IBinder asBinder() {
            return this.f9678b;
        }

        public final boolean a(boolean z4) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            boolean z5 = false;
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(z4 ? 1 : 0);
                this.f9678b.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() != 0) {
                    z5 = true;
                }
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                throw th;
            }
            obtain2.recycle();
            obtain.recycle();
            return z5;
        }
    }
}
