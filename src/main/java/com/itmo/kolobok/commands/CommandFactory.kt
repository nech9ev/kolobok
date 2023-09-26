package com.itmo.kolobok.commands

import com.itmo.kolobok.handlers.PedikRandomHandler
import com.itmo.kolobok.handlers.PedikRatingHandler
import org.telegram.telegrambots.meta.api.objects.Update

object CommandFactory {

    fun getHandler(update: Update): CommandHandler<*>? {
        val text = update.message.text
        return when (text) {
            Commands.WHO_PEDIK.value -> PedikRandomHandler()
            Commands.RATING.value -> PedikRatingHandler()
            else -> null
        }
    }
}