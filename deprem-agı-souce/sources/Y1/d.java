package y1;

import A1.c;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import org.json.JSONObject;
import y1.a;

public class d implements a {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f17091a = new int[2];

    private void b(ViewGroup viewGroup, JSONObject jSONObject, a.C0167a aVar, boolean z4) {
        for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
            aVar.a(viewGroup.getChildAt(i5), this, jSONObject, z4);
        }
    }

    private void c(ViewGroup viewGroup, JSONObject jSONObject, a.C0167a aVar, boolean z4) {
        HashMap hashMap = new HashMap();
        for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
            View childAt = viewGroup.getChildAt(i5);
            ArrayList arrayList = (ArrayList) hashMap.get(Float.valueOf(childAt.getZ()));
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap.put(Float.valueOf(childAt.getZ()), arrayList);
            }
            arrayList.add(childAt);
        }
        ArrayList arrayList2 = new ArrayList(hashMap.keySet());
        Collections.sort(arrayList2);
        int size = arrayList2.size();
        int i6 = 0;
        while (i6 < size) {
            Object obj = arrayList2.get(i6);
            i6++;
            ArrayList arrayList3 = (ArrayList) hashMap.get((Float) obj);
            int size2 = arrayList3.size();
            int i7 = 0;
            while (i7 < size2) {
                Object obj2 = arrayList3.get(i7);
                i7++;
                aVar.a((View) obj2, this, jSONObject, z4);
            }
        }
    }

    public JSONObject a(View view) {
        if (view == null) {
            return c.c(0, 0, 0, 0);
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.f17091a);
        int[] iArr = this.f17091a;
        return c.c(iArr[0], iArr[1], width, height);
    }

    public void a(View view, JSONObject jSONObject, a.C0167a aVar, boolean z4, boolean z5) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (z4) {
                c(viewGroup, jSONObject, aVar, z5);
            } else {
                b(viewGroup, jSONObject, aVar, z5);
            }
        }
    }
}
