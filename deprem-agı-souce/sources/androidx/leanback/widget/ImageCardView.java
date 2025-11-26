package androidx.leanback.widget;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.view.ViewCompat;
import androidx.leanback.R;

public class ImageCardView extends BaseCardView {
    private static final String ALPHA = "alpha";
    public static final int CARD_TYPE_FLAG_CONTENT = 2;
    public static final int CARD_TYPE_FLAG_ICON_LEFT = 8;
    public static final int CARD_TYPE_FLAG_ICON_RIGHT = 4;
    public static final int CARD_TYPE_FLAG_IMAGE_ONLY = 0;
    public static final int CARD_TYPE_FLAG_TITLE = 1;
    private boolean mAttachedToWindow;
    private ImageView mBadgeImage;
    private TextView mContentView;
    ObjectAnimator mFadeInAnimator;
    private ImageView mImageView;
    private ViewGroup mInfoArea;
    private TextView mTitleView;

    @Deprecated
    public ImageCardView(Context context, int i5) {
        this(new ContextThemeWrapper(context, i5));
    }

    @SuppressLint({"CustomViewStyleable"})
    private void buildImageCardView(AttributeSet attributeSet, int i5, int i6) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        setFocusable(true);
        setFocusableInTouchMode(true);
        LayoutInflater from = LayoutInflater.from(getContext());
        from.inflate(R.layout.lb_image_card_view, this);
        Context context = getContext();
        int[] iArr = R.styleable.lbImageCardView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i5, i6);
        ViewCompat.saveAttributeDataForStyleable(this, getContext(), iArr, attributeSet, obtainStyledAttributes, i5, i6);
        int i7 = obtainStyledAttributes.getInt(R.styleable.lbImageCardView_lbImageCardViewType, 0);
        if (i7 == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if ((i7 & 1) == 1) {
            z5 = true;
        } else {
            z5 = false;
        }
        if ((i7 & 2) == 2) {
            z6 = true;
        } else {
            z6 = false;
        }
        if ((i7 & 4) == 4) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7 || (i7 & 8) != 8) {
            z8 = false;
        } else {
            z8 = true;
        }
        ImageView imageView = (ImageView) findViewById(R.id.main_image);
        this.mImageView = imageView;
        if (imageView.getDrawable() == null) {
            this.mImageView.setVisibility(4);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mImageView, "alpha", new float[]{1.0f});
        this.mFadeInAnimator = ofFloat;
        ofFloat.setDuration((long) this.mImageView.getResources().getInteger(17694720));
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.info_field);
        this.mInfoArea = viewGroup;
        if (z4) {
            removeView(viewGroup);
            obtainStyledAttributes.recycle();
            return;
        }
        if (z5) {
            TextView textView = (TextView) from.inflate(R.layout.lb_image_card_view_themed_title, viewGroup, false);
            this.mTitleView = textView;
            this.mInfoArea.addView(textView);
        }
        if (z6) {
            TextView textView2 = (TextView) from.inflate(R.layout.lb_image_card_view_themed_content, this.mInfoArea, false);
            this.mContentView = textView2;
            this.mInfoArea.addView(textView2);
        }
        if (z7 || z8) {
            int i8 = R.layout.lb_image_card_view_themed_badge_right;
            if (z8) {
                i8 = R.layout.lb_image_card_view_themed_badge_left;
            }
            ImageView imageView2 = (ImageView) from.inflate(i8, this.mInfoArea, false);
            this.mBadgeImage = imageView2;
            this.mInfoArea.addView(imageView2);
        }
        if (z5 && !z6 && this.mBadgeImage != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
            if (z8) {
                layoutParams.addRule(17, this.mBadgeImage.getId());
            } else {
                layoutParams.addRule(16, this.mBadgeImage.getId());
            }
            this.mTitleView.setLayoutParams(layoutParams);
        }
        if (z6) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mContentView.getLayoutParams();
            if (!z5) {
                layoutParams2.addRule(10);
            }
            if (z8) {
                layoutParams2.removeRule(16);
                layoutParams2.removeRule(20);
                layoutParams2.addRule(17, this.mBadgeImage.getId());
            }
            this.mContentView.setLayoutParams(layoutParams2);
        }
        ImageView imageView3 = this.mBadgeImage;
        if (imageView3 != null) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) imageView3.getLayoutParams();
            if (z6) {
                layoutParams3.addRule(8, this.mContentView.getId());
            } else if (z5) {
                layoutParams3.addRule(8, this.mTitleView.getId());
            }
            this.mBadgeImage.setLayoutParams(layoutParams3);
        }
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.lbImageCardView_infoAreaBackground);
        if (drawable != null) {
            setInfoAreaBackground(drawable);
        }
        ImageView imageView4 = this.mBadgeImage;
        if (imageView4 != null && imageView4.getDrawable() == null) {
            this.mBadgeImage.setVisibility(8);
        }
        obtainStyledAttributes.recycle();
    }

    private void fadeIn() {
        this.mImageView.setAlpha(0.0f);
        if (this.mAttachedToWindow) {
            this.mFadeInAnimator.start();
        }
    }

    public Drawable getBadgeImage() {
        ImageView imageView = this.mBadgeImage;
        if (imageView == null) {
            return null;
        }
        return imageView.getDrawable();
    }

    public CharSequence getContentText() {
        TextView textView = this.mContentView;
        if (textView == null) {
            return null;
        }
        return textView.getText();
    }

    public Drawable getInfoAreaBackground() {
        ViewGroup viewGroup = this.mInfoArea;
        if (viewGroup != null) {
            return viewGroup.getBackground();
        }
        return null;
    }

    public Drawable getMainImage() {
        ImageView imageView = this.mImageView;
        if (imageView == null) {
            return null;
        }
        return imageView.getDrawable();
    }

    public final ImageView getMainImageView() {
        return this.mImageView;
    }

    public CharSequence getTitleText() {
        TextView textView = this.mTitleView;
        if (textView == null) {
            return null;
        }
        return textView.getText();
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mAttachedToWindow = true;
        if (this.mImageView.getAlpha() == 0.0f) {
            fadeIn();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.mAttachedToWindow = false;
        this.mFadeInAnimator.cancel();
        this.mImageView.setAlpha(1.0f);
        super.onDetachedFromWindow();
    }

    public void setBadgeImage(Drawable drawable) {
        ImageView imageView = this.mBadgeImage;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
            if (drawable != null) {
                this.mBadgeImage.setVisibility(0);
            } else {
                this.mBadgeImage.setVisibility(8);
            }
        }
    }

    public void setContentText(CharSequence charSequence) {
        TextView textView = this.mContentView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setInfoAreaBackground(Drawable drawable) {
        ViewGroup viewGroup = this.mInfoArea;
        if (viewGroup != null) {
            viewGroup.setBackground(drawable);
        }
    }

    public void setInfoAreaBackgroundColor(@ColorInt int i5) {
        ViewGroup viewGroup = this.mInfoArea;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(i5);
        }
    }

    public void setMainImage(Drawable drawable) {
        setMainImage(drawable, true);
    }

    public void setMainImageAdjustViewBounds(boolean z4) {
        ImageView imageView = this.mImageView;
        if (imageView != null) {
            imageView.setAdjustViewBounds(z4);
        }
    }

    public void setMainImageDimensions(int i5, int i6) {
        ViewGroup.LayoutParams layoutParams = this.mImageView.getLayoutParams();
        layoutParams.width = i5;
        layoutParams.height = i6;
        this.mImageView.setLayoutParams(layoutParams);
    }

    public void setMainImageScaleType(ImageView.ScaleType scaleType) {
        ImageView imageView = this.mImageView;
        if (imageView != null) {
            imageView.setScaleType(scaleType);
        }
    }

    public void setTitleText(CharSequence charSequence) {
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public ImageCardView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        buildImageCardView(attributeSet, i5, R.style.Widget_Leanback_ImageCardView);
    }

    public void setMainImage(Drawable drawable, boolean z4) {
        ImageView imageView = this.mImageView;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
            if (drawable == null) {
                this.mFadeInAnimator.cancel();
                this.mImageView.setAlpha(1.0f);
                this.mImageView.setVisibility(4);
                return;
            }
            this.mImageView.setVisibility(0);
            if (z4) {
                fadeIn();
                return;
            }
            this.mFadeInAnimator.cancel();
            this.mImageView.setAlpha(1.0f);
        }
    }

    public ImageCardView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ImageCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.imageCardViewStyle);
    }
}
