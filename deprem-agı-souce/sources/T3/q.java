package t3;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import q3.C2728d;
import q3.C2729e;

public abstract class q {
    /* access modifiers changed from: private */
    public static final C2788l d(Matcher matcher, int i5, CharSequence charSequence) {
        if (!matcher.find(i5)) {
            return null;
        }
        return new C2789m(matcher, charSequence);
    }

    /* access modifiers changed from: private */
    public static final C2728d e(MatchResult matchResult) {
        return C2729e.l(matchResult.start(), matchResult.end());
    }

    /* access modifiers changed from: private */
    public static final C2728d f(MatchResult matchResult, int i5) {
        return C2729e.l(matchResult.start(i5), matchResult.end(i5));
    }
}
