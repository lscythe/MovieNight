package dev.rendrap.app.movienight.data.tmdb.mapper

import dev.rendrap.app.movienight.data.tmdb.dto.response.PeopleDetailResponse
import dev.rendrap.app.movienight.model.People

fun PeopleDetailResponse.toModel() = People(
    name = name,
    avatar = profilePath,
    placeOfBirth = placeOfBirth,
    dateOfBirth = birthday,
    deathDay = deathday.orEmpty()
)