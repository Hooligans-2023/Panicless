package com.example.graduation.data.models.response.subscriptions.payment

import com.google.gson.annotations.SerializedName

data class PaymentResponse(

	@field:SerializedName("IsSuccess")
	val isSuccess: Boolean? = null,

	@field:SerializedName("Message")
	val message: String? = null,

	@field:SerializedName("ValidationErrors")
	val validationErrors: Any? = null,

	@field:SerializedName("Data")
	val data: PaymentModel? = null
)

data class PaymentModel(

	@field:SerializedName("CustomerReference")
	val customerReference: Any? = null,

	@field:SerializedName("UserDefinedField")
	val userDefinedField: Any? = null,

	@field:SerializedName("InvoiceURL")
	val invoiceURL: String? = null,

	@field:SerializedName("InvoiceId")
	val invoiceId: Int? = null
)
