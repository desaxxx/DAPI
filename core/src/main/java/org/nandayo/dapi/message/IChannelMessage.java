package org.nandayo.dapi.message;

import org.nandayo.dapi.util.ColorizeType;

@SuppressWarnings("unused")
public interface IChannelMessage {

    String getRawMessage();
    Object getMessage();

    IChannelMessage copy();
    IChannelMessage insertPrefix();
    IChannelMessage colorize(ColorizeType colorizeType);
    IChannelMessage replace(String key, String value);
}
