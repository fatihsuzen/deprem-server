package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import java.lang.ref.WeakReference;
import java.util.Locale;

class AppCompatTextHelper {
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int TEXT_FONT_WEIGHT_UNSPECIFIED = -1;
    private boolean mAsyncFontPending;
    @NonNull
    private final AppCompatTextViewAutoSizeHelper mAutoSizeTextHelper;
    private TintInfo mDrawableBottomTint;
    private TintInfo mDrawableEndTint;
    private TintInfo mDrawableLeftTint;
    private TintInfo mDrawableRightTint;
    private TintInfo mDrawableStartTint;
    private TintInfo mDrawableTint;
    private TintInfo mDrawableTopTint;
    private Typeface mFontTypeface;
    private int mFontWeight = -1;
    private int mStyle = 0;
    @NonNull
    private final TextView mView;

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static Locale forLanguageTag(String str) {
            return Locale.forLanguageTag(str);
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static LocaleList forLanguageTags(String str) {
            return LocaleList.forLanguageTags(str);
        }

        @DoNotInline
        static void setTextLocales(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static int getAutoSizeStepGranularity(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        @DoNotInline
        static void setAutoSizeTextTypeUniformWithConfiguration(TextView textView, int i5, int i6, int i7, int i8) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i5, i6, i7, i8);
        }

        @DoNotInline
        static void setAutoSizeTextTypeUniformWithPresetSizes(TextView textView, int[] iArr, int i5) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i5);
        }

        @DoNotInline
        static boolean setFontVariationSettings(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static Typeface create(Typeface typeface, int i5, boolean z4) {
            return Typeface.create(typeface, i5, z4);
        }
    }

    AppCompatTextHelper(@NonNull TextView textView) {
        this.mView = textView;
        this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(textView);
    }

    private void applyCompoundDrawableTint(Drawable drawable, TintInfo tintInfo) {
        if (drawable != null && tintInfo != null) {
            AppCompatDrawableManager.tintDrawable(drawable, tintInfo, this.mView.getDrawableState());
        }
    }

    private static TintInfo createTintInfo(Context context, AppCompatDrawableManager appCompatDrawableManager, int i5) {
        ColorStateList tintList = appCompatDrawableManager.getTintList(context, i5);
        if (tintList == null) {
            return null;
        }
        TintInfo tintInfo = new TintInfo();
        tintInfo.mHasTintList = true;
        tintInfo.mTintList = tintList;
        return tintInfo;
    }

    private void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] compoundDrawablesRelative = this.mView.getCompoundDrawablesRelative();
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            TextView textView = this.mView;
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
        } else if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
            Drawable[] compoundDrawablesRelative2 = this.mView.getCompoundDrawablesRelative();
            Drawable drawable7 = compoundDrawablesRelative2[0];
            if (drawable7 == null && compoundDrawablesRelative2[2] == null) {
                Drawable[] compoundDrawables = this.mView.getCompoundDrawables();
                TextView textView2 = this.mView;
                if (drawable == null) {
                    drawable = compoundDrawables[0];
                }
                if (drawable2 == null) {
                    drawable2 = compoundDrawables[1];
                }
                if (drawable3 == null) {
                    drawable3 = compoundDrawables[2];
                }
                if (drawable4 == null) {
                    drawable4 = compoundDrawables[3];
                }
                textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
                return;
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative2[1];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative2[3];
            }
            this.mView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, compoundDrawablesRelative2[2], drawable4);
        }
    }

    private void setCompoundTints() {
        TintInfo tintInfo = this.mDrawableTint;
        this.mDrawableLeftTint = tintInfo;
        this.mDrawableTopTint = tintInfo;
        this.mDrawableRightTint = tintInfo;
        this.mDrawableBottomTint = tintInfo;
        this.mDrawableStartTint = tintInfo;
        this.mDrawableEndTint = tintInfo;
    }

    private void setTextSizeInternal(int i5, float f5) {
        this.mAutoSizeTextHelper.setTextSizeInternal(i5, f5);
    }

    private void updateTypefaceAndStyle(Context context, TintTypedArray tintTypedArray) {
        String string;
        boolean z4;
        boolean z5;
        this.mStyle = tintTypedArray.getInt(R.styleable.TextAppearance_android_textStyle, this.mStyle);
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 28) {
            int i6 = tintTypedArray.getInt(R.styleable.TextAppearance_android_textFontWeight, -1);
            this.mFontWeight = i6;
            if (i6 != -1) {
                this.mStyle &= 2;
            }
        }
        int i7 = R.styleable.TextAppearance_android_fontFamily;
        boolean z6 = true;
        if (tintTypedArray.hasValue(i7) || tintTypedArray.hasValue(R.styleable.TextAppearance_fontFamily)) {
            this.mFontTypeface = null;
            int i8 = R.styleable.TextAppearance_fontFamily;
            if (tintTypedArray.hasValue(i8)) {
                i7 = i8;
            }
            final int i9 = this.mFontWeight;
            final int i10 = this.mStyle;
            if (!context.isRestricted()) {
                final WeakReference weakReference = new WeakReference(this.mView);
                try {
                    Typeface font = tintTypedArray.getFont(i7, this.mStyle, new ResourcesCompat.FontCallback() {
                        public void onFontRetrievalFailed(int i5) {
                        }

                        public void onFontRetrieved(@NonNull Typeface typeface) {
                            int i5;
                            boolean z4;
                            if (Build.VERSION.SDK_INT >= 28 && (i5 = i9) != -1) {
                                if ((i10 & 2) != 0) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                typeface = Api28Impl.create(typeface, i5, z4);
                            }
                            AppCompatTextHelper.this.onAsyncTypefaceReceived(weakReference, typeface);
                        }
                    });
                    if (font != null) {
                        if (i5 < 28 || this.mFontWeight == -1) {
                            this.mFontTypeface = font;
                        } else {
                            Typeface create = Typeface.create(font, 0);
                            int i11 = this.mFontWeight;
                            if ((this.mStyle & 2) != 0) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            this.mFontTypeface = Api28Impl.create(create, i11, z5);
                        }
                    }
                    if (this.mFontTypeface == null) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    this.mAsyncFontPending = z4;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.mFontTypeface == null && (string = tintTypedArray.getString(i7)) != null) {
                if (Build.VERSION.SDK_INT < 28 || this.mFontWeight == -1) {
                    this.mFontTypeface = Typeface.create(string, this.mStyle);
                    return;
                }
                Typeface create2 = Typeface.create(string, 0);
                int i12 = this.mFontWeight;
                if ((this.mStyle & 2) == 0) {
                    z6 = false;
                }
                this.mFontTypeface = Api28Impl.create(create2, i12, z6);
                return;
            }
            return;
        }
        int i13 = R.styleable.TextAppearance_android_typeface;
        if (tintTypedArray.hasValue(i13)) {
            this.mAsyncFontPending = false;
            int i14 = tintTypedArray.getInt(i13, 1);
            if (i14 == 1) {
                this.mFontTypeface = Typeface.SANS_SERIF;
            } else if (i14 == 2) {
                this.mFontTypeface = Typeface.SERIF;
            } else if (i14 == 3) {
                this.mFontTypeface = Typeface.MONOSPACE;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void applyCompoundDrawablesTints() {
        if (!(this.mDrawableLeftTint == null && this.mDrawableTopTint == null && this.mDrawableRightTint == null && this.mDrawableBottomTint == null)) {
            Drawable[] compoundDrawables = this.mView.getCompoundDrawables();
            applyCompoundDrawableTint(compoundDrawables[0], this.mDrawableLeftTint);
            applyCompoundDrawableTint(compoundDrawables[1], this.mDrawableTopTint);
            applyCompoundDrawableTint(compoundDrawables[2], this.mDrawableRightTint);
            applyCompoundDrawableTint(compoundDrawables[3], this.mDrawableBottomTint);
        }
        if (this.mDrawableStartTint != null || this.mDrawableEndTint != null) {
            Drawable[] compoundDrawablesRelative = this.mView.getCompoundDrawablesRelative();
            applyCompoundDrawableTint(compoundDrawablesRelative[0], this.mDrawableStartTint);
            applyCompoundDrawableTint(compoundDrawablesRelative[2], this.mDrawableEndTint);
        }
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void autoSizeText() {
        this.mAutoSizeTextHelper.autoSizeText();
    }

    /* access modifiers changed from: package-private */
    public int getAutoSizeMaxTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMaxTextSize();
    }

    /* access modifiers changed from: package-private */
    public int getAutoSizeMinTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMinTextSize();
    }

    /* access modifiers changed from: package-private */
    public int getAutoSizeStepGranularity() {
        return this.mAutoSizeTextHelper.getAutoSizeStepGranularity();
    }

    /* access modifiers changed from: package-private */
    public int[] getAutoSizeTextAvailableSizes() {
        return this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
    }

    /* access modifiers changed from: package-private */
    public int getAutoSizeTextType() {
        return this.mAutoSizeTextHelper.getAutoSizeTextType();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public ColorStateList getCompoundDrawableTintList() {
        TintInfo tintInfo = this.mDrawableTint;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public PorterDuff.Mode getCompoundDrawableTintMode() {
        TintInfo tintInfo = this.mDrawableTint;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isAutoSizeEnabled() {
        return this.mAutoSizeTextHelper.isAutoSizeEnabled();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0209  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x025b  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x027a  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0288  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0291  */
    /* JADX WARNING: Removed duplicated region for block: B:135:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01f2  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0200  */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadFromAttributes(@androidx.annotation.Nullable android.util.AttributeSet r19, int r20) {
        /*
            r18 = this;
            r0 = r18
            r4 = r19
            r6 = r20
            android.widget.TextView r1 = r0.mView
            android.content.Context r8 = r1.getContext()
            androidx.appcompat.widget.AppCompatDrawableManager r9 = androidx.appcompat.widget.AppCompatDrawableManager.get()
            int[] r3 = androidx.appcompat.R.styleable.AppCompatTextHelper
            r10 = 0
            androidx.appcompat.widget.TintTypedArray r11 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(r8, r4, r3, r6, r10)
            android.widget.TextView r1 = r0.mView
            android.content.Context r2 = r1.getContext()
            android.content.res.TypedArray r5 = r11.getWrappedTypeArray()
            r7 = 0
            androidx.core.view.ViewCompat.saveAttributeDataForStyleable(r1, r2, r3, r4, r5, r6, r7)
            int r1 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_textAppearance
            r7 = -1
            int r1 = r11.getResourceId(r1, r7)
            int r2 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableLeft
            boolean r3 = r11.hasValue(r2)
            if (r3 == 0) goto L_0x003e
            int r2 = r11.getResourceId(r2, r10)
            androidx.appcompat.widget.TintInfo r2 = createTintInfo(r8, r9, r2)
            r0.mDrawableLeftTint = r2
        L_0x003e:
            int r2 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableTop
            boolean r3 = r11.hasValue(r2)
            if (r3 == 0) goto L_0x0050
            int r2 = r11.getResourceId(r2, r10)
            androidx.appcompat.widget.TintInfo r2 = createTintInfo(r8, r9, r2)
            r0.mDrawableTopTint = r2
        L_0x0050:
            int r2 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableRight
            boolean r3 = r11.hasValue(r2)
            if (r3 == 0) goto L_0x0062
            int r2 = r11.getResourceId(r2, r10)
            androidx.appcompat.widget.TintInfo r2 = createTintInfo(r8, r9, r2)
            r0.mDrawableRightTint = r2
        L_0x0062:
            int r2 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableBottom
            boolean r3 = r11.hasValue(r2)
            if (r3 == 0) goto L_0x0074
            int r2 = r11.getResourceId(r2, r10)
            androidx.appcompat.widget.TintInfo r2 = createTintInfo(r8, r9, r2)
            r0.mDrawableBottomTint = r2
        L_0x0074:
            int r2 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableStart
            boolean r3 = r11.hasValue(r2)
            if (r3 == 0) goto L_0x0086
            int r2 = r11.getResourceId(r2, r10)
            androidx.appcompat.widget.TintInfo r2 = createTintInfo(r8, r9, r2)
            r0.mDrawableStartTint = r2
        L_0x0086:
            int r2 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableEnd
            boolean r3 = r11.hasValue(r2)
            if (r3 == 0) goto L_0x0098
            int r2 = r11.getResourceId(r2, r10)
            androidx.appcompat.widget.TintInfo r2 = createTintInfo(r8, r9, r2)
            r0.mDrawableEndTint = r2
        L_0x0098:
            r11.recycle()
            android.widget.TextView r2 = r0.mView
            android.text.method.TransformationMethod r2 = r2.getTransformationMethod()
            boolean r2 = r2 instanceof android.text.method.PasswordTransformationMethod
            r3 = 26
            if (r1 == r7) goto L_0x00e6
            int[] r12 = androidx.appcompat.R.styleable.TextAppearance
            androidx.appcompat.widget.TintTypedArray r1 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes((android.content.Context) r8, (int) r1, (int[]) r12)
            if (r2 != 0) goto L_0x00bd
            int r12 = androidx.appcompat.R.styleable.TextAppearance_textAllCaps
            boolean r13 = r1.hasValue(r12)
            if (r13 == 0) goto L_0x00bd
            boolean r12 = r1.getBoolean(r12, r10)
            r13 = 1
            goto L_0x00bf
        L_0x00bd:
            r12 = r10
            r13 = r12
        L_0x00bf:
            r0.updateTypefaceAndStyle(r8, r1)
            int r14 = android.os.Build.VERSION.SDK_INT
            int r15 = androidx.appcompat.R.styleable.TextAppearance_textLocale
            boolean r16 = r1.hasValue(r15)
            if (r16 == 0) goto L_0x00d1
            java.lang.String r15 = r1.getString(r15)
            goto L_0x00d2
        L_0x00d1:
            r15 = 0
        L_0x00d2:
            if (r14 < r3) goto L_0x00e1
            int r14 = androidx.appcompat.R.styleable.TextAppearance_fontVariationSettings
            boolean r16 = r1.hasValue(r14)
            if (r16 == 0) goto L_0x00e1
            java.lang.String r14 = r1.getString(r14)
            goto L_0x00e2
        L_0x00e1:
            r14 = 0
        L_0x00e2:
            r1.recycle()
            goto L_0x00ea
        L_0x00e6:
            r12 = r10
            r13 = r12
            r14 = 0
            r15 = 0
        L_0x00ea:
            int[] r1 = androidx.appcompat.R.styleable.TextAppearance
            androidx.appcompat.widget.TintTypedArray r1 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(r8, r4, r1, r6, r10)
            if (r2 != 0) goto L_0x0100
            int r5 = androidx.appcompat.R.styleable.TextAppearance_textAllCaps
            boolean r17 = r1.hasValue(r5)
            if (r17 == 0) goto L_0x0100
            boolean r12 = r1.getBoolean(r5, r10)
            r5 = 1
            goto L_0x0101
        L_0x0100:
            r5 = r13
        L_0x0101:
            int r13 = android.os.Build.VERSION.SDK_INT
            int r11 = androidx.appcompat.R.styleable.TextAppearance_textLocale
            boolean r17 = r1.hasValue(r11)
            if (r17 == 0) goto L_0x010f
            java.lang.String r15 = r1.getString(r11)
        L_0x010f:
            if (r13 < r3) goto L_0x011d
            int r3 = androidx.appcompat.R.styleable.TextAppearance_fontVariationSettings
            boolean r11 = r1.hasValue(r3)
            if (r11 == 0) goto L_0x011d
            java.lang.String r14 = r1.getString(r3)
        L_0x011d:
            r3 = 28
            if (r13 < r3) goto L_0x0135
            int r3 = androidx.appcompat.R.styleable.TextAppearance_android_textSize
            boolean r11 = r1.hasValue(r3)
            if (r11 == 0) goto L_0x0135
            int r3 = r1.getDimensionPixelSize(r3, r7)
            if (r3 != 0) goto L_0x0135
            android.widget.TextView r3 = r0.mView
            r11 = 0
            r3.setTextSize(r10, r11)
        L_0x0135:
            r0.updateTypefaceAndStyle(r8, r1)
            r1.recycle()
            if (r2 != 0) goto L_0x0142
            if (r5 == 0) goto L_0x0142
            r0.setAllCaps(r12)
        L_0x0142:
            android.graphics.Typeface r1 = r0.mFontTypeface
            if (r1 == 0) goto L_0x0157
            int r2 = r0.mFontWeight
            if (r2 != r7) goto L_0x0152
            android.widget.TextView r2 = r0.mView
            int r3 = r0.mStyle
            r2.setTypeface(r1, r3)
            goto L_0x0157
        L_0x0152:
            android.widget.TextView r2 = r0.mView
            r2.setTypeface(r1)
        L_0x0157:
            if (r14 == 0) goto L_0x015e
            android.widget.TextView r1 = r0.mView
            androidx.appcompat.widget.AppCompatTextHelper.Api26Impl.setFontVariationSettings(r1, r14)
        L_0x015e:
            if (r15 == 0) goto L_0x017f
            r1 = 24
            if (r13 < r1) goto L_0x016e
            android.widget.TextView r1 = r0.mView
            android.os.LocaleList r2 = androidx.appcompat.widget.AppCompatTextHelper.Api24Impl.forLanguageTags(r15)
            androidx.appcompat.widget.AppCompatTextHelper.Api24Impl.setTextLocales(r1, r2)
            goto L_0x017f
        L_0x016e:
            java.lang.String r1 = ","
            java.lang.String[] r1 = r15.split(r1)
            r1 = r1[r10]
            android.widget.TextView r2 = r0.mView
            java.util.Locale r1 = androidx.appcompat.widget.AppCompatTextHelper.Api21Impl.forLanguageTag(r1)
            r2.setTextLocale(r1)
        L_0x017f:
            androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper r1 = r0.mAutoSizeTextHelper
            r1.loadFromAttributes(r4, r6)
            boolean r1 = androidx.appcompat.widget.ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE
            r11 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 == 0) goto L_0x01c3
            androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper r1 = r0.mAutoSizeTextHelper
            int r1 = r1.getAutoSizeTextType()
            if (r1 == 0) goto L_0x01c3
            androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper r1 = r0.mAutoSizeTextHelper
            int[] r1 = r1.getAutoSizeTextAvailableSizes()
            int r2 = r1.length
            if (r2 <= 0) goto L_0x01c3
            android.widget.TextView r2 = r0.mView
            int r2 = androidx.appcompat.widget.AppCompatTextHelper.Api26Impl.getAutoSizeStepGranularity(r2)
            float r2 = (float) r2
            int r2 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r2 == 0) goto L_0x01be
            android.widget.TextView r1 = r0.mView
            androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper r2 = r0.mAutoSizeTextHelper
            int r2 = r2.getAutoSizeMinTextSize()
            androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper r3 = r0.mAutoSizeTextHelper
            int r3 = r3.getAutoSizeMaxTextSize()
            androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper r5 = r0.mAutoSizeTextHelper
            int r5 = r5.getAutoSizeStepGranularity()
            androidx.appcompat.widget.AppCompatTextHelper.Api26Impl.setAutoSizeTextTypeUniformWithConfiguration(r1, r2, r3, r5, r10)
            goto L_0x01c3
        L_0x01be:
            android.widget.TextView r2 = r0.mView
            androidx.appcompat.widget.AppCompatTextHelper.Api26Impl.setAutoSizeTextTypeUniformWithPresetSizes(r2, r1, r10)
        L_0x01c3:
            int[] r1 = androidx.appcompat.R.styleable.AppCompatTextView
            androidx.appcompat.widget.TintTypedArray r10 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes((android.content.Context) r8, (android.util.AttributeSet) r4, (int[]) r1)
            int r1 = androidx.appcompat.R.styleable.AppCompatTextView_drawableLeftCompat
            int r1 = r10.getResourceId(r1, r7)
            if (r1 == r7) goto L_0x01d6
            android.graphics.drawable.Drawable r1 = r9.getDrawable(r8, r1)
            goto L_0x01d7
        L_0x01d6:
            r1 = 0
        L_0x01d7:
            int r2 = androidx.appcompat.R.styleable.AppCompatTextView_drawableTopCompat
            int r2 = r10.getResourceId(r2, r7)
            if (r2 == r7) goto L_0x01e4
            android.graphics.drawable.Drawable r2 = r9.getDrawable(r8, r2)
            goto L_0x01e5
        L_0x01e4:
            r2 = 0
        L_0x01e5:
            int r3 = androidx.appcompat.R.styleable.AppCompatTextView_drawableRightCompat
            int r3 = r10.getResourceId(r3, r7)
            if (r3 == r7) goto L_0x01f2
            android.graphics.drawable.Drawable r3 = r9.getDrawable(r8, r3)
            goto L_0x01f3
        L_0x01f2:
            r3 = 0
        L_0x01f3:
            int r4 = androidx.appcompat.R.styleable.AppCompatTextView_drawableBottomCompat
            int r4 = r10.getResourceId(r4, r7)
            if (r4 == r7) goto L_0x0200
            android.graphics.drawable.Drawable r4 = r9.getDrawable(r8, r4)
            goto L_0x0201
        L_0x0200:
            r4 = 0
        L_0x0201:
            int r5 = androidx.appcompat.R.styleable.AppCompatTextView_drawableStartCompat
            int r5 = r10.getResourceId(r5, r7)
            if (r5 == r7) goto L_0x020e
            android.graphics.drawable.Drawable r5 = r9.getDrawable(r8, r5)
            goto L_0x020f
        L_0x020e:
            r5 = 0
        L_0x020f:
            int r6 = androidx.appcompat.R.styleable.AppCompatTextView_drawableEndCompat
            int r6 = r10.getResourceId(r6, r7)
            if (r6 == r7) goto L_0x021c
            android.graphics.drawable.Drawable r6 = r9.getDrawable(r8, r6)
            goto L_0x021d
        L_0x021c:
            r6 = 0
        L_0x021d:
            r0.setCompoundDrawables(r1, r2, r3, r4, r5, r6)
            int r1 = androidx.appcompat.R.styleable.AppCompatTextView_drawableTint
            boolean r2 = r10.hasValue(r1)
            if (r2 == 0) goto L_0x0231
            android.content.res.ColorStateList r1 = r10.getColorStateList(r1)
            android.widget.TextView r2 = r0.mView
            androidx.core.widget.TextViewCompat.setCompoundDrawableTintList(r2, r1)
        L_0x0231:
            int r1 = androidx.appcompat.R.styleable.AppCompatTextView_drawableTintMode
            boolean r2 = r10.hasValue(r1)
            if (r2 == 0) goto L_0x0247
            int r1 = r10.getInt(r1, r7)
            r2 = 0
            android.graphics.PorterDuff$Mode r1 = androidx.appcompat.widget.DrawableUtils.parseTintMode(r1, r2)
            android.widget.TextView r2 = r0.mView
            androidx.core.widget.TextViewCompat.setCompoundDrawableTintMode(r2, r1)
        L_0x0247:
            int r1 = androidx.appcompat.R.styleable.AppCompatTextView_firstBaselineToTopHeight
            int r1 = r10.getDimensionPixelSize(r1, r7)
            int r2 = androidx.appcompat.R.styleable.AppCompatTextView_lastBaselineToBottomHeight
            int r2 = r10.getDimensionPixelSize(r2, r7)
            int r3 = androidx.appcompat.R.styleable.AppCompatTextView_lineHeight
            boolean r4 = r10.hasValue(r3)
            if (r4 == 0) goto L_0x027a
            android.util.TypedValue r4 = r10.peekValue(r3)
            if (r4 == 0) goto L_0x0273
            int r5 = r4.type
            r6 = 5
            if (r5 != r6) goto L_0x0273
            int r3 = r4.data
            int r3 = androidx.core.util.TypedValueCompat.getUnitFromComplexDimension(r3)
            int r4 = r4.data
            float r4 = android.util.TypedValue.complexToFloat(r4)
            goto L_0x027c
        L_0x0273:
            int r3 = r10.getDimensionPixelSize(r3, r7)
            float r4 = (float) r3
            r3 = r7
            goto L_0x027c
        L_0x027a:
            r3 = r7
            r4 = r11
        L_0x027c:
            r10.recycle()
            if (r1 == r7) goto L_0x0286
            android.widget.TextView r5 = r0.mView
            androidx.core.widget.TextViewCompat.setFirstBaselineToTopHeight(r5, r1)
        L_0x0286:
            if (r2 == r7) goto L_0x028d
            android.widget.TextView r1 = r0.mView
            androidx.core.widget.TextViewCompat.setLastBaselineToBottomHeight(r1, r2)
        L_0x028d:
            int r1 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r1 == 0) goto L_0x029f
            if (r3 != r7) goto L_0x029a
            android.widget.TextView r1 = r0.mView
            int r2 = (int) r4
            androidx.core.widget.TextViewCompat.setLineHeight(r1, r2)
            return
        L_0x029a:
            android.widget.TextView r1 = r0.mView
            androidx.core.widget.TextViewCompat.setLineHeight(r1, r3, r4)
        L_0x029f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatTextHelper.loadFromAttributes(android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: package-private */
    public void onAsyncTypefaceReceived(WeakReference<TextView> weakReference, final Typeface typeface) {
        if (this.mAsyncFontPending) {
            this.mFontTypeface = typeface;
            final TextView textView = weakReference.get();
            if (textView == null) {
                return;
            }
            if (textView.isAttachedToWindow()) {
                final int i5 = this.mStyle;
                textView.post(new Runnable() {
                    public void run() {
                        textView.setTypeface(typeface, i5);
                    }
                });
                return;
            }
            textView.setTypeface(typeface, this.mStyle);
        }
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        if (!ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            autoSizeText();
        }
    }

    /* access modifiers changed from: package-private */
    public void onSetCompoundDrawables() {
        applyCompoundDrawablesTints();
    }

    /* access modifiers changed from: package-private */
    public void onSetTextAppearance(Context context, int i5) {
        String string;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, i5, R.styleable.TextAppearance);
        int i6 = R.styleable.TextAppearance_textAllCaps;
        if (obtainStyledAttributes.hasValue(i6)) {
            setAllCaps(obtainStyledAttributes.getBoolean(i6, false));
        }
        int i7 = Build.VERSION.SDK_INT;
        int i8 = R.styleable.TextAppearance_android_textSize;
        if (obtainStyledAttributes.hasValue(i8) && obtainStyledAttributes.getDimensionPixelSize(i8, -1) == 0) {
            this.mView.setTextSize(0, 0.0f);
        }
        updateTypefaceAndStyle(context, obtainStyledAttributes);
        if (i7 >= 26) {
            int i9 = R.styleable.TextAppearance_fontVariationSettings;
            if (obtainStyledAttributes.hasValue(i9) && (string = obtainStyledAttributes.getString(i9)) != null) {
                Api26Impl.setFontVariationSettings(this.mView, string);
            }
        }
        obtainStyledAttributes.recycle();
        Typeface typeface = this.mFontTypeface;
        if (typeface != null) {
            this.mView.setTypeface(typeface, this.mStyle);
        }
    }

    /* access modifiers changed from: package-private */
    public void populateSurroundingTextIfNeeded(@NonNull TextView textView, @Nullable InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT < 30 && inputConnection != null) {
            EditorInfoCompat.setInitialSurroundingText(editorInfo, textView.getText());
        }
    }

    /* access modifiers changed from: package-private */
    public void setAllCaps(boolean z4) {
        this.mView.setAllCaps(z4);
    }

    /* access modifiers changed from: package-private */
    public void setAutoSizeTextTypeUniformWithConfiguration(int i5, int i6, int i7, int i8) throws IllegalArgumentException {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithConfiguration(i5, i6, i7, i8);
    }

    /* access modifiers changed from: package-private */
    public void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] iArr, int i5) throws IllegalArgumentException {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i5);
    }

    /* access modifiers changed from: package-private */
    public void setAutoSizeTextTypeWithDefaults(int i5) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeWithDefaults(i5);
    }

    /* access modifiers changed from: package-private */
    public void setCompoundDrawableTintList(@Nullable ColorStateList colorStateList) {
        boolean z4;
        if (this.mDrawableTint == null) {
            this.mDrawableTint = new TintInfo();
        }
        TintInfo tintInfo = this.mDrawableTint;
        tintInfo.mTintList = colorStateList;
        if (colorStateList != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        tintInfo.mHasTintList = z4;
        setCompoundTints();
    }

    /* access modifiers changed from: package-private */
    public void setCompoundDrawableTintMode(@Nullable PorterDuff.Mode mode) {
        boolean z4;
        if (this.mDrawableTint == null) {
            this.mDrawableTint = new TintInfo();
        }
        TintInfo tintInfo = this.mDrawableTint;
        tintInfo.mTintMode = mode;
        if (mode != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        tintInfo.mHasTintMode = z4;
        setCompoundTints();
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setTextSize(int i5, float f5) {
        if (!ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE && !isAutoSizeEnabled()) {
            setTextSizeInternal(i5, f5);
        }
    }
}
