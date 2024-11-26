package dev.rendrap.app.movienight.core.resource.icons

import androidx.compose.ui.graphics.vector.ImageVector
import dev.rendrap.app.movienight.core.resource.icons.mvicon.Archive
import dev.rendrap.app.movienight.core.resource.icons.mvicon.ArrowLeft
import dev.rendrap.app.movienight.core.resource.icons.mvicon.ChevronRight
import dev.rendrap.app.movienight.core.resource.icons.mvicon.Cog
import dev.rendrap.app.movienight.core.resource.icons.mvicon.Image
import dev.rendrap.app.movienight.core.resource.icons.mvicon.ImageBroken
import dev.rendrap.app.movienight.core.resource.icons.mvicon.Movie
import dev.rendrap.app.movienight.core.resource.icons.mvicon.Play
import dev.rendrap.app.movienight.core.resource.icons.mvicon.Search
import dev.rendrap.app.movienight.core.resource.icons.mvicon.SearchAlt
import dev.rendrap.app.movienight.core.resource.icons.mvicon.SearchFolder
import kotlin.collections.List as ____KtList

public object MVIcon

private var __AllIcons: ____KtList<ImageVector>? = null

public val MVIcon.AllIcons: ____KtList<ImageVector>
  get() {
    if (__AllIcons != null) {
      return __AllIcons!!
    }
    __AllIcons= listOf(Cog, SearchFolder, Search, SearchAlt, Play, Image, ArrowLeft, ChevronRight,
        ImageBroken, Archive, Movie)
    return __AllIcons!!
  }
