package com.mbridge.msdk.newreward.player.view.floatview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.newreward.player.presenter.AbsPresenter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;

public class AlertTempleView extends FrameLayout {
    public static final int TYPE_IV = 0;
    public static final int TYPE_PL = 2;
    public static final int TYPE_RV = 1;
    private final String TAG = "AlertTempleView";
    private final View.OnClickListener buttonClickListener = new View.OnClickListener() {
        public void onClick(View view) {
            AbsPresenter absPresenter = AlertTempleView.this.mPresenter;
            if (absPresenter != null) {
                absPresenter.click(view);
            }
        }
    };
    String closeBtnText = "";
    Button closeButton;
    String content = "";
    TextView contentView;
    String continueBtnText = "";
    Button continueButton;
    public AbsPresenter mPresenter;
    String title = "";
    TextView titleView;

    @Retention(RetentionPolicy.SOURCE)
    @interface AlertType {
    }

    public AlertTempleView(@NonNull Context context, AbsPresenter absPresenter) {
        super(context);
        this.mPresenter = absPresenter;
        initView();
    }

    private void initView() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setBackgroundColor(-1073741824);
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
        View inflate = LayoutInflater.from(getContext()).inflate(x.a(getContext(), "mbridge_alertview_layout", TtmlNode.TAG_LAYOUT), this, true);
        if (inflate != null) {
            this.titleView = (TextView) inflate.findViewById(x.a(getContext(), "mbridge_alertview_titleview", "id"));
            this.contentView = (TextView) inflate.findViewById(x.a(getContext(), "mbridge_alertview_contentview", "id"));
            this.closeButton = (Button) inflate.findViewById(x.a(getContext(), "mbridge_alertview_close_button", "id"));
            this.continueButton = (Button) inflate.findViewById(x.a(getContext(), "mbridge_alertview_continue_button", "id"));
            this.closeButton.setOnClickListener(this.buttonClickListener);
            this.continueButton.setOnClickListener(this.buttonClickListener);
        }
    }

    private void setIVAlertViewContent(int i5, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        try {
            Context context = getContext();
            this.title = an.a(context, "MBridge_ConfirmTitle" + str, "").toString();
            Context context2 = getContext();
            this.content = an.a(context2, "MBridge_ConfirmContent" + str, "").toString();
            Context context3 = getContext();
            this.continueBtnText = an.a(context3, "MBridge_CancelText" + str, "").toString();
            Context context4 = getContext();
            this.closeBtnText = an.a(context4, "MBridge_ConfirmText" + str, "").toString();
        } catch (Exception e5) {
            af.a("AlertTempleView", e5.getMessage());
        }
        if (TextUtils.isEmpty(this.title) && TextUtils.isEmpty(this.content) && TextUtils.isEmpty(this.closeBtnText) && TextUtils.isEmpty(this.continueBtnText)) {
            String language = Locale.getDefault().getLanguage();
            if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                int i6 = a.f9165H;
                if (i5 == i6) {
                    str2 = "Confirm";
                } else {
                    str2 = "Tips";
                }
                this.title = str2;
                if (i5 == i6) {
                    str3 = "If you choose to continue, you will receive a reward after the end. Confirm closed?";
                } else {
                    str3 = "If you choose to continue, you will receive a reward after the end. Whether to continue?";
                }
                this.content = str3;
                this.continueBtnText = "Continue";
                if (i5 == i6) {
                    str4 = "Close";
                } else {
                    str4 = "Cancel";
                }
                this.closeBtnText = str4;
            } else {
                int i7 = a.f9165H;
                if (i5 == i7) {
                    str5 = "确认关闭？";
                } else {
                    str5 = "提示";
                }
                this.title = str5;
                if (i5 == i7) {
                    str6 = "如果你选择继续，结束后将会获得奖励。确认关闭吗？";
                } else {
                    str6 = "如果你选择继续，结束后将会获得奖励。是否继续？";
                }
                this.content = str6;
                this.continueBtnText = "继续";
                if (i5 == i7) {
                    str7 = "确认关闭";
                } else {
                    str7 = "取消";
                }
                this.closeBtnText = str7;
            }
        }
        setViewContent(this.title, this.content, this.closeBtnText, this.continueBtnText);
    }

    private void setPlayableAlertViewContent() {
        g b5 = h.a().b(c.m().k());
        this.title = b5.z();
        this.content = b5.x();
        this.continueBtnText = b5.v();
        this.closeBtnText = b5.y();
        String language = Locale.getDefault().getLanguage();
        if (TextUtils.isEmpty(this.title) && TextUtils.isEmpty(this.content) && TextUtils.isEmpty(this.closeBtnText) && TextUtils.isEmpty(this.continueBtnText)) {
            if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                this.title = "Confirm to close? ";
                this.content = "You will not be rewarded after closing the window";
                this.closeBtnText = "Close it";
                this.continueBtnText = "Continue";
            } else {
                this.title = "确认关闭？";
                this.content = "关闭后您将不会获得任何奖励噢~ ";
                this.closeBtnText = "确认关闭";
                this.continueBtnText = "继续试玩";
            }
        }
        setViewContent(this.title, this.content, this.closeBtnText, this.continueBtnText);
    }

    private void setRVAlertViewContent(String str) {
        try {
            Context context = getContext();
            this.title = an.a(context, "MBridge_ConfirmTitle" + str, "").toString();
            Context context2 = getContext();
            this.content = an.a(context2, "MBridge_ConfirmContent" + str, "").toString();
            Context context3 = getContext();
            this.continueBtnText = an.a(context3, "MBridge_CancelText" + str, "").toString();
            Context context4 = getContext();
            this.closeBtnText = an.a(context4, "MBridge_ConfirmText" + str, "").toString();
            g b5 = h.a().b(c.m().k());
            if (TextUtils.isEmpty(this.title) && TextUtils.isEmpty(this.content) && TextUtils.isEmpty(this.closeBtnText) && TextUtils.isEmpty(this.continueBtnText) && b5 != null) {
                this.title = b5.z();
                this.content = b5.x();
                this.closeBtnText = b5.y();
                this.continueBtnText = b5.w();
            }
            if (TextUtils.isEmpty(this.title) && TextUtils.isEmpty(this.content) && TextUtils.isEmpty(this.closeBtnText) && TextUtils.isEmpty(this.continueBtnText)) {
                String language = Locale.getDefault().getLanguage();
                if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                    this.title = "Confirm to close? ";
                    this.content = "You will not be rewarded after closing the window";
                    this.continueBtnText = "Continue";
                    this.closeBtnText = "Close it";
                } else {
                    this.title = "确认关闭？";
                    this.content = "关闭后您将不会获得任何奖励噢~ ";
                    this.continueBtnText = "继续观看";
                    this.closeBtnText = "确认关闭";
                }
            }
            setViewContent(this.title, this.content, this.closeBtnText, this.continueBtnText);
        } catch (Exception e5) {
            af.a("AlertTempleView", e5.getMessage());
        }
    }

    private void setViewContent(String str, String str2, String str3, String str4) {
        this.titleView.setText(str);
        this.contentView.setText(str2);
        this.closeButton.setText(str3);
        this.continueButton.setText(str4);
    }

    public void setAlertType(int i5, String str, int i6) {
        if (i5 == 0) {
            setIVAlertViewContent(i6, str);
        } else if (i5 == 1) {
            setRVAlertViewContent(str);
        } else if (i5 == 2) {
            setPlayableAlertViewContent();
        }
    }

    public void setPresenter(AbsPresenter absPresenter) {
        this.mPresenter = absPresenter;
    }

    public AlertTempleView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }
}
