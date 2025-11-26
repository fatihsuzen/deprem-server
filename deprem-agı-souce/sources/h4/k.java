package h4;

import android.text.TextUtils;
import g4.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p4.a;

public class k {

    /* renamed from: b  reason: collision with root package name */
    private static final String f23778b = b.i(k.class);

    /* renamed from: a  reason: collision with root package name */
    private final String f23779a;

    public k(String str) {
        this.f23779a = str;
    }

    private j a(g gVar) {
        if (gVar.a().isEmpty()) {
            return null;
        }
        return new j(this.f23779a + gVar);
    }

    private j b(List list) {
        if (list.isEmpty()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(((g) it.next()).a());
            }
            jSONObject.put("requests", jSONArray);
            return new j(this.f23779a, jSONObject, list.size());
        } catch (JSONException e5) {
            a.b(f23778b).i(e5, "Cannot create json object:\n%s", TextUtils.join(", ", list));
            return null;
        }
    }

    public List c(List list) {
        j jVar;
        if (list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        if (list.size() == 1) {
            j a5 = a((g) list.get(0));
            if (a5 == null) {
                return Collections.EMPTY_LIST;
            }
            return Collections.singletonList(a5);
        }
        ArrayList arrayList = new ArrayList((int) Math.ceil((((double) list.size()) * 1.0d) / 20.0d));
        int i5 = 0;
        while (i5 < list.size()) {
            int i6 = i5 + 20;
            List subList = list.subList(i5, Math.min(i6, list.size()));
            if (subList.size() == 1) {
                jVar = a((g) subList.get(0));
            } else {
                jVar = b(subList);
            }
            if (jVar != null) {
                arrayList.add(jVar);
            }
            i5 = i6;
        }
        return arrayList;
    }
}
