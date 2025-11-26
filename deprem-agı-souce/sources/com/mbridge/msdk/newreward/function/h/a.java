package com.mbridge.msdk.newreward.function.h;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;

public final class a {

    /* renamed from: com.mbridge.msdk.newreward.function.h.a$a  reason: collision with other inner class name */
    public interface C0104a {
        void blurFailCallBack();

        void blurSuccessCallBack(Bitmap bitmap);
    }

    /* access modifiers changed from: private */
    @TargetApi(17)
    public static Bitmap b(Bitmap bitmap) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_4444);
            RenderScript create = RenderScript.create(c.m().c());
            ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
            Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap);
            Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
            create2.setRadius(25.0f);
            create2.setInput(createFromBitmap);
            create2.forEach(createFromBitmap2);
            createFromBitmap2.copyTo(createBitmap);
            create.destroy();
            return createBitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a(final Bitmap bitmap, final C0104a aVar) {
        try {
            com.mbridge.msdk.foundation.same.f.a.d().execute(new Runnable() {
                public final void run() {
                    if (aVar != null) {
                        try {
                            Bitmap a5 = a.b(bitmap);
                            if (a5 == null || a5.isRecycled()) {
                                aVar.blurFailCallBack();
                            } else {
                                aVar.blurSuccessCallBack(a5);
                            }
                        } catch (Exception unused) {
                            aVar.blurFailCallBack();
                        }
                    }
                }
            });
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }
}
