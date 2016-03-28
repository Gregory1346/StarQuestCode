package com.ginger_walnut.sqsmoothcraft.ship;

import java.util.ArrayList;
import java.util.List;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_9_R1.EntityPlayer;

import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.ginger_walnut.sqsmoothcraft.SQSmoothCraft;

public class ShipUtils {

	public static ShipBlock getShipBlockFromArmorStand(ArmorStand stand) {
		
		List<ShipBlock> shipBlocks = new ArrayList<ShipBlock>();
		
		for (Object object : SQSmoothCraft.shipMap.values().toArray()) {
			
			Ship ship = (Ship) object;
			
			shipBlocks.addAll(ship.getShipBlocks());
			
		}
		
		for (Ship ship : SQSmoothCraft.stoppedShipMap) {
			
			shipBlocks.addAll(ship.getShipBlocks());
			
		}
		
		for (ShipBlock shipBlock : shipBlocks) {
			
			if (shipBlock.getArmorStand().equals(stand)) {
				
				return shipBlock;
				
			}
			
		}
		
		return null;
		
	}
	
	public static Ship getShipFromNpc(EntityPlayer npc) {
		
		List<Ship> ships = new ArrayList<Ship>();		
		
		for (Ship ship : ships) {
			
			if (ship.thirdPersonPlayer.equals(npc)) {
				
				return ship;
				
			}
			
		}
		
		return null;
		
	}
	
	public static List<EntityPlayer> getAllShipNpcs() {
		
		List<EntityPlayer> npcs = new ArrayList<EntityPlayer>();
		
			for (Ship ship : SQSmoothCraft.shipMap.values()) {
				
				if (ship.thirdPersonPlayer != null) {
					
					npcs.add(ship.thirdPersonPlayer);
					
				}
				
			}
		
		return npcs;
		
	}
	
	public static void setPlayerShipInventory(Player player) {
		
		player.getInventory().clear();
		player.getInventory().setArmorContents(null);
		
		ItemStack mcd = new ItemStack(Material.WATCH);
		ItemMeta mcdMeta = mcd.getItemMeta();
		
		mcdMeta.setDisplayName("Main Control Device");
		
		List<String> mcdLore = new ArrayList<String>();
		mcdLore.add(ChatColor.DARK_PURPLE + "Point in the direction you want to turn");
		mcdLore.add(ChatColor.DARK_PURPLE + "while holding this to turn. You can left");
		mcdLore.add(ChatColor.DARK_PURPLE + "click while holding this to fire the");
		mcdLore.add(ChatColor.DARK_PURPLE + "ship's main cannons.");
		
		mcdMeta.setLore(mcdLore);
		
		mcd.setItemMeta(mcdMeta);
		
		player.getInventory().setItem(1, mcd);
		
		ItemStack accel = new ItemStack(Material.WATCH);
		ItemMeta accelMeta = accel.getItemMeta();
		
		accelMeta.setDisplayName("Accelerator");
		
		List<String> accelLore = new ArrayList<String>();
		accelLore.add(ChatColor.DARK_PURPLE + "Has the same function as the Main Control");
		accelLore.add(ChatColor.DARK_PURPLE + "Device except when you right click, the");
		accelLore.add(ChatColor.DARK_PURPLE + "ship accelerates");
		
		accelMeta.setLore(accelLore);
		
		accel.setItemMeta(accelMeta);
		
		player.getInventory().setItem(2, accel);
		
		ItemStack decel = new ItemStack(Material.WATCH);
		ItemMeta decelMeta = decel.getItemMeta();
		
		decelMeta.setDisplayName("Decelerator");
		
		List<String> decelLore = new ArrayList<String>();
		decelLore.add(ChatColor.DARK_PURPLE + "Has the same function as the Main Control");
		decelLore.add(ChatColor.DARK_PURPLE + "Device except when you right click, the");
		decelLore.add(ChatColor.DARK_PURPLE + "ship decelerates");
		
		decelMeta.setLore(decelLore);
		
		decel.setItemMeta(decelMeta);
		
		player.getInventory().setItem(3, decel);
		
		ItemStack missle = new ItemStack(Material.WATCH);
		ItemMeta missleMeta = missle.getItemMeta();
		
		missleMeta.setDisplayName("Missile Controler");
		
		List<String> missleLore = new ArrayList<String>();
		missleLore.add(ChatColor.DARK_PURPLE + "Has the same function as the Main Control");
		missleLore.add(ChatColor.DARK_PURPLE + "Device except when you left click, missiles");
		missleLore.add(ChatColor.DARK_PURPLE + "are launched");
		
		missleMeta.setLore(missleLore);
		
		missle.setItemMeta(missleMeta);
		
		player.getInventory().setItem(5, missle);
		
		ItemStack directionLock = new ItemStack(Material.COMPASS);
		ItemMeta directionLockMeta = directionLock.getItemMeta();
		
		directionLockMeta.setDisplayName("Direction Locker");
		
		List<String> directionLockLore = new ArrayList<String>();
		directionLockLore.add(ChatColor.DARK_PURPLE + "Right click this to lock the direction that");
		directionLockLore.add(ChatColor.DARK_PURPLE + "the ship is facing");
		
		directionLockMeta.setLore(directionLockLore);
		
		directionLock.setItemMeta(directionLockMeta);
		
		player.getInventory().setItem(7, directionLock);
				
		ItemStack exit = new ItemStack(Material.WOOD_DOOR);
		ItemMeta exitMeta = exit.getItemMeta();
		
		exitMeta.setDisplayName("Exit");
		
		List<String> exitLore = new ArrayList<String>();
		exitLore.add(ChatColor.DARK_PURPLE + "Right click with this in hand to exit");
		exitLore.add(ChatColor.DARK_PURPLE + "your ship.");
		
		exitMeta.setLore(exitLore);
		
		exit.setItemMeta(exitMeta);
		
		player.getInventory().setItem(8, exit);
		
		player.getInventory().setHeldItemSlot(0);
		
	}
	
}
