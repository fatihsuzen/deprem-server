package O1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.uptodown.activities.MainActivity;

public final /* synthetic */ class Q0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TextView f3413a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageView f3414b;

    public /* synthetic */ Q0(TextView textView, ImageView imageView) {
        this.f3413a = textView;
        this.f3414b = imageView;
    }

    public final void onClick(View view) {
        MainActivity.v7(this.f3413a, this.f3414b, view);
    }
}
