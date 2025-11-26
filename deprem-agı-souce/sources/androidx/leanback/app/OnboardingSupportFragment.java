package androidx.leanback.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.os.Bundle;
import android.util.Property;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.leanback.R;
import androidx.leanback.widget.PagingIndicator;
import java.util.ArrayList;

public abstract class OnboardingSupportFragment extends Fragment {
    private static final boolean DEBUG = false;
    private static final long DESCRIPTION_START_DELAY_MS = 33;
    private static final long HEADER_ANIMATION_DURATION_MS = 417;
    private static final long HEADER_APPEAR_DELAY_MS = 500;
    private static final TimeInterpolator HEADER_APPEAR_INTERPOLATOR = new DecelerateInterpolator();
    private static final TimeInterpolator HEADER_DISAPPEAR_INTERPOLATOR = new AccelerateInterpolator();
    private static final String KEY_CURRENT_PAGE_INDEX = "leanback.onboarding.current_page_index";
    private static final String KEY_ENTER_ANIMATION_FINISHED = "leanback.onboarding.enter_animation_finished";
    private static final String KEY_LOGO_ANIMATION_FINISHED = "leanback.onboarding.logo_animation_finished";
    private static final long LOGO_SPLASH_PAUSE_DURATION_MS = 1333;
    private static final int SLIDE_DISTANCE = 60;
    private static final String TAG = "OnboardingF";
    private static int sSlideDistance;
    private AnimatorSet mAnimator;
    @ColorInt
    private int mArrowBackgroundColor = 0;
    private boolean mArrowBackgroundColorSet;
    @ColorInt
    private int mArrowColor = 0;
    private boolean mArrowColorSet;
    int mCurrentPageIndex;
    TextView mDescriptionView;
    @ColorInt
    private int mDescriptionViewTextColor = 0;
    private boolean mDescriptionViewTextColorSet;
    @ColorInt
    private int mDotBackgroundColor = 0;
    private boolean mDotBackgroundColorSet;
    boolean mEnterAnimationFinished;
    private int mIconResourceId;
    boolean mIsLtr;
    boolean mLogoAnimationFinished;
    private int mLogoResourceId;
    private ImageView mLogoView;
    private ImageView mMainIconView;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        public void onClick(View view) {
            OnboardingSupportFragment onboardingSupportFragment = OnboardingSupportFragment.this;
            if (onboardingSupportFragment.mLogoAnimationFinished) {
                if (onboardingSupportFragment.mCurrentPageIndex == onboardingSupportFragment.getPageCount() - 1) {
                    OnboardingSupportFragment.this.onFinishFragment();
                } else {
                    OnboardingSupportFragment.this.moveToNextPage();
                }
            }
        }
    };
    private final View.OnKeyListener mOnKeyListener = new View.OnKeyListener() {
        public boolean onKey(View view, int i5, KeyEvent keyEvent) {
            if (!OnboardingSupportFragment.this.mLogoAnimationFinished) {
                if (i5 != 4) {
                    return true;
                }
                return false;
            } else if (keyEvent.getAction() == 0) {
                return false;
            } else {
                if (i5 == 4) {
                    OnboardingSupportFragment onboardingSupportFragment = OnboardingSupportFragment.this;
                    if (onboardingSupportFragment.mCurrentPageIndex == 0) {
                        return false;
                    }
                    onboardingSupportFragment.moveToPreviousPage();
                    return true;
                } else if (i5 == 21) {
                    OnboardingSupportFragment onboardingSupportFragment2 = OnboardingSupportFragment.this;
                    if (onboardingSupportFragment2.mIsLtr) {
                        onboardingSupportFragment2.moveToPreviousPage();
                    } else {
                        onboardingSupportFragment2.moveToNextPage();
                    }
                    return true;
                } else if (i5 != 22) {
                    return false;
                } else {
                    OnboardingSupportFragment onboardingSupportFragment3 = OnboardingSupportFragment.this;
                    if (onboardingSupportFragment3.mIsLtr) {
                        onboardingSupportFragment3.moveToNextPage();
                    } else {
                        onboardingSupportFragment3.moveToPreviousPage();
                    }
                    return true;
                }
            }
        }
    };
    PagingIndicator mPageIndicator;
    View mStartButton;
    private CharSequence mStartButtonText;
    private boolean mStartButtonTextSet;
    private ContextThemeWrapper mThemeWrapper;
    TextView mTitleView;
    @ColorInt
    private int mTitleViewTextColor = 0;
    private boolean mTitleViewTextColorSet;

    private Animator createAnimator(View view, boolean z4, int i5, long j5) {
        boolean z5;
        boolean z6;
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        int i6;
        int i7;
        if (getView().getLayoutDirection() == 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        if ((!z5 || i5 != 8388613) && ((z5 || i5 != 8388611) && i5 != 5)) {
            z6 = false;
        } else {
            z6 = true;
        }
        if (z4) {
            objectAnimator2 = ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{0.0f, 1.0f});
            Property property = View.TRANSLATION_X;
            if (z6) {
                i7 = sSlideDistance;
            } else {
                i7 = -sSlideDistance;
            }
            objectAnimator = ObjectAnimator.ofFloat(view, property, new float[]{(float) i7, 0.0f});
            TimeInterpolator timeInterpolator = HEADER_APPEAR_INTERPOLATOR;
            objectAnimator2.setInterpolator(timeInterpolator);
            objectAnimator.setInterpolator(timeInterpolator);
        } else {
            objectAnimator2 = ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{1.0f, 0.0f});
            Property property2 = View.TRANSLATION_X;
            if (z6) {
                i6 = sSlideDistance;
            } else {
                i6 = -sSlideDistance;
            }
            objectAnimator = ObjectAnimator.ofFloat(view, property2, new float[]{0.0f, (float) i6});
            TimeInterpolator timeInterpolator2 = HEADER_DISAPPEAR_INTERPOLATOR;
            objectAnimator2.setInterpolator(timeInterpolator2);
            objectAnimator.setInterpolator(timeInterpolator2);
        }
        objectAnimator2.setDuration(HEADER_ANIMATION_DURATION_MS);
        objectAnimator2.setTarget(view);
        objectAnimator.setDuration(HEADER_ANIMATION_DURATION_MS);
        objectAnimator.setTarget(view);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{objectAnimator2, objectAnimator});
        if (j5 > 0) {
            animatorSet.setStartDelay(j5);
        }
        return animatorSet;
    }

    private LayoutInflater getThemeInflater(LayoutInflater layoutInflater) {
        ContextThemeWrapper contextThemeWrapper = this.mThemeWrapper;
        if (contextThemeWrapper == null) {
            return layoutInflater;
        }
        return layoutInflater.cloneInContext(contextThemeWrapper);
    }

    private void onPageChangedInternal(int i5) {
        OnboardingSupportFragment onboardingSupportFragment;
        Animator animator;
        AnimatorSet animatorSet = this.mAnimator;
        if (animatorSet != null) {
            animatorSet.end();
        }
        this.mPageIndicator.onPageSelected(this.mCurrentPageIndex, true);
        ArrayList arrayList = new ArrayList();
        if (i5 < getCurrentPageIndex()) {
            onboardingSupportFragment = this;
            arrayList.add(onboardingSupportFragment.createAnimator(this.mTitleView, false, GravityCompat.START, 0));
            animator = onboardingSupportFragment.createAnimator(onboardingSupportFragment.mDescriptionView, false, GravityCompat.START, DESCRIPTION_START_DELAY_MS);
            arrayList.add(animator);
            arrayList.add(onboardingSupportFragment.createAnimator(onboardingSupportFragment.mTitleView, true, GravityCompat.END, HEADER_APPEAR_DELAY_MS));
            arrayList.add(onboardingSupportFragment.createAnimator(onboardingSupportFragment.mDescriptionView, true, GravityCompat.END, 533));
        } else {
            onboardingSupportFragment = this;
            arrayList.add(onboardingSupportFragment.createAnimator(onboardingSupportFragment.mTitleView, false, GravityCompat.END, 0));
            animator = onboardingSupportFragment.createAnimator(onboardingSupportFragment.mDescriptionView, false, GravityCompat.END, DESCRIPTION_START_DELAY_MS);
            arrayList.add(animator);
            arrayList.add(onboardingSupportFragment.createAnimator(onboardingSupportFragment.mTitleView, true, GravityCompat.START, HEADER_APPEAR_DELAY_MS));
            arrayList.add(onboardingSupportFragment.createAnimator(onboardingSupportFragment.mDescriptionView, true, GravityCompat.START, 533));
        }
        final int currentPageIndex = getCurrentPageIndex();
        animator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                OnboardingSupportFragment onboardingSupportFragment = OnboardingSupportFragment.this;
                onboardingSupportFragment.mTitleView.setText(onboardingSupportFragment.getPageTitle(currentPageIndex));
                OnboardingSupportFragment onboardingSupportFragment2 = OnboardingSupportFragment.this;
                onboardingSupportFragment2.mDescriptionView.setText(onboardingSupportFragment2.getPageDescription(currentPageIndex));
            }
        });
        Context context = getContext();
        if (getCurrentPageIndex() == getPageCount() - 1) {
            onboardingSupportFragment.mStartButton.setVisibility(0);
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, R.animator.lb_onboarding_page_indicator_fade_out);
            loadAnimator.setTarget(onboardingSupportFragment.mPageIndicator);
            loadAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    OnboardingSupportFragment.this.mPageIndicator.setVisibility(8);
                }
            });
            arrayList.add(loadAnimator);
            Animator loadAnimator2 = AnimatorInflater.loadAnimator(context, R.animator.lb_onboarding_start_button_fade_in);
            loadAnimator2.setTarget(onboardingSupportFragment.mStartButton);
            arrayList.add(loadAnimator2);
        } else if (i5 == getPageCount() - 1) {
            onboardingSupportFragment.mPageIndicator.setVisibility(0);
            Animator loadAnimator3 = AnimatorInflater.loadAnimator(context, R.animator.lb_onboarding_page_indicator_fade_in);
            loadAnimator3.setTarget(onboardingSupportFragment.mPageIndicator);
            arrayList.add(loadAnimator3);
            Animator loadAnimator4 = AnimatorInflater.loadAnimator(context, R.animator.lb_onboarding_start_button_fade_out);
            loadAnimator4.setTarget(onboardingSupportFragment.mStartButton);
            loadAnimator4.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    OnboardingSupportFragment.this.mStartButton.setVisibility(8);
                }
            });
            arrayList.add(loadAnimator4);
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        onboardingSupportFragment.mAnimator = animatorSet2;
        animatorSet2.playTogether(arrayList);
        onboardingSupportFragment.mAnimator.start();
        onPageChanged(onboardingSupportFragment.mCurrentPageIndex, i5);
    }

    private void resolveTheme() {
        Context context = getContext();
        int onProvideTheme = onProvideTheme();
        if (onProvideTheme == -1) {
            int i5 = R.attr.onboardingTheme;
            TypedValue typedValue = new TypedValue();
            if (context.getTheme().resolveAttribute(i5, typedValue, true)) {
                this.mThemeWrapper = new ContextThemeWrapper(context, typedValue.resourceId);
                return;
            }
            return;
        }
        this.mThemeWrapper = new ContextThemeWrapper(context, onProvideTheme);
    }

    @ColorInt
    public final int getArrowBackgroundColor() {
        return this.mArrowBackgroundColor;
    }

    @ColorInt
    public final int getArrowColor() {
        return this.mArrowColor;
    }

    /* access modifiers changed from: protected */
    public final int getCurrentPageIndex() {
        return this.mCurrentPageIndex;
    }

    @ColorInt
    public final int getDescriptionViewTextColor() {
        return this.mDescriptionViewTextColor;
    }

    @ColorInt
    public final int getDotBackgroundColor() {
        return this.mDotBackgroundColor;
    }

    public final int getIconResourceId() {
        return this.mIconResourceId;
    }

    public final int getLogoResourceId() {
        return this.mLogoResourceId;
    }

    /* access modifiers changed from: protected */
    public abstract int getPageCount();

    /* access modifiers changed from: protected */
    public abstract CharSequence getPageDescription(int i5);

    /* access modifiers changed from: protected */
    public abstract CharSequence getPageTitle(int i5);

    public final CharSequence getStartButtonText() {
        return this.mStartButtonText;
    }

    @ColorInt
    public final int getTitleViewTextColor() {
        return this.mTitleViewTextColor;
    }

    /* access modifiers changed from: package-private */
    public void hideLogoView() {
        this.mLogoView.setVisibility(8);
        int i5 = this.mIconResourceId;
        if (i5 != 0) {
            this.mMainIconView.setImageResource(i5);
            this.mMainIconView.setVisibility(0);
        }
        View view = getView();
        LayoutInflater themeInflater = getThemeInflater(LayoutInflater.from(getContext()));
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.background_container);
        View onCreateBackgroundView = onCreateBackgroundView(themeInflater, viewGroup);
        if (onCreateBackgroundView != null) {
            viewGroup.setVisibility(0);
            viewGroup.addView(onCreateBackgroundView);
        }
        int i6 = R.id.content_container;
        ViewGroup viewGroup2 = (ViewGroup) view.findViewById(i6);
        View onCreateContentView = onCreateContentView(themeInflater, viewGroup2);
        if (onCreateContentView != null) {
            viewGroup2.setVisibility(0);
            viewGroup2.addView(onCreateContentView);
        }
        ViewGroup viewGroup3 = (ViewGroup) view.findViewById(R.id.foreground_container);
        View onCreateForegroundView = onCreateForegroundView(themeInflater, viewGroup3);
        if (onCreateForegroundView != null) {
            viewGroup3.setVisibility(0);
            viewGroup3.addView(onCreateForegroundView);
        }
        view.findViewById(R.id.page_container).setVisibility(0);
        view.findViewById(i6).setVisibility(0);
        if (getPageCount() > 1) {
            this.mPageIndicator.setPageCount(getPageCount());
            this.mPageIndicator.onPageSelected(this.mCurrentPageIndex, false);
        }
        if (this.mCurrentPageIndex == getPageCount() - 1) {
            this.mStartButton.setVisibility(0);
        } else {
            this.mPageIndicator.setVisibility(0);
        }
        this.mTitleView.setText(getPageTitle(this.mCurrentPageIndex));
        this.mDescriptionView.setText(getPageDescription(this.mCurrentPageIndex));
    }

    /* access modifiers changed from: protected */
    public final boolean isLogoAnimationFinished() {
        return this.mLogoAnimationFinished;
    }

    /* access modifiers changed from: protected */
    public void moveToNextPage() {
        if (this.mLogoAnimationFinished && this.mCurrentPageIndex < getPageCount() - 1) {
            int i5 = this.mCurrentPageIndex;
            this.mCurrentPageIndex = i5 + 1;
            onPageChangedInternal(i5);
        }
    }

    /* access modifiers changed from: protected */
    public void moveToPreviousPage() {
        int i5;
        if (this.mLogoAnimationFinished && (i5 = this.mCurrentPageIndex) > 0) {
            this.mCurrentPageIndex = i5 - 1;
            onPageChangedInternal(i5);
        }
    }

    /* access modifiers changed from: protected */
    public abstract View onCreateBackgroundView(LayoutInflater layoutInflater, ViewGroup viewGroup);

    /* access modifiers changed from: protected */
    public abstract View onCreateContentView(LayoutInflater layoutInflater, ViewGroup viewGroup);

    /* access modifiers changed from: protected */
    public Animator onCreateDescriptionAnimator() {
        return AnimatorInflater.loadAnimator(getContext(), R.animator.lb_onboarding_description_enter);
    }

    /* access modifiers changed from: protected */
    public Animator onCreateEnterAnimation() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract View onCreateForegroundView(LayoutInflater layoutInflater, ViewGroup viewGroup);

    /* access modifiers changed from: protected */
    public Animator onCreateLogoAnimation() {
        return null;
    }

    /* access modifiers changed from: protected */
    public Animator onCreateTitleAnimator() {
        return AnimatorInflater.loadAnimator(getContext(), R.animator.lb_onboarding_title_enter);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        resolveTheme();
        boolean z4 = false;
        ViewGroup viewGroup2 = (ViewGroup) getThemeInflater(layoutInflater).inflate(R.layout.lb_onboarding_fragment, viewGroup, false);
        if (getResources().getConfiguration().getLayoutDirection() == 0) {
            z4 = true;
        }
        this.mIsLtr = z4;
        PagingIndicator pagingIndicator = (PagingIndicator) viewGroup2.findViewById(R.id.page_indicator);
        this.mPageIndicator = pagingIndicator;
        pagingIndicator.setOnClickListener(this.mOnClickListener);
        this.mPageIndicator.setOnKeyListener(this.mOnKeyListener);
        View findViewById = viewGroup2.findViewById(R.id.button_start);
        this.mStartButton = findViewById;
        findViewById.setOnClickListener(this.mOnClickListener);
        this.mStartButton.setOnKeyListener(this.mOnKeyListener);
        this.mMainIconView = (ImageView) viewGroup2.findViewById(R.id.main_icon);
        this.mLogoView = (ImageView) viewGroup2.findViewById(R.id.logo);
        this.mTitleView = (TextView) viewGroup2.findViewById(R.id.title);
        this.mDescriptionView = (TextView) viewGroup2.findViewById(R.id.description);
        if (this.mTitleViewTextColorSet) {
            this.mTitleView.setTextColor(this.mTitleViewTextColor);
        }
        if (this.mDescriptionViewTextColorSet) {
            this.mDescriptionView.setTextColor(this.mDescriptionViewTextColor);
        }
        if (this.mDotBackgroundColorSet) {
            this.mPageIndicator.setDotBackgroundColor(this.mDotBackgroundColor);
        }
        if (this.mArrowColorSet) {
            this.mPageIndicator.setArrowColor(this.mArrowColor);
        }
        if (this.mArrowBackgroundColorSet) {
            this.mPageIndicator.setDotBackgroundColor(this.mArrowBackgroundColor);
        }
        if (this.mStartButtonTextSet) {
            ((Button) this.mStartButton).setText(this.mStartButtonText);
        }
        Context context = getContext();
        if (sSlideDistance == 0) {
            sSlideDistance = (int) (context.getResources().getDisplayMetrics().scaledDensity * 60.0f);
        }
        viewGroup2.requestFocus();
        return viewGroup2;
    }

    /* access modifiers changed from: protected */
    public void onFinishFragment() {
    }

    /* access modifiers changed from: protected */
    public void onLogoAnimationFinished() {
        startEnterAnimation(false);
    }

    /* access modifiers changed from: protected */
    public void onPageChanged(int i5, int i6) {
    }

    public int onProvideTheme() {
        return -1;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(KEY_CURRENT_PAGE_INDEX, this.mCurrentPageIndex);
        bundle.putBoolean(KEY_LOGO_ANIMATION_FINISHED, this.mLogoAnimationFinished);
        bundle.putBoolean(KEY_ENTER_ANIMATION_FINISHED, this.mEnterAnimationFinished);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (bundle == null) {
            this.mCurrentPageIndex = 0;
            this.mLogoAnimationFinished = false;
            this.mEnterAnimationFinished = false;
            this.mPageIndicator.onPageSelected(0, false);
            view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                public boolean onPreDraw() {
                    OnboardingSupportFragment.this.getView().getViewTreeObserver().removeOnPreDrawListener(this);
                    if (!OnboardingSupportFragment.this.startLogoAnimation()) {
                        OnboardingSupportFragment onboardingSupportFragment = OnboardingSupportFragment.this;
                        onboardingSupportFragment.mLogoAnimationFinished = true;
                        onboardingSupportFragment.onLogoAnimationFinished();
                    }
                    return true;
                }
            });
            return;
        }
        this.mCurrentPageIndex = bundle.getInt(KEY_CURRENT_PAGE_INDEX);
        this.mLogoAnimationFinished = bundle.getBoolean(KEY_LOGO_ANIMATION_FINISHED);
        this.mEnterAnimationFinished = bundle.getBoolean(KEY_ENTER_ANIMATION_FINISHED);
        if (this.mLogoAnimationFinished) {
            onLogoAnimationFinished();
        } else if (!startLogoAnimation()) {
            this.mLogoAnimationFinished = true;
            onLogoAnimationFinished();
        }
    }

    public void setArrowBackgroundColor(@ColorInt int i5) {
        this.mArrowBackgroundColor = i5;
        this.mArrowBackgroundColorSet = true;
        PagingIndicator pagingIndicator = this.mPageIndicator;
        if (pagingIndicator != null) {
            pagingIndicator.setArrowBackgroundColor(i5);
        }
    }

    public void setArrowColor(@ColorInt int i5) {
        this.mArrowColor = i5;
        this.mArrowColorSet = true;
        PagingIndicator pagingIndicator = this.mPageIndicator;
        if (pagingIndicator != null) {
            pagingIndicator.setArrowColor(i5);
        }
    }

    public void setDescriptionViewTextColor(@ColorInt int i5) {
        this.mDescriptionViewTextColor = i5;
        this.mDescriptionViewTextColorSet = true;
        TextView textView = this.mDescriptionView;
        if (textView != null) {
            textView.setTextColor(i5);
        }
    }

    public void setDotBackgroundColor(@ColorInt int i5) {
        this.mDotBackgroundColor = i5;
        this.mDotBackgroundColorSet = true;
        PagingIndicator pagingIndicator = this.mPageIndicator;
        if (pagingIndicator != null) {
            pagingIndicator.setDotBackgroundColor(i5);
        }
    }

    public final void setIconResouceId(int i5) {
        this.mIconResourceId = i5;
        ImageView imageView = this.mMainIconView;
        if (imageView != null) {
            imageView.setImageResource(i5);
            this.mMainIconView.setVisibility(0);
        }
    }

    public final void setLogoResourceId(int i5) {
        this.mLogoResourceId = i5;
    }

    public void setStartButtonText(CharSequence charSequence) {
        this.mStartButtonText = charSequence;
        this.mStartButtonTextSet = true;
        View view = this.mStartButton;
        if (view != null) {
            ((Button) view).setText(charSequence);
        }
    }

    public void setTitleViewTextColor(@ColorInt int i5) {
        this.mTitleViewTextColor = i5;
        this.mTitleViewTextColorSet = true;
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setTextColor(i5);
        }
    }

    /* access modifiers changed from: protected */
    public final void startEnterAnimation(boolean z4) {
        Object obj;
        Context context = getContext();
        if (context != null) {
            hideLogoView();
            if (!this.mEnterAnimationFinished || z4) {
                ArrayList arrayList = new ArrayList();
                Animator loadAnimator = AnimatorInflater.loadAnimator(context, R.animator.lb_onboarding_page_indicator_enter);
                if (getPageCount() <= 1) {
                    obj = this.mStartButton;
                } else {
                    obj = this.mPageIndicator;
                }
                loadAnimator.setTarget(obj);
                arrayList.add(loadAnimator);
                Animator onCreateTitleAnimator = onCreateTitleAnimator();
                if (onCreateTitleAnimator != null) {
                    onCreateTitleAnimator.setTarget(this.mTitleView);
                    arrayList.add(onCreateTitleAnimator);
                }
                Animator onCreateDescriptionAnimator = onCreateDescriptionAnimator();
                if (onCreateDescriptionAnimator != null) {
                    onCreateDescriptionAnimator.setTarget(this.mDescriptionView);
                    arrayList.add(onCreateDescriptionAnimator);
                }
                Animator onCreateEnterAnimation = onCreateEnterAnimation();
                if (onCreateEnterAnimation != null) {
                    arrayList.add(onCreateEnterAnimation);
                }
                if (!arrayList.isEmpty()) {
                    AnimatorSet animatorSet = new AnimatorSet();
                    this.mAnimator = animatorSet;
                    animatorSet.playTogether(arrayList);
                    this.mAnimator.start();
                    this.mAnimator.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            OnboardingSupportFragment.this.mEnterAnimationFinished = true;
                        }
                    });
                    getView().requestFocus();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean startLogoAnimation() {
        AnimatorSet animatorSet;
        final Context context = getContext();
        if (context == null) {
            return false;
        }
        if (this.mLogoResourceId != 0) {
            this.mLogoView.setVisibility(0);
            this.mLogoView.setImageResource(this.mLogoResourceId);
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, R.animator.lb_onboarding_logo_enter);
            Animator loadAnimator2 = AnimatorInflater.loadAnimator(context, R.animator.lb_onboarding_logo_exit);
            loadAnimator2.setStartDelay(LOGO_SPLASH_PAUSE_DURATION_MS);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playSequentially(new Animator[]{loadAnimator, loadAnimator2});
            animatorSet2.setTarget(this.mLogoView);
            animatorSet = animatorSet2;
        } else {
            animatorSet = onCreateLogoAnimation();
        }
        if (animatorSet == null) {
            return false;
        }
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (context != null) {
                    OnboardingSupportFragment onboardingSupportFragment = OnboardingSupportFragment.this;
                    onboardingSupportFragment.mLogoAnimationFinished = true;
                    onboardingSupportFragment.onLogoAnimationFinished();
                }
            }
        });
        animatorSet.start();
        return true;
    }
}
