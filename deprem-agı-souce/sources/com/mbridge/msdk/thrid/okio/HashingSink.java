package com.mbridge.msdk.thrid.okio;

import androidx.annotation.Nullable;
import com.mbridge.msdk.foundation.tools.SameMD5;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class HashingSink extends ForwardingSink {
    @Nullable
    private final Mac mac;
    @Nullable
    private final MessageDigest messageDigest;

    private HashingSink(Sink sink, String str) {
        super(sink);
        try {
            this.messageDigest = MessageDigest.getInstance(str);
            this.mac = null;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public static HashingSink hmacSha1(Sink sink, ByteString byteString) {
        return new HashingSink(sink, byteString, "HmacSHA1");
    }

    public static HashingSink hmacSha256(Sink sink, ByteString byteString) {
        return new HashingSink(sink, byteString, "HmacSHA256");
    }

    public static HashingSink hmacSha512(Sink sink, ByteString byteString) {
        return new HashingSink(sink, byteString, "HmacSHA512");
    }

    public static HashingSink md5(Sink sink) {
        return new HashingSink(sink, SameMD5.TAG);
    }

    public static HashingSink sha1(Sink sink) {
        return new HashingSink(sink, "SHA-1");
    }

    public static HashingSink sha256(Sink sink) {
        return new HashingSink(sink, "SHA-256");
    }

    public static HashingSink sha512(Sink sink) {
        return new HashingSink(sink, "SHA-512");
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

    public void write(Buffer buffer, long j5) throws IOException {
        long j6 = j5;
        Util.checkOffsetAndCount(buffer.size, 0, j6);
        Segment segment = buffer.head;
        long j7 = 0;
        while (j7 < j6) {
            int min = (int) Math.min(j6 - j7, (long) (segment.limit - segment.pos));
            MessageDigest messageDigest2 = this.messageDigest;
            if (messageDigest2 != null) {
                messageDigest2.update(segment.data, segment.pos, min);
            } else {
                this.mac.update(segment.data, segment.pos, min);
            }
            j7 += (long) min;
            segment = segment.next;
        }
        super.write(buffer, j6);
    }

    private HashingSink(Sink sink, ByteString byteString, String str) {
        super(sink);
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
