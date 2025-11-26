package Q3;

import android.text.Editable;
import android.text.style.BulletSpan;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import kotlin.jvm.internal.t;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public final int f18944a = 20;

    /* renamed from: b  reason: collision with root package name */
    public final BulletSpan f18945b = new BulletSpan(10);

    public void a(Editable editable) {
        t.e(editable, MimeTypes.BASE_TYPE_TEXT);
        if (editable.length() > 0 && editable.charAt(editable.length() - 1) != 10) {
            editable.append("\n");
        }
        editable.setSpan(this, editable.length(), editable.length(), 17);
    }

    public abstract Object[] b(int i5);
}
