package T0;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import o0.f;
import org.json.JSONException;
import org.json.JSONObject;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private File f4372a;

    /* renamed from: b  reason: collision with root package name */
    private final f f4373b;

    public enum a {
        ATTEMPT_MIGRATION,
        NOT_GENERATED,
        UNREGISTERED,
        REGISTERED,
        REGISTER_ERROR
    }

    public c(f fVar) {
        this.f4373b = fVar;
    }

    private File a() {
        if (this.f4372a == null) {
            synchronized (this) {
                try {
                    if (this.f4372a == null) {
                        File filesDir = this.f4373b.k().getFilesDir();
                        this.f4372a = new File(filesDir, "PersistedInstallation." + this.f4373b.o() + ".json");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f4372a;
    }

    private JSONObject c() {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        try {
            fileInputStream = new FileInputStream(a());
            while (true) {
                int read = fileInputStream.read(bArr, 0, 16384);
                if (read < 0) {
                    JSONObject jSONObject = new JSONObject(byteArrayOutputStream.toString());
                    fileInputStream.close();
                    return jSONObject;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (IOException | JSONException unused) {
            return new JSONObject();
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public d b(d dVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Fid", dVar.d());
            jSONObject.put("Status", dVar.g().ordinal());
            jSONObject.put("AuthToken", dVar.b());
            jSONObject.put("RefreshToken", dVar.f());
            jSONObject.put("TokenCreationEpochInSecs", dVar.h());
            jSONObject.put("ExpiresInSecs", dVar.c());
            jSONObject.put("FisError", dVar.e());
            File createTempFile = File.createTempFile("PersistedInstallation", "tmp", this.f4373b.k().getFilesDir());
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(jSONObject.toString().getBytes(C.UTF8_NAME));
            fileOutputStream.close();
            if (createTempFile.renameTo(a())) {
                return dVar;
            }
            throw new IOException("unable to rename the tmpfile to PersistedInstallation");
        } catch (IOException | JSONException unused) {
        }
    }

    public d d() {
        JSONObject c5 = c();
        String optString = c5.optString("Fid", (String) null);
        int optInt = c5.optInt("Status", a.ATTEMPT_MIGRATION.ordinal());
        String optString2 = c5.optString("AuthToken", (String) null);
        String optString3 = c5.optString("RefreshToken", (String) null);
        long optLong = c5.optLong("TokenCreationEpochInSecs", 0);
        long optLong2 = c5.optLong("ExpiresInSecs", 0);
        return d.a().d(optString).g(a.values()[optInt]).b(optString2).f(optString3).h(optLong).c(optLong2).e(c5.optString("FisError", (String) null)).a();
    }
}
