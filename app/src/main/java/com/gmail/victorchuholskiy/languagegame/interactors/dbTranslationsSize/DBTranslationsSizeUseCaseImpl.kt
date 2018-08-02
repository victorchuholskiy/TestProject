package com.gmail.victorchuholskiy.languagegame.interactors.dbTranslationsSize

import com.gmail.victorchuholskiy.languagegame.data.local.tables.Translations
import com.raizlabs.android.dbflow.rx2.language.RXSQLite
import com.raizlabs.android.dbflow.sql.language.SQLite
import io.reactivex.Observable

/**
 * Created by user
 * 26.07.2018.
 */
class DBTranslationsSizeUseCaseImpl: DBTranslationsSizeUseCase {
	override fun execute(): Observable<Long> {
		return RXSQLite.rx(SQLite.selectCountOf()
				.from(Translations::class.java))
				.longValue()
				.toObservable()
	}
}