package com.mbridge.msdk.playercommon.exoplayer2.upstream;

import android.text.TextUtils;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.Predicate;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import j$.util.DesugarCollections;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface HttpDataSource extends DataSource {
    public static final Predicate<String> REJECT_PAYWALL_TYPES = new Predicate<String>() {
        public final boolean evaluate(String str) {
            String lowerInvariant = Util.toLowerInvariant(str);
            if (!TextUtils.isEmpty(lowerInvariant)) {
                return (!lowerInvariant.contains(MimeTypes.BASE_TYPE_TEXT) || lowerInvariant.contains(MimeTypes.TEXT_VTT)) && !lowerInvariant.contains("html") && !lowerInvariant.contains("xml");
            }
            return false;
        }
    };

    public static abstract class BaseFactory implements Factory {
        private final RequestProperties defaultRequestProperties = new RequestProperties();

        @Deprecated
        public final void clearAllDefaultRequestProperties() {
            this.defaultRequestProperties.clear();
        }

        @Deprecated
        public final void clearDefaultRequestProperty(String str) {
            this.defaultRequestProperties.remove(str);
        }

        /* access modifiers changed from: protected */
        public abstract HttpDataSource createDataSourceInternal(RequestProperties requestProperties);

        public final RequestProperties getDefaultRequestProperties() {
            return this.defaultRequestProperties;
        }

        @Deprecated
        public final void setDefaultRequestProperty(String str, String str2) {
            this.defaultRequestProperties.set(str, str2);
        }

        public final HttpDataSource createDataSource() {
            return createDataSourceInternal(this.defaultRequestProperties);
        }
    }

    public interface Factory extends DataSource.Factory {
        @Deprecated
        void clearAllDefaultRequestProperties();

        @Deprecated
        void clearDefaultRequestProperty(String str);

        /* bridge */ /* synthetic */ DataSource createDataSource();

        HttpDataSource createDataSource();

        RequestProperties getDefaultRequestProperties();

        @Deprecated
        void setDefaultRequestProperty(String str, String str2);
    }

    public static final class InvalidContentTypeException extends HttpDataSourceException {
        public final String contentType;

        public InvalidContentTypeException(String str, DataSpec dataSpec) {
            super("Invalid content type: " + str, dataSpec, 1);
            this.contentType = str;
        }
    }

    public static final class InvalidResponseCodeException extends HttpDataSourceException {
        public final Map<String, List<String>> headerFields;
        public final int responseCode;

        public InvalidResponseCodeException(int i5, Map<String, List<String>> map, DataSpec dataSpec) {
            super("Response code: " + i5, dataSpec, 1);
            this.responseCode = i5;
            this.headerFields = map;
        }
    }

    void clearAllRequestProperties();

    void clearRequestProperty(String str);

    void close() throws HttpDataSourceException;

    Map<String, List<String>> getResponseHeaders();

    long open(DataSpec dataSpec) throws HttpDataSourceException;

    int read(byte[] bArr, int i5, int i6) throws HttpDataSourceException;

    void setRequestProperty(String str, String str2);

    public static class HttpDataSourceException extends IOException {
        public static final int TYPE_CLOSE = 3;
        public static final int TYPE_OPEN = 1;
        public static final int TYPE_READ = 2;
        public final DataSpec dataSpec;
        public final int type;

        @Retention(RetentionPolicy.SOURCE)
        public @interface Type {
        }

        public HttpDataSourceException(DataSpec dataSpec2, int i5) {
            this.dataSpec = dataSpec2;
            this.type = i5;
        }

        public HttpDataSourceException(String str, DataSpec dataSpec2, int i5) {
            super(str);
            this.dataSpec = dataSpec2;
            this.type = i5;
        }

        public HttpDataSourceException(IOException iOException, DataSpec dataSpec2, int i5) {
            super(iOException);
            this.dataSpec = dataSpec2;
            this.type = i5;
        }

        public HttpDataSourceException(String str, IOException iOException, DataSpec dataSpec2, int i5) {
            super(str, iOException);
            this.dataSpec = dataSpec2;
            this.type = i5;
        }
    }

    public static final class RequestProperties {
        private final Map<String, String> requestProperties = new HashMap();
        private Map<String, String> requestPropertiesSnapshot;

        public final synchronized void clear() {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.clear();
        }

        public final synchronized void clearAndSet(Map<String, String> map) {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.clear();
            this.requestProperties.putAll(map);
        }

        public final synchronized Map<String, String> getSnapshot() {
            try {
                if (this.requestPropertiesSnapshot == null) {
                    this.requestPropertiesSnapshot = DesugarCollections.unmodifiableMap(new HashMap(this.requestProperties));
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
            return this.requestPropertiesSnapshot;
        }

        public final synchronized void remove(String str) {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.remove(str);
        }

        public final synchronized void set(String str, String str2) {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.put(str, str2);
        }

        public final synchronized void set(Map<String, String> map) {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.putAll(map);
        }
    }
}
