package Q2;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.text.style.ClickableSpan;
import android.view.View;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.model.ChoiceError;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.t;

public final class e extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m f18908a;

    public e(m mVar) {
        this.f18908a = mVar;
    }

    public final void onClick(View view) {
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        try {
            o oVar = this.f18908a.f18925i;
            o oVar2 = null;
            if (oVar == null) {
                t.w("viewModel");
                oVar = null;
            }
            if (oVar.f18940h.f25401g.length() > 0) {
                m mVar = this.f18908a;
                Intent intent = new Intent("android.intent.action.VIEW");
                o oVar3 = this.f18908a.f18925i;
                if (oVar3 == null) {
                    t.w("viewModel");
                } else {
                    oVar2 = oVar3;
                }
                intent.setData(Uri.parse(oVar2.f18940h.f25401g));
                mVar.startActivity(intent);
            }
        } catch (ActivityNotFoundException unused) {
            ChoiceCmpCallback callback = ChoiceCmp.INSTANCE.getCallback();
            if (callback != null) {
                callback.onCmpError(ChoiceError.INVALID_URL);
            }
        }
    }
}
