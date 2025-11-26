package b2;

import T1.C2194t;
import W2.J;
import W2.u;
import Y1.g;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.text.format.DateFormat;
import androidx.documentfile.provider.DocumentFile;
import b2.C2279K;
import b3.C2308e;
import c3.C2316b;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;
import k3.C2616a;
import k3.p;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2625c;
import kotlin.jvm.internal.t;
import t3.s;
import w3.C2865c0;
import w3.C2872g;
import w3.M;

/* renamed from: b2.i  reason: case insensitive filesystem */
public final class C2289i {

    /* renamed from: b2.i$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20693a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f20694b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f20695c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context, String str, C2308e eVar) {
            super(2, eVar);
            this.f20694b = context;
            this.f20695c = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f20694b, this.f20695c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f20693a == 0) {
                u.b(obj);
                Context context = this.f20694b;
                if (context instanceof C2194t) {
                    ((C2194t) context).u0(this.f20695c);
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: b2.i$b */
    static final class b extends d {

        /* renamed from: a  reason: collision with root package name */
        int f20696a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f20697b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2289i f20698c;

        /* renamed from: d  reason: collision with root package name */
        int f20699d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C2289i iVar, C2308e eVar) {
            super(eVar);
            this.f20698c = iVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f20697b = obj;
            this.f20699d |= Integer.MIN_VALUE;
            return this.f20698c.f((Object) null, (String) null, (Context) null, (C2616a) null, this);
        }
    }

    /* renamed from: b2.i$c */
    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20700a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f20701b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f20702c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2616a f20703d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Context context, String str, C2616a aVar, C2308e eVar) {
            super(2, eVar);
            this.f20701b = context;
            this.f20702c = str;
            this.f20703d = aVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f20701b, this.f20702c, this.f20703d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f20700a == 0) {
                u.b(obj);
                Context context = this.f20701b;
                if (context instanceof C2194t) {
                    ((C2194t) context).u0(this.f20702c);
                }
                this.f20703d.invoke();
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    private final boolean c(String str) {
        return !s.T(str, "Backups", true);
    }

    private final Object e(Context context, String str, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.c(), new a(context, str, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final J g(C2616a aVar) {
        aVar.invoke();
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final J h(C2616a aVar) {
        aVar.invoke();
        return J.f19942a;
    }

    private final Object i(Context context, String str, C2616a aVar, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.c(), new c(context, str, aVar, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    private final ArrayList n(Context context) {
        ArrayList arrayList = new ArrayList();
        ArrayList b5 = new C2277I().b(context);
        if (b5.size() > 0) {
            Iterator it = b5.iterator();
            t.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                t.d(next, "next(...)");
                File file = new File(((g) next).b());
                if (file.exists() && file.isDirectory()) {
                    arrayList.addAll(m(file, context));
                }
            }
            return arrayList;
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        t.b(externalStorageDirectory);
        arrayList.addAll(m(externalStorageDirectory, context));
        return arrayList;
    }

    private final ArrayList r(ArrayList arrayList, Context context) {
        ArrayList arrayList2 = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        t.d(packageManager, "getPackageManager(...)");
        Iterator it = arrayList.iterator();
        t.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            File file = (File) next;
            String name = file.getName();
            t.d(name, "getName(...)");
            if (!s.P(name, ".", false, 2, (Object) null)) {
                String name2 = file.getName();
                t.d(name2, "getName(...)");
                if (s.D(name2, ".apk", false, 2, (Object) null)) {
                    String absolutePath = file.getAbsolutePath();
                    t.d(absolutePath, "getAbsolutePath(...)");
                    PackageInfo c5 = C2301u.c(packageManager, absolutePath, 128);
                    if (c5 == null) {
                        String name3 = file.getName();
                        t.d(name3, "getName(...)");
                        if (!s.P(name3, "split_config", false, 2, (Object) null)) {
                            arrayList2.add(file);
                        }
                    } else if (!o(c5)) {
                        arrayList2.add(file);
                    }
                } else {
                    C2279K.a aVar = C2279K.f20490b;
                    String name4 = file.getName();
                    t.d(name4, "getName(...)");
                    if (aVar.a(name4)) {
                        arrayList2.add(file);
                    }
                }
            }
        }
        return arrayList2;
    }

    public final String d(Object obj) {
        t.e(obj, "directory");
        int i5 = 0;
        if (obj instanceof File) {
            File[] listFiles = ((File) obj).listFiles();
            if (listFiles != null) {
                i5 = listFiles.length;
            }
        } else if (obj instanceof DocumentFile) {
            i5 = ((DocumentFile) obj).listFiles().length;
        }
        return String.valueOf(i5);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0091, code lost:
        if (r10.i(r12, r11, r14, r0) == r1) goto L_0x0112;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ae, code lost:
        if (r10.e(r12, r11, r0) == r1) goto L_0x0112;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c7, code lost:
        if (r10.e(r12, r11, r0) == r1) goto L_0x0112;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00f7, code lost:
        if (r10.i(r12, r11, r14, r0) == r1) goto L_0x0112;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0110, code lost:
        if (r10.e(r12, r11, r0) == r1) goto L_0x0112;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object f(java.lang.Object r10, java.lang.String r11, android.content.Context r12, k3.C2616a r13, b3.C2308e r14) {
        /*
            r9 = this;
            boolean r0 = r14 instanceof b2.C2289i.b
            if (r0 == 0) goto L_0x0013
            r0 = r14
            b2.i$b r0 = (b2.C2289i.b) r0
            int r1 = r0.f20699d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f20699d = r1
            goto L_0x0018
        L_0x0013:
            b2.i$b r0 = new b2.i$b
            r0.<init>(r9, r14)
        L_0x0018:
            java.lang.Object r14 = r0.f20697b
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f20699d
            r3 = 0
            r4 = 5
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = 1
            if (r2 == 0) goto L_0x0042
            if (r2 == r8) goto L_0x003b
            if (r2 == r7) goto L_0x003b
            if (r2 == r6) goto L_0x003b
            if (r2 == r5) goto L_0x003b
            if (r2 != r4) goto L_0x0033
            goto L_0x003b
        L_0x0033:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x003b:
            int r10 = r0.f20696a
            W2.u.b(r14)
            goto L_0x0114
        L_0x0042:
            W2.u.b(r14)
            boolean r14 = r10 instanceof java.io.File
            java.lang.String r2 = "getString(...)"
            if (r14 == 0) goto L_0x00ca
            java.io.File r14 = new java.io.File
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.io.File r10 = (java.io.File) r10
            java.lang.String r10 = r10.getAbsolutePath()
            r4.append(r10)
            r10 = 47
            r4.append(r10)
            r4.append(r11)
            java.lang.String r10 = r4.toString()
            r14.<init>(r10)
            boolean r10 = r14.exists()
            if (r10 != 0) goto L_0x00b1
            boolean r10 = r14.mkdir()
            if (r10 == 0) goto L_0x0098
            b2.i r10 = new b2.i
            r10.<init>()
            int r11 = S1.i.core_create_dialog_folder_created
            java.lang.String r11 = r12.getString(r11)
            kotlin.jvm.internal.t.d(r11, r2)
            b2.g r14 = new b2.g
            r14.<init>(r13)
            r0.f20696a = r8
            r0.f20699d = r8
            java.lang.Object r10 = r10.i(r12, r11, r14, r0)
            if (r10 != r1) goto L_0x0095
            goto L_0x0112
        L_0x0095:
            r10 = r8
            goto L_0x0114
        L_0x0098:
            b2.i r10 = new b2.i
            r10.<init>()
            int r11 = S1.i.core_create_dialog_folder_error
            java.lang.String r11 = r12.getString(r11)
            kotlin.jvm.internal.t.d(r11, r2)
            r0.f20696a = r3
            r0.f20699d = r7
            java.lang.Object r10 = r10.e(r12, r11, r0)
            if (r10 != r1) goto L_0x0113
            goto L_0x0112
        L_0x00b1:
            b2.i r10 = new b2.i
            r10.<init>()
            int r11 = S1.i.core_create_dialog_already_exists
            java.lang.String r11 = r12.getString(r11)
            kotlin.jvm.internal.t.d(r11, r2)
            r0.f20696a = r3
            r0.f20699d = r6
            java.lang.Object r10 = r10.e(r12, r11, r0)
            if (r10 != r1) goto L_0x0113
            goto L_0x0112
        L_0x00ca:
            boolean r14 = r10 instanceof androidx.documentfile.provider.DocumentFile
            if (r14 == 0) goto L_0x0113
            androidx.documentfile.provider.DocumentFile r10 = (androidx.documentfile.provider.DocumentFile) r10
            androidx.documentfile.provider.DocumentFile r10 = r10.createDirectory(r11)
            if (r10 == 0) goto L_0x00fa
            boolean r10 = r10.exists()
            if (r10 == 0) goto L_0x00fa
            b2.i r10 = new b2.i
            r10.<init>()
            int r11 = S1.i.core_create_dialog_folder_created
            java.lang.String r11 = r12.getString(r11)
            kotlin.jvm.internal.t.d(r11, r2)
            b2.h r14 = new b2.h
            r14.<init>(r13)
            r0.f20696a = r8
            r0.f20699d = r5
            java.lang.Object r10 = r10.i(r12, r11, r14, r0)
            if (r10 != r1) goto L_0x0095
            goto L_0x0112
        L_0x00fa:
            b2.i r10 = new b2.i
            r10.<init>()
            int r11 = S1.i.core_create_dialog_folder_error
            java.lang.String r11 = r12.getString(r11)
            kotlin.jvm.internal.t.d(r11, r2)
            r0.f20696a = r3
            r0.f20699d = r4
            java.lang.Object r10 = r10.e(r12, r11, r0)
            if (r10 != r1) goto L_0x0113
        L_0x0112:
            return r1
        L_0x0113:
            r10 = r3
        L_0x0114:
            if (r10 == 0) goto L_0x0117
            r3 = r8
        L_0x0117:
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.b.a(r3)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.C2289i.f(java.lang.Object, java.lang.String, android.content.Context, k3.a, b3.e):java.lang.Object");
    }

    public final long j(String str) {
        t.e(str, "realPath");
        try {
            return new File(str).length();
        } catch (Exception unused) {
            return -1;
        }
    }

    public final String k(long j5) {
        Calendar instance = Calendar.getInstance(Locale.FRANCE);
        instance.setTimeInMillis(j5);
        return DateFormat.format("dd MMM yyyy hh:mm", instance).toString();
    }

    public final long l(File file) {
        File[] fileArr;
        t.e(file, "dir");
        if (!file.isDirectory()) {
            return file.length();
        }
        try {
            fileArr = file.listFiles();
        } catch (SecurityException e5) {
            e5.printStackTrace();
            fileArr = null;
        }
        long j5 = 0;
        if (fileArr != null) {
            Iterator a5 = C2625c.a(fileArr);
            while (a5.hasNext()) {
                j5 += l((File) a5.next());
            }
        }
        return j5;
    }

    public final ArrayList m(File file, Context context) {
        t.e(file, "directory");
        t.e(context, "context");
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            String packageName = context.getPackageName();
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    String absolutePath = file2.getAbsolutePath();
                    t.d(absolutePath, "getAbsolutePath(...)");
                    if (!s.D(absolutePath, "Android/data/" + packageName, false, 2, (Object) null)) {
                        String name = file2.getName();
                        t.d(name, "getName(...)");
                        if (c(name)) {
                            t.b(file2);
                            arrayList.addAll(m(file2, context));
                        }
                    }
                } else {
                    String name2 = file2.getName();
                    t.d(name2, "getName(...)");
                    if (p(name2)) {
                        arrayList.add(file2);
                    }
                }
            }
        }
        return arrayList;
    }

    public final boolean o(PackageInfo packageInfo) {
        Bundle bundle;
        t.e(packageInfo, "pi");
        try {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo != null) {
                bundle = applicationInfo.metaData;
            } else {
                bundle = null;
            }
            if (bundle != null) {
                t.b(applicationInfo);
                if (applicationInfo.metaData.containsKey("com.android.vending.splits.required")) {
                    ApplicationInfo applicationInfo2 = packageInfo.applicationInfo;
                    t.b(applicationInfo2);
                    return applicationInfo2.metaData.getBoolean("com.android.vending.splits.required");
                }
            }
            return false;
        } catch (Exception e5) {
            e5.printStackTrace();
            return false;
        }
    }

    public final boolean p(String str) {
        t.e(str, RewardPlus.NAME);
        if ((s.D(str, ".apk", false, 2, (Object) null) || C2279K.f20490b.a(str)) && !s.P(str, ".", false, 2, (Object) null)) {
            return true;
        }
        return false;
    }

    public final String q(String str) {
        t.e(str, "fileName");
        return new t3.p("[/\\\\:*?\"<>|]").h(str, "");
    }

    public final ArrayList s(Context context) {
        t.e(context, "context");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(n(context));
        return r(arrayList, context);
    }
}
