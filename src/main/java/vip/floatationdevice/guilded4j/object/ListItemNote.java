/*
 Copyright (C) 2021 MCUmbrella & contributors
 Licensed under the MIT License. See LICENSE in the project root for license information.
*/

package vip.floatationdevice.guilded4j.object;

/**
 * This class represents a note in a ListItem object.
 * This class is not present in the official API.
 */
public class ListItemNote
{
    private final String createdAt, createdBy;
    private String content;

    public ListItemNote(String createdAt, String createdBy, String content)
    {
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.content = content;
    }

    public String getCreationTime(){return createdAt;}

    public String getCreator(){return createdBy;}

    /**
     * Get the displayable content of the note.
     * @return The note's text.
     */
    public String getContent(){return content;}

    public ListItemNote setContent(String content)
    {
        this.content = content;
        return this;
    }
}