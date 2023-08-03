package com.example.webviewinscrollviewsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class CollectionFragment : Fragment() {
    private lateinit var collectionPagerAdapter: CollectionPagerAdapter
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_collection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        collectionPagerAdapter = CollectionPagerAdapter(childFragmentManager)
        viewPager = view.findViewById(R.id.pager)
        viewPager.adapter = collectionPagerAdapter
        tabLayout = view.findViewById(R.id.tab_layout)
        tabLayout.setupWithViewPager(viewPager)
    }

    class CollectionPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        override fun getCount(): Int = 4

        override fun getItem(i: Int): Fragment {
            val fragment = CollectionObjectFragment()
            fragment.arguments = Bundle().apply {
                putInt(ARG_OBJECT, i + 1)
            }
            return fragment
        }

        override fun getPageTitle(position: Int): CharSequence {
            return "OBJECT ${(position + 1)}"
        }
    }

    companion object {
        const val ARG_OBJECT = "object"
    }
}
