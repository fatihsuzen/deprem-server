package androidx.appcompat.widget;

import android.content.Context;
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
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class VectorEnabledTintResources extends ResourcesWrapper {
    public static final int MAX_SDK_WHERE_REQUIRED = 20;
    private static boolean sCompatVectorFromResourcesEnabled = false;
    private final WeakReference<Context> mContextRef;

    public VectorEnabledTintResources(@NonNull Context context, @NonNull Resources resources) {
        super(resources);
        this.mContextRef = new WeakReference<>(context);
    }

    public static boolean isCompatVectorFromResourcesEnabled() {
        return sCompatVectorFromResourcesEnabled;
    }

    public static void setCompatVectorFromResourcesEnabled(boolean z4) {
        sCompatVectorFromResourcesEnabled = z4;
    }

    public static boolean shouldBeUsed() {
        isCompatVectorFromResourcesEnabled();
        return false;
    }

    public /* bridge */ /* synthetic */ XmlResourceParser getAnimation(int i5) throws Resources.NotFoundException {
        return super.getAnimation(i5);
    }

    public /* bridge */ /* synthetic */ boolean getBoolean(int i5) throws Resources.NotFoundException {
        return super.getBoolean(i5);
    }

    public /* bridge */ /* synthetic */ int getColor(int i5) throws Resources.NotFoundException {
        return super.getColor(i5);
    }

    public /* bridge */ /* synthetic */ ColorStateList getColorStateList(int i5) throws Resources.NotFoundException {
        return super.getColorStateList(i5);
    }

    public /* bridge */ /* synthetic */ Configuration getConfiguration() {
        return super.getConfiguration();
    }

    public /* bridge */ /* synthetic */ float getDimension(int i5) throws Resources.NotFoundException {
        return super.getDimension(i5);
    }

    public /* bridge */ /* synthetic */ int getDimensionPixelOffset(int i5) throws Resources.NotFoundException {
        return super.getDimensionPixelOffset(i5);
    }

    public /* bridge */ /* synthetic */ int getDimensionPixelSize(int i5) throws Resources.NotFoundException {
        return super.getDimensionPixelSize(i5);
    }

    public /* bridge */ /* synthetic */ DisplayMetrics getDisplayMetrics() {
        return super.getDisplayMetrics();
    }

    @RequiresApi(21)
    public /* bridge */ /* synthetic */ Drawable getDrawable(int i5, Resources.Theme theme) throws Resources.NotFoundException {
        return super.getDrawable(i5, theme);
    }

    public /* bridge */ /* synthetic */ Drawable getDrawableForDensity(int i5, int i6) throws Resources.NotFoundException {
        return super.getDrawableForDensity(i5, i6);
    }

    public /* bridge */ /* synthetic */ float getFraction(int i5, int i6, int i7) {
        return super.getFraction(i5, i6, i7);
    }

    public /* bridge */ /* synthetic */ int getIdentifier(String str, String str2, String str3) {
        return super.getIdentifier(str, str2, str3);
    }

    public /* bridge */ /* synthetic */ int[] getIntArray(int i5) throws Resources.NotFoundException {
        return super.getIntArray(i5);
    }

    public /* bridge */ /* synthetic */ int getInteger(int i5) throws Resources.NotFoundException {
        return super.getInteger(i5);
    }

    public /* bridge */ /* synthetic */ XmlResourceParser getLayout(int i5) throws Resources.NotFoundException {
        return super.getLayout(i5);
    }

    public /* bridge */ /* synthetic */ Movie getMovie(int i5) throws Resources.NotFoundException {
        return super.getMovie(i5);
    }

    public /* bridge */ /* synthetic */ String getQuantityString(int i5, int i6) throws Resources.NotFoundException {
        return super.getQuantityString(i5, i6);
    }

    public /* bridge */ /* synthetic */ CharSequence getQuantityText(int i5, int i6) throws Resources.NotFoundException {
        return super.getQuantityText(i5, i6);
    }

    public /* bridge */ /* synthetic */ String getResourceEntryName(int i5) throws Resources.NotFoundException {
        return super.getResourceEntryName(i5);
    }

    public /* bridge */ /* synthetic */ String getResourceName(int i5) throws Resources.NotFoundException {
        return super.getResourceName(i5);
    }

    public /* bridge */ /* synthetic */ String getResourcePackageName(int i5) throws Resources.NotFoundException {
        return super.getResourcePackageName(i5);
    }

    public /* bridge */ /* synthetic */ String getResourceTypeName(int i5) throws Resources.NotFoundException {
        return super.getResourceTypeName(i5);
    }

    public /* bridge */ /* synthetic */ String getString(int i5) throws Resources.NotFoundException {
        return super.getString(i5);
    }

    public /* bridge */ /* synthetic */ String[] getStringArray(int i5) throws Resources.NotFoundException {
        return super.getStringArray(i5);
    }

    public /* bridge */ /* synthetic */ CharSequence getText(int i5) throws Resources.NotFoundException {
        return super.getText(i5);
    }

    public /* bridge */ /* synthetic */ CharSequence[] getTextArray(int i5) throws Resources.NotFoundException {
        return super.getTextArray(i5);
    }

    public /* bridge */ /* synthetic */ void getValue(int i5, TypedValue typedValue, boolean z4) throws Resources.NotFoundException {
        super.getValue(i5, typedValue, z4);
    }

    public /* bridge */ /* synthetic */ void getValueForDensity(int i5, int i6, TypedValue typedValue, boolean z4) throws Resources.NotFoundException {
        super.getValueForDensity(i5, i6, typedValue, z4);
    }

    public /* bridge */ /* synthetic */ XmlResourceParser getXml(int i5) throws Resources.NotFoundException {
        return super.getXml(i5);
    }

    public /* bridge */ /* synthetic */ TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return super.obtainAttributes(attributeSet, iArr);
    }

    public /* bridge */ /* synthetic */ TypedArray obtainTypedArray(int i5) throws Resources.NotFoundException {
        return super.obtainTypedArray(i5);
    }

    public /* bridge */ /* synthetic */ InputStream openRawResource(int i5) throws Resources.NotFoundException {
        return super.openRawResource(i5);
    }

    public /* bridge */ /* synthetic */ AssetFileDescriptor openRawResourceFd(int i5) throws Resources.NotFoundException {
        return super.openRawResourceFd(i5);
    }

    public /* bridge */ /* synthetic */ void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        super.parseBundleExtra(str, attributeSet, bundle);
    }

    public /* bridge */ /* synthetic */ void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        super.parseBundleExtras(xmlResourceParser, bundle);
    }

    public /* bridge */ /* synthetic */ void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
    }

    public Drawable getDrawable(int i5) throws Resources.NotFoundException {
        Context context = this.mContextRef.get();
        if (context != null) {
            return ResourceManagerInternal.get().onDrawableLoadedFromResources(context, this, i5);
        }
        return getDrawableCanonical(i5);
    }

    @RequiresApi(21)
    public /* bridge */ /* synthetic */ Drawable getDrawableForDensity(int i5, int i6, Resources.Theme theme) {
        return super.getDrawableForDensity(i5, i6, theme);
    }

    public /* bridge */ /* synthetic */ String getQuantityString(int i5, int i6, Object[] objArr) throws Resources.NotFoundException {
        return super.getQuantityString(i5, i6, objArr);
    }

    public /* bridge */ /* synthetic */ String getString(int i5, Object[] objArr) throws Resources.NotFoundException {
        return super.getString(i5, objArr);
    }

    public /* bridge */ /* synthetic */ CharSequence getText(int i5, CharSequence charSequence) {
        return super.getText(i5, charSequence);
    }

    public /* bridge */ /* synthetic */ void getValue(String str, TypedValue typedValue, boolean z4) throws Resources.NotFoundException {
        super.getValue(str, typedValue, z4);
    }

    public /* bridge */ /* synthetic */ InputStream openRawResource(int i5, TypedValue typedValue) throws Resources.NotFoundException {
        return super.openRawResource(i5, typedValue);
    }
}
