package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.controller.d;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.same.f.a;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ad extends l {
    public static void a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                g b5 = h.a().b(c.m().k());
                if (b5 == null) {
                    h.a();
                    b5 = i.a();
                }
                long currentTimeMillis = System.currentTimeMillis() - ((long) (b5.l() * 1000));
                File file = new File(str);
                if (file.exists() && file.isDirectory()) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        for (File file2 : listFiles) {
                            if (file2.lastModified() + currentTimeMillis < currentTimeMillis2) {
                                a(file2);
                                try {
                                    File file3 = new File(str + ".zip");
                                    if (file3.exists() && file3.isFile()) {
                                        a(file3);
                                    }
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception unused2) {
        }
    }

    public static void b() {
        new Thread(new Runnable() {
            public final void run() {
                try {
                    if (c.m().c() != null) {
                        String a5 = e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_VC);
                        try {
                            File file = new File(a5);
                            if (file.exists() && file.isDirectory()) {
                                for (File file2 : ad.b(a5)) {
                                    if (file2.exists() && file2.isFile()) {
                                        file2.delete();
                                    }
                                }
                            }
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                    }
                } catch (Exception e6) {
                    if (MBridgeConstans.DEBUG) {
                        e6.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private static ArrayList<File> c(File file) {
        ArrayList<File> arrayList = new ArrayList<>();
        for (File file2 : file.listFiles(new FileFilter() {
            public final boolean accept(File file) {
                if (!file.isHidden() || file.isDirectory()) {
                    return true;
                }
                return false;
            }
        })) {
            if (!file2.isDirectory()) {
                arrayList.add(file2);
            } else {
                arrayList.addAll(c(file2));
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0029, code lost:
        if (r2 != null) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002f, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
        r4.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0037, code lost:
        if (r2 != null) goto L_0x002b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x003d A[SYNTHETIC, Splitter:B:26:0x003d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long d(java.io.File r4) throws java.lang.Exception {
        /*
            r0 = 0
            r2 = 0
            boolean r3 = r4.exists()     // Catch:{ Exception -> 0x001d }
            if (r3 == 0) goto L_0x001f
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x001d }
            r3.<init>(r4)     // Catch:{ Exception -> 0x001d }
            int r4 = r3.available()     // Catch:{ Exception -> 0x0018, all -> 0x0015 }
            long r0 = (long) r4
            r2 = r3
            goto L_0x0029
        L_0x0015:
            r4 = move-exception
            r2 = r3
            goto L_0x003b
        L_0x0018:
            r4 = move-exception
            r2 = r3
            goto L_0x0034
        L_0x001b:
            r4 = move-exception
            goto L_0x003b
        L_0x001d:
            r4 = move-exception
            goto L_0x0034
        L_0x001f:
            r4.createNewFile()     // Catch:{ Exception -> 0x001d }
            java.lang.String r4 = "获取文件大小"
            java.lang.String r3 = "文件不存在!"
            com.mbridge.msdk.foundation.tools.af.b(r4, r3)     // Catch:{ Exception -> 0x001d }
        L_0x0029:
            if (r2 == 0) goto L_0x003a
        L_0x002b:
            r2.close()     // Catch:{ Exception -> 0x002f }
            goto L_0x003a
        L_0x002f:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x003a
        L_0x0034:
            r4.printStackTrace()     // Catch:{ all -> 0x001b }
            if (r2 == 0) goto L_0x003a
            goto L_0x002b
        L_0x003a:
            return r0
        L_0x003b:
            if (r2 == 0) goto L_0x0045
            r2.close()     // Catch:{ Exception -> 0x0041 }
            goto L_0x0045
        L_0x0041:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0045:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ad.d(java.io.File):long");
    }

    private static long e(File file) throws Exception {
        long d5;
        File[] listFiles = file.listFiles();
        long j5 = 0;
        if (listFiles != null) {
            for (int i5 = 0; i5 < listFiles.length; i5++) {
                if (listFiles[i5].isDirectory()) {
                    d5 = e(listFiles[i5]);
                } else {
                    d5 = d(listFiles[i5]);
                }
                j5 += d5;
            }
        }
        return j5;
    }

    public static File[] b(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.listFiles();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0042, code lost:
        if (r1 == null) goto L_0x0045;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x004f A[SYNTHETIC, Splitter:B:30:0x004f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(java.io.File r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x003c, all -> 0x003a }
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ IOException -> 0x003c, all -> 0x003a }
            r2.<init>(r4)     // Catch:{ IOException -> 0x003c, all -> 0x003a }
            r1.<init>(r2)     // Catch:{ IOException -> 0x003c, all -> 0x003a }
            java.lang.StringBuffer r4 = new java.lang.StringBuffer     // Catch:{ IOException -> 0x0037 }
            r4.<init>()     // Catch:{ IOException -> 0x0037 }
        L_0x0013:
            java.lang.String r2 = r1.readLine()     // Catch:{ IOException -> 0x0031 }
            if (r2 == 0) goto L_0x0033
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0031 }
            r3.<init>()     // Catch:{ IOException -> 0x0031 }
            r3.append(r2)     // Catch:{ IOException -> 0x0031 }
            java.lang.String r2 = "\n"
            r3.append(r2)     // Catch:{ IOException -> 0x0031 }
            java.lang.String r2 = r3.toString()     // Catch:{ IOException -> 0x0031 }
            r4.append(r2)     // Catch:{ IOException -> 0x0031 }
            goto L_0x0013
        L_0x002e:
            r4 = move-exception
            r0 = r1
            goto L_0x004d
        L_0x0031:
            r2 = move-exception
            goto L_0x003f
        L_0x0033:
            r1.close()     // Catch:{ IOException -> 0x0045 }
            goto L_0x0045
        L_0x0037:
            r2 = move-exception
            r4 = r0
            goto L_0x003f
        L_0x003a:
            r4 = move-exception
            goto L_0x004d
        L_0x003c:
            r2 = move-exception
            r4 = r0
            r1 = r4
        L_0x003f:
            r2.printStackTrace()     // Catch:{ all -> 0x002e }
            if (r1 == 0) goto L_0x0045
            goto L_0x0033
        L_0x0045:
            if (r4 == 0) goto L_0x004c
            java.lang.String r4 = r4.toString()
            return r4
        L_0x004c:
            return r0
        L_0x004d:
            if (r0 == 0) goto L_0x0052
            r0.close()     // Catch:{ IOException -> 0x0052 }
        L_0x0052:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ad.b(java.io.File):java.lang.String");
    }

    private static void e(String str) {
        try {
            ArrayList<File> c5 = c(new File(str));
            Collections.sort(c5, new Comparator<File>() {
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    int i5 = ((((File) obj).lastModified() - ((File) obj2).lastModified()) > 0 ? 1 : ((((File) obj).lastModified() - ((File) obj2).lastModified()) == 0 ? 0 : -1));
                    if (i5 > 0) {
                        return 1;
                    }
                    if (i5 == 0) {
                        return 0;
                    }
                    return -1;
                }

                public final boolean equals(Object obj) {
                    return true;
                }
            });
            int size = (c5.size() - 1) / 2;
            for (int i5 = 0; i5 < size; i5++) {
                File file = c5.get(i5);
                if (file.exists() && file.isFile()) {
                    file.delete();
                }
            }
        } catch (Exception unused) {
            af.b("SameFileTool", "del memory failed");
        }
    }

    public static String c(String str) {
        if (!TextUtils.isEmpty(str)) {
            return SameMD5.getMD5(aq.b(str.trim()));
        }
        return "";
    }

    public static boolean d(String str) {
        if (com.mbridge.msdk.foundation.same.c.e.a(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x012c, code lost:
        if (r12 == null) goto L_0x0136;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:?, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0132, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0133, code lost:
        com.mbridge.msdk.foundation.tools.af.b("SameFileTool", com.mbridge.msdk.newreward.function.common.MBridgeError.ERROR_MESSAGE_DOWNLOAD_UN_ZIP_ERROR, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00fd, code lost:
        if (r12 == null) goto L_0x0107;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0103, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0104, code lost:
        com.mbridge.msdk.foundation.tools.af.b("SameFileTool", com.mbridge.msdk.newreward.function.common.MBridgeError.ERROR_MESSAGE_DOWNLOAD_UN_ZIP_ERROR, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x009b */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x014a A[Catch:{ all -> 0x0065 }] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0153 A[SYNTHETIC, Splitter:B:121:0x0153] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x015d A[SYNTHETIC, Splitter:B:126:0x015d] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0168 A[SYNTHETIC, Splitter:B:132:0x0168] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0172 A[SYNTHETIC, Splitter:B:137:0x0172] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x00b3 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b4 A[Catch:{ IOException -> 0x0068 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(java.lang.String r12, java.lang.String r13) {
        /*
            java.lang.String r0 = "../"
            java.lang.String r1 = ".."
            java.lang.String r2 = "unzip error"
            java.lang.String r3 = "SameFileTool"
            if (r12 == 0) goto L_0x017b
            if (r13 != 0) goto L_0x000e
            goto L_0x017b
        L_0x000e:
            java.lang.String r4 = "/"
            boolean r5 = r13.endsWith(r4)
            if (r5 != 0) goto L_0x0025
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r13)
            r5.append(r4)
            java.lang.String r13 = r5.toString()
        L_0x0025:
            java.io.File r4 = new java.io.File
            r4.<init>(r12)
            boolean r12 = r4.exists()
            if (r12 != 0) goto L_0x0033
            java.lang.String r12 = "unzip file not exists"
            return r12
        L_0x0033:
            r12 = 0
            java.util.zip.ZipFile r5 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x0144, all -> 0x0141 }
            r5.<init>(r4)     // Catch:{ IOException -> 0x0144, all -> 0x0141 }
            java.util.Enumeration r4 = r5.entries()     // Catch:{ IOException -> 0x0144, all -> 0x0141 }
            r6 = r12
        L_0x003e:
            boolean r7 = r4.hasMoreElements()     // Catch:{ IOException -> 0x0068 }
            java.lang.String r8 = ""
            if (r7 == 0) goto L_0x0129
            java.lang.Object r7 = r4.nextElement()     // Catch:{ IOException -> 0x0068 }
            java.util.zip.ZipEntry r7 = (java.util.zip.ZipEntry) r7     // Catch:{ IOException -> 0x0068 }
            if (r7 != 0) goto L_0x006b
            java.lang.String r13 = "unzip zipEntry is null"
            if (r12 == 0) goto L_0x005a
            r12.close()     // Catch:{ IOException -> 0x0056 }
            goto L_0x005a
        L_0x0056:
            r12 = move-exception
            com.mbridge.msdk.foundation.tools.af.b(r3, r2, r12)
        L_0x005a:
            if (r6 == 0) goto L_0x0064
            r6.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x0064
        L_0x0060:
            r12 = move-exception
            com.mbridge.msdk.foundation.tools.af.b(r3, r2, r12)
        L_0x0064:
            return r13
        L_0x0065:
            r13 = move-exception
            goto L_0x0166
        L_0x0068:
            r13 = move-exception
            goto L_0x0146
        L_0x006b:
            java.lang.String r9 = r7.getName()     // Catch:{ IOException -> 0x0068 }
            boolean r10 = android.text.TextUtils.isEmpty(r9)     // Catch:{ IOException -> 0x0068 }
            if (r10 != 0) goto L_0x0112
            boolean r10 = r9.startsWith(r1)     // Catch:{ IOException -> 0x0068 }
            if (r10 != 0) goto L_0x0112
            boolean r10 = r9.startsWith(r0)     // Catch:{ IOException -> 0x0068 }
            if (r10 == 0) goto L_0x0083
            goto L_0x0112
        L_0x0083:
            java.io.File r10 = new java.io.File     // Catch:{ IOException -> 0x0068 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0068 }
            r11.<init>()     // Catch:{ IOException -> 0x0068 }
            r11.append(r13)     // Catch:{ IOException -> 0x0068 }
            r11.append(r9)     // Catch:{ IOException -> 0x0068 }
            java.lang.String r9 = r11.toString()     // Catch:{ IOException -> 0x0068 }
            r10.<init>(r9)     // Catch:{ IOException -> 0x0068 }
            java.lang.String r8 = r10.getCanonicalPath()     // Catch:{ IOException -> 0x009b }
        L_0x009b:
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ IOException -> 0x0068 }
            if (r9 != 0) goto L_0x00fb
            boolean r9 = r8.startsWith(r13)     // Catch:{ IOException -> 0x0068 }
            if (r9 == 0) goto L_0x00fb
            boolean r9 = r8.startsWith(r1)     // Catch:{ IOException -> 0x0068 }
            if (r9 != 0) goto L_0x00fb
            boolean r8 = r8.startsWith(r0)     // Catch:{ IOException -> 0x0068 }
            if (r8 == 0) goto L_0x00b4
            goto L_0x00fb
        L_0x00b4:
            boolean r8 = r7.isDirectory()     // Catch:{ IOException -> 0x0068 }
            if (r8 == 0) goto L_0x00be
            r10.mkdirs()     // Catch:{ IOException -> 0x0068 }
            goto L_0x003e
        L_0x00be:
            java.io.File r8 = r10.getParentFile()     // Catch:{ IOException -> 0x0068 }
            if (r8 == 0) goto L_0x00d5
            java.io.File r8 = r10.getParentFile()     // Catch:{ IOException -> 0x0068 }
            boolean r8 = r8.exists()     // Catch:{ IOException -> 0x0068 }
            if (r8 != 0) goto L_0x00d5
            java.io.File r8 = r10.getParentFile()     // Catch:{ IOException -> 0x0068 }
            r8.mkdirs()     // Catch:{ IOException -> 0x0068 }
        L_0x00d5:
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0068 }
            r8.<init>(r10)     // Catch:{ IOException -> 0x0068 }
            java.io.InputStream r12 = r5.getInputStream(r7)     // Catch:{ IOException -> 0x00f5, all -> 0x00f1 }
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r7 = new byte[r6]     // Catch:{ IOException -> 0x00f5, all -> 0x00f1 }
        L_0x00e2:
            r9 = 0
            int r10 = r12.read(r7, r9, r6)     // Catch:{ IOException -> 0x00f5, all -> 0x00f1 }
            r11 = -1
            if (r10 == r11) goto L_0x00f8
            r8.write(r7, r9, r10)     // Catch:{ IOException -> 0x00f5, all -> 0x00f1 }
            r8.flush()     // Catch:{ IOException -> 0x00f5, all -> 0x00f1 }
            goto L_0x00e2
        L_0x00f1:
            r13 = move-exception
            r6 = r8
            goto L_0x0166
        L_0x00f5:
            r13 = move-exception
            r6 = r8
            goto L_0x0146
        L_0x00f8:
            r6 = r8
            goto L_0x003e
        L_0x00fb:
            java.lang.String r13 = "unzip zipEntry canonicalPath is not available"
            if (r12 == 0) goto L_0x0107
            r12.close()     // Catch:{ IOException -> 0x0103 }
            goto L_0x0107
        L_0x0103:
            r12 = move-exception
            com.mbridge.msdk.foundation.tools.af.b(r3, r2, r12)
        L_0x0107:
            if (r6 == 0) goto L_0x0111
            r6.close()     // Catch:{ IOException -> 0x010d }
            goto L_0x0111
        L_0x010d:
            r12 = move-exception
            com.mbridge.msdk.foundation.tools.af.b(r3, r2, r12)
        L_0x0111:
            return r13
        L_0x0112:
            java.lang.String r13 = "unzip zipEntry name is not available"
            if (r12 == 0) goto L_0x011e
            r12.close()     // Catch:{ IOException -> 0x011a }
            goto L_0x011e
        L_0x011a:
            r12 = move-exception
            com.mbridge.msdk.foundation.tools.af.b(r3, r2, r12)
        L_0x011e:
            if (r6 == 0) goto L_0x0128
            r6.close()     // Catch:{ IOException -> 0x0124 }
            goto L_0x0128
        L_0x0124:
            r12 = move-exception
            com.mbridge.msdk.foundation.tools.af.b(r3, r2, r12)
        L_0x0128:
            return r13
        L_0x0129:
            r5.close()     // Catch:{ IOException -> 0x0068 }
            if (r12 == 0) goto L_0x0136
            r12.close()     // Catch:{ IOException -> 0x0132 }
            goto L_0x0136
        L_0x0132:
            r12 = move-exception
            com.mbridge.msdk.foundation.tools.af.b(r3, r2, r12)
        L_0x0136:
            if (r6 == 0) goto L_0x0140
            r6.close()     // Catch:{ IOException -> 0x013c }
            goto L_0x0140
        L_0x013c:
            r12 = move-exception
            com.mbridge.msdk.foundation.tools.af.b(r3, r2, r12)
        L_0x0140:
            return r8
        L_0x0141:
            r13 = move-exception
            r6 = r12
            goto L_0x0166
        L_0x0144:
            r13 = move-exception
            r6 = r12
        L_0x0146:
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0065 }
            if (r0 == 0) goto L_0x014d
            com.mbridge.msdk.foundation.tools.af.b(r3, r2, r13)     // Catch:{ all -> 0x0065 }
        L_0x014d:
            java.lang.String r13 = r13.getMessage()     // Catch:{ all -> 0x0065 }
            if (r12 == 0) goto L_0x015b
            r12.close()     // Catch:{ IOException -> 0x0157 }
            goto L_0x015b
        L_0x0157:
            r12 = move-exception
            com.mbridge.msdk.foundation.tools.af.b(r3, r2, r12)
        L_0x015b:
            if (r6 == 0) goto L_0x0165
            r6.close()     // Catch:{ IOException -> 0x0161 }
            goto L_0x0165
        L_0x0161:
            r12 = move-exception
            com.mbridge.msdk.foundation.tools.af.b(r3, r2, r12)
        L_0x0165:
            return r13
        L_0x0166:
            if (r12 == 0) goto L_0x0170
            r12.close()     // Catch:{ IOException -> 0x016c }
            goto L_0x0170
        L_0x016c:
            r12 = move-exception
            com.mbridge.msdk.foundation.tools.af.b(r3, r2, r12)
        L_0x0170:
            if (r6 == 0) goto L_0x017a
            r6.close()     // Catch:{ IOException -> 0x0176 }
            goto L_0x017a
        L_0x0176:
            r12 = move-exception
            com.mbridge.msdk.foundation.tools.af.b(r3, r2, r12)
        L_0x017a:
            throw r13
        L_0x017b:
            java.lang.String r12 = "unzip srcFile or destDir is null "
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ad.b(java.lang.String, java.lang.String):java.lang.String");
    }

    public static void a() {
        AnonymousClass1 r02 = new Runnable() {
            public final void run() {
                try {
                    g b5 = h.a().b(c.m().k());
                    if (b5 == null) {
                        h.a();
                        b5 = i.a();
                    }
                    ad.a(e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_RES_MANAGER_DIR), b5.T());
                    ad.a(System.currentTimeMillis() - ((long) (b5.l() * 1000)));
                } catch (Exception e5) {
                    if (MBridgeConstans.DEBUG) {
                        e5.printStackTrace();
                    }
                }
            }
        };
        d.a();
        a.b().execute(r02);
    }

    public static void a(long j5) {
        try {
            ArrayList<File> c5 = c(new File(e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_RES_MANAGER_DIR)));
            int size = c5.size();
            int i5 = 0;
            while (i5 < size) {
                File file = c5.get(i5);
                i5++;
                File file2 = file;
                if (file2.lastModified() < j5 && file2.exists() && file2.isFile()) {
                    file2.delete();
                }
            }
        } catch (Throwable th) {
            af.b("SameFileTool", th.getMessage(), th);
        }
    }

    public static String a(File file) {
        try {
            if (file.isFile()) {
                file.delete();
                return "";
            }
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    if (listFiles.length != 0) {
                        for (File a5 : listFiles) {
                            a(a5);
                        }
                        file.delete();
                        return "";
                    }
                }
                file.delete();
            }
            return "";
        } catch (Exception e5) {
            return e5.getMessage();
        }
    }

    public static List<String> a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        try {
            if (!TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    File file = new File(str + File.separator + "template_config.json");
                    if (file.isFile()) {
                        if (file.exists()) {
                            String b5 = b(file);
                            if (!TextUtils.isEmpty(b5)) {
                                try {
                                    JSONArray jSONArray = new JSONArray(b5);
                                    for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                                        JSONObject jSONObject = jSONArray.getJSONObject(i5);
                                        if (jSONObject != null) {
                                            if (str2.equals(jSONObject.optString("xml_type"))) {
                                                arrayList.add(str + File.separator + jSONObject.optString(RewardPlus.NAME));
                                                if (jSONObject.has("ext_template")) {
                                                    jSONObject.put("folder_dir", str);
                                                    arrayList.add(jSONObject.toString());
                                                }
                                            }
                                        }
                                    }
                                } catch (JSONException e5) {
                                    af.b("SameFileTool", e5.getMessage());
                                }
                            }
                        }
                    }
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (Exception e6) {
            af.b("SameFileTool", e6.getMessage());
            return arrayList;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0035 A[SYNTHETIC, Splitter:B:25:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0041 A[SYNTHETIC, Splitter:B:30:0x0041] */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(byte[] r2, java.io.File r3) {
        /*
            r0 = 0
            java.io.File r1 = r3.getParentFile()     // Catch:{ Exception -> 0x0017 }
            if (r1 == 0) goto L_0x0019
            boolean r1 = r3.exists()     // Catch:{ Exception -> 0x0017 }
            if (r1 != 0) goto L_0x0019
            java.io.File r1 = r3.getParentFile()     // Catch:{ Exception -> 0x0017 }
            r1.mkdirs()     // Catch:{ Exception -> 0x0017 }
            goto L_0x0019
        L_0x0015:
            r2 = move-exception
            goto L_0x003f
        L_0x0017:
            r2 = move-exception
            goto L_0x0030
        L_0x0019:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0017 }
            r1.<init>(r3)     // Catch:{ Exception -> 0x0017 }
            r1.write(r2)     // Catch:{ Exception -> 0x002e, all -> 0x002b }
            r1.close()     // Catch:{ IOException -> 0x0025 }
            goto L_0x0029
        L_0x0025:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0029:
            r2 = 1
            return r2
        L_0x002b:
            r2 = move-exception
            r0 = r1
            goto L_0x003f
        L_0x002e:
            r2 = move-exception
            r0 = r1
        L_0x0030:
            r2.printStackTrace()     // Catch:{ all -> 0x0015 }
            if (r0 == 0) goto L_0x003d
            r0.close()     // Catch:{ IOException -> 0x0039 }
            goto L_0x003d
        L_0x0039:
            r2 = move-exception
            r2.printStackTrace()
        L_0x003d:
            r2 = 0
            return r2
        L_0x003f:
            if (r0 == 0) goto L_0x0049
            r0.close()     // Catch:{ IOException -> 0x0045 }
            goto L_0x0049
        L_0x0045:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0049:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ad.a(byte[], java.io.File):boolean");
    }

    static /* synthetic */ void a(String str, int i5) {
        try {
            if (e(new File(str)) > ((long) (i5 * 1048576))) {
                e(str);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        } catch (Throwable unused) {
            af.b("SameFileTool", "clean memory failed");
        }
    }
}
