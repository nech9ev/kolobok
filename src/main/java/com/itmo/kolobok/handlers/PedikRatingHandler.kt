package com.itmo.kolobok.handlers

import com.itmo.kolobok.commands.CommandHandler
import com.itmo.kolobok.database.Pediks
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update

class PedikRatingHandler : CommandHandler<SendMessage> {

    override fun process(update: Update): SendMessage? {
        val chatId = update.message.chatId.toString()
        val users = getChatUsers()
        val resultList: StringBuilder = java.lang.StringBuilder("")
        users.forEach { user ->
            resultList.append("$user : ${Pediks.users.getOrDefault(user, 0)}\n")
        }
        return SendMessage(chatId, "Рейтинг педиков:\n $resultList")
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