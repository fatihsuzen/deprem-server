package com.mbridge.msdk.out;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.c.b;
import com.mbridge.msdk.foundation.same.c.c;
import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;

abstract class BaseCampaign implements c, NoProGuard, Serializable {
    public static final int TYPE_BIG = 3;
    public static final int TYPE_ICON = 2;
    public static final int TYPE_MB = 1;
    private static final long serialVersionUID = 1;
    public String adCall;
    private int adchoiceSizeHeight = 0;
    private int adchoiceSizeWidth = 0;
    private String appDesc = "";
    private String appName = "";
    private Drawable bigDrawable;
    private long creativeId = 0;
    private Drawable iconDrawable;
    private String iconUrl = "";
    private String id = "";
    private String imageUrl = "";
    private OnImageLoadListener mOnImageLoadListener;
    private Object nativead;
    private int numberRating = 33333;
    private String packageName = "";
    private double rating;
    private String size = "";
    private String subType;
    private long timestamp = 0;
    private int type = 1;
    private int videoLength = 0;

    BaseCampaign() {
    }

    private Drawable BitmapToDrawable(Bitmap bitmap) {
        return new BitmapDrawable(bitmap);
    }

    public String getAdCall() {
        return this.adCall;
    }

    public int getAdchoiceSizeHeight() {
        return this.adchoiceSizeHeight;
    }

    public int getAdchoiceSizeWidth() {
        return this.adchoiceSizeWidth;
    }

    public String getAppDesc() {
        return this.appDesc;
    }

    public String getAppName() {
        return this.appName;
    }

    public Drawable getBigDrawable() {
        return this.bigDrawable;
    }

    public long getCreativeId() {
        return this.creativeId;
    }

    public Drawable getIconDrawable() {
        return this.iconDrawable;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getId() {
        return this.id;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public Object getNativead() {
        return this.nativead;
    }

    public int getNumberRating() {
        return this.numberRating;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public double getRating() {
        return this.rating;
    }

    public String getSize() {
        return this.size;
    }

    public String getSubType() {
        return this.subType;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public int getType() {
        return this.type;
    }

    public int getVideoLength() {
        return this.videoLength;
    }

    public void loadIconUrlAsyncWithBlock(OnImageLoadListener onImageLoadListener) {
        this.mOnImageLoadListener = onImageLoadListener;
        if (!TextUtils.isEmpty(getIconUrl())) {
            b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(getIconUrl(), this);
        }
    }

    public void loadImageUrlAsyncWithBlock(OnImageLoadListener onImageLoadListener) {
        this.mOnImageLoadListener = onImageLoadListener;
        if (!TextUtils.isEmpty(getImageUrl())) {
            b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(getImageUrl(), this);
        }
    }

    public void onFailedLoad(String str, String str2) {
    }

    public void onSuccessLoad(Bitmap bitmap, String str) {
        if (!TextUtils.isEmpty(getImageUrl()) && getImageUrl().equals(str) && bitmap != null) {
            setBigDrawable(BitmapToDrawable(bitmap));
            OnImageLoadListener onImageLoadListener = this.mOnImageLoadListener;
            if (onImageLoadListener != null) {
                onImageLoadListener.loadSuccess(BitmapToDrawable(bitmap), 3);
            }
        }
        if (!TextUtils.isEmpty(getIconUrl()) && getIconUrl() != null && getIconUrl().equals(str) && bitmap != null) {
            setIconDrawable(BitmapToDrawable(bitmap));
            OnImageLoadListener onImageLoadListener2 = this.mOnImageLoadListener;
            if (onImageLoadListener2 != null) {
                onImageLoadListener2.loadSuccess(BitmapToDrawable(bitmap), 2);
            }
        }
    }

    public void setAdCall(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.adCall = str;
        }
    }

    public void setAdchoiceSizeHeight(int i5) {
        this.adchoiceSizeHeight = i5;
    }

    public void setAdchoiceSizeWidth(int i5) {
        this.adchoiceSizeWidth = i5;
    }

    public void setAppDesc(String str) {
        this.appDesc = str;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setBigDrawable(Drawable drawable) {
        this.bigDrawable = drawable;
    }

    public void setCreativeId(long j5) {
        this.creativeId = j5;
    }

    public void setIconDrawable(Drawable drawable) {
        this.iconDrawable = drawable;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setNativead(Object obj) {
        this.nativead = obj;
    }

    public void setNumberRating(int i5) {
        if (i5 > 0) {
            this.numberRating = i5;
        }
    }

    public void setOnImageLoadListener(OnImageLoadListener onImageLoadListener) {
        this.mOnImageLoadListener = onImageLoadListener;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setRating(double d5) {
        this.rating = d5;
    }

    public void setSize(String str) {
        this.size = str;
    }

    public void setSubType(String str) {
        this.subType = str;
    }

    public void setTimestamp(long j5) {
        this.timestamp = j5;
    }

    public void setType(int i5) {
        this.type = i5;
    }

    public void setVideoLength(int i5) {
        this.videoLength = i5;
    }
}
