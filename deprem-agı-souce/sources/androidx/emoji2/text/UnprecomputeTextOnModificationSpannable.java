package androidx.emoji2.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.text.b;
import j$.util.stream.IntStream;

class UnprecomputeTextOnModificationSpannable implements Spannable {
    @NonNull
    private Spannable mDelegate;
    private boolean mSafeToWrite = false;

    @RequiresApi(24)
    private static class CharSequenceHelper_API24 {
        private CharSequenceHelper_API24() {
        }

        static IntStream chars(CharSequence charSequence) {
            return IntStream.VivifiedWrapper.convert(charSequence.chars());
        }

        static IntStream codePoints(CharSequence charSequence) {
            return IntStream.VivifiedWrapper.convert(charSequence.codePoints());
        }
    }

    static class PrecomputedTextDetector {
        PrecomputedTextDetector() {
        }

        /* access modifiers changed from: package-private */
        public boolean isPrecomputedText(CharSequence charSequence) {
            return charSequence instanceof PrecomputedTextCompat;
        }
    }

    @RequiresApi(28)
    static class PrecomputedTextDetector_28 extends PrecomputedTextDetector {
        PrecomputedTextDetector_28() {
        }

        /* access modifiers changed from: package-private */
        public boolean isPrecomputedText(CharSequence charSequence) {
            if (b.a(charSequence) || (charSequence instanceof PrecomputedTextCompat)) {
                return true;
            }
            return false;
        }
    }

    UnprecomputeTextOnModificationSpannable(@NonNull Spannable spannable) {
        this.mDelegate = spannable;
    }

    private void ensureSafeWrites() {
        Spannable spannable = this.mDelegate;
        if (!this.mSafeToWrite && precomputedTextDetector().isPrecomputedText(spannable)) {
            this.mDelegate = new SpannableString(spannable);
        }
        this.mSafeToWrite = true;
    }

    static PrecomputedTextDetector precomputedTextDetector() {
        if (Build.VERSION.SDK_INT < 28) {
            return new PrecomputedTextDetector();
        }
        return new PrecomputedTextDetector_28();
    }

    public char charAt(int i5) {
        return this.mDelegate.charAt(i5);
    }

    public int getSpanEnd(Object obj) {
        return this.mDelegate.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        return this.mDelegate.getSpanFlags(obj);
    }

    public int getSpanStart(Object obj) {
        return this.mDelegate.getSpanStart(obj);
    }

    public <T> T[] getSpans(int i5, int i6, Class<T> cls) {
        return this.mDelegate.getSpans(i5, i6, cls);
    }

    /* access modifiers changed from: package-private */
    public Spannable getUnwrappedSpannable() {
        return this.mDelegate;
    }

    public int length() {
        return this.mDelegate.length();
    }

    public int nextSpanTransition(int i5, int i6, Class cls) {
        return this.mDelegate.nextSpanTransition(i5, i6, cls);
    }

    public void removeSpan(Object obj) {
        ensureSafeWrites();
        this.mDelegate.removeSpan(obj);
    }

    public void setSpan(Object obj, int i5, int i6, int i7) {
        ensureSafeWrites();
        this.mDelegate.setSpan(obj, i5, i6, i7);
    }

    @NonNull
    public CharSequence subSequence(int i5, int i6) {
        return this.mDelegate.subSequence(i5, i6);
    }

    @NonNull
    public String toString() {
        return this.mDelegate.toString();
    }

    @RequiresApi(api = 24)
    @NonNull
    public IntStream chars() {
        return CharSequenceHelper_API24.chars(this.mDelegate);
    }

    @RequiresApi(api = 24)
    @NonNull
    public IntStream codePoints() {
        return CharSequenceHelper_API24.codePoints(this.mDelegate);
    }

    UnprecomputeTextOnModificationSpannable(@NonNull Spanned spanned) {
        this.mDelegate = new SpannableString(spanned);
    }

    UnprecomputeTextOnModificationSpannable(@NonNull CharSequence charSequence) {
        this.mDelegate = new SpannableString(charSequence);
    }
}
