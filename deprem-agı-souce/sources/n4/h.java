package n4;

public final class h {
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.lang.String r6, b3.C2308e r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof n4.b
            if (r0 == 0) goto L_0x0013
            r0 = r7
            n4.b r0 = (n4.b) r0
            int r1 = r0.f25521c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f25521c = r1
            goto L_0x0018
        L_0x0013:
            n4.b r0 = new n4.b
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f25519a
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f25521c
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            W2.u.b(r7)     // Catch:{ Exception -> 0x0029 }
            goto L_0x004e
        L_0x0029:
            r6 = move-exception
            goto L_0x0051
        L_0x002b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0033:
            W2.u.b(r7)
            java.lang.String r7 = "Calling api"
            H2.d.b(r7, r6)     // Catch:{ Exception -> 0x0029 }
            w3.I r7 = w3.C2865c0.b()     // Catch:{ Exception -> 0x0029 }
            n4.c r2 = new n4.c     // Catch:{ Exception -> 0x0029 }
            r4 = 0
            r2.<init>(r6, r4)     // Catch:{ Exception -> 0x0029 }
            r0.f25521c = r3     // Catch:{ Exception -> 0x0029 }
            java.lang.Object r7 = w3.C2872g.g(r7, r2, r0)     // Catch:{ Exception -> 0x0029 }
            if (r7 != r1) goto L_0x004e
            return r1
        L_0x004e:
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x0029 }
            return r7
        L_0x0051:
            boolean r7 = r6 instanceof java.security.cert.CertificateException
            if (r7 == 0) goto L_0x0056
            goto L_0x0069
        L_0x0056:
            boolean r7 = r6 instanceof javax.net.ssl.SSLHandshakeException
            if (r7 == 0) goto L_0x005b
            goto L_0x0069
        L_0x005b:
            boolean r7 = r6 instanceof java.net.SocketException
            if (r7 == 0) goto L_0x0060
            goto L_0x0069
        L_0x0060:
            boolean r7 = r6 instanceof java.net.MalformedURLException
            if (r7 == 0) goto L_0x0065
            goto L_0x0069
        L_0x0065:
            boolean r7 = r6 instanceof java.lang.NullPointerException
            if (r7 == 0) goto L_0x006c
        L_0x0069:
            com.inmobi.cmp.model.ChoiceError r6 = com.inmobi.cmp.model.ChoiceError.NETWORK_CALL_FAILED
            goto L_0x0075
        L_0x006c:
            boolean r6 = r6 instanceof java.io.FileNotFoundException
            if (r6 == 0) goto L_0x0073
            com.inmobi.cmp.model.ChoiceError r6 = com.inmobi.cmp.model.ChoiceError.NETWORK_FILE_NOT_FOUND_ERROR
            goto L_0x0075
        L_0x0073:
            com.inmobi.cmp.model.ChoiceError r6 = com.inmobi.cmp.model.ChoiceError.NETWORK_UNEXPECTED_ERROR
        L_0x0075:
            com.inmobi.cmp.ChoiceCmp r7 = com.inmobi.cmp.ChoiceCmp.INSTANCE
            com.inmobi.cmp.ChoiceCmpCallback r7 = r7.getCallback()
            if (r7 != 0) goto L_0x007e
            goto L_0x0081
        L_0x007e:
            r7.onCmpError(r6)
        L_0x0081:
            H2.a r7 = new H2.a
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: n4.h.a(java.lang.String, b3.e):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(java.lang.String r6, java.lang.String r7, b3.C2308e r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof n4.f
            if (r0 == 0) goto L_0x0013
            r0 = r8
            n4.f r0 = (n4.f) r0
            int r1 = r0.f25529c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f25529c = r1
            goto L_0x0018
        L_0x0013:
            n4.f r0 = new n4.f
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f25527a
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f25529c
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            W2.u.b(r8)     // Catch:{ Exception -> 0x0029 }
            goto L_0x0049
        L_0x0029:
            r6 = move-exception
            goto L_0x004c
        L_0x002b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0033:
            W2.u.b(r8)
            w3.I r8 = w3.C2865c0.b()     // Catch:{ Exception -> 0x0029 }
            n4.g r2 = new n4.g     // Catch:{ Exception -> 0x0029 }
            r4 = 0
            r2.<init>(r6, r7, r4)     // Catch:{ Exception -> 0x0029 }
            r0.f25529c = r3     // Catch:{ Exception -> 0x0029 }
            java.lang.Object r6 = w3.C2872g.g(r8, r2, r0)     // Catch:{ Exception -> 0x0029 }
            if (r6 != r1) goto L_0x0049
            return r1
        L_0x0049:
            W2.J r6 = W2.J.f19942a
            return r6
        L_0x004c:
            boolean r7 = r6 instanceof java.security.cert.CertificateException
            if (r7 == 0) goto L_0x0051
            goto L_0x0064
        L_0x0051:
            boolean r7 = r6 instanceof javax.net.ssl.SSLHandshakeException
            if (r7 == 0) goto L_0x0056
            goto L_0x0064
        L_0x0056:
            boolean r7 = r6 instanceof java.net.SocketException
            if (r7 == 0) goto L_0x005b
            goto L_0x0064
        L_0x005b:
            boolean r7 = r6 instanceof java.net.MalformedURLException
            if (r7 == 0) goto L_0x0060
            goto L_0x0064
        L_0x0060:
            boolean r7 = r6 instanceof java.lang.NullPointerException
            if (r7 == 0) goto L_0x0067
        L_0x0064:
            com.inmobi.cmp.model.ChoiceError r6 = com.inmobi.cmp.model.ChoiceError.NETWORK_CALL_FAILED
            goto L_0x0070
        L_0x0067:
            boolean r6 = r6 instanceof java.io.FileNotFoundException
            if (r6 == 0) goto L_0x006e
            com.inmobi.cmp.model.ChoiceError r6 = com.inmobi.cmp.model.ChoiceError.NETWORK_FILE_NOT_FOUND_ERROR
            goto L_0x0070
        L_0x006e:
            com.inmobi.cmp.model.ChoiceError r6 = com.inmobi.cmp.model.ChoiceError.NETWORK_UNEXPECTED_ERROR
        L_0x0070:
            com.inmobi.cmp.ChoiceCmp r7 = com.inmobi.cmp.ChoiceCmp.INSTANCE
            com.inmobi.cmp.ChoiceCmpCallback r7 = r7.getCallback()
            if (r7 != 0) goto L_0x0079
            goto L_0x007c
        L_0x0079:
            r7.onCmpError(r6)
        L_0x007c:
            H2.a r7 = new H2.a
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: n4.h.b(java.lang.String, java.lang.String, b3.e):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(java.lang.String r6, b3.C2308e r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof n4.d
            if (r0 == 0) goto L_0x0013
            r0 = r7
            n4.d r0 = (n4.d) r0
            int r1 = r0.f25525c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f25525c = r1
            goto L_0x0018
        L_0x0013:
            n4.d r0 = new n4.d
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f25523a
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f25525c
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            W2.u.b(r7)     // Catch:{ Exception -> 0x0029 }
            goto L_0x0049
        L_0x0029:
            r6 = move-exception
            goto L_0x0051
        L_0x002b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0033:
            W2.u.b(r7)
            w3.I r7 = w3.C2865c0.b()     // Catch:{ Exception -> 0x0029 }
            n4.e r2 = new n4.e     // Catch:{ Exception -> 0x0029 }
            r4 = 0
            r2.<init>(r6, r4)     // Catch:{ Exception -> 0x0029 }
            r0.f25525c = r3     // Catch:{ Exception -> 0x0029 }
            java.lang.Object r7 = w3.C2872g.g(r7, r2, r0)     // Catch:{ Exception -> 0x0029 }
            if (r7 != r1) goto L_0x0049
            return r1
        L_0x0049:
            java.lang.String r6 = "url: String): Bitmap {\n …}\n            }\n        }"
            kotlin.jvm.internal.t.d(r7, r6)     // Catch:{ Exception -> 0x0029 }
            android.graphics.Bitmap r7 = (android.graphics.Bitmap) r7     // Catch:{ Exception -> 0x0029 }
            return r7
        L_0x0051:
            boolean r7 = r6 instanceof java.security.cert.CertificateException
            if (r7 == 0) goto L_0x0056
            goto L_0x0069
        L_0x0056:
            boolean r7 = r6 instanceof javax.net.ssl.SSLHandshakeException
            if (r7 == 0) goto L_0x005b
            goto L_0x0069
        L_0x005b:
            boolean r7 = r6 instanceof java.net.SocketException
            if (r7 == 0) goto L_0x0060
            goto L_0x0069
        L_0x0060:
            boolean r7 = r6 instanceof java.net.MalformedURLException
            if (r7 == 0) goto L_0x0065
            goto L_0x0069
        L_0x0065:
            boolean r7 = r6 instanceof java.lang.NullPointerException
            if (r7 == 0) goto L_0x006c
        L_0x0069:
            com.inmobi.cmp.model.ChoiceError r6 = com.inmobi.cmp.model.ChoiceError.FAILED_LOGO_DOWNLOAD
            goto L_0x0075
        L_0x006c:
            boolean r6 = r6 instanceof java.io.FileNotFoundException
            if (r6 == 0) goto L_0x0073
            com.inmobi.cmp.model.ChoiceError r6 = com.inmobi.cmp.model.ChoiceError.NETWORK_FILE_NOT_FOUND_ERROR
            goto L_0x0075
        L_0x0073:
            com.inmobi.cmp.model.ChoiceError r6 = com.inmobi.cmp.model.ChoiceError.NETWORK_UNEXPECTED_ERROR
        L_0x0075:
            com.inmobi.cmp.ChoiceCmp r7 = com.inmobi.cmp.ChoiceCmp.INSTANCE
            com.inmobi.cmp.ChoiceCmpCallback r7 = r7.getCallback()
            if (r7 != 0) goto L_0x007e
            goto L_0x0081
        L_0x007e:
            r7.onCmpError(r6)
        L_0x0081:
            H2.a r7 = new H2.a
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: n4.h.c(java.lang.String, b3.e):java.lang.Object");
    }
}
