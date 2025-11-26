package com.uptodown.core.activities;

import S1.e;
import S1.f;
import S1.g;
import S1.i;
import S1.j;
import S1.k;
import T1.C2152A;
import T1.C2153B;
import T1.C2154C;
import T1.C2155D;
import T1.C2156E;
import T1.C2158a0;
import T1.C2200z;
import T1.S0;
import U1.C2201a;
import V1.C2206b;
import W1.C2209b;
import W1.C2211d;
import W2.u;
import X1.C2226c;
import X1.C2227d;
import X1.C2228e;
import X1.C2229f;
import X1.C2230g;
import X1.C2232i;
import X2.C2250q;
import Z1.h;
import a3.C2265a;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import androidx.documentfile.provider.DocumentFile;
import androidx.recyclerview.widget.RecyclerView;
import b2.C2290j;
import b2.C2291k;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.google.android.material.tabs.TabLayout;
import com.mbridge.msdk.MBridgeConstans;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import k3.p;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import t3.s;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;

public final class FileExplorerActivity extends S0 {

    /* renamed from: z0  reason: collision with root package name */
    public static final C2317a f20847z0 = new C2317a((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: A  reason: collision with root package name */
    public RelativeLayout f20848A;
    /* access modifiers changed from: private */

    /* renamed from: B  reason: collision with root package name */
    public LinearLayout f20849B;

    /* renamed from: C  reason: collision with root package name */
    private LinearLayout f20850C;

    /* renamed from: D  reason: collision with root package name */
    private HorizontalScrollView f20851D;

    /* renamed from: E  reason: collision with root package name */
    private TextView f20852E;
    /* access modifiers changed from: private */

    /* renamed from: F  reason: collision with root package name */
    public TextView f20853F;

    /* renamed from: G  reason: collision with root package name */
    private TextView f20854G;
    /* access modifiers changed from: private */

    /* renamed from: H  reason: collision with root package name */
    public SearchView f20855H;

    /* renamed from: I  reason: collision with root package name */
    private ImageView f20856I;

    /* renamed from: J  reason: collision with root package name */
    private RelativeLayout f20857J;
    /* access modifiers changed from: private */

    /* renamed from: K  reason: collision with root package name */
    public RadioButton f20858K;
    /* access modifiers changed from: private */

    /* renamed from: L  reason: collision with root package name */
    public RadioButton f20859L;
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public RadioButton f20860M;
    /* access modifiers changed from: private */

    /* renamed from: N  reason: collision with root package name */
    public AlertDialog f20861N;
    /* access modifiers changed from: private */

    /* renamed from: O  reason: collision with root package name */
    public Toolbar f20862O;

    /* renamed from: P  reason: collision with root package name */
    private TextView f20863P;
    /* access modifiers changed from: private */

    /* renamed from: Q  reason: collision with root package name */
    public C2206b f20864Q;
    /* access modifiers changed from: private */

    /* renamed from: R  reason: collision with root package name */
    public ArrayList f20865R;
    /* access modifiers changed from: private */

    /* renamed from: S  reason: collision with root package name */
    public ArrayList f20866S;
    /* access modifiers changed from: private */

    /* renamed from: T  reason: collision with root package name */
    public DocumentFile f20867T;
    /* access modifiers changed from: private */

    /* renamed from: U  reason: collision with root package name */
    public ArrayList f20868U;
    /* access modifiers changed from: private */

    /* renamed from: V  reason: collision with root package name */
    public ArrayList f20869V;
    /* access modifiers changed from: private */

    /* renamed from: W  reason: collision with root package name */
    public ArrayList f20870W;
    /* access modifiers changed from: private */

    /* renamed from: X  reason: collision with root package name */
    public File f20871X;

    /* renamed from: Y  reason: collision with root package name */
    private boolean f20872Y;
    /* access modifiers changed from: private */

    /* renamed from: Z  reason: collision with root package name */
    public boolean f20873Z;

    /* renamed from: m0  reason: collision with root package name */
    private Object f20874m0;
    /* access modifiers changed from: private */

    /* renamed from: n0  reason: collision with root package name */
    public ArrayList f20875n0;

    /* renamed from: o0  reason: collision with root package name */
    private boolean f20876o0;

    /* renamed from: p0  reason: collision with root package name */
    private boolean f20877p0;

    /* renamed from: q0  reason: collision with root package name */
    private TabLayout f20878q0;

    /* renamed from: r0  reason: collision with root package name */
    private TextView f20879r0;

    /* renamed from: s0  reason: collision with root package name */
    private Uri f20880s0;

    /* renamed from: t0  reason: collision with root package name */
    private String f20881t0;

    /* renamed from: u0  reason: collision with root package name */
    private C f20882u0 = new C(this);

    /* renamed from: v0  reason: collision with root package name */
    private final C2322f f20883v0 = new C2322f(this);

    /* renamed from: w0  reason: collision with root package name */
    private final G f20884w0 = new G(this);

    /* renamed from: x  reason: collision with root package name */
    private TextView f20885x;

    /* renamed from: x0  reason: collision with root package name */
    private final E f20886x0 = new E(this);

    /* renamed from: y  reason: collision with root package name */
    private ImageView f20887y;

    /* renamed from: y0  reason: collision with root package name */
    private ActivityResultLauncher f20888y0;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public RecyclerView f20889z;

    public static final class A implements C2229f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f20890a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ File f20891b;

        A(FileExplorerActivity fileExplorerActivity, File file) {
            this.f20890a = fileExplorerActivity;
            this.f20891b = file;
        }

        public void a() {
            j.f(new j(this.f20890a), this.f20891b, (String) null, false, 6, (Object) null);
        }
    }

    public static final class B implements C2229f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f20892a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ DocumentFile f20893b;

        B(FileExplorerActivity fileExplorerActivity, DocumentFile documentFile) {
            this.f20892a = fileExplorerActivity;
            this.f20893b = documentFile;
        }

        public void a() {
            j jVar = new j(this.f20892a);
            Uri uri = this.f20893b.getUri();
            t.d(uri, "getUri(...)");
            j.e(jVar, uri, (String) null, false, false, 14, (Object) null);
        }
    }

    public static final class C implements C2230g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f20894a;

        C(FileExplorerActivity fileExplorerActivity) {
            this.f20894a = fileExplorerActivity;
        }

        public void a(Object obj, int i5) {
            t.e(obj, "item");
            C2206b y22 = this.f20894a.f20864Q;
            if (y22 != null && y22.c()) {
                C2206b y23 = this.f20894a.f20864Q;
                t.b(y23);
                y23.g(i5);
                C2206b y24 = this.f20894a.f20864Q;
                t.b(y24);
                if (!y24.b().isEmpty()) {
                    this.f20894a.a5();
                    return;
                }
                C2206b y25 = this.f20894a.f20864Q;
                t.b(y25);
                y25.h(false);
                this.f20894a.d4();
            } else if (obj instanceof File) {
                File file = (File) obj;
                if (file.isDirectory()) {
                    this.f20894a.f20871X = file;
                    this.f20894a.f20867T = null;
                    FileExplorerActivity.i4(this.f20894a, false, 1, (Object) null);
                    return;
                }
                if (this.f20894a.getIntent().getExtras() != null) {
                    Bundle extras = this.f20894a.getIntent().getExtras();
                    t.b(extras);
                    if (extras.containsKey("select_file")) {
                        Bundle extras2 = this.f20894a.getIntent().getExtras();
                        t.b(extras2);
                        if (extras2.getInt("select_file") == 1) {
                            Intent intent = new Intent();
                            if (file.isFile()) {
                                intent.putExtra("path_selected", file.getAbsolutePath());
                                intent.putExtra("sdcard_selected", this.f20894a.f20873Z);
                                this.f20894a.setResult(145, intent);
                                this.f20894a.finish();
                                return;
                            }
                            return;
                        }
                    }
                }
                C2290j jVar = new C2290j();
                String name = file.getName();
                t.d(name, "getName(...)");
                if (jVar.o(name)) {
                    this.f20894a.f4(file);
                    return;
                }
                String name2 = file.getName();
                t.d(name2, "getName(...)");
                if (s.D(name2, ".zip", false, 2, (Object) null)) {
                    this.f20894a.X3(obj);
                } else {
                    this.f20894a.H4(file);
                }
            } else if (obj instanceof DocumentFile) {
                DocumentFile documentFile = (DocumentFile) obj;
                if (documentFile.isDirectory()) {
                    this.f20894a.f20867T = documentFile;
                    this.f20894a.f20871X = null;
                    FileExplorerActivity.i4(this.f20894a, false, 1, (Object) null);
                    return;
                }
                if (this.f20894a.getIntent().getExtras() != null) {
                    Bundle extras3 = this.f20894a.getIntent().getExtras();
                    t.b(extras3);
                    if (extras3.containsKey("select_file")) {
                        Bundle extras4 = this.f20894a.getIntent().getExtras();
                        t.b(extras4);
                        if (extras4.getInt("select_file") == 1) {
                            Intent intent2 = new Intent();
                            if (documentFile.isFile()) {
                                intent2.setData(documentFile.getUri());
                                intent2.putExtra("sdcard_selected", this.f20894a.f20873Z);
                                this.f20894a.setResult(145, intent2);
                                this.f20894a.finish();
                                return;
                            }
                            return;
                        }
                    }
                }
                if (documentFile.getName() != null) {
                    C2290j jVar2 = new C2290j();
                    String name3 = documentFile.getName();
                    t.b(name3);
                    if (jVar2.o(name3)) {
                        this.f20894a.e4(documentFile);
                        return;
                    }
                }
                if (documentFile.getName() != null) {
                    String name4 = documentFile.getName();
                    t.b(name4);
                    if (s.D(name4, ".zip", false, 2, (Object) null)) {
                        this.f20894a.X3(obj);
                        return;
                    }
                }
                this.f20894a.G4(documentFile);
            }
        }

        public void b(Object obj, int i5) {
            t.e(obj, "item");
            if (this.f20894a.f20864Q != null) {
                C2206b y22 = this.f20894a.f20864Q;
                t.b(y22);
                if (y22.c()) {
                    C2206b y23 = this.f20894a.f20864Q;
                    t.b(y23);
                    y23.g(i5);
                    C2206b y24 = this.f20894a.f20864Q;
                    t.b(y24);
                    if (y24.b().contains(obj)) {
                        this.f20894a.a5();
                        return;
                    }
                    this.f20894a.d4();
                    C2206b y25 = this.f20894a.f20864Q;
                    t.b(y25);
                    y25.h(false);
                    return;
                }
                C2206b y26 = this.f20894a.f20864Q;
                t.b(y26);
                y26.h(true);
                C2206b y27 = this.f20894a.f20864Q;
                t.b(y27);
                y27.g(i5);
                this.f20894a.a5();
            }
        }
    }

    public static final class D implements C2232i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f20895a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f20896b;

        D(FileExplorerActivity fileExplorerActivity, String str) {
            this.f20895a = fileExplorerActivity;
            this.f20896b = str;
        }

        public void a(ArrayList arrayList) {
            t.e(arrayList, "items");
            this.f20895a.f20866S = arrayList;
            this.f20895a.f20865R = arrayList;
            this.f20895a.f20870W = null;
            this.f20895a.f20869V = null;
            FileExplorerActivity fileExplorerActivity = this.f20895a;
            SearchView K22 = fileExplorerActivity.f20855H;
            t.b(K22);
            fileExplorerActivity.s3(K22.getQuery().toString(), this.f20896b);
        }

        public void b(ArrayList arrayList) {
            t.e(arrayList, "items");
            this.f20895a.f20870W = arrayList;
            this.f20895a.f20869V = arrayList;
            this.f20895a.f20866S = null;
            this.f20895a.f20865R = null;
            if (this.f20895a.f20871X != null) {
                File A22 = this.f20895a.f20871X;
                t.b(A22);
                if (!A22.canRead()) {
                    ArrayList C22 = this.f20895a.f20870W;
                    t.b(C22);
                    if (C22.isEmpty()) {
                        File externalStorageDirectory = Environment.getExternalStorageDirectory();
                        File A23 = this.f20895a.f20871X;
                        t.b(A23);
                        String absolutePath = A23.getAbsolutePath();
                        if (absolutePath.equals(externalStorageDirectory.getAbsolutePath() + "/Android/data")) {
                            File file = new File(this.f20895a.f20871X, this.f20895a.getPackageName());
                            if (file.exists() && file.canRead()) {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(new File(this.f20895a.f20871X, this.f20895a.getPackageName()));
                                this.f20895a.f20870W = arrayList2;
                                this.f20895a.f20869V = arrayList2;
                            }
                        }
                    }
                }
            }
            FileExplorerActivity fileExplorerActivity = this.f20895a;
            SearchView K22 = fileExplorerActivity.f20855H;
            t.b(K22);
            fileExplorerActivity.s3(K22.getQuery().toString(), this.f20896b);
        }
    }

    public static final class E extends OnBackPressedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f20897a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        E(FileExplorerActivity fileExplorerActivity) {
            super(true);
            this.f20897a = fileExplorerActivity;
        }

        public void handleOnBackPressed() {
            C2206b y22 = this.f20897a.f20864Q;
            if (y22 != null && y22.c()) {
                C2206b y23 = this.f20897a.f20864Q;
                t.b(y23);
                y23.h(false);
                this.f20897a.d4();
            } else if (this.f20897a.f20867T != null) {
                DocumentFile B22 = this.f20897a.f20867T;
                t.b(B22);
                String name = B22.getName();
                DocumentFile B23 = this.f20897a.f20867T;
                t.b(B23);
                DocumentFile parentFile = B23.getParentFile();
                if (parentFile != null) {
                    this.f20897a.f20867T = parentFile;
                    this.f20897a.f20871X = null;
                    this.f20897a.M4();
                    this.f20897a.g4(name);
                    SearchView K22 = this.f20897a.f20855H;
                    if (K22 != null) {
                        this.f20897a.w3(K22);
                        return;
                    }
                    return;
                }
                this.f20897a.x3();
            } else if (this.f20897a.f20871X == null || t.a(this.f20897a.f20871X, Environment.getExternalStorageDirectory())) {
                this.f20897a.x3();
            } else {
                File A22 = this.f20897a.f20871X;
                t.b(A22);
                String name2 = A22.getName();
                File A23 = this.f20897a.f20871X;
                t.b(A23);
                File parentFile2 = A23.getParentFile();
                if (parentFile2 != null) {
                    this.f20897a.f20871X = parentFile2;
                    this.f20897a.f20867T = null;
                    this.f20897a.M4();
                    this.f20897a.g4(name2);
                    SearchView K23 = this.f20897a.f20855H;
                    if (K23 != null) {
                        this.f20897a.w3(K23);
                        return;
                    }
                    return;
                }
                this.f20897a.x3();
            }
        }
    }

    public static final class F implements TabLayout.OnTabSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f20898a;

        F(FileExplorerActivity fileExplorerActivity) {
            this.f20898a = fileExplorerActivity;
        }

        public void onTabReselected(TabLayout.Tab tab) {
        }

        public void onTabSelected(TabLayout.Tab tab) {
            if (tab == null || tab.getId() != 0) {
                this.f20898a.f20873Z = true;
                ArrayList L22 = this.f20898a.f20868U;
                t.b(L22);
                if (L22.size() > 0) {
                    this.f20898a.N4();
                    this.f20898a.u3();
                    return;
                }
                return;
            }
            this.f20898a.f20873Z = false;
            RecyclerView J22 = this.f20898a.f20889z;
            if (J22 == null) {
                t.w("rvFiles");
                J22 = null;
            }
            J22.setVisibility(0);
            LinearLayout E22 = this.f20898a.f20849B;
            if (E22 == null) {
                t.w("llPermissionExplanation");
                E22 = null;
            }
            E22.setVisibility(8);
            RecyclerView J23 = this.f20898a.f20889z;
            if (J23 == null) {
                t.w("rvFiles");
                J23 = null;
            }
            J23.setVisibility(0);
            this.f20898a.N4();
            this.f20898a.T4();
            FileExplorerActivity.i4(this.f20898a, false, 1, (Object) null);
        }

        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    public static final class G implements SearchView.OnQueryTextListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f20899a;

        G(FileExplorerActivity fileExplorerActivity) {
            this.f20899a = fileExplorerActivity;
        }

        public boolean onQueryTextChange(String str) {
            t.e(str, "newText");
            this.f20899a.s3(str, (String) null);
            return false;
        }

        public boolean onQueryTextSubmit(String str) {
            t.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
            this.f20899a.s3(str, (String) null);
            return true;
        }
    }

    static final class H extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20900a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f20901b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        H(FileExplorerActivity fileExplorerActivity, C2308e eVar) {
            super(2, eVar);
            this.f20901b = fileExplorerActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new H(this.f20901b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f20900a;
            if (i5 == 0) {
                u.b(obj);
                FileExplorerActivity fileExplorerActivity = this.f20901b;
                this.f20900a = 1;
                if (fileExplorerActivity.J4(this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return W2.J.f19942a;
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((H) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    static final class I extends d {

        /* renamed from: a  reason: collision with root package name */
        Object f20902a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f20903b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f20904c;

        /* renamed from: d  reason: collision with root package name */
        int f20905d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        I(FileExplorerActivity fileExplorerActivity, C2308e eVar) {
            super(eVar);
            this.f20904c = fileExplorerActivity;
        }

        public final Object invokeSuspend(Object obj) {
            this.f20903b = obj;
            this.f20905d |= Integer.MIN_VALUE;
            return this.f20904c.J4(this);
        }
    }

    static final class J extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20906a;

        /* renamed from: b  reason: collision with root package name */
        private /* synthetic */ Object f20907b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f20908c;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20909a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ FileExplorerActivity f20910b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(FileExplorerActivity fileExplorerActivity, C2308e eVar) {
                super(2, eVar);
                this.f20910b = fileExplorerActivity;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f20910b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20909a == 0) {
                    u.b(obj);
                    this.f20910b.d5();
                    return W2.J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(w3.M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
            }
        }

        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20911a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ FileExplorerActivity f20912b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(FileExplorerActivity fileExplorerActivity, C2308e eVar) {
                super(2, eVar);
                this.f20912b = fileExplorerActivity;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new b(this.f20912b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20911a == 0) {
                    u.b(obj);
                    this.f20912b.b5();
                    return W2.J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(w3.M m5, C2308e eVar) {
                return ((b) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
            }
        }

        static final class c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20913a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ FileExplorerActivity f20914b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(FileExplorerActivity fileExplorerActivity, C2308e eVar) {
                super(2, eVar);
                this.f20914b = fileExplorerActivity;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new c(this.f20914b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20913a == 0) {
                    u.b(obj);
                    this.f20914b.c5();
                    return W2.J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(w3.M m5, C2308e eVar) {
                return ((c) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        J(FileExplorerActivity fileExplorerActivity, C2308e eVar) {
            super(2, eVar);
            this.f20908c = fileExplorerActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            J j5 = new J(this.f20908c, eVar);
            j5.f20907b = obj;
            return j5;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x004c, code lost:
            if (r12.A(r11) == r0) goto L_0x009c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0073, code lost:
            if (r12.A(r11) == r0) goto L_0x009c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x009a, code lost:
            if (r12.A(r11) == r0) goto L_0x009c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r11.f20906a
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x001f
                if (r1 == r4) goto L_0x001a
                if (r1 == r3) goto L_0x001a
                if (r1 != r2) goto L_0x0012
                goto L_0x001a
            L_0x0012:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L_0x001a:
                W2.u.b(r12)
                goto L_0x009d
            L_0x001f:
                W2.u.b(r12)
                java.lang.Object r12 = r11.f20907b
                r5 = r12
                w3.M r5 = (w3.M) r5
                com.uptodown.core.activities.FileExplorerActivity r12 = r11.f20908c
                android.widget.RadioButton r12 = r12.f20858K
                kotlin.jvm.internal.t.b(r12)
                boolean r12 = r12.isChecked()
                r1 = 0
                if (r12 == 0) goto L_0x004f
                com.uptodown.core.activities.FileExplorerActivity$J$c r8 = new com.uptodown.core.activities.FileExplorerActivity$J$c
                com.uptodown.core.activities.FileExplorerActivity r12 = r11.f20908c
                r8.<init>(r12, r1)
                r9 = 3
                r10 = 0
                r6 = 0
                r7 = 0
                w3.U r12 = w3.C2876i.b(r5, r6, r7, r8, r9, r10)
                r11.f20906a = r4
                java.lang.Object r12 = r12.A(r11)
                if (r12 != r0) goto L_0x009d
                goto L_0x009c
            L_0x004f:
                com.uptodown.core.activities.FileExplorerActivity r12 = r11.f20908c
                android.widget.RadioButton r12 = r12.f20859L
                kotlin.jvm.internal.t.b(r12)
                boolean r12 = r12.isChecked()
                if (r12 == 0) goto L_0x0076
                com.uptodown.core.activities.FileExplorerActivity$J$a r8 = new com.uptodown.core.activities.FileExplorerActivity$J$a
                com.uptodown.core.activities.FileExplorerActivity r12 = r11.f20908c
                r8.<init>(r12, r1)
                r9 = 3
                r10 = 0
                r6 = 0
                r7 = 0
                w3.U r12 = w3.C2876i.b(r5, r6, r7, r8, r9, r10)
                r11.f20906a = r3
                java.lang.Object r12 = r12.A(r11)
                if (r12 != r0) goto L_0x009d
                goto L_0x009c
            L_0x0076:
                com.uptodown.core.activities.FileExplorerActivity r12 = r11.f20908c
                android.widget.RadioButton r12 = r12.f20860M
                kotlin.jvm.internal.t.b(r12)
                boolean r12 = r12.isChecked()
                if (r12 == 0) goto L_0x009d
                com.uptodown.core.activities.FileExplorerActivity$J$b r8 = new com.uptodown.core.activities.FileExplorerActivity$J$b
                com.uptodown.core.activities.FileExplorerActivity r12 = r11.f20908c
                r8.<init>(r12, r1)
                r9 = 3
                r10 = 0
                r6 = 0
                r7 = 0
                w3.U r12 = w3.C2876i.b(r5, r6, r7, r8, r9, r10)
                r11.f20906a = r2
                java.lang.Object r12 = r12.A(r11)
                if (r12 != r0) goto L_0x009d
            L_0x009c:
                return r0
            L_0x009d:
                W2.J r12 = W2.J.f19942a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.J.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((J) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    static final class K extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20915a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f20916b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        K(FileExplorerActivity fileExplorerActivity, C2308e eVar) {
            super(2, eVar);
            this.f20916b = fileExplorerActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new K(this.f20916b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f20915a == 0) {
                u.b(obj);
                this.f20916b.S4();
                RelativeLayout I22 = this.f20916b.f20848A;
                if (I22 == null) {
                    t.w("rlLoading");
                    I22 = null;
                }
                I22.setVisibility(8);
                return W2.J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((K) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    public static final class L implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return C2265a.a(Long.valueOf(((DocumentFile) obj).lastModified()), Long.valueOf(((DocumentFile) obj2).lastModified()));
        }
    }

    public static final class M implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return C2265a.a(Boolean.valueOf(((DocumentFile) obj).isFile()), Boolean.valueOf(((DocumentFile) obj2).isFile()));
        }
    }

    public static final class N implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return C2265a.a(Long.valueOf(((File) obj).lastModified()), Long.valueOf(((File) obj2).lastModified()));
        }
    }

    public static final class O implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return C2265a.a(Boolean.valueOf(((File) obj).isFile()), Boolean.valueOf(((File) obj2).isFile()));
        }
    }

    public static final class P implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return C2265a.a(Long.valueOf(((DocumentFile) obj2).lastModified()), Long.valueOf(((DocumentFile) obj).lastModified()));
        }
    }

    public static final class Q implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return C2265a.a(Boolean.valueOf(((DocumentFile) obj2).isDirectory()), Boolean.valueOf(((DocumentFile) obj).isDirectory()));
        }
    }

    public static final class R implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return C2265a.a(Long.valueOf(((File) obj2).lastModified()), Long.valueOf(((File) obj).lastModified()));
        }
    }

    public static final class S implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return C2265a.a(Boolean.valueOf(((File) obj2).isDirectory()), Boolean.valueOf(((File) obj).isDirectory()));
        }
    }

    public static final class T implements Comparator {
        public final int compare(Object obj, Object obj2) {
            String str;
            String name = ((DocumentFile) obj).getName();
            String str2 = null;
            if (name != null) {
                str = name.toUpperCase(Locale.ROOT);
                t.d(str, "toUpperCase(...)");
            } else {
                str = null;
            }
            String name2 = ((DocumentFile) obj2).getName();
            if (name2 != null) {
                str2 = name2.toUpperCase(Locale.ROOT);
                t.d(str2, "toUpperCase(...)");
            }
            return C2265a.a(str, str2);
        }
    }

    public static final class U implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return C2265a.a(Boolean.valueOf(((DocumentFile) obj).isFile()), Boolean.valueOf(((DocumentFile) obj2).isFile()));
        }
    }

    public static final class V implements Comparator {
        public final int compare(Object obj, Object obj2) {
            String name = ((File) obj).getName();
            t.d(name, "getName(...)");
            Locale locale = Locale.ROOT;
            String upperCase = name.toUpperCase(locale);
            t.d(upperCase, "toUpperCase(...)");
            String name2 = ((File) obj2).getName();
            t.d(name2, "getName(...)");
            String upperCase2 = name2.toUpperCase(locale);
            t.d(upperCase2, "toUpperCase(...)");
            return C2265a.a(upperCase, upperCase2);
        }
    }

    public static final class W implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return C2265a.a(Boolean.valueOf(((File) obj).isFile()), Boolean.valueOf(((File) obj2).isFile()));
        }
    }

    public static final class X implements Comparator {
        public final int compare(Object obj, Object obj2) {
            String str;
            String name = ((DocumentFile) obj2).getName();
            String str2 = null;
            if (name != null) {
                str = name.toUpperCase(Locale.ROOT);
                t.d(str, "toUpperCase(...)");
            } else {
                str = null;
            }
            String name2 = ((DocumentFile) obj).getName();
            if (name2 != null) {
                str2 = name2.toUpperCase(Locale.ROOT);
                t.d(str2, "toUpperCase(...)");
            }
            return C2265a.a(str, str2);
        }
    }

    public static final class Y implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return C2265a.a(Boolean.valueOf(((DocumentFile) obj2).isDirectory()), Boolean.valueOf(((DocumentFile) obj).isDirectory()));
        }
    }

    public static final class Z implements Comparator {
        public final int compare(Object obj, Object obj2) {
            String name = ((File) obj2).getName();
            t.d(name, "getName(...)");
            Locale locale = Locale.ROOT;
            String upperCase = name.toUpperCase(locale);
            t.d(upperCase, "toUpperCase(...)");
            String name2 = ((File) obj).getName();
            t.d(name2, "getName(...)");
            String upperCase2 = name2.toUpperCase(locale);
            t.d(upperCase2, "toUpperCase(...)");
            return C2265a.a(upperCase, upperCase2);
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$a  reason: case insensitive filesystem */
    public static final class C2317a {
        public /* synthetic */ C2317a(C2633k kVar) {
            this();
        }

        private C2317a() {
        }
    }

    public static final class a0 implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return C2265a.a(Boolean.valueOf(((File) obj2).isDirectory()), Boolean.valueOf(((File) obj).isDirectory()));
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$b  reason: case insensitive filesystem */
    static final class C2318b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20917a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f20918b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f20919c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f20920d;

        /* renamed from: com.uptodown.core.activities.FileExplorerActivity$b$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20921a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ FileExplorerActivity f20922b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f20923c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ String f20924d;

            /* renamed from: com.uptodown.core.activities.FileExplorerActivity$b$a$a  reason: collision with other inner class name */
            static final class C0214a extends l implements p {

                /* renamed from: a  reason: collision with root package name */
                int f20925a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ FileExplorerActivity f20926b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ String f20927c;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C0214a(FileExplorerActivity fileExplorerActivity, String str, C2308e eVar) {
                    super(2, eVar);
                    this.f20926b = fileExplorerActivity;
                    this.f20927c = str;
                }

                public final C2308e create(Object obj, C2308e eVar) {
                    return new C0214a(this.f20926b, this.f20927c, eVar);
                }

                public final Object invokeSuspend(Object obj) {
                    C2316b.f();
                    if (this.f20925a == 0) {
                        u.b(obj);
                        RelativeLayout I22 = this.f20926b.f20848A;
                        if (I22 == null) {
                            t.w("rlLoading");
                            I22 = null;
                        }
                        I22.setVisibility(8);
                        this.f20926b.Z4(this.f20927c);
                        this.f20926b.t3();
                        return W2.J.f19942a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Object invoke(w3.M m5, C2308e eVar) {
                    return ((C0214a) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(FileExplorerActivity fileExplorerActivity, String str, String str2, C2308e eVar) {
                super(2, eVar);
                this.f20922b = fileExplorerActivity;
                this.f20923c = str;
                this.f20924d = str2;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f20922b, this.f20923c, this.f20924d, eVar);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:11:0x0047, code lost:
                if (w3.C2872g.g(r7, r1, r6) == r0) goto L_0x0049;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:12:0x0049, code lost:
                return r0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:9:0x0030, code lost:
                if (com.uptodown.core.activities.FileExplorerActivity.W2(r7, r6) == r0) goto L_0x0049;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                /*
                    r6 = this;
                    java.lang.Object r0 = c3.C2316b.f()
                    int r1 = r6.f20921a
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L_0x001e
                    if (r1 == r3) goto L_0x001a
                    if (r1 != r2) goto L_0x0012
                    W2.u.b(r7)
                    goto L_0x004a
                L_0x0012:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r0)
                    throw r7
                L_0x001a:
                    W2.u.b(r7)
                    goto L_0x0033
                L_0x001e:
                    W2.u.b(r7)
                    com.uptodown.core.activities.FileExplorerActivity r7 = r6.f20922b
                    java.lang.String r1 = r6.f20923c
                    r7.R4(r1)
                    com.uptodown.core.activities.FileExplorerActivity r7 = r6.f20922b
                    r6.f20921a = r3
                    java.lang.Object r7 = r7.J4(r6)
                    if (r7 != r0) goto L_0x0033
                    goto L_0x0049
                L_0x0033:
                    w3.I0 r7 = w3.C2865c0.c()
                    com.uptodown.core.activities.FileExplorerActivity$b$a$a r1 = new com.uptodown.core.activities.FileExplorerActivity$b$a$a
                    com.uptodown.core.activities.FileExplorerActivity r3 = r6.f20922b
                    java.lang.String r4 = r6.f20924d
                    r5 = 0
                    r1.<init>(r3, r4, r5)
                    r6.f20921a = r2
                    java.lang.Object r7 = w3.C2872g.g(r7, r1, r6)
                    if (r7 != r0) goto L_0x004a
                L_0x0049:
                    return r0
                L_0x004a:
                    W2.J r7 = W2.J.f19942a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.C2318b.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            public final Object invoke(w3.M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2318b(FileExplorerActivity fileExplorerActivity, String str, String str2, C2308e eVar) {
            super(2, eVar);
            this.f20918b = fileExplorerActivity;
            this.f20919c = str;
            this.f20920d = str2;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C2318b(this.f20918b, this.f20919c, this.f20920d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f20917a;
            if (i5 == 0) {
                u.b(obj);
                w3.I b5 = C2865c0.b();
                a aVar = new a(this.f20918b, this.f20919c, this.f20920d, (C2308e) null);
                this.f20917a = 1;
                if (C2872g.g(b5, aVar, this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return W2.J.f19942a;
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((C2318b) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    public static final class b0 implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return C2265a.a(Long.valueOf(((DocumentFile) obj).length()), Long.valueOf(((DocumentFile) obj2).length()));
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$c  reason: case insensitive filesystem */
    static final class C2319c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20928a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f20929b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ DocumentFile f20930c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2226c f20931d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f20932e;

        /* renamed from: com.uptodown.core.activities.FileExplorerActivity$c$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20933a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ FileExplorerActivity f20934b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(FileExplorerActivity fileExplorerActivity, C2308e eVar) {
                super(2, eVar);
                this.f20934b = fileExplorerActivity;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f20934b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20933a == 0) {
                    u.b(obj);
                    this.f20934b.f5();
                    return W2.J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(w3.M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2319c(ArrayList arrayList, DocumentFile documentFile, C2226c cVar, FileExplorerActivity fileExplorerActivity, C2308e eVar) {
            super(2, eVar);
            this.f20929b = arrayList;
            this.f20930c = documentFile;
            this.f20931d = cVar;
            this.f20932e = fileExplorerActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C2319c(this.f20929b, this.f20930c, this.f20931d, this.f20932e, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0056, code lost:
            if (w3.C2872g.g(r10, r1, r9) == r0) goto L_0x0058;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0058, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0041, code lost:
            if (r3.h(r4, r5, r6, r7, r8) == r0) goto L_0x0058;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r9.f20928a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x0020
                if (r1 == r3) goto L_0x001b
                if (r1 != r2) goto L_0x0013
                W2.u.b(r10)
                r8 = r9
                goto L_0x0059
            L_0x0013:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L_0x001b:
                W2.u.b(r10)
                r8 = r9
                goto L_0x0044
            L_0x0020:
                W2.u.b(r10)
                r10 = r3
                b2.L r3 = new b2.L
                r3.<init>()
                java.util.ArrayList r4 = r9.f20929b
                androidx.documentfile.provider.DocumentFile r5 = r9.f20930c
                X1.c r6 = r9.f20931d
                com.uptodown.core.activities.FileExplorerActivity r1 = r9.f20932e
                android.content.Context r7 = r1.getApplicationContext()
                java.lang.String r1 = "getApplicationContext(...)"
                kotlin.jvm.internal.t.d(r7, r1)
                r9.f20928a = r10
                r8 = r9
                java.lang.Object r10 = r3.h(r4, r5, r6, r7, r8)
                if (r10 != r0) goto L_0x0044
                goto L_0x0058
            L_0x0044:
                w3.I0 r10 = w3.C2865c0.c()
                com.uptodown.core.activities.FileExplorerActivity$c$a r1 = new com.uptodown.core.activities.FileExplorerActivity$c$a
                com.uptodown.core.activities.FileExplorerActivity r3 = r8.f20932e
                r4 = 0
                r1.<init>(r3, r4)
                r8.f20928a = r2
                java.lang.Object r10 = w3.C2872g.g(r10, r1, r9)
                if (r10 != r0) goto L_0x0059
            L_0x0058:
                return r0
            L_0x0059:
                W2.J r10 = W2.J.f19942a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.C2319c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((C2319c) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    public static final class c0 implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return C2265a.a(Boolean.valueOf(((DocumentFile) obj).isFile()), Boolean.valueOf(((DocumentFile) obj2).isFile()));
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$d  reason: case insensitive filesystem */
    static final class C2320d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20935a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f20936b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ File f20937c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2226c f20938d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f20939e;

        /* renamed from: com.uptodown.core.activities.FileExplorerActivity$d$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20940a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ FileExplorerActivity f20941b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(FileExplorerActivity fileExplorerActivity, C2308e eVar) {
                super(2, eVar);
                this.f20941b = fileExplorerActivity;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f20941b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20940a == 0) {
                    u.b(obj);
                    this.f20941b.f5();
                    return W2.J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(w3.M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2320d(ArrayList arrayList, File file, C2226c cVar, FileExplorerActivity fileExplorerActivity, C2308e eVar) {
            super(2, eVar);
            this.f20936b = arrayList;
            this.f20937c = file;
            this.f20938d = cVar;
            this.f20939e = fileExplorerActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C2320d(this.f20936b, this.f20937c, this.f20938d, this.f20939e, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0047, code lost:
            if (w3.C2872g.g(r7, r1, r6) == r0) goto L_0x0049;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0049, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0032, code lost:
            if (r7.i(r1, r4, r5, r6) == r0) goto L_0x0049;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r6.f20935a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x001e
                if (r1 == r3) goto L_0x001a
                if (r1 != r2) goto L_0x0012
                W2.u.b(r7)
                goto L_0x004a
            L_0x0012:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L_0x001a:
                W2.u.b(r7)
                goto L_0x0035
            L_0x001e:
                W2.u.b(r7)
                b2.L r7 = new b2.L
                r7.<init>()
                java.util.ArrayList r1 = r6.f20936b
                java.io.File r4 = r6.f20937c
                X1.c r5 = r6.f20938d
                r6.f20935a = r3
                java.lang.Object r7 = r7.i(r1, r4, r5, r6)
                if (r7 != r0) goto L_0x0035
                goto L_0x0049
            L_0x0035:
                w3.I0 r7 = w3.C2865c0.c()
                com.uptodown.core.activities.FileExplorerActivity$d$a r1 = new com.uptodown.core.activities.FileExplorerActivity$d$a
                com.uptodown.core.activities.FileExplorerActivity r3 = r6.f20939e
                r4 = 0
                r1.<init>(r3, r4)
                r6.f20935a = r2
                java.lang.Object r7 = w3.C2872g.g(r7, r1, r6)
                if (r7 != r0) goto L_0x004a
            L_0x0049:
                return r0
            L_0x004a:
                W2.J r7 = W2.J.f19942a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.C2320d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((C2320d) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    public static final class d0 implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return C2265a.a(Long.valueOf(((File) obj).length()), Long.valueOf(((File) obj2).length()));
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$e  reason: case insensitive filesystem */
    static final class C2321e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20942a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f20943b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2321e(FileExplorerActivity fileExplorerActivity, C2308e eVar) {
            super(2, eVar);
            this.f20943b = fileExplorerActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C2321e(this.f20943b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f20942a;
            if (i5 == 0) {
                u.b(obj);
                FileExplorerActivity fileExplorerActivity = this.f20943b;
                this.f20942a = 1;
                if (fileExplorerActivity.D3(this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return W2.J.f19942a;
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((C2321e) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    public static final class e0 implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return C2265a.a(Boolean.valueOf(((File) obj).isFile()), Boolean.valueOf(((File) obj2).isFile()));
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$f  reason: case insensitive filesystem */
    public static final class C2322f implements C2227d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f20944a;

        C2322f(FileExplorerActivity fileExplorerActivity) {
            this.f20944a = fileExplorerActivity;
        }

        public void a(DocumentFile documentFile) {
            t.e(documentFile, "docFile");
        }

        public void b(Object obj, int i5, int i6, long j5) {
            t.e(obj, "file");
            if (obj instanceof File) {
                this.f20944a.H3(((File) obj).getName(), i5, i6, j5);
                return;
            }
            int i7 = i5;
            int i8 = i6;
            long j6 = j5;
            if (obj instanceof DocumentFile) {
                this.f20944a.H3(((DocumentFile) obj).getName(), i7, i8, j6);
                return;
            }
            FileExplorerActivity fileExplorerActivity = this.f20944a;
            fileExplorerActivity.H3(fileExplorerActivity.getString(i.copying), i7, i8, j6);
        }

        public void c(File file) {
            t.e(file, "file");
        }

        public void d(DocumentFile documentFile) {
            t.e(documentFile, "docFile");
        }

        public void e(int i5, String str, long j5, long j6) {
            t.e(str, "currentFilename");
            if (this.f20944a.R() != null) {
                AlertDialog R4 = this.f20944a.R();
                t.b(R4);
                int i6 = f.pb_dialog_copying;
                if (R4.findViewById(i6) != null) {
                    AlertDialog R5 = this.f20944a.R();
                    t.b(R5);
                    ((ProgressBar) R5.findViewById(i6)).setProgress(i5);
                    AlertDialog R6 = this.f20944a.R();
                    t.b(R6);
                    ((TextView) R6.findViewById(f.tv_size_dialog_copying)).setText(this.f20944a.getString(i.size_of_total_size, new Object[]{new C2291k().c(j5), new C2291k().c(j6)}));
                    AlertDialog R7 = this.f20944a.R();
                    t.b(R7);
                    ((TextView) R7.findViewById(f.tv_percentage_dialog_copying)).setText(i5 + this.f20944a.getString(i.percentage));
                    AlertDialog R8 = this.f20944a.R();
                    t.b(R8);
                    ((TextView) R8.findViewById(f.tv_files_dialog_copying)).setText(str);
                }
            }
        }

        public void f(File file) {
            t.e(file, "file");
        }

        public void g() {
        }

        public void h(Object obj) {
            t.e(obj, "file");
        }

        public void i() {
            this.f20944a.f20875n0 = null;
            this.f20944a.d4();
            FileExplorerActivity.i4(this.f20944a, false, 1, (Object) null);
            AlertDialog R4 = this.f20944a.R();
            if (R4 != null) {
                R4.dismiss();
            }
            this.f20944a.t0((AlertDialog) null);
        }
    }

    public static final class f0 implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return C2265a.a(Long.valueOf(((DocumentFile) obj2).length()), Long.valueOf(((DocumentFile) obj).length()));
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$g  reason: case insensitive filesystem */
    static final class C2323g extends d {

        /* renamed from: a  reason: collision with root package name */
        Object f20945a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f20946b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f20947c;

        /* renamed from: d  reason: collision with root package name */
        int f20948d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2323g(FileExplorerActivity fileExplorerActivity, C2308e eVar) {
            super(eVar);
            this.f20947c = fileExplorerActivity;
        }

        public final Object invokeSuspend(Object obj) {
            this.f20946b = obj;
            this.f20948d |= Integer.MIN_VALUE;
            return this.f20947c.D3(this);
        }
    }

    public static final class g0 implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return C2265a.a(Boolean.valueOf(((DocumentFile) obj2).isDirectory()), Boolean.valueOf(((DocumentFile) obj).isDirectory()));
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$h  reason: case insensitive filesystem */
    static final class C2324h extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20949a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f20950b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2324h(FileExplorerActivity fileExplorerActivity, C2308e eVar) {
            super(2, eVar);
            this.f20950b = fileExplorerActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C2324h(this.f20950b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f20949a == 0) {
                u.b(obj);
                if (this.f20950b.f20864Q != null) {
                    FileExplorerActivity fileExplorerActivity = this.f20950b;
                    C2206b y22 = fileExplorerActivity.f20864Q;
                    t.b(y22);
                    fileExplorerActivity.f20875n0 = y22.b();
                }
                return W2.J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((C2324h) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    public static final class h0 implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return C2265a.a(Long.valueOf(((File) obj2).length()), Long.valueOf(((File) obj).length()));
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$i  reason: case insensitive filesystem */
    static final class C2325i extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20951a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f20952b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2325i(FileExplorerActivity fileExplorerActivity, C2308e eVar) {
            super(2, eVar);
            this.f20952b = fileExplorerActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C2325i(this.f20952b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Menu menu;
            MenuItem findItem;
            Menu menu2;
            MenuItem findItem2;
            Menu menu3;
            MenuItem findItem3;
            Menu menu4;
            MenuItem findItem4;
            Menu menu5;
            MenuItem findItem5;
            Menu menu6;
            MenuItem findItem6;
            C2316b.f();
            if (this.f20951a == 0) {
                u.b(obj);
                C2206b y22 = this.f20952b.f20864Q;
                t.b(y22);
                y22.h(false);
                if (this.f20952b.f20875n0 != null) {
                    ArrayList D22 = this.f20952b.f20875n0;
                    t.b(D22);
                    if (!D22.isEmpty()) {
                        Toolbar M22 = this.f20952b.f20862O;
                        if (!(M22 == null || (menu6 = M22.getMenu()) == null || (findItem6 = menu6.findItem(f.action_paste)) == null)) {
                            findItem6.setVisible(true);
                        }
                        Toolbar M23 = this.f20952b.f20862O;
                        if (!(M23 == null || (menu5 = M23.getMenu()) == null || (findItem5 = menu5.findItem(f.action_create)) == null)) {
                            findItem5.setVisible(true);
                        }
                        Toolbar M24 = this.f20952b.f20862O;
                        if (!(M24 == null || (menu4 = M24.getMenu()) == null || (findItem4 = menu4.findItem(f.action_copy)) == null)) {
                            findItem4.setVisible(false);
                        }
                        Toolbar M25 = this.f20952b.f20862O;
                        if (!(M25 == null || (menu3 = M25.getMenu()) == null || (findItem3 = menu3.findItem(f.action_compress)) == null)) {
                            findItem3.setVisible(false);
                        }
                        Toolbar M26 = this.f20952b.f20862O;
                        if (!(M26 == null || (menu2 = M26.getMenu()) == null || (findItem2 = menu2.findItem(f.action_cut)) == null)) {
                            findItem2.setVisible(false);
                        }
                        Toolbar M27 = this.f20952b.f20862O;
                        if (!(M27 == null || (menu = M27.getMenu()) == null || (findItem = menu.findItem(f.action_delete)) == null)) {
                            findItem.setVisible(false);
                        }
                    }
                }
                return W2.J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((C2325i) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    public static final class i0 implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return C2265a.a(Boolean.valueOf(((File) obj2).isDirectory()), Boolean.valueOf(((File) obj).isDirectory()));
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$j  reason: case insensitive filesystem */
    static final class C2326j extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f20953a;

        /* renamed from: b  reason: collision with root package name */
        int f20954b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f20955c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.I f20956d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f20957e;

        /* renamed from: com.uptodown.core.activities.FileExplorerActivity$j$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20958a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ FileExplorerActivity f20959b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(FileExplorerActivity fileExplorerActivity, C2308e eVar) {
                super(2, eVar);
                this.f20959b = fileExplorerActivity;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f20959b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20958a == 0) {
                    u.b(obj);
                    this.f20959b.h4(false);
                    return W2.J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(w3.M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2326j(FileExplorerActivity fileExplorerActivity, kotlin.jvm.internal.I i5, String str, C2308e eVar) {
            super(2, eVar);
            this.f20955c = fileExplorerActivity;
            this.f20956d = i5;
            this.f20957e = str;
        }

        /* access modifiers changed from: private */
        public static final W2.J e(FileExplorerActivity fileExplorerActivity) {
            AlertDialog z22 = fileExplorerActivity.f20861N;
            if (z22 != null) {
                z22.dismiss();
            }
            return W2.J.f19942a;
        }

        /* access modifiers changed from: private */
        public static final W2.J f(FileExplorerActivity fileExplorerActivity) {
            AlertDialog z22 = fileExplorerActivity.f20861N;
            if (z22 != null) {
                z22.dismiss();
            }
            return W2.J.f19942a;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C2326j(this.f20955c, this.f20956d, this.f20957e, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0060, code lost:
            if (r12 == r0) goto L_0x00be;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0097, code lost:
            if (r12 == r0) goto L_0x00be;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00bc, code lost:
            if (w3.C2872g.g(r12, r1, r11) == r0) goto L_0x00be;
         */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x00a8  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r11.f20954b
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x0032
                if (r1 == r4) goto L_0x0029
                if (r1 == r3) goto L_0x001f
                if (r1 != r2) goto L_0x0017
                W2.u.b(r12)
                r8 = r11
                goto L_0x00bf
            L_0x0017:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L_0x001f:
                java.lang.Object r1 = r11.f20953a
                kotlin.jvm.internal.I r1 = (kotlin.jvm.internal.I) r1
                W2.u.b(r12)
                r8 = r11
                goto L_0x009a
            L_0x0029:
                java.lang.Object r1 = r11.f20953a
                kotlin.jvm.internal.I r1 = (kotlin.jvm.internal.I) r1
                W2.u.b(r12)
                r8 = r11
                goto L_0x0063
            L_0x0032:
                W2.u.b(r12)
                com.uptodown.core.activities.FileExplorerActivity r12 = r11.f20955c
                java.io.File r12 = r12.f20871X
                if (r12 == 0) goto L_0x006c
                kotlin.jvm.internal.I r1 = r11.f20956d
                b2.i r5 = new b2.i
                r5.<init>()
                com.uptodown.core.activities.FileExplorerActivity r12 = r11.f20955c
                java.io.File r6 = r12.f20871X
                kotlin.jvm.internal.t.b(r6)
                java.lang.String r7 = r11.f20957e
                com.uptodown.core.activities.FileExplorerActivity r8 = r11.f20955c
                com.uptodown.core.activities.a r9 = new com.uptodown.core.activities.a
                r9.<init>(r8)
                r11.f20953a = r1
                r11.f20954b = r4
                r10 = r11
                java.lang.Object r12 = r5.f(r6, r7, r8, r9, r10)
                r8 = r10
                if (r12 != r0) goto L_0x0063
                goto L_0x00be
            L_0x0063:
                java.lang.Boolean r12 = (java.lang.Boolean) r12
                boolean r12 = r12.booleanValue()
                r1.f24687a = r12
                goto L_0x00a2
            L_0x006c:
                r8 = r11
                com.uptodown.core.activities.FileExplorerActivity r12 = r8.f20955c
                androidx.documentfile.provider.DocumentFile r12 = r12.f20867T
                if (r12 == 0) goto L_0x00a2
                kotlin.jvm.internal.I r1 = r8.f20956d
                r12 = r3
                b2.i r3 = new b2.i
                r3.<init>()
                com.uptodown.core.activities.FileExplorerActivity r4 = r8.f20955c
                androidx.documentfile.provider.DocumentFile r4 = r4.f20867T
                kotlin.jvm.internal.t.b(r4)
                java.lang.String r5 = r8.f20957e
                com.uptodown.core.activities.FileExplorerActivity r6 = r8.f20955c
                com.uptodown.core.activities.b r7 = new com.uptodown.core.activities.b
                r7.<init>(r6)
                r8.f20953a = r1
                r8.f20954b = r12
                java.lang.Object r12 = r3.f(r4, r5, r6, r7, r8)
                if (r12 != r0) goto L_0x009a
                goto L_0x00be
            L_0x009a:
                java.lang.Boolean r12 = (java.lang.Boolean) r12
                boolean r12 = r12.booleanValue()
                r1.f24687a = r12
            L_0x00a2:
                kotlin.jvm.internal.I r12 = r8.f20956d
                boolean r12 = r12.f24687a
                if (r12 == 0) goto L_0x00bf
                w3.I0 r12 = w3.C2865c0.c()
                com.uptodown.core.activities.FileExplorerActivity$j$a r1 = new com.uptodown.core.activities.FileExplorerActivity$j$a
                com.uptodown.core.activities.FileExplorerActivity r3 = r8.f20955c
                r4 = 0
                r1.<init>(r3, r4)
                r8.f20953a = r4
                r8.f20954b = r2
                java.lang.Object r12 = w3.C2872g.g(r12, r1, r11)
                if (r12 != r0) goto L_0x00bf
            L_0x00be:
                return r0
            L_0x00bf:
                W2.J r12 = W2.J.f19942a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.C2326j.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((C2326j) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$k  reason: case insensitive filesystem */
    static final class C2327k extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20960a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f20961b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2327k(FileExplorerActivity fileExplorerActivity, C2308e eVar) {
            super(2, eVar);
            this.f20961b = fileExplorerActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C2327k(this.f20961b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f20960a;
            if (i5 == 0) {
                u.b(obj);
                FileExplorerActivity fileExplorerActivity = this.f20961b;
                this.f20960a = 1;
                if (fileExplorerActivity.K3(this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return W2.J.f19942a;
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((C2327k) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$l  reason: case insensitive filesystem */
    static final class C2328l extends d {

        /* renamed from: a  reason: collision with root package name */
        Object f20962a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f20963b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f20964c;

        /* renamed from: d  reason: collision with root package name */
        int f20965d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2328l(FileExplorerActivity fileExplorerActivity, C2308e eVar) {
            super(eVar);
            this.f20964c = fileExplorerActivity;
        }

        public final Object invokeSuspend(Object obj) {
            this.f20963b = obj;
            this.f20965d |= Integer.MIN_VALUE;
            return this.f20964c.K3(this);
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$m  reason: case insensitive filesystem */
    static final class C2329m extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20966a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f20967b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2329m(FileExplorerActivity fileExplorerActivity, C2308e eVar) {
            super(2, eVar);
            this.f20967b = fileExplorerActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C2329m(this.f20967b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f20966a == 0) {
                u.b(obj);
                if (this.f20967b.f20864Q != null) {
                    FileExplorerActivity fileExplorerActivity = this.f20967b;
                    C2206b y22 = fileExplorerActivity.f20864Q;
                    t.b(y22);
                    fileExplorerActivity.f20875n0 = y22.b();
                }
                return W2.J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((C2329m) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$n  reason: case insensitive filesystem */
    static final class C2330n extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20968a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f20969b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2330n(FileExplorerActivity fileExplorerActivity, C2308e eVar) {
            super(2, eVar);
            this.f20969b = fileExplorerActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C2330n(this.f20969b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Menu menu;
            MenuItem findItem;
            Menu menu2;
            MenuItem findItem2;
            Menu menu3;
            MenuItem findItem3;
            Menu menu4;
            MenuItem findItem4;
            Menu menu5;
            MenuItem findItem5;
            Menu menu6;
            MenuItem findItem6;
            C2316b.f();
            if (this.f20968a == 0) {
                u.b(obj);
                C2206b y22 = this.f20969b.f20864Q;
                t.b(y22);
                y22.h(false);
                if (this.f20969b.f20875n0 != null) {
                    ArrayList D22 = this.f20969b.f20875n0;
                    t.b(D22);
                    if (!D22.isEmpty()) {
                        Toolbar M22 = this.f20969b.f20862O;
                        if (!(M22 == null || (menu6 = M22.getMenu()) == null || (findItem6 = menu6.findItem(f.action_paste)) == null)) {
                            findItem6.setVisible(true);
                        }
                        Toolbar M23 = this.f20969b.f20862O;
                        if (!(M23 == null || (menu5 = M23.getMenu()) == null || (findItem5 = menu5.findItem(f.action_create)) == null)) {
                            findItem5.setVisible(true);
                        }
                        Toolbar M24 = this.f20969b.f20862O;
                        if (!(M24 == null || (menu4 = M24.getMenu()) == null || (findItem4 = menu4.findItem(f.action_copy)) == null)) {
                            findItem4.setVisible(false);
                        }
                        Toolbar M25 = this.f20969b.f20862O;
                        if (!(M25 == null || (menu3 = M25.getMenu()) == null || (findItem3 = menu3.findItem(f.action_compress)) == null)) {
                            findItem3.setVisible(false);
                        }
                        Toolbar M26 = this.f20969b.f20862O;
                        if (!(M26 == null || (menu2 = M26.getMenu()) == null || (findItem2 = menu2.findItem(f.action_cut)) == null)) {
                            findItem2.setVisible(false);
                        }
                        Toolbar M27 = this.f20969b.f20862O;
                        if (!(M27 == null || (menu = M27.getMenu()) == null || (findItem = menu.findItem(f.action_delete)) == null)) {
                            findItem.setVisible(false);
                        }
                    }
                }
                return W2.J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((C2330n) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$o  reason: case insensitive filesystem */
    static final class C2331o extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20970a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ File f20971b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f20972c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2228e f20973d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f20974e;

        /* renamed from: com.uptodown.core.activities.FileExplorerActivity$o$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20975a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ FileExplorerActivity f20976b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(FileExplorerActivity fileExplorerActivity, C2308e eVar) {
                super(2, eVar);
                this.f20976b = fileExplorerActivity;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f20976b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20975a == 0) {
                    u.b(obj);
                    this.f20976b.f5();
                    return W2.J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(w3.M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2331o(File file, String str, C2228e eVar, FileExplorerActivity fileExplorerActivity, C2308e eVar2) {
            super(2, eVar2);
            this.f20971b = file;
            this.f20972c = str;
            this.f20973d = eVar;
            this.f20974e = fileExplorerActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C2331o(this.f20971b, this.f20972c, this.f20973d, this.f20974e, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0047, code lost:
            if (w3.C2872g.g(r7, r1, r6) == r0) goto L_0x0049;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0049, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0032, code lost:
            if (r7.m(r1, r4, r5, r6) == r0) goto L_0x0049;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r6.f20970a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x001e
                if (r1 == r3) goto L_0x001a
                if (r1 != r2) goto L_0x0012
                W2.u.b(r7)
                goto L_0x004a
            L_0x0012:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L_0x001a:
                W2.u.b(r7)
                goto L_0x0035
            L_0x001e:
                W2.u.b(r7)
                b2.L r7 = new b2.L
                r7.<init>()
                java.io.File r1 = r6.f20971b
                java.lang.String r4 = r6.f20972c
                X1.e r5 = r6.f20973d
                r6.f20970a = r3
                java.lang.Object r7 = r7.m(r1, r4, r5, r6)
                if (r7 != r0) goto L_0x0035
                goto L_0x0049
            L_0x0035:
                w3.I0 r7 = w3.C2865c0.c()
                com.uptodown.core.activities.FileExplorerActivity$o$a r1 = new com.uptodown.core.activities.FileExplorerActivity$o$a
                com.uptodown.core.activities.FileExplorerActivity r3 = r6.f20974e
                r4 = 0
                r1.<init>(r3, r4)
                r6.f20970a = r2
                java.lang.Object r7 = w3.C2872g.g(r7, r1, r6)
                if (r7 != r0) goto L_0x004a
            L_0x0049:
                return r0
            L_0x004a:
                W2.J r7 = W2.J.f19942a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.C2331o.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((C2331o) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$p  reason: case insensitive filesystem */
    static final class C2332p extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20977a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ File f20978b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Uri f20979c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2228e f20980d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f20981e;

        /* renamed from: com.uptodown.core.activities.FileExplorerActivity$p$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20982a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ FileExplorerActivity f20983b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(FileExplorerActivity fileExplorerActivity, C2308e eVar) {
                super(2, eVar);
                this.f20983b = fileExplorerActivity;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f20983b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20982a == 0) {
                    u.b(obj);
                    this.f20983b.f5();
                    return W2.J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(w3.M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2332p(File file, Uri uri, C2228e eVar, FileExplorerActivity fileExplorerActivity, C2308e eVar2) {
            super(2, eVar2);
            this.f20978b = file;
            this.f20979c = uri;
            this.f20980d = eVar;
            this.f20981e = fileExplorerActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C2332p(this.f20978b, this.f20979c, this.f20980d, this.f20981e, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0056, code lost:
            if (w3.C2872g.g(r10, r1, r9) == r0) goto L_0x0058;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0058, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0041, code lost:
            if (r3.l(r4, r5, r6, r7, r8) == r0) goto L_0x0058;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r9.f20977a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x0020
                if (r1 == r3) goto L_0x001b
                if (r1 != r2) goto L_0x0013
                W2.u.b(r10)
                r8 = r9
                goto L_0x0059
            L_0x0013:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L_0x001b:
                W2.u.b(r10)
                r8 = r9
                goto L_0x0044
            L_0x0020:
                W2.u.b(r10)
                r10 = r3
                b2.L r3 = new b2.L
                r3.<init>()
                java.io.File r4 = r9.f20978b
                android.net.Uri r5 = r9.f20979c
                X1.e r6 = r9.f20980d
                com.uptodown.core.activities.FileExplorerActivity r1 = r9.f20981e
                android.content.Context r7 = r1.getApplicationContext()
                java.lang.String r1 = "getApplicationContext(...)"
                kotlin.jvm.internal.t.d(r7, r1)
                r9.f20977a = r10
                r8 = r9
                java.lang.Object r10 = r3.l(r4, r5, r6, r7, r8)
                if (r10 != r0) goto L_0x0044
                goto L_0x0058
            L_0x0044:
                w3.I0 r10 = w3.C2865c0.c()
                com.uptodown.core.activities.FileExplorerActivity$p$a r1 = new com.uptodown.core.activities.FileExplorerActivity$p$a
                com.uptodown.core.activities.FileExplorerActivity r3 = r8.f20981e
                r4 = 0
                r1.<init>(r3, r4)
                r8.f20977a = r2
                java.lang.Object r10 = w3.C2872g.g(r10, r1, r9)
                if (r10 != r0) goto L_0x0059
            L_0x0058:
                return r0
            L_0x0059:
                W2.J r10 = W2.J.f19942a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.C2332p.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((C2332p) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$q  reason: case insensitive filesystem */
    static final class C2333q extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20984a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ DocumentFile f20985b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f20986c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2228e f20987d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f20988e;

        /* renamed from: com.uptodown.core.activities.FileExplorerActivity$q$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20989a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ FileExplorerActivity f20990b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(FileExplorerActivity fileExplorerActivity, C2308e eVar) {
                super(2, eVar);
                this.f20990b = fileExplorerActivity;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f20990b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20989a == 0) {
                    u.b(obj);
                    this.f20990b.f5();
                    return W2.J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(w3.M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2333q(DocumentFile documentFile, String str, C2228e eVar, FileExplorerActivity fileExplorerActivity, C2308e eVar2) {
            super(2, eVar2);
            this.f20985b = documentFile;
            this.f20986c = str;
            this.f20987d = eVar;
            this.f20988e = fileExplorerActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C2333q(this.f20985b, this.f20986c, this.f20987d, this.f20988e, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0056, code lost:
            if (w3.C2872g.g(r10, r1, r9) == r0) goto L_0x0058;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0058, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0041, code lost:
            if (r3.k(r4, r5, r6, r7, r8) == r0) goto L_0x0058;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r9.f20984a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x0020
                if (r1 == r3) goto L_0x001b
                if (r1 != r2) goto L_0x0013
                W2.u.b(r10)
                r8 = r9
                goto L_0x0059
            L_0x0013:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L_0x001b:
                W2.u.b(r10)
                r8 = r9
                goto L_0x0044
            L_0x0020:
                W2.u.b(r10)
                r10 = r3
                b2.L r3 = new b2.L
                r3.<init>()
                androidx.documentfile.provider.DocumentFile r4 = r9.f20985b
                java.lang.String r5 = r9.f20986c
                X1.e r6 = r9.f20987d
                com.uptodown.core.activities.FileExplorerActivity r1 = r9.f20988e
                android.content.Context r7 = r1.getApplicationContext()
                java.lang.String r1 = "getApplicationContext(...)"
                kotlin.jvm.internal.t.d(r7, r1)
                r9.f20984a = r10
                r8 = r9
                java.lang.Object r10 = r3.k(r4, r5, r6, r7, r8)
                if (r10 != r0) goto L_0x0044
                goto L_0x0058
            L_0x0044:
                w3.I0 r10 = w3.C2865c0.c()
                com.uptodown.core.activities.FileExplorerActivity$q$a r1 = new com.uptodown.core.activities.FileExplorerActivity$q$a
                com.uptodown.core.activities.FileExplorerActivity r3 = r8.f20988e
                r4 = 0
                r1.<init>(r3, r4)
                r8.f20984a = r2
                java.lang.Object r10 = w3.C2872g.g(r10, r1, r9)
                if (r10 != r0) goto L_0x0059
            L_0x0058:
                return r0
            L_0x0059:
                W2.J r10 = W2.J.f19942a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.C2333q.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((C2333q) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$r  reason: case insensitive filesystem */
    static final class C2334r extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20991a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ DocumentFile f20992b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Uri f20993c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2228e f20994d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f20995e;

        /* renamed from: com.uptodown.core.activities.FileExplorerActivity$r$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20996a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ FileExplorerActivity f20997b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(FileExplorerActivity fileExplorerActivity, C2308e eVar) {
                super(2, eVar);
                this.f20997b = fileExplorerActivity;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f20997b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20996a == 0) {
                    u.b(obj);
                    this.f20997b.f5();
                    return W2.J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(w3.M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2334r(DocumentFile documentFile, Uri uri, C2228e eVar, FileExplorerActivity fileExplorerActivity, C2308e eVar2) {
            super(2, eVar2);
            this.f20992b = documentFile;
            this.f20993c = uri;
            this.f20994d = eVar;
            this.f20995e = fileExplorerActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C2334r(this.f20992b, this.f20993c, this.f20994d, this.f20995e, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0056, code lost:
            if (w3.C2872g.g(r10, r1, r9) == r0) goto L_0x0058;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0058, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0041, code lost:
            if (r3.j(r4, r5, r6, r7, r8) == r0) goto L_0x0058;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r9.f20991a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x0020
                if (r1 == r3) goto L_0x001b
                if (r1 != r2) goto L_0x0013
                W2.u.b(r10)
                r8 = r9
                goto L_0x0059
            L_0x0013:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L_0x001b:
                W2.u.b(r10)
                r8 = r9
                goto L_0x0044
            L_0x0020:
                W2.u.b(r10)
                r10 = r3
                b2.L r3 = new b2.L
                r3.<init>()
                androidx.documentfile.provider.DocumentFile r4 = r9.f20992b
                android.net.Uri r5 = r9.f20993c
                X1.e r6 = r9.f20994d
                com.uptodown.core.activities.FileExplorerActivity r1 = r9.f20995e
                android.content.Context r7 = r1.getApplicationContext()
                java.lang.String r1 = "getApplicationContext(...)"
                kotlin.jvm.internal.t.d(r7, r1)
                r9.f20991a = r10
                r8 = r9
                java.lang.Object r10 = r3.j(r4, r5, r6, r7, r8)
                if (r10 != r0) goto L_0x0044
                goto L_0x0058
            L_0x0044:
                w3.I0 r10 = w3.C2865c0.c()
                com.uptodown.core.activities.FileExplorerActivity$r$a r1 = new com.uptodown.core.activities.FileExplorerActivity$r$a
                com.uptodown.core.activities.FileExplorerActivity r3 = r8.f20995e
                r4 = 0
                r1.<init>(r3, r4)
                r8.f20991a = r2
                java.lang.Object r10 = w3.C2872g.g(r10, r1, r9)
                if (r10 != r0) goto L_0x0059
            L_0x0058:
                return r0
            L_0x0059:
                W2.J r10 = W2.J.f19942a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.C2334r.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((C2334r) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$s  reason: case insensitive filesystem */
    static final class C2335s extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20998a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f20999b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2335s(FileExplorerActivity fileExplorerActivity, C2308e eVar) {
            super(2, eVar);
            this.f20999b = fileExplorerActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C2335s(this.f20999b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f20998a;
            if (i5 == 0) {
                u.b(obj);
                FileExplorerActivity fileExplorerActivity = this.f20999b;
                this.f20998a = 1;
                if (fileExplorerActivity.Q3(this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return W2.J.f19942a;
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((C2335s) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$t  reason: case insensitive filesystem */
    static final class C2336t extends d {

        /* renamed from: a  reason: collision with root package name */
        Object f21000a;

        /* renamed from: b  reason: collision with root package name */
        Object f21001b;

        /* renamed from: c  reason: collision with root package name */
        /* synthetic */ Object f21002c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f21003d;

        /* renamed from: e  reason: collision with root package name */
        int f21004e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2336t(FileExplorerActivity fileExplorerActivity, C2308e eVar) {
            super(eVar);
            this.f21003d = fileExplorerActivity;
        }

        public final Object invokeSuspend(Object obj) {
            this.f21002c = obj;
            this.f21004e |= Integer.MIN_VALUE;
            return this.f21003d.Q3(this);
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$u  reason: case insensitive filesystem */
    static final class C2337u extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21005a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f21006b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2337u(FileExplorerActivity fileExplorerActivity, C2308e eVar) {
            super(2, eVar);
            this.f21006b = fileExplorerActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C2337u(this.f21006b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f21005a == 0) {
                u.b(obj);
                RelativeLayout I22 = this.f21006b.f20848A;
                if (I22 == null) {
                    t.w("rlLoading");
                    I22 = null;
                }
                I22.setVisibility(0);
                return W2.J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((C2337u) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$v  reason: case insensitive filesystem */
    static final class C2338v extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f21007a;

        /* renamed from: b  reason: collision with root package name */
        int f21008b;

        /* renamed from: c  reason: collision with root package name */
        int f21009c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f21010d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.J f21011e;

        /* renamed from: com.uptodown.core.activities.FileExplorerActivity$v$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21012a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ FileExplorerActivity f21013b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f21014c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(FileExplorerActivity fileExplorerActivity, int i5, C2308e eVar) {
                super(2, eVar);
                this.f21013b = fileExplorerActivity;
                this.f21014c = i5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21013b, this.f21014c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21012a == 0) {
                    u.b(obj);
                    C2206b y22 = this.f21013b.f20864Q;
                    t.b(y22);
                    y22.notifyItemRemoved(this.f21014c);
                    return W2.J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(w3.M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2338v(FileExplorerActivity fileExplorerActivity, kotlin.jvm.internal.J j5, C2308e eVar) {
            super(2, eVar);
            this.f21010d = fileExplorerActivity;
            this.f21011e = j5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C2338v(this.f21010d, this.f21011e, eVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x004b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r9.f21009c
                r2 = 0
                r3 = 1
                if (r1 == 0) goto L_0x001f
                if (r1 != r3) goto L_0x0017
                int r1 = r9.f21008b
                java.lang.Object r4 = r9.f21007a
                java.util.Iterator r4 = (java.util.Iterator) r4
                W2.u.b(r10)
                goto L_0x0088
            L_0x0017:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L_0x001f:
                W2.u.b(r10)
                com.uptodown.core.activities.FileExplorerActivity r10 = r9.f21010d
                V1.b r10 = r10.f20864Q
                if (r10 == 0) goto L_0x008a
                com.uptodown.core.activities.FileExplorerActivity r10 = r9.f21010d
                V1.b r10 = r10.f20864Q
                kotlin.jvm.internal.t.b(r10)
                java.util.ArrayList r10 = r10.b()
                kotlin.jvm.internal.J r1 = r9.f21011e
                int r4 = r10.size()
                r1.f24688a = r4
                java.util.Iterator r10 = r10.iterator()
                r4 = r10
                r10 = r2
            L_0x0045:
                boolean r1 = r4.hasNext()
                if (r1 == 0) goto L_0x008a
                int r1 = r10 + 1
                java.lang.Object r5 = r4.next()
                boolean r6 = r5 instanceof java.io.File
                if (r6 == 0) goto L_0x0061
                b2.k r6 = new b2.k
                r6.<init>()
                java.io.File r5 = (java.io.File) r5
                boolean r5 = r6.a(r5)
                goto L_0x006d
            L_0x0061:
                boolean r6 = r5 instanceof androidx.documentfile.provider.DocumentFile
                if (r6 == 0) goto L_0x006c
                androidx.documentfile.provider.DocumentFile r5 = (androidx.documentfile.provider.DocumentFile) r5
                boolean r5 = r5.delete()
                goto L_0x006d
            L_0x006c:
                r5 = r2
            L_0x006d:
                if (r5 == 0) goto L_0x0088
                w3.I0 r5 = w3.C2865c0.c()
                com.uptodown.core.activities.FileExplorerActivity$v$a r6 = new com.uptodown.core.activities.FileExplorerActivity$v$a
                com.uptodown.core.activities.FileExplorerActivity r7 = r9.f21010d
                r8 = 0
                r6.<init>(r7, r10, r8)
                r9.f21007a = r4
                r9.f21008b = r1
                r9.f21009c = r3
                java.lang.Object r10 = w3.C2872g.g(r5, r6, r9)
                if (r10 != r0) goto L_0x0088
                return r0
            L_0x0088:
                r10 = r1
                goto L_0x0045
            L_0x008a:
                W2.J r10 = W2.J.f19942a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.C2338v.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((C2338v) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$w  reason: case insensitive filesystem */
    static final class C2339w extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21015a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f21016b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.J f21017c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2339w(FileExplorerActivity fileExplorerActivity, kotlin.jvm.internal.J j5, C2308e eVar) {
            super(2, eVar);
            this.f21016b = fileExplorerActivity;
            this.f21017c = j5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C2339w(this.f21016b, this.f21017c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f21015a == 0) {
                u.b(obj);
                C2206b y22 = this.f21016b.f20864Q;
                t.b(y22);
                y22.h(false);
                RelativeLayout I22 = this.f21016b.f20848A;
                if (I22 == null) {
                    t.w("rlLoading");
                    I22 = null;
                }
                I22.setVisibility(8);
                FileExplorerActivity fileExplorerActivity = this.f21016b;
                String string = fileExplorerActivity.getString(i.core_files_deleted, new Object[]{String.valueOf(this.f21017c.f24688a)});
                t.d(string, "getString(...)");
                fileExplorerActivity.u0(string);
                this.f21016b.d4();
                this.f21016b.h4(false);
                return W2.J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((C2339w) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$x  reason: case insensitive filesystem */
    public static final class C2340x implements C2226c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ProgressBar f21018a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TextView f21019b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ EditText f21020c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f21021d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ TextView f21022e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ TextView f21023f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ RelativeLayout f21024g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ TextView f21025h;

        C2340x(ProgressBar progressBar, TextView textView, EditText editText, FileExplorerActivity fileExplorerActivity, TextView textView2, TextView textView3, RelativeLayout relativeLayout, TextView textView4) {
            this.f21018a = progressBar;
            this.f21019b = textView;
            this.f21020c = editText;
            this.f21021d = fileExplorerActivity;
            this.f21022e = textView2;
            this.f21023f = textView3;
            this.f21024g = relativeLayout;
            this.f21025h = textView4;
        }

        public void a(String str) {
            t.e(str, "fileName");
            this.f21023f.setText(str);
            this.f21024g.setVisibility(8);
            this.f21022e.setVisibility(8);
            this.f21025h.setText(this.f21021d.getString(i.close));
        }

        public void b(String str) {
            t.e(str, "filesCount");
            this.f21020c.setFocusable(false);
            this.f21020c.setFocusableInTouchMode(false);
            this.f21020c.clearFocus();
            this.f21018a.setVisibility(0);
            this.f21019b.setVisibility(0);
            this.f21019b.setText(this.f21021d.getString(i.core_start_counting_value, new Object[]{str}));
            this.f21022e.setVisibility(8);
        }

        public void c(int i5, String str) {
            t.e(str, "filesCount");
            this.f21018a.setProgress(i5);
            this.f21019b.setText(str);
        }

        public void onError(String str) {
            this.f21023f.setText(str);
            this.f21018a.setVisibility(0);
            this.f21022e.setVisibility(8);
            this.f21025h.setText(this.f21021d.getString(i.close));
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$y  reason: case insensitive filesystem */
    static final class C2341y extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21026a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f21027b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ EditText f21028c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2341y(FileExplorerActivity fileExplorerActivity, EditText editText, C2308e eVar) {
            super(2, eVar);
            this.f21027b = fileExplorerActivity;
            this.f21028c = editText;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C2341y(this.f21027b, this.f21028c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f21026a == 0) {
                u.b(obj);
                this.f21027b.I3(this.f21028c.getText().toString());
                return W2.J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((C2341y) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$z  reason: case insensitive filesystem */
    public static final class C2342z implements C2228e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f21029a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f21030b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f21031c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ProgressBar f21032d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ TextView f21033e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ TextView f21034f;

        C2342z(TextView textView, FileExplorerActivity fileExplorerActivity, View view, ProgressBar progressBar, TextView textView2, TextView textView3) {
            this.f21029a = textView;
            this.f21030b = fileExplorerActivity;
            this.f21031c = view;
            this.f21032d = progressBar;
            this.f21033e = textView2;
            this.f21034f = textView3;
        }

        public void a() {
            this.f21029a.setText(this.f21030b.getString(i.core_decompress_dialog_error));
            this.f21032d.setIndeterminate(false);
            this.f21032d.setProgress(0);
            this.f21034f.setText(this.f21030b.getString(i.close));
        }

        public void b(int i5) {
            this.f21029a.setText(this.f21030b.getString(i.core_decompress_dialog_completed, new Object[]{String.valueOf(i5)}));
            this.f21032d.setIndeterminate(false);
            this.f21032d.setProgress(100);
            this.f21034f.setText(this.f21030b.getString(i.close));
        }

        public void c() {
            this.f21029a.setText(this.f21030b.getString(i.core_decompress_dialog_decompressing));
            ((RadioGroup) this.f21031c.findViewById(f.rg_decompress_path)).setVisibility(8);
            TextView N22 = this.f21030b.f20853F;
            if (N22 == null) {
                t.w("tvSelectedPath");
                N22 = null;
            }
            N22.setVisibility(8);
            this.f21032d.setVisibility(0);
            this.f21032d.setIndeterminate(true);
            this.f21033e.setVisibility(8);
        }

        public void d(long j5) {
            TextView textView = this.f21029a;
            textView.setText(this.f21030b.getString(i.core_decompress_dialog_decompressing) + ' ' + new C2291k().d(j5, this.f21030b));
        }
    }

    public FileExplorerActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C2200z(this));
        t.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f20888y0 = registerForActivityResult;
    }

    private final C2908y0 A3(ArrayList arrayList, DocumentFile documentFile, C2226c cVar) {
        return C2876i.d(w3.N.a(C2865c0.b()), (C2312i) null, (w3.O) null, new C2319c(arrayList, documentFile, cVar, this, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void A4(FileExplorerActivity fileExplorerActivity, View view) {
        fileExplorerActivity.finish();
    }

    private final C2908y0 B3(ArrayList arrayList, File file, C2226c cVar) {
        return C2876i.d(w3.N.a(C2865c0.b()), (C2312i) null, (w3.O) null, new C2320d(arrayList, file, cVar, this, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final boolean B4(FileExplorerActivity fileExplorerActivity, MenuItem menuItem) {
        t.e(menuItem, "item");
        int itemId = menuItem.getItemId();
        if (itemId == f.action_create) {
            fileExplorerActivity.U3();
            return true;
        } else if (itemId == f.action_delete) {
            fileExplorerActivity.E3();
            return true;
        } else if (itemId == f.action_compress) {
            fileExplorerActivity.R3();
            return true;
        } else if (itemId == f.action_copy) {
            fileExplorerActivity.C3();
            return true;
        } else if (itemId == f.action_cut) {
            fileExplorerActivity.J3();
            return true;
        } else if (itemId != f.action_paste) {
            return true;
        } else {
            fileExplorerActivity.K4();
            return true;
        }
    }

    private final void C3() {
        C2908y0 unused = C2876i.d(w3.N.a(C2865c0.b()), (C2312i) null, (w3.O) null, new C2321e(this, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void C4(FileExplorerActivity fileExplorerActivity, View view) {
        fileExplorerActivity.N4();
        fileExplorerActivity.T4();
        fileExplorerActivity.h4(true);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0066, code lost:
        if (w3.C2872g.g(r7, r4, r0) != r1) goto L_0x0069;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object D3(b3.C2308e r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.uptodown.core.activities.FileExplorerActivity.C2323g
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.uptodown.core.activities.FileExplorerActivity$g r0 = (com.uptodown.core.activities.FileExplorerActivity.C2323g) r0
            int r1 = r0.f20948d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f20948d = r1
            goto L_0x0018
        L_0x0013:
            com.uptodown.core.activities.FileExplorerActivity$g r0 = new com.uptodown.core.activities.FileExplorerActivity$g
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f20946b
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f20948d
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            W2.u.b(r7)
            goto L_0x0069
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0035:
            java.lang.Object r2 = r0.f20945a
            com.uptodown.core.activities.FileExplorerActivity r2 = (com.uptodown.core.activities.FileExplorerActivity) r2
            W2.u.b(r7)
            goto L_0x0055
        L_0x003d:
            W2.u.b(r7)
            w3.I r7 = w3.C2865c0.b()
            com.uptodown.core.activities.FileExplorerActivity$h r2 = new com.uptodown.core.activities.FileExplorerActivity$h
            r2.<init>(r6, r5)
            r0.f20945a = r6
            r0.f20948d = r4
            java.lang.Object r7 = w3.C2872g.g(r7, r2, r0)
            if (r7 != r1) goto L_0x0054
            goto L_0x0068
        L_0x0054:
            r2 = r6
        L_0x0055:
            w3.I0 r7 = w3.C2865c0.c()
            com.uptodown.core.activities.FileExplorerActivity$i r4 = new com.uptodown.core.activities.FileExplorerActivity$i
            r4.<init>(r2, r5)
            r0.f20945a = r5
            r0.f20948d = r3
            java.lang.Object r7 = w3.C2872g.g(r7, r4, r0)
            if (r7 != r1) goto L_0x0069
        L_0x0068:
            return r1
        L_0x0069:
            W2.J r7 = W2.J.f19942a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.D3(b3.e):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final void D4(FileExplorerActivity fileExplorerActivity, View view) {
        SearchView searchView = fileExplorerActivity.f20855H;
        if (searchView != null) {
            searchView.setIconified(false);
        }
    }

    private final void E3() {
        AlertDialog alertDialog = this.f20861N;
        if (alertDialog != null) {
            t.b(alertDialog);
            alertDialog.dismiss();
        }
        Integer num = null;
        View inflate = getLayoutInflater().inflate(g.dialog_accept_cancel, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(f.tv_dialog_msg);
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.x());
        Context context = textView.getContext();
        int i5 = i.core_delete_x_files;
        C2206b bVar = this.f20864Q;
        if (bVar != null) {
            num = Integer.valueOf(bVar.a());
        }
        textView.setText(context.getString(i5, new Object[]{String.valueOf(num)}));
        TextView textView2 = (TextView) inflate.findViewById(f.tv_accept_option);
        textView2.setText(getString(i.option_button_delete));
        textView2.setTypeface(aVar.w());
        textView2.setOnClickListener(new T1.U(this));
        TextView textView3 = (TextView) inflate.findViewById(f.tv_cancel_option);
        textView3.setText(getString(i.option_button_cancel));
        textView3.setTypeface(aVar.w());
        textView3.setOnClickListener(new T1.V(this));
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(inflate);
        AlertDialog create = builder.create();
        this.f20861N = create;
        t.b(create);
        Window window = create.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        AlertDialog alertDialog2 = this.f20861N;
        t.b(alertDialog2);
        alertDialog2.show();
    }

    /* access modifiers changed from: private */
    public static final void E4(FileExplorerActivity fileExplorerActivity, View view) {
        RelativeLayout relativeLayout = fileExplorerActivity.f20857J;
        t.b(relativeLayout);
        if (relativeLayout.getVisibility() == 0) {
            view.animate().rotation(0.0f).start();
            RelativeLayout relativeLayout2 = fileExplorerActivity.f20857J;
            t.b(relativeLayout2);
            relativeLayout2.setVisibility(8);
            return;
        }
        view.animate().rotation(180.0f).start();
        RelativeLayout relativeLayout3 = fileExplorerActivity.f20857J;
        t.b(relativeLayout3);
        relativeLayout3.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public static final void F3(FileExplorerActivity fileExplorerActivity, View view) {
        fileExplorerActivity.P3();
        AlertDialog alertDialog = fileExplorerActivity.f20861N;
        t.b(alertDialog);
        alertDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void F4(FileExplorerActivity fileExplorerActivity, View view) {
        fileExplorerActivity.f20872Y = !fileExplorerActivity.f20872Y;
        fileExplorerActivity.I4();
        fileExplorerActivity.W4();
    }

    /* access modifiers changed from: private */
    public static final void G3(FileExplorerActivity fileExplorerActivity, View view) {
        AlertDialog alertDialog = fileExplorerActivity.f20861N;
        t.b(alertDialog);
        alertDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public final void G4(DocumentFile documentFile) {
        Uri uri = documentFile.getUri();
        t.d(uri, "getUri(...)");
        e5(uri);
    }

    /* access modifiers changed from: private */
    public final void H3(String str, int i5, int i6, long j5) {
        if (R() == null) {
            View inflate = getLayoutInflater().inflate(g.dialog_copy_files, (ViewGroup) null, false);
            TextView textView = (TextView) inflate.findViewById(f.tv_title_dialog_copying);
            k.a aVar = k.f32g;
            textView.setTypeface(aVar.w());
            int i7 = i.copying;
            int i8 = i.size_of_total_size;
            textView.setText(getString(i7, new Object[]{getString(i8, new Object[]{String.valueOf(i5), String.valueOf(i6)})}));
            TextView textView2 = (TextView) inflate.findViewById(f.tv_size_dialog_copying);
            textView2.setTypeface(aVar.x());
            int i9 = i.mb_placeholder;
            int i10 = i.zero;
            textView2.setText(getString(i8, new Object[]{getString(i9, new Object[]{getString(i10)}), new C2291k().c(j5)}));
            ((ProgressBar) inflate.findViewById(f.pb_dialog_copying)).setProgress(0);
            TextView textView3 = (TextView) inflate.findViewById(f.tv_files_dialog_copying);
            textView3.setTypeface(aVar.x());
            textView3.setText(str);
            TextView textView4 = (TextView) inflate.findViewById(f.tv_percentage_dialog_copying);
            textView4.setTypeface(aVar.x());
            textView4.setText(getString(i10) + getString(i.percentage));
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(inflate);
            builder.setCancelable(false);
            if (!isFinishing()) {
                t0(builder.create());
                AlertDialog R4 = R();
                t.b(R4);
                Window window = R4.getWindow();
                if (window != null) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                }
                AlertDialog R5 = R();
                t.b(R5);
                R5.show();
                return;
            }
            return;
        }
        AlertDialog R6 = R();
        t.b(R6);
        TextView textView5 = (TextView) R6.findViewById(f.tv_title_dialog_copying);
        if (textView5 != null) {
            textView5.setText(getString(i.copying, new Object[]{getString(i.size_of_total_size, new Object[]{String.valueOf(i5), String.valueOf(i6)})}));
        }
        AlertDialog R7 = R();
        t.b(R7);
        TextView textView6 = (TextView) R7.findViewById(f.tv_files_dialog_copying);
        if (textView6 != null) {
            textView6.setTypeface(k.f32g.x());
            textView6.setText(str);
        }
    }

    /* access modifiers changed from: private */
    public final void H4(File file) {
        Uri uriForFile = FileProvider.getUriForFile(this, getApplicationContext().getPackageName() + ".provider", file);
        t.b(uriForFile);
        e5(uriForFile);
    }

    /* access modifiers changed from: private */
    public final void I3(String str) {
        C2908y0 unused = C2876i.d(w3.N.a(C2865c0.b()), (C2312i) null, (w3.O) null, new C2326j(this, new kotlin.jvm.internal.I(), str, (C2308e) null), 3, (Object) null);
    }

    private final void I4() {
        C2908y0 unused = C2876i.d(w3.N.a(C2865c0.b()), (C2312i) null, (w3.O) null, new H(this, (C2308e) null), 3, (Object) null);
    }

    private final void J3() {
        this.f20876o0 = true;
        C2908y0 unused = C2876i.d(w3.N.a(C2865c0.b()), (C2312i) null, (w3.O) null, new C2327k(this, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0066, code lost:
        if (w3.C2872g.g(r7, r4, r0) != r1) goto L_0x0069;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object J4(b3.C2308e r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.uptodown.core.activities.FileExplorerActivity.I
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.uptodown.core.activities.FileExplorerActivity$I r0 = (com.uptodown.core.activities.FileExplorerActivity.I) r0
            int r1 = r0.f20905d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f20905d = r1
            goto L_0x0018
        L_0x0013:
            com.uptodown.core.activities.FileExplorerActivity$I r0 = new com.uptodown.core.activities.FileExplorerActivity$I
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f20903b
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f20905d
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            W2.u.b(r7)
            goto L_0x0069
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0035:
            java.lang.Object r2 = r0.f20902a
            com.uptodown.core.activities.FileExplorerActivity r2 = (com.uptodown.core.activities.FileExplorerActivity) r2
            W2.u.b(r7)
            goto L_0x0055
        L_0x003d:
            W2.u.b(r7)
            w3.I r7 = w3.C2865c0.b()
            com.uptodown.core.activities.FileExplorerActivity$J r2 = new com.uptodown.core.activities.FileExplorerActivity$J
            r2.<init>(r6, r5)
            r0.f20902a = r6
            r0.f20905d = r4
            java.lang.Object r7 = w3.C2872g.g(r7, r2, r0)
            if (r7 != r1) goto L_0x0054
            goto L_0x0068
        L_0x0054:
            r2 = r6
        L_0x0055:
            w3.I0 r7 = w3.C2865c0.c()
            com.uptodown.core.activities.FileExplorerActivity$K r4 = new com.uptodown.core.activities.FileExplorerActivity$K
            r4.<init>(r2, r5)
            r0.f20902a = r5
            r0.f20905d = r3
            java.lang.Object r7 = w3.C2872g.g(r7, r4, r0)
            if (r7 != r1) goto L_0x0069
        L_0x0068:
            return r1
        L_0x0069:
            W2.J r7 = W2.J.f19942a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.J4(b3.e):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0066, code lost:
        if (w3.C2872g.g(r7, r4, r0) != r1) goto L_0x0069;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object K3(b3.C2308e r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.uptodown.core.activities.FileExplorerActivity.C2328l
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.uptodown.core.activities.FileExplorerActivity$l r0 = (com.uptodown.core.activities.FileExplorerActivity.C2328l) r0
            int r1 = r0.f20965d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f20965d = r1
            goto L_0x0018
        L_0x0013:
            com.uptodown.core.activities.FileExplorerActivity$l r0 = new com.uptodown.core.activities.FileExplorerActivity$l
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f20963b
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f20965d
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            W2.u.b(r7)
            goto L_0x0069
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0035:
            java.lang.Object r2 = r0.f20962a
            com.uptodown.core.activities.FileExplorerActivity r2 = (com.uptodown.core.activities.FileExplorerActivity) r2
            W2.u.b(r7)
            goto L_0x0055
        L_0x003d:
            W2.u.b(r7)
            w3.I r7 = w3.C2865c0.b()
            com.uptodown.core.activities.FileExplorerActivity$m r2 = new com.uptodown.core.activities.FileExplorerActivity$m
            r2.<init>(r6, r5)
            r0.f20962a = r6
            r0.f20965d = r4
            java.lang.Object r7 = w3.C2872g.g(r7, r2, r0)
            if (r7 != r1) goto L_0x0054
            goto L_0x0068
        L_0x0054:
            r2 = r6
        L_0x0055:
            w3.I0 r7 = w3.C2865c0.c()
            com.uptodown.core.activities.FileExplorerActivity$n r4 = new com.uptodown.core.activities.FileExplorerActivity$n
            r4.<init>(r2, r5)
            r0.f20962a = r5
            r0.f20965d = r3
            java.lang.Object r7 = w3.C2872g.g(r7, r4, r0)
            if (r7 != r1) goto L_0x0069
        L_0x0068:
            return r1
        L_0x0069:
            W2.J r7 = W2.J.f19942a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.K3(b3.e):java.lang.Object");
    }

    private final void K4() {
        if (this.f20871X != null) {
            ArrayList arrayList = this.f20875n0;
            t.b(arrayList);
            File file = this.f20871X;
            t.b(file);
            new C2209b(arrayList, file, this.f20883v0, this.f20876o0, this);
            return;
        }
        if (this.f20867T != null) {
            ArrayList arrayList2 = this.f20875n0;
            t.b(arrayList2);
            DocumentFile documentFile = this.f20867T;
            t.b(documentFile);
            new C2209b(arrayList2, documentFile, this.f20883v0, this.f20876o0, this);
        }
    }

    private final C2908y0 L3(DocumentFile documentFile, Uri uri, C2228e eVar) {
        return C2876i.d(w3.N.a(C2865c0.b()), (C2312i) null, (w3.O) null, new C2334r(documentFile, uri, eVar, this, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void L4(FileExplorerActivity fileExplorerActivity, ActivityResult activityResult) {
        String str;
        Uri uri;
        Bundle extras;
        if (activityResult.getResultCode() == 145) {
            Intent data = activityResult.getData();
            TextView textView = null;
            if (data == null || (extras = data.getExtras()) == null) {
                str = null;
            } else {
                str = extras.getString("path_selected");
            }
            fileExplorerActivity.f20881t0 = str;
            if (str != null) {
                fileExplorerActivity.f20880s0 = null;
                TextView textView2 = fileExplorerActivity.f20853F;
                if (textView2 == null) {
                    t.w("tvSelectedPath");
                } else {
                    textView = textView2;
                }
                textView.setText(fileExplorerActivity.f20881t0);
                return;
            }
            Intent data2 = activityResult.getData();
            if (data2 != null) {
                uri = data2.getData();
            } else {
                uri = null;
            }
            if (uri != null) {
                fileExplorerActivity.f20880s0 = uri;
                fileExplorerActivity.f20881t0 = null;
                String lastPathSegment = uri.getLastPathSegment();
                t.b(lastPathSegment);
                String substring = lastPathSegment.substring(s.l0(lastPathSegment, ":", 0, false, 6, (Object) null) + 1);
                t.d(substring, "substring(...)");
                TextView textView3 = fileExplorerActivity.f20853F;
                if (textView3 == null) {
                    t.w("tvSelectedPath");
                } else {
                    textView = textView3;
                }
                textView.setText(fileExplorerActivity.getString(i.sd_card) + '/' + substring);
            }
        }
    }

    private final C2908y0 M3(DocumentFile documentFile, String str, C2228e eVar) {
        return C2876i.d(w3.N.a(C2865c0.b()), (C2312i) null, (w3.O) null, new C2333q(documentFile, str, eVar, this, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void M4() {
        LinearLayout linearLayout = this.f20850C;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            t.w("llBreadcrumb");
            linearLayout = null;
        }
        if (linearLayout.getChildCount() > 1) {
            LinearLayout linearLayout3 = this.f20850C;
            if (linearLayout3 == null) {
                t.w("llBreadcrumb");
                linearLayout3 = null;
            }
            LinearLayout linearLayout4 = this.f20850C;
            if (linearLayout4 == null) {
                t.w("llBreadcrumb");
            } else {
                linearLayout2 = linearLayout4;
            }
            linearLayout3.removeViewAt(linearLayout2.getChildCount() - 1);
        }
    }

    private final C2908y0 N3(File file, Uri uri, C2228e eVar) {
        return C2876i.d(w3.N.a(C2865c0.b()), (C2312i) null, (w3.O) null, new C2332p(file, uri, eVar, this, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void N4() {
        LinearLayout linearLayout = this.f20850C;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            t.w("llBreadcrumb");
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        LayoutInflater layoutInflater = getLayoutInflater();
        int i5 = g.breadcrumb_main;
        LinearLayout linearLayout3 = this.f20850C;
        if (linearLayout3 == null) {
            t.w("llBreadcrumb");
            linearLayout3 = null;
        }
        View inflate = layoutInflater.inflate(i5, linearLayout3, false);
        t.c(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout4 = (LinearLayout) inflate;
        TextView textView = (TextView) linearLayout4.findViewById(f.tv_main_path);
        if (this.f20873Z) {
            textView.setText(getString(i.sd_card));
        } else {
            textView.setText(getString(i.internal_storage));
        }
        textView.setTypeface(k.f32g.x());
        LinearLayout linearLayout5 = this.f20850C;
        if (linearLayout5 == null) {
            t.w("llBreadcrumb");
        } else {
            linearLayout2 = linearLayout5;
        }
        linearLayout2.addView(linearLayout4);
    }

    private final C2908y0 O3(File file, String str, C2228e eVar) {
        return C2876i.d(w3.N.a(C2865c0.b()), (C2312i) null, (w3.O) null, new C2331o(file, str, eVar, this, (C2308e) null), 3, (Object) null);
    }

    private final void O4() {
        Intent intent = new Intent();
        DocumentFile documentFile = this.f20867T;
        if (documentFile != null) {
            t.b(documentFile);
            if (documentFile.canWrite()) {
                DocumentFile documentFile2 = this.f20867T;
                t.b(documentFile2);
                intent.setData(documentFile2.getUri());
            } else {
                g5();
                return;
            }
        } else {
            File file = this.f20871X;
            t.b(file);
            if (file.canWrite()) {
                File file2 = this.f20871X;
                t.b(file2);
                t.b(intent.putExtra("path_selected", file2.getAbsolutePath()));
            } else {
                g5();
                return;
            }
        }
        intent.putExtra("sdcard_selected", this.f20873Z);
        setResult(145, intent);
        finish();
    }

    private final void P3() {
        C2908y0 unused = C2876i.d(w3.N.a(C2865c0.b()), (C2312i) null, (w3.O) null, new C2335s(this, (C2308e) null), 3, (Object) null);
    }

    private final void P4() {
        new Handler(Looper.getMainLooper()).post(new T1.G(this));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x009b, code lost:
        if (w3.C2872g.g(r9, r5, r0) != r1) goto L_0x009e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object Q3(b3.C2308e r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.uptodown.core.activities.FileExplorerActivity.C2336t
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.uptodown.core.activities.FileExplorerActivity$t r0 = (com.uptodown.core.activities.FileExplorerActivity.C2336t) r0
            int r1 = r0.f21004e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f21004e = r1
            goto L_0x0018
        L_0x0013:
            com.uptodown.core.activities.FileExplorerActivity$t r0 = new com.uptodown.core.activities.FileExplorerActivity$t
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f21002c
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f21004e
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0051
            if (r2 == r5) goto L_0x0045
            if (r2 == r4) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            W2.u.b(r9)
            goto L_0x009e
        L_0x0031:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0039:
            java.lang.Object r2 = r0.f21001b
            kotlin.jvm.internal.J r2 = (kotlin.jvm.internal.J) r2
            java.lang.Object r4 = r0.f21000a
            com.uptodown.core.activities.FileExplorerActivity r4 = (com.uptodown.core.activities.FileExplorerActivity) r4
            W2.u.b(r9)
            goto L_0x0088
        L_0x0045:
            java.lang.Object r2 = r0.f21001b
            kotlin.jvm.internal.J r2 = (kotlin.jvm.internal.J) r2
            java.lang.Object r5 = r0.f21000a
            com.uptodown.core.activities.FileExplorerActivity r5 = (com.uptodown.core.activities.FileExplorerActivity) r5
            W2.u.b(r9)
            goto L_0x0071
        L_0x0051:
            W2.u.b(r9)
            kotlin.jvm.internal.J r9 = new kotlin.jvm.internal.J
            r9.<init>()
            w3.I0 r2 = w3.C2865c0.c()
            com.uptodown.core.activities.FileExplorerActivity$u r7 = new com.uptodown.core.activities.FileExplorerActivity$u
            r7.<init>(r8, r6)
            r0.f21000a = r8
            r0.f21001b = r9
            r0.f21004e = r5
            java.lang.Object r2 = w3.C2872g.g(r2, r7, r0)
            if (r2 != r1) goto L_0x006f
            goto L_0x009d
        L_0x006f:
            r5 = r8
            r2 = r9
        L_0x0071:
            w3.I r9 = w3.C2865c0.b()
            com.uptodown.core.activities.FileExplorerActivity$v r7 = new com.uptodown.core.activities.FileExplorerActivity$v
            r7.<init>(r5, r2, r6)
            r0.f21000a = r5
            r0.f21001b = r2
            r0.f21004e = r4
            java.lang.Object r9 = w3.C2872g.g(r9, r7, r0)
            if (r9 != r1) goto L_0x0087
            goto L_0x009d
        L_0x0087:
            r4 = r5
        L_0x0088:
            w3.I0 r9 = w3.C2865c0.c()
            com.uptodown.core.activities.FileExplorerActivity$w r5 = new com.uptodown.core.activities.FileExplorerActivity$w
            r5.<init>(r4, r2, r6)
            r0.f21000a = r6
            r0.f21001b = r6
            r0.f21004e = r3
            java.lang.Object r9 = w3.C2872g.g(r9, r5, r0)
            if (r9 != r1) goto L_0x009e
        L_0x009d:
            return r1
        L_0x009e:
            W2.J r9 = W2.J.f19942a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.Q3(b3.e):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final void Q4(FileExplorerActivity fileExplorerActivity) {
        HorizontalScrollView horizontalScrollView = fileExplorerActivity.f20851D;
        LinearLayout linearLayout = null;
        if (horizontalScrollView == null) {
            t.w("svBreadcrumb");
            horizontalScrollView = null;
        }
        LinearLayout linearLayout2 = fileExplorerActivity.f20850C;
        if (linearLayout2 == null) {
            t.w("llBreadcrumb");
            linearLayout2 = null;
        }
        int right = linearLayout2.getRight();
        LinearLayout linearLayout3 = fileExplorerActivity.f20850C;
        if (linearLayout3 == null) {
            t.w("llBreadcrumb");
        } else {
            linearLayout = linearLayout3;
        }
        horizontalScrollView.scrollTo(right, linearLayout.getTop());
    }

    private final void R3() {
        EditText editText;
        AlertDialog alertDialog;
        if (!isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            LayoutInflater layoutInflater = getLayoutInflater();
            t.d(layoutInflater, "getLayoutInflater(...)");
            View inflate = layoutInflater.inflate(g.dialog_compress_files, (ViewGroup) null, false);
            k.a aVar = k.f32g;
            ((TextView) inflate.findViewById(f.tv_dialog_title_compress)).setTypeface(aVar.w());
            TextView textView = (TextView) inflate.findViewById(f.tv_dialog_file_name_compress);
            textView.setTypeface(aVar.x());
            RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(f.rl_dialog_file_name_compress);
            EditText editText2 = (EditText) inflate.findViewById(f.et_dialog_file_name_compress);
            editText2.setTypeface(aVar.x());
            TextView textView2 = (TextView) inflate.findViewById(f.tv_dialog_file_name_extension);
            textView2.setTypeface(aVar.x());
            textView2.setText(".zip");
            ((TextView) inflate.findViewById(f.tv_dialog_selected_files_title)).setTypeface(aVar.x());
            TextView textView3 = (TextView) inflate.findViewById(f.tv_dialog_selected_files);
            textView3.setTypeface(aVar.x());
            TextView textView4 = (TextView) inflate.findViewById(f.tv_progress_count_files);
            textView4.setTypeface(aVar.w());
            TextView textView5 = (TextView) inflate.findViewById(f.tv_accept_option_compress);
            textView5.setTypeface(aVar.w());
            TextView textView6 = (TextView) inflate.findViewById(f.tv_cancel_option_compress);
            textView6.setTypeface(aVar.w());
            ProgressBar progressBar = (ProgressBar) inflate.findViewById(f.pb_dialog_compress);
            C2206b bVar = this.f20864Q;
            t.b(bVar);
            ArrayList b5 = bVar.b();
            ArrayList arrayList = new ArrayList();
            if (!b5.isEmpty()) {
                Iterator it = b5.iterator();
                t.d(it, "iterator(...)");
                String str = "";
                while (it.hasNext()) {
                    Object next = it.next();
                    EditText editText3 = editText2;
                    t.d(next, "next(...)");
                    if (next instanceof File) {
                        str = str + ((File) next).getName() + 10;
                        arrayList.add(next);
                    } else if (next instanceof DocumentFile) {
                        str = str + ((DocumentFile) next).getName() + 10;
                    }
                    editText2 = editText3;
                }
                editText = editText2;
                textView3.setText(str);
            } else {
                editText = editText2;
            }
            kotlin.jvm.internal.L l5 = new kotlin.jvm.internal.L();
            TextView textView7 = textView4;
            EditText editText4 = editText;
            C2340x xVar = new C2340x(progressBar, textView7, editText4, this, textView5, textView, relativeLayout, textView6);
            EditText editText5 = editText4;
            TextView textView8 = textView5;
            kotlin.jvm.internal.L l6 = l5;
            textView8.setOnClickListener(new T1.H(editText5, b5, this, arrayList, l6, xVar));
            textView6.setOnClickListener(new T1.I(l6, this));
            builder.setView(inflate);
            this.f20861N = builder.create();
            if (!isFinishing() && (alertDialog = this.f20861N) != null) {
                t.b(alertDialog);
                Window window = alertDialog.getWindow();
                if (window != null) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                }
                AlertDialog alertDialog2 = this.f20861N;
                t.b(alertDialog2);
                alertDialog2.show();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void R4(String str) {
        CharSequence charSequence;
        boolean r5 = new C2201a(this).r();
        if (str == null) {
            SearchView searchView = this.f20855H;
            if (searchView != null) {
                charSequence = searchView.getQuery();
            } else {
                charSequence = null;
            }
            str = String.valueOf(charSequence);
        }
        if (str.length() <= 0 && r5) {
            ArrayList arrayList = this.f20869V;
            if (arrayList != null) {
                this.f20870W = arrayList;
                return;
            }
            ArrayList arrayList2 = this.f20865R;
            if (arrayList2 != null) {
                this.f20866S = arrayList2;
                return;
            }
            return;
        }
        ArrayList arrayList3 = this.f20869V;
        if (arrayList3 != null) {
            t.b(arrayList3);
            ArrayList arrayList4 = new ArrayList();
            int size = arrayList3.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList3.get(i5);
                i5++;
                File file = (File) obj;
                String name = file.getName();
                t.d(name, "getName(...)");
                if (s.T(name, str, true)) {
                    if (!r5) {
                        String name2 = file.getName();
                        t.d(name2, "getName(...)");
                        if (s.P(name2, ".", false, 2, (Object) null)) {
                        }
                    }
                    arrayList4.add(obj);
                }
            }
            this.f20870W = arrayList4;
            return;
        }
        ArrayList arrayList5 = this.f20865R;
        if (arrayList5 != null) {
            t.b(arrayList5);
            ArrayList arrayList6 = new ArrayList();
            int size2 = arrayList5.size();
            int i6 = 0;
            while (i6 < size2) {
                Object obj2 = arrayList5.get(i6);
                i6++;
                DocumentFile documentFile = (DocumentFile) obj2;
                String name3 = documentFile.getName();
                t.b(name3);
                if (s.T(name3, str, true)) {
                    if (!r5) {
                        String name4 = documentFile.getName();
                        t.b(name4);
                        if (s.P(name4, ".", false, 2, (Object) null)) {
                        }
                    }
                    arrayList6.add(obj2);
                }
            }
            this.f20866S = arrayList6;
        }
    }

    /* access modifiers changed from: private */
    public static final void S3(EditText editText, ArrayList arrayList, FileExplorerActivity fileExplorerActivity, ArrayList arrayList2, kotlin.jvm.internal.L l5, C2340x xVar, View view) {
        String str;
        EditText editText2 = editText;
        FileExplorerActivity fileExplorerActivity2 = fileExplorerActivity;
        ArrayList arrayList3 = arrayList2;
        kotlin.jvm.internal.L l6 = l5;
        C2340x xVar2 = xVar;
        if (editText2.getText().toString().length() <= 0) {
            String string = fileExplorerActivity2.getString(i.core_compress_dialog_file_name_empty);
            t.d(string, "getString(...)");
            fileExplorerActivity2.u0(string);
        } else if (!arrayList.isEmpty()) {
            File file = fileExplorerActivity2.f20871X;
            long j5 = 0;
            if (file != null) {
                t.b(file);
                long usableSpace = file.getUsableSpace();
                int size = arrayList3.size();
                int i5 = 0;
                while (i5 < size) {
                    Object obj = arrayList3.get(i5);
                    i5++;
                    j5 += ((File) obj).length();
                }
                if (usableSpace > j5 * ((long) 2)) {
                    StringBuilder sb = new StringBuilder();
                    File file2 = fileExplorerActivity2.f20871X;
                    if (file2 != null) {
                        str = file2.getAbsolutePath();
                    } else {
                        str = null;
                    }
                    sb.append(str);
                    sb.append('/');
                    sb.append(editText2.getText());
                    sb.append(".zip");
                    File file3 = new File(sb.toString());
                    if (!file3.exists()) {
                        k.f32g.d(fileExplorerActivity2, editText2);
                        l6.f24690a = fileExplorerActivity2.B3(arrayList3, file3, xVar2);
                        return;
                    }
                    String string2 = fileExplorerActivity2.getString(i.core_compress_dialog_file_name_already_exists, new Object[]{editText2.getText()});
                    t.d(string2, "getString(...)");
                    fileExplorerActivity2.u0(string2);
                    return;
                }
                String string3 = fileExplorerActivity2.getString(i.error_not_enough_space);
                t.d(string3, "getString(...)");
                fileExplorerActivity2.u0(string3);
            } else if (fileExplorerActivity2.f20867T != null) {
                ArrayList arrayList4 = new ArrayList();
                Iterator it = arrayList.iterator();
                t.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    t.d(next, "next(...)");
                    if (next instanceof DocumentFile) {
                        arrayList4.add(next);
                    }
                }
                C2290j jVar = new C2290j();
                Context applicationContext = fileExplorerActivity2.getApplicationContext();
                t.d(applicationContext, "getApplicationContext(...)");
                DocumentFile documentFile = fileExplorerActivity2.f20867T;
                t.b(documentFile);
                long l7 = jVar.l(applicationContext, documentFile);
                int size2 = arrayList4.size();
                int i6 = 0;
                while (i6 < size2) {
                    Object obj2 = arrayList4.get(i6);
                    i6++;
                    j5 += ((DocumentFile) obj2).length();
                }
                if (l7 > j5 * ((long) 2)) {
                    String str2 = editText2.getText() + ".zip";
                    DocumentFile documentFile2 = fileExplorerActivity2.f20867T;
                    t.b(documentFile2);
                    DocumentFile[] listFiles = documentFile2.listFiles();
                    t.d(listFiles, "listFiles(...)");
                    boolean z4 = false;
                    for (DocumentFile name : listFiles) {
                        if (t.a(name.getName(), str2)) {
                            String string4 = fileExplorerActivity2.getString(i.core_compress_dialog_file_name_already_exists, new Object[]{editText2.getText()});
                            t.d(string4, "getString(...)");
                            fileExplorerActivity2.u0(string4);
                            z4 = true;
                        }
                    }
                    if (!z4) {
                        k.f32g.d(fileExplorerActivity2, editText2);
                        DocumentFile documentFile3 = fileExplorerActivity2.f20867T;
                        t.b(documentFile3);
                        DocumentFile createFile = documentFile3.createFile(new C2290j().i(str2), str2);
                        t.b(createFile);
                        l6.f24690a = fileExplorerActivity2.A3(arrayList4, createFile, xVar2);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void S4() {
        String str;
        DocumentFile documentFile = this.f20867T;
        RecyclerView recyclerView = null;
        if (documentFile != null) {
            t.b(documentFile);
            String lastPathSegment = documentFile.getUri().getLastPathSegment();
            if (lastPathSegment != null) {
                str = lastPathSegment.substring(s.l0(lastPathSegment, ":", 0, false, 6, (Object) null) + 1);
                t.d(str, "substring(...)");
            } else {
                str = "";
            }
            if (!this.f20873Z) {
                TextView textView = this.f20885x;
                if (textView == null) {
                    t.w("tvBreadCrumb");
                    textView = null;
                }
                textView.setText(getString(i.internal_storage) + '/' + str);
            } else if (str.length() == 0) {
                TextView textView2 = this.f20885x;
                if (textView2 == null) {
                    t.w("tvBreadCrumb");
                    textView2 = null;
                }
                textView2.setText(getString(i.sd_card));
            } else {
                q3();
            }
        } else {
            File file = this.f20871X;
            if (file != null) {
                if (t.a(file, Environment.getExternalStorageDirectory())) {
                    TextView textView3 = this.f20885x;
                    if (textView3 == null) {
                        t.w("tvBreadCrumb");
                        textView3 = null;
                    }
                    textView3.setText(getString(i.internal_storage));
                } else {
                    r3();
                }
            }
        }
        if (this.f20864Q == null) {
            this.f20864Q = new C2206b(this.f20882u0);
            RecyclerView recyclerView2 = this.f20889z;
            if (recyclerView2 == null) {
                t.w("rvFiles");
            } else {
                recyclerView = recyclerView2;
            }
            recyclerView.setAdapter(this.f20864Q);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f20866S;
        if (arrayList2 != null) {
            t.b(arrayList2);
            arrayList.addAll(arrayList2);
        } else {
            ArrayList arrayList3 = this.f20870W;
            if (arrayList3 != null) {
                t.b(arrayList3);
                arrayList.addAll(arrayList3);
            }
        }
        C2206b bVar = this.f20864Q;
        t.b(bVar);
        bVar.f(arrayList);
    }

    /* access modifiers changed from: private */
    public static final void T3(kotlin.jvm.internal.L l5, FileExplorerActivity fileExplorerActivity, View view) {
        C2908y0 y0Var = (C2908y0) l5.f24690a;
        if (y0Var != null) {
            C2908y0.a.a(y0Var, (CancellationException) null, 1, (Object) null);
        }
        AlertDialog alertDialog = fileExplorerActivity.f20861N;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public final void T4() {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            this.f20871X = externalStorageDirectory;
            this.f20867T = null;
        }
    }

    private final void U3() {
        AlertDialog alertDialog;
        if (!isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            LayoutInflater layoutInflater = getLayoutInflater();
            t.d(layoutInflater, "getLayoutInflater(...)");
            View inflate = layoutInflater.inflate(g.dialog_create, (ViewGroup) null, false);
            k.a aVar = k.f32g;
            ((TextView) inflate.findViewById(f.tv_dialog_title_create)).setTypeface(aVar.w());
            ((TextView) inflate.findViewById(f.tv_dialog_file_name_create)).setTypeface(aVar.x());
            EditText editText = (EditText) inflate.findViewById(f.et_dialog_file_name_create);
            editText.setTypeface(aVar.x());
            TextView textView = (TextView) inflate.findViewById(f.tv_accept_option_create);
            textView.setTypeface(aVar.w());
            TextView textView2 = (TextView) inflate.findViewById(f.tv_cancel_option_create);
            textView2.setTypeface(aVar.w());
            textView.setOnClickListener(new C2152A(editText, this));
            textView2.setOnClickListener(new C2153B(this));
            builder.setView(inflate);
            this.f20861N = builder.create();
            if (!isFinishing() && (alertDialog = this.f20861N) != null) {
                t.b(alertDialog);
                Window window = alertDialog.getWindow();
                if (window != null) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                }
                AlertDialog alertDialog2 = this.f20861N;
                t.b(alertDialog2);
                alertDialog2.show();
            }
        }
    }

    private final void U4() {
        int i5;
        Menu menu;
        MenuItem findItem;
        Menu menu2;
        MenuItem findItem2;
        Menu menu3;
        MenuItem findItem3;
        Menu menu4;
        MenuItem findItem4;
        Menu menu5;
        MenuItem findItem5;
        Menu menu6;
        MenuItem findItem6;
        Menu menu7;
        MenuItem findItem7;
        Menu menu8;
        MenuItem findItem8;
        C2206b bVar = this.f20864Q;
        if (bVar != null) {
            t.b(bVar);
            i5 = bVar.a();
        } else {
            i5 = 0;
        }
        if (i5 > 0) {
            Toolbar toolbar = this.f20862O;
            if (!(toolbar == null || (menu8 = toolbar.getMenu()) == null || (findItem8 = menu8.findItem(f.action_delete)) == null)) {
                findItem8.setEnabled(true);
            }
            Toolbar toolbar2 = this.f20862O;
            if (!(toolbar2 == null || (menu7 = toolbar2.getMenu()) == null || (findItem7 = menu7.findItem(f.action_copy)) == null)) {
                findItem7.setEnabled(true);
            }
            Toolbar toolbar3 = this.f20862O;
            if (!(toolbar3 == null || (menu6 = toolbar3.getMenu()) == null || (findItem6 = menu6.findItem(f.action_cut)) == null)) {
                findItem6.setEnabled(true);
            }
            Toolbar toolbar4 = this.f20862O;
            if (!(toolbar4 == null || (menu5 = toolbar4.getMenu()) == null || (findItem5 = menu5.findItem(f.action_compress)) == null)) {
                findItem5.setEnabled(true);
            }
        } else {
            Toolbar toolbar5 = this.f20862O;
            if (!(toolbar5 == null || (menu4 = toolbar5.getMenu()) == null || (findItem4 = menu4.findItem(f.action_delete)) == null)) {
                findItem4.setEnabled(false);
            }
            Toolbar toolbar6 = this.f20862O;
            if (!(toolbar6 == null || (menu3 = toolbar6.getMenu()) == null || (findItem3 = menu3.findItem(f.action_copy)) == null)) {
                findItem3.setEnabled(false);
            }
            Toolbar toolbar7 = this.f20862O;
            if (!(toolbar7 == null || (menu2 = toolbar7.getMenu()) == null || (findItem2 = menu2.findItem(f.action_cut)) == null)) {
                findItem2.setEnabled(false);
            }
            Toolbar toolbar8 = this.f20862O;
            if (!(toolbar8 == null || (menu = toolbar8.getMenu()) == null || (findItem = menu.findItem(f.action_compress)) == null)) {
                findItem.setEnabled(false);
            }
        }
        TextView textView = this.f20863P;
        if (textView != null) {
            textView.setText(getString(i.core_x_items_selected, new Object[]{String.valueOf(i5)}));
        }
    }

    /* access modifiers changed from: private */
    public static final void V3(EditText editText, FileExplorerActivity fileExplorerActivity, View view) {
        if (editText.getText().toString().length() > 0) {
            C2908y0 unused = C2876i.d(w3.N.a(C2865c0.b()), (C2312i) null, (w3.O) null, new C2341y(fileExplorerActivity, editText, (C2308e) null), 3, (Object) null);
            return;
        }
        String string = fileExplorerActivity.getString(i.core_compress_dialog_file_name_empty);
        t.d(string, "getString(...)");
        fileExplorerActivity.u0(string);
    }

    private final void V4() {
        if (!this.f20872Y) {
            RadioButton radioButton = this.f20860M;
            t.b(radioButton);
            radioButton.setBackground(ContextCompat.getDrawable(this, e.core_vector_sort_date_asc_on));
            RadioButton radioButton2 = this.f20859L;
            t.b(radioButton2);
            radioButton2.setBackground(ContextCompat.getDrawable(this, e.core_vector_sort_size_asc_off));
            RadioButton radioButton3 = this.f20858K;
            t.b(radioButton3);
            radioButton3.setBackground(ContextCompat.getDrawable(this, e.core_vector_sort_az_asc_off));
            return;
        }
        RadioButton radioButton4 = this.f20860M;
        t.b(radioButton4);
        radioButton4.setBackground(ContextCompat.getDrawable(this, e.core_vector_sort_date_desc_on));
        RadioButton radioButton5 = this.f20859L;
        t.b(radioButton5);
        radioButton5.setBackground(ContextCompat.getDrawable(this, e.core_vector_sort_size_desc_off));
        RadioButton radioButton6 = this.f20858K;
        t.b(radioButton6);
        radioButton6.setBackground(ContextCompat.getDrawable(this, e.core_vector_sort_az_desc_off));
    }

    /* access modifiers changed from: private */
    public static final void W3(FileExplorerActivity fileExplorerActivity, View view) {
        AlertDialog alertDialog = fileExplorerActivity.f20861N;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    private final void W4() {
        if (!this.f20872Y) {
            RadioButton radioButton = this.f20858K;
            t.b(radioButton);
            radioButton.setBackground(ContextCompat.getDrawable(this, e.core_vector_sort_az_asc_on));
            RadioButton radioButton2 = this.f20859L;
            t.b(radioButton2);
            radioButton2.setBackground(ContextCompat.getDrawable(this, e.core_vector_sort_size_asc_off));
            RadioButton radioButton3 = this.f20860M;
            t.b(radioButton3);
            radioButton3.setBackground(ContextCompat.getDrawable(this, e.core_vector_sort_date_asc_off));
            return;
        }
        RadioButton radioButton4 = this.f20858K;
        t.b(radioButton4);
        radioButton4.setBackground(ContextCompat.getDrawable(this, e.core_vector_sort_az_desc_on));
        RadioButton radioButton5 = this.f20859L;
        t.b(radioButton5);
        radioButton5.setBackground(ContextCompat.getDrawable(this, e.core_vector_sort_size_desc_off));
        RadioButton radioButton6 = this.f20860M;
        t.b(radioButton6);
        radioButton6.setBackground(ContextCompat.getDrawable(this, e.core_vector_sort_date_desc_off));
    }

    /* access modifiers changed from: private */
    public final void X3(Object obj) {
        AlertDialog alertDialog;
        String str;
        Object obj2 = obj;
        if (!isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            LayoutInflater layoutInflater = getLayoutInflater();
            t.d(layoutInflater, "getLayoutInflater(...)");
            TextView textView = null;
            View inflate = layoutInflater.inflate(g.dialog_decompress_file, (ViewGroup) null, false);
            k.a aVar = k.f32g;
            ((TextView) inflate.findViewById(f.tv_dialog_title_decompress)).setTypeface(aVar.w());
            TextView textView2 = (TextView) inflate.findViewById(f.tv_dialog_file_name_decompress);
            textView2.setTypeface(aVar.x());
            RadioButton radioButton = (RadioButton) inflate.findViewById(f.rb_dialog_decompress_current_path);
            radioButton.setTypeface(aVar.x());
            RadioButton radioButton2 = (RadioButton) inflate.findViewById(f.rb_dialog_decompress_select_path);
            radioButton2.setTypeface(aVar.x());
            TextView textView3 = (TextView) inflate.findViewById(f.tv_dialog_decompress_selected_path);
            this.f20853F = textView3;
            if (textView3 == null) {
                t.w("tvSelectedPath");
                textView3 = null;
            }
            textView3.setTypeface(aVar.x());
            kotlin.jvm.internal.L l5 = new kotlin.jvm.internal.L();
            if (obj2 instanceof File) {
                l5.f24690a = ((File) obj2).getParent();
            } else if (obj2 instanceof DocumentFile) {
                DocumentFile documentFile = this.f20867T;
                t.b(documentFile);
                String lastPathSegment = documentFile.getUri().getLastPathSegment();
                if (lastPathSegment != null) {
                    DocumentFile documentFile2 = this.f20867T;
                    t.b(documentFile2);
                    String lastPathSegment2 = documentFile2.getUri().getLastPathSegment();
                    t.b(lastPathSegment2);
                    str = lastPathSegment.substring(s.l0(lastPathSegment2, ":", 0, false, 6, (Object) null) + 1);
                    t.d(str, "substring(...)");
                } else {
                    str = null;
                }
                l5.f24690a = getString(i.sd_card) + '/' + str;
            }
            TextView textView4 = this.f20853F;
            if (textView4 == null) {
                t.w("tvSelectedPath");
                textView4 = null;
            }
            textView4.setText((CharSequence) l5.f24690a);
            this.f20881t0 = (String) l5.f24690a;
            TextView textView5 = (TextView) inflate.findViewById(f.tv_accept_option_compress);
            textView5.setTypeface(aVar.w());
            TextView textView6 = (TextView) inflate.findViewById(f.tv_cancel_option_decompress);
            textView6.setTypeface(aVar.w());
            ProgressBar progressBar = (ProgressBar) inflate.findViewById(f.pb_dialog_decompress);
            TextView textView7 = this.f20853F;
            if (textView7 == null) {
                t.w("tvSelectedPath");
            } else {
                textView = textView7;
            }
            textView.setOnClickListener(new T1.W(this));
            radioButton.setOnCheckedChangeListener(new T1.X(this, l5));
            radioButton2.setOnCheckedChangeListener(new T1.Y(this));
            kotlin.jvm.internal.L l6 = new kotlin.jvm.internal.L();
            View view = inflate;
            TextView textView8 = textView5;
            TextView textView9 = textView6;
            textView8.setOnClickListener(new T1.Z(obj2, this, l6, new C2342z(textView2, this, view, progressBar, textView8, textView9)));
            textView9.setOnClickListener(new C2158a0(l6, this));
            builder.setView(view);
            this.f20861N = builder.create();
            if (!isFinishing() && (alertDialog = this.f20861N) != null) {
                t.b(alertDialog);
                Window window = alertDialog.getWindow();
                if (window != null) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                }
                AlertDialog alertDialog2 = this.f20861N;
                t.b(alertDialog2);
                alertDialog2.show();
            }
        }
    }

    private final void X4() {
        if (!this.f20872Y) {
            RadioButton radioButton = this.f20859L;
            t.b(radioButton);
            radioButton.setBackground(ContextCompat.getDrawable(this, e.core_vector_sort_size_asc_on));
            RadioButton radioButton2 = this.f20858K;
            t.b(radioButton2);
            radioButton2.setBackground(ContextCompat.getDrawable(this, e.core_vector_sort_az_asc_off));
            RadioButton radioButton3 = this.f20860M;
            t.b(radioButton3);
            radioButton3.setBackground(ContextCompat.getDrawable(this, e.core_vector_sort_date_asc_off));
            return;
        }
        RadioButton radioButton4 = this.f20859L;
        t.b(radioButton4);
        radioButton4.setBackground(ContextCompat.getDrawable(this, e.core_vector_sort_size_desc_on));
        RadioButton radioButton5 = this.f20858K;
        t.b(radioButton5);
        radioButton5.setBackground(ContextCompat.getDrawable(this, e.core_vector_sort_az_desc_off));
        RadioButton radioButton6 = this.f20860M;
        t.b(radioButton6);
        radioButton6.setBackground(ContextCompat.getDrawable(this, e.core_vector_sort_date_desc_off));
    }

    /* access modifiers changed from: private */
    public static final void Y3(FileExplorerActivity fileExplorerActivity, View view) {
        Intent intent = new Intent(fileExplorerActivity.getApplicationContext(), FileExplorerActivity.class);
        intent.putExtra("select_path", 1);
        fileExplorerActivity.f20888y0.launch(intent);
    }

    private final void Y4(boolean z4) {
        TextView textView = null;
        if (z4) {
            TextView textView2 = this.f20852E;
            if (textView2 == null) {
                t.w("tvEmptyDirectory");
                textView2 = null;
            }
            textView2.setText(getString(i.empty_directory));
        } else {
            TextView textView3 = this.f20852E;
            if (textView3 == null) {
                t.w("tvEmptyDirectory");
                textView3 = null;
            }
            textView3.setText(getString(i.no_permissions_directory));
        }
        TextView textView4 = this.f20852E;
        if (textView4 == null) {
            t.w("tvEmptyDirectory");
        } else {
            textView = textView4;
        }
        textView.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public static final void Z3(FileExplorerActivity fileExplorerActivity, kotlin.jvm.internal.L l5, CompoundButton compoundButton, boolean z4) {
        if (z4) {
            TextView textView = fileExplorerActivity.f20853F;
            TextView textView2 = null;
            if (textView == null) {
                t.w("tvSelectedPath");
                textView = null;
            }
            textView.setVisibility(8);
            TextView textView3 = fileExplorerActivity.f20853F;
            if (textView3 == null) {
                t.w("tvSelectedPath");
            } else {
                textView2 = textView3;
            }
            textView2.setText((CharSequence) l5.f24690a);
        }
    }

    /* access modifiers changed from: private */
    public final void Z4(String str) {
        int i5 = 0;
        if (str != null) {
            ArrayList arrayList = this.f20866S;
            if (arrayList != null) {
                t.b(arrayList);
                Iterator it = arrayList.iterator();
                t.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    t.d(next, "next(...)");
                    DocumentFile documentFile = (DocumentFile) next;
                    if (documentFile.getName() != null && s.E(documentFile.getName(), str, true)) {
                        break;
                    }
                    i5++;
                }
            } else {
                ArrayList arrayList2 = this.f20870W;
                if (arrayList2 != null) {
                    t.b(arrayList2);
                    Iterator it2 = arrayList2.iterator();
                    t.d(it2, "iterator(...)");
                    while (it2.hasNext()) {
                        Object next2 = it2.next();
                        t.d(next2, "next(...)");
                        if (s.E(((File) next2).getName(), str, true)) {
                            break;
                        }
                        i5++;
                    }
                }
            }
        }
        RecyclerView recyclerView = this.f20889z;
        if (recyclerView == null) {
            t.w("rvFiles");
            recyclerView = null;
        }
        recyclerView.scrollToPosition(i5);
    }

    /* access modifiers changed from: private */
    public static final void a4(FileExplorerActivity fileExplorerActivity, CompoundButton compoundButton, boolean z4) {
        if (z4) {
            TextView textView = fileExplorerActivity.f20853F;
            if (textView == null) {
                t.w("tvSelectedPath");
                textView = null;
            }
            textView.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public final void a5() {
        Toolbar toolbar;
        Menu menu;
        MenuItem findItem;
        Menu menu2;
        MenuItem findItem2;
        Menu menu3;
        MenuItem findItem3;
        Menu menu4;
        MenuItem findItem4;
        Menu menu5;
        MenuItem findItem5;
        Menu menu6;
        MenuItem findItem6;
        Toolbar toolbar2 = this.f20862O;
        if (!(toolbar2 == null || (menu6 = toolbar2.getMenu()) == null || (findItem6 = menu6.findItem(f.action_delete)) == null)) {
            findItem6.setVisible(true);
        }
        Toolbar toolbar3 = this.f20862O;
        if (!(toolbar3 == null || (menu5 = toolbar3.getMenu()) == null || (findItem5 = menu5.findItem(f.action_create)) == null)) {
            findItem5.setVisible(true);
        }
        Toolbar toolbar4 = this.f20862O;
        if (!(toolbar4 == null || (menu4 = toolbar4.getMenu()) == null || (findItem4 = menu4.findItem(f.action_copy)) == null)) {
            findItem4.setVisible(true);
        }
        Toolbar toolbar5 = this.f20862O;
        if (!(toolbar5 == null || (menu3 = toolbar5.getMenu()) == null || (findItem3 = menu3.findItem(f.action_compress)) == null)) {
            findItem3.setVisible(true);
        }
        Toolbar toolbar6 = this.f20862O;
        if (!(toolbar6 == null || (menu2 = toolbar6.getMenu()) == null || (findItem2 = menu2.findItem(f.action_cut)) == null)) {
            findItem2.setVisible(true);
        }
        U4();
        ArrayList arrayList = this.f20875n0;
        if (arrayList != null) {
            t.b(arrayList);
            if (!arrayList.isEmpty() && (toolbar = this.f20862O) != null && (menu = toolbar.getMenu()) != null && (findItem = menu.findItem(f.action_paste)) != null) {
                findItem.setVisible(true);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void b4(Object obj, FileExplorerActivity fileExplorerActivity, kotlin.jvm.internal.L l5, C2342z zVar, View view) {
        long j5;
        Long l6;
        if (obj instanceof File) {
            if (fileExplorerActivity.f20881t0 != null) {
                File file = fileExplorerActivity.f20871X;
                if (file != null) {
                    l6 = Long.valueOf(file.getUsableSpace());
                } else {
                    l6 = null;
                }
                t.b(l6);
                File file2 = (File) obj;
                if (l6.longValue() > file2.length() * ((long) 2)) {
                    String str = fileExplorerActivity.f20881t0;
                    t.b(str);
                    l5.f24690a = fileExplorerActivity.O3(file2, str, zVar);
                }
            } else if (fileExplorerActivity.f20880s0 != null) {
                C2290j jVar = new C2290j();
                Context applicationContext = fileExplorerActivity.getApplicationContext();
                t.d(applicationContext, "getApplicationContext(...)");
                Uri uri = fileExplorerActivity.f20880s0;
                t.b(uri);
                File file3 = (File) obj;
                if (jVar.k(applicationContext, uri) > file3.length() * ((long) 2)) {
                    Uri uri2 = fileExplorerActivity.f20880s0;
                    t.b(uri2);
                    l5.f24690a = fileExplorerActivity.N3(file3, uri2, zVar);
                }
            }
        } else if (!(obj instanceof DocumentFile)) {
        } else {
            if (fileExplorerActivity.f20881t0 != null) {
                File file4 = fileExplorerActivity.f20871X;
                if (file4 == null) {
                    File externalStorageDirectory = Environment.getExternalStorageDirectory();
                    if (externalStorageDirectory != null) {
                        j5 = externalStorageDirectory.getUsableSpace();
                    } else {
                        j5 = 0;
                    }
                } else {
                    t.b(file4);
                    j5 = file4.getUsableSpace();
                }
                DocumentFile documentFile = (DocumentFile) obj;
                if (j5 > documentFile.length() * ((long) 2)) {
                    String str2 = fileExplorerActivity.f20881t0;
                    t.b(str2);
                    l5.f24690a = fileExplorerActivity.M3(documentFile, str2, zVar);
                }
            } else if (fileExplorerActivity.f20880s0 != null) {
                C2290j jVar2 = new C2290j();
                Context applicationContext2 = fileExplorerActivity.getApplicationContext();
                t.d(applicationContext2, "getApplicationContext(...)");
                Uri uri3 = fileExplorerActivity.f20880s0;
                t.b(uri3);
                DocumentFile documentFile2 = (DocumentFile) obj;
                if (jVar2.k(applicationContext2, uri3) > documentFile2.length() * ((long) 2)) {
                    Uri uri4 = fileExplorerActivity.f20880s0;
                    t.b(uri4);
                    l5.f24690a = fileExplorerActivity.L3(documentFile2, uri4, zVar);
                }
            } else {
                DocumentFile documentFile3 = fileExplorerActivity.f20867T;
                if (documentFile3 != null) {
                    t.b(documentFile3);
                    Uri uri5 = documentFile3.getUri();
                    t.d(uri5, "getUri(...)");
                    l5.f24690a = fileExplorerActivity.L3((DocumentFile) obj, uri5, zVar);
                    return;
                }
                File file5 = fileExplorerActivity.f20871X;
                if (file5 != null) {
                    t.b(file5);
                    String absolutePath = file5.getAbsolutePath();
                    t.d(absolutePath, "getAbsolutePath(...)");
                    l5.f24690a = fileExplorerActivity.M3((DocumentFile) obj, absolutePath, zVar);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void b5() {
        if (this.f20872Y) {
            ArrayList arrayList = this.f20866S;
            if (arrayList != null) {
                t.b(arrayList);
                if (arrayList.size() > 1) {
                    C2250q.t(arrayList, new P());
                }
                ArrayList arrayList2 = this.f20866S;
                t.b(arrayList2);
                if (arrayList2.size() > 1) {
                    C2250q.t(arrayList2, new Q());
                }
            }
            ArrayList arrayList3 = this.f20870W;
            if (arrayList3 != null) {
                t.b(arrayList3);
                if (arrayList3.size() > 1) {
                    C2250q.t(arrayList3, new R());
                }
                ArrayList arrayList4 = this.f20870W;
                t.b(arrayList4);
                if (arrayList4.size() > 1) {
                    C2250q.t(arrayList4, new S());
                    return;
                }
                return;
            }
            return;
        }
        ArrayList arrayList5 = this.f20866S;
        if (arrayList5 != null) {
            t.b(arrayList5);
            if (arrayList5.size() > 1) {
                C2250q.t(arrayList5, new L());
            }
            ArrayList arrayList6 = this.f20866S;
            t.b(arrayList6);
            if (arrayList6.size() > 1) {
                C2250q.t(arrayList6, new M());
            }
        }
        ArrayList arrayList7 = this.f20870W;
        if (arrayList7 != null) {
            t.b(arrayList7);
            if (arrayList7.size() > 1) {
                C2250q.t(arrayList7, new N());
            }
            ArrayList arrayList8 = this.f20870W;
            t.b(arrayList8);
            if (arrayList8.size() > 1) {
                C2250q.t(arrayList8, new O());
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void c4(kotlin.jvm.internal.L l5, FileExplorerActivity fileExplorerActivity, View view) {
        C2908y0 y0Var = (C2908y0) l5.f24690a;
        if (y0Var != null) {
            C2908y0.a.a(y0Var, (CancellationException) null, 1, (Object) null);
        }
        AlertDialog alertDialog = fileExplorerActivity.f20861N;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public final void c5() {
        if (this.f20872Y) {
            ArrayList arrayList = this.f20866S;
            if (arrayList != null) {
                t.b(arrayList);
                if (arrayList.size() > 1) {
                    C2250q.t(arrayList, new X());
                }
                ArrayList arrayList2 = this.f20866S;
                t.b(arrayList2);
                if (arrayList2.size() > 1) {
                    C2250q.t(arrayList2, new Y());
                }
            }
            ArrayList arrayList3 = this.f20870W;
            if (arrayList3 != null) {
                t.b(arrayList3);
                if (arrayList3.size() > 1) {
                    C2250q.t(arrayList3, new Z());
                }
                ArrayList arrayList4 = this.f20870W;
                t.b(arrayList4);
                if (arrayList4.size() > 1) {
                    C2250q.t(arrayList4, new a0());
                    return;
                }
                return;
            }
            return;
        }
        ArrayList arrayList5 = this.f20866S;
        if (arrayList5 != null) {
            t.b(arrayList5);
            if (arrayList5.size() > 1) {
                C2250q.t(arrayList5, new T());
            }
            ArrayList arrayList6 = this.f20866S;
            t.b(arrayList6);
            if (arrayList6.size() > 1) {
                C2250q.t(arrayList6, new U());
            }
        }
        ArrayList arrayList7 = this.f20870W;
        if (arrayList7 != null) {
            t.b(arrayList7);
            if (arrayList7.size() > 1) {
                C2250q.t(arrayList7, new V());
            }
            ArrayList arrayList8 = this.f20870W;
            t.b(arrayList8);
            if (arrayList8.size() > 1) {
                C2250q.t(arrayList8, new W());
            }
        }
    }

    /* access modifiers changed from: private */
    public final void d4() {
        Menu menu;
        MenuItem findItem;
        Menu menu2;
        MenuItem findItem2;
        Menu menu3;
        MenuItem findItem3;
        Menu menu4;
        MenuItem findItem4;
        Menu menu5;
        MenuItem findItem5;
        Menu menu6;
        MenuItem findItem6;
        TextView textView = this.f20863P;
        if (textView != null) {
            textView.setText(getString(i.action_name_file_explorer));
        }
        Toolbar toolbar = this.f20862O;
        if (!(toolbar == null || (menu6 = toolbar.getMenu()) == null || (findItem6 = menu6.findItem(f.action_create)) == null)) {
            findItem6.setVisible(true);
        }
        Toolbar toolbar2 = this.f20862O;
        if (!(toolbar2 == null || (menu5 = toolbar2.getMenu()) == null || (findItem5 = menu5.findItem(f.action_delete)) == null)) {
            findItem5.setVisible(false);
        }
        Toolbar toolbar3 = this.f20862O;
        if (!(toolbar3 == null || (menu4 = toolbar3.getMenu()) == null || (findItem4 = menu4.findItem(f.action_copy)) == null)) {
            findItem4.setVisible(false);
        }
        Toolbar toolbar4 = this.f20862O;
        if (!(toolbar4 == null || (menu3 = toolbar4.getMenu()) == null || (findItem3 = menu3.findItem(f.action_compress)) == null)) {
            findItem3.setVisible(false);
        }
        Toolbar toolbar5 = this.f20862O;
        if (!(toolbar5 == null || (menu2 = toolbar5.getMenu()) == null || (findItem2 = menu2.findItem(f.action_cut)) == null)) {
            findItem2.setVisible(false);
        }
        Toolbar toolbar6 = this.f20862O;
        if (toolbar6 != null && (menu = toolbar6.getMenu()) != null && (findItem = menu.findItem(f.action_paste)) != null) {
            findItem.setVisible(false);
        }
    }

    /* access modifiers changed from: private */
    public final void d5() {
        if (this.f20872Y) {
            ArrayList arrayList = this.f20866S;
            if (arrayList != null) {
                t.b(arrayList);
                if (arrayList.size() > 1) {
                    C2250q.t(arrayList, new f0());
                }
                ArrayList arrayList2 = this.f20866S;
                t.b(arrayList2);
                if (arrayList2.size() > 1) {
                    C2250q.t(arrayList2, new g0());
                }
            }
            ArrayList arrayList3 = this.f20870W;
            if (arrayList3 != null) {
                t.b(arrayList3);
                if (arrayList3.size() > 1) {
                    C2250q.t(arrayList3, new h0());
                }
                ArrayList arrayList4 = this.f20870W;
                t.b(arrayList4);
                if (arrayList4.size() > 1) {
                    C2250q.t(arrayList4, new i0());
                    return;
                }
                return;
            }
            return;
        }
        ArrayList arrayList5 = this.f20866S;
        if (arrayList5 != null) {
            t.b(arrayList5);
            if (arrayList5.size() > 1) {
                C2250q.t(arrayList5, new b0());
            }
            ArrayList arrayList6 = this.f20866S;
            t.b(arrayList6);
            if (arrayList6.size() > 1) {
                C2250q.t(arrayList6, new c0());
            }
        }
        ArrayList arrayList7 = this.f20870W;
        if (arrayList7 != null) {
            t.b(arrayList7);
            if (arrayList7.size() > 1) {
                C2250q.t(arrayList7, new d0());
            }
            ArrayList arrayList8 = this.f20870W;
            t.b(arrayList8);
            if (arrayList8.size() > 1) {
                C2250q.t(arrayList8, new e0());
            }
        }
    }

    /* access modifiers changed from: private */
    public final void e4(DocumentFile documentFile) {
        Application application = getApplication();
        t.c(application, "null cannot be cast to non-null type com.uptodown.core.UptodownCoreApplication");
        Uri uri = documentFile.getUri();
        t.d(uri, "getUri(...)");
        ((k) application).N(uri, new B(this, documentFile), this);
    }

    private final void e5(Uri uri) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(uri, getContentResolver().getType(uri));
        intent.addFlags(1);
        startActivity(Intent.createChooser(intent, (CharSequence) null));
    }

    /* access modifiers changed from: private */
    public final void f4(File file) {
        Application application = getApplication();
        t.c(application, "null cannot be cast to non-null type com.uptodown.core.UptodownCoreApplication");
        ((k) application).O(file, new A(this, file), this);
    }

    /* access modifiers changed from: private */
    public final void f5() {
        C2206b bVar = this.f20864Q;
        t.b(bVar);
        bVar.h(false);
        d4();
        h4(false);
    }

    /* access modifiers changed from: private */
    public final void g4(String str) {
        RelativeLayout relativeLayout = this.f20848A;
        if (relativeLayout == null) {
            t.w("rlLoading");
            relativeLayout = null;
        }
        relativeLayout.setVisibility(0);
        if (this.f20867T == null && this.f20871X == null) {
            T4();
        }
        new C2211d(this.f20867T, this.f20871X, this, new D(this, str));
    }

    private final void g5() {
        String string = getString(i.core_msg_cannot_write_path);
        t.d(string, "getString(...)");
        u0(string);
    }

    /* access modifiers changed from: private */
    public final void h4(boolean z4) {
        SearchView searchView;
        if (z4 && (searchView = this.f20855H) != null) {
            w3(searchView);
        }
        g4((String) null);
    }

    static /* synthetic */ void i4(FileExplorerActivity fileExplorerActivity, boolean z4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z4 = true;
        }
        fileExplorerActivity.h4(z4);
    }

    /* access modifiers changed from: private */
    public static final WindowInsetsCompat j4(View view, WindowInsetsCompat windowInsetsCompat) {
        t.e(view, "v");
        t.e(windowInsetsCompat, "windowInsets");
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        t.d(insets, "getInsets(...)");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = insets.left;
            marginLayoutParams.bottomMargin = insets.bottom;
            marginLayoutParams.rightMargin = insets.right;
            marginLayoutParams.topMargin = insets.top;
            view.setLayoutParams(marginLayoutParams);
            return WindowInsetsCompat.CONSUMED;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    /* access modifiers changed from: private */
    public static final void k4(FileExplorerActivity fileExplorerActivity, CompoundButton compoundButton, boolean z4) {
        if (z4) {
            fileExplorerActivity.f20872Y = !fileExplorerActivity.f20872Y;
            RadioButton radioButton = fileExplorerActivity.f20858K;
            t.b(radioButton);
            radioButton.setOnClickListener(new T1.L(fileExplorerActivity));
            RadioButton radioButton2 = fileExplorerActivity.f20859L;
            t.b(radioButton2);
            radioButton2.setOnClickListener(new T1.M());
            RadioButton radioButton3 = fileExplorerActivity.f20860M;
            t.b(radioButton3);
            radioButton3.setOnClickListener(new T1.N());
        }
    }

    /* access modifiers changed from: private */
    public static final void l4(FileExplorerActivity fileExplorerActivity, View view) {
        fileExplorerActivity.f20872Y = !fileExplorerActivity.f20872Y;
        fileExplorerActivity.I4();
        fileExplorerActivity.W4();
    }

    /* access modifiers changed from: private */
    public static final void m4(View view) {
    }

    /* access modifiers changed from: private */
    public static final void n4(View view) {
    }

    /* access modifiers changed from: private */
    public static final void o4(FileExplorerActivity fileExplorerActivity, CompoundButton compoundButton, boolean z4) {
        if (z4) {
            fileExplorerActivity.f20872Y = !fileExplorerActivity.f20872Y;
            RadioButton radioButton = fileExplorerActivity.f20859L;
            t.b(radioButton);
            radioButton.setOnClickListener(new C2154C(fileExplorerActivity));
            RadioButton radioButton2 = fileExplorerActivity.f20858K;
            t.b(radioButton2);
            radioButton2.setOnClickListener(new C2155D());
            RadioButton radioButton3 = fileExplorerActivity.f20860M;
            t.b(radioButton3);
            radioButton3.setOnClickListener(new C2156E());
        }
    }

    /* access modifiers changed from: private */
    public static final void p4(FileExplorerActivity fileExplorerActivity, View view) {
        fileExplorerActivity.f20872Y = !fileExplorerActivity.f20872Y;
        fileExplorerActivity.I4();
        fileExplorerActivity.X4();
    }

    private final void q3() {
        DocumentFile documentFile = this.f20867T;
        t.b(documentFile);
        String lastPathSegment = documentFile.getUri().getLastPathSegment();
        LinearLayout linearLayout = this.f20850C;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            t.w("llBreadcrumb");
            linearLayout = null;
        }
        if (linearLayout.findViewWithTag(lastPathSegment) == null) {
            LayoutInflater layoutInflater = getLayoutInflater();
            int i5 = g.breadcrumb;
            LinearLayout linearLayout3 = this.f20850C;
            if (linearLayout3 == null) {
                t.w("llBreadcrumb");
                linearLayout3 = null;
            }
            View inflate = layoutInflater.inflate(i5, linearLayout3, false);
            t.c(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
            LinearLayout linearLayout4 = (LinearLayout) inflate;
            linearLayout4.setTag(lastPathSegment);
            TextView textView = (TextView) linearLayout4.findViewById(f.tv_breadcrumb_path);
            t.b(lastPathSegment);
            String substring = lastPathSegment.substring(s.l0(lastPathSegment, ":", 0, false, 6, (Object) null) + 1);
            t.d(substring, "substring(...)");
            if (substring.length() > 0) {
                String substring2 = lastPathSegment.substring(s.l0(lastPathSegment, ":", 0, false, 6, (Object) null) + 1);
                t.d(substring2, "substring(...)");
                String substring3 = substring2.substring(s.l0(substring2, "/", 0, false, 6, (Object) null) + 1);
                t.d(substring3, "substring(...)");
                if (substring3.length() > 0) {
                    String substring4 = substring2.substring(s.l0(substring2, "/", 0, false, 6, (Object) null) + 1);
                    t.d(substring4, "substring(...)");
                    textView.setText(substring4);
                } else {
                    String substring5 = substring2.substring(s.l0(substring2, ":", 0, false, 6, (Object) null) + 1);
                    t.d(substring5, "substring(...)");
                    textView.setText(substring5);
                }
            }
            textView.setTypeface(k.f32g.x());
            LinearLayout linearLayout5 = this.f20850C;
            if (linearLayout5 == null) {
                t.w("llBreadcrumb");
            } else {
                linearLayout2 = linearLayout5;
            }
            linearLayout2.addView(linearLayout4);
            W2.J j5 = W2.J.f19942a;
            P4();
        }
    }

    /* access modifiers changed from: private */
    public static final void q4(View view) {
    }

    private final void r3() {
        File file = this.f20871X;
        t.b(file);
        String absolutePath = file.getAbsolutePath();
        LinearLayout linearLayout = this.f20850C;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            t.w("llBreadcrumb");
            linearLayout = null;
        }
        if (linearLayout.findViewWithTag(absolutePath) == null) {
            LayoutInflater layoutInflater = getLayoutInflater();
            int i5 = g.breadcrumb;
            LinearLayout linearLayout3 = this.f20850C;
            if (linearLayout3 == null) {
                t.w("llBreadcrumb");
                linearLayout3 = null;
            }
            View inflate = layoutInflater.inflate(i5, linearLayout3, false);
            t.c(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
            LinearLayout linearLayout4 = (LinearLayout) inflate;
            linearLayout4.setTag(absolutePath);
            TextView textView = (TextView) linearLayout4.findViewById(f.tv_breadcrumb_path);
            File file2 = this.f20871X;
            t.b(file2);
            String path = file2.getPath();
            t.d(path, "getPath(...)");
            textView.setText(Uri.parse(path).getLastPathSegment());
            textView.setTypeface(k.f32g.x());
            LinearLayout linearLayout5 = this.f20850C;
            if (linearLayout5 == null) {
                t.w("llBreadcrumb");
            } else {
                linearLayout2 = linearLayout5;
            }
            linearLayout2.addView(linearLayout4);
            W2.J j5 = W2.J.f19942a;
            P4();
        }
    }

    /* access modifiers changed from: private */
    public static final void r4(View view) {
    }

    /* access modifiers changed from: private */
    public final void s3(String str, String str2) {
        if (!isFinishing()) {
            RelativeLayout relativeLayout = this.f20848A;
            if (relativeLayout == null) {
                t.w("rlLoading");
                relativeLayout = null;
            }
            relativeLayout.setVisibility(0);
            C2908y0 unused = C2876i.d(w3.N.a(C2865c0.b()), (C2312i) null, (w3.O) null, new C2318b(this, str, str2, (C2308e) null), 3, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void s4(FileExplorerActivity fileExplorerActivity, View view) {
        fileExplorerActivity.O4();
    }

    /* access modifiers changed from: private */
    public final void t3() {
        C2206b bVar = this.f20864Q;
        t.b(bVar);
        if (bVar.getItemCount() == 0) {
            DocumentFile documentFile = this.f20867T;
            if (documentFile != null) {
                t.b(documentFile);
                Y4(documentFile.canRead());
                return;
            }
            File file = this.f20871X;
            if (file != null) {
                t.b(file);
                Y4(file.canRead());
                return;
            }
            return;
        }
        TextView textView = this.f20852E;
        if (textView == null) {
            t.w("tvEmptyDirectory");
            textView = null;
        }
        textView.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public static final void t4(FileExplorerActivity fileExplorerActivity, CompoundButton compoundButton, boolean z4) {
        if (z4) {
            fileExplorerActivity.f20872Y = !fileExplorerActivity.f20872Y;
            RadioButton radioButton = fileExplorerActivity.f20860M;
            t.b(radioButton);
            radioButton.setOnClickListener(new T1.P(fileExplorerActivity));
            RadioButton radioButton2 = fileExplorerActivity.f20858K;
            t.b(radioButton2);
            radioButton2.setOnClickListener(new T1.S());
            RadioButton radioButton3 = fileExplorerActivity.f20859L;
            t.b(radioButton3);
            radioButton3.setOnClickListener(new T1.T());
        }
    }

    /* access modifiers changed from: private */
    public final void u3() {
        Uri n5 = new C2290j().n(this);
        LinearLayout linearLayout = null;
        if (n5 != null) {
            this.f20867T = DocumentFile.fromTreeUri(this, n5);
            this.f20871X = null;
            i4(this, false, 1, (Object) null);
            return;
        }
        LinearLayout linearLayout2 = this.f20849B;
        if (linearLayout2 == null) {
            t.w("llPermissionExplanation");
            linearLayout2 = null;
        }
        linearLayout2.setVisibility(0);
        RecyclerView recyclerView = this.f20889z;
        if (recyclerView == null) {
            t.w("rvFiles");
            recyclerView = null;
        }
        recyclerView.setVisibility(8);
        LinearLayout linearLayout3 = this.f20849B;
        if (linearLayout3 == null) {
            t.w("llPermissionExplanation");
        } else {
            linearLayout = linearLayout3;
        }
        View findViewById = linearLayout.findViewById(f.tv_grant_access_sd);
        t.d(findViewById, "findViewById(...)");
        TextView textView = (TextView) findViewById;
        textView.setTypeface(k.f32g.x());
        textView.setOnClickListener(new T1.O(this));
    }

    /* access modifiers changed from: private */
    public static final void u4(FileExplorerActivity fileExplorerActivity, View view) {
        fileExplorerActivity.f20872Y = !fileExplorerActivity.f20872Y;
        fileExplorerActivity.I4();
        fileExplorerActivity.V4();
    }

    /* access modifiers changed from: private */
    public static final void v3(FileExplorerActivity fileExplorerActivity, View view) {
        fileExplorerActivity.n0();
    }

    /* access modifiers changed from: private */
    public static final void v4(View view) {
    }

    /* access modifiers changed from: private */
    public final void w3(SearchView searchView) {
        searchView.setOnQueryTextListener((SearchView.OnQueryTextListener) null);
        searchView.setQuery("", false);
        searchView.setOnQueryTextListener(this.f20884w0);
        Object systemService = getSystemService("input_method");
        t.c(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(searchView.getWindowToken(), 0);
    }

    /* access modifiers changed from: private */
    public static final void w4(View view) {
    }

    /* access modifiers changed from: private */
    public final void x3() {
        AlertDialog alertDialog = this.f20861N;
        if (alertDialog != null) {
            t.b(alertDialog);
            alertDialog.dismiss();
        }
        View inflate = getLayoutInflater().inflate(g.dialog_accept_cancel, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(f.tv_dialog_msg);
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.x());
        textView.setText(textView.getContext().getString(i.dialog_close_file_manager));
        TextView textView2 = (TextView) inflate.findViewById(f.tv_accept_option);
        textView2.setText(getString(i.ok));
        textView2.setTypeface(aVar.w());
        textView2.setOnClickListener(new T1.J(this));
        TextView textView3 = (TextView) inflate.findViewById(f.tv_cancel_option);
        textView3.setText(getString(i.option_button_cancel));
        textView3.setTypeface(aVar.w());
        textView3.setOnClickListener(new T1.K(this));
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(inflate);
        AlertDialog create = builder.create();
        this.f20861N = create;
        t.b(create);
        Window window = create.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        AlertDialog alertDialog2 = this.f20861N;
        t.b(alertDialog2);
        alertDialog2.show();
    }

    /* access modifiers changed from: private */
    public static final void x4(FileExplorerActivity fileExplorerActivity, CompoundButton compoundButton, boolean z4) {
        new C2201a(fileExplorerActivity).J(z4);
        SearchView searchView = fileExplorerActivity.f20855H;
        t.b(searchView);
        fileExplorerActivity.s3(searchView.getQuery().toString(), (String) null);
    }

    /* access modifiers changed from: private */
    public static final void y3(FileExplorerActivity fileExplorerActivity, View view) {
        AlertDialog alertDialog = fileExplorerActivity.f20861N;
        t.b(alertDialog);
        alertDialog.dismiss();
        fileExplorerActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void y4(View view) {
    }

    /* access modifiers changed from: private */
    public static final void z3(FileExplorerActivity fileExplorerActivity, View view) {
        AlertDialog alertDialog = fileExplorerActivity.f20861N;
        t.b(alertDialog);
        alertDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void z4(FileExplorerActivity fileExplorerActivity, View view) {
        fileExplorerActivity.finish();
    }

    public void b1() {
        Object obj;
        super.b1();
        h o5 = k.f32g.o();
        t.b(o5);
        if (o5.e() != null && (obj = this.f20874m0) != null) {
            t.b(obj);
            if (obj instanceof File) {
                File file = (File) obj;
                if (!file.isDirectory()) {
                    Application application = getApplication();
                    t.c(application, "null cannot be cast to non-null type com.uptodown.core.UptodownCoreApplication");
                    ((k) application).Z(file);
                }
            } else if (obj instanceof DocumentFile) {
                Application application2 = getApplication();
                t.c(application2, "null cannot be cast to non-null type com.uptodown.core.UptodownCoreApplication");
                ((k) application2).Y((DocumentFile) obj);
            }
        }
    }

    public void c0() {
        I(getString(i.msg_permission_storage_denied));
    }

    public void d0() {
        Uri n5 = new C2290j().n(this);
        if (n5 != null) {
            LinearLayout linearLayout = this.f20849B;
            if (linearLayout == null) {
                t.w("llPermissionExplanation");
                linearLayout = null;
            }
            linearLayout.setVisibility(8);
            RecyclerView recyclerView = this.f20889z;
            if (recyclerView == null) {
                t.w("rvFiles");
                recyclerView = null;
            }
            recyclerView.setVisibility(0);
            this.f20867T = DocumentFile.fromTreeUri(this, n5);
            this.f20871X = null;
            i4(this, false, 1, (Object) null);
        }
    }

    public void e0() {
        I(getString(i.core_error_wrong_sdcard_path));
    }

    public void e1() {
    }

    public void f0() {
        I(getString(i.msg_permission_storage_denied));
    }

    public void h0() {
        i4(this, false, 1, (Object) null);
        if (!U()) {
            q0();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0066 A[LOOP:0: B:15:0x0066->B:18:0x0076, LOOP_START, PHI: r3 
      PHI: (r3v36 androidx.documentfile.provider.DocumentFile) = (r3v34 androidx.documentfile.provider.DocumentFile), (r3v37 androidx.documentfile.provider.DocumentFile) binds: [B:14:0x0054, B:18:0x0076] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r12) {
        /*
            r11 = this;
            super.onCreate(r12)
            int r12 = S1.g.file_explorer
            r11.setContentView((int) r12)
            int r12 = S1.f.rl_file_explorer
            android.view.View r12 = r11.findViewById(r12)
            android.widget.RelativeLayout r12 = (android.widget.RelativeLayout) r12
            T1.u r0 = new T1.u
            r0.<init>()
            androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener(r12, r0)
            android.content.Intent r12 = r11.getIntent()
            android.os.Bundle r12 = r12.getExtras()
            r0 = 1
            r1 = 0
            r2 = 0
            if (r12 == 0) goto L_0x00ec
            java.lang.String r3 = "subdir"
            boolean r4 = r12.containsKey(r3)
            if (r4 == 0) goto L_0x0086
            java.lang.String r5 = r12.getString(r3)
            if (r5 == 0) goto L_0x0086
            java.lang.String r3 = "subdir_sd"
            boolean r3 = r12.getBoolean(r3)
            r11.f20873Z = r3
            if (r3 == 0) goto L_0x007d
            b2.j r3 = new b2.j
            r3.<init>()
            android.net.Uri r3 = r3.n(r11)
            if (r3 == 0) goto L_0x0086
            androidx.documentfile.provider.DocumentFile r3 = androidx.documentfile.provider.DocumentFile.fromTreeUri(r11, r3)
            if (r3 == 0) goto L_0x0078
            int r4 = r5.length()
            if (r4 <= 0) goto L_0x0078
            java.lang.String r4 = "/"
            java.lang.String[] r6 = new java.lang.String[]{r4}
            r9 = 6
            r10 = 0
            r7 = 0
            r8 = 0
            java.util.List r4 = t3.s.G0(r5, r6, r7, r8, r9, r10)
            java.util.Iterator r4 = r4.iterator()
        L_0x0066:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0078
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            androidx.documentfile.provider.DocumentFile r3 = r3.findFile(r5)
            if (r3 != 0) goto L_0x0066
        L_0x0078:
            r11.f20867T = r3
            r11.f20871X = r2
            goto L_0x0086
        L_0x007d:
            java.io.File r3 = new java.io.File
            r3.<init>(r5)
            r11.f20871X = r3
            r11.f20867T = r2
        L_0x0086:
            java.lang.String r3 = "select_path"
            boolean r4 = r12.containsKey(r3)
            if (r4 == 0) goto L_0x00ec
            int r12 = r12.getInt(r3)
            if (r12 != r0) goto L_0x00ec
            r11.f20877p0 = r0
            int r12 = S1.f.ll_options
            android.view.View r12 = r11.findViewById(r12)
            java.lang.String r3 = "findViewById(...)"
            kotlin.jvm.internal.t.d(r12, r3)
            android.widget.LinearLayout r12 = (android.widget.LinearLayout) r12
            int r4 = S1.f.view_options_shadow
            android.view.View r4 = r11.findViewById(r4)
            kotlin.jvm.internal.t.d(r4, r3)
            r12.setVisibility(r1)
            r4.setVisibility(r1)
            int r12 = S1.f.tv_select_current_dir
            android.view.View r12 = r11.findViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            r11.f20854G = r12
            if (r12 == 0) goto L_0x00c7
            S1.k$a r3 = S1.k.f32g
            android.graphics.Typeface r3 = r3.w()
            r12.setTypeface(r3)
        L_0x00c7:
            android.widget.TextView r12 = r11.f20854G
            if (r12 == 0) goto L_0x00d3
            T1.d0 r3 = new T1.d0
            r3.<init>(r11)
            r12.setOnClickListener(r3)
        L_0x00d3:
            int r12 = S1.f.tv_cancel
            android.view.View r12 = r11.findViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            S1.k$a r3 = S1.k.f32g
            android.graphics.Typeface r3 = r3.w()
            r12.setTypeface(r3)
            T1.e0 r3 = new T1.e0
            r3.<init>(r11)
            r12.setOnClickListener(r3)
        L_0x00ec:
            int r12 = S1.f.f28n0
            android.view.View r12 = r11.findViewById(r12)
            androidx.appcompat.widget.Toolbar r12 = (androidx.appcompat.widget.Toolbar) r12
            r11.f20862O = r12
            int r12 = S1.f.tv_toolbar_title
            android.view.View r12 = r11.findViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            r11.f20863P = r12
            if (r12 == 0) goto L_0x010b
            int r3 = S1.i.action_name_file_explorer
            java.lang.String r3 = r11.getString(r3)
            r12.setText(r3)
        L_0x010b:
            android.widget.TextView r12 = r11.f20863P
            if (r12 == 0) goto L_0x0118
            S1.k$a r3 = S1.k.f32g
            android.graphics.Typeface r3 = r3.w()
            r12.setTypeface(r3)
        L_0x0118:
            androidx.appcompat.widget.Toolbar r12 = r11.f20862O
            if (r12 == 0) goto L_0x0125
            int r3 = S1.e.core_vector_menu_dots_blue
            android.graphics.drawable.Drawable r3 = androidx.core.content.ContextCompat.getDrawable(r11, r3)
            r12.setOverflowIcon(r3)
        L_0x0125:
            androidx.appcompat.widget.Toolbar r12 = r11.f20862O
            if (r12 == 0) goto L_0x0132
            int r3 = S1.e.core_vector_back
            android.graphics.drawable.Drawable r3 = androidx.core.content.ContextCompat.getDrawable(r11, r3)
            r12.setNavigationIcon((android.graphics.drawable.Drawable) r3)
        L_0x0132:
            androidx.appcompat.widget.Toolbar r12 = r11.f20862O
            if (r12 == 0) goto L_0x013e
            T1.f0 r3 = new T1.f0
            r3.<init>(r11)
            r12.setNavigationOnClickListener(r3)
        L_0x013e:
            androidx.appcompat.widget.Toolbar r12 = r11.f20862O
            if (r12 == 0) goto L_0x0147
            int r3 = S1.h.core_menu_file_explorer
            r12.inflateMenu(r3)
        L_0x0147:
            androidx.appcompat.widget.Toolbar r12 = r11.f20862O
            if (r12 == 0) goto L_0x0153
            T1.g0 r3 = new T1.g0
            r3.<init>(r11)
            r12.setOnMenuItemClickListener(r3)
        L_0x0153:
            r11.d4()
            int r12 = S1.f.layout_breadcrumb_main
            android.view.View r12 = r11.findViewById(r12)
            android.widget.LinearLayout r12 = (android.widget.LinearLayout) r12
            r11.f20850C = r12
            int r12 = S1.f.sv_breadcumb
            android.view.View r12 = r11.findViewById(r12)
            android.widget.HorizontalScrollView r12 = (android.widget.HorizontalScrollView) r12
            r11.f20851D = r12
            android.widget.LinearLayout r12 = r11.f20850C
            if (r12 != 0) goto L_0x0174
            java.lang.String r12 = "llBreadcrumb"
            kotlin.jvm.internal.t.w(r12)
            r12 = r2
        L_0x0174:
            int r3 = S1.f.tv_main_path
            android.view.View r12 = r12.findViewById(r3)
            android.widget.TextView r12 = (android.widget.TextView) r12
            r11.f20885x = r12
            int r12 = S1.f.iv_home_path
            android.view.View r12 = r11.findViewById(r12)
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            r11.f20887y = r12
            if (r12 != 0) goto L_0x0190
            java.lang.String r12 = "ivBreadCrumb"
            kotlin.jvm.internal.t.w(r12)
            r12 = r2
        L_0x0190:
            T1.h0 r3 = new T1.h0
            r3.<init>(r11)
            r12.setOnClickListener(r3)
            android.widget.TextView r12 = r11.f20885x
            if (r12 != 0) goto L_0x01a2
            java.lang.String r12 = "tvBreadCrumb"
            kotlin.jvm.internal.t.w(r12)
            r12 = r2
        L_0x01a2:
            S1.k$a r3 = S1.k.f32g
            android.graphics.Typeface r4 = r3.x()
            r12.setTypeface(r4)
            int r12 = S1.f.tv_empty_dir
            android.view.View r12 = r11.findViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            r11.f20852E = r12
            if (r12 != 0) goto L_0x01bd
            java.lang.String r12 = "tvEmptyDirectory"
            kotlin.jvm.internal.t.w(r12)
            r12 = r2
        L_0x01bd:
            android.graphics.Typeface r4 = r3.x()
            r12.setTypeface(r4)
            int r12 = S1.f.search_view
            android.view.View r12 = r11.findViewById(r12)
            androidx.appcompat.widget.SearchView r12 = (androidx.appcompat.widget.SearchView) r12
            r11.f20855H = r12
            if (r12 == 0) goto L_0x01d5
            com.uptodown.core.activities.FileExplorerActivity$G r4 = r11.f20884w0
            r12.setOnQueryTextListener(r4)
        L_0x01d5:
            androidx.appcompat.widget.SearchView r12 = r11.f20855H
            if (r12 == 0) goto L_0x01e1
            T1.v r4 = new T1.v
            r4.<init>(r11)
            r12.setOnClickListener(r4)
        L_0x01e1:
            androidx.appcompat.widget.SearchView r12 = r11.f20855H
            kotlin.jvm.internal.t.b(r12)
            int r4 = androidx.appcompat.R.id.search_close_btn
            android.view.View r12 = r12.findViewById(r4)
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            int r4 = S1.e.core_shape_transparent
            r12.setBackgroundResource(r4)
            androidx.appcompat.widget.SearchView r12 = r11.f20855H
            kotlin.jvm.internal.t.b(r12)
            int r4 = androidx.appcompat.R.id.search_src_text
            android.view.View r12 = r12.findViewById(r4)
            android.widget.EditText r12 = (android.widget.EditText) r12
            android.graphics.Typeface r4 = r3.x()
            r12.setTypeface(r4)
            int r4 = S1.c.text_primary
            int r4 = androidx.core.content.ContextCompat.getColor(r11, r4)
            r12.setTextColor(r4)
            int r4 = S1.c.core_search_view_color
            int r4 = androidx.core.content.ContextCompat.getColor(r11, r4)
            r12.setHintTextColor(r4)
            int r12 = S1.f.iv_search_options
            android.view.View r12 = r11.findViewById(r12)
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            r11.f20856I = r12
            kotlin.jvm.internal.t.b(r12)
            T1.w r4 = new T1.w
            r4.<init>(r11)
            r12.setOnClickListener(r4)
            int r12 = S1.f.rl_sort_options
            android.view.View r12 = r11.findViewById(r12)
            android.widget.RelativeLayout r12 = (android.widget.RelativeLayout) r12
            r11.f20857J = r12
            int r12 = S1.f.rb_name_sort
            android.view.View r12 = r11.findViewById(r12)
            android.widget.RadioButton r12 = (android.widget.RadioButton) r12
            r11.f20858K = r12
            kotlin.jvm.internal.t.b(r12)
            android.graphics.Typeface r4 = r3.x()
            r12.setTypeface(r4)
            android.widget.RadioButton r12 = r11.f20858K
            kotlin.jvm.internal.t.b(r12)
            T1.x r4 = new T1.x
            r4.<init>(r11)
            r12.setOnClickListener(r4)
            android.widget.RadioButton r12 = r11.f20858K
            kotlin.jvm.internal.t.b(r12)
            T1.y r4 = new T1.y
            r4.<init>(r11)
            r12.setOnCheckedChangeListener(r4)
            int r12 = S1.f.rb_size_sort
            android.view.View r12 = r11.findViewById(r12)
            android.widget.RadioButton r12 = (android.widget.RadioButton) r12
            r11.f20859L = r12
            kotlin.jvm.internal.t.b(r12)
            T1.F r4 = new T1.F
            r4.<init>(r11)
            r12.setOnCheckedChangeListener(r4)
            int r12 = S1.f.rb_date_sort
            android.view.View r12 = r11.findViewById(r12)
            android.widget.RadioButton r12 = (android.widget.RadioButton) r12
            r11.f20860M = r12
            kotlin.jvm.internal.t.b(r12)
            T1.Q r4 = new T1.Q
            r4.<init>(r11)
            r12.setOnCheckedChangeListener(r4)
            int r12 = S1.f.cb_show_hidden_files
            android.view.View r12 = r11.findViewById(r12)
            android.widget.CheckBox r12 = (android.widget.CheckBox) r12
            android.graphics.Typeface r4 = r3.x()
            r12.setTypeface(r4)
            U1.a r4 = new U1.a
            r4.<init>(r11)
            boolean r4 = r4.r()
            r12.setChecked(r4)
            T1.b0 r4 = new T1.b0
            r4.<init>(r11)
            r12.setOnCheckedChangeListener(r4)
            r11.W4()
            int r12 = S1.f.rv_files
            android.view.View r12 = r11.findViewById(r12)
            androidx.recyclerview.widget.RecyclerView r12 = (androidx.recyclerview.widget.RecyclerView) r12
            r11.f20889z = r12
            java.lang.String r4 = "rvFiles"
            if (r12 != 0) goto L_0x02c8
            kotlin.jvm.internal.t.w(r4)
            r12 = r2
        L_0x02c8:
            androidx.recyclerview.widget.LinearLayoutManager r5 = new androidx.recyclerview.widget.LinearLayoutManager
            r5.<init>(r11, r0, r1)
            r12.setLayoutManager(r5)
            androidx.recyclerview.widget.RecyclerView r12 = r11.f20889z
            if (r12 != 0) goto L_0x02d8
            kotlin.jvm.internal.t.w(r4)
            r12 = r2
        L_0x02d8:
            b2.w r5 = new b2.w
            android.content.res.Resources r6 = r11.getResources()
            int r7 = S1.d.margin_generic_item_recyclerview
            float r6 = r6.getDimension(r7)
            int r6 = (int) r6
            r5.<init>(r6)
            r12.addItemDecoration(r5)
            androidx.recyclerview.widget.RecyclerView r12 = r11.f20889z
            if (r12 != 0) goto L_0x02f3
            kotlin.jvm.internal.t.w(r4)
            r12 = r2
        L_0x02f3:
            androidx.recyclerview.widget.DefaultItemAnimator r4 = new androidx.recyclerview.widget.DefaultItemAnimator
            r4.<init>()
            r12.setItemAnimator(r4)
            int r12 = S1.f.rl_loading_file_explorer
            android.view.View r12 = r11.findViewById(r12)
            android.widget.RelativeLayout r12 = (android.widget.RelativeLayout) r12
            r11.f20848A = r12
            if (r12 != 0) goto L_0x030d
            java.lang.String r12 = "rlLoading"
            kotlin.jvm.internal.t.w(r12)
            r12 = r2
        L_0x030d:
            T1.c0 r4 = new T1.c0
            r4.<init>()
            r12.setOnClickListener(r4)
            int r12 = S1.f.ll_sd_permissions_explanation
            android.view.View r12 = r11.findViewById(r12)
            android.widget.LinearLayout r12 = (android.widget.LinearLayout) r12
            r11.f20849B = r12
            int r12 = S1.f.tv_storage_devices
            android.view.View r12 = r11.findViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            r11.f20879r0 = r12
            if (r12 == 0) goto L_0x0332
            android.graphics.Typeface r3 = r3.w()
            r12.setTypeface(r3)
        L_0x0332:
            int r12 = S1.f.tl_storage
            android.view.View r12 = r11.findViewById(r12)
            com.google.android.material.tabs.TabLayout r12 = (com.google.android.material.tabs.TabLayout) r12
            r11.f20878q0 = r12
            kotlin.jvm.internal.t.b(r12)
            com.google.android.material.tabs.TabLayout$Tab r12 = r12.newTab()
            int r3 = S1.i.internal_storage
            java.lang.String r3 = r11.getString(r3)
            com.google.android.material.tabs.TabLayout$Tab r12 = r12.setText((java.lang.CharSequence) r3)
            java.lang.String r3 = "setText(...)"
            kotlin.jvm.internal.t.d(r12, r3)
            r12.setId(r1)
            com.google.android.material.tabs.TabLayout r4 = r11.f20878q0
            kotlin.jvm.internal.t.b(r4)
            r4.addTab(r12)
            com.google.android.material.tabs.TabLayout r12 = r11.f20878q0
            kotlin.jvm.internal.t.b(r12)
            com.google.android.material.tabs.TabLayout$Tab r12 = r12.newTab()
            int r4 = S1.i.sd_card
            java.lang.String r4 = r11.getString(r4)
            com.google.android.material.tabs.TabLayout$Tab r12 = r12.setText((java.lang.CharSequence) r4)
            kotlin.jvm.internal.t.d(r12, r3)
            r12.setId(r0)
            com.google.android.material.tabs.TabLayout r3 = r11.f20878q0
            kotlin.jvm.internal.t.b(r3)
            r3.addTab(r12)
            com.google.android.material.tabs.TabLayout r12 = r11.f20878q0
            kotlin.jvm.internal.t.b(r12)
            android.view.View r12 = androidx.core.view.ViewGroupKt.get(r12, r1)
            r12.setSelected(r0)
            com.google.android.material.tabs.TabLayout r12 = r11.f20878q0
            kotlin.jvm.internal.t.b(r12)
            com.uptodown.core.activities.FileExplorerActivity$F r3 = new com.uptodown.core.activities.FileExplorerActivity$F
            r3.<init>(r11)
            r12.addOnTabSelectedListener((com.google.android.material.tabs.TabLayout.OnTabSelectedListener) r3)
            boolean r12 = r11.V()
            if (r12 == 0) goto L_0x03d4
            i4(r11, r1, r0, r2)
            b2.I r12 = new b2.I
            r12.<init>()
            java.util.ArrayList r12 = r12.c(r11)
            r11.f20868U = r12
            if (r12 == 0) goto L_0x03c3
            boolean r12 = r12.isEmpty()
            if (r12 == 0) goto L_0x03b4
            goto L_0x03c3
        L_0x03b4:
            com.google.android.material.tabs.TabLayout r12 = r11.f20878q0
            if (r12 == 0) goto L_0x03bb
            r12.setVisibility(r1)
        L_0x03bb:
            android.widget.TextView r12 = r11.f20879r0
            if (r12 == 0) goto L_0x03d7
            r12.setVisibility(r1)
            goto L_0x03d7
        L_0x03c3:
            com.google.android.material.tabs.TabLayout r12 = r11.f20878q0
            r0 = 8
            if (r12 == 0) goto L_0x03cc
            r12.setVisibility(r0)
        L_0x03cc:
            android.widget.TextView r12 = r11.f20879r0
            if (r12 == 0) goto L_0x03d7
            r12.setVisibility(r0)
            goto L_0x03d7
        L_0x03d4:
            r11.K()
        L_0x03d7:
            androidx.activity.OnBackPressedDispatcher r12 = r11.getOnBackPressedDispatcher()
            com.uptodown.core.activities.FileExplorerActivity$E r0 = r11.f20886x0
            r12.addCallback(r11, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.onCreate(android.os.Bundle):void");
    }

    public boolean onKeyDown(int i5, KeyEvent keyEvent) {
        t.e(keyEvent, NotificationCompat.CATEGORY_EVENT);
        if (i5 != 82) {
            return super.onKeyDown(i5, keyEvent);
        }
        Toolbar toolbar = this.f20862O;
        t.b(toolbar);
        toolbar.showOverflowMenu();
        return true;
    }
}
