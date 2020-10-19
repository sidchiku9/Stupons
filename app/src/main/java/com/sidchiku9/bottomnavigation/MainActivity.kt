package com.sidchiku9.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstfragment = FirstGragment()
        val secondfragment = SecondFragment()
        val thirdfragment = ThirdFragment()
        //val fourthfragment = FourthFragment()
        //just testing
        val fifthfragment = FifthFragment()

        setCurrentFragment(firstfragment)

        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.pageOne -> setCurrentFragment(firstfragment)
                R.id.pageTwo -> setCurrentFragment(secondfragment)
                R.id.pageThree -> setCurrentFragment(thirdfragment)
                //R.id.pageFour -> setCurrentFragment(fourthfragment)
                R.id.pageFive -> setCurrentFragment(fifthfragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment : Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, fragment)
            commit()
        }
}