package F0;

import D0.g;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.json.JSONObject;
import x0.C1914j;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final File f2417a;

    public a(g gVar) {
        this.f2417a = gVar.g("com.crashlytics.settings.json");
    }

    private File a() {
        return this.f2417a;
    }

    public JSONObject b() {
        FileInputStream fileInputStream;
        JSONObject jSONObject;
        u0.g.f().b("Checking for cached settings...");
        FileInputStream fileInputStream2 = null;
        try {
            File a5 = a();
            if (a5.exists()) {
                fileInputStream = new FileInputStream(a5);
                try {
                    jSONObject = new JSONObject(C1914j.B(fileInputStream));
                    fileInputStream2 = fileInputStream;
                } catch (Exception e5) {
                    e = e5;
                    try {
                        u0.g.f().e("Failed to fetch cached settings", e);
                        C1914j.f(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        C1914j.f(fileInputStream, "Error while closing settings cache file.");
                        throw th;
                    }
                }
            } else {
                u0.g.f().i("Settings file does not exist.");
                jSONObject = null;
            }
            C1914j.f(fileInputStream2, "Error while closing settings cache file.");
            return jSONObject;
        } catch (Exception e6) {
            e = e6;
            fileInputStream = null;
            u0.g.f().e("Failed to fetch cached settings", e);
            C1914j.f(fileInputStream, "Error while closing settings cache file.");
            return null;
        } catch (Throwable th2) {
            fileInputStream = null;
            th = th2;
            C1914j.f(fileInputStream, "Error while closing settings cache file.");
            throw th;
        }
    }

    public void c(long j5, JSONObject jSONObject) {
        u0.g.f().i("Writing settings to cache file...");
        if (jSONObject != null) {
            FileWriter fileWriter = null;
            try {
                jSONObject.put("expires_at", j5);
                FileWriter fileWriter2 = new FileWriter(a());
                try {
                    fileWriter2.write(jSONObject.toString());
                    fileWriter2.flush();
                    C1914j.f(fileWriter2, "Failed to close settings writer.");
                } catch (Exception e5) {
                    e = e5;
                    fileWriter = fileWriter2;
                    try {
                        u0.g.f().e("Failed to cache settings", e);
                        C1914j.f(fileWriter, "Failed to close settings writer.");
                    } catch (Throwable th) {
                        th = th;
                        C1914j.f(fileWriter, "Failed to close settings writer.");
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileWriter = fileWriter2;
                    C1914j.f(fileWriter, "Failed to close settings writer.");
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                u0.g.f().e("Failed to cache settings", e);
                C1914j.f(fileWriter, "Failed to close settings writer.");
            }
        }
    }
}
