package ru.art241111.graphicaltoolforkawasaki.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import ru.art241111.graphicaltoolforkawasaki.MainActivity
import ru.art241111.graphicaltoolforkawasaki.R
import ru.art241111.graphicaltoolforkawasaki.databinding.FragmentArrowControlsXyzBinding
import ru.art241111.graphicaltoolforkawasaki.repository.RepositoryForRobotApi
import ru.art241111.graphicaltoolforkawasaki.viewModel.RobotViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [ArrowControlsFragmentXYZ.newInstance] factory method to
 * create an instance of this fragment.
 */
class ArrowControlsFragmentXYZ : Fragment() {
    private lateinit var binding: FragmentArrowControlsXyzBinding
    private lateinit var viewModel: RobotViewModel
    private lateinit var repositoryForRobotApi: RepositoryForRobotApi

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(activity as MainActivity).get(RobotViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_arrow_controls_xyz, container, false)
        binding.executePendingBindings()

        setClickListeners()
        return binding.root
    }

    private fun setClickListeners() {
        binding.ibUpZ.setOnClickListener {
            onButtonUpZClickListener()
        }
    }

    private fun onButtonUpZClickListener() {
        repositoryForRobotApi = RepositoryForRobotApi()
        repositoryForRobotApi.moveByZ(10)
        repositoryForRobotApi.switchRobotOff()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment ArrowControlsFragment.
         */
        @JvmStatic
        fun newInstance() = ArrowControlsFragmentXYZ()
    }
}