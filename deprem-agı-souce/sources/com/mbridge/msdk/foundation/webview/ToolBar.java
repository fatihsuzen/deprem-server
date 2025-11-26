package com.mbridge.msdk.foundation.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ToolBar extends LinearLayout {
    public ToolBar(Context context) {
        super(context);
        a();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0013 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x003e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0069 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0094 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a() {
        /*
            r6 = this;
            java.lang.String r0 = "drawable"
            r1 = 0
            r6.setOrientation(r1)
            android.content.Context r2 = r6.getContext()     // Catch:{ Exception -> 0x0013 }
            r3 = 1092616192(0x41200000, float:10.0)
            int r2 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r2, (float) r3)     // Catch:{ Exception -> 0x0013 }
            r6.setPadding(r1, r2, r1, r2)     // Catch:{ Exception -> 0x0013 }
        L_0x0013:
            android.view.View r1 = r6.b()     // Catch:{ Exception -> 0x003e }
            android.widget.ImageView r1 = (android.widget.ImageView) r1     // Catch:{ Exception -> 0x003e }
            java.lang.String r2 = "backward"
            r1.setTag(r2)     // Catch:{ Exception -> 0x003e }
            android.content.res.Resources r2 = r6.getResources()     // Catch:{ Exception -> 0x003e }
            android.content.res.Resources r3 = r6.getResources()     // Catch:{ Exception -> 0x003e }
            java.lang.String r4 = "mbridge_cm_backward"
            com.mbridge.msdk.foundation.controller.c r5 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x003e }
            java.lang.String r5 = r5.g()     // Catch:{ Exception -> 0x003e }
            int r3 = r3.getIdentifier(r4, r0, r5)     // Catch:{ Exception -> 0x003e }
            android.graphics.drawable.Drawable r2 = r2.getDrawable(r3)     // Catch:{ Exception -> 0x003e }
            r1.setImageDrawable(r2)     // Catch:{ Exception -> 0x003e }
            r6.addView(r1)     // Catch:{ Exception -> 0x003e }
        L_0x003e:
            android.view.View r1 = r6.b()     // Catch:{ Exception -> 0x0069 }
            android.widget.ImageView r1 = (android.widget.ImageView) r1     // Catch:{ Exception -> 0x0069 }
            java.lang.String r2 = "forward"
            r1.setTag(r2)     // Catch:{ Exception -> 0x0069 }
            android.content.res.Resources r2 = r6.getResources()     // Catch:{ Exception -> 0x0069 }
            android.content.res.Resources r3 = r6.getResources()     // Catch:{ Exception -> 0x0069 }
            java.lang.String r4 = "mbridge_cm_forward"
            com.mbridge.msdk.foundation.controller.c r5 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0069 }
            java.lang.String r5 = r5.g()     // Catch:{ Exception -> 0x0069 }
            int r3 = r3.getIdentifier(r4, r0, r5)     // Catch:{ Exception -> 0x0069 }
            android.graphics.drawable.Drawable r2 = r2.getDrawable(r3)     // Catch:{ Exception -> 0x0069 }
            r1.setImageDrawable(r2)     // Catch:{ Exception -> 0x0069 }
            r6.addView(r1)     // Catch:{ Exception -> 0x0069 }
        L_0x0069:
            android.view.View r1 = r6.b()     // Catch:{ Exception -> 0x0094 }
            android.widget.ImageView r1 = (android.widget.ImageView) r1     // Catch:{ Exception -> 0x0094 }
            java.lang.String r2 = "refresh"
            r1.setTag(r2)     // Catch:{ Exception -> 0x0094 }
            android.content.res.Resources r2 = r6.getResources()     // Catch:{ Exception -> 0x0094 }
            android.content.res.Resources r3 = r6.getResources()     // Catch:{ Exception -> 0x0094 }
            java.lang.String r4 = "mbridge_cm_refresh"
            com.mbridge.msdk.foundation.controller.c r5 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0094 }
            java.lang.String r5 = r5.g()     // Catch:{ Exception -> 0x0094 }
            int r3 = r3.getIdentifier(r4, r0, r5)     // Catch:{ Exception -> 0x0094 }
            android.graphics.drawable.Drawable r2 = r2.getDrawable(r3)     // Catch:{ Exception -> 0x0094 }
            r1.setImageDrawable(r2)     // Catch:{ Exception -> 0x0094 }
            r6.addView(r1)     // Catch:{ Exception -> 0x0094 }
        L_0x0094:
            android.view.View r1 = r6.b()     // Catch:{ Exception -> 0x00bf }
            android.widget.ImageView r1 = (android.widget.ImageView) r1     // Catch:{ Exception -> 0x00bf }
            java.lang.String r2 = "exits"
            r1.setTag(r2)     // Catch:{ Exception -> 0x00bf }
            android.content.res.Resources r2 = r6.getResources()     // Catch:{ Exception -> 0x00bf }
            android.content.res.Resources r3 = r6.getResources()     // Catch:{ Exception -> 0x00bf }
            java.lang.String r4 = "mbridge_cm_exits"
            com.mbridge.msdk.foundation.controller.c r5 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x00bf }
            java.lang.String r5 = r5.g()     // Catch:{ Exception -> 0x00bf }
            int r0 = r3.getIdentifier(r4, r0, r5)     // Catch:{ Exception -> 0x00bf }
            android.graphics.drawable.Drawable r0 = r2.getDrawable(r0)     // Catch:{ Exception -> 0x00bf }
            r1.setImageDrawable(r0)     // Catch:{ Exception -> 0x00bf }
            r6.addView(r1)     // Catch:{ Exception -> 0x00bf }
        L_0x00bf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.webview.ToolBar.a():void");
    }

    private View b() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        imageView.setLayoutParams(layoutParams);
        imageView.setClickable(true);
        return imageView;
    }

    public View getItem(String str) {
        return findViewWithTag(str);
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            getChildAt(i5).setOnClickListener(onClickListener);
        }
    }

    public ToolBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}
