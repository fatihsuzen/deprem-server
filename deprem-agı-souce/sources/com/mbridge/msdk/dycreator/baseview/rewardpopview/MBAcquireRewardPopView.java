package com.mbridge.msdk.dycreator.baseview.rewardpopview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.GravityCompat;
import com.mbridge.msdk.dycreator.baseview.rewardpopview.MBGradientAndShadowTextView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MBAcquireRewardPopView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private final String f8548a = "MBAcquireRewardPopView";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public AcquireRewardPopViewParameters f8549b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public AnimationSet f8550c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public float f8551d = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public float f8552e = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public float f8553f = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public float f8554g = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f8555h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f8556i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public boolean f8557j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f8558k;

    /* renamed from: l  reason: collision with root package name */
    private final View.OnClickListener f8559l = new View.OnClickListener() {
        public void onClick(View view) {
            View view2;
            MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
            mBAcquireRewardPopView.removeCallbacks(mBAcquireRewardPopView.f8560m);
            String str = (String) view.getTag();
            if (!TextUtils.isEmpty(str)) {
                boolean contains = MBAcquireRewardPopView.this.f8549b.rightAnswerList.contains(str);
                MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                if (contains) {
                    view2 = MBAcquireRewardPopView.e(mBAcquireRewardPopView2);
                } else {
                    view2 = MBAcquireRewardPopView.f(mBAcquireRewardPopView2);
                }
                View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                if (childAt != null) {
                    MBAcquireRewardPopView.a(MBAcquireRewardPopView.this, childAt, view2);
                }
                if (MBAcquireRewardPopView.this.f8549b.behaviourListener != null) {
                    if (contains) {
                        MBAcquireRewardPopView.this.f8549b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.f8549b.reduceTime);
                    } else {
                        MBAcquireRewardPopView.this.f8549b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_WRONG_ANSWER);
                    }
                }
                MBAcquireRewardPopView mBAcquireRewardPopView3 = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView3.postDelayed(mBAcquireRewardPopView3.f8561n, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public Runnable f8560m = new Runnable() {
        public void run() {
            if (MBAcquireRewardPopView.this.f8555h <= 0) {
                if (MBAcquireRewardPopView.this.f8549b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.f8549b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_AUTO_DISMISS);
                }
                boolean unused = MBAcquireRewardPopView.this.f8556i = false;
                MBAcquireRewardPopView.this.setVisibility(8);
                MBAcquireRewardPopView.this.removeAllViews();
                return;
            }
            MBAcquireRewardPopView.i(MBAcquireRewardPopView.this);
            MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
            mBAcquireRewardPopView.postDelayed(mBAcquireRewardPopView.f8560m, 1000);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public Runnable f8561n = new Runnable() {
        public void run() {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(300);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    boolean unused = MBAcquireRewardPopView.this.f8556i = false;
                    MBAcquireRewardPopView.this.setVisibility(8);
                    MBAcquireRewardPopView.this.removeAllViews();
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            });
            MBAcquireRewardPopView.this.startAnimation(alphaAnimation);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public View.OnTouchListener f8562o = new View.OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                float unused = MBAcquireRewardPopView.this.f8551d = motionEvent.getX();
                float unused2 = MBAcquireRewardPopView.this.f8552e = motionEvent.getY();
            } else if (action != 1) {
                if (action == 2) {
                    float unused3 = MBAcquireRewardPopView.this.f8553f = motionEvent.getX();
                    float unused4 = MBAcquireRewardPopView.this.f8554g = motionEvent.getY();
                }
            } else if (MBAcquireRewardPopView.this.f8553f <= MBAcquireRewardPopView.this.f8551d) {
                MBAcquireRewardPopView.this.f8549b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f8551d, MBAcquireRewardPopView.this.f8552e);
            } else if (Math.abs(MBAcquireRewardPopView.this.f8553f - MBAcquireRewardPopView.this.f8551d) <= 50.0f || Math.abs(MBAcquireRewardPopView.this.f8554g - MBAcquireRewardPopView.this.f8552e) >= 100.0f) {
                MBAcquireRewardPopView.this.f8549b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f8551d, MBAcquireRewardPopView.this.f8552e);
            } else if (MBAcquireRewardPopView.this.f8557j) {
                return false;
            } else {
                MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView.removeCallbacks(mBAcquireRewardPopView.f8560m);
                boolean unused5 = MBAcquireRewardPopView.this.f8557j = true;
                View e5 = MBAcquireRewardPopView.e(MBAcquireRewardPopView.this);
                View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                if (childAt != null) {
                    MBAcquireRewardPopView.a(MBAcquireRewardPopView.this, childAt, e5);
                }
                if (MBAcquireRewardPopView.this.f8549b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.f8549b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.f8549b.reduceTime);
                }
                MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView2.postDelayed(mBAcquireRewardPopView2.f8561n, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
            }
            return false;
        }
    };

    /* renamed from: p  reason: collision with root package name */
    private final View.OnClickListener f8563p = new View.OnClickListener() {
        public void onClick(View view) {
            if (MBAcquireRewardPopView.this.f8549b.behaviourListener != null) {
                MBAcquireRewardPopView.this.f8549b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f8551d, MBAcquireRewardPopView.this.f8552e);
            }
        }
    };

    /* renamed from: q  reason: collision with root package name */
    private final View.OnClickListener f8564q = new View.OnClickListener() {
        public void onClick(View view) {
            if (MBAcquireRewardPopView.this.f8549b.behaviourListener != null) {
                MBAcquireRewardPopView.this.f8549b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_CLOSE);
            }
            boolean unused = MBAcquireRewardPopView.this.f8556i = false;
            MBAcquireRewardPopView.this.setVisibility(8);
            MBAcquireRewardPopView.this.removeAllViews();
        }
    };

    public MBAcquireRewardPopView(Context context) {
        super(context);
    }

    static /* synthetic */ View e(MBAcquireRewardPopView mBAcquireRewardPopView) {
        String str;
        LinearLayout linearLayout = new LinearLayout(mBAcquireRewardPopView.getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        MBGradientAndShadowTextView.GradientAndShadowParameters gradientAndShadowParameters = new MBGradientAndShadowTextView.GradientAndShadowParameters();
        AcquireRewardPopViewParameters acquireRewardPopViewParameters = mBAcquireRewardPopView.f8549b;
        gradientAndShadowParameters.gradientStartColor = acquireRewardPopViewParameters.successTitleGradientStartColor;
        gradientAndShadowParameters.gradientEndColor = acquireRewardPopViewParameters.successTitleGradientEndColor;
        gradientAndShadowParameters.shadowColor = acquireRewardPopViewParameters.successTitleShadowColor;
        MBGradientAndShadowTextView mBGradientAndShadowTextView = new MBGradientAndShadowTextView(mBAcquireRewardPopView.getContext(), gradientAndShadowParameters);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, 0, ak.a(mBAcquireRewardPopView.getContext(), 12.0f));
        layoutParams2.gravity = 1;
        mBGradientAndShadowTextView.setLayoutParams(layoutParams2);
        AcquireRewardPopViewParameters acquireRewardPopViewParameters2 = mBAcquireRewardPopView.f8549b;
        int i5 = acquireRewardPopViewParameters2.viewType;
        if (i5 == 1) {
            str = acquireRewardPopViewParameters2.successTitle;
        } else if (i5 == 2) {
            str = acquireRewardPopViewParameters2.slideSuccessTitle;
        } else {
            str = "";
        }
        mBGradientAndShadowTextView.setGravity(17);
        mBGradientAndShadowTextView.setText(String.format(" %s ", new Object[]{str}));
        linearLayout.addView(mBGradientAndShadowTextView);
        GradientDrawable a5 = mBAcquireRewardPopView.a(new int[]{AcquireRewardPopViewConst.DEFAULT_COLOR_00FDB258, AcquireRewardPopViewConst.DEFAULT_COLOR_FFE39E4A, AcquireRewardPopViewConst.DEFAULT_COLOR_FFE39E4A, AcquireRewardPopViewConst.DEFAULT_COLOR_00F3A850}, GradientDrawable.Orientation.LEFT_RIGHT);
        TextView textView = new TextView(mBAcquireRewardPopView.getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 1;
        textView.setLayoutParams(layoutParams3);
        textView.setTextSize(12.0f);
        textView.setGravity(17);
        textView.setTextColor(mBAcquireRewardPopView.f8549b.successTipTextColor);
        AcquireRewardPopViewParameters acquireRewardPopViewParameters3 = mBAcquireRewardPopView.f8549b;
        textView.setText(String.format(acquireRewardPopViewParameters3.successTip, new Object[]{Integer.valueOf(acquireRewardPopViewParameters3.reduceTime)}));
        int a6 = ak.a(mBAcquireRewardPopView.getContext(), 6.0f);
        int a7 = ak.a(mBAcquireRewardPopView.getContext(), 32.0f);
        textView.setPadding(a7, a6, a7, a6);
        textView.setBackground(a5);
        linearLayout.addView(textView);
        return linearLayout;
    }

    static /* synthetic */ View f(MBAcquireRewardPopView mBAcquireRewardPopView) {
        LinearLayout linearLayout = new LinearLayout(mBAcquireRewardPopView.getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        MBGradientAndShadowTextView.GradientAndShadowParameters gradientAndShadowParameters = new MBGradientAndShadowTextView.GradientAndShadowParameters();
        AcquireRewardPopViewParameters acquireRewardPopViewParameters = mBAcquireRewardPopView.f8549b;
        gradientAndShadowParameters.gradientStartColor = acquireRewardPopViewParameters.failTitleGradientStartColor;
        gradientAndShadowParameters.gradientEndColor = acquireRewardPopViewParameters.failTitleGradientEndColor;
        gradientAndShadowParameters.shadowColor = acquireRewardPopViewParameters.failTitleShadowColor;
        MBGradientAndShadowTextView mBGradientAndShadowTextView = new MBGradientAndShadowTextView(mBAcquireRewardPopView.getContext(), gradientAndShadowParameters);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, 0, ak.a(mBAcquireRewardPopView.getContext(), 12.0f));
        layoutParams2.gravity = 1;
        mBGradientAndShadowTextView.setGravity(17);
        mBGradientAndShadowTextView.setLayoutParams(layoutParams2);
        mBGradientAndShadowTextView.setText(String.format(" %s ", new Object[]{mBAcquireRewardPopView.f8549b.failTitle}));
        linearLayout.addView(mBGradientAndShadowTextView);
        GradientDrawable a5 = mBAcquireRewardPopView.a(new int[]{AcquireRewardPopViewConst.DEFAULT_COLOR_00B09A80, AcquireRewardPopViewConst.DEFAULT_COLOR_FFB09A80, AcquireRewardPopViewConst.DEFAULT_COLOR_FFB09A80, AcquireRewardPopViewConst.DEFAULT_COLOR_00B09A80}, GradientDrawable.Orientation.LEFT_RIGHT);
        TextView textView = new TextView(mBAcquireRewardPopView.getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 1;
        textView.setLayoutParams(layoutParams3);
        textView.setTextSize(12.0f);
        textView.setGravity(17);
        textView.setTextColor(mBAcquireRewardPopView.f8549b.failTipTextColor);
        textView.setText(String.format(mBAcquireRewardPopView.f8549b.failTip, new Object[]{""}));
        int a6 = ak.a(mBAcquireRewardPopView.getContext(), 6.0f);
        int a7 = ak.a(mBAcquireRewardPopView.getContext(), 32.0f);
        textView.setPadding(a7, a6, a7, a6);
        textView.setBackground(a5);
        linearLayout.addView(textView);
        return linearLayout;
    }

    static /* synthetic */ int i(MBAcquireRewardPopView mBAcquireRewardPopView) {
        int i5 = mBAcquireRewardPopView.f8555h;
        mBAcquireRewardPopView.f8555h = i5 - 1;
        return i5;
    }

    public void init(AcquireRewardPopViewParameters acquireRewardPopViewParameters) {
        LinearLayout linearLayout;
        if (acquireRewardPopViewParameters == null) {
            af.b("MBAcquireRewardPopView", "Must generate parameters.");
            return;
        }
        this.f8549b = acquireRewardPopViewParameters;
        if (acquireRewardPopViewParameters.viewType == 1) {
            ArrayList arrayList = new ArrayList();
            AcquireRewardPopViewParameters acquireRewardPopViewParameters2 = this.f8549b;
            if (acquireRewardPopViewParameters2 != null) {
                List<String> list = acquireRewardPopViewParameters2.rightAnswerList;
                if (list != null) {
                    arrayList.addAll(list);
                }
                if (this.f8549b.wrongAnswerList != null) {
                    int nextInt = new Random().nextInt(this.f8549b.wrongAnswerList.size());
                    if (nextInt > this.f8549b.wrongAnswerList.size() - 1) {
                        nextInt = 0;
                    }
                    arrayList.add(this.f8549b.wrongAnswerList.get(nextInt));
                }
            }
            linearLayout = a((ArrayList<String>) arrayList);
            if (this.f8549b.canClickMaskArea) {
                setOnClickListener(this.f8563p);
            }
        } else {
            linearLayout = null;
        }
        if (this.f8549b.viewType == 2) {
            int a5 = ak.a(getContext(), 290.0f);
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a5, -2);
            layoutParams.addRule(13);
            linearLayout2.setLayoutParams(layoutParams);
            linearLayout2.setOrientation(1);
            MBGradientAndShadowTextView.GradientAndShadowParameters gradientAndShadowParameters = new MBGradientAndShadowTextView.GradientAndShadowParameters();
            AcquireRewardPopViewParameters acquireRewardPopViewParameters3 = this.f8549b;
            gradientAndShadowParameters.gradientStartColor = acquireRewardPopViewParameters3.successTitleGradientStartColor;
            gradientAndShadowParameters.gradientEndColor = acquireRewardPopViewParameters3.successTitleGradientEndColor;
            gradientAndShadowParameters.shadowColor = acquireRewardPopViewParameters3.successTitleShadowColor;
            gradientAndShadowParameters.textSize = 30;
            MBGradientAndShadowTextView mBGradientAndShadowTextView = new MBGradientAndShadowTextView(getContext(), gradientAndShadowParameters);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, 0, ak.a(getContext(), 12.0f));
            layoutParams2.gravity = 1;
            mBGradientAndShadowTextView.setLayoutParams(layoutParams2);
            mBGradientAndShadowTextView.setText(String.format(" %s ", new Object[]{this.f8549b.slideTitle}));
            mBGradientAndShadowTextView.setGravity(17);
            linearLayout2.addView(mBGradientAndShadowTextView);
            GradientDrawable a6 = a(new int[]{AcquireRewardPopViewConst.DEFAULT_COLOR_00FDB258, AcquireRewardPopViewConst.DEFAULT_COLOR_FFE39E4A, AcquireRewardPopViewConst.DEFAULT_COLOR_FFE39E4A, AcquireRewardPopViewConst.DEFAULT_COLOR_00F3A850}, GradientDrawable.Orientation.LEFT_RIGHT);
            this.f8558k = new TextView(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = 1;
            layoutParams3.setMargins(0, 0, 0, ak.a(getContext(), 25.0f));
            this.f8558k.setLayoutParams(layoutParams3);
            this.f8558k.setTextSize(12.0f);
            this.f8558k.setGravity(17);
            this.f8558k.setTextColor(this.f8549b.successTipTextColor);
            TextView textView = this.f8558k;
            AcquireRewardPopViewParameters acquireRewardPopViewParameters4 = this.f8549b;
            textView.setText(String.format(acquireRewardPopViewParameters4.slideTip, new Object[]{Integer.valueOf(acquireRewardPopViewParameters4.reduceTime)}));
            int a7 = ak.a(getContext(), 6.0f);
            int a8 = ak.a(getContext(), 32.0f);
            this.f8558k.setPadding(a8, a7, a8, a7);
            this.f8558k.setBackground(a6);
            linearLayout2.addView(this.f8558k);
            ImageView imageView = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.gravity = 1;
            imageView.setLayoutParams(layoutParams4);
            imageView.setBackgroundResource(getResources().getIdentifier("mbridge_slide_rightarrow", "drawable", c.m().g()));
            linearLayout2.addView(imageView);
            ImageView imageView2 = new ImageView(getContext());
            imageView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            imageView2.setBackgroundResource(getResources().getIdentifier("mbridge_slide_hand", "drawable", c.m().g()));
            linearLayout2.addView(imageView2);
            imageView2.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                public void onViewAttachedToWindow(View view) {
                    MBAcquireRewardPopView.a(MBAcquireRewardPopView.this, view);
                }

                public void onViewDetachedFromWindow(View view) {
                    if (MBAcquireRewardPopView.this.f8550c != null) {
                        MBAcquireRewardPopView.this.f8550c.cancel();
                    }
                }
            });
            linearLayout2.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                public void onViewAttachedToWindow(View view) {
                    MBAcquireRewardPopView.this.setLongClickable(true);
                    MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView.setOnTouchListener(mBAcquireRewardPopView.f8562o);
                }

                public void onViewDetachedFromWindow(View view) {
                }
            });
            linearLayout = linearLayout2;
        }
        if (linearLayout != null) {
            setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            setBackgroundColor(this.f8549b.containerBackgroundColor);
            addView(linearLayout);
            int i5 = this.f8549b.autoDismissTime;
            if (i5 > 0) {
                this.f8555h = i5;
                post(this.f8560m);
                this.f8556i = true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f8560m);
    }

    public void onPause() {
        if (this.f8556i && this.f8555h > 0) {
            removeCallbacks(this.f8560m);
        }
    }

    public void onResume() {
        if (this.f8556i && this.f8555h > 0) {
            post(this.f8560m);
        }
    }

    public void onStop() {
        if (this.f8556i && this.f8555h > 0) {
            removeCallbacks(this.f8560m);
        }
    }

    public void onTimeLessThanReduce(int i5) {
        AcquireRewardPopViewParameters acquireRewardPopViewParameters = this.f8549b;
        acquireRewardPopViewParameters.reduceTime = i5;
        TextView textView = this.f8558k;
        if (textView != null) {
            textView.setText(String.format(acquireRewardPopViewParameters.tips, new Object[]{Integer.valueOf(i5)}));
        }
    }

    private View a(ArrayList<String> arrayList) {
        ArrayList<String> arrayList2 = arrayList;
        LinearLayout linearLayout = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ak.a(getContext(), 290.0f), -2);
        layoutParams.addRule(13);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setClickable(true);
        AcquireRewardPopViewParameters acquireRewardPopViewParameters = this.f8549b;
        int i5 = acquireRewardPopViewParameters.viewBackLayerTopColor;
        int i6 = acquireRewardPopViewParameters.viewBackLayerBottomColor;
        int i7 = acquireRewardPopViewParameters.viewForegroundTopColor;
        int i8 = acquireRewardPopViewParameters.viewForegroundBottomColor;
        int[] iArr = {i5, i6};
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        GradientDrawable a5 = a(iArr, orientation);
        a5.setCornerRadius((float) ak.a(getContext(), 12.0f));
        GradientDrawable a6 = a(new int[]{i7, i8}, orientation);
        a6.setCornerRadius((float) ak.a(getContext(), 12.0f));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{a5, a6});
        layerDrawable.setLayerInset(1, 5, 5, 5, 5);
        linearLayout.setBackground(layerDrawable);
        ImageView imageView = new ImageView(getContext());
        int a7 = ak.a(getContext(), 20.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a7, a7);
        layoutParams2.gravity = GravityCompat.END;
        layoutParams2.setMargins(0, 13, 13, 0);
        imageView.setLayoutParams(layoutParams2);
        imageView.setImageResource(getResources().getIdentifier("mbridge_reward_popview_close", "drawable", c.m().g()));
        imageView.setOnClickListener(this.f8564q);
        linearLayout.addView(imageView);
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 1;
        int a8 = ak.a(getContext(), 18.0f);
        layoutParams3.setMargins(a8, 5, a8, ak.a(getContext(), 12.0f));
        textView.setLayoutParams(layoutParams3);
        textView.setText(this.f8549b.title);
        textView.setTextColor(this.f8549b.titleTextColor);
        textView.setTextSize(18.0f);
        textView.setGravity(17);
        linearLayout.addView(textView);
        if (arrayList2 != null && arrayList2.size() > 1) {
            int a9 = ak.a(getContext(), 8.0f);
            int a10 = ak.a(getContext(), 24.0f);
            int a11 = ak.a(getContext(), 30.0f);
            int a12 = ak.a(getContext(), 12.0f);
            int a13 = ak.a(getContext(), 40.0f);
            for (int i9 = 0; i9 < arrayList2.size(); i9++) {
                boolean contains = this.f8549b.rightAnswerList.contains(arrayList2.get(i9));
                TextView textView2 = new TextView(getContext());
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams4.gravity = 1;
                layoutParams4.setMargins(a11, a12, a11, 0);
                textView2.setPadding(a10, a9, a10, a9);
                textView2.setLayoutParams(layoutParams4);
                textView2.setText(arrayList2.get(i9));
                textView2.setSingleLine(true);
                textView2.setEllipsize(TextUtils.TruncateAt.END);
                textView2.setTag(arrayList2.get(i9));
                textView2.setTextSize(17.0f);
                textView2.setGravity(17);
                AcquireRewardPopViewParameters acquireRewardPopViewParameters2 = this.f8549b;
                textView2.setTextColor(contains ? acquireRewardPopViewParameters2.buttonTextLightColor : acquireRewardPopViewParameters2.buttonTextDarkColor);
                AcquireRewardPopViewParameters acquireRewardPopViewParameters3 = this.f8549b;
                int i10 = contains ? acquireRewardPopViewParameters3.buttonBackgroundLightColor : acquireRewardPopViewParameters3.buttonBackgroundDarkColor;
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(i10);
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius((float) a13);
                textView2.setBackground(gradientDrawable);
                textView2.setOnClickListener(this.f8559l);
                linearLayout.addView(textView2);
            }
        }
        this.f8558k = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        int a14 = ak.a(getContext(), 16.0f);
        int a15 = ak.a(getContext(), 18.0f);
        layoutParams5.setMargins(a15, a14, a15, a14);
        layoutParams5.gravity = 1;
        this.f8558k.setLayoutParams(layoutParams5);
        TextView textView3 = this.f8558k;
        AcquireRewardPopViewParameters acquireRewardPopViewParameters4 = this.f8549b;
        textView3.setText(String.format(acquireRewardPopViewParameters4.tips, new Object[]{Integer.valueOf(acquireRewardPopViewParameters4.reduceTime)}));
        this.f8558k.setTextColor(this.f8549b.tipTextColor);
        this.f8558k.setGravity(17);
        this.f8558k.setTextSize(12.0f);
        linearLayout.addView(this.f8558k);
        return linearLayout;
    }

    public MBAcquireRewardPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBAcquireRewardPopView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }

    @RequiresApi(api = 21)
    public MBAcquireRewardPopView(Context context, @Nullable AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
    }

    private GradientDrawable a(int[] iArr, GradientDrawable.Orientation orientation) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColors(iArr);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setOrientation(orientation);
        gradientDrawable.setShape(0);
        return gradientDrawable;
    }

    static /* synthetic */ void a(MBAcquireRewardPopView mBAcquireRewardPopView, final View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.8f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(1000);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000);
        AnimationSet animationSet = new AnimationSet(true);
        mBAcquireRewardPopView.f8550c = animationSet;
        animationSet.addAnimation(translateAnimation);
        mBAcquireRewardPopView.f8550c.addAnimation(alphaAnimation);
        final AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation2.setDuration(1000);
        alphaAnimation2.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                view.startAnimation(MBAcquireRewardPopView.this.f8550c);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        mBAcquireRewardPopView.f8550c.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                view.startAnimation(alphaAnimation2);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        view.startAnimation(mBAcquireRewardPopView.f8550c);
    }

    static /* synthetic */ void a(MBAcquireRewardPopView mBAcquireRewardPopView, View view, View view2) {
        mBAcquireRewardPopView.removeView(view);
        mBAcquireRewardPopView.addView(view2);
    }
}
