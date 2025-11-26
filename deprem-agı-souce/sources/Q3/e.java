package Q3;

import android.text.style.BulletSpan;
import android.text.style.LeadingMarginSpan;

public final class e extends c {
    public final Object[] b(int i5) {
        int i6 = 10;
        if (i5 > 1) {
            i6 = 10 - this.f18945b.getLeadingMargin(true);
            if (i5 > 2) {
                i6 -= (i5 - 2) * this.f18944a;
            }
        }
        return new Object[]{new LeadingMarginSpan.Standard((i5 - 1) * this.f18944a), new BulletSpan(i6)};
    }
}
