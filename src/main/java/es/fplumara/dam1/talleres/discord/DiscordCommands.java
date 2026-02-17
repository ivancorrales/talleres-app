package es.fplumara.dam1.talleres.discord;

import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class DiscordCommands extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        // Ignorar mensajes de otros bots
        if (event.getAuthor().isBot()) return;

        String mensaje = event.getMessage().getContentRaw();
        String usuario = event.getAuthor().getName();




        System.out.println(event.getChannel().getName()+" - " +usuario + ": " + mensaje);







    }


    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        switch(event.getName()) {
            case "ping" -> event.reply("Pong!").queue();
            case "hora" -> {
                String zoneId = event.getOption("zone").getAsString();
                Date date = new Date();
                DateFormat df = new SimpleDateFormat("HH:mm:ss");
                df.setTimeZone(TimeZone.getTimeZone(zoneId));
                String horaFormateada = df.format(date);
                event.reply(horaFormateada).queue();
            }
            case "suma" -> {

            }
        }
    }
}
