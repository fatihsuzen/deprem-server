package androidx.work.impl.utils;

import X2.C2250q;
import android.net.NetworkRequest;
import android.os.Build;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import kotlin.jvm.internal.t;

public final class NetworkRequestCompatKt {
    /* access modifiers changed from: private */
    public static final int[] defaultCapabilities = {13, 15, 14};

    @RequiresApi(28)
    public static final int[] getCapabilitiesCompat(NetworkRequest networkRequest) {
        t.e(networkRequest, "<this>");
        if (Build.VERSION.SDK_INT >= 31) {
            return NetworkRequest31.INSTANCE.capabilities(networkRequest);
        }
        int[] iArr = {17, 5, 2, 10, 29, 19, 3, 32, 7, 4, 12, 36, 23, 0, 33, 20, 11, 13, 18, 21, 15, 35, 34, 8, 1, 25, 14, 16, 6, 9};
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < 30; i5++) {
            int i6 = iArr[i5];
            if (NetworkRequest28.INSTANCE.hasCapability$work_runtime_release(networkRequest, i6)) {
                arrayList.add(Integer.valueOf(i6));
            }
        }
        return C2250q.m0(arrayList);
    }

    @RequiresApi(28)
    public static final int[] getTransportTypesCompat(NetworkRequest networkRequest) {
        t.e(networkRequest, "<this>");
        if (Build.VERSION.SDK_INT >= 31) {
            return NetworkRequest31.INSTANCE.transportTypes(networkRequest);
        }
        int[] iArr = {2, 0, 3, 6, 10, 9, 8, 4, 1, 5};
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < 10; i5++) {
            int i6 = iArr[i5];
            if (NetworkRequest28.INSTANCE.hasTransport$work_runtime_release(networkRequest, i6)) {
                arrayList.add(Integer.valueOf(i6));
            }
        }
        return C2250q.m0(arrayList);
    }
}
