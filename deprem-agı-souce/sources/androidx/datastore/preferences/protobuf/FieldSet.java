package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.FieldSet.FieldDescriptorLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.LazyField;
import androidx.datastore.preferences.protobuf.MessageLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import j$.util.DesugarCollections;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class FieldSet<T extends FieldDescriptorLite<T>> {
    private static final FieldSet<?> DEFAULT_INSTANCE = new FieldSet<>(true);
    /* access modifiers changed from: private */
    public final SmallSortedMap<T, Object> fields;
    /* access modifiers changed from: private */
    public boolean hasLazyField;
    private boolean isImmutable;

    /* renamed from: androidx.datastore.preferences.protobuf.FieldSet$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType;

        /* JADX WARNING: Can't wrap try/catch for region: R(55:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|(3:71|72|74)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(56:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|(3:71|72|74)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(58:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|74) */
        /* JADX WARNING: Can't wrap try/catch for region: R(59:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|74) */
        /* JADX WARNING: Can't wrap try/catch for region: R(60:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|74) */
        /* JADX WARNING: Can't wrap try/catch for region: R(62:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|74) */
        /* JADX WARNING: Can't wrap try/catch for region: R(65:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|74) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00e9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00f3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x00fd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0107 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x0111 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x011b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x0125 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x012f */
        static {
            /*
                androidx.datastore.preferences.protobuf.WireFormat$FieldType[] r0 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$WireFormat$FieldType = r0
                r1 = 1
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r2 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r3 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r5 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r6 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                r5 = 6
                int[] r6 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r7 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                r6 = 7
                int[] r7 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r8 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r7[r8] = r6     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                r7 = 8
                int[] r8 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r9 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r8[r9] = r7     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                r8 = 9
                int[] r9 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.GROUP     // Catch:{ NoSuchFieldError -> 0x006c }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r9[r10] = r8     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r9 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r11 = 10
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r9 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0084 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r11 = 11
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r9 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0090 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r11 = 12
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r9 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x009c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x009c }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r11 = 13
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r9 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00a8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r11 = 14
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r9 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00b4 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r11 = 15
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r9 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00c0 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r11 = 16
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r9 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00cc }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r11 = 17
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r9 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00d8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r11 = 18
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                androidx.datastore.preferences.protobuf.WireFormat$JavaType[] r9 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.values()
                int r9 = r9.length
                int[] r9 = new int[r9]
                $SwitchMap$com$google$protobuf$WireFormat$JavaType = r9
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r10 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.INT     // Catch:{ NoSuchFieldError -> 0x00e9 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e9 }
                r9[r10] = r1     // Catch:{ NoSuchFieldError -> 0x00e9 }
            L_0x00e9:
                int[] r1 = $SwitchMap$com$google$protobuf$WireFormat$JavaType     // Catch:{ NoSuchFieldError -> 0x00f3 }
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r9 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.LONG     // Catch:{ NoSuchFieldError -> 0x00f3 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f3 }
                r1[r9] = r0     // Catch:{ NoSuchFieldError -> 0x00f3 }
            L_0x00f3:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$JavaType     // Catch:{ NoSuchFieldError -> 0x00fd }
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r1 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.FLOAT     // Catch:{ NoSuchFieldError -> 0x00fd }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fd }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fd }
            L_0x00fd:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$JavaType     // Catch:{ NoSuchFieldError -> 0x0107 }
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r1 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0107 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0107 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0107 }
            L_0x0107:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$JavaType     // Catch:{ NoSuchFieldError -> 0x0111 }
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r1 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0111 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0111 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0111 }
            L_0x0111:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$JavaType     // Catch:{ NoSuchFieldError -> 0x011b }
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r1 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.STRING     // Catch:{ NoSuchFieldError -> 0x011b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x011b }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x011b }
            L_0x011b:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$JavaType     // Catch:{ NoSuchFieldError -> 0x0125 }
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r1 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.BYTE_STRING     // Catch:{ NoSuchFieldError -> 0x0125 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0125 }
                r0[r1] = r6     // Catch:{ NoSuchFieldError -> 0x0125 }
            L_0x0125:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$JavaType     // Catch:{ NoSuchFieldError -> 0x012f }
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r1 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.ENUM     // Catch:{ NoSuchFieldError -> 0x012f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x012f }
                r0[r1] = r7     // Catch:{ NoSuchFieldError -> 0x012f }
            L_0x012f:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$JavaType     // Catch:{ NoSuchFieldError -> 0x0139 }
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r1 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0139 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0139 }
                r0[r1] = r8     // Catch:{ NoSuchFieldError -> 0x0139 }
            L_0x0139:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.FieldSet.AnonymousClass1.<clinit>():void");
        }
    }

    static final class Builder<T extends FieldDescriptorLite<T>> {
        private SmallSortedMap<T, Object> fields;
        private boolean hasLazyField;
        private boolean hasNestedBuilders;
        private boolean isMutable;

        /* synthetic */ Builder(AnonymousClass1 r12) {
            this();
        }

        private FieldSet<T> buildImpl(boolean z4) {
            if (this.fields.isEmpty()) {
                return FieldSet.emptySet();
            }
            this.isMutable = false;
            SmallSortedMap<T, Object> smallSortedMap = this.fields;
            if (this.hasNestedBuilders) {
                smallSortedMap = FieldSet.cloneAllFieldsMap(smallSortedMap, false, false);
                replaceBuilders(smallSortedMap, z4);
            }
            FieldSet<T> fieldSet = new FieldSet<>(smallSortedMap, (AnonymousClass1) null);
            boolean unused = fieldSet.hasLazyField = this.hasLazyField;
            return fieldSet;
        }

        private void ensureIsMutable() {
            if (!this.isMutable) {
                this.fields = FieldSet.cloneAllFieldsMap(this.fields, true, false);
                this.isMutable = true;
            }
        }

        public static <T extends FieldDescriptorLite<T>> Builder<T> fromFieldSet(FieldSet<T> fieldSet) {
            Builder<T> builder = new Builder<>(FieldSet.cloneAllFieldsMap(fieldSet.fields, true, false));
            builder.hasLazyField = fieldSet.hasLazyField;
            return builder;
        }

        private void mergeFromField(Map.Entry<T, Object> entry) {
            FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite) entry.getKey();
            Object value = entry.getValue();
            boolean z4 = value instanceof LazyField;
            if (fieldDescriptorLite.isRepeated()) {
                if (!z4) {
                    List list = (List) getFieldAllowBuilders(fieldDescriptorLite);
                    List list2 = (List) value;
                    int size = list2.size();
                    if (list == null) {
                        list = new ArrayList(size);
                        this.fields.put(fieldDescriptorLite, list);
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        list.add(FieldSet.cloneIfMutable(list2.get(i5)));
                    }
                    return;
                }
                throw new IllegalStateException("Lazy fields can not be repeated");
            } else if (fieldDescriptorLite.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
                Object fieldAllowBuilders = getFieldAllowBuilders(fieldDescriptorLite);
                if (fieldAllowBuilders == null) {
                    this.fields.put(fieldDescriptorLite, FieldSet.cloneIfMutable(value));
                    if (z4) {
                        this.hasLazyField = true;
                        return;
                    }
                    return;
                }
                if (z4) {
                    value = ((LazyField) value).getValue();
                }
                if (fieldAllowBuilders instanceof MessageLite.Builder) {
                    fieldDescriptorLite.internalMergeFrom((MessageLite.Builder) fieldAllowBuilders, (MessageLite) value);
                    return;
                }
                this.fields.put(fieldDescriptorLite, fieldDescriptorLite.internalMergeFrom(((MessageLite) fieldAllowBuilders).toBuilder(), (MessageLite) value).build());
            } else if (!z4) {
                this.fields.put(fieldDescriptorLite, FieldSet.cloneIfMutable(value));
            } else {
                throw new IllegalStateException("Lazy fields must be message-valued");
            }
        }

        private static Object replaceBuilder(Object obj, boolean z4) {
            if (!(obj instanceof MessageLite.Builder)) {
                return obj;
            }
            MessageLite.Builder builder = (MessageLite.Builder) obj;
            if (z4) {
                return builder.buildPartial();
            }
            return builder.build();
        }

        private static <T extends FieldDescriptorLite<T>> void replaceBuilders(SmallSortedMap<T, Object> smallSortedMap, boolean z4) {
            int numArrayEntries = smallSortedMap.getNumArrayEntries();
            for (int i5 = 0; i5 < numArrayEntries; i5++) {
                replaceBuilders(smallSortedMap.getArrayEntryAt(i5), z4);
            }
            for (Map.Entry<T, Object> replaceBuilders : smallSortedMap.getOverflowEntries()) {
                replaceBuilders(replaceBuilders, z4);
            }
        }

        private void verifyType(T t5, Object obj) {
            if (FieldSet.isValidType(t5.getLiteType(), obj)) {
                return;
            }
            if (t5.getLiteType().getJavaType() != WireFormat.JavaType.MESSAGE || !(obj instanceof MessageLite.Builder)) {
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(t5.getNumber()), t5.getLiteType().getJavaType(), obj.getClass().getName()}));
            }
        }

        public void addRepeatedField(T t5, Object obj) {
            boolean z4;
            List list;
            ensureIsMutable();
            if (t5.isRepeated()) {
                if (this.hasNestedBuilders || (obj instanceof MessageLite.Builder)) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                this.hasNestedBuilders = z4;
                verifyType(t5, obj);
                Object fieldAllowBuilders = getFieldAllowBuilders(t5);
                if (fieldAllowBuilders == null) {
                    list = new ArrayList();
                    this.fields.put(t5, list);
                } else {
                    list = (List) fieldAllowBuilders;
                }
                list.add(obj);
                return;
            }
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }

        public FieldSet<T> build() {
            return buildImpl(false);
        }

        public FieldSet<T> buildPartial() {
            return buildImpl(true);
        }

        public void clearField(T t5) {
            ensureIsMutable();
            this.fields.remove(t5);
            if (this.fields.isEmpty()) {
                this.hasLazyField = false;
            }
        }

        public Map<T, Object> getAllFields() {
            if (this.hasLazyField) {
                SmallSortedMap access$100 = FieldSet.cloneAllFieldsMap(this.fields, false, true);
                if (this.fields.isImmutable()) {
                    access$100.makeImmutable();
                    return access$100;
                }
                replaceBuilders(access$100, true);
                return access$100;
            } else if (this.fields.isImmutable()) {
                return this.fields;
            } else {
                return DesugarCollections.unmodifiableMap(this.fields);
            }
        }

        public Object getField(T t5) {
            return replaceBuilders(t5, getFieldAllowBuilders(t5), true);
        }

        /* access modifiers changed from: package-private */
        public Object getFieldAllowBuilders(T t5) {
            Object obj = this.fields.get(t5);
            if (obj instanceof LazyField) {
                return ((LazyField) obj).getValue();
            }
            return obj;
        }

        public Object getRepeatedField(T t5, int i5) {
            if (this.hasNestedBuilders) {
                ensureIsMutable();
            }
            return replaceBuilder(getRepeatedFieldAllowBuilders(t5, i5), true);
        }

        /* access modifiers changed from: package-private */
        public Object getRepeatedFieldAllowBuilders(T t5, int i5) {
            if (t5.isRepeated()) {
                Object fieldAllowBuilders = getFieldAllowBuilders(t5);
                if (fieldAllowBuilders != null) {
                    return ((List) fieldAllowBuilders).get(i5);
                }
                throw new IndexOutOfBoundsException();
            }
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }

        public int getRepeatedFieldCount(T t5) {
            if (t5.isRepeated()) {
                Object fieldAllowBuilders = getFieldAllowBuilders(t5);
                if (fieldAllowBuilders == null) {
                    return 0;
                }
                return ((List) fieldAllowBuilders).size();
            }
            throw new IllegalArgumentException("getRepeatedFieldCount() can only be called on repeated fields.");
        }

        public boolean hasField(T t5) {
            if (t5.isRepeated()) {
                throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
            } else if (this.fields.get(t5) != null) {
                return true;
            } else {
                return false;
            }
        }

        public boolean isInitialized() {
            int numArrayEntries = this.fields.getNumArrayEntries();
            for (int i5 = 0; i5 < numArrayEntries; i5++) {
                if (!FieldSet.isInitialized(this.fields.getArrayEntryAt(i5))) {
                    return false;
                }
            }
            for (Map.Entry<T, Object> access$600 : this.fields.getOverflowEntries()) {
                if (!FieldSet.isInitialized(access$600)) {
                    return false;
                }
            }
            return true;
        }

        public void mergeFrom(FieldSet<T> fieldSet) {
            ensureIsMutable();
            int numArrayEntries = fieldSet.fields.getNumArrayEntries();
            for (int i5 = 0; i5 < numArrayEntries; i5++) {
                mergeFromField(fieldSet.fields.getArrayEntryAt(i5));
            }
            for (Map.Entry mergeFromField : fieldSet.fields.getOverflowEntries()) {
                mergeFromField(mergeFromField);
            }
        }

        public void setField(T t5, Object obj) {
            boolean z4;
            ensureIsMutable();
            boolean z5 = false;
            if (!t5.isRepeated()) {
                verifyType(t5, obj);
            } else if (obj instanceof List) {
                ArrayList arrayList = new ArrayList((List) obj);
                int size = arrayList.size();
                for (int i5 = 0; i5 < size; i5++) {
                    Object obj2 = arrayList.get(i5);
                    verifyType(t5, obj2);
                    if (this.hasNestedBuilders || (obj2 instanceof MessageLite.Builder)) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    this.hasNestedBuilders = z4;
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            if (obj instanceof LazyField) {
                this.hasLazyField = true;
            }
            if (this.hasNestedBuilders || (obj instanceof MessageLite.Builder)) {
                z5 = true;
            }
            this.hasNestedBuilders = z5;
            this.fields.put(t5, obj);
        }

        public void setRepeatedField(T t5, int i5, Object obj) {
            boolean z4;
            ensureIsMutable();
            if (t5.isRepeated()) {
                if (this.hasNestedBuilders || (obj instanceof MessageLite.Builder)) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                this.hasNestedBuilders = z4;
                Object fieldAllowBuilders = getFieldAllowBuilders(t5);
                if (fieldAllowBuilders != null) {
                    verifyType(t5, obj);
                    ((List) fieldAllowBuilders).set(i5, obj);
                    return;
                }
                throw new IndexOutOfBoundsException();
            }
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }

        private Builder() {
            this(SmallSortedMap.newFieldMap());
        }

        private Builder(SmallSortedMap<T, Object> smallSortedMap) {
            this.fields = smallSortedMap;
            this.isMutable = true;
        }

        private static <T extends FieldDescriptorLite<T>> void replaceBuilders(Map.Entry<T, Object> entry, boolean z4) {
            entry.setValue(replaceBuilders((FieldDescriptorLite) entry.getKey(), entry.getValue(), z4));
        }

        private static <T extends FieldDescriptorLite<T>> Object replaceBuilders(T t5, Object obj, boolean z4) {
            if (obj == null || t5.getLiteJavaType() != WireFormat.JavaType.MESSAGE) {
                return obj;
            }
            if (!t5.isRepeated()) {
                return replaceBuilder(obj, z4);
            }
            if (obj instanceof List) {
                List list = (List) obj;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    Object obj2 = list.get(i5);
                    Object replaceBuilder = replaceBuilder(obj2, z4);
                    if (replaceBuilder != obj2) {
                        if (list == obj) {
                            list = new ArrayList(list);
                        }
                        list.set(i5, replaceBuilder);
                    }
                }
                return list;
            }
            throw new IllegalStateException("Repeated field should contains a List but actually contains type: " + obj.getClass());
        }
    }

    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
        Internal.EnumLiteMap<?> getEnumType();

        WireFormat.JavaType getLiteJavaType();

        WireFormat.FieldType getLiteType();

        int getNumber();

        MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite);

        boolean isPacked();

        boolean isRepeated();
    }

    /* synthetic */ FieldSet(SmallSortedMap smallSortedMap, AnonymousClass1 r22) {
        this(smallSortedMap);
    }

    /* access modifiers changed from: private */
    public static <T extends FieldDescriptorLite<T>> SmallSortedMap<T, Object> cloneAllFieldsMap(SmallSortedMap<T, Object> smallSortedMap, boolean z4, boolean z5) {
        SmallSortedMap<T, Object> newFieldMap = SmallSortedMap.newFieldMap();
        int numArrayEntries = smallSortedMap.getNumArrayEntries();
        for (int i5 = 0; i5 < numArrayEntries; i5++) {
            cloneFieldEntry(newFieldMap, smallSortedMap.getArrayEntryAt(i5), z4, z5);
        }
        for (Map.Entry<T, Object> cloneFieldEntry : smallSortedMap.getOverflowEntries()) {
            cloneFieldEntry(newFieldMap, cloneFieldEntry, z4, z5);
        }
        return newFieldMap;
    }

    private static <T extends FieldDescriptorLite<T>> void cloneFieldEntry(Map<T, Object> map, Map.Entry<T, Object> entry, boolean z4, boolean z5) {
        FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite) entry.getKey();
        Object value = entry.getValue();
        if (z5 && (value instanceof LazyField)) {
            map.put(fieldDescriptorLite, ((LazyField) value).getValue());
        } else if (!z4 || !(value instanceof List)) {
            map.put(fieldDescriptorLite, value);
        } else {
            map.put(fieldDescriptorLite, new ArrayList((List) value));
        }
    }

    /* access modifiers changed from: private */
    public static Object cloneIfMutable(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    static int computeElementSize(WireFormat.FieldType fieldType, int i5, Object obj) {
        int computeTagSize = CodedOutputStream.computeTagSize(i5);
        if (fieldType == WireFormat.FieldType.GROUP) {
            computeTagSize *= 2;
        }
        return computeTagSize + computeElementSizeNoTag(fieldType, obj);
    }

    static int computeElementSizeNoTag(WireFormat.FieldType fieldType, Object obj) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                return CodedOutputStream.computeDoubleSizeNoTag(((Double) obj).doubleValue());
            case 2:
                return CodedOutputStream.computeFloatSizeNoTag(((Float) obj).floatValue());
            case 3:
                return CodedOutputStream.computeInt64SizeNoTag(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.computeUInt64SizeNoTag(((Long) obj).longValue());
            case 5:
                return CodedOutputStream.computeInt32SizeNoTag(((Integer) obj).intValue());
            case 6:
                return CodedOutputStream.computeFixed64SizeNoTag(((Long) obj).longValue());
            case 7:
                return CodedOutputStream.computeFixed32SizeNoTag(((Integer) obj).intValue());
            case 8:
                return CodedOutputStream.computeBoolSizeNoTag(((Boolean) obj).booleanValue());
            case 9:
                return CodedOutputStream.computeGroupSizeNoTag((MessageLite) obj);
            case 10:
                if (obj instanceof LazyField) {
                    return CodedOutputStream.computeLazyFieldSizeNoTag((LazyField) obj);
                }
                return CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj);
            case 11:
                if (obj instanceof ByteString) {
                    return CodedOutputStream.computeBytesSizeNoTag((ByteString) obj);
                }
                return CodedOutputStream.computeStringSizeNoTag((String) obj);
            case 12:
                if (obj instanceof ByteString) {
                    return CodedOutputStream.computeBytesSizeNoTag((ByteString) obj);
                }
                return CodedOutputStream.computeByteArraySizeNoTag((byte[]) obj);
            case 13:
                return CodedOutputStream.computeUInt32SizeNoTag(((Integer) obj).intValue());
            case 14:
                return CodedOutputStream.computeSFixed32SizeNoTag(((Integer) obj).intValue());
            case 15:
                return CodedOutputStream.computeSFixed64SizeNoTag(((Long) obj).longValue());
            case 16:
                return CodedOutputStream.computeSInt32SizeNoTag(((Integer) obj).intValue());
            case 17:
                return CodedOutputStream.computeSInt64SizeNoTag(((Long) obj).longValue());
            case 18:
                if (obj instanceof Internal.EnumLite) {
                    return CodedOutputStream.computeEnumSizeNoTag(((Internal.EnumLite) obj).getNumber());
                }
                return CodedOutputStream.computeEnumSizeNoTag(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int computeFieldSize(FieldDescriptorLite<?> fieldDescriptorLite, Object obj) {
        WireFormat.FieldType liteType = fieldDescriptorLite.getLiteType();
        int number = fieldDescriptorLite.getNumber();
        if (!fieldDescriptorLite.isRepeated()) {
            return computeElementSize(liteType, number, obj);
        }
        List list = (List) obj;
        int size = list.size();
        int i5 = 0;
        if (!fieldDescriptorLite.isPacked()) {
            int i6 = 0;
            while (i5 < size) {
                i6 += computeElementSize(liteType, number, list.get(i5));
                i5++;
            }
            return i6;
        } else if (list.isEmpty()) {
            return 0;
        } else {
            int i7 = 0;
            while (i5 < size) {
                i7 += computeElementSizeNoTag(liteType, list.get(i5));
                i5++;
            }
            return CodedOutputStream.computeTagSize(number) + i7 + CodedOutputStream.computeUInt32SizeNoTag(i7);
        }
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> emptySet() {
        return DEFAULT_INSTANCE;
    }

    static int getWireFormatForFieldType(WireFormat.FieldType fieldType, boolean z4) {
        if (z4) {
            return 2;
        }
        return fieldType.getWireType();
    }

    private static boolean isMessageFieldValueInitialized(Object obj) {
        if (obj instanceof MessageLiteOrBuilder) {
            return ((MessageLiteOrBuilder) obj).isInitialized();
        }
        if (obj instanceof LazyField) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    /* access modifiers changed from: private */
    public static boolean isValidType(WireFormat.FieldType fieldType, Object obj) {
        Internal.checkNotNull(obj);
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[fieldType.getJavaType().ordinal()]) {
            case 1:
                return obj instanceof Integer;
            case 2:
                return obj instanceof Long;
            case 3:
                return obj instanceof Float;
            case 4:
                return obj instanceof Double;
            case 5:
                return obj instanceof Boolean;
            case 6:
                return obj instanceof String;
            case 7:
                if ((obj instanceof ByteString) || (obj instanceof byte[])) {
                    return true;
                }
                return false;
            case 8:
                if ((obj instanceof Integer) || (obj instanceof Internal.EnumLite)) {
                    return true;
                }
                return false;
            case 9:
                if ((obj instanceof MessageLite) || (obj instanceof LazyField)) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    private void mergeFromField(Map.Entry<T, Object> entry) {
        FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite) entry.getKey();
        Object value = entry.getValue();
        boolean z4 = value instanceof LazyField;
        if (fieldDescriptorLite.isRepeated()) {
            if (!z4) {
                Object field = getField(fieldDescriptorLite);
                if (field == null) {
                    field = new ArrayList();
                }
                for (Object cloneIfMutable : (List) value) {
                    ((List) field).add(cloneIfMutable(cloneIfMutable));
                }
                this.fields.put(fieldDescriptorLite, field);
                return;
            }
            throw new IllegalStateException("Lazy fields can not be repeated");
        } else if (fieldDescriptorLite.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
            Object field2 = getField(fieldDescriptorLite);
            if (field2 == null) {
                this.fields.put(fieldDescriptorLite, cloneIfMutable(value));
                if (z4) {
                    this.hasLazyField = true;
                    return;
                }
                return;
            }
            if (z4) {
                value = ((LazyField) value).getValue();
            }
            this.fields.put(fieldDescriptorLite, fieldDescriptorLite.internalMergeFrom(((MessageLite) field2).toBuilder(), (MessageLite) value).build());
        } else if (!z4) {
            this.fields.put(fieldDescriptorLite, cloneIfMutable(value));
        } else {
            throw new IllegalStateException("Lazy fields must be message-valued");
        }
    }

    public static <T extends FieldDescriptorLite<T>> Builder<T> newBuilder() {
        return new Builder<>((AnonymousClass1) null);
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> newFieldSet() {
        return new FieldSet<>();
    }

    public static Object readPrimitiveField(CodedInputStream codedInputStream, WireFormat.FieldType fieldType, boolean z4) throws IOException {
        if (z4) {
            return WireFormat.readPrimitiveField(codedInputStream, fieldType, WireFormat.Utf8Validation.STRICT);
        }
        return WireFormat.readPrimitiveField(codedInputStream, fieldType, WireFormat.Utf8Validation.LOOSE);
    }

    private void verifyType(T t5, Object obj) {
        if (!isValidType(t5.getLiteType(), obj)) {
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(t5.getNumber()), t5.getLiteType().getJavaType(), obj.getClass().getName()}));
        }
    }

    static void writeElement(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, int i5, Object obj) throws IOException {
        if (fieldType == WireFormat.FieldType.GROUP) {
            codedOutputStream.writeGroup(i5, (MessageLite) obj);
            return;
        }
        codedOutputStream.writeTag(i5, getWireFormatForFieldType(fieldType, false));
        writeElementNoTag(codedOutputStream, fieldType, obj);
    }

    static void writeElementNoTag(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, Object obj) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                codedOutputStream.writeDoubleNoTag(((Double) obj).doubleValue());
                return;
            case 2:
                codedOutputStream.writeFloatNoTag(((Float) obj).floatValue());
                return;
            case 3:
                codedOutputStream.writeInt64NoTag(((Long) obj).longValue());
                return;
            case 4:
                codedOutputStream.writeUInt64NoTag(((Long) obj).longValue());
                return;
            case 5:
                codedOutputStream.writeInt32NoTag(((Integer) obj).intValue());
                return;
            case 6:
                codedOutputStream.writeFixed64NoTag(((Long) obj).longValue());
                return;
            case 7:
                codedOutputStream.writeFixed32NoTag(((Integer) obj).intValue());
                return;
            case 8:
                codedOutputStream.writeBoolNoTag(((Boolean) obj).booleanValue());
                return;
            case 9:
                codedOutputStream.writeGroupNoTag((MessageLite) obj);
                return;
            case 10:
                codedOutputStream.writeMessageNoTag((MessageLite) obj);
                return;
            case 11:
                if (obj instanceof ByteString) {
                    codedOutputStream.writeBytesNoTag((ByteString) obj);
                    return;
                } else {
                    codedOutputStream.writeStringNoTag((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof ByteString) {
                    codedOutputStream.writeBytesNoTag((ByteString) obj);
                    return;
                } else {
                    codedOutputStream.writeByteArrayNoTag((byte[]) obj);
                    return;
                }
            case 13:
                codedOutputStream.writeUInt32NoTag(((Integer) obj).intValue());
                return;
            case 14:
                codedOutputStream.writeSFixed32NoTag(((Integer) obj).intValue());
                return;
            case 15:
                codedOutputStream.writeSFixed64NoTag(((Long) obj).longValue());
                return;
            case 16:
                codedOutputStream.writeSInt32NoTag(((Integer) obj).intValue());
                return;
            case 17:
                codedOutputStream.writeSInt64NoTag(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof Internal.EnumLite) {
                    codedOutputStream.writeEnumNoTag(((Internal.EnumLite) obj).getNumber());
                    return;
                } else {
                    codedOutputStream.writeEnumNoTag(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public static void writeField(FieldDescriptorLite<?> fieldDescriptorLite, Object obj, CodedOutputStream codedOutputStream) throws IOException {
        WireFormat.FieldType liteType = fieldDescriptorLite.getLiteType();
        int number = fieldDescriptorLite.getNumber();
        if (fieldDescriptorLite.isRepeated()) {
            List list = (List) obj;
            int size = list.size();
            int i5 = 0;
            if (!fieldDescriptorLite.isPacked()) {
                while (i5 < size) {
                    writeElement(codedOutputStream, liteType, number, list.get(i5));
                    i5++;
                }
            } else if (!list.isEmpty()) {
                codedOutputStream.writeTag(number, 2);
                int i6 = 0;
                for (int i7 = 0; i7 < size; i7++) {
                    i6 += computeElementSizeNoTag(liteType, list.get(i7));
                }
                codedOutputStream.writeUInt32NoTag(i6);
                while (i5 < size) {
                    writeElementNoTag(codedOutputStream, liteType, list.get(i5));
                    i5++;
                }
            }
        } else if (obj instanceof LazyField) {
            writeElement(codedOutputStream, liteType, number, ((LazyField) obj).getValue());
        } else {
            writeElement(codedOutputStream, liteType, number, obj);
        }
    }

    public void addRepeatedField(T t5, Object obj) {
        List list;
        if (t5.isRepeated()) {
            verifyType(t5, obj);
            Object field = getField(t5);
            if (field == null) {
                list = new ArrayList();
                this.fields.put(t5, list);
            } else {
                list = (List) field;
            }
            list.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    public void clear() {
        this.fields.clear();
        this.hasLazyField = false;
    }

    public void clearField(T t5) {
        this.fields.remove(t5);
        if (this.fields.isEmpty()) {
            this.hasLazyField = false;
        }
    }

    /* access modifiers changed from: package-private */
    public Iterator<Map.Entry<T, Object>> descendingIterator() {
        if (isEmpty()) {
            return Collections.emptyIterator();
        }
        if (this.hasLazyField) {
            return new LazyField.LazyIterator(this.fields.descendingEntrySet().iterator());
        }
        return this.fields.descendingEntrySet().iterator();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldSet)) {
            return false;
        }
        return this.fields.equals(((FieldSet) obj).fields);
    }

    public Map<T, Object> getAllFields() {
        if (this.hasLazyField) {
            SmallSortedMap<T, Object> cloneAllFieldsMap = cloneAllFieldsMap(this.fields, false, true);
            if (this.fields.isImmutable()) {
                cloneAllFieldsMap.makeImmutable();
            }
            return cloneAllFieldsMap;
        } else if (this.fields.isImmutable()) {
            return this.fields;
        } else {
            return DesugarCollections.unmodifiableMap(this.fields);
        }
    }

    public Object getField(T t5) {
        Object obj = this.fields.get(t5);
        if (obj instanceof LazyField) {
            return ((LazyField) obj).getValue();
        }
        return obj;
    }

    public int getMessageSetSerializedSize() {
        int numArrayEntries = this.fields.getNumArrayEntries();
        int i5 = 0;
        for (int i6 = 0; i6 < numArrayEntries; i6++) {
            i5 += getMessageSetSerializedSize(this.fields.getArrayEntryAt(i6));
        }
        for (Map.Entry<T, Object> messageSetSerializedSize : this.fields.getOverflowEntries()) {
            i5 += getMessageSetSerializedSize(messageSetSerializedSize);
        }
        return i5;
    }

    public Object getRepeatedField(T t5, int i5) {
        if (t5.isRepeated()) {
            Object field = getField(t5);
            if (field != null) {
                return ((List) field).get(i5);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int getRepeatedFieldCount(T t5) {
        if (t5.isRepeated()) {
            Object field = getField(t5);
            if (field == null) {
                return 0;
            }
            return ((List) field).size();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int getSerializedSize() {
        int numArrayEntries = this.fields.getNumArrayEntries();
        int i5 = 0;
        for (int i6 = 0; i6 < numArrayEntries; i6++) {
            Map.Entry<T, Object> arrayEntryAt = this.fields.getArrayEntryAt(i6);
            i5 += computeFieldSize((FieldDescriptorLite) arrayEntryAt.getKey(), arrayEntryAt.getValue());
        }
        for (Map.Entry next : this.fields.getOverflowEntries()) {
            i5 += computeFieldSize((FieldDescriptorLite) next.getKey(), next.getValue());
        }
        return i5;
    }

    public boolean hasField(T t5) {
        if (t5.isRepeated()) {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        } else if (this.fields.get(t5) != null) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return this.fields.hashCode();
    }

    /* access modifiers changed from: package-private */
    public boolean isEmpty() {
        return this.fields.isEmpty();
    }

    public boolean isImmutable() {
        return this.isImmutable;
    }

    public boolean isInitialized() {
        int numArrayEntries = this.fields.getNumArrayEntries();
        for (int i5 = 0; i5 < numArrayEntries; i5++) {
            if (!isInitialized(this.fields.getArrayEntryAt(i5))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> isInitialized : this.fields.getOverflowEntries()) {
            if (!isInitialized(isInitialized)) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Map.Entry<T, Object>> iterator() {
        if (isEmpty()) {
            return Collections.emptyIterator();
        }
        if (this.hasLazyField) {
            return new LazyField.LazyIterator(this.fields.entrySet().iterator());
        }
        return this.fields.entrySet().iterator();
    }

    public void makeImmutable() {
        if (!this.isImmutable) {
            int numArrayEntries = this.fields.getNumArrayEntries();
            for (int i5 = 0; i5 < numArrayEntries; i5++) {
                Map.Entry<T, Object> arrayEntryAt = this.fields.getArrayEntryAt(i5);
                if (arrayEntryAt.getValue() instanceof GeneratedMessageLite) {
                    ((GeneratedMessageLite) arrayEntryAt.getValue()).makeImmutable();
                }
            }
            this.fields.makeImmutable();
            this.isImmutable = true;
        }
    }

    public void mergeFrom(FieldSet<T> fieldSet) {
        int numArrayEntries = fieldSet.fields.getNumArrayEntries();
        for (int i5 = 0; i5 < numArrayEntries; i5++) {
            mergeFromField(fieldSet.fields.getArrayEntryAt(i5));
        }
        for (Map.Entry<T, Object> mergeFromField : fieldSet.fields.getOverflowEntries()) {
            mergeFromField(mergeFromField);
        }
    }

    public void setField(T t5, Object obj) {
        if (!t5.isRepeated()) {
            verifyType(t5, obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj2 = arrayList.get(i5);
                i5++;
                verifyType(t5, obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof LazyField) {
            this.hasLazyField = true;
        }
        this.fields.put(t5, obj);
    }

    public void setRepeatedField(T t5, int i5, Object obj) {
        if (t5.isRepeated()) {
            Object field = getField(t5);
            if (field != null) {
                verifyType(t5, obj);
                ((List) field).set(i5, obj);
                return;
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public void writeMessageSetTo(CodedOutputStream codedOutputStream) throws IOException {
        int numArrayEntries = this.fields.getNumArrayEntries();
        for (int i5 = 0; i5 < numArrayEntries; i5++) {
            writeMessageSetTo(this.fields.getArrayEntryAt(i5), codedOutputStream);
        }
        for (Map.Entry<T, Object> writeMessageSetTo : this.fields.getOverflowEntries()) {
            writeMessageSetTo(writeMessageSetTo, codedOutputStream);
        }
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int numArrayEntries = this.fields.getNumArrayEntries();
        for (int i5 = 0; i5 < numArrayEntries; i5++) {
            Map.Entry<T, Object> arrayEntryAt = this.fields.getArrayEntryAt(i5);
            writeField((FieldDescriptorLite) arrayEntryAt.getKey(), arrayEntryAt.getValue(), codedOutputStream);
        }
        for (Map.Entry next : this.fields.getOverflowEntries()) {
            writeField((FieldDescriptorLite) next.getKey(), next.getValue(), codedOutputStream);
        }
    }

    private FieldSet() {
        this.fields = SmallSortedMap.newFieldMap();
    }

    public FieldSet<T> clone() {
        FieldSet<T> newFieldSet = newFieldSet();
        int numArrayEntries = this.fields.getNumArrayEntries();
        for (int i5 = 0; i5 < numArrayEntries; i5++) {
            Map.Entry<T, Object> arrayEntryAt = this.fields.getArrayEntryAt(i5);
            newFieldSet.setField((FieldDescriptorLite) arrayEntryAt.getKey(), arrayEntryAt.getValue());
        }
        for (Map.Entry next : this.fields.getOverflowEntries()) {
            newFieldSet.setField((FieldDescriptorLite) next.getKey(), next.getValue());
        }
        newFieldSet.hasLazyField = this.hasLazyField;
        return newFieldSet;
    }

    private FieldSet(boolean z4) {
        this(SmallSortedMap.newFieldMap());
        makeImmutable();
    }

    private int getMessageSetSerializedSize(Map.Entry<T, Object> entry) {
        FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite) entry.getKey();
        Object value = entry.getValue();
        if (fieldDescriptorLite.getLiteJavaType() != WireFormat.JavaType.MESSAGE || fieldDescriptorLite.isRepeated() || fieldDescriptorLite.isPacked()) {
            return computeFieldSize(fieldDescriptorLite, value);
        }
        if (value instanceof LazyField) {
            return CodedOutputStream.computeLazyFieldMessageSetExtensionSize(((FieldDescriptorLite) entry.getKey()).getNumber(), (LazyField) value);
        }
        return CodedOutputStream.computeMessageSetExtensionSize(((FieldDescriptorLite) entry.getKey()).getNumber(), (MessageLite) value);
    }

    /* access modifiers changed from: private */
    public static <T extends FieldDescriptorLite<T>> boolean isInitialized(Map.Entry<T, Object> entry) {
        FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite) entry.getKey();
        if (fieldDescriptorLite.getLiteJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        if (!fieldDescriptorLite.isRepeated()) {
            return isMessageFieldValueInitialized(entry.getValue());
        }
        List list = (List) entry.getValue();
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (!isMessageFieldValueInitialized(list.get(i5))) {
                return false;
            }
        }
        return true;
    }

    private void writeMessageSetTo(Map.Entry<T, Object> entry, CodedOutputStream codedOutputStream) throws IOException {
        FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite) entry.getKey();
        if (fieldDescriptorLite.getLiteJavaType() != WireFormat.JavaType.MESSAGE || fieldDescriptorLite.isRepeated() || fieldDescriptorLite.isPacked()) {
            writeField(fieldDescriptorLite, entry.getValue(), codedOutputStream);
            return;
        }
        Object value = entry.getValue();
        if (value instanceof LazyField) {
            codedOutputStream.writeRawMessageSetExtension(((FieldDescriptorLite) entry.getKey()).getNumber(), ((LazyField) value).toByteString());
            return;
        }
        codedOutputStream.writeMessageSetExtension(((FieldDescriptorLite) entry.getKey()).getNumber(), (MessageLite) value);
    }

    private FieldSet(SmallSortedMap<T, Object> smallSortedMap) {
        this.fields = smallSortedMap;
        makeImmutable();
    }
}
