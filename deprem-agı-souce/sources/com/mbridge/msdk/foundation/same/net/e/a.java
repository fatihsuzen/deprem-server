package com.mbridge.msdk.foundation.same.net.e;

public final class a {
    public static String a(com.mbridge.msdk.foundation.same.net.a.a aVar) {
        int i5;
        if (aVar != null) {
            try {
                int i6 = aVar.f9304a;
                com.mbridge.msdk.foundation.same.net.d.a aVar2 = aVar.f9306c;
                if (aVar2 != null) {
                    i5 = aVar2.f9315d;
                } else {
                    i5 = 0;
                }
                if (i6 == -2) {
                    return "Network is canceled";
                }
                if (i6 == 15) {
                    return "Network error,I/O exception contents null";
                }
                if (i6 == 880023) {
                    return "timeout";
                }
                if (i6 == 880041) {
                    return "Network error,UnknownHostException";
                }
                switch (i6) {
                    case 1:
                        break;
                    case 2:
                        return "Network error,I/O exception";
                    case 3:
                        return "Network error,timeout exception";
                    case 4:
                        return "Network unknown error";
                    case 5:
                        return "Network error，https is not work,please check your phone time";
                    case 6:
                        if (i5 == 0) {
                            return "Network error,please check ";
                        }
                        return "Network error,please check state code " + i5;
                    case 7:
                        if (i5 == 0) {
                            return "The server returns an exception ";
                        }
                        return "The server returns an exception state code " + i5;
                    case 8:
                        return "Cast exception, return data can not be casted correctly";
                    default:
                        switch (i6) {
                            case 10:
                                return "Network error,socket timeout exception";
                            case 11:
                                return "Network error，sslp exception";
                            case 12:
                                return "Network error,ConnectException";
                            case 13:
                                if (aVar2 == null) {
                                    return "Unknown socket exception";
                                }
                                byte[] bArr = aVar2.f9312a;
                                if (bArr != null) {
                                    return new String(bArr);
                                }
                                return "Socket exception message is NULL";
                            default:
                                return "Network error,unknown";
                        }
                }
            } catch (Exception e5) {
                e5.printStackTrace();
                return "Network error,Load failed";
            }
        }
        return "Network error,Load failed";
    }
}
