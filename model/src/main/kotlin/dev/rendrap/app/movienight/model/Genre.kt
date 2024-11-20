package dev.rendrap.app.movienight.model

enum class MovieGenreType(val id: Int, val value: String) {
    ACTION(28, "Action"),
    ADVENTURE(12, "Adventure"),
    ANIMATION(16, "Animation"),
    COMEDY(35, "Comedy"),
    CRIME(80, "Crime"),
    DOCUMENTARY(99, "Documentary"),
    DRAMA(18, "Drama"),
    FAMILY(10751, "Family"),
    FANTASY(14, "Fantasy"),
    HISTORY(36, "History"),
    HORROR(27, "Horror"),
    MUSIC(10402, "Music"),
    MYSTERY(9648, "Mystery"),
    ROMANCE(10749, "Romance"),
    SCIENCE_FICTION(878, "Sci-Fi"),
    TV_MOVIE(10770, "Tv Movie"),
    THRILLER(53, "Thriller"),
    WAR(10752, "War"),
    WESTERN(37, "Western")
}

enum class TvGenreType(val id: Int, val value: String) {
    ACTION_ADVENTURE(10759, "Action Adventure"),
    ANIMATION(16, "Animation"),
    COMEDY(35, "Comedy"),
    CRIME(80, "Crime"),
    DOCUMENTARY(99, "Documentary"),
    DRAMA(18, "Drama"),
    FAMILY(10751, "Family"),
    KIDS(10762, "Kids"),
    MYSTERY(9468, "Mystery"),
    NEWS(10763, "News"),
    SCI_FI_FANTASY(10764, "Sci-Fi Fantasy"),
    SOAP(10765, "Soap"),
    TALK(10766, "Talk"),
    WAR_POLITICS(10767, "War & Politics"),
    WESTERN(10768, "Western")
}