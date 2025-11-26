package com.mbridge.msdk.newreward.function.command.receiver.tagreceiver;

import com.mbridge.apt_anotation.ReceiverAction;
import com.mbridge.msdk.newreward.function.command.receiver.b;
import java.util.Map;

@ReceiverAction(id = "DoReceiver", type = b.class)
public class DoReceiver implements b {
    public final void a(Object obj) {
        Map map = (Map) obj;
    }
}
