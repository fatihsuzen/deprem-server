package com.mbridge.msdk.thrid.okhttp.internal.ws;

import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.BufferedSource;
import com.mbridge.msdk.thrid.okio.ByteString;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

final class WebSocketReader {
    boolean closed;
    private final Buffer controlFrameBuffer = new Buffer();
    final FrameCallback frameCallback;
    long frameLength;
    final boolean isClient;
    boolean isControlFrame;
    boolean isFinalFrame;
    private final Buffer.UnsafeCursor maskCursor;
    private final byte[] maskKey;
    private final Buffer messageFrameBuffer = new Buffer();
    int opcode;
    final BufferedSource source;

    public interface FrameCallback {
        void onReadClose(int i5, String str);

        void onReadMessage(ByteString byteString) throws IOException;

        void onReadMessage(String str) throws IOException;

        void onReadPing(ByteString byteString);

        void onReadPong(ByteString byteString);
    }

    WebSocketReader(boolean z4, BufferedSource bufferedSource, FrameCallback frameCallback2) {
        byte[] bArr;
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        } else if (frameCallback2 != null) {
            this.isClient = z4;
            this.source = bufferedSource;
            this.frameCallback = frameCallback2;
            Buffer.UnsafeCursor unsafeCursor = null;
            if (z4) {
                bArr = null;
            } else {
                bArr = new byte[4];
            }
            this.maskKey = bArr;
            this.maskCursor = !z4 ? new Buffer.UnsafeCursor() : unsafeCursor;
        } else {
            throw new NullPointerException("frameCallback == null");
        }
    }

    private void readControlFrame() throws IOException {
        String str;
        short s5;
        long j5 = this.frameLength;
        if (j5 > 0) {
            this.source.readFully(this.controlFrameBuffer, j5);
            if (!this.isClient) {
                this.controlFrameBuffer.readAndWriteUnsafe(this.maskCursor);
                this.maskCursor.seek(0);
                WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        switch (this.opcode) {
            case 8:
                long size = this.controlFrameBuffer.size();
                if (size != 1) {
                    if (size != 0) {
                        s5 = this.controlFrameBuffer.readShort();
                        str = this.controlFrameBuffer.readUtf8();
                        String closeCodeExceptionMessage = WebSocketProtocol.closeCodeExceptionMessage(s5);
                        if (closeCodeExceptionMessage != null) {
                            throw new ProtocolException(closeCodeExceptionMessage);
                        }
                    } else {
                        s5 = 1005;
                        str = "";
                    }
                    this.frameCallback.onReadClose(s5, str);
                    this.closed = true;
                    return;
                }
                throw new ProtocolException("Malformed close payload length of 1.");
            case 9:
                this.frameCallback.onReadPing(this.controlFrameBuffer.readByteString());
                return;
            case 10:
                this.frameCallback.onReadPong(this.controlFrameBuffer.readByteString());
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.opcode));
        }
    }

    /* JADX INFO: finally extract failed */
    private void readHeader() throws IOException {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        String str;
        if (!this.closed) {
            long timeoutNanos = this.source.timeout().timeoutNanos();
            this.source.timeout().clearTimeout();
            try {
                byte readByte = this.source.readByte();
                this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                this.opcode = readByte & 15;
                boolean z9 = false;
                if ((readByte & 128) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                this.isFinalFrame = z4;
                if ((readByte & 8) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                this.isControlFrame = z5;
                if (!z5 || z4) {
                    if ((readByte & 64) != 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if ((readByte & 32) != 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if ((readByte & 16) != 0) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (z6 || z7 || z8) {
                        throw new ProtocolException("Reserved flags are unsupported.");
                    }
                    byte readByte2 = this.source.readByte();
                    if ((readByte2 & 128) != 0) {
                        z9 = true;
                    }
                    if (z9 == this.isClient) {
                        if (this.isClient) {
                            str = "Server-sent frames must not be masked.";
                        } else {
                            str = "Client-sent frames must be masked.";
                        }
                        throw new ProtocolException(str);
                    }
                    long j5 = (long) (readByte2 & Byte.MAX_VALUE);
                    this.frameLength = j5;
                    if (j5 == 126) {
                        this.frameLength = ((long) this.source.readShort()) & 65535;
                    } else if (j5 == 127) {
                        long readLong = this.source.readLong();
                        this.frameLength = readLong;
                        if (readLong < 0) {
                            throw new ProtocolException("Frame length 0x" + Long.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
                        }
                    }
                    if (this.isControlFrame && this.frameLength > 125) {
                        throw new ProtocolException("Control frame must be less than 125B.");
                    } else if (z9) {
                        this.source.readFully(this.maskKey);
                    }
                } else {
                    throw new ProtocolException("Control frames must be final.");
                }
            } catch (Throwable th) {
                this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                throw th;
            }
        } else {
            throw new IOException("closed");
        }
    }

    private void readMessage() throws IOException {
        while (!this.closed) {
            long j5 = this.frameLength;
            if (j5 > 0) {
                this.source.readFully(this.messageFrameBuffer, j5);
                if (!this.isClient) {
                    this.messageFrameBuffer.readAndWriteUnsafe(this.maskCursor);
                    this.maskCursor.seek(this.messageFrameBuffer.size() - this.frameLength);
                    WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            }
            if (!this.isFinalFrame) {
                readUntilNonControlFrame();
                if (this.opcode != 0) {
                    throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.opcode));
                }
            } else {
                return;
            }
        }
        throw new IOException("closed");
    }

    private void readMessageFrame() throws IOException {
        int i5 = this.opcode;
        if (i5 == 1 || i5 == 2) {
            readMessage();
            if (i5 == 1) {
                this.frameCallback.onReadMessage(this.messageFrameBuffer.readUtf8());
            } else {
                this.frameCallback.onReadMessage(this.messageFrameBuffer.readByteString());
            }
        } else {
            throw new ProtocolException("Unknown opcode: " + Integer.toHexString(i5));
        }
    }

    private void readUntilNonControlFrame() throws IOException {
        while (!this.closed) {
            readHeader();
            if (this.isControlFrame) {
                readControlFrame();
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void processNextFrame() throws IOException {
        readHeader();
        if (this.isControlFrame) {
            readControlFrame();
        } else {
            readMessageFrame();
        }
    }
}
