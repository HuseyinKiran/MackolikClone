package com.huseyinkiran.mackolikclone.util

import com.huseyinkiran.mackolikclone.R

object LeagueImageProvider {
    fun getImageResource(leagueKey: String) : Int {
        return when(leagueKey) {
            "ingiltere-premier-ligi" -> R.drawable.ingiltereligi
            "ispanya-la-liga" -> R.drawable.laliga
            "italya-serie-a-ligi" -> R.drawable.italyaligi
            "fransa-ligue-1" -> R.drawable.fr1
            "almanya-bundesliga" -> R.drawable.bundesliga
            "super-lig" -> R.drawable.trendyolsuperlig
            "tff-1-lig" -> R.drawable.tr2
            "uefa-konferans-ligi" -> R.drawable.konferansligi
            "ingiltere-sampiyonluk-ligi" -> R.drawable.championship
            "almanya-bundesliga-2-ligi" -> R.drawable.bundesliga2
            "fransa-ligue-2" -> R.drawable.fr2
            "euroleague" -> R.drawable.euoroleague
            "basketbol-super-ligi" -> R.drawable.basketbolturk
            else -> R.drawable.ic_launcher_foreground
        }
    }
}