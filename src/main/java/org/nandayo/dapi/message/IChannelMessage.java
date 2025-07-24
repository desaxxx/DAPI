package org.nandayo.dapi.message;

import net.kyori.adventure.text.Component;
import org.nandayo.dapi.util.ColorizeType;

@SuppressWarnings("unused")
public interface IChannelMessage {

    String getRawMessage();
    Component getMessage();

    IChannelMessage copy();
    IChannelMessage insertPrefix();
    IChannelMessage colorize(ColorizeType colorizeType);
    IChannelMessage replace(String key, String value);
}
