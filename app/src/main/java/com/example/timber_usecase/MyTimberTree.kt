package com.example.timber_usecase

import timber.log.Timber

class MyTimberTree : Timber.DebugTree() {

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        val stackTrace = Throwable().stackTrace
        if (stackTrace.size < 5) {
            super.log(priority, tag, message, t)
            return
        }

        val caller = stackTrace[4]
        val methodName = caller.methodName
        val lineNumber = caller.lineNumber

        val newMessage = "(${caller.fileName}:${lineNumber}).$methodName: $message"

        super.log(priority, tag, newMessage, t)
    }

//Customize TAG
//    override fun createStackElementTag(element: StackTraceElement): String {
//        return "(${element.fileName}:${element.lineNumber}).${element.methodName}"
//    }

}