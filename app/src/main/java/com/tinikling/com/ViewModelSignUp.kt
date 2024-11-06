package com.tinikling.com

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tinikling.com.dao.UserDao
import com.tinikling.com.database.TiniklingDatabase
import com.tinikling.com.table.User
import kotlinx.coroutines.launch

class ViewModelSignUp (context: Context) : ViewModel() {
    private lateinit var userDao: UserDao

    init {
        val database = TiniklingDatabase(context)
        userDao = database.getUser()

    }
    fun insertUser(user: User) {
        viewModelScope.launch {
            userDao.insertUser(user)
        }
    }
}