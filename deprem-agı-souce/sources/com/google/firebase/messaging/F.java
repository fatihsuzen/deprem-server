package com.google.firebase.messaging;

import N.C0722p;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import k0.C1698l;
import k0.C1699m;

public class F implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final URL f7275a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Future f7276b;

    /* renamed from: c  reason: collision with root package name */
    private C1698l f7277c;

    private F(URL url) {
        this.f7275a = url;
    }

    public static /* synthetic */ void a(F f5, C1699m mVar) {
        f5.getClass();
        try {
            mVar.c(f5.d());
        } catch (Exception e5) {
            mVar.b(e5);
        }
    }

    private byte[] l() {
        URLConnection openConnection = this.f7275a.openConnection();
        if (openConnection.getContentLength() <= 1048576) {
            InputStream inputStream = openConnection.getInputStream();
            try {
                byte[] d5 = C1553b.d(C1553b.b(inputStream, 1048577));
                if (inputStream != null) {
                    inputStream.close();
                }
                if (Log.isLoggable("FirebaseMessaging", 2)) {
                    Log.v("FirebaseMessaging", "Downloaded " + d5.length + " bytes from " + this.f7275a);
                }
                if (d5.length <= 1048576) {
                    return d5;
                }
                throw new IOException("Image exceeds max size of 1048576");
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            throw new IOException("Content-Length exceeds max size of 1048576");
        }
        throw th;
    }

    public static F m(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new F(new URL(str));
        } catch (MalformedURLException unused) {
            Log.w("FirebaseMessaging", "Not downloading image, bad URL: " + str);
            return null;
        }
    }

    public void close() {
        this.f7276b.cancel(true);
    }

    public Bitmap d() {
        if (Log.isLoggable("FirebaseMessaging", 4)) {
            Log.i("FirebaseMessaging", "Starting download of: " + this.f7275a);
        }
        byte[] l5 = l();
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(l5, 0, l5.length);
        if (decodeByteArray != null) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Successfully downloaded image: " + this.f7275a);
            }
            return decodeByteArray;
        }
        throw new IOException("Failed to decode image: " + this.f7275a);
    }

    public C1698l n() {
        return (C1698l) C0722p.k(this.f7277c);
    }

    public void o(ExecutorService executorService) {
        C1699m mVar = new C1699m();
        this.f7276b = executorService.submit(new E(this, mVar));
        this.f7277c = mVar.a();
    }
}
