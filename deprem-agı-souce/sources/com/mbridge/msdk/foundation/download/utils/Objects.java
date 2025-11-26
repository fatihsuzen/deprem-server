package com.mbridge.msdk.foundation.download.utils;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.thrid.okhttp.Response;
import com.mbridge.msdk.thrid.okhttp.ResponseBody;
import java.io.File;
import java.io.FileFilter;
import java.io.InputStream;
import java.util.Arrays;

public class Objects {
    public static void closeInputStream(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e5) {
                af.a("closeStream", e5.getLocalizedMessage());
            }
        }
    }

    public static void closeOutputStream(DownloadFileOutputStream downloadFileOutputStream) {
        if (downloadFileOutputStream != null) {
            try {
                downloadFileOutputStream.close();
            } catch (Exception e5) {
                af.a("closeStream", e5.getLocalizedMessage());
            }
        }
    }

    public static void closeResponse(Response response) {
        if (response != null) {
            try {
                if (response.body() != null) {
                    response.body().close();
                }
                response.close();
            } catch (Exception e5) {
                af.a("closeStream", e5.getLocalizedMessage());
            }
        }
    }

    public static void closeResponseBody(ResponseBody responseBody) {
        if (responseBody != null) {
            try {
                responseBody.close();
            } catch (Exception e5) {
                af.a("closeStream", e5.getLocalizedMessage());
            }
        }
    }

    private static boolean doubleCheckExists(File file, final String str, final String str2) {
        File[] fileArr;
        try {
            fileArr = file.getParentFile().listFiles(new FileFilter() {
                public final boolean accept(File file) {
                    String absolutePath = file.getAbsolutePath();
                    return TextUtils.equals(absolutePath, str + str2);
                }
            });
        } catch (Exception e5) {
            af.a("doubleCheckExists", e5.getLocalizedMessage());
            fileArr = null;
        }
        if (fileArr == null || file.length() <= 0) {
            return false;
        }
        return true;
    }

    public static boolean exists(File file, String str, String str2) {
        if (file == null || TextUtils.isEmpty(str)) {
            return false;
        }
        boolean exists = file.exists();
        if (!exists) {
            return doubleCheckExists(file, str, str2);
        }
        return exists;
    }

    public static int hash(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static boolean isNotNull(Object obj) {
        return !isNull(obj);
    }

    public static boolean isNull(Object obj) {
        return obj == null;
    }
}
