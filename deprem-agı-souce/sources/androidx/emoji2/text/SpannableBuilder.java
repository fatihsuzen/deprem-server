package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class SpannableBuilder extends SpannableStringBuilder {
    @NonNull
    private final Class<?> mWatcherClass;
    @NonNull
    private final List<WatcherWrapper> mWatchers = new ArrayList();

    private static class WatcherWrapper implements TextWatcher, SpanWatcher {
        private final AtomicInteger mBlockCalls = new AtomicInteger(0);
        final Object mObject;

        WatcherWrapper(Object obj) {
            this.mObject = obj;
        }

        private boolean isEmojiSpan(Object obj) {
            return obj instanceof EmojiSpan;
        }

        public void afterTextChanged(Editable editable) {
            ((TextWatcher) this.mObject).afterTextChanged(editable);
        }

        public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
            ((TextWatcher) this.mObject).beforeTextChanged(charSequence, i5, i6, i7);
        }

        /* access modifiers changed from: package-private */
        public final void blockCalls() {
            this.mBlockCalls.incrementAndGet();
        }

        public void onSpanAdded(Spannable spannable, Object obj, int i5, int i6) {
            if (this.mBlockCalls.get() <= 0 || !isEmojiSpan(obj)) {
                ((SpanWatcher) this.mObject).onSpanAdded(spannable, obj, i5, i6);
            }
        }

        public void onSpanChanged(Spannable spannable, Object obj, int i5, int i6, int i7, int i8) {
            int i9;
            int i10;
            if (this.mBlockCalls.get() <= 0 || !isEmojiSpan(obj)) {
                if (Build.VERSION.SDK_INT < 28) {
                    if (i5 > i6) {
                        i5 = 0;
                    }
                    if (i7 > i8) {
                        i10 = i5;
                        i9 = 0;
                        ((SpanWatcher) this.mObject).onSpanChanged(spannable, obj, i10, i6, i9, i8);
                    }
                }
                i10 = i5;
                i9 = i7;
                ((SpanWatcher) this.mObject).onSpanChanged(spannable, obj, i10, i6, i9, i8);
            }
        }

        public void onSpanRemoved(Spannable spannable, Object obj, int i5, int i6) {
            if (this.mBlockCalls.get() <= 0 || !isEmojiSpan(obj)) {
                ((SpanWatcher) this.mObject).onSpanRemoved(spannable, obj, i5, i6);
            }
        }

        public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
            ((TextWatcher) this.mObject).onTextChanged(charSequence, i5, i6, i7);
        }

        /* access modifiers changed from: package-private */
        public final void unblockCalls() {
            this.mBlockCalls.decrementAndGet();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    SpannableBuilder(@NonNull Class<?> cls) {
        Preconditions.checkNotNull(cls, "watcherClass cannot be null");
        this.mWatcherClass = cls;
    }

    private void blockWatchers() {
        for (int i5 = 0; i5 < this.mWatchers.size(); i5++) {
            this.mWatchers.get(i5).blockCalls();
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static SpannableBuilder create(@NonNull Class<?> cls, @NonNull CharSequence charSequence) {
        return new SpannableBuilder(cls, charSequence);
    }

    private void fireWatchers() {
        for (int i5 = 0; i5 < this.mWatchers.size(); i5++) {
            this.mWatchers.get(i5).onTextChanged(this, 0, length(), length());
        }
    }

    private WatcherWrapper getWatcherFor(Object obj) {
        for (int i5 = 0; i5 < this.mWatchers.size(); i5++) {
            WatcherWrapper watcherWrapper = this.mWatchers.get(i5);
            if (watcherWrapper.mObject == obj) {
                return watcherWrapper;
            }
        }
        return null;
    }

    private boolean isWatcher(@Nullable Object obj) {
        return obj != null && isWatcher(obj.getClass());
    }

    private void unblockwatchers() {
        for (int i5 = 0; i5 < this.mWatchers.size(); i5++) {
            this.mWatchers.get(i5).unblockCalls();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void beginBatchEdit() {
        blockWatchers();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void endBatchEdit() {
        unblockwatchers();
        fireWatchers();
    }

    public int getSpanEnd(@Nullable Object obj) {
        WatcherWrapper watcherFor;
        if (isWatcher(obj) && (watcherFor = getWatcherFor(obj)) != null) {
            obj = watcherFor;
        }
        return super.getSpanEnd(obj);
    }

    public int getSpanFlags(@Nullable Object obj) {
        WatcherWrapper watcherFor;
        if (isWatcher(obj) && (watcherFor = getWatcherFor(obj)) != null) {
            obj = watcherFor;
        }
        return super.getSpanFlags(obj);
    }

    public int getSpanStart(@Nullable Object obj) {
        WatcherWrapper watcherFor;
        if (isWatcher(obj) && (watcherFor = getWatcherFor(obj)) != null) {
            obj = watcherFor;
        }
        return super.getSpanStart(obj);
    }

    @SuppressLint({"UnknownNullness"})
    public <T> T[] getSpans(int i5, int i6, @NonNull Class<T> cls) {
        if (!isWatcher((Class<?>) cls)) {
            return super.getSpans(i5, i6, cls);
        }
        WatcherWrapper[] watcherWrapperArr = (WatcherWrapper[]) super.getSpans(i5, i6, WatcherWrapper.class);
        T[] tArr = (Object[]) Array.newInstance(cls, watcherWrapperArr.length);
        for (int i7 = 0; i7 < watcherWrapperArr.length; i7++) {
            tArr[i7] = watcherWrapperArr[i7].mObject;
        }
        return tArr;
    }

    public int nextSpanTransition(int i5, int i6, @Nullable Class<WatcherWrapper> cls) {
        if (cls == null || isWatcher((Class<?>) cls)) {
            cls = WatcherWrapper.class;
        }
        return super.nextSpanTransition(i5, i6, cls);
    }

    public void removeSpan(@Nullable Object obj) {
        WatcherWrapper watcherWrapper;
        if (isWatcher(obj)) {
            watcherWrapper = getWatcherFor(obj);
            if (watcherWrapper != null) {
                obj = watcherWrapper;
            }
        } else {
            watcherWrapper = null;
        }
        super.removeSpan(obj);
        if (watcherWrapper != null) {
            this.mWatchers.remove(watcherWrapper);
        }
    }

    public void setSpan(@Nullable Object obj, int i5, int i6, int i7) {
        if (isWatcher(obj)) {
            WatcherWrapper watcherWrapper = new WatcherWrapper(obj);
            this.mWatchers.add(watcherWrapper);
            obj = watcherWrapper;
        }
        super.setSpan(obj, i5, i6, i7);
    }

    @SuppressLint({"UnknownNullness"})
    public CharSequence subSequence(int i5, int i6) {
        return new SpannableBuilder(this.mWatcherClass, this, i5, i6);
    }

    private boolean isWatcher(@NonNull Class<?> cls) {
        return this.mWatcherClass == cls;
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder delete(int i5, int i6) {
        super.delete(i5, i6);
        return this;
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder insert(int i5, CharSequence charSequence) {
        super.insert(i5, charSequence);
        return this;
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder replace(int i5, int i6, CharSequence charSequence) {
        blockWatchers();
        super.replace(i5, i6, charSequence);
        unblockwatchers();
        return this;
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder insert(int i5, CharSequence charSequence, int i6, int i7) {
        super.insert(i5, charSequence, i6, i7);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    SpannableBuilder(@NonNull Class<?> cls, @NonNull CharSequence charSequence) {
        super(charSequence);
        Preconditions.checkNotNull(cls, "watcherClass cannot be null");
        this.mWatcherClass = cls;
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder replace(int i5, int i6, CharSequence charSequence, int i7, int i8) {
        blockWatchers();
        super.replace(i5, i6, charSequence, i7, i8);
        unblockwatchers();
        return this;
    }

    @NonNull
    public SpannableStringBuilder append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @NonNull
    public SpannableStringBuilder append(char c5) {
        super.append(c5);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    SpannableBuilder(@NonNull Class<?> cls, @NonNull CharSequence charSequence, int i5, int i6) {
        super(charSequence, i5, i6);
        Preconditions.checkNotNull(cls, "watcherClass cannot be null");
        this.mWatcherClass = cls;
    }

    @NonNull
    public SpannableStringBuilder append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i5, int i6) {
        super.append(charSequence, i5, i6);
        return this;
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder append(CharSequence charSequence, Object obj, int i5) {
        super.append(charSequence, obj, i5);
        return this;
    }
}
