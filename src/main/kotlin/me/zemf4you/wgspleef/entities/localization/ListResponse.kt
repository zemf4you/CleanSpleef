package me.zemf4you.wgspleef.entities.localization

import kotlinx.serialization.Serializable
import java.text.MessageFormat

@Serializable
data class ListResponse(
    val header: String,
    val string: String = "\n",
    val separator: String,
) {
    operator fun <T> invoke(items: Iterable<T>, itemRepresent: (T) -> String) =
        header + items.joinToString(separator) { item ->
            MessageFormat.format(string, itemRepresent(item))
        }
}