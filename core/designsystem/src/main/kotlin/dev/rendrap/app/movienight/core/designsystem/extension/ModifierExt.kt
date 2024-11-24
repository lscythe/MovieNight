package dev.rendrap.app.movienight.core.designsystem.extension

import androidx.compose.ui.Modifier

inline fun <T> Modifier.ifNotNull(value: T?, builder: Modifier.(T) -> Modifier) =
    then(if (value != null) builder(value) else Modifier)

inline fun Modifier.ifTrue(value: Boolean = false, builder: Modifier.() -> Modifier) =
    then(if (value) builder() else Modifier)