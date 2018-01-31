package cz.vutbr.fit.brnogo.injection;

import cz.vutbr.fit.brnogo.injection.annotation.scope.PerScreen;
import cz.vutbr.fit.brnogo.ui.departures.DeparturesFragment;
import cz.vutbr.fit.brnogo.ui.departures.DeparturesFragmentModule;
import cz.vutbr.fit.brnogo.ui.nearby.NearbyFragment;
import cz.vutbr.fit.brnogo.ui.nearby.NearbyFragmentModule;
import cz.vutbr.fit.brnogo.ui.routes.RoutesFragment;
import cz.vutbr.fit.brnogo.ui.routes.RoutesFragmentModule;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuilderModule {

	@PerScreen
	@ContributesAndroidInjector(modules = RoutesFragmentModule.class)
	abstract RoutesFragment bindRoutesFragment();

	@PerScreen
	@ContributesAndroidInjector(modules = DeparturesFragmentModule.class)
	abstract DeparturesFragment bindDeparturesFragment();

	@PerScreen
	@ContributesAndroidInjector(modules = NearbyFragmentModule.class)
	abstract NearbyFragment bindNearbyFragment();

}
