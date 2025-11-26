package com.google.gson.internal;

import j$.util.Objects;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

public abstract class u {

    /* renamed from: a  reason: collision with root package name */
    static final Type[] f7773a = new Type[0];

    private static final class a implements GenericArrayType, Serializable {

        /* renamed from: a  reason: collision with root package name */
        private final Type f7774a;

        a(Type type) {
            Objects.requireNonNull(type);
            this.f7774a = u.b(type);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof GenericArrayType) || !u.f(this, (GenericArrayType) obj)) {
                return false;
            }
            return true;
        }

        public Type getGenericComponentType() {
            return this.f7774a;
        }

        public int hashCode() {
            return this.f7774a.hashCode();
        }

        public String toString() {
            return u.u(this.f7774a) + "[]";
        }
    }

    private static final class b implements ParameterizedType, Serializable {

        /* renamed from: a  reason: collision with root package name */
        private final Type f7775a;

        /* renamed from: b  reason: collision with root package name */
        private final Type f7776b;

        /* renamed from: c  reason: collision with root package name */
        private final Type[] f7777c;

        b(Type type, Class cls, Type... typeArr) {
            Type type2;
            Objects.requireNonNull(cls);
            if (type != null || !u.o(cls)) {
                if (type == null) {
                    type2 = null;
                } else {
                    type2 = u.b(type);
                }
                this.f7775a = type2;
                this.f7776b = u.b(cls);
                Type[] typeArr2 = (Type[]) typeArr.clone();
                this.f7777c = typeArr2;
                int length = typeArr2.length;
                for (int i5 = 0; i5 < length; i5++) {
                    Objects.requireNonNull(this.f7777c[i5]);
                    u.c(this.f7777c[i5]);
                    Type[] typeArr3 = this.f7777c;
                    typeArr3[i5] = u.b(typeArr3[i5]);
                }
                return;
            }
            throw new IllegalArgumentException("Must specify owner type for " + cls);
        }

        private static int a(Object obj) {
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ParameterizedType) || !u.f(this, (ParameterizedType) obj)) {
                return false;
            }
            return true;
        }

        public Type[] getActualTypeArguments() {
            return (Type[]) this.f7777c.clone();
        }

        public Type getOwnerType() {
            return this.f7775a;
        }

        public Type getRawType() {
            return this.f7776b;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.f7777c) ^ this.f7776b.hashCode()) ^ a(this.f7775a);
        }

        public String toString() {
            int length = this.f7777c.length;
            if (length == 0) {
                return u.u(this.f7776b);
            }
            StringBuilder sb = new StringBuilder((length + 1) * 30);
            sb.append(u.u(this.f7776b));
            sb.append("<");
            sb.append(u.u(this.f7777c[0]));
            for (int i5 = 1; i5 < length; i5++) {
                sb.append(", ");
                sb.append(u.u(this.f7777c[i5]));
            }
            sb.append(">");
            return sb.toString();
        }
    }

    private static final class c implements WildcardType, Serializable {

        /* renamed from: a  reason: collision with root package name */
        private final Type f7778a;

        /* renamed from: b  reason: collision with root package name */
        private final Type f7779b;

        c(Type[] typeArr, Type[] typeArr2) {
            if (typeArr2.length > 1) {
                throw new IllegalArgumentException("At most one lower bound is supported");
            } else if (typeArr.length != 1) {
                throw new IllegalArgumentException("Exactly one upper bound must be specified");
            } else if (typeArr2.length == 1) {
                Objects.requireNonNull(typeArr2[0]);
                u.c(typeArr2[0]);
                Class<Object> cls = Object.class;
                if (typeArr[0] == cls) {
                    this.f7779b = u.b(typeArr2[0]);
                    this.f7778a = cls;
                    return;
                }
                throw new IllegalArgumentException("When lower bound is specified, upper bound must be Object");
            } else {
                Objects.requireNonNull(typeArr[0]);
                u.c(typeArr[0]);
                this.f7779b = null;
                this.f7778a = u.b(typeArr[0]);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof WildcardType) || !u.f(this, (WildcardType) obj)) {
                return false;
            }
            return true;
        }

        public Type[] getLowerBounds() {
            Type type = this.f7779b;
            if (type == null) {
                return u.f7773a;
            }
            return new Type[]{type};
        }

        public Type[] getUpperBounds() {
            return new Type[]{this.f7778a};
        }

        public int hashCode() {
            int i5;
            Type type = this.f7779b;
            if (type != null) {
                i5 = type.hashCode() + 31;
            } else {
                i5 = 1;
            }
            return i5 ^ (this.f7778a.hashCode() + 31);
        }

        public String toString() {
            if (this.f7779b != null) {
                return "? super " + u.u(this.f7779b);
            } else if (this.f7778a == Object.class) {
                return "?";
            } else {
                return "? extends " + u.u(this.f7778a);
            }
        }
    }

    public static GenericArrayType a(Type type) {
        return new a(type);
    }

    public static Type b(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                return new a(b(cls.getComponentType()));
            }
            return cls;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new b(parameterizedType.getOwnerType(), (Class) parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        } else if (type instanceof GenericArrayType) {
            return new a(((GenericArrayType) type).getGenericComponentType());
        } else {
            if (!(type instanceof WildcardType)) {
                return type;
            }
            WildcardType wildcardType = (WildcardType) type;
            return new c(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
        }
    }

    static void c(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException("Primitive type is not allowed");
        }
    }

    private static Class d(TypeVariable typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    private static boolean e(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public static boolean f(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            if (!e(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) || !parameterizedType.getRawType().equals(parameterizedType2.getRawType()) || !Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments())) {
                return false;
            }
            return true;
        } else if (type instanceof GenericArrayType) {
            if (!(type2 instanceof GenericArrayType)) {
                return false;
            }
            return f(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
        } else if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            if (!Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) || !Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds())) {
                return false;
            }
            return true;
        } else if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        } else {
            TypeVariable typeVariable = (TypeVariable) type;
            TypeVariable typeVariable2 = (TypeVariable) type2;
            if (!Objects.equals(typeVariable.getGenericDeclaration(), typeVariable2.getGenericDeclaration()) || !typeVariable.getName().equals(typeVariable2.getName())) {
                return false;
            }
            return true;
        }
    }

    public static Type g(Type type) {
        if (type instanceof GenericArrayType) {
            return ((GenericArrayType) type).getGenericComponentType();
        }
        return ((Class) type).getComponentType();
    }

    public static Type h(Type type, Class cls) {
        Type l5 = l(type, cls, Collection.class);
        if (l5 instanceof ParameterizedType) {
            return ((ParameterizedType) l5).getActualTypeArguments()[0];
        }
        return Object.class;
    }

    private static Type i(Type type, Class<? super Object> cls, Class cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i5 = 0; i5 < length; i5++) {
                Class cls3 = interfaces[i5];
                if (cls3 == cls2) {
                    return cls.getGenericInterfaces()[i5];
                }
                if (cls2.isAssignableFrom(cls3)) {
                    return i(cls.getGenericInterfaces()[i5], interfaces[i5], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return i(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    public static Type[] j(Type type, Class cls) {
        if (Properties.class.isAssignableFrom(cls)) {
            Class<String> cls2 = String.class;
            return new Type[]{cls2, cls2};
        }
        Type l5 = l(type, cls, Map.class);
        if (l5 instanceof ParameterizedType) {
            return ((ParameterizedType) l5).getActualTypeArguments();
        }
        Class<Object> cls3 = Object.class;
        return new Type[]{cls3, cls3};
    }

    public static Class k(Type type) {
        String str;
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return (Class) ((ParameterizedType) type).getRawType();
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(k(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return k(((WildcardType) type).getUpperBounds()[0]);
        }
        if (type == null) {
            str = "null";
        } else {
            str = type.getClass().getName();
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + str);
    }

    private static Type l(Type type, Class cls, Class cls2) {
        if (type instanceof WildcardType) {
            type = ((WildcardType) type).getUpperBounds()[0];
        }
        if (cls2.isAssignableFrom(cls)) {
            return p(type, cls, i(type, cls, cls2));
        }
        throw new IllegalArgumentException(cls + " is not the same as or a subtype of " + cls2);
    }

    private static int m(Object[] objArr, Object obj) {
        int length = objArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (obj.equals(objArr[i5])) {
                return i5;
            }
        }
        throw new NoSuchElementException();
    }

    public static ParameterizedType n(Type type, Class cls, Type... typeArr) {
        return new b(type, cls, typeArr);
    }

    public static boolean o(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (Modifier.isStatic(cls.getModifiers()) || cls.getDeclaringClass() == null) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static Type p(Type type, Class cls, Type type2) {
        return q(type, cls, type2, new HashMap());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.reflect.Type[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v9, resolved type: java.lang.Class} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v14, resolved type: java.lang.reflect.WildcardType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v15, resolved type: java.lang.reflect.WildcardType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v16, resolved type: java.lang.reflect.WildcardType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v17, resolved type: java.lang.reflect.WildcardType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v18, resolved type: java.lang.reflect.WildcardType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v19, resolved type: java.lang.reflect.ParameterizedType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v20, resolved type: java.lang.reflect.GenericArrayType} */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a0, code lost:
        if (r5 != false) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a2, code lost:
        r10 = n(r4, (java.lang.Class) r12.getRawType(), r7);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.reflect.Type q(java.lang.reflect.Type r10, java.lang.Class r11, java.lang.reflect.Type r12, java.util.Map r13) {
        /*
            r0 = 0
        L_0x0001:
            boolean r1 = r12 instanceof java.lang.reflect.TypeVariable
            if (r1 == 0) goto L_0x0024
            r1 = r12
            java.lang.reflect.TypeVariable r1 = (java.lang.reflect.TypeVariable) r1
            java.lang.Object r2 = r13.get(r1)
            java.lang.reflect.Type r2 = (java.lang.reflect.Type) r2
            java.lang.Class r3 = java.lang.Void.TYPE
            if (r2 == 0) goto L_0x0016
            if (r2 != r3) goto L_0x0015
            return r12
        L_0x0015:
            return r2
        L_0x0016:
            r13.put(r1, r3)
            if (r0 != 0) goto L_0x001c
            r0 = r1
        L_0x001c:
            java.lang.reflect.Type r12 = r(r10, r11, r1)
            if (r12 != r1) goto L_0x0001
            goto L_0x00e1
        L_0x0024:
            boolean r1 = r12 instanceof java.lang.Class
            if (r1 == 0) goto L_0x0049
            r1 = r12
            java.lang.Class r1 = (java.lang.Class) r1
            boolean r2 = r1.isArray()
            if (r2 == 0) goto L_0x0049
            java.lang.Class r12 = r1.getComponentType()
            java.lang.reflect.Type r10 = q(r10, r11, r12, r13)
            boolean r11 = e(r12, r10)
            if (r11 == 0) goto L_0x0042
            r12 = r1
            goto L_0x00e1
        L_0x0042:
            java.lang.reflect.GenericArrayType r10 = a(r10)
        L_0x0046:
            r12 = r10
            goto L_0x00e1
        L_0x0049:
            boolean r1 = r12 instanceof java.lang.reflect.GenericArrayType
            if (r1 == 0) goto L_0x0064
            java.lang.reflect.GenericArrayType r12 = (java.lang.reflect.GenericArrayType) r12
            java.lang.reflect.Type r1 = r12.getGenericComponentType()
            java.lang.reflect.Type r10 = q(r10, r11, r1, r13)
            boolean r11 = e(r1, r10)
            if (r11 == 0) goto L_0x005f
            goto L_0x00e1
        L_0x005f:
            java.lang.reflect.GenericArrayType r10 = a(r10)
            goto L_0x0046
        L_0x0064:
            boolean r1 = r12 instanceof java.lang.reflect.ParameterizedType
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x00ad
            java.lang.reflect.ParameterizedType r12 = (java.lang.reflect.ParameterizedType) r12
            java.lang.reflect.Type r1 = r12.getOwnerType()
            java.lang.reflect.Type r4 = q(r10, r11, r1, r13)
            boolean r1 = e(r4, r1)
            java.lang.reflect.Type[] r5 = r12.getActualTypeArguments()
            int r6 = r5.length
            r7 = r5
            r5 = r3
        L_0x007f:
            if (r3 >= r6) goto L_0x009e
            r8 = r7[r3]
            java.lang.reflect.Type r8 = q(r10, r11, r8, r13)
            r9 = r7[r3]
            boolean r9 = e(r8, r9)
            if (r9 != 0) goto L_0x009b
            if (r5 != 0) goto L_0x0099
            java.lang.Object r5 = r7.clone()
            r7 = r5
            java.lang.reflect.Type[] r7 = (java.lang.reflect.Type[]) r7
            r5 = r2
        L_0x0099:
            r7[r3] = r8
        L_0x009b:
            int r3 = r3 + 1
            goto L_0x007f
        L_0x009e:
            if (r1 == 0) goto L_0x00a2
            if (r5 == 0) goto L_0x00e1
        L_0x00a2:
            java.lang.reflect.Type r10 = r12.getRawType()
            java.lang.Class r10 = (java.lang.Class) r10
            java.lang.reflect.ParameterizedType r10 = n(r4, r10, r7)
            goto L_0x0046
        L_0x00ad:
            boolean r1 = r12 instanceof java.lang.reflect.WildcardType
            if (r1 == 0) goto L_0x00e1
            java.lang.reflect.WildcardType r12 = (java.lang.reflect.WildcardType) r12
            java.lang.reflect.Type[] r1 = r12.getLowerBounds()
            java.lang.reflect.Type[] r4 = r12.getUpperBounds()
            int r5 = r1.length
            if (r5 != r2) goto L_0x00cd
            r2 = r1[r3]
            java.lang.reflect.Type r10 = q(r10, r11, r2, r13)
            r11 = r1[r3]
            if (r10 == r11) goto L_0x00e1
            java.lang.reflect.WildcardType r12 = t(r10)
            goto L_0x00e1
        L_0x00cd:
            int r1 = r4.length
            if (r1 != r2) goto L_0x00e1
            r1 = r4[r3]
            java.lang.reflect.Type r10 = q(r10, r11, r1, r13)     // Catch:{ all -> 0x00df }
            r11 = r4[r3]
            if (r10 == r11) goto L_0x00e1
            java.lang.reflect.WildcardType r12 = s(r10)
            goto L_0x00e1
        L_0x00df:
            r10 = move-exception
            throw r10
        L_0x00e1:
            if (r0 == 0) goto L_0x00e6
            r13.put(r0, r12)
        L_0x00e6:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.u.q(java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type, java.util.Map):java.lang.reflect.Type");
    }

    private static Type r(Type type, Class cls, TypeVariable typeVariable) {
        Class d5 = d(typeVariable);
        if (d5 != null) {
            Type i5 = i(type, cls, d5);
            if (i5 instanceof ParameterizedType) {
                return ((ParameterizedType) i5).getActualTypeArguments()[m(d5.getTypeParameters(), typeVariable)];
            }
        }
        return typeVariable;
    }

    public static WildcardType s(Type type) {
        Type[] typeArr;
        if (type instanceof WildcardType) {
            typeArr = ((WildcardType) type).getUpperBounds();
        } else {
            typeArr = new Type[]{type};
        }
        return new c(typeArr, f7773a);
    }

    public static WildcardType t(Type type) {
        Type[] typeArr;
        if (type instanceof WildcardType) {
            typeArr = ((WildcardType) type).getLowerBounds();
        } else {
            typeArr = new Type[]{type};
        }
        return new c(new Type[]{Object.class}, typeArr);
    }

    public static String u(Type type) {
        if (type instanceof Class) {
            return ((Class) type).getName();
        }
        return type.toString();
    }
}
