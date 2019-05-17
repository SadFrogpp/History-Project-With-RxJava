package com.example.history_project_rxjava.util

import android.arch.lifecycle.Lifecycle

interface LifecycleCallback {
    fun apply(event: Lifecycle.Event)
}