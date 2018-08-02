package com.gmail.victorchuholskiy.languagegame.interactors.dbTranslationsSize

import com.gmail.victorchuholskiy.languagegame.interactors.UseCase
import io.reactivex.Observable

/**
 * Created by user
 * 26.07.2018.
 */
interface DBTranslationsSizeUseCase: UseCase<Long> {
	override fun execute(): Observable<Long>
}