package cz.vutbr.fit.brnogo.injection;

import cz.vutbr.fit.brnogo.injection.annotation.scope.PerScreen;
import cz.vutbr.fit.brnogo.ui.main.departures.DeparturesFragment;
import cz.vutbr.fit.brnogo.ui.main.departures.DeparturesFragmentModule;
import cz.vutbr.fit.brnogo.ui.main.directions.DirectionsFragment;
import cz.vutbr.fit.brnogo.ui.main.directions.DirectionsFragmentModule;
import cz.vutbr.fit.brnogo.ui.main.routes.RoutesFragment;
import cz.vutbr.fit.brnogo.ui.main.routes.RoutesFragmentModule;
import cz.vutbr.fit.brnogo.ui.main.routes.dialog.time.TransferTimePickerDialog;
import cz.vutbr.fit.brnogo.ui.main.routes.dialog.time.TransferTimePickerFragmentModule;
import cz.vutbr.fit.brnogo.ui.main.routes.dialog.transfers.TransfersPickerDialog;
import cz.vutbr.fit.brnogo.ui.main.routes.dialog.transfers.TransfersPickerFragmentModule;
import cz.vutbr.fit.brnogo.ui.route.navigation.map.MapFragment;
import cz.vutbr.fit.brnogo.ui.route.navigation.map.MapFragmentModule;
import cz.vutbr.fit.brnogo.ui.settings.SettingsFragment;
import cz.vutbr.fit.brnogo.ui.settings.SettingsFragmentModule;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Class containing all fragments for Dagger.
 */

@Module
public abstract class FragmentBuilderModule {

	@PerScreen
	@ContributesAndroidInjector(modules = RoutesFragmentModule.class)
	abstract RoutesFragment bindRoutesFragment();

	@PerScreen
	@ContributesAndroidInjector(modules = DeparturesFragmentModule.class)
	abstract DeparturesFragment bindDeparturesFragment();

	@PerScreen
	@ContributesAndroidInjector(modules = DirectionsFragmentModule.class)
	abstract DirectionsFragment bindDirectionsFragment();

	@PerScreen
	@ContributesAndroidInjector(modules = TransferTimePickerFragmentModule.class)
	abstract TransferTimePickerDialog bindTransferTimeDialogFragment();

	@PerScreen
	@ContributesAndroidInjector(modules = TransfersPickerFragmentModule.class)
	abstract TransfersPickerDialog bindTransfersDialogFragment();

	@PerScreen
	@ContributesAndroidInjector(modules = SettingsFragmentModule.class)
	abstract SettingsFragment bindSettingsFragment();

	@PerScreen
	@ContributesAndroidInjector(modules = MapFragmentModule.class)
	abstract MapFragment bindMapFragment();

}
