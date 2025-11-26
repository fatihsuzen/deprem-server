package z0;

import D0.g;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import x0.C1914j;

/* renamed from: z0.g  reason: case insensitive filesystem */
class C1978g {

    /* renamed from: b  reason: collision with root package name */
    private static final Charset f17194b = Charset.forName(C.UTF8_NAME);

    /* renamed from: a  reason: collision with root package name */
    private final g f17195a;

    /* renamed from: z0.g$a */
    class a extends JSONObject {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f17196a;

        a(String str) {
            this.f17196a = str;
            put("userId", str);
        }
    }

    public C1978g(g gVar) {
        this.f17195a = gVar;
    }

    private static Map e(String str) {
        JSONObject jSONObject = new JSONObject(str);
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, p(jSONObject, next));
        }
        return hashMap;
    }

    private static List f(String str) {
        JSONArray jSONArray = new JSONObject(str).getJSONArray("rolloutsState");
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < jSONArray.length(); i5++) {
            String string = jSONArray.getString(i5);
            try {
                arrayList.add(j.a(string));
            } catch (Exception e5) {
                u0.g f5 = u0.g.f();
                f5.l("Failed de-serializing rollouts state. " + string, e5);
            }
        }
        return arrayList;
    }

    private String g(String str) {
        return p(new JSONObject(str), "userId");
    }

    private static String h(Map map) {
        return new JSONObject(map).toString();
    }

    private static String l(List list) {
        HashMap hashMap = new HashMap();
        JSONArray jSONArray = new JSONArray();
        for (int i5 = 0; i5 < list.size(); i5++) {
            try {
                jSONArray.put(new JSONObject(j.f17222a.b(list.get(i5))));
            } catch (JSONException e5) {
                u0.g.f().l("Exception parsing rollout assignment!", e5);
            }
        }
        hashMap.put("rolloutsState", jSONArray);
        return new JSONObject(hashMap).toString();
    }

    private static void m(File file) {
        if (file.exists() && file.delete()) {
            u0.g f5 = u0.g.f();
            f5.g("Deleted corrupt file: " + file.getAbsolutePath());
        }
    }

    private static void n(File file, String str) {
        if (file.exists() && file.delete()) {
            u0.g.f().g(String.format("Deleted corrupt file: %s\nReason: %s", new Object[]{file.getAbsolutePath(), str}));
        }
    }

    private static String o(String str) {
        return new a(str).toString();
    }

    private static String p(JSONObject jSONObject, String str) {
        if (!jSONObject.isNull(str)) {
            return jSONObject.optString(str, (String) null);
        }
        return null;
    }

    public File a(String str) {
        return this.f17195a.q(str, "internal-keys");
    }

    public File b(String str) {
        return this.f17195a.q(str, "keys");
    }

    public File c(String str) {
        return this.f17195a.q(str, "rollouts-state");
    }

    public File d(String str) {
        return this.f17195a.q(str, "user-data");
    }

    /* access modifiers changed from: package-private */
    public Map i(String str, boolean z4) {
        File file;
        FileInputStream fileInputStream;
        Exception e5;
        if (z4) {
            file = a(str);
        } else {
            file = b(str);
        }
        if (!file.exists() || file.length() == 0) {
            n(file, "The file has a length of zero for session: " + str);
            return Collections.EMPTY_MAP;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                Map e6 = e(C1914j.B(fileInputStream));
                C1914j.f(fileInputStream, "Failed to close user metadata file.");
                return e6;
            } catch (Exception e7) {
                e5 = e7;
                try {
                    u0.g.f().l("Error deserializing user metadata.", e5);
                    m(file);
                    C1914j.f(fileInputStream, "Failed to close user metadata file.");
                    return Collections.EMPTY_MAP;
                } catch (Throwable th) {
                    th = th;
                    C1914j.f(fileInputStream, "Failed to close user metadata file.");
                    throw th;
                }
            }
        } catch (Exception e8) {
            Exception exc = e8;
            fileInputStream = null;
            e5 = exc;
            u0.g.f().l("Error deserializing user metadata.", e5);
            m(file);
            C1914j.f(fileInputStream, "Failed to close user metadata file.");
            return Collections.EMPTY_MAP;
        } catch (Throwable th2) {
            fileInputStream = null;
            th = th2;
            C1914j.f(fileInputStream, "Failed to close user metadata file.");
            throw th;
        }
    }

    public List j(String str) {
        File c5 = c(str);
        if (!c5.exists() || c5.length() == 0) {
            n(c5, "The file has a length of zero for session: " + str);
            return Collections.EMPTY_LIST;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(c5);
            try {
                List f5 = f(C1914j.B(fileInputStream2));
                u0.g f6 = u0.g.f();
                f6.b("Loaded rollouts state:\n" + f5 + "\nfor session " + str);
                C1914j.f(fileInputStream2, "Failed to close rollouts state file.");
                return f5;
            } catch (Exception e5) {
                e = e5;
                fileInputStream = fileInputStream2;
                try {
                    u0.g.f().l("Error deserializing rollouts state.", e);
                    m(c5);
                    C1914j.f(fileInputStream, "Failed to close rollouts state file.");
                    return Collections.EMPTY_LIST;
                } catch (Throwable th) {
                    th = th;
                    C1914j.f(fileInputStream, "Failed to close rollouts state file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                C1914j.f(fileInputStream, "Failed to close rollouts state file.");
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            u0.g.f().l("Error deserializing rollouts state.", e);
            m(c5);
            C1914j.f(fileInputStream, "Failed to close rollouts state file.");
            return Collections.EMPTY_LIST;
        }
    }

    public String k(String str) {
        FileInputStream fileInputStream;
        File d5 = d(str);
        FileInputStream fileInputStream2 = null;
        if (!d5.exists() || d5.length() == 0) {
            u0.g.f().b("No userId set for session " + str);
            m(d5);
            return null;
        }
        try {
            fileInputStream = new FileInputStream(d5);
            try {
                String g5 = g(C1914j.B(fileInputStream));
                u0.g.f().b("Loaded userId " + g5 + " for session " + str);
                C1914j.f(fileInputStream, "Failed to close user metadata file.");
                return g5;
            } catch (Exception e5) {
                e = e5;
                try {
                    u0.g.f().l("Error deserializing user metadata.", e);
                    m(d5);
                    C1914j.f(fileInputStream, "Failed to close user metadata file.");
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    C1914j.f(fileInputStream2, "Failed to close user metadata file.");
                    throw th;
                }
            }
        } catch (Exception e6) {
            e = e6;
            fileInputStream = null;
            u0.g.f().l("Error deserializing user metadata.", e);
            m(d5);
            C1914j.f(fileInputStream, "Failed to close user metadata file.");
            return null;
        } catch (Throwable th2) {
            th = th2;
            C1914j.f(fileInputStream2, "Failed to close user metadata file.");
            throw th;
        }
    }

    public void q(String str, Map map) {
        r(str, map, false);
    }

    public void r(String str, Map map, boolean z4) {
        File file;
        if (z4) {
            file = a(str);
        } else {
            file = b(str);
        }
        BufferedWriter bufferedWriter = null;
        try {
            String h5 = h(map);
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), f17194b));
            try {
                bufferedWriter2.write(h5);
                bufferedWriter2.flush();
                C1914j.f(bufferedWriter2, "Failed to close key/value metadata file.");
            } catch (Exception e5) {
                e = e5;
                bufferedWriter = bufferedWriter2;
                try {
                    u0.g.f().l("Error serializing key/value metadata.", e);
                    m(file);
                    C1914j.f(bufferedWriter, "Failed to close key/value metadata file.");
                } catch (Throwable th) {
                    th = th;
                    C1914j.f(bufferedWriter, "Failed to close key/value metadata file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter = bufferedWriter2;
                C1914j.f(bufferedWriter, "Failed to close key/value metadata file.");
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            u0.g.f().l("Error serializing key/value metadata.", e);
            m(file);
            C1914j.f(bufferedWriter, "Failed to close key/value metadata file.");
        }
    }

    public void s(String str, List list) {
        BufferedWriter bufferedWriter;
        Exception e5;
        File c5 = c(str);
        if (list.isEmpty()) {
            n(c5, "Rollout state is empty for session: " + str);
            return;
        }
        try {
            String l5 = l(list);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(c5), f17194b));
            try {
                bufferedWriter.write(l5);
                bufferedWriter.flush();
                C1914j.f(bufferedWriter, "Failed to close rollouts state file.");
            } catch (Exception e6) {
                e5 = e6;
                try {
                    u0.g.f().l("Error serializing rollouts state.", e5);
                    m(c5);
                    C1914j.f(bufferedWriter, "Failed to close rollouts state file.");
                } catch (Throwable th) {
                    th = th;
                    C1914j.f(bufferedWriter, "Failed to close rollouts state file.");
                    throw th;
                }
            }
        } catch (Exception e7) {
            bufferedWriter = null;
            e5 = e7;
            u0.g.f().l("Error serializing rollouts state.", e5);
            m(c5);
            C1914j.f(bufferedWriter, "Failed to close rollouts state file.");
        } catch (Throwable th2) {
            bufferedWriter = null;
            th = th2;
            C1914j.f(bufferedWriter, "Failed to close rollouts state file.");
            throw th;
        }
    }

    public void t(String str, String str2) {
        File d5 = d(str);
        BufferedWriter bufferedWriter = null;
        try {
            String o5 = o(str2);
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(d5), f17194b));
            try {
                bufferedWriter2.write(o5);
                bufferedWriter2.flush();
                C1914j.f(bufferedWriter2, "Failed to close user metadata file.");
            } catch (Exception e5) {
                e = e5;
                bufferedWriter = bufferedWriter2;
                try {
                    u0.g.f().l("Error serializing user metadata.", e);
                    C1914j.f(bufferedWriter, "Failed to close user metadata file.");
                } catch (Throwable th) {
                    th = th;
                    C1914j.f(bufferedWriter, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter = bufferedWriter2;
                C1914j.f(bufferedWriter, "Failed to close user metadata file.");
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            u0.g.f().l("Error serializing user metadata.", e);
            C1914j.f(bufferedWriter, "Failed to close user metadata file.");
        }
    }
}
