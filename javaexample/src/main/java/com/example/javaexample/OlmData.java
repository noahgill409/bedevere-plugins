package com.example.olmdata;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import org.pf4j.Extension;

import net.runelite.api.events.ProjectileMoved;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.HitsplatApplied;


import net.runelite.api.Hitsplat
import net.runelite.api.Projectile;

@Extension
@PluginDescriptor(
	name = "Olm Data",
	description = "Collect and records Great Olm data for statistical analysis."
)
@Slf4j
public class OlmDataPlugin extends Plugin
{
	// Injects our config
	@Inject
	private OlmDataConfig config;

	// Provides our config
	@Provides
	OlmDataConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(OlmDataConfig.class);
	}

	@Override
	protected void startUp()
	{
		// runs on plugin startup
		log.info("Plugin started");

		// example how to use config items
		if (config.example())
		{
			// do stuff
			log.info("The value of 'config.example()' is ${config.example()}");
		}
	}

	@Override
	protected void shutDown()
	{
		// runs on plugin shutdown
		log.info("Plugin stopped");
	}

	@Subscribe
	private void onGameTick(GameTick gameTick)
	{
		// runs every gametick
		log.info("Gametick");
	}
	
	@Subscribe
	public void onProjectileMoved(ProjectileMoved projectileMoved)
	{
		Projectile projectile = projectileMoved.projectile;
		int projectileID = projectile.getID();
		
		/* Magic attack */
		if (projectileID == null)
		{
			;
		}
		/* Ranged attack */
		else if (projectile.getId() == null
		{
			;
		}
		/* Phase special attack */
		else if (projectile.getId() == null
		{
			;
		}
		/* Orb attack */
		else if (projectile.getId() == null
		{
			;
		}
		else
		{
			; /* return None / end logic for this frame */
		}
		
		Actor actor = projectile.getInteracting();
		
		if (actor != null)
		{
			int endCycle = projectile.getEndCycle();
			/* wait for end cycle, record damage ensure that it was via this projectile, record */
			
		}
		
	}
	
	@Subscribe
	public void onHitsplatApplied(HitsplatApplied hitsplatApplied)
	{
		Actor actor = hitsplatApplied.actor;
		Hitsplat hitpslat = hitsplatApplied.hitsplat;
		
		
	}
	
	@Subscribe
	public Actor onNpcSpawned(NpcSpawned npcSpawned)
	{
		Actor actor = npcSpawned.getActor();
		int npcID = actor.getID();
				
		if isGreatOlm(npcID)
		{
			return actor; /* track olm head and enraged / head phase for max hits*/
		}
		else if isGreatOlmLeftClaw(npcID)
		{
			return actor; /* track right claw data for crippled max hits*/
		}
	}
	
	@Subscribe
	public Actor onNpcDespawned(NpcDespawned npcDespawned)
	{
		Actor actor = npcDespawned.getActor()
		int npcID = actor.getID();
		
		if isGreatOlm(npcID)
		{
			return actor;
		}
		else if isGreatOlm
		{
			return actor; /* track right claw data for crippled max hits*/
		}
		
	}
}
