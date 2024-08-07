package com.example.fooddelivery.Fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.fooddelivery.Adapters.ImageSliderAdapter
import com.example.fooddelivery.Adapters.PopularFoodAdapter
import com.example.fooddelivery.Models.PopularModel
import com.example.fooddelivery.Models.SharedModel
import com.example.fooddelivery.R
import kotlin.math.abs

class HomeFragment : Fragment() {

    private lateinit var viewPager2: ViewPager2
    private lateinit var adapter: ImageSliderAdapter
    private lateinit var imageList: ArrayList<Int>
    private lateinit var handler: Handler
    private val runnable = Runnable {
        viewPager2.currentItem += 1
    }

    private lateinit var popularAdapter: PopularFoodAdapter
    private lateinit var listPopular: ArrayList<PopularModel>
    private lateinit var homeRV: RecyclerView

    private lateinit var goMenuText : TextView
    private lateinit var sharedModel: SharedModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        viewPager2 = view.findViewById(R.id.image_slider)

        sharedModel = ViewModelProvider(requireActivity()).get(SharedModel::class.java)

        goMenuText = view.findViewById(R.id.go_to_menu)
        goMenuText.setOnClickListener {
            val bottomMenu = MenuBottomFragment()
            bottomMenu.show(parentFragmentManager, "Test")
        }

        homeRV = view.findViewById(R.id.home_popular_menu_RV)
        listPopular = ArrayList()
        listPopular.add(PopularModel(R.drawable.pop_menu_burger, "Burger", "5$"))
        listPopular.add(PopularModel(R.drawable.pop_menu_sandwich, "Sandwich", "7$"))
        listPopular.add(PopularModel(R.drawable.pop_menu_momo, "Momo", "9$"))
        listPopular.add(PopularModel(R.drawable.pop_menu_burger, "Burger", "5$"))
        listPopular.add(PopularModel(R.drawable.pop_menu_sandwich, "Sandwich", "7$"))
        listPopular.add(PopularModel(R.drawable.pop_menu_momo, "Momo", "9$"))
        listPopular.add(PopularModel(R.drawable.pop_menu_burger, "Burger", "5$"))
        listPopular.add(PopularModel(R.drawable.pop_menu_sandwich, "Sandwich", "7$"))
        listPopular.add(PopularModel(R.drawable.pop_menu_momo, "Momo", "9$"))
        listPopular.add(PopularModel(R.drawable.pop_menu_burger, "Burger", "5$"))
        listPopular.add(PopularModel(R.drawable.pop_menu_sandwich, "Sandwich", "7$"))
        listPopular.add(PopularModel(R.drawable.pop_menu_momo, "Momo", "9$"))

        popularAdapter = PopularFoodAdapter(requireContext(), listPopular)
        popularAdapter.setSharedModel(sharedModel)
        homeRV.layoutManager = LinearLayoutManager(requireContext())
        homeRV.adapter = popularAdapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setTransformer()
        viewPager2.registerOnPageChangeCallback(object  : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 2000)
            }
        })
    }

    private fun setTransformer() { //чтоб экран показывал 3 image
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(10))
        transformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.14f
        }

        viewPager2.setPageTransformer(transformer)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable, 2000)
    }

    private fun init() {
        imageList = ArrayList()
        adapter = ImageSliderAdapter(requireContext(), imageList, viewPager2)
        handler = Handler(Looper.myLooper()!!)

        imageList.add(R.drawable.banner_1)
        imageList.add(R.drawable.banner_2)
        imageList.add(R.drawable.banner_3)
        imageList.add(R.drawable.banner_4)
        imageList.add(R.drawable.banner_5)
        imageList.add(R.drawable.banner_6)
        imageList.add(R.drawable.banner_7)
        imageList.add(R.drawable.banner_8)
        imageList.add(R.drawable.banner_9)
        imageList.add(R.drawable.banner_10)
        imageList.add(R.drawable.banner_11)
        imageList.add(R.drawable.banner_12)

        viewPager2.adapter = adapter
        viewPager2.offscreenPageLimit = 3
        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
    }
}