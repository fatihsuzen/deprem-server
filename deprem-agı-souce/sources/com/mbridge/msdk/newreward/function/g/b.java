package com.mbridge.msdk.newreward.function.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.retention.BridgeParameter;
import com.mbridge.msdk.newreward.function.command.retention.ReportAnnotation;
import java.lang.annotation.Annotation;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    Handler f10996a;

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<Object> f10997b;

    /* renamed from: c  reason: collision with root package name */
    private e f10998c;

    /* renamed from: d  reason: collision with root package name */
    private c f10999d;

    public b(Object obj, e eVar, c cVar) {
        HandlerThread handlerThread;
        this.f10997b = new WeakReference<>(obj);
        this.f10998c = eVar;
        this.f10999d = cVar;
        if (eVar == null) {
            handlerThread = new HandlerThread("HandlerReportMessage");
            handlerThread.start();
        } else if (eVar.a() == null) {
            handlerThread = new HandlerThread("HandlerReportMessage");
            eVar.a(handlerThread);
            handlerThread.start();
        } else {
            handlerThread = eVar.a();
        }
        this.f10996a = new Handler(handlerThread.getLooper());
    }

    public final void a(final Object obj, final Method method, final Object[] objArr) {
        CampaignEx campaignEx;
        Object obj2;
        Handler handler = this.f10996a;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        b.a(b.this, obj, method, objArr);
                    } catch (NoSuchMethodException e5) {
                        af.b("HandlerReportMessage", e5.getMessage());
                    }
                }
            });
            try {
                e eVar = this.f10998c;
                if (eVar != null && eVar.D() != null && this.f10998c.D().a() != null) {
                    if (!this.f10998c.D().a().isEmpty()) {
                        List<CampaignEx> a5 = this.f10998c.D().a();
                        if (!a5.isEmpty() && (campaignEx = a5.get(0)) != null && campaignEx.isActiveOm()) {
                            c cVar = this.f10999d;
                            e eVar2 = this.f10998c;
                            WeakReference<Object> weakReference = this.f10997b;
                            if (weakReference == null) {
                                obj2 = null;
                            } else {
                                obj2 = weakReference.get();
                            }
                            cVar.a((Object) cVar.a("adapter_model", eVar2, "methodName", method, "methodRep", obj, "args", objArr, TypedValues.AttributesType.S_TARGET, obj2), "OMSDKReceiver");
                        }
                    }
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    private Map a(Object obj, String str, Object[] objArr) {
        Object[] objArr2 = objArr;
        HashMap hashMap = new HashMap();
        try {
            int length = objArr2.length;
            Class[] clsArr = new Class[length];
            for (int i5 = 0; i5 < length; i5++) {
                Object obj2 = objArr2[i5];
                if (obj2 instanceof Integer) {
                    clsArr[i5] = Integer.TYPE;
                } else {
                    clsArr[i5] = obj2.getClass();
                }
            }
            Method method = obj.getClass().getMethod(str, clsArr);
            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            for (int i6 = 0; i6 < parameterAnnotations.length; i6++) {
                int i7 = 0;
                while (true) {
                    Annotation[] annotationArr = parameterAnnotations[i6];
                    if (i7 >= annotationArr.length) {
                        break;
                    }
                    Annotation annotation = annotationArr[i7];
                    if (annotation instanceof BridgeParameter) {
                        String key = ((BridgeParameter) annotation).key();
                        Object obj3 = objArr2[i6];
                        StringBuilder sb = new StringBuilder();
                        sb.append("ioc上报参数为：第");
                        int i8 = i6 + 1;
                        sb.append(i8);
                        sb.append("参数，第");
                        int i9 = i7 + 1;
                        sb.append(i9);
                        sb.append("个注解,Annotation.parametersKey=");
                        sb.append(key);
                        sb.append(", methodName->");
                        sb.append(method.getName());
                        af.b("HandlerReportMessage", sb.toString());
                        af.b("HandlerReportMessage", "ioc上报参数为：第" + i8 + "参数，第" + i9 + "个注解,Parameter.value=" + obj3);
                        hashMap.put(key, obj3);
                    }
                    i7++;
                }
            }
            return hashMap;
        } catch (Exception e5) {
            af.b("HandlerReportMessage", e5.getMessage());
            return hashMap;
        }
    }

    static /* synthetic */ void a(b bVar, Object obj, Method method, Object[] objArr) throws NoSuchMethodException {
        ReportAnnotation.MethodInfo methodInfo;
        b bVar2 = bVar;
        Object obj2 = obj;
        Method method2 = method;
        Object[] objArr2 = objArr;
        if (bVar2.f10999d != null) {
            Class cls = ReportAnnotation.MethodInfo.class;
            if (method2.isAnnotationPresent(cls)) {
                if ((!(obj2 instanceof Boolean) || !((Boolean) obj2).booleanValue()) && (methodInfo = (ReportAnnotation.MethodInfo) method2.getAnnotation(cls)) != null) {
                    String key = methodInfo.key();
                    String reportType = methodInfo.reportType();
                    reportType.getClass();
                    char c5 = 65535;
                    switch (reportType.hashCode()) {
                        case 49:
                            if (reportType.equals("1")) {
                                c5 = 0;
                                break;
                            }
                            break;
                        case 50:
                            if (reportType.equals("2")) {
                                c5 = 1;
                                break;
                            }
                            break;
                        case 51:
                            if (reportType.equals(ExifInterface.GPS_MEASUREMENT_3D)) {
                                c5 = 2;
                                break;
                            }
                            break;
                    }
                    int i5 = 4;
                    Map<String, String> map = null;
                    switch (c5) {
                        case 0:
                            boolean isParameter = methodInfo.isParameter();
                            if (isParameter && bVar2.f10997b.get() != null) {
                                map = bVar2.a(bVar2.f10997b.get(), method2.getName(), objArr2);
                            }
                            af.b("HandlerReportMessage", "开始上报，方法名：" + method2.getName() + ", isParameter-->" + isParameter + ",BuildType-->" + "1");
                            c cVar = bVar2.f10999d;
                            cVar.a((Object) cVar.a("adapter_model", bVar2.f10998c, "metrics_data", map, "metrics_report_key", key), "ReportReceiver");
                            return;
                        case 1:
                            try {
                                String className = methodInfo.className();
                                String methodName = methodInfo.methodName();
                                d[] a5 = bVar2.f10998c.c().a();
                                if (!TextUtils.isEmpty(className) && !TextUtils.isEmpty(methodName) && a5 != null) {
                                    if (a5.length != 0) {
                                        int length = a5.length;
                                        int i6 = 0;
                                        while (i6 < length) {
                                            d dVar = a5[i6];
                                            if (dVar.a().equals(className) && dVar.b().equals(methodName)) {
                                                String c6 = dVar.c();
                                                if (!TextUtils.isEmpty(c6)) {
                                                    c cVar2 = bVar2.f10999d;
                                                    e eVar = bVar2.f10998c;
                                                    Object[] objArr3 = new Object[i5];
                                                    objArr3[0] = "adapter_model";
                                                    objArr3[1] = eVar;
                                                    objArr3[2] = "metrics_report_key";
                                                    objArr3[3] = c6;
                                                    cVar2.a((Object) cVar2.a(objArr3), "ReportReceiver");
                                                }
                                            }
                                            i6++;
                                            i5 = 4;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                return;
                            } catch (Exception e5) {
                                af.b("HandlerReportMessage", e5.getMessage());
                                return;
                            }
                        case 2:
                            af.b("HandlerReportMessage", "开始上报，方法名：" + method2.getName() + ",BuildType-->" + ExifInterface.GPS_MEASUREMENT_3D);
                            String str = (String) objArr2[0];
                            if (str.equals("onCreate")) {
                                str = "2000129";
                            }
                            if (str.equals("onDestroy")) {
                                str = "2000151";
                            }
                            try {
                                if (methodInfo.isParameter() && bVar2.f10997b.get() != null && objArr2.length > 1) {
                                    Object obj3 = objArr2[1];
                                    if (obj3 instanceof com.mbridge.msdk.foundation.same.report.d.e) {
                                        map = ((com.mbridge.msdk.foundation.same.report.d.e) obj3).a();
                                    }
                                }
                            } catch (Exception e6) {
                                if (MBridgeConstans.DEBUG) {
                                    e6.printStackTrace();
                                }
                            }
                            c cVar3 = bVar2.f10999d;
                            cVar3.a((Object) cVar3.a("adapter_model", bVar2.f10998c, "metrics_data", map, "metrics_report_key", str), "ReportReceiver");
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    }
}
