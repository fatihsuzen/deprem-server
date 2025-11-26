package com.mbridge.msdk.newreward.player.redirect;

import com.mbridge.msdk.foundation.same.e.a;
import com.mbridge.msdk.foundation.same.e.b;
import com.mbridge.msdk.newreward.function.command.c;

public class UrlReDirectController {
    private c commandManager;
    private b mLoader;

    /* renamed from: com.mbridge.msdk.newreward.player.redirect.UrlReDirectController$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$mbridge$msdk$newreward$player$redirect$RedirectType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.mbridge.msdk.newreward.player.redirect.RedirectType[] r0 = com.mbridge.msdk.newreward.player.redirect.RedirectType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$mbridge$msdk$newreward$player$redirect$RedirectType = r0
                com.mbridge.msdk.newreward.player.redirect.RedirectType r1 = com.mbridge.msdk.newreward.player.redirect.RedirectType.CLICK_URL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$mbridge$msdk$newreward$player$redirect$RedirectType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.newreward.player.redirect.RedirectType r1 = com.mbridge.msdk.newreward.player.redirect.RedirectType.NOTICE_URL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.player.redirect.UrlReDirectController.AnonymousClass2.<clinit>():void");
        }
    }

    public UrlReDirectController() {
        this.mLoader = null;
        this.mLoader = new b(com.mbridge.msdk.foundation.controller.c.m().c());
    }

    private void reDirect(final String str) {
        this.mLoader.a(new a() {
            public void cancelTask() {
            }

            public void pauseTask(boolean z4) {
            }

            public void runTask() {
                UrlReDirectController.this.realDoDirectUrl(str);
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void realDoDirectUrl(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0064, all -> 0x005a }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0064, all -> 0x005a }
            java.net.URLConnection r4 = r1.openConnection()     // Catch:{ Exception -> 0x0064, all -> 0x005a }
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ Exception -> 0x0064, all -> 0x005a }
            r0 = 0
            r4.setInstanceFollowRedirects(r0)     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            java.lang.String r0 = "GET"
            r4.setRequestMethod(r0)     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            r0 = 10000(0x2710, float:1.4013E-41)
            r4.setConnectTimeout(r0)     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            r4.setReadTimeout(r0)     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            java.lang.String r0 = "User-Agent"
            java.lang.String r1 = com.mbridge.msdk.foundation.tools.ab.g()     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            r4.setRequestProperty(r0, r1)     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            int r0 = r4.getResponseCode()     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            r1 = 302(0x12e, float:4.23E-43)
            if (r0 == r1) goto L_0x0032
            r1 = 301(0x12d, float:4.22E-43)
            if (r0 != r1) goto L_0x0056
        L_0x0032:
            java.lang.String r0 = "Location"
            java.lang.String r0 = r4.getHeaderField(r0)     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            java.lang.String r1 = "market:"
            boolean r1 = r0.startsWith(r1)     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            if (r1 == 0) goto L_0x0050
            com.mbridge.msdk.foundation.controller.c r1 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            android.content.Context r1 = r1.c()     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            com.mbridge.msdk.click.c.a((android.content.Context) r1, (java.lang.String) r0)     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            goto L_0x0056
        L_0x004c:
            r0 = move-exception
            goto L_0x005e
        L_0x004e:
            r0 = r4
            goto L_0x0064
        L_0x0050:
            r4.disconnect()     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            r3.realDoDirectUrl(r0)     // Catch:{ Exception -> 0x004e, all -> 0x004c }
        L_0x0056:
            r4.disconnect()
            return
        L_0x005a:
            r4 = move-exception
            r2 = r0
            r0 = r4
            r4 = r2
        L_0x005e:
            if (r4 == 0) goto L_0x0063
            r4.disconnect()
        L_0x0063:
            throw r0
        L_0x0064:
            if (r0 == 0) goto L_0x0069
            r0.disconnect()
        L_0x0069:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.player.redirect.UrlReDirectController.realDoDirectUrl(java.lang.String):void");
    }

    public void doReDirect(RedirectModel redirectModel) {
        int i5 = AnonymousClass2.$SwitchMap$com$mbridge$msdk$newreward$player$redirect$RedirectType[redirectModel.getRedirectType().ordinal()];
        if (i5 == 1) {
            reDirect((String) null);
        } else if (i5 == 2) {
            reDirect((String) null);
        }
    }

    public c getCommandManager() {
        return this.commandManager;
    }

    public void setCommandManager(c cVar) {
        this.commandManager = cVar;
    }
}
