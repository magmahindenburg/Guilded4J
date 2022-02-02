/*
 Copyright (C) 2021 MCUmbrella & contributors
 Licensed under the MIT License. See LICENSE in the project root for license information.
*/

package vip.floatationdevice.guilded4j.object;

import cn.hutool.json.JSONConfig;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import vip.floatationdevice.guilded4j.Util;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * The basic forum thread object in a 'forum' type channel.<br>
 * <a href="https://www.guilded.gg/docs/api/forums/ForumThread" target=_blank>https://www.guilded.gg/docs/api/forums/ForumThread</a>
 */
public class ForumThread
{
    int id;
    String serverId, channelId, title, content, createdAt, createdBy, createdByBotId, createdByWebhookId;

    /**
     * Get the thread's ID (it is not UUID).
     */
    public int getId(){return id;}

    /**
     * Get the ID of the server to which the thread belongs.
     */
    public String getServerId(){return serverId;}

    /**
     * Get the UUID of the channel to which the thread belongs.
     */
    @Nullable public String getChannelId(){return channelId;}

    /**
     * Get the title of the thread.
     */
    @Nullable public String getTitle(){return title;}//TODO: get an accurate answer on whether its optional or not

    /**
     * Get the content of the thread.
     */
    @Nullable public String getContent(){return content;}//TODO: get an accurate answer on whether its optional or not

    /**
     * Get the ISO 8601 timestamp string that the forum thread was created at.
     */
    public String getCreationTime(){return createdAt;}

    /**
     * The ID of the user who created this forum thread.
     */
    public String getCreatorId(){return createdBy;}

    /**
     * Broken because of the bot object migration.
     * @return Always null.
     */
    @Deprecated public String getBotCreatorId(){return createdByBotId;}

    /**
     * Get the ID of the webhook who created this forum thread.
     * @return A UUID string of the webhook who created the thread. If the creator isn't webhook, return {@code null}.
     */
    @Nullable public String getWebhookCreatorId(){return createdByWebhookId;}

    public ForumThread setId(int id){this.id=id;return this;}
    public ForumThread setServerId(String serverId){this.serverId=serverId;return this;}
    public ForumThread setChannelId(String channelId){this.channelId=channelId;return this;}
    public ForumThread setTitle(String title){this.title=title;return this;}
    public ForumThread setContent(String content){this.content=content;return this;}
    public ForumThread setCreationTime(@Nonnull String createdAt){this.createdAt=createdAt;return this;}
    public ForumThread setCreatorId(@Nonnull String createdBy){this.createdBy=createdBy;return this;}
    public ForumThread setBotCreatorId(String createdByBotId){this.createdByBotId=createdByBotId;return this;}
    public ForumThread setWebhookCreatorId(String createdByWebhookId){this.createdByWebhookId=createdByWebhookId;return this;}

    /**
     * Generate empty ForumThread object - make sure to set all the essential fields before using it.
     */
    public ForumThread(){}

    /**
     * Generate ForumThread object from JSON string.
     * @param jsonString The JSON string.
     */
    public ForumThread(String jsonString) {fromString(jsonString);}

    /**
     * Use the given JSON string to generate ForumThread object.
     * @param rawString The JSON string.
     * @return ForumThread object.
     * @throws IllegalArgumentException when the essential fields are not set.
     * @throws ClassCastException when the provided String's content isn't JSON format.
     */
    @Nullable public ForumThread fromString(String rawString)
    {
        if(JSONUtil.isJson(rawString))
        {
            JSONObject json=new JSONObject(rawString);
            Util.checkNullArgument(
                    json.getStr("id"),
                    json.getStr("serverId"),
                    json.getStr("channelId"),
                    json.getStr("createdAt"),
                    json.getStr("createdBy")
            );
            return this.setId(json.getInt("id"))
                    .setServerId(json.getStr("serverId"))
                    .setChannelId(json.getStr("channelId"))
                    .setTitle(json.getStr("title"))
                    .setContent(json.getStr("content"))
                    .setCreationTime(json.getStr("createdAt"))
                    .setCreatorId(json.getStr("createdBy"))
                    .setBotCreatorId(json.getStr("createdByBotId"))
                    .setWebhookCreatorId(json.getStr("createdByWebhookId"));
        }
        else throw new ClassCastException("The provided String's content can't be converted to JSON object");
    }

    /**
     * Convert the ForumThread object to JSON string.
     * @return A JSON string.
     */
    @Override
    public String toString()
    {
        return new JSONObject(new JSONConfig().setIgnoreNullValue(true))
                .set("id",id)
                .set("serverId",serverId)
                .set("channelId",channelId)
                .set("title",title)
                .set("content",content)
                .set("createdAt",createdAt)
                .set("createdBy",createdBy)
                .set("createdByBotId",createdByBotId)
                .set("createdByWebhookId",createdByWebhookId)
                .toString();
    }
}
