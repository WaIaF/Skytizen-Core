package me.waiaf.skytizencore.commands

@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class CommandInfo(val name: String, val permission: String = "", val requiresPlayer: Boolean)