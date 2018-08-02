package com.gmail.victorchuholskiy.languagegame.interactors.prepareRoundQuestions

import com.gmail.victorchuholskiy.languagegame.data.local.models.TranslationModel
import com.gmail.victorchuholskiy.languagegame.data.local.models.TranslationQuestion
import com.gmail.victorchuholskiy.languagegame.utils.QUESTION_PER_ROUND
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by user
 * 26.07.2018.
 */
class PrepareRoundQuestionsUseCaseImpl(private val list: List<TranslationModel>): PrepareRoundQuestionsUseCase {
	override fun execute(): Observable<List<TranslationQuestion>> {
		return Observable.just(list)
				.subscribeOn(Schedulers.newThread())
				.observeOn(AndroidSchedulers.mainThread())
				.map {
					val size = it.size
					when {
						size > 1 -> {
							val questionCount = Math.min(size, QUESTION_PER_ROUND)
							val result = ArrayList<TranslationQuestion>()
							val random = Random()
							val chosenIndexes = (0 until size).shuffled().subList(0, questionCount)
							for (index in chosenIndexes) {
								if (random.nextBoolean()) {
									result.add(TranslationQuestion(it[index].eng, it[index].spa, true))
								} else {
									var incorrectIndex = Math.abs(random.nextInt()) % size
									if (incorrectIndex == index) {
										if (index > 0) {
											incorrectIndex--
										} else {
											incorrectIndex++
										}
									}
									result.add(TranslationQuestion(it[index].eng, it[incorrectIndex].spa, false))
								}
							}
							result
						}
						size == 1 -> arrayListOf(TranslationQuestion(it[0].eng, it[0].spa, true))
						else -> arrayListOf()
					}
				}
	}
}