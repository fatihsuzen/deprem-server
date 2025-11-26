package com.mbridge.msdk.thrid.okio;

import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Okio {
    static final Logger logger = Logger.getLogger(Okio.class.getName());

    private Okio() {
    }

    public static Sink appendingSink(File file) throws FileNotFoundException {
        if (file != null) {
            return sink((OutputStream) new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink blackhole() {
        return new Sink() {
            public void close() throws IOException {
            }

            public void flush() throws IOException {
            }

            public Timeout timeout() {
                return Timeout.NONE;
            }

            public void write(Buffer buffer, long j5) throws IOException {
                buffer.skip(j5);
            }
        };
    }

    public static BufferedSource buffer(Source source) {
        return new RealBufferedSource(source);
    }

    static boolean isAndroidGetsocknameError(AssertionError assertionError) {
        if (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) {
            return false;
        }
        return true;
    }

    public static Sink sink(OutputStream outputStream) {
        return sink(outputStream, new Timeout());
    }

    public static Source source(InputStream inputStream) {
        return source(inputStream, new Timeout());
    }

    private static AsyncTimeout timeout(final Socket socket) {
        return new AsyncTimeout() {
            /* access modifiers changed from: protected */
            public IOException newTimeoutException(@Nullable IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            /* access modifiers changed from: protected */
            public void timedOut() {
                try {
                    socket.close();
                } catch (Exception e5) {
                    Logger logger = Okio.logger;
                    Level level = Level.WARNING;
                    logger.log(level, "Failed to close timed out socket " + socket, e5);
                } catch (AssertionError e6) {
                    if (Okio.isAndroidGetsocknameError(e6)) {
                        Logger logger2 = Okio.logger;
                        Level level2 = Level.WARNING;
                        logger2.log(level2, "Failed to close timed out socket " + socket, e6);
                        return;
                    }
                    throw e6;
                }
            }
        };
    }

    public static BufferedSink buffer(Sink sink) {
        return new RealBufferedSink(sink);
    }

    private static Sink sink(final OutputStream outputStream, final Timeout timeout) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (timeout != null) {
            return new Sink() {
                public void close() throws IOException {
                    outputStream.close();
                }

                public void flush() throws IOException {
                    outputStream.flush();
                }

                public Timeout timeout() {
                    return timeout;
                }

                public String toString() {
                    return "sink(" + outputStream + ")";
                }

                public void write(Buffer buffer, long j5) throws IOException {
                    Util.checkOffsetAndCount(buffer.size, 0, j5);
                    while (j5 > 0) {
                        timeout.throwIfReached();
                        Segment segment = buffer.head;
                        int min = (int) Math.min(j5, (long) (segment.limit - segment.pos));
                        outputStream.write(segment.data, segment.pos, min);
                        int i5 = segment.pos + min;
                        segment.pos = i5;
                        long j6 = (long) min;
                        j5 -= j6;
                        buffer.size -= j6;
                        if (i5 == segment.limit) {
                            buffer.head = segment.pop();
                            SegmentPool.recycle(segment);
                        }
                    }
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    private static Source source(final InputStream inputStream, final Timeout timeout) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (timeout != null) {
            return new Source() {
                public void close() throws IOException {
                    inputStream.close();
                }

                public long read(Buffer buffer, long j5) throws IOException {
                    int i5 = (j5 > 0 ? 1 : (j5 == 0 ? 0 : -1));
                    if (i5 < 0) {
                        throw new IllegalArgumentException("byteCount < 0: " + j5);
                    } else if (i5 == 0) {
                        return 0;
                    } else {
                        try {
                            timeout.throwIfReached();
                            Segment writableSegment = buffer.writableSegment(1);
                            int read = inputStream.read(writableSegment.data, writableSegment.limit, (int) Math.min(j5, (long) (8192 - writableSegment.limit)));
                            if (read == -1) {
                                return -1;
                            }
                            writableSegment.limit += read;
                            long j6 = (long) read;
                            buffer.size += j6;
                            return j6;
                        } catch (AssertionError e5) {
                            if (Okio.isAndroidGetsocknameError(e5)) {
                                throw new IOException(e5);
                            }
                            throw e5;
                        }
                    }
                }

                public Timeout timeout() {
                    return timeout;
                }

                public String toString() {
                    return "source(" + inputStream + ")";
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static Sink sink(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getOutputStream() != null) {
            AsyncTimeout timeout = timeout(socket);
            return timeout.sink(sink(socket.getOutputStream(), (Timeout) timeout));
        } else {
            throw new IOException("socket's output stream == null");
        }
    }

    public static Source source(File file) throws FileNotFoundException {
        if (file != null) {
            return source((InputStream) new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Source source(Path path, OpenOption... openOptionArr) throws IOException {
        if (path != null) {
            return source(Files.newInputStream(path, openOptionArr));
        }
        throw new IllegalArgumentException("path == null");
    }

    public static Source source(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getInputStream() != null) {
            AsyncTimeout timeout = timeout(socket);
            return timeout.source(source(socket.getInputStream(), (Timeout) timeout));
        } else {
            throw new IOException("socket's input stream == null");
        }
    }

    public static Sink sink(File file) throws FileNotFoundException {
        if (file != null) {
            return sink((OutputStream) new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink sink(Path path, OpenOption... openOptionArr) throws IOException {
        if (path != null) {
            return sink(Files.newOutputStream(path, openOptionArr));
        }
        throw new IllegalArgumentException("path == null");
    }
}
