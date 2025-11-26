package com.mbridge.msdk.thrid.okhttp;

import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.publicsuffix.PublicSuffixDatabase;
import com.mbridge.msdk.thrid.okio.Buffer;
import j$.util.DesugarCollections;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class HttpUrl {
    static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    static final String FRAGMENT_ENCODE_SET = "";
    static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    static final String QUERY_ENCODE_SET = " \"'<>#";
    static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    private final String fragment;
    final String host;
    private final String password;
    private final List<String> pathSegments;
    final int port;
    private final List<String> queryNamesAndValues;
    final String scheme;
    private final String url;
    private final String username;

    HttpUrl(Builder builder) {
        List<String> list;
        this.scheme = builder.scheme;
        this.username = percentDecode(builder.encodedUsername, false);
        this.password = percentDecode(builder.encodedPassword, false);
        this.host = builder.host;
        this.port = builder.effectivePort();
        this.pathSegments = percentDecode(builder.encodedPathSegments, false);
        List<String> list2 = builder.encodedQueryNamesAndValues;
        String str = null;
        if (list2 != null) {
            list = percentDecode(list2, true);
        } else {
            list = null;
        }
        this.queryNamesAndValues = list;
        String str2 = builder.encodedFragment;
        this.fragment = str2 != null ? percentDecode(str2, false) : str;
        this.url = builder.toString();
    }

    static String canonicalize(String str, int i5, int i6, String str2, boolean z4, boolean z5, boolean z6, boolean z7, Charset charset) {
        int i7 = i5;
        while (i7 < i6) {
            int codePointAt = str.codePointAt(i7);
            if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z7) || str2.indexOf(codePointAt) != -1 || ((codePointAt == 37 && (!z4 || (z5 && !percentEncoded(str, i7, i6)))) || (codePointAt == 43 && z6)))) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, i5, i7);
                canonicalize(buffer, str, i7, i6, str2, z4, z5, z6, z7, charset);
                return buffer.readUtf8();
            }
            i7 += Character.charCount(codePointAt);
        }
        return str.substring(i5, i6);
    }

    public static int defaultPort(String str) {
        if (str.equals("http")) {
            return 80;
        }
        if (str.equals("https")) {
            return 443;
        }
        return -1;
    }

    public static HttpUrl get(String str) {
        return new Builder().parse((HttpUrl) null, str).build();
    }

    static void namesAndValuesToQueryString(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i5 = 0; i5 < size; i5 += 2) {
            String str = list.get(i5);
            String str2 = list.get(i5 + 1);
            if (i5 > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    public static HttpUrl parse(String str) {
        try {
            return get(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    static void pathSegmentsToString(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            sb.append('/');
            sb.append(list.get(i5));
        }
    }

    static String percentDecode(String str, boolean z4) {
        return percentDecode(str, 0, str.length(), z4);
    }

    static boolean percentEncoded(String str, int i5, int i6) {
        int i7 = i5 + 2;
        if (i7 >= i6 || str.charAt(i5) != '%' || Util.decodeHexDigit(str.charAt(i5 + 1)) == -1 || Util.decodeHexDigit(str.charAt(i7)) == -1) {
            return false;
        }
        return true;
    }

    static List<String> queryStringToNamesAndValues(String str) {
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        while (i5 <= str.length()) {
            int indexOf = str.indexOf(38, i5);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i5);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i5, indexOf));
                arrayList.add((Object) null);
            } else {
                arrayList.add(str.substring(i5, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i5 = indexOf + 1;
        }
        return arrayList;
    }

    public String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        return this.url.substring(this.url.indexOf(35) + 1);
    }

    public String encodedPassword() {
        if (this.password.isEmpty()) {
            return "";
        }
        int indexOf = this.url.indexOf(64);
        return this.url.substring(this.url.indexOf(58, this.scheme.length() + 3) + 1, indexOf);
    }

    public String encodedPath() {
        int indexOf = this.url.indexOf(47, this.scheme.length() + 3);
        String str = this.url;
        return this.url.substring(indexOf, Util.delimiterOffset(str, indexOf, str.length(), "?#"));
    }

    public List<String> encodedPathSegments() {
        int indexOf = this.url.indexOf(47, this.scheme.length() + 3);
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < delimiterOffset) {
            int i5 = indexOf + 1;
            int delimiterOffset2 = Util.delimiterOffset(this.url, i5, delimiterOffset, '/');
            arrayList.add(this.url.substring(i5, delimiterOffset2));
            indexOf = delimiterOffset2;
        }
        return arrayList;
    }

    public String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int indexOf = this.url.indexOf(63) + 1;
        String str = this.url;
        return this.url.substring(indexOf, Util.delimiterOffset(str, indexOf, str.length(), '#'));
    }

    public String encodedUsername() {
        if (this.username.isEmpty()) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        return this.url.substring(length, Util.delimiterOffset(str, length, str.length(), ":@"));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HttpUrl) || !((HttpUrl) obj).url.equals(this.url)) {
            return false;
        }
        return true;
    }

    public String fragment() {
        return this.fragment;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String host() {
        return this.host;
    }

    public boolean isHttps() {
        return this.scheme.equals("https");
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.scheme = this.scheme;
        builder.encodedUsername = encodedUsername();
        builder.encodedPassword = encodedPassword();
        builder.host = this.host;
        builder.port = this.port != defaultPort(this.scheme) ? this.port : -1;
        builder.encodedPathSegments.clear();
        builder.encodedPathSegments.addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.encodedFragment = encodedFragment();
        return builder;
    }

    public String password() {
        return this.password;
    }

    public List<String> pathSegments() {
        return this.pathSegments;
    }

    public int pathSize() {
        return this.pathSegments.size();
    }

    public int port() {
        return this.port;
    }

    public String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        namesAndValuesToQueryString(sb, this.queryNamesAndValues);
        return sb.toString();
    }

    public String queryParameter(String str) {
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            return null;
        }
        int size = list.size();
        for (int i5 = 0; i5 < size; i5 += 2) {
            if (str.equals(this.queryNamesAndValues.get(i5))) {
                return this.queryNamesAndValues.get(i5 + 1);
            }
        }
        return null;
    }

    public String queryParameterName(int i5) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.get(i5 * 2);
        }
        throw new IndexOutOfBoundsException();
    }

    public Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return Collections.EMPTY_SET;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int size = this.queryNamesAndValues.size();
        for (int i5 = 0; i5 < size; i5 += 2) {
            linkedHashSet.add(this.queryNamesAndValues.get(i5));
        }
        return DesugarCollections.unmodifiableSet(linkedHashSet);
    }

    public String queryParameterValue(int i5) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.get((i5 * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    public List<String> queryParameterValues(String str) {
        if (this.queryNamesAndValues == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.queryNamesAndValues.size();
        for (int i5 = 0; i5 < size; i5 += 2) {
            if (str.equals(this.queryNamesAndValues.get(i5))) {
                arrayList.add(this.queryNamesAndValues.get(i5 + 1));
            }
        }
        return DesugarCollections.unmodifiableList(arrayList);
    }

    public int querySize() {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public String redact() {
        return newBuilder("/...").username("").password("").build().toString();
    }

    public HttpUrl resolve(String str) {
        Builder newBuilder = newBuilder(str);
        if (newBuilder != null) {
            return newBuilder.build();
        }
        return null;
    }

    public String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.url;
    }

    public String topPrivateDomain() {
        if (Util.verifyAsIpAddress(this.host)) {
            return null;
        }
        return PublicSuffixDatabase.get().getEffectiveTldPlusOne(this.host);
    }

    public URI uri() {
        String builder = newBuilder().reencodeForUri().toString();
        try {
            return new URI(builder);
        } catch (URISyntaxException e5) {
            try {
                return URI.create(builder.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e5);
            }
        }
    }

    public URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e5) {
            throw new RuntimeException(e5);
        }
    }

    public String username() {
        return this.username;
    }

    public static final class Builder {
        static final String INVALID_HOST = "Invalid URL host";
        String encodedFragment;
        String encodedPassword = "";
        final List<String> encodedPathSegments;
        List<String> encodedQueryNamesAndValues;
        String encodedUsername = "";
        String host;
        int port = -1;
        String scheme;

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add("");
        }

        private static String canonicalizeHost(String str, int i5, int i6) {
            return Util.canonicalizeHost(HttpUrl.percentDecode(str, i5, i6, false));
        }

        private boolean isDot(String str) {
            if (str.equals(".") || str.equalsIgnoreCase("%2e")) {
                return true;
            }
            return false;
        }

        private boolean isDotDot(String str) {
            if (str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e")) {
                return true;
            }
            return false;
        }

        private static int parsePort(String str, int i5, int i6) {
            try {
                int parseInt = Integer.parseInt(HttpUrl.canonicalize(str, i5, i6, "", false, false, false, true, (Charset) null));
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }

        private void pop() {
            List<String> list = this.encodedPathSegments;
            if (!list.remove(list.size() - 1).isEmpty() || this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
                return;
            }
            List<String> list2 = this.encodedPathSegments;
            list2.set(list2.size() - 1, "");
        }

        private static int portColonOffset(String str, int i5, int i6) {
            while (i5 < i6) {
                char charAt = str.charAt(i5);
                if (charAt == ':') {
                    return i5;
                }
                if (charAt == '[') {
                    do {
                        i5++;
                        if (i5 >= i6) {
                            break;
                        }
                    } while (str.charAt(i5) == ']');
                }
                i5++;
            }
            return i6;
        }

        private void push(String str, int i5, int i6, boolean z4, boolean z5) {
            String canonicalize = HttpUrl.canonicalize(str, i5, i6, HttpUrl.PATH_SEGMENT_ENCODE_SET, z5, false, false, true, (Charset) null);
            if (!isDot(canonicalize)) {
                if (isDotDot(canonicalize)) {
                    pop();
                    return;
                }
                List<String> list = this.encodedPathSegments;
                if (list.get(list.size() - 1).isEmpty()) {
                    List<String> list2 = this.encodedPathSegments;
                    list2.set(list2.size() - 1, canonicalize);
                } else {
                    this.encodedPathSegments.add(canonicalize);
                }
                if (z4) {
                    this.encodedPathSegments.add("");
                }
            }
        }

        private void removeAllCanonicalQueryParameters(String str) {
            for (int size = this.encodedQueryNamesAndValues.size() - 2; size >= 0; size -= 2) {
                if (str.equals(this.encodedQueryNamesAndValues.get(size))) {
                    this.encodedQueryNamesAndValues.remove(size + 1);
                    this.encodedQueryNamesAndValues.remove(size);
                    if (this.encodedQueryNamesAndValues.isEmpty()) {
                        this.encodedQueryNamesAndValues = null;
                        return;
                    }
                }
            }
        }

        private void resolvePath(String str, int i5, int i6) {
            boolean z4;
            if (i5 != i6) {
                char charAt = str.charAt(i5);
                if (charAt == '/' || charAt == '\\') {
                    this.encodedPathSegments.clear();
                    this.encodedPathSegments.add("");
                    i5++;
                } else {
                    List<String> list = this.encodedPathSegments;
                    list.set(list.size() - 1, "");
                }
                int i7 = i5;
                while (i7 < i6) {
                    int delimiterOffset = Util.delimiterOffset(str, i7, i6, "/\\");
                    if (delimiterOffset < i6) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    String str2 = str;
                    push(str2, i7, delimiterOffset, z4, true);
                    if (z4) {
                        delimiterOffset++;
                    }
                    i7 = delimiterOffset;
                    str = str2;
                }
            }
        }

        private static int schemeDelimiterOffset(String str, int i5, int i6) {
            if (i6 - i5 < 2) {
                return -1;
            }
            char charAt = str.charAt(i5);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i5++;
                    if (i5 >= i6) {
                        break;
                    }
                    char charAt2 = str.charAt(i5);
                    if ((charAt2 < 'a' || charAt2 > 'z') && ((charAt2 < 'A' || charAt2 > 'Z') && !((charAt2 >= '0' && charAt2 <= '9') || charAt2 == '+' || charAt2 == '-' || charAt2 == '.'))) {
                        if (charAt2 == ':') {
                            return i5;
                        }
                    }
                }
            }
            return -1;
        }

        private static int slashCount(String str, int i5, int i6) {
            int i7 = 0;
            while (i5 < i6) {
                char charAt = str.charAt(i5);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i7++;
                i5++;
            }
            return i7;
        }

        public Builder addEncodedPathSegment(String str) {
            if (str != null) {
                push(str, 0, str.length(), false, true);
                return this;
            }
            throw new NullPointerException("encodedPathSegment == null");
        }

        public Builder addEncodedPathSegments(String str) {
            if (str != null) {
                return addPathSegments(str, true);
            }
            throw new NullPointerException("encodedPathSegments == null");
        }

        public Builder addEncodedQueryParameter(String str, String str2) {
            String str3;
            if (str != null) {
                if (this.encodedQueryNamesAndValues == null) {
                    this.encodedQueryNamesAndValues = new ArrayList();
                }
                this.encodedQueryNamesAndValues.add(HttpUrl.canonicalize(str, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, true));
                List<String> list = this.encodedQueryNamesAndValues;
                if (str2 != null) {
                    str3 = HttpUrl.canonicalize(str2, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, true);
                } else {
                    str3 = null;
                }
                list.add(str3);
                return this;
            }
            throw new NullPointerException("encodedName == null");
        }

        public Builder addPathSegment(String str) {
            if (str != null) {
                push(str, 0, str.length(), false, false);
                return this;
            }
            throw new NullPointerException("pathSegment == null");
        }

        public Builder addPathSegments(String str) {
            if (str != null) {
                return addPathSegments(str, false);
            }
            throw new NullPointerException("pathSegments == null");
        }

        public Builder addQueryParameter(String str, String str2) {
            String str3;
            if (str != null) {
                if (this.encodedQueryNamesAndValues == null) {
                    this.encodedQueryNamesAndValues = new ArrayList();
                }
                this.encodedQueryNamesAndValues.add(HttpUrl.canonicalize(str, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, true));
                List<String> list = this.encodedQueryNamesAndValues;
                if (str2 != null) {
                    str3 = HttpUrl.canonicalize(str2, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, true);
                } else {
                    str3 = null;
                }
                list.add(str3);
                return this;
            }
            throw new NullPointerException("name == null");
        }

        public HttpUrl build() {
            if (this.scheme == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.host != null) {
                return new HttpUrl(this);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        /* access modifiers changed from: package-private */
        public int effectivePort() {
            int i5 = this.port;
            if (i5 != -1) {
                return i5;
            }
            return HttpUrl.defaultPort(this.scheme);
        }

        public Builder encodedFragment(String str) {
            String str2;
            if (str != null) {
                str2 = HttpUrl.canonicalize(str, "", true, false, false, false);
            } else {
                str2 = null;
            }
            this.encodedFragment = str2;
            return this;
        }

        public Builder encodedPassword(String str) {
            if (str != null) {
                this.encodedPassword = HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                return this;
            }
            throw new NullPointerException("encodedPassword == null");
        }

        public Builder encodedPath(String str) {
            if (str == null) {
                throw new NullPointerException("encodedPath == null");
            } else if (str.startsWith("/")) {
                resolvePath(str, 0, str.length());
                return this;
            } else {
                throw new IllegalArgumentException("unexpected encodedPath: " + str);
            }
        }

        public Builder encodedQuery(String str) {
            List<String> list;
            if (str != null) {
                list = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(str, HttpUrl.QUERY_ENCODE_SET, true, false, true, true));
            } else {
                list = null;
            }
            this.encodedQueryNamesAndValues = list;
            return this;
        }

        public Builder encodedUsername(String str) {
            if (str != null) {
                this.encodedUsername = HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                return this;
            }
            throw new NullPointerException("encodedUsername == null");
        }

        public Builder fragment(String str) {
            String str2;
            if (str != null) {
                str2 = HttpUrl.canonicalize(str, "", false, false, false, false);
            } else {
                str2 = null;
            }
            this.encodedFragment = str2;
            return this;
        }

        public Builder host(String str) {
            if (str != null) {
                String canonicalizeHost = canonicalizeHost(str, 0, str.length());
                if (canonicalizeHost != null) {
                    this.host = canonicalizeHost;
                    return this;
                }
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            throw new NullPointerException("host == null");
        }

        /* access modifiers changed from: package-private */
        public Builder parse(HttpUrl httpUrl, String str) {
            String str2;
            int delimiterOffset;
            char c5;
            String str3;
            int i5;
            HttpUrl httpUrl2 = httpUrl;
            String str4 = str;
            int skipLeadingAsciiWhitespace = Util.skipLeadingAsciiWhitespace(str4, 0, str4.length());
            int skipTrailingAsciiWhitespace = Util.skipTrailingAsciiWhitespace(str4, skipLeadingAsciiWhitespace, str4.length());
            int schemeDelimiterOffset = schemeDelimiterOffset(str4, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace);
            if (schemeDelimiterOffset != -1) {
                if (str4.regionMatches(true, skipLeadingAsciiWhitespace, "https:", 0, 6)) {
                    this.scheme = "https";
                    skipLeadingAsciiWhitespace += 6;
                    str4 = str;
                } else {
                    str4 = str;
                    if (str4.regionMatches(true, skipLeadingAsciiWhitespace, "http:", 0, 5)) {
                        this.scheme = "http";
                        skipLeadingAsciiWhitespace += 5;
                    } else {
                        throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str4.substring(0, schemeDelimiterOffset) + "'");
                    }
                }
            } else if (httpUrl2 != null) {
                this.scheme = httpUrl2.scheme;
            } else {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            int slashCount = slashCount(str4, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace);
            char c6 = '#';
            if (slashCount >= 2 || httpUrl2 == null || !httpUrl2.scheme.equals(this.scheme)) {
                int i6 = skipLeadingAsciiWhitespace + slashCount;
                boolean z4 = false;
                boolean z5 = false;
                while (true) {
                    delimiterOffset = Util.delimiterOffset(str4, i6, skipTrailingAsciiWhitespace, "@/\\?#");
                    if (delimiterOffset != skipTrailingAsciiWhitespace) {
                        c5 = str4.charAt(delimiterOffset);
                    } else {
                        c5 = 65535;
                    }
                    if (c5 == 65535 || c5 == c6 || c5 == '/' || c5 == '\\' || c5 == '?') {
                        int i7 = delimiterOffset;
                        str2 = str4;
                        int i8 = i6;
                        int portColonOffset = portColonOffset(str2, i8, i7);
                        int i9 = portColonOffset + 1;
                    } else {
                        if (c5 != '@') {
                            str3 = str4;
                        } else {
                            if (!z4) {
                                int delimiterOffset2 = Util.delimiterOffset(str4, i6, delimiterOffset, ':');
                                int i10 = delimiterOffset;
                                String str5 = "%40";
                                String canonicalize = HttpUrl.canonicalize(str, i6, delimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, (Charset) null);
                                if (z5) {
                                    canonicalize = this.encodedUsername + str5 + canonicalize;
                                }
                                this.encodedUsername = canonicalize;
                                if (delimiterOffset2 != i10) {
                                    int i11 = delimiterOffset2 + 1;
                                    i5 = i10;
                                    this.encodedPassword = HttpUrl.canonicalize(str, i11, i5, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, (Charset) null);
                                    z4 = true;
                                } else {
                                    i5 = i10;
                                }
                                str3 = str;
                                z5 = true;
                            } else {
                                i5 = delimiterOffset;
                                StringBuilder sb = new StringBuilder();
                                sb.append(this.encodedPassword);
                                sb.append("%40");
                                str3 = str;
                                sb.append(HttpUrl.canonicalize(str3, i6, i5, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, (Charset) null));
                                this.encodedPassword = sb.toString();
                            }
                            i6 = i5 + 1;
                        }
                        str4 = str3;
                        c6 = '#';
                    }
                }
                int i72 = delimiterOffset;
                str2 = str4;
                int i82 = i6;
                int portColonOffset2 = portColonOffset(str2, i82, i72);
                int i92 = portColonOffset2 + 1;
                if (i92 < i72) {
                    this.host = canonicalizeHost(str2, i82, portColonOffset2);
                    int parsePort = parsePort(str2, i92, i72);
                    this.port = parsePort;
                    if (parsePort == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str2.substring(i92, i72) + '\"');
                    }
                } else {
                    this.host = canonicalizeHost(str2, i82, portColonOffset2);
                    this.port = HttpUrl.defaultPort(this.scheme);
                }
                if (this.host != null) {
                    skipLeadingAsciiWhitespace = i72;
                } else {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str2.substring(i82, portColonOffset2) + '\"');
                }
            } else {
                this.encodedUsername = httpUrl2.encodedUsername();
                this.encodedPassword = httpUrl2.encodedPassword();
                this.host = httpUrl2.host;
                this.port = httpUrl2.port;
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(httpUrl2.encodedPathSegments());
                if (skipLeadingAsciiWhitespace == skipTrailingAsciiWhitespace || str4.charAt(skipLeadingAsciiWhitespace) == '#') {
                    encodedQuery(httpUrl2.encodedQuery());
                }
                str2 = str4;
            }
            int delimiterOffset3 = Util.delimiterOffset(str2, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace, "?#");
            resolvePath(str2, skipLeadingAsciiWhitespace, delimiterOffset3);
            if (delimiterOffset3 < skipTrailingAsciiWhitespace && str2.charAt(delimiterOffset3) == '?') {
                int delimiterOffset4 = Util.delimiterOffset(str2, delimiterOffset3, skipTrailingAsciiWhitespace, '#');
                this.encodedQueryNamesAndValues = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(str2, delimiterOffset3 + 1, delimiterOffset4, HttpUrl.QUERY_ENCODE_SET, true, false, true, true, (Charset) null));
                delimiterOffset3 = delimiterOffset4;
            }
            if (delimiterOffset3 < skipTrailingAsciiWhitespace && str2.charAt(delimiterOffset3) == '#') {
                this.encodedFragment = HttpUrl.canonicalize(str2, delimiterOffset3 + 1, skipTrailingAsciiWhitespace, "", true, false, false, false, (Charset) null);
            }
            return this;
        }

        public Builder password(String str) {
            if (str != null) {
                this.encodedPassword = HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("password == null");
        }

        public Builder port(int i5) {
            if (i5 <= 0 || i5 > 65535) {
                throw new IllegalArgumentException("unexpected port: " + i5);
            }
            this.port = i5;
            return this;
        }

        public Builder query(String str) {
            List<String> list;
            if (str != null) {
                list = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(str, HttpUrl.QUERY_ENCODE_SET, false, false, true, true));
            } else {
                list = null;
            }
            this.encodedQueryNamesAndValues = list;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder reencodeForUri() {
            int size = this.encodedPathSegments.size();
            for (int i5 = 0; i5 < size; i5++) {
                this.encodedPathSegments.set(i5, HttpUrl.canonicalize(this.encodedPathSegments.get(i5), HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, true));
            }
            List<String> list = this.encodedQueryNamesAndValues;
            if (list != null) {
                int size2 = list.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    String str = this.encodedQueryNamesAndValues.get(i6);
                    if (str != null) {
                        this.encodedQueryNamesAndValues.set(i6, HttpUrl.canonicalize(str, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, true));
                    }
                }
            }
            String str2 = this.encodedFragment;
            if (str2 != null) {
                this.encodedFragment = HttpUrl.canonicalize(str2, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, false);
            }
            return this;
        }

        public Builder removeAllEncodedQueryParameters(String str) {
            if (str == null) {
                throw new NullPointerException("encodedName == null");
            } else if (this.encodedQueryNamesAndValues == null) {
                return this;
            } else {
                removeAllCanonicalQueryParameters(HttpUrl.canonicalize(str, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, true));
                return this;
            }
        }

        public Builder removeAllQueryParameters(String str) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (this.encodedQueryNamesAndValues == null) {
                return this;
            } else {
                removeAllCanonicalQueryParameters(HttpUrl.canonicalize(str, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, true));
                return this;
            }
        }

        public Builder removePathSegment(int i5) {
            this.encodedPathSegments.remove(i5);
            if (this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            }
            return this;
        }

        public Builder scheme(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            } else if (str.equalsIgnoreCase("http")) {
                this.scheme = "http";
                return this;
            } else if (str.equalsIgnoreCase("https")) {
                this.scheme = "https";
                return this;
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + str);
            }
        }

        public Builder setEncodedPathSegment(int i5, String str) {
            if (str != null) {
                String str2 = str;
                String canonicalize = HttpUrl.canonicalize(str2, 0, str.length(), HttpUrl.PATH_SEGMENT_ENCODE_SET, true, false, false, true, (Charset) null);
                this.encodedPathSegments.set(i5, canonicalize);
                if (!isDot(canonicalize) && !isDotDot(canonicalize)) {
                    return this;
                }
                throw new IllegalArgumentException("unexpected path segment: " + str2);
            }
            throw new NullPointerException("encodedPathSegment == null");
        }

        public Builder setEncodedQueryParameter(String str, String str2) {
            removeAllEncodedQueryParameters(str);
            addEncodedQueryParameter(str, str2);
            return this;
        }

        public Builder setPathSegment(int i5, String str) {
            if (str != null) {
                String str2 = str;
                String canonicalize = HttpUrl.canonicalize(str2, 0, str.length(), HttpUrl.PATH_SEGMENT_ENCODE_SET, false, false, false, true, (Charset) null);
                if (isDot(canonicalize) || isDotDot(canonicalize)) {
                    throw new IllegalArgumentException("unexpected path segment: " + str2);
                }
                this.encodedPathSegments.set(i5, canonicalize);
                return this;
            }
            throw new NullPointerException("pathSegment == null");
        }

        public Builder setQueryParameter(String str, String str2) {
            removeAllQueryParameters(str);
            addQueryParameter(str, str2);
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.scheme;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (!this.encodedUsername.isEmpty() || !this.encodedPassword.isEmpty()) {
                sb.append(this.encodedUsername);
                if (!this.encodedPassword.isEmpty()) {
                    sb.append(':');
                    sb.append(this.encodedPassword);
                }
                sb.append('@');
            }
            String str2 = this.host;
            if (str2 != null) {
                if (str2.indexOf(58) != -1) {
                    sb.append('[');
                    sb.append(this.host);
                    sb.append(']');
                } else {
                    sb.append(this.host);
                }
            }
            if (!(this.port == -1 && this.scheme == null)) {
                int effectivePort = effectivePort();
                String str3 = this.scheme;
                if (str3 == null || effectivePort != HttpUrl.defaultPort(str3)) {
                    sb.append(':');
                    sb.append(effectivePort);
                }
            }
            HttpUrl.pathSegmentsToString(sb, this.encodedPathSegments);
            if (this.encodedQueryNamesAndValues != null) {
                sb.append('?');
                HttpUrl.namesAndValuesToQueryString(sb, this.encodedQueryNamesAndValues);
            }
            if (this.encodedFragment != null) {
                sb.append('#');
                sb.append(this.encodedFragment);
            }
            return sb.toString();
        }

        public Builder username(String str) {
            if (str != null) {
                this.encodedUsername = HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("username == null");
        }

        private Builder addPathSegments(String str, boolean z4) {
            boolean z5;
            boolean z6;
            String str2;
            Builder builder;
            int i5 = 0;
            while (true) {
                int delimiterOffset = Util.delimiterOffset(str, i5, str.length(), "/\\");
                if (delimiterOffset < str.length()) {
                    z6 = true;
                    str2 = str;
                    z5 = z4;
                    builder = this;
                } else {
                    z6 = false;
                    builder = this;
                    str2 = str;
                    z5 = z4;
                }
                builder.push(str2, i5, delimiterOffset, z6, z5);
                i5 = delimiterOffset + 1;
                if (i5 > str2.length()) {
                    return builder;
                }
                str = str2;
                z4 = z5;
            }
        }
    }

    public static HttpUrl get(URL url2) {
        return parse(url2.toString());
    }

    private List<String> percentDecode(List<String> list, boolean z4) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i5 = 0; i5 < size; i5++) {
            String str = list.get(i5);
            arrayList.add(str != null ? percentDecode(str, z4) : null);
        }
        return DesugarCollections.unmodifiableList(arrayList);
    }

    public static HttpUrl get(URI uri) {
        return parse(uri.toString());
    }

    static String percentDecode(String str, int i5, int i6, boolean z4) {
        for (int i7 = i5; i7 < i6; i7++) {
            char charAt = str.charAt(i7);
            if (charAt == '%' || (charAt == '+' && z4)) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, i5, i7);
                percentDecode(buffer, str, i7, i6, z4);
                return buffer.readUtf8();
            }
        }
        return str.substring(i5, i6);
    }

    static void canonicalize(Buffer buffer, String str, int i5, int i6, String str2, boolean z4, boolean z5, boolean z6, boolean z7, Charset charset) {
        Buffer buffer2 = null;
        while (i5 < i6) {
            int codePointAt = str.codePointAt(i5);
            if (!z4 || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt == 43 && z6) {
                    buffer.writeUtf8(z4 ? "+" : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z7) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z4 || (z5 && !percentEncoded(str, i5, i6)))))) {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    if (charset == null || charset.equals(Util.UTF_8)) {
                        buffer2.writeUtf8CodePoint(codePointAt);
                    } else {
                        buffer2.writeString(str, i5, Character.charCount(codePointAt) + i5, charset);
                    }
                    while (!buffer2.exhausted()) {
                        byte readByte = buffer2.readByte();
                        buffer.writeByte(37);
                        char[] cArr = HEX_DIGITS;
                        buffer.writeByte((int) cArr[((readByte & 255) >> 4) & 15]);
                        buffer.writeByte((int) cArr[readByte & 15]);
                    }
                } else {
                    buffer.writeUtf8CodePoint(codePointAt);
                }
            }
            i5 += Character.charCount(codePointAt);
        }
    }

    public Builder newBuilder(String str) {
        try {
            return new Builder().parse(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    static void percentDecode(Buffer buffer, String str, int i5, int i6, boolean z4) {
        int i7;
        while (i5 < i6) {
            int codePointAt = str.codePointAt(i5);
            if (codePointAt == 37 && (i7 = i5 + 2) < i6) {
                int decodeHexDigit = Util.decodeHexDigit(str.charAt(i5 + 1));
                int decodeHexDigit2 = Util.decodeHexDigit(str.charAt(i7));
                if (!(decodeHexDigit == -1 || decodeHexDigit2 == -1)) {
                    buffer.writeByte((decodeHexDigit << 4) + decodeHexDigit2);
                    i5 = i7;
                    i5 += Character.charCount(codePointAt);
                }
            } else if (codePointAt == 43 && z4) {
                buffer.writeByte(32);
                i5 += Character.charCount(codePointAt);
            }
            buffer.writeUtf8CodePoint(codePointAt);
            i5 += Character.charCount(codePointAt);
        }
    }

    static String canonicalize(String str, String str2, boolean z4, boolean z5, boolean z6, boolean z7, Charset charset) {
        return canonicalize(str, 0, str.length(), str2, z4, z5, z6, z7, charset);
    }

    static String canonicalize(String str, String str2, boolean z4, boolean z5, boolean z6, boolean z7) {
        return canonicalize(str, 0, str.length(), str2, z4, z5, z6, z7, (Charset) null);
    }
}
