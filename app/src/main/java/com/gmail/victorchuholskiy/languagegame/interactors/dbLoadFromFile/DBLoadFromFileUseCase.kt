package com.gmail.victorchuholskiy.languagegame.interactors.dbLoadFromFile

import com.gmail.victorchuholskiy.languagegame.interactors.UseCase
import io.reactivex.Observable

/**
 * Created by user
 * 26.07.2018.
 */
interface DBLoadFromFileUseCase: UseCase<Boolean> {
	override fun execute(): Observable<Boolean>
}