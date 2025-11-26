package k4;

public enum A {
    PARTIAL_CONSENT("partial"),
    SAVE_AND_EXIT("saveAndExit"),
    ACCEPT_ALL("acceptAll"),
    REJECT_ALL("rejectAll"),
    ACCEPT_ALL_LEGITIMATE("acceptAllLegitimate"),
    OBJECT_ALL_LEGITIMATE("objectAllLegitimate"),
    ACTION1("Action1"),
    ACTION2("Action2");
    

    /* renamed from: a  reason: collision with root package name */
    public final String f24552a;

    /* access modifiers changed from: public */
    A(String str) {
        this.f24552a = str;
    }
}
