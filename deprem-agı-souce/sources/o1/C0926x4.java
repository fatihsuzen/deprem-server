package O1;

import android.view.View;
import com.uptodown.activities.PublicProfileActivity;
import l2.V;

/* renamed from: O1.x4  reason: case insensitive filesystem */
public final /* synthetic */ class C0926x4 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ V f3840a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PublicProfileActivity f3841b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ V f3842c;

    public /* synthetic */ C0926x4(V v5, PublicProfileActivity publicProfileActivity, V v6) {
        this.f3840a = v5;
        this.f3841b = publicProfileActivity;
        this.f3842c = v6;
    }

    public final void onClick(View view) {
        PublicProfileActivity.J3(this.f3840a, this.f3841b, this.f3842c, view);
    }
}
