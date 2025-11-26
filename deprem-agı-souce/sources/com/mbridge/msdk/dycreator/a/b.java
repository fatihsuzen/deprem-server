package com.mbridge.msdk.dycreator.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import com.mbridge.msdk.dycreator.baseview.GradientOrientationUtils;
import com.mbridge.msdk.dycreator.e.e;
import com.mbridge.msdk.dycreator.e.g;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

public class b {

    /* renamed from: g  reason: collision with root package name */
    private static volatile b f8241g;

    /* renamed from: a  reason: collision with root package name */
    private SoftReference<HashMap<String, c>> f8242a;

    /* renamed from: b  reason: collision with root package name */
    private SoftReference<HashMap<String, String>> f8243b;

    /* renamed from: c  reason: collision with root package name */
    private SoftReference<HashMap<String, c>> f8244c;

    /* renamed from: d  reason: collision with root package name */
    private String f8245d;

    /* renamed from: e  reason: collision with root package name */
    private String f8246e;

    /* renamed from: f  reason: collision with root package name */
    private Context f8247f;

    private b() {
    }

    public static b a() {
        if (f8241g == null) {
            synchronized (b.class) {
                try {
                    if (f8241g == null) {
                        f8241g = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f8241g;
    }

    public final HashMap b() {
        SoftReference<HashMap<String, c>> softReference = this.f8242a;
        if (softReference == null || softReference.get() == null) {
            HashMap hashMap = new HashMap(45);
            hashMap.put("layout_width", c.layout_width);
            hashMap.put("layout_height", c.layout_height);
            hashMap.put("orientation", c.orientation);
            hashMap.put("layout_centerHorizontal", c.layout_centerHorizontal);
            hashMap.put("layout_centerVertical", c.layout_centerVertical);
            c cVar = c.layout_marginLeft;
            hashMap.put("layout_marginLeft", cVar);
            c cVar2 = c.layout_marginRight;
            hashMap.put("layout_marginRight", cVar2);
            hashMap.put("layout_margin", c.layout_margin);
            hashMap.put("layout_gravity", c.layout_gravity);
            hashMap.put("layout_alignParentRight", c.layout_alignParentRight);
            hashMap.put("layout_weight", c.layout_weight);
            hashMap.put("contentDescription", c.contentDescription);
            hashMap.put("gravity", c.gravity);
            hashMap.put("id", c.id);
            hashMap.put("layout_below", c.layout_below);
            hashMap.put("layout_above", c.layout_above);
            hashMap.put("layout_toLeftOf", c.layout_toLeftOf);
            hashMap.put("layout_toRightOf", c.layout_toRightOf);
            hashMap.put("layout_toEndOf", c.layout_toEndOf);
            hashMap.put("background", c.background);
            hashMap.put("layout_marginTop", c.layout_marginTop);
            hashMap.put("layout_marginBottom", c.layout_marginBottom);
            hashMap.put("layout_marginLeft", cVar);
            hashMap.put("layout_marginRight", cVar2);
            hashMap.put("layout_alignParentBottom", c.layout_alignParentBottom);
            hashMap.put("layout_alignParentTop", c.layout_alignParentTop);
            hashMap.put("layout_alignParentLeft", c.layout_alignParentLeft);
            hashMap.put("layout_alignWithParentIfMissing", c.layout_alignWithParentIfMissing);
            hashMap.put("layout_alignTop", c.layout_alignTop);
            hashMap.put("layout_alignBottom", c.layout_alignBottom);
            hashMap.put("layout_alignLeft", c.layout_alignLeft);
            hashMap.put("layout_alignRight", c.layout_alignRight);
            hashMap.put("layout_centerInParent", c.layout_centerInParent);
            hashMap.put("layout_alignParentEnd", c.layout_alignParentEnd);
            this.f8242a = new SoftReference<>(hashMap);
        }
        return this.f8242a.get();
    }

    public final HashMap<String, c> c() {
        SoftReference<HashMap<String, c>> softReference = this.f8244c;
        if (softReference == null || softReference.get() == null) {
            HashMap hashMap = new HashMap(55);
            hashMap.put("id", c.id);
            hashMap.put(MimeTypes.BASE_TYPE_TEXT, c.text);
            hashMap.put("ellipsize", c.ellipsize);
            hashMap.put("singleLine", c.singleLine);
            hashMap.put("lines", c.lines);
            hashMap.put("maxLength", c.maxLength);
            hashMap.put("drawableLeft", c.drawableLeft);
            hashMap.put("drawablePadding", c.drawablePadding);
            hashMap.put("fadingEdge", c.fadingEdge);
            hashMap.put("scrollHorizontally", c.scrollHorizontally);
            hashMap.put("textColor", c.textColor);
            hashMap.put("textSize", c.textSize);
            hashMap.put("visibility", c.visibility);
            c cVar = c.background;
            hashMap.put("background", cVar);
            hashMap.put("textStyle", c.textStyle);
            hashMap.put(TtmlNode.TAG_STYLE, c.style);
            hashMap.put("layout_width", c.layout_width);
            hashMap.put("layout_height", c.layout_height);
            hashMap.put("layout_below", c.layout_below);
            hashMap.put("layout_centerInParent", c.layout_centerInParent);
            hashMap.put("contentDescription", c.contentDescription);
            hashMap.put("src", c.src);
            hashMap.put("gravity", c.gravity);
            hashMap.put("orientation", c.orientation);
            hashMap.put("numColumns", c.numColumns);
            hashMap.put("verticalSpacing", c.verticalSpacing);
            hashMap.put("horizontalSpacing", c.horizontalSpacing);
            hashMap.put("background", cVar);
            hashMap.put("layout_marginBottom", c.layout_marginBottom);
            hashMap.put("scaleType", c.scaleType);
            hashMap.put("tag", c.tag);
            hashMap.put("layout_gravity", c.layout_gravity);
            hashMap.put("parent_view", c.parent_view);
            hashMap.put("padding", c.padding);
            hashMap.put("paddingTop", c.paddingTop);
            hashMap.put("paddingBottom", c.paddingBottom);
            hashMap.put("paddingLeft", c.paddingLeft);
            hashMap.put("paddingRight", c.paddingRight);
            hashMap.put("divider", c.divider);
            hashMap.put("scrollbars", c.scrollbars);
            hashMap.put("listSelector", c.listSelector);
            this.f8244c = new SoftReference<>(hashMap);
        }
        return this.f8244c.get();
    }

    public final int d(String str) {
        if (this.f8247f == null) {
            return 0;
        }
        String g5 = c.m().g();
        if (TextUtils.isEmpty(g5)) {
            g5 = this.f8247f.getPackageName();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(g5);
        sb.append(".R$");
        String[] split = str.split("\\.");
        sb.append(split[1]);
        try {
            Class<?> cls = Class.forName(sb.toString());
            Object newInstance = cls.newInstance();
            Field declaredField = cls.getDeclaredField(split[2]);
            declaredField.setAccessible(true);
            return ((Integer) declaredField.get(newInstance)).intValue();
        } catch (Exception e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    public final String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("@")) {
            return str;
        }
        SoftReference<HashMap<String, String>> softReference = this.f8243b;
        if (softReference == null || softReference.get() == null) {
            this.f8243b = new SoftReference<>(d());
        }
        String substring = str.substring(8);
        if (this.f8243b.get() == null || this.f8243b.get().size() <= 0) {
            return null;
        }
        String str2 = (String) this.f8243b.get().get(substring);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        try {
            return c.m().c().getString(x.a(c.m().c(), substring, TypedValues.Custom.S_STRING));
        } catch (Exception e5) {
            af.b("MBResource", e5.getMessage());
            return null;
        }
    }

    public final View f(String str) {
        if (this.f8247f != null) {
            try {
                a aVar = new a(this.f8247f);
                new String();
                g.a(str.toString());
                return aVar.a(str.toString(), (ViewGroup) null);
            } catch (Exception e5) {
                af.b("MBResource", e5.getMessage());
            }
        }
        return null;
    }

    public final void a(Context context, String str) {
        try {
            if (g.f8695a) {
                this.f8245d = context.getFilesDir().toString();
            } else {
                this.f8245d = str;
            }
            if (e.a(context).heightPixels > 320) {
                if (!g.f8695a) {
                    this.f8246e = "/drawable-hdpi/";
                    this.f8247f = context;
                    com.mbridge.msdk.dycreator.e.b.f8692a = a().d();
                }
            }
            this.f8246e = "/drawable-mdpi/";
            this.f8247f = context;
            com.mbridge.msdk.dycreator.e.b.f8692a = a().d();
        } catch (Exception e5) {
            af.b("MBResource", e5.getMessage());
        }
    }

    private HashMap<String, String> d() {
        InputStream inputStream;
        try {
            inputStream = this.f8247f.getAssets().open("rv_binddatas.xml");
        } catch (IOException e5) {
            e5.printStackTrace();
            inputStream = null;
        }
        XmlPullParser newPullParser = Xml.newPullParser();
        try {
            newPullParser.setInput(inputStream, "utf-8");
            HashMap<String, String> hashMap = new HashMap<>();
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2 && TypedValues.Custom.S_STRING.equals(newPullParser.getName())) {
                    hashMap.put(newPullParser.getAttributeValue(0), newPullParser.nextText());
                }
            }
            return hashMap;
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public final void a(Context context) {
        try {
            if (e.a(context).heightPixels > 320) {
                if (!g.f8695a) {
                    this.f8246e = "/drawable-hdpi/";
                    this.f8247f = context;
                    com.mbridge.msdk.dycreator.e.b.f8692a = a().d();
                }
            }
            this.f8246e = "/drawable-mdpi/";
            this.f8247f = context;
            com.mbridge.msdk.dycreator.e.b.f8692a = a().d();
        } catch (Exception e5) {
            af.b("MBResource", e5.getMessage());
        }
    }

    public final int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return ViewCompat.MEASURED_STATE_MASK;
        }
        if (str.startsWith("#")) {
            int length = str.length();
            if (length == 7) {
                return (int) Long.decode(str.replace("#", "#FF")).longValue();
            }
            if (length == 9) {
                return (int) Long.decode(str).longValue();
            }
            g.a("返回白色背景");
            return -1;
        } else if (!str.startsWith("@color/")) {
            return ViewCompat.MEASURED_STATE_MASK;
        } else {
            return c.m().c().getColor(x.a(c.m().c(), str.substring(7), "color"));
        }
    }

    public final GradientDrawable a(String[] strArr) {
        try {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientOrientationUtils.getOrientation(strArr[2]), new int[]{Color.parseColor(strArr[0]), Color.parseColor(strArr[1])});
            gradientDrawable.setGradientType(0);
            return gradientDrawable;
        } catch (Exception e5) {
            af.b("MBResource", e5.getMessage());
            return null;
        }
    }

    public final int b(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            int indexOf = str.indexOf("d");
            int indexOf2 = str.indexOf("s");
            if (indexOf == -1) {
                indexOf = indexOf2;
            }
            int parseInt = Integer.parseInt(str.substring(0, indexOf));
            if (str.contains("d")) {
                return (int) TypedValue.applyDimension(1, (float) parseInt, this.f8247f.getResources().getDisplayMetrics());
            }
            str.contains("s");
            return parseInt;
        }
    }

    public final void a(String str, ImageView imageView) {
        Context context;
        if (str != null && str.startsWith("@drawable/") && (context = this.f8247f) != null) {
            try {
                Resources resources = context.getResources();
                String g5 = c.m().g();
                if (TextUtils.isEmpty(g5)) {
                    g5 = this.f8247f.getPackageName();
                }
                imageView.setImageResource(resources.getIdentifier(str, "drawable", g5));
            } catch (Exception e5) {
                af.b("MBResource", e5.getMessage());
            }
        }
    }

    public final int c(String str) {
        String[] split = str.toUpperCase().split("\\|");
        int i5 = 48;
        try {
            Class<?> cls = Class.forName("android.view.Gravity");
            for (String field : split) {
                i5 = cls.getField(field).getInt((Object) null);
            }
            return i5;
        } catch (Exception e5) {
            e5.printStackTrace();
            return 48;
        }
    }
}
