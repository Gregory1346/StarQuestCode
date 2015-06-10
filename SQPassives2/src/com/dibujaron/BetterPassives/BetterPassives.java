//  /\*.*?\*/ 

package com.dibujaron.BetterPassives;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class BetterPassives extends JavaPlugin {

	public void onEnable() {
		getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
		getServer().getPluginManager().registerEvents(new EntityListener(this), this);
		getServer().getPluginManager().registerEvents(new ChunkListener(this), this);

		saveDefaultConfig();
		
		Settings.loadSettings(getConfig());
	}

	public void onDisable() {
		World w = Bukkit.getWorld(Bukkit.getServerName());
		if(w == null) return;
		List<EntityType> types = getAcceptableHostileTypes(w);
		if(types == null) return;
		ArrayList<Entity> removalQueue = new ArrayList<Entity>();
		for (Entity e : w.getEntities()) {
			if (types.contains(e.getType())) {
				removalQueue.add(e);
			}
		}
		for (Entity e : removalQueue)
			e.remove();
	}

	public void setMetadata(Player player, String key, Object value) {
		player.setMetadata(key, new FixedMetadataValue(this, value));
	}

	public Object getMetadata(Player player, String key) {
		List<MetadataValue> values = player.getMetadata(key);
		for (MetadataValue value : values) {
			if (value.getOwningPlugin().getDescription().getName().equals(getDescription().getName())) {
				return value.value();
			}
		}
		return null;
	}

	public ItemStack getTameItem(Entity entity) {
		EntityType type = entity.getType();

		if (type == EntityType.PIG)
			return new ItemStack(Material.CARROT_ITEM);
		if ((type == EntityType.COW) || (type == EntityType.SHEEP) || (type == EntityType.MUSHROOM_COW))
			return new ItemStack(Material.WHEAT);
		if (type == EntityType.WOLF)
			return new ItemStack(Material.BONE);
		if (type == EntityType.CHICKEN)
			return new ItemStack(Material.SEEDS);
		if (type == EntityType.OCELOT)
			return new ItemStack(Material.RAW_FISH);
		return null;
	}

	public String getRandomName(Entity entity) {
		EntityType type = entity.getType();
		return type.getName().toLowerCase();
	}

	public Block getRealHighestBlockAt(Location location) {
		Location location2 = location.getWorld().getHighestBlockAt(location).getLocation();
		Location location3 = new Location(location2.getWorld(), location2.getX(), location2.getY() - 1.0D, location2.getZ());
		return location3.getBlock();
	}

	public List<EntityType> getAcceptableTypes(World world) {
		return Settings.getPassivesOfPlanet(world.getName());
	}

	public List<EntityType> getAcceptableHostileTypes(World world) {
		return Settings.getHostilesOfPlanet(world.getName());
	}
}

/*
 * Location: C:\Users\Drew\Desktop\SQPassives.jar Qualified Name:
 * com.dibujaron.BetterPassives.BetterPassives JD-Core Version: 0.6.2
 */