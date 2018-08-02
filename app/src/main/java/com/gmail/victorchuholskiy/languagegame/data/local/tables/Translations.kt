package com.gmail.victorchuholskiy.languagegame.data.local.tables

import com.gmail.victorchuholskiy.languagegame.data.local.TranslationsDatabase
import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.structure.BaseModel
import com.raizlabs.android.dbflow.annotation.Table

/**
 * Created by viktor.chukholskiy
 * 25/07/18.
 */
@Table(database = TranslationsDatabase::class)
class Translations() : BaseModel() {

	constructor(eng: String,
				spa: String) : this() {
		this.eng = eng
		this.spa = spa
	}

	@Column
	@PrimaryKey (autoincrement=true)
	var id: Int = 0

	@Column
	var eng: String? = null

	@Column
	var spa: String? = null
}