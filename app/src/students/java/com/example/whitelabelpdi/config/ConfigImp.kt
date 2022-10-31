package com.example.whitelabelpdi.config

import javax.inject.Inject

class ConfigImp @Inject constructor(): Config {
    override val isTeachers: Boolean
        get() = false
}