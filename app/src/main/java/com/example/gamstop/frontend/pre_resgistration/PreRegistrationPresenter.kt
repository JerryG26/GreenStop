package com.example.gamstop.frontend.pre_resgistration

import com.example.gamstop.backend.UserPhysicalData

class PreRegistrationPresenter(
    private var view: PreRegistrationContract.View?
) : PreRegistrationContract.Presenter {

    override fun submitUserData(bodyType: String, heightStr: String, weightStr: String, ageStr: String) {
        view?.showLoading()

        val height = heightStr.toFloatOrNull()
        val weight = weightStr.toFloatOrNull()
        val age = ageStr.toIntOrNull()

        if (height == null || height <= 0) {
            view?.hideLoading()
            view?.showValidationError("Please enter a valid height.")
            return
        }
        if (weight == null || weight <= 0) {
            view?.hideLoading()
            view?.showValidationError("Please enter a valid weight.")
            return
        }
        if (age == null || age <= 0) {
            view?.hideLoading()
            view?.showValidationError("Please enter a valid age.")
            return
        }

        // Utilizing the model from your backend package
        val userData = UserPhysicalData(bodyType, height, weight, age)

        saveDataToRepository(userData)

        view?.hideLoading()
        view?.navigateToNextScreen()
    }

    private fun saveDataToRepository(data: UserPhysicalData) {
        // Ready for your backend logic implementation
        println("Saving data: $data")
    }

    override fun onDestroy() {
        view = null
    }
}