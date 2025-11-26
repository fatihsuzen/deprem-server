package com.mbridge.msdk.thrid.okhttp;

import java.net.Socket;

public interface Connection {
    Handshake handshake();

    Protocol protocol();

    Route route();

    Socket socket();
}
