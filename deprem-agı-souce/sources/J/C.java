package J;

import android.os.Bundle;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;

final class C extends C0644A {
    C(int i5, int i6, Bundle bundle) {
        super(i5, i6, bundle);
    }

    /* access modifiers changed from: package-private */
    public final void a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(DataSchemeDataSource.SCHEME_DATA);
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        d(bundle2);
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        return false;
    }
}
