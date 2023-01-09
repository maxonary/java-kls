package de.coaster;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.security.auth.login.LoginException;

import de.coaster.listener.CommandListener;


public class DiscordBot {

	public ShardManager shardMan;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new DiscordBot();
			
		} catch (LoginException | IllegalArgumentException e) {
			e.printStackTrace();
		
		
	}}
	
	public DiscordBot() throws LoginException, IllegalArgumentException {
		DefaultShardManagerBuilder builder = new DefaultShardManagerBuilder();
		builder.setToken("NjM3OTY2MTgyNDA1NjM2MTE2.XbV4Bg.zV7F3qlnfzB7HdSrd0qEcpc1iig");
		
		builder.setActivity(Activity.watching("Minecraft Let's Play by Gronkh"));
		builder.setStatus(OnlineStatus.ONLINE);
		
		builder.addEventListeners(new CommandListener());
		
		shardMan = builder.build();
		System.out.print("Bot online.");
		
		shutdown();
	}

	
	public void shutdown() {
		
		new Thread(() -> {
			
			String line = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				while((line = reader.readLine()) != null) {
					
					if(line.equalsIgnoreCase("+exit")) {
						if(shardMan != null) {
							shardMan.setStatus(OnlineStatus.OFFLINE);
							shardMan.shutdown();
							System.out.print("Bot offline.");
						}
						
						reader.close();
						
					}
					else {
						System.out.print("Use '+exit' to shutdown.");
					}
					
				}
				
			}catch (IOException e) {
				e.printStackTrace();
			}
			
		}).start();
	
		
		
	}
	}

