package org.nandayo.dapi.message;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.nandayo.dapi.ColorizeType;
import org.nandayo.dapi.service.AdventureService;

@SuppressWarnings("unused")
public interface IChannelMessage {
    MiniMessage miniMessage = AdventureService.getMiniMessage();

    Component getMessage();

    IChannelMessage copy();
    IChannelMessage insertPrefix();
    IChannelMessage colorize(ColorizeType colorizeType);
    IChannelMessage replace(String key, String value);
}
