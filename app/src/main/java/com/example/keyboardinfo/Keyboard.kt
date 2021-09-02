package com.example.keyboardinfo


data class Keyboard(
    var name: String = "",
    var subTitle: String = "",
    var desc: String = "",
    var photoUrl: Int = 0,
    var spec: Spec = Spec()
)

data class Spec(
    var productNumber: String = "",
    var structure: String = "",
    var triggerSwitch: String = "",
    var connectionInterface: String = "",
    var keycapMaterial: String = "",
    var output_number: String = "",
    var dimensions: String = "",
    var origin: String = ""
)




