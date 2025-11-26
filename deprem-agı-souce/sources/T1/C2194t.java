package T1;

import S1.f;
import S1.g;
import S1.i;
import S1.k;
import U1.C2201a;
import W2.J;
import W2.u;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.documentfile.provider.DocumentFile;
import androidx.lifecycle.LifecycleOwnerKt;
import b2.C2290j;
import b2.C2301u;
import b3.C2308e;
import c3.C2316b;
import com.uptodown.core.activities.FileExplorerActivity;
import java.io.File;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import t3.s;
import w3.C2865c0;
import w3.C2908y0;
import w3.M;
import w3.O;

/* renamed from: T1.t  reason: case insensitive filesystem */
public abstract class C2194t extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    private AlertDialog f19172a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f19173b;

    /* renamed from: c  reason: collision with root package name */
    private RadioButton f19174c;

    /* renamed from: d  reason: collision with root package name */
    private RadioButton f19175d;

    /* renamed from: e  reason: collision with root package name */
    private RadioButton f19176e;

    /* renamed from: f  reason: collision with root package name */
    private CheckBox f19177f;

    /* renamed from: g  reason: collision with root package name */
    private CheckBox f19178g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f19179h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f19180i;

    /* renamed from: j  reason: collision with root package name */
    private Boolean f19181j;

    /* renamed from: k  reason: collision with root package name */
    private String f19182k;

    /* renamed from: l  reason: collision with root package name */
    private final ActivityResultLauncher f19183l;

    /* renamed from: m  reason: collision with root package name */
    private final ActivityResultLauncher f19184m;

    /* renamed from: n  reason: collision with root package name */
    private final ActivityResultLauncher f19185n;

    /* renamed from: o  reason: collision with root package name */
    private ActivityResultLauncher f19186o;

    /* renamed from: T1.t$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19187a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2194t f19188b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f19189c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C2194t tVar, String str, C2308e eVar) {
            super(2, eVar);
            this.f19188b = tVar;
            this.f19189c = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f19188b, this.f19189c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f19187a == 0) {
                u.b(obj);
                View inflate = this.f19188b.getLayoutInflater().inflate(g.uptodown_toast, (ViewGroup) null, false);
                View findViewById = inflate.findViewById(f.tv_text_uptodown_toast);
                String str = this.f19189c;
                TextView textView = (TextView) findViewById;
                textView.setTypeface(k.f32g.x());
                textView.setText(str);
                Toast toast = new Toast(this.f19188b);
                toast.setDuration(1);
                toast.setGravity(81, 0, 100);
                if (Build.VERSION.SDK_INT >= 30) {
                    toast.setView(inflate);
                } else {
                    toast.setView(inflate);
                }
                toast.show();
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public C2194t() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C2179l(this));
        t.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f19183l = registerForActivityResult;
        ActivityResultLauncher registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C2181m(this));
        t.d(registerForActivityResult2, "registerForActivityResult(...)");
        this.f19184m = registerForActivityResult2;
        ActivityResultLauncher registerForActivityResult3 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C2183n(this));
        t.d(registerForActivityResult3, "registerForActivityResult(...)");
        this.f19185n = registerForActivityResult3;
        ActivityResultLauncher registerForActivityResult4 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C2185o(this));
        t.d(registerForActivityResult4, "registerForActivityResult(...)");
        this.f19186o = registerForActivityResult4;
    }

    /* access modifiers changed from: private */
    public static final void B(C2194t tVar, View view) {
        Intent intent = new Intent(tVar.getApplicationContext(), FileExplorerActivity.class);
        intent.putExtra("select_path", 1);
        tVar.f19186o.launch(intent);
    }

    /* access modifiers changed from: private */
    public static final void C(C2194t tVar, String str, String str2, long j5, String str3, boolean z4, CompoundButton compoundButton, boolean z5) {
        tVar.x0(str, str2, j5, str3, z4);
    }

    /* access modifiers changed from: private */
    public static final void D(C2194t tVar, String str, String str2, long j5, String str3, boolean z4, CompoundButton compoundButton, boolean z5) {
        tVar.x0(str, str2, j5, str3, z4);
    }

    /* access modifiers changed from: private */
    public static final void E(C2194t tVar, String str, String str2, long j5, String str3, boolean z4, RadioGroup radioGroup, int i5) {
        tVar.x0(str, str2, j5, str3, z4);
    }

    /* access modifiers changed from: private */
    public static final void F(C2194t tVar, String str, String str2, long j5, String str3, boolean z4, RadioGroup radioGroup, int i5) {
        tVar.x0(str, str2, j5, str3, z4);
    }

    /* access modifiers changed from: private */
    public static final void G(C2194t tVar, View view) {
        TextView textView = tVar.f19180i;
        TextView textView2 = null;
        if (textView == null) {
            t.w("tvErrorPath");
            textView = null;
        }
        if (textView.getVisibility() == 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(tVar.getApplicationContext(), S1.a.core_shake);
            TextView textView3 = tVar.f19180i;
            if (textView3 == null) {
                t.w("tvErrorPath");
            } else {
                textView2 = textView3;
            }
            textView2.startAnimation(loadAnimation);
            return;
        }
        if (tVar.f19181j != null) {
            new C2201a(tVar).G(t.a(tVar.f19181j, Boolean.TRUE));
        }
        if (tVar.f19182k != null) {
            new C2201a(tVar).A(tVar.f19182k);
        }
        tVar.r0();
        AlertDialog alertDialog = tVar.f19172a;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        tVar.f19172a = null;
        tVar.Z();
    }

    /* access modifiers changed from: private */
    public static final void H(C2194t tVar, View view) {
        AlertDialog alertDialog = tVar.f19172a;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        tVar.f19172a = null;
    }

    /* access modifiers changed from: private */
    public static final void J(C2194t tVar, View view) {
        AlertDialog alertDialog = tVar.f19172a;
        t.b(alertDialog);
        alertDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void L(C2194t tVar, View view) {
        AlertDialog alertDialog = tVar.f19172a;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        tVar.p0();
    }

    /* access modifiers changed from: private */
    public static final void N(C2194t tVar, View view) {
        AlertDialog alertDialog = tVar.f19172a;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        tVar.o0();
    }

    /* access modifiers changed from: private */
    public static final void O(C2194t tVar, View view) {
        AlertDialog alertDialog = tVar.f19172a;
        t.b(alertDialog);
        alertDialog.dismiss();
        tVar.j0();
    }

    /* access modifiers changed from: private */
    public static final void P(C2194t tVar, ActivityResult activityResult) {
        t.b(activityResult);
        tVar.v0(activityResult);
    }

    private final String Q() {
        String string = getString(i.app_name);
        t.d(string, "getString(...)");
        return string;
    }

    private final long S() {
        try {
            PackageManager packageManager = getPackageManager();
            t.d(packageManager, "getPackageManager(...)");
            String packageName = getPackageName();
            t.d(packageName, "getPackageName(...)");
            return new C2290j().m(C2301u.d(packageManager, packageName, 0));
        } catch (PackageManager.NameNotFoundException e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    private final String T() {
        try {
            PackageManager packageManager = getPackageManager();
            t.d(packageManager, "getPackageManager(...)");
            String packageName = getPackageName();
            t.d(packageName, "getPackageName(...)");
            return C2301u.d(packageManager, packageName, 0).versionName;
        } catch (PackageManager.NameNotFoundException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static final void Y(C2194t tVar, ActivityResult activityResult) {
        if (tVar.V()) {
            tVar.h0();
        } else {
            tVar.f0();
        }
    }

    private final void r0() {
        String str;
        C2201a aVar = new C2201a(this);
        RadioButton radioButton = this.f19174c;
        RadioButton radioButton2 = null;
        if (radioButton == null) {
            t.w("rbAppName");
            radioButton = null;
        }
        aVar.v(radioButton.isChecked());
        RadioButton radioButton3 = this.f19175d;
        if (radioButton3 == null) {
            t.w("rbPackagename");
            radioButton3 = null;
        }
        aVar.w(radioButton3.isChecked());
        CheckBox checkBox = this.f19177f;
        if (checkBox == null) {
            t.w("cbVersioncode");
            checkBox = null;
        }
        aVar.x(checkBox.isChecked());
        CheckBox checkBox2 = this.f19178g;
        if (checkBox2 == null) {
            t.w("cbVersionname");
            checkBox2 = null;
        }
        aVar.y(checkBox2.isChecked());
        RadioButton radioButton4 = this.f19176e;
        if (radioButton4 == null) {
            t.w("rbXapkExtension");
        } else {
            radioButton2 = radioButton4;
        }
        if (radioButton2.isChecked()) {
            str = ".xapk";
        } else {
            str = ".apks";
        }
        aVar.z(str);
    }

    /* access modifiers changed from: private */
    public static final void s0(C2194t tVar, ActivityResult activityResult) {
        Uri uri;
        if (activityResult.getResultCode() == -1) {
            Intent data = activityResult.getData();
            Integer num = null;
            if (data != null) {
                uri = data.getData();
            } else {
                uri = null;
            }
            if (uri != null) {
                Intent data2 = activityResult.getData();
                if (data2 != null) {
                    num = Integer.valueOf(data2.getFlags());
                }
                if (num != null) {
                    num = Integer.valueOf(num.intValue() & 3);
                }
                ContentResolver contentResolver = tVar.getContentResolver();
                t.b(num);
                contentResolver.takePersistableUriPermission(uri, num.intValue());
                if (new C2290j().q(uri)) {
                    tVar.d0();
                } else {
                    tVar.e0();
                }
            } else {
                tVar.c0();
            }
        }
    }

    private final void v0(ActivityResult activityResult) {
        String str;
        Boolean bool;
        Uri uri;
        Boolean bool2;
        String str2;
        Bundle extras;
        Bundle extras2;
        Bundle extras3;
        if (activityResult.getResultCode() == 145) {
            Intent data = activityResult.getData();
            TextView textView = null;
            if (data == null || (extras3 = data.getExtras()) == null) {
                str = null;
            } else {
                str = extras3.getString("path_selected");
            }
            this.f19182k = str;
            Intent data2 = activityResult.getData();
            if (data2 == null || (extras2 = data2.getExtras()) == null) {
                bool = null;
            } else {
                bool = Boolean.valueOf(extras2.getBoolean("sdcard_selected"));
            }
            this.f19181j = bool;
            Intent data3 = activityResult.getData();
            if (data3 != null) {
                uri = data3.getData();
            } else {
                uri = null;
            }
            if (this.f19182k != null) {
                String str3 = this.f19182k;
                t.b(str3);
                File file = new File(str3);
                TextView textView2 = this.f19179h;
                if (textView2 == null) {
                    t.w("tvPath");
                    textView2 = null;
                }
                textView2.setText(this.f19182k);
                if (!file.exists() || !file.isDirectory() || !file.canWrite()) {
                    TextView textView3 = this.f19180i;
                    if (textView3 == null) {
                        t.w("tvErrorPath");
                    } else {
                        textView = textView3;
                    }
                    textView.setVisibility(0);
                    return;
                }
                TextView textView4 = this.f19180i;
                if (textView4 == null) {
                    t.w("tvErrorPath");
                } else {
                    textView = textView4;
                }
                textView.setVisibility(8);
            } else if (uri != null) {
                String lastPathSegment = uri.getLastPathSegment();
                Intent data4 = activityResult.getData();
                if (data4 == null || (extras = data4.getExtras()) == null) {
                    bool2 = null;
                } else {
                    bool2 = Boolean.valueOf(extras.getBoolean("sdcard_selected"));
                }
                this.f19181j = bool2;
                if (lastPathSegment != null) {
                    str2 = lastPathSegment.substring(s.l0(lastPathSegment, ":", 0, false, 6, (Object) null) + 1);
                    t.d(str2, "substring(...)");
                } else {
                    str2 = null;
                }
                this.f19182k = str2;
                if (t.a(this.f19181j, Boolean.TRUE)) {
                    TextView textView5 = this.f19179h;
                    if (textView5 == null) {
                        t.w("tvPath");
                        textView5 = null;
                    }
                    textView5.setText(getString(i.sd_card) + '/' + this.f19182k);
                } else {
                    TextView textView6 = this.f19179h;
                    if (textView6 == null) {
                        t.w("tvPath");
                        textView6 = null;
                    }
                    textView6.setText(getString(i.internal_storage) + '/' + this.f19182k);
                }
                DocumentFile fromSingleUri = DocumentFile.fromSingleUri(this, uri);
                if (fromSingleUri == null || !fromSingleUri.exists() || !fromSingleUri.isDirectory() || !fromSingleUri.canWrite()) {
                    TextView textView7 = this.f19180i;
                    if (textView7 == null) {
                        t.w("tvErrorPath");
                    } else {
                        textView = textView7;
                    }
                    textView.setVisibility(0);
                    return;
                }
                TextView textView8 = this.f19180i;
                if (textView8 == null) {
                    t.w("tvErrorPath");
                } else {
                    textView = textView8;
                }
                textView.setVisibility(8);
            } else {
                TextView textView9 = this.f19180i;
                if (textView9 == null) {
                    t.w("tvErrorPath");
                } else {
                    textView = textView9;
                }
                textView.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void w0(C2194t tVar, ActivityResult activityResult) {
        tVar.l0();
    }

    private final void x0(String str, String str2, long j5, String str3, boolean z4) {
        String str4;
        RadioButton radioButton = this.f19174c;
        TextView textView = null;
        if (radioButton == null) {
            t.w("rbAppName");
            radioButton = null;
        }
        if (radioButton.isChecked()) {
            if (str == null) {
                str = Q();
            }
        } else if (str2 != null) {
            str = str2;
        } else {
            str = getPackageName();
        }
        CheckBox checkBox = this.f19177f;
        if (checkBox == null) {
            t.w("cbVersioncode");
            checkBox = null;
        }
        if (checkBox.isChecked()) {
            if (j5 > -1) {
                str = str + '_' + j5;
            } else {
                str = str + '_' + S();
            }
        }
        CheckBox checkBox2 = this.f19178g;
        if (checkBox2 == null) {
            t.w("cbVersionname");
            checkBox2 = null;
        }
        if (checkBox2.isChecked()) {
            if (str3 != null) {
                str = str + '_' + str3;
            } else {
                str = str + '_' + T();
            }
        }
        if (z4) {
            RadioButton radioButton2 = this.f19176e;
            if (radioButton2 == null) {
                t.w("rbXapkExtension");
                radioButton2 = null;
            }
            if (radioButton2.isChecked()) {
                str4 = str + ".xapk";
            } else {
                str4 = str + ".apks";
            }
        } else {
            str4 = str + ".apk";
        }
        TextView textView2 = this.f19173b;
        if (textView2 == null) {
            t.w("tvResult");
        } else {
            textView = textView2;
        }
        textView.setText(str4);
    }

    public final void A(String str, String str2, long j5, String str3, boolean z4) {
        CheckBox checkBox;
        Window window;
        AlertDialog alertDialog = this.f19172a;
        if (!(alertDialog == null || alertDialog == null)) {
            alertDialog.dismiss();
        }
        View inflate = getLayoutInflater().inflate(g.dialog_path, (ViewGroup) null, false);
        k.a aVar = k.f32g;
        ((TextView) inflate.findViewById(f.tv_title_dialog_path)).setTypeface(aVar.w());
        TextView textView = (TextView) inflate.findViewById(f.tv_path_dialog_path);
        this.f19179h = textView;
        if (textView == null) {
            t.w("tvPath");
            textView = null;
        }
        textView.setTypeface(aVar.x());
        if (new C2201a(this).o()) {
            TextView textView2 = this.f19179h;
            if (textView2 == null) {
                t.w("tvPath");
                textView2 = null;
            }
            textView2.setText(getString(i.sd_card) + '/' + new C2201a(this).d());
        } else {
            TextView textView3 = this.f19179h;
            if (textView3 == null) {
                t.w("tvPath");
                textView3 = null;
            }
            textView3.setText(new C2201a(this).d());
        }
        TextView textView4 = (TextView) inflate.findViewById(f.tv_error_path);
        this.f19180i = textView4;
        if (textView4 == null) {
            t.w("tvErrorPath");
            textView4 = null;
        }
        textView4.setTypeface(aVar.x());
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(f.rl_path_dialog);
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new C2165e(this));
        }
        ((TextView) inflate.findViewById(f.tv_name_format_dialog_path)).setTypeface(aVar.w());
        RadioGroup radioGroup = (RadioGroup) inflate.findViewById(f.rg_name_format);
        RadioButton radioButton = (RadioButton) inflate.findViewById(f.rb_option_appname);
        this.f19174c = radioButton;
        if (radioButton == null) {
            t.w("rbAppName");
            radioButton = null;
        }
        radioButton.setTypeface(aVar.x());
        RadioButton radioButton2 = (RadioButton) inflate.findViewById(f.rb_option_packagename);
        this.f19175d = radioButton2;
        if (radioButton2 == null) {
            t.w("rbPackagename");
            radioButton2 = null;
        }
        radioButton2.setTypeface(aVar.x());
        CheckBox checkBox2 = (CheckBox) inflate.findViewById(f.cb_versioncode);
        this.f19177f = checkBox2;
        if (checkBox2 == null) {
            t.w("cbVersioncode");
            checkBox2 = null;
        }
        checkBox2.setTypeface(aVar.x());
        CheckBox checkBox3 = (CheckBox) inflate.findViewById(f.cb_versionname);
        this.f19178g = checkBox3;
        if (checkBox3 == null) {
            t.w("cbVersionname");
            checkBox3 = null;
        }
        checkBox3.setTypeface(aVar.x());
        C2201a aVar2 = new C2201a(this);
        RadioButton radioButton3 = this.f19174c;
        if (radioButton3 == null) {
            t.w("rbAppName");
            radioButton3 = null;
        }
        radioButton3.setChecked(aVar2.i());
        RadioButton radioButton4 = this.f19175d;
        if (radioButton4 == null) {
            t.w("rbPackagename");
            radioButton4 = null;
        }
        radioButton4.setChecked(aVar2.j());
        CheckBox checkBox4 = this.f19177f;
        if (checkBox4 == null) {
            t.w("cbVersioncode");
            checkBox4 = null;
        }
        checkBox4.setChecked(aVar2.k());
        CheckBox checkBox5 = this.f19178g;
        if (checkBox5 == null) {
            t.w("cbVersionname");
            checkBox5 = null;
        }
        checkBox5.setChecked(aVar2.l());
        TextView textView5 = (TextView) inflate.findViewById(f.tv_extension_dialog_path);
        RadioGroup radioGroup2 = (RadioGroup) inflate.findViewById(f.rg_extension);
        this.f19176e = (RadioButton) inflate.findViewById(f.rb_xapk_extension);
        if (z4) {
            textView5.setTypeface(aVar.w());
            RadioButton radioButton5 = this.f19176e;
            if (radioButton5 == null) {
                t.w("rbXapkExtension");
                radioButton5 = null;
            }
            radioButton5.setTypeface(aVar.x());
            RadioButton radioButton6 = this.f19176e;
            if (radioButton6 == null) {
                t.w("rbXapkExtension");
                radioButton6 = null;
            }
            radioButton6.setText(".xapk");
            View findViewById = inflate.findViewById(f.rb_apks_extension);
            t.d(findViewById, "findViewById(...)");
            RadioButton radioButton7 = (RadioButton) findViewById;
            radioButton7.setTypeface(aVar.x());
            radioButton7.setText(".apks");
            String b5 = aVar2.b();
            RadioButton radioButton8 = this.f19176e;
            if (radioButton8 == null) {
                t.w("rbXapkExtension");
                radioButton8 = null;
            }
            radioButton8.setChecked(s.E(b5, ".xapk", true));
            RadioButton radioButton9 = this.f19176e;
            if (radioButton9 == null) {
                t.w("rbXapkExtension");
                radioButton9 = null;
            }
            radioButton7.setChecked(!radioButton9.isChecked());
        } else {
            textView5.setVisibility(8);
            radioGroup2.setVisibility(8);
        }
        ((TextView) inflate.findViewById(f.tv_result_title_dialog_path)).setTypeface(aVar.x());
        TextView textView6 = (TextView) inflate.findViewById(f.tv_result_dialog_path);
        this.f19173b = textView6;
        if (textView6 == null) {
            t.w("tvResult");
            textView6 = null;
        }
        textView6.setTypeface(aVar.w());
        x0(str, str2, j5, str3, z4);
        CheckBox checkBox6 = this.f19177f;
        if (checkBox6 == null) {
            t.w("cbVersioncode");
            checkBox6 = null;
        }
        checkBox6.setOnCheckedChangeListener(new C2167f(this, str, str2, j5, str3, z4));
        CheckBox checkBox7 = this.f19178g;
        if (checkBox7 == null) {
            t.w("cbVersionname");
            checkBox = null;
        } else {
            checkBox = checkBox7;
        }
        String str4 = str;
        String str5 = str2;
        long j6 = j5;
        String str6 = str3;
        boolean z5 = z4;
        checkBox.setOnCheckedChangeListener(new C2169g(this, str4, str5, j6, str6, z5));
        radioGroup.setOnCheckedChangeListener(new C2171h(this, str4, str5, j6, str6, z5));
        radioGroup2.setOnCheckedChangeListener(new C2173i(this, str4, str5, j6, str6, z5));
        View findViewById2 = inflate.findViewById(f.tv_ok_dialog_path);
        t.d(findViewById2, "findViewById(...)");
        TextView textView7 = (TextView) findViewById2;
        textView7.setTypeface(aVar.w());
        textView7.setOnClickListener(new C2175j(this));
        View findViewById3 = inflate.findViewById(f.tv_cancel_dialog_path);
        t.d(findViewById3, "findViewById(...)");
        TextView textView8 = (TextView) findViewById3;
        textView8.setTypeface(aVar.w());
        textView8.setOnClickListener(new C2177k(this));
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(inflate);
        AlertDialog create = builder.create();
        this.f19172a = create;
        if (!(create == null || (window = create.getWindow()) == null)) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        AlertDialog alertDialog2 = this.f19172a;
        if (alertDialog2 != null) {
            alertDialog2.show();
        }
    }

    public final void I(String str) {
        AlertDialog alertDialog = this.f19172a;
        if (alertDialog != null) {
            t.b(alertDialog);
            alertDialog.dismiss();
        }
        View inflate = getLayoutInflater().inflate(g.dialog_accept, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(f.tv_dialog_accept_msg);
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.x());
        if (str == null) {
            textView.setText(getString(i.error_unknown));
        } else {
            textView.setText(str);
        }
        TextView textView2 = (TextView) inflate.findViewById(f.tv_accept_option);
        textView2.setTypeface(aVar.w());
        textView2.setOnClickListener(new r(this));
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(inflate);
        builder.setCancelable(false);
        this.f19172a = builder.create();
        if (!isFinishing()) {
            AlertDialog alertDialog2 = this.f19172a;
            t.b(alertDialog2);
            Window window = alertDialog2.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            AlertDialog alertDialog3 = this.f19172a;
            t.b(alertDialog3);
            alertDialog3.show();
        }
    }

    public final void K() {
        AlertDialog alertDialog;
        AlertDialog alertDialog2 = this.f19172a;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
        View inflate = getLayoutInflater().inflate(g.dialog_accept, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(f.tv_dialog_accept_msg);
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.x());
        textView.setText(getString(i.msg_request_permissions_write_external_storage));
        TextView textView2 = (TextView) inflate.findViewById(f.tv_accept_option);
        textView2.setTypeface(aVar.w());
        textView2.setOnClickListener(new C2192s(this));
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(inflate);
        builder.setCancelable(false);
        this.f19172a = builder.create();
        if (!isFinishing() && (alertDialog = this.f19172a) != null) {
            alertDialog.show();
        }
    }

    public final void M() {
        try {
            if (!X()) {
                AlertDialog alertDialog = this.f19172a;
                if (alertDialog != null) {
                    t.b(alertDialog);
                    alertDialog.dismiss();
                }
                View inflate = getLayoutInflater().inflate(g.dialog_title_accept_cancel, (ViewGroup) null, false);
                TextView textView = (TextView) inflate.findViewById(f.tv_dialog_title);
                k.a aVar = k.f32g;
                textView.setTypeface(aVar.w());
                int i5 = i.title_unknown_source_dialog;
                int i6 = i.app_name;
                textView.setText(getString(i5, new Object[]{getString(i6)}));
                TextView textView2 = (TextView) inflate.findViewById(f.tv_dialog_msg);
                textView2.setTypeface(aVar.x());
                textView2.setText(getString(i.msg_install_from_unknown_source, new Object[]{getString(i6)}));
                TextView textView3 = (TextView) inflate.findViewById(f.tv_accept_option);
                textView3.setTypeface(aVar.w());
                textView3.setOnClickListener(new C2187p(this));
                TextView textView4 = (TextView) inflate.findViewById(f.tv_cancel_option);
                textView4.setTypeface(aVar.w());
                textView4.setOnClickListener(new C2189q(this));
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setView(inflate);
                AlertDialog create = builder.create();
                this.f19172a = create;
                t.b(create);
                Window window = create.getWindow();
                if (window != null) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                }
                if (!isFinishing()) {
                    AlertDialog alertDialog2 = this.f19172a;
                    t.b(alertDialog2);
                    alertDialog2.show();
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final AlertDialog R() {
        return this.f19172a;
    }

    public final boolean U() {
        if (Build.VERSION.SDK_INT >= 33 || ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return true;
        }
        return false;
    }

    public final boolean V() {
        if (Build.VERSION.SDK_INT >= 30) {
            return Environment.isExternalStorageManager();
        }
        return U();
    }

    public final boolean W() {
        if (Build.VERSION.SDK_INT < 33 || ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") == 0) {
            return true;
        }
        return false;
    }

    public final boolean X() {
        if (Build.VERSION.SDK_INT >= 26) {
            return getPackageManager().canRequestPackageInstalls();
        }
        if (Settings.Secure.getInt(getContentResolver(), "install_non_market_apps", 0) == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        if (context != null) {
            context = k.f32g.a(context);
        }
        super.attachBaseContext(context);
    }

    public abstract void c0();

    public abstract void d0();

    public abstract void e0();

    public abstract void f0();

    public abstract void h0();

    public final void m0() {
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.POST_NOTIFICATIONS"}, 646);
        new C2201a(this).F(true);
    }

    public final void n0() {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
        intent.addFlags(195);
        intent.putExtra("android.content.extra.SHOW_ADVANCED", true);
        intent.putExtra("android.content.extra.FANCY", true);
        intent.putExtra("android.content.extra.SHOW_FILESIZE", true);
        this.f19184m.launch(intent);
    }

    public final void o0() {
        try {
            if (Build.VERSION.SDK_INT < 26) {
                this.f19185n.launch(new Intent("android.settings.SECURITY_SETTINGS"));
                return;
            }
            ActivityResultLauncher activityResultLauncher = this.f19185n;
            activityResultLauncher.launch(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + getPackageName())));
        } catch (ActivityNotFoundException e5) {
            e5.printStackTrace();
            k0();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        k.a aVar = k.f32g;
        if (!aVar.y()) {
            aVar.G(true);
            aVar.U(aVar.A(this));
        }
        if (aVar.z()) {
            setRequestedOrientation(-1);
        }
    }

    public void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        t.e(strArr, "permissions");
        t.e(iArr, "grantResults");
        super.onRequestPermissionsResult(i5, strArr, iArr);
        boolean z4 = true;
        if (i5 == 645) {
            if (iArr.length != 0) {
                z4 = false;
            }
            if (z4 || iArr[0] != 0) {
                g0();
            } else {
                i0();
            }
        } else if (i5 == 646) {
            if (iArr.length != 0) {
                z4 = false;
            }
            if (z4 || iArr[0] != 0) {
                a0();
            } else {
                b0();
            }
        }
    }

    public final void p0() {
        if (Build.VERSION.SDK_INT >= 30) {
            if (!Environment.isExternalStorageManager()) {
                try {
                    this.f19183l.launch(new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION", Uri.parse("package:" + getPackageName())));
                } catch (ActivityNotFoundException e5) {
                    e5.printStackTrace();
                    q0();
                }
            } else if (!U()) {
                q0();
            }
        } else if (!U()) {
            q0();
        }
    }

    public final void q0() {
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 645);
    }

    public final void t0(AlertDialog alertDialog) {
        this.f19172a = alertDialog;
    }

    public final void u0(String str) {
        t.e(str, NotificationCompat.CATEGORY_MESSAGE);
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (O) null, new a(this, str, (C2308e) null), 2, (Object) null);
    }

    public void Z() {
    }

    public void a0() {
    }

    public void b0() {
    }

    public void g0() {
    }

    public void i0() {
    }

    public void j0() {
    }

    public void k0() {
    }

    public void l0() {
    }
}
