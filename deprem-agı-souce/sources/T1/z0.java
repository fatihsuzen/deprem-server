package T1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.uptodown.core.activities.InstallerActivity;
import kotlin.jvm.internal.I;

public final /* synthetic */ class z0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ I f19201a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TextView f19202b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ InstallerActivity f19203c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ImageView f19204d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TextView f19205e;

    public /* synthetic */ z0(I i5, TextView textView, InstallerActivity installerActivity, ImageView imageView, TextView textView2) {
        this.f19201a = i5;
        this.f19202b = textView;
        this.f19203c = installerActivity;
        this.f19204d = imageView;
        this.f19205e = textView2;
    }

    public final void onClick(View view) {
        InstallerActivity.K1(this.f19201a, this.f19202b, this.f19203c, this.f19204d, this.f19205e, view);
    }
}
