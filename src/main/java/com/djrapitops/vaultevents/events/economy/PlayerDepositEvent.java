package com.djrapitops.vaultevents.events.economy;

import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.Optional;

/**
 * Event that is fired when Economy#depositPlayer(OfflinePlayer, double) is called.
 *
 * @author Rsl1122
 */
public class PlayerDepositEvent extends Event {

    private final OfflinePlayer player;
    private final double amount;
    private final String world;
    private final EconomyResponse response;

    public PlayerDepositEvent(OfflinePlayer player, double amount, EconomyResponse response) {
        this(player, amount, null, response);
    }

    public PlayerDepositEvent(OfflinePlayer player, double amount, String world, EconomyResponse response) {
        super(!Bukkit.isPrimaryThread());
        this.player = player;
        this.amount = amount;
        this.world = world;
        this.response = response;
    }

    public OfflinePlayer getOfflinePlayer() {
        return player;
    }

    public double getAmount() {
        return amount;
    }

    public EconomyResponse getResponse() {
        return response;
    }

    public Optional<String> getWorldName() {
        return Optional.ofNullable(world);
    }

    private static final HandlerList HANDLERS = new HandlerList();

    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}