package C1;

import android.os.AsyncTask;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

public abstract class b extends AsyncTask {

    /* renamed from: a  reason: collision with root package name */
    private a f2335a;

    /* renamed from: b  reason: collision with root package name */
    protected final C0042b f2336b;

    public interface a {
        void a(b bVar);
    }

    /* renamed from: C1.b$b  reason: collision with other inner class name */
    public interface C0042b {
        JSONObject a();

        void a(JSONObject jSONObject);
    }

    public b(C0042b bVar) {
        this.f2336b = bVar;
    }

    public void a(a aVar) {
        this.f2335a = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void onPostExecute(String str) {
        a aVar = this.f2335a;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void c(ThreadPoolExecutor threadPoolExecutor) {
        executeOnExecutor(threadPoolExecutor, new Object[0]);
    }
}
