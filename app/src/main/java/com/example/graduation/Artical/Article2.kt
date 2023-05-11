import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.graduation.R
import com.example.graduation.databinding.FragmentArtical2Binding

class Article2 : Fragment() {

    private val binding by lazy {
        FragmentArtical2Binding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding.toolbar.setOnClickListener {
            findNavController().navigate(R.id.action_artical2_to_home)
        }
        return binding.root
    }

}