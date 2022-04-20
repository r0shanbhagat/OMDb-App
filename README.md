 
## Introduction      
This application is a simple implementation of the popular images feature of 500px which using the [500px API](https://github.com/500px/legacy-api-documentation) built using modern Android development strategies focusing on the following key aspects:     
- Code structuring as per clean Architecture      
- Using MVVM Pattern as per Google's recommendation      
- Android Architecture Components (LiveData, ViewModel, Navigation)        
- Kotlin features (Lambdas, Extension functions, typealias, sealed class and Coroutines)        
    
## App Overview      
 The app features a 2 screen navigation      
      
- List screen displaying popular images in a paginated fashion      
         
   <img alt="Popular Images List" height="250px" src="https://raw.githubusercontent.com/prasannajeet/500px-clone-app/master/List_Screen.png" />      
         
- Details screen showing the details of the image on click on the image in the list screen      
      
    <img alt="Image Details" height="250px" src="https://raw.githubusercontent.com/prasannajeet/500px-clone-app/master/Details_Screen.png" />      
    
Navigation between the screens has been done using the Jetpack Navigation library and the following is its nav graph:    
    
<img alt="Nav Graph" height="250px" src="https://raw.githubusercontent.com/prasannajeet/500px-clone-app/master/Navigation_Graph.png" />      
      
## Libraries The App uses libraries and tools used to build Modern Android application, mainly part of Android Jetpack 
- [Kotlin](https://kotlinlang.org/) first
- [Clean Architecture](https://pub.dev/documentation/flutter_clean_architecture/latest/) for unit testing
- [Coroutines Flow API](https://kotlinlang.org/docs/reference/coroutines/flow.html)
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture)
- [Android desugaring for Java 8+ APIs](https://developer.android.com/studio/write/java8-support#library-desugaring)
- [Retrofit](https://square.github.io/retrofit/)
- [Moshi](https://github.com/square/moshi)
- [Picasso](https://square.github.io/picasso/)
- [Hilt](https://dagger.dev/hilt/) for dependency injection
- [Android KTX](https://developer.android.com/kotlin/ktx) features
- [MockK](https://mockk.io/) for unit testing

### Scope for Improvements        
 The app can be further improved with the addition of the following features
- Dynamic image sizes using multiple ViewHolders for different image sizes instead of current GridLayoutManager implementation  
- Espresso Tests

#Notes
Create a separate branch without Usecase ,Take these reference with stateFlow
https://github.com/prasannajeet/kotlin-mvvm-hilt-flow-app
https://github.com/inspire-coding/OMDB_MVVM_KotlinFlow_DaggerHilt_Retrofit_MotionLayout
https://github.com/android/sunflower
https://developer.android.com/kotlin/flow
https://developer.android.com/jetpack/guide/data-layer#architecture
https://developer.android.com/kotlin/coroutines/coroutines-best-practices#coroutines-data-layer

https://blog.mindorks.com/stateflow-apis-in-kotlin
https://logidots.com/insights/live-data-flow-shared-flow-state-flow-2/#:~:text=StateFlow%20requires%20an%20initial%20state,does%20not%20stop%20collecting%20automatically.
https://developer.android.com/jetpack/guide/ui-layer#views

https://medium.com/androiddevelopers/coroutines-patterns-for-work-that-shouldnt-be-cancelled-e26c40f142ad
https://www.geeksforgeeks.org/android-coding-style-and-guidelines/

