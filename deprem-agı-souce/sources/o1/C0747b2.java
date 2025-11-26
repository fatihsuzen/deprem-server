package O1;

import android.view.View;
import android.widget.TextView;
import com.uptodown.activities.MoreInfo;

/* renamed from: O1.b2  reason: case insensitive filesystem */
public final /* synthetic */ class C0747b2 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MoreInfo f3574a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TextView f3575b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f3576c;

    public /* synthetic */ C0747b2(MoreInfo moreInfo, TextView textView, View view) {
        this.f3574a = moreInfo;
        this.f3575b = textView;
        this.f3576c = view;
    }

    public final void onClick(View view) {
        MoreInfo.P3(this.f3574a, this.f3575b, this.f3576c, view);
    }
}
