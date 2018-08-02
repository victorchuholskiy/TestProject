package com.gmail.victorchuholskiy.languagegame.interactors.dbTranslationsGet

import com.gmail.victorchuholskiy.languagegame.data.local.tables.Translations
import com.gmail.victorchuholskiy.languagegame.data.local.tables.Translations_Table
import com.raizlabs.android.dbflow.rx2.language.RXSQLite
import com.raizlabs.android.dbflow.sql.language.Method
import com.raizlabs.android.dbflow.sql.language.SQLite
import io.reactivex.Observable
import java.util.*

/**
 * Created by user
 * 26.07.2018.
 */
class DBTranslationGetUseCaseImpl(): DBTranslationGetUseCase {
	override fun execute(): Observable<List<Translations>> {
		val cursor = SQLite.select(Method.max(Translations_Table.id)).from(Translations::class.java).query()
		val maxId = cursor!!.getInt(0)
		return RXSQLite.rx(SQLite.select().from<Translations>(Translations::class.java)
				.where(Translations_Table.id.greaterThan(Math.abs(Random().nextInt() % maxId + 1)))
				.limit(10))
				.queryList()
				.toObservable()


		/*return Observable.just(list)
				.subscribeOn(Schedulers.newThread())
				.observeOn(AndroidSchedulers.mainThread())
				.map {
					val translations = ArrayList<Translations>()
					for (pair in it) {
						translations.add(Translations(pair.eng!!, pair.spa!!))
					}
					FlowManager.getDatabase(TranslationsDatabase.javaClass)
							.transactionManager
							.saveQueue
							.addAll(translations as Collection<Translations>)
					true
				}*/
	}
}