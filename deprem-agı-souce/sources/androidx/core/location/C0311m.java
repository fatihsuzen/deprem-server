package androidx.core.location;

import android.location.Location;
import android.os.Bundle;
import java.util.List;

/* renamed from: androidx.core.location.m  reason: case insensitive filesystem */
public abstract /* synthetic */ class C0311m {
    public static void b(LocationListenerCompat locationListenerCompat, List list) {
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            locationListenerCompat.onLocationChanged((Location) list.get(i5));
        }
    }

    public static void a(LocationListenerCompat locationListenerCompat, int i5) {
    }

    public static void c(LocationListenerCompat locationListenerCompat, String str) {
    }

    public static void d(LocationListenerCompat locationListenerCompat, String str) {
    }

    public static void e(LocationListenerCompat locationListenerCompat, String str, int i5, Bundle bundle) {
    }
}
