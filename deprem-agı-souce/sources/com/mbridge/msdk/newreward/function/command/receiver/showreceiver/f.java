package com.mbridge.msdk.newreward.function.command.receiver.showreceiver;

import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.newreward.function.command.receiver.e;
import java.util.HashMap;
import java.util.Map;

public final class f implements e {

    /* renamed from: a  reason: collision with root package name */
    private final com.mbridge.msdk.newreward.function.command.f f10853a;

    /* renamed from: com.mbridge.msdk.newreward.function.command.receiver.showreceiver.f$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10854a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.mbridge.msdk.newreward.function.command.f[] r0 = com.mbridge.msdk.newreward.function.command.f.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10854a = r0
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.TEMP_PLAYER_INIT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10854a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.TEMP_PLAY_START_COUNT_DOWN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f10854a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.TEMP_PLAY_PROGRESS_COUNT_DOWN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.command.receiver.showreceiver.f.AnonymousClass1.<clinit>():void");
        }
    }

    public f(com.mbridge.msdk.newreward.function.command.f fVar) {
        this.f10853a = fVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0151  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object b(java.util.Map r20) {
        /*
            r19 = this;
            r0 = r20
            java.lang.String r1 = "campaign"
            boolean r2 = r0.containsKey(r1)
            if (r2 == 0) goto L_0x0011
            java.lang.Object r1 = r0.get(r1)
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = (com.mbridge.msdk.foundation.entity.CampaignEx) r1
            goto L_0x0012
        L_0x0011:
            r1 = 0
        L_0x0012:
            java.lang.String r2 = "fullScreenWidth"
            boolean r3 = r0.containsKey(r2)
            r4 = 0
            if (r3 == 0) goto L_0x002a
            java.lang.Object r2 = r0.get(r2)
            boolean r3 = r2 instanceof java.lang.Float
            if (r3 == 0) goto L_0x002a
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
            goto L_0x002b
        L_0x002a:
            r2 = r4
        L_0x002b:
            java.lang.String r3 = "fullScreenHeight"
            boolean r5 = r0.containsKey(r3)
            if (r5 == 0) goto L_0x0042
            java.lang.Object r3 = r0.get(r3)
            boolean r5 = r3 instanceof java.lang.Float
            if (r5 == 0) goto L_0x0042
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
            goto L_0x0043
        L_0x0042:
            r3 = r4
        L_0x0043:
            java.lang.String r5 = "orientation"
            boolean r6 = r0.containsKey(r5)
            r7 = 1
            if (r6 == 0) goto L_0x005b
            java.lang.Object r0 = r0.get(r5)
            boolean r5 = r0 instanceof java.lang.Integer
            if (r5 == 0) goto L_0x005b
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            goto L_0x005c
        L_0x005b:
            r0 = r7
        L_0x005c:
            r5 = 2
            r8 = 0
            r6 = 0
            r10 = 904(0x388, float:1.267E-42)
            if (r1 == 0) goto L_0x00ab
            java.lang.String r11 = r1.getVideoResolution()
            java.lang.String r12 = "x"
            java.lang.String[] r11 = r11.split(r12)
            int r12 = r11.length
            if (r12 != r5) goto L_0x0096
            r12 = r11[r6]
            double r12 = com.mbridge.msdk.foundation.tools.ak.m((java.lang.String) r12)
            int r12 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r12 <= 0) goto L_0x0082
            r12 = r11[r6]
            double r12 = com.mbridge.msdk.foundation.tools.ak.m((java.lang.String) r12)
            goto L_0x0083
        L_0x0082:
            r12 = r8
        L_0x0083:
            r14 = r11[r7]
            double r14 = com.mbridge.msdk.foundation.tools.ak.m((java.lang.String) r14)
            int r14 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
            if (r14 <= 0) goto L_0x0094
            r11 = r11[r7]
            double r14 = com.mbridge.msdk.foundation.tools.ak.m((java.lang.String) r11)
            goto L_0x0098
        L_0x0094:
            r14 = r8
            goto L_0x0098
        L_0x0096:
            r12 = r8
            r14 = r12
        L_0x0098:
            boolean r11 = r1.isDynamicView()
            com.mbridge.msdk.foundation.entity.CampaignEx$c r16 = r1.getRewardTemplateMode()
            if (r16 == 0) goto L_0x00ae
            com.mbridge.msdk.foundation.entity.CampaignEx$c r1 = r1.getRewardTemplateMode()
            int r10 = r1.f()
            goto L_0x00ae
        L_0x00ab:
            r11 = r7
            r12 = r8
            r14 = r12
        L_0x00ae:
            int r1 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r1 > 0) goto L_0x00b4
            r12 = 4653344314980564992(0x4094000000000000, double:1280.0)
        L_0x00b4:
            int r1 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
            if (r1 > 0) goto L_0x00bd
            r14 = 4649544402794971136(0x4086800000000000, double:720.0)
        L_0x00bd:
            int r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r1 <= 0) goto L_0x0151
            int r1 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r1 > 0) goto L_0x00c7
            goto L_0x0151
        L_0x00c7:
            double r4 = r12 / r14
            float r1 = r2 / r3
            double r8 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r4)
            double r17 = com.mbridge.msdk.foundation.tools.ak.a((java.lang.Double) r1)
            java.lang.Double r1 = java.lang.Double.valueOf(r8)
            double r8 = com.mbridge.msdk.foundation.tools.ak.a((java.lang.Double) r1)
            int r1 = (r17 > r8 ? 1 : (r17 == r8 ? 0 : -1))
            if (r1 <= 0) goto L_0x00e9
            double r8 = (double) r2
            double r8 = r8 * r14
            double r8 = r8 / r12
            int r1 = (int) r8
            r6 = r1
            r1 = -1
        L_0x00e6:
            r8 = 17
            goto L_0x00f5
        L_0x00e9:
            int r1 = (r17 > r8 ? 1 : (r17 == r8 ? 0 : -1))
            if (r1 >= 0) goto L_0x00f2
            double r8 = (double) r3
            double r8 = r8 * r4
            int r1 = (int) r8
            r6 = -1
            goto L_0x00e6
        L_0x00f2:
            r8 = r6
            r1 = -1
            r6 = -1
        L_0x00f5:
            if (r11 == 0) goto L_0x014d
            r9 = 102(0x66, float:1.43E-43)
            if (r10 == r9) goto L_0x0103
            r9 = 202(0xca, float:2.83E-43)
            if (r10 != r9) goto L_0x0100
            goto L_0x0103
        L_0x0100:
            r3 = r6
            r6 = r8
            goto L_0x0115
        L_0x0103:
            if (r0 != r7) goto L_0x0110
            double r0 = (double) r2
            double r0 = r12 / r0
            double r0 = r14 / r0
            int r6 = (int) r0
            r3 = r6
            r1 = -1
        L_0x010d:
            r6 = 17
            goto L_0x0115
        L_0x0110:
            double r0 = (double) r3
            double r0 = r0 * r4
            int r1 = (int) r0
            r3 = -1
            goto L_0x010d
        L_0x0115:
            r0 = 302(0x12e, float:4.23E-43)
            if (r10 == r0) goto L_0x0122
            r0 = 802(0x322, float:1.124E-42)
            if (r10 == r0) goto L_0x0122
            r0 = 5002010(0x4c531a, float:7.009309E-39)
            if (r10 != r0) goto L_0x014a
        L_0x0122:
            r7 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 <= 0) goto L_0x012d
            double r0 = (double) r2
            double r14 = r14 * r0
            double r14 = r14 / r12
            int r0 = (int) r14
            goto L_0x0154
        L_0x012d:
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ all -> 0x0140 }
            android.content.Context r0 = r0.c()     // Catch:{ all -> 0x0140 }
            r2 = 1130102784(0x435c0000, float:220.0)
            int r0 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r0, (float) r2)     // Catch:{ all -> 0x0140 }
            double r1 = (double) r0
            double r12 = r12 * r1
            double r12 = r12 / r14
            int r9 = (int) r12
            goto L_0x0160
        L_0x0140:
            r0 = move-exception
            java.lang.String r2 = "RefactorShow"
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r2, r0)
        L_0x014a:
            r9 = r1
            r0 = r3
            goto L_0x0160
        L_0x014d:
            r9 = r1
            r0 = r6
            r6 = r8
            goto L_0x0160
        L_0x0151:
            if (r0 != r5) goto L_0x0156
            r0 = -1
        L_0x0154:
            r9 = -1
            goto L_0x0160
        L_0x0156:
            r0 = 1091567616(0x41100000, float:9.0)
            float r2 = r2 * r0
            r0 = 1098907648(0x41800000, float:16.0)
            float r2 = r2 / r0
            int r0 = (int) r2
            r6 = 17
            goto L_0x0154
        L_0x0160:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.lang.String r2 = "width"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r9)
            r1.put(r2, r3)
            java.lang.String r2 = "height"
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.put(r2, r0)
            java.lang.String r0 = "gravity"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
            r1.put(r0, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.command.receiver.showreceiver.f.b(java.util.Map):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0157, code lost:
        if (r1 == 0) goto L_0x0159;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x018a, code lost:
        if (r0 == 0) goto L_0x0159;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.lang.Object r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof java.util.Map
            r1 = 0
            if (r0 == 0) goto L_0x0008
            java.util.Map r13 = (java.util.Map) r13
            goto L_0x0009
        L_0x0008:
            r13 = r1
        L_0x0009:
            if (r13 != 0) goto L_0x000c
            return r1
        L_0x000c:
            int[] r0 = com.mbridge.msdk.newreward.function.command.receiver.showreceiver.f.AnonymousClass1.f10854a
            com.mbridge.msdk.newreward.function.command.f r2 = r12.f10853a
            int r2 = r2.ordinal()
            r0 = r0[r2]
            r2 = 1
            if (r0 == r2) goto L_0x01a6
            r3 = 2
            if (r0 == r3) goto L_0x01a1
            r3 = 3
            if (r0 == r3) goto L_0x0020
            return r1
        L_0x0020:
            java.lang.String r0 = "videoCompleteTime"
            boolean r3 = r13.containsKey(r0)
            r4 = 0
            if (r3 == 0) goto L_0x0034
            java.lang.Object r0 = r13.get(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            goto L_0x0035
        L_0x0034:
            r0 = r4
        L_0x0035:
            java.lang.String r3 = "campaign"
            boolean r5 = r13.containsKey(r3)
            if (r5 == 0) goto L_0x0043
            java.lang.Object r1 = r13.get(r3)
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = (com.mbridge.msdk.foundation.entity.CampaignEx) r1
        L_0x0043:
            java.lang.String r3 = "isIV"
            boolean r5 = r13.containsKey(r3)
            if (r5 == 0) goto L_0x0056
            java.lang.Object r3 = r13.get(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            goto L_0x0057
        L_0x0056:
            r3 = r4
        L_0x0057:
            java.lang.String r5 = "videoSkipTime"
            boolean r6 = r13.containsKey(r5)
            if (r6 == 0) goto L_0x006a
            java.lang.Object r5 = r13.get(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            goto L_0x006b
        L_0x006a:
            r5 = r4
        L_0x006b:
            java.lang.String r6 = "allDuration"
            boolean r7 = r13.containsKey(r6)
            if (r7 == 0) goto L_0x007e
            java.lang.Object r6 = r13.get(r6)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            goto L_0x007f
        L_0x007e:
            r6 = r4
        L_0x007f:
            java.lang.String r7 = "curPlayPosition"
            boolean r8 = r13.containsKey(r7)
            if (r8 == 0) goto L_0x0092
            java.lang.Object r13 = r13.get(r7)
            java.lang.Integer r13 = (java.lang.Integer) r13
            int r13 = r13.intValue()
            goto L_0x0093
        L_0x0092:
            r13 = r4
        L_0x0093:
            java.lang.String r7 = "string"
            if (r3 == 0) goto L_0x00a9
            int r8 = r6 - r13
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            java.lang.Object[] r9 = new java.lang.Object[r2]
            r9[r4] = r8
            java.lang.String r8 = "%s"
            java.lang.String r8 = java.lang.String.format(r8, r9)
            goto L_0x0116
        L_0x00a9:
            if (r0 <= r6) goto L_0x00ac
            r0 = r6
        L_0x00ac:
            if (r0 > 0) goto L_0x00b1
            int r8 = r6 - r13
            goto L_0x00b3
        L_0x00b1:
            int r8 = r0 - r13
        L_0x00b3:
            if (r8 > 0) goto L_0x00db
            if (r0 > 0) goto L_0x00ba
            java.lang.String r8 = "0"
            goto L_0x0116
        L_0x00ba:
            com.mbridge.msdk.foundation.controller.c r8 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r8 = r8.c()
            android.content.res.Resources r8 = r8.getResources()
            com.mbridge.msdk.foundation.controller.c r9 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r9 = r9.c()
            java.lang.String r10 = "mbridge_reward_video_view_reward_time_complete"
            int r9 = com.mbridge.msdk.foundation.tools.x.a(r9, r10, r7)
            java.lang.CharSequence r8 = r8.getText(r9)
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x0116
        L_0x00db:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            if (r0 > 0) goto L_0x00ef
            r9.<init>()
            r9.append(r8)
            java.lang.String r8 = ""
        L_0x00e7:
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            goto L_0x0116
        L_0x00ef:
            r9.<init>()
            r9.append(r8)
            com.mbridge.msdk.foundation.controller.c r8 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r8 = r8.c()
            android.content.res.Resources r8 = r8.getResources()
            com.mbridge.msdk.foundation.controller.c r10 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r10 = r10.c()
            java.lang.String r11 = "mbridge_reward_video_view_reward_time_left"
            int r10 = com.mbridge.msdk.foundation.tools.x.a(r10, r11, r7)
            java.lang.CharSequence r8 = r8.getText(r10)
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x00e7
        L_0x0116:
            int r1 = r1.getUseSkipTime()
            if (r1 != r2) goto L_0x018d
            int r1 = java.lang.Math.min(r5, r6)
            r2 = 8
            java.lang.String r5 = "mbridge_reward_video_view_reward_time_left_skip_time"
            if (r1 >= r0) goto L_0x015b
            if (r1 < 0) goto L_0x015b
            int r1 = r1 - r13
            if (r1 <= 0) goto L_0x0155
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r1)
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r0 = r0.c()
            com.mbridge.msdk.foundation.controller.c r1 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r1 = r1.c()
            int r1 = com.mbridge.msdk.foundation.tools.x.a(r1, r5, r7)
            java.lang.CharSequence r0 = r0.getText(r1)
            java.lang.String r0 = (java.lang.String) r0
            r13.append(r0)
            java.lang.String r8 = r13.toString()
            goto L_0x018d
        L_0x0155:
            if (r3 == 0) goto L_0x018d
            if (r1 != 0) goto L_0x018d
        L_0x0159:
            r4 = r2
            goto L_0x018d
        L_0x015b:
            int r0 = r0 - r13
            if (r3 == 0) goto L_0x018d
            if (r0 <= 0) goto L_0x018a
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r0)
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r0 = r0.c()
            com.mbridge.msdk.foundation.controller.c r1 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r1 = r1.c()
            int r1 = com.mbridge.msdk.foundation.tools.x.a(r1, r5, r7)
            java.lang.CharSequence r0 = r0.getText(r1)
            java.lang.String r0 = (java.lang.String) r0
            r13.append(r0)
            java.lang.String r8 = r13.toString()
            goto L_0x018d
        L_0x018a:
            if (r0 != 0) goto L_0x018d
            goto L_0x0159
        L_0x018d:
            java.util.HashMap r13 = new java.util.HashMap
            r13.<init>()
            java.lang.String r0 = "countMsg"
            r13.put(r0, r8)
            java.lang.String r0 = "valueVisible"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            r13.put(r0, r1)
            return r13
        L_0x01a1:
            java.lang.Object r13 = r12.a((java.util.Map) r13)
            return r13
        L_0x01a6:
            java.lang.Object r13 = r12.b(r13)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.command.receiver.showreceiver.f.a(java.lang.Object):java.lang.Object");
    }

    private Object a(Map map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    if (map.containsKey("videoCompleteTime") && (map.get("videoCompleteTime") instanceof Integer)) {
                        int intValue = ((Integer) map.get("videoCompleteTime")).intValue();
                        int a5 = ak.a(c.m().c(), 25.0f);
                        int a6 = ak.a(c.m().c(), 5.0f);
                        int a7 = x.a(c.m().c(), intValue > 0 ? "mbridge_reward_video_time_count_num_bg" : "mbridge_reward_shape_progress", "drawable");
                        hashMap.put("width", -2);
                        hashMap.put("height", Integer.valueOf(a5));
                        hashMap.put("padding", Integer.valueOf(a6));
                        hashMap.put("background", Integer.valueOf(a7));
                        return hashMap;
                    }
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        return hashMap;
    }
}
