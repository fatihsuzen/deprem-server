package O1;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.uptodown.activities.MoreInfo;

/* renamed from: O1.a2  reason: case insensitive filesystem */
public final /* synthetic */ class C0738a2 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TextView f3560a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MoreInfo f3561b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f3562c;

    public /* synthetic */ C0738a2(TextView textView, MoreInfo moreInfo, View view) {
        this.f3560a = textView;
        this.f3561b = moreInfo;
        this.f3562c = view;
    }

    public final void onGlobalLayout() {
        MoreInfo.O3(this.f3560a, this.f3561b, this.f3562c);
    }
}
