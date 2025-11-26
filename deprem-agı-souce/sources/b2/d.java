package B2;

import M1.e;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import androidx.core.content.ContextCompat;
import com.uptodown.R;
import kotlin.jvm.internal.t;

public final class d implements e {

    /* renamed from: a  reason: collision with root package name */
    private final Context f17335a;

    public d(Context context) {
        t.e(context, "context");
        this.f17335a = context;
    }

    public Bitmap a(Bitmap bitmap) {
        Bitmap bitmap2 = bitmap;
        t.e(bitmap2, "source");
        int width = bitmap2.getWidth();
        int height = bitmap2.getHeight();
        int i5 = height / 3;
        Bitmap createBitmap = Bitmap.createBitmap(bitmap2);
        t.d(createBitmap, "createBitmap(...)");
        if (bitmap2.getConfig() != null) {
            Bitmap.Config config = bitmap2.getConfig();
            t.b(config);
            createBitmap = Bitmap.createBitmap(width, height, config);
        }
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
        float f5 = (float) (height - i5);
        float f6 = (float) height;
        LinearGradient linearGradient = new LinearGradient(0.0f, f5, 0.0f, f6, 0, ContextCompat.getColor(this.f17335a, R.color.background_color), Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setShader(linearGradient);
        canvas.drawRect(0.0f, f5, (float) width, f6, paint);
        bitmap2.recycle();
        return createBitmap;
    }

    public String key() {
        return "bottomGradient";
    }
}
