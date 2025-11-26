package com.mbridge.msdk.dycreator.a;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import com.mbridge.msdk.MBridgeConstans;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class a {

    /* renamed from: f  reason: collision with root package name */
    private static final Class[] f8231f = {Context.class, AttributeSet.class};

    /* renamed from: g  reason: collision with root package name */
    private static final HashMap<String, Constructor> f8232g = new HashMap<>();

    /* renamed from: j  reason: collision with root package name */
    private static String f8233j = "com.mbridge.msdk.dycreator.baseview.MB";

    /* renamed from: a  reason: collision with root package name */
    protected final Context f8234a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f8235b = true;

    /* renamed from: c  reason: collision with root package name */
    private C0082a f8236c;

    /* renamed from: d  reason: collision with root package name */
    private b f8237d;

    /* renamed from: e  reason: collision with root package name */
    private final Object[] f8238e = new Object[2];

    /* renamed from: h  reason: collision with root package name */
    private HashMap<String, Boolean> f8239h;

    /* renamed from: i  reason: collision with root package name */
    private long f8240i;

    /* renamed from: com.mbridge.msdk.dycreator.a.a$a  reason: collision with other inner class name */
    public interface C0082a {
        View a(String str, Context context, AttributeSet attributeSet);
    }

    public interface b {
        boolean a(Class cls);
    }

    public a(Context context) {
        this.f8234a = context;
    }

    private XmlPullParser a(String str) {
        XmlPullParser newPullParser = Xml.newPullParser();
        try {
            newPullParser.setInput(new FileInputStream(str), "utf-8");
            return newPullParser;
        } catch (Exception e5) {
            e5.printStackTrace();
            return newPullParser;
        }
    }

    private void b(String str, String str2, AttributeSet attributeSet) {
        StringBuilder sb = new StringBuilder();
        sb.append(attributeSet.getPositionDescription());
        sb.append(": Class not allowed to be inflated ");
        if (str2 != null) {
            str = str2 + str;
        }
        sb.append(str);
        throw new InflateException(sb.toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0063, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006f, code lost:
        if (r8 != null) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r2.setLayoutParams(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r8 = r7.generateLayoutParams(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007b, code lost:
        if (r8 == null) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        a((org.xmlpull.v1.XmlPullParser) r0, r2, r1);
        r7.addView(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b8, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00bb, code lost:
        throw r6;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0077 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0053 A[Catch:{ all -> 0x0063 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x009d A[Catch:{ all -> 0x0063 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(org.xmlpull.v1.XmlPullParser r6, android.view.View r7, android.util.AttributeSet r8) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r5 = this;
            boolean r0 = r7 instanceof android.view.ViewGroup
            if (r0 == 0) goto L_0x00bc
            r0 = 0
            r1 = 0
            java.lang.String r2 = "layout"
            int r0 = r8.getAttributeResourceValue(r1, r2, r0)
            if (r0 != 0) goto L_0x0038
            java.lang.String r6 = r8.getAttributeValue(r1, r2)
            if (r6 != 0) goto L_0x001c
            android.view.InflateException r6 = new android.view.InflateException
            java.lang.String r7 = "You must specifiy a layout in the include tag: <include layout=\"@layout/layoutID\" />"
            r6.<init>(r7)
            throw r6
        L_0x001c:
            android.view.InflateException r7 = new android.view.InflateException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "You must specifiy a valid layout reference. The layout ID "
            r8.append(r0)
            r8.append(r6)
            java.lang.String r6 = " is not valid."
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r7.<init>(r6)
            throw r7
        L_0x0038:
            android.content.Context r1 = r5.f8234a
            android.content.res.Resources r1 = r1.getResources()
            android.content.res.XmlResourceParser r0 = r1.getLayout(r0)
            android.util.AttributeSet r1 = android.util.Xml.asAttributeSet(r0)     // Catch:{ all -> 0x0063 }
        L_0x0046:
            int r2 = r0.next()     // Catch:{ all -> 0x0063 }
            r3 = 1
            r4 = 2
            if (r2 == r4) goto L_0x0051
            if (r2 == r3) goto L_0x0051
            goto L_0x0046
        L_0x0051:
            if (r2 != r4) goto L_0x009d
            java.lang.String r2 = r0.getName()     // Catch:{ all -> 0x0063 }
            java.lang.String r4 = "merge"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0063 }
            if (r4 == 0) goto L_0x0065
            r5.a((org.xmlpull.v1.XmlPullParser) r0, (android.view.View) r7, (android.util.AttributeSet) r1)     // Catch:{ all -> 0x0063 }
            goto L_0x0084
        L_0x0063:
            r6 = move-exception
            goto L_0x00b8
        L_0x0065:
            android.view.View r2 = r5.a((java.lang.String) r2, (android.util.AttributeSet) r1)     // Catch:{ all -> 0x0063 }
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7     // Catch:{ all -> 0x0063 }
            android.view.ViewGroup$LayoutParams r8 = r7.generateLayoutParams(r8)     // Catch:{ RuntimeException -> 0x0077 }
            if (r8 == 0) goto L_0x007e
        L_0x0071:
            r2.setLayoutParams(r8)     // Catch:{ all -> 0x0063 }
            goto L_0x007e
        L_0x0075:
            r6 = move-exception
            goto L_0x009c
        L_0x0077:
            android.view.ViewGroup$LayoutParams r8 = r7.generateLayoutParams(r1)     // Catch:{ all -> 0x0075 }
            if (r8 == 0) goto L_0x007e
            goto L_0x0071
        L_0x007e:
            r5.a((org.xmlpull.v1.XmlPullParser) r0, (android.view.View) r2, (android.util.AttributeSet) r1)     // Catch:{ all -> 0x0063 }
            r7.addView(r2)     // Catch:{ all -> 0x0063 }
        L_0x0084:
            r0.close()
            int r7 = r6.getDepth()
        L_0x008b:
            int r8 = r6.next()
            r0 = 3
            if (r8 != r0) goto L_0x0098
            int r0 = r6.getDepth()
            if (r0 <= r7) goto L_0x009b
        L_0x0098:
            if (r8 == r3) goto L_0x009b
            goto L_0x008b
        L_0x009b:
            return
        L_0x009c:
            throw r6     // Catch:{ all -> 0x0063 }
        L_0x009d:
            android.view.InflateException r6 = new android.view.InflateException     // Catch:{ all -> 0x0063 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0063 }
            r7.<init>()     // Catch:{ all -> 0x0063 }
            java.lang.String r8 = r0.getPositionDescription()     // Catch:{ all -> 0x0063 }
            r7.append(r8)     // Catch:{ all -> 0x0063 }
            java.lang.String r8 = ": No start tag found!"
            r7.append(r8)     // Catch:{ all -> 0x0063 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0063 }
            r6.<init>(r7)     // Catch:{ all -> 0x0063 }
            throw r6     // Catch:{ all -> 0x0063 }
        L_0x00b8:
            r0.close()
            throw r6
        L_0x00bc:
            android.view.InflateException r6 = new android.view.InflateException
            java.lang.String r7 = "<include /> can only be used inside of a ViewGroup"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.a.a.b(org.xmlpull.v1.XmlPullParser, android.view.View, android.util.AttributeSet):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: android.view.ViewGroup} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: android.view.ViewGroup} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001b A[Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056, all -> 0x0053 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a9 A[SYNTHETIC, Splitter:B:40:0x00a9] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.View a(org.xmlpull.v1.XmlPullParser r7, android.view.ViewGroup r8, boolean r9) {
        /*
            r6 = this;
            java.lang.Object[] r0 = r6.f8238e
            monitor-enter(r0)
            android.util.AttributeSet r1 = android.util.Xml.asAttributeSet(r7)     // Catch:{ all -> 0x0053 }
            java.lang.Object[] r2 = r6.f8238e     // Catch:{ all -> 0x0053 }
            android.content.Context r3 = r6.f8234a     // Catch:{ all -> 0x0053 }
            r4 = 0
            r2[r4] = r3     // Catch:{ all -> 0x0053 }
        L_0x000e:
            int r2 = r7.next()     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            r3 = 2
            if (r2 == r3) goto L_0x0019
            r4 = 1
            if (r2 == r4) goto L_0x0019
            goto L_0x000e
        L_0x0019:
            if (r2 != r3) goto L_0x00a9
            java.lang.String r2 = r7.getName()     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            java.io.PrintStream r3 = java.lang.System.out     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            java.lang.String r4 = "**************************"
            r3.println(r4)     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            java.io.PrintStream r3 = java.lang.System.out     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            r4.<init>()     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            java.lang.String r5 = "Creating root view: "
            r4.append(r5)     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            r4.append(r2)     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            java.lang.String r4 = r4.toString()     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            r3.println(r4)     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            java.io.PrintStream r3 = java.lang.System.out     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            java.lang.String r4 = "**************************"
            r3.println(r4)     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            java.lang.String r3 = "merge"
            boolean r3 = r3.equals(r2)     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            if (r3 == 0) goto L_0x0063
            if (r8 == 0) goto L_0x005b
            if (r9 == 0) goto L_0x005b
            r6.a((org.xmlpull.v1.XmlPullParser) r7, (android.view.View) r8, (android.util.AttributeSet) r1)     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            goto L_0x00a7
        L_0x0053:
            r7 = move-exception
            goto L_0x00f6
        L_0x0056:
            r8 = move-exception
            goto L_0x00c4
        L_0x0058:
            r7 = move-exception
            goto L_0x00e9
        L_0x005b:
            android.view.InflateException r8 = new android.view.InflateException     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            java.lang.String r9 = "<merge /> can be used only with a valid ViewGroup root and attachToRoot=true"
            r8.<init>(r9)     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            throw r8     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
        L_0x0063:
            android.view.View r2 = r6.a((java.lang.String) r2, (android.util.AttributeSet) r1)     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            if (r8 == 0) goto L_0x0089
            java.io.PrintStream r3 = java.lang.System.out     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            r4.<init>()     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            java.lang.String r5 = "Creating params from root: "
            r4.append(r5)     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            r4.append(r8)     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            java.lang.String r4 = r4.toString()     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            r3.println(r4)     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            android.view.ViewGroup$LayoutParams r3 = r8.generateLayoutParams(r1)     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            if (r9 != 0) goto L_0x008a
            r2.setLayoutParams(r3)     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            goto L_0x008a
        L_0x0089:
            r3 = 0
        L_0x008a:
            java.io.PrintStream r4 = java.lang.System.out     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            java.lang.String r5 = "-----> start inflating children"
            r4.println(r5)     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            r6.a((org.xmlpull.v1.XmlPullParser) r7, (android.view.View) r2, (android.util.AttributeSet) r1)     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            java.io.PrintStream r1 = java.lang.System.out     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            java.lang.String r4 = "-----> done inflating children"
            r1.println(r4)     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            if (r8 == 0) goto L_0x00a2
            if (r9 == 0) goto L_0x00a2
            r8.addView(r2, r3)     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
        L_0x00a2:
            if (r8 == 0) goto L_0x00a6
            if (r9 != 0) goto L_0x00a7
        L_0x00a6:
            r8 = r2
        L_0x00a7:
            monitor-exit(r0)     // Catch:{ all -> 0x0053 }
            return r8
        L_0x00a9:
            android.view.InflateException r8 = new android.view.InflateException     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            r9.<init>()     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            java.lang.String r1 = r7.getPositionDescription()     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            r9.append(r1)     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            java.lang.String r1 = ": No start tag found!"
            r9.append(r1)     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            java.lang.String r9 = r9.toString()     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            r8.<init>(r9)     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            throw r8     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
        L_0x00c4:
            android.view.InflateException r9 = new android.view.InflateException     // Catch:{ all -> 0x0053 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0053 }
            r1.<init>()     // Catch:{ all -> 0x0053 }
            java.lang.String r7 = r7.getPositionDescription()     // Catch:{ all -> 0x0053 }
            r1.append(r7)     // Catch:{ all -> 0x0053 }
            java.lang.String r7 = ": "
            r1.append(r7)     // Catch:{ all -> 0x0053 }
            java.lang.String r7 = r8.getMessage()     // Catch:{ all -> 0x0053 }
            r1.append(r7)     // Catch:{ all -> 0x0053 }
            java.lang.String r7 = r1.toString()     // Catch:{ all -> 0x0053 }
            r9.<init>(r7)     // Catch:{ all -> 0x0053 }
            r9.initCause(r8)     // Catch:{ all -> 0x0053 }
            throw r9     // Catch:{ all -> 0x0053 }
        L_0x00e9:
            android.view.InflateException r8 = new android.view.InflateException     // Catch:{ all -> 0x0053 }
            java.lang.String r9 = r7.getMessage()     // Catch:{ all -> 0x0053 }
            r8.<init>(r9)     // Catch:{ all -> 0x0053 }
            r8.initCause(r7)     // Catch:{ all -> 0x0053 }
            throw r8     // Catch:{ all -> 0x0053 }
        L_0x00f6:
            monitor-exit(r0)     // Catch:{ all -> 0x0053 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.a.a.a(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View");
    }

    private View a(String str, String str2, AttributeSet attributeSet) throws ClassNotFoundException, InflateException {
        String str3;
        String str4;
        String str5;
        HashMap<String, Constructor> hashMap = f8232g;
        Constructor<?> constructor = hashMap.get(str);
        Class cls = null;
        if (constructor == null) {
            try {
                ClassLoader classLoader = this.f8234a.getClassLoader();
                if (str2 != null) {
                    str5 = str2 + str;
                } else {
                    str5 = str;
                }
                Class<?> loadClass = classLoader.loadClass(str5);
                b bVar = this.f8237d;
                if (!(bVar == null || loadClass == null || bVar.a(loadClass))) {
                    b(str, str2, attributeSet);
                }
                constructor = loadClass.getConstructor(f8231f);
                hashMap.put(str, constructor);
            } catch (NoSuchMethodException e5) {
                StringBuilder sb = new StringBuilder();
                sb.append(attributeSet.getPositionDescription());
                sb.append(": Error inflating class ");
                if (str2 != null) {
                    str = str2 + str;
                }
                sb.append(str);
                InflateException inflateException = new InflateException(sb.toString());
                inflateException.initCause(e5);
                throw inflateException;
            } catch (ClassNotFoundException e6) {
                throw e6;
            } catch (Exception e7) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(attributeSet.getPositionDescription());
                sb2.append(": Error inflating class ");
                if (cls == null) {
                    str4 = "<unknown>";
                } else {
                    str4 = cls.getName();
                }
                sb2.append(str4);
                InflateException inflateException2 = new InflateException(sb2.toString());
                inflateException2.initCause(e7);
                throw inflateException2;
            }
        } else if (this.f8237d != null) {
            Boolean bool = this.f8239h.get(str);
            if (bool == null) {
                ClassLoader classLoader2 = this.f8234a.getClassLoader();
                if (str2 != null) {
                    str3 = str2 + str;
                } else {
                    str3 = str;
                }
                Class<?> loadClass2 = classLoader2.loadClass(str3);
                boolean z4 = loadClass2 != null && this.f8237d.a(loadClass2);
                this.f8239h.put(str, Boolean.valueOf(z4));
                if (!z4) {
                    b(str, str2, attributeSet);
                }
            } else if (bool.equals(Boolean.FALSE)) {
                b(str, str2, attributeSet);
            }
        }
        Object[] objArr = this.f8238e;
        objArr[1] = attributeSet;
        return (View) constructor.newInstance(objArr);
    }

    private View a(String str, AttributeSet attributeSet) {
        if (str.equals(MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW)) {
            str = attributeSet.getAttributeValue((String) null, "class");
        }
        PrintStream printStream = System.out;
        printStream.println("******** Creating view: " + str);
        try {
            C0082a aVar = this.f8236c;
            View a5 = aVar == null ? null : aVar.a(str, this.f8234a, attributeSet);
            if (a5 == null) {
                if (-1 == str.indexOf(46)) {
                    if (!str.equals("MBStarLevelLayoutView")) {
                        if (!str.equals("LuckPan")) {
                            a5 = a(str, f8233j, attributeSet);
                        }
                    }
                    a5 = a(str, "", attributeSet);
                } else {
                    a5 = a(str, (String) null, attributeSet);
                }
            }
            PrintStream printStream2 = System.out;
            printStream2.println("Created view is: " + a5);
            return a5;
        } catch (InflateException e5) {
            throw e5;
        } catch (ClassNotFoundException e6) {
            InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException.initCause(e6);
            throw inflateException;
        } catch (Exception e7) {
            InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException2.initCause(e7);
            throw inflateException2;
        }
    }

    private void a(XmlPullParser xmlPullParser, View view, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int next;
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next2 = xmlPullParser.next();
            if ((next2 == 3 && xmlPullParser.getDepth() <= depth) || next2 == 1) {
                return;
            }
            if (next2 == 2) {
                String name = xmlPullParser.getName();
                if ("requestFocus".equals(name)) {
                    view.requestFocus();
                    int depth2 = xmlPullParser.getDepth();
                    do {
                        next = xmlPullParser.next();
                        if (next == 3 && xmlPullParser.getDepth() <= depth2) {
                            break;
                        }
                    } while (next != 1);
                } else if ("include".equals(name)) {
                    if (xmlPullParser.getDepth() != 0) {
                        b(xmlPullParser, view, attributeSet);
                    } else {
                        throw new InflateException("<include /> cannot be the root element");
                    }
                } else if (!"merge".equals(name)) {
                    View a5 = a(name, attributeSet);
                    ViewGroup viewGroup = (ViewGroup) view;
                    ViewGroup.LayoutParams generateLayoutParams = viewGroup.generateLayoutParams(attributeSet);
                    a(xmlPullParser, a5, attributeSet);
                    viewGroup.addView(a5, generateLayoutParams);
                } else {
                    throw new InflateException("<merge /> must be the root element");
                }
            }
        }
    }

    public final View a(String str, ViewGroup viewGroup) {
        boolean z4 = viewGroup != null;
        this.f8240i = System.currentTimeMillis();
        PrintStream printStream = System.out;
        printStream.println("INFLATING from resource: " + str);
        return a(a(str), viewGroup, z4);
    }
}
