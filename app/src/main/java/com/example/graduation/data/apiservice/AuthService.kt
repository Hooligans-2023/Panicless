package com.example.graduation.data.apiservice

import com.example.graduation.data.models.MainResponseModel
import com.example.graduation.data.models.postbody.LoginBody
import com.example.graduation.data.models.response.auth.LoginResponse
import com.example.graduation.data.models.postbody.ChangePasswordBody
import com.example.graduation.data.models.postbody.ForgetPasswordBody
import com.example.graduation.data.models.postbody.ForgetPasswordCheckCodeBody
import com.example.graduation.data.models.postbody.RegisterBody
import com.example.graduation.data.models.postbody.ResetPasswordBody
import com.example.graduation.data.models.postbody.SubmitRegisterBody
import com.example.graduation.data.models.response.auth.ChangePasswordResponse
import com.example.graduation.data.models.response.auth.DeleteAccountResponse
import com.example.graduation.data.models.response.auth.ForgetPasswordResponse
import com.example.graduation.data.models.response.auth.ForgetPasswordRestResponse
import com.example.graduation.data.models.response.auth.IntroVideoResponse
import com.example.graduation.data.models.response.auth.NewPasswordResponse
import com.example.graduation.data.models.response.auth.RegisterResponse
import com.example.graduation.data.models.response.auth.VerificationCodeResponse
import retrofit2.Response
import retrofit2.http.*
import retrofit2.http.Body


interface AuthService {


    @POST("account/users/")
    suspend fun register(
        @Body registerBody: RegisterBody
    ): Response<RegisterResponse>

    @POST("account/login/")
    suspend fun login(
        @Body loginBody: LoginBody
    ): Response<LoginResponse>

    @POST("client/register/submit")
    suspend fun submitRegister(
        @Body submitRegisterBody: SubmitRegisterBody
    ): Response<MainResponseModel<VerificationCodeResponse>>

    @GET("client/register/video")
    suspend fun getIntroVideo(): Response<MainResponseModel<IntroVideoResponse>>

    @DELETE("client/auth/delete-account")
    suspend fun deleteAccount(): Response<MainResponseModel<DeleteAccountResponse>>

    @POST("client/auth/change-password")
    suspend fun changePassword(@Body changePasswordBody: ChangePasswordBody): Response<MainResponseModel<ChangePasswordResponse>>


    @POST("client/auth/forgot-password")
    suspend fun forgetPassword(@Body forgetPasswordBody: ForgetPasswordBody): Response<MainResponseModel<ForgetPasswordResponse>>

    @POST("client/auth/check-code")
    suspend fun forgetPasswordCheckCode(@Body forgetPasswordCheckCodeBody: ForgetPasswordCheckCodeBody):
            Response<MainResponseModel<ForgetPasswordRestResponse>>

    @POST("client/auth/reset-password")
    suspend fun resetPassword(@Body resetPasswordBody: ResetPasswordBody): Response<MainResponseModel<NewPasswordResponse>>

}