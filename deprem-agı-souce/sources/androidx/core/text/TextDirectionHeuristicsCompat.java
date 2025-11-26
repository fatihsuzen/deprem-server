package androidx.core.text;

import java.nio.CharBuffer;
import java.util.Locale;

public final class TextDirectionHeuristicsCompat {
    public static final TextDirectionHeuristicCompat ANYRTL_LTR = new TextDirectionHeuristicInternal(AnyStrong.INSTANCE_RTL, false);
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_LTR;
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_RTL;
    public static final TextDirectionHeuristicCompat LOCALE = TextDirectionHeuristicLocale.INSTANCE;
    public static final TextDirectionHeuristicCompat LTR = new TextDirectionHeuristicInternal((TextDirectionAlgorithm) null, false);
    public static final TextDirectionHeuristicCompat RTL = new TextDirectionHeuristicInternal((TextDirectionAlgorithm) null, true);
    private static final int STATE_FALSE = 1;
    private static final int STATE_TRUE = 0;
    private static final int STATE_UNKNOWN = 2;

    private static class AnyStrong implements TextDirectionAlgorithm {
        static final AnyStrong INSTANCE_RTL = new AnyStrong(true);
        private final boolean mLookForRtl;

        private AnyStrong(boolean z4) {
            this.mLookForRtl = z4;
        }

        public int checkRtl(CharSequence charSequence, int i5, int i6) {
            int i7 = i6 + i5;
            boolean z4 = false;
            while (i5 < i7) {
                int isRtlText = TextDirectionHeuristicsCompat.isRtlText(Character.getDirectionality(charSequence.charAt(i5)));
                if (isRtlText != 0) {
                    if (isRtlText != 1) {
                        continue;
                        i5++;
                    } else if (!this.mLookForRtl) {
                        return 1;
                    }
                } else if (this.mLookForRtl) {
                    return 0;
                }
                z4 = true;
                i5++;
            }
            if (z4) {
                return this.mLookForRtl ? 1 : 0;
            }
            return 2;
        }
    }

    private static class FirstStrong implements TextDirectionAlgorithm {
        static final FirstStrong INSTANCE = new FirstStrong();

        private FirstStrong() {
        }

        public int checkRtl(CharSequence charSequence, int i5, int i6) {
            int i7 = i6 + i5;
            int i8 = 2;
            while (i5 < i7 && i8 == 2) {
                i8 = TextDirectionHeuristicsCompat.isRtlTextOrFormat(Character.getDirectionality(charSequence.charAt(i5)));
                i5++;
            }
            return i8;
        }
    }

    private interface TextDirectionAlgorithm {
        int checkRtl(CharSequence charSequence, int i5, int i6);
    }

    private static abstract class TextDirectionHeuristicImpl implements TextDirectionHeuristicCompat {
        private final TextDirectionAlgorithm mAlgorithm;

        TextDirectionHeuristicImpl(TextDirectionAlgorithm textDirectionAlgorithm) {
            this.mAlgorithm = textDirectionAlgorithm;
        }

        private boolean doCheck(CharSequence charSequence, int i5, int i6) {
            int checkRtl = this.mAlgorithm.checkRtl(charSequence, i5, i6);
            if (checkRtl == 0) {
                return true;
            }
            if (checkRtl != 1) {
                return defaultIsRtl();
            }
            return false;
        }

        /* access modifiers changed from: protected */
        public abstract boolean defaultIsRtl();

        public boolean isRtl(char[] cArr, int i5, int i6) {
            return isRtl((CharSequence) CharBuffer.wrap(cArr), i5, i6);
        }

        public boolean isRtl(CharSequence charSequence, int i5, int i6) {
            if (charSequence == null || i5 < 0 || i6 < 0 || charSequence.length() - i6 < i5) {
                throw new IllegalArgumentException();
            } else if (this.mAlgorithm == null) {
                return defaultIsRtl();
            } else {
                return doCheck(charSequence, i5, i6);
            }
        }
    }

    private static class TextDirectionHeuristicInternal extends TextDirectionHeuristicImpl {
        private final boolean mDefaultIsRtl;

        TextDirectionHeuristicInternal(TextDirectionAlgorithm textDirectionAlgorithm, boolean z4) {
            super(textDirectionAlgorithm);
            this.mDefaultIsRtl = z4;
        }

        /* access modifiers changed from: protected */
        public boolean defaultIsRtl() {
            return this.mDefaultIsRtl;
        }
    }

    private static class TextDirectionHeuristicLocale extends TextDirectionHeuristicImpl {
        static final TextDirectionHeuristicLocale INSTANCE = new TextDirectionHeuristicLocale();

        TextDirectionHeuristicLocale() {
            super((TextDirectionAlgorithm) null);
        }

        /* access modifiers changed from: protected */
        public boolean defaultIsRtl() {
            if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
                return true;
            }
            return false;
        }
    }

    static {
        FirstStrong firstStrong = FirstStrong.INSTANCE;
        FIRSTSTRONG_LTR = new TextDirectionHeuristicInternal(firstStrong, false);
        FIRSTSTRONG_RTL = new TextDirectionHeuristicInternal(firstStrong, true);
    }

    private TextDirectionHeuristicsCompat() {
    }

    static int isRtlText(int i5) {
        if (i5 != 0) {
            return (i5 == 1 || i5 == 2) ? 0 : 2;
        }
        return 1;
    }

    static int isRtlTextOrFormat(int i5) {
        if (i5 != 0) {
            if (i5 == 1 || i5 == 2) {
                return 0;
            }
            switch (i5) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
