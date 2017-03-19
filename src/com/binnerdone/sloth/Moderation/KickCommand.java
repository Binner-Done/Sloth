package com.binnerdone.sloth.Moderation;

import com.walshydev.jba.commands.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.managers.GuildController;

import java.awt.*;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by Jack on 19/03/2017.
 */
public class KickCommand implements Command {
    @Override
    public void onCommand(User user, TextChannel textChannel, Message message, String[] args, Member member) {
        if(member.hasPermission(Permission.KICK_MEMBERS)){
        try {
            String userBefore = args[0];
            String userAfter = userBefore.replaceAll("[^0-9]", "");
            System.out.println(userAfter);
                GuildController guildController = new GuildController(textChannel.getGuild());
                guildController.kick(userAfter).queue();
                textChannel.sendMessage(new EmbedBuilder()
                        .setAuthor("Sloth", null, textChannel.getJDA().getSelfUser().getEffectiveAvatarUrl())
                        .setDescription("Success! \nKicked the user: " + args[0])
                        .setImage("https://media.giphy.com/media/l3V0j3ytFyGHqiV7W/giphy.gif")
                        .setColor(Color.GREEN)
                        .build())
                        .queue();
            }catch(Exception e){
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
        }else{
            textChannel.sendMessage(new EmbedBuilder()
                    .setAuthor("Sloth", null, textChannel.getJDA().getSelfUser().getEffectiveAvatarUrl())
                    .setDescription("Denied! \nPermission Denied: Lacking Permission `KICK_MEMBERS` ")
                    .setColor(Color.RED)
                    .setImage("https://media.giphy.com/media/l3V0px8dfZmmfwize/giphy.gif")
                    .build())
                    .queue();
        }
    }

    @Override
    public String getCommand() {
        return "kick";
    }

    @Override
    public String getDescription() {
        return "Kicks a user!";
    }
}
