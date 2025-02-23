package org.example

fun doLec2Codes() {
    /**Operators and special symbols with their shortcuts
     * https://kotlinlang.org/docs/keyword-reference.html#operators-and-special-symbols
     **/
    "%" //Modulus المُعامِل is still unknown to me
    "&&" // Does meaning "And" in Logic operation Mandatory. +
    // By the way there's no concat symbol in kotlin, but just input them together.
    "||" // Does meaning "Or" in Logic operation Optionality
    "!" // Does meaning "Not" in general Logic operation
    "+=, -=, *=, /=, %=" // Make binary value for itself then memorize the new value
    // \ Back-Slash
    // / Forward-Slash

    val line1 = "Welcome to"
    val line2 = "Android Course"
    val line3 = "In RCC with Ahmad Atef"
    // \n means down one line then. $val to recall the value inside string
    println("$line1 \n $line2 \n $line3")

    var smallNumber: Int = 5 //The default shape of variables
}

fun doLec2MainMission() {
    val appName: String = "Welcome to WhatsApp"
    val appLanguage: String = "choose your language to get started"
    val isClickedOnAgreement: Boolean = true
    val region: String = "Egypt"
    val phoneNumber: String = "01091412022"
    val isBackupPassed: Boolean = true
    val isLoggedIn: Boolean = true
    val profilePicture: String = "https://"
    val profileName: String = "MohamadMF"
    var about: String? = "+201091412022"
    var chatArray: Array<Int> = arrayOf(0,1,2,3,4,5)
    var statusArray: Array<Int> = arrayOf(0,1,2,3,4,5)
    var myStatusPics: Int = 5
    var myStatusSeenBy: Int = 20
    var missedCalls: Int = 3
    var unreadMessage: Int = 10
    val groupName: String = "RCC039"
    var groupAdmins: Array<String> = arrayOf("Ahmed Atef")
    var groupParticipants: Int = 49
    val messageText: String = "ازيك يا بشمندس أحمد"
    val messageUserName: String = "MohamadMF"
}
fun doLec2ExtraMission() {
    val appName: String = "Monument Valley"
    val appDeveloper: String = "ustwo games"
    val appAds: String = "In-app Purchases"
    val appRate: Double = 4.9
    val appSize: Int = 217088
    val appDownloadsNumber: Int = 5157461
    val about: String = "An illusory adventure of impossible architecture"
    val appUserName: String = "Piyush Kumbhrajwale"
    val appUserRate: Int = 5
    val appUserComment: String = "Monument Valley is a visually stunning puzzle"
    val wasThisReviewHelpful: Boolean = true
}