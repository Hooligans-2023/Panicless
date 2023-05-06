package com.example.graduation.domain.repository

import com.example.graduation.data.models.MainResponseModel
import com.example.graduation.data.models.postbody.ChangePasswordBody
import com.example.graduation.data.models.postbody.ForgetPasswordBody
import com.example.graduation.data.models.postbody.ForgetPasswordCheckCodeBody
import com.example.graduation.data.models.postbody.LoginBody
import com.example.graduation.data.models.postbody.RegisterBody
import com.example.graduation.data.models.postbody.ResetPasswordBody
import com.example.graduation.data.models.response.auth.ChangePasswordResponse
import com.example.graduation.data.models.response.auth.DeleteAccountResponse
import com.example.graduation.data.models.response.auth.ForgetPasswordResponse
import com.example.graduation.data.models.response.auth.ForgetPasswordRestResponse
import com.example.graduation.data.models.response.auth.IntroVideoResponse
import com.example.graduation.data.models.response.auth.LoginResponse
import com.example.graduation.data.models.response.auth.NewPasswordResponse
import com.example.graduation.data.models.response.auth.RegisterResponse
import retrofit2.Response


interface AuthRepository {

    suspend fun getIntroVideo(): Response<MainResponseModel<IntroVideoResponse>>

    suspend fun deleteAccount(): Response<MainResponseModel<DeleteAccountResponse>>

    suspend fun changePassword( changePasswordBody: ChangePasswordBody): Response<MainResponseModel<ChangePasswordResponse>>

    suspend fun forgetPassword( forgetPasswordBody: ForgetPasswordBody): Response<MainResponseModel<ForgetPasswordResponse>>

    suspend fun forgetPasswordCheckCode( forgetPasswordCheckCodeBody: ForgetPasswordCheckCodeBody): Response<MainResponseModel<ForgetPasswordRestResponse>>
    suspend fun register( registerBody: RegisterBody): Response<MainResponseModel<RegisterResponse>>
    suspend fun login( loginBody: LoginBody): Response<MainResponseModel<LoginResponse>>



    suspend fun resetPassword( resetPasswordBody: ResetPasswordBody): Response<MainResponseModel<NewPasswordResponse>>

}