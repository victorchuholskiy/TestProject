package com.gmail.victorchuholskiy.languagegame.interactors.dbTranslationsGet

import com.gmail.victorchuholskiy.languagegame.data.local.tables.Translations
import com.gmail.victorchuholskiy.languagegame.interactors.UseCase
import io.reactivex.Observable

/**
 * Created by user
 * 26.07.2018.
 */
interface DBTranslationGetUseCase: UseCase<List<Translations>> {
	override fun execute(): Observable<List<Translations>>
}