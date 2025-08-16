package org.nandayo.dapi.message;

import org.nandayo.dapi.service.AdventureProvider;
import org.nandayo.dapi.util.ColorizeType;

@SuppressWarnings("unused")
public interface IChannelMessage {

    String getRawMessage();
    AdventureProvider.ComponentProvider getMessage();

    IChannelMessage copy();
    IChannelMessage insertPrefix();
    IChannelMessage colorize(ColorizeType colorizeType);
    IChannelMessage replace(String key, String value);
}
