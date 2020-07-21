package com.d10s3.daynightthemedemo.ui.preferences

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.d10s3.daynightthemedemo.R
import com.d10s3.daynightthemedemo.ThemeManager
import kotlinx.android.synthetic.main.fragment_preferences.*
import kotlinx.android.synthetic.main.fragment_preferences.view.*

class PreferencesFragment : Fragment() {

    private lateinit var preferencesViewModel: PreferencesViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        preferencesViewModel =
                ViewModelProviders.of(this).get(PreferencesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_preferences, container, false)

        when(ThemeManager.getTheme()) {
            AppCompatDelegate.MODE_NIGHT_NO ->
                root.radioLightButton.isChecked = true
            AppCompatDelegate.MODE_NIGHT_YES ->
                root.radioDarkButton.isChecked = true
            else ->
                root.radioDefaultButton.isChecked = true
        }

        root.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId) {
                radioLightButton.id ->
                    ThemeManager.applyTheme(ThemeManager.ThemeMode.LIGHT)
                radioDarkButton.id ->
                    ThemeManager.applyTheme(ThemeManager.ThemeMode.DARK)
                else ->
                    ThemeManager.applyTheme(ThemeManager.ThemeMode.DEFAULT)

            }
        }
        return root
    }
}
