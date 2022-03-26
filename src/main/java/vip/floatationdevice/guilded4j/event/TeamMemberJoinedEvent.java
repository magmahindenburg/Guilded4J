/*
 Copyright (C) 2021 MCUmbrella & contributors
 Licensed under the MIT License. See LICENSE in the project root for license information.
*/

package vip.floatationdevice.guilded4j.event;

import vip.floatationdevice.guilded4j.object.TeamMember;

/**
 * Event that is fired when a user joins a server.<br>
 * <a href="https://www.guilded.gg/docs/api/websockets/TeamMemberJoined", target=_blank>https://www.guilded.gg/docs/api/websockets/TeamMemberJoined</a>
 */
public class TeamMemberJoinedEvent extends GuildedEvent
{
    private final TeamMember member;

    /**
     * Generate TeamMemberJoinedEvent with given TeamMember object.
     */
    public TeamMemberJoinedEvent(Object source, TeamMember member)
    {
        super(source);
        this.member = member;
    }

    /**
     * Get the member that joined the server.
     * @return The member's TeamMember object.
     */
    public TeamMember getMember(){return member;}
}