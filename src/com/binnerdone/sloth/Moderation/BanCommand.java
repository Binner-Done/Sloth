package com.binnerdone.sloth.Moderation;

import com.walshydev.jba.commands.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.managers.GuildController;

import java.awt.*;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by Jack on 19/03/2017.
 */
public class BanCommand implements Command {
    @Override
    public void onCommand(User user, TextChannel textChannel, Message message, String[] args, Member member) {
        if (member.hasPermission(Permission.BAN_MEMBERS)) {
            try {
                String userBefore = args[0];
                String userAfter = userBefore.replaceAll("[^0-9]", "");
                System.out.println(userAfter);
                GuildController guildController = new GuildController(textChannel.getGuild());
                guildController.ban(userAfter, 0).queue();
                textChannel.sendMessage(new EmbedBuilder()
                        .setAuthor("Sloth", null, textChannel.getJDA().getSelfUser().getEffectiveAvatarUrl())
                        .setDescription("Success! \nBannedd the user: " + args[0])
                        .setImage("https://media.giphy.com/media/CybZqG4etuZsA/giphy.gif")
                        .setColor(Color.GREEN)
                        .build())
                        .queue();
            } catch (Exception e) {
                textChannel.sendMessage(new EmbedBuilder()
                        .setAuthor("Sloth", null, message.getJDA().getSelfUser().getEffectiveAvatarUrl())
                        .setDescription("Error Occoured! \nPlease Try again.")
                        .setColor(Color.RED)
                        .build())
                        .queue();
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw));
                String exceptionAsString = sw.toString();
                message.getJDA().getGuildById("293083088320200705").getTextChannelById("293084774795444225").sendMessage(new EmbedBuilder()
                        .setAuthor(user.getName(), null, user.getEffectiveAvatarUrl())
                        .setDescription("An exception has occurred!: \n" + exceptionAsString)
                        .setColor(Color.red)
                        .build())
                        .queue();
            }
        } else {
            textChannel.sendMessage(new EmbedBuilder()
                    .setAuthor("Sloth", null, textChannel.getJDA().getSelfUser().getEffectiveAvatarUrl())
                    .setDescription("Denied! \nPermission Denied: Lacking Permission `BAN_MEMBERS` ")
                    .setColor(Color.RED)
                    .setImage("https://media.giphy.com/media/l3V0px8dfZmmfwize/giphy.gif")
                    .build())
                    .queue();
        }
    }
    @Override
    public String getCommand() {
        return "ban";
    }

    @Override
    public String getDescription() {
        return "Bans a user";
    }
}
