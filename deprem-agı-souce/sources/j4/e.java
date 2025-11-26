package j4;

public class e {
    public String a() {
        return c("http.agent");
    }

    public String b() {
        return c("java.vm.version");
    }

    public String c(String str) {
        return System.getProperty(str);
    }
}
