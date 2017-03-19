package com.binnerdone.sloth;

import com.binnerdone.sloth.Utils.HelpCommand;
import com.binnerdone.sloth.Utils.InfoCommand;
import com.binnerdone.sloth.Utils.Secret;
import com.binnerdone.sloth.Utils.StatusCommand;
import com.walshydev.jba.JBA;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;

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
        LOGGER.info("Bot Successfully Started");
    }
}
