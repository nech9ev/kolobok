package com.itmo.kolobok

import com.itmo.kolobok.commands.CommandFactory
import com.itmo.kolobok.config.BotConfig
import org.springframework.stereotype.Component
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update


@Component
class KolobokBotService(
    private val botConfig: BotConfig,
) : TelegramLongPollingBot(botConfig.token) {

    override fun getBotUsername(): String = botConfig.botUserName

    override fun onUpdateReceived(update: Update?) {
        if (update == null) return
        if (!update.hasMessage() || !update.message.hasText() || update.message.from.isBot) return
//        if (update.message.from.userName !in listOf("nech9ev", "lublinskj")) return
        when (val result = CommandFactory.getHandler(update)?.process(update)) {
            is SendMessage -> execute(result)
        }
    }
}
