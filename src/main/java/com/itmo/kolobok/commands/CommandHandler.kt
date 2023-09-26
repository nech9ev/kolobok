package com.itmo.kolobok.commands

import org.telegram.telegrambots.meta.api.methods.BotApiMethod
import org.telegram.telegrambots.meta.api.objects.Update

interface CommandHandler<T: BotApiMethod<*>> {

    fun process(update: Update): T?
}