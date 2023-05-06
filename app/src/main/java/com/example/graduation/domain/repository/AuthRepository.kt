package com.example.graduation.domain.repository

import com.example.graduation.data.models.MainResponseModel
import com.example.graduation.data.models.postbody.ChangePasswordBody
import com.example.graduation.data.models.postbody.ForgetPasswordBody
import com.example.graduation.data.models.postbody.ForgetPasswordCheckCodeBody
import com.example.graduation.data.models.postbody.ResetPasswordBody
import com.example.graduation.data.models.response.auth.ChangePasswordResponse
import com.example.graduation.data.models.response.auth.DeleteAccountResponse
import com.example.graduation.data.models.response.auth.ForgetPasswordResponse
import com.example.graduation.data.models.response.auth.ForgetPasswordRestResponse
import com.example.graduation.data.models.response.auth.IntroVideoResponse
import com.example.graduation.data.models.response.auth.NewPasswordResponse
import retrofit2.Response


interface AuthRepository {

    suspend fun getIntroVideo(): Response<MainResponseModel<IntroVideoResponse>>

    suspend fun deleteAccount(): Response<MainResponseModel<DeleteAccountResponse>>

    suspend fun changePassword( changePasswordBody: ChangePasswordBody): Response<MainResponseModel<ChangePasswordResponse>>

    suspend fun forgetPassword( forgetPasswordBody: ForgetPasswordBody): Response<MainResponseModel<ForgetPasswordResponse>>

    suspend fun forgetPasswordCheckCode( forgetPasswordCheckCodeBody: ForgetPasswordCheckCodeBody): Response<MainResponseModel<ForgetPasswordRestResponse>>



    suspend fun resetPassword( resetPasswordBody: ResetPasswordBody): Response<MainResponseModel<NewPasswordResponse>>

}