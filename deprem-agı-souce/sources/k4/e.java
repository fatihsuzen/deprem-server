package k4;

public enum e {
    TCF_MANDATORY("tcfui:mandatory"),
    TCF_CHANGE_OF_CONSENT("tcfui:changeofconsent"),
    USP("uspui:donotsell"),
    GBC("gbc:standalone"),
    GBC_CHANGE_OF_CONSENT("gbc:changeofconsent"),
    MSPA_MANDATORY("mspa:mandatory"),
    MSPA_CHANGE_OF_CONSENT("mspa:changeofconsent"),
    MSPA_OPT_OUT("mspa:usoptout"),
    NR("NR");
    

    /* renamed from: a  reason: collision with root package name */
    public final String f24576a;

    /* access modifiers changed from: public */
    e(String str) {
        this.f24576a = str;
    }
}
