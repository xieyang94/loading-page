# loading-page
init commit
Add it in your root build.gradle at the end of repositories:

allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
Add the dependency：

dependencies {
	        compile 'com.github.xieyang94:loading-page:1.0'
	}
  