package com.binnerdone.sloth.Utils;

import com.walshydev.jba.commands.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;

import java.awt.*;

/**
 * Created by Jack on 19/03/2017.
 */
public class HelpCommand implements Command {
    @Override
    public void onCommand(User user, TextChannel textChannel, Message message, String[] strings, Member member) {
        textChannel.sendMessage(new EmbedBuilder()
        .setAuthor("Sloth", null, textChannel.getJDA().getSelfUser().getEffectiveAvatarUrl())
                .setDescription("Sloth Bot \n`sHelp` - Displays this Help Message")
                .setColor(Color.GREEN)
                .setThumbnail(textChannel.getJDA().getSelfUser().getEffectiveAvatarUrl())
                .build())
                .queue();
        message.delete().queue();
    }

    @Override
    public String getCommand() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Shows help";
    }
}
