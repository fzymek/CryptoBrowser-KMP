package pl.fzymek.cryptobrowser

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform