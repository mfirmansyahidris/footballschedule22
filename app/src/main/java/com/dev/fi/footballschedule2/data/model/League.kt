package com.dev.fi.footballschedule2.data

import com.google.gson.annotations.SerializedName

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

data class League(
        @SerializedName("idLeague")
        var idLeague: String? = "",

        @SerializedName("strLeague")
        var strLeague: String? = "",

        @SerializedName("strSport")
        var strSport: String? = "",

        @SerializedName("strLeagueAlternate")
        var strLeagueAlternate: String? = ""
)