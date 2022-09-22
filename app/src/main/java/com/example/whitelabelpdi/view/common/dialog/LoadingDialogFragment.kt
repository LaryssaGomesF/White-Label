package com.example.whitelabelpdi.view.common.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.whitelabelpdi.R
import com.example.whitelabelpdi.databinding.DialogFragmentLoadingBinding


class LoadingDialogFragment() : DialogFragment() {

    private lateinit var viewBinding: DialogFragmentLoadingBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        DialogFragmentLoadingBinding.inflate(inflater, container, false)
            .also {
                viewBinding = it
            }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {

        fun newInstance(): LoadingDialogFragment {
            val frag = LoadingDialogFragment()
            val args = Bundle()
            frag.arguments = args
            return frag
        }
    }
}

