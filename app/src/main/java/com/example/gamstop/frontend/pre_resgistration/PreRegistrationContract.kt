package com.example.gamstop.frontend.pre_resgistration

interface PreRegistrationContract {
    interface View {
        fun showLoading()
        fun hideLoading()
        fun showValidationError(message: String)
        fun navigateToNextScreen()
    }

    interface Presenter {
        fun submitUserData(bodyType: String, heightStr: String, weightStr: String, ageStr: String)
        fun onDestroy()
    }
}