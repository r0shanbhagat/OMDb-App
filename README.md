 
## Introduction      
This application is a simple implementation of the popular images feature of 500px which using the [500px API](https://github.com/500px/legacy-api-documentation) built using modern Android development strategies focusing on the following key aspects:     
- Code structuring as per clean Architecture      
- Using MVVM/MVI Pattern as per Google's recommendation      
- Android Architecture Components (LiveData, ViewModel, Navigation)        
- Kotlin features (Lambdas, Extension functions, typealias, sealed class and Coroutines)        
    
## App Overview      
      
1.Search the Movie </br>
2.Show the List of Suggested Movie </br>
3.Show the Detail on Tapping of any List.</br>

<img alt="Popular Images List" height="250px" width="110px" src="https://user-images.githubusercontent.com/22414106/168663851-a97c962e-3f59-4a4a-8a8a-866fa2ea40c2.png" > <img alt="Popular Images List" height="250px" width="110px" src="https://user-images.githubusercontent.com/22414106/168663865-0ec95b5e-520e-4508-a4ff-07db7f41200e.png" >  <img alt="Popular Images List" height="250px" width="110px" src="https://user-images.githubusercontent.com/22414106/168663919-c9b11f6b-befd-40b4-98e0-4f8d95fd077a.png" >  <img alt="Popular Images List" height="250px" width="110px" src="https://user-images.githubusercontent.com/22414106/168663925-dc5020ad-dcf1-4d7e-b479-581c28f49ef0.png" > 
         
    
Navigation between the screens has been done using the Jetpack Navigation library and the following is its nav graph:    

      
## Libraries The App uses libraries and tools used to build Modern Android application, mainly part of Android Jetpack 
- [Kotlin](https://kotlinlang.org/) first
- [Clean Architecture](https://pub.dev/documentation/flutter_clean_architecture/latest/) 
- [Coroutines Flow API](https://kotlinlang.org/docs/reference/coroutines/flow.html)
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture)
- [Retrofit](https://square.github.io/retrofit/) for Networking
- [Glide](https://github.com/bumptech/glide) for image loading
- [Hilt](https://dagger.dev/hilt/) for dependency injection
- [Android KTX](https://developer.android.com/kotlin/ktx) features
- [MockK](https://mockk.io/) for unit testing


### Scope for Improvements        
 The app can be further improved with the addition of the following features
- Unit Test cases
- Adding Level 2 implementation

