package com.binnerdone.sloth.Utils;

import com.walshydev.jba.commands.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

/**
 * Created by TehKi on 3/19/2017.
 */
public class PingCommand implements Command {

    @Override
    public void onCommand(User user, TextChannel textChannel, Message message, String[] strings, Member member) {
        long ping = message.getCreationTime().until(LocalDateTime.now().atOffset(ZoneOffset.UTC), ChronoUnit.MILLIS);
        textChannel.sendMessage(new EmbedBuilder()
                .setAuthor("Sloth", null, textChannel.getJDA().getSelfUser().getEffectiveAvatarUrl())
                .setDescription("Sloth Bot \nThe ping of the bot is " + "`" + ping + "`" + " ms")
                .setColor(Color.YELLOW)
                .setThumbnail(textChannel.getJDA().getSelfUser().getEffectiveAvatarUrl())
                .build())
                .queue();
        message.delete().queue();
    }

    @Override
    public String getCommand() {
        return "ping";
    }

    @Override
    public String getDescription() {
        return "Shows connection";
    }

}