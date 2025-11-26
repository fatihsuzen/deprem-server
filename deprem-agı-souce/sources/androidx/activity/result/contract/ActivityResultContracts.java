package androidx.activity.result.contract;

import W2.q;
import W2.s;
import W2.y;
import X2.C2242i;
import X2.C2250q;
import X2.M;
import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.CallSuper;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import e.b;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import q3.C2729e;

public final class ActivityResultContracts {

    public static class CaptureVideo extends ActivityResultContract<Uri, Boolean> {
        public final ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(Context context, Uri uri) {
            t.e(context, "context");
            t.e(uri, "input");
            return null;
        }

        @CallSuper
        public Intent createIntent(Context context, Uri uri) {
            t.e(context, "context");
            t.e(uri, "input");
            Intent putExtra = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", uri);
            t.d(putExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return putExtra;
        }

        public final Boolean parseResult(int i5, Intent intent) {
            return Boolean.valueOf(i5 == -1);
        }
    }

    @RequiresApi(19)
    public static class CreateDocument extends ActivityResultContract<String, Uri> {
        private final String mimeType;

        public CreateDocument(String str) {
            t.e(str, "mimeType");
            this.mimeType = str;
        }

        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, String str) {
            t.e(context, "context");
            t.e(str, "input");
            return null;
        }

        @CallSuper
        public Intent createIntent(Context context, String str) {
            t.e(context, "context");
            t.e(str, "input");
            Intent putExtra = new Intent("android.intent.action.CREATE_DOCUMENT").setType(this.mimeType).putExtra("android.intent.extra.TITLE", str);
            t.d(putExtra, "Intent(Intent.ACTION_CRE…ntent.EXTRA_TITLE, input)");
            return putExtra;
        }

        public final Uri parseResult(int i5, Intent intent) {
            if (i5 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }

        public CreateDocument() {
            this("*/*");
        }
    }

    public static class GetContent extends ActivityResultContract<String, Uri> {
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, String str) {
            t.e(context, "context");
            t.e(str, "input");
            return null;
        }

        @CallSuper
        public Intent createIntent(Context context, String str) {
            t.e(context, "context");
            t.e(str, "input");
            Intent type = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(str);
            t.d(type, "Intent(Intent.ACTION_GET…          .setType(input)");
            return type;
        }

        public final Uri parseResult(int i5, Intent intent) {
            if (i5 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @RequiresApi(18)
    public static class GetMultipleContents extends ActivityResultContract<String, List<Uri>> {
        public static final Companion Companion = new Companion((C2633k) null);

        @RequiresApi(18)
        public static final class Companion {
            public /* synthetic */ Companion(C2633k kVar) {
                this();
            }

            public final List<Uri> getClipDataUris$activity_release(Intent intent) {
                t.e(intent, "<this>");
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Uri data = intent.getData();
                if (data != null) {
                    linkedHashSet.add(data);
                }
                ClipData clipData = intent.getClipData();
                if (clipData == null && linkedHashSet.isEmpty()) {
                    return C2250q.g();
                }
                if (clipData != null) {
                    int itemCount = clipData.getItemCount();
                    for (int i5 = 0; i5 < itemCount; i5++) {
                        Uri uri = clipData.getItemAt(i5).getUri();
                        if (uri != null) {
                            linkedHashSet.add(uri);
                        }
                    }
                }
                return new ArrayList(linkedHashSet);
            }

            private Companion() {
            }
        }

        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(Context context, String str) {
            t.e(context, "context");
            t.e(str, "input");
            return null;
        }

        @CallSuper
        public Intent createIntent(Context context, String str) {
            t.e(context, "context");
            t.e(str, "input");
            Intent putExtra = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(str).putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            t.d(putExtra, "Intent(Intent.ACTION_GET…TRA_ALLOW_MULTIPLE, true)");
            return putExtra;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0007, code lost:
            r2 = Companion.getClipDataUris$activity_release(r3);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.List<android.net.Uri> parseResult(int r2, android.content.Intent r3) {
            /*
                r1 = this;
                r0 = -1
                if (r2 != r0) goto L_0x0004
                goto L_0x0005
            L_0x0004:
                r3 = 0
            L_0x0005:
                if (r3 == 0) goto L_0x0010
                androidx.activity.result.contract.ActivityResultContracts$GetMultipleContents$Companion r2 = Companion
                java.util.List r2 = r2.getClipDataUris$activity_release(r3)
                if (r2 == 0) goto L_0x0010
                return r2
            L_0x0010:
                java.util.List r2 = X2.C2250q.g()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.activity.result.contract.ActivityResultContracts.GetMultipleContents.parseResult(int, android.content.Intent):java.util.List");
        }
    }

    @RequiresApi(19)
    public static class OpenDocument extends ActivityResultContract<String[], Uri> {
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, String[] strArr) {
            t.e(context, "context");
            t.e(strArr, "input");
            return null;
        }

        @CallSuper
        public Intent createIntent(Context context, String[] strArr) {
            t.e(context, "context");
            t.e(strArr, "input");
            Intent type = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", strArr).setType("*/*");
            t.d(type, "Intent(Intent.ACTION_OPE…          .setType(\"*/*\")");
            return type;
        }

        public final Uri parseResult(int i5, Intent intent) {
            if (i5 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @RequiresApi(21)
    public static class OpenDocumentTree extends ActivityResultContract<Uri, Uri> {
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, Uri uri) {
            t.e(context, "context");
            return null;
        }

        @CallSuper
        public Intent createIntent(Context context, Uri uri) {
            t.e(context, "context");
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            if (Build.VERSION.SDK_INT >= 26 && uri != null) {
                intent.putExtra("android.provider.extra.INITIAL_URI", uri);
            }
            return intent;
        }

        public final Uri parseResult(int i5, Intent intent) {
            if (i5 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @RequiresApi(19)
    public static class OpenMultipleDocuments extends ActivityResultContract<String[], List<Uri>> {
        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(Context context, String[] strArr) {
            t.e(context, "context");
            t.e(strArr, "input");
            return null;
        }

        @CallSuper
        public Intent createIntent(Context context, String[] strArr) {
            t.e(context, "context");
            t.e(strArr, "input");
            Intent type = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", strArr).putExtra("android.intent.extra.ALLOW_MULTIPLE", true).setType("*/*");
            t.d(type, "Intent(Intent.ACTION_OPE…          .setType(\"*/*\")");
            return type;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0007, code lost:
            r2 = androidx.activity.result.contract.ActivityResultContracts.GetMultipleContents.Companion.getClipDataUris$activity_release(r3);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.List<android.net.Uri> parseResult(int r2, android.content.Intent r3) {
            /*
                r1 = this;
                r0 = -1
                if (r2 != r0) goto L_0x0004
                goto L_0x0005
            L_0x0004:
                r3 = 0
            L_0x0005:
                if (r3 == 0) goto L_0x0010
                androidx.activity.result.contract.ActivityResultContracts$GetMultipleContents$Companion r2 = androidx.activity.result.contract.ActivityResultContracts.GetMultipleContents.Companion
                java.util.List r2 = r2.getClipDataUris$activity_release(r3)
                if (r2 == 0) goto L_0x0010
                return r2
            L_0x0010:
                java.util.List r2 = X2.C2250q.g()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.activity.result.contract.ActivityResultContracts.OpenMultipleDocuments.parseResult(int, android.content.Intent):java.util.List");
        }
    }

    public static final class PickContact extends ActivityResultContract<Void, Uri> {
        public Intent createIntent(Context context, Void voidR) {
            t.e(context, "context");
            Intent type = new Intent("android.intent.action.PICK").setType("vnd.android.cursor.dir/contact");
            t.d(type, "Intent(Intent.ACTION_PIC…ct.Contacts.CONTENT_TYPE)");
            return type;
        }

        public Uri parseResult(int i5, Intent intent) {
            if (i5 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @RequiresApi(19)
    public static class PickMultipleVisualMedia extends ActivityResultContract<PickVisualMediaRequest, List<Uri>> {
        public static final Companion Companion = new Companion((C2633k) null);
        private final int maxItems;

        public static final class Companion {
            public /* synthetic */ Companion(C2633k kVar) {
                this();
            }

            @SuppressLint({"NewApi", "ClassVerificationFailure"})
            public final int getMaxItems$activity_release() {
                if (PickVisualMedia.Companion.isSystemPickerAvailable$activity_release()) {
                    return MediaStore.getPickImagesMaxLimit();
                }
                return Integer.MAX_VALUE;
            }

            private Companion() {
            }
        }

        public PickMultipleVisualMedia() {
            this(0, 1, (C2633k) null);
        }

        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(Context context, PickVisualMediaRequest pickVisualMediaRequest) {
            t.e(context, "context");
            t.e(pickVisualMediaRequest, "input");
            return null;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ PickMultipleVisualMedia(int i5, int i6, C2633k kVar) {
            this((i6 & 1) != 0 ? Companion.getMaxItems$activity_release() : i5);
        }

        @CallSuper
        @SuppressLint({"NewApi", "ClassVerificationFailure"})
        public Intent createIntent(Context context, PickVisualMediaRequest pickVisualMediaRequest) {
            t.e(context, "context");
            t.e(pickVisualMediaRequest, "input");
            PickVisualMedia.Companion companion = PickVisualMedia.Companion;
            if (companion.isSystemPickerAvailable$activity_release()) {
                Intent intent = new Intent("android.provider.action.PICK_IMAGES");
                intent.setType(companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                if (this.maxItems <= MediaStore.getPickImagesMaxLimit()) {
                    intent.putExtra("android.provider.extra.PICK_IMAGES_MAX", this.maxItems);
                    return intent;
                }
                throw new IllegalArgumentException("Max items must be less or equals MediaStore.getPickImagesMaxLimit()");
            } else if (companion.isSystemFallbackPickerAvailable$activity_release(context)) {
                ResolveInfo systemFallbackPicker$activity_release = companion.getSystemFallbackPicker$activity_release(context);
                if (systemFallbackPicker$activity_release != null) {
                    ActivityInfo activityInfo = systemFallbackPicker$activity_release.activityInfo;
                    Intent intent2 = new Intent(PickVisualMedia.ACTION_SYSTEM_FALLBACK_PICK_IMAGES);
                    intent2.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
                    intent2.setType(companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                    intent2.putExtra(PickVisualMedia.GMS_EXTRA_PICK_IMAGES_MAX, this.maxItems);
                    return intent2;
                }
                throw new IllegalStateException("Required value was null.");
            } else if (companion.isGmsPickerAvailable$activity_release(context)) {
                ResolveInfo gmsPicker$activity_release = companion.getGmsPicker$activity_release(context);
                if (gmsPicker$activity_release != null) {
                    ActivityInfo activityInfo2 = gmsPicker$activity_release.activityInfo;
                    Intent intent3 = new Intent(PickVisualMedia.GMS_ACTION_PICK_IMAGES);
                    intent3.setClassName(activityInfo2.applicationInfo.packageName, activityInfo2.name);
                    intent3.putExtra(PickVisualMedia.GMS_EXTRA_PICK_IMAGES_MAX, this.maxItems);
                    return intent3;
                }
                throw new IllegalStateException("Required value was null.");
            } else {
                Intent intent4 = new Intent("android.intent.action.OPEN_DOCUMENT");
                intent4.setType(companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                intent4.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                if (intent4.getType() == null) {
                    intent4.setType("*/*");
                    intent4.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
                }
                return intent4;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0007, code lost:
            r2 = androidx.activity.result.contract.ActivityResultContracts.GetMultipleContents.Companion.getClipDataUris$activity_release(r3);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.List<android.net.Uri> parseResult(int r2, android.content.Intent r3) {
            /*
                r1 = this;
                r0 = -1
                if (r2 != r0) goto L_0x0004
                goto L_0x0005
            L_0x0004:
                r3 = 0
            L_0x0005:
                if (r3 == 0) goto L_0x0010
                androidx.activity.result.contract.ActivityResultContracts$GetMultipleContents$Companion r2 = androidx.activity.result.contract.ActivityResultContracts.GetMultipleContents.Companion
                java.util.List r2 = r2.getClipDataUris$activity_release(r3)
                if (r2 == 0) goto L_0x0010
                return r2
            L_0x0010:
                java.util.List r2 = X2.C2250q.g()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.activity.result.contract.ActivityResultContracts.PickMultipleVisualMedia.parseResult(int, android.content.Intent):java.util.List");
        }

        public PickMultipleVisualMedia(int i5) {
            this.maxItems = i5;
            if (i5 <= 1) {
                throw new IllegalArgumentException("Max items must be higher than 1");
            }
        }
    }

    @RequiresApi(19)
    public static class PickVisualMedia extends ActivityResultContract<PickVisualMediaRequest, Uri> {
        public static final String ACTION_SYSTEM_FALLBACK_PICK_IMAGES = "androidx.activity.result.contract.action.PICK_IMAGES";
        public static final Companion Companion = new Companion((C2633k) null);
        public static final String EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_MAX = "androidx.activity.result.contract.extra.PICK_IMAGES_MAX";
        public static final String GMS_ACTION_PICK_IMAGES = "com.google.android.gms.provider.action.PICK_IMAGES";
        public static final String GMS_EXTRA_PICK_IMAGES_MAX = "com.google.android.gms.provider.extra.PICK_IMAGES_MAX";

        public static final class Companion {
            public /* synthetic */ Companion(C2633k kVar) {
                this();
            }

            public static /* synthetic */ void getACTION_SYSTEM_FALLBACK_PICK_IMAGES$annotations() {
            }

            public static /* synthetic */ void getEXTRA_SYSTEM_FALLBACK_PICK_IMAGES_MAX$annotations() {
            }

            public final ResolveInfo getGmsPicker$activity_release(Context context) {
                t.e(context, "context");
                return context.getPackageManager().resolveActivity(new Intent(PickVisualMedia.GMS_ACTION_PICK_IMAGES), 1114112);
            }

            public final ResolveInfo getSystemFallbackPicker$activity_release(Context context) {
                t.e(context, "context");
                return context.getPackageManager().resolveActivity(new Intent(PickVisualMedia.ACTION_SYSTEM_FALLBACK_PICK_IMAGES), 1114112);
            }

            public final String getVisualMimeType$activity_release(VisualMediaType visualMediaType) {
                t.e(visualMediaType, "input");
                if (visualMediaType instanceof ImageOnly) {
                    return "image/*";
                }
                if (visualMediaType instanceof VideoOnly) {
                    return "video/*";
                }
                if (visualMediaType instanceof SingleMimeType) {
                    return ((SingleMimeType) visualMediaType).getMimeType();
                }
                if (visualMediaType instanceof ImageAndVideo) {
                    return null;
                }
                throw new q();
            }

            public final boolean isGmsPickerAvailable$activity_release(Context context) {
                t.e(context, "context");
                if (getGmsPicker$activity_release(context) != null) {
                    return true;
                }
                return false;
            }

            @SuppressLint({"ClassVerificationFailure", "NewApi"})
            public final boolean isPhotoPickerAvailable() {
                return isSystemPickerAvailable$activity_release();
            }

            public final boolean isSystemFallbackPickerAvailable$activity_release(Context context) {
                t.e(context, "context");
                if (getSystemFallbackPicker$activity_release(context) != null) {
                    return true;
                }
                return false;
            }

            @SuppressLint({"ClassVerificationFailure", "NewApi"})
            public final boolean isSystemPickerAvailable$activity_release() {
                int i5 = Build.VERSION.SDK_INT;
                if (i5 >= 33) {
                    return true;
                }
                if (i5 < 30 || b.a(30) < 2) {
                    return false;
                }
                return true;
            }

            private Companion() {
            }

            @SuppressLint({"ClassVerificationFailure", "NewApi"})
            public final boolean isPhotoPickerAvailable(Context context) {
                t.e(context, "context");
                return isSystemPickerAvailable$activity_release() || isSystemFallbackPickerAvailable$activity_release(context) || isGmsPickerAvailable$activity_release(context);
            }
        }

        public static final class ImageAndVideo implements VisualMediaType {
            public static final ImageAndVideo INSTANCE = new ImageAndVideo();

            private ImageAndVideo() {
            }
        }

        public static final class ImageOnly implements VisualMediaType {
            public static final ImageOnly INSTANCE = new ImageOnly();

            private ImageOnly() {
            }
        }

        public static final class SingleMimeType implements VisualMediaType {
            private final String mimeType;

            public SingleMimeType(String str) {
                t.e(str, "mimeType");
                this.mimeType = str;
            }

            public final String getMimeType() {
                return this.mimeType;
            }
        }

        public static final class VideoOnly implements VisualMediaType {
            public static final VideoOnly INSTANCE = new VideoOnly();

            private VideoOnly() {
            }
        }

        public interface VisualMediaType {
        }

        public static final ResolveInfo getGmsPicker$activity_release(Context context) {
            return Companion.getGmsPicker$activity_release(context);
        }

        public static final ResolveInfo getSystemFallbackPicker$activity_release(Context context) {
            return Companion.getSystemFallbackPicker$activity_release(context);
        }

        public static final boolean isGmsPickerAvailable$activity_release(Context context) {
            return Companion.isGmsPickerAvailable$activity_release(context);
        }

        @SuppressLint({"ClassVerificationFailure", "NewApi"})
        public static final boolean isPhotoPickerAvailable() {
            return Companion.isPhotoPickerAvailable();
        }

        public static final boolean isSystemFallbackPickerAvailable$activity_release(Context context) {
            return Companion.isSystemFallbackPickerAvailable$activity_release(context);
        }

        @SuppressLint({"ClassVerificationFailure", "NewApi"})
        public static final boolean isSystemPickerAvailable$activity_release() {
            return Companion.isSystemPickerAvailable$activity_release();
        }

        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, PickVisualMediaRequest pickVisualMediaRequest) {
            t.e(context, "context");
            t.e(pickVisualMediaRequest, "input");
            return null;
        }

        @SuppressLint({"ClassVerificationFailure", "NewApi"})
        public static final boolean isPhotoPickerAvailable(Context context) {
            return Companion.isPhotoPickerAvailable(context);
        }

        @CallSuper
        public Intent createIntent(Context context, PickVisualMediaRequest pickVisualMediaRequest) {
            t.e(context, "context");
            t.e(pickVisualMediaRequest, "input");
            Companion companion = Companion;
            if (companion.isSystemPickerAvailable$activity_release()) {
                Intent intent = new Intent("android.provider.action.PICK_IMAGES");
                intent.setType(companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                return intent;
            } else if (companion.isSystemFallbackPickerAvailable$activity_release(context)) {
                ResolveInfo systemFallbackPicker$activity_release = companion.getSystemFallbackPicker$activity_release(context);
                if (systemFallbackPicker$activity_release != null) {
                    ActivityInfo activityInfo = systemFallbackPicker$activity_release.activityInfo;
                    Intent intent2 = new Intent(ACTION_SYSTEM_FALLBACK_PICK_IMAGES);
                    intent2.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
                    intent2.setType(companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                    return intent2;
                }
                throw new IllegalStateException("Required value was null.");
            } else if (companion.isGmsPickerAvailable$activity_release(context)) {
                ResolveInfo gmsPicker$activity_release = companion.getGmsPicker$activity_release(context);
                if (gmsPicker$activity_release != null) {
                    ActivityInfo activityInfo2 = gmsPicker$activity_release.activityInfo;
                    Intent intent3 = new Intent(GMS_ACTION_PICK_IMAGES);
                    intent3.setClassName(activityInfo2.applicationInfo.packageName, activityInfo2.name);
                    intent3.setType(companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                    return intent3;
                }
                throw new IllegalStateException("Required value was null.");
            } else {
                Intent intent4 = new Intent("android.intent.action.OPEN_DOCUMENT");
                intent4.setType(companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                if (intent4.getType() == null) {
                    intent4.setType("*/*");
                    intent4.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
                }
                return intent4;
            }
        }

        public final Uri parseResult(int i5, Intent intent) {
            if (i5 != -1) {
                intent = null;
            }
            if (intent == null) {
                return null;
            }
            Uri data = intent.getData();
            return data == null ? (Uri) C2250q.O(GetMultipleContents.Companion.getClipDataUris$activity_release(intent)) : data;
        }
    }

    public static final class RequestMultiplePermissions extends ActivityResultContract<String[], Map<String, Boolean>> {
        public static final String ACTION_REQUEST_PERMISSIONS = "androidx.activity.result.contract.action.REQUEST_PERMISSIONS";
        public static final Companion Companion = new Companion((C2633k) null);
        public static final String EXTRA_PERMISSIONS = "androidx.activity.result.contract.extra.PERMISSIONS";
        public static final String EXTRA_PERMISSION_GRANT_RESULTS = "androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS";

        public static final class Companion {
            public /* synthetic */ Companion(C2633k kVar) {
                this();
            }

            public final Intent createIntent$activity_release(String[] strArr) {
                t.e(strArr, "input");
                Intent putExtra = new Intent(RequestMultiplePermissions.ACTION_REQUEST_PERMISSIONS).putExtra(RequestMultiplePermissions.EXTRA_PERMISSIONS, strArr);
                t.d(putExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
                return putExtra;
            }

            private Companion() {
            }
        }

        public Intent createIntent(Context context, String[] strArr) {
            t.e(context, "context");
            t.e(strArr, "input");
            return Companion.createIntent$activity_release(strArr);
        }

        public ActivityResultContract.SynchronousResult<Map<String, Boolean>> getSynchronousResult(Context context, String[] strArr) {
            t.e(context, "context");
            t.e(strArr, "input");
            if (strArr.length == 0) {
                return new ActivityResultContract.SynchronousResult<>(M.h());
            }
            for (String checkSelfPermission : strArr) {
                if (ContextCompat.checkSelfPermission(context, checkSelfPermission) != 0) {
                    return null;
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(C2729e.c(M.e(strArr.length), 16));
            for (String a5 : strArr) {
                s a6 = y.a(a5, Boolean.TRUE);
                linkedHashMap.put(a6.c(), a6.d());
            }
            return new ActivityResultContract.SynchronousResult<>(linkedHashMap);
        }

        public Map<String, Boolean> parseResult(int i5, Intent intent) {
            if (i5 != -1) {
                return M.h();
            }
            if (intent == null) {
                return M.h();
            }
            String[] stringArrayExtra = intent.getStringArrayExtra(EXTRA_PERMISSIONS);
            int[] intArrayExtra = intent.getIntArrayExtra(EXTRA_PERMISSION_GRANT_RESULTS);
            if (intArrayExtra == null || stringArrayExtra == null) {
                return M.h();
            }
            ArrayList arrayList = new ArrayList(intArrayExtra.length);
            int length = intArrayExtra.length;
            for (int i6 = 0; i6 < length; i6++) {
                arrayList.add(Boolean.valueOf(intArrayExtra[i6] == 0));
            }
            return M.r(C2250q.s0(C2242i.O(stringArrayExtra), arrayList));
        }
    }

    public static final class RequestPermission extends ActivityResultContract<String, Boolean> {
        public Intent createIntent(Context context, String str) {
            t.e(context, "context");
            t.e(str, "input");
            return RequestMultiplePermissions.Companion.createIntent$activity_release(new String[]{str});
        }

        public ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(Context context, String str) {
            t.e(context, "context");
            t.e(str, "input");
            if (ContextCompat.checkSelfPermission(context, str) == 0) {
                return new ActivityResultContract.SynchronousResult<>(Boolean.TRUE);
            }
            return null;
        }

        public Boolean parseResult(int i5, Intent intent) {
            if (intent == null || i5 != -1) {
                return Boolean.FALSE;
            }
            int[] intArrayExtra = intent.getIntArrayExtra(RequestMultiplePermissions.EXTRA_PERMISSION_GRANT_RESULTS);
            boolean z4 = false;
            if (intArrayExtra != null) {
                int length = intArrayExtra.length;
                int i6 = 0;
                while (true) {
                    if (i6 >= length) {
                        break;
                    } else if (intArrayExtra[i6] == 0) {
                        z4 = true;
                        break;
                    } else {
                        i6++;
                    }
                }
            }
            return Boolean.valueOf(z4);
        }
    }

    public static final class StartActivityForResult extends ActivityResultContract<Intent, ActivityResult> {
        public static final Companion Companion = new Companion((C2633k) null);
        public static final String EXTRA_ACTIVITY_OPTIONS_BUNDLE = "androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE";

        public static final class Companion {
            public /* synthetic */ Companion(C2633k kVar) {
                this();
            }

            private Companion() {
            }
        }

        public Intent createIntent(Context context, Intent intent) {
            t.e(context, "context");
            t.e(intent, "input");
            return intent;
        }

        public ActivityResult parseResult(int i5, Intent intent) {
            return new ActivityResult(i5, intent);
        }
    }

    public static final class StartIntentSenderForResult extends ActivityResultContract<IntentSenderRequest, ActivityResult> {
        public static final String ACTION_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.action.INTENT_SENDER_REQUEST";
        public static final Companion Companion = new Companion((C2633k) null);
        public static final String EXTRA_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST";
        public static final String EXTRA_SEND_INTENT_EXCEPTION = "androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION";

        public static final class Companion {
            public /* synthetic */ Companion(C2633k kVar) {
                this();
            }

            private Companion() {
            }
        }

        public Intent createIntent(Context context, IntentSenderRequest intentSenderRequest) {
            t.e(context, "context");
            t.e(intentSenderRequest, "input");
            Intent putExtra = new Intent(ACTION_INTENT_SENDER_REQUEST).putExtra(EXTRA_INTENT_SENDER_REQUEST, intentSenderRequest);
            t.d(putExtra, "Intent(ACTION_INTENT_SEN…NT_SENDER_REQUEST, input)");
            return putExtra;
        }

        public ActivityResult parseResult(int i5, Intent intent) {
            return new ActivityResult(i5, intent);
        }
    }

    public static class TakePicture extends ActivityResultContract<Uri, Boolean> {
        public final ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(Context context, Uri uri) {
            t.e(context, "context");
            t.e(uri, "input");
            return null;
        }

        @CallSuper
        public Intent createIntent(Context context, Uri uri) {
            t.e(context, "context");
            t.e(uri, "input");
            Intent putExtra = new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", uri);
            t.d(putExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return putExtra;
        }

        public final Boolean parseResult(int i5, Intent intent) {
            return Boolean.valueOf(i5 == -1);
        }
    }

    public static class TakePicturePreview extends ActivityResultContract<Void, Bitmap> {
        public final ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(Context context, Void voidR) {
            t.e(context, "context");
            return null;
        }

        @CallSuper
        public Intent createIntent(Context context, Void voidR) {
            t.e(context, "context");
            return new Intent("android.media.action.IMAGE_CAPTURE");
        }

        public final Bitmap parseResult(int i5, Intent intent) {
            if (i5 != -1) {
                intent = null;
            }
            if (intent != null) {
                return (Bitmap) intent.getParcelableExtra(DataSchemeDataSource.SCHEME_DATA);
            }
            return null;
        }
    }

    public static class TakeVideo extends ActivityResultContract<Uri, Bitmap> {
        public final ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(Context context, Uri uri) {
            t.e(context, "context");
            t.e(uri, "input");
            return null;
        }

        @CallSuper
        public Intent createIntent(Context context, Uri uri) {
            t.e(context, "context");
            t.e(uri, "input");
            Intent putExtra = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", uri);
            t.d(putExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return putExtra;
        }

        public final Bitmap parseResult(int i5, Intent intent) {
            if (i5 != -1) {
                intent = null;
            }
            if (intent != null) {
                return (Bitmap) intent.getParcelableExtra(DataSchemeDataSource.SCHEME_DATA);
            }
            return null;
        }
    }

    private ActivityResultContracts() {
    }
}
