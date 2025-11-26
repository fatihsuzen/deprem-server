package com.mbridge.msdk.video.dynview.j;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.dycreator.baseview.MBFrameLayout;
import com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeFramLayout;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.video.dynview.a.a;
import com.mbridge.msdk.video.dynview.c;
import com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView;
import com.mbridge.msdk.video.dynview.widget.MBridgeRelativeLayout;
import com.mbridge.msdk.video.module.MBridgeClickCTAView;
import java.util.Map;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private String f12188a = "mbridge_top_play_bg";

    /* renamed from: b  reason: collision with root package name */
    private String f12189b = "mbridge_top_finger_bg";

    /* renamed from: c  reason: collision with root package name */
    private String f12190c = "mbridge_bottom_play_bg";

    /* renamed from: d  reason: collision with root package name */
    private String f12191d = "mbridge_bottom_finger_bg";

    /* renamed from: e  reason: collision with root package name */
    private String f12192e = "mbridge_tv_count";

    /* renamed from: f  reason: collision with root package name */
    private String f12193f = "mbridge_sound_switch";

    /* renamed from: g  reason: collision with root package name */
    private String f12194g = "mbridge_top_control";

    /* renamed from: h  reason: collision with root package name */
    private String f12195h = "mbridge_tv_title";

    /* renamed from: i  reason: collision with root package name */
    private String f12196i = "mbridge_tv_desc";

    /* renamed from: j  reason: collision with root package name */
    private String f12197j = "mbridge_tv_install";

    /* renamed from: k  reason: collision with root package name */
    private String f12198k = "mbridge_sv_starlevel";

    /* renamed from: l  reason: collision with root package name */
    private String f12199l = "mbridge_sv_heat_count_level";

    /* renamed from: m  reason: collision with root package name */
    private String f12200m = "mbridge_tv_cta";

    /* renamed from: n  reason: collision with root package name */
    private String f12201n = "mbridge_native_ec_controller";

    /* renamed from: o  reason: collision with root package name */
    private String f12202o = "mbridge_reward_shape_choice_rl";

    /* renamed from: p  reason: collision with root package name */
    private String f12203p = "#FFFFFF";

    /* renamed from: q  reason: collision with root package name */
    private String f12204q = "#FF000000";

    /* renamed from: r  reason: collision with root package name */
    private String f12205r = "#40000000";

    /* renamed from: s  reason: collision with root package name */
    private String f12206s = "#CAEF79";

    /* renamed from: t  reason: collision with root package name */
    private String f12207t = "#2196F3";

    /* renamed from: u  reason: collision with root package name */
    private String f12208u = "#402196F3";

    /* renamed from: v  reason: collision with root package name */
    private String f12209v = "#8FC31F";

    /* renamed from: w  reason: collision with root package name */
    private String f12210w = "#03A9F4";

    /* renamed from: x  reason: collision with root package name */
    private String f12211x = "#FF89C120";

    /* renamed from: y  reason: collision with root package name */
    private String f12212y = "#FF2BAE5D";

    /* renamed from: z  reason: collision with root package name */
    private boolean f12213z = false;

    public final void a(View view, Map<String, Object> map) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        if (view != null && (view instanceof MBridgeFramLayout)) {
            MBridgeFramLayout mBridgeFramLayout = (MBridgeFramLayout) view;
            AnimatorSet animatorSet = new AnimatorSet();
            if (view.getContext() != null) {
                if (map != null && map.containsKey("is_dy_success")) {
                    this.f12213z = ((Boolean) map.get("is_dy_success")).booleanValue();
                }
                if (this.f12213z) {
                    imageView = (ImageView) view.findViewById(b(this.f12188a));
                    imageView4 = (ImageView) view.findViewById(b(this.f12189b));
                    imageView3 = (ImageView) view.findViewById(b(this.f12190c));
                    imageView2 = (ImageView) view.findViewById(b(this.f12191d));
                } else {
                    imageView = (ImageView) view.findViewById(a(this.f12188a));
                    imageView4 = (ImageView) view.findViewById(a(this.f12189b));
                    imageView3 = (ImageView) view.findViewById(a(this.f12190c));
                    imageView2 = (ImageView) view.findViewById(a(this.f12191d));
                }
                ObjectAnimator objectAnimator = null;
                ObjectAnimator a5 = imageView != null ? new com.mbridge.msdk.video.dynview.h.b().a(imageView) : null;
                ObjectAnimator b5 = imageView4 != null ? new com.mbridge.msdk.video.dynview.h.b().b(imageView4) : null;
                ObjectAnimator a6 = imageView3 != null ? new com.mbridge.msdk.video.dynview.h.b().a(imageView3) : null;
                if (imageView2 != null) {
                    objectAnimator = new com.mbridge.msdk.video.dynview.h.b().b(imageView2);
                }
                if (a5 != null && a6 != null && b5 != null && objectAnimator != null) {
                    animatorSet.playTogether(new Animator[]{a5, a6, b5, objectAnimator});
                    mBridgeFramLayout.setAnimatorSet(animatorSet);
                }
            }
        }
    }

    public final void b(View view, c cVar, Map<String, Object> map) {
        LinearLayout linearLayout;
        View view2;
        if (view != null && cVar != null) {
            if (view.getContext() != null) {
                if (map != null && map.containsKey("is_dy_success")) {
                    this.f12213z = ((Boolean) map.get("is_dy_success")).booleanValue();
                }
                if (this.f12213z) {
                    linearLayout = (LinearLayout) view.findViewById(b(this.f12198k));
                    view2 = view.findViewById(b(this.f12200m));
                } else {
                    linearLayout = (LinearLayout) view.findViewById(a(this.f12198k));
                    view2 = view.findViewById(a(this.f12200m));
                }
                if (linearLayout != null && (linearLayout instanceof MBridgeLevelLayoutView)) {
                    if (cVar.e() == 1) {
                        linearLayout.setOrientation(1);
                    } else {
                        linearLayout.setOrientation(0);
                    }
                }
                if (linearLayout != null && (linearLayout instanceof MBStarLevelLayoutView)) {
                    linearLayout.setOrientation(0);
                }
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(a(this.f12201n));
                if (relativeLayout != null) {
                    if (relativeLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                        layoutParams.setMargins(layoutParams.leftMargin + a.f12032a, layoutParams.topMargin + a.f12034c, layoutParams.rightMargin + a.f12033b, layoutParams.bottomMargin + a.f12035d);
                        relativeLayout.setLayoutParams(layoutParams);
                    }
                    if (relativeLayout.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) relativeLayout.getLayoutParams();
                        layoutParams2.setMargins(layoutParams2.leftMargin + a.f12032a, layoutParams2.topMargin + a.f12034c, layoutParams2.rightMargin + a.f12033b, layoutParams2.bottomMargin + a.f12035d);
                        relativeLayout.setLayoutParams(layoutParams2);
                    }
                }
                if (view2 != null) {
                    if (view2 instanceof TextView) {
                        TextView textView = (TextView) view2;
                        textView.setTextColor(Color.parseColor(this.f12203p));
                        textView.setTextSize(22.0f);
                        com.mbridge.msdk.video.dynview.i.b.a.a(view2, 1.0f, (float) (cVar.i() == 1302 ? 25 : 5), this.f12206s, new String[]{this.f12211x, this.f12212y}, GradientDrawable.Orientation.LEFT_RIGHT);
                    }
                    try {
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(new Animator[]{new com.mbridge.msdk.video.dynview.h.b().c(view2)});
                        animatorSet.addListener(new Animator.AnimatorListener() {
                            public final void onAnimationCancel(Animator animator) {
                            }

                            public final void onAnimationEnd(Animator animator) {
                            }

                            public final void onAnimationRepeat(Animator animator) {
                            }

                            public final void onAnimationStart(Animator animator) {
                            }
                        });
                        if (view instanceof MBFrameLayout) {
                            ((MBFrameLayout) view).setAnimator(animatorSet);
                        }
                        if (view instanceof MBridgeFramLayout) {
                            ((MBridgeFramLayout) view).setAnimatorSet(animatorSet);
                        }
                        if (view instanceof MBridgeRelativeLayout) {
                            ((MBridgeRelativeLayout) view).setAnimatorSet(animatorSet);
                        }
                    } catch (Exception e5) {
                        Exception exc = e5;
                        if (MBridgeConstans.DEBUG) {
                            exc.printStackTrace();
                        }
                    }
                }
            }
            new com.mbridge.msdk.video.dynview.h.b().c(view, 500);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.view.View r9, com.mbridge.msdk.video.dynview.c r10, java.util.Map<java.lang.String, java.lang.Object> r11) {
        /*
            r8 = this;
            if (r9 == 0) goto L_0x0007
            android.content.Context r0 = r9.getContext()
            goto L_0x0008
        L_0x0007:
            r0 = 0
        L_0x0008:
            if (r0 == 0) goto L_0x0171
            if (r10 != 0) goto L_0x000e
            goto L_0x0171
        L_0x000e:
            java.lang.String r1 = "mbridge_reward_click_tv"
            if (r11 == 0) goto L_0x0056
            java.lang.String r2 = "is_dy_success"
            boolean r3 = r11.containsKey(r2)
            if (r3 == 0) goto L_0x0056
            java.lang.Object r11 = r11.get(r2)
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            r8.f12213z = r11
            if (r11 == 0) goto L_0x003f
            java.lang.String r11 = r8.f12192e
            int r11 = r8.b(r11)
            android.view.View r11 = r9.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            int r1 = r8.b(r1)
            android.view.View r1 = r9.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            goto L_0x006c
        L_0x003f:
            java.lang.String r11 = r8.f12192e
            int r11 = r8.a(r11)
            android.view.View r11 = r9.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            int r1 = r8.a(r1)
            android.view.View r1 = r9.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            goto L_0x006c
        L_0x0056:
            java.lang.String r11 = r8.f12192e
            int r11 = r8.a(r11)
            android.view.View r11 = r9.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            int r1 = r8.a(r1)
            android.view.View r1 = r9.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
        L_0x006c:
            if (r11 == 0) goto L_0x0087
            java.lang.String r2 = "mbridge_reward_shape_progress"
            java.lang.String r3 = "drawable"
            int r0 = com.mbridge.msdk.foundation.tools.x.a(r0, r2, r3)
            r11.setBackgroundResource(r0)
            java.lang.String r0 = r8.f12203p
            int r0 = android.graphics.Color.parseColor(r0)
            r11.setTextColor(r0)
            r0 = 1093664768(0x41300000, float:11.0)
            r11.setTextSize(r0)
        L_0x0087:
            if (r1 == 0) goto L_0x00b4
            r11 = 1101004800(0x41a00000, float:20.0)
            r1.setTextSize(r11)
            boolean r11 = r1 instanceof com.mbridge.msdk.dycreator.baseview.cusview.MBridgeTextView
            if (r11 == 0) goto L_0x00a1
            com.mbridge.msdk.video.dynview.h.b r11 = new com.mbridge.msdk.video.dynview.h.b
            r11.<init>()
            android.animation.ObjectAnimator r11 = r11.c(r1)
            r0 = r1
            com.mbridge.msdk.dycreator.baseview.cusview.MBridgeTextView r0 = (com.mbridge.msdk.dycreator.baseview.cusview.MBridgeTextView) r0
            r0.setObjectAnimator(r11)
        L_0x00a1:
            boolean r11 = r1 instanceof com.mbridge.msdk.dycreator.baseview.MBTextView
            if (r11 == 0) goto L_0x00b4
            com.mbridge.msdk.video.dynview.h.b r11 = new com.mbridge.msdk.video.dynview.h.b
            r11.<init>()
            android.animation.ObjectAnimator r11 = r11.c(r1)
            r0 = r1
            com.mbridge.msdk.dycreator.baseview.MBTextView r0 = (com.mbridge.msdk.dycreator.baseview.MBTextView) r0
            r0.setAnimator(r11)
        L_0x00b4:
            java.lang.String r11 = r8.f12204q
            java.lang.String r0 = r8.f12206s
            int r2 = r10.i()
            r3 = 302(0x12e, float:4.23E-43)
            r4 = 1092616192(0x41200000, float:10.0)
            r5 = 1065353216(0x3f800000, float:1.0)
            if (r2 == r3) goto L_0x00ef
            r3 = 802(0x322, float:1.124E-42)
            if (r2 == r3) goto L_0x00e0
            r3 = 5002010(0x4c531a, float:7.009309E-39)
            if (r2 == r3) goto L_0x00d7
            java.lang.String r2 = r8.f12209v
            java.lang.String r3 = r8.f12206s
            r4 = 1084227584(0x40a00000, float:5.0)
        L_0x00d3:
            r7 = r4
            r4 = r0
            r0 = r7
            goto L_0x00f8
        L_0x00d7:
            java.lang.String r0 = r8.f12209v
            java.lang.String r11 = r8.f12203p
            r2 = r0
            r3 = r2
            r0 = r4
            r4 = r3
            goto L_0x00f8
        L_0x00e0:
            java.lang.String r2 = r8.f12203p
            java.lang.String r11 = r8.f12204q
            java.lang.String r0 = r8.f12205r
            r5 = 1056964608(0x3f000000, float:0.5)
            r4 = 1103626240(0x41c80000, float:25.0)
            r3 = r4
            r4 = r0
            r0 = r3
            r3 = r2
            goto L_0x00f8
        L_0x00ef:
            java.lang.String r2 = r8.f12207t
            java.lang.String r3 = r8.f12210w
            java.lang.String r11 = r8.f12203p
            java.lang.String r0 = r8.f12208u
            goto L_0x00d3
        L_0x00f8:
            if (r1 == 0) goto L_0x010d
            int r11 = android.graphics.Color.parseColor(r11)
            r1.setTextColor(r11)
            java.lang.String[] r11 = new java.lang.String[]{r2, r3}
            android.graphics.drawable.GradientDrawable$Orientation r6 = android.graphics.drawable.GradientDrawable.Orientation.LEFT_RIGHT
            r3 = r0
            r2 = r5
            r5 = r11
            com.mbridge.msdk.video.dynview.i.b.a.a(r1, r2, r3, r4, r5, r6)
        L_0x010d:
            android.view.View r11 = r10.f()
            r0 = 0
            if (r11 == 0) goto L_0x012a
            android.view.View r11 = r10.f()
            android.view.ViewGroup$LayoutParams r11 = r11.getLayoutParams()
            android.widget.RelativeLayout$LayoutParams r11 = (android.widget.RelativeLayout.LayoutParams) r11
            if (r11 == 0) goto L_0x012a
            r11.setMargins(r0, r0, r0, r0)
            android.view.View r10 = r10.f()
            r10.setLayoutParams(r11)
        L_0x012a:
            boolean r10 = r8.f12213z
            if (r10 == 0) goto L_0x013b
            java.lang.String r10 = r8.f12194g
            int r10 = r8.b(r10)
            android.view.View r9 = r9.findViewById(r10)
            android.widget.RelativeLayout r9 = (android.widget.RelativeLayout) r9
            goto L_0x0147
        L_0x013b:
            java.lang.String r10 = r8.f12194g
            int r10 = r8.a(r10)
            android.view.View r9 = r9.findViewById(r10)
            android.widget.RelativeLayout r9 = (android.widget.RelativeLayout) r9
        L_0x0147:
            if (r9 == 0) goto L_0x0171
            int r10 = com.mbridge.msdk.video.dynview.a.a.f12032a
            if (r10 != 0) goto L_0x015a
            int r10 = com.mbridge.msdk.video.dynview.a.a.f12033b
            if (r10 != 0) goto L_0x015a
            int r10 = com.mbridge.msdk.video.dynview.a.a.f12034c
            if (r10 != 0) goto L_0x015a
            int r10 = com.mbridge.msdk.video.dynview.a.a.f12035d
            if (r10 != 0) goto L_0x015a
            goto L_0x0171
        L_0x015a:
            r10 = 4
            r9.setVisibility(r10)
            android.view.animation.AlphaAnimation r10 = new android.view.animation.AlphaAnimation
            r11 = 0
            r1 = 1120403456(0x42c80000, float:100.0)
            r10.<init>(r11, r1)
            r1 = 200(0xc8, double:9.9E-322)
            r10.setDuration(r1)
            r9.startAnimation(r10)
            r9.setVisibility(r0)
        L_0x0171:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.dynview.j.b.a(android.view.View, com.mbridge.msdk.video.dynview.c, java.util.Map):void");
    }

    private int b(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.hashCode();
        }
        return -1;
    }

    public final void a(View view, c cVar) {
        Context context;
        int i5;
        if (view != null && cVar != null && (context = view.getContext()) != null) {
            if (cVar.e() == 1) {
                view.setBackground(context.getResources().getDrawable(x.a(context, this.f12202o, "drawable")));
                TextView textView = (TextView) view.findViewById(a(this.f12195h));
                if (textView != null) {
                    textView.setTextColor(Color.parseColor(this.f12204q));
                }
                TextView textView2 = (TextView) view.findViewById(a(this.f12196i));
                if (textView2 != null) {
                    textView2.setTextColor(Color.parseColor(this.f12204q));
                }
                i5 = ak.a(context, 2.0f);
            } else {
                i5 = ak.a(context, 10.0f);
                view.getBackground().setAlpha(100);
            }
            int a5 = ak.a(context, 8.0f);
            View findViewById = view.findViewById(a(this.f12197j));
            if (findViewById != null) {
                if (cVar.f() != null && (cVar.f() instanceof MBridgeClickCTAView)) {
                    ((MBridgeClickCTAView) cVar.f()).setObjectAnimator(new com.mbridge.msdk.video.dynview.h.b().c(findViewById));
                }
                if (findViewById instanceof TextView) {
                    TextView textView3 = (TextView) findViewById;
                    textView3.setTextColor(Color.parseColor(this.f12203p));
                    textView3.setTextSize(15.0f);
                    String str = this.f12209v;
                    String str2 = this.f12206s;
                    com.mbridge.msdk.video.dynview.i.b.a.a(textView3, 1.0f, 5.0f, str2, new String[]{str, str2}, GradientDrawable.Orientation.LEFT_RIGHT);
                }
            }
            if (view.getLayoutParams() == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(i5, i5, i5, a5);
                layoutParams.height = ak.a(context, 60.0f);
                view.setLayoutParams(layoutParams);
            }
        }
    }

    private int a(String str) {
        return x.a(com.mbridge.msdk.foundation.controller.c.m().c(), str, "id");
    }
}
