package com.mbridge.msdk.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.x;

public class MBFeedBackDialog extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private Button f13222a;

    /* renamed from: b  reason: collision with root package name */
    private Button f13223b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f13224c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public a f13225d;

    /* renamed from: e  reason: collision with root package name */
    private Button f13226e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f13227f;

    /* renamed from: g  reason: collision with root package name */
    private int f13228g;

    /* renamed from: h  reason: collision with root package name */
    private int f13229h;

    public MBFeedBackDialog(Context context, a aVar) {
        super(context);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        requestWindowFeature(1);
        View inflate = LayoutInflater.from(context).inflate(x.a(context, "mbridge_cm_feedbackview", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
        setDialogWidthAndHeight(0.5f, 0.8f);
        this.f13225d = aVar;
        if (inflate != null) {
            setContentView(inflate);
            try {
                this.f13227f = (TextView) inflate.findViewById(x.a(context, "mbridge_video_common_alertview_titleview", "id"));
            } catch (Exception e5) {
                af.a("MBAlertDialog", e5.getMessage());
            }
            try {
                this.f13224c = (LinearLayout) inflate.findViewById(x.a(context, "mbridge_video_common_alertview_contentview", "id"));
                this.f13223b = (Button) inflate.findViewById(x.a(context, "mbridge_video_common_alertview_confirm_button", "id"));
                this.f13222a = (Button) inflate.findViewById(x.a(context, "mbridge_video_common_alertview_cancel_button", "id"));
                this.f13226e = (Button) inflate.findViewById(x.a(context, "mbridge_video_common_alertview_private_action_button", "id"));
            } catch (Exception e6) {
                af.a("MBAlertDialog", e6.getMessage());
            }
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        Button button = this.f13222a;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (MBFeedBackDialog.this.f13225d != null) {
                        MBFeedBackDialog.this.f13225d.a();
                    }
                    MBFeedBackDialog.this.dismiss();
                }
            });
        }
        Button button2 = this.f13223b;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (MBFeedBackDialog.this.f13225d != null) {
                        MBFeedBackDialog.this.f13225d.b();
                    }
                    MBFeedBackDialog.this.dismiss();
                }
            });
        }
        Button button3 = this.f13226e;
        if (button3 != null) {
            button3.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    MBFeedBackDialog.this.dismiss();
                    if (MBFeedBackDialog.this.f13225d != null) {
                        MBFeedBackDialog.this.f13225d.c();
                    }
                }
            });
        }
        setOnCancelListener(new DialogInterface.OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                if (MBFeedBackDialog.this.f13225d != null) {
                    MBFeedBackDialog.this.f13225d.b();
                }
            }
        });
    }

    public static boolean isScreenOrientationPortrait(Context context) {
        if (context.getResources().getConfiguration().orientation == 1) {
            return true;
        }
        return false;
    }

    public void clear() {
        if (this.f13225d != null) {
            this.f13225d = null;
        }
    }

    public a getListener() {
        return this.f13225d;
    }

    public void hideNavigationBar(Window window) {
        if (window != null) {
            window.setFlags(1024, 1024);
            int i5 = Build.VERSION.SDK_INT;
            window.addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
            window.getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
            if (i5 >= 28) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                window.setAttributes(attributes);
            }
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-1, -1);
            window.setGravity(17);
        }
    }

    public void setCancelButtonClickable(boolean z4) {
        Button button = this.f13222a;
        if (button != null) {
            button.setClickable(z4);
            if (z4) {
                this.f13222a.setBackgroundResource(getContext().getResources().getIdentifier("mbridge_cm_feedback_choice_btn_bg_pressed", "drawable", c.m().g()));
                this.f13222a.setAlpha(1.0f);
                return;
            }
            this.f13222a.setBackgroundResource(getContext().getResources().getIdentifier("mbridge_cm_feedback_choice_btn_bg_pressed", "drawable", c.m().g()));
            this.f13222a.setAlpha(0.4f);
        }
    }

    public void setCancelText(String str) {
        Button button = this.f13222a;
        if (button != null) {
            button.setText(str);
        }
    }

    public void setConfirmText(String str) {
    }

    public void setContent(ViewGroup viewGroup) {
        LinearLayout linearLayout = this.f13224c;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(viewGroup);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.leftMargin = ak.a(c.m().c(), 16.0f);
            layoutParams.rightMargin = ak.a(c.m().c(), 16.0f);
            layoutParams.topMargin = ak.a(c.m().c(), 3.0f);
            layoutParams.bottomMargin = ak.a(c.m().c(), 3.0f);
            this.f13224c.addView(viewGroup, layoutParams);
        }
    }

    public void setDialogWidthAndHeight(float f5, float f6) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        if (isScreenOrientationPortrait(getContext())) {
            this.f13229h = displayMetrics.widthPixels;
            this.f13228g = displayMetrics.heightPixels;
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = (int) (((float) this.f13228g) * f6);
            attributes.gravity = 80;
            getWindow().setAttributes(attributes);
            return;
        }
        this.f13229h = displayMetrics.heightPixels;
        this.f13228g = displayMetrics.widthPixels;
        WindowManager.LayoutParams attributes2 = getWindow().getAttributes();
        attributes2.width = (int) (((float) this.f13228g) * f5);
        attributes2.height = -1;
        attributes2.gravity = 17;
        getWindow().setAttributes(attributes2);
    }

    public void setListener(a aVar) {
        this.f13225d = aVar;
    }

    public void setPrivacyText(String str) {
        Button button = this.f13226e;
        if (button != null) {
            button.setText(str);
        }
    }

    public void setTitle(String str) {
        TextView textView = this.f13227f;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void show() {
        super.show();
        try {
            getWindow().setFlags(8, 8);
            super.show();
            hideNavigationBar(getWindow());
            getWindow().clearFlags(8);
        } catch (Exception e5) {
            af.b("MBAlertDialog", e5.getMessage());
            super.show();
        }
    }
}
