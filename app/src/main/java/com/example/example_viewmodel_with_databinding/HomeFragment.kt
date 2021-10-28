package com.example.example_viewmodel_with_databinding

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.example_viewmodel_with_databinding.databinding.HomeFragmentBinding
import kotlinx.android.synthetic.main.home_fragment.*


class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        //Pass the ViewModel into the data binding:
        binding.homeViewModel = viewModel
        binding.lifecycleOwner = this

        //Start code here

        binding.SaveButton.setOnClickListener {
            var testEditText = binding.testEditText.text.toString()
            binding.unmodifiedTextView.text = testEditText

            var modifiedText = viewModel.modifyEntry(testEditText)
            binding.modifiedTextView.text = modifiedText

        }

        //End code here

        //Needed for data binding at end
        return binding.root
    }
}