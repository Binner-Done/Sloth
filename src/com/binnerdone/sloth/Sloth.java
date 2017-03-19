package com.binnerdone.sloth;

import com.binnerdone.sloth.Moderation.BanCommand;
import com.binnerdone.sloth.Moderation.KickCommand;
import com.binnerdone.sloth.Utils.*;
import com.walshydev.jba.JBA;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.handle.GuildCreateHandler;

/**
 * Created by Jack on 19/03/2017.
 */
public class Sloth extends JBA {
    public static void main(String[] args){
        new Sloth().init(new JDABuilder(AccountType.BOT)
                        .setToken(Secret.token)
                        .setGame(Game.of("sHelp | Sloth "))
                , "s");
    }

    @Override
    public void run() {
        registerCommand(new StatusCommand());
        registerCommand(new HelpCommand());
        registerCommand(new InfoCommand());
        registerCommand(new PingCommand());
        registerCommand(new KickCommand());
        registerCommand(new BanCommand());
        LOGGER.info("Bot Successfully Started");
    }
}
