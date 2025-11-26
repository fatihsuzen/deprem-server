package O1;

import android.view.animation.Animation;
import android.widget.ImageView;
import com.uptodown.activities.MainActivity;

public final /* synthetic */ class W1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageView f3525a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Animation f3526b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageView f3527c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Animation f3528d;

    public /* synthetic */ W1(ImageView imageView, Animation animation, ImageView imageView2, Animation animation2) {
        this.f3525a = imageView;
        this.f3526b = animation;
        this.f3527c = imageView2;
        this.f3528d = animation2;
    }

    public final void run() {
        MainActivity.C.b(this.f3525a, this.f3526b, this.f3527c, this.f3528d);
    }
}
