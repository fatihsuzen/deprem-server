package androidx.room;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import k3.l;
import kotlin.jvm.internal.t;

final class BaseRoomConnectionManager$DriverWrapper$openLocked$2 implements l {
    final /* synthetic */ String $filename;

    BaseRoomConnectionManager$DriverWrapper$openLocked$2(String str) {
        this.$filename = str;
    }

    public final Void invoke(Throwable th) {
        t.e(th, CampaignEx.JSON_NATIVE_VIDEO_ERROR);
        throw new IllegalStateException("Unable to open database '" + this.$filename + "'. Was a proper path / name used in Room's database builder?", th);
    }
}
