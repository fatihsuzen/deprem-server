package androidx.datastore.preferences.protobuf;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

final class MessageLiteToString {
    private static final String BUILDER_LIST_SUFFIX = "OrBuilderList";
    private static final String BYTES_SUFFIX = "Bytes";
    private static final char[] INDENT_BUFFER;
    private static final String LIST_SUFFIX = "List";
    private static final String MAP_SUFFIX = "Map";

    static {
        char[] cArr = new char[80];
        INDENT_BUFFER = cArr;
        Arrays.fill(cArr, ' ');
    }

    private MessageLiteToString() {
    }

    private static void indent(int i5, StringBuilder sb) {
        int i6;
        while (i5 > 0) {
            char[] cArr = INDENT_BUFFER;
            if (i5 > cArr.length) {
                i6 = cArr.length;
            } else {
                i6 = i5;
            }
            sb.append(cArr, 0, i6);
            i5 -= i6;
        }
    }

    private static boolean isDefaultValue(Object obj) {
        if (obj instanceof Boolean) {
            return !((Boolean) obj).booleanValue();
        }
        if (obj instanceof Integer) {
            if (((Integer) obj).intValue() == 0) {
                return true;
            }
            return false;
        } else if (obj instanceof Float) {
            if (Float.floatToRawIntBits(((Float) obj).floatValue()) == 0) {
                return true;
            }
            return false;
        } else if (obj instanceof Double) {
            if (Double.doubleToRawLongBits(((Double) obj).doubleValue()) == 0) {
                return true;
            }
            return false;
        } else if (obj instanceof String) {
            return obj.equals("");
        } else {
            if (obj instanceof ByteString) {
                return obj.equals(ByteString.EMPTY);
            }
            if (obj instanceof MessageLite) {
                if (obj == ((MessageLite) obj).getDefaultInstanceForType()) {
                    return true;
                }
                return false;
            } else if (!(obj instanceof Enum) || ((Enum) obj).ordinal() != 0) {
                return false;
            } else {
                return true;
            }
        }
    }

    private static String pascalCaseToSnakeCase(String str) {
        if (str.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toLowerCase(str.charAt(0)));
        for (int i5 = 1; i5 < str.length(); i5++) {
            char charAt = str.charAt(i5);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    static void printField(StringBuilder sb, int i5, String str, Object obj) {
        if (obj instanceof List) {
            for (Object printField : (List) obj) {
                printField(sb, i5, str, printField);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry printField2 : ((Map) obj).entrySet()) {
                printField(sb, i5, str, printField2);
            }
        } else {
            sb.append(10);
            indent(i5, sb);
            sb.append(pascalCaseToSnakeCase(str));
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(TextFormatEscaper.escapeText((String) obj));
                sb.append('\"');
            } else if (obj instanceof ByteString) {
                sb.append(": \"");
                sb.append(TextFormatEscaper.escapeBytes((ByteString) obj));
                sb.append('\"');
            } else if (obj instanceof GeneratedMessageLite) {
                sb.append(" {");
                reflectivePrintWithIndent((GeneratedMessageLite) obj, sb, i5 + 2);
                sb.append("\n");
                indent(i5, sb);
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                int i6 = i5 + 2;
                printField(sb, i6, "key", entry.getKey());
                printField(sb, i6, "value", entry.getValue());
                sb.append("\n");
                indent(i5, sb);
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0136  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void reflectivePrintWithIndent(androidx.datastore.preferences.protobuf.MessageLite r17, java.lang.StringBuilder r18, int r19) {
        /*
            r0 = r17
            r1 = r18
            r2 = r19
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.util.TreeMap r5 = new java.util.TreeMap
            r5.<init>()
            java.lang.Class r6 = r0.getClass()
            java.lang.reflect.Method[] r6 = r6.getDeclaredMethods()
            int r7 = r6.length
            r8 = 0
            r9 = r8
        L_0x0020:
            java.lang.String r10 = "get"
            java.lang.String r11 = "has"
            java.lang.String r12 = "set"
            r13 = 3
            if (r9 >= r7) goto L_0x008c
            r14 = r6[r9]
            int r15 = r14.getModifiers()
            boolean r15 = java.lang.reflect.Modifier.isStatic(r15)
            if (r15 == 0) goto L_0x0036
            goto L_0x0089
        L_0x0036:
            java.lang.String r15 = r14.getName()
            int r15 = r15.length()
            if (r15 >= r13) goto L_0x0041
            goto L_0x0089
        L_0x0041:
            java.lang.String r13 = r14.getName()
            boolean r12 = r13.startsWith(r12)
            if (r12 == 0) goto L_0x0053
            java.lang.String r10 = r14.getName()
            r3.add(r10)
            goto L_0x0089
        L_0x0053:
            int r12 = r14.getModifiers()
            boolean r12 = java.lang.reflect.Modifier.isPublic(r12)
            if (r12 != 0) goto L_0x005e
            goto L_0x0089
        L_0x005e:
            java.lang.Class[] r12 = r14.getParameterTypes()
            int r12 = r12.length
            if (r12 == 0) goto L_0x0066
            goto L_0x0089
        L_0x0066:
            java.lang.String r12 = r14.getName()
            boolean r11 = r12.startsWith(r11)
            if (r11 == 0) goto L_0x0078
            java.lang.String r10 = r14.getName()
            r4.put(r10, r14)
            goto L_0x0089
        L_0x0078:
            java.lang.String r11 = r14.getName()
            boolean r10 = r11.startsWith(r10)
            if (r10 == 0) goto L_0x0089
            java.lang.String r10 = r14.getName()
            r5.put(r10, r14)
        L_0x0089:
            int r9 = r9 + 1
            goto L_0x0020
        L_0x008c:
            java.util.Set r6 = r5.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x0094:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x01b6
            java.lang.Object r7 = r6.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r9 = r7.getKey()
            java.lang.String r9 = (java.lang.String) r9
            java.lang.String r9 = r9.substring(r13)
            java.lang.String r14 = "List"
            boolean r15 = r9.endsWith(r14)
            if (r15 == 0) goto L_0x00ec
            java.lang.String r15 = "OrBuilderList"
            boolean r15 = r9.endsWith(r15)
            if (r15 != 0) goto L_0x00ec
            boolean r14 = r9.equals(r14)
            if (r14 != 0) goto L_0x00ec
            java.lang.Object r14 = r7.getValue()
            java.lang.reflect.Method r14 = (java.lang.reflect.Method) r14
            if (r14 == 0) goto L_0x00ec
            java.lang.Class r15 = r14.getReturnType()
            r16 = r13
            java.lang.Class<java.util.List> r13 = java.util.List.class
            boolean r13 = r15.equals(r13)
            if (r13 == 0) goto L_0x00ee
            int r7 = r9.length()
            int r7 = r7 + -4
            java.lang.String r7 = r9.substring(r8, r7)
            java.lang.Object[] r9 = new java.lang.Object[r8]
            java.lang.Object r9 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.invokeOrDie(r14, r0, r9)
            printField(r1, r2, r7, r9)
        L_0x00e9:
            r13 = r16
            goto L_0x0094
        L_0x00ec:
            r16 = r13
        L_0x00ee:
            java.lang.String r13 = "Map"
            boolean r14 = r9.endsWith(r13)
            if (r14 == 0) goto L_0x0136
            boolean r13 = r9.equals(r13)
            if (r13 != 0) goto L_0x0136
            java.lang.Object r13 = r7.getValue()
            java.lang.reflect.Method r13 = (java.lang.reflect.Method) r13
            if (r13 == 0) goto L_0x0136
            java.lang.Class r14 = r13.getReturnType()
            java.lang.Class<java.util.Map> r15 = java.util.Map.class
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x0136
            java.lang.Class<java.lang.Deprecated> r14 = java.lang.Deprecated.class
            boolean r14 = r13.isAnnotationPresent(r14)
            if (r14 != 0) goto L_0x0136
            int r14 = r13.getModifiers()
            boolean r14 = java.lang.reflect.Modifier.isPublic(r14)
            if (r14 == 0) goto L_0x0136
            int r7 = r9.length()
            int r7 = r7 + -3
            java.lang.String r7 = r9.substring(r8, r7)
            java.lang.Object[] r9 = new java.lang.Object[r8]
            java.lang.Object r9 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.invokeOrDie(r13, r0, r9)
            printField(r1, r2, r7, r9)
            goto L_0x00e9
        L_0x0136:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r12)
            r13.append(r9)
            java.lang.String r13 = r13.toString()
            boolean r13 = r3.contains(r13)
            if (r13 != 0) goto L_0x014c
        L_0x014b:
            goto L_0x00e9
        L_0x014c:
            java.lang.String r13 = "Bytes"
            boolean r13 = r9.endsWith(r13)
            if (r13 == 0) goto L_0x0174
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r10)
            int r14 = r9.length()
            int r14 = r14 + -5
            java.lang.String r14 = r9.substring(r8, r14)
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            boolean r13 = r5.containsKey(r13)
            if (r13 == 0) goto L_0x0174
            goto L_0x014b
        L_0x0174:
            java.lang.Object r7 = r7.getValue()
            java.lang.reflect.Method r7 = (java.lang.reflect.Method) r7
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r11)
            r13.append(r9)
            java.lang.String r13 = r13.toString()
            java.lang.Object r13 = r4.get(r13)
            java.lang.reflect.Method r13 = (java.lang.reflect.Method) r13
            if (r7 == 0) goto L_0x00e9
            java.lang.Object[] r14 = new java.lang.Object[r8]
            java.lang.Object r7 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.invokeOrDie(r7, r0, r14)
            if (r13 != 0) goto L_0x01a3
            boolean r13 = isDefaultValue(r7)
            if (r13 != 0) goto L_0x01a1
            r13 = 1
            goto L_0x01af
        L_0x01a1:
            r13 = r8
            goto L_0x01af
        L_0x01a3:
            java.lang.Object[] r14 = new java.lang.Object[r8]
            java.lang.Object r13 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.invokeOrDie(r13, r0, r14)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
        L_0x01af:
            if (r13 == 0) goto L_0x00e9
            printField(r1, r2, r9, r7)
            goto L_0x00e9
        L_0x01b6:
            boolean r3 = r0 instanceof androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtendableMessage
            if (r3 == 0) goto L_0x01f7
            r3 = r0
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtendableMessage r3 = (androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtendableMessage) r3
            androidx.datastore.preferences.protobuf.FieldSet<androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor> r3 = r3.extensions
            java.util.Iterator r3 = r3.iterator()
        L_0x01c3:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x01f7
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "["
            r5.append(r6)
            java.lang.Object r6 = r4.getKey()
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r6 = (androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtensionDescriptor) r6
            int r6 = r6.getNumber()
            r5.append(r6)
            java.lang.String r6 = "]"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.Object r4 = r4.getValue()
            printField(r1, r2, r5, r4)
            goto L_0x01c3
        L_0x01f7:
            androidx.datastore.preferences.protobuf.GeneratedMessageLite r0 = (androidx.datastore.preferences.protobuf.GeneratedMessageLite) r0
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r0 = r0.unknownFields
            if (r0 == 0) goto L_0x0200
            r0.printWithIndent(r1, r2)
        L_0x0200:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageLiteToString.reflectivePrintWithIndent(androidx.datastore.preferences.protobuf.MessageLite, java.lang.StringBuilder, int):void");
    }

    static String toString(MessageLite messageLite, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        reflectivePrintWithIndent(messageLite, sb, 0);
        return sb.toString();
    }
}
