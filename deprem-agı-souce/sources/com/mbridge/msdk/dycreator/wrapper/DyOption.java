package com.mbridge.msdk.dycreator.wrapper;

import com.mbridge.msdk.dycreator.listener.DyCountDownListenerWrapper;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.util.List;

public class DyOption {

    /* renamed from: a  reason: collision with root package name */
    private List<String> f8720a;

    /* renamed from: b  reason: collision with root package name */
    private File f8721b;

    /* renamed from: c  reason: collision with root package name */
    private CampaignEx f8722c;

    /* renamed from: d  reason: collision with root package name */
    private DyAdType f8723d;

    /* renamed from: e  reason: collision with root package name */
    private String f8724e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f8725f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f8726g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f8727h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f8728i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f8729j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f8730k;

    /* renamed from: l  reason: collision with root package name */
    private int f8731l;

    /* renamed from: m  reason: collision with root package name */
    private int f8732m;

    /* renamed from: n  reason: collision with root package name */
    private int f8733n;

    /* renamed from: o  reason: collision with root package name */
    private int f8734o;

    /* renamed from: p  reason: collision with root package name */
    private int f8735p;

    /* renamed from: q  reason: collision with root package name */
    private int f8736q;

    /* renamed from: r  reason: collision with root package name */
    private DyCountDownListenerWrapper f8737r;

    public static class Builder implements IViewOptionBuilder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public List<String> f8738a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public File f8739b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public CampaignEx f8740c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public DyAdType f8741d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public boolean f8742e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public String f8743f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public boolean f8744g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public boolean f8745h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public boolean f8746i;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public boolean f8747j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public boolean f8748k;
        /* access modifiers changed from: private */

        /* renamed from: l  reason: collision with root package name */
        public int f8749l;
        /* access modifiers changed from: private */

        /* renamed from: m  reason: collision with root package name */
        public int f8750m;
        /* access modifiers changed from: private */

        /* renamed from: n  reason: collision with root package name */
        public int f8751n;
        /* access modifiers changed from: private */

        /* renamed from: o  reason: collision with root package name */
        public int f8752o;
        /* access modifiers changed from: private */

        /* renamed from: p  reason: collision with root package name */
        public int f8753p;

        public IViewOptionBuilder adChoiceLink(String str) {
            this.f8743f = str;
            return this;
        }

        public DyOption build() {
            return new DyOption(this);
        }

        public IViewOptionBuilder campaignEx(CampaignEx campaignEx) {
            this.f8740c = campaignEx;
            return this;
        }

        public IViewOptionBuilder canSkip(boolean z4) {
            this.f8742e = z4;
            return this;
        }

        public IViewOptionBuilder countDownTime(int i5) {
            this.f8752o = i5;
            return this;
        }

        public IViewOptionBuilder dyAdType(DyAdType dyAdType) {
            this.f8741d = dyAdType;
            return this;
        }

        public IViewOptionBuilder file(File file) {
            this.f8739b = file;
            return this;
        }

        public IViewOptionBuilder fileDirs(List<String> list) {
            this.f8738a = list;
            return this;
        }

        public IViewOptionBuilder isApkInfoVisible(boolean z4) {
            this.f8747j = z4;
            return this;
        }

        public IViewOptionBuilder isClickButtonVisible(boolean z4) {
            this.f8745h = z4;
            return this;
        }

        public IViewOptionBuilder isLogoVisible(boolean z4) {
            this.f8748k = z4;
            return this;
        }

        public IViewOptionBuilder isScreenClick(boolean z4) {
            this.f8744g = z4;
            return this;
        }

        public IViewOptionBuilder isShakeVisible(boolean z4) {
            this.f8746i = z4;
            return this;
        }

        public IViewOptionBuilder orientation(int i5) {
            this.f8751n = i5;
            return this;
        }

        public IViewOptionBuilder shakeStrenght(int i5) {
            this.f8749l = i5;
            return this;
        }

        public IViewOptionBuilder shakeTime(int i5) {
            this.f8750m = i5;
            return this;
        }

        public IViewOptionBuilder templateType(int i5) {
            this.f8753p = i5;
            return this;
        }
    }

    public interface IViewOptionBuilder {
        IViewOptionBuilder adChoiceLink(String str);

        DyOption build();

        IViewOptionBuilder campaignEx(CampaignEx campaignEx);

        IViewOptionBuilder canSkip(boolean z4);

        IViewOptionBuilder countDownTime(int i5);

        IViewOptionBuilder dyAdType(DyAdType dyAdType);

        IViewOptionBuilder file(File file);

        IViewOptionBuilder fileDirs(List<String> list);

        IViewOptionBuilder isApkInfoVisible(boolean z4);

        IViewOptionBuilder isClickButtonVisible(boolean z4);

        IViewOptionBuilder isLogoVisible(boolean z4);

        IViewOptionBuilder isScreenClick(boolean z4);

        IViewOptionBuilder isShakeVisible(boolean z4);

        IViewOptionBuilder orientation(int i5);

        IViewOptionBuilder shakeStrenght(int i5);

        IViewOptionBuilder shakeTime(int i5);

        IViewOptionBuilder templateType(int i5);
    }

    public DyOption(Builder builder) {
        this.f8720a = builder.f8738a;
        this.f8721b = builder.f8739b;
        this.f8722c = builder.f8740c;
        this.f8723d = builder.f8741d;
        this.f8726g = builder.f8742e;
        this.f8724e = builder.f8743f;
        this.f8725f = builder.f8744g;
        this.f8727h = builder.f8745h;
        this.f8729j = builder.f8747j;
        this.f8728i = builder.f8746i;
        this.f8730k = builder.f8748k;
        this.f8731l = builder.f8749l;
        this.f8732m = builder.f8750m;
        this.f8733n = builder.f8751n;
        this.f8734o = builder.f8752o;
        this.f8736q = builder.f8753p;
    }

    public String getAdChoiceLink() {
        return this.f8724e;
    }

    public CampaignEx getCampaignEx() {
        return this.f8722c;
    }

    public int getCountDownTime() {
        return this.f8734o;
    }

    public int getCurrentCountDown() {
        return this.f8735p;
    }

    public DyAdType getDyAdType() {
        return this.f8723d;
    }

    public File getFile() {
        return this.f8721b;
    }

    public List<String> getFileDirs() {
        return this.f8720a;
    }

    public int getOrientation() {
        return this.f8733n;
    }

    public int getShakeStrenght() {
        return this.f8731l;
    }

    public int getShakeTime() {
        return this.f8732m;
    }

    public int getTemplateType() {
        return this.f8736q;
    }

    public boolean isApkInfoVisible() {
        return this.f8729j;
    }

    public boolean isCanSkip() {
        return this.f8726g;
    }

    public boolean isClickButtonVisible() {
        return this.f8727h;
    }

    public boolean isClickScreen() {
        return this.f8725f;
    }

    public boolean isLogoVisible() {
        return this.f8730k;
    }

    public boolean isShakeVisible() {
        return this.f8728i;
    }

    public void setDyCountDownListener(int i5) {
        DyCountDownListenerWrapper dyCountDownListenerWrapper = this.f8737r;
        if (dyCountDownListenerWrapper != null) {
            dyCountDownListenerWrapper.getCountDownValue(i5);
        }
        this.f8735p = i5;
    }

    public void setDyCountDownListenerWrapper(DyCountDownListenerWrapper dyCountDownListenerWrapper) {
        this.f8737r = dyCountDownListenerWrapper;
    }
}
