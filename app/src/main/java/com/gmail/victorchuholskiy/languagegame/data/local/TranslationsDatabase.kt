package com.gmail.victorchuholskiy.languagegame.data.local

import com.raizlabs.android.dbflow.annotation.Database

/**
 * Created by viktor.chukholskiy
 * 25/07/18.
 */
@Database(name = TranslationsDatabase.name, version = TranslationsDatabase.version)
object TranslationsDatabase {
	const val name = "TranslationsDatabase"
	const val version = 1
}