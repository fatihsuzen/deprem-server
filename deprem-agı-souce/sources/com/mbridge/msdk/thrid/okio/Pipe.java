package com.mbridge.msdk.thrid.okio;

import java.io.IOException;

public final class Pipe {
    final Buffer buffer = new Buffer();
    final long maxBufferSize;
    private final Sink sink = new PipeSink();
    boolean sinkClosed;
    private final Source source = new PipeSource();
    boolean sourceClosed;

    final class PipeSink implements Sink {
        final Timeout timeout = new Timeout();

        PipeSink() {
        }

        public void close() throws IOException {
            synchronized (Pipe.this.buffer) {
                try {
                    Pipe pipe = Pipe.this;
                    if (!pipe.sinkClosed) {
                        if (pipe.sourceClosed) {
                            if (pipe.buffer.size() > 0) {
                                throw new IOException("source is closed");
                            }
                        }
                        Pipe pipe2 = Pipe.this;
                        pipe2.sinkClosed = true;
                        pipe2.buffer.notifyAll();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void flush() throws IOException {
            synchronized (Pipe.this.buffer) {
                try {
                    Pipe pipe = Pipe.this;
                    if (pipe.sinkClosed) {
                        throw new IllegalStateException("closed");
                    } else if (pipe.sourceClosed) {
                        if (pipe.buffer.size() > 0) {
                            throw new IOException("source is closed");
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public Timeout timeout() {
            return this.timeout;
        }

        public void write(Buffer buffer, long j5) throws IOException {
            synchronized (Pipe.this.buffer) {
                try {
                    if (!Pipe.this.sinkClosed) {
                        while (j5 > 0) {
                            Pipe pipe = Pipe.this;
                            if (!pipe.sourceClosed) {
                                long size = pipe.maxBufferSize - pipe.buffer.size();
                                if (size == 0) {
                                    this.timeout.waitUntilNotified(Pipe.this.buffer);
                                } else {
                                    long min = Math.min(size, j5);
                                    Pipe.this.buffer.write(buffer, min);
                                    j5 -= min;
                                    Pipe.this.buffer.notifyAll();
                                }
                            } else {
                                throw new IOException("source is closed");
                            }
                        }
                    } else {
                        throw new IllegalStateException("closed");
                    }
                } finally {
                }
            }
        }
    }

    final class PipeSource implements Source {
        final Timeout timeout = new Timeout();

        PipeSource() {
        }

        public void close() throws IOException {
            synchronized (Pipe.this.buffer) {
                Pipe pipe = Pipe.this;
                pipe.sourceClosed = true;
                pipe.buffer.notifyAll();
            }
        }

        public long read(Buffer buffer, long j5) throws IOException {
            synchronized (Pipe.this.buffer) {
                try {
                    if (!Pipe.this.sourceClosed) {
                        while (Pipe.this.buffer.size() == 0) {
                            Pipe pipe = Pipe.this;
                            if (pipe.sinkClosed) {
                                return -1;
                            }
                            this.timeout.waitUntilNotified(pipe.buffer);
                        }
                        long read = Pipe.this.buffer.read(buffer, j5);
                        Pipe.this.buffer.notifyAll();
                        return read;
                    }
                    throw new IllegalStateException("closed");
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public Timeout timeout() {
            return this.timeout;
        }
    }

    public Pipe(long j5) {
        if (j5 >= 1) {
            this.maxBufferSize = j5;
            return;
        }
        throw new IllegalArgumentException("maxBufferSize < 1: " + j5);
    }

    public final Sink sink() {
        return this.sink;
    }

    public final Source source() {
        return this.source;
    }
}
