package org.nandayo.dapi.message;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.nandayo.dapi.util.ColorizeType;
import org.nandayo.dapi.DAPI;

@SuppressWarnings("unused")
public interface IChannelMessage {
    MiniMessage miniMessage = DAPI.getMiniMessage();

    String getRawMessage();
    Component getMessage();

    IChannelMessage copy();
    IChannelMessage insertPrefix();
    IChannelMessage colorize(ColorizeType colorizeType);
    IChannelMessage replace(String key, String value);
}
