package androidx.core.provider;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class FontProvider {
    private static final Comparator<byte[]> sByteArrayComparator = new a();

    private interface ContentQueryWrapper {
        void close();

        Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal);
    }

    private static class ContentQueryWrapperApi16Impl implements ContentQueryWrapper {
        private final ContentProviderClient mClient;

        ContentQueryWrapperApi16Impl(Context context, Uri uri) {
            this.mClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        public void close() {
            ContentProviderClient contentProviderClient = this.mClient;
            if (contentProviderClient != null) {
                contentProviderClient.release();
            }
        }

        public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.mClient;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException e5) {
                Log.w("FontsProvider", "Unable to query the content provider", e5);
                return null;
            }
        }
    }

    @RequiresApi(24)
    private static class ContentQueryWrapperApi24Impl implements ContentQueryWrapper {
        private final ContentProviderClient mClient;

        ContentQueryWrapperApi24Impl(Context context, Uri uri) {
            this.mClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        public void close() {
            ContentProviderClient contentProviderClient = this.mClient;
            if (contentProviderClient != null) {
                c.a(contentProviderClient);
            }
        }

        public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.mClient;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException e5) {
                Log.w("FontsProvider", "Unable to query the content provider", e5);
                return null;
            }
        }
    }

    private FontProvider() {
    }

    public static /* synthetic */ int a(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i5 = 0; i5 < bArr.length; i5++) {
            byte b5 = bArr[i5];
            byte b6 = bArr2[i5];
            if (b5 != b6) {
                return b5 - b6;
            }
        }
        return 0;
    }

    private static List<byte[]> convertToByteArrayList(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature byteArray : signatureArr) {
            arrayList.add(byteArray.toByteArray());
        }
        return arrayList;
    }

    private static boolean equalsByteArrayList(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i5 = 0; i5 < list.size(); i5++) {
            if (!Arrays.equals(list.get(i5), list2.get(i5))) {
                return false;
            }
        }
        return true;
    }

    private static List<List<byte[]>> getCertificates(FontRequest fontRequest, Resources resources) {
        if (fontRequest.getCertificates() != null) {
            return fontRequest.getCertificates();
        }
        return FontResourcesParserCompat.readCerts(resources, fontRequest.getCertificatesArrayResId());
    }

    @NonNull
    static FontsContractCompat.FontFamilyResult getFontFamilyResult(@NonNull Context context, @NonNull FontRequest fontRequest, @Nullable CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        ProviderInfo provider = getProvider(context.getPackageManager(), fontRequest, context.getResources());
        if (provider == null) {
            return FontsContractCompat.FontFamilyResult.create(1, (FontsContractCompat.FontInfo[]) null);
        }
        return FontsContractCompat.FontFamilyResult.create(0, query(context, fontRequest, provider.authority, cancellationSignal));
    }

    @VisibleForTesting
    @Nullable
    static ProviderInfo getProvider(@NonNull PackageManager packageManager, @NonNull FontRequest fontRequest, @Nullable Resources resources) throws PackageManager.NameNotFoundException {
        String providerAuthority = fontRequest.getProviderAuthority();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(providerAuthority, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + providerAuthority);
        } else if (resolveContentProvider.packageName.equals(fontRequest.getProviderPackage())) {
            List<byte[]> convertToByteArrayList = convertToByteArrayList(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort(convertToByteArrayList, sByteArrayComparator);
            List<List<byte[]>> certificates = getCertificates(fontRequest, resources);
            for (int i5 = 0; i5 < certificates.size(); i5++) {
                ArrayList arrayList = new ArrayList(certificates.get(i5));
                Collections.sort(arrayList, sByteArrayComparator);
                if (equalsByteArrayList(convertToByteArrayList, arrayList)) {
                    return resolveContentProvider;
                }
            }
            return null;
        } else {
            throw new PackageManager.NameNotFoundException("Found content provider " + providerAuthority + ", but package was not " + fontRequest.getProviderPackage());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f8  */
    @androidx.annotation.VisibleForTesting
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static androidx.core.provider.FontsContractCompat.FontInfo[] query(android.content.Context r16, androidx.core.provider.FontRequest r17, java.lang.String r18, android.os.CancellationSignal r19) {
        /*
            r0 = r18
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            android.net.Uri$Builder r2 = new android.net.Uri$Builder
            r2.<init>()
            java.lang.String r3 = "content"
            android.net.Uri$Builder r2 = r2.scheme(r3)
            android.net.Uri$Builder r2 = r2.authority(r0)
            android.net.Uri r5 = r2.build()
            android.net.Uri$Builder r2 = new android.net.Uri$Builder
            r2.<init>()
            android.net.Uri$Builder r2 = r2.scheme(r3)
            android.net.Uri$Builder r0 = r2.authority(r0)
            java.lang.String r2 = "file"
            android.net.Uri$Builder r0 = r0.appendPath(r2)
            android.net.Uri r0 = r0.build()
            r2 = r16
            androidx.core.provider.FontProvider$ContentQueryWrapper r4 = androidx.core.provider.b.a(r2, r5)
            r2 = 0
            java.lang.String r6 = "_id"
            java.lang.String r7 = "file_id"
            java.lang.String r8 = "font_ttc_index"
            java.lang.String r9 = "font_variation_settings"
            java.lang.String r10 = "font_weight"
            java.lang.String r11 = "font_italic"
            java.lang.String r12 = "result_code"
            java.lang.String[] r6 = new java.lang.String[]{r6, r7, r8, r9, r10, r11, r12}     // Catch:{ all -> 0x009a }
            java.lang.String r7 = "query = ?"
            java.lang.String r3 = r17.getQuery()     // Catch:{ all -> 0x009a }
            java.lang.String[] r8 = new java.lang.String[]{r3}     // Catch:{ all -> 0x009a }
            r9 = 0
            r10 = r19
            android.database.Cursor r2 = r4.query(r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x009a }
            if (r2 == 0) goto L_0x00e2
            int r6 = r2.getCount()     // Catch:{ all -> 0x009a }
            if (r6 <= 0) goto L_0x00e2
            java.lang.String r1 = "result_code"
            int r1 = r2.getColumnIndex(r1)     // Catch:{ all -> 0x009a }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x009a }
            r6.<init>()     // Catch:{ all -> 0x009a }
            java.lang.String r7 = "_id"
            int r7 = r2.getColumnIndex(r7)     // Catch:{ all -> 0x009a }
            java.lang.String r8 = "file_id"
            int r8 = r2.getColumnIndex(r8)     // Catch:{ all -> 0x009a }
            java.lang.String r9 = "font_ttc_index"
            int r9 = r2.getColumnIndex(r9)     // Catch:{ all -> 0x009a }
            java.lang.String r10 = "font_weight"
            int r10 = r2.getColumnIndex(r10)     // Catch:{ all -> 0x009a }
            java.lang.String r11 = "font_italic"
            int r11 = r2.getColumnIndex(r11)     // Catch:{ all -> 0x009a }
        L_0x008c:
            boolean r12 = r2.moveToNext()     // Catch:{ all -> 0x009a }
            if (r12 == 0) goto L_0x00de
            r12 = -1
            if (r1 == r12) goto L_0x009e
            int r13 = r2.getInt(r1)     // Catch:{ all -> 0x009a }
            goto L_0x009f
        L_0x009a:
            r0 = move-exception
            r16 = r4
            goto L_0x00f6
        L_0x009e:
            r13 = 0
        L_0x009f:
            if (r9 == r12) goto L_0x00a6
            int r14 = r2.getInt(r9)     // Catch:{ all -> 0x009a }
            goto L_0x00a7
        L_0x00a6:
            r14 = 0
        L_0x00a7:
            if (r8 != r12) goto L_0x00b6
            r16 = r4
            long r3 = r2.getLong(r7)     // Catch:{ all -> 0x00b4 }
            android.net.Uri r3 = android.content.ContentUris.withAppendedId(r5, r3)     // Catch:{ all -> 0x00b4 }
            goto L_0x00c0
        L_0x00b4:
            r0 = move-exception
            goto L_0x00f6
        L_0x00b6:
            r16 = r4
            long r3 = r2.getLong(r8)     // Catch:{ all -> 0x00b4 }
            android.net.Uri r3 = android.content.ContentUris.withAppendedId(r0, r3)     // Catch:{ all -> 0x00b4 }
        L_0x00c0:
            if (r10 == r12) goto L_0x00c7
            int r4 = r2.getInt(r10)     // Catch:{ all -> 0x00b4 }
            goto L_0x00c9
        L_0x00c7:
            r4 = 400(0x190, float:5.6E-43)
        L_0x00c9:
            if (r11 == r12) goto L_0x00d3
            int r12 = r2.getInt(r11)     // Catch:{ all -> 0x00b4 }
            r15 = 1
            if (r12 != r15) goto L_0x00d3
            goto L_0x00d4
        L_0x00d3:
            r15 = 0
        L_0x00d4:
            androidx.core.provider.FontsContractCompat$FontInfo r3 = androidx.core.provider.FontsContractCompat.FontInfo.create(r3, r14, r4, r15, r13)     // Catch:{ all -> 0x00b4 }
            r6.add(r3)     // Catch:{ all -> 0x00b4 }
            r4 = r16
            goto L_0x008c
        L_0x00de:
            r16 = r4
            r1 = r6
            goto L_0x00e4
        L_0x00e2:
            r16 = r4
        L_0x00e4:
            if (r2 == 0) goto L_0x00e9
            r2.close()
        L_0x00e9:
            r16.close()
            r0 = 0
            androidx.core.provider.FontsContractCompat$FontInfo[] r0 = new androidx.core.provider.FontsContractCompat.FontInfo[r0]
            java.lang.Object[] r0 = r1.toArray(r0)
            androidx.core.provider.FontsContractCompat$FontInfo[] r0 = (androidx.core.provider.FontsContractCompat.FontInfo[]) r0
            return r0
        L_0x00f6:
            if (r2 == 0) goto L_0x00fb
            r2.close()
        L_0x00fb:
            r16.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.FontProvider.query(android.content.Context, androidx.core.provider.FontRequest, java.lang.String, android.os.CancellationSignal):androidx.core.provider.FontsContractCompat$FontInfo[]");
    }
}
