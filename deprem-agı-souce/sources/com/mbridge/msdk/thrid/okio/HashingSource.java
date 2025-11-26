package com.mbridge.msdk.thrid.okio;

import com.mbridge.msdk.foundation.tools.SameMD5;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class HashingSource extends ForwardingSource {
    private final Mac mac;
    private final MessageDigest messageDigest;

    private HashingSource(Source source, String str) {
        super(source);
        try {
            this.messageDigest = MessageDigest.getInstance(str);
            this.mac = null;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public static HashingSource hmacSha1(Source source, ByteString byteString) {
        return new HashingSource(source, byteString, "HmacSHA1");
    }

    public static HashingSource hmacSha256(Source source, ByteString byteString) {
        return new HashingSource(source, byteString, "HmacSHA256");
    }

    public static HashingSource md5(Source source) {
        return new HashingSource(source, SameMD5.TAG);
    }

    public static HashingSource sha1(Source source) {
        return new HashingSource(source, "SHA-1");
    }

    public static HashingSource sha256(Source source) {
        return new HashingSource(source, "SHA-256");
    }

    public final ByteString hash() {
        byte[] bArr;
        MessageDigest messageDigest2 = this.messageDigest;
        if (messageDigest2 != null) {
            bArr = messageDigest2.digest();
        } else {
            bArr = this.mac.doFinal();
        }
        return ByteString.of(bArr);
    }

    public long read(Buffer buffer, long j5) throws IOException {
        long read = super.read(buffer, j5);
        if (read != -1) {
            long j6 = buffer.size;
            long j7 = j6 - read;
            Segment segment = buffer.head;
            while (j6 > j7) {
                segment = segment.prev;
                j6 -= (long) (segment.limit - segment.pos);
            }
            while (j6 < buffer.size) {
                int i5 = (int) ((((long) segment.pos) + j7) - j6);
                MessageDigest messageDigest2 = this.messageDigest;
                if (messageDigest2 != null) {
                    messageDigest2.update(segment.data, i5, segment.limit - i5);
                } else {
                    this.mac.update(segment.data, i5, segment.limit - i5);
                }
                j7 = ((long) (segment.limit - segment.pos)) + j6;
                segment = segment.next;
                j6 = j7;
            }
        }
        return read;
    }

    private HashingSource(Source source, ByteString byteString, String str) {
        super(source);
        try {
            Mac instance = Mac.getInstance(str);
            this.mac = instance;
            instance.init(new SecretKeySpec(byteString.toByteArray(), str));
            this.messageDigest = null;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        } catch (InvalidKeyException e5) {
            throw new IllegalArgumentException(e5);
        }
    }
}
