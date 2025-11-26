package com.mbridge.msdk.newreward.function.common;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.tools.FastKV;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class MBridgeSharedPreferenceModel {
    private static final String DEFAULT_NAME = "mbridge_new_config";
    private static final Map<String, MBridgeSharedPreferenceModel> mInstanceMap = new HashMap();
    private static final ConcurrentHashMap<String, Integer> mIntegerCache = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Long> mLongCache = new ConcurrentHashMap<>();
    private static final String mPath = (e.a(c.MBRIDGE_700_CONFIG) + File.separator);
    private static final ConcurrentHashMap<String, String> mStringCache = new ConcurrentHashMap<>();
    private volatile FastKV mFastKV;
    private final String mName;

    private MBridgeSharedPreferenceModel(String str) {
        this.mName = str;
        initFastKV();
    }

    public static MBridgeSharedPreferenceModel getInstance() {
        return getInstance("");
    }

    private int getIntegerValue(String str, int i5) {
        if (this.mFastKV == null) {
            initFastKV();
        }
        try {
            int i6 = this.mFastKV.getInt(str, i5);
            mIntegerCache.put(str, Integer.valueOf(i6));
            return i6;
        } catch (Exception unused) {
            return i5;
        }
    }

    private long getLongValue(String str, long j5) {
        if (this.mFastKV == null) {
            initFastKV();
        }
        try {
            long j6 = this.mFastKV.getLong(str, j5);
            mLongCache.put(str, Long.valueOf(j6));
            return j6;
        } catch (Exception unused) {
            return j5;
        }
    }

    private String getStringValue(String str, String str2) {
        if (this.mFastKV == null) {
            initFastKV();
        }
        String string = this.mFastKV.getString(str, str2);
        if (string != null) {
            mStringCache.put(str, string);
        }
        return string;
    }

    private void initFastKV() {
        if (this.mFastKV == null) {
            try {
                this.mFastKV = new FastKV.Builder(mPath, this.mName).build();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:0|1|2|3|5) */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0009 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void putIntegerValue(java.lang.String r3, int r4) {
        /*
            r2 = this;
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> r0 = mIntegerCache     // Catch:{ Exception -> 0x0009 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0009 }
            r0.put(r3, r1)     // Catch:{ Exception -> 0x0009 }
        L_0x0009:
            com.mbridge.msdk.foundation.tools.FastKV r0 = r2.mFastKV     // Catch:{ Exception -> 0x000e }
            r0.putInt(r3, r4)     // Catch:{ Exception -> 0x000e }
        L_0x000e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.common.MBridgeSharedPreferenceModel.putIntegerValue(java.lang.String, int):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:0|1|2|3|5) */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0009 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void putLongValue(java.lang.String r3, long r4) {
        /*
            r2 = this;
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> r0 = mLongCache     // Catch:{ Exception -> 0x0009 }
            java.lang.Long r1 = java.lang.Long.valueOf(r4)     // Catch:{ Exception -> 0x0009 }
            r0.put(r3, r1)     // Catch:{ Exception -> 0x0009 }
        L_0x0009:
            com.mbridge.msdk.foundation.tools.FastKV r0 = r2.mFastKV     // Catch:{ Exception -> 0x000e }
            r0.putLong(r3, r4)     // Catch:{ Exception -> 0x000e }
        L_0x000e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.common.MBridgeSharedPreferenceModel.putLongValue(java.lang.String, long):void");
    }

    private void putStringValue(String str, String str2) {
        try {
            mStringCache.put(str, str2);
            this.mFastKV.putString(str, str2);
        } catch (Exception unused) {
        }
    }

    public final void clear() {
        mStringCache.clear();
        mIntegerCache.clear();
        mLongCache.clear();
        if (this.mFastKV != null) {
            this.mFastKV.clear();
        }
    }

    public final int getInteger(String str, int i5) {
        Integer num;
        if (TextUtils.isEmpty(str)) {
            return i5;
        }
        ConcurrentHashMap<String, Integer> concurrentHashMap = mIntegerCache;
        if (!concurrentHashMap.containsKey(str) || (num = concurrentHashMap.get(str)) == null) {
            return getIntegerValue(str, i5);
        }
        return num.intValue();
    }

    public final long getLong(String str, long j5) {
        Long l5;
        if (TextUtils.isEmpty(str)) {
            return j5;
        }
        ConcurrentHashMap<String, Long> concurrentHashMap = mLongCache;
        if (!concurrentHashMap.containsKey(str) || (l5 = concurrentHashMap.get(str)) == null) {
            return getLongValue(str, j5);
        }
        return l5.longValue();
    }

    public final String getString(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        ConcurrentHashMap<String, String> concurrentHashMap = mStringCache;
        if (concurrentHashMap.containsKey(str)) {
            return concurrentHashMap.get(str);
        }
        return getStringValue(str, str2);
    }

    public final void init() {
    }

    public final void putInteger(String str, int i5) {
        if (!TextUtils.isEmpty(str)) {
            ConcurrentHashMap<String, Integer> concurrentHashMap = mIntegerCache;
            if (concurrentHashMap.containsKey(str)) {
                Integer num = concurrentHashMap.get(str);
                if (num == null || num.intValue() != i5) {
                    putIntegerValue(str, i5);
                    return;
                }
                return;
            }
            putIntegerValue(str, i5);
        }
    }

    public final void putLong(String str, long j5) {
        if (!TextUtils.isEmpty(str)) {
            ConcurrentHashMap<String, Long> concurrentHashMap = mLongCache;
            if (concurrentHashMap.containsKey(str)) {
                Long l5 = concurrentHashMap.get(str);
                if (l5 == null || l5.longValue() != j5) {
                    putLongValue(str, j5);
                    return;
                }
                return;
            }
            putLongValue(str, j5);
        }
    }

    public final void putString(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str2 != null) {
            ConcurrentHashMap<String, String> concurrentHashMap = mStringCache;
            if (!concurrentHashMap.containsKey(str)) {
                putStringValue(str, str2);
            } else if (!TextUtils.equals(concurrentHashMap.get(str), str2)) {
                putStringValue(str, str2);
            }
        }
    }

    public static MBridgeSharedPreferenceModel getInstance(String str) {
        MBridgeSharedPreferenceModel mBridgeSharedPreferenceModel;
        Map<String, MBridgeSharedPreferenceModel> map = mInstanceMap;
        synchronized (map) {
            try {
                if (TextUtils.isEmpty(str)) {
                    str = DEFAULT_NAME;
                }
                mBridgeSharedPreferenceModel = map.get(str);
                if (mBridgeSharedPreferenceModel == null) {
                    mBridgeSharedPreferenceModel = new MBridgeSharedPreferenceModel(str);
                    map.put(str, mBridgeSharedPreferenceModel);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return mBridgeSharedPreferenceModel;
    }
}
