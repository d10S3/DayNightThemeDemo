package com.d10s3.daynightthemedemo.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.d10s3.daynightthemedemo.R

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
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        preferencesViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
