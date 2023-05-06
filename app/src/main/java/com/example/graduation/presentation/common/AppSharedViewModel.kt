package com.example.graduation.presentation.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.example.graduation.data.models.common.AddressModel
import com.example.graduation.data.models.common.OrderModel
import com.example.graduation.data.models.response.subscriptions.SubscriptionModel
import com.example.graduation.data.models.response.subscriptions.payment.PaymentModel

class AppSharedViewModel : ViewModel() {

    private var _userName = MutableStateFlow<String?>(null)
    val userName = _userName.asStateFlow()
    private var _userImage = MutableStateFlow<String?>(null)
    val userImage = _userImage.asStateFlow()
    private var _isLogin = MutableStateFlow<Boolean?>(null)
    val isLogin = _isLogin.asStateFlow()

    private var _categoryId = MutableStateFlow<Int?>(null)
    val categoryId = _categoryId.asStateFlow()
    private var _storeId = MutableStateFlow<Int?>(null)
    val storeId = _storeId.asStateFlow()
    private var _blogId = MutableStateFlow<Int?>(null)
    val blogId = _blogId.asStateFlow()

    private var _productId = MutableStateFlow<Int?>(null)
    val productId = _productId.asStateFlow()

    private var _searchQuery = MutableSharedFlow<String?>()
    val searchQuery  = _searchQuery.asSharedFlow()

    private var _address = MutableStateFlow<AddressModel?>(null)
    val address  = _address.asStateFlow()

    private var _order = MutableStateFlow<OrderModel?>(null)
    val order  = _order.asStateFlow()

    private var _subscriptionModel = MutableStateFlow<SubscriptionModel?>(null)
    val subscriptionModel  = _subscriptionModel.asStateFlow()

    private var _paymentModel = MutableStateFlow<PaymentModel?>(null)
    val paymentModel  = _paymentModel.asStateFlow()



    fun setUserName(name: String?) {
        viewModelScope.launch { _userName.emit(name) }
    }

    fun setUserImage(image: String?) {
        viewModelScope.launch { _userImage.emit(image) }
    }

    fun setLoginState(isLogin: Boolean?) {
        _isLogin.value = isLogin
    }


    fun setCategoryId(id: Int?) {
        viewModelScope.launch { _categoryId.emit(id) }
    }

    fun setStoreId(id: Int?) {
        viewModelScope.launch { _storeId.emit(id) }
    }

    fun setBlogId(id: Int?) {
        viewModelScope.launch { _blogId.emit(id) }
    }

    fun setSearchQuery(query: String?) {
        viewModelScope.launch {  _searchQuery.emit( query)}
    }

    fun setProductId(id: Int?) {
        _productId.value = id
    }

    fun setAddress(address:AddressModel) {
        _address.value = address
    }

    fun setOrder(orderModel: OrderModel) {
        _order.value = orderModel
    }

    fun setSubscription(subscriptionModel: SubscriptionModel) {
        _subscriptionModel.value = subscriptionModel
    }

    fun setPaymentModel(paymentModel: PaymentModel) {
        _paymentModel.value = paymentModel
    }

    fun clearAppData() {
        _userName.value = null
        _isLogin.value = null
        _userImage.value = null
        _categoryId.value = null
        _storeId.value = null
        _blogId.value = null
        _productId.value = null
        _order.value = null
        _subscriptionModel.value = null

    }

}