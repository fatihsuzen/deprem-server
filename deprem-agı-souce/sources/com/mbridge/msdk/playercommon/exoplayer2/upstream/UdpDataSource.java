package com.mbridge.msdk.playercommon.exoplayer2.upstream;

import android.net.Uri;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

public final class UdpDataSource implements DataSource {
    public static final int DEAFULT_SOCKET_TIMEOUT_MILLIS = 8000;
    public static final int DEFAULT_MAX_PACKET_SIZE = 2000;
    private InetAddress address;
    private final TransferListener<? super UdpDataSource> listener;
    private MulticastSocket multicastSocket;
    private boolean opened;
    private final DatagramPacket packet;
    private final byte[] packetBuffer;
    private int packetRemaining;
    private DatagramSocket socket;
    private InetSocketAddress socketAddress;
    private final int socketTimeoutMillis;
    private Uri uri;

    public static final class UdpDataSourceException extends IOException {
        public UdpDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public UdpDataSource(TransferListener<? super UdpDataSource> transferListener) {
        this(transferListener, 2000);
    }

    public final void close() {
        this.uri = null;
        MulticastSocket multicastSocket2 = this.multicastSocket;
        if (multicastSocket2 != null) {
            try {
                multicastSocket2.leaveGroup(this.address);
            } catch (IOException unused) {
            }
            this.multicastSocket = null;
        }
        DatagramSocket datagramSocket = this.socket;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.socket = null;
        }
        this.address = null;
        this.socketAddress = null;
        this.packetRemaining = 0;
        if (this.opened) {
            this.opened = false;
            TransferListener<? super UdpDataSource> transferListener = this.listener;
            if (transferListener != null) {
                transferListener.onTransferEnd(this);
            }
        }
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final long open(DataSpec dataSpec) throws UdpDataSourceException {
        Uri uri2 = dataSpec.uri;
        this.uri = uri2;
        String host = uri2.getHost();
        int port = this.uri.getPort();
        try {
            this.address = InetAddress.getByName(host);
            this.socketAddress = new InetSocketAddress(this.address, port);
            if (this.address.isMulticastAddress()) {
                MulticastSocket multicastSocket2 = new MulticastSocket(this.socketAddress);
                this.multicastSocket = multicastSocket2;
                multicastSocket2.joinGroup(this.address);
                this.socket = this.multicastSocket;
            } else {
                this.socket = new DatagramSocket(this.socketAddress);
            }
            try {
                this.socket.setSoTimeout(this.socketTimeoutMillis);
                this.opened = true;
                TransferListener<? super UdpDataSource> transferListener = this.listener;
                if (transferListener == null) {
                    return -1;
                }
                transferListener.onTransferStart(this, dataSpec);
                return -1;
            } catch (SocketException e5) {
                throw new UdpDataSourceException(e5);
            }
        } catch (IOException e6) {
            throw new UdpDataSourceException(e6);
        }
    }

    public final int read(byte[] bArr, int i5, int i6) throws UdpDataSourceException {
        if (i6 == 0) {
            return 0;
        }
        if (this.packetRemaining == 0) {
            try {
                this.socket.receive(this.packet);
                int length = this.packet.getLength();
                this.packetRemaining = length;
                TransferListener<? super UdpDataSource> transferListener = this.listener;
                if (transferListener != null) {
                    transferListener.onBytesTransferred(this, length);
                }
            } catch (IOException e5) {
                throw new UdpDataSourceException(e5);
            }
        }
        int length2 = this.packet.getLength();
        int i7 = this.packetRemaining;
        int min = Math.min(i7, i6);
        System.arraycopy(this.packetBuffer, length2 - i7, bArr, i5, min);
        this.packetRemaining -= min;
        return min;
    }

    public UdpDataSource(TransferListener<? super UdpDataSource> transferListener, int i5) {
        this(transferListener, i5, 8000);
    }

    public UdpDataSource(TransferListener<? super UdpDataSource> transferListener, int i5, int i6) {
        this.listener = transferListener;
        this.socketTimeoutMillis = i6;
        byte[] bArr = new byte[i5];
        this.packetBuffer = bArr;
        this.packet = new DatagramPacket(bArr, 0, i5);
    }
}
