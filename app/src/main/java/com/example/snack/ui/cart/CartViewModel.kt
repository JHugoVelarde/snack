package com.example.snack.ui.cart

import androidx.lifecycle.ViewModel
import com.example.snack.data.FakeSnackData
import com.example.snack.data.OrderLine
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor() : ViewModel() {
    // Estado inicial simulado con productos en el carrito
    private val _orderLines = MutableStateFlow(
        listOf(
            OrderLine(FakeSnackData.snacks[0], 2),
            OrderLine(FakeSnackData.snacks[1], 1)
        )
    )
    val orderLines: StateFlow<List<OrderLine>> = _orderLines.asStateFlow()

    fun increaseSnackCount(snackId: Long) {
        _orderLines.update { lines ->
            lines.map { if (it.snack.id == snackId) it.copy(count = it.count + 1) else it }
        }
    }

    fun decreaseSnackCount(snackId: Long) {
        _orderLines.update { lines ->
            lines.map { if (it.snack.id == snackId && it.count > 1) it.copy(count = it.count - 1) else it }
        }
    }

    fun removeSnack(snackId: Long) {
        _orderLines.update { lines -> lines.filterNot { it.snack.id == snackId } }
    }

    fun clearCart() {
        _orderLines.value = emptyList()
    }
}