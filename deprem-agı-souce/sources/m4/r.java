package m4;

import J2.v;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import kotlin.jvm.internal.t;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    public final int f25487a;

    /* renamed from: b  reason: collision with root package name */
    public final String f25488b;

    /* renamed from: c  reason: collision with root package name */
    public final String f25489c;

    public r(String str, int i5, String str2) {
        t.e(str, "label");
        t.e(str2, MRAIDCommunicatorUtil.KEY_STATE);
        this.f25487a = i5;
        this.f25488b = str;
        this.f25489c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        if (this.f25487a == rVar.f25487a && t.a(this.f25488b, rVar.f25488b) && t.a(this.f25489c, rVar.f25489c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f25489c.hashCode() + v.a(this.f25488b, this.f25487a * 31, 31);
    }

    public final String toString() {
        return "StackInfo(id=" + this.f25487a + ", label=" + this.f25488b + ", state=" + this.f25489c + ')';
    }
}
