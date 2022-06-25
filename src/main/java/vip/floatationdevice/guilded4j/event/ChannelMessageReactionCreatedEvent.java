/*
 Copyright (C) 2021-2022 MCUmbrella & contributors
 Licensed under the MIT License. See LICENSE in the project root for license information.
*/

package vip.floatationdevice.guilded4j.event;

/**
 * Not implemented yet.<br>
 * <a href="https://www.guilded.gg/docs/api/websockets/ChannelMessageReactionCreated", target=_blank>https://www.guilded.gg/docs/api/websockets/ChannelMessageReactionCreated</a>
 */
public class ChannelMessageReactionCreatedEvent extends GuildedEvent // TODO: wait
{
    /*
    This event currently doesn't return a ContentReaction but returns another undocumented object instead.
    According to the chat history, this is a bug in the API and will be fixed in the future.

    The current ChannelMessageReactionCreatedEvent data structure is:
    d:
      serverId: "xxxxxxxx"
      reaction:
        channelId: "00000000-0000-0000-0000-000000000000
        messageId: "00000000-0000-0000-0000-000000000000
        createdBy: "xxxxxxxx"
        emote:
          id: 0
          name: ":thumbsup:"
          url: "https://www.example.com/emotes/thumbsup.png"

    What we possibly want to return is:
    d:
      serverId: "xxxxxxxx"
      messageId: "00000000-0000-0000-0000-000000000000
      contentReaction:
        id: 0
        serverId: "xxxxxxxx"
        createdAt: "2020-01-01T00:00:00.000Z"
        createdBy: "xxxxxxxx"
     */
    public ChannelMessageReactionCreatedEvent(Object source, String json)
    {
        super(source, json);
    }
}
