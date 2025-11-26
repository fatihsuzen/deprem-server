package com.google.firebase.messaging;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.firebase.messaging.e  reason: case insensitive filesystem */
public abstract class C1556e {

    /* renamed from: a  reason: collision with root package name */
    public static final long f7404a = TimeUnit.MINUTES.toMillis(3);

    /* renamed from: com.google.firebase.messaging.e$a */
    public static final class a {
        public static ArrayMap a(Bundle bundle) {
            ArrayMap arrayMap = new ArrayMap();
            for (String next : bundle.keySet()) {
                Object obj = bundle.get(next);
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (!next.startsWith("google.") && !next.startsWith("gcm.") && !next.equals(TypedValues.TransitionType.S_FROM) && !next.equals("message_type") && !next.equals("collapse_key")) {
                        arrayMap.put(next, str);
                    }
                }
            }
            return arrayMap;
        }
    }
}
