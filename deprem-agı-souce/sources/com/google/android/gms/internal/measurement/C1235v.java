package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.measurement.v  reason: case insensitive filesystem */
public final class C1235v implements Iterable, r {

    /* renamed from: a  reason: collision with root package name */
    private final String f5597a;

    public C1235v(String str) {
        if (str != null) {
            this.f5597a = str;
            return;
        }
        throw new IllegalArgumentException("StringValue cannot be null.");
    }

    public final Double C() {
        String str = this.f5597a;
        if (str.isEmpty()) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    public final String b() {
        return this.f5597a;
    }

    public final Iterator c() {
        return new C1217t(this);
    }

    public final Boolean d() {
        return Boolean.valueOf(!this.f5597a.isEmpty());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1235v)) {
            return false;
        }
        return this.f5597a.equals(((C1235v) obj).f5597a);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String f() {
        return this.f5597a;
    }

    public final int hashCode() {
        return this.f5597a.hashCode();
    }

    public final Iterator iterator() {
        return new C1226u(this);
    }

    public final r j() {
        return new C1235v(this.f5597a);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0194, code lost:
        throw new java.lang.IllegalArgumentException("Command not supported");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0195, code lost:
        com.google.android.gms.internal.measurement.C1238v2.a("toUpperCase", r16, r25);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01a9, code lost:
        return new com.google.android.gms.internal.measurement.C1235v(r22.f5597a.trim());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01aa, code lost:
        com.google.android.gms.internal.measurement.C1238v2.a("toUpperCase", r16, r25);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01c0, code lost:
        return new com.google.android.gms.internal.measurement.C1235v(r22.f5597a.toUpperCase(java.util.Locale.ENGLISH));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01c1, code lost:
        r9 = r22;
        com.google.android.gms.internal.measurement.C1238v2.a(r7, r16, r25);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01ca, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01cb, code lost:
        com.google.android.gms.internal.measurement.C1238v2.a("toLowerCase", r16, r25);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01e1, code lost:
        return new com.google.android.gms.internal.measurement.C1235v(r22.f5597a.toLowerCase(java.util.Locale.ENGLISH));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01e2, code lost:
        com.google.android.gms.internal.measurement.C1238v2.a("toLocaleLowerCase", r16, r25);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01f6, code lost:
        return new com.google.android.gms.internal.measurement.C1235v(r22.f5597a.toLowerCase());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x01f7, code lost:
        com.google.android.gms.internal.measurement.C1238v2.a(r8, r16, r25);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x020b, code lost:
        return new com.google.android.gms.internal.measurement.C1235v(r22.f5597a.toUpperCase());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x020c, code lost:
        r1 = r25;
        r0 = r16;
        com.google.android.gms.internal.measurement.C1238v2.c("substring", 2, r1);
        r2 = r22.f5597a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x021c, code lost:
        if (r1.isEmpty() != false) goto L_0x0238;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x021e, code lost:
        r6 = r24;
        r0 = (int) com.google.android.gms.internal.measurement.C1238v2.i(r6.a((com.google.android.gms.internal.measurement.r) r1.get(r0)).C().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0238, code lost:
        r6 = r24;
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0240, code lost:
        if (r1.size() <= 1) goto L_0x025b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0242, code lost:
        r1 = (int) com.google.android.gms.internal.measurement.C1238v2.i(r6.a((com.google.android.gms.internal.measurement.r) r1.get(1)).C().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x025b, code lost:
        r1 = r2.length();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0260, code lost:
        r0 = java.lang.Math.min(java.lang.Math.max(r0, 0), r2.length());
        r1 = java.lang.Math.min(java.lang.Math.max(r1, 0), r2.length());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0289, code lost:
        return new com.google.android.gms.internal.measurement.C1235v(r2.substring(java.lang.Math.min(r0, r1), java.lang.Math.max(r0, r1)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x028a, code lost:
        r9 = r22;
        r6 = r24;
        r1 = r25;
        com.google.android.gms.internal.measurement.C1238v2.c("split", 2, r1);
        r0 = r9.f5597a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x029a, code lost:
        if (r0.length() != 0) goto L_0x02ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02ab, code lost:
        return new com.google.android.gms.internal.measurement.C1092f(java.util.Arrays.asList(new com.google.android.gms.internal.measurement.r[]{r9}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x02ac, code lost:
        r2 = new java.util.ArrayList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x02b6, code lost:
        if (r1.isEmpty() == false) goto L_0x02bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x02b8, code lost:
        r2.add(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x02bd, code lost:
        r3 = r6.a((com.google.android.gms.internal.measurement.r) r1.get(0)).b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02d0, code lost:
        if (r1.size() <= 1) goto L_0x02e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02d2, code lost:
        r4 = com.google.android.gms.internal.measurement.C1238v2.h(r6.a((com.google.android.gms.internal.measurement.r) r1.get(1)).C().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x02e9, code lost:
        r4 = 2147483647L;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x02f0, code lost:
        if (r4 != 0) goto L_0x02f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x02f7, code lost:
        return new com.google.android.gms.internal.measurement.C1092f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x02f8, code lost:
        r0 = r0.split(java.util.regex.Pattern.quote(r3), ((int) r4) + 1);
        r1 = r0.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x030a, code lost:
        if (r3.isEmpty() == false) goto L_0x0322;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x030c, code lost:
        if (r1 <= 0) goto L_0x0322;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x030e, code lost:
        r8 = r0[0].isEmpty();
        r3 = r1 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x031e, code lost:
        if (r0[r3].isEmpty() != false) goto L_0x0324;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0320, code lost:
        r3 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0322, code lost:
        r3 = r1;
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0327, code lost:
        if (((long) r1) <= r4) goto L_0x032b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0329, code lost:
        r3 = r3 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x032b, code lost:
        if (r8 >= r3) goto L_0x033a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x032d, code lost:
        r2.add(new com.google.android.gms.internal.measurement.C1235v(r0[r8]));
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x033f, code lost:
        return new com.google.android.gms.internal.measurement.C1092f(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0340, code lost:
        r6 = r24;
        r1 = r25;
        com.google.android.gms.internal.measurement.C1238v2.c("slice", 2, r1);
        r0 = r22.f5597a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0350, code lost:
        if (r1.isEmpty() != false) goto L_0x0366;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0352, code lost:
        r7 = r6.a((com.google.android.gms.internal.measurement.r) r1.get(0)).C().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0366, code lost:
        r7 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0367, code lost:
        r7 = com.google.android.gms.internal.measurement.C1238v2.i(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x036d, code lost:
        if (r7 >= 0.0d) goto L_0x037a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x036f, code lost:
        r7 = java.lang.Math.max(((double) r0.length()) + r7, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x037a, code lost:
        r7 = java.lang.Math.min(r7, (double) r0.length());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0388, code lost:
        if (r1.size() <= 1) goto L_0x039d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x038a, code lost:
        r1 = r6.a((com.google.android.gms.internal.measurement.r) r1.get(1)).C().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x039d, code lost:
        r1 = (double) r0.length();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x03a2, code lost:
        r1 = com.google.android.gms.internal.measurement.C1238v2.i(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x03a8, code lost:
        if (r1 >= 0.0d) goto L_0x03b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x03aa, code lost:
        r1 = java.lang.Math.max(((double) r0.length()) + r1, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x03b5, code lost:
        r1 = java.lang.Math.min(r1, (double) r0.length());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x03be, code lost:
        r3 = (int) r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x03d0, code lost:
        return new com.google.android.gms.internal.measurement.C1235v(r0.substring(r3, java.lang.Math.max(0, ((int) r1) - r3) + r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x03d1, code lost:
        r9 = r22;
        r6 = r24;
        r1 = r25;
        r2 = r16;
        com.google.android.gms.internal.measurement.C1238v2.c("search", 1, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x03e1, code lost:
        if (r1.isEmpty() != false) goto L_0x03f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x03e3, code lost:
        r18 = r6.a((com.google.android.gms.internal.measurement.r) r1.get(r2)).b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x03f1, code lost:
        r0 = java.util.regex.Pattern.compile(r18).matcher(r9.f5597a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x03ff, code lost:
        if (r0.find() == false) goto L_0x0410;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x040f, code lost:
        return new com.google.android.gms.internal.measurement.C1128j(java.lang.Double.valueOf((double) r0.start()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x041b, code lost:
        return new com.google.android.gms.internal.measurement.C1128j(java.lang.Double.valueOf(-1.0d));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x041c, code lost:
        r9 = r22;
        r6 = r24;
        r1 = r25;
        com.google.android.gms.internal.measurement.C1238v2.c("replace", 2, r1);
        r0 = com.google.android.gms.internal.measurement.r.f5553b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x042c, code lost:
        if (r1.isEmpty() != false) goto L_0x044e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x042e, code lost:
        r18 = r6.a((com.google.android.gms.internal.measurement.r) r1.get(0)).b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0442, code lost:
        if (r1.size() <= 1) goto L_0x044e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0444, code lost:
        r0 = r6.a((com.google.android.gms.internal.measurement.r) r1.get(1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x044e, code lost:
        r1 = r18;
        r2 = r9.f5597a;
        r3 = r2.indexOf(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0456, code lost:
        if (r3 < 0) goto L_0x04c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x045a, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.C1137k) == false) goto L_0x0484;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x045c, code lost:
        r8 = 0;
        r0 = ((com.google.android.gms.internal.measurement.C1137k) r0).a(r6, java.util.Arrays.asList(new com.google.android.gms.internal.measurement.r[]{new com.google.android.gms.internal.measurement.C1235v(r1), new com.google.android.gms.internal.measurement.C1128j(java.lang.Double.valueOf((double) r3)), r9}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0484, code lost:
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x0485, code lost:
        r5 = r2.substring(r8, r3);
        r0 = r0.b();
        r1 = r2.substring(r3 + r1.length());
        r7 = new java.lang.StringBuilder((java.lang.String.valueOf(r5).length() + java.lang.String.valueOf(r0).length()) + java.lang.String.valueOf(r1).length());
        r7.append(r5);
        r7.append(r0);
        r7.append(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x04c7, code lost:
        return new com.google.android.gms.internal.measurement.C1235v(r7.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x04cb, code lost:
        r6 = r24;
        r1 = r25;
        com.google.android.gms.internal.measurement.C1238v2.c("match", 1, r1);
        r0 = r22.f5597a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x04db, code lost:
        if (r1.size() > 0) goto L_0x04e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x04dd, code lost:
        r1 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x04e0, code lost:
        r1 = r6.a((com.google.android.gms.internal.measurement.r) r1.get(0)).b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x04ef, code lost:
        r0 = java.util.regex.Pattern.compile(r1).matcher(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x04fb, code lost:
        if (r0.find() == false) goto L_0x0516;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x0515, code lost:
        return new com.google.android.gms.internal.measurement.C1092f(java.util.Arrays.asList(new com.google.android.gms.internal.measurement.r[]{new com.google.android.gms.internal.measurement.C1235v(r0.group())}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x0518, code lost:
        return com.google.android.gms.internal.measurement.r.f5554c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x0519, code lost:
        r6 = r24;
        r1 = r25;
        r3 = r16;
        com.google.android.gms.internal.measurement.C1238v2.c("lastIndexOf", 2, r1);
        r0 = r22.f5597a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x052b, code lost:
        if (r1.size() > 0) goto L_0x0530;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x052d, code lost:
        r3 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x0530, code lost:
        r18 = r6.a((com.google.android.gms.internal.measurement.r) r1.get(r3)).b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x0543, code lost:
        if (r1.size() >= 2) goto L_0x0548;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x0545, code lost:
        r1 = Double.NaN;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x0548, code lost:
        r1 = r6.a((com.google.android.gms.internal.measurement.r) r1.get(1)).C().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x055f, code lost:
        if (java.lang.Double.isNaN(r1) == false) goto L_0x0564;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x0561, code lost:
        r1 = Double.POSITIVE_INFINITY;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x0564, code lost:
        r1 = com.google.android.gms.internal.measurement.C1238v2.i(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x0577, code lost:
        return new com.google.android.gms.internal.measurement.C1128j(java.lang.Double.valueOf((double) r0.lastIndexOf(r3, (int) r1)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x0578, code lost:
        r6 = r24;
        r1 = r25;
        com.google.android.gms.internal.measurement.C1238v2.c(r19, 2, r1);
        r0 = r22.f5597a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x058a, code lost:
        if (r1.size() > 0) goto L_0x058f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x058c, code lost:
        r5 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x058f, code lost:
        r18 = r6.a((com.google.android.gms.internal.measurement.r) r1.get(0)).b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x05a3, code lost:
        if (r1.size() >= 2) goto L_0x05a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x05a6, code lost:
        r3 = r6.a((com.google.android.gms.internal.measurement.r) r1.get(1)).C().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x05cc, code lost:
        return new com.google.android.gms.internal.measurement.C1128j(java.lang.Double.valueOf((double) r0.indexOf(r5, (int) com.google.android.gms.internal.measurement.C1238v2.i(r3))));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x05cd, code lost:
        r1 = r25;
        com.google.android.gms.internal.measurement.C1238v2.a(r9, 1, r1);
        r2 = r22.f5597a;
        r1 = r24.a((com.google.android.gms.internal.measurement.r) r1.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x05ee, code lost:
        if ("length".equals(r1.b()) == false) goto L_0x05f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x05f2, code lost:
        return com.google.android.gms.internal.measurement.r.f5558g0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x05f3, code lost:
        r3 = r1.C().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x0601, code lost:
        if (r3 != java.lang.Math.floor(r3)) goto L_0x060f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x0603, code lost:
        r1 = (int) r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x0604, code lost:
        if (r1 < 0) goto L_0x060f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x060a, code lost:
        if (r1 >= r2.length()) goto L_0x060f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x060e, code lost:
        return com.google.android.gms.internal.measurement.r.f5558g0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0611, code lost:
        return com.google.android.gms.internal.measurement.r.f5559h0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x0612, code lost:
        r0 = r22;
        r6 = r24;
        r1 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x061c, code lost:
        if (r1.isEmpty() != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x061e, code lost:
        r3 = new java.lang.StringBuilder(r0.f5597a);
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x062a, code lost:
        if (r8 >= r1.size()) goto L_0x0640;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x062c, code lost:
        r3.append(r6.a((com.google.android.gms.internal.measurement.r) r1.get(r8)).b());
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x0649, code lost:
        return new com.google.android.gms.internal.measurement.C1235v(r3.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x064b, code lost:
        r0 = r22;
        r6 = r24;
        r1 = r25;
        com.google.android.gms.internal.measurement.C1238v2.c(r21, 1, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x065b, code lost:
        if (r1.isEmpty() != false) goto L_0x0676;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x065d, code lost:
        r8 = (int) com.google.android.gms.internal.measurement.C1238v2.i(r6.a((com.google.android.gms.internal.measurement.r) r1.get(0)).C().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x0676, code lost:
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x0678, code lost:
        r1 = r0.f5597a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x067a, code lost:
        if (r8 < 0) goto L_0x0691;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x0680, code lost:
        if (r8 < r1.length()) goto L_0x0683;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x0690, code lost:
        return new com.google.android.gms.internal.measurement.C1235v(java.lang.String.valueOf(r1.charAt(r8)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x0693, code lost:
        return com.google.android.gms.internal.measurement.r.f5560i0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:?, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00bf, code lost:
        r4 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c1, code lost:
        r9 = r19;
        r7 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00dd, code lost:
        r4 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00df, code lost:
        r9 = r19;
        r7 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0181, code lost:
        r1 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0182, code lost:
        r18 = "undefined";
        r19 = "indexOf";
        r21 = r4;
        r3 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x018a, code lost:
        switch(r1) {
            case 0: goto L_0x064b;
            case 1: goto L_0x0612;
            case 2: goto L_0x05cd;
            case 3: goto L_0x0578;
            case 4: goto L_0x0519;
            case 5: goto L_0x04cb;
            case 6: goto L_0x041c;
            case 7: goto L_0x03d1;
            case 8: goto L_0x0340;
            case 9: goto L_0x028a;
            case 10: goto L_0x020c;
            case 11: goto L_0x01f7;
            case 12: goto L_0x01e2;
            case 13: goto L_0x01cb;
            case 14: goto L_0x01c1;
            case 15: goto L_0x01aa;
            case 16: goto L_0x0195;
            default: goto L_0x018d;
        };
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0173  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.r k(java.lang.String r23, com.google.android.gms.internal.measurement.U1 r24, java.util.List r25) {
        /*
            r22 = this;
            r1 = r23
            java.lang.String r4 = "charAt"
            boolean r5 = r4.equals(r1)
            java.lang.String r6 = "trim"
            java.lang.String r7 = "concat"
            java.lang.String r8 = "toLocaleUpperCase"
            java.lang.String r9 = "toString"
            java.lang.String r10 = "toLocaleLowerCase"
            java.lang.String r11 = "toLowerCase"
            java.lang.String r12 = "substring"
            java.lang.String r13 = "split"
            java.lang.String r14 = "slice"
            java.lang.String r15 = "search"
            r16 = r5
            java.lang.String r5 = "replace"
            java.lang.String r2 = "match"
            java.lang.String r0 = "lastIndexOf"
            java.lang.String r3 = "indexOf"
            r17 = r4
            java.lang.String r4 = "hasOwnProperty"
            r18 = r6
            java.lang.String r6 = "toUpperCase"
            r19 = r8
            if (r16 != 0) goto L_0x00b1
            boolean r16 = r7.equals(r1)
            if (r16 != 0) goto L_0x00b1
            boolean r16 = r4.equals(r1)
            if (r16 != 0) goto L_0x00b1
            boolean r16 = r3.equals(r1)
            if (r16 != 0) goto L_0x00b1
            boolean r16 = r0.equals(r1)
            if (r16 != 0) goto L_0x00b1
            boolean r16 = r2.equals(r1)
            if (r16 != 0) goto L_0x00b1
            boolean r16 = r5.equals(r1)
            if (r16 != 0) goto L_0x00b1
            boolean r16 = r15.equals(r1)
            if (r16 != 0) goto L_0x00b1
            boolean r16 = r14.equals(r1)
            if (r16 != 0) goto L_0x00b1
            boolean r16 = r13.equals(r1)
            if (r16 != 0) goto L_0x00b1
            boolean r16 = r12.equals(r1)
            if (r16 != 0) goto L_0x00b1
            boolean r16 = r11.equals(r1)
            if (r16 != 0) goto L_0x00b1
            boolean r16 = r10.equals(r1)
            if (r16 != 0) goto L_0x00b1
            boolean r16 = r9.equals(r1)
            if (r16 != 0) goto L_0x00b1
            boolean r16 = r6.equals(r1)
            if (r16 != 0) goto L_0x00b1
            r8 = r19
            r16 = 0
            boolean r19 = r8.equals(r1)
            if (r19 != 0) goto L_0x00ac
            r19 = r4
            r4 = r18
            boolean r18 = r4.equals(r1)
            if (r18 == 0) goto L_0x009b
            goto L_0x00b6
        L_0x009b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r16] = r1
            java.lang.String r1 = "%s is not a String function"
            java.lang.String r1 = java.lang.String.format(r1, r2)
            r0.<init>(r1)
            throw r0
        L_0x00ac:
            r19 = r4
            r4 = r18
            goto L_0x00b6
        L_0x00b1:
            r8 = r19
            r16 = 0
            goto L_0x00ac
        L_0x00b6:
            int r18 = r1.hashCode()
            r21 = r9
            switch(r18) {
                case -1789698943: goto L_0x0173;
                case -1776922004: goto L_0x0161;
                case -1464939364: goto L_0x0155;
                case -1361633751: goto L_0x014a;
                case -1354795244: goto L_0x013c;
                case -1137582698: goto L_0x0133;
                case -906336856: goto L_0x012b;
                case -726908483: goto L_0x0122;
                case -467511597: goto L_0x011a;
                case -399551817: goto L_0x0111;
                case 3568674: goto L_0x0108;
                case 103668165: goto L_0x0100;
                case 109526418: goto L_0x00f7;
                case 109648666: goto L_0x00ee;
                case 530542161: goto L_0x00e5;
                case 1094496948: goto L_0x00d6;
                case 1943291465: goto L_0x00c7;
                default: goto L_0x00bf;
            }
        L_0x00bf:
            r4 = r17
        L_0x00c1:
            r9 = r19
            r7 = r21
            goto L_0x0181
        L_0x00c7:
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00bf
            r4 = r17
            r9 = r19
            r7 = r21
            r1 = 3
            goto L_0x0182
        L_0x00d6:
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x00bf
            r1 = 6
        L_0x00dd:
            r4 = r17
        L_0x00df:
            r9 = r19
            r7 = r21
            goto L_0x0182
        L_0x00e5:
            boolean r1 = r1.equals(r12)
            if (r1 == 0) goto L_0x00bf
            r1 = 10
            goto L_0x00dd
        L_0x00ee:
            boolean r1 = r1.equals(r13)
            if (r1 == 0) goto L_0x00bf
            r1 = 9
            goto L_0x00dd
        L_0x00f7:
            boolean r1 = r1.equals(r14)
            if (r1 == 0) goto L_0x00bf
            r1 = 8
            goto L_0x00dd
        L_0x0100:
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00bf
            r1 = 5
            goto L_0x00dd
        L_0x0108:
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00bf
            r1 = 16
            goto L_0x00dd
        L_0x0111:
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x00bf
            r1 = 15
            goto L_0x00dd
        L_0x011a:
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00bf
            r1 = 4
            goto L_0x00dd
        L_0x0122:
            boolean r1 = r1.equals(r8)
            if (r1 == 0) goto L_0x00bf
            r1 = 11
            goto L_0x00dd
        L_0x012b:
            boolean r1 = r1.equals(r15)
            if (r1 == 0) goto L_0x00bf
            r1 = 7
            goto L_0x00dd
        L_0x0133:
            boolean r1 = r1.equals(r11)
            if (r1 == 0) goto L_0x00bf
            r1 = 13
            goto L_0x00dd
        L_0x013c:
            boolean r1 = r1.equals(r7)
            if (r1 == 0) goto L_0x00bf
            r4 = r17
            r9 = r19
            r7 = r21
            r1 = 1
            goto L_0x0182
        L_0x014a:
            r4 = r17
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00c1
            r1 = r16
            goto L_0x00df
        L_0x0155:
            r4 = r17
            boolean r1 = r1.equals(r10)
            if (r1 == 0) goto L_0x00c1
            r1 = 12
            goto L_0x00df
        L_0x0161:
            r4 = r17
            r7 = r21
            boolean r1 = r1.equals(r7)
            if (r1 == 0) goto L_0x0170
            r1 = 14
            r9 = r19
            goto L_0x0182
        L_0x0170:
            r9 = r19
            goto L_0x0181
        L_0x0173:
            r4 = r17
            r9 = r19
            r7 = r21
            boolean r1 = r1.equals(r9)
            if (r1 == 0) goto L_0x0181
            r1 = 2
            goto L_0x0182
        L_0x0181:
            r1 = -1
        L_0x0182:
            java.lang.String r18 = "undefined"
            r19 = r3
            r21 = r4
            r3 = 0
            switch(r1) {
                case 0: goto L_0x064b;
                case 1: goto L_0x0612;
                case 2: goto L_0x05cd;
                case 3: goto L_0x0578;
                case 4: goto L_0x0519;
                case 5: goto L_0x04cb;
                case 6: goto L_0x041c;
                case 7: goto L_0x03d1;
                case 8: goto L_0x0340;
                case 9: goto L_0x028a;
                case 10: goto L_0x020c;
                case 11: goto L_0x01f7;
                case 12: goto L_0x01e2;
                case 13: goto L_0x01cb;
                case 14: goto L_0x01c1;
                case 15: goto L_0x01aa;
                case 16: goto L_0x0195;
                default: goto L_0x018d;
            }
        L_0x018d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Command not supported"
            r0.<init>(r1)
            throw r0
        L_0x0195:
            r1 = r25
            r0 = r16
            com.google.android.gms.internal.measurement.C1238v2.a(r6, r0, r1)
            r9 = r22
            java.lang.String r0 = r9.f5597a
            com.google.android.gms.internal.measurement.v r1 = new com.google.android.gms.internal.measurement.v
            java.lang.String r0 = r0.trim()
            r1.<init>(r0)
            return r1
        L_0x01aa:
            r9 = r22
            r1 = r25
            r0 = r16
            com.google.android.gms.internal.measurement.C1238v2.a(r6, r0, r1)
            java.lang.String r0 = r9.f5597a
            com.google.android.gms.internal.measurement.v r1 = new com.google.android.gms.internal.measurement.v
            java.util.Locale r2 = java.util.Locale.ENGLISH
            java.lang.String r0 = r0.toUpperCase(r2)
            r1.<init>(r0)
            return r1
        L_0x01c1:
            r9 = r22
            r1 = r25
            r0 = r16
            com.google.android.gms.internal.measurement.C1238v2.a(r7, r0, r1)
            return r9
        L_0x01cb:
            r9 = r22
            r1 = r25
            r0 = r16
            com.google.android.gms.internal.measurement.C1238v2.a(r11, r0, r1)
            java.lang.String r0 = r9.f5597a
            com.google.android.gms.internal.measurement.v r1 = new com.google.android.gms.internal.measurement.v
            java.util.Locale r2 = java.util.Locale.ENGLISH
            java.lang.String r0 = r0.toLowerCase(r2)
            r1.<init>(r0)
            return r1
        L_0x01e2:
            r9 = r22
            r1 = r25
            r0 = r16
            com.google.android.gms.internal.measurement.C1238v2.a(r10, r0, r1)
            java.lang.String r0 = r9.f5597a
            com.google.android.gms.internal.measurement.v r1 = new com.google.android.gms.internal.measurement.v
            java.lang.String r0 = r0.toLowerCase()
            r1.<init>(r0)
            return r1
        L_0x01f7:
            r9 = r22
            r1 = r25
            r0 = r16
            com.google.android.gms.internal.measurement.C1238v2.a(r8, r0, r1)
            java.lang.String r0 = r9.f5597a
            com.google.android.gms.internal.measurement.v r1 = new com.google.android.gms.internal.measurement.v
            java.lang.String r0 = r0.toUpperCase()
            r1.<init>(r0)
            return r1
        L_0x020c:
            r9 = r22
            r1 = r25
            r0 = r16
            r2 = 2
            com.google.android.gms.internal.measurement.C1238v2.c(r12, r2, r1)
            java.lang.String r2 = r9.f5597a
            boolean r3 = r1.isEmpty()
            if (r3 != 0) goto L_0x0238
            java.lang.Object r3 = r1.get(r0)
            com.google.android.gms.internal.measurement.r r3 = (com.google.android.gms.internal.measurement.r) r3
            r6 = r24
            com.google.android.gms.internal.measurement.r r0 = r6.a(r3)
            java.lang.Double r0 = r0.C()
            double r3 = r0.doubleValue()
            double r3 = com.google.android.gms.internal.measurement.C1238v2.i(r3)
            int r0 = (int) r3
            goto L_0x023b
        L_0x0238:
            r6 = r24
            r0 = 0
        L_0x023b:
            int r3 = r1.size()
            r4 = 1
            if (r3 <= r4) goto L_0x025b
            java.lang.Object r1 = r1.get(r4)
            com.google.android.gms.internal.measurement.r r1 = (com.google.android.gms.internal.measurement.r) r1
            com.google.android.gms.internal.measurement.r r1 = r6.a(r1)
            java.lang.Double r1 = r1.C()
            double r3 = r1.doubleValue()
            double r3 = com.google.android.gms.internal.measurement.C1238v2.i(r3)
            int r1 = (int) r3
        L_0x0259:
            r3 = 0
            goto L_0x0260
        L_0x025b:
            int r1 = r2.length()
            goto L_0x0259
        L_0x0260:
            int r0 = java.lang.Math.max(r0, r3)
            int r4 = r2.length()
            int r0 = java.lang.Math.min(r0, r4)
            int r1 = java.lang.Math.max(r1, r3)
            int r3 = r2.length()
            int r1 = java.lang.Math.min(r1, r3)
            com.google.android.gms.internal.measurement.v r3 = new com.google.android.gms.internal.measurement.v
            int r4 = java.lang.Math.min(r0, r1)
            int r0 = java.lang.Math.max(r0, r1)
            java.lang.String r0 = r2.substring(r4, r0)
            r3.<init>(r0)
            return r3
        L_0x028a:
            r9 = r22
            r6 = r24
            r1 = r25
            r2 = 2
            com.google.android.gms.internal.measurement.C1238v2.c(r13, r2, r1)
            java.lang.String r0 = r9.f5597a
            int r2 = r0.length()
            if (r2 != 0) goto L_0x02ac
            com.google.android.gms.internal.measurement.f r0 = new com.google.android.gms.internal.measurement.f
            r2 = 1
            com.google.android.gms.internal.measurement.r[] r1 = new com.google.android.gms.internal.measurement.r[r2]
            r3 = 0
            r1[r3] = r9
            java.util.List r1 = java.util.Arrays.asList(r1)
            r0.<init>(r1)
            return r0
        L_0x02ac:
            r3 = 0
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            boolean r4 = r1.isEmpty()
            if (r4 == 0) goto L_0x02bd
            r2.add(r9)
            goto L_0x033a
        L_0x02bd:
            java.lang.Object r4 = r1.get(r3)
            com.google.android.gms.internal.measurement.r r4 = (com.google.android.gms.internal.measurement.r) r4
            com.google.android.gms.internal.measurement.r r3 = r6.a(r4)
            java.lang.String r3 = r3.b()
            int r4 = r1.size()
            r5 = 1
            if (r4 <= r5) goto L_0x02e9
            java.lang.Object r1 = r1.get(r5)
            com.google.android.gms.internal.measurement.r r1 = (com.google.android.gms.internal.measurement.r) r1
            com.google.android.gms.internal.measurement.r r1 = r6.a(r1)
            java.lang.Double r1 = r1.C()
            double r4 = r1.doubleValue()
            long r4 = com.google.android.gms.internal.measurement.C1238v2.h(r4)
            goto L_0x02ec
        L_0x02e9:
            r4 = 2147483647(0x7fffffff, double:1.060997895E-314)
        L_0x02ec:
            r6 = 0
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 != 0) goto L_0x02f8
            com.google.android.gms.internal.measurement.f r0 = new com.google.android.gms.internal.measurement.f
            r0.<init>()
            return r0
        L_0x02f8:
            java.lang.String r1 = java.util.regex.Pattern.quote(r3)
            int r6 = (int) r4
            r20 = 1
            int r6 = r6 + 1
            java.lang.String[] r0 = r0.split(r1, r6)
            int r1 = r0.length
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0322
            if (r1 <= 0) goto L_0x0322
            r16 = 0
            r3 = r0[r16]
            boolean r8 = r3.isEmpty()
            int r3 = r1 + -1
            r6 = r0[r3]
            boolean r6 = r6.isEmpty()
            if (r6 != 0) goto L_0x0324
            r3 = r1
            goto L_0x0324
        L_0x0322:
            r3 = r1
            r8 = 0
        L_0x0324:
            long r6 = (long) r1
            int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r1 <= 0) goto L_0x032b
            int r3 = r3 + -1
        L_0x032b:
            if (r8 >= r3) goto L_0x033a
            com.google.android.gms.internal.measurement.v r1 = new com.google.android.gms.internal.measurement.v
            r4 = r0[r8]
            r1.<init>(r4)
            r2.add(r1)
            int r8 = r8 + 1
            goto L_0x032b
        L_0x033a:
            com.google.android.gms.internal.measurement.f r0 = new com.google.android.gms.internal.measurement.f
            r0.<init>(r2)
            return r0
        L_0x0340:
            r9 = r22
            r6 = r24
            r1 = r25
            r2 = 2
            com.google.android.gms.internal.measurement.C1238v2.c(r14, r2, r1)
            java.lang.String r0 = r9.f5597a
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x0366
            r2 = 0
            java.lang.Object r5 = r1.get(r2)
            com.google.android.gms.internal.measurement.r r5 = (com.google.android.gms.internal.measurement.r) r5
            com.google.android.gms.internal.measurement.r r2 = r6.a(r5)
            java.lang.Double r2 = r2.C()
            double r7 = r2.doubleValue()
            goto L_0x0367
        L_0x0366:
            r7 = r3
        L_0x0367:
            double r7 = com.google.android.gms.internal.measurement.C1238v2.i(r7)
            int r2 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r2 >= 0) goto L_0x037a
            int r2 = r0.length()
            double r10 = (double) r2
            double r10 = r10 + r7
            double r7 = java.lang.Math.max(r10, r3)
            goto L_0x0383
        L_0x037a:
            int r2 = r0.length()
            double r10 = (double) r2
            double r7 = java.lang.Math.min(r7, r10)
        L_0x0383:
            int r2 = r1.size()
            r5 = 1
            if (r2 <= r5) goto L_0x039d
            java.lang.Object r1 = r1.get(r5)
            com.google.android.gms.internal.measurement.r r1 = (com.google.android.gms.internal.measurement.r) r1
            com.google.android.gms.internal.measurement.r r1 = r6.a(r1)
            java.lang.Double r1 = r1.C()
            double r1 = r1.doubleValue()
            goto L_0x03a2
        L_0x039d:
            int r1 = r0.length()
            double r1 = (double) r1
        L_0x03a2:
            double r1 = com.google.android.gms.internal.measurement.C1238v2.i(r1)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x03b5
            int r5 = r0.length()
            double r5 = (double) r5
            double r5 = r5 + r1
            double r1 = java.lang.Math.max(r5, r3)
            goto L_0x03be
        L_0x03b5:
            int r3 = r0.length()
            double r3 = (double) r3
            double r1 = java.lang.Math.min(r1, r3)
        L_0x03be:
            int r3 = (int) r7
            int r1 = (int) r1
            int r1 = r1 - r3
            r2 = 0
            int r1 = java.lang.Math.max(r2, r1)
            int r1 = r1 + r3
            com.google.android.gms.internal.measurement.v r2 = new com.google.android.gms.internal.measurement.v
            java.lang.String r0 = r0.substring(r3, r1)
            r2.<init>(r0)
            return r2
        L_0x03d1:
            r9 = r22
            r6 = r24
            r1 = r25
            r2 = r16
            r5 = 1
            com.google.android.gms.internal.measurement.C1238v2.c(r15, r5, r1)
            boolean r0 = r1.isEmpty()
            if (r0 != 0) goto L_0x03f1
            java.lang.Object r0 = r1.get(r2)
            com.google.android.gms.internal.measurement.r r0 = (com.google.android.gms.internal.measurement.r) r0
            com.google.android.gms.internal.measurement.r r0 = r6.a(r0)
            java.lang.String r18 = r0.b()
        L_0x03f1:
            java.lang.String r0 = r9.f5597a
            java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r18)
            java.util.regex.Matcher r0 = r1.matcher(r0)
            boolean r1 = r0.find()
            if (r1 == 0) goto L_0x0410
            com.google.android.gms.internal.measurement.j r1 = new com.google.android.gms.internal.measurement.j
            int r0 = r0.start()
            double r2 = (double) r0
            java.lang.Double r0 = java.lang.Double.valueOf(r2)
            r1.<init>(r0)
            return r1
        L_0x0410:
            com.google.android.gms.internal.measurement.j r0 = new com.google.android.gms.internal.measurement.j
            r1 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r0.<init>(r1)
            return r0
        L_0x041c:
            r2 = 2
            r9 = r22
            r6 = r24
            r1 = r25
            com.google.android.gms.internal.measurement.C1238v2.c(r5, r2, r1)
            com.google.android.gms.internal.measurement.r r0 = com.google.android.gms.internal.measurement.r.f5553b0
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x044e
            r2 = 0
            java.lang.Object r3 = r1.get(r2)
            com.google.android.gms.internal.measurement.r r3 = (com.google.android.gms.internal.measurement.r) r3
            com.google.android.gms.internal.measurement.r r2 = r6.a(r3)
            java.lang.String r18 = r2.b()
            int r2 = r1.size()
            r5 = 1
            if (r2 <= r5) goto L_0x044e
            java.lang.Object r0 = r1.get(r5)
            com.google.android.gms.internal.measurement.r r0 = (com.google.android.gms.internal.measurement.r) r0
            com.google.android.gms.internal.measurement.r r0 = r6.a(r0)
        L_0x044e:
            r1 = r18
            java.lang.String r2 = r9.f5597a
            int r3 = r2.indexOf(r1)
            if (r3 < 0) goto L_0x04c8
            boolean r4 = r0 instanceof com.google.android.gms.internal.measurement.C1137k
            if (r4 == 0) goto L_0x0484
            com.google.android.gms.internal.measurement.k r0 = (com.google.android.gms.internal.measurement.C1137k) r0
            com.google.android.gms.internal.measurement.v r4 = new com.google.android.gms.internal.measurement.v
            r4.<init>(r1)
            double r7 = (double) r3
            com.google.android.gms.internal.measurement.j r5 = new com.google.android.gms.internal.measurement.j
            java.lang.Double r7 = java.lang.Double.valueOf(r7)
            r5.<init>(r7)
            r7 = 3
            com.google.android.gms.internal.measurement.r[] r7 = new com.google.android.gms.internal.measurement.r[r7]
            r8 = 0
            r7[r8] = r4
            r20 = 1
            r7[r20] = r5
            r17 = 2
            r7[r17] = r9
            java.util.List r4 = java.util.Arrays.asList(r7)
            com.google.android.gms.internal.measurement.r r0 = r0.a(r6, r4)
            goto L_0x0485
        L_0x0484:
            r8 = 0
        L_0x0485:
            com.google.android.gms.internal.measurement.v r4 = new com.google.android.gms.internal.measurement.v
            java.lang.String r5 = r2.substring(r8, r3)
            java.lang.String r0 = r0.b()
            int r1 = r1.length()
            int r3 = r3 + r1
            java.lang.String r1 = r2.substring(r3)
            java.lang.String r2 = java.lang.String.valueOf(r5)
            int r2 = r2.length()
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            java.lang.String r6 = java.lang.String.valueOf(r1)
            int r6 = r6.length()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            int r2 = r2 + r3
            int r2 = r2 + r6
            r7.<init>(r2)
            r7.append(r5)
            r7.append(r0)
            r7.append(r1)
            java.lang.String r0 = r7.toString()
            r4.<init>(r0)
            return r4
        L_0x04c8:
            r0 = r9
            goto L_0x064a
        L_0x04cb:
            r9 = r22
            r6 = r24
            r1 = r25
            r5 = 1
            com.google.android.gms.internal.measurement.C1238v2.c(r2, r5, r1)
            java.lang.String r0 = r9.f5597a
            int r2 = r1.size()
            if (r2 > 0) goto L_0x04e0
            java.lang.String r1 = ""
            goto L_0x04ef
        L_0x04e0:
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            com.google.android.gms.internal.measurement.r r1 = (com.google.android.gms.internal.measurement.r) r1
            com.google.android.gms.internal.measurement.r r1 = r6.a(r1)
            java.lang.String r1 = r1.b()
        L_0x04ef:
            java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r1)
            java.util.regex.Matcher r0 = r1.matcher(r0)
            boolean r1 = r0.find()
            if (r1 == 0) goto L_0x0516
            com.google.android.gms.internal.measurement.f r1 = new com.google.android.gms.internal.measurement.f
            com.google.android.gms.internal.measurement.v r2 = new com.google.android.gms.internal.measurement.v
            java.lang.String r0 = r0.group()
            r2.<init>(r0)
            r5 = 1
            com.google.android.gms.internal.measurement.r[] r0 = new com.google.android.gms.internal.measurement.r[r5]
            r3 = 0
            r0[r3] = r2
            java.util.List r0 = java.util.Arrays.asList(r0)
            r1.<init>(r0)
            return r1
        L_0x0516:
            com.google.android.gms.internal.measurement.r r0 = com.google.android.gms.internal.measurement.r.f5554c0
            return r0
        L_0x0519:
            r9 = r22
            r6 = r24
            r1 = r25
            r3 = r16
            r2 = 2
            com.google.android.gms.internal.measurement.C1238v2.c(r0, r2, r1)
            java.lang.String r0 = r9.f5597a
            int r4 = r1.size()
            if (r4 > 0) goto L_0x0530
        L_0x052d:
            r3 = r18
            goto L_0x053f
        L_0x0530:
            java.lang.Object r3 = r1.get(r3)
            com.google.android.gms.internal.measurement.r r3 = (com.google.android.gms.internal.measurement.r) r3
            com.google.android.gms.internal.measurement.r r3 = r6.a(r3)
            java.lang.String r18 = r3.b()
            goto L_0x052d
        L_0x053f:
            int r4 = r1.size()
            if (r4 >= r2) goto L_0x0548
            r1 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            goto L_0x055b
        L_0x0548:
            r5 = 1
            java.lang.Object r1 = r1.get(r5)
            com.google.android.gms.internal.measurement.r r1 = (com.google.android.gms.internal.measurement.r) r1
            com.google.android.gms.internal.measurement.r r1 = r6.a(r1)
            java.lang.Double r1 = r1.C()
            double r1 = r1.doubleValue()
        L_0x055b:
            boolean r4 = java.lang.Double.isNaN(r1)
            if (r4 == 0) goto L_0x0564
            r1 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            goto L_0x0568
        L_0x0564:
            double r1 = com.google.android.gms.internal.measurement.C1238v2.i(r1)
        L_0x0568:
            int r1 = (int) r1
            com.google.android.gms.internal.measurement.j r2 = new com.google.android.gms.internal.measurement.j
            int r0 = r0.lastIndexOf(r3, r1)
            double r0 = (double) r0
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            r2.<init>(r0)
            return r2
        L_0x0578:
            r9 = r22
            r6 = r24
            r1 = r25
            r0 = r19
            r2 = 2
            com.google.android.gms.internal.measurement.C1238v2.c(r0, r2, r1)
            java.lang.String r0 = r9.f5597a
            int r5 = r1.size()
            if (r5 > 0) goto L_0x058f
        L_0x058c:
            r5 = r18
            goto L_0x059f
        L_0x058f:
            r8 = 0
            java.lang.Object r5 = r1.get(r8)
            com.google.android.gms.internal.measurement.r r5 = (com.google.android.gms.internal.measurement.r) r5
            com.google.android.gms.internal.measurement.r r5 = r6.a(r5)
            java.lang.String r18 = r5.b()
            goto L_0x058c
        L_0x059f:
            int r7 = r1.size()
            if (r7 >= r2) goto L_0x05a6
            goto L_0x05b9
        L_0x05a6:
            r2 = 1
            java.lang.Object r1 = r1.get(r2)
            com.google.android.gms.internal.measurement.r r1 = (com.google.android.gms.internal.measurement.r) r1
            com.google.android.gms.internal.measurement.r r1 = r6.a(r1)
            java.lang.Double r1 = r1.C()
            double r3 = r1.doubleValue()
        L_0x05b9:
            double r1 = com.google.android.gms.internal.measurement.C1238v2.i(r3)
            int r1 = (int) r1
            com.google.android.gms.internal.measurement.j r2 = new com.google.android.gms.internal.measurement.j
            int r0 = r0.indexOf(r5, r1)
            double r0 = (double) r0
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            r2.<init>(r0)
            return r2
        L_0x05cd:
            r0 = r22
            r6 = r24
            r1 = r25
            r5 = 1
            com.google.android.gms.internal.measurement.C1238v2.a(r9, r5, r1)
            java.lang.String r2 = r0.f5597a
            r3 = 0
            java.lang.Object r1 = r1.get(r3)
            com.google.android.gms.internal.measurement.r r1 = (com.google.android.gms.internal.measurement.r) r1
            com.google.android.gms.internal.measurement.r r1 = r6.a(r1)
            java.lang.String r3 = r1.b()
            java.lang.String r4 = "length"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x05f3
            com.google.android.gms.internal.measurement.r r1 = com.google.android.gms.internal.measurement.r.f5558g0
            return r1
        L_0x05f3:
            java.lang.Double r1 = r1.C()
            double r3 = r1.doubleValue()
            double r5 = java.lang.Math.floor(r3)
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x060f
            int r1 = (int) r3
            if (r1 < 0) goto L_0x060f
            int r2 = r2.length()
            if (r1 >= r2) goto L_0x060f
            com.google.android.gms.internal.measurement.r r1 = com.google.android.gms.internal.measurement.r.f5558g0
            return r1
        L_0x060f:
            com.google.android.gms.internal.measurement.r r1 = com.google.android.gms.internal.measurement.r.f5559h0
            return r1
        L_0x0612:
            r0 = r22
            r6 = r24
            r1 = r25
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x064a
            java.lang.String r2 = r0.f5597a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            r8 = 0
        L_0x0626:
            int r2 = r1.size()
            if (r8 >= r2) goto L_0x0640
            java.lang.Object r2 = r1.get(r8)
            com.google.android.gms.internal.measurement.r r2 = (com.google.android.gms.internal.measurement.r) r2
            com.google.android.gms.internal.measurement.r r2 = r6.a(r2)
            java.lang.String r2 = r2.b()
            r3.append(r2)
            int r8 = r8 + 1
            goto L_0x0626
        L_0x0640:
            java.lang.String r1 = r3.toString()
            com.google.android.gms.internal.measurement.v r2 = new com.google.android.gms.internal.measurement.v
            r2.<init>(r1)
            return r2
        L_0x064a:
            return r0
        L_0x064b:
            r0 = r22
            r6 = r24
            r1 = r25
            r4 = r21
            r5 = 1
            com.google.android.gms.internal.measurement.C1238v2.c(r4, r5, r1)
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x0676
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            com.google.android.gms.internal.measurement.r r1 = (com.google.android.gms.internal.measurement.r) r1
            com.google.android.gms.internal.measurement.r r1 = r6.a(r1)
            java.lang.Double r1 = r1.C()
            double r1 = r1.doubleValue()
            double r1 = com.google.android.gms.internal.measurement.C1238v2.i(r1)
            int r8 = (int) r1
            goto L_0x0678
        L_0x0676:
            r2 = 0
            r8 = r2
        L_0x0678:
            java.lang.String r1 = r0.f5597a
            if (r8 < 0) goto L_0x0691
            int r2 = r1.length()
            if (r8 < r2) goto L_0x0683
            goto L_0x0691
        L_0x0683:
            com.google.android.gms.internal.measurement.v r2 = new com.google.android.gms.internal.measurement.v
            char r1 = r1.charAt(r8)
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r2.<init>(r1)
            return r2
        L_0x0691:
            com.google.android.gms.internal.measurement.r r1 = com.google.android.gms.internal.measurement.r.f5560i0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C1235v.k(java.lang.String, com.google.android.gms.internal.measurement.U1, java.util.List):com.google.android.gms.internal.measurement.r");
    }

    public final String toString() {
        String str = this.f5597a;
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append("\"");
        sb.append(str);
        sb.append("\"");
        return sb.toString();
    }
}
