# Vault-Events
VaultAPI wrapper for adding events to Vault

See VaultAPI here:
https://github.com/MilkBowl/VaultAPI

## Dependency information

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.AuroraLS3</groupId>
        <artifactId>Vault-Events</artifactId>
        <version>{commit}</version>
    </dependency>
</dependencies>
```

plugin.yml:
```yml
(soft)depend: [Vault, VaultEvents]
```

## Listening for events

Use the Event API of Spigot: https://www.spigotmc.org/wiki/using-the-event-api/

- [See available events](https://github.com/Rsl1122/Vault-Events/tree/master/src/main/java/com/djrapitops/vaultevents/events) 

## License

Licensed under MIT-license
