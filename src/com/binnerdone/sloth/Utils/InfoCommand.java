package com.binnerdone.sloth.Utils;

import com.walshydev.jba.commands.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;

import java.awt.*;

/**
 * Created by Jack on 19/03/2017.
 */
public class InfoCommand implements Command {
    @Override
    public void onCommand(User user, TextChannel textChannel, Message message, String[] strings, Member member) {
        JDA jda = message.getJDA();
        textChannel.sendMessage(new EmbedBuilder()
                .setAuthor("Sloth", null, jda.getSelfUser().getEffectiveAvatarUrl())
                .setDescription("Servers: " + jda.getGuilds().size() + "\nUsers: " + jda.getUsers().size() + "\nText Channels: " + jda.getTextChannels().size() + "\nVoice Channels: " + jda.getVoiceChannels().size())
                .setColor(Color.GREEN)
                .build())
                .queue();
    }

    @Override
    public String getCommand() {
        return "info";
    }

    @Override
    public String getDescription() {
        return "Shows information about the bot";
    }
}
