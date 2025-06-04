package org.nandayo.dapi.message;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
@SuppressWarnings("unused")
public class ChannelMessage {

    private final @NotNull String primaryMessage;
    private String secondaryMessage = "";
    private int fadeInTicks = 10;
    private int stayTicks = 70;
    private int fadeOutTicks = 20;

    public ChannelMessage(@NotNull String primaryMessage) {
        this.primaryMessage = primaryMessage;
    }

    public ChannelMessage(@NotNull String primaryMessage, @NotNull String secondaryMessage, int fadeInTicks, int stayTicks, int fadeOutTicks) {
        this.primaryMessage = primaryMessage;
        this.secondaryMessage = secondaryMessage;
        this.fadeInTicks = fadeInTicks;
        this.stayTicks = stayTicks;
        this.fadeOutTicks = fadeOutTicks;
    }



    static public class Builder {

        private final @NotNull String message;
        private String secondaryMessage = "";
        private int fadeInTicks = 10;
        private int stayTicks = 70;
        private int fadeOutTicks = 20;

        public Builder(@NotNull String message) {
            this.message = message;
        }

        static public Builder of(@NotNull String message) {
            return new Builder(message);
        }

        public Builder secondaryMessage(@NotNull String secondaryMessage) {
            this.secondaryMessage = secondaryMessage;
            return this;
        }

        public Builder durations(int fadeInTicks, int stayTicks, int fadeOutTicks) {
            this.fadeInTicks = fadeInTicks;
            this.stayTicks = stayTicks;
            this.fadeOutTicks = fadeOutTicks;
            return this;
        }

        public ChannelMessage build() {
            return new ChannelMessage(message, secondaryMessage, fadeInTicks, stayTicks, fadeOutTicks);
        }
    }
}
