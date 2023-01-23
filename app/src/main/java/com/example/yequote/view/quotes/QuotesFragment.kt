package com.example.yequote.view.quotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.WindowCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.yequote.R
import com.example.yequote.data.model.Quotes
import com.example.yequote.data.viewmodel.QuotesViewModel
import com.example.yequote.databinding.FragmentQuotesBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.FragmentScoped


@FragmentScoped
@AndroidEntryPoint
class QuotesFragment : Fragment(R.layout.fragment_quotes) {

    @FragmentScoped
    private var _binding : FragmentQuotesBinding? = null
    private val binding get() = _binding!!

    private lateinit var quotes: Quotes
    private val viewModel : QuotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuotesBinding.inflate(inflater, container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}