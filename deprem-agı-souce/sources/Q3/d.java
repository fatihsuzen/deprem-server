package Q3;

import android.text.Editable;
import android.text.style.LeadingMarginSpan;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import kotlin.jvm.internal.t;

public final class d extends c {

    /* renamed from: c  reason: collision with root package name */
    public int f18946c = 1;

    public final void a(Editable editable) {
        t.e(editable, MimeTypes.BASE_TYPE_TEXT);
        t.e(editable, MimeTypes.BASE_TYPE_TEXT);
        if (editable.length() > 0 && editable.charAt(editable.length() - 1) != 10) {
            editable.append("\n");
        }
        editable.setSpan(this, editable.length(), editable.length(), 17);
        int i5 = this.f18946c;
        this.f18946c = i5 + 1;
        editable.append(String.valueOf(i5)).append(". ");
    }

    public final Object[] b(int i5) {
        int i6 = this.f18944a;
        int i7 = (i5 - 1) * i6;
        if (i5 > 2) {
            i7 -= (i5 - 2) * i6;
        }
        return new Object[]{new LeadingMarginSpan.Standard(i7)};
    }
}
