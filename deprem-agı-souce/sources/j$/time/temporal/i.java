package j$.time.temporal;

import j$.com.android.tools.r8.a;

public enum i implements s {
    WEEK_BASED_YEARS("WeekBasedYears"),
    QUARTER_YEARS("QuarterYears");
    

    /* renamed from: a  reason: collision with root package name */
    public final String f1188a;

    /* access modifiers changed from: public */
    i(String str) {
        this.f1188a = str;
    }

    public final m e(m mVar, long j5) {
        int i5 = c.f1184a[ordinal()];
        if (i5 == 1) {
            h hVar = j.f1191c;
            return mVar.a(a.x((long) mVar.e(hVar), j5), hVar);
        } else if (i5 == 2) {
            return mVar.b(j5 / 4, b.YEARS).b((j5 % 4) * 3, b.MONTHS);
        } else {
            throw new IllegalStateException("Unreachable");
        }
    }

    public final String toString() {
        return this.f1188a;
    }
}
