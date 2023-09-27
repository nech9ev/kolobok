package com.itmo.kolobok.handlers

import com.itmo.kolobok.commands.CommandHandler
import com.itmo.kolobok.database.Pediks
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update

class PedikRandomHandler : CommandHandler<SendMessage> {

    override fun process(update: Update): SendMessage? {
        val chatId = update.message.chatId.toString()

        val randomUser = getChatUsers().randomOrNull()
        if (Pediks.users.getOrDefault(update.message.from.userName, 0) == 0
            && update.message.from.userName != "nech9ev") return null
        if (randomUser != null) {
            val oldCount = Pediks.users.getOrDefault(randomUser, 0)
            Pediks.users[randomUser] = oldCount + 1
            return SendMessage(chatId, "победитель: $randomUser!")
        }

        return null
    }

    private fun getChatUsers() = listOf(
        "@CJIABJ9HCKUY_3AzjuM_YayLjAMu",
        "@nech9ev",
        "Andrew⚽\uFE0F\uD83D\uDDA4",
        "@RaHaJI6Da",
        "@kocan0",
        "@lublinskj",
        "@EtoNeTot0KomTblPodymal",
        "Артем Засов",
        "@Rugast2",
    )
}