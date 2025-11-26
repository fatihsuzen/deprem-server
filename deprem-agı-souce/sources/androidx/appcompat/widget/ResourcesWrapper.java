package androidx.appcompat.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.annotation.RequiresApi;
import androidx.core.content.res.ResourcesCompat;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

class ResourcesWrapper extends Resources {
    private final Resources mResources;

    public ResourcesWrapper(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.mResources = resources;
    }

    public XmlResourceParser getAnimation(int i5) throws Resources.NotFoundException {
        return this.mResources.getAnimation(i5);
    }

    public boolean getBoolean(int i5) throws Resources.NotFoundException {
        return this.mResources.getBoolean(i5);
    }

    public int getColor(int i5) throws Resources.NotFoundException {
        return this.mResources.getColor(i5);
    }

    public ColorStateList getColorStateList(int i5) throws Resources.NotFoundException {
        return this.mResources.getColorStateList(i5);
    }

    public Configuration getConfiguration() {
        return this.mResources.getConfiguration();
    }

    public float getDimension(int i5) throws Resources.NotFoundException {
        return this.mResources.getDimension(i5);
    }

    public int getDimensionPixelOffset(int i5) throws Resources.NotFoundException {
        return this.mResources.getDimensionPixelOffset(i5);
    }

    public int getDimensionPixelSize(int i5) throws Resources.NotFoundException {
        return this.mResources.getDimensionPixelSize(i5);
    }

    public DisplayMetrics getDisplayMetrics() {
        return this.mResources.getDisplayMetrics();
    }

    public Drawable getDrawable(int i5) throws Resources.NotFoundException {
        return this.mResources.getDrawable(i5);
    }

    /* access modifiers changed from: package-private */
    public final Drawable getDrawableCanonical(int i5) throws Resources.NotFoundException {
        return super.getDrawable(i5);
    }

    public Drawable getDrawableForDensity(int i5, int i6) throws Resources.NotFoundException {
        return ResourcesCompat.getDrawableForDensity(this.mResources, i5, i6, (Resources.Theme) null);
    }

    public float getFraction(int i5, int i6, int i7) {
        return this.mResources.getFraction(i5, i6, i7);
    }

    public int getIdentifier(String str, String str2, String str3) {
        return this.mResources.getIdentifier(str, str2, str3);
    }

    public int[] getIntArray(int i5) throws Resources.NotFoundException {
        return this.mResources.getIntArray(i5);
    }

    public int getInteger(int i5) throws Resources.NotFoundException {
        return this.mResources.getInteger(i5);
    }

    public XmlResourceParser getLayout(int i5) throws Resources.NotFoundException {
        return this.mResources.getLayout(i5);
    }

    public Movie getMovie(int i5) throws Resources.NotFoundException {
        return this.mResources.getMovie(i5);
    }

    public String getQuantityString(int i5, int i6, Object... objArr) throws Resources.NotFoundException {
        return this.mResources.getQuantityString(i5, i6, objArr);
    }

    public CharSequence getQuantityText(int i5, int i6) throws Resources.NotFoundException {
        return this.mResources.getQuantityText(i5, i6);
    }

    public String getResourceEntryName(int i5) throws Resources.NotFoundException {
        return this.mResources.getResourceEntryName(i5);
    }

    public String getResourceName(int i5) throws Resources.NotFoundException {
        return this.mResources.getResourceName(i5);
    }

    public String getResourcePackageName(int i5) throws Resources.NotFoundException {
        return this.mResources.getResourcePackageName(i5);
    }

    public String getResourceTypeName(int i5) throws Resources.NotFoundException {
        return this.mResources.getResourceTypeName(i5);
    }

    public String getString(int i5) throws Resources.NotFoundException {
        return this.mResources.getString(i5);
    }

    public String[] getStringArray(int i5) throws Resources.NotFoundException {
        return this.mResources.getStringArray(i5);
    }

    public CharSequence getText(int i5) throws Resources.NotFoundException {
        return this.mResources.getText(i5);
    }

    public CharSequence[] getTextArray(int i5) throws Resources.NotFoundException {
        return this.mResources.getTextArray(i5);
    }

    public void getValue(int i5, TypedValue typedValue, boolean z4) throws Resources.NotFoundException {
        this.mResources.getValue(i5, typedValue, z4);
    }

    public void getValueForDensity(int i5, int i6, TypedValue typedValue, boolean z4) throws Resources.NotFoundException {
        this.mResources.getValueForDensity(i5, i6, typedValue, z4);
    }

    public XmlResourceParser getXml(int i5) throws Resources.NotFoundException {
        return this.mResources.getXml(i5);
    }

    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.mResources.obtainAttributes(attributeSet, iArr);
    }

    public TypedArray obtainTypedArray(int i5) throws Resources.NotFoundException {
        return this.mResources.obtainTypedArray(i5);
    }

    public InputStream openRawResource(int i5) throws Resources.NotFoundException {
        return this.mResources.openRawResource(i5);
    }

    public AssetFileDescriptor openRawResourceFd(int i5) throws Resources.NotFoundException {
        return this.mResources.openRawResourceFd(i5);
    }

    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        this.mResources.parseBundleExtra(str, attributeSet, bundle);
    }

    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        this.mResources.parseBundleExtras(xmlResourceParser, bundle);
    }

    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        Resources resources = this.mResources;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    @RequiresApi(21)
    public Drawable getDrawable(int i5, Resources.Theme theme) throws Resources.NotFoundException {
        return ResourcesCompat.getDrawable(this.mResources, i5, theme);
    }

    @RequiresApi(21)
    public Drawable getDrawableForDensity(int i5, int i6, Resources.Theme theme) {
        return ResourcesCompat.getDrawableForDensity(this.mResources, i5, i6, theme);
    }

    public String getQuantityString(int i5, int i6) throws Resources.NotFoundException {
        return this.mResources.getQuantityString(i5, i6);
    }

    public String getString(int i5, Object... objArr) throws Resources.NotFoundException {
        return this.mResources.getString(i5, objArr);
    }

    public CharSequence getText(int i5, CharSequence charSequence) {
        return this.mResources.getText(i5, charSequence);
    }

    public void getValue(String str, TypedValue typedValue, boolean z4) throws Resources.NotFoundException {
        this.mResources.getValue(str, typedValue, z4);
    }

    public InputStream openRawResource(int i5, TypedValue typedValue) throws Resources.NotFoundException {
        return this.mResources.openRawResource(i5, typedValue);
    }
}
