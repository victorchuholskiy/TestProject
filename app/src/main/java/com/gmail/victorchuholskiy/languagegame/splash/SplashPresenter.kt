package com.gmail.victorchuholskiy.languagegame.splash

import android.content.res.AssetManager
import android.util.Log
import com.gmail.victorchuholskiy.languagegame.interactors.parseFile.DBParseFileUseCaseImpl
import com.gmail.victorchuholskiy.languagegame.interactors.prepareRoundQuestions.PrepareRoundQuestionsUseCaseImpl

/**
 * Created by viktor.chukholskiy
 * 25/07/18.
 */
class SplashPresenter(private val view: SplashContract.View,
					  private val assets: AssetManager)
	: SplashContract.Presenter {

	init {
		view.presenter = this
	}

	override fun start() {
		DBParseFileUseCaseImpl(assets)
				.execute()
				.flatMap { PrepareRoundQuestionsUseCaseImpl(it).execute() }
				.subscribe({
					Log.d("AAA", it.toString())
				})
	}
}