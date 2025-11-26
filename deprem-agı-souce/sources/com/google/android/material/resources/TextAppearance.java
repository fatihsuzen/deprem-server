package com.google.android.material.resources;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.text.TextPaint;
import android.util.Log;
import android.util.Xml;
import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TextAppearance {
    private static final String TAG = "TextAppearance";
    private static final int TYPEFACE_MONOSPACE = 3;
    private static final int TYPEFACE_SANS = 1;
    private static final int TYPEFACE_SERIF = 2;
    /* access modifiers changed from: private */
    public Typeface font;
    @Nullable
    public final String fontFamily;
    @FontRes
    private final int fontFamilyResourceId;
    /* access modifiers changed from: private */
    public boolean fontResolved = false;
    @Nullable
    public String fontVariationSettings;
    public final boolean hasLetterSpacing;
    public final float letterSpacing;
    @Nullable
    public final ColorStateList shadowColor;
    public final float shadowDx;
    public final float shadowDy;
    public final float shadowRadius;
    private boolean systemFontLoadAttempted = false;
    public final boolean textAllCaps;
    @Nullable
    private ColorStateList textColor;
    @Nullable
    public final ColorStateList textColorHint;
    @Nullable
    public final ColorStateList textColorLink;
    private float textSize;
    public final int textStyle;
    public final int typeface;

    public TextAppearance(@NonNull Context context, @StyleRes int i5) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i5, R.styleable.TextAppearance);
        setTextSize(obtainStyledAttributes.getDimension(R.styleable.TextAppearance_android_textSize, 0.0f));
        setTextColor(MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColor));
        this.textColorHint = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorHint);
        this.textColorLink = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorLink);
        this.textStyle = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_textStyle, 0);
        this.typeface = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_typeface, 1);
        int indexWithValue = MaterialResources.getIndexWithValue(obtainStyledAttributes, R.styleable.TextAppearance_fontFamily, R.styleable.TextAppearance_android_fontFamily);
        this.fontFamilyResourceId = obtainStyledAttributes.getResourceId(indexWithValue, 0);
        this.fontFamily = obtainStyledAttributes.getString(indexWithValue);
        this.textAllCaps = obtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        this.shadowColor = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.TextAppearance_android_shadowColor);
        this.shadowDx = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.shadowDy = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.shadowRadius = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i5, com.google.android.material.R.styleable.MaterialTextAppearance);
        int i6 = com.google.android.material.R.styleable.MaterialTextAppearance_android_letterSpacing;
        this.hasLetterSpacing = obtainStyledAttributes2.hasValue(i6);
        this.letterSpacing = obtainStyledAttributes2.getFloat(i6, 0.0f);
        if (Build.VERSION.SDK_INT >= 26) {
            this.fontVariationSettings = obtainStyledAttributes2.getString(MaterialResources.getIndexWithValue(obtainStyledAttributes2, com.google.android.material.R.styleable.MaterialTextAppearance_fontVariationSettings, com.google.android.material.R.styleable.MaterialTextAppearance_android_fontVariationSettings));
        }
        obtainStyledAttributes2.recycle();
    }

    private void createFallbackFont() {
        String str;
        if (this.font == null && (str = this.fontFamily) != null) {
            this.font = Typeface.create(str, this.textStyle);
        }
        if (this.font == null) {
            int i5 = this.typeface;
            if (i5 == 1) {
                this.font = Typeface.SANS_SERIF;
            } else if (i5 == 2) {
                this.font = Typeface.SERIF;
            } else if (i5 != 3) {
                this.font = Typeface.DEFAULT;
            } else {
                this.font = Typeface.MONOSPACE;
            }
            this.font = Typeface.create(this.font, this.textStyle);
        }
    }

    @Nullable
    private Typeface getSystemTypeface(Context context) {
        Typeface create;
        if (this.systemFontLoadAttempted) {
            return null;
        }
        this.systemFontLoadAttempted = true;
        String readFontProviderSystemFontFamily = readFontProviderSystemFontFamily(context, this.fontFamilyResourceId);
        if (readFontProviderSystemFontFamily == null || (create = Typeface.create(readFontProviderSystemFontFamily, 0)) == Typeface.DEFAULT) {
            return null;
        }
        return Typeface.create(create, this.textStyle);
    }

    private boolean maybeLoadFontSynchronously(Context context) {
        if (TextAppearanceConfig.shouldLoadFontSynchronously()) {
            getFont(context);
            return true;
        } else if (this.fontResolved) {
            return true;
        } else {
            int i5 = this.fontFamilyResourceId;
            if (i5 == 0) {
                return false;
            }
            Typeface cachedFont = ResourcesCompat.getCachedFont(context, i5);
            if (cachedFont != null) {
                this.font = cachedFont;
                this.fontResolved = true;
                return true;
            }
            Typeface systemTypeface = getSystemTypeface(context);
            if (systemTypeface == null) {
                return false;
            }
            this.font = systemTypeface;
            this.fontResolved = true;
            return true;
        }
    }

    @SuppressLint({"ResourceType"})
    @Nullable
    private static String readFontProviderSystemFontFamily(Context context, @FontRes int i5) {
        Resources resources = context.getResources();
        if (i5 != 0 && resources.getResourceTypeName(i5).equals("font")) {
            try {
                XmlResourceParser xml = resources.getXml(i5);
                while (xml.getEventType() != 1) {
                    if (xml.getEventType() != 2 || !xml.getName().equals("font-family")) {
                        xml.next();
                    } else {
                        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xml), androidx.core.R.styleable.FontFamily);
                        String string = obtainAttributes.getString(androidx.core.R.styleable.FontFamily_fontProviderSystemFontFamily);
                        obtainAttributes.recycle();
                        return string;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public Typeface getFallbackFont() {
        createFallbackFont();
        return this.font;
    }

    @VisibleForTesting
    @NonNull
    public Typeface getFont(@NonNull Context context) {
        if (this.fontResolved) {
            return this.font;
        }
        if (!context.isRestricted()) {
            try {
                Typeface font2 = ResourcesCompat.getFont(context, this.fontFamilyResourceId);
                this.font = font2;
                if (font2 != null) {
                    this.font = Typeface.create(font2, this.textStyle);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e5) {
                Log.d(TAG, "Error loading font " + this.fontFamily, e5);
            }
        }
        createFallbackFont();
        this.fontResolved = true;
        return this.font;
    }

    public void getFontAsync(@NonNull Context context, @NonNull final TextAppearanceFontCallback textAppearanceFontCallback) {
        if (!maybeLoadFontSynchronously(context)) {
            createFallbackFont();
        }
        int i5 = this.fontFamilyResourceId;
        if (i5 == 0) {
            this.fontResolved = true;
        }
        if (this.fontResolved) {
            textAppearanceFontCallback.onFontRetrieved(this.font, true);
            return;
        }
        try {
            ResourcesCompat.getFont(context, i5, new ResourcesCompat.FontCallback() {
                public void onFontRetrievalFailed(int i5) {
                    boolean unused = TextAppearance.this.fontResolved = true;
                    textAppearanceFontCallback.onFontRetrievalFailed(i5);
                }

                public void onFontRetrieved(@NonNull Typeface typeface) {
                    TextAppearance textAppearance = TextAppearance.this;
                    Typeface unused = textAppearance.font = Typeface.create(typeface, textAppearance.textStyle);
                    boolean unused2 = TextAppearance.this.fontResolved = true;
                    textAppearanceFontCallback.onFontRetrieved(TextAppearance.this.font, false);
                }
            }, (Handler) null);
        } catch (Resources.NotFoundException unused) {
            this.fontResolved = true;
            textAppearanceFontCallback.onFontRetrievalFailed(1);
        } catch (Exception e5) {
            Log.d(TAG, "Error loading font " + this.fontFamily, e5);
            this.fontResolved = true;
            textAppearanceFontCallback.onFontRetrievalFailed(-3);
        }
    }

    @RequiresApi(26)
    @Nullable
    public String getFontVariationSettings() {
        return this.fontVariationSettings;
    }

    @Nullable
    public ColorStateList getTextColor() {
        return this.textColor;
    }

    public float getTextSize() {
        return this.textSize;
    }

    @RequiresApi(26)
    public void setFontVariationSettings(@Nullable String str) {
        this.fontVariationSettings = str;
    }

    public void setTextColor(@Nullable ColorStateList colorStateList) {
        this.textColor = colorStateList;
    }

    public void setTextSize(float f5) {
        this.textSize = f5;
    }

    public void updateDrawState(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull TextAppearanceFontCallback textAppearanceFontCallback) {
        int i5;
        int i6;
        updateMeasureState(context, textPaint, textAppearanceFontCallback);
        ColorStateList colorStateList = this.textColor;
        if (colorStateList != null) {
            i5 = colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor());
        } else {
            i5 = ViewCompat.MEASURED_STATE_MASK;
        }
        textPaint.setColor(i5);
        float f5 = this.shadowRadius;
        float f6 = this.shadowDx;
        float f7 = this.shadowDy;
        ColorStateList colorStateList2 = this.shadowColor;
        if (colorStateList2 != null) {
            i6 = colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor());
        } else {
            i6 = 0;
        }
        textPaint.setShadowLayer(f5, f6, f7, i6);
    }

    public void updateMeasureState(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull TextAppearanceFontCallback textAppearanceFontCallback) {
        Typeface typeface2;
        if (!maybeLoadFontSynchronously(context) || !this.fontResolved || (typeface2 = this.font) == null) {
            getFontAsync(context, textPaint, textAppearanceFontCallback);
        } else {
            updateTextPaintMeasureState(context, textPaint, typeface2);
        }
    }

    public void updateTextPaintMeasureState(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull Typeface typeface2) {
        boolean z4;
        float f5;
        Typeface maybeCopyWithFontWeightAdjustment = TypefaceUtils.maybeCopyWithFontWeightAdjustment(context, typeface2);
        if (maybeCopyWithFontWeightAdjustment != null) {
            typeface2 = maybeCopyWithFontWeightAdjustment;
        }
        textPaint.setTypeface(typeface2);
        int i5 = this.textStyle & (~typeface2.getStyle());
        if ((i5 & 1) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        textPaint.setFakeBoldText(z4);
        if ((i5 & 2) != 0) {
            f5 = -0.25f;
        } else {
            f5 = 0.0f;
        }
        textPaint.setTextSkewX(f5);
        textPaint.setTextSize(this.textSize);
        if (Build.VERSION.SDK_INT >= 26) {
            boolean unused = textPaint.setFontVariationSettings(this.fontVariationSettings);
        }
        if (this.hasLetterSpacing) {
            textPaint.setLetterSpacing(this.letterSpacing);
        }
    }

    public void getFontAsync(@NonNull final Context context, @NonNull final TextPaint textPaint, @NonNull final TextAppearanceFontCallback textAppearanceFontCallback) {
        updateTextPaintMeasureState(context, textPaint, getFallbackFont());
        getFontAsync(context, new TextAppearanceFontCallback() {
            public void onFontRetrievalFailed(int i5) {
                textAppearanceFontCallback.onFontRetrievalFailed(i5);
            }

            public void onFontRetrieved(@NonNull Typeface typeface, boolean z4) {
                TextAppearance.this.updateTextPaintMeasureState(context, textPaint, typeface);
                textAppearanceFontCallback.onFontRetrieved(typeface, z4);
            }
        });
    }
}
