package dev.rendrap.app.movienight

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.ApplicationProductFlavor
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.ProductFlavor

enum class FlavorDimension {
    STAGE
}

enum class Flavor(val dimension: FlavorDimension, val applicationIdSuffix: String? = null) {
    DEV(FlavorDimension.STAGE, applicationIdSuffix = ".dev"),
    STAGING(FlavorDimension.STAGE, applicationIdSuffix = ".staging"),
    UAT(FlavorDimension.STAGE, applicationIdSuffix = ".uat"),
    PROD(FlavorDimension.STAGE)
}

fun configureFlavors(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
    flavorConfigurationBlock: ProductFlavor.(flavor: Flavor) -> Unit = {}
) {
    commonExtension.apply {
        flavorDimensions += FlavorDimension.STAGE.name
        productFlavors {
            Flavor.values().forEach {
                create(it.name.lowercase()) {
                    dimension = it.dimension.name
                    flavorConfigurationBlock(this, it)
                    if (this@apply is ApplicationExtension && this is ApplicationProductFlavor) {
                        if (it.applicationIdSuffix != null) {
                            applicationIdSuffix = it.applicationIdSuffix
                        }
                    }
                }
            }
        }
    }
}