package com.mbridge.msdk.mbsignalcommon.commonwebview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.mbridge.msdk.foundation.controller.c;
import java.util.List;

public class ToolBar extends LinearLayout {
    public static final String BACKWARD = "backward";
    public static final String EXITS = "exits";
    public static final String FORWARD = "forward";
    public static final String OPEN_BY_BROWSER = "open_by_browser";
    public static final String REFRESH = "refresh";
    public String title;
    public TextView titleView;

    public static class a {

        /* renamed from: b  reason: collision with root package name */
        public static int f10150b = 40;

        /* renamed from: c  reason: collision with root package name */
        public static int f10151c = 10;

        /* renamed from: a  reason: collision with root package name */
        public int f10152a;
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f10153a;

        /* renamed from: b  reason: collision with root package name */
        public String f10154b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f10155c = true;

        /* renamed from: d  reason: collision with root package name */
        public View.OnClickListener f10156d;

        public b(String str) {
            this.f10153a = str;
        }
    }

    public ToolBar(Context context) {
        super(context);
        a();
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x001b */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0025 A[Catch:{ Exception -> 0x0077 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.a r8, java.util.List<com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.b> r9) {
        /*
            r7 = this;
            r8 = 0
            r7.setOrientation(r8)
            android.content.Context r0 = r7.getContext()     // Catch:{ Exception -> 0x001b }
            r1 = 1092616192(0x41200000, float:10.0)
            int r0 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r0, (float) r1)     // Catch:{ Exception -> 0x001b }
            android.content.Context r1 = r7.getContext()     // Catch:{ Exception -> 0x001b }
            r2 = 1101004800(0x41a00000, float:20.0)
            int r1 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r1, (float) r2)     // Catch:{ Exception -> 0x001b }
            r7.setPadding(r8, r0, r1, r0)     // Catch:{ Exception -> 0x001b }
        L_0x001b:
            java.util.Iterator r9 = r9.iterator()     // Catch:{ Exception -> 0x0077 }
        L_0x001f:
            boolean r0 = r9.hasNext()     // Catch:{ Exception -> 0x0077 }
            if (r0 == 0) goto L_0x0077
            java.lang.Object r0 = r9.next()     // Catch:{ Exception -> 0x0077 }
            com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar$b r0 = (com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.b) r0     // Catch:{ Exception -> 0x0077 }
            android.view.View r1 = r7.b()     // Catch:{ Exception -> 0x0077 }
            android.widget.ImageView r1 = (android.widget.ImageView) r1     // Catch:{ Exception -> 0x0077 }
            java.lang.String r2 = r0.f10153a     // Catch:{ Exception -> 0x0077 }
            r1.setTag(r2)     // Catch:{ Exception -> 0x0077 }
            android.content.res.Resources r2 = r7.getResources()     // Catch:{ Exception -> 0x0077 }
            android.content.res.Resources r3 = r7.getResources()     // Catch:{ Exception -> 0x0077 }
            java.lang.String r4 = r0.f10154b     // Catch:{ Exception -> 0x0077 }
            java.lang.String r5 = "drawable"
            com.mbridge.msdk.foundation.controller.c r6 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0077 }
            java.lang.String r6 = r6.g()     // Catch:{ Exception -> 0x0077 }
            int r3 = r3.getIdentifier(r4, r5, r6)     // Catch:{ Exception -> 0x0077 }
            android.graphics.drawable.Drawable r2 = r2.getDrawable(r3)     // Catch:{ Exception -> 0x0077 }
            r1.setImageDrawable(r2)     // Catch:{ Exception -> 0x0077 }
            android.widget.LinearLayout$LayoutParams r2 = new android.widget.LinearLayout$LayoutParams     // Catch:{ Exception -> 0x0077 }
            int r3 = com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.a.f10150b     // Catch:{ Exception -> 0x0077 }
            r4 = -1
            r2.<init>(r3, r4)     // Catch:{ Exception -> 0x0077 }
            r3 = 32
            r2.setMargins(r3, r8, r3, r8)     // Catch:{ Exception -> 0x0077 }
            r1.setLayoutParams(r2)     // Catch:{ Exception -> 0x0077 }
            android.view.View$OnClickListener r2 = r0.f10156d     // Catch:{ Exception -> 0x0077 }
            r1.setOnClickListener(r2)     // Catch:{ Exception -> 0x0077 }
            boolean r0 = r0.f10155c     // Catch:{ Exception -> 0x0077 }
            if (r0 != 0) goto L_0x0073
            r0 = 8
            r1.setVisibility(r0)     // Catch:{ Exception -> 0x0077 }
        L_0x0073:
            r7.addView(r1)     // Catch:{ Exception -> 0x0077 }
            goto L_0x001f
        L_0x0077:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.a(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar$a, java.util.List):void");
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

    public void hideTitle() {
        TextView textView = this.titleView;
        if (textView != null) {
            textView.setText("");
        }
    }

    public void setButtonIcon(String str, String str2) {
        ((ImageView) findViewWithTag(str)).setImageDrawable(getResources().getDrawable(getResources().getIdentifier(str2, "drawable", c.m().g())));
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            getChildAt(i5).setOnClickListener(onClickListener);
        }
    }

    public void setTitle(String str, int i5) {
        this.title = str;
        if (this.titleView == null) {
            TextView textView = new TextView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            textView.setLayoutParams(layoutParams);
            textView.setClickable(true);
            this.titleView = textView;
            textView.setPadding(64, 0, 10, 0);
            this.titleView.setTextColor(i5);
            addView(this.titleView, 0);
        }
        this.titleView.setText(str);
    }

    public void showTitle() {
        TextView textView = this.titleView;
        if (textView != null) {
            textView.setText(this.title);
        }
    }

    public ToolBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public ToolBar(Context context, List<b> list) {
        super(context);
        a(list);
    }

    public ToolBar(Context context, AttributeSet attributeSet, List<b> list) {
        super(context, attributeSet);
        a(list);
    }

    public ToolBar(Context context, a aVar, List<b> list) {
        super(context);
        a(aVar, list);
    }

    public ToolBar(Context context, AttributeSet attributeSet, a aVar, List<b> list) {
        super(context, attributeSet);
        a(aVar, list);
    }

    public void setTitle(String str) {
        setTitle(str, ViewCompat.MEASURED_STATE_MASK);
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0011 */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x001b A[Catch:{ Exception -> 0x005d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.util.List<com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.b> r8) {
        /*
            r7 = this;
            r0 = 0
            r7.setOrientation(r0)
            android.content.Context r1 = r7.getContext()     // Catch:{ Exception -> 0x0011 }
            r2 = 1092616192(0x41200000, float:10.0)
            int r1 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r1, (float) r2)     // Catch:{ Exception -> 0x0011 }
            r7.setPadding(r0, r1, r0, r1)     // Catch:{ Exception -> 0x0011 }
        L_0x0011:
            java.util.Iterator r8 = r8.iterator()     // Catch:{ Exception -> 0x005d }
        L_0x0015:
            boolean r0 = r8.hasNext()     // Catch:{ Exception -> 0x005d }
            if (r0 == 0) goto L_0x005d
            java.lang.Object r0 = r8.next()     // Catch:{ Exception -> 0x005d }
            com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar$b r0 = (com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.b) r0     // Catch:{ Exception -> 0x005d }
            android.view.View r1 = r7.b()     // Catch:{ Exception -> 0x005d }
            android.widget.ImageView r1 = (android.widget.ImageView) r1     // Catch:{ Exception -> 0x005d }
            java.lang.String r2 = r0.f10153a     // Catch:{ Exception -> 0x005d }
            r1.setTag(r2)     // Catch:{ Exception -> 0x005d }
            android.content.res.Resources r2 = r7.getResources()     // Catch:{ Exception -> 0x005d }
            android.content.res.Resources r3 = r7.getResources()     // Catch:{ Exception -> 0x005d }
            java.lang.String r4 = r0.f10154b     // Catch:{ Exception -> 0x005d }
            java.lang.String r5 = "drawable"
            com.mbridge.msdk.foundation.controller.c r6 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x005d }
            java.lang.String r6 = r6.g()     // Catch:{ Exception -> 0x005d }
            int r3 = r3.getIdentifier(r4, r5, r6)     // Catch:{ Exception -> 0x005d }
            android.graphics.drawable.Drawable r2 = r2.getDrawable(r3)     // Catch:{ Exception -> 0x005d }
            r1.setImageDrawable(r2)     // Catch:{ Exception -> 0x005d }
            android.view.View$OnClickListener r2 = r0.f10156d     // Catch:{ Exception -> 0x005d }
            r1.setOnClickListener(r2)     // Catch:{ Exception -> 0x005d }
            boolean r0 = r0.f10155c     // Catch:{ Exception -> 0x005d }
            if (r0 != 0) goto L_0x0059
            r0 = 8
            r1.setVisibility(r0)     // Catch:{ Exception -> 0x005d }
        L_0x0059:
            r7.addView(r1)     // Catch:{ Exception -> 0x005d }
            goto L_0x0015
        L_0x005d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.a(java.util.List):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x00bf */
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
            java.lang.String r2 = "open_by_browser"
            r1.setTag(r2)     // Catch:{ Exception -> 0x00bf }
            android.content.res.Resources r2 = r6.getResources()     // Catch:{ Exception -> 0x00bf }
            android.content.res.Resources r3 = r6.getResources()     // Catch:{ Exception -> 0x00bf }
            java.lang.String r4 = "mbridge_cm_browser"
            com.mbridge.msdk.foundation.controller.c r5 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x00bf }
            java.lang.String r5 = r5.g()     // Catch:{ Exception -> 0x00bf }
            int r3 = r3.getIdentifier(r4, r0, r5)     // Catch:{ Exception -> 0x00bf }
            android.graphics.drawable.Drawable r2 = r2.getDrawable(r3)     // Catch:{ Exception -> 0x00bf }
            r1.setImageDrawable(r2)     // Catch:{ Exception -> 0x00bf }
            r6.addView(r1)     // Catch:{ Exception -> 0x00bf }
        L_0x00bf:
            android.view.View r1 = r6.b()     // Catch:{ Exception -> 0x00ea }
            android.widget.ImageView r1 = (android.widget.ImageView) r1     // Catch:{ Exception -> 0x00ea }
            java.lang.String r2 = "exits"
            r1.setTag(r2)     // Catch:{ Exception -> 0x00ea }
            android.content.res.Resources r2 = r6.getResources()     // Catch:{ Exception -> 0x00ea }
            android.content.res.Resources r3 = r6.getResources()     // Catch:{ Exception -> 0x00ea }
            java.lang.String r4 = "mbridge_cm_exits"
            com.mbridge.msdk.foundation.controller.c r5 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x00ea }
            java.lang.String r5 = r5.g()     // Catch:{ Exception -> 0x00ea }
            int r0 = r3.getIdentifier(r4, r0, r5)     // Catch:{ Exception -> 0x00ea }
            android.graphics.drawable.Drawable r0 = r2.getDrawable(r0)     // Catch:{ Exception -> 0x00ea }
            r1.setImageDrawable(r0)     // Catch:{ Exception -> 0x00ea }
            r6.addView(r1)     // Catch:{ Exception -> 0x00ea }
        L_0x00ea:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.a():void");
    }
}
