package android.kuchristianunion.kucu.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.kuchristianunion.kucu.R
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat

class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings, rootKey)

        val accountSettingsPref = findPreference<Preference>(getString(R.string.key_account_settings))
        accountSettingsPref?.setOnPreferenceClickListener {
            // do something

            true
        }
    }
}