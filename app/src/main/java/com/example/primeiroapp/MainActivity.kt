package com.example.primeiroapp
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.primeiroapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        binding.bottomNav.setOnItemSelectedListener{ item ->
            when(item.itemId){
                R.id.id_home -> replaceFragment(HomeFragment())
                R.id.id_users -> replaceFragment(UsersFragment())
                R.id.id_products -> replaceFragment(ProductsFragment())
            }
        }

    }
    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, fragment).commit()
    }

}