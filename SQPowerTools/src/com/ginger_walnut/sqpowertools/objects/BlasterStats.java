package com.ginger_walnut.sqpowertools.objects;

import com.ginger_walnut.sqpowertools.enums.AmmoType;
import com.ginger_walnut.sqpowertools.enums.ProjectileType;

public class BlasterStats {

	public int cooldown = 0;
	public double damage = 0.0;
	public int scope = 0;
	public int ammo = 0;
	public int reload = 0;
	public AmmoType ammoType = AmmoType.ARROWS;
	public ProjectileType projectileType = ProjectileType.ARROW;
	public float explosionSize = 1.0f;
	
	public BlasterStats() {
		
	}
	
}
