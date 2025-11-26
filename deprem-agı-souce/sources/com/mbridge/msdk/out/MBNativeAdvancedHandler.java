package com.mbridge.msdk.out;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.mbridge.msdk.advanced.b.c;
import com.mbridge.msdk.foundation.tools.ak;
import org.json.JSONObject;

public class MBNativeAdvancedHandler {
    private c nativeAdvancedProvider;

    /* renamed from: com.mbridge.msdk.out.MBNativeAdvancedHandler$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$mbridge$msdk$out$MBMultiStateEnum;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.mbridge.msdk.out.MBMultiStateEnum[] r0 = com.mbridge.msdk.out.MBMultiStateEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$mbridge$msdk$out$MBMultiStateEnum = r0
                com.mbridge.msdk.out.MBMultiStateEnum r1 = com.mbridge.msdk.out.MBMultiStateEnum.negative     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$mbridge$msdk$out$MBMultiStateEnum     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.out.MBMultiStateEnum r1 = com.mbridge.msdk.out.MBMultiStateEnum.positive     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$mbridge$msdk$out$MBMultiStateEnum     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mbridge.msdk.out.MBMultiStateEnum r1 = com.mbridge.msdk.out.MBMultiStateEnum.undefined     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.out.MBNativeAdvancedHandler.AnonymousClass1.<clinit>():void");
        }
    }

    public MBNativeAdvancedHandler(Activity activity, String str, String str2) {
        String e5 = ak.e(str2);
        if (!TextUtils.isEmpty(e5)) {
            ak.b(str2, e5);
        }
        this.nativeAdvancedProvider = new c(str, str2, activity);
    }

    public void autoLoopPlay(int i5) {
        c cVar = this.nativeAdvancedProvider;
        if (cVar != null) {
            cVar.c(i5);
        }
    }

    public ViewGroup getAdViewGroup() {
        c cVar = this.nativeAdvancedProvider;
        if (cVar != null) {
            return cVar.b();
        }
        return null;
    }

    public String getCreativeIdWithUnitId() {
        c cVar = this.nativeAdvancedProvider;
        if (cVar != null) {
            return cVar.e();
        }
        return "";
    }

    public String getRequestId() {
        c cVar = this.nativeAdvancedProvider;
        if (cVar != null) {
            return cVar.d();
        }
        return "";
    }

    public boolean isReady() {
        return isReady("");
    }

    public void load() {
        c cVar = this.nativeAdvancedProvider;
        if (cVar != null) {
            cVar.b("");
        }
    }

    public void loadByToken(String str) {
        c cVar = this.nativeAdvancedProvider;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    public void onPause() {
        c cVar = this.nativeAdvancedProvider;
        if (cVar != null) {
            cVar.e(3);
        }
    }

    public void onResume() {
        c cVar = this.nativeAdvancedProvider;
        if (cVar != null) {
            cVar.d(3);
        }
    }

    public void release() {
        c cVar = this.nativeAdvancedProvider;
        if (cVar != null) {
            cVar.f();
        }
    }

    public void setAdListener(NativeAdvancedAdListener nativeAdvancedAdListener) {
        c cVar = this.nativeAdvancedProvider;
        if (cVar != null) {
            cVar.a(nativeAdvancedAdListener);
        }
    }

    public void setCloseButtonState(MBMultiStateEnum mBMultiStateEnum) {
        int i5 = AnonymousClass1.$SwitchMap$com$mbridge$msdk$out$MBMultiStateEnum[mBMultiStateEnum.ordinal()];
        int i6 = 1;
        if (i5 == 1) {
            i6 = 0;
        } else if (i5 != 2) {
            i6 = -1;
        }
        this.nativeAdvancedProvider.a(i6);
    }

    public void setNativeViewSize(int i5, int i6) {
        this.nativeAdvancedProvider.a(i6, i5);
    }

    public void setPlayMuteState(int i5) {
        c cVar = this.nativeAdvancedProvider;
        if (cVar != null) {
            cVar.b(i5);
        }
    }

    public void setViewElementStyle(JSONObject jSONObject) {
        c cVar = this.nativeAdvancedProvider;
        if (cVar != null) {
            cVar.a(jSONObject);
        }
    }

    public boolean isReady(String str) {
        c cVar = this.nativeAdvancedProvider;
        if (cVar != null) {
            return cVar.c(str);
        }
        return false;
    }
}
