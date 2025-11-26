package C1;

import C1.b;
import android.text.TextUtils;
import java.util.HashSet;
import org.json.JSONObject;
import u1.n;
import x1.c;

public class f extends a {
    public f(b.C0042b bVar, HashSet hashSet, JSONObject jSONObject, long j5) {
        super(bVar, hashSet, jSONObject, j5);
    }

    private void e(String str) {
        c e5 = c.e();
        if (e5 != null) {
            for (n nVar : e5.c()) {
                if (this.f2332c.contains(nVar.s())) {
                    nVar.t().p(str, this.f2334e);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void onPostExecute(String str) {
        if (!TextUtils.isEmpty(str)) {
            e(str);
        }
        super.onPostExecute(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String doInBackground(Object... objArr) {
        if (A1.c.v(this.f2333d, this.f2336b.a())) {
            return null;
        }
        this.f2336b.a(this.f2333d);
        return this.f2333d.toString();
    }
}
