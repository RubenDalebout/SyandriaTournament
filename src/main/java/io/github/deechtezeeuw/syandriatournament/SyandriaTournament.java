package io.github.deechtezeeuw.syandriatournament;

import io.github.deechtezeeuw.syandriatournament.managers.*;
import io.github.deechtezeeuw.syandriatournament.utils.GUI;
import io.github.deechtezeeuw.syandriatournament.utils.TextColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class SyandriaTournament extends JavaPlugin {
    private static SyandriaTournament instance;
    private ConsoleCommandSender console;

    // Utils
    private TextColor color;

    // Managers
    private TournamentManager tournamentManager;
    private CommandManager commandManager;
    private ConfigurationManager configurationManager;
    private ArenaManager arenaManager;
    private EventManager eventManager;
    private KitsManager kitsManager;

    // GUI
    private GUI gui;

    @Override
    public void onEnable() {
        instance = this;
        console = getServer().getConsoleSender();

        // Utils
        color = new TextColor();

        // Managers
        tournamentManager = new TournamentManager();
        commandManager = new CommandManager();
        commandManager.setup();
        configurationManager = new ConfigurationManager();
        arenaManager = new ArenaManager();
        eventManager = new EventManager();
        kitsManager = new KitsManager();

        // GUI util
        gui = new GUI();

        console.sendMessage(color.color("&7&m----------------------------------------"));
        console.sendMessage(color.color("&9&l" + getDescription().getName() + " &aenabled!"));
        console.sendMessage(color.color("&7Version: &b&l" + getDescription().getVersion()));
        console.sendMessage(color.color("&7&m----------------------------------------"));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        console.sendMessage(color.color("&7&m----------------------------------------"));
        console.sendMessage(color.color("&9&l" + getDescription().getName() + " &cdisabled!"));
        console.sendMessage(color.color("&7Version: &b&l" + getDescription().getVersion()));
        console.sendMessage(color.color("&7&m----------------------------------------"));
    }

    public static SyandriaTournament getInstance() {
        return instance;
    }

    public TextColor getColor() {
        return color;
    }

    public TournamentManager getTournamentManager() {
        return tournamentManager;
    }

    public ConfigurationManager getConfigurationManager() {
        return configurationManager;
    }

    public GUI getGui() {
        return gui;
    }

    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public KitsManager getKitsManager() {
        return kitsManager;
    }

    public ArenaManager getArenaManager() {
        return arenaManager;
    }
}
