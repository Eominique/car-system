package com.model

import java.math.BigDecimal
import com.enum.Color
import lombok.Builder


@Builder
data class Car(var model: String?,
               var price: BigDecimal?,
               var color: Color?,
               var mileage: Double = 0.0,
               var components: Set<String>?) {



}


