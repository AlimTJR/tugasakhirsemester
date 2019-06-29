package com.tjr.alim.profilmhs.rest

import com.tjr.alim.profilmhs.BuildConfig
import com.tjr.alim.profilmhs.model.RootDataModel
import retrofit.http.GET
import rx.Observable
import java.util.*

interface ApiService {
    @GET("detil_jadwal?key=" + BuildConfig.API_KEY + "&npm=" + BuildConfig.NPM)
    fun getJadwalKuliah(
    ): Observable<RootDataModel>

    @GET("detil_pribadi?key=" + BuildConfig.API_KEY + "&npm=" + BuildConfig.NPM)
    fun getProfil(
    ): Observable<RootDataModel>

}