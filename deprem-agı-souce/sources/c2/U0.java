package C2;

import S1.k;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.uptodown.R;
import kotlin.jvm.internal.t;

public final class U0 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f17617a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public U0(View view, String str) {
        super(view);
        t.e(view, "itemView");
        t.e(str, MimeTypes.BASE_TYPE_TEXT);
        View findViewById = view.findViewById(R.id.tv_system_apps_title);
        t.d(findViewById, "findViewById(...)");
        TextView textView = (TextView) findViewById;
        this.f17617a = textView;
        textView.setTypeface(k.f32g.w());
        textView.setText(str);
    }

    public final void a() {
        this.f17617a.setVisibility(0);
    }
}
