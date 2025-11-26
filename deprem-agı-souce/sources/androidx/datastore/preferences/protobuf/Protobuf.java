package androidx.datastore.preferences.protobuf;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.concurrent.ConcurrentMap;

@CheckReturnValue
final class Protobuf {
    private static final Protobuf INSTANCE = new Protobuf();
    static boolean assumeLiteRuntime = false;
    private final ConcurrentMap<Class<?>, Schema<?>> schemaCache = new ConcurrentHashMap();
    private final SchemaFactory schemaFactory = new ManifestSchemaFactory();

    private Protobuf() {
    }

    public static Protobuf getInstance() {
        return INSTANCE;
    }

    /* access modifiers changed from: package-private */
    public int getTotalSchemaSize() {
        int i5 = 0;
        for (Schema next : this.schemaCache.values()) {
            if (next instanceof MessageSchema) {
                i5 += ((MessageSchema) next).getSchemaSize();
            }
        }
        return i5;
    }

    /* access modifiers changed from: package-private */
    public <T> boolean isInitialized(T t5) {
        return schemaFor(t5).isInitialized(t5);
    }

    public <T> void makeImmutable(T t5) {
        schemaFor(t5).makeImmutable(t5);
    }

    public <T> void mergeFrom(T t5, Reader reader) throws IOException {
        mergeFrom(t5, reader, ExtensionRegistryLite.getEmptyRegistry());
    }

    public Schema<?> registerSchema(Class<?> cls, Schema<?> schema) {
        Internal.checkNotNull(cls, "messageType");
        Internal.checkNotNull(schema, "schema");
        return this.schemaCache.putIfAbsent(cls, schema);
    }

    @CanIgnoreReturnValue
    public Schema<?> registerSchemaOverride(Class<?> cls, Schema<?> schema) {
        Internal.checkNotNull(cls, "messageType");
        Internal.checkNotNull(schema, "schema");
        return this.schemaCache.put(cls, schema);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
        r0 = r1.schemaFactory.createSchema(r2);
        r2 = registerSchema(r2, r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> androidx.datastore.preferences.protobuf.Schema<T> schemaFor(java.lang.Class<T> r2) {
        /*
            r1 = this;
            java.lang.String r0 = "messageType"
            androidx.datastore.preferences.protobuf.Internal.checkNotNull(r2, r0)
            java.util.concurrent.ConcurrentMap<java.lang.Class<?>, androidx.datastore.preferences.protobuf.Schema<?>> r0 = r1.schemaCache
            java.lang.Object r0 = r0.get(r2)
            androidx.datastore.preferences.protobuf.Schema r0 = (androidx.datastore.preferences.protobuf.Schema) r0
            if (r0 != 0) goto L_0x001c
            androidx.datastore.preferences.protobuf.SchemaFactory r0 = r1.schemaFactory
            androidx.datastore.preferences.protobuf.Schema r0 = r0.createSchema(r2)
            androidx.datastore.preferences.protobuf.Schema r2 = r1.registerSchema(r2, r0)
            if (r2 == 0) goto L_0x001c
            return r2
        L_0x001c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Protobuf.schemaFor(java.lang.Class):androidx.datastore.preferences.protobuf.Schema");
    }

    public <T> void writeTo(T t5, Writer writer) throws IOException {
        schemaFor(t5).writeTo(t5, writer);
    }

    public <T> void mergeFrom(T t5, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        schemaFor(t5).mergeFrom(t5, reader, extensionRegistryLite);
    }

    public <T> Schema<T> schemaFor(T t5) {
        return schemaFor(t5.getClass());
    }
}
