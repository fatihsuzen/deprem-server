package androidx.core.view.inputmethod;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Preconditions;

@SuppressLint({"PrivateConstructorForUtilityClass"})
public final class EditorInfoCompat {
    private static final String CONTENT_MIME_TYPES_INTEROP_KEY = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_MIME_TYPES_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_SELECTION_END_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END";
    private static final String CONTENT_SELECTION_HEAD_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD";
    private static final String CONTENT_SURROUNDING_TEXT_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT";
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final int IME_FLAG_FORCE_ASCII = Integer.MIN_VALUE;
    public static final int IME_FLAG_NO_PERSONALIZED_LEARNING = 16777216;
    @VisibleForTesting
    static final int MAX_INITIAL_SELECTION_LENGTH = 1024;
    @VisibleForTesting
    static final int MEMORY_EFFICIENT_TEXT_LENGTH = 2048;
    private static final String STYLUS_HANDWRITING_ENABLED_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.STYLUS_HANDWRITING_ENABLED";

    @RequiresApi(30)
    private static class Api30Impl {
        private Api30Impl() {
        }

        static CharSequence getInitialSelectedText(@NonNull EditorInfo editorInfo, int i5) {
            return editorInfo.getInitialSelectedText(i5);
        }

        static CharSequence getInitialTextAfterCursor(@NonNull EditorInfo editorInfo, int i5, int i6) {
            return editorInfo.getInitialTextAfterCursor(i5, i6);
        }

        static CharSequence getInitialTextBeforeCursor(@NonNull EditorInfo editorInfo, int i5, int i6) {
            return editorInfo.getInitialTextBeforeCursor(i5, i6);
        }

        static void setInitialSurroundingSubText(@NonNull EditorInfo editorInfo, CharSequence charSequence, int i5) {
            editorInfo.setInitialSurroundingSubText(charSequence, i5);
        }
    }

    @NonNull
    public static String[] getContentMimeTypes(@NonNull EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 25) {
            String[] a5 = editorInfo.contentMimeTypes;
            if (a5 != null) {
                return a5;
            }
            return EMPTY_STRING_ARRAY;
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return EMPTY_STRING_ARRAY;
        }
        String[] stringArray = bundle.getStringArray(CONTENT_MIME_TYPES_KEY);
        if (stringArray == null) {
            stringArray = editorInfo.extras.getStringArray(CONTENT_MIME_TYPES_INTEROP_KEY);
        }
        if (stringArray != null) {
            return stringArray;
        }
        return EMPTY_STRING_ARRAY;
    }

    @Nullable
    public static CharSequence getInitialSelectedText(@NonNull EditorInfo editorInfo, int i5) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getInitialSelectedText(editorInfo, i5);
        }
        if (editorInfo.extras == null) {
            return null;
        }
        int min = Math.min(editorInfo.initialSelStart, editorInfo.initialSelEnd);
        int max = Math.max(editorInfo.initialSelStart, editorInfo.initialSelEnd);
        int i6 = editorInfo.extras.getInt(CONTENT_SELECTION_HEAD_KEY);
        int i7 = editorInfo.extras.getInt(CONTENT_SELECTION_END_KEY);
        int i8 = max - min;
        if (editorInfo.initialSelStart < 0 || editorInfo.initialSelEnd < 0 || i7 - i6 != i8 || (charSequence = editorInfo.extras.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY)) == null) {
            return null;
        }
        if ((i5 & 1) != 0) {
            return charSequence.subSequence(i6, i7);
        }
        return TextUtils.substring(charSequence, i6, i7);
    }

    @Nullable
    public static CharSequence getInitialTextAfterCursor(@NonNull EditorInfo editorInfo, int i5, int i6) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getInitialTextAfterCursor(editorInfo, i5, i6);
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null || (charSequence = bundle.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY)) == null) {
            return null;
        }
        int i7 = editorInfo.extras.getInt(CONTENT_SELECTION_END_KEY);
        int min = Math.min(i5, charSequence.length() - i7);
        if ((i6 & 1) != 0) {
            return charSequence.subSequence(i7, min + i7);
        }
        return TextUtils.substring(charSequence, i7, min + i7);
    }

    @Nullable
    public static CharSequence getInitialTextBeforeCursor(@NonNull EditorInfo editorInfo, int i5, int i6) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getInitialTextBeforeCursor(editorInfo, i5, i6);
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null || (charSequence = bundle.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY)) == null) {
            return null;
        }
        int i7 = editorInfo.extras.getInt(CONTENT_SELECTION_HEAD_KEY);
        int min = Math.min(i5, i7);
        if ((i6 & 1) != 0) {
            return charSequence.subSequence(i7 - min, i7);
        }
        return TextUtils.substring(charSequence, i7 - min, i7);
    }

    static int getProtocol(EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 25) {
            return 1;
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return 0;
        }
        boolean containsKey = bundle.containsKey(CONTENT_MIME_TYPES_KEY);
        boolean containsKey2 = editorInfo.extras.containsKey(CONTENT_MIME_TYPES_INTEROP_KEY);
        if (containsKey && containsKey2) {
            return 4;
        }
        if (containsKey) {
            return 3;
        }
        if (containsKey2) {
            return 2;
        }
        return 0;
    }

    private static boolean isCutOnSurrogate(CharSequence charSequence, int i5, int i6) {
        if (i6 == 0) {
            return Character.isLowSurrogate(charSequence.charAt(i5));
        }
        if (i6 != 1) {
            return false;
        }
        return Character.isHighSurrogate(charSequence.charAt(i5));
    }

    private static boolean isPasswordInputType(int i5) {
        int i6 = i5 & 4095;
        return i6 == 129 || i6 == 225 || i6 == 18;
    }

    public static boolean isStylusHandwritingEnabled(@NonNull EditorInfo editorInfo) {
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return false;
        }
        return bundle.getBoolean(STYLUS_HANDWRITING_ENABLED_KEY);
    }

    public static void setContentMimeTypes(@NonNull EditorInfo editorInfo, @Nullable String[] strArr) {
        if (Build.VERSION.SDK_INT >= 25) {
            editorInfo.contentMimeTypes = strArr;
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putStringArray(CONTENT_MIME_TYPES_KEY, strArr);
        editorInfo.extras.putStringArray(CONTENT_MIME_TYPES_INTEROP_KEY, strArr);
    }

    public static void setInitialSurroundingSubText(@NonNull EditorInfo editorInfo, @NonNull CharSequence charSequence, int i5) {
        int i6;
        int i7;
        Preconditions.checkNotNull(charSequence);
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.setInitialSurroundingSubText(editorInfo, charSequence, i5);
            return;
        }
        int i8 = editorInfo.initialSelStart;
        int i9 = editorInfo.initialSelEnd;
        if (i8 > i9) {
            i6 = i9 - i5;
        } else {
            i6 = i8 - i5;
        }
        if (i8 > i9) {
            i7 = i8 - i5;
        } else {
            i7 = i9 - i5;
        }
        int length = charSequence.length();
        if (i5 < 0 || i6 < 0 || i7 > length) {
            setSurroundingText(editorInfo, (CharSequence) null, 0, 0);
        } else if (isPasswordInputType(editorInfo.inputType)) {
            setSurroundingText(editorInfo, (CharSequence) null, 0, 0);
        } else if (length <= 2048) {
            setSurroundingText(editorInfo, charSequence, i6, i7);
        } else {
            trimLongSurroundingText(editorInfo, charSequence, i6, i7);
        }
    }

    public static void setInitialSurroundingText(@NonNull EditorInfo editorInfo, @NonNull CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.setInitialSurroundingSubText(editorInfo, charSequence, 0);
        } else {
            setInitialSurroundingSubText(editorInfo, charSequence, 0);
        }
    }

    public static void setStylusHandwritingEnabled(@NonNull EditorInfo editorInfo, boolean z4) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putBoolean(STYLUS_HANDWRITING_ENABLED_KEY, z4);
    }

    private static void setSurroundingText(EditorInfo editorInfo, CharSequence charSequence, int i5, int i6) {
        SpannableStringBuilder spannableStringBuilder;
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        if (charSequence != null) {
            spannableStringBuilder = new SpannableStringBuilder(charSequence);
        } else {
            spannableStringBuilder = null;
        }
        editorInfo.extras.putCharSequence(CONTENT_SURROUNDING_TEXT_KEY, spannableStringBuilder);
        editorInfo.extras.putInt(CONTENT_SELECTION_HEAD_KEY, i5);
        editorInfo.extras.putInt(CONTENT_SELECTION_END_KEY, i6);
    }

    private static void trimLongSurroundingText(EditorInfo editorInfo, CharSequence charSequence, int i5, int i6) {
        int i7;
        CharSequence charSequence2;
        int i8 = i6 - i5;
        if (i8 > 1024) {
            i7 = 0;
        } else {
            i7 = i8;
        }
        int i9 = 2048 - i7;
        int min = Math.min(charSequence.length() - i6, i9 - Math.min(i5, (int) (((double) i9) * 0.8d)));
        int min2 = Math.min(i5, i9 - min);
        int i10 = i5 - min2;
        if (isCutOnSurrogate(charSequence, i10, 0)) {
            i10++;
            min2--;
        }
        if (isCutOnSurrogate(charSequence, (i6 + min) - 1, 1)) {
            min--;
        }
        int i11 = min2 + i7 + min;
        if (i7 != i8) {
            charSequence2 = TextUtils.concat(new CharSequence[]{charSequence.subSequence(i10, i10 + min2), charSequence.subSequence(i6, min + i6)});
        } else {
            charSequence2 = charSequence.subSequence(i10, i11 + i10);
        }
        setSurroundingText(editorInfo, charSequence2, min2, i7 + min2);
    }
}
