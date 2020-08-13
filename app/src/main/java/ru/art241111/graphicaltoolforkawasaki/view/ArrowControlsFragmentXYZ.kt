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


        repositoryForRobotApi = RepositoryForRobotApi()
        setClickListeners()

        return binding.root
    }

    private fun setClickListeners() {
        // Move by Z
        onButtonUpZClickListener()
        onButtonDownZClickListener()

        // Move by X
        onButtonRightXClickListener()
        onButtonLeftXClickListener()

        // Move by Z
        onButtonUpYClickListener()
        onButtonDownYClickListener()
    }

    private fun onButtonUpZClickListener() {
        binding.ibUpZ.setOnClickListener {
            repositoryForRobotApi.moveByZ(100)
        }
    }

    private fun onButtonDownZClickListener() {
        binding.ibDownZ.setOnClickListener{
            repositoryForRobotApi.moveByZ(-100)
        }
    }

    private fun onButtonRightXClickListener() {
        binding.ibRightX.setOnClickListener{
            repositoryForRobotApi.moveByX(100)
        }
    }

    private fun onButtonLeftXClickListener() {
        binding.ibLeftX.setOnClickListener{
            repositoryForRobotApi.moveByX(-100)
        }
    }

    private fun onButtonUpYClickListener() {
        binding.ibUpY.setOnClickListener {
            repositoryForRobotApi.moveByY(100)
        }
    }

    private fun onButtonDownYClickListener() {
        binding.ibDownY.setOnClickListener{
            repositoryForRobotApi.moveByY(-100)
        }
    }

    override fun onDetach() {
        repositoryForRobotApi.disconnect()
        super.onDetach()
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