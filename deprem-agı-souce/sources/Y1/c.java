package y1;

import A1.e;
import A1.i;
import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import org.json.JSONObject;
import u1.n;
import y1.a;

public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    private final a f17090a;

    public c(a aVar) {
        this.f17090a = aVar;
    }

    public JSONObject a(View view) {
        JSONObject c5 = A1.c.c(0, 0, 0, 0);
        A1.c.j(c5, e.a());
        return c5;
    }

    /* access modifiers changed from: package-private */
    public ArrayList b() {
        View rootView;
        ArrayList arrayList = new ArrayList();
        x1.c e5 = x1.c.e();
        if (e5 != null) {
            Collection<n> a5 = e5.a();
            IdentityHashMap identityHashMap = new IdentityHashMap((a5.size() * 2) + 3);
            for (n n5 : a5) {
                View n6 = n5.n();
                if (n6 != null && i.g(n6) && (rootView = n6.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float d5 = i.d(rootView);
                    int size = arrayList.size();
                    while (size > 0 && i.d((View) arrayList.get(size - 1)) > d5) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        return arrayList;
    }

    public void a(View view, JSONObject jSONObject, a.C0167a aVar, boolean z4, boolean z5) {
        ArrayList b5 = b();
        int size = b5.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = b5.get(i5);
            i5++;
            aVar.a((View) obj, this.f17090a, jSONObject, z5);
        }
    }
}
