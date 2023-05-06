package com.example.graduation.data.models

import com.google.gson.annotations.SerializedName


data class UploadFileResponse(

	@field:SerializedName("file")
	val file: File? = null,

	@field:SerializedName("collection")
	val collection: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class File(

	@field:SerializedName("extension")
	val extension: String? = null,

	@field:SerializedName("size")
	val size: Int? = null,

	@field:SerializedName("mime_type")
	val mimeType: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("uuid")
	val uuid: String? = null,

	@field:SerializedName("collection_name")
	val collectionName: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)
