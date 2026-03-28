package com.example.snack.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.snack.ui.home.HomeSections
import kotlin.collections.forEach

@Composable
fun TiendaBottomBar(
    tabs: Array<HomeSections>,
    currentRoute: String,
    navigateToRoute: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        color = Color(0xFF3D27E5), // El azul fuerte del diseño
        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp), // Esquinas superiores
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp).height(64.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            tabs.forEach { section ->
                val selected = currentRoute == section.route
                val weight = if (selected) 2f else 1f

                // Un Box para cada pestaña, con diseño especial si está seleccionado
                Box(
                    modifier = Modifier
                        .weight(weight)
                        .clip(CircleShape)
                        .clickable { navigateToRoute(section.route) }
                        .padding(vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    if (selected) {
                        // DISEÑO ESPECIAL: "Botón" blanco con icono y texto
                        Surface(
                            color = Color.White,
                            shape = RoundedCornerShape(16.dp), // Esquinas menos redondeadas
                            modifier = Modifier.fillMaxHeight()
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Icon(section.icon, contentDescription = null, tint = Color(0xFF3D27E5))
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = section.title.uppercase(),
                                    style = MaterialTheme.typography.labelLarge,
                                    color = Color(0xFF3D27E5),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                    } else {
                        // DISEÑO ESTÁNDAR: Solo el icono
                        Icon(section.icon, contentDescription = section.title, tint = Color.White.copy(alpha = 0.7f))
                    }
                }
            }
        }
    }
}