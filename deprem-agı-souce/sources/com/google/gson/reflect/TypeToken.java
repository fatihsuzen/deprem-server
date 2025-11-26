package com.google.gson.reflect;

import com.google.gson.internal.F;
import com.google.gson.internal.u;
import j$.util.Objects;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

public class TypeToken<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Class f7824a;

    /* renamed from: b  reason: collision with root package name */
    private final Type f7825b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7826c;

    protected TypeToken() {
        Type e5 = e();
        this.f7825b = e5;
        this.f7824a = u.k(e5);
        this.f7826c = e5.hashCode();
    }

    public static TypeToken a(Class cls) {
        return new TypeToken(cls);
    }

    public static TypeToken b(Type type) {
        return new TypeToken(type);
    }

    private Type e() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Class<TypeToken> cls = TypeToken.class;
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            if (parameterizedType.getRawType() == cls) {
                Type b5 = u.b(parameterizedType.getActualTypeArguments()[0]);
                if (f()) {
                    g(b5);
                }
                return b5;
            }
        } else if (genericSuperclass == cls) {
            throw new IllegalStateException("TypeToken must be created with a type argument: new TypeToken<...>() {}; When using code shrinkers (ProGuard, R8, ...) make sure that generic signatures are preserved.\nSee " + F.a("type-token-raw"));
        }
        throw new IllegalStateException("Must only create direct subclasses of TypeToken");
    }

    private static boolean f() {
        return !Objects.equals(System.getProperty("gson.allowCapturingTypeVariables"), "true");
    }

    private static void g(Type type) {
        if (type instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type;
            throw new IllegalArgumentException("TypeToken type argument must not contain a type variable; captured type variable " + typeVariable.getName() + " declared by " + typeVariable.getGenericDeclaration() + "\nSee " + F.a("typetoken-type-variable"));
        } else if (type instanceof GenericArrayType) {
            g(((GenericArrayType) type).getGenericComponentType());
        } else {
            int i5 = 0;
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type ownerType = parameterizedType.getOwnerType();
                if (ownerType != null) {
                    g(ownerType);
                }
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                int length = actualTypeArguments.length;
                while (i5 < length) {
                    g(actualTypeArguments[i5]);
                    i5++;
                }
            } else if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                for (Type g5 : wildcardType.getLowerBounds()) {
                    g(g5);
                }
                Type[] upperBounds = wildcardType.getUpperBounds();
                int length2 = upperBounds.length;
                while (i5 < length2) {
                    g(upperBounds[i5]);
                    i5++;
                }
            } else if (type == null) {
                throw new IllegalArgumentException("TypeToken captured `null` as type argument; probably a compiler / runtime bug");
            }
        }
    }

    public final Class c() {
        return this.f7824a;
    }

    public final Type d() {
        return this.f7825b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof TypeToken) || !u.f(this.f7825b, ((TypeToken) obj).f7825b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f7826c;
    }

    public final String toString() {
        return u.u(this.f7825b);
    }

    private TypeToken(Type type) {
        Objects.requireNonNull(type);
        Type b5 = u.b(type);
        this.f7825b = b5;
        this.f7824a = u.k(b5);
        this.f7826c = b5.hashCode();
    }
}
