package com.gmail.victorchuholskiy.languagegame

import android.app.Application
import com.gmail.victorchuholskiy.languagegame.data.local.TranslationsDatabase
import com.raizlabs.android.dbflow.config.DatabaseConfig
import com.raizlabs.android.dbflow.config.FlowConfig
import com.raizlabs.android.dbflow.config.FlowManager

/**
 * Created by viktor.chukholskiy
 * 25/07/18.
 */
class LanguageGameApp : Application() {
	override fun onCreate() {
		super.onCreate()

		// This instantiates DBFlow
		FlowManager.init(FlowConfig.Builder(this)
				.addDatabaseConfig(DatabaseConfig.Builder(TranslationsDatabase::class.java).build()).build())
	}
}