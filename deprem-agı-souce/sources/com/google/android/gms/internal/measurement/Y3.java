package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import l0.g;

public abstract class Y3 {

    /* renamed from: a  reason: collision with root package name */
    private static volatile g f5279a;

    public static g a(Context context) {
        g gVar;
        Context context2;
        StrictMode.ThreadPolicy allowThreadDiskReads;
        g gVar2;
        BufferedReader bufferedReader;
        Throwable th;
        g gVar3 = f5279a;
        if (gVar3 != null) {
            return gVar3;
        }
        synchronized (Y3.class) {
            try {
                gVar = f5279a;
                if (gVar == null) {
                    String str = Build.TYPE;
                    String str2 = Build.TAGS;
                    int i5 = C1061b4.f5309b;
                    if (!str.equals("eng")) {
                        if (str.equals("userdebug")) {
                        }
                        gVar = g.a();
                        f5279a = gVar;
                    }
                    if (!str2.contains("dev-keys")) {
                        if (str2.contains("test-keys")) {
                        }
                        gVar = g.a();
                        f5279a = gVar;
                    }
                    if (!L3.a() || context.isDeviceProtectedStorage()) {
                        context2 = context;
                    } else {
                        context2 = context.createDeviceProtectedStorageContext();
                    }
                    allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    StrictMode.allowThreadDiskWrites();
                    char c5 = 0;
                    try {
                        File file = new File(context2.getDir("phenotype_hermetic", 0), "overrides.txt");
                        if (file.exists()) {
                            gVar2 = g.d(file);
                        } else {
                            gVar2 = g.a();
                        }
                    } catch (RuntimeException e5) {
                        Log.e("HermeticFileOverrides", "no data dir", e5);
                        gVar2 = g.a();
                    }
                    if (gVar2.c()) {
                        File file2 = (File) gVar2.b();
                        try {
                            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
                            SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
                            HashMap hashMap = new HashMap();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                String[] split = readLine.split(" ", 3);
                                if (split.length != 3) {
                                    StringBuilder sb = new StringBuilder(readLine.length() + 9);
                                    sb.append("Invalid: ");
                                    sb.append(readLine);
                                    Log.e("HermeticFileOverrides", sb.toString());
                                } else {
                                    String str3 = new String(split[c5]);
                                    String decode = Uri.decode(new String(split[1]));
                                    String str4 = (String) hashMap.get(split[2]);
                                    if (str4 == null) {
                                        String str5 = new String(split[2]);
                                        str4 = Uri.decode(str5);
                                        if (str4.length() < 1024 || str4 == str5) {
                                            hashMap.put(str5, str4);
                                        }
                                    }
                                    SimpleArrayMap simpleArrayMap2 = (SimpleArrayMap) simpleArrayMap.get(str3);
                                    if (simpleArrayMap2 == null) {
                                        simpleArrayMap2 = new SimpleArrayMap();
                                        simpleArrayMap.put(str3, simpleArrayMap2);
                                    }
                                    simpleArrayMap2.put(decode, str4);
                                    c5 = 0;
                                }
                            }
                            String obj = file2.toString();
                            String packageName = context2.getPackageName();
                            StringBuilder sb2 = new StringBuilder(obj.length() + 28 + String.valueOf(packageName).length());
                            sb2.append("Parsed ");
                            sb2.append(obj);
                            sb2.append(" for Android package ");
                            sb2.append(packageName);
                            Log.w("HermeticFileOverrides", sb2.toString());
                            R3 r32 = new R3(simpleArrayMap);
                            bufferedReader.close();
                            gVar = g.d(r32);
                        } catch (IOException e6) {
                            throw new RuntimeException(e6);
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        gVar = g.a();
                    }
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                    f5279a = gVar;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return gVar;
        throw th;
    }
}
