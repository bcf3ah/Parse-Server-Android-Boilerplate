# Parse-Server-Android-Boilerplate
This is the boilerplate for connecting to a Parse Server set up on an EC2 instance, assuming you have already launched one. This boilerplate should save a SolarSystem class with a few basic fields in it, which you can view in your Parse Dashboard

# Key Steps
1. Include compile 'com.parse:parse-android:1.15.7' in your build.gradle dependencies (or the latest version)

2. Create a new class that extends Application to initialize your Parse Server connection. For this, you'll need your app id, client/master key, and server url + "/", all of which you can get by connecting to your EC2 instance via SSH (I used Putty on Windows).

3. In your AndroidManifest.xml file, make sure you include android:name=".App" under <application>, NOT <activity>

4. Check out [this link](http://docs.parseplatform.org/android/guide/) to the Parse Android docs for more info and for ParseObject methods. Enjoy!
