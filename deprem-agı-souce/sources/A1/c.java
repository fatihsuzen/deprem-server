package A1;

import B1.b;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.WindowManager;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import u1.j;
import x1.e;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    private static WindowManager f2283a;

    /* renamed from: b  reason: collision with root package name */
    private static String[] f2284b = {"x", "y", "width", "height"};

    /* renamed from: c  reason: collision with root package name */
    static float f2285c = Resources.getSystem().getDisplayMetrics().density;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2286a;

        static {
            int[] iArr = new int[j.values().length];
            f2286a = iArr;
            try {
                iArr[j.NOT_DETECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        final float f2287a;

        /* renamed from: b  reason: collision with root package name */
        final float f2288b;

        b(float f5, float f6) {
            this.f2287a = f5;
            this.f2288b = f6;
        }
    }

    static float a(int i5) {
        return ((float) i5) / f2285c;
    }

    private static b b(JSONObject jSONObject) {
        float f5;
        float f6;
        if (f2283a != null) {
            Point point = new Point(0, 0);
            f2283a.getDefaultDisplay().getRealSize(point);
            f6 = a(point.x);
            f5 = a(point.y);
        } else {
            f6 = 0.0f;
            f5 = 0.0f;
        }
        return new b(f6, f5);
    }

    public static JSONObject c(int i5, int i6, int i7, int i8) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", (double) a(i5));
            jSONObject.put("y", (double) a(i6));
            jSONObject.put("width", (double) a(i7));
            jSONObject.put("height", (double) a(i8));
            return jSONObject;
        } catch (JSONException e5) {
            d.b("Error with creating viewStateObject", e5);
            return jSONObject;
        }
    }

    public static void d(Context context) {
        if (context != null) {
            f2285c = context.getResources().getDisplayMetrics().density;
            f2283a = (WindowManager) context.getSystemService("window");
        }
    }

    public static void e(JSONObject jSONObject, b.a aVar) {
        e a5 = aVar.a();
        JSONArray jSONArray = new JSONArray();
        ArrayList c5 = aVar.c();
        int size = c5.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = c5.get(i5);
            i5++;
            jSONArray.put((String) obj);
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", jSONArray);
            jSONObject.put("friendlyObstructionClass", a5.d());
            jSONObject.put("friendlyObstructionPurpose", a5.b());
            jSONObject.put("friendlyObstructionReason", a5.a());
        } catch (JSONException e5) {
            d.b("Error with setting friendly obstruction", e5);
        }
    }

    public static void f(JSONObject jSONObject, Boolean bool) {
        try {
            jSONObject.put("hasWindowFocus", bool);
        } catch (JSONException e5) {
            d.b("Error with setting has window focus", e5);
        }
    }

    public static void g(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e5) {
            d.b("Error with setting ad session id", e5);
        }
    }

    public static void h(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (NullPointerException | JSONException e5) {
            d.b("JSONException during JSONObject.put for name [" + str + "]", e5);
        }
    }

    public static void i(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
                jSONObject.put("childViews", optJSONArray);
            }
            optJSONArray.put(jSONObject2);
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
    }

    public static void j(JSONObject jSONObject, j jVar) {
        try {
            jSONObject.put("noOutputDevice", l(jVar));
        } catch (JSONException e5) {
            d.b("Error with setting output device status", e5);
        }
    }

    private static boolean k(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        if (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) {
            return false;
        }
        return true;
    }

    private static boolean l(j jVar) {
        if (a.f2286a[jVar.ordinal()] != 1) {
            return false;
        }
        return true;
    }

    public static void m(JSONObject jSONObject) {
        b b5 = b(jSONObject);
        try {
            jSONObject.put("width", (double) b5.f2287a);
            jSONObject.put("height", (double) b5.f2288b);
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
    }

    public static void n(JSONObject jSONObject, Boolean bool) {
        if (bool.booleanValue()) {
            try {
                jSONObject.put("isPipActive", bool);
            } catch (JSONException e5) {
                d.b("Error with setting is picture-in-picture active", e5);
            }
        }
    }

    public static void o(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("notVisibleReason", str);
        } catch (JSONException e5) {
            d.b("Error with setting not visible reason", e5);
        }
    }

    private static boolean p(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("childViews");
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (!k(optJSONArray, optJSONArray2)) {
            return false;
        }
        for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
            if (!v(optJSONArray.optJSONObject(i5), optJSONArray2.optJSONObject(i5))) {
                return false;
            }
        }
        return true;
    }

    private static boolean q(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("isFriendlyObstructionFor");
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("isFriendlyObstructionFor");
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (!k(optJSONArray, optJSONArray2)) {
            return false;
        }
        for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
            if (!optJSONArray.optString(i5, "").equals(optJSONArray2.optString(i5, ""))) {
                return false;
            }
        }
        return true;
    }

    private static boolean r(JSONObject jSONObject, JSONObject jSONObject2) {
        return Boolean.valueOf(jSONObject.optBoolean("hasWindowFocus")).equals(Boolean.valueOf(jSONObject2.optBoolean("hasWindowFocus")));
    }

    private static boolean s(JSONObject jSONObject, JSONObject jSONObject2) {
        return Boolean.valueOf(jSONObject.optBoolean("noOutputDevice")).equals(Boolean.valueOf(jSONObject2.optBoolean("noOutputDevice")));
    }

    private static boolean t(JSONObject jSONObject, JSONObject jSONObject2) {
        for (String str : f2284b) {
            if (jSONObject.optDouble(str) != jSONObject2.optDouble(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean u(JSONObject jSONObject, JSONObject jSONObject2) {
        return jSONObject.optString("adSessionId", "").equals(jSONObject2.optString("adSessionId", ""));
    }

    public static boolean v(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        if (jSONObject == null || jSONObject2 == null || !t(jSONObject, jSONObject2) || !u(jSONObject, jSONObject2) || !s(jSONObject, jSONObject2) || !r(jSONObject, jSONObject2) || !q(jSONObject, jSONObject2) || !p(jSONObject, jSONObject2)) {
            return false;
        }
        return true;
    }
}
