package com.google.gson.internal;

import com.google.gson.h;
import com.google.gson.internal.bind.TypeAdapters;
import j$.util.Objects;
import j1.c;
import java.io.Writer;

public abstract class E {
    public static void a(h hVar, c cVar) {
        TypeAdapters.f7701V.d(cVar, hVar);
    }

    public static Writer b(Appendable appendable) {
        if (appendable instanceof Writer) {
            return (Writer) appendable;
        }
        return new b(appendable);
    }

    private static final class b extends Writer {

        /* renamed from: a  reason: collision with root package name */
        private final Appendable f7581a;

        /* renamed from: b  reason: collision with root package name */
        private final a f7582b = new a();

        private static class a implements CharSequence {

            /* renamed from: a  reason: collision with root package name */
            private char[] f7583a;

            /* renamed from: b  reason: collision with root package name */
            private String f7584b;

            private a() {
            }

            /* access modifiers changed from: package-private */
            public void a(char[] cArr) {
                this.f7583a = cArr;
                this.f7584b = null;
            }

            public char charAt(int i5) {
                return this.f7583a[i5];
            }

            public int length() {
                return this.f7583a.length;
            }

            public CharSequence subSequence(int i5, int i6) {
                return new String(this.f7583a, i5, i6 - i5);
            }

            public String toString() {
                if (this.f7584b == null) {
                    this.f7584b = new String(this.f7583a);
                }
                return this.f7584b;
            }
        }

        b(Appendable appendable) {
            this.f7581a = appendable;
        }

        public void close() {
        }

        public void flush() {
        }

        public void write(char[] cArr, int i5, int i6) {
            this.f7582b.a(cArr);
            this.f7581a.append(this.f7582b, i5, i6 + i5);
        }

        public Writer append(CharSequence charSequence) {
            this.f7581a.append(charSequence);
            return this;
        }

        public void write(int i5) {
            this.f7581a.append((char) i5);
        }

        public Writer append(CharSequence charSequence, int i5, int i6) {
            this.f7581a.append(charSequence, i5, i6);
            return this;
        }

        public void write(String str, int i5, int i6) {
            Objects.requireNonNull(str);
            this.f7581a.append(str, i5, i6 + i5);
        }
    }
}
