/*
 Copyright (C) 2021 MCUmbrella & contributors
 Licensed under the MIT License. See LICENSE in the project root for license information.
*/

package vip.floatationdevice.guilded4j.object;

import cn.hutool.json.JSONConfig;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import vip.floatationdevice.guilded4j.Util;

/**
 * A summary of a list item.
 * <a href="https://www.guilded.gg/docs/api/listItems/ListItemSummary" target=_blank>https://www.guilded.gg/docs/api/listItems/ListItemSummary</a>
 */
public class ListItemSummary
{
    private String
            id, serverId, channelId, message, createdAt, createdBy, createdByWebhookId,
            updatedAt, updatedBy, parentListItemId, completedAt, completedBy;
    private ListItemNote note;

    /**
     * Get the UUID of this list item.
     */
    public String getId(){return id;}

    /**
     * Get the UUID of the server this list item is in.
     */
    public String getChannelId(){return channelId;}

    /**
     * Get the message of the list item.
     */
    public String getMessage(){return message;}

    /**
     * Get the note of this list item.
     * @return The note's ListItemNote object (with no content).
     */
    public ListItemNote getNote(){return note;}

    /**
     * Get the time this list item was created.
     * @return The ISO 8601 timestamp that the list item was created at.
     */
    public String getCreationTime(){return createdAt;}

    /**
     * Get the ID of the user who created this list item.
     * @return The ID of the user who created this list item.<br>
     * <b>NOTE:</b><br>
     * If this event has createdByWebhookId present, this field will still be populated, but can be ignored.<br>
     * In this case, the value of this field will always be 'Ann6LewA'.
     */
    public String getCreatorId(){return createdBy;}

    /**
     * Get the ID of the webhook that created this list item.
     * @return The ID of the webhook who created this list item. If this list item was not created by a webhook, return {@code null}.
     */
    public String getWebhookCreatorId(){return createdByWebhookId;}

    /**
     * Get the time this list item was last updated.
     * @return The ISO 8601 timestamp that the list item was last updated at. If this list item has never been updated, return {@code null}.
     */
    public String getUpdateTime(){return updatedAt;}

    /**
     * Get the ID of the user who updated this list item.
     * @return The ID of the user who updated this list item. If this list item has never been updated, return {@code null}.
     */
    public String getUpdaterId(){return updatedBy;}

    /**
     * Get the ID of the parent list item.
     * @return The ID of the parent list item if this list item is nested, otherwise {@code null}.
     */
    public String getParentListItemId(){return parentListItemId;}

    /**
     * Get the time this list item was completed.
     * @return The ISO 8601 timestamp that the list item was completed at. If this list item is not completed, return {@code null}.
     */
    public String getCompletionTime(){return completedAt;}

    /**
     * Get the ID of the user who completed this list item.
     * @return The ID of the user who completed this list item. If this list item is not completed, return {@code null}.
     */
    public String getCompleterId(){return completedBy;}

    public ListItemSummary setId(String id)
    {
        this.id = id;
        return this;
    }

    public ListItemSummary setServerId(String serverId)
    {
        this.serverId = serverId;
        return this;
    }

    public ListItemSummary setChannelId(String channelId)
    {
        this.channelId = channelId;
        return this;
    }

    public ListItemSummary setMessage(String message)
    {
        this.message = message;
        return this;
    }

    public ListItemSummary setNote(ListItemNote note)
    {
        this.note = note;
        return this;
    }

    public ListItemSummary setCreationTime(String createdAt)
    {
        this.createdAt = createdAt;
        return this;
    }

    public ListItemSummary setCreatorId(String createdBy)
    {
        this.createdBy = createdBy;
        return this;
    }

    public ListItemSummary setWebhookCreatorId(String createdByWebhookId)
    {
        this.createdByWebhookId = createdByWebhookId;
        return this;
    }

    public ListItemSummary setUpdateTime(String updatedAt)
    {
        this.updatedAt = updatedAt;
        return this;
    }

    public ListItemSummary setUpdaterId(String updatedBy)
    {
        this.updatedBy = updatedBy;
        return this;
    }

    public ListItemSummary setParentListItemId(String parentListItemId)
    {
        this.parentListItemId = parentListItemId;
        return this;
    }

    public ListItemSummary setCompletionTime(String completedAt)
    {
        this.completedAt = completedAt;
        return this;
    }

    public ListItemSummary setCompleterId(String completedBy)
    {
        this.completedBy = completedBy;
        return this;
    }

    /**
     * Use the given JSON string to generate ListItemSummary object.
     * @param rawString The JSON string.
     * @return ListItemSummary object.
     * @throws IllegalArgumentException when the essential fields are not set.
     * @throws ClassCastException when the provided String's content isn't JSON format.
     */
    public static ListItemSummary fromString(String rawString)
    {
        if(JSONUtil.isTypeJSON(rawString))
        {
            JSONObject json = new JSONObject(rawString);
            Util.checkNullArgument(
                    json.getStr("id"),
                    json.getStr("serverId"),
                    json.getStr("channelId"),
                    json.getStr("message"),
                    json.getStr("createdAt"),
                    json.getStr("createdBy")
            );
            return new ListItemSummary()
                    .setId(json.getStr("id"))
                    .setServerId(json.getStr("serverId"))
                    .setChannelId(json.getStr("channelId"))
                    .setMessage(json.getStr("message"))
                    .setNote(new ListItemNote(
                            json.getByPath("note.createdAt").toString(),
                            json.getByPath("note.createdBy").toString(),
                            json.getByPath("note.content").toString()
                    ))
                    .setCreationTime(json.getStr("createdAt"))
                    .setCreatorId(json.getStr("createdBy"))
                    .setWebhookCreatorId(json.getStr("createdByWebhookId"))
                    .setUpdateTime(json.getStr("updatedAt"))
                    .setUpdaterId(json.getStr("updatedBy"))
                    .setParentListItemId(json.getStr("parentListItemId"))
                    .setCompletionTime(json.getStr("completedAt"))
                    .setCompleterId(json.getStr("completedBy"));
        }
        else throw new ClassCastException("The provided String's content can't be converted to JSON object");
    }

    /**
     * Convert the ListItemSummary object to JSON string.
     * @return A JSON string.
     */
    @Override public String toString()
    {
        return new JSONObject(new JSONConfig().setIgnoreNullValue(true))
                .set("id", id)
                .set("serverId", serverId)
                .set("channelId", channelId)
                .set("message", message)
                .set("note", new JSONObject(note.toString()))
                .set("createdAt", createdAt)
                .set("createdBy", createdBy)
                .set("createdByWebhookId", createdByWebhookId)
                .set("updatedAt", updatedAt)
                .set("updatedBy", updatedBy)
                .set("parentListItemId", parentListItemId)
                .set("completedAt", completedAt)
                .set("completedBy", completedBy)
                .toString();
    }
}
