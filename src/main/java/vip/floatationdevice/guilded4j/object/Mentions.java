/*
 Copyright (C) 2021-2023 MCUmbrella & contributors
 Licensed under the MIT License. See LICENSE in the project root for license information.
*/

package vip.floatationdevice.guilded4j.object;

/**
 * Metadata of who or what is mentioned in content.<br>
 * <a href="https://www.guilded.gg/docs/api/channels/Mentions" target=_blank>https://www.guilded.gg/docs/api/channels/Mentions</a>
 */
public class Mentions //TODO: implement when guilded.gg changes their design
{
    // the Mentions model is shitty made and should be changed. im not going to implement this atm

    Channel[] channels;
    boolean everyone;
    boolean here;

    public boolean isEveryone() {
        return everyone;
    }

    public void setEveryone(boolean everyone) {
        this.everyone = everyone;
    }

    public boolean isHere() {
        return here;
    }

    public void setHere(boolean here) {
        this.here = here;
    }

    public void setChannel(String id) {
        channels = new Channel[1];
        channels[0] = new Channel(id);
    }

    public void setChannels(String[] ids) {
        channels = new Channel[ids.length];
        int i=0;
        for (String id : ids) {
            channels[i] = new Channel(id);
            i++;
        }

    }

    private class Channel {
        private String id;

        public Channel(String id) {
            this.id = id;
        }
    }
}
