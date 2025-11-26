package com.mbridge.msdk.video.module.a.a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.ae;

public final class j extends e {

    /* renamed from: a  reason: collision with root package name */
    private int f12580a;

    public j(ImageView imageView, int i5) {
        super(imageView);
        this.f12580a = i5;
    }

    public final void onSuccessLoad(Bitmap bitmap, String str) {
        Bitmap a5;
        if (bitmap != null) {
            try {
                if (this.f12574b != null && !bitmap.isRecycled() && (a5 = ae.a(bitmap, 1, this.f12580a)) != null) {
                    this.f12574b.setImageBitmap(a5);
                }
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
            }
        }
    }
}
