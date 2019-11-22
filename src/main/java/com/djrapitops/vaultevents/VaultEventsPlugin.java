package com.djrapitops.vaultevents;

import com.djrapitops.vaultevents.events.VaultEventsAvailableEvent;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Optional;
import java.util.logging.Logger;

/**
 * JavaPlugin that wraps the original Economy implementation to send events.
 *
 * @author Rsl1122
 */
public class VaultEventsPlugin extends JavaPlugin {

    private boolean eventsAvailable = false;

    @Override
    public void onEnable() {
        Logger logger = getLogger();

        PluginManager plugins = getServer().getPluginManager();
        if (!plugins.isPluginEnabled("Vault")) {
            logger.warning("Vault is required for Vault Events -> Plugin Disabled.");
            return;
        }

        Optional<Economy> economy = getEconomy();
        if (economy.isPresent()) {
            registerWrapper(economy.get());
        } else {
            tryAgainOnStart();
        }
    }

    public boolean areEventsAvailable() {
        return eventsAvailable;
    }

    public boolean supportsEconomyEvents() {
        return true;
    }

    public boolean supportsPermissionEvents() {
        return false; // Vault Permission based events are not supported at the moment. PR if you'd like to add them.
    }

    public boolean supportsChatEvents() {
        return false; // Vault Chat based events are not supported at the moment. PR if you'd like to add them.
    }

    private void tryAgainOnStart() {
        getServer().getScheduler().runTaskLater(this,
                () -> getEconomy().ifPresent(this::registerWrapper),
                0); // Run when server has done loading
    }

    private Optional<Economy> getEconomy() {
        ServicesManager services = getServer().getServicesManager();
        RegisteredServiceProvider<Economy> economyService = services.getRegistration(Economy.class);
        if (economyService == null) return Optional.empty();
        Economy economy = economyService.getProvider();
        return Optional.ofNullable(economy);
    }

    private void registerWrapper(Economy original) {
        // Don't wrap Economy twice in case of reloads.
        Economy wrappedEco = original instanceof EconomyWrapper ? original : new EconomyWrapper(original);
        getServer().getServicesManager().register(Economy.class, wrappedEco, this, ServicePriority.Highest);
        getLogger().info("Vault Events registered - Events can now be listened to.");
        eventsAvailable = true;
        Bukkit.getPluginManager().callEvent(new VaultEventsAvailableEvent(wrappedEco));
    }
}