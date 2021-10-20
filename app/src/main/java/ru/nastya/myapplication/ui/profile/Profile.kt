package ru.nastya.myapplication.ui.profile
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.nastya.myapplication.MainActivity
import ru.nastya.myapplication.databinding.FragmentProfileBinding
import ru.nastya.myapplication.R



class Profile : Fragment() {

    private var binding: FragmentProfileBinding? = null
    private val mBinding get() = binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fab = (activity as MainActivity?)!!.getFloatingActionButton()
        if (fab != null) {
            (activity as MainActivity?)!!.hideFloatingActionButton()
        }
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return mBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.profileSettingsText.setOnClickListener {
            startActivity(Intent(requireContext(),SettingsActivity::class.java))
        }

        mBinding.profileAboutText.setOnClickListener {
            startActivity(
                AboutActivity.newInstance(requireContext(), "https://www.journaldev.com")
            )
        }

        mBinding.profileShareText.setOnClickListener {
            shareApp()
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
    private fun shareApp() {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, getString(R.string.shareDescription))
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }
}