package com.uptodown.util.views;

import B2.w;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.uptodown.R;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class UsernameTextView extends AppCompatTextView {

    /* renamed from: k  reason: collision with root package name */
    public static final a f21329k = new a((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ValueAnimator f21330a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public float f21331b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int[] f21332c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Integer f21333d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public long f21334e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public long f21335f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f21336g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f21337h;

    /* renamed from: i  reason: collision with root package name */
    private String f21338i;

    /* renamed from: j  reason: collision with root package name */
    private Handler f21339j;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final void a(UsernameTextView usernameTextView, boolean z4, String str) {
            t.e(usernameTextView, "<this>");
            b(usernameTextView);
            ValueAnimator e5 = usernameTextView.f21330a;
            if (e5 != null) {
                e5.cancel();
            }
            usernameTextView.setTurbo(z4);
            usernameTextView.setUsernameFormat(str);
            if (str != null) {
                switch (str.hashCode()) {
                    case 110843959:
                        if (str.equals("type1")) {
                            usernameTextView.f21334e = AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS;
                            usernameTextView.f21335f = 200;
                            break;
                        }
                        break;
                    case 110843960:
                        if (str.equals("type2")) {
                            usernameTextView.f21334e = 4000;
                            usernameTextView.f21335f = 300;
                            break;
                        }
                        break;
                    case 110843961:
                        if (str.equals("type3")) {
                            usernameTextView.f21334e = 3000;
                            usernameTextView.f21335f = 400;
                            break;
                        }
                        break;
                }
            }
            usernameTextView.m(usernameTextView.f21335f);
        }

        public final void b(UsernameTextView usernameTextView) {
            t.e(usernameTextView, "<this>");
            ValueAnimator e5 = usernameTextView.f21330a;
            if (e5 != null) {
                e5.cancel();
            }
            usernameTextView.f21330a = null;
            usernameTextView.f21331b = 0.0f;
            usernameTextView.f21332c = null;
            usernameTextView.f21333d = Integer.valueOf(ContextCompat.getColor(usernameTextView.getContext(), R.color.text_terciary));
            usernameTextView.f21334e = 0;
            usernameTextView.f21335f = 0;
            usernameTextView.f21336g = false;
            usernameTextView.setTurbo(false);
            usernameTextView.setUsernameFormat((String) null);
            usernameTextView.getPaint().setShader((Shader) null);
            Handler animationHandler = usernameTextView.getAnimationHandler();
            if (animationHandler != null) {
                animationHandler.removeCallbacksAndMessages((Object) null);
            }
            usernameTextView.setAnimationHandler(new Handler(Looper.getMainLooper()));
            Integer b5 = usernameTextView.f21333d;
            t.b(b5);
            usernameTextView.setTextColor(b5.intValue());
            usernameTextView.invalidate();
        }

        private a() {
        }
    }

    public static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UsernameTextView f21340a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f21341b;

        b(UsernameTextView usernameTextView, long j5) {
            this.f21340a = usernameTextView;
            this.f21341b = j5;
        }

        /* access modifiers changed from: private */
        public static final void b(UsernameTextView usernameTextView, ValueAnimator valueAnimator) {
            t.e(valueAnimator, "it");
            Object animatedValue = valueAnimator.getAnimatedValue();
            t.c(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            usernameTextView.f21331b = ((Float) animatedValue).floatValue();
            usernameTextView.invalidate();
        }

        public void run() {
            ValueAnimator e5 = this.f21340a.f21330a;
            if (e5 != null) {
                e5.cancel();
            }
            UsernameTextView usernameTextView = this.f21340a;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            long j5 = this.f21341b;
            UsernameTextView usernameTextView2 = this.f21340a;
            ofFloat.setDuration(j5);
            ofFloat.setRepeatCount(1);
            ofFloat.setRepeatMode(2);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.addUpdateListener(new w(usernameTextView2));
            usernameTextView.f21330a = ofFloat;
            ValueAnimator e6 = this.f21340a.f21330a;
            if (e6 != null) {
                e6.start();
            }
            this.f21340a.f21336g = true;
            Handler animationHandler = this.f21340a.getAnimationHandler();
            if (animationHandler != null) {
                animationHandler.postDelayed(this, this.f21340a.f21334e);
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public UsernameTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (C2633k) null);
        t.e(context, "context");
    }

    /* access modifiers changed from: private */
    public final void m(long j5) {
        if (this.f21337h) {
            n();
            this.f21339j = new Handler(Looper.getMainLooper());
            b bVar = new b(this, j5);
            String str = this.f21338i;
            if (str != null) {
                switch (str.hashCode()) {
                    case 110843959:
                        if (str.equals("type1")) {
                            int color = ContextCompat.getColor(getContext(), R.color.turbo_username_type_1_1);
                            this.f21332c = new int[]{color, ContextCompat.getColor(getContext(), R.color.turbo_username_type_1_2), color, color, color};
                            break;
                        }
                        break;
                    case 110843960:
                        if (str.equals("type2")) {
                            int color2 = ContextCompat.getColor(getContext(), R.color.turbo_username_type_2_1);
                            this.f21332c = new int[]{color2, ContextCompat.getColor(getContext(), R.color.turbo_username_type_2_2), color2, color2, color2};
                            break;
                        }
                        break;
                    case 110843961:
                        if (str.equals("type3")) {
                            int color3 = ContextCompat.getColor(getContext(), R.color.turbo_username_type_3_1);
                            this.f21332c = new int[]{color3, ContextCompat.getColor(getContext(), R.color.turbo_username_type_3_2), color3, color3, color3};
                            break;
                        }
                        break;
                }
            }
            Handler handler = this.f21339j;
            if (handler != null) {
                handler.post(bVar);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void n() {
        /*
            r2 = this;
            android.text.TextPaint r0 = r2.getPaint()
            r1 = 0
            r0.setShader(r1)
            java.lang.String r0 = r2.f21338i
            if (r0 == 0) goto L_0x0052
            int r1 = r0.hashCode()
            switch(r1) {
                case 110843959: goto L_0x003e;
                case 110843960: goto L_0x0029;
                case 110843961: goto L_0x0014;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x0052
        L_0x0014:
            java.lang.String r1 = "type3"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x001d
            goto L_0x0052
        L_0x001d:
            android.content.Context r0 = r2.getContext()
            r1 = 2131100861(0x7f0604bd, float:1.7814115E38)
            int r0 = androidx.core.content.ContextCompat.getColor(r0, r1)
            goto L_0x005d
        L_0x0029:
            java.lang.String r1 = "type2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0032
            goto L_0x0052
        L_0x0032:
            android.content.Context r0 = r2.getContext()
            r1 = 2131100859(0x7f0604bb, float:1.7814111E38)
            int r0 = androidx.core.content.ContextCompat.getColor(r0, r1)
            goto L_0x005d
        L_0x003e:
            java.lang.String r1 = "type1"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0052
            android.content.Context r0 = r2.getContext()
            r1 = 2131100857(0x7f0604b9, float:1.7814107E38)
            int r0 = androidx.core.content.ContextCompat.getColor(r0, r1)
            goto L_0x005d
        L_0x0052:
            android.content.Context r0 = r2.getContext()
            r1 = 2131100836(0x7f0604a4, float:1.7814065E38)
            int r0 = androidx.core.content.ContextCompat.getColor(r0, r1)
        L_0x005d:
            r2.setTextColor(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.util.views.UsernameTextView.n():void");
    }

    public final Handler getAnimationHandler() {
        return this.f21339j;
    }

    public final String getUsernameFormat() {
        return this.f21338i;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        t.e(canvas, "canvas");
        if (this.f21332c != null) {
            ValueAnimator valueAnimator = this.f21330a;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                n();
            } else {
                float width = (float) getWidth();
                int[] iArr = this.f21332c;
                t.b(iArr);
                float f5 = this.f21331b;
                getPaint().setShader(new LinearGradient(0.0f, 0.0f, width, 0.0f, iArr, new float[]{0.0f, f5, f5, f5, 1.0f}, Shader.TileMode.CLAMP));
            }
        } else {
            Integer num = this.f21333d;
            if (num != null) {
                t.b(num);
                setTextColor(num.intValue());
            }
        }
        super.onDraw(canvas);
    }

    public final void setAnimationHandler(Handler handler) {
        this.f21339j = handler;
    }

    public final void setTurbo(boolean z4) {
        this.f21337h = z4;
    }

    public final void setUsernameFormat(String str) {
        this.f21338i = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UsernameTextView(Context context, AttributeSet attributeSet, int i5, int i6, C2633k kVar) {
        this(context, (i6 & 2) != 0 ? null : attributeSet, (i6 & 4) != 0 ? 0 : i5);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UsernameTextView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        t.e(context, "context");
        this.f21339j = new Handler(Looper.getMainLooper());
        this.f21333d = Integer.valueOf(getCurrentTextColor());
    }
}
