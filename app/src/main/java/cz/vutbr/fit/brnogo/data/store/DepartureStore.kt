package cz.vutbr.fit.brnogo.data.store

import android.view.Menu
import cz.vutbr.fit.brnogo.data.api.ApiManager
import cz.vutbr.fit.brnogo.data.model.response.CurrentDeparture
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DepartureStore @Inject constructor(
		val apiManager: ApiManager) {

	fun getDepartures(stationId: Int): Single<List<CurrentDeparture>> {
		return apiManager.getDepartures(stationId)
	}
}
