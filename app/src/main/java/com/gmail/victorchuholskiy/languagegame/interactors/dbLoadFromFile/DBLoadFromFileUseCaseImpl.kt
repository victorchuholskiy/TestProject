package com.gmail.victorchuholskiy.languagegame.interactors.dbLoadFromFile

import android.content.res.AssetManager
import com.gmail.victorchuholskiy.languagegame.data.local.TranslationsDatabase
import com.gmail.victorchuholskiy.languagegame.data.local.models.TranslationModel
import com.gmail.victorchuholskiy.languagegame.data.local.tables.Translations
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.raizlabs.android.dbflow.config.FlowManager
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.exceptions.Exceptions
import io.reactivex.schedulers.Schedulers
import java.io.IOException

/**
 * Created by user
 * 26.07.2018.
 */
class DBLoadFromFileUseCaseImpl(private val assets: AssetManager): DBLoadFromFileUseCase {
	override fun execute(): Observable<Boolean> {

		return Observable.just(assets)
				.subscribeOn(Schedulers.newThread())
				.observeOn(AndroidSchedulers.mainThread())
				.map {
					try {
						val inputStream = it.open("words_v2.json")
						val size = inputStream.available()
						val buffer = ByteArray(size)
						inputStream.read(buffer)
						inputStream.close()

						val listType = object : TypeToken<List<TranslationModel>>() {}.type
						val list: List<TranslationModel> = Gson().fromJson(String(buffer, Charsets.UTF_8), listType)
						list
					} catch (e: IOException) {
						throw Exceptions.propagate(e)
					}
				}
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
				}
	}
}