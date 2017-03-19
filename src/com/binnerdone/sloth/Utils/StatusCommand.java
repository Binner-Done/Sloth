package com.binnerdone.sloth.Utils;

import com.walshydev.jba.commands.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.*;

import java.awt.*;

/**
 * Created by Jack on 19/03/2017.
 */
public class StatusCommand implements Command {
    @Override
    public void onCommand(User user, TextChannel textChannel, Message message, String[] args, Member member) {
        if(user.getId().equals("189110605074923521") | user.getId().equals("210982207601246208")){
            if(args[0].equals("issues")) {
                textChannel.sendMessage(new EmbedBuilder()
                        .setAuthor(user.getName(), null, user.getEffectiveAvatarUrl())
                        .setDescription("Successfully set the status!")
                        .setColor(Color.green)
                        .build())
                        .queue();
                message.getJDA().getPresence().setGame(Game.of("Experiancing Issues | sHelp | Sloth "));
                message.getJDA().getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);
            }else if(args[0].equals("online")){
                textChannel.sendMessage(new EmbedBuilder()
                        .setAuthor(user.getName(), null, user.getEffectiveAvatarUrl())
                        .setDescription("Successfully set the status!")
                        .setColor(Color.green)
                        .build())
                        .queue();
                message.getJDA().getPresence().setGame(Game.of("sHelp | Sloth "));
                message.getJDA().getPresence().setStatus(OnlineStatus.ONLINE);
            }

        }
        message.delete().queue();
    }

    @Override
    public String getCommand() {
        return "status";
    }

    @Override
    public String getDescription() {
        return "Changes the status of the bot";
    }
}
