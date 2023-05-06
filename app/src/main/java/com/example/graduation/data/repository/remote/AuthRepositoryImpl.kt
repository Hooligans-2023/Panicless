package com.example.graduation.data.repository.remote

import com.example.graduation.data.apiservice.AuthService
import com.example.graduation.data.models.MainResponseModel
import com.example.graduation.domain.repository.AuthRepository
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
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api: AuthService
) : AuthRepository {

    override suspend fun getIntroVideo(): Response<MainResponseModel<IntroVideoResponse>> =
        api.getIntroVideo()

    override suspend fun deleteAccount(): Response<MainResponseModel<DeleteAccountResponse>> =
        api.deleteAccount()

    override suspend fun changePassword(changePasswordBody: ChangePasswordBody): Response<MainResponseModel<ChangePasswordResponse>> =
        api.changePassword(changePasswordBody)

    override suspend fun forgetPassword(forgetPasswordBody: ForgetPasswordBody): Response<MainResponseModel<ForgetPasswordResponse>> =
        api.forgetPassword(forgetPasswordBody)

    override suspend fun forgetPasswordCheckCode(forgetPasswordCheckCodeBody: ForgetPasswordCheckCodeBody)
            : Response<MainResponseModel<ForgetPasswordRestResponse>> =
        api.forgetPasswordCheckCode(forgetPasswordCheckCodeBody)

    override suspend fun resetPassword(resetPasswordBody: ResetPasswordBody): Response<MainResponseModel<NewPasswordResponse>> =
        api.resetPassword(resetPasswordBody)


}