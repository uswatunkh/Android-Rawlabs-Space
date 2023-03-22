package com.example.androidrawlabspace.rawlabspace.screen.fragment

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidrawlabspace.R
import com.example.androidrawlabspace.databinding.FragmentHomeBinding
import com.example.androidrawlabspace.databinding.FragmentSearchBinding
import com.example.androidrawlabspace.databinding.SelectAddressBinding
import com.example.androidrawlabspace.rawlabspace.shared.ui.SearchAdapter
import com.example.androidrawlabspace.rawlabspace.shared.ui.SearchItem

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentSearch : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var binding: FragmentHomeBinding
    private lateinit var recyclerView : RecyclerView
    private lateinit var searchlist : ArrayList<SearchItem>
    private lateinit var searchAdapter: SearchAdapter

    lateinit var frag : FragmentHome



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_search, container, false)
        binding = FragmentHomeBinding.bind(
            inflater.inflate(
                R.layout.fragment_home ,
                container,
                false
            )
        )




        showDialogSearch()
        return binding.root

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Home.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentSearch().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    fun showDialogSearch() {

        val dialog = context?.let { Dialog(it) }
        val binding2 = SelectAddressBinding.bind(layoutInflater.inflate(R.layout.select_address, null))

        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.setContentView(binding2.root)

        dialog?.show()
        dialog?.getWindow()

        //dialog.window?.clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM)
        dialog?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        //dialog?.setCanceledOnTouchOutside(false);
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,1500);

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        dialog?.window?.getAttributes()?.windowAnimations = R.style.DialogAnimation;
        dialog?.window?.setGravity(Gravity.BOTTOM);
        binding2.idedit.hint = "Street, address"

        //recyclerView = findViewById(R.id.recycler)
        binding2.recycler.setHasFixedSize(true)
        binding2.recycler.layoutManager = LinearLayoutManager(context)

        searchlist = ArrayList()

        searchlist.add(SearchItem("Ruang Kerja","Ruko Dr. Sardjito, Terban, Gondokusuman"))
        searchlist.add(SearchItem("Kolektif Collaboration Space","Jl Watugede 58 Wonorejo, Sariharjo, Ngaglik, Sleman"))
        searchlist.add(SearchItem("Srawung Galih","Jalan Brigjen Katamso, Keparakan, Kecamatan Mergangsan, Jogja"))
        searchlist.add(SearchItem("Ruang Kerja","Ruko Dr. Sardjito, Terban, Gondokusuman"))
        searchlist.add(SearchItem("Kolektif Collaboration Space","Jl Watugede 58 Wonorejo, Sariharjo, Ngaglik, Sleman"))
        searchlist.add(SearchItem("Srawung Galih","Jalan Brigjen Katamso, Keparakan, Kecamatan Mergangsan, Jogja"))
        searchlist.add(SearchItem("Ruang Kerja","Ruko Dr. Sardjito, Terban, Gondokusuman"))
        searchlist.add(SearchItem("Kolektif Collaboration Space","Jl Watugede 58 Wonorejo, Sariharjo, Ngaglik, Sleman"))
        searchlist.add(SearchItem("Srawung Galih","Jalan Brigjen Katamso, Keparakan, Kecamatan Mergangsan, Jogja"))

        searchAdapter = SearchAdapter(searchlist)
        binding2.recycler.adapter = searchAdapter


    }


}

