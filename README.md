# 🍿 Snack App

![Kotlin](https://img.shields.io/badge/Kotlin-2.0+-blue.svg?logo=kotlin)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-Material%203-4285F4.svg?logo=android)
![Hilt](https://img.shields.io/badge/Dagger%20Hilt-DI-success.svg)

Esta es una réplica avanzada del proyecto **Jetsnack**, enfocada en dominar interfaces de usuario altamente personalizadas, **navegación anidada profunda** y la gestión de estados complejos en un flujo de carrito de compras real.

## 📱 Capturas de pantalla y video

| Pantalla 1 | Pantalla 2 | Pantalla 3 |
| :---: | :---: | :---: |
| <img src="/assets/scr01.jpg" width="250"/> | <img src="/assets/scr02.jpg" width="250"/> | <img src="/assets/scr03.jpg" width="250"/> |

| Pantalla 4 | Video |
| :---: | :---: |
| <img src="/assets/scr04.jpg" width="250"/> | <img src="/assets/vdo01.gif" width="250"/> |

## ✨ Características Principales

* **UI Orthogonal Compleja:** Implementación de un catálogo dinámico usando `LazyColumn` para secciones verticales que contienen `LazyRow` horizontales, permitiendo una navegación fluida por categorías.
* **Custom BottomBar:** Barra de navegación personalizada donde la pestaña activa se transforma en un **botón interactivo** con texto e icono, optimizando el espacio mediante pesos dinámicos.
* **Navegación de Doble Nivel:** Separación del grafo de navegación principal (Detail, Checkout) del grafo interno de pestañas (Feed, Search, Cart, Profile) para preservar el estado de scroll.
* **Manejo de Insets & Edge-to-Edge:** Solución al problema de "Doble Padding" y ajuste preciso del contenido para que conviva con la barra de estado y la barra de navegación del sistema.
* **Flujo de Checkout:** Implementación de lógica de negocio para gestionar el carrito (incrementar/decrementar/eliminar items) y un proceso de finalización de compra completo.

## 🛠️ Stack Tecnológico

| Herramienta | Propósito |
| :--- | :--- |
| **Kotlin 2.0.21** | Lenguaje moderno con compilador K2. |
| **Jetpack Compose** | UI declarativa basada en Material Design 3. |
| **Dagger Hilt** | Inyección de dependencias para ViewModels y Repositorios. |
| **Coil 3** | Carga asíncrona de imágenes con soporte para Kotlin Multiplatform. |
| **Navigation Compose** | Gestión de rutas tipadas y argumentos entre pantallas. |

## 📂 Estructura del Proyecto

```
com.example.tiendaapp
│
├── data/                       # Modelos de datos y fuentes ficticias
│   ├── Snack.kt                # Modelos y FakeSnackData (Colecciones)
│   ├── OrderLine.kt            # Modelo para el carrito de compras
│   └── User.kt                 # Datos del perfil de usuario
│
├── ui/                         # Capa de presentación
│   ├── components/             # Componentes visuales personalizados
│   │   ├── FeaturedSnackCard.kt # Tarjetas con degradados
│   │   ├── PopularSnackCircle.kt # Items circulares
│   │   └── TiendaBottomBar.kt  # BottomBar personalizada
│   │
│   ├── home/                   # Grafo anidado (Feed, Search, Cart, Profile)
│   ├── detail/                 # Pantalla de detalle de producto
│   ├── checkout/               # Flujo de confirmación de pago
│   └── TiendaApp.kt            # Orquestador del NavHost raíz
│
└── MainActivity.kt             # Configuración de Edge-to-Edge y Hilt
```

## 🚀 Lecciones de Ingeniería
Pro-Tip: El uso de WindowInsets(0, 0, 0, 0) en el TopAppBar es vital cuando se anidan Scaffolds. Esto evita que el sistema aplique dos veces el margen de la barra de estado, eliminando espacios en blanco innecesarios en la parte superior.

## 🛠️ Instalación
- Clona el repositorio.
- Asegúrate de tener instalada la última versión de Android Studio (Ladybug o superior).
- Sincroniza el proyecto con Gradle para descargar las dependencias.
- Ejecuta la app en un emulador con Android 13 (API 33) o superior para visualizar correctamente los efectos de transparencia en las barras del sistema.

## 📝 Notas de Versión
- v1.0: Estructura básica de Feed y detalle.
- v1.1: Integración de Carrito y ViewModel de Hilt.
- v1.2 (Final): Corrección de Insets superiores y rediseño de BottomBar interactiva.

## 📄 Licencia
Este proyecto está licenciado bajo la Licencia Apache 2.0 - consulta el archivo [LICENSE](LICENSE) para más detalles.
