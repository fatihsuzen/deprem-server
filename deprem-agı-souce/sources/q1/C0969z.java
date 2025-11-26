package Q1;

import S1.k;
import android.content.Context;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.uptodown.R;
import kotlin.jvm.internal.t;

/* renamed from: Q1.z  reason: case insensitive filesystem */
public abstract class C0969z extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        if (context != null) {
            context = k.f32g.a(context);
        }
        super.attachBaseContext(context);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade_in, R.anim.right_to_left_out);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        t.e(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}
