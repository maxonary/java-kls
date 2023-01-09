package de.coaster.listener;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CommandListener extends ListenerAdapter {

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		
		String message = event.getMessage().getContentDisplay();
		
		
		
		if(event.isFromType(ChannelType.TEXT)) {
			TextChannel channel = event.getTextChannel();
			
			
			
			if(message.startsWith("!tut")) {
				String [] args = message.substring(5).split(" ");
				
				if(args.length == 1) {
					if(args[0].equalsIgnoreCase("hi")) {
						
						channel.sendMessage("Hallo" + event.getMember().getAsMention() + "!").queue();
						
						
					}
				}
				if(args.length == 1) {
					if(args[0].equalsIgnoreCase("sport")) {
						
						channel.sendMessage("Sport ist Mord ").queue();
						
						
					}
				}	
				if(args.length == 1) {
					if(args[0].equalsIgnoreCase("wtf")) {
						
						channel.sendMessage("Alarm!! Alarm!! Alle Lappen aus der Bahn. Ich schnetzle euch alle!" + "!").queue();
						
						
					}
				}
				if(args.length == 1) {
					if(args[0].equalsIgnoreCase("tut")) {
						
						channel.sendMessage("-play tomas the tank engine").queue();
						
						
					}
				if(args.length == 1) {
					if(args[0].equalsIgnoreCase("nice")) {
						
						channel.sendMessage("So gefällt mir das.").queue();
					
							
							
					}
				
				}
			
			}
			
		}
		
 	}
	}
}

