package cz.vutbr.fit.brnogo.ui.settings;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.Toast;

import javax.inject.Inject;

import cz.vutbr.fit.brnogo.R;
import cz.vutbr.fit.brnogo.databinding.ActivitySettingsBinding;
import cz.vutbr.fit.brnogo.tools.constant.Constant;
import cz.vutbr.fit.brnogo.ui.base.BaseActivity;

public class SettingsActivity extends BaseActivity<SettingsViewModel, ActivitySettingsBinding> implements SettingsView {

	@Inject
	SettingsViewModelFactory viewModelFactory;

	public static Intent getStartIntent(Context context) {
		return new Intent(context, SettingsActivity.class);
	}

	@Override
	protected SettingsViewModel createViewModel() {
		return ViewModelProviders.of(this, viewModelFactory).get(SettingsViewModel.class);
	}

	@Override
	protected ActivitySettingsBinding inflateBindingLayout(LayoutInflater layoutInflater) {
		return ActivitySettingsBinding.inflate(layoutInflater);
	}

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setSupportActionBar(binding.toolbar);

		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null) {
			actionBar.setDisplayHomeAsUpEnabled(true);
		}

		if (savedInstanceState == null) {
			getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.preference_content, new SettingsFragment())
					.commit();
		}

		viewModel.msgType.observe(this, syncStatus -> {
			if (syncStatus != null) {
				switch (syncStatus) {
					case Constant.SyncStatus.DONE:
						Toast.makeText(getApplicationContext(), getString(R.string.sync_success), Toast.LENGTH_SHORT).show();
						break;
					default:
						Toast.makeText(getApplicationContext(), getString(R.string.sync_failed), Toast.LENGTH_SHORT).show();
						break;
				}
			}
		});
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				finish();
				return true;
		}
		return false;
	}

	protected void sync() {
		viewModel.sync();
	}
}
