package com.satriopndt.kicawcapstone.repository

import androidx.lifecycle.liveData
import com.google.gson.Gson
import com.satriopndt.kicawcapstone.data.retrofit.ApiService
import com.satriopndt.kicawcapstone.data.UserModel
import com.satriopndt.kicawcapstone.data.pref.UserPreferences
import com.satriopndt.kicawcapstone.data.response.Login
import com.satriopndt.kicawcapstone.data.response.LoginResponse
import com.satriopndt.kicawcapstone.data.response.Register
import com.satriopndt.kicawcapstone.data.response.RegisterResponse
import com.satriopndt.kicawcapstone.model.FakeDataBird
import com.satriopndt.kicawcapstone.model.FakeDataForum
import com.satriopndt.kicawcapstone.model.ForumModel
import com.satriopndt.kicawcapstone.model.KicawModel
import com.satriopndt.kicawcapstone.model.OrderBird
import com.satriopndt.kicawcapstone.ui.helper.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import retrofit2.HttpException

class KicawRepository(
    private val userPreferences: UserPreferences,
    private val apiService: ApiService,
) {

    private val historyBird = mutableListOf<OrderBird>()


    suspend fun saveSession(userModel: UserModel){
        userPreferences.saveSession(userModel)
    }

    fun getSession(): Flow<UserModel>{
        return userPreferences.getSession()
    }

    suspend fun logout(){
        userPreferences.logout()
    }
    fun getBirdies(): List<KicawModel> {
        return FakeDataBird.dummyBird
    }

    fun getHistory(): List<KicawModel> {
        return FakeDataBird.dummyBird
    }

    fun getForum(): List<ForumModel> {
        return FakeDataForum.dummyForum
    }

    fun searchBird(query: String): List<KicawModel> {
        return FakeDataBird.dummyBird.filter {
            it.name.contains(query, ignoreCase = false)
        }
    }

    fun searchForum(query: String): List<ForumModel>{
        return FakeDataForum.dummyForum.filter {
            it.title.contains(query, ignoreCase = false)
        }
    }

    fun getAll(): Flow<List<OrderBird>> {
        return flowOf(historyBird)
    }

    suspend fun login(email: String, password: String) = liveData {
        emit(UiState.Loading)
        try {
            val login = Login(email, password)
            val successResponse = apiService.login(login)
            emit(UiState.Success(successResponse))
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            val errorResponse = Gson().fromJson(errorBody, LoginResponse::class.java)
            emit(UiState.Error(errorResponse.toString()))
        } catch (e: Exception) {
            emit(UiState.Error("Error : ${e.message.toString()}"))
        }
    }

    suspend fun register(name: String, username: String, email: String, password: String) = liveData {
        emit(UiState.Loading)
        try {
            val register = Register(name, username, email, password)
            val successResponse = apiService.register(register)
            emit(UiState.Success(successResponse))
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            val errorResponse = Gson().fromJson(errorBody, RegisterResponse::class.java)
            emit(UiState.Error(errorResponse.toString()))
        } catch (e: Exception) {
            emit(UiState.Error("Error : ${e.message.toString()}"))
        }

    }

    companion object {
        @Volatile
        private var instance: KicawRepository? = null

        fun getInstance(
            userPreferences: UserPreferences,
            apiService: ApiService
        ): KicawRepository =
            instance ?: synchronized(this) {
                instance?: KicawRepository(userPreferences, apiService)
            }.also { instance = it }
    }

}